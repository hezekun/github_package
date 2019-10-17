package com.zhisen.spring_test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhisen.spring_test1.dao.entity.DBConfig;
import com.zhisen.spring_test1.dao.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
		Student s = (Student) context.getBean("myStudent");
		//Student s1 = (Student) context.getBean("myStudent1");
		// s.setName("zhang");
//        System.out.println(s1);
//        System.out.println(s1.getId());
//        System.out.println(s1.getName());
//		System.out.println(s);
//		System.out.println(s.getList());
//		System.out.println(s.getSubject());
//		s.getSubject().setSubname("天文");
//		System.out.println(s1.getSubject());
//		System.out.println(s.getSubject().getSubname());
//		System.out.println(s1.getSubject().getSubname());
		s.getStudentDao().show();//通过接口注入实现类,不用写工厂类了
		System.out.println(s.getSets());
		System.out.println(s.getMaps());
		System.out.println(s.getProperties());
		System.out.println(s.getLs().get(0).getSubname());
		System.out.println(s.getM().get("student1").getSubname());
		System.out.println(s.getOmap());
		Student sf =  (Student) context.getBean("getMyStudent");
		System.out.println(sf);
		Student sf1 =  (Student) context.getBean("myStudent2");
		System.out.println(sf1);
		
		DBConfig config= (DBConfig) context.getBean("dbConfig");
		System.out.println(config.getJdbcDriver());
		System.out.println(config.getPassword());
		System.out.println(config.getUserName());
	}
}
