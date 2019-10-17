package com.zhisen.dao.entity;

import java.sql.Date;

public class Action extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private int type;
	
	private String content;
	
	private String icon;
	
	private String aClass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getaClass() {
		return aClass;
	}

	public void setaClass(String aClass) {
		this.aClass = aClass;
	}

	public Action(int id, String createUserName, String createUserCode, Date createDate, String updateUserName,
			String updateUserCode, Date updateDate, boolean isDel, int version, String name, int type, String content,
			String icon, String aClass) {
		super(id, createUserName, createUserCode, createDate, updateUserName, updateUserCode, updateDate, isDel,
				version);
		this.name = name;
		this.type = type;
		this.content = content;
		this.icon = icon;
		this.aClass = aClass;
	}

	public Action() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Action(int id, String createUserName, String createUserCode, Date createDate, String updateUserName,
			String updateUserCode, Date updateDate, boolean isDel, int version) {
		super(id, createUserName, createUserCode, createDate, updateUserName, updateUserCode, updateDate, isDel, version);
		// TODO Auto-generated constructor stub
	}
	
	
}
