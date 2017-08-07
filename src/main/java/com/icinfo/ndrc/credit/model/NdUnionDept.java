/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    nd_union_dept 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月17日
 */
@Table(name = "nd_union_dept")
public class NdUnionDept implements Serializable {

    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 任务编号
     */
    @Column(name = "JobNO")
    private String jobNO;

    /**
     * 部门编码
     */
    @Column(name = "RecDep")
    private String recDep;
    
    /**
     * 发送通知 
     * 1 是
     * 0 否
     */
    @Column(name = "IsSend")
    private String isSend;

    /**
     * 处理结果 1:已处理  0:未处理
     */
    @Column(name = "HandleStatue")
    private String handleStatue;

    /**
     * 处理人
     */
    @Column(name = "HandleUserID")
    private String handleUserID;

    /**
     * 处理结果
     */
    @Column(name = "HandleRst")
    private String handleRst;

    /**
     * 附件
     */
    @Column(name = "HandleEncl")
    private String handleEncl;

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
     * 获取任务编号
     *
     * @return JobNO - 任务编号
     */
    public String getJobNO() {
        return jobNO;
    }

    /**
     * 设置任务编号
     *
     * @param jobNO 任务编号
     */
    public void setJobNO(String jobNO) {
        this.jobNO = jobNO;
    }

    public String getRecDep() {
		return recDep;
	}

	public void setRecDep(String recDep) {
		this.recDep = recDep;
	}

	/**
     * 获取处理结果 1:已处理  0:未处理
     *
     * @return HandleStatue - 处理结果 1:已处理  0:未处理
     */
    public String getHandleStatue() {
        return handleStatue;
    }

    /**
     * 设置处理结果 1:已处理  0:未处理
     *
     * @param handleStatue 处理结果 1:已处理  0:未处理
     */
    public void setHandleStatue(String handleStatue) {
        this.handleStatue = handleStatue;
    }

    /**
     * 获取处理人
     *
     * @return HandleUserID - 处理人
     */
    public String getHandleUserID() {
        return handleUserID;
    }

    /**
     * 设置处理人
     *
     * @param handleUserID 处理人
     */
    public void setHandleUserID(String handleUserID) {
        this.handleUserID = handleUserID;
    }

    /**
     * 获取处理结果
     *
     * @return HandleRst - 处理结果
     */
    public String getHandleRst() {
        return handleRst;
    }

    /**
     * 设置处理结果
     *
     * @param handleRst 处理结果
     */
    public void setHandleRst(String handleRst) {
        this.handleRst = handleRst;
    }

    /**
     * 获取附件
     *
     * @return HandleEncl - 附件
     */
    public String getHandleEncl() {
        return handleEncl;
    }

    /**
     * 设置附件
     *
     * @param handleEncl 附件
     */
    public void setHandleEncl(String handleEncl) {
        this.handleEncl = handleEncl;
    }

	public String getIsSend() {
		return isSend;
	}

	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}
    
    
}