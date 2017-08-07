/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.ndrc.credit.model.NdUnionObj;

/**
 * 描述:    nd_union_obj 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月17日
 */
public interface INdUnionObjService extends BaseService {
	
	/**
	 * 保存
	 * 
	 * @author zhuyong
	 * @param model
	 * @throws Exception
	 */
	public void save(NdUnionObj model) throws Exception;
}