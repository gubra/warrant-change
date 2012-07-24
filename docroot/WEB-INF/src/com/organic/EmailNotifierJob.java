package com.organic.job;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.organic.model.Warrant;
import com.organic.service.WarrantLocalServiceUtil;

public class EmailNotifierJob implements MessageListener {

	private static final Logger log = Logger.getLogger(EmailNotifierJob.class);
	
	private static final String ADDR_FROM = "no-reply@organicmission.co.uk";
	private static final int DAYS_TO_EXPIRE = 14;

	public void receive(Message arg0) throws MessageListenerException {
		log.debug("Checking expiring warrants.");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_YEAR, -DAYS_TO_EXPIRE + 1);
		Date before = cal.getTime();
		
		List<Warrant> warrants = null;
		try {
			warrants = WarrantLocalServiceUtil.findWarrantsCreatedBefore(before);
			log.debug(String.format("# of warrants to be expired (created before %tF): %d", before, warrants.size()));
		} catch (SystemException e) {
			log.error(String.format("Failed to retrieve warrants expiring before %tF", before), e);
		}
		
		if (warrants != null) {			
			for (Warrant warrant : warrants) {
				log.debug(String.format("Warrant [id=%d] created on %tF", warrant.getId(), warrant.getCreateDate()));
				String to = null;
				try {
					User user = UserLocalServiceUtil.getUserById(warrant.getUserId());
					to = user.getEmailAddress();
					sendEmail(warrant, to);
					log.debug("Notification email sent to "+to);
				} catch (Exception e) {
					log.error(String.format("Failed to send notification email for warrant id: %s to: [userId=%s] %s"
							, warrant.getId(), warrant.getUserId(), to), e);
				}
			}
			if (!warrants.isEmpty()) {
				log.debug("Notification emails sent");
			}
		}
	}

	private static void sendEmail(Warrant warrant, String to) throws AddressException {
		MailMessage mailMessage = new MailMessage();
		mailMessage.setBody("This warrant expired: "+warrant);
		mailMessage.setFrom(new InternetAddress(ADDR_FROM));
		mailMessage.setSubject("Warrant expired");
		mailMessage.setTo(new InternetAddress(to));
		MessageBusUtil.sendMessage(DestinationNames.MAIL, mailMessage);
	}
}
