package com.zhisen.dao.entity;

import java.sql.Date;

public class Api extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int resId;
	
	private String apiMethod;
	
	private String apiName;
	
	private String apiPath;

	private Res res;
	
	
	
	public Res getRes() {
		return res;
	}

	public void setRes(Res res) {
		this.res = res;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getApiMethod() {
		return apiMethod;
	}

	public void setApiMethod(String apiMethod) {
		this.apiMethod = apiMethod;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	public Api() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Api(int id, String createUserName, String createUserCode, Date createDate, String updateUserName,
			String updateUserCode, Date updateDate, boolean isDel, int version) {
		super(id, createUserName, createUserCode, createDate, updateUserName, updateUserCode, updateDate, isDel, version);
		// TODO Auto-generated constructor stub
	}

	public Api(int id, String createUserName, String createUserCode, Date createDate, String updateUserName,
			String updateUserCode, Date updateDate, boolean isDel, int version, int resId, String apiMethod,
			String apiName, String apiPath) {
		super(id, createUserName, createUserCode, createDate, updateUserName, updateUserCode, updateDate, isDel,
				version);
		this.resId = resId;
		this.apiMethod = apiMethod;
		this.apiName = apiName;
		this.apiPath = apiPath;
	}
	
	
}
