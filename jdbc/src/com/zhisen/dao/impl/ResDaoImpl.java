package com.zhisen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhisen.contants.ErrorCode;
import com.zhisen.contants.MsgCode;
import com.zhisen.dao.ResDao;
import com.zhisen.dao.entity.Api;
import com.zhisen.dao.entity.Res;
import com.zhisen.dao.exception.DaoException;
import com.zhisen.dao.factory.DaoFactory;
import com.zhisen.dao.util.DaoUtil;

public class ResDaoImpl implements ResDao{

	@Override
	public boolean saveObject(Res object) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "insert into res values(tabApiSeq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getCode());
			preparedStatement.setInt(3, object.getServiceId());
			preparedStatement.setString(4, object.getResType());
			preparedStatement.setString(5, object.getUpdateUserCode());
			preparedStatement.setString(6, object.getUpdateUserName());
			preparedStatement.setDate(7, object.getUpdateDate());
			preparedStatement.setString(8, object.getCreateUserName());
			preparedStatement.setString(9, object.getCreateUserCode());
			preparedStatement.setDate(10, object.getCreateDate());
			preparedStatement.setInt(11, object.getVersion());
			preparedStatement.setInt(12, object.isDel() ? 1 : 0);
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.SAVE_RES_ERROR, MsgCode.MSG_SAVE_RES_ERROR, e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public boolean dropObject(Res object) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "delete from res where id=? and version =? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, object.getId());
			preparedStatement.setInt(2, object.getVersion());
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.DROP_RES_ERROR, MsgCode.MSG_DROP_RES_ERROR, e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public boolean updateObject(Res object) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "update tab_res set name=?,code=?,serviceId=?,resType=?,"
					+ "modifierCode=?,modifierName=?,modifyTime=?,isDel=?,version=version+1" 
					+ " where id=? and version = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getCode());
			preparedStatement.setInt(3, object.getServiceId());
			preparedStatement.setString(4, object.getResType());
			preparedStatement.setString(5, object.getUpdateUserCode());
			preparedStatement.setString(6, object.getUpdateUserName());
			preparedStatement.setDate(7, object.getUpdateDate());
			preparedStatement.setInt(8, object.isDel() ? 1 : 0);
			preparedStatement.setInt(9, object.getId());
			preparedStatement.setInt(10, object.getVersion());
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.UPDATE_RES_ERROR, MsgCode.MSG_UPDATE_RES_ERROR, e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public Res findObjectById(int id) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			connection = DaoUtil.getDBConnection();
			String sql = "select id as res_id ,name as res_name,code as res_code,"
					+ "serviceId as res_serviceId,resType as res_resType,modifierCode as res_modifierCode,"
					+ "modifierName as res_modifierName,modifyTime as res_modifyTime,"
					+ "createUserCode as res_createUserCode,createUserName as res_createUserName,"
					+ "createTime as res_createTime,version as res_version,isDel as res_isDel"
					+ " FROM res" + "where id=?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			if (result.next()) {
				Res res=new Res();
				res.setId(result.getInt("res_id"));
				res.setName(result.getString("res_name"));                                           
				res.setCode(result.getString("res_code"));
				res.setServiceId(result.getInt("res_serviceId"));
				res.setResType(result.getString("res_resType"));
				res.setUpdateUserCode(result.getString("res_modifierCode"));
				res.setUpdateUserName(result.getString("res_modifierName"));
				res.setUpdateDate(result.getDate("res_modifyTime"));
				res.setCreateUserCode(result.getString("res_createUserCode"));
				res.setCreateUserName(result.getString("res_createUserName"));
				res.setCreateDate(result.getDate("res_createTime"));
				res.setVersion(result.getInt("res_version"));
				res.setDel(result.getInt("res_isDel") == 1 ? true : false);
				List<Api> apis= DaoFactory.getApiDao().findApiByResId(res);
				res.setApis(apis);
				return res;

			} else {
				return null;
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.ID_SELECT_RES_ERROR, MsgCode.MSG_ID_SELECT_RES_ERROR, e);
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public List<Res> findAllObject() throws DaoException{
		List<Res> resultList =new ArrayList<Res>();
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet result = null;
		try {
			connection = DaoUtil.getDBConnection();
			String sql = "select id ,name,code,serviceId,resType,modifierCode,modifierName,"
					+ "modifyTime,createUserCode,createUserName,createTime,version,isDel FROM res" 
					+ " where isDel=0";

			preparedStatement = connection.createStatement();
			result = preparedStatement.executeQuery(sql);
			while(result.next()) {
				Res res=new Res();
				res.setId(result.getInt("id"));
				res.setName(result.getString("name"));
				res.setCode(result.getString("code"));
				res.setServiceId(result.getInt("serviceId"));
				res.setResType(result.getString("resType"));
				res.setUpdateUserCode(result.getString("modifierCode"));
				res.setUpdateUserName(result.getString("modifierName"));
				res.setUpdateDate(result.getDate("modifyTime"));
				res.setCreateUserCode(result.getString("createUserCode"));
				res.setCreateUserName(result.getString("createUserName"));
				res.setCreateDate(result.getDate("createTime"));
				res.setVersion(result.getInt("version"));
				res.setDel(result.getInt("isDel") == 1 ? true : false);
				resultList.add(res);
				 
			} 

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.SELECT_RES_ERROR, MsgCode.MSG_SELECT_RES_ERROR, e);
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return resultList;
	}

	@Override
	public List<Map<String, Object>> findResAndApiByResId(int id) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "select " + "res.id               as res_id, " + "res.name             as res_name, "
					+ "res.code             as res_code, " + "res.serviceId        as res_serviceId, "
					+ "res.resType          as res_resType, " + "res.modifierCode     as res_modifierCode, "
					+ "res.modifierName     as res_modifierName, " + "res.modifyTime       as res_modifyTime, "
					+ "res.createUserCode   as res_createUserCode, " + "res.createUserName   as res_createUserName, "
					+ "res.createTime       as res_createTime, " + "res.version          as res_version, "
					+ "res.isDel            as res_isDel, " + "api.id               as api_id, "
					+ "api.resId            as api_resId, " + "api.apiMethod        as api_apiMethod, "
					+ "api.apiName          as api_apiName, " + "api.apiPath          as api_apiPath, "
					+ "api.modifierCode     as api_modifierCode, " + "api.modifierName     as api_modiferName, "
					+ "api.modifyTime       as api_modifyTime, " + "api.createUserCode   as api_createUserCode, "
					+ "api.createUserName   as api_createUserName, " + "api.createTime       as api_createTime, "
					+ "api.version          as api_version, " + "api.isDel            as api_isDel " + "from res "
					+ "join api " + "on res.id  = api.resId " 
					+ " where res.isDel  = 0 and api.isDel =0 and res.id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Map<String, Object> columnObject = new HashMap<String, Object>();
				columnObject.put("res_id", resultSet.getInt("res_id"));
				columnObject.put("res_name", resultSet.getString("res_name"));
				columnObject.put("res_code", resultSet.getString("res_code"));
				columnObject.put("res_serviceId", resultSet.getInt("res_serviceId"));
				columnObject.put("res_resType", resultSet.getString("res_resType"));
				columnObject.put("res_modifierCode", resultSet.getString("res_modifierCode"));
				columnObject.put("res_modifierName", resultSet.getString("res_modifierName"));
				columnObject.put("res_modifyTime", resultSet.getDate("res_modifyTime"));
				columnObject.put("res_createUserCode", resultSet.getString("res_createUserCode"));
				columnObject.put("res_createUserName", resultSet.getString("res_createUserName"));
				columnObject.put("res_createTime", resultSet.getString("res_createTime"));
				columnObject.put("res_version", resultSet.getInt("res_version"));
				columnObject.put("res_isDel", resultSet.getInt("res_isDel"));
				columnObject.put("api_id", resultSet.getInt("api_id"));
				columnObject.put("api_resId", resultSet.getInt("api_resId"));
				columnObject.put("api_apiMethod", resultSet.getString("api_apiMethod"));
				columnObject.put("api_apiName", resultSet.getString("api_apiName"));
				columnObject.put("api_apiPath", resultSet.getString("api_apiPath"));
				columnObject.put("api_modifierCode", resultSet.getString("api_modifierCode"));
				columnObject.put("api_modifierName", resultSet.getString("api_modifierName"));
				columnObject.put("api_modifyTime", resultSet.getDate("api_modifyTime"));
				columnObject.put("api_createUserCode", resultSet.getString("api_createUserCode"));
				columnObject.put("api_createUserName", resultSet.getString("api_createUserName"));
				columnObject.put("api_createTime", resultSet.getString("api_createTime"));
				columnObject.put("api_version", resultSet.getInt("api_version"));
				columnObject.put("api_isDel", resultSet.getInt("api_isDel"));
				result.add(columnObject);

			}

		} catch (DaoException e) {
			throw e;

		} catch (SQLException e) {
			throw new DaoException(ErrorCode.SELECT_RES_API_ERROR, MsgCode.MSG_SELECT_RES_API_ERROR, e);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;


	}

	
}
