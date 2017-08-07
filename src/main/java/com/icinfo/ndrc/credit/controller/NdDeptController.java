/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.ndrc.credit.dto.NdDeptDto;
import com.icinfo.ndrc.credit.model.NdDept;
import com.icinfo.ndrc.credit.service.INdDeptService;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.model.SysUser;

/**
 * 描述:    nd_dept 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月19日
 */
@Controller
@RequestMapping({"/credit/dept","/gateway/reception/dept"})
public class NdDeptController extends BaseController {
	
	@Autowired
	INdDeptService ndDeptService;
	/**
	 * 进入部门维护
	 * @author zjj
	 */
	@RequestMapping("/views")
	public ModelAndView views() throws Exception{
		ModelAndView mv = new ModelAndView("credit/system/credit_dept_manage_list");
		return mv;
	}
	/**
	 * 进入登记机关树页面(单选)
	 * @author ylr
	 * @date 2017年06月07日
	 * @throws Exception
	 */
	@RequestMapping("/enRadioTreeSelect")
	public ModelAndView enRadioTreeSelect() throws Exception{
		ModelAndView view  = new ModelAndView("credit/system/common/credit_dept_radio_tree_select");
		return view;
	}
	/**
	 * 获取部门数据
	 * @author zjj
	 */
	@RequestMapping("/doGetDeptList")
	@ResponseBody
	public List<NdDeptDto> doGetDeptList() throws Exception{
		return ndDeptService.selectNdDeptList();
	}
	/**
	 * 获取某条部门数据
	 * @author zjj
	 */
	@RequestMapping("/doGetDept")
	@ResponseBody
	public AjaxResult doGetDept(String depCode) throws Exception{
		if(StringUtils.isBlank(depCode)) return AjaxResult.error("参数错误");
		
		Map<String, Object> qryMap = new HashMap<String,Object>();
		qryMap.put("depCode", depCode);
		List<NdDept> list = ndDeptService.doGetDeptByMap(qryMap);
		if(list.size()==0) return AjaxResult.error("参数错误");
		
		return AjaxResult.success(null, list.get(0));
		
	}
	
	/**
	 *进入部门增加修改页面
	 *@author zjj
	 */
	@RequestMapping("/enEdit")
	public ModelAndView enEdit(String uid,String sid,String pid,String pName) throws Exception{
		ModelAndView mv =new ModelAndView("credit/system/credit_dept_manage_edit");
		if(StringUtils.isNotBlank(uid)){
			Map<String, Object> qryMap = new HashMap<String,Object>();
			qryMap.put("uid", uid);
			List<NdDept> list = ndDeptService.doGetDeptByMap(qryMap);
			if(list.size()==0) return mv;
			mv.addObject("pName",pName);
			mv.addObject("ndDept",list.get(0));
		}else{
			mv.addObject("pid",pid);
    		mv.addObject("sid",sid);
		}
		return mv;
	}
	/**
	 * 部门增加修改
	 * @author zjj
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public AjaxResult edit(HttpSession session,NdDept ndDept) throws Exception{
		if(StringUtils.isBlank(ndDept.getDepName().trim())) 
			return AjaxResult.error("部门名称不能为空");
		
		SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		ndDept.setDepSetName(user.getUsername());
		ndDept.setDepSysType(user.getUserType());
		ndDept.setDepSetDate(new Date());
		
		Map<String, Object> qryMap = new HashMap<String,Object>();
		qryMap.put("depName", ndDept.getDepName().trim());
		List<NdDept> list = ndDeptService.doGetDeptByMap(qryMap);
		if(list.size()>0)  return AjaxResult.error("部门名称已存在");
		
		if(StringUtils.isNotBlank(ndDept.getDepCode())){//修改
			if(ndDeptService.update(ndDept)>0)
				return AjaxResult.success("修改成功");
			
		}else{//增加
			qryMap.clear();
			list = ndDeptService.doGetDeptByMap(qryMap);
			ndDept.setDepCode(ndDeptService.doGetDepCode(list.get(0).getDepOrderNO()));
			ndDept.setDepOrderNO(String.valueOf(Integer.parseInt(list.get(0).getDepOrderNO())+1));
			if(ndDeptService.insert(ndDept)>0)
				return AjaxResult.success("增加成功");
		}
		return AjaxResult.error("操作失败");
	}
	/**
	 * 删除部门数据
	 * @author zjj
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(String uid) throws Exception{
		if(StringUtils.isBlank(uid)) return AjaxResult.error("参数错误");
		
		if(ndDeptService.delete(uid)>0)
			return AjaxResult.success("删除成功");
		return AjaxResult.error("操作失败");
	}
}