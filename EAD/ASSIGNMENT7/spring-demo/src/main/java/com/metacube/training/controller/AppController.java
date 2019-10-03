package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.training.service.MailSender;

/**
 * This is the controller class
 *
 */
@RestController
public class AppController {
	
	@Autowired
	@Qualifier("mockMailSender")
	private MailSender mailSender;


	
	@RequestMapping("/sendMail")
	public String sendMail() {
		mailSender.sendMail();
		return "Please check your mailbox";
	}
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/writeMail")
	public String writeMail() {
		mailSender.writeMail();
		return "Your mail content is printed on console";
	}
}