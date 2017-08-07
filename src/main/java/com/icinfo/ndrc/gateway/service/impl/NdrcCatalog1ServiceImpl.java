/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.ndrc.gateway.mapper.NdrcCatalog1Mapper;
import com.icinfo.ndrc.gateway.model.NdrcCatalog1;
import com.icinfo.ndrc.gateway.service.INdrcCatalog1Service;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    NDRC_CATALOG1 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月09日
 */
@Service
public class NdrcCatalog1ServiceImpl extends MyBatisServiceSupport implements INdrcCatalog1Service {
	
	@Autowired
	NdrcCatalog1Mapper ndrcCatalog1Mapper;
	
	/**
	 * 查找一级目录
	 * @author liuguangju	
	 * @date 2017-06-12
	 */
	@Override
	public List<NdrcCatalog1> selectNdrcCatalog1() throws Exception {
		
		return ndrcCatalog1Mapper.selectNdrcCatalog1Mapper();
	}
}