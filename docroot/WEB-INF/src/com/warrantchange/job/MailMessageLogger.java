/**
 * 
 */
package com.warrantchange.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.mail.MailMessage;
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
		
//		Object payload = message.getPayload();
//		
//		if(!(payload instanceof MailMessage)){
//			return;
//		}
//		MailMessage mailMsg = (MailMessage)payload;
//		
//		String subject = mailMsg.getSubject();
//		
//		String body = mailMsg.getBody();
//		
//		if(subject != null && subject.contains("warrant")){
//			log.info(payload);
//		}

	}

}
