package com.karuite.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.karuite.dao.TdConsultDao;
import com.karuite.db.DBUtilsTemplate;
import com.karuite.entity.TdConsult;

@Repository
public class TdConsultDaoImpl implements TdConsultDao {

	private static final Logger logger = Logger.getLogger(TdConsultDaoImpl.class);
	
	@Autowired
    @Qualifier("dbutilsTemplate")
    private DBUtilsTemplate dbutilsTemplate;
	
	@Override
	public List<TdConsult> findConsult(Class entityClass, String sql)
	{	
		return dbutilsTemplate.find(entityClass, sql, null); 
	}

}
