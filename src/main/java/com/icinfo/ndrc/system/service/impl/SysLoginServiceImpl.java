/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.service.impl;

import com.icinfo.framework.security.shiro.LoginToken;
import com.icinfo.framework.security.shiro.ShiroSecurityService;
import com.icinfo.framework.security.shiro.UserProfile;
import com.icinfo.framework.tools.utils.StringUtils;
import com.icinfo.ndrc.system.model.SysPermision;
import com.icinfo.ndrc.system.model.SysUser;
import com.icinfo.ndrc.system.service.ISysPermisionService;
import com.icinfo.ndrc.system.service.ISysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.*;

/**
 * 描述:  系统用户登录.<br>
 *
 * @author xiajunwei
 * @date 2016年06月12日
 */
@Service("sysLoginService")
public class SysLoginServiceImpl implements ShiroSecurityService {
    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysPermisionService sysPermisionService;

    private static final String DEFAULT_PREMISSION_STRING = "perms[{0}]";

    @Override
    public UserProfile doGetUserProfile(LoginToken token) throws AuthenticationException {
        SysUser sysUser = null;
        try {
            sysUser = sysUserService.selectByUserName(token.getUsername());
        } catch (Exception e) {

        }
        if (sysUser == null) {
            return null;
        }

        UserProfile userProfile = new UserProfile();
        //基本信息
        userProfile.setUserId(sysUser.getUid());
        userProfile.setUsername(sysUser.getUsername());
        userProfile.setPassword(sysUser.getPassword());
        userProfile.setPasswordSalt(sysUser.getPasswordSalt());
        userProfile.setRealName(sysUser.getRealName());
        //用户权限
        List<SysPermision> permisionList = sysPermisionService.selectUserPermisions(sysUser.getUid());

        //权限
        Set<String> permisions = new HashSet<String>();
        //菜单
        Map<String, List> menus = new HashMap<String, List>();
        for (SysPermision permision : permisionList) {
            permisions.add(permision.getUrl());
            if ("1".equals(permision.getType())) {
                if (org.apache.commons.lang3.StringUtils.isBlank(permision.getParentId())) {
                    //根菜单
                    if (!menus.containsKey("-1")) {
                        menus.put("-1", new ArrayList<SysPermision>());
                    }
                    menus.get("-1").add(permision);
                } else {
                    //子菜单
                    String parentId = permision.getParentId();
                    if (!menus.containsKey(parentId)) {
                        menus.put(parentId, new ArrayList<SysPermision>());
                    }
                    menus.get(parentId).add(permision);
                }
            }
            //关联权限资源
            if (StringUtils.isNotBlank(permision.getRelatedUrl())) {
                String[] perms = permision.getRelatedUrl().split(",");
                for (String perm : perms) {
                    if (StringUtils.isNotEmpty(perm) && perm.startsWith("/")) {
                        permisions.add(perm);
                    }
                }
            }

        }
        userProfile.setPermissions(permisions);
        userProfile.setMenus(menus);
        return userProfile;
    }

    @Override
    public Map<String, String> doGetDynamicPermisions() {
        List<SysPermision> permisionList = sysPermisionService.selectAll();
        Map<String, String> permisions = new HashMap<>();
        for (SysPermision permision : permisionList) {
            String url = permision.getUrl();
            if (StringUtils.isNotEmpty(url) && url.startsWith("/")) {
                permisions.put(url, MessageFormat.format(DEFAULT_PREMISSION_STRING, url));
                //关联资源处理
                if (StringUtils.isNotBlank(permision.getRelatedUrl())) {
                    String[] perms = permision.getRelatedUrl().split(",");
                    for (String perm : perms) {
                        if (StringUtils.isNotEmpty(perm) && perm.startsWith("/")) {
                            permisions.put(perm, MessageFormat.format(DEFAULT_PREMISSION_STRING, perm));
                        }
                    }
                }
            }
        }
        return permisions;
    }
}
