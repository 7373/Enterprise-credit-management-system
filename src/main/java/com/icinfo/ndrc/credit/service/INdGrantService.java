/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdGrantDto;
import com.icinfo.ndrc.credit.model.NdGrant;

import java.util.List;
import java.util.Map;

/**
 * 描述:    nd_grant 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月26日
 */
public interface INdGrantService extends BaseService {

    /**
     *@Description 获取用户授权信息
     *@author ylr
     *@date 2017-06-27
     */
    public List<NdGrant> selectNdGrantEffectList(NdGrant ndGrant)throws Exception;
    /**
     *@Description 用户授权
     *@author ylr
     *@date 2017-06-27
     */
    public Integer doSave(NdGrant ndGrant)throws Exception;
    /**
     *@Description 用户授权修改
     *@author ylr
     *@date 2017-06-27
     */
    public Integer doMod(NdGrant ndGrant)throws Exception;
    /**
     *@Description 获取用户授权信息
     *@param map
     *@date 2017-06-27
     */
    public List<NdGrant> selectNdGrantInfoList(PageRequest request)throws Exception;
    /**
     *@Description 获取授权信息详细
     *@param map
     *@date 2017-06-27
     */
    public NdGrantDto selectNdGrantDetail(String uid)throws Exception;


}