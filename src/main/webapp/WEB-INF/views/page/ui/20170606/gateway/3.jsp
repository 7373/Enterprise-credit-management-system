<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信用临安_2信用动态2</title>
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
        <li><a class="active" href="javascript:void(0);">信用动态</a></li>
        <li><a href="javascript:void(0);">政策法规</a></li>
        <li><a href="javascript:void(0);">信用研究</a></li>
        <li><a href="javascript:void(0);">信用查询</a></li>
        <li><a href="javascript:void(0);">发布平台</a></li>
        <li><a href="javascript:void(0);">互动交流</a></li>
    </ul>
</div>
<div class="wrap1000 mt20 clearfix">
    <div class="nav-left fl">
        <h3 class="nav-left-title">信用动态</h3>
        <ul class="nav-left-list js-nav-list">
            <li><a href="javascript:void(0);"><img src="/img/gateway/nav_left_arr.png"> 本地动态</a></li>
            <li><a class="nav-cur" href="javascript:void(0);"><img src="/img/gateway/nav_left_arr.png">省市动态</a></li>
            <li><a href="javascript:void(0);"><img src="/img/gateway/nav_left_arr.png">国家动态</a></li>
        </ul>
    </div>
    <div class="cont-right fr">
        <div class="cont-title clearfix">
            <div class="cont-title-nav">
                <span><a href="#">首页</a></span><span>></span><span><a href="#">信用动态</a></span>
            </div>
        </div>
        <h3 class="title-top">我市召开信用杭州建设领导小组会议</h3>
        <div class="time-source">
            <span>发布时间：2017年05月24日</span><span>来源：“中国杭州” 政府门户网站</span>
        </div>
        <div class="img-text">
            <div class="center mb20">
                <img src="/img/gateway/dynamic_01.jpg">
            </div>
            <p>5月24日上午，我市召开2017年全市信用杭州建设领导小组会议，市委常委、常务副市长戴建平出席会议。会议通报了2016年度信用杭州建设工作先进单位，市发改委对我市2016年信用杭州建设工作进行了总结，并对2017年信用工作重点任务作出了具体部署。</p>
            <p>会议指出，今年是我市争创全国社会信用示范城市的关键之年，各级各部门要深刻领会社会信用体系建设的重要意义。用发展的眼光看，信用是智慧城市的基石，信用城市是智慧城市的高级形态；用联系的眼光看，信用与居民生活、企业生产和城市治理的关联性日益紧密；用辩证的眼光看，信用的特征是“数据”，关键在“应用”。</p>
            <p>会议强调，要围绕政府、企业和个人三大主体，扎实推进社会信用体系建设。一是实行信用信息管理“一平台”。 今年年底前，桐庐、萧山、余杭、富阳、临安、建德、淳安等7个区、县（市）要完成公共信息平台建设。二是推进政务诚信建设“一盘棋”。把政务诚信建设放在更加突出的位置，突出重点领域的政务诚信建设，以政务诚信引领全社会诚信守信。三是加强企业信用管理“一个码”。在全国率先开展以统一社会信用代码为核心的“1+N”+X多证合一、证照联办改革；在商务诚信领域积极探索跨境电子商务的综合信用评价机制。四是加强个人诚信建设“一条龙”。加强个人信用数据安全管理，积极推广个人信用应用，完善个人守信激励和失信惩戒机制。五是统筹推进联合惩戒“一张网”。加强政府与社会、各级政府间的联动，积极融入全国信用信息共享平台，更好地实施联合惩戒。</p>
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
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
    $(function () {
        $('.js-nav-list a').on('click',function () {
            $('.js-nav-list a').removeClass('nav-cur');
            $(this).addClass('nav-cur');
        })
    })
</script>
</html>