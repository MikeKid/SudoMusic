package com.evolusound.sudomusic.service;

import org.springframework.validation.Errors;

import com.evolusound.sudomusic.data_transfer.CustomerDTO;

public interface RegisterService {

	Errors validateCustomer(CustomerDTO customer);
	void addCustomerAndPassword(CustomerDTO customer);
	
}
