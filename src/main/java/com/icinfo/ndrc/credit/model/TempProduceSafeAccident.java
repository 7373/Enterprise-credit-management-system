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
 * 描述:    temp_produce_safe_accident 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月22日
 */
@Table(name = "temp_produce_safe_accident")
public class TempProduceSafeAccident implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 事故名称
     */
    @Column(name = "AccidentName")
    private String accidentName;

    /**
     * 发生日期
     */
    @Column(name = "OccurDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date occurDate;

    /**
     * 伤亡情况(死亡人数)
     */
    @Column(name = "DeathNum")
    private String deathNum;

    /**
     * 伤亡情况(重伤人数)
     */
    @Column(name = "InjuredNum")
    private String injuredNum;

    /**
     * 处理结果
     */
    @Column(name = "HandleResult")
    private String handleResult;

    /**
     * 累计发生事故次数
     */
    @Column(name = "AccidentCountAll")
    private String accidentCountAll;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date importTime;

    @Column(name = "BatchNO")
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
     * 
     *
     * @return AccidentName 
     */
    public String getAccidentName() {
        return accidentName;
    }

    /**
     * 
     *
     * @param accidentName 
     */
    public void setAccidentName(String accidentName) {
        this.accidentName = accidentName;
    }

    /**
     *
     * @return OccurDate 
     */
    public Date getOccurDate() {
        return occurDate;
    }

    /**
     *
     * @param occurDate 
     */
    public void setOccurDate(Date occurDate) {
        this.occurDate = occurDate;
    }

    /**
     * @return DeathNum 
     */
    public String getDeathNum() {
        return deathNum;
    }

    /**
     *
     * @param deathNum 
     */
    public void setDeathNum(String deathNum) {
        this.deathNum = deathNum;
    }

    /**
     *
     * @return InjuredNum 
     */
    public String getInjuredNum() {
        return injuredNum;
    }

    /**
     *
     * @param injuredNum 
     */
    public void setInjuredNum(String injuredNum) {
        this.injuredNum = injuredNum;
    }

    /**
     *
     * @return HandleResult 
     */
    public String getHandleResult() {
        return handleResult;
    }

    /**
     *
     * @param handleResult 
     */
    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    /**
     *
     * @return AccidentCountAll 
     */
    public String getAccidentCountAll() {
        return accidentCountAll;
    }

    /**
     *
     * @param accidentCountAll 
     */
    public void setAccidentCountAll(String accidentCountAll) {
        this.accidentCountAll = accidentCountAll;
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
}