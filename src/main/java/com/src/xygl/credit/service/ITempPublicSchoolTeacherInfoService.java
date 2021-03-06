/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    temp_public_school_teacher_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月28日
 */
public interface ITempPublicSchoolTeacherInfoService extends BaseService,IBatchService {
	
	/**
	 * 读取Excel存取
	 * @author fanzhen
	 * @date 20170628
	 * @param deptName
	 * @param sheet
	 * @param bacthNO
	 * @return
	 * @throws Exception
	 */
	public String record(String deptName,HSSFSheet sheet,String bacthNO) throws Exception;
}