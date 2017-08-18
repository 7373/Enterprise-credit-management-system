/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.mapper.NdWageBlackListMapper;
import com.icinfo.ndrc.credit.model.NdWageBlackList;
import com.icinfo.ndrc.credit.service.INdWageBlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:    nd_wage_black_list 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
@Service
public class NdWageBlackListServiceImpl extends MyBatisServiceSupport implements INdWageBlackListService {

    @Autowired
    private NdWageBlackListMapper ndWageBlackListMapper;
    @Override
    public List<NdWageBlackList> selectWageBlackList(PageRequest request) throws Exception {
        PageHelper.startPage(request.getStart(),request.getPageNum());
        return ndWageBlackListMapper.selectWageBlackList(request.getParams());
    }
}