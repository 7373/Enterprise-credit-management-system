/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    HZCX_QY_BASE_LA 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月02日
 */
@Table(name = "HZCX_QY_BASE_LA")
public class HzcxQyBaseLa implements Serializable {
    @Column(name = "enterprise_id")
    private String enterprise_id;

    @Column(name = "qymc")
    private String qymc;

    @Column(name = "gszch")
    private String gszch;

    @Column(name = "swdjzh")
    private String swdjzh;

    @Column(name = "zzjgdm")
    private String zzjgdm;

    @Column(name = "frdbxm")
    private String frdbxm;

    @Column(name = "frdbzjh")
    private String frdbzjh;

    @Column(name = "qyzt")
    private String qyzt;

    @Column(name = "time_of_move")
    private Date timeOfMove;

    @Column(name = "dwlb")
    private String dwlb;

    @Column(name = "bm")
    private String bm;

    @Column(name = "sys_id")
    private String sysId;

    @Column(name = "uscc")
    private String uscc;

    @Column(name = "djjg")
    private String djjg;

    @Column(name = "hzrq")
    private Date hzrq;
    
    @Column(name ="ListType")
    
    private String listType;
    

    private static final long serialVersionUID = 1L;

    /**
     * @return enterprise_id
     */
    
    
    public String getEnterprise_id() {
        return enterprise_id;
    }

    public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	/**
     * @param enterprise_id
     */
    public void setEnterprise_id(String enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    /**
     * @return qymc
     */
    public String getQymc() {
        return qymc;
    }

    /**
     * @param qymc
     */
    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    /**
     * @return gszch
     */
    public String getGszch() {
        return gszch;
    }

    /**
     * @param gszch
     */
    public void setGszch(String gszch) {
        this.gszch = gszch;
    }

    /**
     * @return swdjzh
     */
    public String getSwdjzh() {
        return swdjzh;
    }

    /**
     * @param swdjzh
     */
    public void setSwdjzh(String swdjzh) {
        this.swdjzh = swdjzh;
    }

    /**
     * @return zzjgdm
     */
    public String getZzjgdm() {
        return zzjgdm;
    }

    /**
     * @param zzjgdm
     */
    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }

    /**
     * @return frdbxm
     */
    public String getFrdbxm() {
        return frdbxm;
    }

    /**
     * @param frdbxm
     */
    public void setFrdbxm(String frdbxm) {
        this.frdbxm = frdbxm;
    }

    /**
     * @return frdbzjh
     */
    public String getFrdbzjh() {
        return frdbzjh;
    }

    /**
     * @param frdbzjh
     */
    public void setFrdbzjh(String frdbzjh) {
        this.frdbzjh = frdbzjh;
    }

    /**
     * @return qyzt
     */
    public String getQyzt() {
        return qyzt;
    }

    /**
     * @param qyzt
     */
    public void setQyzt(String qyzt) {
        this.qyzt = qyzt;
    }


    public Date getTimeOfMove() {
		return timeOfMove;
	}

	public void setTimeOfMove(Date timeOfMove) {
		this.timeOfMove = timeOfMove;
	}

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	/**
     * @return dwlb
     */
    public String getDwlb() {
        return dwlb;
    }

    /**
     * @param dwlb
     */
    public void setDwlb(String dwlb) {
        this.dwlb = dwlb;
    }

    /**
     * @return bm
     */
    public String getBm() {
        return bm;
    }

    /**
     * @param bm
     */
    public void setBm(String bm) {
        this.bm = bm;
    }


    /**
     * @param uscc
     */
    public void setUscc(String uscc) {
        this.uscc = uscc;
    }

    /**
     * @return djjg
     */
    public String getDjjg() {
        return djjg;
    }

    /**
     * @param djjg
     */
    public void setDjjg(String djjg) {
        this.djjg = djjg;
    }

    /**
     * @return hzrq
     */
    public Date getHzrq() {
        return hzrq;
    }

    /**
     * @param hzrq
     */
    public void setHzrq(Date hzrq) {
        this.hzrq = hzrq;
    }
}