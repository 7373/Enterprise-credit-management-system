/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_commend_reward_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "temp_commend_reward_info")
public class TempCommendRewardInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
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
    private Date commendTime;

    /**
     * 累计表彰次数
     */
    @Column(name = "CommendCount")
    private String commendCount;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    private Date importTime;

    /**
     * Excel上传的时候自动生成的uuid,方便删除
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
     * 获取表彰名称
     *
     * @return CommendName - 表彰名称
     */
    public String getCommendName() {
        return commendName;
    }

    /**
     * 设置表彰名称
     *
     * @param commendName 表彰名称
     */
    public void setCommendName(String commendName) {
        this.commendName = commendName;
    }

    /**
     * 获取表彰等级
     *
     * @return CommendGrade - 表彰等级
     */
    public String getCommendGrade() {
        return commendGrade;
    }

    /**
     * 设置表彰等级
     *
     * @param commendGrade 表彰等级
     */
    public void setCommendGrade(String commendGrade) {
        this.commendGrade = commendGrade;
    }

    /**
     * 获取表彰文件（号）
     *
     * @return CommendFileNO - 表彰文件（号）
     */
    public String getCommendFileNO() {
        return commendFileNO;
    }

    /**
     * 设置表彰文件（号）
     *
     * @param commendFileNO 表彰文件（号）
     */
    public void setCommendFileNO(String commendFileNO) {
        this.commendFileNO = commendFileNO;
    }

    /**
     * 获取表彰部门全称
     *
     * @return CommendDeptName - 表彰部门全称
     */
    public String getCommendDeptName() {
        return commendDeptName;
    }

    /**
     * 设置表彰部门全称
     *
     * @param commendDeptName 表彰部门全称
     */
    public void setCommendDeptName(String commendDeptName) {
        this.commendDeptName = commendDeptName;
    }

    /**
     * 获取表彰时间
     *
     * @return CommendTime - 表彰时间
     */
    public Date getCommendTime() {
        return commendTime;
    }

    /**
     * 设置表彰时间
     *
     * @param commendTime 表彰时间
     */
    public void setCommendTime(Date commendTime) {
        this.commendTime = commendTime;
    }

    /**
     * 获取累计表彰次数
     *
     * @return CommendCount - 累计表彰次数
     */
    public String getCommendCount() {
        return commendCount;
    }

    /**
     * 设置累计表彰次数
     *
     * @param commendCount 累计表彰次数
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


    public Date getImportTime() {
		return importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	/**
     * 获取Excel上传的时候自动生成的uuid,方便删除
     *
     * @return BatchNO - Excel上传的时候自动生成的uuid,方便删除
     */
    public String getBatchNO() {
        return batchNO;
    }

    /**
     * 设置Excel上传的时候自动生成的uuid,方便删除
     *
     * @param batchNO Excel上传的时候自动生成的uuid,方便删除
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