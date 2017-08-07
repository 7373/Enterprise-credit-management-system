<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>信用临安门户后台</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/layout-default-latest.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/admin.css"/>"/>
</head>
<body style="overflow: hidden; position: relative;">
<div id="container">
    <div class="pane ui-layout-center">
        <div id="page-wrapper">
            <jsp:include page="common/header.jsp"/>
            <div id="content-main" class="J_mainContent">

                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="/gateway/backstage/mainpage" frameborder="0"></iframe>
            </div>
            <jsp:include page="common/footer.jsp"/>
        </div>
    </div>

    <div class="pane ui-layout-west">
        <div class="nano">
            <div class="nano-content">
                <%--<div class="user-info">--%>
                <%--<p class="user-name"> ${_session_sys_user_key.realName}，您好！</p>--%>
                <%--<a href="javascript:void(0)" class="modify-pwd">修改密码</a>--%>
                <%--</div>--%>
                <div class="index-logo">
                    <img src="/img/gateway/admin/index-logo.png" alt="">
                </div>
                <div class="sidebar">
                    <div class="sidebar-nav">
                        <ul id="side-menu">

                            <c:forEach var="menu_1" items="${menus['-1']}">
                                <li class="list-item">
                                    <c:if test="${menu_1.name == '资讯管理'}">
                                        <a href="javascript:void(0)" class="sub-title"><i class="nav-img nav-img1"></i><span
                                                class="nav-label">${menu_1.name}</span></a>
                                    </c:if>
                                    <c:if test="${menu_1.name == '互动交流'}">
                                        <a href="javascript:void(0)" class="sub-title"><i class="nav-img nav-img2"></i><span
                                                class="nav-label">${menu_1.name}</span></a>
                                    </c:if>
                                    <c:if test="${menu_1.name == '系统功能'}">
                                        <a href="javascript:void(0)" class="sub-title"><i class="nav-img nav-img3"></i><span
                                                class="nav-label">${menu_1.name}</span></a>
                                    </c:if>

                                    <c:if test="${!empty menus[menu_1.uid]}">
                                        <ul class="nav nav-second-level">

                                            <c:forEach var="menu_2" items="${menus[menu_1.uid]}">

                                                <c:if test="${empty menus[menu_2.uid]}"> <%--不存在三级目录 则二级目录触发--%>
                                                    <li><a class="J_menuItem" href="javascript:void(0);"
                                                           data-href="${menu_2.url}"
                                                    >${menu_2.name}</a></li>
                                                </c:if>

                                                <c:if test="${!empty menus[menu_2.uid]}"> <%--存在三级目录 则二级目录不触发 三级目录触发--%>
                                                    <li>
                                                        <a href="javascript:void(0)">${menu_2.name}</a>
                                                        <ul class="nav nav-third-level">
                                                            <c:forEach var="menu_3" items="${menus[menu_2.uid]}">
                                                                <li><a class="J_menuItem" href="javascript:void(0);"
                                                                       data-href="${menu_3.url}"
                                                                >${menu_3.name}</a></li>
                                                            </c:forEach>
                                                        </ul>

                                                    </li>
                                                </c:if>

                                            </c:forEach>
                                        </ul>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 通用页面 -->
<jsp:include page="common/common.jsp"/>
<script src="<c:url value='/js/gateway/system/index_mian.js'/>"></script>
</body>
</html>