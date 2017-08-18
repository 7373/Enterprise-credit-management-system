/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.ndrc.credit.model.NdVerifyCode;
import com.icinfo.ndrc.credit.service.INdVerifyCodeService;
import com.icinfo.ndrc.credit.service.ISmsService;
import com.icinfo.ndrc.util.SmsUtil;

/**
 * 描述:    nd_verify_code 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月23日
 */
@Controller
@RequestMapping({"/credit","/gateway/reception"})
public class NdVerifyCodeController extends BaseController {
	
	@Autowired
	INdVerifyCodeService ndVerifyCodeService;
	
	@Autowired
	ISmsService smsService;
	
	 /** 
     * 描述: 获取手机验证码, 发送短信
     * 
     * @author zjj
     */
	@RequestMapping(value = "sendMsg", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult sendMsg(String tel) throws Exception{
		
		String verifyCode = SmsUtil.createVerifyCode();
		String msgContent = SmsUtil.createMsgContent(verifyCode);
		
		try {
			if(!SmsUtil.validateIsPhone(tel))
				return AjaxResult.error("手机号码错误");
			ndVerifyCodeService.insert(new NdVerifyCode(tel,verifyCode,msgContent));
			if(smsService.doSendMsg(tel, msgContent))
				return AjaxResult.success("发送成功");
			return AjaxResult.error("发送失败");
			
		} catch (Exception e) {
			return AjaxResult.error("发送失败");
		}
		
	}
}