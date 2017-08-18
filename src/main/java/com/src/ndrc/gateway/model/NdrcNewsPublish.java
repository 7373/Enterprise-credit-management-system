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
 * 描述:    NDRC_NEWS_PUBLISH 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月08日
 */
@Table(name = "nd_news_publish")
public class NdrcNewsPublish implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * UID主键
     */
    @Id
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
     private String UID;

    /**
     * 标题
     */
    @Column(name = "Title")
    private String title;

    /**
     * 一级分类
     */
    @Column(name = "Type1")
    private String type1;

    /**
     * 一级分类编码
     */
    @Column(name = "Type1Code")
    private String type1Code;

    /**
     * 二级分类
     */
    @Column(name = "Type2")
    private String type2;

    /**
     * 二级分类编码
     */
    @Column(name = "Type2Code")
    private String type2Code;

    /**
     * 发布人
     */
    @Column(name = "Publisher")
    private String publisher;

    /**
     * 发布时间
     */
    @Column(name = "PublishTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date publishTime;

    /**
     * 发布状态（1.发布； 0.暂停）
     */
    @Column(name = "State")
    private String state;

    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "UpdateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;

    /**
     * 是否已删除
     */
    @Column(name = "IsDel")
    private String isDel;

    /**
     * 发布内容
     */
    @Column(name = "Content")
    private String content;

	/**
	 * 发布内容
	 */
	@Column(name = "Source")
	private String source;

	/**
	 * 上传文件路径
	 */
	@Column(name = "FilePath")
	private String filePath;

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType1Code() {
		return type1Code;
	}

	public void setType1Code(String type1Code) {
		this.type1Code = type1Code;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getType2Code() {
		return type2Code;
	}

	public void setType2Code(String type2Code) {
		this.type2Code = type2Code;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getStateDesc() {
		if("1".equals(this.state))
			return "发布";
		if("0".equals(this.state))
			return "暂停";
		return "";
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date creatTime) {
		this.createTime = creatTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}