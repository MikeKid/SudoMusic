package com.evolusound.sudomusic.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.evolusound.sudomusic.command.ContactFormCommand;

@Component("contactFormValidator")
public class ContactFormValidator extends EmailFormValidator {
	
	@Override
	public boolean supports(Class<?> targetClass) {
		return ContactFormCommand.class.equals(targetClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		rejectIfMandatoryFieldEmpty(errors, "fullName");
		rejectIfMandatoryFieldEmpty(errors, "email");
		rejectIfEmailNotValid(errors, "email");
		rejectIfMandatoryFieldEmpty(errors, "message");
	}

}
