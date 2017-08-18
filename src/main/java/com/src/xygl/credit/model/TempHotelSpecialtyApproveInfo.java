/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_hotel_specialty_approve_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_hotel_specialty_approve_info")
public class TempHotelSpecialtyApproveInfo implements Serializable {
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
     * 旅馆名称
     */
    @Column(name = "HotelName")
    private String hotelName;

    /**
     * 旅馆地址
     */
    @Column(name = "HotelAddr")
    private String hotelAddr;

    /**
     * 社会信用代码/工商注册号/组织机构代码
     */
    @Column(name = "Uniscid")
    private String uniscid;

    /**
     * 旅馆联系电话
     */
    @Column(name = "HotelPhone")
    private String hotelPhone;

    /**
     * 开设日期
     */
    @Column(name = "StartTime")
    private Date startTime;

    /**
     * 法人代表姓名
     */
    @Column(name = "LegalPersonName")
    private String legalPersonName;

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
     * 获取旅馆名称
     *
     * @return HotelName - 旅馆名称
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * 设置旅馆名称
     *
     * @param hotelName 旅馆名称
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * 获取旅馆地址
     *
     * @return HotelAddr - 旅馆地址
     */
    public String getHotelAddr() {
        return hotelAddr;
    }

    /**
     * 设置旅馆地址
     *
     * @param hotelAddr 旅馆地址
     */
    public void setHotelAddr(String hotelAddr) {
        this.hotelAddr = hotelAddr;
    }

    /**
     * 获取社会信用代码/工商注册号/组织机构代码
     *
     * @return Uniscid - 社会信用代码/工商注册号/组织机构代码
     */
    public String getUniscid() {
        return uniscid;
    }

    /**
     * 设置社会信用代码/工商注册号/组织机构代码
     *
     * @param uniscid 社会信用代码/工商注册号/组织机构代码
     */
    public void setUniscid(String uniscid) {
        this.uniscid = uniscid;
    }

    /**
     * 获取旅馆联系电话
     *
     * @return HotelPhone - 旅馆联系电话
     */
    public String getHotelPhone() {
        return hotelPhone;
    }

    /**
     * 设置旅馆联系电话
     *
     * @param hotelPhone 旅馆联系电话
     */
    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    /**
     * 获取开设日期
     *
     * @return StartTime - 开设日期
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开设日期
     *
     * @param startTime 开设日期
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取法人代表姓名
     *
     * @return LegalPersonName - 法人代表姓名
     */
    public String getLegalPersonName() {
        return legalPersonName;
    }

    /**
     * 设置法人代表姓名
     *
     * @param legalPersonName 法人代表姓名
     */
    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
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
}