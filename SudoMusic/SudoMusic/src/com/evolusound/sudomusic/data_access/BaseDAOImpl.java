package com.evolusound.sudomusic.data_access;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class BaseDAOImpl<ENTITY> implements BaseDAO<ENTITY> {
	
	private SessionFactory sessionFactory;
	private Class<ENTITY> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseDAOImpl() {
		this.entityClass = (Class<ENTITY>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public ENTITY createOrUpdate(ENTITY entity) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(entity);
		transaction.commit();
		session.close();
		return entity;
	}
	
    @SuppressWarnings("unchecked")
	@Override
    public List<ENTITY> listAll() {
        Session session = getSessionFactory().openSession();
        List<ENTITY> personList = session.createQuery("from " + entityClass.getSimpleName()).list();
        session.close();
        return personList;
    }

	@Override
	public List<ENTITY> findAll() {
		return findByCriteria();
	}
	
	public List<ENTITY> findByCriteria(Criterion... criterion) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(this.entityClass);
		for (Criterion c : criterion) {
			criteria.add(c);
		}
		return findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<ENTITY> findByCriteria(Criteria criteria) {
		Session session = getSessionFactory().openSession();
		List<ENTITY> list = criteria.list();
		session.close();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public ENTITY findById(Long id) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(this.entityClass);
		criteria.add(Restrictions.eqOrIsNull("id", id));
		return (ENTITY) criteria.uniqueResult();
	}
	
	protected SessionFactory getSessionFactory() {
    	if (sessionFactory == null) {
    		initializeSessionFactory();
    	}
		return this.sessionFactory;
	}
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    protected void initializeSessionFactory() {
    	Configuration configuration = new Configuration().configure();
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
    	applySettings(configuration.getProperties());
    	sessionFactory = configuration.buildSessionFactory(builder.build());
    }
    
	public List<ENTITY> findByExample(ENTITY example) {
		Object[] noArgs = null;
    	Criteria criteria = getSessionFactory().openSession().createCriteria(this.entityClass);
    	for (Field field : example.getClass().getDeclaredFields()) {
    		try {
	    		String getterName = "get"+upperCamelCase(field.getName());
	    		Class<?> mainClass = example.getClass();
	    		Object currentAttribute = mainClass.getMethod(getterName, (Class<?>[])null).invoke(example, noArgs);
	    		if (currentAttribute != null  && !getterName.equals("getIterations")) {
		        	criteria.add(Restrictions.eq(field.getName(), currentAttribute.toString()).ignoreCase());
		        	//criteria.add(Restrictions.like(field.getName(), "%" + currentAttribute + "%"));
	    		}
    		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
    			//TODO
    		}
    	}
    	return findByCriteria(criteria);
	}
    
    protected String upperCamelCase(String s) {
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append(s.substring(0, 1).toUpperCase());
    	stringBuilder.append(s.substring(1));
    	return stringBuilder.toString();
    }

}
