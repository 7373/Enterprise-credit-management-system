/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_qy_head_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_qy_head_info")
public class TempQyHeadInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uid
     */
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 联系电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 导入部门
     */
    @Column(name = "ImportDept")
    private String importDept;

    /**
     * 导入日期
     */
    @Column(name = "ImportTime")
    private Date importTime;

    /**
     * 批次号
     */
    @Column(name = "BatchNO")
    private String batchNO;

    /**
     * 0:未删除，1:已删除
     */
    @Column(name = "IsUse")
    private String isUse;

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
     * 获取uid
     *
     * @return uid - uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uid
     *
     * @param uid uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取导入部门
     *
     * @return ImportDept - 导入部门
     */
    public String getImportDept() {
        return importDept;
    }

    /**
     * 设置导入部门
     *
     * @param importDept 导入部门
     */
    public void setImportDept(String importDept) {
        this.importDept = importDept;
    }

    /**
     * 获取导入日期
     *
     * @return ImportTime - 导入日期
     */
    public Date getImportTime() {
        return importTime;
    }

    /**
     * 设置导入日期
     *
     * @param importTime 导入日期
     */
    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    /**
     * 获取批次号
     *
     * @return BatchNO - 批次号
     */
    public String getBatchNO() {
        return batchNO;
    }

    /**
     * 设置批次号
     *
     * @param batchNO 批次号
     */
    public void setBatchNO(String batchNO) {
        this.batchNO = batchNO;
    }

    /**
     * 获取0:未删除，1:已删除
     *
     * @return IsUse - 0:未删除，1:已删除
     */
    public String getIsUse() {
        return isUse;
    }

    /**
     * 设置0:未删除，1:已删除
     *
     * @param isUse 0:未删除，1:已删除
     */
    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }
}