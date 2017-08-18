/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.dto.SysUserDto;
import com.icinfo.ndrc.system.model.SysUser;
import com.icinfo.ndrc.system.model.SysUserRole;
import com.icinfo.ndrc.system.service.ISysRoleService;
import com.icinfo.ndrc.system.service.ISysUserRoleService;
import com.icinfo.ndrc.system.service.ISysUserService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.security.shiro.UserProfile;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:  系统用户管理控制器.<br>
 *
 * @author xiajunwei
 * @date 2016年04月20日
 */
@Controller
@RequestMapping("/credit/system/sysuser")
public class CreditSysUserController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(CreditSysUserController.class);
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserRoleService sysUserRoleService;
    @Autowired
    private ISysRoleService sysRoleService;
    @Value("${spring.shiro.hash.iterations}")
    private int iterations;

    /**
     * 进入系统用户列表页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public String list() throws Exception {
        return "credit/system/sysuser/list";
    }


    /**
     * 系统数据JSON数据列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list.json", "list.xml"})
    @ResponseBody
    public PageResponse<SysUser> listJSON(PageRequest request) throws Exception {
        List<SysUser> data = sysUserService.queryPage(request);
        return new PageResponse<SysUser>(data);
    }

    /**
     * 显示编辑对话框
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView show(String uid) throws Exception {
        ModelAndView view = new ModelAndView("credit/system/sysuser/edit");
        //所有角色信息
        view.addObject("allRoles", sysRoleService.selectAllByRoleType(Constants.CREDIT_USER_TYPE));
        if (StringUtils.isNotEmpty(uid)) {
            //获取用户信息
            SysUser sysUser = sysUserService.select(uid);
            if (sysUser != null) {
                view.addObject("sysUser", sysUser);
                //获取用户角色信息
                List<SysUserRole> rolesList = sysUserRoleService.selectByUserId(uid);

                Map<String, SysUserRole> rolesMap = new HashMap<String, SysUserRole>();
                for (SysUserRole userRole : rolesList) {
                    rolesMap.put(userRole.getRoleId(), userRole);
                }
                view.addObject("userRoles", rolesMap);
            }
        }
        return view;
    }

    /**
     * 用户信息保存
     *
     * @param sysUser
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult save(@Valid @RequestBody SysUserDto sysUser, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            //参数验证错误
            AjaxResult error = AjaxResult.error("参数验证错误");
            error.addErrorInfo(result.getAllErrors());
            return error;
        }
        if (StringUtils.isNotEmpty(sysUser.getUid())) {
            if (sysUserService.update(sysUser, sysUser.getRoles()) > 0) {
                return AjaxResult.success("更新用户信息成功");
            }
            return AjaxResult.error("更新用户信息失败!");
        }

        try {
            sysUserService.insert(sysUser, sysUser.getRoles());
            return AjaxResult.success("创建新用户成功.");
        } catch (BusinessException e) {
            return AjaxResult.error(e.getMessage());
        }


    }

    /**
     * 删除用户
     *
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public AjaxResult delete(String uid) throws Exception {
        if (StringUtils.isEmpty(uid)) {
            return AjaxResult.error("未选择删除用户!");
        }
        if (sysUserService.deleteByUID(uid) > 0) {
            return AjaxResult.success("删除用户成功.");
        }
        return AjaxResult.error("删除用户失败!");
    }
    /**
     * 进入修改密码页面
     * @author zjj
     */
    @RequestMapping(value = "/enEditPass", method = RequestMethod.GET)
    public ModelAndView enEditPass(HttpSession session)throws Exception{
    	ModelAndView view = new ModelAndView("editpassword");
		UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
    	view.addObject("id",userProfile.getUserId());
    	view.addObject("roles",userProfile.getRoles());
    	
    	return view;
    }
    /**
     * 修改密码
     * @author zjj
     */
    @RequestMapping(value = "/editPass", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult editPass(SysUserDto sysUser,HttpServletRequest req) throws Exception {
    	if (StringUtils.isBlank(sysUser.getUid()))
			return AjaxResult.error("修改密码失败!");
		SysUser user = sysUserService.select(sysUser.getUid());
		SimpleHash hash = new SimpleHash("md5", sysUser.getPassword(), user.getPasswordSalt(), iterations);
		if(! hash.toHex().equals(user.getPassword()))
			return AjaxResult.error("原密码错误!");
		user.setPassword(sysUser.getPassword1());
		if(sysUserService.updatePass(user)>0){
			req.getSession().removeAttribute(Constants.SESSION_SYS_USER_KEY);
			return AjaxResult.success("修改密码成功");
		}
        return AjaxResult.error("修改密码失败!");
    }
}
