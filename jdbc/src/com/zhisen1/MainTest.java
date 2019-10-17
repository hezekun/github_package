package com.zhisen1;

import java.sql.Date;
import java.util.List;

import com.zhisen.dao.entity.Api;
import com.zhisen.dao.entity.Permission;
import com.zhisen.dao.exception.DaoException;
import com.zhisen.dao.factory.DaoFactory;

public class MainTest {

	public static void main(String[] args) {
		Api api1 =new Api(1, "createUserName", "createUserCode", new Date(System.currentTimeMillis()), "updateUserName", 
				"updateUserCode", new Date(System.currentTimeMillis()), false, 1, 1, "apiMethod", "apiName", "apiPath");
		Api api2 =new Api(3, "createUserName", "createUserCode", new Date(System.currentTimeMillis()), "updateUserName更改", 
				"updateUserCode更改", new Date(System.currentTimeMillis()), false, 5, 2, "apiMethod", "apiName", "apiPath");
		Permission permission1 = new Permission(1, "createUserName", "createUserCode", new Date(System.currentTimeMillis()), "updateUserName", 
				"updateUserCode", new Date(System.currentTimeMillis()), false, 0, "权限名1", 1, 20, "description");		
		Permission permission2 = new Permission(3, "createUserName1", "createUserCode", new Date(System.currentTimeMillis()), "updateUserName更改", 
				"updateUserCode更改", new Date(System.currentTimeMillis()), false, 0, "权限1", 1, 21, "使用000");
		
		try {
			//boolean result1=DaoFactory.getApiDao().saveObject(api2);   //增
			//boolean result2=DaoFactory.getApiDao().dropObject(api2);	//删
			//boolean result3=DaoFactory.getApiDao().updateObject(api1); //改
			//System.out.println(result3);
			//Api api0=DaoFactory.getApiDao().findObjectById(api2.getId()); //通过id查询
			//System.out.println(api0.getUpdateUserCode()+api0.getUpdateDate());
			//List<Api> resultList = DaoFactory.getApiDao().findAllObject();  //查询所有
			//for (Api a:resultList) {
			//	System.out.println(a.getId());
			//}
			
			//boolean result1=DaoFactory.getPermissionDao().saveObject(permission2);   //增
			//boolean result2=DaoFactory.getPermissionDao().dropObject(permission2);	//删
			//boolean result3=DaoFactory.getPermissionDao().updateObject(permission2); //改
			//System.out.println(result3);
			//Permission permission0=DaoFactory.getPermissionDao().findObjectById(permission1.getId()); //通过id查询
			//System.out.println(permission0.getUpdateUserCode()+permission0.getUpdateDate());
			List<Permission> resultList = DaoFactory.getPermissionDao().findAllObject();  //查询所有
			for (Permission a:resultList) {
				System.out.println(a.getId());
			}
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
