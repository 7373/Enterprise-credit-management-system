<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<div class="header clearfix index-top">
    <h1 class="loged-title fl">
        信用临安门户后台管理平台欢迎您！
    </h1>
    <c:if test="${param.ref != 'client'}">
        <div class="fr">
            <c:if test="${!empty _session_sys_user_key}">
                <div class="login-after login-info">
                    <span class="user-name">
                        <a href="javascript:void(0);">${_session_sys_user_key.realName}，您好！</a>
                    </span>
                    <a href="/gateway/admin/index" class="pos-rel">首页</a>
                    <a href="javascript:void(0);" class="log-updatepw pos-rel modify-pwd">修改密码<i class="icon-updatepw"></i></a>
                    <a href="javascript:void(0);" class="log-out pos-rel js-logout">退出 <i class="icon-out"></i></a>
                </div>
            </c:if>
            <c:if test="${empty _session_sys_user_key}">
                <div class="entry">
                    <a href="<c:url value='/cas/login'/>" class="login-btn">登录</a>
                </div>
            </c:if>
        </div>
    </c:if>
</div>