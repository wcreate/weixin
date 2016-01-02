package com.karuite.dao;

import java.util.List;

import com.karuite.entity.TdConsult;

public interface TdConsultDao extends baseDao<TdConsult> {

	public List<TdConsult> findConsult(Class entityClass, String sql);
}
