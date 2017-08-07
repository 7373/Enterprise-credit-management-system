/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月27日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.dto.NdUploadHandleDto;
import com.icinfo.ndrc.credit.model.NdUploadHandle;

/**
 * 描述:    nd_upload_handle 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
public interface NdUploadHandleMapper extends Mapper<NdUploadHandle> {
	
	List<NdUploadHandleDto> selectNdUploadHandle(Map<String,Object> qryMap);
}