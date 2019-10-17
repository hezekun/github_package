package com.zhisen.spring_test1.dao.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.zhisen.spring_test1.dao.StudentDao;

public class Student {

	private int id;

	private String name;

	private List<String> list;
	
	private Subject subject;
	
	private StudentDao studentDao;
	
	private Set<String> sets;

	private Map<String,Object> maps;
	
	private Properties properties;
	
	private List<Subject> ls;
	
	private Map<String,Subject> m;
	
	private List<Map<String,Subject>> listMap;
	
	private Map<Subject,String> omap;
	
	
	
	public Map<Subject, String> getOmap() {
		return omap;
	}

	public void setOmap(Map<Subject, String> omap) {
		this.omap = omap;
	}

	public List<Map<String, Subject>> getListMap() {
		return listMap;
	}

	public void setListMap(List<Map<String, Subject>> listMap) {
		this.listMap = listMap;
	}

	public Map<String, Subject> getM() {
		return m;
	}

	public void setM(Map<String, Subject> m) {
		this.m = m;
	}

	public List<Subject> getLs() {
		return ls;
	}

	public void setLs(List<Subject> ls) {
		this.ls = ls;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	public Set<String> getSets() {
		return sets;
	}

	public void setSets(Set<String> sets) {
		this.sets = sets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	
	

	
	

	
	public Student(int id, String name, List<String> list, Subject subject, StudentDao studentDao, Set<String> sets,
			Map<String, Object> maps, Properties properties) {
		super();
		this.id = id;
		this.name = name;
		this.list = list;
		this.subject = subject;
		this.studentDao = studentDao;
		this.sets = sets;
		this.maps = maps;
		this.properties = properties;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
