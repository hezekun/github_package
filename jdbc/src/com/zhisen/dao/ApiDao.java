package com.zhisen.dao;

import java.util.List;

import com.zhisen.dao.entity.Api;
import com.zhisen.dao.entity.Res;
import com.zhisen.dao.exception.DaoException;

public interface ApiDao extends BaseDao<Api>{

	List<Api> findApiByResId(Res res) throws DaoException;
}
