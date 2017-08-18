/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月30日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.model.NdEnvironmentEvaluateInfo;

/**
 * 描述:    nd_environment_evaluate_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
public interface NdEnvironmentEvaluateInfoMapper extends Mapper<NdEnvironmentEvaluateInfo> {

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月30日下午1:55:18
	 * @param params
	 * @return
	 */
	List<NdEnvironmentEvaluateInfo> selectList(Map<String, Object> params);
}