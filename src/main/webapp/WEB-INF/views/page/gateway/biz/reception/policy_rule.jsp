<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信用临安</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/gateway.css"/>"/>
</head>
<body>
<jsp:include page="../common/gateway_header.jsp" />
<div class="xyla-nav-wrap xyla-nav-bg">
    <jsp:include page="../common/gateway_menu.jsp" />
</div>

<div class="wrap1000 mt20 clearfix">
    <div class="nav-left fl">
        <h3 class="nav-left-title">政策法规</h3>
        <ul class="nav-left-list js-nav-list">
            <li><a class="nav-cur" href="javascript:void(0);" type="2004"><img src="/img/gateway/nav_left_arr.png"><span>本地政策法规</span></a></li>
            <li><a href="javascript:void(0);" type="2005"><img src="/img/gateway/nav_left_arr.png"><span>省市政策法规</span></a></li>
            <li><a href="javascript:void(0);" type="2006"><img src="/img/gateway/nav_left_arr.png"><span>国家政策法规</span></a></li>
        </ul>
    </div>
    <div class="cont-right fr">
        <div class="cont-title clearfix">
            <div class="fl cont-title-text">本地政策法规</div>
            <div class="fl interval3"></div>
            <div class="cont-title-nav border-bottom2b">
                <span><a href="#">首页</a></span><span>></span><span><a href="#">政策法规</a></span>
            </div>
        </div>
        <ul id="notice-list-id" class="notice-list cont-list fr"></ul>
        <div class="notice-pagination-box clearfix">
            <div id="pageforhide">
                    <span class="items-page" id="items-page">每页
                        <select>
                            <option value="5">5</option>
                            <option value="10" selected>10</option>
                            <option value="15">15</option>
                            <option value="20">20</option>
                            <option value="25">25</option>
                            <option value="30">30</option>
                        </select>条
                    </span>
                <span class="page-total">共<em id="notice-total"></em>条数据</span>
                <div id="pagination" class="pagination">

                </div>
            </div>
            <div id="nodata"></div>
        </div>

    </div>

</div>
<script id="notice_li_list" type="text/x-handlebars-template">
    {{#each data}}
    <li><a href="/gateway/reception/publish/getPublishDetail?menu=3&item={{type2Code}}&uid={{uid}}" class="headTitle" linkUID="{{UID}}" ><span>></span>{{title}}
        <span class="fr">{{publishTime}}</span></a></li>
    {{/each}}
</script>
<!-- 通用页面 -->
<jsp:include page="../common/gateway_footer.jsp"/>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/pagination/jquery.pagination.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value='/js/gateway/biz/reception/policy_rule.js'/>"></script>
</body>
</html>