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

package com.organic.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.organic.model.Warrant;

import java.util.List;

/**
 * The persistence utility for the Warrant service. This utility wraps {@link WarrantPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author davidk
 * @see WarrantPersistence
 * @see WarrantPersistenceImpl
 * @generated
 */
public class WarrantUtil {
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
	public static void clearCache(Warrant warrant) {
		getPersistence().clearCache(warrant);
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
	public static List<Warrant> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Warrant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Warrant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Warrant update(Warrant warrant, boolean merge)
		throws SystemException {
		return getPersistence().update(warrant, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Warrant update(Warrant warrant, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(warrant, merge, serviceContext);
	}

	/**
	* Caches the Warrant in the entity cache if it is enabled.
	*
	* @param warrant the Warrant
	*/
	public static void cacheResult(com.organic.model.Warrant warrant) {
		getPersistence().cacheResult(warrant);
	}

	/**
	* Caches the Warrants in the entity cache if it is enabled.
	*
	* @param warrants the Warrants
	*/
	public static void cacheResult(
		java.util.List<com.organic.model.Warrant> warrants) {
		getPersistence().cacheResult(warrants);
	}

	/**
	* Creates a new Warrant with the primary key. Does not add the Warrant to the database.
	*
	* @param id the primary key for the new Warrant
	* @return the new Warrant
	*/
	public static com.organic.model.Warrant create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the Warrant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the Warrant
	* @return the Warrant that was removed
	* @throws com.organic.NoSuchWarrantException if a Warrant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.organic.model.Warrant remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.organic.NoSuchWarrantException {
		return getPersistence().remove(id);
	}

	public static com.organic.model.Warrant updateImpl(
		com.organic.model.Warrant warrant, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(warrant, merge);
	}

	/**
	* Returns the Warrant with the primary key or throws a {@link com.organic.NoSuchWarrantException} if it could not be found.
	*
	* @param id the primary key of the Warrant
	* @return the Warrant
	* @throws com.organic.NoSuchWarrantException if a Warrant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.organic.model.Warrant findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.organic.NoSuchWarrantException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the Warrant with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the Warrant
	* @return the Warrant, or <code>null</code> if a Warrant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.organic.model.Warrant fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the Warrant where status = &#63; or throws a {@link com.organic.NoSuchWarrantException} if it could not be found.
	*
	* @param status the status
	* @return the matching Warrant
	* @throws com.organic.NoSuchWarrantException if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.organic.model.Warrant findByAll(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.organic.NoSuchWarrantException {
		return getPersistence().findByAll(status);
	}

	/**
	* Returns the Warrant where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param status the status
	* @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.organic.model.Warrant fetchByAll(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAll(status);
	}

	/**
	* Returns the Warrant where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.organic.model.Warrant fetchByAll(
		java.lang.String status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAll(status, retrieveFromCache);
	}

	/**
	* Returns the Warrant where createDate = &#63; or throws a {@link com.organic.NoSuchWarrantException} if it could not be found.
	*
	* @param createDate the create date
	* @return the matching Warrant
	* @throws com.organic.NoSuchWarrantException if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.organic.model.Warrant findByWarrantByAge(
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.organic.NoSuchWarrantException {
		return getPersistence().findByWarrantByAge(createDate);
	}

	/**
	* Returns the Warrant where createDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param createDate the create date
	* @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.organic.model.Warrant fetchByWarrantByAge(
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWarrantByAge(createDate);
	}

	/**
	* Returns the Warrant where createDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param createDate the create date
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.organic.model.Warrant fetchByWarrantByAge(
		java.util.Date createDate, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWarrantByAge(createDate, retrieveFromCache);
	}

	/**
	* Returns all the Warrants.
	*
	* @return the Warrants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.organic.model.Warrant> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.organic.model.Warrant> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.organic.model.Warrant> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the Warrant where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAll(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.organic.NoSuchWarrantException {
		getPersistence().removeByAll(status);
	}

	/**
	* Removes the Warrant where createDate = &#63; from the database.
	*
	* @param createDate the create date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByWarrantByAge(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.organic.NoSuchWarrantException {
		getPersistence().removeByWarrantByAge(createDate);
	}

	/**
	* Removes all the Warrants from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Warrants where status = &#63;.
	*
	* @param status the status
	* @return the number of matching Warrants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAll(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAll(status);
	}

	/**
	* Returns the number of Warrants where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the number of matching Warrants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWarrantByAge(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWarrantByAge(createDate);
	}

	/**
	* Returns the number of Warrants.
	*
	* @return the number of Warrants
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WarrantPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WarrantPersistence)PortletBeanLocatorUtil.locate(com.organic.service.ClpSerializer.getServletContextName(),
					WarrantPersistence.class.getName());

			ReferenceRegistry.registerReference(WarrantUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(WarrantPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(WarrantUtil.class, "_persistence");
	}

	private static WarrantPersistence _persistence;
}