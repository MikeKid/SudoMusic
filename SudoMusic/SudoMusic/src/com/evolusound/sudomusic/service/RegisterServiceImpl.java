package com.evolusound.sudomusic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.evolusound.sudomusic.data_service.CustomerDataService;
import com.evolusound.sudomusic.data_service.AuthenticationDataService;
import com.evolusound.sudomusic.data_transfer.CustomerDTO;
import com.evolusound.sudomusic.data_transfer.PasswordDTO;
import com.evolusound.sudomusic.validator.RegisterValidator;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	protected RegisterValidator registerValidator;
	@Autowired
	protected CustomerDataService customerDataService;
	@Autowired
	protected AuthenticationDataService authenticationDataService;

	public Errors validateCustomer(CustomerDTO customer) {
		Errors errors = new BeanPropertyBindingResult(customer, "customer");
		registerValidator.validate(customer, errors);
		return errors;
	}
	
	/*public String getErrorMessages(Errors errors) {
		StringBuilder message = new StringBuilder();
		for (ObjectError error : errors.getAllErrors()) {
			message.append(error.getCode() + "\n");
		}
		return message.toString();
	}*/
	
	public void addCustomerAndPassword(CustomerDTO customerDTO) {
		String password = customerDTO.getPassword();
		customerDTO = customerDataService.createCustomer(customerDTO);
		
		PasswordDTO passwordDTO = authenticationDataService.hashPassword(customerDTO.getEmail(), password, customerDTO.getId());
		authenticationDataService.createPassword(passwordDTO);
	}

}
