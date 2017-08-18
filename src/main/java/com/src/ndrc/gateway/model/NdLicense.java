/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.gateway.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_license 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月22日
 */
@Table(name = "nd_license")
public class NdLicense implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 编号
     */
    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    @Column(name = "EnterpriseID")
    private String enterpriseID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 法人类型
     */
    @Column(name = "LegalType")
    private String legalType;

    /**
     * 法定代表人
     */
    @Column(name = "LegalPerson")
    private String legalPerson;

    /**
     * 有效期
     */
    @Column(name = "ValidTerm")
    private String validTerm;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 所属区域
     */
    @Column(name = "Area")
    private String area;

    /**
     * 经营地址
     */
    @Column(name = "OperateAddr")
    private String operateAddr;

    /**
     * 经营方式
     */
    @Column(name = "OperateWay")
    private String operateWay;

    /**
     * 储存地址
     */
    @Column(name = "StorageAddr")
    private String storageAddr;

    /**
     * 许可经营范围
     */
    @Column(name = "OperateRange")
    private String operateRange;

    /**
     * 许可证号
     */
    @Column(name = "LicenseNo")
    private String licenseNo;

    @Column(name = "InputDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8" )
    private Date inputDate;

    @Column(name = "MsgOp")
    private Integer msgOp;

    @Column(name = "SeqValue")
    private Integer seqValue;

    @Column(name = "Ycyy")
    private String ycyy;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取编号
     *
     * @return uid - 编号
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置编号
     *
     * @param uid 编号
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return EnterpriseID
     */
    public String getEnterpriseID() {
        return enterpriseID;
    }

    /**
     * @param enterpriseID
     */
    public void setEnterpriseID(String enterpriseID) {
        this.enterpriseID = enterpriseID;
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
     * 获取法人类型
     *
     * @return LegalType - 法人类型
     */
    public String getLegalType() {
        return legalType;
    }

    /**
     * 设置法人类型
     *
     * @param legalType 法人类型
     */
    public void setLegalType(String legalType) {
        this.legalType = legalType;
    }

    /**
     * 获取法定代表人
     *
     * @return LegalPerson - 法定代表人
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法定代表人
     *
     * @param legalPerson 法定代表人
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * 获取有效期
     *
     * @return ValidTerm - 有效期
     */
    public String getValidTerm() {
        return validTerm;
    }

    /**
     * 设置有效期
     *
     * @param validTerm 有效期
     */
    public void setValidTerm(String validTerm) {
        this.validTerm = validTerm;
    }

    /**
     * 获取备注
     *
     * @return Remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取所属区域
     *
     * @return Area - 所属区域
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置所属区域
     *
     * @param area 所属区域
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取经营地址
     *
     * @return OperateAddr - 经营地址
     */
    public String getOperateAddr() {
        return operateAddr;
    }

    /**
     * 设置经营地址
     *
     * @param operateAddr 经营地址
     */
    public void setOperateAddr(String operateAddr) {
        this.operateAddr = operateAddr;
    }

    /**
     * 获取经营方式
     *
     * @return OperateWay - 经营方式
     */
    public String getOperateWay() {
        return operateWay;
    }

    /**
     * 设置经营方式
     *
     * @param operateWay 经营方式
     */
    public void setOperateWay(String operateWay) {
        this.operateWay = operateWay;
    }

    /**
     * 获取储存地址
     *
     * @return StorageAddr - 储存地址
     */
    public String getStorageAddr() {
        return storageAddr;
    }

    /**
     * 设置储存地址
     *
     * @param storageAddr 储存地址
     */
    public void setStorageAddr(String storageAddr) {
        this.storageAddr = storageAddr;
    }

    /**
     * 获取许可经营范围
     *
     * @return OperateRange - 许可经营范围
     */
    public String getOperateRange() {
        return operateRange;
    }

    /**
     * 设置许可经营范围
     *
     * @param operateRange 许可经营范围
     */
    public void setOperateRange(String operateRange) {
        this.operateRange = operateRange;
    }

    /**
     * 获取许可证号
     *
     * @return LicenseNo - 许可证号
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * 设置许可证号
     *
     * @param licenseNo 许可证号
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    /**
     * @return InputDate
     */
    public Date getInputDate() {
        return inputDate;
    }

    /**
     * @param inputDate
     */
    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * @return MsgOp
     */
    public Integer getMsgOp() {
        return msgOp;
    }

    /**
     * @param msgOp
     */
    public void setMsgOp(Integer msgOp) {
        this.msgOp = msgOp;
    }

    /**
     * @return SeqValue
     */
    public Integer getSeqValue() {
        return seqValue;
    }

    /**
     * @param seqValue
     */
    public void setSeqValue(Integer seqValue) {
        this.seqValue = seqValue;
    }

    /**
     * @return Ycyy
     */
    public String getYcyy() {
        return ycyy;
    }

    /**
     * @param ycyy
     */
    public void setYcyy(String ycyy) {
        this.ycyy = ycyy;
    }
}