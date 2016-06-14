package com.evolusound.sudomusic.service;

import com.evolusound.sudomusic.data_transfer.CustomerDTO;

public interface LoginService {

	CustomerDTO checkEmailAndPassword(String email, String password);
	
}
