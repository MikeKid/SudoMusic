package com.evolusound.sudomusic.data_access;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.Random;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import com.evolusound.sudomusic.domain.Customer;
import com.evolusound.sudomusic.domain.CustomerUtils;


public class BaseDAOImplTest {

	private SessionFactory mockSessionFactory;
	private BaseDAOImpl<Customer> instance;

	@Before
	public void before() {
		instance = new BaseDAOImpl<Customer>();
		mockSessionFactory = mock(SessionFactory.class);
		
		instance.setSessionFactory(mockSessionFactory);
	}
	
	@Test
	public void createOrUpdateShouldUpdate() {
		Random rn = new Random();
		long randomId = rn.nextLong() + 1;
		Customer customer = CustomerUtils.getSampleCustomer01();
		customer.setId(randomId);
		
		instance.createOrUpdate(CustomerUtils.getSampleCustomer01());
		Criterion criterion = Restrictions.eq("id", randomId);
		List<Customer> result = instance.findByCriteria(criterion);
		
		assertTrue(result.size() == 0);
		assertTrue(result.get(0).getId().equals(randomId));
	}
	
	public void listAllSuccessTest() {
		List<Customer> result = instance.listAll();
		assertTrue(result.size() != 0);
	}
	
}
