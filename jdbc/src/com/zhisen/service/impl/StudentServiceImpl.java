package com.zhisen.service.impl;

import javax.sql.rowset.serial.SerialException;

import com.zhisen.dao.BaseDao;
import com.zhisen.dao.entity.Student;
import com.zhisen.dao.exception.DaoException;
import com.zhisen.dao.factory.DaoFactory;
import com.zhisen.service.StudentService;
import com.zhisen.service.exception.ServiceException;
import com.zhisen.service.factory.ServiceFactory;

public class StudentServiceImpl implements StudentService {

	private BaseDao studentDao;

	public StudentServiceImpl() {
		studentDao = DaoFactory.getStudentDao();
	}

	@Override
	public void StudentBaoDao(Student student) throws ServiceException {
		try {
			studentDao.addStudent(student);
		} catch (DaoException e) {
			throw new ServiceException("ѧ�����������쳣", e);
		}
	}

	public void StudentDelete(Student student) throws ServiceException {
		try {
			studentDao.dropStudent(student);
		} catch (DaoException e) {
			throw new ServiceException("ѧ��ɾ�������쳣", e);
		}
	}

	@Override
	public void changeStudent(Student student1,Student student2) throws ServiceException {
		try {
			studentDao.updateStudent(student1,student2);
		} catch (DaoException e) {
			throw new ServiceException("ѧ�����ķ����쳣", e);
		}
		
	}
	
	public void findStudent(Student student) throws ServiceException {
		try {
			studentDao.findStudentByName(student);
		} catch (DaoException e) {
			throw new ServiceException("ѧ�����ҷ����쳣", e);
		}
	}
	

}
