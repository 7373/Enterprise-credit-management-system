/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.service.impl;

import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.tools.utils.StringUtils;
import com.icinfo.ndrc.system.mapper.SysRolePermisionMapper;
import com.icinfo.ndrc.system.model.SysRolePermision;
import com.icinfo.ndrc.system.service.ISysRolePermisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:  角色权限业务实现.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
@Service
public class SysRolePermisionServiceImpl extends MyBatisServiceSupport implements ISysRolePermisionService {

    /**
     * 系统角色权限mapper
     */
    @Autowired
    private SysRolePermisionMapper sysRolePermisionMapper;

    /**
     * 查询角色的全部权限
     *
     * @param roleId
     * @return
     */
    @Override
    public List<SysRolePermision> selectAllRolePermision(String roleId) {
        if (StringUtils.isEmpty(roleId)) {
            return new ArrayList<SysRolePermision>();
        }
        Example example = new Example(SysRolePermision.class);
        example.createCriteria().andEqualTo("roleId", roleId);
        return sysRolePermisionMapper.selectByExample(example);
    }

    /**
     * 添加用户角色
     *
     * @param permision
     * @return
     * @throws Exception
     */
    @Override
    public int insert(SysRolePermision permision) throws Exception {
        return sysRolePermisionMapper.insert(permision);
    }

    /**
     * 添加角色权限
     *
     * @param permisions
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(List<SysRolePermision> permisions) throws Exception {
        for (SysRolePermision permision : permisions) {
            if (sysRolePermisionMapper.insert(permision) <= 0) {
                throw new BusinessException("保存角色权限失败");
            }
        }
        return permisions.size();
    }

    /**
     * 删除角色所有权限
     *
     * @param roleId
     * @return
     */
    @Override
    public int deleteByRoleId(String roleId) {
        if (StringUtils.isBlank(roleId)) {
            return 0;
        }
        Example example = new Example(SysRolePermision.class);
        example.createCriteria().andEqualTo("roleId", roleId);
        return sysRolePermisionMapper.deleteByExample(example);
    }
}
