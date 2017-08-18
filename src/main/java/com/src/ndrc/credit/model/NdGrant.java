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
 * 描述:    nd_grant 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月26日
 */
@Table(name = "nd_grant")
public class NdGrant implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 授权人ID
     */
    @Column(name = "GraUserID")
    private String graUserID;

    @Column(name = "CorpidOrSfzjhm")
    private String corpidOrSfzjhm;

    /**
     * 企业名称个人姓名
     */
    @Column(name = "GraName")
    private String graName;

    /**
     * 注册号_证件号
     */
    @Column(name = "GraNo")
    private String graNo;

    /**
     * 授权类型：0：企业 1：个人
     */
    @Column(name = "GraType")
    private Integer graType;

    /**
     * 授权开始时间
     */
    @Column(name = "GraStartLine")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date graStartLine;

    /**
     * 授权期限
     */
    @Column(name = "GraDeadLine")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date graDeadLine;

    /**
     * 操作时间
     */
    @Column(name = "GraOptTime")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date graOptTime;

    /**
     * 是否删除 0：未删  1：删除
     */
    @Column(name = "GraIsDel")
    private Integer graIsDel;

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
     * 获取授权人ID
     *
     * @return GraUserID - 授权人ID
     */
    public String getGraUserID() {
        return graUserID;
    }

    /**
     * 设置授权人ID
     *
     * @param graUserID 授权人ID
     */
    public void setGraUserID(String graUserID) {
        this.graUserID = graUserID;
    }

    /**
     * @return CorpidOrSfzjhm
     */
    public String getCorpidOrSfzjhm() {
        return corpidOrSfzjhm;
    }

    /**
     * @param corpidOrSfzjhm
     */
    public void setCorpidOrSfzjhm(String corpidOrSfzjhm) {
        this.corpidOrSfzjhm = corpidOrSfzjhm;
    }

    /**
     * 获取企业名称个人姓名
     *
     * @return GraName - 企业名称个人姓名
     */
    public String getGraName() {
        return graName;
    }

    /**
     * 设置企业名称个人姓名
     *
     * @param graName 企业名称个人姓名
     */
    public void setGraName(String graName) {
        this.graName = graName;
    }

    /**
     * 获取注册号_证件号
     *
     * @return GraNo - 注册号_证件号
     */
    public String getGraNo() {
        return graNo;
    }

    /**
     * 设置注册号_证件号
     *
     * @param graNo 注册号_证件号
     */
    public void setGraNo(String graNo) {
        this.graNo = graNo;
    }

    /**
     * 获取授权类型：0：企业 1：个人
     *
     * @return GraType - 授权类型：0：企业 1：个人
     */
    public Integer getGraType() {
        return graType;
    }

    /**
     * 设置授权类型：0：企业 1：个人
     *
     * @param graType 授权类型：0：企业 1：个人
     */
    public void setGraType(Integer graType) {
        this.graType = graType;
    }

    /**
     * 获取授权开始时间
     *
     * @return GraStartLine - 授权开始时间
     */
    public Date getGraStartLine() {
        return graStartLine;
    }

    /**
     * 设置授权开始时间
     *
     * @param graStartLine 授权开始时间
     */
    public void setGraStartLine(Date graStartLine) {
        this.graStartLine = graStartLine;
    }

    /**
     * 获取授权期限
     *
     * @return GraDeadLine - 授权期限
     */
    public Date getGraDeadLine() {
        return graDeadLine;
    }

    /**
     * 设置授权期限
     *
     * @param graDeadLine 授权期限
     */
    public void setGraDeadLine(Date graDeadLine) {
        this.graDeadLine = graDeadLine;
    }

    /**
     * 获取操作时间
     *
     * @return GraOptTime - 操作时间
     */
    public Date getGraOptTime() {
        return graOptTime;
    }

    /**
     * 设置操作时间
     *
     * @param graOptTime 操作时间
     */
    public void setGraOptTime(Date graOptTime) {
        this.graOptTime = graOptTime;
    }

    /**
     * 获取是否删除 0：未删  1：删除
     *
     * @return GraIsDel - 是否删除 0：未删  1：删除
     */
    public Integer getGraIsDel() {
        return graIsDel;
    }

    /**
     * 设置是否删除 0：未删  1：删除
     *
     * @param graIsDel 是否删除 0：未删  1：删除
     */
    public void setGraIsDel(Integer graIsDel) {
        this.graIsDel = graIsDel;
    }
}