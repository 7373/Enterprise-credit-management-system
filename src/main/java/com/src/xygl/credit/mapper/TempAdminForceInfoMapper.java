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
import com.icinfo.ndrc.credit.dto.TempAdminForceInfoDto;
import com.icinfo.ndrc.credit.model.TempAdminForceInfo;

/**
 * 描述:    temp_admin_force_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月22日
 */
public interface TempAdminForceInfoMapper extends Mapper<TempAdminForceInfo> {
	List<TempAdminForceInfoDto> selectListByMap(Map<String, Object> map);
}