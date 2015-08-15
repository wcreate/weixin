package com.karuite.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karuite.dao.TdUserDao;
import com.karuite.entity.TdUser;
import com.karuite.service.TdUserService;

@Service
public class TdUserServiceImpl implements TdUserService {

	@Autowired
    private TdUserDao tduserDao;
	
	@Transactional(readOnly = true)
	public TdUser getByIdentity(String username) {
		return tduserDao.getByIdentity(username);
	}

}
