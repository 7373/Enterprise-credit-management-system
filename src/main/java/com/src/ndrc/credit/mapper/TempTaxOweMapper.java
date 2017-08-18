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
import com.icinfo.ndrc.credit.model.TempTaxOwe;

/**
 * 描述:    temp_tax_owe 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
public interface TempTaxOweMapper extends Mapper<TempTaxOwe> {
	/**
	 * 批次号删除
	 * @author fanzhen
	 * @Date 20170629
	 * @param batchNO
	 */
	public void deleteByBatchNO(String batchNO);
}