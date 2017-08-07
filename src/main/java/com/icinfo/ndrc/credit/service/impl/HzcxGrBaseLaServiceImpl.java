/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.ndrc.credit.dto.HzcxGrBaseLaDto;
import com.icinfo.ndrc.credit.dto.HzcxQyBaseLaDto;
import com.icinfo.ndrc.credit.mapper.HzcxGrBaseLaMapper;
import com.icinfo.ndrc.credit.mapper.HzcxQyBaseLaMapper;
import com.icinfo.ndrc.credit.service.IHzcxGrBaseLaService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    HZCX_GR_BASE_LA 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月02日
 */

/**
 * 
 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
 * 
 * @author ranah
 * @when 2017年6月12日下午4:57:48
 */
@Service
public class HzcxGrBaseLaServiceImpl extends MyBatisServiceSupport implements IHzcxGrBaseLaService {
	@Autowired
	private HzcxGrBaseLaMapper hzcxGrBaseLaMapper;

	@Override
	/**
	 * 查询个人信息 Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月13日下午4:47:45
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<HzcxGrBaseLaDto> doGetList(PageRequest request) throws Exception {

		PageHelper.startPage(request.getPageNum(), request.getLength());
		return hzcxGrBaseLaMapper.selectHzcxGrBaseLaList(request.getParams());
	}

	@Override
	/**
	 * 根据ID查询个人信息 Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月13日下午4:48:07
	 * @param map
	 * @return
	 */
	public List<HzcxGrBaseLaDto> findById(Map<String, Object> map) {
		// TODO Auto-generated method stub

		return hzcxGrBaseLaMapper.findByGrId(map);
	}

}