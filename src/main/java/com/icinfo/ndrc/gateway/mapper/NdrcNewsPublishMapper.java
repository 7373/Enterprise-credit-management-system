/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月08日
 * @version 2.0
 */
package com.icinfo.ndrc.gateway.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.gateway.dto.NdrcNewsPublishDto;
import com.icinfo.ndrc.gateway.model.NdrcNewsPublish;

/**
 * 描述:    NdrcNewsPublish_NEWS_PUBLISH 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月08日
 */
public interface NdrcNewsPublishMapper extends Mapper<NdrcNewsPublish> {
	
	List<NdrcNewsPublish> selectNdrcNewsPublishMapper(Map<String,Object> qryMap);
	
	NdrcNewsPublishDto selectCountPublish(Map<String,Object> qryMap);
}