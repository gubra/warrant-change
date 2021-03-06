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

import com.warrantchange.service.WarrantUserUniqueIdLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author davidk
 */
public class WarrantUserUniqueIdClp extends BaseModelImpl<WarrantUserUniqueId>
	implements WarrantUserUniqueId {
	public WarrantUserUniqueIdClp() {
	}

	public Class<?> getModelClass() {
		return WarrantUserUniqueId.class;
	}

	public String getModelClassName() {
		return WarrantUserUniqueId.class.getName();
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

	public String getUniqueId() {
		return _uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		_uniqueId = uniqueId;
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

	public String getSentEmail() {
		return _sentEmail;
	}

	public void setSentEmail(String sentEmail) {
		_sentEmail = sentEmail;
	}

	public Date getSentDate() {
		return _sentDate;
	}

	public void setSentDate(Date sentDate) {
		_sentDate = sentDate;
	}

	public String getSentOmicode() {
		return _sentOmicode;
	}

	public void setSentOmicode(String sentOmicode) {
		_sentOmicode = sentOmicode;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			WarrantUserUniqueIdLocalServiceUtil.addWarrantUserUniqueId(this);
		}
		else {
			WarrantUserUniqueIdLocalServiceUtil.updateWarrantUserUniqueId(this);
		}
	}

	@Override
	public WarrantUserUniqueId toEscapedModel() {
		return (WarrantUserUniqueId)Proxy.newProxyInstance(WarrantUserUniqueId.class.getClassLoader(),
			new Class[] { WarrantUserUniqueId.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WarrantUserUniqueIdClp clone = new WarrantUserUniqueIdClp();

		clone.setId(getId());
		clone.setUniqueId(getUniqueId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSentEmail(getSentEmail());
		clone.setSentDate(getSentDate());
		clone.setSentOmicode(getSentOmicode());

		return clone;
	}

	public int compareTo(WarrantUserUniqueId warrantUserUniqueId) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				warrantUserUniqueId.getCreateDate());

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

		WarrantUserUniqueIdClp warrantUserUniqueId = null;

		try {
			warrantUserUniqueId = (WarrantUserUniqueIdClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = warrantUserUniqueId.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", uniqueId=");
		sb.append(getUniqueId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", sentEmail=");
		sb.append(getSentEmail());
		sb.append(", sentDate=");
		sb.append(getSentDate());
		sb.append(", sentOmicode=");
		sb.append(getSentOmicode());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.warrantchange.model.WarrantUserUniqueId");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uniqueId</column-name><column-value><![CDATA[");
		sb.append(getUniqueId());
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
		sb.append(
			"<column><column-name>sentEmail</column-name><column-value><![CDATA[");
		sb.append(getSentEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentDate</column-name><column-value><![CDATA[");
		sb.append(getSentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentOmicode</column-name><column-value><![CDATA[");
		sb.append(getSentOmicode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _uniqueId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _sentEmail;
	private Date _sentDate;
	private String _sentOmicode;
}