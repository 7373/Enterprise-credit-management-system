/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月08日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.ndrc.credit.dto.NdCreditAppealDto;
import com.icinfo.ndrc.credit.model.NdCreditAppeal;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    nd_credit_appeal 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月08日
 */
public interface NdCreditAppealMapper extends Mapper<NdCreditAppeal> {
	
	List<NdCreditAppealDto> selectNdCreditAppealList(Map<String,Object> qryMap);
	/**
	 * 更新
	 * @author fanzhen
	 * @date 20170614
	 * @param dto
	 * @return
	 */
	int UpdateNdCreditAppealDto(NdCreditAppeal dto);
}