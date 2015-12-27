package com.karuite.service;

import java.util.List;

import com.karuite.entity.TdConsult;

public interface TdConsultService {

	// 查询所有咨询师
	public List<TdConsult> findConsult(Class entityClass, String sql);
	

}
