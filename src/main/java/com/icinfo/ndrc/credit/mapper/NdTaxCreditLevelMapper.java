/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月27日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.model.NdTaxCreditLevel;

import java.util.List;
import java.util.Map;

/**
 * 描述:    nd_tax_credit_level 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
public interface NdTaxCreditLevelMapper extends Mapper<NdTaxCreditLevel> {


    List<NdTaxCreditLevel> selectNdTaxCreditLevelList(Map<String,Object> qryMap);
}