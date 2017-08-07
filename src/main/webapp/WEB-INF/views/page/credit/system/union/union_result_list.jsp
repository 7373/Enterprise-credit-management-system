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
<link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon" />
<link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/credit/credit.css"/>" />
</head>
<body>
	<div class="iframe-wrap">
		<div class="form-panel">
			<div class="title">协查结果查看</div>
			<form id="hxForm" class="form-box mb10">
			<input type="hidden" name="contactsDep" value="${session_sys_user.dept}">
				<div class="form-list">
					<div class="form-item clearfix mr20">
						<div class="col-3">
							<label class="item-name col-4">任务编码：</label>
							<div class="col-5">
								<div class="ipt-box">
									<input type="text" class="ipt-txt clx" name="jobNO" >
								</div>
							</div>
						</div>
						<div class="col-3">
							<label class="item-name col-4">处理状态：</label>
							<div class="col-5">
								<div class="ipt-box">
									<select name="handleStatue">
										<option value="0" selected>待处理</option>
										<option value="1">已处理</option>
									</select>
								</div>
							</div>
						</div>
						<div class="col-6">
							<label class="item-name col-4">发起日期：</label>
							<div class="col-5">
								<div class="ipt-box col-575">
									<input type="text" class="ipt-txt clx" name="createTimeStart" onclick="laydate();">
								</div>
								<span class="col-05 item-line">-</span>
								<div class="ipt-box col-575">
									<input type="text" class="ipt-txt clx" name="createTimeEnd" onclick="laydate();">
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
			<table id="hx-table" class="table-row nowrap" width="100%">
				<thead>
					<tr>
						<th>序号</th>
						<th>附件</th>
						<th>协查反馈</th>
						<th>任务编码</th>
						<th>协查原因</th>
						<th>处理状态</th>
						<th>发起部门</th>
						<th>发起日期</th>
						<th>接收部门</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>

	<script>
	    window._CONFIG = {
	        select_dept_url: '<c:url value="/credit/department/enRadioTreeSelect"/>'
	    }
	</script>	
	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="<c:url value='/js/credit/system/union/union_result_list.js'/>"></script>
</body>
</html>
