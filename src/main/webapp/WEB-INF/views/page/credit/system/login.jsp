<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信用临安门户网站管理平台</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/admin.css"/>"/>
</head>
<body>
<h3 class="login-hd"><div class="login-title">后台管理平台</div></h3>
<form id="login-form">
<div class="login-box">
    <ul>
        <li class="user"><i ></i><input type="text" name="username" id="username" placeholder="请输入用户名"></li>
        <li class="pw"><i ></i><input type="password" name="password" id="password" placeholder="请输入密码"></li>
        <li class="error h-20 border-none" id="errorContainer"></li>
        <li class="log-btn"><input type="submit" class="btn-login" value="登录"></li>
    </ul>
</div>
    </form>

<div class="footer">
    主办：临安市发展和改革委员会&nbsp;&nbsp;&nbsp;&nbsp;技术支持：浙江汇信科技有限公司<br/>
    浙ICP备：浙B2-20070198-13 &nbsp;&nbsp;&nbsp;&nbsp;浙公网安备：33010502002208号
</div>
</body>
<script src="<c:url value='/js/lib/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script src="<c:url value='/js/credit/system/credit_login.js'/>"></script>
</body>
</html>