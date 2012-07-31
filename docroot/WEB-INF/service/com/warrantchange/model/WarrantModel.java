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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Warrant service. Represents a row in the &quot;warrant&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.warrantchange.model.impl.WarrantModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.warrantchange.model.impl.WarrantImpl}.
 * </p>
 *
 * @author davidk
 * @see Warrant
 * @see com.warrantchange.model.impl.WarrantImpl
 * @see com.warrantchange.model.impl.WarrantModelImpl
 * @generated
 */
public interface WarrantModel extends BaseModel<Warrant> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a Warrant model instance should use the {@link Warrant} interface instead.
	 */

	/**
	 * Returns the primary key of this Warrant.
	 *
	 * @return the primary key of this Warrant
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this Warrant.
	 *
	 * @param primaryKey the primary key of this Warrant
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this Warrant.
	 *
	 * @return the ID of this Warrant
	 */
	public long getId();

	/**
	 * Sets the ID of this Warrant.
	 *
	 * @param id the ID of this Warrant
	 */
	public void setId(long id);

	/**
	 * Returns the user ID of this Warrant.
	 *
	 * @return the user ID of this Warrant
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this Warrant.
	 *
	 * @param userId the user ID of this Warrant
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this Warrant.
	 *
	 * @return the user uuid of this Warrant
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this Warrant.
	 *
	 * @param userUuid the user uuid of this Warrant
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the summary of this Warrant.
	 *
	 * @return the summary of this Warrant
	 */
	@AutoEscape
	public String getSummary();

	/**
	 * Sets the summary of this Warrant.
	 *
	 * @param summary the summary of this Warrant
	 */
	public void setSummary(String summary);

	/**
	 * Returns the quantity of this Warrant.
	 *
	 * @return the quantity of this Warrant
	 */
	public int getQuantity();

	/**
	 * Sets the quantity of this Warrant.
	 *
	 * @param quantity the quantity of this Warrant
	 */
	public void setQuantity(int quantity);

	/**
	 * Returns the price of this Warrant.
	 *
	 * @return the price of this Warrant
	 */
	public double getPrice();

	/**
	 * Sets the price of this Warrant.
	 *
	 * @param price the price of this Warrant
	 */
	public void setPrice(double price);

	/**
	 * Returns the status of this Warrant.
	 *
	 * @return the status of this Warrant
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this Warrant.
	 *
	 * @param status the status of this Warrant
	 */
	public void setStatus(String status);

	/**
	 * Returns the create date of this Warrant.
	 *
	 * @return the create date of this Warrant
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this Warrant.
	 *
	 * @param createDate the create date of this Warrant
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this Warrant.
	 *
	 * @return the modified date of this Warrant
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this Warrant.
	 *
	 * @param modifiedDate the modified date of this Warrant
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the expiration warning sent of this Warrant.
	 *
	 * @return the expiration warning sent of this Warrant
	 */
	public boolean getExpirationWarningSent();

	/**
	 * Returns <code>true</code> if this Warrant is expiration warning sent.
	 *
	 * @return <code>true</code> if this Warrant is expiration warning sent; <code>false</code> otherwise
	 */
	public boolean isExpirationWarningSent();

	/**
	 * Sets whether this Warrant is expiration warning sent.
	 *
	 * @param expirationWarningSent the expiration warning sent of this Warrant
	 */
	public void setExpirationWarningSent(boolean expirationWarningSent);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Warrant warrant);

	public int hashCode();

	public CacheModel<Warrant> toCacheModel();

	public Warrant toEscapedModel();

	public String toString();

	public String toXmlString();
}