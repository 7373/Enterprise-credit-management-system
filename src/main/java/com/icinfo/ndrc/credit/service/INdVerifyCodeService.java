/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.ndrc.credit.model.NdVerifyCode;

/**
 * 描述:    nd_verify_code 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月23日
 */
public interface INdVerifyCodeService extends BaseService {
	/**
	 *插入验证码信息 
	 */
	public int insert(NdVerifyCode ndVerifyCode) throws Exception;
	
	/**
	 * 获取验证码数据
	 * @author zjj
	 */
	public List<NdVerifyCode> selectVerifyCode(Map<String,Object> qryMap) throws Exception;
}