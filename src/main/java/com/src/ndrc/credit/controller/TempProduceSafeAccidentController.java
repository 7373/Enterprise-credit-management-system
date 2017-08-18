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
import com.icinfo.ndrc.credit.dto.TempProduceSafeAccidentDto;
import com.icinfo.ndrc.credit.service.ITempProduceSafeAccidentService;

/**
 * 描述:    temp_produce_safe_accident 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月22日
 */
@Controller
@RequestMapping("/credit/tempProduceSafeAccident")
public class TempProduceSafeAccidentController extends BaseController {
	@Autowired
	ITempProduceSafeAccidentService tempProduceAccidentService;
	/**
	 * 查询生产安全事故信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageResponse<TempProduceSafeAccidentDto> list(PageRequest request){
		return new PageResponse<TempProduceSafeAccidentDto>(tempProduceAccidentService.selectListByMap(request));
	}
}