/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    nd_union_obj 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月17日
 */
@Table(name = "nd_union_obj")
public class NdUnionObj implements Serializable {

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 任务编号
     */
    @Column(name = "JobNO")
    private String jobNO;

    /**
     * 对象名称
     */
    @Column(name = "EntName")
    private String entName;

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

    /**
     * 获取对象名称
     *
     * @return EntName - 对象名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置对象名称
     *
     * @param entName 对象名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }
}