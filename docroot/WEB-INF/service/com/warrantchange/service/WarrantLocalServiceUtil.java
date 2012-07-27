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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the Warrant local service. This utility wraps {@link com.warrantchange.service.impl.WarrantLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author davidk
 * @see WarrantLocalService
 * @see com.warrantchange.service.base.WarrantLocalServiceBaseImpl
 * @see com.warrantchange.service.impl.WarrantLocalServiceImpl
 * @generated
 */
public class WarrantLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.warrantchange.service.impl.WarrantLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the Warrant to the database. Also notifies the appropriate model listeners.
	*
	* @param warrant the Warrant
	* @return the Warrant that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.Warrant addWarrant(
		com.warrantchange.model.Warrant warrant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWarrant(warrant);
	}

	/**
	* Creates a new Warrant with the primary key. Does not add the Warrant to the database.
	*
	* @param id the primary key for the new Warrant
	* @return the new Warrant
	*/
	public static com.warrantchange.model.Warrant createWarrant(long id) {
		return getService().createWarrant(id);
	}

	/**
	* Deletes the Warrant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the Warrant
	* @throws PortalException if a Warrant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws com.warrantchange.NoSuchWarrantException
	*/
	public static void deleteWarrant(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantException {
		getService().deleteWarrant(id);
	}

	/**
	* Deletes the Warrant from the database. Also notifies the appropriate model listeners.
	*
	* @param warrant the Warrant
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWarrant(com.warrantchange.model.Warrant warrant)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWarrant(warrant);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.warrantchange.model.Warrant fetchWarrant(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWarrant(id);
	}

	/**
	* Returns the Warrant with the primary key.
	*
	* @param id the primary key of the Warrant
	* @return the Warrant
	* @throws PortalException if a Warrant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.Warrant getWarrant(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWarrant(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.warrantchange.model.Warrant> getWarrants(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWarrants(start, end);
	}

	/**
	* Returns the number of Warrants.
	*
	* @return the number of Warrants
	* @throws SystemException if a system exception occurred
	*/
	public static int getWarrantsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWarrantsCount();
	}

	/**
	* Updates the Warrant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param warrant the Warrant
	* @return the Warrant that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.Warrant updateWarrant(
		com.warrantchange.model.Warrant warrant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWarrant(warrant);
	}

	/**
	* Updates the Warrant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param warrant the Warrant
	* @param merge whether to merge the Warrant with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the Warrant that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.Warrant updateWarrant(
		com.warrantchange.model.Warrant warrant, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWarrant(warrant, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static com.warrantchange.model.Warrant addWarrant(long userId,
		java.lang.String summary, int quantity, long price)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWarrant(userId, summary, quantity, price);
	}

	public static void updateWarrant(long id, java.lang.String summary,
		int quantity, long price)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.warrantchange.NoSuchWarrantException {
		getService().updateWarrant(id, summary, quantity, price);
	}

	public static java.util.List<com.warrantchange.model.Warrant> findWarrants(
		int start, int count)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findWarrants(start, count);
	}

	public static java.util.List<com.warrantchange.model.Warrant> findWarrants() {
		return getService().findWarrants();
	}

	public static java.util.List<com.warrantchange.model.Warrant> findWarrantsByCreateDate(
		java.util.Date from, java.util.Date to)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findWarrantsByCreateDate(from, to);
	}

	public static void clearService() {
		_service = null;
	}

	public static WarrantLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WarrantLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					WarrantLocalService.class.getName(), portletClassLoader);

			_service = new WarrantLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(WarrantLocalServiceUtil.class,
				"_service");
			MethodCache.remove(WarrantLocalService.class);
		}

		return _service;
	}

	public void setService(WarrantLocalService service) {
		MethodCache.remove(WarrantLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(WarrantLocalServiceUtil.class,
			"_service");
		MethodCache.remove(WarrantLocalService.class);
	}

	private static WarrantLocalService _service;
}