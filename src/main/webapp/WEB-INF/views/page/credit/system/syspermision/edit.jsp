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
    <link rel="stylesheet" href="<c:url value='/css/system.css'/>">
</head>
<body class="white-bg">
<div class="container .container-fluid">
    <div class="form-format">
        <form class="form-horizontal" id="sysPermisionForm">
            <input type="hidden" name="uid" value="${sysPermision.uid}">
            <div class="form-group clearfix">
                <label class="col-3 control-label">上级权限：</label>
                <div class="col-9 mt5">
                    <c:choose>
                        <c:when test="${empty sysPermision}">
                            <input type="radio" name="parentId" checked="checked" value="${parentIdForSibling}">添加同级权限
                            <input type="radio" name="parentId" value="${parentIdForSub}">添加子权限
                        </c:when>
                        <c:otherwise>
                            ${empty parentName?"没有了":parentName}
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label">权限名称(<span style="color: red"> *</span>)：</label>
                <div class="col-9">
                    <input type="text" name="name" class="form-control" placeholder="请输入权限名称"
                           value="${sysPermision.name}">
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label">权限类型：</label>
                <div class="col-9 mt5">
                    <c:choose>
                        <c:when test="${empty sysPermision}">
                            <input type="radio" name="type" checked="checked" value="1">菜单权限
                            <input type="radio" name="type" value="0">操作权限
                        </c:when>
                        <c:otherwise>
                            ${type=="1"?"菜单权限":"操作权限"}
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label">权限资源(<span style="color: red"> *</span>)：</label>
                <div class="col-9">
                    <input type="text" name="url" class="form-control" placeholder="请输入权限资源"
                           value="${sysPermision.url}">
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label">关联资源：</label>
                <div class="col-9">
                    <input type="text" name="relatedUrl" class="form-control" placeholder="请输入关联权限资源"
                           value="${sysPermision.relatedUrl}">
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label">序号：</label>
                <div class="col-9">
                    <input type="text" name="sort" class="form-control" placeholder="请输入序号"
                           value="${sysPermision.sort}">
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label">权限描述：</label>
                <div class="col-9">
                    <textarea name="desc" class="form-control" placeholder="请输入权限描述">${sysPermision.desc}</textarea>
                </div>
            </div>
            <input type="hidden" name="permisionSysType" value="2"/>
        </form>
    </div>
    <div class="row center">
        <button id="save" type="button" class="btn btn-sm mr20">保存</button>
        <button id="cancel" type="button" class="btn btn-sm mr20">取消</button>
    </div>
</div>
<!-- 通用页面 -->
<jsp:include page="../common/common.jsp"/>
<script src="<c:url value='/js/credit/system/syspermision/edit_main.js'/>"></script>
</body>
</html>
