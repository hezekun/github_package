package com.zhisen.dao;


import java.util.List;

import com.zhisen.dao.exception.DaoException;

public interface BaseDao<T>{
	boolean saveObject(T object) throws DaoException;
	boolean dropObject(T object) throws DaoException;
	boolean updateObject(T object) throws DaoException;
	T findObjectById(int id) throws DaoException;
	List<T> findAllObject() throws DaoException;
	
	
}
