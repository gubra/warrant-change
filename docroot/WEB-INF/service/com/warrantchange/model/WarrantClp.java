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

import com.warrantchange.service.WarrantLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author davidk
 */
public class WarrantClp extends BaseModelImpl<Warrant> implements Warrant {
	public WarrantClp() {
	}

	public Class<?> getModelClass() {
		return Warrant.class;
	}

	public String getModelClassName() {
		return Warrant.class.getName();
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

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public long getPrice() {
		return _price;
	}

	public void setPrice(long price) {
		_price = price;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
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

	public boolean getExpirationWarningSent() {
		return _expirationWarningSent;
	}

	public boolean isExpirationWarningSent() {
		return _expirationWarningSent;
	}

	public void setExpirationWarningSent(boolean expirationWarningSent) {
		_expirationWarningSent = expirationWarningSent;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			WarrantLocalServiceUtil.addWarrant(this);
		}
		else {
			WarrantLocalServiceUtil.updateWarrant(this);
		}
	}

	@Override
	public Warrant toEscapedModel() {
		return (Warrant)Proxy.newProxyInstance(Warrant.class.getClassLoader(),
			new Class[] { Warrant.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WarrantClp clone = new WarrantClp();

		clone.setId(getId());
		clone.setUserId(getUserId());
		clone.setSummary(getSummary());
		clone.setQuantity(getQuantity());
		clone.setPrice(getPrice());
		clone.setStatus(getStatus());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setExpirationWarningSent(getExpirationWarningSent());

		return clone;
	}

	public int compareTo(Warrant warrant) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), warrant.getCreateDate());

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

		WarrantClp warrant = null;

		try {
			warrant = (WarrantClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = warrant.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", summary=");
		sb.append(getSummary());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", expirationWarningSent=");
		sb.append(getExpirationWarningSent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.warrantchange.model.Warrant");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>summary</column-name><column-value><![CDATA[");
		sb.append(getSummary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
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
			"<column><column-name>expirationWarningSent</column-name><column-value><![CDATA[");
		sb.append(getExpirationWarningSent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _userId;
	private String _userUuid;
	private String _summary;
	private int _quantity;
	private long _price;
	private String _status;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _expirationWarningSent;
}