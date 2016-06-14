package com.evolusound.sudomusic.data_access;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.evolusound.sudomusic.domain.Customer;
import com.evolusound.sudomusic.domain.CustomerUtils;

@Transactional
public class CustomerDAOTest {
	private CustomerDAO instance;
	private SessionFactory mockSessionFactory;
	private Session mockSession;
	
	@Before
	public void before() {
		instance = new CustomerDAO();
		mockSessionFactory = mock(SessionFactory.class);
		instance.setSessionFactory(mockSessionFactory);
		mockSession = mock(Session.class);
		when(mockSessionFactory.openSession()).thenReturn(mockSession);
	}
	
	@Test
	public void getSessionMockTest() {
		when(mockSessionFactory.getCurrentSession()).thenCallRealMethod();
		
		Session session = instance.getSessionFactory().openSession();
		assertNotNull(session);
		session.close();
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
}
