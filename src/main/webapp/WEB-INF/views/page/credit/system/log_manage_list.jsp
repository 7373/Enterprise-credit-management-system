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
    <title>临安信用信息应用平台</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/credit/credit.css'/>">
</head>
<body>
<form id="hxForm">
	<input type="hidden" name="${_session_sys_user_key.realName}" /> 
	<input type="hidden" id="userType" name="${session_sys_user.userType}" /> 
</form>
<div class="iframe-wrap">
    <div class="iframe-header-bg"></div>
    <div class="form-panel">
        <div class="title">日志监控</div>
        <div class="pd15">
            <table id="log-table" class="table-row" width="100%">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>最新操作人</th>
                    <th>操作内容</th>
                    <th>操作时间</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<!-- 通用页面 -->
	<jsp:include page="../../credit/system/common/common.jsp" />
<script src="<c:url value='/js/credit/system/syslog/log_manage_list.js'/>"></script>
</body>
</html>
