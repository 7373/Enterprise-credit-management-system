/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.system.service;

import com.icinfo.ndrc.system.model.SysDepart;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;

/**
 * 描述:   机构表 SYS_DEPART 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月07日
 */
public interface ISysDepartService extends BaseService {

    /**
     * 获取部门列表
     *
     * @param departSysType
     * @return
     * @throws Exception
     */
    public List<SysDepart> doGetList(String departSysType) throws Exception;
}