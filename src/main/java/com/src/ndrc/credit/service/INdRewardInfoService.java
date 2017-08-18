/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.model.NdRewardInfo;

/**
 * 描述:    nd_reward_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
public interface INdRewardInfoService extends BaseService {
	
	public List<NdRewardInfo> selectList(PageRequest request)throws Exception;
}