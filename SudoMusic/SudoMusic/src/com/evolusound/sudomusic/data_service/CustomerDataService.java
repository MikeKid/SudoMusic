package com.evolusound.sudomusic.data_service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolusound.sudomusic.data_access.CustomerDAO;
import com.evolusound.sudomusic.data_transfer.CustomerDTO;
import com.evolusound.sudomusic.domain.Customer;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Service(value = "customerDataService")
@Transactional
public class CustomerDataService {
	
	@Autowired CustomerDAO customerDAO;
	
	protected MapperFacade mapper = new DefaultMapperFactory.Builder().build().getMapperFacade();
	
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
		Customer customer = customerDAO.createOrUpdate(mapper.map(customerDTO, Customer.class));
		return mapper.map(customer, CustomerDTO.class);
	}

}
