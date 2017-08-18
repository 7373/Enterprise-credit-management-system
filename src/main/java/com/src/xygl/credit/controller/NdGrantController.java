/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.credit.dto.NdGrantDto;
import com.icinfo.ndrc.credit.model.NdGrant;
import com.icinfo.ndrc.credit.service.INdGrantService;
import com.icinfo.ndrc.system.dto.SysUserDto;
import com.icinfo.ndrc.system.service.ISysUserService;
import com.icinfo.ndrc.util.DateUtil;

import org.apache.catalina.util.HexUtils;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * 描述:    nd_grant 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月26日
 */
@Controller
@RequestMapping("/credit/ndgrant/")
public class NdGrantController extends BaseController {

    @Autowired
    private INdGrantService ndGrantService;

    @Autowired
    private ISysUserService sysUserService;


    /**
     *@Description 用户授权
     *@date 2017-06-27
     */
    @RequestMapping("doEnEditGrant")
    public ModelAndView doEditGrant(String uid)throws Exception{
    ModelAndView mv = new ModelAndView("credit/system/grant/credit_grant_edit");
        NdGrantDto ndGrant = ndGrantService.selectNdGrantDetail(uid);
        SysUserDto sysUserDto = sysUserService.selectForCredit(ndGrant.getGraUserID());
        ndGrant.setGraUserName(sysUserDto.getRealName());
        mv.addObject("ndGrant",ndGrant);
    return mv;
    }
    /**
     *@Description 用户授权
     *@author ylr
     *@date 2017-06-26
     */
    @RequestMapping("doEnAddAndEditGrant")
    public ModelAndView doEnAddAndEditGrant(String userID)throws Exception{
    ModelAndView mv = new ModelAndView("credit/system/grant/credit_grant_add");
        SysUserDto sysUserDto = sysUserService.selectForCredit(userID);
        NdGrantDto ndGrant = new NdGrantDto();
        ndGrant.setGraUserID(sysUserDto.getUid());
        ndGrant.setGraUserName(sysUserDto.getRealName());
        mv.addObject("ndGrant",ndGrant);
    return mv;
    }
    /**
     *@Description 用户授权添加修改
     *@author ylr
     *@date 2017-06-26
     */
    @RequestMapping("doAddAndEditGrant")
    @ResponseBody
    public AjaxResult doAddAndEditGrant(NdGrant ndGrant)throws Exception{
        try {
            if(StringUtils.isBlank(ndGrant.getUid())){
                List<NdGrant> ndGrantList = ndGrantService.selectNdGrantEffectList(ndGrant);
		        if(ndGrantList!=null&&ndGrantList.size()>0)
			        return AjaxResult.error("已授权，请勿重复授权");
                ndGrant.setGraOptTime(new Date());
                ndGrantService.doSave(ndGrant);
            }else{
                ndGrantService.doMod(ndGrant);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("授权失败");
        }
        return AjaxResult.success("授权成功");
    }
    /**
     * 查看企业(或者个人)拥有的权限
     * @param userID
     * @return
     * @throws Exception 
     */
    @RequestMapping("list")
    public ModelAndView view(String userID) throws Exception{
    	ModelAndView mv = new ModelAndView("credit/system/grant/credit_grant_view");
    	SysUserDto sysUserDto = sysUserService.selectForCredit(userID);
        NdGrantDto ndGrant = new NdGrantDto();
        ndGrant.setGraUserID(sysUserDto.getUid());
        ndGrant.setGraUserName(sysUserDto.getRealName());
        mv.addObject("ndGrant",ndGrant);
		return mv;
    }
    /**
     * 查询授权信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("doReadNdGrantListJSON")
    @ResponseBody
    public PageResponse<NdGrant> doReadNdGrantListJSON(PageRequest request) throws Exception{
    	List<NdGrant> ndgrantList = ndGrantService.selectNdGrantInfoList(request);
    	return new PageResponse<NdGrant>(ndgrantList);
    }

}