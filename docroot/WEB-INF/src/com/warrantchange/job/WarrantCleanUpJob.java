package com.warrantchange.job;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.warrantchange.NoSuchWarrantException;
import com.warrantchange.model.Warrant;
import com.warrantchange.service.WarrantLocalServiceUtil;

public class WarrantCleanUpJob implements MessageListener {

	private static final Log log = LogFactory.getLog(WarrantCleanUpJob.class);

	private static final int DAYS_TO_CLEAN_UP = 14;

	public void receive(Message msg) throws MessageListenerException {
		Date before = JobUtils.createDate(DAYS_TO_CLEAN_UP);
		log.debug(String.format("Cleaning up warrants deleted before %tD", before));
		try {
			List<Warrant> warrants = WarrantLocalServiceUtil.findWarrants(0, 3);
			for (Warrant warrant : warrants) {
				log.info("warrant id: "+warrant.getId());
			}
			WarrantLocalServiceUtil.cleanUpWarrantsDeletedBefore(before);
		} catch (NoSuchWarrantException e) {
			log.error("failed to run warrant cleanup job", e);
		} catch (SystemException e) {
			log.error("failed to run warrant cleanup job", e);
		}
	}
}
