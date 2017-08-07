/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_union_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月17日
 */
@Table(name = "nd_union_info")
public class NdUnionInfo implements Serializable {

    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 任务编码
     */
    @Column(name = "JobNO")
    private String jobNO;

    /**
     * 协查原因
     */
    @Column(name = "AssistReason")
    private String assistReason;

    /**
     * 联系人
     */
    @Column(name = "ContactsName")
    private String contactsName;

    /**
     * 联系电话
     */
    @Column(name = "ContactsTel")
    private String contactsTel;

    /**
     * 联系部门
     */
    @Column(name = "ContactsDep")
    private String contactsDep;

    /**
     * 联系邮箱
     */
    @Column(name = "ContactsMail")
    private String contactsMail;

    /**
     * 创建人ID
     */
    @Column(name = "CreateUserID")
    private String createUserID;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    private Date createTime;

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
     * 获取任务编码
     *
     * @return JobNO - 任务编码
     */
    public String getJobNO() {
        return jobNO;
    }

    /**
     * 设置任务编码
     *
     * @param jobNO 任务编码
     */
    public void setJobNO(String jobNO) {
        this.jobNO = jobNO;
    }

    /**
     * 获取协查原因
     *
     * @return AssistReason - 协查原因
     */
    public String getAssistReason() {
        return assistReason;
    }

    /**
     * 设置协查原因
     *
     * @param assistReason 协查原因
     */
    public void setAssistReason(String assistReason) {
        this.assistReason = assistReason;
    }

    /**
     * 获取联系人
     *
     * @return ContactsName - 联系人
     */
    public String getContactsName() {
        return contactsName;
    }

    /**
     * 设置联系人
     *
     * @param contactsName 联系人
     */
    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    /**
     * 获取联系电话
     *
     * @return ContactsTel - 联系电话
     */
    public String getContactsTel() {
        return contactsTel;
    }

    /**
     * 设置联系电话
     *
     * @param contactsTel 联系电话
     */
    public void setContactsTel(String contactsTel) {
        this.contactsTel = contactsTel;
    }

    /**
     * 获取联系部门
     *
     * @return ContactsDep - 联系部门
     */
    public String getContactsDep() {
        return contactsDep;
    }

    /**
     * 设置联系部门
     *
     * @param contactsDep 联系部门
     */
    public void setContactsDep(String contactsDep) {
        this.contactsDep = contactsDep;
    }

    /**
     * 获取联系邮箱
     *
     * @return ContactsMail - 联系邮箱
     */
    public String getContactsMail() {
        return contactsMail;
    }

    /**
     * 设置联系邮箱
     *
     * @param contactsMail 联系邮箱
     */
    public void setContactsMail(String contactsMail) {
        this.contactsMail = contactsMail;
    }


    /**
     * 获取创建人ID
     *
     * @return CreateUserID - 创建人ID
     */
    public String getCreateUserID() {
        return createUserID;
    }

    /**
     * 设置创建人ID
     *
     * @param createUserID 创建人ID
     */
    public void setCreateUserID(String createUserID) {
        this.createUserID = createUserID;
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}