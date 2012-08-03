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
 * This class is used by SOAP remote services, specifically {@link com.warrantchange.service.http.WarrantUserEmailLogServiceSoap}.
 *
 * @author    davidk
 * @see       com.warrantchange.service.http.WarrantUserEmailLogServiceSoap
 * @generated
 */
public class WarrantUserEmailLogSoap implements Serializable {
	public static WarrantUserEmailLogSoap toSoapModel(WarrantUserEmailLog model) {
		WarrantUserEmailLogSoap soapModel = new WarrantUserEmailLogSoap();

		soapModel.setId(model.getId());
		soapModel.setSubject(model.getSubject());
		soapModel.setBodyContent(model.getBodyContent());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static WarrantUserEmailLogSoap[] toSoapModels(
		WarrantUserEmailLog[] models) {
		WarrantUserEmailLogSoap[] soapModels = new WarrantUserEmailLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WarrantUserEmailLogSoap[][] toSoapModels(
		WarrantUserEmailLog[][] models) {
		WarrantUserEmailLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WarrantUserEmailLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WarrantUserEmailLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WarrantUserEmailLogSoap[] toSoapModels(
		List<WarrantUserEmailLog> models) {
		List<WarrantUserEmailLogSoap> soapModels = new ArrayList<WarrantUserEmailLogSoap>(models.size());

		for (WarrantUserEmailLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WarrantUserEmailLogSoap[soapModels.size()]);
	}

	public WarrantUserEmailLogSoap() {
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

	private long _id;
	private String _subject;
	private String _bodyContent;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
}