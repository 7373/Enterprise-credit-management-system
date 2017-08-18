/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月26日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.dto.NdGrantDto;
import com.icinfo.ndrc.credit.model.NdGrant;

import java.util.List;
import java.util.Map;

/**
 * 描述:    nd_grant 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月26日
 */
public interface NdGrantMapper extends Mapper<NdGrant> {

    List<NdGrant> selectNdGrantEffectList(NdGrant ndGrant);
    List<NdGrant> selectListByMap(Map<String,Object> map);
    NdGrantDto selectNdGrantDetailByMap(Map<String,Object> map);
}