/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:  SysPermision 实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年04月14日
 */
@Table(name = "SYS_PERMISION")
public class SysPermision implements Serializable{
	@Id
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 资源名称
     */
    @Column(name = "PERMISION_NAME")
    private String name;

    /**
     * 父资源ID
     */
    @Column(name = "PERMISION_PARENT_ID")
    private String parentId;

    /**
     * 资源类型
     */
    @Column(name = "PERMISION_TYPE")
    private String type;

    /**
     * 排序
     */
    @Column(name = "PERMISION_SORT")
    private Integer sort;

    /**
     * 资源地址
     */
    @Column(name = "PERMISION_URL")
    private String url;

    /**
     * 资源关联地址
     */
    @Column(name = "PERMISION_RELATED_URL")
    private String relatedUrl;

    /**
     * 资源描述
     */
    @Column(name = "PERMISION_DESC")
    private String desc;

    /**
     * 权限状态
     */
    @Column(name = "PERMISION_STATE")
    private String state;

    /**
     * 权限所属类型
     */
    @Column(name = "PERMISION_SYS_TYPE")
    private String permisionSysType;

    public String getPermisionSysType() {
        return permisionSysType;
    }

    public void setPermisionSysType(String permisionSysType) {
        this.permisionSysType = permisionSysType;
    }

    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
     * 获取资源名称
     *
     * @return PERMISION_NAME - 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源名称
     *
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父资源ID
     *
     * @return PERMISION_PARENT_ID - 父资源ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父资源ID
     *
     * @param parentId 父资源ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取资源类型
     *
     * @return PERMISION_TYPE - 资源类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置资源类型
     *
     * @param type 资源类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取排序
     *
     * @return PERMISION_SORT - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取资源地址
     *
     * @return PERMISION_URL - 资源地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置资源地址
     *
     * @param url 资源地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取资源描述
     *
     * @return PERMISION_DESC - 资源描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置资源描述
     *
     * @param desc 资源描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取权限状态
     *
     * @return PERMISION_STATE - 权限状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置权限状态
     *
     * @param state 权限状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取权限关联资源
     *
     * @return PERMISION_RELATD_URL - 权限关联资源
     */
    public String getRelatedUrl() {
        return relatedUrl;
    }
    /**
     * 设置权限关联资源
     *
     * @param relatedUrl 关联资源
     */
    public void setRelatedUrl(String relatedUrl) {
        this.relatedUrl = relatedUrl;
    }
}