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
<body class="white-bg">
<!-- 头部开始 -->
<div class="sys-top">
    <div class="logo"></div>
</div>

<!-- 主体 用户登录开始 -->
<div class="mod login-main">
    <div class="tip">
        <a href="###"><i class="icon-enter"></i>
        工商格式合同备案系统企业端</a>
    </div>
    <div class="login-l">
        <h3 class="login-title">工商电子工作证登录</h3>
        <div class="login-box">
            <p>请先插入电子工作证</p>
            <input type="button" class="btn btn-login2" value="登录">
        </div>
    </div>
    <div class="login-r">
        <h3 class="login-title">用户名密码登录</h3>
        <div class="user-box fl">
            <ul>
                <li class="user"><i class="cl-icon"></i><input type="text" class="txt" placeholder="请输入用户名"></li>
                <li class="pw"><i class="cl-icon"></i><input type="password"  class="txt"  placeholder="请输入密码"></li>
                <li class="yzm clearfix mb3">
                    <span class="mr8 fl"><input type="text" class="txt" placeholder="请输入验证码"></span><!---
                    ----><img src="/img/biz/yzm.png" alt="" class="mr8 fl"><!---
                    ----><a href="" class="fl">换一张</a>
                </li>
                <li class="error" id="errorContainer"></li>
                <li>
                    <input type="button" class="btn-login" value="登录">
                </li>
            </ul>
        </div>
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