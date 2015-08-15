package com.karuite.dao;

import java.util.List;

import com.karuite.entity.TdUser;

public interface TdUserDao {

	TdUser getByIdentity(String username);
}
