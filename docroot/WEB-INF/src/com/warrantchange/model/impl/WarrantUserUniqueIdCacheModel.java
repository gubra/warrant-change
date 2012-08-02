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

package com.warrantchange.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.warrantchange.model.WarrantUserUniqueId;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing WarrantUserUniqueId in entity cache.
 *
 * @author davidk
 * @see WarrantUserUniqueId
 * @generated
 */
public class WarrantUserUniqueIdCacheModel implements CacheModel<WarrantUserUniqueId>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", uniqueId=");
		sb.append(uniqueId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public WarrantUserUniqueId toEntityModel() {
		WarrantUserUniqueIdImpl warrantUserUniqueIdImpl = new WarrantUserUniqueIdImpl();

		warrantUserUniqueIdImpl.setId(id);

		if (uniqueId == null) {
			warrantUserUniqueIdImpl.setUniqueId(StringPool.BLANK);
		}
		else {
			warrantUserUniqueIdImpl.setUniqueId(uniqueId);
		}

		warrantUserUniqueIdImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			warrantUserUniqueIdImpl.setCreateDate(null);
		}
		else {
			warrantUserUniqueIdImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			warrantUserUniqueIdImpl.setModifiedDate(null);
		}
		else {
			warrantUserUniqueIdImpl.setModifiedDate(new Date(modifiedDate));
		}

		warrantUserUniqueIdImpl.resetOriginalValues();

		return warrantUserUniqueIdImpl;
	}

	public long id;
	public String uniqueId;
	public long userId;
	public long createDate;
	public long modifiedDate;
}