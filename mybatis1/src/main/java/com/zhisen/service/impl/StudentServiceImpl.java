package com.zhisen.service.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.zhisen.service.StudentService;
import com.zhisen.service.Exception.ServiceException;
import com.zhisen.service.util.ServiceUtil;
import com.zhisen.zy.dao.StudentDao;

public class StudentServiceImpl implements StudentService {

	@Override
	public int saveStudent(Map<String,Object> student) throws ServiceException{

		try(SqlSession session = ServiceUtil.getSession()){
			StudentDao mapper = session.getMapper(StudentDao.class);
			int result = mapper.saveStudent(student);
			session.commit();
			return result;
		}catch(Exception e) {
			throw new ServiceException("保存学生信息错误",e);
		}
	}

}
