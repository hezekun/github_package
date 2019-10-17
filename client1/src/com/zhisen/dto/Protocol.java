package com.zhisen.dto;

import java.io.Serializable;

public class Protocol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chatString;
	
	public Protocol(String charString) {
		super();
		this.chatString = charString;
	}
	
	public Protocol() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getChatString() {
		return chatString;
	}
	
	public void setChatString(String chatString) {
		this.chatString = chatString;
	}
	
	
	
}
