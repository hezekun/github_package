package com.zhisen.dao.entity;

import java.sql.Date;
import java.util.List;

public class Res extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String code;
	
	private int serviceId;
	
	private String resType;
	
	private List<Api> apis;

	
	

	public List<Api> getApis() {
		return apis;
	}

	public void setApis(List<Api> apis) {
		this.apis = apis;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public Res() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Res(int id, String createUserName, String createUserCode, Date createDate, String updateUserName,
			String updateUserCode, Date updateDate, boolean isDel, int version) {
		super(id, createUserName, createUserCode, createDate, updateUserName, updateUserCode, updateDate, isDel, version);
		// TODO Auto-generated constructor stub
	}

	public Res(int id, String createUserName, String createUserCode, Date createDate, String updateUserName,
			String updateUserCode, Date updateDate, boolean isDel, int version, String name, String code, int serviceId,
			String resType) {
		super(id, createUserName, createUserCode, createDate, updateUserName, updateUserCode, updateDate, isDel,
				version);
		this.name = name;
		this.code = code;
		this.serviceId = serviceId;
		this.resType = resType;
	}
	
	
}
