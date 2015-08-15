package com.karuite.weixin.util.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.karuite.weixin.util.AdvancedUtil;
import com.karuite.weixin.util.object.App;
import com.karuite.weixin.util.pojo.SNSUserInfo;
import com.karuite.weixin.util.pojo.WeixinOauth2Token;

/**
 * 授权后的回调请求处理
 * 
 * @author liufeng
 * @date 2013-11-12
 */
public class OAuthServlet extends HttpServlet {
	private static final long serialVersionUID = -1847238807216447030L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");

		// 用户同意授权后，能获取到code
		String code = request.getParameter("code");

		// 用户同意授权
		if (!"authdeny".equals(code)) {
			// 获取网页授权access_token
			WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(App.appId, App.appSecret, code);
			// 网页授权接口访问凭证
			String accessToken = weixinOauth2Token.getAccessToken();
			// 用户标识
			String openId = weixinOauth2Token.getOpenId();
			// 获取用户信息
			SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

			// 设置要传递的参数
			request.setAttribute("headImgUrl", snsUserInfo.getHeadImgUrl());
			request.setAttribute("nickName", snsUserInfo.getNickname());
			request.setAttribute("openId", openId);
		}
		// 跳转到index.jsp
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
