<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/credit/credit.css"/>" />
<link rel="stylesheet"
	href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
	
</head>
<body>
<form id="hxForm">
	<input type="hidden" name="enterprise_id" value="${param.uid}">
</form>
	<div class="pd20">
		<div class="common-title">
			<%--<span class="assist">信用标识：-</span>--%>
			<h2>企业隐私信息</h2>
		</div>
		<div class="table-outside-title">
			<i class="better-info-icon"></i> 部门评价
		</div>
		<div class="admin-department">
			纳税信用等级评定信息<span class="ml10">共<span class="light" id="gtjlhxx">0</span>条
			</span>
		</div>
		<div>
			<table id="taxCreditLevelTable" class="table-row table-row-color nowrap mb10"
				width="100%">
				<thead>
					<tr>
						<th>纳税人名称</th>
						<th>信用等级</th>
						<th>统一社会信用代码</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="table-outside-title">
			<i class="bad-info-icon"></i> 不良信息
		</div>
		<div class="admin-department">
			企业欠薪黑名单<span class="ml10">共<span class="light" id="gtjblxx">0</span>条
			</span>
		</div>
		<div>
			<table id="wageBlackListTable" class="table-row table-row-color nowrap mb10"
				width="100%">
				<thead>
					<tr>
						<th>企业名称</th>
						<th>工商注册号</th>
						<th>欠薪额度</th>
						<th>发生时间</th>
						<th>取消时间</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</body>
<script src="<c:url value='/js/lib/require.js'/> "></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script src="<c:url value='/js/credit/system/qy_privacy.js'/>"></script>
</html>