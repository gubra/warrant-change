package com.organic;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

public class TestJob implements MessageListener {

	public void receive(Message arg0) throws MessageListenerException {
		
		
		try {
			MailMessage mailMessage = new MailMessage();
			mailMessage.setBody("Sent from Liferay");
			mailMessage.setFrom(new InternetAddress("liferay@organicmission.co.uk"));
			mailMessage.setSubject("Email Subject");
			mailMessage.setTo(new InternetAddress("davidakiss@gmail.com"));
			// FIXME temporarily disabled for stopping spam
//			MessageBusUtil.sendMessage(DestinationNames.MAIL, mailMessage);
		} catch (AddressException e) {
			e.printStackTrace();
		}
	}
}
