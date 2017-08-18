/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;
import java.util.Map;

import com.icinfo.ndrc.credit.dto.HzcxGrBaseLaDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    HZCX_GR_BASE_LA 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月02日
 */
public interface IHzcxGrBaseLaService extends BaseService {
   /**
    * 查询个人信息
    * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
    * @author  ranah
    * @when   2017年6月13日下午4:47:45
    * @param request
    * @return
    * @throws Exception
    */
	List<HzcxGrBaseLaDto> doGetList(PageRequest request) throws Exception;
   /**
    * 根据ID查询个人信息
    * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
    * @author  ranah
    * @when   2017年6月13日下午4:48:07
    * @param map
    * @return
    */
	List<HzcxGrBaseLaDto> findById(Map<String, Object> map);
}