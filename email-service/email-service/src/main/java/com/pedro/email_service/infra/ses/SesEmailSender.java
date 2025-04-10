package com.pedro.email_service.infra.ses;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.pinpointemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemailv2.model.Body;
import com.amazonaws.services.simpleemailv2.model.Destination;
import com.amazonaws.services.simpleemailv2.model.Message;
import com.pedro.email_service.adapters.EmailSenderGateway;

public class SesEmailSender implements EmailSenderGateway{

	private final AmazonSimpleEmailService amazonSimpleEmailService;
	
	@Autowired
	public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
		this.amazonSimpleEmailService = amazonSimpleEmailService;
	}
	
	@Override
	public void sendEmail(String to, String subject, String body) {
		SendEmailRequest request = new SendEmailRequest()
				.withSource("revolucionario2k@gmail.com")
				.withDestination(new Destination().withToAddresses(to))
				.withMessage(new Message()
						.withSubject(new Content(subject))
						.withBody(new Body().withText(new Content(body)))
						);
	}

}
