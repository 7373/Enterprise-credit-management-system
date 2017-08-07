/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    temp_marriage_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
public interface ITempMarriageInfoService extends BaseService,IBatchService {

	/**
	 * 读取Excel存取
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月29日下午3:28:56
	 * @param depCode
	 * @param sheet
	 * @param bacthNO
	 * @return
	 */
	public String record(String depCode, HSSFSheet sheet, String bacthNO) throws Exception;
}