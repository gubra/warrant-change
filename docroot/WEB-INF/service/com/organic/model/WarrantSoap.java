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

package com.organic.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.organic.service.http.WarrantServiceSoap}.
 *
 * @author    davidk
 * @see       com.organic.service.http.WarrantServiceSoap
 * @generated
 */
public class WarrantSoap implements Serializable {
	public static WarrantSoap toSoapModel(Warrant model) {
		WarrantSoap soapModel = new WarrantSoap();

		soapModel.setId(model.getId());
		soapModel.setUserId(model.getUserId());
		soapModel.setSummary(model.getSummary());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setPrice(model.getPrice());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static WarrantSoap[] toSoapModels(Warrant[] models) {
		WarrantSoap[] soapModels = new WarrantSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WarrantSoap[][] toSoapModels(Warrant[][] models) {
		WarrantSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WarrantSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WarrantSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WarrantSoap[] toSoapModels(List<Warrant> models) {
		List<WarrantSoap> soapModels = new ArrayList<WarrantSoap>(models.size());

		for (Warrant model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WarrantSoap[soapModels.size()]);
	}

	public WarrantSoap() {
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	private long _id;
	private long _userId;
	private String _summary;
	private int _quantity;
	private long _price;
	private String _status;
	private Date _createDate;
	private Date _modifiedDate;
}