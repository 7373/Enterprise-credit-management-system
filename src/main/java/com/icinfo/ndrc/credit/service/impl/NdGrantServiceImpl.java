/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdGrantDto;
import com.icinfo.ndrc.credit.mapper.NdGrantMapper;
import com.icinfo.ndrc.credit.model.NdGrant;
import com.icinfo.ndrc.credit.service.INdGrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:    nd_grant 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月26日
 */
@Service
public class NdGrantServiceImpl extends MyBatisServiceSupport implements INdGrantService {
    @Autowired
    private NdGrantMapper ndGrantMapper;
    @Override
    public List<NdGrant> selectNdGrantEffectList(NdGrant ndGrant) throws Exception {
        return ndGrantMapper.selectNdGrantEffectList(ndGrant);
    }

    @Override
    public Integer doSave(NdGrant ndGrant) throws Exception {
        return ndGrantMapper.insertSelective(ndGrant);
    }

    @Override
    public Integer doMod(NdGrant ndGrant) throws Exception {
        return ndGrantMapper.updateByPrimaryKeySelective(ndGrant);
    }

	@Override
	public List<NdGrant> selectNdGrantInfoList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		return ndGrantMapper.selectListByMap(request.getParams());
	}

	@Override
	public NdGrantDto selectNdGrantDetail(String uid) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("uid", uid);
		return ndGrantMapper.selectNdGrantDetailByMap(map);
	}
}