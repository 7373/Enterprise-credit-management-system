/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月02日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.ndrc.credit.dto.HzcxQyBaseLaDto;
import com.icinfo.ndrc.credit.model.HzcxQyBaseLa;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    HZCX_QY_BASE_LA 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月02日
 */
/**
 * 
 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
 * @author  ranah
 * @when   2017年6月8日上午10:31:59
 */
public interface HzcxQyBaseLaMapper extends Mapper<HzcxQyBaseLa> {
	public List<HzcxQyBaseLaDto> selectHzcxQyBaseLaList(Map<String,Object> qryMap);
	public List<HzcxQyBaseLaDto> findByQyId(Map<String,Object> map);



}