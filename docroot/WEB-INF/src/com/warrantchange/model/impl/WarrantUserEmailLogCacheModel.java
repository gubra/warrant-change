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

import com.warrantchange.model.WarrantUserEmailLog;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing WarrantUserEmailLog in entity cache.
 *
 * @author davidk
 * @see WarrantUserEmailLog
 * @generated
 */
public class WarrantUserEmailLogCacheModel implements CacheModel<WarrantUserEmailLog>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", bodyContent=");
		sb.append(bodyContent);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public WarrantUserEmailLog toEntityModel() {
		WarrantUserEmailLogImpl warrantUserEmailLogImpl = new WarrantUserEmailLogImpl();

		warrantUserEmailLogImpl.setId(id);

		if (subject == null) {
			warrantUserEmailLogImpl.setSubject(StringPool.BLANK);
		}
		else {
			warrantUserEmailLogImpl.setSubject(subject);
		}

		if (bodyContent == null) {
			warrantUserEmailLogImpl.setBodyContent(StringPool.BLANK);
		}
		else {
			warrantUserEmailLogImpl.setBodyContent(bodyContent);
		}

		warrantUserEmailLogImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			warrantUserEmailLogImpl.setCreateDate(null);
		}
		else {
			warrantUserEmailLogImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			warrantUserEmailLogImpl.setModifiedDate(null);
		}
		else {
			warrantUserEmailLogImpl.setModifiedDate(new Date(modifiedDate));
		}

		warrantUserEmailLogImpl.resetOriginalValues();

		return warrantUserEmailLogImpl;
	}

	public long id;
	public String subject;
	public String bodyContent;
	public long userId;
	public long createDate;
	public long modifiedDate;
}