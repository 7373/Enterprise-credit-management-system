/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_sys_log 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月23日
 */
@Table(name = "nd_sys_log")
public class NdSysLog implements Serializable {
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
     * 用户登录名
     */
    @Column(name = "LogLoginName")
    private String logLoginName;

    /**
     * 操作业务编码
     */
    @Column(name = "LogOperaterCode")
    private String logOperaterCode;

    /**
     * 操作信息
     */
    @Column(name = "LogMsg")
    private String logMsg;

    /**
     * 操作日期
     */
    @Column(name = "LogDate")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date logDate;

    /**
     * 请求ip
     */
    @Column(name = "LogIp")
    private String logIp;

    /**
     * 用户类型1:门户后台-2:信用临安
     */
    @Column(name = "LogUserType")
    private String logUserType;

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
     * 获取用户登录名
     *
     * @return LogLoginName - 用户登录名
     */
    public String getLogLoginName() {
        return logLoginName;
    }

    /**
     * 设置用户登录名
     *
     * @param logLoginName 用户登录名
     */
    public void setLogLoginName(String logLoginName) {
        this.logLoginName = logLoginName;
    }

    /**
     * 获取操作业务编码
     *
     * @return LogOperaterCode - 操作业务编码
     */
    public String getLogOperaterCode() {
        return logOperaterCode;
    }

    /**
     * 设置操作业务编码
     *
     * @param logOperaterCode 操作业务编码
     */
    public void setLogOperaterCode(String logOperaterCode) {
        this.logOperaterCode = logOperaterCode;
    }

    /**
     * 获取操作信息
     *
     * @return LogMsg - 操作信息
     */
    public String getLogMsg() {
        return logMsg;
    }

    /**
     * 设置操作信息
     *
     * @param logMsg 操作信息
     */
    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg;
    }

    /**
     * 获取操作日期
     *
     * @return LogDate - 操作日期
     */
    public Date getLogDate() {
        return logDate;
    }

    /**
     * 设置操作日期
     *
     * @param logDate 操作日期
     */
    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    /**
     * 获取请求ip
     *
     * @return LogIp - 请求ip
     */
    public String getLogIp() {
        return logIp;
    }

    /**
     * 设置请求ip
     *
     * @param logIp 请求ip
     */
    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    /**
     * 获取用户类型1:门户后台-2:信用临安
     *
     * @return LogUserType - 用户类型1:门户后台-2:信用临安
     */
    public String getLogUserType() {
        return logUserType;
    }

    /**
     * 设置用户类型1:门户后台-2:信用临安
     *
     * @param logUserType 用户类型1:门户后台-2:信用临安
     */
    public void setLogUserType(String logUserType) {
        this.logUserType = logUserType;
    }
}