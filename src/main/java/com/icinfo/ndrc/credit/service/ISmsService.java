/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    短信机 对应的Service接口.<br>
 * 出资方式
 * @author framework generator   
 * @date 2016年08月30日
 */
public interface ISmsService extends BaseService {
	
	/** 
	 * 描述: 发送短信
	 */
	public boolean doSendMsg(final String phone, final String message) throws Exception;
	
}