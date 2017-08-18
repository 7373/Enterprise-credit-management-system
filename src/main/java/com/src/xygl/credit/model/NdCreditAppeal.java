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
 * 描述:    nd_credit_appeal 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月08日
 */
@Table(name = "nd_credit_appeal")
public class NdCreditAppeal implements Serializable {
	
	@Id
    @Column(name = "id")
    private Integer id;
	
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 申诉人/企业/机构名称
     */
    @Column(name = "AppealName")
    private String appealName;

    /**
     * 申诉机构
     */
    @Column(name = "AppealOrgan")
    private String appealOrgan;

    /**
     * 证件类型
     */
    @Column(name = "CertType")
    private String certType;
    /**
     * 证件类型
     */
    @Column(name = "CertNO")
    private String certNO;
    /**
     * 联系邮箱
     */
    @Column(name = "Email")
    private String email;

    /**
     * 联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 标题
     */
    @Column(name = "Title")
    private String title;

    /**
     * 申请内容
     */
    @Column(name = "AppealContent")
    private String appealContent;

    /**
     * 相关证明材料
     */
    @Column(name = "ProveMaterial")
    private String proveMaterial;

    /**
     * 到期状态
     */
    @Column(name = "EndState")
    private String endState;

    /**
     * 申请人id
     */
    @Column(name = "AppealId")
    private String appealId;

    /**
     * 处理人id
     */
    @Column(name = "HandleId")
    private String handleId;

    /**
     * 处理人
     */
    @Column(name = "HandlePerson")
    private String handlePerson;
    
    /**
     * 申请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 处理时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "HandleTime")
    private Date handleTime;

    /**
     * 发起来源
     */
    @Column(name = "AppealSource")
    private String appealSource;

    /**
     * 处理结果
     */
    @Column(name = "HandleResult")
    private String handleResult;

    /**
     * 处理备注
     */
    @Column(name = "HandleRemark")
    private String handleRemark;
    
    @Transient
    private String isOverDate;
    
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
     * 获取申诉人/企业/机构名称
     *
     * @return AppealName - 申诉人/企业/机构名称
     */
    public String getAppealName() {
        return appealName;
    }

    /**
     * 设置申诉人/企业/机构名称
     *
     * @param appealName 申诉人/企业/机构名称
     */
    public void setAppealName(String appealName) {
        this.appealName = appealName;
    }

    /**
     * 获取申诉机构
     *
     * @return AppealOrgan - 申诉机构
     */
    public String getAppealOrgan() {
        return appealOrgan;
    }

    /**
     * 设置申诉机构
     *
     * @param appealOrgan 申诉机构
     */
    public void setAppealOrgan(String appealOrgan) {
        this.appealOrgan = appealOrgan;
    }

    /**
     * 获取证件类型
     *
     * @return CertType - 证件类型
     */
    public String getCertType() {
        return certType;
    }

    /**
     * 设置证件类型
     *
     * @param certType 证件类型
     */
    public void setCertType(String certType) {
        this.certType = certType;
    }

    /**
     * 获取联系邮箱
     *
     * @return Email - 联系邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置联系邮箱
     *
     * @param email 联系邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取联系电话
     *
     * @return Tel - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取标题
     *
     * @return Title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取申请内容
     *
     * @return AppealContent - 申请内容
     */
    public String getAppealContent() {
        return appealContent;
    }

    /**
     * 设置申请内容
     *
     * @param appealContent 申请内容
     */
    public void setAppealContent(String appealContent) {
        this.appealContent = appealContent;
    }

    /**
     * 获取相关证明材料
     *
     * @return ProveMaterial - 相关证明材料
     */
    public String getProveMaterial() {
        return proveMaterial;
    }

    /**
     * 设置相关证明材料
     *
     * @param proveMaterial 相关证明材料
     */
    public void setProveMaterial(String proveMaterial) {
        this.proveMaterial = proveMaterial;
    }

    /**
     * 获取到期状态
     *
     * @return EndState - 到期状态
     */
    public String getEndState() {
        return endState;
    }

    /**
     * 设置到期状态
     *
     * @param endState 到期状态
     */
    public void setEndState(String endState) {
        this.endState = endState;
    }

    /**
     * 获取申请人id
     *
     * @return AppealId - 申请人id
     */
    public String getAppealId() {
        return appealId;
    }

    /**
     * 设置申请人id
     *
     * @param appealId 申请人id
     */
    public void setAppealId(String appealId) {
        this.appealId = appealId;
    }

    /**
     * 获取处理人id
     *
     * @return HandleId - 处理人id
     */
    public String getHandleId() {
        return handleId;
    }

    /**
     * 设置处理人id
     *
     * @param handleId 处理人id
     */
    public void setHandleId(String handleId) {
        this.handleId = handleId;
    }

    /**
     * 获取申请时间
     *
     * @return CreateTime - 申请时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置申请时间
     *
     * @param createTime 申请时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取处理时间
     *
     * @return HandleTime - 处理时间
     */
    public Date getHandleTime() {
        return handleTime;
    }

    /**
     * 设置处理时间
     *
     * @param handleTime 处理时间
     */
    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    /**
     * 获取发起来源
     *
     * @return AppealSource - 发起来源
     */
    public String getAppealSource() {
        return appealSource;
    }

    /**
     * 设置发起来源
     *
     * @param appealSource 发起来源
     */
    public void setAppealSource(String appealSource) {
        this.appealSource = appealSource;
    }

    /**
     * 获取处理结果
     *
     * @return HandleResult - 处理结果
     */
    public String getHandleResult() {
        return handleResult;
    }

    /**
     * 设置处理结果
     *
     * @param handleResult 处理结果
     */
    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    /**
     * 获取处理备注
     *
     * @return HandleRemark - 处理备注
     */
    public String getHandleRemark() {
        return handleRemark;
    }

    /**
     * 设置处理备注
     *
     * @param handleRemark 处理备注
     */
    public void setHandleRemark(String handleRemark) {
        this.handleRemark = handleRemark;
    }

	public String getCertNO() {
		return certNO;
	}

	public void setCertNO(String certNO) {
		this.certNO = certNO;
	}

	public String getHandlePerson() {
		return handlePerson;
	}

	public void setHandlePerson(String handlePerson) {
		this.handlePerson = handlePerson;
	}

	public String getIsOverDate() {
		return isOverDate;
	}

	public void setIsOverDate(String isOverDate) {
		this.isOverDate = isOverDate;
	}
    
    
}