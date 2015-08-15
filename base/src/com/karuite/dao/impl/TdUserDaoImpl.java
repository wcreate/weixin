package com.karuite.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.karuite.dao.DBUtilsTemplate;
import com.karuite.dao.PageHelp;
import com.karuite.dao.TdUserDao;
import com.karuite.entity.TdUser;

@Repository
public class TdUserDaoImpl implements TdUserDao {

	@Autowired
    @Qualifier("dbutilsTemplate")
    private DBUtilsTemplate dbutilsTemplate;
	
	@Override
	public TdUser getByIdentity(String username) {
		//(String sql, int page, int count, Object... params);   
		String sql = "select * from TdUser where username = '" +username + "'";
		
		List<TdUser> list = dbutilsTemplate.findPageT(TdUser.class, sql, 0, PageHelp.Constants_PAGESIZE);  
		int totalRows = list.size();  
		return (TdUser) new PageHelp(list, totalRows, 0).getItems().get(0); 
	}

}
