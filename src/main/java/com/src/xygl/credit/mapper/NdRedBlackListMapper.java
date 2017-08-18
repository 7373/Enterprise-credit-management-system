/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月19日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.dto.NdRedBlackListDto;
import com.icinfo.ndrc.credit.model.NdRedBlackList;

/**
 * 描述:    nd_red_black_list 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月19日
 */
public interface NdRedBlackListMapper extends Mapper<NdRedBlackList> {
	
	List<NdRedBlackListDto> selectRedBlackList(Map<String,Object> qryMap);
	
	NdRedBlackListDto selectCountRedBlack(Map<String,Object> qryMap);
}