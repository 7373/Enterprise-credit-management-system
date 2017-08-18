/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    temp_socia_organ_class_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
public interface ITempSociaOrganClassInfoService extends BaseService,IBatchService {
	/**
	 * 读取Excel存取
	 * @author zjj
	 */
	public String record(String depCode, HSSFSheet sheet, String bacthNO) throws Exception;
}