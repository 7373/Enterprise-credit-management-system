<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    	<c:if test="${item==2000||item==2001||item==2002||item==2003}">
        <h3 class="nav-left-title">信用动态</h3>
        </c:if>
        <c:if test="${item==2004||item==2005||item==2006}">
        <h3 class="nav-left-title">政策法规</h3>
        </c:if>
        <c:if test="${item==2007||item==2008}">
        <h3 class="nav-left-title">信用研究</h3>
        </c:if>
        <ul class="nav-left-list js-nav-list">
            <c:if test="${item==2000||item==2001||item==2002||item==2003}">
            <li><a class="${item=='2000'?'nav-cur':''}" href="/gateway/reception/doEnCreditDynamic?menu=2"><img src="/img/gateway/nav_left_arr.png">信用临安动态</a></li>
            <li><a class="${item=='2001'?'nav-cur':''}" href="/gateway/reception/doEnCreditDynamic?menu=2"><img src="/img/gateway/nav_left_arr.png">信用杭州动态</a></li>
            <li><a class="${item=='2002'?'nav-cur':''}" href="/gateway/reception/doEnCreditDynamic?menu=2"><img src="/img/gateway/nav_left_arr.png">信用浙江动态</a></li>
            <li><a class="${item=='2003'?'nav-cur':''}" href="/gateway/reception/doEnCreditDynamic?menu=2"><img src="/img/gateway/nav_left_arr.png">信用中国动态</a></li>
            </c:if>
            <c:if test="${item==2004||item==2005||item==2006}">
            <li><a class="${item=='2004'?'nav-cur':''}" href="/gateway/reception/doEnPolicyRule?menu=3"><img src="/img/gateway/nav_left_arr.png">本地政策法规</a></li>
            <li><a class="${item=='2005'?'nav-cur':''}" href="/gateway/reception/doEnPolicyRule?menu=3"><img src="/img/gateway/nav_left_arr.png">省市政策法规</a></li>
            <li><a class="${item=='2006'?'nav-cur':''}" href="/gateway/reception/doEnPolicyRule?menu=3"><img src="/img/gateway/nav_left_arr.png">国家政策法规</a></li>
            </c:if>
            <c:if test="${item==2007||item==2008}">
                <li><a class="${item=='2007'?'nav-cur':''}" href="/gateway/reception/doEnCreditResearch?menu=4"><img src="/img/gateway/nav_left_arr.png">研究文献</a></li>
                <li><a class="${item=='2008'?'nav-cur':''}" href="/gateway/reception/doEnCreditResearch?menu=4"><img src="/img/gateway/nav_left_arr.png">视频资料</a></li>
            </c:if>
        </ul>
    </div>
    <div class="cont-right fr">
        <div class="cont-title clearfix">
            <div class="cont-title-nav">
                <span><a href="#">首页</a></span><span>></span><span><a href="#">
                <c:if test="${item==2000||item==2001||item==2002||item==2003}">信用动态</c:if>
                <c:if test="${item==2004||item==2005||item==2006}">政策法规</c:if>
                <c:if test="${item==2007||item==2008}">信用研究</c:if>
            </a></span>
            </div>
        </div>
        <h3 class="title-top">${publish.title}</h3>
        <div class="time-source">
            <span>发布时间：<fmt:formatDate value="${publish.publishTime}" pattern="yyyy年MM月dd日"/></span><span>&emsp;&emsp;来源：${publish.source}</span>
        </div>
        <div class="img-text">
            ${publish.content}
        </div>
    </div>
</div>
<jsp:include page="../common/gateway_footer.jsp"/>
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