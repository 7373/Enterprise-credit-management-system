<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-06-21
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信用临安</title>
</head>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/gateway.css"/>"/>
<body>
<div class="mt38">
    <div class="home-item h-statistics">
    <input id="uid" value="${uid}" type="hidden"/>
        <div class="h-contant clearfix" style="border-top: none; height: 350px;">
            <div id="main" style="height:350px;"></div>
        </div>

    </div>
</div>
<script src="/js/lib/echarts/echarts-all.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/gateway/biz/reception/survey_bar.js"></script>
</body>
</html>
