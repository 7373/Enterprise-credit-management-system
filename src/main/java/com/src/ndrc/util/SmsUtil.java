package com.icinfo.ndrc.util;

import java.util.List;

/** 
 * 描述: 发送短信相关验证类
 */
public class SmsUtil {
	
	/**
	 * 生成6位数验证码
	 * 
	 * @author zhuyong
	 * @return
	 */
	public static String createVerifyCode(){
		return String.valueOf((int)(Math.random()*(899999)+100000));
	}
	
	/**
	 * 生成短信发送内容
	 * 
	 * @author zhuyong
	 * @param verifyCode
	 * @return
	 */
	public static String createMsgContent(String verifyCode){
		return "您的验证码是" +verifyCode+"，在10分钟内有效。";
	}
	
	/**
	 * 用户审核通过发送短信内容
	 * @author zjj
	 */
	public static String createSuccessMsg(String userName){
		return "您申请的账号名"+userName+"审核通过了！";
	}
	
	/** 
	 * 描述: 验证参数是否有效
	 * 
	 * @author ZhouYan
	 * @date 2016年9月8日 
	 * @param phoneList
	 * @param message
	 * @return
	 * @throws Exception 
	 */
	public static boolean validateParams(List<String> phoneList, String message)
			throws Exception {
		if (phoneList.isEmpty() || message == null || "".equals(message))
			return false;
		return true;
	}

	/** 
	 * 描述: 简单验证是否为手机号11位，并且以“1”开头的数字
	 * @author ZhouYan
	 * @date 2016年9月8日 
	 * @param phone
	 * @return 
	 */
	public static boolean validateIsPhone(String phone) {
		if (null == phone)
			return false;
		for (int i = 0; i < phone.length(); i++) {
			if (!Character.isDigit(phone.charAt(i))) {
				return false;
			}
		}
		return phone.length() == 11 && phone.startsWith("1");
	}

	/** 
	 * 描述: 验证是否是移动号段
	 * @author ZhouYan
	 * @date 2016年9月8日 
	 * @param phone
	 * @return 
	 */
	public static boolean validateIsMobile(String phone) {
		String[] ltd = { "134", "135", "136", "137", "138", "139", 
				"147","150", "151", "152", "157", "158", "159",
				 "178", "182", "183", "184", "187", "188"};
		for (int i = 0; i < ltd.length; i++) {
			if (phone.substring(0, 3).equalsIgnoreCase(ltd[i])) {
				return true;
			}
		}
		return false;
	}

	/** 
	 * 描述: 验证是否是联通号段
	 * @author ZhouYan
	 * @date 2016年9月8日 
	 * @param phone
	 * @return 
	 */
	public static boolean validateIsUnicom(String phone) {
		String[] ltd = { "130", "131", "132", "145",
				"155", "156", "176", "185", "186"};
		for (int i = 0; i < ltd.length; i++) {
			if (phone.substring(0, 3).equalsIgnoreCase(ltd[i])) {
				return true;
			}
		}
		return false;
	}
	
	/** 
	 * 描述: 验证是否是电信号段
	 * @author ZhouYan
	 * @date 2016年9月8日 
	 * @param phone
	 * @return 
	 */
	public static boolean validateIsChinaNet(String phone) {
		String[] ltd = { "133", "153",  "177", "180", "181", "189"};
		for (int i = 0; i < ltd.length; i++) {
			if (phone.substring(0, 3).equalsIgnoreCase(ltd[i])) {
				return true;
			}
		}
		return false;
	}
}
