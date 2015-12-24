package com.karuite.weixin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.karuite.service.TdAdvisoryService;
import com.karuite.service.TdCompanyService;
import com.karuite.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T> {

	private static final long serialVersionUID = 1L;

	@Resource
	protected TdCompanyService tdCompanyService;
	@Resource
	protected TdAdvisoryService tdAdvisoryService;

	protected T model;

	@SuppressWarnings( { "unchecked" })
	public BaseAction() {
		try {
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class clazz = (Class) pt.getActualTypeArguments()[0];

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public PrintWriter getPrintWriter(HttpServletResponse response,
			String charset) {
		response.setHeader("Cache-Control", "no-cache");
		if (!StringUtil.isValid(charset))
			response.setHeader("Content-Type", "text/html; charset=UTF-8");
		else
			response.setHeader("Content-Type", "text/html; charset=" + charset);
		PrintWriter out = null;
		try {
			out = ServletActionContext.getResponse().getWriter();
		} catch (IOException e) {
		}
		return out;
	}

	protected String writeAjaxResponse(String ajaxString) {
		try {
			getResponse().setContentType("text/html;charset=utf-8");
			PrintWriter out = getResponse().getWriter();
			out.write(ajaxString);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			return null;
		}
	}

	public T getModel() {
		return model;
	}

}
