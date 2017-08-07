/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.system.controller;

import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.model.SysDepart;
import com.icinfo.ndrc.system.service.ISysDepartService;
import com.icinfo.framework.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:   机构表 SYS_DEPART 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月07日
 */
@Controller
@RequestMapping("/credit/department")
public class CreditSysDepartController extends BaseController {

    @Autowired
    private ISysDepartService sysDepartService;

    /**
     * 进入登记机关树页面(单选)
     * @author ylr
     * @date 2017年06月07日
     * @throws Exception
     */
    @RequestMapping("/enRadioTreeSelect")
    public ModelAndView enRadioTreeSelect(String dept) throws Exception{
        ModelAndView view  = new ModelAndView("credit/system/common/credit_dept_radio_tree_select");
        view.addObject("area",dept);
        return view;
    }

    /**
     * 获取登记机关数据
     * @author ylr
     * @date 2017年06月07日
     */
    @RequestMapping("/registTreeList")
    @ResponseBody
    public List<SysDepart> registRadioTreeList() throws Exception{
        List<SysDepart> departmentList = sysDepartService.doGetList(Constants.CREDIT_USER_TYPE);
        return departmentList;
    }



}