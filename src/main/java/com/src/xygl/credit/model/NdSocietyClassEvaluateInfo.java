/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_society_class_evaluate_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "nd_society_class_evaluate_info")
public class NdSocietyClassEvaluateInfo implements Serializable {
    @Id
    @Column(name = "id")

    private Integer id;
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 社会组织评估等级
     */
    @Column(name = "EvaluateClass")
    private String evaluateClass;

    /**
     * 社会信用代码/组织机构代码
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 评估等级有效期
     */
    @Column(name = "EvaluateValidTerm")
    private Date evaluateValidTerm;

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
     * 获取社会组织评估等级
     *
     * @return EvaluateClass - 社会组织评估等级
     */
    public String getEvaluateClass() {
        return evaluateClass;
    }

    /**
     * 设置社会组织评估等级
     *
     * @param evaluateClass 社会组织评估等级
     */
    public void setEvaluateClass(String evaluateClass) {
        this.evaluateClass = evaluateClass;
    }

    /**
     * 获取社会信用代码/组织机构代码
     *
     * @return Unicode - 社会信用代码/组织机构代码
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置社会信用代码/组织机构代码
     *
     * @param unicode 社会信用代码/组织机构代码
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取评估等级有效期
     *
     * @return EvaluateValidTerm - 评估等级有效期
     */
    public Date getEvaluateValidTerm() {
        return evaluateValidTerm;
    }

    /**
     * 设置评估等级有效期
     *
     * @param evaluateValidTerm 评估等级有效期
     */
    public void setEvaluateValidTerm(Date evaluateValidTerm) {
        this.evaluateValidTerm = evaluateValidTerm;
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