/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.mapper.NdTaxCreditLevelMapper;
import com.icinfo.ndrc.credit.model.NdTaxCreditLevel;
import com.icinfo.ndrc.credit.service.INdTaxCreditLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:    nd_tax_credit_level 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
@Service
public class NdTaxCreditLevelServiceImpl extends MyBatisServiceSupport implements INdTaxCreditLevelService {

    @Autowired
    private NdTaxCreditLevelMapper ndTaxCreditLevelMapper;
    @Override
    public List<NdTaxCreditLevel> selectNdTaxCreditLevelList(PageRequest request) throws Exception {
        PageHelper.startPage(request.getStart(),request.getPageNum());
        return ndTaxCreditLevelMapper.selectNdTaxCreditLevelList(request.getParams());
    }
}