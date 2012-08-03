package com.warrantchange.portlet;

import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.warrantchange.NoSuchWarrantUserUniqueIdException;
import com.warrantchange.model.WarrantUserUniqueId;
import com.warrantchange.service.WarrantUserUniqueIdLocalServiceUtil;
import com.warrantchange.service.persistence.WarrantUserUniqueIdUtil;

public class ServicePreEvent extends Action {

	public ServicePreEvent() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ActionException {
		
//		String attribute = (String)request.getAttribute("_58_ExpandoAttributeName--warrantUserUniqueId--");
//		System.out.println("attribute: "+attribute);
//		
//		Map parameterMap = request.getParameterMap();
//		Collection values = parameterMap.values();
//		Set set = parameterMap.entrySet();
//		for(Object entry : values){
//			if(entry instanceof String){
//				String s = (String)entry;
//				System.out.println("entry: "+s);
//			}
//		}	
//		
//		String warrantUserUniqueId = request.getParameter("_58_ExpandoAttributeName--warrantUserUniqueId--");
//		
//		Enumeration attributeNames = request.getAttributeNames();
//		while(attributeNames.hasMoreElements()){
//			System.out.println(attributeNames.nextElement());
//		}
//		
//		Enumeration parameterNames = request.getParameterNames();
//		while(parameterNames.hasMoreElements()){
//			System.out.println(parameterNames.nextElement());
//		}
//
//		System.out.println("warrantUserUniqueId: "+warrantUserUniqueId);
//		
//		if(warrantUserUniqueId != null){
//
//			try {
//
//				WarrantUserUniqueId findByuniqueId = 
//						WarrantUserUniqueIdLocalServiceUtil.findByuniqueId(warrantUserUniqueId);
//
//				if(findByuniqueId == null){
//					System.out.println("warrant-user-unique-id not specified!");
//					add(request.getSession(),"warrant-user-unique-id error!","warrant-user-unique-id error!");
//					throw new ActionException();
//				}else if (findByuniqueId.getUserId() > 0){
//					System.out.println("warrant-user-unique-id is already used!");
//					add(request.getSession(),"warrant-user-unique-id error!","warrant-user-unique-id error!");
//					throw new ActionException();
//				}
//				
//				//				else{
//				//					System.out.println("warrant-user-unique-id is :"+warrantUserUniqueId);
//				//					long userId = model.getUserId();
//				//					System.out.println("userId :"+userId);
//				//					findByuniqueId.setUserId(userId);
//				//					findByuniqueId.setModifiedDate(new Date());
//				//					WarrantUserUniqueIdLocalServiceUtil.updateWarrantUserUniqueId(findByuniqueId);
//				//				}
//				
//			} catch (NoSuchWarrantUserUniqueIdException e) {
//				add(request.getSession(),"warrant-user-unique-id error!","warrant-user-unique-id error!");
//				throw new ActionException(e);
//			} catch (SystemException e) {
//				add(request.getSession(),"warrant-user-unique-id error!","warrant-user-unique-id error!");
//				throw new ActionException(e);
//			}
//
//		}

	}
	
	public static void add(HttpSession session, String key, Object value) {
		Map<String, Object> errors = _getErrors(session, true);

		errors.put(key, value);
	}
	private static Map<String, Object> _getErrors(
			HttpSession portletSession, boolean createIfAbsent) {

		Map<String, Object> errors = null;

		try {
			errors = (Map<String, Object>)portletSession.getAttribute(
					SessionErrors.class.getName());

			if ((errors == null) && createIfAbsent) {
				errors = new LinkedHashMap<String, Object>();

				portletSession.setAttribute(
						SessionErrors.class.getName(), errors);
			}
		}
		catch (IllegalStateException ise) {

			// Session is already invalidated, just return a null map

		}

		return errors;
	}
}
