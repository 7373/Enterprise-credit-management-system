/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;
import java.util.Map;

import com.icinfo.ndrc.credit.dto.HzcxQyBaseLaDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    HZCX_QY_BASE_LA 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月02日
 */
/**
 * 
 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
 * 
 * @author ranah
 * @when 2017年6月8日上午10:42:26
 */
public interface IHzcxQyBaseLaService extends BaseService {
	/**
	 * 查询企业信息 Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月13日下午4:49:31
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<HzcxQyBaseLaDto> doGetList(PageRequest request) throws Exception;

	/**
	 * 根据注册号查询企业信息 Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月13日下午4:49:44
	 * @param map
	 * @return
	 */
	public List<HzcxQyBaseLaDto> findById(Map<String, Object> map);


	/**
	 * 根据注册号查询企业信息 Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 *
	 * @author ylr
	 * @when 2017年6月26日下午4:49:44
	 * @param map
	 * @return
	 */
	public List<HzcxQyBaseLaDto> selectQyInfo(Map<String, Object> map)throws Exception;


}