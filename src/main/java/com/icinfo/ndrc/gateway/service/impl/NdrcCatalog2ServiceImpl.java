/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service.impl;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.ndrc.gateway.dto.NdrcCatalog2Dto;
import com.icinfo.ndrc.gateway.mapper.NdrcCatalog2Mapper;
import com.icinfo.ndrc.gateway.model.NdrcCatalog2;
import com.icinfo.ndrc.gateway.service.INdrcCatalog2Service;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    NDRC_CATALOG2 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月09日
 */
@Service
public class NdrcCatalog2ServiceImpl extends MyBatisServiceSupport implements INdrcCatalog2Service {

	@Autowired
	NdrcCatalog2Mapper ndrcCatalog2Mapper;
	
	/**
	 * 分页获取频道/栏目页面的目录信息
	 * @author liuguangju
	 * @date 2017-06-09
	 */
	@Override
	public List<NdrcCatalog2Dto> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		return ndrcCatalog2Mapper.selectNdrcCatalogMapper(request.getParams());
	}

	/**
	 * 根据一级目录查找对应的二级目录
	 */
	@Override
	public List<NdrcCatalog2> selectCatalog2(String parentID) throws Exception {
		List<NdrcCatalog2> ndrcCatalog2List = ndrcCatalog2Mapper.selectCatalog2Mapper(parentID);
		return ndrcCatalog2List;
	}

	
	/**
	 * 保存新增目录
	 * @author liuguangju	
	 * @date 2017-06-12
	 */
	@Override
	public Integer saveCatalog(NdrcCatalog2 ndrcCatalog2) throws Exception {
		
		return ndrcCatalog2Mapper.insert(ndrcCatalog2);
	}

	
	/**
	 * 删除目录
	 * @author liuguangju
	 * @date 2017-06-12
	 */
	@Override
	public Integer deleteCatalog(NdrcCatalog2 ndrcCatalog2) throws Exception {
		if (ndrcCatalog2 == null || isEmpty(ndrcCatalog2.getUID())) {
            return null;
        }
        Example example = new Example(NdrcCatalog2.class);
        example.createCriteria().andEqualTo("UID", ndrcCatalog2.getUID());
		return ndrcCatalog2Mapper.updateByExampleSelective(ndrcCatalog2, example);
	}

	/**
	 * 查询所有的目录
	 * @author liuguangju
	 * @date 20017-06-12
	 */
	@Override
	public List<NdrcCatalog2> selectCatalog2() throws Exception {
		
		return ndrcCatalog2Mapper.selectCatalog();
	}
}