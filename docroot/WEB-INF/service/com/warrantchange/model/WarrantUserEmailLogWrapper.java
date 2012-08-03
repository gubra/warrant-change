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
 * This class is a wrapper for {@link WarrantUserEmailLog}.
 * </p>
 *
 * @author    davidk
 * @see       WarrantUserEmailLog
 * @generated
 */
public class WarrantUserEmailLogWrapper implements WarrantUserEmailLog,
	ModelWrapper<WarrantUserEmailLog> {
	public WarrantUserEmailLogWrapper(WarrantUserEmailLog warrantUserEmailLog) {
		_warrantUserEmailLog = warrantUserEmailLog;
	}

	public Class<?> getModelClass() {
		return WarrantUserEmailLog.class;
	}

	public String getModelClassName() {
		return WarrantUserEmailLog.class.getName();
	}

	/**
	* Returns the primary key of this WarrantUserEmailLog.
	*
	* @return the primary key of this WarrantUserEmailLog
	*/
	public long getPrimaryKey() {
		return _warrantUserEmailLog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this WarrantUserEmailLog.
	*
	* @param primaryKey the primary key of this WarrantUserEmailLog
	*/
	public void setPrimaryKey(long primaryKey) {
		_warrantUserEmailLog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this WarrantUserEmailLog.
	*
	* @return the ID of this WarrantUserEmailLog
	*/
	public long getId() {
		return _warrantUserEmailLog.getId();
	}

	/**
	* Sets the ID of this WarrantUserEmailLog.
	*
	* @param id the ID of this WarrantUserEmailLog
	*/
	public void setId(long id) {
		_warrantUserEmailLog.setId(id);
	}

	/**
	* Returns the subject of this WarrantUserEmailLog.
	*
	* @return the subject of this WarrantUserEmailLog
	*/
	public java.lang.String getSubject() {
		return _warrantUserEmailLog.getSubject();
	}

	/**
	* Sets the subject of this WarrantUserEmailLog.
	*
	* @param subject the subject of this WarrantUserEmailLog
	*/
	public void setSubject(java.lang.String subject) {
		_warrantUserEmailLog.setSubject(subject);
	}

	/**
	* Returns the body content of this WarrantUserEmailLog.
	*
	* @return the body content of this WarrantUserEmailLog
	*/
	public java.lang.String getBodyContent() {
		return _warrantUserEmailLog.getBodyContent();
	}

	/**
	* Sets the body content of this WarrantUserEmailLog.
	*
	* @param bodyContent the body content of this WarrantUserEmailLog
	*/
	public void setBodyContent(java.lang.String bodyContent) {
		_warrantUserEmailLog.setBodyContent(bodyContent);
	}

	/**
	* Returns the user ID of this WarrantUserEmailLog.
	*
	* @return the user ID of this WarrantUserEmailLog
	*/
	public long getUserId() {
		return _warrantUserEmailLog.getUserId();
	}

	/**
	* Sets the user ID of this WarrantUserEmailLog.
	*
	* @param userId the user ID of this WarrantUserEmailLog
	*/
	public void setUserId(long userId) {
		_warrantUserEmailLog.setUserId(userId);
	}

	/**
	* Returns the user uuid of this WarrantUserEmailLog.
	*
	* @return the user uuid of this WarrantUserEmailLog
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _warrantUserEmailLog.getUserUuid();
	}

	/**
	* Sets the user uuid of this WarrantUserEmailLog.
	*
	* @param userUuid the user uuid of this WarrantUserEmailLog
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_warrantUserEmailLog.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this WarrantUserEmailLog.
	*
	* @return the create date of this WarrantUserEmailLog
	*/
	public java.util.Date getCreateDate() {
		return _warrantUserEmailLog.getCreateDate();
	}

	/**
	* Sets the create date of this WarrantUserEmailLog.
	*
	* @param createDate the create date of this WarrantUserEmailLog
	*/
	public void setCreateDate(java.util.Date createDate) {
		_warrantUserEmailLog.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this WarrantUserEmailLog.
	*
	* @return the modified date of this WarrantUserEmailLog
	*/
	public java.util.Date getModifiedDate() {
		return _warrantUserEmailLog.getModifiedDate();
	}

	/**
	* Sets the modified date of this WarrantUserEmailLog.
	*
	* @param modifiedDate the modified date of this WarrantUserEmailLog
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_warrantUserEmailLog.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _warrantUserEmailLog.isNew();
	}

	public void setNew(boolean n) {
		_warrantUserEmailLog.setNew(n);
	}

	public boolean isCachedModel() {
		return _warrantUserEmailLog.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_warrantUserEmailLog.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _warrantUserEmailLog.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _warrantUserEmailLog.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_warrantUserEmailLog.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _warrantUserEmailLog.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_warrantUserEmailLog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WarrantUserEmailLogWrapper((WarrantUserEmailLog)_warrantUserEmailLog.clone());
	}

	public int compareTo(
		com.warrantchange.model.WarrantUserEmailLog warrantUserEmailLog) {
		return _warrantUserEmailLog.compareTo(warrantUserEmailLog);
	}

	@Override
	public int hashCode() {
		return _warrantUserEmailLog.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.warrantchange.model.WarrantUserEmailLog> toCacheModel() {
		return _warrantUserEmailLog.toCacheModel();
	}

	public com.warrantchange.model.WarrantUserEmailLog toEscapedModel() {
		return new WarrantUserEmailLogWrapper(_warrantUserEmailLog.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _warrantUserEmailLog.toString();
	}

	public java.lang.String toXmlString() {
		return _warrantUserEmailLog.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_warrantUserEmailLog.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public WarrantUserEmailLog getWrappedWarrantUserEmailLog() {
		return _warrantUserEmailLog;
	}

	public WarrantUserEmailLog getWrappedModel() {
		return _warrantUserEmailLog;
	}

	public void resetOriginalValues() {
		_warrantUserEmailLog.resetOriginalValues();
	}

	private WarrantUserEmailLog _warrantUserEmailLog;
}