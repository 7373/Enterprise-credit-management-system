/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.TempProduceSafeAccidentDto;

/**
 * 描述:    temp_produce_safe_accident 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月22日
 */
public interface ITempProduceSafeAccidentService extends BaseService,IBatchService {
	/**
	 * 查询生产安全事故信息。
	 * @param map
	 * @return
	 */
	List<TempProduceSafeAccidentDto> selectListByMap(PageRequest request);
	
	/**
	 * 读取Excel存取
	 * @author zjj
	 */
	public String record(String deptName,HSSFSheet sheet,String bacthNO) throws Exception;
}