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

import com.liferay.portal.service.persistence.BasePersistence;

import com.warrantchange.model.WarrantUserUniqueId;

/**
 * The persistence interface for the WarrantUserUniqueId service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author davidk
 * @see WarrantUserUniqueIdPersistenceImpl
 * @see WarrantUserUniqueIdUtil
 * @generated
 */
public interface WarrantUserUniqueIdPersistence extends BasePersistence<WarrantUserUniqueId> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WarrantUserUniqueIdUtil} to access the WarrantUserUniqueId persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the WarrantUserUniqueId in the entity cache if it is enabled.
	*
	* @param warrantUserUniqueId the WarrantUserUniqueId
	*/
	public void cacheResult(
		com.warrantchange.model.WarrantUserUniqueId warrantUserUniqueId);

	/**
	* Caches the WarrantUserUniqueIds in the entity cache if it is enabled.
	*
	* @param warrantUserUniqueIds the WarrantUserUniqueIds
	*/
	public void cacheResult(
		java.util.List<com.warrantchange.model.WarrantUserUniqueId> warrantUserUniqueIds);

	/**
	* Creates a new WarrantUserUniqueId with the primary key. Does not add the WarrantUserUniqueId to the database.
	*
	* @param id the primary key for the new WarrantUserUniqueId
	* @return the new WarrantUserUniqueId
	*/
	public com.warrantchange.model.WarrantUserUniqueId create(long id);

	/**
	* Removes the WarrantUserUniqueId with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the WarrantUserUniqueId
	* @return the WarrantUserUniqueId that was removed
	* @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a WarrantUserUniqueId with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserUniqueId remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException;

	public com.warrantchange.model.WarrantUserUniqueId updateImpl(
		com.warrantchange.model.WarrantUserUniqueId warrantUserUniqueId,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the WarrantUserUniqueId with the primary key or throws a {@link com.warrantchange.NoSuchWarrantUserUniqueIdException} if it could not be found.
	*
	* @param id the primary key of the WarrantUserUniqueId
	* @return the WarrantUserUniqueId
	* @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a WarrantUserUniqueId with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserUniqueId findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException;

	/**
	* Returns the WarrantUserUniqueId with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the WarrantUserUniqueId
	* @return the WarrantUserUniqueId, or <code>null</code> if a WarrantUserUniqueId with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserUniqueId fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the WarrantUserUniqueId where uniqueId = &#63; or throws a {@link com.warrantchange.NoSuchWarrantUserUniqueIdException} if it could not be found.
	*
	* @param uniqueId the unique ID
	* @return the matching WarrantUserUniqueId
	* @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a matching WarrantUserUniqueId could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserUniqueId findByuniqueId(
		java.lang.String uniqueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException;

	/**
	* Returns the WarrantUserUniqueId where uniqueId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uniqueId the unique ID
	* @return the matching WarrantUserUniqueId, or <code>null</code> if a matching WarrantUserUniqueId could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserUniqueId fetchByuniqueId(
		java.lang.String uniqueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the WarrantUserUniqueId where uniqueId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uniqueId the unique ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching WarrantUserUniqueId, or <code>null</code> if a matching WarrantUserUniqueId could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserUniqueId fetchByuniqueId(
		java.lang.String uniqueId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the WarrantUserUniqueId where userId = &#63; or throws a {@link com.warrantchange.NoSuchWarrantUserUniqueIdException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching WarrantUserUniqueId
	* @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a matching WarrantUserUniqueId could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserUniqueId findByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException;

	/**
	* Returns the WarrantUserUniqueId where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching WarrantUserUniqueId, or <code>null</code> if a matching WarrantUserUniqueId could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserUniqueId fetchByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the WarrantUserUniqueId where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching WarrantUserUniqueId, or <code>null</code> if a matching WarrantUserUniqueId could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserUniqueId fetchByuserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the WarrantUserUniqueIds.
	*
	* @return the WarrantUserUniqueIds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrantchange.model.WarrantUserUniqueId> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrantchange.model.WarrantUserUniqueId> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.warrantchange.model.WarrantUserUniqueId> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the WarrantUserUniqueId where uniqueId = &#63; from the database.
	*
	* @param uniqueId the unique ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuniqueId(java.lang.String uniqueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException;

	/**
	* Removes the WarrantUserUniqueId where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserUniqueIdException;

	/**
	* Removes all the WarrantUserUniqueIds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of WarrantUserUniqueIds where uniqueId = &#63;.
	*
	* @param uniqueId the unique ID
	* @return the number of matching WarrantUserUniqueIds
	* @throws SystemException if a system exception occurred
	*/
	public int countByuniqueId(java.lang.String uniqueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of WarrantUserUniqueIds where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching WarrantUserUniqueIds
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of WarrantUserUniqueIds.
	*
	* @return the number of WarrantUserUniqueIds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}