package com.pedro.email_service.application;

import org.springframework.beans.factory.annotation.Autowired;

import com.pedro.email_service.adapters.EmailSenderGateway;
import com.pedro.email_service.core.EmailSenderUserCase;

public class EmailSenderService implements EmailSenderUserCase {

	
	private final EmailSenderGateway emailSenderGateway;
	
	@Autowired
	public EmailSenderService(EmailSenderGateway emailGateway) {
		this.emailSenderGateway = emailGateway;
	}
	
	@Override
	public void sendEmail(String to, String subject, String body) {
		this.emailSenderGateway.sendEmail(to, subject, body);
		
	}

}
