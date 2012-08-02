/**
 * 
 */
package com.warrantchange.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

/**
 * @author gubra
 *
 */
public class MailMessageLogger implements MessageListener {
	
	private static final Log log = LogFactory.getLog(EmailNotifierJob.class);

	/**
	 * 
	 */
	public MailMessageLogger() {
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.messaging.MessageListener#receive(com.liferay.portal.kernel.messaging.Message)
	 */
//	@Override
	public void receive(Message message) throws MessageListenerException {
		
		log.info(message.getPayload());
		

	}

}
