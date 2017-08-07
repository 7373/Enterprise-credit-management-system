/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdUploadHandleDto;
import com.icinfo.ndrc.credit.model.NdUploadHandle;

/**
 * 描述:    nd_upload_handle 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
public interface INdUploadHandleService extends BaseService {
	
	/**
	 * 获取数据
	 * @author zjj
	 */
	public List<NdUploadHandleDto> query(PageRequest request) throws Exception;
	
	/**
	 *插入导入记录
	 *@author zjj 
	 */
	public int insert(NdUploadHandle ndUploadHandle) throws Exception;
}