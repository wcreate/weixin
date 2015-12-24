package com.karuite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karuite.dao.TdCompanyDao;
import com.karuite.service.TdCompanyService;

@Service
@Transactional
public class TdCompanyServiceImpl implements TdCompanyService {

	@Autowired
    private TdCompanyDao tdCompanyDao;
	
	public int addCompany(String company[]) {
		return tdCompanyDao.addCompany(company);
	}
	

}
