/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service.impl;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.gateway.dto.NdrcNewsPublishDto;
import com.icinfo.ndrc.gateway.mapper.NdrcNewsPublishMapper;
import com.icinfo.ndrc.gateway.model.NdrcCatalog2;
import com.icinfo.ndrc.gateway.model.NdrcNewsPublish;
import com.icinfo.ndrc.gateway.service.INdrcNewsPublishService;

/**
 * 描述:    NDRC_NEWS_PUBLISH 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月08日
 */
@Service
public class NdrcNewsPublishServiceImpl extends MyBatisServiceSupport implements INdrcNewsPublishService {

	@Autowired
	NdrcNewsPublishMapper ndrcNewsPublishMapper;
	
	/**
	 * 分页获取新闻资讯发布信息
	 * @author liuguangju
	 * @date 2017-06-08
	 */
	@Override
	public List<NdrcNewsPublish> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		List<NdrcNewsPublish> list = ndrcNewsPublishMapper.selectNdrcNewsPublishMapper(request.getParams());
		if("2008".equals(request.getParams().get("type2Code"))){
			for(NdrcNewsPublish pub:list){
				String[] str = pub.getFilePath().split("\\|");
				pub.setFilePath(File.separator+"file"+File.separator+str[0]);
			}
		}
		return list;
	}

	/**
	 *  获取新闻资讯发布信息详细
	 * @author ylr
	 * @date 2017-06-13
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public NdrcNewsPublish getPublishDetail(String uid) throws Exception{
		Example example = new Example(NdrcNewsPublish.class);
		example.createCriteria().andEqualTo("UID",uid);
		return ndrcNewsPublishMapper.selectByExample(example).get(0);
	}
	
	/**
	 * 新增内容采编
	 * @author liuguangju	
	 * @date	2017-06-13
	 */
	@Override
	public Integer saveNewsCatalog(NdrcNewsPublish newsPublish) throws Exception {
		return ndrcNewsPublishMapper.insert(newsPublish);
	}

	/**
	 * 更新内容采编
	 * @author liuguangju	
	 * @date 2017-06-13
	 */
	@Override
	public Integer updateNewsPublish(NdrcNewsPublish newsPublish) throws Exception {
		if (newsPublish == null || isEmpty(newsPublish.getUID())) {
            return null;
        }
        Example example = new Example(NdrcCatalog2.class);
        example.createCriteria().andEqualTo("UID", newsPublish.getUID());
		return ndrcNewsPublishMapper.updateByExampleSelective(newsPublish, example);
	}

	/**
	 * 内容采编（查看）
	 * @author liuguangju
	 * @date 2017-06-13
	 */
	@Override
	public List<NdrcNewsPublish> doGetNewsPublishList(Map<String, Object> qryMap) throws Exception {
		return ndrcNewsPublishMapper.selectNdrcNewsPublishMapper(qryMap);
	}

	/**
	 * 根据Type1Code统计对应目录个数
	 * @author liuguangju
	 * @date 2017-06-23
	 */
	@Override
	public NdrcNewsPublishDto selectCountPublishByType1Code(String type1Code) throws Exception {
		
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("type1Code", type1Code);
		
		return ndrcNewsPublishMapper.selectCountPublish(qryMap);
	}

	/**
	 * 根据Type2Code统计对应目录个数
	 * @author liuguangju
	 * @date 2017-06-23
	 */
	@Override
	public NdrcNewsPublishDto selectCountPublishByType2Code(String type2Code) throws Exception {
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("type2Code", type2Code);
		
		return ndrcNewsPublishMapper.selectCountPublish(qryMap);
	}

	

}