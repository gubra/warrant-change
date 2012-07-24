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

import com.warrantchange.model.Warrant;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Warrant in entity cache.
 *
 * @author davidk
 * @see Warrant
 * @generated
 */
public class WarrantCacheModel implements CacheModel<Warrant>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", price=");
		sb.append(price);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public Warrant toEntityModel() {
		WarrantImpl warrantImpl = new WarrantImpl();

		warrantImpl.setId(id);
		warrantImpl.setUserId(userId);

		if (summary == null) {
			warrantImpl.setSummary(StringPool.BLANK);
		}
		else {
			warrantImpl.setSummary(summary);
		}

		warrantImpl.setQuantity(quantity);
		warrantImpl.setPrice(price);

		if (status == null) {
			warrantImpl.setStatus(StringPool.BLANK);
		}
		else {
			warrantImpl.setStatus(status);
		}

		if (createDate == Long.MIN_VALUE) {
			warrantImpl.setCreateDate(null);
		}
		else {
			warrantImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			warrantImpl.setModifiedDate(null);
		}
		else {
			warrantImpl.setModifiedDate(new Date(modifiedDate));
		}

		warrantImpl.resetOriginalValues();

		return warrantImpl;
	}

	public long id;
	public long userId;
	public String summary;
	public int quantity;
	public long price;
	public String status;
	public long createDate;
	public long modifiedDate;
}