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
 * The utility for the WarrantUserEmailLog remote service. This utility wraps {@link com.warrantchange.service.impl.WarrantUserEmailLogServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author davidk
 * @see WarrantUserEmailLogService
 * @see com.warrantchange.service.base.WarrantUserEmailLogServiceBaseImpl
 * @see com.warrantchange.service.impl.WarrantUserEmailLogServiceImpl
 * @generated
 */
public class WarrantUserEmailLogServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.warrantchange.service.impl.WarrantUserEmailLogServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void clearService() {
		_service = null;
	}

	public static WarrantUserEmailLogService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WarrantUserEmailLogService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					WarrantUserEmailLogService.class.getName(),
					portletClassLoader);

			_service = new WarrantUserEmailLogServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(WarrantUserEmailLogServiceUtil.class,
				"_service");
			MethodCache.remove(WarrantUserEmailLogService.class);
		}

		return _service;
	}

	public void setService(WarrantUserEmailLogService service) {
		MethodCache.remove(WarrantUserEmailLogService.class);

		_service = service;

		ReferenceRegistry.registerReference(WarrantUserEmailLogServiceUtil.class,
			"_service");
		MethodCache.remove(WarrantUserEmailLogService.class);
	}

	private static WarrantUserEmailLogService _service;
}