package com.zhisen.spring_test1.dao.factory;

import com.zhisen.spring_test1.dao.entity.Student;

public class StudentFactory {
	
	public static Student getStudent() {
		System.out.println("工厂类被调用");
		return new Student();
	}
	
	public Student getStu() {
		System.out.println("不用静态方法调用");
		return new Student();
	}
}
