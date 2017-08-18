/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdCommendRewardInfoDto;

/**
 * 描述:    nd_commend_reward_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
public interface INdCommendRewardInfoService extends BaseService {
	
	/**
	 * 查询企业表彰奖励信息
	 * 
	 */
	public List<NdCommendRewardInfoDto> getRedBlackList(PageRequest request)throws Exception;
}