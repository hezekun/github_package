package com.zhisen.zy.dao;

import java.util.List;
import java.util.Map;

public interface StudentDao {

	List<Map<String,Object>> findAllStudent();
	
	List<Map<String,Object>> findStudentByName();
	int saveStudent(Map<String,Object> student);
	int updateStudent(Map<String,Object> student);
}
