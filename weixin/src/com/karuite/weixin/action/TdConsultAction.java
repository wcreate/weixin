package com.karuite.weixin.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.karuite.entity.TdConsult;


@Controller
@Scope("prototype")
public class TdConsultAction extends BaseAction<TdConsult> {

	private static final long serialVersionUID = 3302734902140283674L;
	private static final Logger logger = Logger.getLogger(TdConsultAction.class);
	
	public String consult() throws Exception {

		String sql = "select * from consulter";
		List<TdConsult> tdConsult = tdConsultService.findConsult(TdConsult.class, sql);
		
		System.out.println(tdConsult.size());
		logger.info("这是一条从tdConsult产生的info信息,debug信息无法打印！");
		
		return SUCCESS;
	}
	
}
