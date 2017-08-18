package com.icinfo.ndrc.common.constant;

/**
 * Created by Administrator on 2017-06-26.
 */
public enum  LogTypeConstant {

    LogLogin("1000","用户登录"),
    LogLoginFail("10001","用户登录失败");

    private String logCode;
    private String logMsg;

    private LogTypeConstant(String logCode,String logMsg){
        this.logCode = logCode;
        this.logMsg = logMsg;
    }

    public String getLogCode() {
        return logCode;
    }

    public void setLogCode(String logCode) {
        this.logCode = logCode;
    }

    public String getLogMsg() {
        return logMsg;
    }

    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg;
    }
}
