/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.system.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.system.dto.NdSysLogDto;
import com.icinfo.ndrc.system.mapper.NdSysLogMapper;
import com.icinfo.ndrc.system.model.NdSysLog;
import com.icinfo.ndrc.system.service.INdSysLogService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_sys_log 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月23日
 */
@Service
public class NdSysLogServiceImpl extends MyBatisServiceSupport implements INdSysLogService {
	@Autowired
	NdSysLogMapper ndSysLogMapper;
	@Override
	public List<NdSysLogDto> selectListByMap(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(),request.getLength());
		return ndSysLogMapper.selectListByMap(request.getParams());
	}

	@Override
	public Integer insert(NdSysLog ndSysLog) throws Exception{
		return ndSysLogMapper.insertSelective(ndSysLog);
	}
}