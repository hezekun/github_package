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
import com.zhisen.dao.ActionDao;
import com.zhisen.dao.entity.Action;
import com.zhisen.dao.entity.Res;
import com.zhisen.dao.exception.DaoException;
import com.zhisen.dao.util.DaoUtil;

public class ActionDaoImpl implements ActionDao{

	@Override
	public boolean saveObject(Action object) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "insert into action values(tabActionSeq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setInt(2, object.getType());
			preparedStatement.setString(3, object.getContent());
			preparedStatement.setString(4, object.getIcon());
			preparedStatement.setString(5, object.getaClass());
			preparedStatement.setString(6, object.getUpdateUserCode());
			preparedStatement.setString(7, object.getUpdateUserName());
			preparedStatement.setDate(8, object.getUpdateDate());
			preparedStatement.setString(9, object.getCreateUserCode());
			preparedStatement.setString(10, object.getCreateUserName());
			preparedStatement.setDate(11, object.getCreateDate());
			preparedStatement.setInt(12, object.getVersion());
			preparedStatement.setInt(13, object.isDel() ? 1 : 0);
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.SAVE_ACTION_ERROR, MsgCode.MSG_SAVE_ACTION_ERROR, e);
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
	public boolean dropObject(Action object) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "delete from action where id=? and version =? ";
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
			throw new DaoException(ErrorCode.DROP_ACTION_ERROR, MsgCode.MSG_DROP_ACTION_ERROR, e);
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
	public boolean updateObject(Action object) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "update tab_action set name=?,type=?,content=?,icon=?,aClass=?"
					+ "modifierCode=?,modifierName=?,modifyTime=?,isDel=?,version=version+1" 
					+ " where id=? and version = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setInt(2, object.getType());
			preparedStatement.setString(3, object.getContent());
			preparedStatement.setString(4, object.getIcon());
			preparedStatement.setString(5, object.getaClass());
			preparedStatement.setString(6, object.getUpdateUserCode());
			preparedStatement.setString(7, object.getUpdateUserName());
			preparedStatement.setDate(8, object.getUpdateDate());
			preparedStatement.setInt(9, object.isDel() ? 1 : 0);
			preparedStatement.setInt(10, object.getId());
			preparedStatement.setInt(11, object.getVersion());
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.UPDATE_ACTION_ERROR, MsgCode.MSG_UPDATE_ACTION_ERROR, e);
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
	public Action findObjectById(int id) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			connection = DaoUtil.getDBConnection();
			String sql = "select id,name,type,content,icon,aClass,modifierCode,modifierName,"
					+ "modifyTime,createUserCode,createUserName,createTime,version,isDel FROM action" 
					+ " where id=?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			if (result.next()) {
				Action action=new Action();
				action.setId(id);
				action.setName(result.getString("name"));
				action.setType(result.getInt("type"));
				action.setContent(result.getString("content"));
				action.setIcon(result.getString("icon"));
				action.setaClass(result.getString("aClass"));
				action.setUpdateUserCode(result.getString("modifierCode"));
				action.setUpdateUserName(result.getString("modifierName"));
				action.setUpdateDate(result.getDate("modifyTime"));
				action.setCreateUserCode(result.getString("createUserCode"));
				action.setCreateUserName(result.getString("createUserName"));
				action.setCreateDate(result.getDate("createTime"));
				action.setVersion(result.getInt("version"));
				action.setDel(result.getInt("isDel") == 1 ? true : false);
				return action;

			} else {
				return null;
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.ID_SELECT_ACTION_ERROR, MsgCode.MSG_ID_SELECT_ACTION_ERROR, e);
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
	public List<Action> findAllObject() throws DaoException {
		List<Action> resultList =new ArrayList<Action>();
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet result = null;
		try {
			connection = DaoUtil.getDBConnection();
			String sql = "select id,name,type,content,icon,aClass,modifierCode,modifierName,"
					+ "modifyTime,createUserCode,createUserName,createTime,version,isDel FROM action" 
					+ " where isDel=0";

			preparedStatement = connection.createStatement();
			result = preparedStatement.executeQuery(sql);
			while(result.next()) {
				Action action=new Action();
				action.setId(result.getInt("id"));
				action.setName(result.getString("name"));
				action.setType(result.getInt("type"));
				action.setContent(result.getString("content"));
				action.setIcon(result.getString("icon"));
				action.setaClass(result.getString("aClass"));
				action.setUpdateUserCode(result.getString("modifierCode"));
				action.setUpdateUserName(result.getString("modifierName"));
				action.setUpdateDate(result.getDate("modifyTime"));
				action.setCreateUserCode(result.getString("createUserCode"));
				action.setCreateUserName(result.getString("createUserName"));
				action.setCreateDate(result.getDate("createTime"));
				action.setVersion(result.getInt("version"));
				action.setDel(result.getInt("isDel") == 1 ? true : false);
				resultList.add(action);
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.SELECT_ACTION_ERROR, MsgCode.MSG_SELECT_ACTION_ERROR, e);
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
