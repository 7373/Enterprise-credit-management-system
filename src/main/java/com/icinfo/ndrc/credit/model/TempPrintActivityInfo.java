/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_print_activity_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "temp_print_activity_info")
public class TempPrintActivityInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uid
     */
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 企业名称
     */
    @Column(name = "QyName")
    private String qyName;

    /**
     * 社会信用代码/组织机构代码/工商注册号
     */
    @Column(name = "Uniscid")
    private String uniscid;

    /**
     * 许可证证号
     */
    @Column(name = "LicenseNo")
    private String licenseNo;

    /**
     * 许可证发证日期
     */
    @Column(name = "LicenseStartDate")
    private Date licenseStartDate;

    /**
     * 许可证说明
     */
    @Column(name = "LicenseInStruction")
    private String licenseInStruction;

    /**
     * 许可证说明
     */
    @Column(name = "Addr")
    private String addr;

    /**
     * 负责人
     */
    @Column(name = "HeadName")
    private String headName;

    /**
     * 负责人身份证号
     */
    @Column(name = "HeadIdCard")
    private String headIdCard;

    /**
     * 联系电话
     */
    @Column(name = "Phone")
    private String phone;

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
    
    /**
     * sheet名
     */
    @Column(name="sheetType")
    private String sheetType;

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
     * 获取uid
     *
     * @return uid - uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uid
     *
     * @param uid uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取企业名称
     *
     * @return QyName - 企业名称
     */
    public String getQyName() {
        return qyName;
    }

    /**
     * 设置企业名称
     *
     * @param qyName 企业名称
     */
    public void setQyName(String qyName) {
        this.qyName = qyName;
    }

    /**
     * 获取社会信用代码/组织机构代码/工商注册号
     *
     * @return Uniscid - 社会信用代码/组织机构代码/工商注册号
     */
    public String getUniscid() {
        return uniscid;
    }

    /**
     * 设置社会信用代码/组织机构代码/工商注册号
     *
     * @param uniscid 社会信用代码/组织机构代码/工商注册号
     */
    public void setUniscid(String uniscid) {
        this.uniscid = uniscid;
    }

    /**
     * 获取许可证证号
     *
     * @return LicenseNo - 许可证证号
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * 设置许可证证号
     *
     * @param licenseNo 许可证证号
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    /**
     * 获取许可证发证日期
     *
     * @return LicenseStartDate - 许可证发证日期
     */
    public Date getLicenseStartDate() {
        return licenseStartDate;
    }

    /**
     * 设置许可证发证日期
     *
     * @param licenseStartDate 许可证发证日期
     */
    public void setLicenseStartDate(Date licenseStartDate) {
        this.licenseStartDate = licenseStartDate;
    }

    /**
     * 获取许可证说明
     *
     * @return LicenseInStruction - 许可证说明
     */
    public String getLicenseInStruction() {
        return licenseInStruction;
    }

    /**
     * 设置许可证说明
     *
     * @param licenseInStruction 许可证说明
     */
    public void setLicenseInStruction(String licenseInStruction) {
        this.licenseInStruction = licenseInStruction;
    }

    /**
     * 获取许可证说明
     *
     * @return Addr - 许可证说明
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置许可证说明
     *
     * @param addr 许可证说明
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 获取负责人
     *
     * @return HeadName - 负责人
     */
    public String getHeadName() {
        return headName;
    }

    /**
     * 设置负责人
     *
     * @param headName 负责人
     */
    public void setHeadName(String headName) {
        this.headName = headName;
    }

    /**
     * 获取负责人身份证号
     *
     * @return HeadIdCard - 负责人身份证号
     */
    public String getHeadIdCard() {
        return headIdCard;
    }

    /**
     * 设置负责人身份证号
     *
     * @param headIdCard 负责人身份证号
     */
    public void setHeadIdCard(String headIdCard) {
        this.headIdCard = headIdCard;
    }

    /**
     * 获取联系电话
     *
     * @return Phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
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

	public String getSheetType() {
		return sheetType;
	}

	public void setSheetType(String sheetType) {
		this.sheetType = sheetType;
	}
}