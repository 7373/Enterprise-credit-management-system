<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信用临安_7互动交流2</title>
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
        <li><a href="javascript:void(0);">政策法规</a></li>
        <li><a href="javascript:void(0);">信用研究</a></li>
        <li><a href="javascript:void(0);">信用查询</a></li>
        <li><a href="javascript:void(0);">发布平台</a></li>
        <li><a class="active" href="javascript:void(0);">互动交流</a></li>
    </ul>
</div>
<div class="wrap1000 mt20 clearfix">
    <div class="nav-left fl">
        <h3 class="nav-left-title">互动交流</h3>
        <ul class="nav-left-list js-nav-list">
            <li><a href="javascript:void(0);"><img src="/img/gateway/nav_left_arr.png"> 信用咨询</a></li>
            <li><a class="nav-cur" href="javascript:void(0);"><img src="/img/gateway/nav_left_arr.png">信用申诉</a></li>
            <li><a href="javascript:void(0);"><img src="/img/gateway/nav_left_arr.png">反馈结果</a></li>
        </ul>
    </div>
    <div class="cont-right fr">
        <div class="cont-title clearfix">
            <div class="fl cont-title-text">信用申述</div>
            <div class="fl interval3"></div>
            <div class="cont-title-nav border-bottom2b">
                <span><a href="#">首页</a></span><span>></span><span><a href="#">互动交流</a></span>
            </div>
        </div>
        <form id="" method="" action="" name="">
            <div class="credit-info pl15">
                <ul>
                    <li><label class="w-131">申述人/企业/机构名称：</label><input class="w-600" type="text"></li>
                    <li>
                        <label class="w-131 vertical10">申述机构：</label><div class="select-box">
                        <select class="select">
                            <option value="volvo">Volvo</option>
                            <option value="saab">Saab</option>
                            <option value="opel">Opel</option>
                            <option value="audi">Audi</option>
                        </select>
                    </div>

                    </li>
                    <li>
                        <label class="w-131 vertical10">证件类型：</label><div class="select-box">
                        <select class="select">
                            <option value="volvo">Volvo</option>
                            <option value="saab">Saab</option>
                            <option value="opel">Opel</option>
                            <option value="audi">Audi</option>
                        </select>
                    </div>

                    </li>
                    <li><label class="w-131">证件号码：</label><input type="text"></li>
                    <li><label class="w-131">联系邮箱：</label><input type="text"></li>
                    <li><label class="w-131">联系电话：</label><input type="text"></li>
                    <li>
                        <label class="w-131">手机验证码：</label><input class="w-70" type="text">
                        <a class="btn-mad btn-bg-bule" href="javascript:void(0);">发送验证码</a>
                        <a class="btn-mad w-100 btn-bg-disable" href="javascript:void(0);">60S后重新发送</a>
                        <a class="btn-mad btn-bg-bule" href="javascript:void(0);">重新发送</a>
                    </li>
                    <li><label class="w-131"><span>*</span>留言标题：</label><input class="w-600" type="text"></li>
                    <li><label class="w-131"><span>*</span>留言内容：</label><textarea class="textarea-message" rows="10"></textarea></li>
                    <li>
                        <label class="w-131">相关证明材料：</label>
                        <div class="file-box">
                            <input type="text" class="textfield" id="textfield">
                            <input type="button" class="upload btn-mad w-60 btn-bg-bule" value="上传">
                            <input type="file" class="file" onchange="document.getElementById('textfield').value=this.value">
                        </div>
                    </li>
                    <li>
                        <label class="w-131">验证码：</label><input class="w-60" type="text">
                        <a href="javascript:void(0);"><img src="/img/gateway/verification_Code.jpg">看不清楚，换一张</a>
                    </li>
                </ul>
            </div>
            <p class="center notice mb10"><input type="checkbox">同意<a href="#">《留言须知》</a></p>
            <div class="btn-group center">
                <input class="w-90 fs16 btn-sub btn-bg-bule h-40" type="submit" value="提交">
                <input class="w-90 fs16 btn-sub btn-bg-bule h-40" type="reset" value="重置">
            </div>
        </form>
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