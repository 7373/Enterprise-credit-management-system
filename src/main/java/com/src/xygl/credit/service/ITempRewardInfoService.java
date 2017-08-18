/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.model.NdEntOweTaxInfo;
import com.icinfo.ndrc.credit.model.TempRewardInfo;

/**
 * 描述:    temp_reward_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
public interface ITempRewardInfoService extends BaseService,IBatchService {

	/**
	 * 读取Excel存取
	 * @author fanzhen
	 * @date 20170629
	 * @param deptName
	 * @param sheet
	 * @param bacthNO
	 * @return
	 * @throws Exception
	 */
	public String record(String deptName,HSSFSheet sheet,String bacthNO) throws Exception;

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月30日下午3:39:08
	 * @param request
	 * @return
	 */
	public List<TempRewardInfo> selectList(PageRequest request)throws Exception;
}