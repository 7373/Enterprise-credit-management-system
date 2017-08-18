/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月20日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.model.TempSafeProduceLincence;

/**
 * 描述:    temp_safe_produce_licence 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月20日
 */
public interface TempSafeProduceLincenceMapper extends Mapper<TempSafeProduceLincence> {
	
	/**
	 * 根据Map来查询数据
	 * @author fanzhen
	 * @date 20170620
	 * @param map
	 * @return
	 */
	public List<TempSafeProduceLincence> findByMap(Map<String,Object> map);
}