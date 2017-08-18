/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月29日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.model.NdRewardInfo;

/**
 * 描述:    nd_reward_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
public interface NdRewardInfoMapper extends Mapper<NdRewardInfo> {
	
	List<NdRewardInfo> selectList(Map<String,Object> qryMap);
}