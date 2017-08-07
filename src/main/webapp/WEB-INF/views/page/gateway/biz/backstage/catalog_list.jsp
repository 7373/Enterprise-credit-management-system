<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信用临安</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/system.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/admin.css"/>"/>
</head>
<body>
<div class="iframe-wrap">
<!--     <div class="iframe-header-bg"></div> -->
    <div class="form-panel">
        <div class="title">目录管理</div>
    	<form id="sceneForm" class="form-box">
        </form>
        
        <div class="clearfix mb5 pos-rel">
            <p class="fl"><input type="button" class="btn btn-sm mr5" value="新增" id="js-add"></p>
            <%--<span class="table-load js-table-load top20" title="刷新表格"></span>--%>
        </div>

        <div class="">
            <div class="table-out">
                <table id="scene-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap"
                       width="100%">
                    <thead>
                    <tr>
                        <th style="padding: 0 20px;">序号</th>
                        <th>操作</th>
                        <th>一级目录</th>
                        <th>二级目录</th>
                        <th>目录类别</th>
                        <th>创建时间</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../../system/common/common.jsp"/>
<script src="<c:url value='/js/gateway/biz/backstage/catalog_list.js'/>"></script>
</body>
</html>