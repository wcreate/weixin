package com.karuite.weixin.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.karuite.dao.DBUtilsTemplate;
import com.karuite.entity.TdUser;

@Controller
@Scope("prototype")
public class TdUserAction extends BaseAction<TdUser> {

	private static final long serialVersionUID = 3302734902140283674L;
	private static final Logger logger = Logger.getLogger(TdUserAction.class);
	
	public String tdUser() throws Exception {

		TdUser tdUser = tdUserService.getByIdentity("tengshengwei");
		System.out.println(tdUser.getOpenid());
		logger.info("这是一条从tdUser产生的info信息,debug信息无法打印！");
		
		return SUCCESS;
	}
	
}
