package com.evolusound.sudomusic.validator;

import static com.evolusound.sudomusic.constant.AlertConstants.MINIMUM_LEGAL_AGE;
import static com.evolusound.sudomusic.constant.AlertConstants.MINORS_NOT_ALLOWED;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.evolusound.sudomusic.data_transfer.CustomerDTO;

@Component("registerValidator")
public class RegisterValidator extends EmailFormValidator {

	@Override
	public boolean supports(Class<?> targetClass) {
		return CustomerDTO.class.equals(targetClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		rejectIfMandatoryFieldEmpty(errors, "name");
		rejectIfMandatoryFieldEmpty(errors, "surname");
		rejectIfMandatoryFieldEmpty(errors, "email");
		rejectIfEmailNotValid(errors, "email");
		rejectIfMandatoryFieldEmpty(errors, "password");
		rejectIfPasswordNotValid(errors, "password");
		rejectIfPasswordsDontMatch(errors, "password", "passwordRepeat");
		//TODO rejectIfMinor(errors, (CustomerDTO) target);
	}
	
	protected void rejectIfMinor(Errors errors, CustomerDTO customer) {
		LocalDate now = new LocalDate();
		Years age = Years.yearsBetween(customer.getDateOfBirth(), now);
		if (age.isLessThan(Years.years(MINIMUM_LEGAL_AGE))) {
			errors.rejectValue("age", MINORS_NOT_ALLOWED);
		}
	}

}
