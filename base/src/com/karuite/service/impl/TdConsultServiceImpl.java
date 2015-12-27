package com.karuite.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karuite.dao.TdConsultDao;
import com.karuite.entity.TdConsult;
import com.karuite.service.TdConsultService;

@Service
@Transactional
public class TdConsultServiceImpl implements TdConsultService {

	@Autowired
    private TdConsultDao tdConsultDao;
	
	public List<TdConsult> findConsult(Class entityClass, String sql) {
		return tdConsultDao.findConsult(entityClass, sql);
	}
	

}
