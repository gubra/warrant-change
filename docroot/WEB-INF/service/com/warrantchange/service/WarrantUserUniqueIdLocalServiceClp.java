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

package com.warrantchange.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author davidk
 */
public class WarrantUserUniqueIdLocalServiceClp
	implements WarrantUserUniqueIdLocalService {
	public WarrantUserUniqueIdLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addWarrantUserUniqueIdMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addWarrantUserUniqueId",
				com.warrantchange.model.WarrantUserUniqueId.class);

		_createWarrantUserUniqueIdMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createWarrantUserUniqueId", long.class);

		_deleteWarrantUserUniqueIdMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteWarrantUserUniqueId", long.class);

		_deleteWarrantUserUniqueIdMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteWarrantUserUniqueId",
				com.warrantchange.model.WarrantUserUniqueId.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_fetchWarrantUserUniqueIdMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchWarrantUserUniqueId", long.class);

		_getWarrantUserUniqueIdMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getWarrantUserUniqueId", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getWarrantUserUniqueIdsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getWarrantUserUniqueIds", int.class, int.class);

		_getWarrantUserUniqueIdsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getWarrantUserUniqueIdsCount");

		_updateWarrantUserUniqueIdMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateWarrantUserUniqueId",
				com.warrantchange.model.WarrantUserUniqueId.class);

		_updateWarrantUserUniqueIdMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateWarrantUserUniqueId",
				com.warrantchange.model.WarrantUserUniqueId.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_findByuniqueIdMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByuniqueId", java.lang.String.class);
	}

	public com.warrantchange.model.WarrantUserUniqueId addWarrantUserUniqueId(
		com.warrantchange.model.WarrantUserUniqueId warrantUserUniqueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addWarrantUserUniqueIdMethodKey0,
				ClpSerializer.translateInput(warrantUserUniqueId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.warrantchange.model.WarrantUserUniqueId)ClpSerializer.translateOutput(returnObj);
	}

	public com.warrantchange.model.WarrantUserUniqueId createWarrantUserUniqueId(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createWarrantUserUniqueIdMethodKey1,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.warrantchange.model.WarrantUserUniqueId)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteWarrantUserUniqueId(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteWarrantUserUniqueIdMethodKey2,
				id);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteWarrantUserUniqueId(
		com.warrantchange.model.WarrantUserUniqueId warrantUserUniqueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteWarrantUserUniqueIdMethodKey3,
				ClpSerializer.translateInput(warrantUserUniqueId));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public com.warrantchange.model.WarrantUserUniqueId fetchWarrantUserUniqueId(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchWarrantUserUniqueIdMethodKey8,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.warrantchange.model.WarrantUserUniqueId)ClpSerializer.translateOutput(returnObj);
	}

	public com.warrantchange.model.WarrantUserUniqueId getWarrantUserUniqueId(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getWarrantUserUniqueIdMethodKey9,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.warrantchange.model.WarrantUserUniqueId)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.warrantchange.model.WarrantUserUniqueId> getWarrantUserUniqueIds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getWarrantUserUniqueIdsMethodKey11,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.warrantchange.model.WarrantUserUniqueId>)ClpSerializer.translateOutput(returnObj);
	}

	public int getWarrantUserUniqueIdsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getWarrantUserUniqueIdsCountMethodKey12);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.warrantchange.model.WarrantUserUniqueId updateWarrantUserUniqueId(
		com.warrantchange.model.WarrantUserUniqueId warrantUserUniqueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateWarrantUserUniqueIdMethodKey13,
				ClpSerializer.translateInput(warrantUserUniqueId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.warrantchange.model.WarrantUserUniqueId)ClpSerializer.translateOutput(returnObj);
	}

	public com.warrantchange.model.WarrantUserUniqueId updateWarrantUserUniqueId(
		com.warrantchange.model.WarrantUserUniqueId warrantUserUniqueId,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateWarrantUserUniqueIdMethodKey14,
				ClpSerializer.translateInput(warrantUserUniqueId), merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.warrantchange.model.WarrantUserUniqueId)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey15);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey16,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.warrantchange.model.WarrantUserUniqueId findByuniqueId(
		java.lang.String uniqueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByuniqueIdMethodKey17,
				ClpSerializer.translateInput(uniqueId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.warrantchange.NoSuchWarrantUserUniqueIdException) {
				throw (com.warrantchange.NoSuchWarrantUserUniqueIdException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.warrantchange.model.WarrantUserUniqueId)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addWarrantUserUniqueIdMethodKey0;
	private MethodKey _createWarrantUserUniqueIdMethodKey1;
	private MethodKey _deleteWarrantUserUniqueIdMethodKey2;
	private MethodKey _deleteWarrantUserUniqueIdMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchWarrantUserUniqueIdMethodKey8;
	private MethodKey _getWarrantUserUniqueIdMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getWarrantUserUniqueIdsMethodKey11;
	private MethodKey _getWarrantUserUniqueIdsCountMethodKey12;
	private MethodKey _updateWarrantUserUniqueIdMethodKey13;
	private MethodKey _updateWarrantUserUniqueIdMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _findByuniqueIdMethodKey17;
}