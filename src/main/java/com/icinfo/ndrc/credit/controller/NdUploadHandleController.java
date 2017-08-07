/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.credit.dto.NdUploadHandleDto;
import com.icinfo.ndrc.credit.service.INdUploadHandleService;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.model.SysUser;

/**
 * 描述:    nd_upload_handle 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
@Controller
@RequestMapping("/credit/uploadHandle")
public class NdUploadHandleController extends BaseController {
	
	@Autowired
	INdUploadHandleService ndUploadHandleService;
	
	/**
	 * 进入上传查询页面
	 * @author zjj
	 */
	@RequestMapping("/views")
	public ModelAndView views(HttpSession session) throws Exception{
		SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mv = new ModelAndView("credit/system/uploadhandle_list");
		mv.addObject("deptCode",user.getDept());
		return mv;
	}
	/**
	 * 获取数据
	 * @author zjj
	 */
	@RequestMapping("/data.json")
	@ResponseBody
	public PageResponse<NdUploadHandleDto> getData(PageRequest request) throws Exception{
		List<NdUploadHandleDto> data = ndUploadHandleService.query(request);
		return new PageResponse<NdUploadHandleDto>(data);
	}
	
}