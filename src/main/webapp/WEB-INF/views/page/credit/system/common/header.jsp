<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<div class="header clearfix">
    <a href="#" class="logo fl js-logo"></a>
    <c:if test="${!empty _session_sys_user_key}">
        <div class="hd-nav fr">
            <ul class="clearfix">
                <li><span><i class="user-icon-i"></i>${_session_sys_user_key.realName}，您好！</span></li>
                <li><a href="/credit/admin/index"><i class="home-icon-i"></i>返回首页</a></li>
                <li><a href="javascript:void(0);" class="modify-pwd"><i class="change-password-icon-i"></i>修改密码</a></li>
                <li><a href="javascript:void(0);" class="js-logout log-out"><i class="log-out-i"></i>退出系统</a></li>
            </ul>
        </div>
    </c:if>
</div>
