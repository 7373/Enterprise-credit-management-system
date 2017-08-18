/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.service.impl;

import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.tools.utils.StringUtils;
import com.icinfo.ndrc.system.mapper.SysUserRoleMapper;
import com.icinfo.ndrc.system.model.SysUserRole;
import com.icinfo.ndrc.system.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:  用户角色业务实现.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
@Service
public class SysUserRoleServiceImpl extends MyBatisServiceSupport implements ISysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 通过主键删除用户角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public int deleteByPrimaryKey(String id) throws Exception {
        return sysUserRoleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 删除用户所有角色
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public int deleteByUserId(String userId) throws Exception {
        Example example = new Example(SysUserRole.class);
        example.createCriteria().andEqualTo("userId", userId);
        return sysUserRoleMapper.deleteByExample(example);
    }

    /**
     * 添加用户角色
     *
     * @param userRoles
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(List<SysUserRole> userRoles) throws Exception {
        for (SysUserRole userRole : userRoles) {
            if (sysUserRoleMapper.insert(userRole) <= 0) {
                throw new BusinessException("保存用户角色失败");
            }
        }
        return userRoles.size();
    }

    /**
     * 获取用户角色信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<SysUserRole> selectByUserId(String userId) throws Exception {
        if (StringUtils.isBlank(userId)) {
            return new ArrayList<SysUserRole>();
        }
        Example example = new Example(SysUserRole.class);
        example.createCriteria().andEqualTo("userId", userId);
        return sysUserRoleMapper.selectByExample(example);
    }
}
