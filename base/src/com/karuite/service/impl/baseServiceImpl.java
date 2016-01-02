package com.karuite.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karuite.dao.baseDao;
import com.karuite.service.baseService;

@Service
@Transactional
public class baseServiceImpl<T> implements baseService<T> {

	private static final Logger logger = Logger.getLogger(baseServiceImpl.class);
	
	@Autowired
    private baseDao baseDao ;
	
	@Override
	public int insert(String sql, Object[] params)
	{
		return baseDao.insert(sql, params);
	}

	@Override
	public int update(String sql, Object[] params)
	{
		return baseDao.update(sql, params);
	}

	@Override
	public T findFirst(Class<T> entityClass, String sql, Object[] params)
	{
		return (T) baseDao.findFirst(entityClass, sql, params);
	}

	@Override
	public List<T> find(Class<T> entityClass, String sql, Object[] params)
	{
		return baseDao.find(entityClass, sql, params);
	}

	@Override
	public List<T> findPage(Class<T> entityClass, String sql, int page,
			int pageSize, Object... params)
	{
		return baseDao.findPage(entityClass, sql, page, pageSize, params);
	}

}
