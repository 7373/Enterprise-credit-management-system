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
    <title>权限管理</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/js/lib/ztree/css/zTreeStyle/zTreeStyle.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/system.css'/>">
</head>
<body>
<div class="iframe-wrap">
<!--     <div class="iframe-header-bg"></div> -->
    <div class="form-panel clearfix">
        <div class="title">权限管理</div>
        <div class="page-content">
            <div class="col-3">
                <div style="border-right: 1px solid #CCC; min-height: 400px;">
                    <ul id="permisionTree" class="ztree"></ul>
                </div>
            </div>
            <div class="col-9">
                <div style="margin: 0 20px;">
                    <div class="form-header">
                        权限维护&nbsp;
                        <button class="btn" id="reloadBtn">重新加载</button>
                    </div>
                    <button class="btn btn-xs" id="addBtn">新增</button>
                    <button class="btn btn-xs" id="editBtn">修改</button>
                    <button class="btn btn-xs" id="delBtn">删除</button>
                    <div id="showArea">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script id="viewTemplate" type="text/x-handlebars-template">
    <input type="hidden" id="id" value="{{uid}}"/>
    <table class="table-col-spread" style="margin-top: 14px">
        <tbody>
        <tr>
            <td class="title">上级权限：</td>
            <td>{{parentName}}</td>
        </tr>
        <tr>
            <td class="title">权限名称：</td>
            <td>{{name}}</td>
        </tr>
        <tr>
            <td class="title">权限类型：</td>
            <td>{{type}}</td>
        </tr>
        <tr>
            <td class="title">权限资源：</td>
            <td>{{url}}</td>
        </tr>
        <tr>
            <td class="title">关联资源：</td>
            <td>{{relatedUrl}}</td>
        </tr>
        <tr>
            <td class="title">序号：</td>
            <td>{{sort}}</td>
        </tr>
        <tr>
            <td class="title">权限描述：</td>
            <td>{{desc}}</td>
        </tr>
        </tbody>
    </table>
</script>
<!-- 通用页面 -->
<jsp:include page="../common/common.jsp"/>
<script src="<c:url value='/js/gateway/system/syspermision/list_main.js'/>"></script>
</body>
</html>
