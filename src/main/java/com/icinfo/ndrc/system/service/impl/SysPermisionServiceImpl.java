/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.service.impl;

import com.icinfo.framework.common.exception.GenericException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.tools.utils.StringUtils;
import com.icinfo.ndrc.system.mapper.SysPermisionMapper;
import com.icinfo.ndrc.system.model.SysPermision;
import com.icinfo.ndrc.system.service.ISysPermisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 描述:  系统权限业务.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
@Service
public class SysPermisionServiceImpl extends MyBatisServiceSupport implements ISysPermisionService {
    /**
     * 用户权限mapper注入
     */
    @Autowired
    private SysPermisionMapper sysPermisionMapper;

    /**
     * 添加系统权限
     *
     * @param sysPermision
     * @return
     * @throws Exception
     */
    @Override
    public int insert(SysPermision sysPermision) throws Exception {
        if (!"1".equals(sysPermision.getType())) {
            sysPermision.setType("0");
        }
        if (StringUtils.isNotBlank(sysPermision.getParentId())) {
            SysPermision parent = selectByPrimaryKey(sysPermision.getParentId());
            if (parent == null) {
                throw new GenericException("添加失败，上级权限不存在");
            }
            if ("0".equals(parent.getType())) {
                throw new GenericException("添加失败，操作权限不允许有子菜单权限。");
            }
        }
        if (sysPermision.getSort() == null) {
            sysPermision.setSort(0);
        }
        return sysPermisionMapper.insert(sysPermision);
    }

    /**
     * 加载所有权限数据
     *
     * @return
     */
    @Override
    public List<SysPermision> selectAll() {
        Example example = new Example(SysPermision.class);
        example.setOrderByClause("PERMISION_SORT ASC");
        return sysPermisionMapper.selectByExample(example);
    }

    /**
     * 根据类型加载所有权限数据
     *
     * @return
     */
    @Override
    public List<SysPermision> selectAllByPermisionSysType(String type){
        Example example = new Example(SysPermision.class);
        example.createCriteria().andEqualTo("permisionSysType",type);
        example.setOrderByClause("PERMISION_SORT ASC");
        return sysPermisionMapper.selectByExample(example);
    }

    /**
     * 通过主键获取系统权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public SysPermision selectByPrimaryKey(String uid) throws Exception {
    	Example example = new Example(SysPermision.class);
    	example.createCriteria().andEqualTo("uid", uid);
        return sysPermisionMapper.selectByExample(example).get(0);
        
        
    }

    /**
     * 通过主键删除系统权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public int deleteByPrimaryKey(String uid) throws Exception {
        if (StringUtils.isEmpty(uid)) {
            throw new IllegalArgumentException("删除失败：uid不能为空");
        }
        if (isHaveSub(uid)) {
            throw new GenericException("删除失败：存在子权限");
        }
        Example example = new Example(SysPermision.class);
    	example.createCriteria().andEqualTo("uid", uid);
        return sysPermisionMapper.deleteByExample(example);
    }

    /**
     * 更新权限数据
     *
     * @param sysPermision
     * @return
     * @throws Exception
     */
    @Override
    public int update(SysPermision sysPermision) throws Exception {
        //不允许修改父子关系
        sysPermision.setParentId(null);
        //不允许修改权限类型
        sysPermision.setType(null);
        Example example = new Example(SysPermision.class);
    	example.createCriteria().andEqualTo("uid", sysPermision.getUid());
        return sysPermisionMapper.updateByExampleSelective(sysPermision, example);
    }

    /**
     * 判断是否存在子权限
     *
     * @param id 权限ID
     * @return
     * @throws Exception
     */
    @Override
    public boolean isHaveSub(String uid) throws Exception {
        if (StringUtils.isEmpty(uid)) {
            throw new IllegalArgumentException("参数错误，id不能为空");
        }
        Example example = new Example(SysPermision.class);
        example.createCriteria().andEqualTo("parentId", uid);
        return sysPermisionMapper.selectCountByExample(example) > 0;
    }

    /**
     * 查询用户权限列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<SysPermision> selectUserPermisions(String userId) {
        if (StringUtils.isBlank(userId)) {
            return new ArrayList<SysPermision>();
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        return sysPermisionMapper.selectUserPermisions(params);
    }
}
