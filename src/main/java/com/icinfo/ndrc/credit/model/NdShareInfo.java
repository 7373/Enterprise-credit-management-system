/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    nd_share_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月21日
 */
@Table(name = "nd_share_info")
public class NdShareInfo implements Serializable {
    @Column(name = "id")
    private Integer id;

    @Column(name = "uid")
    private String uid;

    /**
     * 单位名称
     */
    @Column(name = "UnitName")
    private String unitName;

    /**
     * 信息标题
     */
    @Column(name = "InfoTitle")
    private String infoTitle;

    /**
     * 信息分类
     */
    @Column(name = "InfoType")
    private String infoType;

    /**
     * 期数
     */
    @Column(name = "Nper")
    private String nper;

    /**
     * 查看权限
     */
    @Column(name = "SeePermission")
    private String seePermission;

    @Column(name = "DeptCode")
    private String deptCode;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }


    public String getUnitName() {
        return unitName;
    }


    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }


    public String getInfoTitle() {
        return infoTitle;
    }


    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }


    public String getInfoType() {
        return infoType;
    }


    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }


    public String getNper() {
        return nper;
    }

    
    public void setNper(String nper) {
        this.nper = nper;
    }

    public String getSeePermission() {
        return seePermission;
    }


    public void setSeePermission(String seePermission) {
        this.seePermission = seePermission;
    }


    public String getDeptCode() {
        return deptCode;
    }


    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
}