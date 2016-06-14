package com.evolusound.sudomusic.data_service;

import static com.evolusound.sudomusic.constant.SystemConstants.HASH_KEY_FACTORY_STRING;
import static com.evolusound.sudomusic.constant.SystemConstants.HASH_KEY_LENGTH;
import static com.evolusound.sudomusic.constant.SystemConstants.HASH_NUMBER_ITERATIONS;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.transaction.Transactional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolusound.sudomusic.data_access.CustomerDAO;
import com.evolusound.sudomusic.data_access.PasswordDAO;
import com.evolusound.sudomusic.data_transfer.CustomerDTO;
import com.evolusound.sudomusic.data_transfer.PasswordDTO;
import com.evolusound.sudomusic.domain.Customer;
import com.evolusound.sudomusic.domain.Password;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Service(value = "authenticationDataService")
@Transactional
public class AuthenticationDataService {
	
	@Autowired PasswordDAO passwordDAO;
	@Autowired CustomerDAO customerDAO;
	
	protected MapperFacade mapper = new DefaultMapperFactory.Builder().build().getMapperFacade();
	
	public Password createPassword(PasswordDTO passwordDTO) {
		return passwordDAO.createOrUpdate(mapper.map(passwordDTO, Password.class));
	}
	
	public CustomerDTO checkEmailAndPassword(String email, String unhashedPassword) {
		List<Password> passwords = passwordDAO.listAll();
		for (Password password : passwords) {
			if (check(unhashedPassword, password.getPassword()) && checkIfCustomerIdAndEmailMatch(password.getCustomerId(), email)) {
				return mapper.map(customerDAO.findById(password.getCustomerId()), CustomerDTO.class);
			}
		}
		return null;
	}
	
	public boolean checkIfCustomerIdAndEmailMatch(Long customerId, String email) {
		Customer customer = customerDAO.findById(customerId);
		Boolean result;
		if (email == null) {
			result = false;
		} else {
			return(email.equals(customer.getEmail()));
		}
		return result;
	}

	public PasswordDTO hashPassword(String email, String unhashedPassword) {
		return hashPassword(email, unhashedPassword, null);
	}
	
	public PasswordDTO hashPassword(String email, String unhashedPassword, Long customerId) {
		PasswordDTO password = new PasswordDTO();
		password.setPassword(doSalt(unhashedPassword, HASH_NUMBER_ITERATIONS, HASH_KEY_FACTORY_STRING, HASH_KEY_LENGTH).toString());
		password.setIterations(HASH_NUMBER_ITERATIONS);
		password.setCustomerId(customerId);
		return password;
	}
	
	protected String doSalt(String password, Integer numberOfIterations, String factoryString, Integer keyLength) {
        byte[] salt = null;
		try {
			salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(keyLength);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return Base64.encodeBase64String(salt) + "$" + doHash(password.toCharArray(), salt, numberOfIterations, factoryString, keyLength);
	}
	
    protected String doHash(final char[] password, final byte[] salt, final int iterations, String hashKeyFactory, final int hashKeyLength) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(hashKeyFactory);
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, hashKeyLength);
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            return Base64.encodeBase64String(res); 
        } catch(NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
    
    protected boolean check(String password, String stored) {
    	return check(password, stored, HASH_KEY_FACTORY_STRING);
    }
    
    public boolean check(String password, String stored, String factoryString) {
        String[] saltAndPass = stored.split("\\$");
        if (saltAndPass.length != 2) {
            throw new IllegalStateException("The stored password have the form 'salt$hash'");
        }
        String hashOfInput = doHash(password.toCharArray(), Base64.decodeBase64(saltAndPass[0]), HASH_NUMBER_ITERATIONS, factoryString, HASH_KEY_LENGTH);
        return hashOfInput.equals(saltAndPass[1]);
    }

}
