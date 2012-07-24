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

package com.organic.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link WarrantService}.
 * </p>
 *
 * @author    davidk
 * @see       WarrantService
 * @generated
 */
public class WarrantServiceWrapper implements WarrantService,
	ServiceWrapper<WarrantService> {
	public WarrantServiceWrapper(WarrantService warrantService) {
		_warrantService = warrantService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WarrantService getWrappedWarrantService() {
		return _warrantService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWarrantService(WarrantService warrantService) {
		_warrantService = warrantService;
	}

	public WarrantService getWrappedService() {
		return _warrantService;
	}

	public void setWrappedService(WarrantService warrantService) {
		_warrantService = warrantService;
	}

	private WarrantService _warrantService;
}