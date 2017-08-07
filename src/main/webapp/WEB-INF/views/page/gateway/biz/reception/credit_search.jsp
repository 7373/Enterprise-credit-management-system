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
        <form id="hxForm" class="form-box mb10">
            <div class="query-criteria clearfix">
                <div class="fl mr24">
                    <label>企业名称：</label><input id="qymc" class="w-219" name="qymc" type="text">
                </div>
                <div class="fl mr24">
                    <label>社会统一信用代码/工商注册号：</label><input id="gszch" class="w-140" name="gszch" type="text">
                </div>
                <div class="fl">
                    <label>验证码：</label>
                    <input class="w-80 verification-code" type="text" id="checkCode" name="checkCode"  placeholder="请输入验证码"><span>
                    <img src="/ndrcCaptcha?t=0.9532056235676236" alt="" class="js-check-img" width="94px"></span>
                    <a href="javascript:void(0);" class="js-checkcode">换一张</a>
                </div>
                <div class="mt15">
                    <div class="center">
                        <input id="searchparam" type="hidden" name="searchparam" value="${param.searchparam}" />
                        <input type="button" id="search" value="查询" class="w-90 fs16 btn-sub btn-bg-bule">
                        <input type="reset" id="reset" value="重置" class="w-90 fs16 btn-sub btn-bg-bule">
                    </div>
                </div>
            </div>
        </form>

    <div class="box-panel">
        <table id="contract-table" class="table-row nowrap" width="100%">
            <thead>
            <tr>
                <th>序号</th>
                <th>企业名称</th>
                <th>社会统一信用代码/工商注册号</th>
                <th>操作</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<!-- 通用页面 -->
<jsp:include page="../common/gateway_footer.jsp"/>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value='/js/gateway/biz/reception/credit_search.js'/>"></script>
</body>
</html>