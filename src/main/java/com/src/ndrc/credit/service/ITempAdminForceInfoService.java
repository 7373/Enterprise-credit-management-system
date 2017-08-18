/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.TempAdminForceInfoDto;

/**
 * 描述:    temp_admin_force_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月22日
 */
public interface ITempAdminForceInfoService extends BaseService,IBatchService {
	/**
	 * 查询行政强制信息
	 * @param map
	 * @return
	 */
	List<TempAdminForceInfoDto> selectListByMap(PageRequest request);
	
	/**
	 * 读取Excel存取
	 * @author zjj
	 */
	public String record(String deptName,HSSFSheet sheet,String bacthNO) throws Exception;
}