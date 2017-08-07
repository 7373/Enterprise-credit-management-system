/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月28日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.model.TempPublicSchoolInfo;

/**
 * 描述:    temp_public_school_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月28日
 */
public interface TempPublicSchoolInfoMapper extends Mapper<TempPublicSchoolInfo> {
	
	/**
	 * 根据批次号删除
	 * @author fanzhen
	 * @date 20170628
	 * @param BaseNo
	 */
	public void DeleteByBatchNo(String BatchNo);
	
}