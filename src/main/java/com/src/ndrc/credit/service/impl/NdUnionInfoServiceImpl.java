/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.dto.NdUnionInfoDto;
import com.icinfo.ndrc.credit.mapper.NdUnionInfoMapper;
import com.icinfo.ndrc.credit.model.NdUnionDept;
import com.icinfo.ndrc.credit.model.NdUnionInfo;
import com.icinfo.ndrc.credit.model.NdUnionObj;
import com.icinfo.ndrc.credit.service.INdUnionDeptService;
import com.icinfo.ndrc.credit.service.INdUnionInfoService;
import com.icinfo.ndrc.credit.service.INdUnionObjService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_union_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月17日
 */
@Service
public class NdUnionInfoServiceImpl extends MyBatisServiceSupport implements INdUnionInfoService {
	
	
	@Autowired
	private NdUnionInfoMapper ndUnionInfoMapper;
	@Autowired
	private INdUnionObjService ndUnionObjService;
	@Autowired
	private INdUnionDeptService ndUnionDeptService;
	
	/**
	 * 保存申请
	 * 
	 * @param dto
	 * @throws Exception
	 */
	public void save(NdUnionInfoDto dto,String userId) throws Exception{
		if(dto == null || StringUtils.isBlank(dto.getJobNO())){
			return ;
		}
		String jobNO = dto.getJobNO();
		// 保存对象
		saveUnionObjList(dto.getUnionObjList(), jobNO);
		// 保存协查部门
		saveUnionDepList(dto.getUnionDeptList(), jobNO, userId);
		
		NdUnionInfo model = (NdUnionInfo) dto;
		model.setCreateUserID(userId);
		model.setCreateTime(new Date());
		
		ndUnionInfoMapper.insert(model);
		
	}
	
	/**
	 * 保存申请对象
	 * 
	 * @param objList
	 * @param jobNO
	 * @throws Exception
	 */
	private void saveUnionObjList(List<NdUnionObj> objList,String jobNO) throws Exception{
		for (NdUnionObj model : objList) {
			if(model == null || StringUtils.isBlank(model.getEntName()))
				break;
			model.setJobNO(jobNO);
			ndUnionObjService.save(model);
		}
	}
	
	/**
	 * 保存协查部门
	 * 
	 * @param objList
	 * @param jobNO
	 * @throws Exception
	 */
	private void saveUnionDepList(List<NdUnionDept> depList,String jobNO,String userId) throws Exception{
		for (NdUnionDept model : depList) {
			if(model == null || StringUtils.isBlank(model.getRecDep()))
				break;
			model.setJobNO(jobNO);
			model.setHandleStatue("0");
			ndUnionDeptService.save(model);
		}
	}

	@Override
	public String doGetTaskNO() throws Exception {
		return "NO"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+((int)(Math.random()*900)+100);
	}
	
	
}