package com.zhisen.dao.factory;

import com.zhisen.dao.ActionDao;
import com.zhisen.dao.ApiDao;
import com.zhisen.dao.PermissionDao;
import com.zhisen.dao.ResDao;
import com.zhisen.dao.impl.ActionDaoImpl;
import com.zhisen.dao.impl.ApiDaoImpl;
import com.zhisen.dao.impl.PermissionDaoImpl;
import com.zhisen.dao.impl.ResDaoImpl;

public class DaoFactory {
	
	public static ApiDao getApiDao() {
		return new ApiDaoImpl();
	}

	public static PermissionDao getPermissionDao() {
		return new ServiceDaoImpl();
	}
	
	public static ResDao getResDao() {
		return new ResDaoImpl();
	}
	
	public static ServiceDao getServiceDao() {
		return new ServiceResDaoImpl();
	}
	
	public static ActionDao getActionDao() {
		return new ActionDaoImpl();
	}
}
