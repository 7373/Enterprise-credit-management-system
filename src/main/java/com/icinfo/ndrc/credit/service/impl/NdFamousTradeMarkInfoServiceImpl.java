/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.mapper.NdEnvironmentEvaluateInfoMapper;
import com.icinfo.ndrc.credit.mapper.NdFamousTradeMarkInfoMapper;
import com.icinfo.ndrc.credit.model.NdEnvironmentEvaluateInfo;
import com.icinfo.ndrc.credit.model.NdFamousTradeMarkInfo;
import com.icinfo.ndrc.credit.service.INdFamousTradeMarkInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_famous_trade_mark_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Service
public class NdFamousTradeMarkInfoServiceImpl extends MyBatisServiceSupport implements INdFamousTradeMarkInfoService {
	@Autowired
	NdFamousTradeMarkInfoMapper ndFamousTradeMarkInfoMapper;
	@Override
	public List<NdFamousTradeMarkInfo> selectList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return ndFamousTradeMarkInfoMapper.selectList(request.getParams());
	}
}