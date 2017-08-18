/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.gateway.dto.NdrcNewsPublishDto;
import com.icinfo.ndrc.gateway.model.NdrcNewsPublish;

/**
 * 描述:    NDRC_NEWS_PUBLISH 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月08日
 */
public interface INdrcNewsPublishService extends BaseService {
	
	
	/**
	 *  分页获取新闻资讯发布信息
	 * @author liuguangju
	 * @date 2017-06-08
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<NdrcNewsPublish> queryPage(PageRequest request) throws Exception;
	
	/**
	 * 新增内容采编
	 * @author liuguangju	
	 * @date	2017-06-13
	 * @param newsPublish
	 * @return
	 * @throws Exception
	 */
	public Integer saveNewsCatalog(NdrcNewsPublish newsPublish) throws Exception;

	/**
	 *  获取新闻资讯发布信息详细
	 * @author ylr
	 * @date 2017-06-13
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public NdrcNewsPublish getPublishDetail(String uid) throws Exception;


	/**
	 * 更新内容采编
	 * @author liuguangju	
	 * @date 2017-06-13
	 * @param newsPublish
	 * @return
	 * @throws Exception
	 */
	public Integer updateNewsPublish(NdrcNewsPublish newsPublish) throws Exception;
	
	/**
	 * 内容采编（查看）
	 * @author liuguangju
	 * @date 2017-06-13
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<NdrcNewsPublish> doGetNewsPublishList(Map<String, Object> qryMap) throws Exception;

	/**
	 * 根据Type1Code统计对应目录个数
	 * @author liuguangju
	 * @date 2017-06-23
	 * @param type1Code
	 * @return
	 * @throws Exception
	 */
	public NdrcNewsPublishDto selectCountPublishByType1Code(String type1Code) throws Exception;

	/**
	 * 根据Type2Code统计对应目录个数
	 * @author liuguangju
	 * @date 2017-06-23
	 * @param type2Code
	 * @return
	 * @throws Exception
	 */
	public NdrcNewsPublishDto selectCountPublishByType2Code(String type2Code) throws Exception;
}