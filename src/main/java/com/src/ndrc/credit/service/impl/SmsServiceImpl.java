/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.service.ISmsService;
import com.icinfo.ndrc.support.Constants;
import com.sgs.sms.SmsClient;

import net.sf.json.JSONObject;

/**
 * 描述:    短信机 对应的Service接口实现类.<br>
 * 出资方式
 * @author framework generator
 * @date 2016年08月30日
 */
@Service
public class SmsServiceImpl extends MyBatisServiceSupport implements ISmsService {
	
	//短信服务器IP
	@Value("${sms.baseUrl}")
	private  String baseUrl;
	
	//短信签名
	@Value("${sms.sign}")
	public  String sign;
	
	//应用标识
	@Value("${sms.appCode}")
	public  String appCode;
	
	//用户名
	@Value("${sms.username}")
	public  String username;
	
	//密码
	@Value("${sms.password}")
	public  String password;
	
	//是否开启云平台模式
	@Value("${cloudModel}")
	public String cloudModel;
	
	/** 
	 * 描述: 发送短信
	 * 
	 * @throws Exception 
	 */
	@Override
	public boolean doSendMsg(String phone, String message) {
		// 本地模式，无短信机可以调用 ， 直接返回
		if(! Constants.CLOUDMODEL_OPEN.equalsIgnoreCase(cloudModel))
			return true;
		
		try {
			SmsClient client = new SmsClient(baseUrl, appCode, username, password, sign);
			String result = client.sendMsg(phone, message, "330000");
			JSONObject object = (JSONObject) JSONObject.fromObject(result).get("result");
			if("success".equalsIgnoreCase(object.getString("returnstatus")))
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}