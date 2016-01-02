package com.karuite.service;

import java.util.List;

import com.karuite.entity.TdConsult;
import com.karuite.service.impl.baseServiceImpl;

public interface TdConsultService extends baseService<TdConsult> {

	// 查询所有咨询师
	public List<TdConsult> findConsult(Class entityClass, String sql);
	

}
