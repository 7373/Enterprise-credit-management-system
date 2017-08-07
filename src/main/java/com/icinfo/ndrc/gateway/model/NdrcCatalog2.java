/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.gateway.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    NDRC_CATALOG2 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月09日
 */
@Table(name = "nd_catalog2")
public class NdrcCatalog2 implements Serializable {
    /**
     * ID序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主键
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 分类名称
     */
    @Column(name = "CatalogName")
    private String catalogName;

    /**
     * 所对应的一级分类UID
     */
    @Column(name = "ParentID")
    private String parentID;

    /**
     * 目录类别
     */
    @Column(name = "CatalogType")
    private String catalogType;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
    
    /**
     * 
     */
    @Column(name = "CatalogCode")
    private Integer catalogCode;

    /**
     * 是否删除（1：已删除；0：未删除）
     */
    @Column(name = "IsDel")
    private String isDel;

    private static final long serialVersionUID = 1L;

    /**
     * 获取ID序号
     *
     * @return id - ID序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID序号
     *
     * @param id ID序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取主键
     *
     * @return UID - 主键
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置主键
     *
     * @param UID 主键
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    public Integer getCatalogCode() {
		return catalogCode;
	}

	public void setCatalogCode(Integer catalogCode) {
		this.catalogCode = catalogCode;
	}

	/**
     * 获取分类名称
     *
     * @return CatalogName - 分类名称
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * 设置分类名称
     *
     * @param catalogName 分类名称
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }


    public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	/**
     * 获取目录类别
     *
     * @return CatalogType - 目录类别
     */
    public String getCatalogType() {
        return catalogType;
    }

    /**
     * 设置目录类别
     *
     * @param catalogType 目录类别
     */
    public void setCatalogType(String catalogType) {
        this.catalogType = catalogType;
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否删除（1：已删除；0：未删除）
     *
     * @return IsDel - 是否删除（1：已删除；0：未删除）
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * 设置是否删除（1：已删除；0：未删除）
     *
     * @param isDel 是否删除（1：已删除；0：未删除）
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
}