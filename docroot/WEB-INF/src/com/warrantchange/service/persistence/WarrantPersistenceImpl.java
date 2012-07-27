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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.warrantchange.NoSuchWarrantException;

import com.warrantchange.model.Warrant;
import com.warrantchange.model.impl.WarrantImpl;
import com.warrantchange.model.impl.WarrantModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the Warrant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author davidk
 * @see WarrantPersistence
 * @see WarrantUtil
 * @generated
 */
public class WarrantPersistenceImpl extends BasePersistenceImpl<Warrant>
	implements WarrantPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WarrantUtil} to access the Warrant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WarrantImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_ALL = new FinderPath(WarrantModelImpl.ENTITY_CACHE_ENABLED,
			WarrantModelImpl.FINDER_CACHE_ENABLED, WarrantImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByAll",
			new String[] { String.class.getName() },
			WarrantModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALL = new FinderPath(WarrantModelImpl.ENTITY_CACHE_ENABLED,
			WarrantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAll",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_WARRANTBYAGE = new FinderPath(WarrantModelImpl.ENTITY_CACHE_ENABLED,
			WarrantModelImpl.FINDER_CACHE_ENABLED, WarrantImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByWarrantByAge",
			new String[] { Date.class.getName() },
			WarrantModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WARRANTBYAGE = new FinderPath(WarrantModelImpl.ENTITY_CACHE_ENABLED,
			WarrantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWarrantByAge",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WarrantModelImpl.ENTITY_CACHE_ENABLED,
			WarrantModelImpl.FINDER_CACHE_ENABLED, WarrantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WarrantModelImpl.ENTITY_CACHE_ENABLED,
			WarrantModelImpl.FINDER_CACHE_ENABLED, WarrantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WarrantModelImpl.ENTITY_CACHE_ENABLED,
			WarrantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the Warrant in the entity cache if it is enabled.
	 *
	 * @param warrant the Warrant
	 */
	public void cacheResult(Warrant warrant) {
		EntityCacheUtil.putResult(WarrantModelImpl.ENTITY_CACHE_ENABLED,
			WarrantImpl.class, warrant.getPrimaryKey(), warrant);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ALL,
			new Object[] { warrant.getStatus() }, warrant);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WARRANTBYAGE,
			new Object[] { warrant.getCreateDate() }, warrant);

		warrant.resetOriginalValues();
	}

	/**
	 * Caches the Warrants in the entity cache if it is enabled.
	 *
	 * @param warrants the Warrants
	 */
	public void cacheResult(List<Warrant> warrants) {
		for (Warrant warrant : warrants) {
			if (EntityCacheUtil.getResult(
						WarrantModelImpl.ENTITY_CACHE_ENABLED,
						WarrantImpl.class, warrant.getPrimaryKey()) == null) {
				cacheResult(warrant);
			}
			else {
				warrant.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Warrants.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WarrantImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WarrantImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Warrant.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Warrant warrant) {
		EntityCacheUtil.removeResult(WarrantModelImpl.ENTITY_CACHE_ENABLED,
			WarrantImpl.class, warrant.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(warrant);
	}

	@Override
	public void clearCache(List<Warrant> warrants) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Warrant warrant : warrants) {
			EntityCacheUtil.removeResult(WarrantModelImpl.ENTITY_CACHE_ENABLED,
				WarrantImpl.class, warrant.getPrimaryKey());

			clearUniqueFindersCache(warrant);
		}
	}

	protected void clearUniqueFindersCache(Warrant warrant) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ALL,
			new Object[] { warrant.getStatus() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WARRANTBYAGE,
			new Object[] { warrant.getCreateDate() });
	}

	/**
	 * Creates a new Warrant with the primary key. Does not add the Warrant to the database.
	 *
	 * @param id the primary key for the new Warrant
	 * @return the new Warrant
	 */
	public Warrant create(long id) {
		Warrant warrant = new WarrantImpl();

		warrant.setNew(true);
		warrant.setPrimaryKey(id);

		return warrant;
	}

	/**
	 * Removes the Warrant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the Warrant
	 * @return the Warrant that was removed
	 * @throws com.warrantchange.NoSuchWarrantException if a Warrant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Warrant remove(long id)
		throws NoSuchWarrantException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the Warrant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Warrant
	 * @return the Warrant that was removed
	 * @throws com.warrantchange.NoSuchWarrantException if a Warrant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Warrant remove(Serializable primaryKey)
		throws NoSuchWarrantException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Warrant warrant = (Warrant)session.get(WarrantImpl.class, primaryKey);

			if (warrant == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWarrantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(warrant);
		}
		catch (NoSuchWarrantException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Warrant removeImpl(Warrant warrant) throws SystemException {
		warrant = toUnwrappedModel(warrant);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, warrant);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(warrant);

		return warrant;
	}

	@Override
	public Warrant updateImpl(com.warrantchange.model.Warrant warrant,
		boolean merge) throws SystemException {
		warrant = toUnwrappedModel(warrant);

		boolean isNew = warrant.isNew();

		WarrantModelImpl warrantModelImpl = (WarrantModelImpl)warrant;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, warrant, merge);

			warrant.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WarrantModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(WarrantModelImpl.ENTITY_CACHE_ENABLED,
			WarrantImpl.class, warrant.getPrimaryKey(), warrant);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ALL,
				new Object[] { warrant.getStatus() }, warrant);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WARRANTBYAGE,
				new Object[] { warrant.getCreateDate() }, warrant);
		}
		else {
			if ((warrantModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ALL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						warrantModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ALL, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ALL,
					new Object[] { warrant.getStatus() }, warrant);
			}

			if ((warrantModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_WARRANTBYAGE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						warrantModelImpl.getOriginalCreateDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WARRANTBYAGE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WARRANTBYAGE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WARRANTBYAGE,
					new Object[] { warrant.getCreateDate() }, warrant);
			}
		}

		return warrant;
	}

	protected Warrant toUnwrappedModel(Warrant warrant) {
		if (warrant instanceof WarrantImpl) {
			return warrant;
		}

		WarrantImpl warrantImpl = new WarrantImpl();

		warrantImpl.setNew(warrant.isNew());
		warrantImpl.setPrimaryKey(warrant.getPrimaryKey());

		warrantImpl.setId(warrant.getId());
		warrantImpl.setUserId(warrant.getUserId());
		warrantImpl.setSummary(warrant.getSummary());
		warrantImpl.setQuantity(warrant.getQuantity());
		warrantImpl.setPrice(warrant.getPrice());
		warrantImpl.setStatus(warrant.getStatus());
		warrantImpl.setCreateDate(warrant.getCreateDate());
		warrantImpl.setModifiedDate(warrant.getModifiedDate());
		warrantImpl.setExpirationWarningSent(warrant.isExpirationWarningSent());

		return warrantImpl;
	}

	/**
	 * Returns the Warrant with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Warrant
	 * @return the Warrant
	 * @throws com.liferay.portal.NoSuchModelException if a Warrant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Warrant findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Warrant with the primary key or throws a {@link com.warrantchange.NoSuchWarrantException} if it could not be found.
	 *
	 * @param id the primary key of the Warrant
	 * @return the Warrant
	 * @throws com.warrantchange.NoSuchWarrantException if a Warrant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Warrant findByPrimaryKey(long id)
		throws NoSuchWarrantException, SystemException {
		Warrant warrant = fetchByPrimaryKey(id);

		if (warrant == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchWarrantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return warrant;
	}

	/**
	 * Returns the Warrant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Warrant
	 * @return the Warrant, or <code>null</code> if a Warrant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Warrant fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Warrant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the Warrant
	 * @return the Warrant, or <code>null</code> if a Warrant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Warrant fetchByPrimaryKey(long id) throws SystemException {
		Warrant warrant = (Warrant)EntityCacheUtil.getResult(WarrantModelImpl.ENTITY_CACHE_ENABLED,
				WarrantImpl.class, id);

		if (warrant == _nullWarrant) {
			return null;
		}

		if (warrant == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				warrant = (Warrant)session.get(WarrantImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (warrant != null) {
					cacheResult(warrant);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WarrantModelImpl.ENTITY_CACHE_ENABLED,
						WarrantImpl.class, id, _nullWarrant);
				}

				closeSession(session);
			}
		}

		return warrant;
	}

	/**
	 * Returns the Warrant where status = &#63; or throws a {@link com.warrantchange.NoSuchWarrantException} if it could not be found.
	 *
	 * @param status the status
	 * @return the matching Warrant
	 * @throws com.warrantchange.NoSuchWarrantException if a matching Warrant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Warrant findByAll(String status)
		throws NoSuchWarrantException, SystemException {
		Warrant warrant = fetchByAll(status);

		if (warrant == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWarrantException(msg.toString());
		}

		return warrant;
	}

	/**
	 * Returns the Warrant where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Warrant fetchByAll(String status) throws SystemException {
		return fetchByAll(status, true);
	}

	/**
	 * Returns the Warrant where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Warrant fetchByAll(String status, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ALL,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WARRANT_WHERE);

			if (status == null) {
				query.append(_FINDER_COLUMN_ALL_STATUS_1);
			}
			else {
				if (status.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ALL_STATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_ALL_STATUS_2);
				}
			}

			query.append(WarrantModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (status != null) {
					qPos.add(status);
				}

				List<Warrant> list = q.list();

				result = list;

				Warrant warrant = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ALL,
						finderArgs, list);
				}
				else {
					warrant = list.get(0);

					cacheResult(warrant);

					if ((warrant.getStatus() == null) ||
							!warrant.getStatus().equals(status)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ALL,
							finderArgs, warrant);
					}
				}

				return warrant;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ALL,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Warrant)result;
			}
		}
	}

	/**
	 * Returns the Warrant where createDate = &#63; or throws a {@link com.warrantchange.NoSuchWarrantException} if it could not be found.
	 *
	 * @param createDate the create date
	 * @return the matching Warrant
	 * @throws com.warrantchange.NoSuchWarrantException if a matching Warrant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Warrant findByWarrantByAge(Date createDate)
		throws NoSuchWarrantException, SystemException {
		Warrant warrant = fetchByWarrantByAge(createDate);

		if (warrant == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("createDate=");
			msg.append(createDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWarrantException(msg.toString());
		}

		return warrant;
	}

	/**
	 * Returns the Warrant where createDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param createDate the create date
	 * @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Warrant fetchByWarrantByAge(Date createDate)
		throws SystemException {
		return fetchByWarrantByAge(createDate, true);
	}

	/**
	 * Returns the Warrant where createDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param createDate the create date
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching Warrant, or <code>null</code> if a matching Warrant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Warrant fetchByWarrantByAge(Date createDate,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { createDate };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_WARRANTBYAGE,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WARRANT_WHERE);

			if (createDate == null) {
				query.append(_FINDER_COLUMN_WARRANTBYAGE_CREATEDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_WARRANTBYAGE_CREATEDATE_2);
			}

			query.append(WarrantModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (createDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				List<Warrant> list = q.list();

				result = list;

				Warrant warrant = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WARRANTBYAGE,
						finderArgs, list);
				}
				else {
					warrant = list.get(0);

					cacheResult(warrant);

					if ((warrant.getCreateDate() == null) ||
							!warrant.getCreateDate().equals(createDate)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WARRANTBYAGE,
							finderArgs, warrant);
					}
				}

				return warrant;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WARRANTBYAGE,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Warrant)result;
			}
		}
	}

	/**
	 * Returns all the Warrants.
	 *
	 * @return the Warrants
	 * @throws SystemException if a system exception occurred
	 */
	public List<Warrant> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Warrant> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Warrant> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Warrant> list = (List<Warrant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WARRANT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WARRANT.concat(WarrantModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Warrant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Warrant>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes the Warrant where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAll(String status)
		throws NoSuchWarrantException, SystemException {
		Warrant warrant = findByAll(status);

		remove(warrant);
	}

	/**
	 * Removes the Warrant where createDate = &#63; from the database.
	 *
	 * @param createDate the create date
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByWarrantByAge(Date createDate)
		throws NoSuchWarrantException, SystemException {
		Warrant warrant = findByWarrantByAge(createDate);

		remove(warrant);
	}

	/**
	 * Removes all the Warrants from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Warrant warrant : findAll()) {
			remove(warrant);
		}
	}

	/**
	 * Returns the number of Warrants where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching Warrants
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAll(String status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ALL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WARRANT_WHERE);

			if (status == null) {
				query.append(_FINDER_COLUMN_ALL_STATUS_1);
			}
			else {
				if (status.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ALL_STATUS_3);
				}
				else {
					query.append(_FINDER_COLUMN_ALL_STATUS_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (status != null) {
					qPos.add(status);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of Warrants where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the number of matching Warrants
	 * @throws SystemException if a system exception occurred
	 */
	public int countByWarrantByAge(Date createDate) throws SystemException {
		Object[] finderArgs = new Object[] { createDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WARRANTBYAGE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WARRANT_WHERE);

			if (createDate == null) {
				query.append(_FINDER_COLUMN_WARRANTBYAGE_CREATEDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_WARRANTBYAGE_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (createDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WARRANTBYAGE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of Warrants.
	 *
	 * @return the number of Warrants
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WARRANT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the Warrant persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.warrantchange.model.Warrant")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Warrant>> listenersList = new ArrayList<ModelListener<Warrant>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Warrant>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(WarrantImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = WarrantPersistence.class)
	protected WarrantPersistence warrantPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_WARRANT = "SELECT warrant FROM Warrant warrant";
	private static final String _SQL_SELECT_WARRANT_WHERE = "SELECT warrant FROM Warrant warrant WHERE ";
	private static final String _SQL_COUNT_WARRANT = "SELECT COUNT(warrant) FROM Warrant warrant";
	private static final String _SQL_COUNT_WARRANT_WHERE = "SELECT COUNT(warrant) FROM Warrant warrant WHERE ";
	private static final String _FINDER_COLUMN_ALL_STATUS_1 = "warrant.status IS NULL AND warrant.status='CREATED'";
	private static final String _FINDER_COLUMN_ALL_STATUS_2 = "warrant.status = ? AND warrant.status='CREATED'";
	private static final String _FINDER_COLUMN_ALL_STATUS_3 = "(warrant.status IS NULL OR warrant.status = ?) AND warrant.status='CREATED'";
	private static final String _FINDER_COLUMN_WARRANTBYAGE_CREATEDATE_1 = "warrant.createDate IS NULL AND warrant.status='CREATED'";
	private static final String _FINDER_COLUMN_WARRANTBYAGE_CREATEDATE_2 = "warrant.createDate = ? AND warrant.status='CREATED'";
	private static final String _ORDER_BY_ENTITY_ALIAS = "warrant.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Warrant exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Warrant exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WarrantPersistenceImpl.class);
	private static Warrant _nullWarrant = new WarrantImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Warrant> toCacheModel() {
				return _nullWarrantCacheModel;
			}
		};

	private static CacheModel<Warrant> _nullWarrantCacheModel = new CacheModel<Warrant>() {
			public Warrant toEntityModel() {
				return _nullWarrant;
			}
		};
}