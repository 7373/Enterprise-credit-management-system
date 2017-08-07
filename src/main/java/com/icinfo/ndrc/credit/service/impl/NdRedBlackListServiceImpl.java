/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdRedBlackListDto;
import com.icinfo.ndrc.credit.mapper.NdRedBlackListMapper;
import com.icinfo.ndrc.credit.model.NdRedBlackList;
import com.icinfo.ndrc.credit.service.INdRedBlackListService;
import com.icinfo.ndrc.util.DateUtil;

/**
 * 描述:    nd_red_black_list 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月19日
 */
@Service
public class NdRedBlackListServiceImpl extends MyBatisServiceSupport implements INdRedBlackListService {

	@Autowired
	NdRedBlackListMapper ndRedBlackListMapper;
	
	@Override
	public List<NdRedBlackListDto> getRedBlackList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return ndRedBlackListMapper.selectRedBlackList(request.getParams());
	}

	@Override
	public List<NdRedBlackListDto> getQyGrRedBlackList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> map = request.getParams();
		if (map.get("includeListDateStart") != null && StringUtils.isNotBlank(map.get("includeListDateStart").toString())){
			String str = map.get("includeListDateStart").toString();
			map.put("includeListDateStart", DateUtil.getStartDate(str));
		}else{ map.remove("includeListDateStart"); }
		if (map.get("includeListDateEnd") != null && StringUtils.isNotBlank(map.get("includeListDateEnd").toString())){
			map.put("includeListDateEnd", DateUtil.getEndDate(map.get("includeListDateEnd").toString()));
		}else{ map.remove("includeListDateEnd"); }
		return ndRedBlackListMapper.selectRedBlackList(map);
	}

	/**
	 * 获取红黑名单详细信息
     * @author liuguangju
     * @date 2017-06-21
	 */
	@Override
	public NdRedBlackList getRedBlackListDetail(String uid) throws Exception {
		Example example = new Example(NdRedBlackList.class);
		example.createCriteria().andEqualTo("uid", uid);
		return ndRedBlackListMapper.selectByExample(example).get(0);
	}

	/**
	 * 红黑名单数统计
	 * @author liuguangju
	 * @date 2017-06-23
	 */
	@Override
	public NdRedBlackListDto selectCountRedBlack(String listType) throws Exception {
		Map<String ,Object> qryMap = new HashMap<>();
		qryMap.put("listType", listType);
		
		return ndRedBlackListMapper.selectCountRedBlack(qryMap);
	}
}