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

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Warrant}.
 * </p>
 *
 * @author    davidk
 * @see       Warrant
 * @generated
 */
public class WarrantWrapper implements Warrant, ModelWrapper<Warrant> {
	public WarrantWrapper(Warrant warrant) {
		_warrant = warrant;
	}

	public Class<?> getModelClass() {
		return Warrant.class;
	}

	public String getModelClassName() {
		return Warrant.class.getName();
	}

	/**
	* Returns the primary key of this Warrant.
	*
	* @return the primary key of this Warrant
	*/
	public long getPrimaryKey() {
		return _warrant.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Warrant.
	*
	* @param primaryKey the primary key of this Warrant
	*/
	public void setPrimaryKey(long primaryKey) {
		_warrant.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this Warrant.
	*
	* @return the ID of this Warrant
	*/
	public long getId() {
		return _warrant.getId();
	}

	/**
	* Sets the ID of this Warrant.
	*
	* @param id the ID of this Warrant
	*/
	public void setId(long id) {
		_warrant.setId(id);
	}

	/**
	* Returns the user ID of this Warrant.
	*
	* @return the user ID of this Warrant
	*/
	public long getUserId() {
		return _warrant.getUserId();
	}

	/**
	* Sets the user ID of this Warrant.
	*
	* @param userId the user ID of this Warrant
	*/
	public void setUserId(long userId) {
		_warrant.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Warrant.
	*
	* @return the user uuid of this Warrant
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _warrant.getUserUuid();
	}

	/**
	* Sets the user uuid of this Warrant.
	*
	* @param userUuid the user uuid of this Warrant
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_warrant.setUserUuid(userUuid);
	}

	/**
	* Returns the summary of this Warrant.
	*
	* @return the summary of this Warrant
	*/
	public java.lang.String getSummary() {
		return _warrant.getSummary();
	}

	/**
	* Sets the summary of this Warrant.
	*
	* @param summary the summary of this Warrant
	*/
	public void setSummary(java.lang.String summary) {
		_warrant.setSummary(summary);
	}

	/**
	* Returns the quantity of this Warrant.
	*
	* @return the quantity of this Warrant
	*/
	public int getQuantity() {
		return _warrant.getQuantity();
	}

	/**
	* Sets the quantity of this Warrant.
	*
	* @param quantity the quantity of this Warrant
	*/
	public void setQuantity(int quantity) {
		_warrant.setQuantity(quantity);
	}

	/**
	* Returns the price of this Warrant.
	*
	* @return the price of this Warrant
	*/
	public double getPrice() {
		return _warrant.getPrice();
	}

	/**
	* Sets the price of this Warrant.
	*
	* @param price the price of this Warrant
	*/
	public void setPrice(double price) {
		_warrant.setPrice(price);
	}

	/**
	* Returns the status of this Warrant.
	*
	* @return the status of this Warrant
	*/
	public java.lang.String getStatus() {
		return _warrant.getStatus();
	}

	/**
	* Sets the status of this Warrant.
	*
	* @param status the status of this Warrant
	*/
	public void setStatus(java.lang.String status) {
		_warrant.setStatus(status);
	}

	/**
	* Returns the create date of this Warrant.
	*
	* @return the create date of this Warrant
	*/
	public java.util.Date getCreateDate() {
		return _warrant.getCreateDate();
	}

	/**
	* Sets the create date of this Warrant.
	*
	* @param createDate the create date of this Warrant
	*/
	public void setCreateDate(java.util.Date createDate) {
		_warrant.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this Warrant.
	*
	* @return the modified date of this Warrant
	*/
	public java.util.Date getModifiedDate() {
		return _warrant.getModifiedDate();
	}

	/**
	* Sets the modified date of this Warrant.
	*
	* @param modifiedDate the modified date of this Warrant
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_warrant.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the expiration warning sent of this Warrant.
	*
	* @return the expiration warning sent of this Warrant
	*/
	public boolean getExpirationWarningSent() {
		return _warrant.getExpirationWarningSent();
	}

	/**
	* Returns <code>true</code> if this Warrant is expiration warning sent.
	*
	* @return <code>true</code> if this Warrant is expiration warning sent; <code>false</code> otherwise
	*/
	public boolean isExpirationWarningSent() {
		return _warrant.isExpirationWarningSent();
	}

	/**
	* Sets whether this Warrant is expiration warning sent.
	*
	* @param expirationWarningSent the expiration warning sent of this Warrant
	*/
	public void setExpirationWarningSent(boolean expirationWarningSent) {
		_warrant.setExpirationWarningSent(expirationWarningSent);
	}

	public boolean isNew() {
		return _warrant.isNew();
	}

	public void setNew(boolean n) {
		_warrant.setNew(n);
	}

	public boolean isCachedModel() {
		return _warrant.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_warrant.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _warrant.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _warrant.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_warrant.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _warrant.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_warrant.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WarrantWrapper((Warrant)_warrant.clone());
	}

	public int compareTo(com.warrantchange.model.Warrant warrant) {
		return _warrant.compareTo(warrant);
	}

	@Override
	public int hashCode() {
		return _warrant.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.warrantchange.model.Warrant> toCacheModel() {
		return _warrant.toCacheModel();
	}

	public com.warrantchange.model.Warrant toEscapedModel() {
		return new WarrantWrapper(_warrant.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _warrant.toString();
	}

	public java.lang.String toXmlString() {
		return _warrant.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_warrant.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Warrant getWrappedWarrant() {
		return _warrant;
	}

	public Warrant getWrappedModel() {
		return _warrant;
	}

	public void resetOriginalValues() {
		_warrant.resetOriginalValues();
	}

	private Warrant _warrant;
}