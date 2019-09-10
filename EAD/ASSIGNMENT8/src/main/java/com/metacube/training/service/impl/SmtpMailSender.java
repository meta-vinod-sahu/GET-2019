package com.metacube.training.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.training.service.MailSender;

//@Component

/**
 * SmtpMailSender implements the MailSender interface for sending the mail on the console.
 *
 */
public class SmtpMailSender  implements MailSender{
	final String username = "thepriyapandey@gmail.com";
	final String password = "this@is#14";
	private static final Logger log = LoggerFactory.getLogger(SmtpMailSender.class);


	@Override
	public void sendMail() {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress());
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("vinod.sahu@metacube.com"));
			message.setSubject("Testing Gmail TLS");
			message.setText("Dear Mail Crawler," + "\n\n Please do not spam my email!");

			Transport.send(message);

			log.info("Please check your mailbox.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void writeMail() {
		// TODO Auto-generated method stub
		
	}

}