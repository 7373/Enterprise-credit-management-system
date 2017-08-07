/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.controller;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.security.shiro.LoginToken;
import com.icinfo.framework.security.shiro.UserProfile;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.dto.LoginDto;
import com.icinfo.ndrc.system.model.SysUser;
import com.icinfo.ndrc.system.service.ISysUserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 描述:  用户登录控制.<br>
 *
 * @author xiajunwei
 * @date 2016年05月18日
 */
@Controller
@RequestMapping("/admin")
public class LoginController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private ISysUserService sysUserService; 

    /**
     * 进入登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() throws Exception {
        return "redirect:/";
    }

    /**
     * 用户登录验证
     *
     * @param session
     * @param loginDto
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult loginCheck(HttpSession session, HttpServletResponse response, @Valid LoginDto loginDto, BindingResult result) throws Exception {
        logger.debug("系统用户登录");
        if (result.hasErrors()) {
            AjaxResult error = AjaxResult.error("参数验证错误");
            error.addErrorInfo(result.getAllErrors());
            return error;
        }

        try {
            LoginToken loginToken = new LoginToken(loginDto.getUsername(), loginDto.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(loginToken);
            session.setAttribute(Constants.SESSION_SYS_USER_KEY, subject.getPrincipal());

            //将登陆用户SysUser放入Session
            UserProfile userProfile = (UserProfile)subject.getPrincipal();
    		SysUser sysUser = sysUserService.select(userProfile.getUserId());
    		session.setAttribute(Constants.SESSION_SYS_USER, sysUser);
        } catch (Exception e) {
        	e.printStackTrace();
            return AjaxResult.error("登录失败，请重试");
        }
        return AjaxResult.success("登录成功");
    }

    /**
     * 进入登录页面
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return "redirect:/";
    }
}
