/**
 * 
 */
package com.warrantchange.model.impl;

import java.io.Serializable;
import java.util.Date;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.model.User;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.warrantchange.NoSuchWarrantUserUniqueIdException;
import com.warrantchange.model.WarrantUserUniqueId;
import com.warrantchange.service.WarrantUserUniqueIdLocalServiceUtil;
import com.warrantchange.service.persistence.WarrantUserUniqueIdUtil;

/**
 * @author gubra
 *
 */
public class UserModelListener implements ModelListener<User> {

	/**
	 * 
	 */
	public UserModelListener() {
	}

//	@Override
	public void onAfterAddAssociation(Object classPK,
			String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		
	}

//	@Override
	public void onAfterCreate(User model) throws ModelListenerException {
		
		System.out.println("onAfterCreate() -> "+model);
		
	}

//	@Override
	public void onAfterRemove(User model) throws ModelListenerException {
		
	}

//	@Override
	public void onAfterRemoveAssociation(Object classPK,
			String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		
	}

//	@Override
	public void onAfterUpdate(User model) throws ModelListenerException {
		
	}

//	@Override
	public void onBeforeAddAssociation(Object classPK,
			String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		
	}

//	@Override
	public void onBeforeCreate(User model) throws ModelListenerException {
		
		System.out.println("onBeforeCreate() -> "+model);
		
		ExpandoBridge expandoBridge = model.getExpandoBridge();
		if(expandoBridge != null){
			String attribute = (String)expandoBridge.getAttribute("warrant-user-unique-id");
			if(attribute == null){
				System.out.println("warrant-user-unique-id not defined!");
				throw new ModelListenerException();
			}else{
				try {
					
					WarrantUserUniqueId findByuniqueId = 
							WarrantUserUniqueIdUtil.findByuniqueId(attribute);
					
					if(findByuniqueId == null){
						System.out.println("warrant-user-unique-id not specified!");
						throw new ModelListenerException();
					}else if (findByuniqueId.getUserId() > 0){
						System.out.println("warrant-user-unique-id is already used!");
						throw new ModelListenerException();
					}else{
						System.out.println("warrant-user-unique-id is :"+attribute);
						long userId = model.getUserId();
						System.out.println("userId :"+userId);
						findByuniqueId.setUserId(userId);
						findByuniqueId.setModifiedDate(new Date());
						WarrantUserUniqueIdLocalServiceUtil.updateWarrantUserUniqueId(findByuniqueId);
					}
				} catch (NoSuchWarrantUserUniqueIdException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

//	@Override
	public void onBeforeRemove(User model) throws ModelListenerException {
		
	}

//	@Override
	public void onBeforeRemoveAssociation(Object classPK,
			String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		
	}

//	@Override
	public void onBeforeUpdate(User model) throws ModelListenerException {
		
	}

}
