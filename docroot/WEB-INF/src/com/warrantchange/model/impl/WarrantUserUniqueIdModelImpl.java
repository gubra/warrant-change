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

package com.warrantchange.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.warrantchange.model.WarrantUserUniqueId;
import com.warrantchange.model.WarrantUserUniqueIdModel;
import com.warrantchange.model.WarrantUserUniqueIdSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the WarrantUserUniqueId service. Represents a row in the &quot;warrantUserUniqueId&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.warrantchange.model.WarrantUserUniqueIdModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WarrantUserUniqueIdImpl}.
 * </p>
 *
 * @author davidk
 * @see WarrantUserUniqueIdImpl
 * @see com.warrantchange.model.WarrantUserUniqueId
 * @see com.warrantchange.model.WarrantUserUniqueIdModel
 * @generated
 */
@JSON(strict = true)
public class WarrantUserUniqueIdModelImpl extends BaseModelImpl<WarrantUserUniqueId>
	implements WarrantUserUniqueIdModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a WarrantUserUniqueId model instance should use the {@link com.warrantchange.model.WarrantUserUniqueId} interface instead.
	 */
	public static final String TABLE_NAME = "warrantUserUniqueId";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "uniqueId", Types.VARCHAR },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table warrantUserUniqueId (id_ LONG not null primary key,uniqueId VARCHAR(75) null,userId LONG,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table warrantUserUniqueId";
	public static final String ORDER_BY_JPQL = " ORDER BY warrantUserUniqueId.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY warrantUserUniqueId.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.warrantchange.model.WarrantUserUniqueId"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.warrantchange.model.WarrantUserUniqueId"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.warrantchange.model.WarrantUserUniqueId"),
			true);
	public static long UNIQUEID_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static WarrantUserUniqueId toModel(WarrantUserUniqueIdSoap soapModel) {
		WarrantUserUniqueId model = new WarrantUserUniqueIdImpl();

		model.setId(soapModel.getId());
		model.setUniqueId(soapModel.getUniqueId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<WarrantUserUniqueId> toModels(
		WarrantUserUniqueIdSoap[] soapModels) {
		List<WarrantUserUniqueId> models = new ArrayList<WarrantUserUniqueId>(soapModels.length);

		for (WarrantUserUniqueIdSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.warrantchange.model.WarrantUserUniqueId"));

	public WarrantUserUniqueIdModelImpl() {
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

	public Class<?> getModelClass() {
		return WarrantUserUniqueId.class;
	}

	public String getModelClassName() {
		return WarrantUserUniqueId.class.getName();
	}

	@JSON
	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	@JSON
	public String getUniqueId() {
		if (_uniqueId == null) {
			return StringPool.BLANK;
		}
		else {
			return _uniqueId;
		}
	}

	public void setUniqueId(String uniqueId) {
		_columnBitmask |= UNIQUEID_COLUMN_BITMASK;

		if (_originalUniqueId == null) {
			_originalUniqueId = _uniqueId;
		}

		_uniqueId = uniqueId;
	}

	public String getOriginalUniqueId() {
		return GetterUtil.getString(_originalUniqueId);
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public WarrantUserUniqueId toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (WarrantUserUniqueId)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					WarrantUserUniqueId.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		WarrantUserUniqueIdImpl warrantUserUniqueIdImpl = new WarrantUserUniqueIdImpl();

		warrantUserUniqueIdImpl.setId(getId());
		warrantUserUniqueIdImpl.setUniqueId(getUniqueId());
		warrantUserUniqueIdImpl.setUserId(getUserId());
		warrantUserUniqueIdImpl.setCreateDate(getCreateDate());
		warrantUserUniqueIdImpl.setModifiedDate(getModifiedDate());

		warrantUserUniqueIdImpl.resetOriginalValues();

		return warrantUserUniqueIdImpl;
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

		WarrantUserUniqueId warrantUserUniqueId = null;

		try {
			warrantUserUniqueId = (WarrantUserUniqueId)obj;
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
	public void resetOriginalValues() {
		WarrantUserUniqueIdModelImpl warrantUserUniqueIdModelImpl = this;

		warrantUserUniqueIdModelImpl._originalUniqueId = warrantUserUniqueIdModelImpl._uniqueId;

		warrantUserUniqueIdModelImpl._originalUserId = warrantUserUniqueIdModelImpl._userId;

		warrantUserUniqueIdModelImpl._setOriginalUserId = false;

		warrantUserUniqueIdModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WarrantUserUniqueId> toCacheModel() {
		WarrantUserUniqueIdCacheModel warrantUserUniqueIdCacheModel = new WarrantUserUniqueIdCacheModel();

		warrantUserUniqueIdCacheModel.id = getId();

		warrantUserUniqueIdCacheModel.uniqueId = getUniqueId();

		String uniqueId = warrantUserUniqueIdCacheModel.uniqueId;

		if ((uniqueId != null) && (uniqueId.length() == 0)) {
			warrantUserUniqueIdCacheModel.uniqueId = null;
		}

		warrantUserUniqueIdCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			warrantUserUniqueIdCacheModel.createDate = createDate.getTime();
		}
		else {
			warrantUserUniqueIdCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			warrantUserUniqueIdCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			warrantUserUniqueIdCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return warrantUserUniqueIdCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

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
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

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

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = WarrantUserUniqueId.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			WarrantUserUniqueId.class
		};
	private long _id;
	private String _uniqueId;
	private String _originalUniqueId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private WarrantUserUniqueId _escapedModelProxy;
}