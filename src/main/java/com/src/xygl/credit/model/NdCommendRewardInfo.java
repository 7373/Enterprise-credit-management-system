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
 * 描述:    nd_commend_reward_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月21日
 */
@Table(name = "nd_commend_reward_info")
public class NdCommendRewardInfo implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    @Column(name = "uid")
    private String uid;

    /**
     * 表彰名称
     */
    @Column(name = "CommendName")
    private String commendName;

    /**
     * 表彰等级
     */
    @Column(name = "CommendGrade")
    private String commendGrade;

    /**
     * 表彰文件（号）
     */
    @Column(name = "CommendFileNO")
    private String commendFileNO;

    /**
     * 表彰部门全称
     */
    @Column(name = "CommendDeptName")
    private String commendDeptName;

    /**
     * 表彰时间
     */
    @Column(name = "CommendTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date commendTime;

    /**
     * 累计表彰次数
     */
    @Column(name = "CommendCount")
    private String commendCount;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "InportTime")
    private Date inportTime;

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
     * @return CommendName 
     */
    public String getCommendName() {
        return commendName;
    }

    /**
     * @param commendName 
     */
    public void setCommendName(String commendName) {
        this.commendName = commendName;
    }

    /**
     * @return CommendGrade
     */
    public String getCommendGrade() {
        return commendGrade;
    }

    /**
     * @param commendGrade
     */
    public void setCommendGrade(String commendGrade) {
        this.commendGrade = commendGrade;
    }

    /**
     * @return CommendFileNO
     */
    public String getCommendFileNO() {
        return commendFileNO;
    }

    /**
     * @param commendFileNO
     */
    public void setCommendFileNO(String commendFileNO) {
        this.commendFileNO = commendFileNO;
    }

    /**
     * @return CommendDeptName 
     */
    public String getCommendDeptName() {
        return commendDeptName;
    }

    /**
     * @param commendDeptName 
     */
    public void setCommendDeptName(String commendDeptName) {
        this.commendDeptName = commendDeptName;
    }

    /**
     * @return CommendTime
     */
    public Date getCommendTime() {
        return commendTime;
    }

    /**
     * @param commendTime 
     */
    public void setCommendTime(Date commendTime) {
        this.commendTime = commendTime;
    }

    /**
     * @return CommendCount 
     */
    public String getCommendCount() {
        return commendCount;
    }

    /**
     * @param commendCount
     */
    public void setCommendCount(String commendCount) {
        this.commendCount = commendCount;
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
     * @return InportTime
     */
    public Date getInportTime() {
        return inportTime;
    }

    /**
     * @param inportTime
     */
    public void setInportTime(Date inportTime) {
        this.inportTime = inportTime;
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