/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.gateway.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    NDRC_CREDIT_CONSULT 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月14日
 */
@Table(name = "nd_credit_consult")
public class NdrcCreditConsult implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 真实姓名
     */
    @Column(name = "RealName")
    private String realName;

    /**
     * 职业
     */
    @Column(name = "Profession")
    private String profession;

    /**
     * 联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 联系邮箱
     */
    @Column(name = "Mail")
    private String mail;

    /**
     * 留言类型
     */
    @Column(name = "MessageType")
    private String messageType;

    /**
     * 留言标题
     */
    @Column(name = "MessageTitle")
    private String messageTitle;

    /**
     * 留言内容
     */
    @Column(name = "MessageContent")
    private String messageContent;

    /**
     * 留言时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 留言状态：0待回复-1：已回复
     */
    @Column(name = "MessageStatus")
    private Integer messageStatus;

    /**
     * 留言回复
     */
    @Column(name = "MessageReply")
    private String messageReply;

    /**
     * 处理时间
     */
    @Column(name = "OptTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date optTime;
    @Transient
    private String feedbackType;

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

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
     * 获取真实姓名
     *
     * @return RealName - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取职业
     *
     * @return Profession - 职业
     */
    public String getProfession() {
        return profession;
    }

    /**
     * 设置职业
     *
     * @param profession 职业
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * 获取联系电话
     *
     * @return Tel - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取联系邮箱
     *
     * @return Mail - 联系邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置联系邮箱
     *
     * @param mail 联系邮箱
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 获取留言类型
     *
     * @return MessageType - 留言类型
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * 设置留言类型
     *
     * @param messageType 留言类型
     */
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    /**
     * 获取留言标题
     *
     * @return MessageTitle - 留言标题
     */
    public String getMessageTitle() {
        return messageTitle;
    }

    /**
     * 设置留言标题
     *
     * @param messageTitle 留言标题
     */
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    /**
     * 获取留言内容
     *
     * @return MessageContent - 留言内容
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * 设置留言内容
     *
     * @param messageContent 留言内容
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    /**
     * 获取留言时间
     *
     * @return CreateTime - 留言时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置留言时间
     *
     * @param createTime 留言时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取留言状态：0待回复-1：已回复
     *
     * @return MessageStatus - 留言状态：0待回复-1：已回复
     */
    public Integer getMessageStatus() {
        return messageStatus;
    }

    /**
     * 设置留言状态：0待回复-1：已回复
     *
     * @param messageStatus 留言状态：0待回复-1：已回复
     */
    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
    }

    /**
     * 获取留言回复
     *
     * @return MessageReply - 留言回复
     */
    public String getMessageReply() {
        return messageReply;
    }

    /**
     * 设置留言回复
     *
     * @param messageReply 留言回复
     */
    public void setMessageReply(String messageReply) {
        this.messageReply = messageReply;
    }

    /**
     * 获取处理时间
     *
     * @return OptTime - 处理时间
     */
    public Date getOptTime() {
        return optTime;
    }

    /**
     * 设置处理时间
     *
     * @param optTime 处理时间
     */
    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }
}