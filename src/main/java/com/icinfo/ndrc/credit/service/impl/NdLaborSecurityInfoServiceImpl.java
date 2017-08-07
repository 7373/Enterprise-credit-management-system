/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdLaborSecurityInfoDto;
import com.icinfo.ndrc.credit.mapper.NdLaborSecurityInfoMapper;
import com.icinfo.ndrc.credit.service.INdLaborSecurityInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_labor_security_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
@Service
public class NdLaborSecurityInfoServiceImpl extends MyBatisServiceSupport implements INdLaborSecurityInfoService {

	@Autowired
	NdLaborSecurityInfoMapper ndLaborSecurityInfoMapper;
	
	@Override
	public List<NdLaborSecurityInfoDto> query(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		return ndLaborSecurityInfoMapper.selectLaborSecurityInfoList(request.getParams());
	}
}