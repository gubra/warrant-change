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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.warrantchange.service.http.WarrantUserUniqueIdServiceSoap}.
 *
 * @author    davidk
 * @see       com.warrantchange.service.http.WarrantUserUniqueIdServiceSoap
 * @generated
 */
public class WarrantUserUniqueIdSoap implements Serializable {
	public static WarrantUserUniqueIdSoap toSoapModel(WarrantUserUniqueId model) {
		WarrantUserUniqueIdSoap soapModel = new WarrantUserUniqueIdSoap();

		soapModel.setId(model.getId());
		soapModel.setUniqueId(model.getUniqueId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSentEmail(model.getSentEmail());
		soapModel.setSentDate(model.getSentDate());
		soapModel.setSentOmicode(model.getSentOmicode());

		return soapModel;
	}

	public static WarrantUserUniqueIdSoap[] toSoapModels(
		WarrantUserUniqueId[] models) {
		WarrantUserUniqueIdSoap[] soapModels = new WarrantUserUniqueIdSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WarrantUserUniqueIdSoap[][] toSoapModels(
		WarrantUserUniqueId[][] models) {
		WarrantUserUniqueIdSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WarrantUserUniqueIdSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WarrantUserUniqueIdSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WarrantUserUniqueIdSoap[] toSoapModels(
		List<WarrantUserUniqueId> models) {
		List<WarrantUserUniqueIdSoap> soapModels = new ArrayList<WarrantUserUniqueIdSoap>(models.size());

		for (WarrantUserUniqueId model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WarrantUserUniqueIdSoap[soapModels.size()]);
	}

	public WarrantUserUniqueIdSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	private long _id;
	private String _uniqueId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _sentEmail;
	private Date _sentDate;
	private String _sentOmicode;
}