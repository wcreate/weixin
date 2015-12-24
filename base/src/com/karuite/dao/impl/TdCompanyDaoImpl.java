package com.karuite.dao.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.karuite.dao.TdCompanyDao;
import com.karuite.db.DBUtilsTemplate;
import com.karuite.util.StringUtil;

@Repository
public class TdCompanyDaoImpl implements TdCompanyDao {

	private static final Logger logger = Logger.getLogger(TdCompanyDaoImpl.class);
	
	@Autowired
    @Qualifier("dbutilsTemplate")
    private DBUtilsTemplate dbutilsTemplate;
	
	@Override
	public int addCompany(String company[]) {
		
		 String sql = "insert into tbl_companyConsult(id,companyName,mainBusiness,consultProblem,contactInformation,createDate) values(?,?,?,?,?,?)";
		 Object params[] = {StringUtil.getStr32(), company[0], company[1], company[2], company[3], new Date()};
		 int totalRows =  dbutilsTemplate.insert(sql, params);
		 
		 return totalRows;

	}

}
