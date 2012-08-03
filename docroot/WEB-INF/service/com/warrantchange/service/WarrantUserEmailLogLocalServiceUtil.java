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
 * The utility for the WarrantUserEmailLog local service. This utility wraps {@link com.warrantchange.service.impl.WarrantUserEmailLogLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author davidk
 * @see WarrantUserEmailLogLocalService
 * @see com.warrantchange.service.base.WarrantUserEmailLogLocalServiceBaseImpl
 * @see com.warrantchange.service.impl.WarrantUserEmailLogLocalServiceImpl
 * @generated
 */
public class WarrantUserEmailLogLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.warrantchange.service.impl.WarrantUserEmailLogLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the WarrantUserEmailLog to the database. Also notifies the appropriate model listeners.
	*
	* @param warrantUserEmailLog the WarrantUserEmailLog
	* @return the WarrantUserEmailLog that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserEmailLog addWarrantUserEmailLog(
		com.warrantchange.model.WarrantUserEmailLog warrantUserEmailLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWarrantUserEmailLog(warrantUserEmailLog);
	}

	/**
	* Creates a new WarrantUserEmailLog with the primary key. Does not add the WarrantUserEmailLog to the database.
	*
	* @param id the primary key for the new WarrantUserEmailLog
	* @return the new WarrantUserEmailLog
	*/
	public static com.warrantchange.model.WarrantUserEmailLog createWarrantUserEmailLog(
		long id) {
		return getService().createWarrantUserEmailLog(id);
	}

	/**
	* Deletes the WarrantUserEmailLog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the WarrantUserEmailLog
	* @throws PortalException if a WarrantUserEmailLog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWarrantUserEmailLog(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWarrantUserEmailLog(id);
	}

	/**
	* Deletes the WarrantUserEmailLog from the database. Also notifies the appropriate model listeners.
	*
	* @param warrantUserEmailLog the WarrantUserEmailLog
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWarrantUserEmailLog(
		com.warrantchange.model.WarrantUserEmailLog warrantUserEmailLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWarrantUserEmailLog(warrantUserEmailLog);
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

	public static com.warrantchange.model.WarrantUserEmailLog fetchWarrantUserEmailLog(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWarrantUserEmailLog(id);
	}

	/**
	* Returns the WarrantUserEmailLog with the primary key.
	*
	* @param id the primary key of the WarrantUserEmailLog
	* @return the WarrantUserEmailLog
	* @throws PortalException if a WarrantUserEmailLog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserEmailLog getWarrantUserEmailLog(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWarrantUserEmailLog(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<com.warrantchange.model.WarrantUserEmailLog> getWarrantUserEmailLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWarrantUserEmailLogs(start, end);
	}

	/**
	* Returns the number of WarrantUserEmailLogs.
	*
	* @return the number of WarrantUserEmailLogs
	* @throws SystemException if a system exception occurred
	*/
	public static int getWarrantUserEmailLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWarrantUserEmailLogsCount();
	}

	/**
	* Updates the WarrantUserEmailLog in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param warrantUserEmailLog the WarrantUserEmailLog
	* @return the WarrantUserEmailLog that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserEmailLog updateWarrantUserEmailLog(
		com.warrantchange.model.WarrantUserEmailLog warrantUserEmailLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWarrantUserEmailLog(warrantUserEmailLog);
	}

	/**
	* Updates the WarrantUserEmailLog in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param warrantUserEmailLog the WarrantUserEmailLog
	* @param merge whether to merge the WarrantUserEmailLog with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the WarrantUserEmailLog that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.warrantchange.model.WarrantUserEmailLog updateWarrantUserEmailLog(
		com.warrantchange.model.WarrantUserEmailLog warrantUserEmailLog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWarrantUserEmailLog(warrantUserEmailLog, merge);
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

	public static void clearService() {
		_service = null;
	}

	public static WarrantUserEmailLogLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WarrantUserEmailLogLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					WarrantUserEmailLogLocalService.class.getName(),
					portletClassLoader);

			_service = new WarrantUserEmailLogLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(WarrantUserEmailLogLocalServiceUtil.class,
				"_service");
			MethodCache.remove(WarrantUserEmailLogLocalService.class);
		}

		return _service;
	}

	public void setService(WarrantUserEmailLogLocalService service) {
		MethodCache.remove(WarrantUserEmailLogLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(WarrantUserEmailLogLocalServiceUtil.class,
			"_service");
		MethodCache.remove(WarrantUserEmailLogLocalService.class);
	}

	private static WarrantUserEmailLogLocalService _service;
}