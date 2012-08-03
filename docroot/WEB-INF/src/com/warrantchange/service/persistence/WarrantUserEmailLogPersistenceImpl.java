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

import com.warrantchange.NoSuchWarrantUserEmailLogException;

import com.warrantchange.model.WarrantUserEmailLog;
import com.warrantchange.model.impl.WarrantUserEmailLogImpl;
import com.warrantchange.model.impl.WarrantUserEmailLogModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the WarrantUserEmailLog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author davidk
 * @see WarrantUserEmailLogPersistence
 * @see WarrantUserEmailLogUtil
 * @generated
 */
public class WarrantUserEmailLogPersistenceImpl extends BasePersistenceImpl<WarrantUserEmailLog>
	implements WarrantUserEmailLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WarrantUserEmailLogUtil} to access the WarrantUserEmailLog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WarrantUserEmailLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(WarrantUserEmailLogModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserEmailLogModelImpl.FINDER_CACHE_ENABLED,
			WarrantUserEmailLogImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByuserId", new String[] { Long.class.getName() },
			WarrantUserEmailLogModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(WarrantUserEmailLogModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserEmailLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WarrantUserEmailLogModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserEmailLogModelImpl.FINDER_CACHE_ENABLED,
			WarrantUserEmailLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WarrantUserEmailLogModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserEmailLogModelImpl.FINDER_CACHE_ENABLED,
			WarrantUserEmailLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WarrantUserEmailLogModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserEmailLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the WarrantUserEmailLog in the entity cache if it is enabled.
	 *
	 * @param warrantUserEmailLog the WarrantUserEmailLog
	 */
	public void cacheResult(WarrantUserEmailLog warrantUserEmailLog) {
		EntityCacheUtil.putResult(WarrantUserEmailLogModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserEmailLogImpl.class, warrantUserEmailLog.getPrimaryKey(),
			warrantUserEmailLog);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(warrantUserEmailLog.getUserId()) },
			warrantUserEmailLog);

		warrantUserEmailLog.resetOriginalValues();
	}

	/**
	 * Caches the WarrantUserEmailLogs in the entity cache if it is enabled.
	 *
	 * @param warrantUserEmailLogs the WarrantUserEmailLogs
	 */
	public void cacheResult(List<WarrantUserEmailLog> warrantUserEmailLogs) {
		for (WarrantUserEmailLog warrantUserEmailLog : warrantUserEmailLogs) {
			if (EntityCacheUtil.getResult(
						WarrantUserEmailLogModelImpl.ENTITY_CACHE_ENABLED,
						WarrantUserEmailLogImpl.class,
						warrantUserEmailLog.getPrimaryKey()) == null) {
				cacheResult(warrantUserEmailLog);
			}
			else {
				warrantUserEmailLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WarrantUserEmailLogs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WarrantUserEmailLogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WarrantUserEmailLogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WarrantUserEmailLog.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WarrantUserEmailLog warrantUserEmailLog) {
		EntityCacheUtil.removeResult(WarrantUserEmailLogModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserEmailLogImpl.class, warrantUserEmailLog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(warrantUserEmailLog);
	}

	@Override
	public void clearCache(List<WarrantUserEmailLog> warrantUserEmailLogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WarrantUserEmailLog warrantUserEmailLog : warrantUserEmailLogs) {
			EntityCacheUtil.removeResult(WarrantUserEmailLogModelImpl.ENTITY_CACHE_ENABLED,
				WarrantUserEmailLogImpl.class,
				warrantUserEmailLog.getPrimaryKey());

			clearUniqueFindersCache(warrantUserEmailLog);
		}
	}

	protected void clearUniqueFindersCache(
		WarrantUserEmailLog warrantUserEmailLog) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(warrantUserEmailLog.getUserId()) });
	}

	/**
	 * Creates a new WarrantUserEmailLog with the primary key. Does not add the WarrantUserEmailLog to the database.
	 *
	 * @param id the primary key for the new WarrantUserEmailLog
	 * @return the new WarrantUserEmailLog
	 */
	public WarrantUserEmailLog create(long id) {
		WarrantUserEmailLog warrantUserEmailLog = new WarrantUserEmailLogImpl();

		warrantUserEmailLog.setNew(true);
		warrantUserEmailLog.setPrimaryKey(id);

		return warrantUserEmailLog;
	}

	/**
	 * Removes the WarrantUserEmailLog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the WarrantUserEmailLog
	 * @return the WarrantUserEmailLog that was removed
	 * @throws com.warrantchange.NoSuchWarrantUserEmailLogException if a WarrantUserEmailLog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserEmailLog remove(long id)
		throws NoSuchWarrantUserEmailLogException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the WarrantUserEmailLog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WarrantUserEmailLog
	 * @return the WarrantUserEmailLog that was removed
	 * @throws com.warrantchange.NoSuchWarrantUserEmailLogException if a WarrantUserEmailLog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WarrantUserEmailLog remove(Serializable primaryKey)
		throws NoSuchWarrantUserEmailLogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WarrantUserEmailLog warrantUserEmailLog = (WarrantUserEmailLog)session.get(WarrantUserEmailLogImpl.class,
					primaryKey);

			if (warrantUserEmailLog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWarrantUserEmailLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(warrantUserEmailLog);
		}
		catch (NoSuchWarrantUserEmailLogException nsee) {
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
	protected WarrantUserEmailLog removeImpl(
		WarrantUserEmailLog warrantUserEmailLog) throws SystemException {
		warrantUserEmailLog = toUnwrappedModel(warrantUserEmailLog);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, warrantUserEmailLog);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(warrantUserEmailLog);

		return warrantUserEmailLog;
	}

	@Override
	public WarrantUserEmailLog updateImpl(
		com.warrantchange.model.WarrantUserEmailLog warrantUserEmailLog,
		boolean merge) throws SystemException {
		warrantUserEmailLog = toUnwrappedModel(warrantUserEmailLog);

		boolean isNew = warrantUserEmailLog.isNew();

		WarrantUserEmailLogModelImpl warrantUserEmailLogModelImpl = (WarrantUserEmailLogModelImpl)warrantUserEmailLog;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, warrantUserEmailLog, merge);

			warrantUserEmailLog.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WarrantUserEmailLogModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(WarrantUserEmailLogModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserEmailLogImpl.class, warrantUserEmailLog.getPrimaryKey(),
			warrantUserEmailLog);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
				new Object[] { Long.valueOf(warrantUserEmailLog.getUserId()) },
				warrantUserEmailLog);
		}
		else {
			if ((warrantUserEmailLogModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(warrantUserEmailLogModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
					new Object[] { Long.valueOf(warrantUserEmailLog.getUserId()) },
					warrantUserEmailLog);
			}
		}

		return warrantUserEmailLog;
	}

	protected WarrantUserEmailLog toUnwrappedModel(
		WarrantUserEmailLog warrantUserEmailLog) {
		if (warrantUserEmailLog instanceof WarrantUserEmailLogImpl) {
			return warrantUserEmailLog;
		}

		WarrantUserEmailLogImpl warrantUserEmailLogImpl = new WarrantUserEmailLogImpl();

		warrantUserEmailLogImpl.setNew(warrantUserEmailLog.isNew());
		warrantUserEmailLogImpl.setPrimaryKey(warrantUserEmailLog.getPrimaryKey());

		warrantUserEmailLogImpl.setId(warrantUserEmailLog.getId());
		warrantUserEmailLogImpl.setSubject(warrantUserEmailLog.getSubject());
		warrantUserEmailLogImpl.setBodyContent(warrantUserEmailLog.getBodyContent());
		warrantUserEmailLogImpl.setUserId(warrantUserEmailLog.getUserId());
		warrantUserEmailLogImpl.setCreateDate(warrantUserEmailLog.getCreateDate());
		warrantUserEmailLogImpl.setModifiedDate(warrantUserEmailLog.getModifiedDate());

		return warrantUserEmailLogImpl;
	}

	/**
	 * Returns the WarrantUserEmailLog with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WarrantUserEmailLog
	 * @return the WarrantUserEmailLog
	 * @throws com.liferay.portal.NoSuchModelException if a WarrantUserEmailLog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WarrantUserEmailLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the WarrantUserEmailLog with the primary key or throws a {@link com.warrantchange.NoSuchWarrantUserEmailLogException} if it could not be found.
	 *
	 * @param id the primary key of the WarrantUserEmailLog
	 * @return the WarrantUserEmailLog
	 * @throws com.warrantchange.NoSuchWarrantUserEmailLogException if a WarrantUserEmailLog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserEmailLog findByPrimaryKey(long id)
		throws NoSuchWarrantUserEmailLogException, SystemException {
		WarrantUserEmailLog warrantUserEmailLog = fetchByPrimaryKey(id);

		if (warrantUserEmailLog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchWarrantUserEmailLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return warrantUserEmailLog;
	}

	/**
	 * Returns the WarrantUserEmailLog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WarrantUserEmailLog
	 * @return the WarrantUserEmailLog, or <code>null</code> if a WarrantUserEmailLog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WarrantUserEmailLog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the WarrantUserEmailLog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the WarrantUserEmailLog
	 * @return the WarrantUserEmailLog, or <code>null</code> if a WarrantUserEmailLog with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserEmailLog fetchByPrimaryKey(long id)
		throws SystemException {
		WarrantUserEmailLog warrantUserEmailLog = (WarrantUserEmailLog)EntityCacheUtil.getResult(WarrantUserEmailLogModelImpl.ENTITY_CACHE_ENABLED,
				WarrantUserEmailLogImpl.class, id);

		if (warrantUserEmailLog == _nullWarrantUserEmailLog) {
			return null;
		}

		if (warrantUserEmailLog == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				warrantUserEmailLog = (WarrantUserEmailLog)session.get(WarrantUserEmailLogImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (warrantUserEmailLog != null) {
					cacheResult(warrantUserEmailLog);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WarrantUserEmailLogModelImpl.ENTITY_CACHE_ENABLED,
						WarrantUserEmailLogImpl.class, id,
						_nullWarrantUserEmailLog);
				}

				closeSession(session);
			}
		}

		return warrantUserEmailLog;
	}

	/**
	 * Returns the WarrantUserEmailLog where userId = &#63; or throws a {@link com.warrantchange.NoSuchWarrantUserEmailLogException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching WarrantUserEmailLog
	 * @throws com.warrantchange.NoSuchWarrantUserEmailLogException if a matching WarrantUserEmailLog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserEmailLog findByuserId(long userId)
		throws NoSuchWarrantUserEmailLogException, SystemException {
		WarrantUserEmailLog warrantUserEmailLog = fetchByuserId(userId);

		if (warrantUserEmailLog == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWarrantUserEmailLogException(msg.toString());
		}

		return warrantUserEmailLog;
	}

	/**
	 * Returns the WarrantUserEmailLog where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching WarrantUserEmailLog, or <code>null</code> if a matching WarrantUserEmailLog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserEmailLog fetchByuserId(long userId)
		throws SystemException {
		return fetchByuserId(userId, true);
	}

	/**
	 * Returns the WarrantUserEmailLog where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching WarrantUserEmailLog, or <code>null</code> if a matching WarrantUserEmailLog could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserEmailLog fetchByuserId(long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WARRANTUSEREMAILLOG_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			query.append(WarrantUserEmailLogModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<WarrantUserEmailLog> list = q.list();

				result = list;

				WarrantUserEmailLog warrantUserEmailLog = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					warrantUserEmailLog = list.get(0);

					cacheResult(warrantUserEmailLog);

					if ((warrantUserEmailLog.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, warrantUserEmailLog);
					}
				}

				return warrantUserEmailLog;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
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
				return (WarrantUserEmailLog)result;
			}
		}
	}

	/**
	 * Returns all the WarrantUserEmailLogs.
	 *
	 * @return the WarrantUserEmailLogs
	 * @throws SystemException if a system exception occurred
	 */
	public List<WarrantUserEmailLog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<WarrantUserEmailLog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<WarrantUserEmailLog> findAll(int start, int end,
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

		List<WarrantUserEmailLog> list = (List<WarrantUserEmailLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WARRANTUSEREMAILLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WARRANTUSEREMAILLOG.concat(WarrantUserEmailLogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<WarrantUserEmailLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<WarrantUserEmailLog>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes the WarrantUserEmailLog where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByuserId(long userId)
		throws NoSuchWarrantUserEmailLogException, SystemException {
		WarrantUserEmailLog warrantUserEmailLog = findByuserId(userId);

		remove(warrantUserEmailLog);
	}

	/**
	 * Removes all the WarrantUserEmailLogs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (WarrantUserEmailLog warrantUserEmailLog : findAll()) {
			remove(warrantUserEmailLog);
		}
	}

	/**
	 * Returns the number of WarrantUserEmailLogs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching WarrantUserEmailLogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByuserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WARRANTUSEREMAILLOG_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of WarrantUserEmailLogs.
	 *
	 * @return the number of WarrantUserEmailLogs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WARRANTUSEREMAILLOG);

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
	 * Initializes the WarrantUserEmailLog persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.warrantchange.model.WarrantUserEmailLog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WarrantUserEmailLog>> listenersList = new ArrayList<ModelListener<WarrantUserEmailLog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WarrantUserEmailLog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WarrantUserEmailLogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = WarrantPersistence.class)
	protected WarrantPersistence warrantPersistence;
	@BeanReference(type = WarrantUserEmailLogPersistence.class)
	protected WarrantUserEmailLogPersistence warrantUserEmailLogPersistence;
	@BeanReference(type = WarrantUserUniqueIdPersistence.class)
	protected WarrantUserUniqueIdPersistence warrantUserUniqueIdPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_WARRANTUSEREMAILLOG = "SELECT warrantUserEmailLog FROM WarrantUserEmailLog warrantUserEmailLog";
	private static final String _SQL_SELECT_WARRANTUSEREMAILLOG_WHERE = "SELECT warrantUserEmailLog FROM WarrantUserEmailLog warrantUserEmailLog WHERE ";
	private static final String _SQL_COUNT_WARRANTUSEREMAILLOG = "SELECT COUNT(warrantUserEmailLog) FROM WarrantUserEmailLog warrantUserEmailLog";
	private static final String _SQL_COUNT_WARRANTUSEREMAILLOG_WHERE = "SELECT COUNT(warrantUserEmailLog) FROM WarrantUserEmailLog warrantUserEmailLog WHERE ";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "warrantUserEmailLog.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "warrantUserEmailLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WarrantUserEmailLog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WarrantUserEmailLog exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WarrantUserEmailLogPersistenceImpl.class);
	private static WarrantUserEmailLog _nullWarrantUserEmailLog = new WarrantUserEmailLogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WarrantUserEmailLog> toCacheModel() {
				return _nullWarrantUserEmailLogCacheModel;
			}
		};

	private static CacheModel<WarrantUserEmailLog> _nullWarrantUserEmailLogCacheModel =
		new CacheModel<WarrantUserEmailLog>() {
			public WarrantUserEmailLog toEntityModel() {
				return _nullWarrantUserEmailLog;
			}
		};
}