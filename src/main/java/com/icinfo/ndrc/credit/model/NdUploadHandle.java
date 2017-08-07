/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_upload_handle 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月27日
 */
@Table(name = "nd_upload_handle")
public class NdUploadHandle implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 上传部门
     */
    @Column(name = "ImportDept")
    private String importDept;

    /**
     * 文件标题
     */
    @Column(name = "FileTitle")
    private String fileTitle;

    /**
     * 上传时间
     */
    @Column(name = "UploadTime")
    private Date uploadTime;

    /**
     * 上传人
     */
    @Column(name = "UploadPerson")
    private String uploadPerson;

    /**
     * 删除操作人
     */
    @Column(name = "DeletePerson")
    private String deletePerson;

    /**
     * 批次号
     */
    @Column(name = "BatchNO")
    private String batchNO;

    /**
     * 0:未删除，1:已删除
     */
    @Column(name = "isUse")
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
     * 获取上传部门
     *
     * @return ImportDept - 上传部门
     */
    public String getImportDept() {
        return importDept;
    }

    /**
     * 设置上传部门
     *
     * @param importDept 上传部门
     */
    public void setImportDept(String importDept) {
        this.importDept = importDept;
    }

    /**
     * 获取文件标题
     *
     * @return FileTitle - 文件标题
     */
    public String getFileTitle() {
        return fileTitle;
    }

    /**
     * 设置文件标题
     *
     * @param fileTitle 文件标题
     */
    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    /**
     * 获取上传时间
     *
     * @return UploadTime - 上传时间
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * 设置上传时间
     *
     * @param uploadTime 上传时间
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * 获取上传人
     *
     * @return UploadPerson - 上传人
     */
    public String getUploadPerson() {
        return uploadPerson;
    }

    /**
     * 设置上传人
     *
     * @param uploadPerson 上传人
     */
    public void setUploadPerson(String uploadPerson) {
        this.uploadPerson = uploadPerson;
    }

    /**
     * 获取删除操作人
     *
     * @return DeletePerson - 删除操作人
     */
    public String getDeletePerson() {
        return deletePerson;
    }

    /**
     * 设置删除操作人
     *
     * @param deletePerson 删除操作人
     */
    public void setDeletePerson(String deletePerson) {
        this.deletePerson = deletePerson;
    }

    /**
     * 获取批次号
     *
     * @return BatchNO - 批次号
     */
    public String getBatchNO() {
        return batchNO;
    }

    /**
     * 设置批次号
     *
     * @param batchNO 批次号
     */
    public void setBatchNO(String batchNO) {
        this.batchNO = batchNO;
    }

    /**
     * 获取0:未删除，1:已删除
     *
     * @return isUse - 0:未删除，1:已删除
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

	public NdUploadHandle() {
		super();
	}

	public NdUploadHandle(String importDept, String fileTitle, String uploadPerson, String batchNO
			) {
		super();
		this.importDept = importDept;
		this.fileTitle = fileTitle;
		this.uploadTime = new Date();
		this.uploadPerson = uploadPerson;
		this.batchNO = batchNO;
		this.isUse = "0";
	}
    
    
    
}