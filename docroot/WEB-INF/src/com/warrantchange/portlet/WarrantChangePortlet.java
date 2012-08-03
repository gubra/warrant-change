package com.warrantchange.portlet;

import java.io.IOException; 
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest; 
import javax.portlet.ActionResponse; 
import javax.portlet.PortletException; 

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.pattern.LogEvent;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.warrantchange.job.MailMessageLogger;
import com.warrantchange.model.Warrant;
import com.warrantchange.model.WarrantUserEmailLog;
import com.warrantchange.model.WarrantUserUniqueId;
import com.warrantchange.model.impl.WarrantStateType;
import com.warrantchange.service.WarrantLocalServiceUtil;
import com.warrantchange.service.WarrantUserEmailLogLocalServiceUtil;
import com.warrantchange.service.WarrantUserUniqueIdLocalServiceUtil;

public class WarrantChangePortlet extends MVCPortlet {

	private static final Log _log = LogFactory.getLog(MVCPortlet.class);
	
	String regex;

	public WarrantChangePortlet() {
	}
	
	@Override
	public void init() throws PortletException {
		super.init();
//		MessageBusUtil.registerMessageListener(
//				DestinationNames.MAIL, new MailMessageLogger());
		
		regex = this.getInitParameter("regex");
		
		if(regex == null){
			regex = "2manysecrets";
		}
		
//		try {
//			WarrantUserUniqueId createWarrantUserUniqueId = WarrantUserUniqueIdLocalServiceUtil.createWarrantUserUniqueId(CounterLocalServiceUtil.increment());
//			createWarrantUserUniqueId.setUniqueId(UUID.randomUUID().toString());
//		} catch (SystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	private void logParameters(ActionRequest actionRequest, 
			ActionResponse actionResponse){
		
		_log.debug("logParameters() -> ");
		
		Map<String, String[]> parameterMap = actionRequest.getParameterMap();
		Set<Entry<String,String[]>> entrySet = parameterMap.entrySet();
		for(Entry<String, String[]> entry : entrySet){
			_log.debug(",key :"+entry.getKey());
			String[] values = entry.getValue();
			for(String s : values){
				_log.debug(s);
				_log.debug(", ");
			}
		}
		_log.debug("processAction() -> "+parameterMap);
	}

	@Override 
	public void processAction(ActionRequest actionRequest, 
			ActionResponse actionResponse) throws IOException, PortletException {
		
		_log.debug("processAction() -> "+actionRequest);
		
		logParameters(actionRequest, actionResponse);
		
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		
		_log.debug("cmd() -> "+cmd);
		
		try {
			if (cmd.equals(Constants.DELETE )) {
				deleteEntry(actionRequest);
			}
			else if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				
				updateEntry(actionRequest);
			}else if(cmd.equals(Constants.SEND)) {
				send(actionRequest);
			}

			String redirect = PortalUtil.escapeRedirect(
				ParamUtil.getString(actionRequest, "redirect"));

			_log.debug("redirect: "+redirect);
			
			if (Validator.isNotNull(redirect)) {
				actionResponse.sendRedirect(redirect);
			}
		}
		catch (Exception e) {
				SessionErrors.add(actionRequest, e.getClass().getName());
				throw new PortletException(e);
		}
		
		super.processAction(actionRequest, actionResponse); 
	}  
	
	protected void updateEntry(ActionRequest actionRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		long userId = themeDisplay.getUserId();

		String summary = ParamUtil.getString(actionRequest, "summary");
		
		int quantity = ParamUtil.getInteger(actionRequest, "quantity");
		double price = ParamUtil.getDouble(actionRequest, "price");
		
		System.out.println("price: "+price);
		
		if(summary == null || summary.length()<=0 || !summary.matches(regex)){
			SessionErrors.add(actionRequest,"summary-required-or-not-valid");
			return;
		}
		
		if(quantity <= 0){
			SessionErrors.add(actionRequest, "quantity-required");
			return;
		}
		
		if((quantity % 10) != 0){
			SessionErrors.add(actionRequest,"must-be-remainder-of-ten");
			return;
		}
		
		if(price < 0){
			SessionErrors.add(actionRequest, "price-required");
			return;
		}

		if (entryId <= 0) {

			// Add entry
			boolean userHasWarrant = WarrantLocalServiceUtil.userHasWarrant(userId);
			
			if(!userHasWarrant){
				WarrantLocalServiceUtil.addWarrant(userId, summary, quantity, price);
			}else{
				SessionErrors.add(actionRequest, "user-already-has-a-valid-warrant");
				return;
			}
		}
		else {

			Warrant warrant = WarrantLocalServiceUtil.getWarrant(entryId);
			
			warrant.setSummary(summary);
			warrant.setQuantity(quantity);
			warrant.setPrice(price);
			
			// Update entry
			WarrantLocalServiceUtil.updateWarrant(warrant);
//			updateWarrant(entryId, summary, quantity, price);

		}
	}
	
	protected void deleteEntry(ActionRequest actionRequest) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		long userId = themeDisplay.getUserId();
		
		User currentUser = UserLocalServiceUtil.getUser(userId);
		
		Warrant warrant = WarrantLocalServiceUtil.getWarrant(entryId);
		boolean isAdmin = false;
		
		List<Role> roles = currentUser.getRoles();
		
		for(Role r : roles){
			if(!"WC Admin".equalsIgnoreCase(r.getName())){
		    	isAdmin = true;
		    }
		}
		
		if(warrant.getUserId() != userId){
			if(!isAdmin){
				System.out.println("This user does not have rights to delete this warrant : "+userId);
				return;
			}
		}
		
		System.out.println("WarrantLocalService, marking Warrant as deleted : "+entryId);
		
		warrant.setStatus(WarrantStateType.DELETED.name());
		WarrantLocalServiceUtil.updateWarrant(warrant);
//		WarrantLocalServiceUtil.deleteWarrant(entryId);
	}
	
	
	protected void send(ActionRequest actionRequest) throws Exception{
		
		sendEmail(actionRequest);
	}
	
	private static synchronized void sendEmail(ActionRequest actionRequest) throws Exception {

		String mailMessage = ParamUtil.getString(actionRequest, "mailMessage");
		
		if(mailMessage == null || mailMessage.length()<=0){
			SessionErrors.add(actionRequest,"mailMessage-required");
			return;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		long userId = themeDisplay.getUserId();

		Warrant warrant;
		User currentUser;
		User sellingUser;
		try {
			warrant = WarrantLocalServiceUtil.getWarrant(entryId);
			
			currentUser = UserLocalServiceUtil.getUser(userId);

			sellingUser = UserLocalServiceUtil.getUser(warrant.getUserId());

			MailMessage mailMessageS = new MailMessage();
			mailMessageS.setBody(mailMessage);
			mailMessageS.setFrom(new InternetAddress(currentUser.getEmailAddress()));
			String subject = "Warrant interest";
			mailMessageS.setSubject(subject);
			mailMessageS.setTo(new InternetAddress(sellingUser.getEmailAddress()));
			MessageBusUtil.sendMessage(DestinationNames.MAIL, mailMessageS);
			
			
			logEmailMessageSent(subject, mailMessage);

		} catch (PortalException e) {
			_log.error("PortalException - ",e);
			SessionErrors.add(actionRequest, e.getClass().getName());
			e.printStackTrace();
			throw e;
		} catch (SystemException e) {
			_log.error("SystemException - ",e);
			SessionErrors.add(actionRequest, e.getClass().getName());
			e.printStackTrace();
			throw e;
		} catch (AddressException e){
			_log.error("AddressException - ",e);
			SessionErrors.add(actionRequest, e.getClass().getName());
			e.printStackTrace();
			throw e;
		}
		
	}

	
	private static void logEmailMessageSent(String subject, String body)
			throws SystemException {
		WarrantUserEmailLog createWarrantUserEmailLog = 
				WarrantUserEmailLogLocalServiceUtil.createWarrantUserEmailLog(CounterLocalServiceUtil.increment());
		
		if(createWarrantUserEmailLog != null){
			createWarrantUserEmailLog.setSubject(subject);
			createWarrantUserEmailLog.setBodyContent(body);
			createWarrantUserEmailLog.setCreateDate(new Date());
		}
		
		WarrantUserEmailLogLocalServiceUtil.updateWarrantUserEmailLog(createWarrantUserEmailLog);
	}

}
