/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_ga_admin_force_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "nd_ga_admin_force_info")
public class NdGaAdminForceInfo implements Serializable {
    @Id
    @Column(name = "id")
  
    private Integer id;
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
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
     * 临时查封时间
     */
    @Column(name = "InterimCloseDate")
    private Date interimCloseDate;

    /**
     * 解除临时查封时间
     */
    @Column(name = "RemoveCloseDate")
    private Date removeCloseDate;

    /**
     * 临时查封/解除临时查封文号
     */
    @Column(name = "InterimRemoveCloseDate")
    private String interimRemoveCloseDate;

    /**
     * 强制执行文号
     */
    @Column(name = "ForceExecuteDocNo")
    private String forceExecuteDocNo;

    /**
     * 强制执行内容
     */
    @Column(name = "ForceExecuteContent")
    private String forceExecuteContent;

    /**
     * 强制执行时间
     */
    @Column(name = "ForceExecuteDate")
    private Date forceExecuteDate;

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
     * 获取临时查封时间
     *
     * @return InterimCloseDate - 临时查封时间
     */
    public Date getInterimCloseDate() {
        return interimCloseDate;
    }

    /**
     * 设置临时查封时间
     *
     * @param interimCloseDate 临时查封时间
     */
    public void setInterimCloseDate(Date interimCloseDate) {
        this.interimCloseDate = interimCloseDate;
    }

    /**
     * 获取解除临时查封时间
     *
     * @return RemoveCloseDate - 解除临时查封时间
     */
    public Date getRemoveCloseDate() {
        return removeCloseDate;
    }

    /**
     * 设置解除临时查封时间
     *
     * @param removeCloseDate 解除临时查封时间
     */
    public void setRemoveCloseDate(Date removeCloseDate) {
        this.removeCloseDate = removeCloseDate;
    }

    /**
     * 获取临时查封/解除临时查封文号
     *
     * @return InterimRemoveCloseDate - 临时查封/解除临时查封文号
     */
    public String getInterimRemoveCloseDate() {
        return interimRemoveCloseDate;
    }

    /**
     * 设置临时查封/解除临时查封文号
     *
     * @param interimRemoveCloseDate 临时查封/解除临时查封文号
     */
    public void setInterimRemoveCloseDate(String interimRemoveCloseDate) {
        this.interimRemoveCloseDate = interimRemoveCloseDate;
    }

    /**
     * 获取强制执行文号
     *
     * @return ForceExecuteDocNo - 强制执行文号
     */
    public String getForceExecuteDocNo() {
        return forceExecuteDocNo;
    }

    /**
     * 设置强制执行文号
     *
     * @param forceExecuteDocNo 强制执行文号
     */
    public void setForceExecuteDocNo(String forceExecuteDocNo) {
        this.forceExecuteDocNo = forceExecuteDocNo;
    }

    /**
     * 获取强制执行内容
     *
     * @return ForceExecuteContent - 强制执行内容
     */
    public String getForceExecuteContent() {
        return forceExecuteContent;
    }

    /**
     * 设置强制执行内容
     *
     * @param forceExecuteContent 强制执行内容
     */
    public void setForceExecuteContent(String forceExecuteContent) {
        this.forceExecuteContent = forceExecuteContent;
    }

    /**
     * 获取强制执行时间
     *
     * @return ForceExecuteDate - 强制执行时间
     */
    public Date getForceExecuteDate() {
        return forceExecuteDate;
    }

    /**
     * 设置强制执行时间
     *
     * @param forceExecuteDate 强制执行时间
     */
    public void setForceExecuteDate(Date forceExecuteDate) {
        this.forceExecuteDate = forceExecuteDate;
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