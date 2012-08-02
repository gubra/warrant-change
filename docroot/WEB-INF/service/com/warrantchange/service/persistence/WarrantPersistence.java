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

import com.warrantchange.model.Warrant;

/**
 * The persistence interface for the Warrant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author davidk
 * @see WarrantPersistenceImpl
 * @see WarrantUtil
 * @generated
 */
public interface WarrantPersistence extends BasePersistence<Warrant> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WarrantUtil} to access the Warrant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the Warrant in the entity cache if it is enabled.
	*
	* @param warrant the Warrant
	*/
	public void cacheResult(com.warrantchange.model.Warrant warrant);

	/**
	* Caches the Warrants in the entity cache if it is enabled.
	*
	* @param warrants the Warrants
	*/
	public void cacheResult(
		java.util.List<com.warrantchange.model.Warrant> warrants);

	/**
	* Creates a new Warrant with the primary key. Does not add the Warrant to the database.
	*
	* @param id the primary key for the new Warrant
	* @return the new Warrant
	*/
	public com.warrantchange.model.Warrant create(long id);

	/**
	* Removes the Warrant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the Warrant
	* @return the Warrant that was removed
	* @throws com.warrantchange.NoSuchWarrantException if a Warrant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.Warrant remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantException;

	public com.warrantchange.model.Warrant updateImpl(
		com.warrantchange.model.Warrant warrant, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Warrant with the primary key or throws a {@link com.warrantchange.NoSuchWarrantException} if it could not be found.
	*
	* @param id the primary key of the Warrant
	* @return the Warrant
	* @throws com.warrantchange.NoSuchWarrantException if a Warrant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.Warrant findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantException;

	/**
	* Returns the Warrant with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the Warrant
	* @return the Warrant, or <code>null</code> if a Warrant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.Warrant fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Warrant where status = &#63; or throws a {@link com.warrantchange.NoSuchWarrantException} if it could not be found.
	*
	* @param status the status
	* @return the matching Warrant
	* @throws com.warrantchange.NoSuchWarrantException if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.Warrant findByAll(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantException;

	/**
	* Returns the Warrant where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param status the status
	* @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.Warrant fetchByAll(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Warrant where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.Warrant fetchByAll(java.lang.String status,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Warrant where createDate = &#63; and status = &#63; and expirationWarningSent = &#63; or throws a {@link com.warrantchange.NoSuchWarrantException} if it could not be found.
	*
	* @param createDate the create date
	* @param status the status
	* @param expirationWarningSent the expiration warning sent
	* @return the matching Warrant
	* @throws com.warrantchange.NoSuchWarrantException if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.Warrant findByWarrantByAge(
		java.util.Date createDate, java.lang.String status,
		boolean expirationWarningSent)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantException;

	/**
	* Returns the Warrant where createDate = &#63; and status = &#63; and expirationWarningSent = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param createDate the create date
	* @param status the status
	* @param expirationWarningSent the expiration warning sent
	* @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.Warrant fetchByWarrantByAge(
		java.util.Date createDate, java.lang.String status,
		boolean expirationWarningSent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Warrant where createDate = &#63; and status = &#63; and expirationWarningSent = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param createDate the create date
	* @param status the status
	* @param expirationWarningSent the expiration warning sent
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.Warrant fetchByWarrantByAge(
		java.util.Date createDate, java.lang.String status,
		boolean expirationWarningSent, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Warrant where userId = &#63; or throws a {@link com.warrantchange.NoSuchWarrantException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching Warrant
	* @throws com.warrantchange.NoSuchWarrantException if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.Warrant findByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantException;

	/**
	* Returns the Warrant where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.Warrant fetchByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Warrant where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.warrantchange.model.Warrant fetchByUserId(long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Warrants.
	*
	* @return the Warrants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrantchange.model.Warrant> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Warrants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Warrants
	* @param end the upper bound of the range of Warrants (not inclusive)
	* @return the range of Warrants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrantchange.model.Warrant> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Warrants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Warrants
	* @param end the upper bound of the range of Warrants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Warrants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.warrantchange.model.Warrant> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the Warrant where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAll(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantException;

	/**
	* Removes the Warrant where createDate = &#63; and status = &#63; and expirationWarningSent = &#63; from the database.
	*
	* @param createDate the create date
	* @param status the status
	* @param expirationWarningSent the expiration warning sent
	* @throws SystemException if a system exception occurred
	*/
	public void removeByWarrantByAge(java.util.Date createDate,
		java.lang.String status, boolean expirationWarningSent)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantException;

	/**
	* Removes the Warrant where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantException;

	/**
	* Removes all the Warrants from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Warrants where status = &#63;.
	*
	* @param status the status
	* @return the number of matching Warrants
	* @throws SystemException if a system exception occurred
	*/
	public int countByAll(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Warrants where createDate = &#63; and status = &#63; and expirationWarningSent = &#63;.
	*
	* @param createDate the create date
	* @param status the status
	* @param expirationWarningSent the expiration warning sent
	* @return the number of matching Warrants
	* @throws SystemException if a system exception occurred
	*/
	public int countByWarrantByAge(java.util.Date createDate,
		java.lang.String status, boolean expirationWarningSent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Warrants where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching Warrants
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Warrants.
	*
	* @return the number of Warrants
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}