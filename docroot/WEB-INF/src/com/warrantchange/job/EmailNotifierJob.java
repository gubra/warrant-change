package com.warrantchange.job;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.ContentUtil;
import com.warrantchange.model.Warrant;
import com.warrantchange.service.WarrantLocalServiceUtil;

public class EmailNotifierJob implements MessageListener {

	private static final Log log = LogFactory.getLog(EmailNotifierJob.class);
	
	private static final String FTL_WARNING_SUBJECT = "email_notif_warrant_warning_subject.ftl";
	private static final String FTL_WARNING_BODY = "email_notif_warrant_warning_body.ftl";
	private static final String FTL_EXPIRED_SUBJECT = "email_notif_warrant_expired_subject.ftl";
	private static final String FTL_EXPIRED_BODY = "email_notif_warrant_expired_body.ftl";
	private static final String ADDR_FROM = "no-reply@organicmission.co.uk";
	private static final int DAYS_TO_EXPIRE = 14;

	private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();
	private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance();
	
	private static enum NotificationType {
		WARNING(DAYS_TO_EXPIRE - 1, FTL_WARNING_SUBJECT, FTL_WARNING_BODY),
		EXPIRED(DAYS_TO_EXPIRE, FTL_EXPIRED_SUBJECT, FTL_EXPIRED_BODY);
		
		private int daysAgo;
		private String subjectTemplate;
		private String bodyTemplate;
		
		private NotificationType(int daysAgo, String subjectTemplate, String bodyTemplate) {
			this.daysAgo = daysAgo;
			this.subjectTemplate = subjectTemplate;
			this.bodyTemplate = bodyTemplate;
		}
	}
	
	public void receive(Message msg) throws MessageListenerException {
		// has to check it first:
		sendNotifications(NotificationType.EXPIRED);
		sendNotifications(NotificationType.WARNING);
	}

	private void sendNotifications(NotificationType type) {
		log.info(String.format("Checking %s warrants.", NotificationType.WARNING.equals(type) ? "expiring" : "expired"));
		
		Date dateFrom = NotificationType.WARNING.equals(type) ? createDate(NotificationType.EXPIRED.daysAgo) : null;
		Date dateTo = createDate(type.daysAgo);
		
		List<Warrant> warrants = null;
		try {
			warrants = WarrantLocalServiceUtil.findWarrantsByCreateDate(dateFrom, dateTo);
			log.info(String.format("# of warrants %s expired (created before %tF): %d", NotificationType.WARNING.equals(type) ? "to be" : "", dateTo, warrants.size()));
		} catch (SystemException e) {
			log.error(String.format("Failed to retrieve warrants expiring before %tF", dateTo), e);
		}
		
		if (warrants != null) {			
			for (Warrant warrant : warrants) {
				log.info(String.format("Warrant [id=%d] created on %tF", warrant.getId(), warrant.getCreateDate()));
				String to = null;
				try {
					User user = UserLocalServiceUtil.getUserById(warrant.getUserId());
					to = user.getEmailAddress();
					String subject = processTemplate(type.subjectTemplate, warrant, user);
					String body = processTemplate(type.bodyTemplate, warrant, user);
					sendEmail(warrant, to, subject, body);
					switch (type) {
					case WARNING:
						warrant.setExpirationWarningSent(true);
						WarrantLocalServiceUtil.updateWarrant(warrant);
						break;
					case EXPIRED:
						WarrantLocalServiceUtil.deleteWarrant(warrant);
						break;
					}
					log.info("Notification email sent to "+to);
				} catch (Exception e) {
					log.error(String.format("Failed to send notification email for warrant id: %s to: [userId=%s] %s"
							, warrant.getId(), warrant.getUserId(), to), e);
				}
			}
			if (!warrants.isEmpty()) {
				log.info("Notification emails sent");
			}
		}
	}

	private Date createDate(int daysAgo) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_YEAR, -daysAgo);
		return cal.getTime();
	}

	private static void sendEmail(Warrant warrant, String to, String subject, String body) throws AddressException {
		MailMessage mailMessage = new MailMessage();
		mailMessage.setFrom(new InternetAddress(ADDR_FROM));
		mailMessage.setTo(new InternetAddress(to));
		mailMessage.setSubject(subject);
		mailMessage.setBody(body);
		MessageBusUtil.sendMessage(DestinationNames.MAIL, mailMessage);
	}
	
	private static String processTemplate(String template, Warrant warrant, User user) throws Exception {
/*		Map<String, Object> context = new HashMap<String, Object>();
		context.put("warrant", warrant);
		context.put("user", user);
		Configuration cfg = new Configuration();
		cfg.setTemplateLoader(new ClassTemplateLoader(EmailNotifierJob.class, StringPool.SLASH));
		StringWriter writer = new StringWriter();
		cfg.getTemplate(template).process(context, writer);
		return writer.toString();
*/
		String content = ContentUtil.get(template);
		return StringUtil.replace(content, new String[] {
				"${warrant.summary}", "${warrant.price}"
				, "${warrant.quantity}", "${warrant.id}"
				, "${warrant.createDate}", "${user.userId}"
		}, new String[] { 
				warrant.getSummary(), CURRENCY_FORMAT.format(((double) warrant.getPrice()) / 100)
				, String.valueOf(warrant.getQuantity()), String.valueOf(warrant.getId())
				, DATE_FORMAT.format(warrant.getCreateDate()), String.valueOf(user.getUserId())
		});
	}
}
