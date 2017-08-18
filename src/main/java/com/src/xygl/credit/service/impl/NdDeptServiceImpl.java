/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.ndrc.credit.dto.NdDeptDto;
import com.icinfo.ndrc.credit.mapper.NdDeptMapper;
import com.icinfo.ndrc.credit.model.NdDept;
import com.icinfo.ndrc.credit.service.INdDeptService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_dept 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月19日
 */
@Service
public class NdDeptServiceImpl extends MyBatisServiceSupport implements INdDeptService {

	@Autowired
	NdDeptMapper ndDeptMapper;
	@Override
	public List<NdDeptDto> selectNdDeptList() throws Exception {
		return ndDeptMapper.selectNdDeptList();
	}
	@Override
	public List<NdDept> doGetDeptByMap(Map<String, Object> qryMap) throws Exception {
		return ndDeptMapper.selectNdDeptByMap(qryMap);
	}
	@Override
	public String doGetDepCode(String orderNO) throws Exception {
		return "ZF330682"+String.format("%03d",Integer.parseInt(orderNO)+1);
	}
	@Override
	public int insert(NdDept ndDept) throws Exception {
		return ndDeptMapper.insert(ndDept);
	}
	@Override
	public int update(NdDept ndDept) throws Exception {
		Example example = new Example(NdDept.class);
		example.createCriteria().andEqualTo("depCode",ndDept.getDepCode());
		return ndDeptMapper.updateByExampleSelective(ndDept, example);
	}
	@Override
	public int delete(String uid) throws Exception {
		Example example = new Example(NdDept.class);
		example.createCriteria().andEqualTo("uid",uid);
		return ndDeptMapper.deleteByExample(example);
	}
	/**
	 * 更加部门编号查找
	 * @author fanzhen
	 * @date 20170616
	 * @return
	 * @throws Exception
	 */
	@Override
	public NdDept findByDepCode(String depCode) throws Exception {
		return ndDeptMapper.findByDepCode(depCode);
	}
}