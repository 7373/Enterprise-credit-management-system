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

import com.icinfo.ndrc.credit.dto.HzcxGrBaseLaDto;
import com.icinfo.ndrc.credit.dto.HzcxQyBaseLaDto;
import com.icinfo.ndrc.credit.model.HzcxGrBaseLa;

import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    HZCX_GR_BASE_LA 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月02日
 */
public interface HzcxGrBaseLaMapper extends Mapper<HzcxGrBaseLa> {



	List<HzcxGrBaseLaDto> selectHzcxGrBaseLaList(Map<String, Object> params);
	public List<HzcxGrBaseLaDto> findByGrId(Map<String,Object> map);
}