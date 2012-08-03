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

import com.warrantchange.NoSuchWarrantUserUniqueIdException;

import com.warrantchange.model.WarrantUserUniqueId;
import com.warrantchange.model.impl.WarrantUserUniqueIdImpl;
import com.warrantchange.model.impl.WarrantUserUniqueIdModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the WarrantUserUniqueId service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author davidk
 * @see WarrantUserUniqueIdPersistence
 * @see WarrantUserUniqueIdUtil
 * @generated
 */
public class WarrantUserUniqueIdPersistenceImpl extends BasePersistenceImpl<WarrantUserUniqueId>
	implements WarrantUserUniqueIdPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WarrantUserUniqueIdUtil} to access the WarrantUserUniqueId persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WarrantUserUniqueIdImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_UNIQUEID = new FinderPath(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserUniqueIdModelImpl.FINDER_CACHE_ENABLED,
			WarrantUserUniqueIdImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByuniqueId", new String[] { String.class.getName() },
			WarrantUserUniqueIdModelImpl.UNIQUEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNIQUEID = new FinderPath(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserUniqueIdModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuniqueId",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserUniqueIdModelImpl.FINDER_CACHE_ENABLED,
			WarrantUserUniqueIdImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByuserId", new String[] { Long.class.getName() },
			WarrantUserUniqueIdModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserUniqueIdModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserUniqueIdModelImpl.FINDER_CACHE_ENABLED,
			WarrantUserUniqueIdImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserUniqueIdModelImpl.FINDER_CACHE_ENABLED,
			WarrantUserUniqueIdImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserUniqueIdModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the WarrantUserUniqueId in the entity cache if it is enabled.
	 *
	 * @param warrantUserUniqueId the WarrantUserUniqueId
	 */
	public void cacheResult(WarrantUserUniqueId warrantUserUniqueId) {
		EntityCacheUtil.putResult(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserUniqueIdImpl.class, warrantUserUniqueId.getPrimaryKey(),
			warrantUserUniqueId);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UNIQUEID,
			new Object[] { warrantUserUniqueId.getUniqueId() },
			warrantUserUniqueId);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(warrantUserUniqueId.getUserId()) },
			warrantUserUniqueId);

		warrantUserUniqueId.resetOriginalValues();
	}

	/**
	 * Caches the WarrantUserUniqueIds in the entity cache if it is enabled.
	 *
	 * @param warrantUserUniqueIds the WarrantUserUniqueIds
	 */
	public void cacheResult(List<WarrantUserUniqueId> warrantUserUniqueIds) {
		for (WarrantUserUniqueId warrantUserUniqueId : warrantUserUniqueIds) {
			if (EntityCacheUtil.getResult(
						WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
						WarrantUserUniqueIdImpl.class,
						warrantUserUniqueId.getPrimaryKey()) == null) {
				cacheResult(warrantUserUniqueId);
			}
			else {
				warrantUserUniqueId.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WarrantUserUniqueIds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WarrantUserUniqueIdImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WarrantUserUniqueIdImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WarrantUserUniqueId.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WarrantUserUniqueId warrantUserUniqueId) {
		EntityCacheUtil.removeResult(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserUniqueIdImpl.class, warrantUserUniqueId.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(warrantUserUniqueId);
	}

	@Override
	public void clearCache(List<WarrantUserUniqueId> warrantUserUniqueIds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WarrantUserUniqueId warrantUserUniqueId : warrantUserUniqueIds) {
			EntityCacheUtil.removeResult(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
				WarrantUserUniqueIdImpl.class,
				warrantUserUniqueId.getPrimaryKey());

			clearUniqueFindersCache(warrantUserUniqueId);
		}
	}

	protected void clearUniqueFindersCache(
		WarrantUserUniqueId warrantUserUniqueId) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UNIQUEID,
			new Object[] { warrantUserUniqueId.getUniqueId() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(warrantUserUniqueId.getUserId()) });
	}

	/**
	 * Creates a new WarrantUserUniqueId with the primary key. Does not add the WarrantUserUniqueId to the database.
	 *
	 * @param id the primary key for the new WarrantUserUniqueId
	 * @return the new WarrantUserUniqueId
	 */
	public WarrantUserUniqueId create(long id) {
		WarrantUserUniqueId warrantUserUniqueId = new WarrantUserUniqueIdImpl();

		warrantUserUniqueId.setNew(true);
		warrantUserUniqueId.setPrimaryKey(id);

		return warrantUserUniqueId;
	}

	/**
	 * Removes the WarrantUserUniqueId with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the WarrantUserUniqueId
	 * @return the WarrantUserUniqueId that was removed
	 * @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a WarrantUserUniqueId with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserUniqueId remove(long id)
		throws NoSuchWarrantUserUniqueIdException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the WarrantUserUniqueId with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WarrantUserUniqueId
	 * @return the WarrantUserUniqueId that was removed
	 * @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a WarrantUserUniqueId with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WarrantUserUniqueId remove(Serializable primaryKey)
		throws NoSuchWarrantUserUniqueIdException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WarrantUserUniqueId warrantUserUniqueId = (WarrantUserUniqueId)session.get(WarrantUserUniqueIdImpl.class,
					primaryKey);

			if (warrantUserUniqueId == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWarrantUserUniqueIdException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(warrantUserUniqueId);
		}
		catch (NoSuchWarrantUserUniqueIdException nsee) {
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
	protected WarrantUserUniqueId removeImpl(
		WarrantUserUniqueId warrantUserUniqueId) throws SystemException {
		warrantUserUniqueId = toUnwrappedModel(warrantUserUniqueId);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, warrantUserUniqueId);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(warrantUserUniqueId);

		return warrantUserUniqueId;
	}

	@Override
	public WarrantUserUniqueId updateImpl(
		com.warrantchange.model.WarrantUserUniqueId warrantUserUniqueId,
		boolean merge) throws SystemException {
		warrantUserUniqueId = toUnwrappedModel(warrantUserUniqueId);

		boolean isNew = warrantUserUniqueId.isNew();

		WarrantUserUniqueIdModelImpl warrantUserUniqueIdModelImpl = (WarrantUserUniqueIdModelImpl)warrantUserUniqueId;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, warrantUserUniqueId, merge);

			warrantUserUniqueId.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WarrantUserUniqueIdModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
			WarrantUserUniqueIdImpl.class, warrantUserUniqueId.getPrimaryKey(),
			warrantUserUniqueId);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UNIQUEID,
				new Object[] { warrantUserUniqueId.getUniqueId() },
				warrantUserUniqueId);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
				new Object[] { Long.valueOf(warrantUserUniqueId.getUserId()) },
				warrantUserUniqueId);
		}
		else {
			if ((warrantUserUniqueIdModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UNIQUEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						warrantUserUniqueIdModelImpl.getOriginalUniqueId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNIQUEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UNIQUEID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UNIQUEID,
					new Object[] { warrantUserUniqueId.getUniqueId() },
					warrantUserUniqueId);
			}

			if ((warrantUserUniqueIdModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(warrantUserUniqueIdModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
					new Object[] { Long.valueOf(warrantUserUniqueId.getUserId()) },
					warrantUserUniqueId);
			}
		}

		return warrantUserUniqueId;
	}

	protected WarrantUserUniqueId toUnwrappedModel(
		WarrantUserUniqueId warrantUserUniqueId) {
		if (warrantUserUniqueId instanceof WarrantUserUniqueIdImpl) {
			return warrantUserUniqueId;
		}

		WarrantUserUniqueIdImpl warrantUserUniqueIdImpl = new WarrantUserUniqueIdImpl();

		warrantUserUniqueIdImpl.setNew(warrantUserUniqueId.isNew());
		warrantUserUniqueIdImpl.setPrimaryKey(warrantUserUniqueId.getPrimaryKey());

		warrantUserUniqueIdImpl.setId(warrantUserUniqueId.getId());
		warrantUserUniqueIdImpl.setUniqueId(warrantUserUniqueId.getUniqueId());
		warrantUserUniqueIdImpl.setUserId(warrantUserUniqueId.getUserId());
		warrantUserUniqueIdImpl.setCreateDate(warrantUserUniqueId.getCreateDate());
		warrantUserUniqueIdImpl.setModifiedDate(warrantUserUniqueId.getModifiedDate());
		warrantUserUniqueIdImpl.setSentEmail(warrantUserUniqueId.getSentEmail());
		warrantUserUniqueIdImpl.setSentDate(warrantUserUniqueId.getSentDate());
		warrantUserUniqueIdImpl.setSentOmicode(warrantUserUniqueId.getSentOmicode());

		return warrantUserUniqueIdImpl;
	}

	/**
	 * Returns the WarrantUserUniqueId with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WarrantUserUniqueId
	 * @return the WarrantUserUniqueId
	 * @throws com.liferay.portal.NoSuchModelException if a WarrantUserUniqueId with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WarrantUserUniqueId findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the WarrantUserUniqueId with the primary key or throws a {@link com.warrantchange.NoSuchWarrantUserUniqueIdException} if it could not be found.
	 *
	 * @param id the primary key of the WarrantUserUniqueId
	 * @return the WarrantUserUniqueId
	 * @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a WarrantUserUniqueId with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserUniqueId findByPrimaryKey(long id)
		throws NoSuchWarrantUserUniqueIdException, SystemException {
		WarrantUserUniqueId warrantUserUniqueId = fetchByPrimaryKey(id);

		if (warrantUserUniqueId == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchWarrantUserUniqueIdException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return warrantUserUniqueId;
	}

	/**
	 * Returns the WarrantUserUniqueId with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WarrantUserUniqueId
	 * @return the WarrantUserUniqueId, or <code>null</code> if a WarrantUserUniqueId with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WarrantUserUniqueId fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the WarrantUserUniqueId with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the WarrantUserUniqueId
	 * @return the WarrantUserUniqueId, or <code>null</code> if a WarrantUserUniqueId with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserUniqueId fetchByPrimaryKey(long id)
		throws SystemException {
		WarrantUserUniqueId warrantUserUniqueId = (WarrantUserUniqueId)EntityCacheUtil.getResult(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
				WarrantUserUniqueIdImpl.class, id);

		if (warrantUserUniqueId == _nullWarrantUserUniqueId) {
			return null;
		}

		if (warrantUserUniqueId == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				warrantUserUniqueId = (WarrantUserUniqueId)session.get(WarrantUserUniqueIdImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (warrantUserUniqueId != null) {
					cacheResult(warrantUserUniqueId);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WarrantUserUniqueIdModelImpl.ENTITY_CACHE_ENABLED,
						WarrantUserUniqueIdImpl.class, id,
						_nullWarrantUserUniqueId);
				}

				closeSession(session);
			}
		}

		return warrantUserUniqueId;
	}

	/**
	 * Returns the WarrantUserUniqueId where uniqueId = &#63; or throws a {@link com.warrantchange.NoSuchWarrantUserUniqueIdException} if it could not be found.
	 *
	 * @param uniqueId the unique ID
	 * @return the matching WarrantUserUniqueId
	 * @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a matching WarrantUserUniqueId could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserUniqueId findByuniqueId(String uniqueId)
		throws NoSuchWarrantUserUniqueIdException, SystemException {
		WarrantUserUniqueId warrantUserUniqueId = fetchByuniqueId(uniqueId);

		if (warrantUserUniqueId == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uniqueId=");
			msg.append(uniqueId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWarrantUserUniqueIdException(msg.toString());
		}

		return warrantUserUniqueId;
	}

	/**
	 * Returns the WarrantUserUniqueId where uniqueId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uniqueId the unique ID
	 * @return the matching WarrantUserUniqueId, or <code>null</code> if a matching WarrantUserUniqueId could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserUniqueId fetchByuniqueId(String uniqueId)
		throws SystemException {
		return fetchByuniqueId(uniqueId, true);
	}

	/**
	 * Returns the WarrantUserUniqueId where uniqueId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uniqueId the unique ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching WarrantUserUniqueId, or <code>null</code> if a matching WarrantUserUniqueId could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserUniqueId fetchByuniqueId(String uniqueId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uniqueId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UNIQUEID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WARRANTUSERUNIQUEID_WHERE);

			if (uniqueId == null) {
				query.append(_FINDER_COLUMN_UNIQUEID_UNIQUEID_1);
			}
			else {
				if (uniqueId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UNIQUEID_UNIQUEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UNIQUEID_UNIQUEID_2);
				}
			}

			query.append(WarrantUserUniqueIdModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uniqueId != null) {
					qPos.add(uniqueId);
				}

				List<WarrantUserUniqueId> list = q.list();

				result = list;

				WarrantUserUniqueId warrantUserUniqueId = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UNIQUEID,
						finderArgs, list);
				}
				else {
					warrantUserUniqueId = list.get(0);

					cacheResult(warrantUserUniqueId);

					if ((warrantUserUniqueId.getUniqueId() == null) ||
							!warrantUserUniqueId.getUniqueId().equals(uniqueId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UNIQUEID,
							finderArgs, warrantUserUniqueId);
					}
				}

				return warrantUserUniqueId;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UNIQUEID,
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
				return (WarrantUserUniqueId)result;
			}
		}
	}

	/**
	 * Returns the WarrantUserUniqueId where userId = &#63; or throws a {@link com.warrantchange.NoSuchWarrantUserUniqueIdException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching WarrantUserUniqueId
	 * @throws com.warrantchange.NoSuchWarrantUserUniqueIdException if a matching WarrantUserUniqueId could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserUniqueId findByuserId(long userId)
		throws NoSuchWarrantUserUniqueIdException, SystemException {
		WarrantUserUniqueId warrantUserUniqueId = fetchByuserId(userId);

		if (warrantUserUniqueId == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchWarrantUserUniqueIdException(msg.toString());
		}

		return warrantUserUniqueId;
	}

	/**
	 * Returns the WarrantUserUniqueId where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching WarrantUserUniqueId, or <code>null</code> if a matching WarrantUserUniqueId could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserUniqueId fetchByuserId(long userId)
		throws SystemException {
		return fetchByuserId(userId, true);
	}

	/**
	 * Returns the WarrantUserUniqueId where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching WarrantUserUniqueId, or <code>null</code> if a matching WarrantUserUniqueId could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WarrantUserUniqueId fetchByuserId(long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WARRANTUSERUNIQUEID_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			query.append(WarrantUserUniqueIdModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<WarrantUserUniqueId> list = q.list();

				result = list;

				WarrantUserUniqueId warrantUserUniqueId = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					warrantUserUniqueId = list.get(0);

					cacheResult(warrantUserUniqueId);

					if ((warrantUserUniqueId.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, warrantUserUniqueId);
					}
				}

				return warrantUserUniqueId;
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
				return (WarrantUserUniqueId)result;
			}
		}
	}

	/**
	 * Returns all the WarrantUserUniqueIds.
	 *
	 * @return the WarrantUserUniqueIds
	 * @throws SystemException if a system exception occurred
	 */
	public List<WarrantUserUniqueId> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the WarrantUserUniqueIds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of WarrantUserUniqueIds
	 * @param end the upper bound of the range of WarrantUserUniqueIds (not inclusive)
	 * @return the range of WarrantUserUniqueIds
	 * @throws SystemException if a system exception occurred
	 */
	public List<WarrantUserUniqueId> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the WarrantUserUniqueIds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of WarrantUserUniqueIds
	 * @param end the upper bound of the range of WarrantUserUniqueIds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of WarrantUserUniqueIds
	 * @throws SystemException if a system exception occurred
	 */
	public List<WarrantUserUniqueId> findAll(int start, int end,
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

		List<WarrantUserUniqueId> list = (List<WarrantUserUniqueId>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WARRANTUSERUNIQUEID);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WARRANTUSERUNIQUEID.concat(WarrantUserUniqueIdModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<WarrantUserUniqueId>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<WarrantUserUniqueId>)QueryUtil.list(q,
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
	 * Removes the WarrantUserUniqueId where uniqueId = &#63; from the database.
	 *
	 * @param uniqueId the unique ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByuniqueId(String uniqueId)
		throws NoSuchWarrantUserUniqueIdException, SystemException {
		WarrantUserUniqueId warrantUserUniqueId = findByuniqueId(uniqueId);

		remove(warrantUserUniqueId);
	}

	/**
	 * Removes the WarrantUserUniqueId where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByuserId(long userId)
		throws NoSuchWarrantUserUniqueIdException, SystemException {
		WarrantUserUniqueId warrantUserUniqueId = findByuserId(userId);

		remove(warrantUserUniqueId);
	}

	/**
	 * Removes all the WarrantUserUniqueIds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (WarrantUserUniqueId warrantUserUniqueId : findAll()) {
			remove(warrantUserUniqueId);
		}
	}

	/**
	 * Returns the number of WarrantUserUniqueIds where uniqueId = &#63;.
	 *
	 * @param uniqueId the unique ID
	 * @return the number of matching WarrantUserUniqueIds
	 * @throws SystemException if a system exception occurred
	 */
	public int countByuniqueId(String uniqueId) throws SystemException {
		Object[] finderArgs = new Object[] { uniqueId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UNIQUEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WARRANTUSERUNIQUEID_WHERE);

			if (uniqueId == null) {
				query.append(_FINDER_COLUMN_UNIQUEID_UNIQUEID_1);
			}
			else {
				if (uniqueId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UNIQUEID_UNIQUEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UNIQUEID_UNIQUEID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uniqueId != null) {
					qPos.add(uniqueId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UNIQUEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of WarrantUserUniqueIds where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching WarrantUserUniqueIds
	 * @throws SystemException if a system exception occurred
	 */
	public int countByuserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WARRANTUSERUNIQUEID_WHERE);

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
	 * Returns the number of WarrantUserUniqueIds.
	 *
	 * @return the number of WarrantUserUniqueIds
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WARRANTUSERUNIQUEID);

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
	 * Initializes the WarrantUserUniqueId persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.warrantchange.model.WarrantUserUniqueId")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WarrantUserUniqueId>> listenersList = new ArrayList<ModelListener<WarrantUserUniqueId>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WarrantUserUniqueId>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WarrantUserUniqueIdImpl.class.getName());
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
	private static final String _SQL_SELECT_WARRANTUSERUNIQUEID = "SELECT warrantUserUniqueId FROM WarrantUserUniqueId warrantUserUniqueId";
	private static final String _SQL_SELECT_WARRANTUSERUNIQUEID_WHERE = "SELECT warrantUserUniqueId FROM WarrantUserUniqueId warrantUserUniqueId WHERE ";
	private static final String _SQL_COUNT_WARRANTUSERUNIQUEID = "SELECT COUNT(warrantUserUniqueId) FROM WarrantUserUniqueId warrantUserUniqueId";
	private static final String _SQL_COUNT_WARRANTUSERUNIQUEID_WHERE = "SELECT COUNT(warrantUserUniqueId) FROM WarrantUserUniqueId warrantUserUniqueId WHERE ";
	private static final String _FINDER_COLUMN_UNIQUEID_UNIQUEID_1 = "warrantUserUniqueId.uniqueId IS NULL";
	private static final String _FINDER_COLUMN_UNIQUEID_UNIQUEID_2 = "warrantUserUniqueId.uniqueId = ?";
	private static final String _FINDER_COLUMN_UNIQUEID_UNIQUEID_3 = "(warrantUserUniqueId.uniqueId IS NULL OR warrantUserUniqueId.uniqueId = ?)";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "warrantUserUniqueId.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "warrantUserUniqueId.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WarrantUserUniqueId exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WarrantUserUniqueId exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WarrantUserUniqueIdPersistenceImpl.class);
	private static WarrantUserUniqueId _nullWarrantUserUniqueId = new WarrantUserUniqueIdImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WarrantUserUniqueId> toCacheModel() {
				return _nullWarrantUserUniqueIdCacheModel;
			}
		};

	private static CacheModel<WarrantUserUniqueId> _nullWarrantUserUniqueIdCacheModel =
		new CacheModel<WarrantUserUniqueId>() {
			public WarrantUserUniqueId toEntityModel() {
				return _nullWarrantUserUniqueId;
			}
		};
}