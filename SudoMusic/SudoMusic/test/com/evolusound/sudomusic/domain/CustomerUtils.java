package com.evolusound.sudomusic.domain;

public class CustomerUtils {
	
	public static Customer getSampleCustomer01() {
		Customer sampleCustomer01 = new Customer();
		sampleCustomer01.setName("Sample");
		sampleCustomer01.setSurname("Customer");
		sampleCustomer01.setId(123L);
		sampleCustomer01.setEmail("sampleCustomer@sudomusic.com");
		return sampleCustomer01;
	}

}
