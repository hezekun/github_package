package com.zhisen.spring_test1.dao.entity;

public class Subject {

	private int id;
	private String subname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public Subject(int id, String subname) {
		super();
		this.id = id;
		this.subname = subname;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

}
