/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.gateway.dto.NdPunishDto;
import com.icinfo.ndrc.gateway.service.INdPunishService;

/**
 * 描述:    nd_punish 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月23日
 */
@Controller
@RequestMapping("/gateway/reception/ndpunish")
public class NdPunishController extends BaseController {
	@Autowired
	INdPunishService ndPunishService;
	/**
	 * 查询企业行政处罚信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageResponse<NdPunishDto> list(PageRequest request){
		return new PageResponse<NdPunishDto>(ndPunishService.selectListByMap(request));
	}
	
}