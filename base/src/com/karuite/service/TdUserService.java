package com.karuite.service;

import java.util.List;

import com.karuite.entity.TdCompany;

public interface TdUserService {

	// 插入一条公司咨询信息
	public int addCompany(String company[]);
	
	// 插入一条咨询师加盟信息
	public int addAdvisory(String advisory[]);

}
