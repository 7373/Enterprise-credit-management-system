/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.system.service.impl;

import com.icinfo.ndrc.system.mapper.SysDepartMapper;
import com.icinfo.ndrc.system.model.SysDepart;
import com.icinfo.ndrc.system.service.ISysDepartService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:   机构表 SYS_DEPART 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月07日
 */
@Service
public class SysDepartServiceImpl extends MyBatisServiceSupport implements ISysDepartService {

    @Autowired
    private SysDepartMapper sysDepartMapper;
    /**
     * 获取部门列表
     *
     * @param departSysType
     * @return
     * @throws Exception
     */
    public List<SysDepart> doGetList(String departSysType) throws Exception{
        Example example = new Example(SysDepart.class);
        example.createCriteria().andEqualTo("dep_sys_type",departSysType);
        return sysDepartMapper.selectByExample(example);
    }
}