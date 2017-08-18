/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdCommendRewardInfoDto;
import com.icinfo.ndrc.credit.mapper.NdCommendRewardInfoMapper;
import com.icinfo.ndrc.credit.service.INdCommendRewardInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_commend_reward_info 对应的Service实现类<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
@Service
public class NdCommendRewardInfoServiceImpl extends MyBatisServiceSupport implements INdCommendRewardInfoService {
	@Autowired
	NdCommendRewardInfoMapper ndCommendRewardInfoMapper;
	@Override
	public List<NdCommendRewardInfoDto> getRedBlackList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return ndCommendRewardInfoMapper.SelectCommendRewardInfoByMap(request.getParams());
	}
}