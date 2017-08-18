/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.controller;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.security.shiro.UserProfile;
import com.icinfo.ndrc.support.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 描述: 系统管理首页控制器 .<br>
 *
 * @author xiajunwei
 * @date 2016年3月15日
 */
@Controller
@RequestMapping("/admin")
public class IndexController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * 管理端首页
     *
     * @param session
     * @return
     */
    @RequestMapping
    public ModelAndView index(HttpSession session) {
        ModelAndView view = new ModelAndView("index");
        UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
        if (userProfile != null) {
            //用户显示菜单
            view.addObject("menus", userProfile.getMenus());
            view.addObject("userProfile", userProfile);
        }
        return view;
    }

    /**
     * 管理中心首页
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/dashboard")
    public String dashboard(HttpServletRequest request, HttpServletResponse response) {
        return "dashboard/dashboard";
    }
    /**
     * 进入信用后台管理首页页面
     * @author zjj
     */
    @RequestMapping("/credit/indexViews")
    public ModelAndView indexViews() throws Exception{
    	ModelAndView mv = new ModelAndView("credit/system/credit_welcome");
    	return mv;
    }

}
