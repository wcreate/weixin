package com.karuite.weixin.action;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.karuite.entity.TdCompany;


@Controller
@Scope("prototype")
public class TdCompanyAction extends BaseAction<TdCompany> {

	private static final long serialVersionUID = 3302734902140283674L;
	private static final Logger logger = Logger.getLogger(TdCompanyAction.class);
	
	public String companyConsult() throws Exception {

		String companyName = ServletActionContext.getRequest()
		.getParameter("companyName");
		String mainBusiness = ServletActionContext.getRequest()
		.getParameter("mainBusiness");
		String consultProblem = ServletActionContext.getRequest()
		.getParameter("consultProblem");
		String contactInformation = ServletActionContext.getRequest()
		.getParameter("contactInformation");
		
		int affectRow = tdCompanyService.addCompany(new String[]{companyName,mainBusiness,consultProblem,contactInformation});
		
		System.out.println(affectRow);
		logger.info("这是一条从tdUser产生的info信息,debug信息无法打印！");
		
		return SUCCESS;
	}
	
}
