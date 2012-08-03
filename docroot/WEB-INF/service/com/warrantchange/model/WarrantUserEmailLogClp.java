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

package com.warrantchange.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.warrantchange.service.WarrantUserEmailLogLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author davidk
 */
public class WarrantUserEmailLogClp extends BaseModelImpl<WarrantUserEmailLog>
	implements WarrantUserEmailLog {
	public WarrantUserEmailLogClp() {
	}

	public Class<?> getModelClass() {
		return WarrantUserEmailLog.class;
	}

	public String getModelClassName() {
		return WarrantUserEmailLog.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getBodyContent() {
		return _bodyContent;
	}

	public void setBodyContent(String bodyContent) {
		_bodyContent = bodyContent;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			WarrantUserEmailLogLocalServiceUtil.addWarrantUserEmailLog(this);
		}
		else {
			WarrantUserEmailLogLocalServiceUtil.updateWarrantUserEmailLog(this);
		}
	}

	@Override
	public WarrantUserEmailLog toEscapedModel() {
		return (WarrantUserEmailLog)Proxy.newProxyInstance(WarrantUserEmailLog.class.getClassLoader(),
			new Class[] { WarrantUserEmailLog.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WarrantUserEmailLogClp clone = new WarrantUserEmailLogClp();

		clone.setId(getId());
		clone.setSubject(getSubject());
		clone.setBodyContent(getBodyContent());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(WarrantUserEmailLog warrantUserEmailLog) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				warrantUserEmailLog.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		WarrantUserEmailLogClp warrantUserEmailLog = null;

		try {
			warrantUserEmailLog = (WarrantUserEmailLogClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = warrantUserEmailLog.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", bodyContent=");
		sb.append(getBodyContent());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.warrantchange.model.WarrantUserEmailLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bodyContent</column-name><column-value><![CDATA[");
		sb.append(getBodyContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _subject;
	private String _bodyContent;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
}