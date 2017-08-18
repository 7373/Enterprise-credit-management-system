/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.mapper.NdEntOweTaxInfoMapper;
import com.icinfo.ndrc.credit.mapper.TempLawFirmAssessInfoMapper;
import com.icinfo.ndrc.credit.model.NdEntOweTaxInfo;
import com.icinfo.ndrc.credit.model.TempLawFirmAssessInfo;
import com.icinfo.ndrc.credit.service.ITempLawFirmAssessInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    temp_law_firm_assess_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年07月03日
 */
@Service
public class TempLawFirmAssessInfoServiceImpl extends MyBatisServiceSupport implements ITempLawFirmAssessInfoService {
	/**
	 * 获取数据 @author rah
	 */
	@Autowired
	TempLawFirmAssessInfoMapper tempLawFirmAssessInfoMapper;
	@Override
	public List<TempLawFirmAssessInfo> selectList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return tempLawFirmAssessInfoMapper.selectList(request.getParams());
	}
	
}