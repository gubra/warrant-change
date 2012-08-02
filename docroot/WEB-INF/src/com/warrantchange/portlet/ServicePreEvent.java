package com.warrantchange.portlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.SystemException;
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

		String warrantUserUniqueId = request.getParameter("warrantUserUniqueId");
		
		if(warrantUserUniqueId != null){
			
			try {
				WarrantUserUniqueId findByuniqueId = WarrantUserUniqueIdUtil.findByuniqueId(warrantUserUniqueId);
				if(findByuniqueId.getUserId()<=0){
					
				}
			} catch (NoSuchWarrantUserUniqueIdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
