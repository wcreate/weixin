package com.karuite.weixin.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.karuite.entity.TdUser;

@Controller
@Scope("prototype")
public class TdUserAction extends BaseAction<TdUser> {

	private static final long serialVersionUID = 3302734902140283674L;
	
	public String tdUser() throws Exception {

		TdUser tdUser = tdUserService.getByIdentity("tengshengwei");
		System.out.println(tdUser.getOpenid());
		
		return SUCCESS;
	}
	
}
