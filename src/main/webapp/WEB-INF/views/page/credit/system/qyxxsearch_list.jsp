<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/credit/credit.css'/>">
</head>
<body>
<div class="iframe-wrap">
    <div class="form-panel">
        <div class="title">企业信息查询</div>
        <div class="tip light">查询说明：目前查询的法人信用记录，是有关政府部门按照有关规定向社会公开的信用信息。对查看到的信用信息有异议，可提出<a href="/credit/appeal/views">异议处理</a>。</div>
        <form id="hxForm" class="form-box mb10">
            <div class="form-list">
                <div class="form-item clearfix mr20">
                    <div class="col-6">
                        <label class="item-name col-4">企业名称：</label>
                        <div class="col-5">
                            <div class="ipt-box">
                                <input type="text" class="ipt-txt clx" name="qymc" value="">
                            </div>
                        </div>

                    </div>
                    <div class="col-6">
                        <label class="item-name col-5">社会统一信用代码/工商注册号：</label>
                        <div class="col-5">
                            <div class="ipt-box">
                                <input type="text" class="ipt-txt clx"  name="gszch" value="" style="margin-left: 10px;">
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="mt15">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="button" id="reset" value="重置" class="btn ">
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
                <th>预警标识</th>
                <th>操作</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
</div>
<!-- 通用页面 -->
<jsp:include page="../../credit/system/common/common.jsp"/>
<script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery-1.12.3.min.js'/> "></script>
<script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery.serialize-object.min.js'/> "></script>
<script src="<c:url value='/js/lib/laydate/laydate.js'/> "></script>
<script src="<c:url value='/js/lib/require.js'/> "></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script src="<c:url value='/js/credit/system/qyxxsearch_list.js'/>"></script>
</body>
</html>
