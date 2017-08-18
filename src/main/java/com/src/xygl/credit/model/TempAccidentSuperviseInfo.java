/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    temp_accident_supervise_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月15日
 */
@Table(name = "temp_accident_supervise_info")
public class TempAccidentSuperviseInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
  
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 隐患具体信息
     */
    @Column(name = "DangerDetail")
    private String dangerDetail;

    /**
     * 整改期限
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "ChangeTerm")
    private Date changeTerm;

    /**
     * 整改完成情况
     */
    @Column(name = "ChangeCompleteInfo")
    private String changeCompleteInfo;

    @Column(name = "ImportDept")
    private String importDept;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Column(name = "ImportTime")
    private Date importTime;
    
    //批次号
    @Column(name="BatchNO")
    private String batchNO;

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
     * 获取隐患具体信息
     *
     * @return DangerDetail - 隐患具体信息
     */
    public String getDangerDetail() {
        return dangerDetail;
    }

    /**
     * 设置隐患具体信息
     *
     * @param dangerDetail 隐患具体信息
     */
    public void setDangerDetail(String dangerDetail) {
        this.dangerDetail = dangerDetail;
    }

    /**
     * 获取整改期限
     *
     * @return ChangeTerm - 整改期限
     */
    public Date getChangeTerm() {
        return changeTerm;
    }

    /**
     * 设置整改期限
     *
     * @param changeTerm 整改期限
     */
    public void setChangeTerm(Date changeTerm) {
        this.changeTerm = changeTerm;
    }

    /**
     * 获取整改完成情况
     *
     * @return ChangeCompleteInfo - 整改完成情况
     */
    public String getChangeCompleteInfo() {
        return changeCompleteInfo;
    }

    /**
     * 设置整改完成情况
     *
     * @param changeCompleteInfo 整改完成情况
     */
    public void setChangeCompleteInfo(String changeCompleteInfo) {
        this.changeCompleteInfo = changeCompleteInfo;
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

	public String getBatchNO() {
		return batchNO;
	}

	public void setBatchNO(String batchNO) {
		this.batchNO = batchNO;
	}

}