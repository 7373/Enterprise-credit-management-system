/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_wage_black_list 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月27日
 */
@Table(name = "nd_wage_black_list")
public class NdWageBlackList implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 企业名称
     */
    @Column(name = "qymc")
    private String qymc;

    @Column(name = "enterprise_id")
    private String enterprise_id;

    /**
     * 工商注册号
     */
    @Column(name = "regno")
    private String regno;

    /**
     * 发生时间
     */
    @Column(name = "StartDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date startDate;

    /**
     * 欠薪额度
     */
    @Column(name = "WageAmount")
    private Long wageAmount;

    /**
     * 取消时间
     */
    @Column(name = "EndDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date endDate;

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

    /**
     * 获取企业名称
     *
     * @return qymc - 企业名称
     */
    public String getQymc() {
        return qymc;
    }

    /**
     * 设置企业名称
     *
     * @param qymc 企业名称
     */
    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    /**
     * 获取工商注册号
     *
     * @return regno - 工商注册号
     */
    public String getRegno() {
        return regno;
    }

    /**
     * 设置工商注册号
     *
     * @param regno 工商注册号
     */
    public void setRegno(String regno) {
        this.regno = regno;
    }

    /**
     * 获取发生时间
     *
     * @return StartDate - 发生时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置发生时间
     *
     * @param startDate 发生时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取欠薪额度
     *
     * @return WageAmount - 欠薪额度
     */
    public Long getWageAmount() {
        return wageAmount;
    }

    /**
     * 设置欠薪额度
     *
     * @param wageAmount 欠薪额度
     */
    public void setWageAmount(Long wageAmount) {
        this.wageAmount = wageAmount;
    }

    /**
     * 获取取消时间
     *
     * @return EndDate - 取消时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置取消时间
     *
     * @param endDate 取消时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
}