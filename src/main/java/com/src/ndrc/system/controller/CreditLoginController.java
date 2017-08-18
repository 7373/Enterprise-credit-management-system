/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.controller;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.security.shiro.LoginToken;
import com.icinfo.framework.security.shiro.UserProfile;
import com.icinfo.ndrc.common.constant.LogTypeConstant;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.dto.LoginDto;
import com.icinfo.ndrc.system.dto.SysUserDto;
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
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/credit/admin")
public class CreditLoginController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(CreditLoginController.class);
    
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
     * 进入信用临安后台首页
     *
     * @return
     */
    @RequestMapping(value = "/index")
    @ResponseBody
    public ModelAndView doEnCreditIndex(HttpSession session) throws Exception {
    	ModelAndView mv = new ModelAndView("credit/system/index");
        UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
        if (userProfile != null) {
            //用户显示菜单
            mv.addObject("menus", userProfile.getMenus());
            mv.addObject("userProfile", userProfile);
        }
    	return mv;
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
        //验证码校验
//        String checkCode = session.getAttribute(DefaultCaptchaServlet.getSessionKey()) + "";
//        if (!loginDto.getCheckCode().equalsIgnoreCase(checkCode)) {
//            return AjaxResult.error("验证码输入错误");
//        }
//        session.removeAttribute(DefaultCaptchaServlet.getSessionKey());
        try {
            SysUser tmpSysUser=sysUserService.selectByUserNameAndUserType(loginDto.getUsername(),loginDto.getUserType());
            if(tmpSysUser==null){
                return AjaxResult.error("登录失败,系统中没有该用户信息,请检查用户名或密码是否正确!");
            }
            if(!"2".equals(tmpSysUser.getUserType())){
                return AjaxResult.error("登录失败,该用户不属于临安门户系统范围,请联系管理员!");
            }
//            if(tmpSysUser!=null&&"0".equals(tmpSysUser.getStatus())){
//            	return AjaxResult.error("登录失败,该用户已失效!");
//            }
            LoginToken loginToken = new LoginToken(loginDto.getUsername(), loginDto.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(loginToken);
            session.setAttribute(Constants.SESSION_SYS_USER_KEY, subject.getPrincipal());

            //将登陆用户SysUser放入Session
            UserProfile userProfile = (UserProfile)subject.getPrincipal();
    		SysUserDto sysUser = sysUserService.selectForCredit(userProfile.getUserId());

            sysUser.setUserType(Constants.CREDIT_USER_TYPE);
            sysUser.setLogCode(LogTypeConstant.LogLogin.getLogCode());
            sysUser.setLogMsg(LogTypeConstant.LogLogin.getLogMsg());
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
        return "redirect:/xylogin";
    }
}
