<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/system.css"/>"/>
</head>
<body class="white-bg baxt-flex">
<!-- 头部开始 -->
<div class="sys-top">
    <div class="logo"></div>
    <div class="mod search-main">
        <div class="gs-search-box">
            <input type="text" class="search-txt" placeholder="输入企业名称/合同名称"><button class="search-btn"><img src="/img/system/search-icon.png" alt=""> 搜索</button>
        </div>

    </div>
</div>
<div class="search-cont mod">
    <div class="nodate center">
        <img src="/img/system/no-data.png" alt="">
        <p>暂无该企业相关数据！</p>
    </div>
</div>


<!-- 底部 开始 -->
<div class="footer">
    <p>©&nbsp;&nbsp;2016 浙江汇信科技有限公司 版权所有<br>
        浙ICP备：浙B2-20070198-13&nbsp;&nbsp;&nbsp;&nbsp;浙公网安备：33010502002208号
    </p>
</div>
</body>
</html>