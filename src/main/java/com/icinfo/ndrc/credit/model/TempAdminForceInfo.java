/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_admin_force_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月22日
 */
@Table(name = "temp_admin_force_info")
public class TempAdminForceInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 行政强制文书号
     */
    @Column(name = "AdminForceNO")
    private String adminForceNO;

    /**
     * 行政强制决定日期
     */
    @Column(name = "AdminForceTime")
    private Date adminForceTime;

    /**
     * 查封扣押清单内容
     */
    @Column(name = "SequeDetail")
    private String sequeDetail;

    /**
     * 导入部门
     */
    @Column(name = "ImportDept")
    private String importDept;

    /**
     * 导入日期
     */
    @Column(name = "ImportTime")
    private Date importTime;

    /**
     * Excel上传的时候自动生成的uuid,方便删除
     */
    @Column(name = "BatchNO")
    private String batchNO;

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
     * 获取行政强制文书号
     *
     * @return AdminForceNO - 行政强制文书号
     */
    public String getAdminForceNO() {
        return adminForceNO;
    }

    /**
     * 设置行政强制文书号
     *
     * @param adminForceNO 行政强制文书号
     */
    public void setAdminForceNO(String adminForceNO) {
        this.adminForceNO = adminForceNO;
    }

    /**
     * 获取行政强制决定日期
     *
     * @return AdminForceTime - 行政强制决定日期
     */
    public Date getAdminForceTime() {
        return adminForceTime;
    }

    /**
     * 设置行政强制决定日期
     *
     * @param adminForceTime 行政强制决定日期
     */
    public void setAdminForceTime(Date adminForceTime) {
        this.adminForceTime = adminForceTime;
    }

    /**
     * 获取查封扣押清单内容
     *
     * @return SequeDetail - 查封扣押清单内容
     */
    public String getSequeDetail() {
        return sequeDetail;
    }

    /**
     * 设置查封扣押清单内容
     *
     * @param sequeDetail 查封扣押清单内容
     */
    public void setSequeDetail(String sequeDetail) {
        this.sequeDetail = sequeDetail;
    }

    /**
     * 获取导入部门
     *
     * @return ImportDept - 导入部门
     */
    public String getImportDept() {
        return importDept;
    }

    /**
     * 设置导入部门
     *
     * @param importDept 导入部门
     */
    public void setImportDept(String importDept) {
        this.importDept = importDept;
    }

    /**
     * 获取导入日期
     *
     * @return ImportTime - 导入日期
     */
    public Date getImportTime() {
        return importTime;
    }

    /**
     * 设置导入日期
     *
     * @param importTime 导入日期
     */
    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

	public String getBatchNO() {
		return batchNO;
	}

	public void setBatchNO(String batchNO) {
		this.batchNO = batchNO;
	}

}