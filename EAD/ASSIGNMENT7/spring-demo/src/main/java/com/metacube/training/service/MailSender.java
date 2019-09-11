package com.metacube.training.service;

/**
 * This is the interface having two methods sendMail and writeMail.
 *
 */
public interface MailSender {

	
	/**
	 * method for send mail
	 */
	void sendMail();
	
	/**
	 * method for write content of mail
	 */
	void writeMail();
	
}
