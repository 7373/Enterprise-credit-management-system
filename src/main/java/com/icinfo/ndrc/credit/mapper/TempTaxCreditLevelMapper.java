/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月29日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.model.TempTaxCreditLevel;

/**
 * 描述:    temp_tax_credit_level 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
public interface TempTaxCreditLevelMapper extends Mapper<TempTaxCreditLevel> {
	
	/**
	 * 根据批次号删除
	 * @param BatchNo
	 */
	public void deleteByBatchNo(String batchNO);
}