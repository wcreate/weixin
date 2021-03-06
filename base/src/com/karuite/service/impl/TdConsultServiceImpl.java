package com.karuite.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karuite.dao.TdConsultDao;
import com.karuite.entity.TdConsult;
import com.karuite.service.TdConsultService;
import com.karuite.service.baseService;

@Service
@Transactional
public class TdConsultServiceImpl extends baseServiceImpl<TdConsult> implements TdConsultService {

	@Autowired
    private TdConsultDao tdConsultDao;
	
	

}
