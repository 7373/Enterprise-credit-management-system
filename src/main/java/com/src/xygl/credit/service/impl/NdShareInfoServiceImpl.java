/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdShareInfoDto;
import com.icinfo.ndrc.credit.mapper.NdShareInfoMapper;
import com.icinfo.ndrc.credit.service.INdShareInfoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_share_info 对应的Service实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
@Service
public class NdShareInfoServiceImpl extends MyBatisServiceSupport implements INdShareInfoService {
	@Autowired
	NdShareInfoMapper ndShareInfoMapper;
	@Override
	public List<NdShareInfoDto> selectNdShareInfoByMap(PageRequest request) {
		PageHelper.startPage(request.getStart(),request.getLength());
		return ndShareInfoMapper.selectNdShareInfoByMap(request.getParams());
	}
}