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

package com.organic.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.organic.NoSuchWarrantException;
import com.organic.model.Warrant;
import com.organic.model.impl.WarrantStateType;
import com.organic.service.WarrantLocalServiceUtil;
import com.organic.service.base.WarrantLocalServiceBaseImpl;
import com.organic.service.persistence.WarrantUtil;

/**
 * The implementation of the Warrant local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.organic.service.WarrantLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author davidk
 * @see com.organic.service.base.WarrantLocalServiceBaseImpl
 * @see com.organic.service.WarrantLocalServiceUtil
 */
public class WarrantLocalServiceImpl extends WarrantLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.organic.service.WarrantLocalServiceUtil} to access the Warrant local service.
	 */
	
	public Warrant addWarrant(long userId, String summary, int quantity, long price) throws SystemException {
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
		return WarrantLocalServiceUtil.addWarrant(warrant);
	}
	
	public void updateWarrant(long id, String summary, int quantity, long price) throws NoSuchWarrantException, SystemException {
		Warrant warrant = WarrantUtil.findByPrimaryKey(id);
		warrant.setSummary(summary);
		warrant.setQuantity(quantity);
		warrant.setPrice(price);
		warrant.setModifiedDate(new Date());
		updateWarrant(warrant);
	}
	
	public Warrant updateWarrant(Warrant warrant) throws SystemException {
		warrant.setModifiedDate(new Date());
		return WarrantLocalServiceUtil.updateWarrant(warrant);
	}
	
	public List<Warrant> findWarrants(int start, int count) throws SystemException {
		return WarrantUtil.findAll(start, start + count);
	}
	
	public void deleteWarrant(long id) throws NoSuchWarrantException, SystemException {
		Warrant warrant = WarrantUtil.findByPrimaryKey(id);
		warrant.setStatus(WarrantStateType.DELETED.name());
		warrant.setModifiedDate(new Date());
		WarrantLocalServiceUtil.updateWarrant(warrant);
	}

	public List<Warrant> findWarrants() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Warrant> findWarrantsCreatedBefore(Date before) throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Warrant.class).add(RestrictionsFactoryUtil.le("createDate", before))
				.add(RestrictionsFactoryUtil.eq("status", WarrantStateType.CREATED.name()));
		return WarrantUtil.findWithDynamicQuery(dynamicQuery);
	}
}
