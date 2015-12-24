package com.karuite.weixin.action;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.karuite.entity.TdAdvisory;


@Controller
@Scope("prototype")
public class TdAdvisoryAction extends BaseAction<TdAdvisory> {

	private static final long serialVersionUID = 3302734902140283674L;
	private static final Logger logger = Logger.getLogger(TdAdvisoryAction.class);
	
	
	public String advisoryJoin() throws Exception {

		String businessBackground = ServletActionContext.getRequest()
		.getParameter("businessBackground");
		String successfulCase = ServletActionContext.getRequest()
		.getParameter("successfulCase");
		String excelField = ServletActionContext.getRequest()
		.getParameter("excelField");
		String contactInformation = ServletActionContext.getRequest()
		.getParameter("contactInformation");
		
		int affectRow = tdAdvisoryService.addAdvisory(new String[]{businessBackground,successfulCase,excelField,contactInformation});
		
		System.out.println(affectRow);
		logger.info("这是一条从tdUser产生的info信息,debug信息无法打印！");
		
		return SUCCESS;
	}
	
}