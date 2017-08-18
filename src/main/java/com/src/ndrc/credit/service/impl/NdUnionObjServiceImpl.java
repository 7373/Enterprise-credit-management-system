/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.NdUnionObjMapper;
import com.icinfo.ndrc.credit.model.NdUnionObj;
import com.icinfo.ndrc.credit.service.INdUnionObjService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_union_obj 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月17日
 */
@Service
public class NdUnionObjServiceImpl extends MyBatisServiceSupport implements INdUnionObjService {
	
	@Autowired
	private NdUnionObjMapper ndUnionObjMapper;
	/**
	 * 保存
	 * 
	 * @author zhuyong
	 * @param model
	 * @throws Exception
	 */
	public void save(NdUnionObj model) throws Exception{
		ndUnionObjMapper.insert(model);
	}
}