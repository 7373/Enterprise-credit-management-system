/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.mapper.NdEnvironmentEvaluateInfoMapper;
import com.icinfo.ndrc.credit.mapper.NdSafeProduceLicenceMapper;
import com.icinfo.ndrc.credit.model.NdEnvironmentEvaluateInfo;
import com.icinfo.ndrc.credit.model.NdSafeProduceLicence;
import com.icinfo.ndrc.credit.service.INdSafeProduceLicenceService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_safe_produce_licence 对应的Service接口实现类<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
@Service
public class NdSafeProduceLicenceServiceImpl extends MyBatisServiceSupport implements INdSafeProduceLicenceService {
	@Autowired
	private NdSafeProduceLicenceMapper ndSafeProduceLicenceMapper;
	/**
	 * 描述:查找安监局许可资质详细信息
	 * @author Administrator
	 * @param map
	 * @return NdSafeProduceLicence
	 */
	public List<NdSafeProduceLicence> selectDetailByMap(PageRequest pageRequest) throws Exception{
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getLength());
		return ndSafeProduceLicenceMapper.selectDetailByMap(pageRequest.getParams());
	}
	
	/**
	 * 获取数据 @author rah
	 */
	
	public List<NdSafeProduceLicence> selectList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return ndSafeProduceLicenceMapper.selectList(request.getParams());
	}
}