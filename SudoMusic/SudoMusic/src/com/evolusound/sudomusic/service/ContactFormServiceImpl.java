package com.evolusound.sudomusic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.evolusound.sudomusic.command.ContactFormCommand;
import com.evolusound.sudomusic.validator.ContactFormValidator;

import static com.evolusound.sudomusic.constant.SystemConstants.ADMIN_EMAIL_ADDRESS;
import static com.evolusound.sudomusic.constant.SystemConstants.EMAIL_SUBJECT;
import static com.evolusound.sudomusic.constant.SystemConstants.NAME_FIELD;
import static com.evolusound.sudomusic.constant.SystemConstants.EMAIL_FIELD;
import static com.evolusound.sudomusic.constant.SystemConstants.MESSAGE_FIELD;
import static com.evolusound.sudomusic.constant.SystemConstants.END_OF_MESSAGE_FIELD;

@Service("contactFormService")
public class ContactFormServiceImpl implements ContactFormService {
	
	@Autowired
	protected ContactFormValidator contactFormValidator;
	@Autowired
    private MailSender mailSender;
	
	@Override
	public Errors validateContactForm(ContactFormCommand cmd) {
		Errors errors = new BeanPropertyBindingResult(cmd, "contactFormCommand");
		contactFormValidator.validate(cmd, errors);
		return errors;
	}

	@Override
	public void sendForm(ContactFormCommand cmd) {
		//TODO save query on db?
		
        SimpleMailMessage message = new SimpleMailMessage();
        //message.setFrom(cmd.getEmail());
        message.setTo(ADMIN_EMAIL_ADDRESS);
        message.setSubject(EMAIL_SUBJECT);
        message.setText(prepareText(cmd));
        mailSender.send(message);
	}
	
	protected String prepareText(ContactFormCommand cmd) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(NAME_FIELD);
		stringBuilder.append(cmd.getFullName() + "\n");
		stringBuilder.append(EMAIL_FIELD);
		stringBuilder.append(cmd.getEmail() + "\n");
		stringBuilder.append(MESSAGE_FIELD);
		stringBuilder.append(cmd.getMessage() + "\n");
		stringBuilder.append(END_OF_MESSAGE_FIELD);
		return stringBuilder.toString();
	}

}
