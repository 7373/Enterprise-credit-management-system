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
import com.icinfo.ndrc.credit.model.NdFireControlLicenceiInfo;

/**
 * 描述:    nd_fire_control_licence_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
public interface NdFireControlLicenceiInfoMapper extends Mapper<NdFireControlLicenceiInfo> {

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月30日下午3:43:27
	 * @param params
	 * @return
	 */
	List<NdFireControlLicenceiInfo> selectList(Map<String, Object> params);
}