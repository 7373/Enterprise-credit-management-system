/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.gateway.dto.NdLicenseDto;
import com.icinfo.ndrc.gateway.dto.NdPunishDto;
import com.icinfo.ndrc.gateway.mapper.NdLicenseMapper;
import com.icinfo.ndrc.gateway.model.NdLicense;
import com.icinfo.ndrc.gateway.service.INdLicenseService;

/**
 * 描述:    nd_license 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月22日
 */
@Service
public class NdLicenseServiceImpl extends MyBatisServiceSupport implements INdLicenseService {
	@Autowired
	NdLicenseMapper ndLicenseMapper;
	@Override
	public List<NdLicenseDto> selectListByMap(PageRequest request) {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		return ndLicenseMapper.selectListByMap(request.getParams());
	}
	
	/**
	 * 七天双公示查询
	 */
	@Override
	public List<NdLicenseDto> selectSevenDoubleList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		return ndLicenseMapper.selectSevenDoubleList(request.getParams());
	}

	/**
	 * 查询指定uid的七天双公示内容（许可）
	 */
	@Override
	public NdLicense selectSevenDoubleListDetail(String uid) {
		Example example = new Example(NdLicense.class);
		example.createCriteria().andEqualTo("uid", uid);
		return ndLicenseMapper.selectByExample(example).get(0);
	}

	@Override
	public NdLicenseDto selectCountAndTime() {
		NdLicenseDto ndLicenseDto =new NdLicenseDto();
		List<Date> list = ndLicenseMapper.doCountAndInputInfo();
		if(list==null)return null;
		ndLicenseDto.setCountNum(String.valueOf(list.size()));
		ndLicenseDto.setInputDate(list.get(0));
		return ndLicenseDto;
	}
}