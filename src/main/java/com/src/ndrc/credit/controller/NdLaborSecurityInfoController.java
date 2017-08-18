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
import com.icinfo.ndrc.credit.dto.NdLaborSecurityInfoDto;
import com.icinfo.ndrc.credit.service.INdLaborSecurityInfoService;

/**
 * 描述:    nd_labor_security_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
@Controller
@RequestMapping("/credit/creditInfo")
public class NdLaborSecurityInfoController extends BaseController {
	
	@Autowired
	INdLaborSecurityInfoService ndLaborSecurityService;
	
	/**
	 * 获取数据
	 * @author zjj
	 */
	@RequestMapping("/data.json")
	@ResponseBody
	public PageResponse<NdLaborSecurityInfoDto> doGetList(PageRequest request)throws Exception{
		List<NdLaborSecurityInfoDto> data = ndLaborSecurityService.query(request);
		return new PageResponse<NdLaborSecurityInfoDto>(data);
	}
}