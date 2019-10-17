package com.zhisen.dao;

import java.util.List;
import java.util.Map;

import com.zhisen.dao.entity.Res;
import com.zhisen.dao.exception.DaoException;

public interface ResDao extends BaseDao<Res>{
	public List<Map<String, Object>> findResAndApiByResId(int id) throws DaoException;
}
