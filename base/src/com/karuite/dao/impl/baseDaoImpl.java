package com.karuite.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.karuite.dao.baseDao;
import com.karuite.db.DBUtilsTemplate;

public class baseDaoImpl<T> implements baseDao<T> {

	private static final Logger logger = Logger.getLogger(baseDaoImpl.class);
	
	@Autowired
    @Qualifier("dbutilsTemplate")
    private DBUtilsTemplate dbutilsTemplate;
	
	@Override
	public int insert(String sql, Object[] params)
	{
		return dbutilsTemplate.insert(sql, params);
	}

	@Override
	public int update(String sql, Object[] params)
	{
		return dbutilsTemplate.update(sql, params);
	}

	@Override
	public T findFirst(Class<T> entityClass, String sql, Object[] params)
	{
		return dbutilsTemplate.findFirst(entityClass, sql, params);
	}

	@Override
	public List<T> find(Class<T> entityClass, String sql, Object[] params)
	{
		return dbutilsTemplate.find(entityClass, sql, params);
	}

	@Override
	public List<T> findPage(Class<T> entityClass, String sql, int page,
			int pageSize, Object... params)
	{
		return dbutilsTemplate.findPage(entityClass, sql, page, pageSize, params);
	}
	
}
