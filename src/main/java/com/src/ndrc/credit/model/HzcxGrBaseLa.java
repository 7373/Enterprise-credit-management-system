/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.ndrc.util.AESEUtil;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.apache.commons.lang3.StringUtils;

/**
 * 描述:    HZCX_GR_BASE_LA 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月02日
 */
@Table(name = "HZCX_GR_BASE_LA")
public class HzcxGrBaseLa implements Serializable {
    @Column(name = "xm")
    private String xm;

    @Column(name = "xb")
    private String xb;

    @Column(name = "sfzhm")
    private String sfzhm;

    @Column(name = "csny")
    private String csny;

    @Column(name = "ryzt")
    private String ryzt;

    @Column(name = "ssqx")
    private String ssqx;

    /**
     * ԭ
     */
    @Column(name = "yhklb")
    private String yhklb;

    /**
     * ע
     */
    @Column(name = "zxbz")
    private String zxbz;

    @Column(name = "zzzh")
    private String zzzh;

    @Column(name = "input_date")
    private Date input_date;

    @Column(name = "personal_id")
    private String personal_id;

    @Column(name = "seq_value")
    private Integer seq_value;

    @Column(name = "sys_id")
    private String sys_id;

    @Column(name = "szjd")
    private String szjd;
    @Column(name = "ListType")
    private String listType;
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 预警类型
     * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
     * @author  ranah
     * @when   2017年6月13日下午2:32:58
     * @return
     */

    public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	/**
     * @return xm
     */
    
    
    public String getXm() {
        return xm;
    }

    /**
     * @param xm
     */
    public void setXm(String xm) {
        this.xm = xm;
    }

    /**
     * @return xb
     */
    public String getXb() {
        return xb;
    }

    /**
     * @param xb
     */
    public void setXb(String xb) {
        this.xb = xb;
    }

    /**
     * @return sfzhm
     */
    public String getSfzhm() {
        return sfzhm;
    }

    public String getSfzhmDesc() {
    	if(StringUtils.isNotBlank(sfzhm))
    		return AESEUtil.encryptContext(sfzhm);
        return sfzhm;
    }
    
    /**
     * @param sfzhm
     */
    public void setSfzhm(String sfzhm) {
        this.sfzhm = sfzhm;
    }

    /**
     * @return csny
     */
    public String getCsny() {
        return csny;
    }

    /**
     * @param csny
     */
    public void setCsny(String csny) {
        this.csny = csny;
    }

    /**
     * @return ryzt
     */
    public String getRyzt() {
        return ryzt;
    }

    /**
     * @param ryzt
     */
    public void setRyzt(String ryzt) {
        this.ryzt = ryzt;
    }

    /**
     * @return ssqx
     */
    public String getSsqx() {
        return ssqx;
    }

    /**
     * @param ssqx
     */
    public void setSsqx(String ssqx) {
        this.ssqx = ssqx;
    }

    /**
     * 获取ԭ
     *
     * @return yhklb - ԭ
     */
    public String getYhklb() {
        return yhklb;
    }

    /**
     * 设置ԭ
     *
     * @param yhklb ԭ
     */
    public void setYhklb(String yhklb) {
        this.yhklb = yhklb;
    }

    /**
     * 获取ע
     *
     * @return zxbz - ע
     */
    public String getZxbz() {
        return zxbz;
    }

    /**
     * 设置ע
     *
     * @param zxbz ע
     */
    public void setZxbz(String zxbz) {
        this.zxbz = zxbz;
    }

    /**
     * @return zzzh
     */
    public String getZzzh() {
        return zzzh;
    }

    /**
     * @param zzzh
     */
    public void setZzzh(String zzzh) {
        this.zzzh = zzzh;
    }

    /**
     * @return input_date
     */
    public Date getInput_date() {
        return input_date;
    }

    /**
     * @param input_date
     */
    public void setInput_date(Date input_date) {
        this.input_date = input_date;
    }

    /**
     * @return personal_id
     */
    public String getPersonal_id() {
        return personal_id;
    }

    /**
     * @param personal_id
     */
    public void setPersonal_id(String personal_id) {
        this.personal_id = personal_id;
    }

    /**
     * @return seq_value
     */
    public Integer getSeq_value() {
        return seq_value;
    }

    /**
     * @param seq_value
     */
    public void setSeq_value(Integer seq_value) {
        this.seq_value = seq_value;
    }

    /**
     * @return sys_id
     */
    public String getSys_id() {
        return sys_id;
    }

    /**
     * @param sys_id
     */
    public void setSys_id(String sys_id) {
        this.sys_id = sys_id;
    }

    /**
     * @return szjd
     */
    public String getSzjd() {
        return szjd;
    }

    /**
     * @param szjd
     */
    public void setSzjd(String szjd) {
        this.szjd = szjd;
    }
}