/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.model.NdFamousFirmInfo;
import com.icinfo.ndrc.credit.model.NdRewardInfo;

/**
 * 描述:    nd_famous_firm_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
public interface INdFamousFirmInfoService extends BaseService {

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月30日上午11:26:25
	 * @param request
	 * @return
	 */
	
	public List<NdFamousFirmInfo> selectList(PageRequest request)throws Exception;
}