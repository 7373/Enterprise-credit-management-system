<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信用临安</title>
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/gateway.css"/>"/>
</head>
<body>
<jsp:include page="../common/gateway_header.jsp" />
<div class="xyla-nav-wrap xyla-nav-bg">
    <jsp:include page="../common/gateway_menu.jsp" />
</div>
<div class="wrap1000 mt20 clearfix">
    <div class="nav-left fl">
        <h3 class="nav-left-title">发布平台</h3>
        <ul class="nav-left-list js-nav-list">
        <input type="hidden" value="${param.item}" id="item"/>
<%--         <c:if test="${item=='Double' ||item=='Red' ||item=='Black' ||item=='Dept'}"> --%>
            <li><a class="${param.item=='Double'?'nav-cur':''}" href="javascript:void(0);" value="Double"><img src="/img/gateway/nav_left_arr.png"><span>七天双公示</span></a></li>
            <li><a class="${param.item=='Red'?'nav-cur':''}" href="javascript:void(0);" value="Red"><img src="/img/gateway/nav_left_arr.png"><span>信用红名单</span></a></li>
            <li><a class="${param.item=='Black'?'nav-cur':''}" href="javascript:void(0);" value="Black"><img src="/img/gateway/nav_left_arr.png"><span>信用黑名单</span></a></li>
<%--             <li><a class="${param.item=='Dept'?'nav-cur':''}" href="javascript:void(0);" value="Dept"><img src="/img/gateway/nav_left_arr.png"><span>部门公示</span></a></li> --%>
<%--         </c:if>	 --%>
        
            
        </ul>
    </div>
    <div class="cont-right fr">
        <div class="cont-title clearfix">
            <div class="fl cont-title-text">七天双公示</div>
            <div class="fl interval3"></div>
            <div class="cont-title-nav border-bottom2b">
                <span><a href="#">首页</a></span><span>></span><span><a href="#">发布平台</a></span>
            </div>
        </div>
        <input type="hidden" id="type" value="${type }">
        <input type="hidden" id="uid" value="${param.uid}">
        <input type="hidden" id="name" value="${param.name}">
        <div id="main"></div>
    </div>
</div>
<!-- 通用页面 -->
<jsp:include page="../common/gateway_footer.jsp"/>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value='/js/gateway/biz/reception/publish_platform.js'/>"></script>
</body>
</html>