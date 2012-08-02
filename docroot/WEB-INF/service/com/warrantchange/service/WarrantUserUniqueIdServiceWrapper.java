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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link WarrantUserUniqueIdService}.
 * </p>
 *
 * @author    davidk
 * @see       WarrantUserUniqueIdService
 * @generated
 */
public class WarrantUserUniqueIdServiceWrapper
	implements WarrantUserUniqueIdService,
		ServiceWrapper<WarrantUserUniqueIdService> {
	public WarrantUserUniqueIdServiceWrapper(
		WarrantUserUniqueIdService warrantUserUniqueIdService) {
		_warrantUserUniqueIdService = warrantUserUniqueIdService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WarrantUserUniqueIdService getWrappedWarrantUserUniqueIdService() {
		return _warrantUserUniqueIdService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWarrantUserUniqueIdService(
		WarrantUserUniqueIdService warrantUserUniqueIdService) {
		_warrantUserUniqueIdService = warrantUserUniqueIdService;
	}

	public WarrantUserUniqueIdService getWrappedService() {
		return _warrantUserUniqueIdService;
	}

	public void setWrappedService(
		WarrantUserUniqueIdService warrantUserUniqueIdService) {
		_warrantUserUniqueIdService = warrantUserUniqueIdService;
	}

	private WarrantUserUniqueIdService _warrantUserUniqueIdService;
}