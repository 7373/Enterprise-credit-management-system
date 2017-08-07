/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdLaborSecurityInfoDto;

/**
 * 描述:    nd_labor_security_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
public interface INdLaborSecurityInfoService extends BaseService {
	/**
	 * 获取数据
	 * @author zjj
	 */
	public List<NdLaborSecurityInfoDto> query(PageRequest request) throws Exception;
}