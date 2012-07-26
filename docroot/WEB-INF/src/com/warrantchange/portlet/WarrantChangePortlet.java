package com.warrantchange.portlet;

import java.io.IOException; 

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest; 
import javax.portlet.ActionResponse; 
import javax.portlet.PortletException; 
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.warrantchange.model.Warrant;
import com.warrantchange.service.WarrantLocalServiceUtil;

public class WarrantChangePortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(WarrantChangePortlet.class);

	public WarrantChangePortlet() {
	}

	@Override 
	public void processAction(ActionRequest actionRequest, 
			ActionResponse actionResponse) throws IOException, PortletException {
		
		_log.debug(actionRequest);
		
		PortletPreferences prefs = actionRequest.getPreferences(); 
		
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		
		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateEntry(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteEntry(actionRequest);
			}else if(cmd.equals(Constants.SEND)) {
				send(actionRequest);
			}

			String redirect = PortalUtil.escapeRedirect(
				ParamUtil.getString(actionRequest, "redirect"));

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
		long price = ParamUtil.getLong(actionRequest, "price");
		
		
		if(summary == null || summary.length()<=0){
			SessionErrors.add(actionRequest,"summary-required");
		}
		
		if(quantity <= 0){
			SessionErrors.add(actionRequest, "quantity-required");
		}
		
		if((quantity % 10) != 0){
			SessionErrors.add(actionRequest,"must-be-remainder-of-ten");
		}
		
		if(price <= 0){
			SessionErrors.add(actionRequest, "price-required");
		}

		if (entryId <= 0) {

			// Add entry
			WarrantLocalServiceUtil.addWarrant(userId, summary, quantity, price);

		}
		else {

			Warrant warrant = WarrantLocalServiceUtil.getWarrant(entryId);
			
//			warrant.setModifiedDate(modifiedDate);
			warrant.setSummary(summary);
			warrant.setQuantity(quantity);
			warrant.setPrice(price);
			
			// Update entry
			WarrantLocalServiceUtil.updateWarrant(warrant);
//			updateWarrant(entryId, summary, quantity, price);

		}
	}
	
	protected void deleteEntry(ActionRequest actionRequest) throws Exception {
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		WarrantLocalServiceUtil.deleteWarrant(entryId);
	}
	
	
	protected void send(ActionRequest actionRequest) throws Exception{
		
		sendEmail(actionRequest);
	}
	
	private static synchronized void sendEmail(ActionRequest actionRequest) throws Exception {

		String mailMessage = ParamUtil.getString(actionRequest, "mailMessage");
		
		if(mailMessage == null || mailMessage.length()<=0){
			SessionErrors.add(actionRequest,"mailMessage-required");
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
			mailMessageS.setBody(mailMessage+" warrant: "+warrant);
			mailMessageS.setFrom(new InternetAddress(currentUser.getEmailAddress()));
			mailMessageS.setSubject("Warrant interest");
			mailMessageS.setTo(new InternetAddress(sellingUser.getEmailAddress()));
			MessageBusUtil.sendMessage(DestinationNames.MAIL, mailMessageS);

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


}