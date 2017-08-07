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
			<div class="title">企业红名单</div>

			<form id="qyRedBlackForm" class="form-box mb10">
				<div class="form-list">
					<div class="form-item clearfix mr20">
						<div class="form-item clearfix">
							<div class="col-6">
							<label class="item-name col-4">企业名称：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt clx" name="partyName" value="">
								</div>
							</div>

						</div>
						<div class="col-6">
							<label class="item-name col-4">统一社会信用代码/注册号：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt clx" name="unicode"
										value="">
								</div>
							</div>
						</div>
						</div>

						
						<div class="col-6">
							<label class="item-name col-4">数据来源：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt clx" name="importDept"
										value="">
								</div>
							</div>

						</div>

					</div>
				</div>
				<input type="hidden" name="listType" value="r">
				<input type="hidden" name="partyType" value="q">
				<div class="mt15">
					<div class="center">
						<input type="button" id="qySearch" value="查看" class="btn mr20">
						<input type="button" id="qyReset" value="重置" class="btn ">
					</div>
				</div>
			</form>
		
		<div class="box-panel">
			<table id="qyRedBlackTable" class="table-row nowrap" width="100%">
				<thead style="white-space:nowrap;">
					<tr>
						<th>序号</th>
						<th>企业名称</th>
						<th>统一社会信用代码/注册号</th>
						<th>数据来源</th>
						<th>列入事由</th>
						<th>发生日期</th>
						<th>列入名单日期</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
	<!-- 个人 -->
	<div class="iframe-wrap">
		<div class="iframe-header-bg"></div>
		<div class="form-panel">
			<div class="title">个人红名单</div>
			<form id="grRedBlackForm" class="form-box mb10">
				<div class="form-list">
					<div class="form-item clearfix mr20">
						<div class="form-item clearfix">
							<div class="col-6">
							<label class="item-name col-4">姓名：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt clx" name="partyName" value="">
								</div>
							</div>

							</div>
							<div class="col-6">
								<label class="item-name col-4">身份证号：</label>
								<div class="col-5">
									<div class="ipt-box">
										<input type="text" class="ipt-txt clx" name="unicode" value="">
									</div>
								</div>
	
							</div>
						</div>

						<div class="col-6">
							<label class="item-name col-4">数据来源：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt clx" name="importDept"
										value="">
								</div>
							</div>

						</div>
					</div>
				</div>
				<input type="hidden" name="listType" value="r">
				<input type="hidden" name="partyType" value="g">
				<div class="mt15">
					<div class="center">
						<input type="button" id="grSearch" value="查询" class="btn mr20">
						<input type="button" id="grReset" value="重置" class="btn ">
					</div>
				</div>
			</form>
		
		<div class="box-panel">
			<table id="grRedBlackTable" class="table-row nowrap" width="100%">
				<thead style="white-space:nowrap;">
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>身份证号</th>
						<th>数据来源</th>
						<th>列入事由</th>
						<th>发生日期</th>
						<th>列入名单日期</th>
					</tr>
				</thead>
			</table>
		</div>
		</div>
	</div>
	<!-- 通用页面 -->
	<jsp:include page="../../credit/system/common/common.jsp" />
	<script type="text/javascript"
		src="<c:url value='/js/lib/jquery/jquery-1.12.3.min.js'/> "></script>
	<script src="<c:url value='/js/credit/system/qyredblack_list.js'/>"></script>
	<script src="<c:url value='/js/credit/system/grredblack_list.js'/>"></script>
</body>
</html>
