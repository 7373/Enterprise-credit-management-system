/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_famous_firm_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "nd_famous_firm_info")
public class NdFamousFirmInfo implements Serializable {
    @Id
    @Column(name = "id")

    private Integer id;
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 社会信用代码/工商注册号
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 字号
     */
    @Column(name = "WordNO")
    private String wordNO;

    /**
     * 认定时间
     */
    @Column(name = "AffirmTime")
    private Date affirmTime;

    /**
     * 有效期
     */
    @Column(name = "ValidTerm")
    private Date validTerm;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    private Date importTime;

    @Column(name = "enterprise_id")
    private String enterprise_id;

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
     * @return EntName - 企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称
     *
     * @param entName 企业名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取社会信用代码/工商注册号
     *
     * @return Unicode - 社会信用代码/工商注册号
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置社会信用代码/工商注册号
     *
     * @param unicode 社会信用代码/工商注册号
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取字号
     *
     * @return WordNO - 字号
     */
    public String getWordNO() {
        return wordNO;
    }

    /**
     * 设置字号
     *
     * @param wordNO 字号
     */
    public void setWordNO(String wordNO) {
        this.wordNO = wordNO;
    }

    /**
     * 获取认定时间
     *
     * @return AffirmTime - 认定时间
     */
    public Date getAffirmTime() {
        return affirmTime;
    }

    /**
     * 设置认定时间
     *
     * @param affirmTime 认定时间
     */
    public void setAffirmTime(Date affirmTime) {
        this.affirmTime = affirmTime;
    }

    /**
     * 获取有效期
     *
     * @return ValidTerm - 有效期
     */
    public Date getValidTerm() {
        return validTerm;
    }

    /**
     * 设置有效期
     *
     * @param validTerm 有效期
     */
    public void setValidTerm(Date validTerm) {
        this.validTerm = validTerm;
    }

    /**
     * @return ImportDept
     */
    public String getImportDept() {
        return importDept;
    }

    /**
     * @param importDept
     */
    public void setImportDept(String importDept) {
        this.importDept = importDept;
    }

    /**
     * @return ImportTime
     */
    public Date getImportTime() {
        return importTime;
    }

    /**
     * @param importTime
     */
    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    /**
     * @return enterprise_id
     */
    public String getEnterprise_id() {
        return enterprise_id;
    }

    /**
     * @param enterprise_id
     */
    public void setEnterprise_id(String enterprise_id) {
        this.enterprise_id = enterprise_id;
    }
}