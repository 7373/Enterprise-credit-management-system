/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.credit.model.NdTaxCreditLevel;
import com.icinfo.ndrc.credit.service.INdTaxCreditLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 描述:    nd_tax_credit_level 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
@Controller
@RequestMapping("/credit/taxcreditlevel")
public class NdTaxCreditLevelController extends BaseController {
    @Autowired
    private INdTaxCreditLevelService ndTaxCreditLevelService;


    /**
     *@Description 获取信用等级信息
     *@author ylr
     *@date 2017-06-27
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageResponse<NdTaxCreditLevel> doSelectNdTaxCreditLevelList(PageRequest request)throws Exception{
        List<NdTaxCreditLevel> list= ndTaxCreditLevelService.selectNdTaxCreditLevelList(request);

        return new PageResponse<NdTaxCreditLevel>(list);
    }

}