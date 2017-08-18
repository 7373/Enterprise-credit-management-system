/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service;

import java.util.List;

import com.icinfo.ndrc.gateway.dto.NdrcCatalog2Dto;
import com.icinfo.ndrc.gateway.model.NdrcCatalog2;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    NDRC_CATALOG2 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月09日
 */
public interface INdrcCatalog2Service extends BaseService {
	
	/**
	 * 分页获取频道/栏目页面的目录信息
	 * @author liuguangju
	 * @date 2017-06-09
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<NdrcCatalog2Dto> queryPage(PageRequest request) throws Exception;
	
	/**
	 * 根据一级目录查找对应的二级目录
	 * @param parentID
	 * @return
	 * @throws Exception
	 */
	public List<NdrcCatalog2> selectCatalog2(String parentID)throws Exception;
	
	/**
	 * 查询所有的目录
	 * @author liuguangju
	 * @date 20017-06-12
	 * @return
	 * @throws Exception
	 */
	public List<NdrcCatalog2> selectCatalog2()throws Exception;
	/**
	 * 保存新增目录
	 * @author liuguangju	
	 * @date 2017-06-12
	 * @param ndrcCatalog2
	 * @return
	 * @throws Exception
	 */
	public Integer saveCatalog(NdrcCatalog2 ndrcCatalog2) throws Exception;
	
	
	
	/**
	 * 删除目录
	 * @author liuguangju
	 * @date 2017-06-12
	 * @param ndrcCatalog2
	 * @return
	 * @throws Exception
	 */
	public Integer deleteCatalog(NdrcCatalog2 ndrcCatalog2) throws Exception;
}