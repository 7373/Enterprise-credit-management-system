<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>查看授权</title>
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/credit/credit.css'/>">
</head>
<body>
<div class="main ">
    <form id="hxForm">
    	<input type="hidden" name="userID" value="${ndGrant.graUserID}">
    	<input type="hidden" id="userName" name="userName" value="${ndGrant.graUserName}">
    </form>
    
     <div class="box-panel">
        <table id="grantInfo-table" class="table-row nowrap" width="100%">
            <thead>
            <tr>
		    	<th>序号</th>
		    	<th>姓名</th>
		    	<th>授权注册号/证件号</th>
		    	<th>授权企业名称/个人姓名</th>
		    	<th>授权开始日期</th>
		    	<th>授权截止日期</th>
		    	<th>操作</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <a href="javascript:void(0);"  class="{{this.class}}">{{this.text}}</a>
    {{/each}}
</script>
<script src="<c:url value='/js/lib/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script src="<c:url value='/js/credit/system/grant/credit_grant_view.js'/>"></script>
</body>
</html>