/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.ndrc.credit.service.INdTempService;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.model.SysUser;

/**
 * 描述:    nd_union_obj 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月17日
 */
@Controller
@RequestMapping("/credit/temp")
public class NdTempController extends BaseController {
	
	@Autowired
	INdTempService ndTempService; 
	/**
	 * 进入上传查询页面
	 * @author zjj
	 */
	@RequestMapping("/views")
	public ModelAndView views(HttpServletSession session) throws Exception{
		SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mv = ndTempService.doGetViews(user.getDept());
		return mv;
	}
}