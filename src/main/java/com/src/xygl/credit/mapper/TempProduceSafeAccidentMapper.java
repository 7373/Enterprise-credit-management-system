/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月22日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.dto.TempProduceSafeAccidentDto;
import com.icinfo.ndrc.credit.model.TempProduceSafeAccident;

/**
 * 描述:    temp_produce_safe_accident 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月22日
 */
public interface TempProduceSafeAccidentMapper extends Mapper<TempProduceSafeAccident> {
	/**
	 * 查询生产安全事故信息。
	 * @param map
	 * @return
	 */
	List<TempProduceSafeAccidentDto> selectListByMap(Map<String,Object> map);
}