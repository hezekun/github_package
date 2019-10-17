package com.zhisen.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zhisen.contants.ErrorCode;
import com.zhisen.contants.MsgCode;
import com.zhisen.dao.exception.DaoException;

public class DaoUtil {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //����������,д�ھ�̬����,ÿ����������һ��
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getDBConnection() throws DaoException{
		try {
			Connection connection=
					DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.2:11521:xe", 
							"hezekun", "123456");//���ݿ�����
			return connection;
		} catch (SQLException e) {
			throw new DaoException(ErrorCode.NO_SUPPORT_DB_DRIVER, MsgCode.MSG_NOT_SUPPORT_DB_DRIVER,e);
		}
		
	}
}
