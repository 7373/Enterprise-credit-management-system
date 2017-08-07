package com.icinfo.ndrc.intercetor;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.ndrc.common.constant.LogTypeConstant;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.dto.SysUserDto;
import com.icinfo.ndrc.system.model.NdSysLog;
import com.icinfo.ndrc.system.service.INdSysLogService;
import com.icinfo.ndrc.util.RequestUtil;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2017-06-23.
 */
@Aspect
@Component
public class NdSysLogAspect {

    @Autowired
    private INdSysLogService ndSysLogService;

    @Pointcut("execution(* com.icinfo.ndrc.system.controller.GatewayLoginController.loginCheck(..))" +
            "|| execution(* com.icinfo.ndrc.system.controller.CreditLoginController.loginCheck(..))")
    public void doMethod(){

    }

    @AfterReturning(value = "doMethod()",returning = "returnValue")
    public void afterAdvice(AjaxResult returnValue) throws Exception{
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> qryMap = RequestUtil.getAllParam(request);
        HttpSession session = request.getSession();
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        NdSysLog log = new NdSysLog();
        if(sysUser==null){
            log.setLogLoginName(qryMap.get("sysUser.loginName"));
            log.setLogOperaterCode(LogTypeConstant.LogLoginFail.getLogCode());
            log.setLogMsg(LogTypeConstant.LogLoginFail.getLogMsg());
            log.setLogUserType(qryMap.get("sysUser.userType"));
        }else{
            log.setLogOperaterCode(sysUser.getLogCode());
            log.setLogLoginName(sysUser.getUsername());
            log.setLogUserType(sysUser.getUserType());
            if("success".equals(returnValue.getStatus())){
                log.setLogMsg(sysUser.getLogMsg()+"_操作成功");
            }else{
                log.setLogMsg(sysUser.getLogMsg()+"_操作失败");
            }
        }
        log.setLogIp(request.getRemoteAddr());
        log.setLogDate(new Date());
        ndSysLogService.insert(log);
    }

}
