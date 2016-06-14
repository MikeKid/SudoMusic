package com.evolusound.sudomusic.validator;

import static com.evolusound.sudomusic.constant.CommonContentCode.INVALID_FORMAT;
import static com.evolusound.sudomusic.constant.SystemConstants.EMAIL_PATTERN;
import static com.evolusound.sudomusic.constant.SystemConstants.PASSWORD_PATTERN;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doCallRealMethod;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.Errors;

public class EmailFormValidatorTest {
	

	private EmailFormValidator passwordValidator;
	Errors mockErrors;
    
	@Before
    public void initData(){
		passwordValidator = mock(EmailFormValidator.class);
		mockErrors = mock(Errors.class);
    }
	
	@Test
	public void validEmailTest() {
		String[] validEmails = {"felipesound.suarez@gmail.com", "A@asdf.aaa", "a123aa@a......argh", "a123aa@......argh"};
		for(String email : validEmails){
			doCallRealMethod().when(passwordValidator).rejectIfEmailNotValid(mockErrors, email);
			doCallRealMethod().when(passwordValidator).rejectIfPatternNotMatched(mockErrors, email, INVALID_FORMAT.errorCode(email), EMAIL_PATTERN);
			doCallRealMethod().when(passwordValidator).isPatternMatched(email, EMAIL_PATTERN);
			when(mockErrors.getFieldValue(email)).thenReturn(email);
			passwordValidator.rejectIfEmailNotValid(mockErrors, email);
			verify(mockErrors, never()).rejectValue(email, INVALID_FORMAT.errorCode(email));
		}
		
	}
	
	@Test
	public void invalidEmailTest() {
		String[] invalidEmails = {"asdfasdfasdfasdf","@asdfasdfasdfasdf","a@asdfasdfasdfasdf","drkKiDDOne@12.realShit.f3e", "a@.a"};
		for(String email : invalidEmails){
			doCallRealMethod().when(passwordValidator).rejectIfEmailNotValid(mockErrors, email);
			doCallRealMethod().when(passwordValidator).rejectIfPatternNotMatched(mockErrors, email, INVALID_FORMAT.errorCode(email), EMAIL_PATTERN);
			doCallRealMethod().when(passwordValidator).isPatternMatched(email, EMAIL_PATTERN);
			when(mockErrors.getFieldValue(email)).thenReturn(email);
			passwordValidator.rejectIfEmailNotValid(mockErrors, email);
			verify(mockErrors, times(1)).rejectValue(email, INVALID_FORMAT.errorCode(email));
		}
	}
	
	@Test
	public void validPasswordTest() {
		String[] validPasswords = {"asdfASD1", "as1234dF", "aS1234g$", "Asdf43QAas", "ev01u50uNd", "mY1A@fdsa4321S"};
		for(String password : validPasswords){
			doCallRealMethod().when(passwordValidator).rejectIfPasswordNotValid(mockErrors, password);
			doCallRealMethod().when(passwordValidator).rejectIfPatternNotMatched(mockErrors, password, INVALID_FORMAT.errorCode(password), PASSWORD_PATTERN);
			doCallRealMethod().when(passwordValidator).isPatternMatched(password, PASSWORD_PATTERN);
			when(mockErrors.getFieldValue(password)).thenReturn(password);
			passwordValidator.rejectIfPasswordNotValid(mockErrors, password);
			verify(mockErrors, never()).rejectValue(password, INVALID_FORMAT.errorCode(password));
		}
	   
	}
	
	@Test
	public void invalidPasswordTest() {
		String[] invalidPasswords = {"dYA@","mfdsa123321asdff","asFHdsAAFa","darthKidd$$"};
		for(String password : invalidPasswords){
			doCallRealMethod().when(passwordValidator).rejectIfPasswordNotValid(mockErrors, password);
			doCallRealMethod().when(passwordValidator).rejectIfPatternNotMatched(mockErrors, password, INVALID_FORMAT.errorCode(password), PASSWORD_PATTERN);
			doCallRealMethod().when(passwordValidator).isPatternMatched(password, PASSWORD_PATTERN);
			when(mockErrors.getFieldValue(password)).thenReturn(password);
			passwordValidator.rejectIfPasswordNotValid(mockErrors, password);
			verify(mockErrors, times(1)).rejectValue(password, INVALID_FORMAT.errorCode(password));
		}
	}
	
	@Test
	public void rejectIfPasswordsDontMatchValidTest() {
		//TODO Implement
	}
	
	@Test
	public void rejectIfPasswordsDontMatchInvalidTest() {
		//TODO Implement
	}
	
	@Test
	public void emailEmptyShouldSucceed() {
		//TODO Implement
	}
	
	@Test
	public void emailEmptyShouldFail() {
		//TODO Implement
	}

}
