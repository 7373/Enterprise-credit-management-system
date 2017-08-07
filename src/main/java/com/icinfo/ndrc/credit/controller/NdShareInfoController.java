/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.credit.dto.NdShareInfoDto;
import com.icinfo.ndrc.credit.service.INdShareInfoService;

/**
 * 描述:    nd_share_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
@Controller
@RequestMapping("/credit/ndShareInfo")
public class NdShareInfoController extends BaseController {
	@Autowired
	INdShareInfoService ndShareInfoService;
	@RequestMapping("/search")
	@ResponseBody
	public PageResponse<NdShareInfoDto> search(PageRequest request){
		return new PageResponse<NdShareInfoDto>(ndShareInfoService.selectNdShareInfoByMap(request));
	}
	@RequestMapping("/views")
	public ModelAndView views() throws Exception{
		ModelAndView mv = new ModelAndView("credit/system/gxxqsearch_list");
		return mv;
		
	}
}