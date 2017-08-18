/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_socia_organ_check_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "temp_socia_organ_check_info")
public class TempSociaOrganCheckInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 年检时间
     */
    @Column(name = "CheckDate")
    private Date checkDate;

    /**
     * 社会信用代码/组织机构代码
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 年检结论
     */
    @Column(name = "CheckResult")
    private String checkResult;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    private Date importTime;

    @Column(name = "BatchNO")
    private String batchNO;

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
     * 获取年检时间
     *
     * @return CheckDate - 年检时间
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 设置年检时间
     *
     * @param checkDate 年检时间
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
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
     * 获取年检结论
     *
     * @return CheckResult - 年检结论
     */
    public String getCheckResult() {
        return checkResult;
    }

    /**
     * 设置年检结论
     *
     * @param checkResult 年检结论
     */
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
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
     * @return BatchNO
     */
    public String getBatchNO() {
        return batchNO;
    }

    /**
     * @param batchNO
     */
    public void setBatchNO(String batchNO) {
        this.batchNO = batchNO;
    }

    /**
     * @return IsUse
     */
    public String getIsUse() {
        return isUse;
    }

    /**
     * @param isUse
     */
    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }
}