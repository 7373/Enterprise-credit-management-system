/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.ndrc.credit.dto.HzcxQyBaseLaDto;
import com.icinfo.ndrc.credit.mapper.HzcxQyBaseLaMapper;
import com.icinfo.ndrc.credit.service.IHzcxQyBaseLaService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: HZCX_QY_BASE_LA 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月02日
 */
@Service("hzcxQyBaseLaService")
public class HzcxQyBaseLaServiceImpl extends MyBatisServiceSupport implements IHzcxQyBaseLaService {
	@Autowired
	private HzcxQyBaseLaMapper hzcxQyBaseLaMapper;

	/**
	 * 查询企业信息 Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月13日下午4:49:31
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<HzcxQyBaseLaDto> doGetList(PageRequest request) throws Exception {

		PageHelper.startPage(request.getPageNum(), request.getLength());
		return hzcxQyBaseLaMapper.selectHzcxQyBaseLaList(request.getParams());
	}

	/**
	 * 根据注册号查询企业信息 Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月13日下午4:49:44
	 * @param map
	 * @return
	 */
	@Override
	public List<HzcxQyBaseLaDto> findById(Map<String, Object> map) {

		return hzcxQyBaseLaMapper.findByQyId(map);

	}

	@Override
	public List<HzcxQyBaseLaDto> selectQyInfo(Map<String, Object> map) throws Exception {
		return hzcxQyBaseLaMapper.selectHzcxQyBaseLaList(map);
	}
}