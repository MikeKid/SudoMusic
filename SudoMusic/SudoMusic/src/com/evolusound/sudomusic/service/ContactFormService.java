package com.evolusound.sudomusic.service;

import org.springframework.validation.Errors;

import com.evolusound.sudomusic.command.ContactFormCommand;

public interface ContactFormService {

	Errors validateContactForm(ContactFormCommand cmd);
	
	void sendForm(ContactFormCommand cmd);
}
