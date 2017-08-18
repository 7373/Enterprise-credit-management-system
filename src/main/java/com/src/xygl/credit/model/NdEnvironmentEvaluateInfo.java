/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_environment_evaluate_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "nd_environment_evaluate_info")
public class NdEnvironmentEvaluateInfo implements Serializable {
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
     * 社会信用代码/组织机构代码/工商注册号
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 环境评定等级
     */
    @Column(name = "EvaluateClass")
    private String evaluateClass;

    /**
     * 文件号
     */
    @Column(name = "FileNO")
    private String fileNO;

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
     * 获取社会信用代码/组织机构代码/工商注册号
     *
     * @return Unicode - 社会信用代码/组织机构代码/工商注册号
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置社会信用代码/组织机构代码/工商注册号
     *
     * @param unicode 社会信用代码/组织机构代码/工商注册号
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取环境评定等级
     *
     * @return EvaluateClass - 环境评定等级
     */
    public String getEvaluateClass() {
        return evaluateClass;
    }

    /**
     * 设置环境评定等级
     *
     * @param evaluateClass 环境评定等级
     */
    public void setEvaluateClass(String evaluateClass) {
        this.evaluateClass = evaluateClass;
    }

    /**
     * 获取文件号
     *
     * @return FileNO - 文件号
     */
    public String getFileNO() {
        return fileNO;
    }

    /**
     * 设置文件号
     *
     * @param fileNO 文件号
     */
    public void setFileNO(String fileNO) {
        this.fileNO = fileNO;
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