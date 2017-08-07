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
        <h3 class="nav-left-title">互动交流</h3>
        <ul class="nav-left-list js-nav-list">
            <li><a class="nav-cur" href="javascript:void(0);" val="doEnCreditConsult"><img src="/img/gateway/nav_left_arr.png"><span>信用咨询</span></a></li>
<!--             <li><a href="javascript:void(0);" val="doEnCreditAppeal"><img src="/img/gateway/nav_left_arr.png"><span>异议申诉</span></a></li> -->
<!--             <li><a href="javascript:void(0);" val="doEnCreditFeedback"><img src="/img/gateway/nav_left_arr.png"><span>反馈结果</span></a></li> -->
        </ul>
    </div>
    <div class="cont-right fr">
        <div class="cont-title clearfix">
            <div class="fl cont-title-text">信用咨询</div>
            <div class="fl interval3"></div>
            <div class="cont-title-nav border-bottom2b">
                <span><a href="#">首页</a></span><span>></span><span><a href="#">互动交流</a></span>
            </div>
        </div>

        <div id="main">
            <jsp:include page="inter_consult.jsp" />
        </div>
    </div>
</div>
<!-- 通用页面 -->
<jsp:include page="../common/gateway_footer.jsp"/>
<%--<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>--%>
<%--<script src="/js/lib/pagination/jquery.pagination.js"></script>--%>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value='/js/gateway/biz/reception/inter_communion.js'/>"></script>
</body>
</html>