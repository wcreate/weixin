package com.karuite.dao;

import java.util.List;

public interface baseDao<T> {

	public int insert(String sql, Object[] params);

	public int update(String sql, Object[] params);

	public T findFirst(Class<T> entityClass, String sql, Object[] params);

	public List<T> find(Class<T> entityClass, String sql, Object[] params);

	public List<T> findPage(Class<T> entityClass, String sql, int page,
			int pageSize, Object... params);
}
