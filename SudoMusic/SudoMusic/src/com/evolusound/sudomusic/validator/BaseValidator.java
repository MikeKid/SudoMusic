package com.evolusound.sudomusic.validator;

import static com.evolusound.sudomusic.constant.CommonContentCode.MANDATORY_FIELD_EMPTY;
import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class BaseValidator implements Validator {

	protected boolean hasNoFieldErrors(Errors errors, String field) {
		return !errors.hasFieldErrors(field);
	}
	
	public void rejectIfMandatoryFieldEmpty(Errors errors, String field) {
		rejectIfEmptyOrWhitespace(errors, field, MANDATORY_FIELD_EMPTY.errorCode(field), new Object[] {
				new DefaultMessageSourceResolvable(field + ".label") }, MANDATORY_FIELD_EMPTY.errorCode(field));
	}
	
	public void rejectIfPatternNotMatched(Errors errors, String field, String errorCode, String pattern) {
		if (!isPatternMatched((String) errors.getFieldValue(field), pattern)) {
			errors.rejectValue(field, errorCode);
		}
	}
	
	public boolean isPatternMatched(String value, String pattern) {
		if (value == null || pattern == null) {
			return false;
		}
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(value);
		return m.matches();
	}

}
