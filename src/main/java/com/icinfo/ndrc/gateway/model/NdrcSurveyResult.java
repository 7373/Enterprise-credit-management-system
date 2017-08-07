/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.gateway.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    NDRC_SURVEY_RESULT 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月21日
 */
@Table(name = "nd_survey_result")
public class NdrcSurveyResult implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uid
     */
    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 问题唯一标识
     */
    @Column(name = "ProblemID")
    private String problemID;

    /**
     * 选项A
     */
    @Column(name = "OptionA")
    private Integer optionA;

    /**
     * 选项B
     */
    @Column(name = "OptionB")
    private Integer optionB;

    /**
     * 选项C
     */
    @Column(name = "OptionC")
    private Integer optionC;

    /**
     * 选项D
     */
    @Column(name = "OptionD")
    private Integer optionD;

    /**
     * 选项E
     */
    @Column(name = "OptionE")
    private Integer optionE;

    /**
     * 选项F
     */
    @Column(name = "OptionF")
    private Integer optionF;

    /**
     * 填写时间
     */
    @Column(name = "CreateTime")
    private Date createTime;

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
     * 获取uid
     *
     * @return uid - uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uid
     *
     * @param uid uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取问题唯一标识
     *
     * @return ProblemID - 问题唯一标识
     */
    public String getProblemID() {
        return problemID;
    }

    /**
     * 设置问题唯一标识
     *
     * @param problemID 问题唯一标识
     */
    public void setProblemID(String problemID) {
        this.problemID = problemID;
    }

    /**
     * 获取选项A
     *
     * @return OptionA - 选项A
     */
    public Integer getOptionA() {
        return optionA;
    }

    /**
     * 设置选项A
     *
     * @param optionA 选项A
     */
    public void setOptionA(Integer optionA) {
        this.optionA = optionA;
    }

    /**
     * 获取选项B
     *
     * @return OptionB - 选项B
     */
    public Integer getOptionB() {
        return optionB;
    }

    /**
     * 设置选项B
     *
     * @param optionB 选项B
     */
    public void setOptionB(Integer optionB) {
        this.optionB = optionB;
    }

    /**
     * 获取选项C
     *
     * @return OptionC - 选项C
     */
    public Integer getOptionC() {
        return optionC;
    }

    /**
     * 设置选项C
     *
     * @param optionC 选项C
     */
    public void setOptionC(Integer optionC) {
        this.optionC = optionC;
    }

    /**
     * 获取选项D
     *
     * @return OptionD - 选项D
     */
    public Integer getOptionD() {
        return optionD;
    }

    /**
     * 设置选项D
     *
     * @param optionD 选项D
     */
    public void setOptionD(Integer optionD) {
        this.optionD = optionD;
    }

    /**
     * 获取选项E
     *
     * @return OptionE - 选项E
     */
    public Integer getOptionE() {
        return optionE;
    }

    /**
     * 设置选项E
     *
     * @param optionE 选项E
     */
    public void setOptionE(Integer optionE) {
        this.optionE = optionE;
    }

    /**
     * 获取选项F
     *
     * @return OptionF - 选项F
     */
    public Integer getOptionF() {
        return optionF;
    }

    /**
     * 设置选项F
     *
     * @param optionF 选项F
     */
    public void setOptionF(Integer optionF) {
        this.optionF = optionF;
    }

    /**
     * 获取填写时间
     *
     * @return CreateTime - 填写时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置填写时间
     *
     * @param createTime 填写时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}