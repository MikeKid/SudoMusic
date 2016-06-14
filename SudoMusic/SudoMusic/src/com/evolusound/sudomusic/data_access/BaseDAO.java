package com.evolusound.sudomusic.data_access;

import java.util.List;

public interface BaseDAO<ENTITY> {
	
	ENTITY createOrUpdate(ENTITY entity);
	List<ENTITY> findAll();
	List<ENTITY> listAll();

}
