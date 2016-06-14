package com.evolusound.sudomusic.constant;

public class SystemConstants {
	
	public static final String JSP_BASE_DIR = "/WEB-INF/jsp/";
	public static final String JSP_SUFFIX = ".jsp";
	public static final String MESSAGES_BASE_DIR = "/WEB-INF/resources/messages";
	public static final String DEFAULT_ENCODING = "UTF-8";
	public static final String LOCALE_COOKIE_NAME = "localeCookie";
	public static final Integer LOCALE_COOKIE_MAX_AGE = 4800;
	public static final String DEFAULT_LOCALE = "en";
	public static final String EMAIL_DEFAULT_HOST = "smtp.gmail.com";
	public static final String EMAIL_SYSTEM_USERNAME = "mugiwarageek@gmail.com";
	public static final String EMAIL_SYSTEM_PASSWORD = "qwee1233";
	public static final String EMAIL_PATTERN = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b";
	public static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])([@#$%]*).{8,20})";
	public static final String PASSWORDS_DONT_MATCH = "passwordsDontMatch";
	public static final String PASSWORD_SEPARATOR = ":";
	public static final String PASSWORDS_MATCHING_PATTERN = "\\b(\\w+)" + PASSWORD_SEPARATOR + "\\1\\b";
	public static final String ADMIN_EMAIL_ADDRESS = "contact.darkkid@gmail.com";
	public static final String EMAIL_SUBJECT = "Contact form";
	public static final String NAME_FIELD = "***NAME*** ";
	public static final String EMAIL_FIELD = "***EMAIL*** ";
	public static final String MESSAGE_FIELD = "***MESSAGE***\n";
	public static final String END_OF_MESSAGE_FIELD = "***END-OF-MESSAGE***\n";
	public static final String HASH_KEY_FACTORY_STRING = "PBKDF2WithHmacSHA512";
	public static final Integer HASH_NUMBER_ITERATIONS = 20; //TODO To set in production as high as computationally acceptable
	public static final Integer HASH_KEY_LENGTH = 256;
	
	public static final String LONG_DESCRIPION = "about.description.long";

}
