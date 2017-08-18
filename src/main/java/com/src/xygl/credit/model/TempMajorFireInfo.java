/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_major_fire_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "temp_major_fire_info")
public class TempMajorFireInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 单位名称
     */
    @Column(name = "UnitName")
    private String unitName;

    /**
     * 单位社会信用代码/工商注册号/组织机构代码
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 存在重大火灾隐患内容
     */
    @Column(name = "FireHiddenContent")
    private String fireHiddenContent;

    /**
     * 认定时间
     */
    @Column(name = "AffirmDate")
    private Date affirmDate;

    /**
     * 认定依据
     */
    @Column(name = "AffirmBasis")
    private String affirmBasis;

    /**
     * 销案日期
     */
    @Column(name = "CloseCaseDate")
    private Date closeCaseDate;

    @Column(name = "ImportDept")
    private String importDept;

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
     * 获取单位名称
     *
     * @return UnitName - 单位名称
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置单位名称
     *
     * @param unitName 单位名称
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取单位社会信用代码/工商注册号/组织机构代码
     *
     * @return Unicode - 单位社会信用代码/工商注册号/组织机构代码
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置单位社会信用代码/工商注册号/组织机构代码
     *
     * @param unicode 单位社会信用代码/工商注册号/组织机构代码
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取存在重大火灾隐患内容
     *
     * @return FireHiddenContent - 存在重大火灾隐患内容
     */
    public String getFireHiddenContent() {
        return fireHiddenContent;
    }

    /**
     * 设置存在重大火灾隐患内容
     *
     * @param fireHiddenContent 存在重大火灾隐患内容
     */
    public void setFireHiddenContent(String fireHiddenContent) {
        this.fireHiddenContent = fireHiddenContent;
    }

    /**
     * 获取认定时间
     *
     * @return AffirmDate - 认定时间
     */
    public Date getAffirmDate() {
        return affirmDate;
    }

    /**
     * 设置认定时间
     *
     * @param affirmDate 认定时间
     */
    public void setAffirmDate(Date affirmDate) {
        this.affirmDate = affirmDate;
    }

    /**
     * 获取认定依据
     *
     * @return AffirmBasis - 认定依据
     */
    public String getAffirmBasis() {
        return affirmBasis;
    }

    /**
     * 设置认定依据
     *
     * @param affirmBasis 认定依据
     */
    public void setAffirmBasis(String affirmBasis) {
        this.affirmBasis = affirmBasis;
    }

    /**
     * 获取销案日期
     *
     * @return CloseCaseDate - 销案日期
     */
    public Date getCloseCaseDate() {
        return closeCaseDate;
    }

    /**
     * 设置销案日期
     *
     * @param closeCaseDate 销案日期
     */
    public void setCloseCaseDate(Date closeCaseDate) {
        this.closeCaseDate = closeCaseDate;
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