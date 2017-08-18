/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.AesCipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.ndrc.credit.dto.HzcxGrBaseLaDto;
import com.icinfo.ndrc.credit.dto.HzcxQyBaseLaDto;
import com.icinfo.ndrc.credit.service.IHzcxGrBaseLaService;
import com.icinfo.ndrc.credit.service.IHzcxQyBaseLaService;
import com.icinfo.ndrc.util.AESEUtil;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    HZCX_GR_BASE_LA 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月02日
 */
/**
 * 
 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
 * 
 * @author ranah
 * @when 2017年6月8日下午3:36:39
 */
@Controller
@RequestMapping("/credit/grbase")
public class HzcxGrBaseLaController extends BaseController {

	@Autowired
	IHzcxGrBaseLaService hzcxGrBaseLaService;
	

	/**
	 * 进入个人信息查询
	 * 
	 * @author ranah 20170608
	 */
	@RequestMapping(value = "views")
	public ModelAndView grviews() throws Exception {
		ModelAndView mv = new ModelAndView("credit/system/grxxsearch_list");
		return mv;
	}

	/**
	 * 获取个人信息JSon
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月9日下午5:14:53
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/grlist.json" })
	@ResponseBody
	public PageResponse<HzcxGrBaseLaDto> doGetGrList(PageRequest request) throws Exception {
		List<HzcxGrBaseLaDto> data = hzcxGrBaseLaService.doGetList(request);
		return new PageResponse<HzcxGrBaseLaDto>(data);
	}

	/**
	 * 个人信息详情查询 Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月12日上午9:32:58
	 * @param uid
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/grxq")
	public ModelAndView showGrXq(String uid) throws Exception {
		ModelAndView mv = new ModelAndView("credit/system/grxq");
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("grId", AESEUtil.decryptContext(uid));
		List<HzcxGrBaseLaDto> list = hzcxGrBaseLaService.findById(map);
		
		mv.addObject("data", list.get(0));
		return mv;
	}
}