/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdUnionDeptDto;
import com.icinfo.ndrc.credit.model.NdUnionDept;

/**
 * 描述:    nd_union_dept 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月17日
 */
public interface INdUnionDeptService extends BaseService {
	
	/**
	 * 保存
	 * 
	 * @author zhuyong
	 * @param model
	 * @throws Exception
	 */
	public void save(NdUnionDept model) throws Exception;
	
	/**
	 * 获取列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<NdUnionDeptDto> pageQuery(PageRequest request) throws Exception;
}