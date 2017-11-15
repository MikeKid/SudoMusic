package com.evolusound.sudomusic.validator;

import static com.evolusound.sudomusic.constant.CommonContentCode.INVALID_FORMAT;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import static com.evolusound.sudomusic.constant.SystemConstants.PASSWORDS_DONT_MATCH;
import static com.evolusound.sudomusic.constant.SystemConstants.PASSWORD_SEPARATOR;
import static com.evolusound.sudomusic.constant.SystemConstants.PASSWORDS_MATCHING_PATTERN;
import static com.evolusound.sudomusic.constant.SystemConstants.EMAIL_PATTERN;
import static com.evolusound.sudomusic.constant.SystemConstants.PASSWORD_PATTERN;

public abstract class EmailFormValidator extends BaseValidator {

	public void rejectIfEmailNotValid(Errors errors, String field) {
		if (!emailEmpty(errors, field)) {
			rejectIfPatternNotMatched(errors, field, INVALID_FORMAT.errorCode(field), EMAIL_PATTERN);
		}
	}
	
	protected boolean emailEmpty(Errors errors, String field) {
		for (FieldError fieldError: errors.getFieldErrors()) {
			if (fieldError.getField().equals(field)) {
				return true;
			}
		}
		return false;
	}
	
	public void rejectIfPasswordNotValid(Errors errors, String field) {
		rejectIfPatternNotMatched(errors, field, INVALID_FORMAT.errorCode(field), PASSWORD_PATTERN);
	}
	
	public void rejectIfPasswordsDontMatch(Errors errors, String password, String passwordRepetition) {
		if (!isPatternMatched((String) errors.getFieldValue(password) + PASSWORD_SEPARATOR + (String) errors.getFieldValue(passwordRepetition), PASSWORDS_MATCHING_PATTERN)) {
			errors.rejectValue(password, INVALID_FORMAT.errorCode(PASSWORDS_DONT_MATCH));
		}
	}
	
}