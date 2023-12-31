package com.hang.work.bank.dao;

public interface BaseDao <T>{
	
	void insert(T t);
	
	void update(T t);
	
	T selectById(Integer id);
	
}
