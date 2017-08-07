/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.mapper.NdEnvironmentEvaluateInfoMapper;
import com.icinfo.ndrc.credit.mapper.NdFireControlLicenceiInfoMapper;
import com.icinfo.ndrc.credit.model.NdEnvironmentEvaluateInfo;
import com.icinfo.ndrc.credit.model.NdFireControlLicenceiInfo;
import com.icinfo.ndrc.credit.service.INdFireControlLicenceiInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_fire_control_licence_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Service
public class NdFireControlLicenceiInfoServiceImpl extends MyBatisServiceSupport implements INdFireControlLicenceiInfoService {
	/**
	 * 获取数据 @author rah
	 */
	@Autowired
	NdFireControlLicenceiInfoMapper ndFireControlLicenceiInfoMapper;
	@Override
	public List<NdFireControlLicenceiInfo> selectList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return ndFireControlLicenceiInfoMapper.selectList(request.getParams());
	}
}