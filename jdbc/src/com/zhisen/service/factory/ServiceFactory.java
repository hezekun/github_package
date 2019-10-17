package com.zhisen.service.factory;

import com.zhisen.service.StudentService;
import com.zhisen.service.impl.StudentServiceImpl;

public class ServiceFactory {

	public static StudentService getStudentService() {
		return new StudentServiceImpl();
	}
}
