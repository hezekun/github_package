package com.zhisen.dao.exception;

public class DaoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dbErrorCode;
	public DaoException(String dbErrorCode, String message, Throwable cause) {
		super(message, cause);
		this.dbErrorCode = dbErrorCode;
	}

	public DaoException(String dbErrorCode, String message) {
		super(message);
		this.dbErrorCode = dbErrorCode;
	}

	public String getDbErrorCode() {
		return dbErrorCode;
	}

	
	
}
