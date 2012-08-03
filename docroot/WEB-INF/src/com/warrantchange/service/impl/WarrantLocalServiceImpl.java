/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.warrantchange.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.warrantchange.NoSuchWarrantException;
import com.warrantchange.model.Warrant;
import com.warrantchange.model.WarrantModel;
import com.warrantchange.model.impl.WarrantStateType;
import com.warrantchange.service.WarrantLocalServiceUtil;
import com.warrantchange.service.base.WarrantLocalServiceBaseImpl;
import com.warrantchange.service.persistence.WarrantPersistence;
import com.warrantchange.service.persistence.WarrantUtil;

/**
 * The implementation of the Warrant local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.warrantchange.service.WarrantLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author davidk
 * @see com.warrantchange.service.base.WarrantLocalServiceBaseImpl
 * @see com.warrantchange.service.WarrantLocalServiceUtil
 */
public class WarrantLocalServiceImpl extends WarrantLocalServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.warrantchange.service.WarrantLocalServiceUtil} to access the Warrant local service.
	 */
	
	public Warrant addWarrant(long userId, String summary, int quantity, double price) throws SystemException {
		long id = counterLocalService.increment();
		Warrant warrant = WarrantLocalServiceUtil.createWarrant(id);
		Date now = new Date();
		warrant.setUserId(userId);
		warrant.setSummary(summary);
		warrant.setQuantity(quantity);
		warrant.setPrice(price);
		warrant.setStatus(WarrantStateType.CREATED.name());
		warrant.setCreateDate(now);
		warrant.setModifiedDate(now);
		return WarrantUtil.update(warrant, true);
	}
	
	public void updateWarrant(long id, String summary, int quantity, double price) throws NoSuchWarrantException, SystemException {
		Warrant warrant = WarrantUtil.findByPrimaryKey(id);
		warrant.setSummary(summary);
		warrant.setQuantity(quantity);
		warrant.setPrice(price);
		warrant.setModifiedDate(new Date());
		updateWarrant(warrant);
	}
	
	public Warrant updateWarrant(Warrant warrant) throws SystemException {
		warrant.setModifiedDate(new Date());
		return WarrantUtil.update(warrant, true);
	}
	
	public List<Warrant> findWarrants(int start, int count) throws SystemException {
		DynamicQuery dynamicQuery = createDynamicQuery()
				.add(RestrictionsFactoryUtil.eq("status", WarrantStateType.CREATED.name()));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));
		dynamicQuery.setLimit(start, start + count);
		return dynamicQuery(dynamicQuery);
	}
	
	public void cleanUpWarrantsDeletedBefore(Date before) throws NoSuchWarrantException, SystemException {
		DynamicQuery dynamicQuery = createDynamicQuery()
				.add(RestrictionsFactoryUtil.eq("status", WarrantStateType.DELETED.name()))
				.add(RestrictionsFactoryUtil.le("modifiedDate", before));
		List<Warrant> warrants = dynamicQuery(dynamicQuery);
		for (Warrant warrant : warrants) {
			WarrantUtil.remove(warrant.getId()); 
		}
	}
	
	public void deleteWarrant(long id) throws NoSuchWarrantException, SystemException {
		Warrant warrant = WarrantUtil.findByPrimaryKey(id);
		deleteWarrant(warrant);
	}
	
	@Override
	public void deleteWarrant(Warrant warrant) throws SystemException {
		warrant.setStatus(WarrantStateType.DELETED.name());
		warrant.setModifiedDate(new Date());
		updateWarrant(warrant);
	}
	
	public List<Warrant> findWarrants() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Warrant> findWarrantsByCreateDate(Date from, Date to) throws SystemException {
		DynamicQuery dynamicQuery = createDynamicQuery()
				.add(RestrictionsFactoryUtil.eq("status", WarrantStateType.CREATED.name()))
				.add(RestrictionsFactoryUtil.eq("expirationWarningSent", false));
		if (from != null) {
			dynamicQuery = dynamicQuery.add(RestrictionsFactoryUtil.gt("createDate", from));
		}
		if (to != null) {
			dynamicQuery = dynamicQuery.add(RestrictionsFactoryUtil.le("createDate", to));
		}
		return dynamicQuery(dynamicQuery);
	}

	private DynamicQuery createDynamicQuery() {
		return DynamicQueryFactoryUtil.forClass(Warrant.class);
	}
	
	public boolean userHasWarrant(long userId) throws SystemException {
		try {
			Warrant findByUserId = WarrantUtil.findByUserId(userId);
			if(findByUserId != null && 
					!findByUserId.getStatus().equals(WarrantStateType.DELETED.name())){
				return true;
			}
		} catch (NoSuchWarrantException e) {
			
		}
		return false;
	}
}
