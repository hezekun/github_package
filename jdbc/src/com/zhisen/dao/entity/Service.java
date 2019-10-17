package com.zhisen.dao.entity;

import java.sql.Date;

public class Service extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String serviceCode;
	
	private String serviceName;

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service(int id, String createUserName, String createUserCode, Date createDate, String updateUserName,
			String updateUserCode, Date updateDate, boolean isDel, int version) {
		super(id, createUserName, createUserCode, createDate, updateUserName, updateUserCode, updateDate, isDel, version);
		// TODO Auto-generated constructor stub
	}

	public Service(int id, String createUserName, String createUserCode, Date createDate, String updateUserName,
			String updateUserCode, Date updateDate, boolean isDel, int version, String serviceCode,
			String serviceName) {
		super(id, createUserName, createUserCode, createDate, updateUserName, updateUserCode, updateDate, isDel,
				version);
		this.serviceCode = serviceCode;
		this.serviceName = serviceName;
	}
	
	
	
}
