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
 * This class is a wrapper for {@link WarrantUserUniqueId}.
 * </p>
 *
 * @author    davidk
 * @see       WarrantUserUniqueId
 * @generated
 */
public class WarrantUserUniqueIdWrapper implements WarrantUserUniqueId,
	ModelWrapper<WarrantUserUniqueId> {
	public WarrantUserUniqueIdWrapper(WarrantUserUniqueId warrantUserUniqueId) {
		_warrantUserUniqueId = warrantUserUniqueId;
	}

	public Class<?> getModelClass() {
		return WarrantUserUniqueId.class;
	}

	public String getModelClassName() {
		return WarrantUserUniqueId.class.getName();
	}

	/**
	* Returns the primary key of this WarrantUserUniqueId.
	*
	* @return the primary key of this WarrantUserUniqueId
	*/
	public long getPrimaryKey() {
		return _warrantUserUniqueId.getPrimaryKey();
	}

	/**
	* Sets the primary key of this WarrantUserUniqueId.
	*
	* @param primaryKey the primary key of this WarrantUserUniqueId
	*/
	public void setPrimaryKey(long primaryKey) {
		_warrantUserUniqueId.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this WarrantUserUniqueId.
	*
	* @return the ID of this WarrantUserUniqueId
	*/
	public long getId() {
		return _warrantUserUniqueId.getId();
	}

	/**
	* Sets the ID of this WarrantUserUniqueId.
	*
	* @param id the ID of this WarrantUserUniqueId
	*/
	public void setId(long id) {
		_warrantUserUniqueId.setId(id);
	}

	/**
	* Returns the unique ID of this WarrantUserUniqueId.
	*
	* @return the unique ID of this WarrantUserUniqueId
	*/
	public java.lang.String getUniqueId() {
		return _warrantUserUniqueId.getUniqueId();
	}

	/**
	* Sets the unique ID of this WarrantUserUniqueId.
	*
	* @param uniqueId the unique ID of this WarrantUserUniqueId
	*/
	public void setUniqueId(java.lang.String uniqueId) {
		_warrantUserUniqueId.setUniqueId(uniqueId);
	}

	/**
	* Returns the user ID of this WarrantUserUniqueId.
	*
	* @return the user ID of this WarrantUserUniqueId
	*/
	public long getUserId() {
		return _warrantUserUniqueId.getUserId();
	}

	/**
	* Sets the user ID of this WarrantUserUniqueId.
	*
	* @param userId the user ID of this WarrantUserUniqueId
	*/
	public void setUserId(long userId) {
		_warrantUserUniqueId.setUserId(userId);
	}

	/**
	* Returns the user uuid of this WarrantUserUniqueId.
	*
	* @return the user uuid of this WarrantUserUniqueId
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _warrantUserUniqueId.getUserUuid();
	}

	/**
	* Sets the user uuid of this WarrantUserUniqueId.
	*
	* @param userUuid the user uuid of this WarrantUserUniqueId
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_warrantUserUniqueId.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this WarrantUserUniqueId.
	*
	* @return the create date of this WarrantUserUniqueId
	*/
	public java.util.Date getCreateDate() {
		return _warrantUserUniqueId.getCreateDate();
	}

	/**
	* Sets the create date of this WarrantUserUniqueId.
	*
	* @param createDate the create date of this WarrantUserUniqueId
	*/
	public void setCreateDate(java.util.Date createDate) {
		_warrantUserUniqueId.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this WarrantUserUniqueId.
	*
	* @return the modified date of this WarrantUserUniqueId
	*/
	public java.util.Date getModifiedDate() {
		return _warrantUserUniqueId.getModifiedDate();
	}

	/**
	* Sets the modified date of this WarrantUserUniqueId.
	*
	* @param modifiedDate the modified date of this WarrantUserUniqueId
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_warrantUserUniqueId.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _warrantUserUniqueId.isNew();
	}

	public void setNew(boolean n) {
		_warrantUserUniqueId.setNew(n);
	}

	public boolean isCachedModel() {
		return _warrantUserUniqueId.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_warrantUserUniqueId.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _warrantUserUniqueId.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _warrantUserUniqueId.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_warrantUserUniqueId.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _warrantUserUniqueId.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_warrantUserUniqueId.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WarrantUserUniqueIdWrapper((WarrantUserUniqueId)_warrantUserUniqueId.clone());
	}

	public int compareTo(
		com.warrantchange.model.WarrantUserUniqueId warrantUserUniqueId) {
		return _warrantUserUniqueId.compareTo(warrantUserUniqueId);
	}

	@Override
	public int hashCode() {
		return _warrantUserUniqueId.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.warrantchange.model.WarrantUserUniqueId> toCacheModel() {
		return _warrantUserUniqueId.toCacheModel();
	}

	public com.warrantchange.model.WarrantUserUniqueId toEscapedModel() {
		return new WarrantUserUniqueIdWrapper(_warrantUserUniqueId.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _warrantUserUniqueId.toString();
	}

	public java.lang.String toXmlString() {
		return _warrantUserUniqueId.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_warrantUserUniqueId.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public WarrantUserUniqueId getWrappedWarrantUserUniqueId() {
		return _warrantUserUniqueId;
	}

	public WarrantUserUniqueId getWrappedModel() {
		return _warrantUserUniqueId;
	}

	public void resetOriginalValues() {
		_warrantUserUniqueId.resetOriginalValues();
	}

	private WarrantUserUniqueId _warrantUserUniqueId;
}