package com.karuite.service;

import java.util.List;

import com.karuite.entity.TdUser;

public interface TdUserService {

	// 查询用户
	TdUser getByIdentity(String username);

}
