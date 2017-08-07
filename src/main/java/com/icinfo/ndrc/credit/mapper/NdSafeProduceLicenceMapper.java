/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月21日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.model.NdSafeProduceLicence;

/**
 * 描述:    nd_safe_produce_licence 对应的Mapper接口<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
public interface NdSafeProduceLicenceMapper extends Mapper<NdSafeProduceLicence> {
	
	public List<NdSafeProduceLicence> selectDetailByMap(Map<String,Object> map);

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月30日下午3:56:14
	 * @param params
	 * @return
	 */
	public List<NdSafeProduceLicence> selectList(Map<String, Object> params);
}