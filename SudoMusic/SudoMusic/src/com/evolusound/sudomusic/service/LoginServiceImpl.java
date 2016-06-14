package com.evolusound.sudomusic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolusound.sudomusic.data_service.AuthenticationDataService;
import com.evolusound.sudomusic.data_transfer.CustomerDTO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	protected AuthenticationDataService authenticationDataService;
	
	@Override
	public CustomerDTO checkEmailAndPassword(String email, String password) {
		CustomerDTO passwordDTO = authenticationDataService.checkEmailAndPassword(email, password);
		return passwordDTO;
	}

}
