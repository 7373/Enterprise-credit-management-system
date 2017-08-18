/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:   机构表 SYS_DEPART 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月07日
 */
@Table(name = "SYS_DEPART")
public class SysDepart implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 部门code
     */
    @Column(name = "dep_code")
    private String dep_code;

    /**
     * 上级code
     */
    @Column(name = "dep_pcode")
    private String dep_pcode;

    /**
     * 部门名称
     */
    @Column(name = "dep_name")
    private String dep_name;

    /**
     * 部门大类 政府：1   银行：2
     */
    @Column(name = "dep_type")
    private String dep_type;

    /**
     * 部门备注
     */
    @Column(name = "dep_remark")
    private String dep_remark;

    /**
     * 设置日期
     */
    @Column(name = "dep_set_date")
    private Date dep_set_date;

    /**
     * 设置人
     */
    @Column(name = "dep_set_name")
    private String dep_set_name;

    /**
     * 排序
     */
    @Column(name = "dep_order_no")
    private String dep_order_no;

    /**
     * 部门所属系统类别：1临安门户，2信用临安
     */
    @Column(name = "dep_sys_type")
    private String dep_sys_type;

    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取部门code
     *
     * @return dep_code - 部门code
     */
    public String getDep_code() {
        return dep_code;
    }

    /**
     * 设置部门code
     *
     * @param dep_code 部门code
     */
    public void setDep_code(String dep_code) {
        this.dep_code = dep_code;
    }

    /**
     * 获取上级code
     *
     * @return dep_pcode - 上级code
     */
    public String getDep_pcode() {
        return dep_pcode;
    }

    /**
     * 设置上级code
     *
     * @param dep_pcode 上级code
     */
    public void setDep_pcode(String dep_pcode) {
        this.dep_pcode = dep_pcode;
    }

    /**
     * 获取部门名称
     *
     * @return dep_name - 部门名称
     */
    public String getDep_name() {
        return dep_name;
    }

    /**
     * 设置部门名称
     *
     * @param dep_name 部门名称
     */
    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    /**
     * 获取部门大类 政府：1   银行：2
     *
     * @return dep_type - 部门大类 政府：1   银行：2
     */
    public String getDep_type() {
        return dep_type;
    }

    /**
     * 设置部门大类 政府：1   银行：2
     *
     * @param dep_type 部门大类 政府：1   银行：2
     */
    public void setDep_type(String dep_type) {
        this.dep_type = dep_type;
    }

    /**
     * 获取部门备注
     *
     * @return dep_remark - 部门备注
     */
    public String getDep_remark() {
        return dep_remark;
    }

    /**
     * 设置部门备注
     *
     * @param dep_remark 部门备注
     */
    public void setDep_remark(String dep_remark) {
        this.dep_remark = dep_remark;
    }

    /**
     * 获取设置日期
     *
     * @return dep_set_date - 设置日期
     */
    public Date getDep_set_date() {
        return dep_set_date;
    }

    /**
     * 设置设置日期
     *
     * @param dep_set_date 设置日期
     */
    public void setDep_set_date(Date dep_set_date) {
        this.dep_set_date = dep_set_date;
    }

    /**
     * 获取设置人
     *
     * @return dep_set_name - 设置人
     */
    public String getDep_set_name() {
        return dep_set_name;
    }

    /**
     * 设置设置人
     *
     * @param dep_set_name 设置人
     */
    public void setDep_set_name(String dep_set_name) {
        this.dep_set_name = dep_set_name;
    }

    /**
     * 获取排序
     *
     * @return dep_order_no - 排序
     */
    public String getDep_order_no() {
        return dep_order_no;
    }

    /**
     * 设置排序
     *
     * @param dep_order_no 排序
     */
    public void setDep_order_no(String dep_order_no) {
        this.dep_order_no = dep_order_no;
    }

    /**
     * 获取部门所属系统类别：1临安门户，2信用临安
     *
     * @return dep_sys_type - 部门所属系统类别：1临安门户，2信用临安
     */
    public String getDep_sys_type() {
        return dep_sys_type;
    }

    /**
     * 设置部门所属系统类别：1临安门户，2信用临安
     *
     * @param dep_sys_type 部门所属系统类别：1临安门户，2信用临安
     */
    public void setDep_sys_type(String dep_sys_type) {
        this.dep_sys_type = dep_sys_type;
    }
}