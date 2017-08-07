/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年07月03日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.model.TempLawFirmAssessInfo;

/**
 * 描述:    temp_law_firm_assess_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年07月03日
 */
public interface TempLawFirmAssessInfoMapper extends Mapper<TempLawFirmAssessInfo> {

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年7月3日上午11:01:15
	 * @param params
	 * @return
	 */
	List<TempLawFirmAssessInfo> selectList(Map<String, Object> params);
}