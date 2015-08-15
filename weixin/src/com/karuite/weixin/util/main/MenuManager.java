package com.karuite.weixin.util.main;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.karuite.weixin.util.CommonUtil;
import com.karuite.weixin.util.MenuUtil;
import com.karuite.weixin.util.menu.Button;
import com.karuite.weixin.util.menu.ClickButton;
import com.karuite.weixin.util.menu.ComplexButton;
import com.karuite.weixin.util.menu.Menu;
import com.karuite.weixin.util.menu.ViewButton;
import com.karuite.weixin.util.object.App;
import com.karuite.weixin.util.pojo.Token;

/**
 * 菜单管理器类
 * 
 * @author liufeng
 * @date 2013-10-17
 */
public class MenuManager {

	/**
	 * 定义菜单结构
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		ViewButton btn11 = new ViewButton();
		btn11.setName("联系业主");
		btn11.setType("view");
		btn11.setUrl("http://120.25.209.211/karuite-weixin/tdTable/tdTable_table.html");
		
		ClickButton btn12 = new ClickButton();
		btn12.setName("企业微站");
		btn12.setType("click");
		btn12.setKey("13");

		ClickButton btn13 = new ClickButton();
		btn13.setName("企业微站");
		btn13.setType("click");
		btn13.setKey("13");
		
		ClickButton btn14 = new ClickButton();
		btn14.setName("周边搜索");
		btn14.setType("click");
		btn14.setKey("14");

		ViewButton btn21 = new ViewButton();
		btn21.setName("天玓官微");
		btn21.setType("view");
		btn21.setUrl("http://120.25.209.211/karuite-weixin/noMean/ManiaIndex.html");

		ViewButton btn22 = new ViewButton();
		btn22.setName("社区样例");
		btn22.setType("view");
		btn22.setUrl("http://wx.wsq.qq.com/253225099");

		ClickButton btn23 = new ClickButton();
		btn23.setName("在线学习");
		btn23.setType("click");
		btn23.setKey("23");

		ClickButton btn31 = new ClickButton();
		btn31.setName("心语蜜话");
		btn31.setType("click");
		btn31.setKey("31");

		ClickButton btn32 = new ClickButton();
		btn32.setName("我的同学");
		btn32.setType("click");
		btn32.setKey("32");
		
		ClickButton btn33 = new ClickButton();
		btn33.setName("我的相册");
		btn33.setType("click");
		btn33.setKey("33");
		
		ClickButton btn34 = new ClickButton();
		btn34.setName("我的资料");
		btn34.setType("click");
		btn34.setKey("34");
		
		ClickButton btn35 = new ClickButton();
		btn35.setName("我的收藏");
		btn35.setType("click");
		btn35.setKey("35");

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("企业中心");
		mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13, btn14 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("天玓社区");
		mainBtn2.setSub_button(new Button[] { btn21, btn22});

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("个人中心");
		mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33, btn34, btn35 });

		Menu menu = new Menu();
	//	menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
		menu.setButton(new Button[] { btn11, btn21, btn31 });
		
		return menu;
	}

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = App.appId;
		// 第三方用户唯一凭证密钥
		String appSecret = App.appSecret;

		// 调用接口获取凭证
		Token token = CommonUtil.getToken(appId, appSecret);

		if (null != token) {
			// 创建菜单
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());

			// 判断菜单创建结果
			if (result)
				System.out.println("菜单创建成功！");
			else
				System.out.println("菜单创建失败！");
		}
	}
}
