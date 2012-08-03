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
 * The base model interface for the WarrantUserEmailLog service. Represents a row in the &quot;warrantUserEmailLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.warrantchange.model.impl.WarrantUserEmailLogModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.warrantchange.model.impl.WarrantUserEmailLogImpl}.
 * </p>
 *
 * @author davidk
 * @see WarrantUserEmailLog
 * @see com.warrantchange.model.impl.WarrantUserEmailLogImpl
 * @see com.warrantchange.model.impl.WarrantUserEmailLogModelImpl
 * @generated
 */
public interface WarrantUserEmailLogModel extends BaseModel<WarrantUserEmailLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a WarrantUserEmailLog model instance should use the {@link WarrantUserEmailLog} interface instead.
	 */

	/**
	 * Returns the primary key of this WarrantUserEmailLog.
	 *
	 * @return the primary key of this WarrantUserEmailLog
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this WarrantUserEmailLog.
	 *
	 * @param primaryKey the primary key of this WarrantUserEmailLog
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this WarrantUserEmailLog.
	 *
	 * @return the ID of this WarrantUserEmailLog
	 */
	public long getId();

	/**
	 * Sets the ID of this WarrantUserEmailLog.
	 *
	 * @param id the ID of this WarrantUserEmailLog
	 */
	public void setId(long id);

	/**
	 * Returns the subject of this WarrantUserEmailLog.
	 *
	 * @return the subject of this WarrantUserEmailLog
	 */
	@AutoEscape
	public String getSubject();

	/**
	 * Sets the subject of this WarrantUserEmailLog.
	 *
	 * @param subject the subject of this WarrantUserEmailLog
	 */
	public void setSubject(String subject);

	/**
	 * Returns the body content of this WarrantUserEmailLog.
	 *
	 * @return the body content of this WarrantUserEmailLog
	 */
	@AutoEscape
	public String getBodyContent();

	/**
	 * Sets the body content of this WarrantUserEmailLog.
	 *
	 * @param bodyContent the body content of this WarrantUserEmailLog
	 */
	public void setBodyContent(String bodyContent);

	/**
	 * Returns the user ID of this WarrantUserEmailLog.
	 *
	 * @return the user ID of this WarrantUserEmailLog
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this WarrantUserEmailLog.
	 *
	 * @param userId the user ID of this WarrantUserEmailLog
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this WarrantUserEmailLog.
	 *
	 * @return the user uuid of this WarrantUserEmailLog
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this WarrantUserEmailLog.
	 *
	 * @param userUuid the user uuid of this WarrantUserEmailLog
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this WarrantUserEmailLog.
	 *
	 * @return the create date of this WarrantUserEmailLog
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this WarrantUserEmailLog.
	 *
	 * @param createDate the create date of this WarrantUserEmailLog
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this WarrantUserEmailLog.
	 *
	 * @return the modified date of this WarrantUserEmailLog
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this WarrantUserEmailLog.
	 *
	 * @param modifiedDate the modified date of this WarrantUserEmailLog
	 */
	public void setModifiedDate(Date modifiedDate);

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

	public int compareTo(WarrantUserEmailLog warrantUserEmailLog);

	public int hashCode();

	public CacheModel<WarrantUserEmailLog> toCacheModel();

	public WarrantUserEmailLog toEscapedModel();

	public String toString();

	public String toXmlString();
}