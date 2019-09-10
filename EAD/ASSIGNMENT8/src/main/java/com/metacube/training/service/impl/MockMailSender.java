package com.metacube.training.service.impl;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.training.service.MailSender;

//@Component
//@Primary
/**
 * MockMailSender implements the MailSender interface for writing the mail on the console.
 *
 */
public class MockMailSender implements MailSender {
	final String username = "thepriyapandey@gmail.com";
	final String password = "this@is#14";

	private static final Logger log = LoggerFactory.getLogger(MockMailSender.class);

	@Override
	public void sendMail() {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeMail() {
		try {
			log.info("hello oled");
			// create properties field
			Properties properties = new Properties();
			
			log.info("---------------------------------");
			log.info("---------------------------------");
			String host = "IMAP.gmail.com";

			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", "993");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");

			store.connect(host, username, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("Inbox");

			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages(1, 1);
			log.info("messages.length---" + messages.length);

			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
				log.info("---------------------------------");
				log.info("Email Number " + (i + 1));
				log.info("Subject: " + message.getSubject());
				log.info("From: " + message.getFrom()[0]);
				log.info("To: " + message.getAllRecipients().toString());
				log.info("Received Date:" + message.getReceivedDate());
				log.info("Text: " + message.getContent().toString());
			}

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
