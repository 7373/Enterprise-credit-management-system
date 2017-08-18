/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.gateway.dto.NdLicenseDto;
import com.icinfo.ndrc.gateway.model.NdLicense;
import com.icinfo.ndrc.gateway.model.NdPunish;
import com.icinfo.ndrc.gateway.service.INdLicenseService;
import com.icinfo.ndrc.gateway.service.INdPunishService;
import com.icinfo.ndrc.support.SevenDoubleEnum;

/**
 * 描述:    nd_license 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月22日
 */
@Controller
@RequestMapping("/gateway/reception/ndlicense")
public class NdLicenseController extends BaseController {
	@Autowired
	INdLicenseService ndLicenseService;
	
	
	/**
	 * 查询行政许可信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageResponse<NdLicenseDto> list(PageRequest request){
		return new PageResponse<NdLicenseDto>(ndLicenseService.selectListByMap(request));
	}
	
	/**
	 * 七天双公示首页显示
	 * @param request
	 * @return
	 */
	@RequestMapping("doubleList")
	@ResponseBody
	public PageResponse<NdLicenseDto> doubleList(PageRequest request){
		return new PageResponse<NdLicenseDto>(ndLicenseService.selectSevenDoubleList(request));
	}
	
	/**
	 * 进入七天双公示 详情页
	 * @param menu
	 * @param item
	 * @param uid
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getSevenDoubleListDetail",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getSevenDoubleListDetail(String menu,String item,String uid,String type,String name)throws Exception{
    	ModelAndView mv = new ModelAndView("gateway/biz/reception/publish_platform");
    	mv.addObject("uid", uid);
    	mv.addObject("type", type);
    	mv.addObject("menu", menu);
    	mv.addObject("item", item);
    	mv.addObject("name", name);
    	return mv;
    }
}