package com.karuite.weixin.action;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.karuite.entity.TdUser;

@Controller
@Scope("prototype")
public class TdUserAction extends BaseAction<TdUser> {

	private static final long serialVersionUID = 3302734902140283674L;
	private static final Logger logger = Logger.getLogger(TdUserAction.class);
	
	public String companyConsult() throws Exception {

		String companyName = ServletActionContext.getRequest()
		.getParameter("companyName");
		String mainBusiness = ServletActionContext.getRequest()
		.getParameter("mainBusiness");
		String consultProblem = ServletActionContext.getRequest()
		.getParameter("consultProblem");
		String contactInformation = ServletActionContext.getRequest()
		.getParameter("contactInformation");
		
		int affectRow = tdUserService.addCompany(new String[]{companyName,mainBusiness,consultProblem,contactInformation});
		
		System.out.println(affectRow);
		logger.info("这是一条从tdUser产生的info信息,debug信息无法打印！");
		
		return SUCCESS;
	}
	
	public String advisoryJoin() throws Exception {

		String businessBackground = ServletActionContext.getRequest()
		.getParameter("businessBackground");
		String successfulCase = ServletActionContext.getRequest()
		.getParameter("successfulCase");
		String excelField = ServletActionContext.getRequest()
		.getParameter("excelField");
		String contactInformation = ServletActionContext.getRequest()
		.getParameter("contactInformation");
		
		int affectRow = tdUserService.addAdvisory(new String[]{businessBackground,successfulCase,excelField,contactInformation});
		
		System.out.println(affectRow);
		logger.info("这是一条从tdUser产生的info信息,debug信息无法打印！");
		
		return SUCCESS;
	}
	
}
