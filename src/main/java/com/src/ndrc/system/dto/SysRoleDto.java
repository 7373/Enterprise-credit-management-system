/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.dto;

import com.icinfo.ndrc.system.model.SysRole;

/**
 * 描述:  系统角色DTO.<br>
 *
 * @author xiajunwei
 * @date 2016年05月16日
 */
public class SysRoleDto extends SysRole {
    /**
     * 权限列表
     */
	private String id;
	
    private String[] permisions;

    public String[] getPermisions() {
        return permisions;
    }

    public void setPermisions(String[] permisions) {
        this.permisions = permisions;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
    
}
