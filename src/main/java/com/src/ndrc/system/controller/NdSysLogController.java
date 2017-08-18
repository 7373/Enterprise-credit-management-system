/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.security.shiro.UserProfile;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.dto.NdSysLogDto;
import com.icinfo.ndrc.system.model.SysUser;
import com.icinfo.ndrc.system.service.INdSysLogService;
import com.icinfo.ndrc.system.service.ISysUserService;

/**
 * 描述:    nd_sys_log 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月23日
 */
@Controller
@RequestMapping({"/credit/system/syslog","/gateway/system/syslog"})
public class NdSysLogController extends BaseController {
	@Autowired
	private INdSysLogService ndSysLogService;
	@Autowired
    private ISysUserService sysUserService; 
	
	/**
     * 进入系统日志监控页面
     *
     * @return
     * @throws Exception
     */
	@RequestMapping("/list")
	public String views(){
		return "credit/system/log_manage_list";
	}
	/**
     * 获取日志监控数据
     *
     * @return
     * @throws Exception
     */
	@RequestMapping("list.json")
	@ResponseBody
	public PageResponse<NdSysLogDto>  list(PageRequest request,HttpSession session) throws Exception{
		UserProfile userProfile=(UserProfile)session.getAttribute(Constants.SESSION_SYS_USER_KEY);
		SysUser sysUser=null;
		if(userProfile!=null) sysUser = sysUserService.select(userProfile.getUserId());
		Map<String, Object> map=new HashMap<String, Object>();
		if(request.getParams()==null)request.setParams(map);
		if(sysUser !=null)request.getParams().put("logUserType", sysUser.getUserType());
		else return new PageResponse<NdSysLogDto>(null);
		List<NdSysLogDto> ndSysLogList = ndSysLogService.selectListByMap(request);
		return new PageResponse<NdSysLogDto>(ndSysLogList);
	}
}