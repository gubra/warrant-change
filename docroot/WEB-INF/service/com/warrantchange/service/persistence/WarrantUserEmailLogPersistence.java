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

import com.warrantchange.model.WarrantUserEmailLog;

/**
 * The persistence interface for the WarrantUserEmailLog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author davidk
 * @see WarrantUserEmailLogPersistenceImpl
 * @see WarrantUserEmailLogUtil
 * @generated
 */
public interface WarrantUserEmailLogPersistence extends BasePersistence<WarrantUserEmailLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WarrantUserEmailLogUtil} to access the WarrantUserEmailLog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the WarrantUserEmailLog in the entity cache if it is enabled.
	*
	* @param warrantUserEmailLog the WarrantUserEmailLog
	*/
	public void cacheResult(
		com.warrantchange.model.WarrantUserEmailLog warrantUserEmailLog);

	/**
	* Caches the WarrantUserEmailLogs in the entity cache if it is enabled.
	*
	* @param warrantUserEmailLogs the WarrantUserEmailLogs
	*/
	public void cacheResult(
		java.util.List<com.warrantchange.model.WarrantUserEmailLog> warrantUserEmailLogs);

	/**
	* Creates a new WarrantUserEmailLog with the primary key. Does not add the WarrantUserEmailLog to the database.
	*
	* @param id the primary key for the new WarrantUserEmailLog
	* @return the new WarrantUserEmailLog
	*/
	public com.warrantchange.model.WarrantUserEmailLog create(long id);

	/**
	* Removes the WarrantUserEmailLog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the WarrantUserEmailLog
	* @return the WarrantUserEmailLog that was removed
	* @throws com.warrantchange.NoSuchWarrantUserEmailLogException if a WarrantUserEmailLog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserEmailLog remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserEmailLogException;

	public com.warrantchange.model.WarrantUserEmailLog updateImpl(
		com.warrantchange.model.WarrantUserEmailLog warrantUserEmailLog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the WarrantUserEmailLog with the primary key or throws a {@link com.warrantchange.NoSuchWarrantUserEmailLogException} if it could not be found.
	*
	* @param id the primary key of the WarrantUserEmailLog
	* @return the WarrantUserEmailLog
	* @throws com.warrantchange.NoSuchWarrantUserEmailLogException if a WarrantUserEmailLog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserEmailLog findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserEmailLogException;

	/**
	* Returns the WarrantUserEmailLog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the WarrantUserEmailLog
	* @return the WarrantUserEmailLog, or <code>null</code> if a WarrantUserEmailLog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserEmailLog fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the WarrantUserEmailLog where userId = &#63; or throws a {@link com.warrantchange.NoSuchWarrantUserEmailLogException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching WarrantUserEmailLog
	* @throws com.warrantchange.NoSuchWarrantUserEmailLogException if a matching WarrantUserEmailLog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserEmailLog findByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserEmailLogException;

	/**
	* Returns the WarrantUserEmailLog where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching WarrantUserEmailLog, or <code>null</code> if a matching WarrantUserEmailLog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserEmailLog fetchByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the WarrantUserEmailLog where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching WarrantUserEmailLog, or <code>null</code> if a matching WarrantUserEmailLog could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.WarrantUserEmailLog fetchByuserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the WarrantUserEmailLogs.
	*
	* @return the WarrantUserEmailLogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrantchange.model.WarrantUserEmailLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the WarrantUserEmailLogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of WarrantUserEmailLogs
	* @param end the upper bound of the range of WarrantUserEmailLogs (not inclusive)
	* @return the range of WarrantUserEmailLogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrantchange.model.WarrantUserEmailLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the WarrantUserEmailLogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of WarrantUserEmailLogs
	* @param end the upper bound of the range of WarrantUserEmailLogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WarrantUserEmailLogs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrantchange.model.WarrantUserEmailLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the WarrantUserEmailLog where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantUserEmailLogException;

	/**
	* Removes all the WarrantUserEmailLogs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of WarrantUserEmailLogs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching WarrantUserEmailLogs
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of WarrantUserEmailLogs.
	*
	* @return the number of WarrantUserEmailLogs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}