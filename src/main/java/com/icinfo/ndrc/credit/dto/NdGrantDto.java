/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.dto;

import com.icinfo.ndrc.credit.model.NdGrant;

import java.util.Date;

/**
 * 描述:    nd_grant 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年06月26日
 */
public class NdGrantDto extends NdGrant {

    private String graUserName;


    public Date getGraStartLineDesc() {
        return this.getGraStartLine();
    }
    public Date getGraDeadLineDesc() {
        return this.getGraDeadLine();
    }
    public String getGraUserName() {
        return graUserName;
    }

    public void setGraUserName(String graUserName) {
        this.graUserName = graUserName;
    }
}