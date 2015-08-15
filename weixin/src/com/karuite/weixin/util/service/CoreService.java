package com.karuite.weixin.util.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.karuite.weixin.util.AdvancedUtil;
import com.karuite.weixin.util.BaiduMapUtil;
import com.karuite.weixin.util.CommonUtil;
import com.karuite.weixin.util.MessageUtil;
import com.karuite.weixin.util.MySQLUtil;
import com.karuite.weixin.util.message.resp.Article;
import com.karuite.weixin.util.message.resp.NewsMessage;
import com.karuite.weixin.util.message.resp.TextMessage;
import com.karuite.weixin.util.object.App;
import com.karuite.weixin.util.object.EmojiFilter;
import com.karuite.weixin.util.pojo.BaiduPlace;
import com.karuite.weixin.util.pojo.UserLocation;
import com.karuite.weixin.util.pojo.WeixinUserInfo;

/**
 * 核心服务类
 * 
 * @author liufeng
 * @date 2013-12-02
 */
public class CoreService {
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return xml
	 */
	public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";  
  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType"); 
            // 消息创建时间
            String createTime = requestMap.get("CreateTime");
  
            // 回复文本消息  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
  
            // 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				String content = requestMap.get("Content").trim();
				if (content.equals("附近")) {
					respContent = getUsage();
				}
				// 周边搜索
				else if (content.startsWith("附近")) {
					String keyWord = content.replaceAll("附近", "").trim();
					// 获取用户最后一次发送的地理位置
					UserLocation location = MySQLUtil.getLastLocation(fromUserName);
					// 未获取到
					if (null == location) {
						respContent = getUsage();
					} else {
						// 根据转换后（纠偏）的坐标搜索周边POI
						List<BaiduPlace> placeList = BaiduMapUtil.searchPlace(keyWord, location.getBd09Lng(), location.getBd09Lat());
						// 未搜索到POI
						if (null == placeList || 0 == placeList.size()) {
							respContent = String.format("/难过，您发送的位置附近未搜索到“%s”信息！", keyWord);
						} else {
							List<Article> articleList = BaiduMapUtil.makeArticleList(placeList, location.getBd09Lng(), location.getBd09Lat());
							// 回复图文消息
							NewsMessage newsMessage = new NewsMessage();
							newsMessage.setToUserName(fromUserName);
							newsMessage.setFromUserName(toUserName);
							newsMessage.setCreateTime(new Date().getTime());
							newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
							newsMessage.setArticles(articleList);
							newsMessage.setArticleCount(articleList.size());
							respMessage = MessageUtil.messageToXml(newsMessage);
							return respMessage; 
						}
					}
				} else {
					respContent = ChatService.chat(fromUserName, createTime, content);
				}
			}
            // 图片消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
            	respContent = "正在建设，稍后上线！";  
            }  
            // 地理位置消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
            	// 用户发送的经纬度
				String lng = requestMap.get("Location_Y");
				String lat = requestMap.get("Location_X");
				// 坐标转换后的经纬度
				String bd09Lng = null;
				String bd09Lat = null;
				// 调用接口转换坐标
				UserLocation userLocation = BaiduMapUtil.convertCoord(lng, lat);
				if (null != userLocation) {
					bd09Lng = userLocation.getBd09Lng();
					bd09Lat = userLocation.getBd09Lat();
				}
				// 保存用户地理位置
				MySQLUtil.saveUserLocation(fromUserName, lng, lat, bd09Lng, bd09Lat);

				StringBuffer buffer = new StringBuffer();
				buffer.append("[愉快]").append("成功接收您的位置！").append("\n\n");
				buffer.append("您可以输入搜索关键词获取周边信息了，例如：").append("\n");
				buffer.append("        附近ATM").append("\n");
				buffer.append("        附近KTV").append("\n");
				buffer.append("        附近厕所").append("\n");
				buffer.append("必须以“附近”两个字开头！");
				respContent = buffer.toString(); 
            }  
            // 链接消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
            	respContent = "正在建设，稍后上线！";  
            }  
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
            	respContent = "正在建设，稍后上线！";  
            }
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {  
            	respContent = "正在建设，稍后上线！";  
            }  
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    respContent = "感谢您关注了【天玓业主交流平台】，系统功能仅对天玓业主开放，更多惊喜等着您哦~~！";
                    
                }  
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                }  
                // 自定义菜单点击事件  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                    // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                    String eventKey = requestMap.get("EventKey");  
  
                    if (eventKey.equals("12")) {  
                        respContent = "正在建设，稍后上线！";  
                    } else if (eventKey.equals("13")) {  
                        respContent = "正在建设，稍后上线！";  
                    } else if (eventKey.equals("14")) {  
                        respContent = getUsage();  
                    } else if (eventKey.equals("21")) {  
                    	respContent = "正在建设，稍后上线！";  
                    } else if (eventKey.equals("22")) {  
                    	respContent = "正在建设，稍后上线！";  
                    } else if (eventKey.equals("23")) { 
                    	respContent = "正在建设，稍后上线！";  
                    } else if (eventKey.equals("31")) {
                    	respContent = "正在建设，稍后上线！";  
                    } else if (eventKey.equals("32")) {  
                        respContent = "正在建设，稍后上线！";  
                    } else if (eventKey.equals("33")) {  
                        respContent = "正在建设，稍后上线！";  
                    } else if (eventKey.equals("34")) {  
                    	respContent = "正在建设，稍后上线！";  
                    } else if (eventKey.equals("35"))
                    {
                    	respContent = "正在建设，稍后上线！";  
                    }
                } 
                // 二维码扫描
                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {  
                	respContent = "二维码正在建设，稍后上线！";  
                }
                // 上报地理位置
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {  
            		respContent = "上报地理位置功能还在开发中，请您耐心等待！";  
                }
            }  
  
            textMessage.setContent(respContent);  
            respMessage = MessageUtil.messageToXml(textMessage);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return respMessage;  
	}

	/**
	 * 使用说明
	 * @return
	 */
	private static String getUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("周边搜索使用说明").append("\n\n");
		buffer.append("1）发送地理位置").append("\n");
		buffer.append("点击窗口底部的“+”按钮，选择“位置”，点“发送”").append("\n\n");
		buffer.append("2）指定关键词搜索").append("\n");
		buffer.append("格式：附近+关键词\n例如：附近ATM、附近KTV、附近厕所");
		return buffer.toString();
	}
}