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
import com.zhisen.dao.PermissionDao;
import com.zhisen.dao.entity.Api;
import com.zhisen.dao.entity.Permission;
import com.zhisen.dao.exception.DaoException;
import com.zhisen.dao.util.DaoUtil;

public class PermissionDaoImpl implements PermissionDao{

	@Override
	public boolean saveObject(Permission object) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "insert into permission values(tabPermissionSeq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setInt(2, object.getObjId());
			preparedStatement.setInt(3, object.getActionId());
			preparedStatement.setString(4, object.getDescription());
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
			throw new DaoException(ErrorCode.SAVE_PERMISSION_ERROR, MsgCode.MSG_SAVE_PERMISSION_ERROR, e);
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
	public boolean dropObject(Permission object) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "delete from permission where id=? and version =? ";
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
			throw new DaoException(ErrorCode.DROP_PERMISSION_ERROR, MsgCode.MSG_DROP_PERMISSION_ERROR, e);
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
	public boolean updateObject(Permission object) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "update permission set name=?,objId=?,actionId=?,description=?,"
					+ "modifierCode=?,modifierName=?,modifyTime=?,isDel=?,version=version+1 " + 
					"where id=? and version = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setInt(2, object.getObjId());
			preparedStatement.setInt(3, object.getActionId());
			preparedStatement.setString(4, object.getDescription());
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
			throw new DaoException(ErrorCode.UPDATE_PERMISSION_ERROR, MsgCode.MSG_UPDATE_PERMISSION_ERROR, e);
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
	public Permission findObjectById(int id) throws DaoException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			connection = DaoUtil.getDBConnection();
			String sql = "select id,name,objId,actionId,description,modifierCode,modifierName,"
					+ "modifyTime,createUserCode,createUserName,createTime,version,isDel FROM permission " 
					+ "where id=?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				Permission permission = new Permission();
				permission.setId(id);
				permission.setName(result.getString("name"));
				permission.setObjId(result.getInt("objId"));
				permission.setActionId(result.getInt("ActionId"));
				permission.setDescription(result.getString("description"));
				permission.setUpdateUserCode(result.getString("modifierCode"));
				permission.setUpdateUserName(result.getString("modifierName"));
				permission.setUpdateDate(result.getDate("modifyTime"));
				permission.setCreateUserCode(result.getString("createUserCode"));
				permission.setCreateUserName(result.getString("createUserName"));
				permission.setCreateDate(result.getDate("createTime"));
				permission.setVersion(result.getInt("version"));
				permission.setDel(result.getInt("isDel") == 1 ? true : false);
				return permission;

			} 

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.ID_SELECT_PERMISSION_ERROR, MsgCode.MSG_ID_SELECT_PERMISSION_ERROR, e);
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

	@Override
	public List<Permission> findAllObject() throws DaoException{
		List<Permission> resultList =new ArrayList<Permission>();
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet result = null;
		try {
			connection = DaoUtil.getDBConnection();
			String sql = "select id,name,objId,actionId,description,modifierCode,modifierName,"
					+ "modifyTime,createUserCode,createUserName,createTime,version,isDel FROM permission" 
					+ " where isDel=0";

			preparedStatement = connection.createStatement();
			result = preparedStatement.executeQuery(sql);
			while(result.next()) {
				Permission permission = new Permission();
				permission.setId(result.getInt("id"));
				permission.setName(result.getString("name"));
				permission.setObjId(result.getInt("objId"));
				permission.setActionId(result.getInt("actionId"));
				permission.setDescription(result.getString("description"));
				permission.setUpdateUserCode(result.getString("modifierCode"));
				permission.setUpdateUserName(result.getString("modifierName"));
				permission.setUpdateDate(result.getDate("modifyTime"));
				permission.setCreateUserCode(result.getString("createUserCode"));
				permission.setCreateUserName(result.getString("createUserName"));
				permission.setCreateDate(result.getDate("createTime"));
				permission.setVersion(result.getInt("version"));
				permission.setDel(result.getInt("isDel") == 1 ? true : false);
				resultList.add(permission);
				 
			} 

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.SELECT_PERMISSION_ERROR, MsgCode.MSG_SELECT_PERMISSION_ERROR, e);
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

	
}
