package com.zhisen.spring_test1.dao.entity;

public class DBConfig {

	private String userName;
	
	private String password;
	
	private String jdbcDriver;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public DBConfig(String userName, String password, String jdbcDriver) {
		super();
		this.userName = userName;
		this.password = password;
		this.jdbcDriver = jdbcDriver;
	}

	public DBConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
