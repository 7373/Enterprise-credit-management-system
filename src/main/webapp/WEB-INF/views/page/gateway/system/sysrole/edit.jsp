<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>权限管理</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/js/lib/ztree/css/zTreeStyle/zTreeStyle.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/system.css'/>">
</head>
<body class="white-bg">
<div class="container .container-fluid">
    <div class="clearfix form-format">
        <div class="col-6">
            <form class="form-horizontal" id="sysRoleForm">
                <input type="hidden" id="uid" name="uid" value="${sysRole.uid}">
                <div class="form-group">
                   <font color="red">*</font><label class="control-label">角色名称：</label>
                    <input type="text" name="name" class="form-control" placeholder="请输入角色名称"
                           value="${sysRole.name}">
                </div>
                <div class="form-group">
                    <font color="red">*</font><label class="control-label">备注：</label>
                    <textarea name="desc" class="form-control" rows="8" placeholder="请输入角色描述">${sysRole.desc}</textarea>
                </div>
            </form>
        </div>
        <div class="col-6">
            <h5>选择角色权限</h5>
            <ul id="permisionTree" class="ztree"></ul>
        </div>
    </div>
    <div class="row center">
        <button id="save" type="button" class="btn btn-sm mr20">保存</button>
        <button id="cancel" type="button" class="btn btn-sm mr20">取消</button>
    </div>
</div>
<script>
    var roleId = '${sysRole.uid}';
</script>
<!-- 通用页面 -->
<jsp:include page="../common/common.jsp"/>
<script src="<c:url value='/js/gateway/system/sysrole/edit_main.js'/>"></script>
</body>
</html>