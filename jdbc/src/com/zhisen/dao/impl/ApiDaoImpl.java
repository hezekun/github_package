package com.zhisen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zhisen.contants.ErrorCode;
import com.zhisen.contants.MsgCode;
import com.zhisen.dao.ApiDao;
import com.zhisen.dao.entity.Api;
import com.zhisen.dao.entity.Res;
import com.zhisen.dao.exception.DaoException;
import com.zhisen.dao.util.DaoUtil;

public class ApiDaoImpl implements ApiDao {

	@Override
	public boolean saveObject(Api object) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "insert into api values(tabApiSeq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, object.getResId());
			preparedStatement.setString(2, object.getApiMethod());
			preparedStatement.setString(3, object.getApiName());
			preparedStatement.setString(4, object.getApiPath());
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
			throw new DaoException(ErrorCode.SAVE_API_ERROR, MsgCode.MSG_SAVE_API_ERROR, e);
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
	public boolean dropObject(Api object) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "delete from Api where id=? and version =? ";
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
			throw new DaoException(ErrorCode.DROP_API_ERROR, MsgCode.MSG_DROP_API_ERROR, e);
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
	public boolean updateObject(Api object) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "update api set resId=?,apiMethod=?,apiName=?,apiPath=?,"
					+ "modifierCode=?,modifierName=?,modifyTime=?,isDel=? ,version=version+1"
					+ "  where id=? and version = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, object.getResId());
			preparedStatement.setString(2, object.getApiMethod());
			preparedStatement.setString(3, object.getApiName());
			preparedStatement.setString(4, object.getApiPath());
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
			throw new DaoException(ErrorCode.UPDATE_API_ERROR, MsgCode.MSG_UPDATE_API_ERROR, e);
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
	public Api findObjectById(int id) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			connection = DaoUtil.getDBConnection();
			String sql = "select id,resId,apiMethod,apiName,apiPath,modifierCode,modifierName,"
					+ "modifyTime,createUserCode,createUserName,createTime,version,isDel FROM API " + "where id=?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			if (result.next()) {
				Api api = new Api();
				api.setId(id);
				api.setResId(result.getInt("resId"));
				api.setApiMethod(result.getString("apiMethod"));
				api.setApiName(result.getString("apiName"));
				api.setApiPath(result.getString("apiPath"));
				api.setUpdateUserCode(result.getString("modifierCode"));
				api.setUpdateUserName(result.getString("modifierName"));
				api.setUpdateDate(result.getDate("modifyTime"));
				api.setCreateUserCode(result.getString("createUserCode"));
				api.setCreateUserName(result.getString("createUserName"));
				api.setCreateDate(result.getDate("createTime"));
				api.setVersion(result.getInt("version"));
				api.setDel(result.getInt("isDel") == 1 ? true : false);
				return api;

			} else {
				return null;
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.ID_SELECT_API_ERROR, MsgCode.MSG_ID_SELECT_API_ERROR, e);
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
	public List<Api> findAllObject() throws DaoException{
		List<Api> resultList =new ArrayList<Api>();
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet result = null;
		try {
			connection = DaoUtil.getDBConnection();
			String sql = "select id,resId,apiMethod,apiName,apiPath,modifierCode,modifierName,"
					+ "modifyTime,createUserCode,createUserName,createTime,version,isDel FROM API " + "where isDel=0";

			preparedStatement = connection.createStatement();
			result = preparedStatement.executeQuery(sql);
			while(result.next()) {
				Api api = new Api();
				api.setId(result.getInt("id"));
				api.setResId(result.getInt("resId"));
				api.setApiMethod(result.getString("apiMethod"));
				api.setApiName(result.getString("apiName"));
				api.setApiPath(result.getString("apiPath"));
				api.setUpdateUserCode(result.getString("modifierCode"));
				api.setUpdateUserName(result.getString("modifierName"));
				api.setUpdateDate(result.getDate("modifyTime"));
				api.setCreateUserCode(result.getString("createUserCode"));
				api.setCreateUserName(result.getString("createUserName"));
				api.setCreateDate(result.getDate("createTime"));
				api.setVersion(result.getInt("version"));
				api.setDel(result.getInt("isDel") == 1 ? true : false);
				resultList.add(api);
				 
			} 

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.SELECT_API_ERROR, MsgCode.MSG_SELECT_API_ERROR, e);
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
	public List<Api> findApiByResId(Res res) throws DaoException{
		List<Api> resultList = new ArrayList<Api>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			connection = DaoUtil.getDBConnection();
			String sql = "select id,resId,apiMethod,apiName,apiPath,modifierCode,modifierName,"
					+ "modifyTime,createUserCode,createUserName,createTime,version,isDel FROM API " + "where resId=?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, res.getId());
			result = preparedStatement.executeQuery();
			if (result.next()) {
				Api api = new Api();
				api.setResId(result.getInt("resId"));
				api.setApiMethod(result.getString("apiMethod"));
				api.setApiName(result.getString("apiName"));
				api.setApiPath(result.getString("apiPath"));
				api.setUpdateUserCode(result.getString("modifierCode"));
				api.setUpdateUserName(result.getString("modifierName"));
				api.setUpdateDate(result.getDate("modifyTime"));
				api.setCreateUserCode(result.getString("createUserCode"));
				api.setCreateUserName(result.getString("createUserName"));
				api.setCreateDate(result.getDate("createTime"));
				api.setVersion(result.getInt("version"));
				api.setDel(result.getInt("isDel") == 1 ? true : false);
				api.setRes(res);
				resultList.add(api);

			} else {
				return null;
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.ID_SELECT_API_ERROR, MsgCode.MSG_ID_SELECT_API_ERROR, e);
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
		return null;
	}


	
	
	
	

}
