package com.evolusound.sudomusic.data_service;

import static com.evolusound.sudomusic.constant.SystemConstants.HASH_KEY_LENGTH;
import static com.evolusound.sudomusic.constant.TestConstants.HASH_KEY_FACTORY_TEST_STRING;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PasswordDataServiceTest {
	
	AuthenticationDataService instance;
	
	@Before
	public void setUp() {
		instance = new AuthenticationDataService();
	}
	
	@Test
	public void doHashShouldGenerateSameValueTwice() {
		String result1 = instance.doHash("Qwee1233".toCharArray(), "Pepito@pepito.com".getBytes(), 20, HASH_KEY_FACTORY_TEST_STRING, HASH_KEY_LENGTH);
		String result2 = instance.doHash("Qwee1233".toCharArray(), "Pepito@pepito.com".getBytes(), 20, HASH_KEY_FACTORY_TEST_STRING, HASH_KEY_LENGTH);
		assertEquals(result1, result2);
	}
	
	@Test
	public void checkPasswordsShouldMatch() {
		String stored = instance.doSalt("Qwee1233", 20, HASH_KEY_FACTORY_TEST_STRING, HASH_KEY_LENGTH);
		instance.check("Qwee1233", stored, HASH_KEY_FACTORY_TEST_STRING);
	}

}
