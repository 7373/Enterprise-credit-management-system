/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.mapper.NdFamousFirmInfoMapper;
import com.icinfo.ndrc.credit.mapper.NdRewardInfoMapper;
import com.icinfo.ndrc.credit.model.NdFamousFirmInfo;
import com.icinfo.ndrc.credit.model.NdRewardInfo;
import com.icinfo.ndrc.credit.service.INdFamousFirmInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_famous_firm_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Service
public class NdFamousFirmInfoServiceImpl extends MyBatisServiceSupport implements INdFamousFirmInfoService {

	@Autowired
	NdFamousFirmInfoMapper ndFamousFirmInfoMapper;
	@Override
	public List<NdFamousFirmInfo> selectList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return ndFamousFirmInfoMapper.selectList(request.getParams());
	}
}