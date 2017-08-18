/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月09日
 * @version 2.0
 */
package com.icinfo.ndrc.gateway.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.ndrc.gateway.dto.NdrcCatalog2Dto;
import com.icinfo.ndrc.gateway.model.NdrcCatalog2;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    NDRC_CATALOG2 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月09日
 */
public interface NdrcCatalog2Mapper extends Mapper<NdrcCatalog2> {
	
	List<NdrcCatalog2Dto> selectNdrcCatalogMapper(Map<String,Object> qryMap);
	
	List<NdrcCatalog2> selectCatalog2Mapper(String parentID);
	
	List<NdrcCatalog2> selectCatalog();
}