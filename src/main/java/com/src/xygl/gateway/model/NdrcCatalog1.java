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
 * 描述:    NDRC_CATALOG1 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月09日
 */
@Table(name = "nd_catalog1")
public class NdrcCatalog1 implements Serializable {
    /**
     * id序号
     */
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * UID主键
     */
    @Column(name = "UID")
    private String UID;

    /**
     * 一级分类名称
     */
    @Column(name = "CatalogName")
    private String catalogName;

    @Column(name = "CatalogCode")
    private String catalogCode;
    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id序号
     *
     * @return id - id序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id序号
     *
     * @param id id序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取UID主键
     *
     * @return UID - UID主键
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置UID主键
     *
     * @param UID UID主键
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取一级分类名称
     *
     * @return CatalogName - 一级分类名称
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * 设置一级分类名称
     *
     * @param catalogName 一级分类名称
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    
    
    public String getCatalogCode() {
		return catalogCode;
	}

	public void setCatalogCode(String catalogCode) {
		this.catalogCode = catalogCode;
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
}