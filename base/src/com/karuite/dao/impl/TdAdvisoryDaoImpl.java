package com.karuite.dao.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.karuite.dao.TdAdvisoryDao;
import com.karuite.db.DBUtilsTemplate;
import com.karuite.util.StringUtil;

@Repository
public class TdAdvisoryDaoImpl implements TdAdvisoryDao {

	private static final Logger logger = Logger.getLogger(TdAdvisoryDaoImpl.class);
	
	@Autowired
    @Qualifier("dbutilsTemplate")
    private DBUtilsTemplate dbutilsTemplate;
	
	@Override
	public int addAdvisory(String advisory[]) {
		
		 String sql = "insert into tbl_advisoryJoin(id,businessBackground,successfulCase,excelField,contactInformation,createDate) values(?,?,?,?,?,?)";
		 Object params[] = {StringUtil.getStr32(), advisory[0], advisory[1], advisory[2], advisory[3], new Date()};
		 int totalRows =  dbutilsTemplate.insert(sql, params);
		 
		 return totalRows;

	}

}
