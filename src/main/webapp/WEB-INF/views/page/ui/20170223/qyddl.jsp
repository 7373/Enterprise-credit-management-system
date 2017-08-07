<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/biz.css"/>"/>
</head>
<body class="c-login-bg">
<div class="login-hd center">
    <h3><img src="/img/biz/client-login-logo.png" alt=""></h3>
    <div class="login-box clearfix">
        <div class="show-banner fl">
            <h4>企业登录</h4>
        </div>
        <div class="user-box fl">
            <ul>
                <li class="user"><i class="cl-icon"></i><input type="text" placeholder="请输入用户名"/></li>
                <li class="pw"><i class="cl-icon"></i><input type="password" placeholder="请输入密码"></li>
                <li class="yzm clearfix mb3">
                    <span class="mr8 fl"><input type="text" placeholder="请输入验证码"></span><!-
                    --><img src="/img/biz/yzm.png" alt="" class="mr8 fl"><!-
                    --><a href="" class="fl">换一张</a>
                </li>
                <li class="error">验证码错误！</li>
                <li>
                    <input type="button" class="btn-login" value="登录">
                </li>
                <li class="other clear">
                    <a href="" class="fl">用户注册</a><a href="" class="fr">忘记密码？</a>
                </li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>