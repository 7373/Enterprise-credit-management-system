<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信用临安_5信用查询1</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/gateway.css"/>"/>
</head>
<body>
<div class="xyla-header clearfix">
    <div class="wrapper">
        <div class="time fl">
            <p>您好，欢迎来到信用临安！ <span>2017年4月17日</span> <span>星期一</span></p>
        </div>
        <ul class="backstage fr">
            <li class="credit"><a href="javascript:void(0);"><i></i>信用申报</a></li>
            <li class="admini"><a href="javascript:void(0);"><i></i>后台管理</a></li>
        </ul>
    </div>
</div>

<div class="xyla-logo">
    <div class="wrapper">
        <a href="javascript:void(0);">
            <img class="logo-img" src="/img/gateway/xyla-logo.png" alt="logo">
        </a>
    </div>
</div>
<div class="xyla-nav-wrap xyla-nav-bg">
    <ul class="xyla-nav">
        <li><i></i><a href="javascript:void(0);">首页</a></li>
        <li><a href="javascript:void(0);">组织架构</a></li>
        <li><a href="javascript:void(0);">信用动态</a></li>
        <li><a class="active" href="javascript:void(0);">政策法规</a></li>
        <li><a href="javascript:void(0);">信用研究</a></li>
        <li><a href="javascript:void(0);">信用查询</a></li>
        <li><a href="javascript:void(0);">发布平台</a></li>
        <li><a href="javascript:void(0);">互动交流</a></li>
    </ul>
</div>
<div class="wrap1000 mt20 clearfix">
        <div class="cont-title clearfix">
            <div class="fl cont-title-text">信用查询</div>
            <div class="fl interval3"></div>
            <div class="cont-title-nav border-bottom2b">
                <span><a href="#">首页</a></span><span>></span><span><a href="#">信用查询</a></span>
            </div>

        </div>
        <div class="explain mt4">
            查询说明：目前查询的法人信用记录，是有关政府部门按照有关规定向社会公开的信用信息。对查看到的信用信息有异议，可提出异议处理。
        </div>
        <div class="query-criteria clearfix">
            <div class="fl mr24">
                <label>企业名称：</label><input class="w-219" type="text">
            </div>
            <div class="fl mr24">
                <label>社会统一信用代码/工商注册号：</label><input class="w-140" type="text">
            </div>
            <div class="fl mr20">
                <label>验证码：</label><input class="w-60" type="text"> <img src="/img/gateway/verification_Code.jpg">
            </div>
            <div class="fl">
                <a class="explain-btn" href="javascript:void(0)">查询</a>
            </div>
        </div>
</div>
<div class="xyla-footer">
    <div class="wrapper">
        <p>
            <span class="mr15">主办：台州市发展和改革委员会</span>
            <span>备案/许可证编号：浙ICP备11061391号</span>
        </p>
        <p>
            <span class="gh-icon mr15"><i></i>浙公网安备：33100202000545号</span>
            <span class="dzjg-icon"><i></i>技术支持：<a href="http://www.icinfo.cn/" target="_blank">浙江汇信科技有限公司</a></span>
        </p>
    </div>
</div>
</body>
</html>