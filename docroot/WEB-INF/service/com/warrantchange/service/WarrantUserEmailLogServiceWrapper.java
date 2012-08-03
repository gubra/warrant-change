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
 * This class is a wrapper for {@link WarrantUserEmailLogService}.
 * </p>
 *
 * @author    davidk
 * @see       WarrantUserEmailLogService
 * @generated
 */
public class WarrantUserEmailLogServiceWrapper
	implements WarrantUserEmailLogService,
		ServiceWrapper<WarrantUserEmailLogService> {
	public WarrantUserEmailLogServiceWrapper(
		WarrantUserEmailLogService warrantUserEmailLogService) {
		_warrantUserEmailLogService = warrantUserEmailLogService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WarrantUserEmailLogService getWrappedWarrantUserEmailLogService() {
		return _warrantUserEmailLogService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWarrantUserEmailLogService(
		WarrantUserEmailLogService warrantUserEmailLogService) {
		_warrantUserEmailLogService = warrantUserEmailLogService;
	}

	public WarrantUserEmailLogService getWrappedService() {
		return _warrantUserEmailLogService;
	}

	public void setWrappedService(
		WarrantUserEmailLogService warrantUserEmailLogService) {
		_warrantUserEmailLogService = warrantUserEmailLogService;
	}

	private WarrantUserEmailLogService _warrantUserEmailLogService;
}