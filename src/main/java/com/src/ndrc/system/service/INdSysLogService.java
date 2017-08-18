/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.system.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.system.dto.NdSysLogDto;
import com.icinfo.ndrc.system.model.NdSysLog;

/**
 * 描述:    nd_sys_log 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月23日
 */
public interface INdSysLogService extends BaseService {
	/**
	 * 查询日志信息
	 * @param request
	 * @return
	 */
	List<NdSysLogDto> selectListByMap(PageRequest request) throws Exception;

	/**
	 *@Description 方法注释
	 *@author ylr
	 *@date 2017-06-26
	 */
	Integer insert(NdSysLog nsSysLog) throws Exception;

}