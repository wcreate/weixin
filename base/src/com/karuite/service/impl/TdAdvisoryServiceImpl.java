package com.karuite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karuite.dao.TdAdvisoryDao;
import com.karuite.service.TdAdvisoryService;

@Service
@Transactional
public class TdAdvisoryServiceImpl implements TdAdvisoryService {

	@Autowired
    private TdAdvisoryDao tdAdvisoryDao;
	
	public int addAdvisory(String advisory[]) {
		return tdAdvisoryDao.addAdvisory(advisory);
	}

}
