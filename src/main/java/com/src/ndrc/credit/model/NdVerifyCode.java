/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_verify_code 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月23日
 */
@Table(name = "nd_verify_code")
public class NdVerifyCode implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "UID")
    private String UID;

    @Column(name = "VerTel")
    private String verTel;

    @Column(name = "VerCode")
    private String verCode;

    @Column(name = "VerContent")
    private String verContent;

    @Column(name = "CreateTime")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    
    public NdVerifyCode() {
		super();
	}

	public NdVerifyCode(String verTel, String verCode, String verContent) {
		super();
		this.verTel = verTel;
		this.verCode = verCode;
		this.verContent = verContent;
		this.createTime = new Date();
	}

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
     * @return UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * @param UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * @return VerTel
     */
    public String getVerTel() {
        return verTel;
    }

    /**
     * @param verTel
     */
    public void setVerTel(String verTel) {
        this.verTel = verTel;
    }

    /**
     * @return VerCode
     */
    public String getVerCode() {
        return verCode;
    }

    /**
     * @param verCode
     */
    public void setVerCode(String verCode) {
        this.verCode = verCode;
    }

    /**
     * @return VerContent
     */
    public String getVerContent() {
        return verContent;
    }

    /**
     * @param verContent
     */
    public void setVerContent(String verContent) {
        this.verContent = verContent;
    }

    /**
     * @return CreateTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}