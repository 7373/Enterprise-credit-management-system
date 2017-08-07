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
 * 描述:  temp_people_quali_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_people_quali_info")
public class TempPeopleQualiInfo implements Serializable {
	@Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 人员名称
     */
    @Column(name = "PeoName")
    private String peoName;

    /**
     * 资格证书
     */
    @Column(name = "CertFile")
    private String certFile;

    /**
     * 身份证号码
     */
    @Column(name = "IdNO")
    private String idNO;

    /**
     * 信用等级
     */
    @Column(name = "CreditLevel")
    private String creditLevel;

    /**
     * 证书类别
     */
    @Column(name = "CertType")
    private String certType;

    /**
     * 新增时间
     */
    @Column(name = "NewDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date newDate;

    /**
     * 有效期起
     */
    @Column(name = "ValDateStart")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date valDateStart;

    /**
     * 有效期止
     */
    @Column(name = "ValDateEnd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date valDateEnd;

    /**
     * 信用评价
     */
    @Column(name = "CreEvaluate")
    private String creEvaluate;

    /**
     * 服务车号
     */
    @Column(name = "ServerNO")
    private String serverNO;

    /**
     * 从业种类
     */
    @Column(name = "IndType")
    private String indType;

    /**
     * 证件编码
     */
    @Column(name = "CerNO")
    private String cerNO;
    
    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date importTime;

    @Column(name = "BatchNO")
    private String batchNO;

    @Column(name = "IsUse")
    private String isUse;

    private static final long serialVersionUID = 1L;

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
     * 获取人员名称
     *
     * @return PeoName - 人员名称
     */
    public String getPeoName() {
        return peoName;
    }

    /**
     * 设置人员名称
     *
     * @param peoName 人员名称
     */
    public void setPeoName(String peoName) {
        this.peoName = peoName;
    }

    /**
     * 获取资格证书
     *
     * @return CertFile - 资格证书
     */
    public String getCertFile() {
        return certFile;
    }

    /**
     * 设置资格证书
     *
     * @param certFile 资格证书
     */
    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    /**
     * 获取身份证号码
     *
     * @return IdNO - 身份证号码
     */
    public String getIdNO() {
        return idNO;
    }

    /**
     * 设置身份证号码
     *
     * @param idNO 身份证号码
     */
    public void setIdNO(String idNO) {
        this.idNO = idNO;
    }

    /**
     * 获取信用等级
     *
     * @return CreditLevel - 信用等级
     */
    public String getCreditLevel() {
        return creditLevel;
    }

    /**
     * 设置信用等级
     *
     * @param creditLevel 信用等级
     */
    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
    }

    /**
     * 获取证书类别
     *
     * @return CertType - 证书类别
     */
    public String getCertType() {
        return certType;
    }

    /**
     * 设置证书类别
     *
     * @param certType 证书类别
     */
    public void setCertType(String certType) {
        this.certType = certType;
    }

    /**
     * 获取新增时间
     *
     * @return NewDate - 新增时间
     */
    public Date getNewDate() {
        return newDate;
    }

    /**
     * 设置新增时间
     *
     * @param newDate 新增时间
     */
    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    /**
     * 获取有效期起
     *
     * @return ValDateStart - 有效期起
     */
    public Date getValDateStart() {
        return valDateStart;
    }

    /**
     * 设置有效期起
     *
     * @param valDateStart 有效期起
     */
    public void setValDateStart(Date valDateStart) {
        this.valDateStart = valDateStart;
    }

    /**
     * 获取有效期止
     *
     * @return ValDateEnd - 有效期止
     */
    public Date getValDateEnd() {
        return valDateEnd;
    }

    /**
     * 设置有效期止
     *
     * @param valDateEnd 有效期止
     */
    public void setValDateEnd(Date valDateEnd) {
        this.valDateEnd = valDateEnd;
    }

    /**
     * 获取信用评价
     *
     * @return CreEvaluate - 信用评价
     */
    public String getCreEvaluate() {
        return creEvaluate;
    }

    /**
     * 设置信用评价
     *
     * @param creEvaluate 信用评价
     */
    public void setCreEvaluate(String creEvaluate) {
        this.creEvaluate = creEvaluate;
    }

    /**
     * 获取服务车号
     *
     * @return ServerNO - 服务车号
     */
    public String getServerNO() {
        return serverNO;
    }

    /**
     * 设置服务车号
     *
     * @param serverNO 服务车号
     */
    public void setServerNO(String serverNO) {
        this.serverNO = serverNO;
    }

    /**
     * 获取从业种类
     *
     * @return IndType - 从业种类
     */
    public String getIndType() {
        return indType;
    }

    /**
     * 设置从业种类
     *
     * @param indType 从业种类
     */
    public void setIndType(String indType) {
        this.indType = indType;
    }

    /**
     * 获取证件编码
     *
     * @return CerNO - 证件编码
     */
    public String getCerNO() {
        return cerNO;
    }

    /**
     * 设置证件编码
     *
     * @param cerNO 证件编码
     */
    public void setCerNO(String cerNO) {
        this.cerNO = cerNO;
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

	public String getImportDept() {
		return importDept;
	}

	public void setImportDept(String importDept) {
		this.importDept = importDept;
	}

	public Date getImportTime() {
		return importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}
    
}