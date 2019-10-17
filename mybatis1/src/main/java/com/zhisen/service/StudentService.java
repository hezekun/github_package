package com.zhisen.service;

import java.util.Map;

import com.zhisen.service.Exception.ServiceException;

public interface StudentService {
 
	int saveStudent(Map<String,Object> student) throws ServiceException;
}
