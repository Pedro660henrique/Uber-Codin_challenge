package com.pedro.email_service.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.email_service.adapters.EmailSenderGateway;
import com.pedro.email_service.core.EmailSenderUserCase;

@Service
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
