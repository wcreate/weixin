package com.karuite.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.id.Hex;

import com.google.gson.Gson;

public class StringUtil {

	public static final Gson gson = new Gson(); // String str = gson.toJson(src); 可以用此方法记录日志（http入参和出参）

	private static DecimalFormat decimalFormat = new DecimalFormat();
	private static final String emailPattern = "^[\\w\\.\\_\\-]+@[\\w\\.\\_\\-]+(\\.[\\w\\-]{2,3}){1,2}$";
	private static final String mobilePattern = "^((13[0-9])|(147)|(15[^4,\\D])|(18[0,1-9]))\\d{8}$";

	/**
	 * 帐号最大允许长度
	 */
	private static final int maxUsernameLength = 20;

	/**
	 * 帐号最小允许长度
	 */
	private static final int minUsernameLength = 4;

	/**
	 * 帐号密码最小允许长度
	 */
	private static final int minPasswordLength = 6;

	public static String md5Enc(String s) {
		return DigestUtils.md5Hex(s);
	}

	@SuppressWarnings("deprecation")
	public static String shaEnc(String s) {
		return DigestUtils.shaHex(s);
	}

	public static boolean isValid(String s) {
		return (s != null && s.trim().length() > 0) ? true : false;
	}

	public static boolean isEmail(String s) {
		return isValid(s) && s.matches(emailPattern);
	}

	public static boolean isUsername(String s) {
		return (s != null && (s.trim().length() <= maxUsernameLength && s
				.trim().length() >= minUsernameLength)) ? true : false;
	}

	public static boolean isPassword(String s) {
		return (s != null && s.trim().length() >= minPasswordLength) ? true
				: false;
	}

	public static boolean isMobileNO(String mobiles) {
		return isValid(mobiles) && mobiles.matches(mobilePattern);
	}

	/**
	 * 将集合中的值拼接为逗号字符串
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String collectionToCommaString(Collection c) {
		if (c == null || c.size() == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (Object o : c)
			sb.append(",").append(o.toString());
		return sb.substring(1);
	}

	/**
	 * 以参数格式拼接StringBuffer
	 * @param sb
	 * @param name
	 * @param value
	 */
	public static void appendParameter(StringBuffer sb, String name,
			String value) {
		if (sb.length() != 0)
			sb.append("&");
		sb.append(name + "=" + value);
	}

	/**
	 * 浮点数格式化输出
	 * @param value
	 * @return
	 */
	public static String formatNumber(float value) {
		decimalFormat.applyPattern("#.00");
		if (value == 0.0)
			return "0";
		else
			return decimalFormat.format(value);
	}

	@SuppressWarnings("deprecation")
	public static String encPassword(String password) {
		return DigestUtils.md5Hex(DigestUtils.sha(password));
	}

	public static String encodeUrl(String s, String encoding) {
		if (!StringUtil.isValid(encoding))
			encoding = "UTF-8";
		String result = s;
		try {
			result = URLEncoder.encode(s, encoding);
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}

	public static String decodeURL(String str, String encoding) {
		if (!StringUtil.isValid(str))
			return null;
		str = str.replace("%", "％");
		if (!StringUtil.isValid(encoding))
			encoding = "UTF-8";
		final char splitter = '/';
		try {
			StringBuilder sb = new StringBuilder(str.length());
			int start = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == splitter) {
					sb.append(URLDecoder.decode(str.substring(start, i),
							encoding));
					sb.append(splitter);
					start = i + 1;
				}
			}
			if (start < str.length())
				sb.append(URLDecoder.decode(str.substring(start), encoding));
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 替换掉字符串中的回车换行空格
	 */
	public static String replaceBlank(String str) {
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(str);
		return m.replaceAll("");
	}

	/**
	 * 32位不重复的字符串
	 */
	public static String getStr32() {
		char[] str32 = Hex.encodeHex(org.apache.commons.id.uuid.UUID
				.randomUUID().getRawBytes());
		String new32 = new String(str32);
		return new32;
	}

	/**
	 * 返回执行的sql
	 */
	public static String getPreparedSQL(String sql, Object[] params) {
		// 1 如果没有参数，说明是不是动态SQL语句
		int paramNum = 0;
		if (null != params) {
			paramNum = params.length;
		}
		if (1 > paramNum) {
			return sql;
		}
		// 2 如果有参数，则是动态SQL语句
		StringBuffer returnSQL = new StringBuffer();
		String[] subSQL = sql.split("\\?");
		for (int i = 0; i < paramNum; i++) {
			if (params[i] instanceof Date) {
				returnSQL.append(subSQL[i]).append("'").append(
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
								.format(params[i])).append("'");
			} else {
				returnSQL.append(subSQL[i]).append("'").append(params[i])
						.append("'");
			}
		}

		if (subSQL.length > params.length) {
			returnSQL.append(subSQL[subSQL.length - 1]);
		}
		return returnSQL.toString();
	}

}
