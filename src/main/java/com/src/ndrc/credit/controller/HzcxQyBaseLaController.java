/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.ndrc.credit.dto.HzcxGrBaseLaDto;
import com.icinfo.ndrc.credit.model.NdGrant;
import com.icinfo.ndrc.credit.service.IHzcxGrBaseLaService;
import com.icinfo.ndrc.credit.service.INdGrantService;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.dto.SysUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.ndrc.credit.dto.HzcxQyBaseLaDto;
import com.icinfo.ndrc.credit.service.IHzcxQyBaseLaService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

import javax.servlet.http.HttpSession;

/**
 * 描述: HZCX_QY_BASE_LA 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月02日
 */
@Controller
@RequestMapping({"/credit/qybase","/gateway/reception/qybase"})
public class HzcxQyBaseLaController extends BaseController {

	@Autowired
	IHzcxQyBaseLaService hzcxQyBaseLaService;
	@Autowired
	IHzcxGrBaseLaService hzcxGrBaseLaService;
	@Autowired
	INdGrantService ndGrantService;

	/**
	 * 进入企业信息查询
	 * 
	 * @author zjj 20170602
	 */

	@RequestMapping(value = "views")
	public ModelAndView views() throws Exception {
		ModelAndView mv = new ModelAndView("credit/system/qyxxsearch_list");

		return mv;
	}

	/**
	 * 企业信息json数据
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved. 
	 * 
	 * @author ranah
	 * @when 2017年6月9日下午2:34:25
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/qylist.json" })
	@ResponseBody
	public PageResponse<HzcxQyBaseLaDto> doGetWarnProcessList(PageRequest request) throws Exception {
		List<HzcxQyBaseLaDto> data = hzcxQyBaseLaService.doGetList(request);

		return new PageResponse<HzcxQyBaseLaDto>(data);
	}

	/**
	 * 企业信息详情 Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月9日下午5:03:17
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/qyxq")
	public ModelAndView showQyXq(String uid) throws Exception {
		ModelAndView mv = new ModelAndView("credit/system/qyxq");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qyId", uid);
		List<HzcxQyBaseLaDto> list = hzcxQyBaseLaService.findById(map);
		mv.addObject("data", list.get(0));
		return mv;
	}

	/**
	 * 企业隐私信息 Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 *
	 * @author ylr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/qyprivacy")
	public ModelAndView showQyPrivacy(String uid,HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("credit/system/qy_privacy");
		ModelAndView nopermission = new ModelAndView("credit/system/no_permission");
		//校验用户是否有此权限-无权限跳转提示页
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		NdGrant ndGrant = new NdGrant();
		ndGrant.setGraUserID(sysUser.getUid());
		ndGrant.setGraNo(uid);//现在传的是企业注册号--详情页入口参数改成主键则需修改
		ndGrant.setGraIsDel(0);
		List<NdGrant> ndGrantList = ndGrantService.selectNdGrantEffectList(ndGrant);
		if(ndGrantList!=null&&ndGrantList.size()>0)//判断权限
			return mv;
		else
			return nopermission;
	}

	/**
	 * 企业信息json数据
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 *
	 * @author ylr
	 * @when 2017年6月27日下午2:34:25
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/qygrinfo")
	@ResponseBody
	public AjaxResult selectQyInfo(NdGrant ndGrant) throws Exception {
		Map<String,Object> qryMap = new HashMap<>();
		if(0==ndGrant.getGraType()){//企业
		qryMap.put("qymc",ndGrant.getGraName());
		qryMap.put("gszch",ndGrant.getGraNo());
		List<HzcxQyBaseLaDto> qyBaseList = hzcxQyBaseLaService.selectQyInfo(qryMap);
		if(qyBaseList!=null&&qyBaseList.size()>0)
			return AjaxResult.success("校验通过",qyBaseList.get(0));
		else
			return AjaxResult.error("校验不通过，请重新填写企业名称或注册号");
		}else{
			qryMap.put("grId",ndGrant.getGraNo());
			List<HzcxGrBaseLaDto> grBaseList = hzcxGrBaseLaService.findById(qryMap);
			if(grBaseList!=null&&grBaseList.size()>0)
				return AjaxResult.success("校验通过",grBaseList.get(0));
			else
				return AjaxResult.error("校验不通过，请重新填写个人证件号");
		}
	}
}