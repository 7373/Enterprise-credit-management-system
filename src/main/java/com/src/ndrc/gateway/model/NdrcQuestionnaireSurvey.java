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
 * 描述:    NDRC_QUESTIONNAIRE_SURVEY 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月15日
 */
@Table(name = "nd_questionnaire_survey")
public class NdrcQuestionnaireSurvey implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * UID
     */
    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 发布人
     */
    @Column(name = "Publisher")
    private String publisher;

    /**
     * 发布状态(1:已发布；0:未发布)
     */
    @Column(name = "PublishState")
    private String publishState;

    /**
     * 发布人ID
     */
    @Column(name = "PublisherId")
    private String publisherId;

    /**
     * 修改人
     */
    @Column(name = "Changer")
    private String changer;

    /**
     * 修改时间
     */
    @Column(name = "ChangeTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date changeTime;

    /**
     * 问题
     */
    @Column(name = "Problem")
    private String problem;

    /**
     * 选项A
     */
    @Column(name = "OptionA")
    private String optionA;

    /**
     * 选项B
     */
    @Column(name = "OptionB")
    private String optionB;

    /**
     * 选项C
     */
    @Column(name = "OptionC")
    private String optionC;

    /**
     * 选项D
     */
    @Column(name = "OptionD")
    private String optionD;

    /**
     * 选项C
     */
    @Column(name = "OptionE")
    private String optionE;

    /**
     * 选项D
     */
    @Column(name = "OptionF")
    private String optionF;
    
    /**
     * 调研开始时间
     */
    @Column(name = "SurveyTimeStart")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date surveyTimeStart;

    /**
     * 调研结束时间
     */
    @Column(name = "SurveyTimeEnd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date surveyTimeEnd;

    /**
     * 发布时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 是否删除
     */
    @Column(name = "IsDel")
    private String isDel;

    /**
     * 修改人ID
     */
    @Column(name = "ChangerId")
    private String changerId;
    
    @Transient
    private String flag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取UID
     *
     * @return uid - UID
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置UID
     *
     * @param uid UID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取发布人
     *
     * @return Publisher - 发布人
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * 设置发布人
     *
     * @param publisher 发布人
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * 获取发布状态(1:已发布；0:未发布)
     *
     * @return PublishState - 发布状态
     */
    public String getPublishState() {
        return publishState;
    }

    /**
     * 设置发布状态(1:已发布；0:未发布)
     *
     * @param publishState 发布状态
     */
    public void setPublishState(String publishState) {
        this.publishState = publishState;
    }

    /**
     * 获取发布人ID
     *
     * @return PublisherId - 发布人ID
     */
    public String getPublisherId() {
        return publisherId;
    }

    /**
     * 设置发布人ID
     *
     * @param publisherId 发布人ID
     */
    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    /**
     * 获取修改人
     *
     * @return Changer - 修改人
     */
    public String getChanger() {
        return changer;
    }

    /**
     * 设置修改人
     *
     * @param changer 修改人
     */
    public void setChanger(String changer) {
        this.changer = changer;
    }

    /**
     * 获取修改时间
     *
     * @return ChangeTime - 修改时间
     */
    public Date getChangeTime() {
        return changeTime;
    }

    /**
     * 设置修改时间
     *
     * @param changeTime 修改时间
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    /**
     * 获取问题
     *
     * @return Problem - 问题
     */
    public String getProblem() {
        return problem;
    }

    /**
     * 设置问题
     *
     * @param problem 问题
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * 获取选项A
     *
     * @return OptionA - 选项A
     */
    public String getOptionA() {
        return optionA;
    }

    /**
     * 设置选项A
     *
     * @param optionA 选项A
     */
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    /**
     * 获取选项B
     *
     * @return OptionB - 选项B
     */
    public String getOptionB() {
        return optionB;
    }

    /**
     * 设置选项B
     *
     * @param optionB 选项B
     */
    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    /**
     * 获取选项C
     *
     * @return OptionC - 选项C
     */
    public String getOptionC() {
        return optionC;
    }

    /**
     * 设置选项C
     *
     * @param optionC 选项C
     */
    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    /**
     * 获取选项D
     *
     * @return OptionD - 选项D
     */
    public String getOptionD() {
        return optionD;
    }

    /**
     * 设置选项D
     *
     * @param optionD 选项D
     */
    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    
    public String getOptionE() {
		return optionE;
	}

	public void setOptionE(String optionE) {
		this.optionE = optionE;
	}

	public String getOptionF() {
		return optionF;
	}

	public void setOptionF(String optionF) {
		this.optionF = optionF;
	}

	/**
     * 获取调研开始时间
     *
     * @return SurveyTimeStart - 调研开始时间
     */
    public Date getSurveyTimeStart() {
        return surveyTimeStart;
    }

    /**
     * 设置调研开始时间
     *
     * @param surveyTimeStart 调研开始时间
     */
    public void setSurveyTimeStart(Date surveyTimeStart) {
        this.surveyTimeStart = surveyTimeStart;
    }

    /**
     * 获取调研结束时间
     *
     * @return SurveyTimeEnd - 调研结束时间
     */
    public Date getSurveyTimeEnd() {
        return surveyTimeEnd;
    }

    /**
     * 设置调研结束时间
     *
     * @param surveyTimeEnd 调研结束时间
     */
    public void setSurveyTimeEnd(Date surveyTimeEnd) {
        this.surveyTimeEnd = surveyTimeEnd;
    }

    /**
     * 获取发布时间
     *
     * @return CreateTime - 发布时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置发布时间
     *
     * @param createTime 发布时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否删除
     *
     * @return IsDel - 是否删除
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * 设置是否删除
     *
     * @param isDel 是否删除
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    /**
     * 获取修改人ID
     *
     * @return ChangerId - 修改人ID
     */
    public String getChangerId() {
        return changerId;
    }

    /**
     * 设置修改人ID
     *
     * @param changerId 修改人ID
     */
    public void setChangerId(String changerId) {
        this.changerId = changerId;
    }

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
    
    
    
}