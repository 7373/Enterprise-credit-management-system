/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.model.NdTaxCreditLevel;

import java.util.List;

/**
 * 描述:    nd_tax_credit_level 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
public interface INdTaxCreditLevelService extends BaseService {



    /**
     *@Description 获取企业信用等级数据
     *@author ylr
     *@date 2017-06-27
     */
    public List<NdTaxCreditLevel> selectNdTaxCreditLevelList(PageRequest request)throws Exception;

}