<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<title></title>
<link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>"
	type="image/x-icon" />
<link rel="stylesheet"
	href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
<link rel="stylesheet" href="<c:url value='/css/credit/credit.css'/>">
</head>
<body>
	<div class="iframe-wrap">
		<div class="iframe-header-bg"></div>
		<div class="form-panel">
			<div class="title">共享查询</div>
			<form id="hxForm" class="form-box mb10">
				<div class="form-list">
					<div class="form-item clearfix mr20">
						<div class="col-4">
							<label class="item-name col-4">信息分类：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt clx" name="infoType" value="">
								</div>
							</div>

						</div>
						<div class="col-4">
							<label class="item-name col-4">单位名称：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt clx" name="unitName" value="">
								</div>
							</div>

						</div>
						<div class="col-4">
							<label class="item-name col-4">信息标题：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt clx" name="infoTitle" value="">
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
		</div>
		<div class="box-panel">
			<table id="contract-table" class="table-row nowrap" width="100%">
				<thead>
					<tr>
						<th>序号</th>
						<th>单位名称</th>
						<th>信息标题</th>
						<th>信息分类</th>
						<th>期数</th>
						<th>查看权限</th>
						<th>信息详情</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<!-- 通用页面 -->
	<jsp:include page="../../credit/system/common/common.jsp" />
	<script src="<c:url value='/js/credit/system/gxxqsearch_list.js'/>"></script>
</body>
</html>
