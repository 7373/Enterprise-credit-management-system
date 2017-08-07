<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/credit/credit.css"/>" />
</head>
<body>
	<form id="hx-form">
	<input type="hidden" value="${taskNO}" name="jobNO">
	<div class="iframe-wrap">
		<div class="form-panel">
			<div class="assist" >任务编码： ${taskNO} </div>
			<div class="title">协查申请</div>
			<div class="pd20">
				<div class="table-outside-title2 mb5">
					<span>录入对象</span>
					<button type="button" class="btn btn-xs btn-del-obj">删除</button>
					<button type="button" class="btn btn-xs btn-add-obj">添加</button>
				</div>
				<div>
					<table class="table-row nowrap mb10" id="table-obj" width="100%">
						<thead>
							<tr>
								<th width="5%">序号</th>
								<th width="5%">选择</th>
								<th>对象名称</th>
							</tr>
						</thead>
						<tbody id="tbody_obj">
						</tbody>
					</table>
				</div>
				<div class="table-outside-title2 mb5">
					<span>协查部门</span>
					<button type="button" class="btn btn-xs btn-del-dept">删除</button>
					<button type="button" class="btn btn-xs btn-add-dept">添加</button>
				</div>
				<div>
					<table class="table-row nowrap mb10" id="table-dep" width="100%">
						<thead>
							<tr>
								<th width="5%">序号</th>
								<th width="5%">选择</th>
								<th width="70%">部门名称</th>
								<th>是否发送工作提示</th>
							</tr>
						</thead>
						<tbody id="tbody_dept">
							
						</tbody>
					</table>
				</div>
				<div class="table-outside-title2 mb10 line-b">
					<span>协查部门</span>
				</div>
					<div class="form-list">
						<div class="form-item clearfix">
							<label class="item-name col-2"><font color="red">* </font>协查原因&nbsp;</label>
							<div class="col-9">
								<textarea rows="10" name="assistReason" class="form-textarea"></textarea>
							</div>
						</div>
						<div class="form-item clearfix">
							<div class="col-6">
								<label class="item-name col-4"><font color="red">* </font>联系人&nbsp;</label>
								<div class="col-4">
									<div class="ipt-box">
										<input type="text" class="ipt-txt clx" name="contactsName" value="">
									</div>
								</div>
							</div>
							<div class="col-6">
								<label class="item-name col-3"><font color="red">* </font>联系电话&nbsp;</label>
								<div class="col-7">
									<div class="ipt-box">
										<input type="text" class="ipt-txt clx" name="contactsTel" value="">
									</div>
								</div>
							</div>
						</div>
						<div class="form-item clearfix">
							<div class="col-6">
								<label class="item-name col-4"><font color="red">* </font>联系部门&nbsp;</label>
								<div class="col-8">
									<div class="ipt-box">
										<input type="hidden" class="ipt-txt clx" name="contactsDep" value="${session_sys_user.dept}">
										<input type="text" class="ipt-txt clx" value="${session_sys_user.deptName}" readonly>
									</div>
								</div>
							</div>
							<div class="col-6">
								<label class="item-name col-3">联系邮箱&nbsp;</label>
								<div class="col-7">
									<div class="ipt-box">
										<input type="text" class="ipt-txt clx" name="contactsMail" value="">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="mt15">
						<div class="center">
							<input type="submit" id="save" value="提交" class="btn mr20">
							<input type="reset" id="" value="重置" class="btn ">
						</div>
					</div>
			</div>
		</div>
	</div>
	</form>
	<script>
	    window._CONFIG = {
	        select_dept_url: '<c:url value="/credit/dept/enRadioTreeSelect"/>'
	    }
	</script>
	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/credit/system/union/union_apply.js"></script>
</body>
</html>