/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.credit.model.NdEntOweTaxInfo;
import com.icinfo.ndrc.credit.model.TempLawFirmAssessInfo;
import com.icinfo.ndrc.credit.service.INdEntOweTaxInfoService;
import com.icinfo.ndrc.credit.service.ITempLawFirmAssessInfoService;

/**
 * 描述:    temp_law_firm_assess_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年07月03日
 */
@Controller
@RequestMapping("/credit/tempLawFirmAssessInfo")
public class TempLawFirmAssessInfoController extends BaseController {
	@Autowired
	ITempLawFirmAssessInfoService tempLawFirmAssessInfoService;
	/**
	 * 获取数据
	 * @author rah
	 */

	@RequestMapping({ "/data.json" })
	@ResponseBody
	public PageResponse<TempLawFirmAssessInfo> doGetList(PageRequest request) throws Exception {
		List<TempLawFirmAssessInfo> data = tempLawFirmAssessInfoService.selectList(request);
		return new PageResponse<TempLawFirmAssessInfo>(data);
	}
	
}