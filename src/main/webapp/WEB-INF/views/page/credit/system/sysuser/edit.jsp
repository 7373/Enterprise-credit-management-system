<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>用户管理</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/credit/credit.css'/>">
</head>
<style type="text/css">
.pt{position:relative}
</style>
<body class="white-bg">
<div class="container .container-fluid">
    <div class="form-format">
        <form class="form-horizontal" id="sysUserForm">
            <input type="hidden" id="uid" name="uid" value="${sysUser.uid}">
            <div class="form-group clearfix">
                <label class="col-3 control-label ">用户名：</label>
                <div class="col-9">
                    <input type="text" name="username" class="form-control" autocomplete="off" placeholder="请输入登录用户名"
                           value="${sysUser.username}">
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label ">登录密码：</label>
                <div class="col-9">
                    <input type="password" name="password" class="form-control" placeholder="${empty sysUser.uid?"请输入登录密码":"如需修改密码，请输入新密码"}"
                           value="">
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label ">姓名：</label>
                <div class="col-9">
                    <input type="text" name="realName" class="form-control" placeholder="请输入姓名"
                           value="${sysUser.realName}">
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label ">Email：</label>
                <div class="col-9">
                    <input type="text" name="email" class="form-control" placeholder="请输入Email地址"
                           value="${sysUser.email}">
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label ">部门：</label>
                <div class="col-9 pos-rel">
                    <input type="text" class="form-control"  id="orgName" value="" readonly/>
                        <input type="hidden"  name="dept" id="orgCode" value="${sysUser.dept}"/>
                        <span class="add-icon" id="selectDept">
                            <i></i>
                        </span>
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label ">角色：</label>
                <div class="col-9">
                    <c:forEach var="role" items="${allRoles}">
                        <label class="checkbox-inline">
                            <input type="checkbox" name="roles[]"
                                   value="${role.uid}" ${!empty userRoles[role.uid]?"checked":""}>${role.name}
                        </label>
                    </c:forEach>
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-3 control-label ">备注：</label>
                <div class="col-9">
                    <textarea name="desc" class="form-control">${sysUser.desc}</textarea>
                </div>
            </div>
            <input type="hidden" name="userType" value="2">
            <div class="center mt20">
                <button id="save" type="submit" class="btn btn-sm mr20">保存</button>
                <button id="cancel" type="button" class="btn btn-sm mr20">取消</button>
            </div>
        </form>
    </div>
</div>
<script>
    window._CONFIG = {
        select_dept_url: '<c:url value="/credit/dept/enRadioTreeSelect"/>'
    }
</script>
<!-- 通用页面 -->
<jsp:include page="../common/common.jsp"/>
<script src="<c:url value='/js/credit/system/sysuser/edit_main.js'/>"></script>
</body>
</html>