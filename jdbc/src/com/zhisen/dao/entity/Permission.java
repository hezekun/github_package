package com.zhisen.dao.entity;

import java.sql.Date;

public class Permission extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private int objId;
	
	private int actionId;
	
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getObjId() {
		return objId;
	}

	public void setObjId(int objId) {
		this.objId = objId;
	}

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Permission(int id, String createUserName, String createUserCode, Date createDate, String updateUserName,
			String updateUserCode, Date updateDate, boolean isDel, int version, String name, int objId, int actionId,
			String description) {
		super(id, createUserName, createUserCode, createDate, updateUserName, updateUserCode, updateDate, isDel,
				version);
		this.name = name;
		this.objId = objId;
		this.actionId = actionId;
		this.description = description;
	}

	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Permission(int id, String createUserName, String createUserCode, Date createDate, String updateUserName,
			String updateUserCode, Date updateDate, boolean isDel, int version) {
		super(id, createUserName, createUserCode, createDate, updateUserName, updateUserCode, updateDate, isDel, version);
		// TODO Auto-generated constructor stub
	}
	
	
}
