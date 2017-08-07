/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.ndrc.credit.dto.NdUnionInfoDto;

/**
 * 描述:    nd_union_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月17日
 */
public interface INdUnionInfoService extends BaseService {
	
	
	/**
	 * 保存申请
	 * 
	 * @param dto
	 * @throws Exception
	 */
	public void save(NdUnionInfoDto dto,String userId) throws Exception;
	/**
	 *获取任务编号
	 *@author zjj
	 */
	public String doGetTaskNO() throws Exception;
}