package com.warrantchange.action;

//import com.liferay.portal.kernel.servlet.SessionErrors;
//import com.liferay.portal.kernel.util.Constants;
//import com.liferay.portal.kernel.util.GetterUtil;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.StringUtil;
//import com.liferay.portal.kernel.util.Validator;
//import com.liferay.portal.kernel.util.WebKeys;
//import com.liferay.portal.security.auth.PrincipalException;
//import com.liferay.portal.struts.PortletAction;
//import com.liferay.portal.theme.ThemeDisplay;
//import com.liferay.portal.util.PortalUtil;
//import com.warrantchange.model.Warrant;
//import com.warrantchange.service.WarrantLocalServiceUtil;
//
//
//import java.util.Calendar;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import javax.portlet.PortletConfig;
//import javax.portlet.PortletRequest;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionForward;
//import org.apache.struts.action.ActionMapping;


public class EditEntryAction {// extends PortletAction {

//	@Override
//	public void processAction(
//			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
//			ActionRequest actionRequest, ActionResponse actionResponse)
//		throws Exception {
//
//		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
//
//		try {
//			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
//				updateEntry(actionRequest);
//			}
//			else if (cmd.equals(Constants.DELETE)) {
//				deleteEntry(actionRequest);
//			}
//
//			String redirect = PortalUtil.escapeRedirect(
//				ParamUtil.getString(actionRequest, "redirect"));
//
//			if (Validator.isNotNull(redirect)) {
//				actionResponse.sendRedirect(redirect);
//			}
//		}
//		catch (Exception e) {
//				SessionErrors.add(actionRequest, e.getClass().getName());
//				throw e;
//		}
//	}
//
//	@Override
//	public ActionForward render(
//			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
//			RenderRequest renderRequest, RenderResponse renderResponse)
//		throws Exception {
//
//		try {
//			getEntry(renderRequest);
//		}
//		catch (Exception e) {
//				SessionErrors.add(renderRequest, e.getClass().getName());
//				throw e;
//		}
//
//		return mapping.findForward(
//			getForward(renderRequest, "portlet.warrantchange.edit_entry"));
//	}
//
//	protected void deleteEntry(ActionRequest actionRequest) throws Exception {
//		long entryId = ParamUtil.getLong(actionRequest, "entryId");
//
//		WarrantLocalServiceUtil.deleteWarrant(entryId);
//	}
//
//	protected void updateEntry(ActionRequest actionRequest) throws Exception {
//		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
//			WebKeys.THEME_DISPLAY);
//
//		long entryId = ParamUtil.getLong(actionRequest, "entryId");
//		long userId = themeDisplay.getUserId();
//
//		String summary = ParamUtil.getString(actionRequest, "summary");
//		int quantity = ParamUtil.getInteger(actionRequest, "quantity");
//		long price = ParamUtil.getLong(actionRequest, "price");
//
//		if (entryId <= 0) {
//
//			// Add entry
//			WarrantLocalServiceUtil.addWarrant(userId, summary, quantity, price);
//			
//		}
//		else {
//
//			// Update entry
//			WarrantLocalServiceUtil.updateWarrant(entryId, summary, quantity, price);
//						
//		}
//	}
//
//	public static void getEntry(HttpServletRequest request) throws Exception {
//		long entryId = ParamUtil.getLong(request, "entryId");
//
//		Warrant entry = null;
//
//		if (entryId > 0) {
//			entry = WarrantLocalServiceUtil.getWarrant(entryId);
//		}
//
//		request.setAttribute("WARRANT_ENTRY", entry);
//	}
//
//	public static void getEntry(PortletRequest portletRequest)
//		throws Exception {
//
//		HttpServletRequest request = PortalUtil.getHttpServletRequest(
//			portletRequest);
//
//		getEntry(request);
//	}
}
