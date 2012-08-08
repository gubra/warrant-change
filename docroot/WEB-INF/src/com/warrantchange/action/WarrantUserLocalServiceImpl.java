package com.warrantchange.action;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceWrapper;

public class WarrantUserLocalServiceImpl extends UserLocalServiceWrapper {
	private static final Log log = LogFactory.getLog(WarrantUserLocalServiceImpl.class);

	public WarrantUserLocalServiceImpl(UserLocalService userLocalService) {
		super(userLocalService);
	}

	@Override
	public User addUser(long creatorUserId, long companyId,
			boolean autoPassword, String password1, String password2,
			boolean autoScreenName, String screenName, String emailAddress,
			long facebookId, String openId, Locale locale, String firstName,
			String middleName, String lastName, int prefixId, int suffixId,
			boolean male, int birthdayMonth, int birthdayDay, int birthdayYear,
			String jobTitle, long[] groupIds, long[] organizationIds,
			long[] roleIds, long[] userGroupIds, boolean sendEmail,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		// TODO Auto-generated method stub
		User user = super.addUser(creatorUserId, companyId, autoPassword, password1,
				password2, autoScreenName, screenName, emailAddress, facebookId,
				openId, locale, firstName, middleName, lastName, prefixId, suffixId,
				male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
				organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		log.debug("Adding user: "+user+", expando: "+user.getExpandoBridge());
		return user;
	}
}
