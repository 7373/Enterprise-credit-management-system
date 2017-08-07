/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.NdVerifyCodeMapper;
import com.icinfo.ndrc.credit.model.NdVerifyCode;
import com.icinfo.ndrc.credit.service.INdVerifyCodeService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_verify_code 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月23日
 */
@Service
public class NdVerifyCodeServiceImpl extends MyBatisServiceSupport implements INdVerifyCodeService {

	@Autowired
	NdVerifyCodeMapper ndVerifyCodeMapper;
	
	@Override
	public int insert(NdVerifyCode ndVerifyCode) throws Exception {
		return ndVerifyCodeMapper.insert(ndVerifyCode);
	}

	@Override
	public List<NdVerifyCode> selectVerifyCode(Map<String, Object> qryMap) throws Exception {
		return ndVerifyCodeMapper.selectVerifyCode(qryMap);
	}
}