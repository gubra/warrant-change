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

package com.warrantchange.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.warrantchange.model.WarrantUserUniqueId;

import java.util.List;

/**
 * The persistence utility for the WarrantUserUniqueId service. This utility wraps {@link WarrantUserUniqueIdPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author davidk
 * @see WarrantUserUniqueIdPersistence
 * @see WarrantUserUniqueIdPersistenceImpl
 * @generated
 */
public class WarrantUserUniqueIdUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(WarrantUserUniqueId warrantUserUniqueId) {
		getPersistence().clearCache(warrantUserUniqueId);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WarrantUserUniqueId> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WarrantUserUniqueId> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WarrantUserUniqueId> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static WarrantUserUniqueId update(
		WarrantUserUniqueId warrantUserUniqueId, boolean merge)
		throws SystemException {
		return getPersistence().update(warrantUserUniqueId, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static WarrantUserUniqueId update(
		WarrantUserUniqueId warrantUserUniqueId, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(warrantUserUniqueId, merge, serviceContext);
	}

	/**
	* Caches the WarrantUserUniqueId in the entity cache if it is enabled.
	*
	* @param warrantUserUniqueId the WarrantUserUniqueId
	*/
	public static void cacheResult(
		com.warrantchange.model.WarrantUserUniqueId warrantUserUniqueId) {
		getPersistence().cacheResult(warrantUserUniqueId);
	}

	/**
	* Caches the WarrantUserUniqueIds in the entity cache if it is enabled.
	*
	* @param warrantUserUniqueIds the WarrantUserUniqueIds
	*/
	public static void cacheResult(
		java.util.List<com.warrantchange.model.WarrantUserUniqueId> warrantUserUniqueIds) {
		getPersistence().cacheResult(warrantUserUniqueIds);
	}

	/**
	* Creates a new WarrantUserUniqueId with the primary key. Does not add the WarrantUserUniqueId to the database.
	*
	* @param id the primary key for the new WarrantUserUniqueId
	* @return the new WarrantUserUniqueId
	*/
	public static com.warrantchange.model.WarrantUserUniqueId create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the WarrantUserUniqueId with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the WarrantUserUniqueId
	* @return the WarrantUserUniqueId that was removed
	* @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a WarrantUserUniqueId with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserUniqueId remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException {
		return getPersistence().remove(id);
	}

	public static com.warrantchange.model.WarrantUserUniqueId updateImpl(
		com.warrantchange.model.WarrantUserUniqueId warrantUserUniqueId,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(warrantUserUniqueId, merge);
	}

	/**
	* Returns the WarrantUserUniqueId with the primary key or throws a {@link com.warrantchange.NoSuchWarrantUserUniqueIdException} if it could not be found.
	*
	* @param id the primary key of the WarrantUserUniqueId
	* @return the WarrantUserUniqueId
	* @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a WarrantUserUniqueId with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserUniqueId findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the WarrantUserUniqueId with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the WarrantUserUniqueId
	* @return the WarrantUserUniqueId, or <code>null</code> if a WarrantUserUniqueId with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserUniqueId fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the WarrantUserUniqueId where uniqueId = &#63; or throws a {@link com.warrantchange.NoSuchWarrantUserUniqueIdException} if it could not be found.
	*
	* @param uniqueId the unique ID
	* @return the matching WarrantUserUniqueId
	* @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a matching WarrantUserUniqueId could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserUniqueId findByuniqueId(
		java.lang.String uniqueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException {
		return getPersistence().findByuniqueId(uniqueId);
	}

	/**
	* Returns the WarrantUserUniqueId where uniqueId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uniqueId the unique ID
	* @return the matching WarrantUserUniqueId, or <code>null</code> if a matching WarrantUserUniqueId could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserUniqueId fetchByuniqueId(
		java.lang.String uniqueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuniqueId(uniqueId);
	}

	/**
	* Returns the WarrantUserUniqueId where uniqueId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uniqueId the unique ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching WarrantUserUniqueId, or <code>null</code> if a matching WarrantUserUniqueId could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserUniqueId fetchByuniqueId(
		java.lang.String uniqueId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuniqueId(uniqueId, retrieveFromCache);
	}

	/**
	* Returns the WarrantUserUniqueId where userId = &#63; or throws a {@link com.warrantchange.NoSuchWarrantUserUniqueIdException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching WarrantUserUniqueId
	* @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a matching WarrantUserUniqueId could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserUniqueId findByuserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException {
		return getPersistence().findByuserId(userId);
	}

	/**
	* Returns the WarrantUserUniqueId where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching WarrantUserUniqueId, or <code>null</code> if a matching WarrantUserUniqueId could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserUniqueId fetchByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId(userId);
	}

	/**
	* Returns the WarrantUserUniqueId where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching WarrantUserUniqueId, or <code>null</code> if a matching WarrantUserUniqueId could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserUniqueId fetchByuserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId(userId, retrieveFromCache);
	}

	/**
	* Returns all the WarrantUserUniqueIds.
	*
	* @return the WarrantUserUniqueIds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrantchange.model.WarrantUserUniqueId> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the WarrantUserUniqueIds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of WarrantUserUniqueIds
	* @param end the upper bound of the range of WarrantUserUniqueIds (not inclusive)
	* @return the range of WarrantUserUniqueIds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrantchange.model.WarrantUserUniqueId> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the WarrantUserUniqueIds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of WarrantUserUniqueIds
	* @param end the upper bound of the range of WarrantUserUniqueIds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WarrantUserUniqueIds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.warrantchange.model.WarrantUserUniqueId> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the WarrantUserUniqueId where uniqueId = &#63; from the database.
	*
	* @param uniqueId the unique ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuniqueId(java.lang.String uniqueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException {
		getPersistence().removeByuniqueId(uniqueId);
	}

	/**
	* Removes the WarrantUserUniqueId where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException {
		getPersistence().removeByuserId(userId);
	}

	/**
	* Removes all the WarrantUserUniqueIds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of WarrantUserUniqueIds where uniqueId = &#63;.
	*
	* @param uniqueId the unique ID
	* @return the number of matching WarrantUserUniqueIds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuniqueId(java.lang.String uniqueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuniqueId(uniqueId);
	}

	/**
	* Returns the number of WarrantUserUniqueIds where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching WarrantUserUniqueIds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Returns the number of WarrantUserUniqueIds.
	*
	* @return the number of WarrantUserUniqueIds
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WarrantUserUniqueIdPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WarrantUserUniqueIdPersistence)PortletBeanLocatorUtil.locate(com.warrantchange.service.ClpSerializer.getServletContextName(),
					WarrantUserUniqueIdPersistence.class.getName());

			ReferenceRegistry.registerReference(WarrantUserUniqueIdUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(WarrantUserUniqueIdPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(WarrantUserUniqueIdUtil.class,
			"_persistence");
	}

	private static WarrantUserUniqueIdPersistence _persistence;
}