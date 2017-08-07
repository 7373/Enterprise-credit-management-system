/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service;

import java.util.List;

import com.icinfo.ndrc.gateway.model.NdrcCatalog1;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    NDRC_CATALOG1 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月09日
 */
public interface INdrcCatalog1Service extends BaseService {
	
	/**
	 * 查找一级目录
	 * @author liuguangju	
	 * @date 2017-06-12
	 * @return
	 * @throws Exception
	 */
	public List<NdrcCatalog1> selectNdrcCatalog1()throws Exception;
}