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
import com.zhisen.dao.ServiceDao;
import com.zhisen.dao.entity.Api;
import com.zhisen.dao.entity.Service;
import com.zhisen.dao.exception.DaoException;
import com.zhisen.dao.util.DaoUtil;

public class ServiceDaoImpl implements ServiceDao{

	@Override
	public boolean saveObject(Service object) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "insert into service values(tabServiceSeq.nextval,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, object.getServiceCode());
			preparedStatement.setString(2, object.getServiceName());
			preparedStatement.setString(3, object.getUpdateUserCode());
			preparedStatement.setString(4, object.getUpdateUserName());
			preparedStatement.setDate(5, object.getUpdateDate());
			preparedStatement.setString(6, object.getCreateUserName());
			preparedStatement.setString(7, object.getCreateUserCode());
			preparedStatement.setDate(8, object.getCreateDate());
			preparedStatement.setInt(9, object.getVersion());
			preparedStatement.setInt(10, object.isDel() ? 1 : 0);
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.SAVE_SERVICE_ERROR, MsgCode.MSG_SAVE_SERVICE_ERROR, e);
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
	public boolean dropObject(Service object) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "delete from service where id=? and version =? ";
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
			throw new DaoException(ErrorCode.DROP_SERVICE_ERROR, MsgCode.MSG_DROP_SERVICE_ERROR, e);
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
	public boolean updateObject(Service object) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DaoUtil.getDBConnection();
			String sql = "update service set serviceCode=?,serviceName=?,"
					+ "modifierCode=?,modifierName=?,modifyTime=?,isDel=? ,version=version+1"
					+ "  where id=? and version = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, object.getServiceCode());
			preparedStatement.setString(2, object.getCreateUserName());
			preparedStatement.setString(3, object.getUpdateUserCode());
			preparedStatement.setString(4, object.getUpdateUserName());
			preparedStatement.setDate(5, object.getUpdateDate());
			preparedStatement.setInt(6, object.isDel() ? 1 : 0);
			preparedStatement.setInt(7, object.getId());
			preparedStatement.setInt(8, object.getVersion());
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.UPDATE_SERVICE_ERROR, MsgCode.MSG_UPDATE_SERVICE_ERROR, e);
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
	public Service findObjectById(int id) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			connection = DaoUtil.getDBConnection();
			String sql = "select id,serviceCode,serviceName,modifierCode,modifierName,"
					+ "modifyTime,createUserCode,createUserName,createTime,version,isDel FROM service " + "where id=?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			if (result.next()) {
				Service service = new Service();
				service.setId(id);
				service.setServiceCode(result.getString("serviceCode"));
				service.setServiceName(result.getString("serviceName"));
				service.setUpdateUserCode(result.getString("modifierCode"));
				service.setUpdateUserName(result.getString("modifierName"));
				service.setUpdateDate(result.getDate("modifyTime"));
				service.setCreateUserCode(result.getString("createUserCode"));
				service.setCreateUserName(result.getString("createUserName"));
				service.setCreateDate(result.getDate("createTime"));
				service.setVersion(result.getInt("version"));
				service.setDel(result.getInt("isDel") == 1 ? true : false);
				return service;

			} else {
				return null;
			}

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.ID_SELECT_SERVICE_ERROR, MsgCode.MSG_ID_SELECT_SERVICE_ERROR, e);
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
	public List<Service> findAllObject() throws DaoException {
		List<Service> resultList =new ArrayList<Service>();
		Connection connection = null;
		Statement preparedStatement = null;
		ResultSet result = null;
		try {
			connection = DaoUtil.getDBConnection();
			String sql = "select id,serviceCode,serviceName,modifierCode,modifierName,"
					+ "modifyTime,createUserCode,createUserName,createTime,version,isDel FROM service " + "where isDel=0";

			preparedStatement = connection.createStatement();
			result = preparedStatement.executeQuery(sql);
			while(result.next()) {
				Service service = new Service();
				service.setId(result.getInt("id"));
				service.setServiceCode(result.getString("serviceCode"));
				service.setServiceName(result.getString("serviceName"));
				service.setUpdateUserCode(result.getString("modifierCode"));
				service.setUpdateUserName(result.getString("modifierName"));
				service.setUpdateDate(result.getDate("modifyTime"));
				service.setCreateUserCode(result.getString("createUserCode"));
				service.setCreateUserName(result.getString("createUserName"));
				service.setCreateDate(result.getDate("createTime"));
				service.setVersion(result.getInt("version"));
				service.setDel(result.getInt("isDel") == 1 ? true : false);
				resultList.add(service);
				 
			} 

		} catch (DaoException | SQLException e) {
			throw new DaoException(ErrorCode.SELECT_SERVICE_ERROR, MsgCode.MSG_SELECT_SERVICE_ERROR, e);
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
