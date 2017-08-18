/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.dto;

import java.io.Serializable;

/**
 * 描述:  .<br>
 *
 * @author xiajunwei
 * @date 2016年05月09日
 */
public class PermisionTreeNode implements Serializable {
    private static final long serialVersionUID = -4238023960294120354L;

    /**
     * 主键
     */
    private String id;

    /**
     * 父ID
     */
    private String pId;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private boolean open = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
