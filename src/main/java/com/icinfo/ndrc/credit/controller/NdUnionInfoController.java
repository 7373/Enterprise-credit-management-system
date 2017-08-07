/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.credit.dto.NdUnionDeptDto;
import com.icinfo.ndrc.credit.dto.NdUnionInfoDto;
import com.icinfo.ndrc.credit.service.INdUnionDeptService;
import com.icinfo.ndrc.credit.service.INdUnionInfoService;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.model.SysUser;

/**
 * 描述:    nd_union_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月17日
 */
@Controller
@RequestMapping(value="/credit/ndunion/info")
public class NdUnionInfoController extends BaseController {
	
	@Autowired
	private INdUnionInfoService ndUnionInfoService;
	
	@Autowired 
	private INdUnionDeptService ndUnionDeptService;
	
	/**
	 * 
	 * 进去申请页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doEnApply")
	public ModelAndView doEnApply() throws Exception{
		ModelAndView mav = new ModelAndView("credit/system/union/union_apply");
		mav.addObject("taskNO",ndUnionInfoService.doGetTaskNO());
		return mav;
	}
	
	/**
	 * 进去申请页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doEnProc")
	public ModelAndView doEnProc() throws Exception{
		ModelAndView mav = new ModelAndView("credit/system/union/union_proc_handle");
		return mav;
	}
	
	/**
	 * 进去申请页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doEnResult")
	public ModelAndView doEnResult() throws Exception{
		ModelAndView mav = new ModelAndView("credit/system/union/union_result_list");
		return mav;
	}
	
	
	
	/**
	 * 
	 * 保存申请
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@ResponseBody
	public AjaxResult save(HttpSession session, NdUnionInfoDto dto) throws Exception{
		SysUser user = (SysUser)session.getAttribute(Constants.SESSION_SYS_USER);
		ndUnionInfoService.save(dto, user.getUid());
		return AjaxResult.success("保存成功");
	}

	
	/**
	 * 协查流程
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("proList.json")
	@ResponseBody
	public PageResponse<NdUnionDeptDto> proList(PageRequest request) throws Exception{
		List<NdUnionDeptDto> dataList = ndUnionDeptService.pageQuery(request);
		return new PageResponse<NdUnionDeptDto>(dataList);
	}
	
	/**
	 * 协查流程
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("rstList.json")
	@ResponseBody
	public PageResponse<NdUnionDeptDto> rstList(PageRequest request) throws Exception{
		List<NdUnionDeptDto> dataList = ndUnionDeptService.pageQuery(request);
		return new PageResponse<NdUnionDeptDto>(dataList);
	}
	
	
	
}