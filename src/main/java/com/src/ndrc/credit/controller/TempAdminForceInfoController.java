/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.credit.dto.TempAdminForceInfoDto;
import com.icinfo.ndrc.credit.service.ITempAdminForceInfoService;

/**
 * 描述:    temp_admin_force_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月22日
 */
@Controller
@RequestMapping("/credit/tempAdminForceInfo")
public class TempAdminForceInfoController extends BaseController {
	@Autowired
	ITempAdminForceInfoService tempAdminForceInfoService;
	/**
	 * 查询行政强制信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageResponse<TempAdminForceInfoDto> list(PageRequest request){
		return new PageResponse<TempAdminForceInfoDto>(tempAdminForceInfoService.selectListByMap(request));
	}
}