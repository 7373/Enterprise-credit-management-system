/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdUploadHandleDto;
import com.icinfo.ndrc.credit.mapper.NdUploadHandleMapper;
import com.icinfo.ndrc.credit.model.NdUploadHandle;
import com.icinfo.ndrc.credit.service.INdUploadHandleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_upload_handle 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
@Service
public class NdUploadHandleServiceImpl extends MyBatisServiceSupport implements INdUploadHandleService {

	@Autowired
	NdUploadHandleMapper ndUploadHandleMapper;
	
	@Override
	public List<NdUploadHandleDto> query(PageRequest request) throws Exception {
		
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return ndUploadHandleMapper.selectNdUploadHandle(request.getParams());
	}

	@Override
	public int insert(NdUploadHandle ndUploadHandle) throws Exception {
		
		return ndUploadHandleMapper.insert(ndUploadHandle);
	}
}