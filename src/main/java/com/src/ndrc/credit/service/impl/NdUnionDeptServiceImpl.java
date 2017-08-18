/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdUnionDeptDto;
import com.icinfo.ndrc.credit.mapper.NdUnionDeptMapper;
import com.icinfo.ndrc.credit.model.NdUnionDept;
import com.icinfo.ndrc.credit.service.INdUnionDeptService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_union_dept 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月17日
 */
@Service
public class NdUnionDeptServiceImpl extends MyBatisServiceSupport implements INdUnionDeptService {
	
	@Autowired
	private NdUnionDeptMapper ndUnionDeptMapper;
	
	/**
	 * 保存
	 * 
	 * @author zhuyong
	 * @param model
	 * @throws Exception
	 */
	public void save(NdUnionDept model) throws Exception{
		ndUnionDeptMapper.insert(model);
	}
	
	
	/**
	 * 获取列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<NdUnionDeptDto> pageQuery(PageRequest request) throws Exception{
	      PageHelper.startPage(request.getPageNum(), request.getLength());
	       return ndUnionDeptMapper.pageQuery(request.getParams());
	}
}