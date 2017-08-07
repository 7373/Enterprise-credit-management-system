package com.icinfo.ndrc.intercetor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.framework.tools.utils.WebUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;


public class ServerLoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        //获取Session
        HttpSession session = request.getSession();
        if(session == null|| !request.isRequestedSessionIdValid()){
            response.sendRedirect(request.getContextPath() +sendLoginUrl(url));
            return  false;
        }
        if(session.getAttribute(Constants.SESSION_SYS_USER_KEY) == null ){
            if(WebUtils.isAjax(request)) {   // 判断是否是js的ajax 请求
                String _url = sendLoginUrl(url);  //跳转的登录路径
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(401);
                ObjectMapper mapper = new ObjectMapper();
                //String json = mapper.writeValueAsString("您尚未登录或登录时间过长,请重新登录!");
                String json = mapper.writeValueAsString(_url);
                PrintWriter pw = response.getWriter();
                pw.write(json);
                pw.close();
            }else{
                response.sendRedirect(request.getContextPath() + sendLoginUrl(url));
            }
            return false;
        }
		if (url.equals("/credit") || url.equals("/credit/")) {
			response.sendRedirect(request.getContextPath() + sendLoginUrl(url));
		}
        return true;
    }
    //判断登录地址 add gqf
    public String sendLoginUrl(String url){
        System.out.println("----"+url);
        if(url.indexOf("gateway/reception") >= 0){
            return "/";
        }else if(url.indexOf("gateway") >= 0){
            return "/login";
        }else if(url.indexOf("credit") >= 0){
           return "/xylogin";
       }else{
            return "/";
        }

    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
