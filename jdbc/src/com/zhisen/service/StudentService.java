package com.zhisen.service;

import javax.sql.rowset.serial.SerialException;

import com.zhisen.dao.entity.Student;
import com.zhisen.service.exception.ServiceException;

public interface StudentService {

	public void StudentBaoDao(Student student) throws  ServiceException;
	public void StudentDelete(Student student) throws ServiceException;
	public void changeStudent(Student student1, Student student2) throws ServiceException;
	public void findStudent(Student student) throws ServiceException;
}
