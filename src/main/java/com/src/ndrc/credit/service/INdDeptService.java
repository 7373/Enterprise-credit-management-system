/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.ndrc.credit.dto.NdDeptDto;
import com.icinfo.ndrc.credit.model.NdDept;

/**
 * 描述:    nd_dept 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月19日
 */
public interface INdDeptService extends BaseService {
	/**
	 * 获取部门数据
	 * @author zjj
	 */
	public List<NdDeptDto> selectNdDeptList() throws Exception;
	/**
	 * 获取某条部门数据
	 * @author zjj
	 */
	public List<NdDept> doGetDeptByMap(Map<String,Object> qryMap) throws Exception;
	/**
	 * 获取部门编号
	 * @author zjj
	 */
	public String doGetDepCode(String orderNO) throws Exception;
	/**
	 * 插入部门数据
	 * @author zjj
	 */
	public int insert(NdDept ndDept) throws Exception;
	/**
	 * 修改部门数据
	 * @author zjj
	 */
	public int update(NdDept ndDept) throws Exception;
	/**
	 * 删除部门数据
	 * @author zjj
	 */
	public int delete(String uid) throws Exception;
	
	/**
	 * 根据部门编号查找
	 * @author fanzhen
	 * @date 20170616
	 * @return
	 * @throws Exception
	 */
	public NdDept findByDepCode(String depcode) throws Exception;
}