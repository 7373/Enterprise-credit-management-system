/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.mapper.NdFireControlLicenceiInfoMapper;
import com.icinfo.ndrc.credit.mapper.NdTowmSkillCertInfoMapper;
import com.icinfo.ndrc.credit.model.NdFireControlLicenceiInfo;
import com.icinfo.ndrc.credit.model.NdTowmSkillCertInfo;
import com.icinfo.ndrc.credit.service.INdTowmSkillCertInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_towm_skill_cert_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Service
public class NdTowmSkillCertInfoServiceImpl extends MyBatisServiceSupport implements INdTowmSkillCertInfoService {
	/**
	 * 获取数据 @author rah
	 */
	@Autowired
	NdTowmSkillCertInfoMapper ndTowmSkillCertInfoMapper;
	@Override
	public List<NdTowmSkillCertInfo> selectList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return ndTowmSkillCertInfoMapper.selectList(request.getParams());
	}
}