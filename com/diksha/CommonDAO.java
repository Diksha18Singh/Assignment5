package com.diksha;

import java.util.List;

public interface CommonDAO<T> {
	
	void create( T object);
	T findById(int id);
	List<T> findAll();
	
	

}
