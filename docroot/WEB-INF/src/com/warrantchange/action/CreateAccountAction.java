/**
 * 
 */
package com.warrantchange.action;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.warrantchange.NoSuchWarrantUserUniqueIdException;
import com.warrantchange.model.WarrantUserUniqueId;
import com.warrantchange.service.WarrantUserUniqueIdLocalServiceUtil;

/**
 * @author gubra
 * 
 */
public class CreateAccountAction extends BaseStrutsPortletAction {

	public void processAction(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		Company company = themeDisplay.getCompany();
		
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		
		System.out.println("Wrapped /login/create_account, cmd: "+cmd);
		
		if (cmd.equals(Constants.ADD)) {
			
			String warrantUserUniqueId = ParamUtil.getString(actionRequest, "ExpandoAttribute--warrantUserUniqueId--");

			WarrantUserUniqueId warrantUserUniqueID = 
					this.checkWarrantUserUniqueId(actionRequest, actionResponse, warrantUserUniqueId);
		
			if(warrantUserUniqueID != null){
				
				System.out.println("warrantUserUniqueID: " + warrantUserUniqueID);
				
				originalStrutsPortletAction.processAction(originalStrutsPortletAction,
						portletConfig, actionRequest, actionResponse);

				String screenName = ParamUtil.getString(actionRequest, "screenName");

				User fetchUserByScreenName = UserLocalServiceUtil.fetchUserByScreenName(company.getCompanyId(), screenName);

				long userId = fetchUserByScreenName.getUserId();

				System.out.println("userId: " + userId);

				updateWarrantUserUniqueId(actionRequest, actionResponse, warrantUserUniqueID, userId);
			}else{
				System.out.println("warrantUserUniqueID retreive error!");
			}
			
		}else{
			originalStrutsPortletAction.processAction(originalStrutsPortletAction,
					portletConfig, actionRequest, actionResponse);
		}
		
	}
	
	private void updateWarrantUserUniqueId(ActionRequest actionRequest, ActionResponse actionResponse,
			WarrantUserUniqueId warrantUserUniqueId, long userId) throws Exception{

		if(warrantUserUniqueId == null){

			System.out.println("warrantUserUniqueId not defined!");
			throw new Exception();

		}else{
			System.out.println("Checking warrant user unique id: "+warrantUserUniqueId);
			try {
				
				warrantUserUniqueId.setUserId(userId);
				warrantUserUniqueId.setModifiedDate(new Date());
				WarrantUserUniqueId findByuniqueId = 
						WarrantUserUniqueIdLocalServiceUtil.updateWarrantUserUniqueId(warrantUserUniqueId);
			
				System.out.println("WarrantUserUniqueId updated! uniqueId: "+ findByuniqueId);
			} catch (SystemException e) {
				System.out.println("warrant-user-unique-id-error!, system not available!");
				SessionErrors.add(actionRequest, "warrant-user-unique-id-error!", "system not available!");
				throw new Exception(e);
			}
		}

	}

	private WarrantUserUniqueId checkWarrantUserUniqueId(ActionRequest actionRequest, ActionResponse actionResponse, String warrantUserUniqueId) throws Exception{
		
		if(warrantUserUniqueId == null){
			
			System.out.println("warrantUserUniqueId not defined!");
			throw new Exception();
			
		}else{
			System.out.println("Checking warrant user unique id: "+warrantUserUniqueId);
			try {
				
				WarrantUserUniqueId findByuniqueId = 
						WarrantUserUniqueIdLocalServiceUtil.findByuniqueId(warrantUserUniqueId);
				
				if(findByuniqueId == null){
					System.out.println("warrant-user-unique-id not specified!");
					SessionErrors.add(actionRequest, "warrant-user-unique-id-error!","warrant-user-unique-id not specified!");
					sendRedirect(actionRequest, actionResponse);
					//throw new Exception();
					return null;
				}else if (findByuniqueId.getUserId() > 0){
					System.out.println("warrant-user-unique-id is already used!");
					SessionErrors.add(actionRequest, "warrant-user-unique-id-error!","warrant-user-unique-id is already used!");
					sendRedirect(actionRequest, actionResponse);
					//throw new Exception();
					return null;
				}
				return findByuniqueId;
			} catch (NoSuchWarrantUserUniqueIdException e) {
				System.out.println("warrant-user-unique-id not specified!");
				SessionErrors.add(actionRequest, "warrant-user-unique-id-error!", "warrant-user-unique-id not specified!");
				sendRedirect(actionRequest, actionResponse);
				//throw new Exception(e);
				return null;
			} catch (SystemException e) {
				System.out.println("warrant-user-unique-id system not available!");
				SessionErrors.add(actionRequest, "warrant-user-unique-id-error!", "system not available!");
				throw new Exception(e);
			}
		}
	}

	public String render(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		System.out.println("Wrapped /login/create_account");
		return originalStrutsPortletAction.render(null, portletConfig,
				renderRequest, renderResponse);
	}

	public void serveResource(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {
		originalStrutsPortletAction.serveResource(originalStrutsPortletAction,
				portletConfig, resourceRequest, resourceResponse);
	}

	protected void sendRedirect(ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
	
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
	
		PortletURL portletURL = PortletURLFactoryUtil.create(
				actionRequest, PortletKeys.LOGIN, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	
		portletURL.setWindowState(WindowState.MAXIMIZED);
		portletURL.setPortletMode(PortletMode.VIEW);
	
		portletURL.setParameter("saveLastPath", "0");
		portletURL.setParameter("struts_action", "/login/create_account");
	
		actionResponse.sendRedirect(portletURL.toString());
	}
	
	public static void add(HttpSession session, String key, Object value) {
		Map<String, Object> errors = _getErrors(session, true);

		errors.put(key, value);
	}
	
	private static Map<String, Object> _getErrors(
			HttpSession session, boolean createIfAbsent) {

			Map<String, Object> errors = null;

			try {
				errors = (Map<String, Object>)session.getAttribute(
					SessionErrors.class.getName());

				if ((errors == null) && createIfAbsent) {
					errors = new LinkedHashMap<String, Object>();

					session.setAttribute(SessionErrors.class.getName(), errors);
				}
			}
			catch (IllegalStateException ise) {

				// Session is already invalidated, just return a null map

			}

			return errors;
		}

}
