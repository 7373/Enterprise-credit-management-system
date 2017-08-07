/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.gateway.dto.NdPunishDto;
import com.icinfo.ndrc.gateway.mapper.NdPunishMapper;
import com.icinfo.ndrc.gateway.model.NdPunish;
import com.icinfo.ndrc.gateway.service.INdPunishService;

/**
 * 描述:    nd_punish 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月23日
 */
@Service
public class NdPunishServiceImpl extends MyBatisServiceSupport implements INdPunishService {
	@Autowired
	NdPunishMapper ndPunishMapper;
	@Override
	public List<NdPunishDto> selectListByMap(PageRequest request) {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		List<NdPunishDto> list = ndPunishMapper.selectListByMap(request.getParams());
		return list;
	}
	
	/**
	 * 查询指定uid的七天双公示内容（处罚）
	 */
	@Override
	public NdPunish selectSevenDoubleListDetail(String uid) {
		Example example = new Example(NdPunish.class);
		example.createCriteria().andEqualTo("uid", uid);
		return ndPunishMapper.selectByExample(example).get(0);
	}

	@Override
	public NdPunishDto selectCountAndTime() {
		NdPunishDto ndpunishDto =new NdPunishDto();
		ndpunishDto.setCountNum(ndPunishMapper.doCountNum());
		ndpunishDto.setInputDate(ndPunishMapper.doGetInputTimeLatest());
		return ndpunishDto;
	}
}