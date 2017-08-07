<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title></title>
<link rel="stylesheet"
	href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/credit/credit.css"/>" />
</head>
<body>
	<form id="hxForm">
		<input type="hidden" name="sfzhm"
			value="${data.sfzhm}"> 
	</form>
	<div class="pd20">
		<div class="common-title">
<!-- 			<span class="assist">信用标识：-</span> -->
			<h2>个人信用信息</h2>
		</div>
		<div class="table-outside-title">
			<i class="basic-info-icon"></i> 个人基本信息
		</div>
		<table id="" class="table-row nowrap mb10" width="100%">
			<tr>
				<td class="bg-grey light-black right">姓名</td>
				<td>${data.xm}</td>
				<td class="bg-grey light-black right">证件类型</td>
				<td>-</td>
				<td class="bg-grey light-black right">证件号</td>
				<td>${data.sfzhm}</td>
			</tr>
			<tr>
				<td class="bg-grey light-black right">婚姻状况</td>
				<td>-</td>
				<td class="bg-grey light-black right">现居地</td>
				<td>-</td>
				<td class="bg-grey light-black right">性别</td>
				<td>${data.sex}</td>
			</tr>
			<tr>
				<td class="bg-grey light-black right">是否就业</td>
				<td>${data.ryzt=='0'?'是':'否'}</td>
				<td class="bg-grey light-black right">是否低保人员</td>
				<td>-</td>
				<td class="bg-grey light-black right">有无地产</td>
				<td>-</td>
			</tr>
			<tr>
				<td class="bg-grey light-black right">有无车辆</td>
				<td>-</td>
				<td class="bg-grey light-black right">有无房产</td>
				<td>-</td>
				<td class="bg-grey light-black right"></td>
				<td></td>
			</tr>

		</table>
		<input type='hidden' id='idCard' value='${data.sfzhm}'>
		<!--     <div class="table-outside-title"> -->
		<!--         <i class="licensing-qual-icon"></i> -->
		<!--         社会行为信息 -->
		<!--     </div> -->
		<!--     <div class="admin-department">人社局<span class="ml10">共<span class="light" id="rsjxx">0</span>条</span></div> -->
		<!--    	<div id="ldxx"> -->
		<!--         <table id="ldTeble" class="table-row table-row-color nowrap mb10" width="100%"> -->
		<!--             <thead> -->
		<!--             <tr> -->
		<!--                 <th>社会保障号</th> -->
		<!--                 <th>参保单位名称</th> -->
		<!--                 <th>是否参加养老保险</th> -->
		<!--                 <th>是否参加医疗保险</th> -->
		<!--                 <th>是否参加失业保险</th> -->
		<!--                 <th>是否参加工伤保险</th> -->
		<!--                 <th>是否参加生育保险</th> -->
		<!--                 <th>是否按月领取基本养老金</th> -->
		<!--             </tr> -->
		<!--             </thead> -->
		<!--         </table> -->
		<!--     </div> -->
		<!--     <div class="table-outside-title"> -->
		<!--         <i class="better-info-icon"></i> -->

		<!--         良好信息 -->
		<!--     </div> -->
		<!--     <div class="admin-department">国土局<span class="ml10">共<span class="light">0</span>条</span></div> -->
		<!--     <div> -->
		<!--         <table id="" class="table-row table-row-color nowrap mb10" width="100%"> -->
		<!--             <thead> -->
		<!--             <tr> -->
		<!--                 <th>序号</th> -->
		<!--                 <th>信息类型</th> -->
		<!--                 <th>当事人名称</th> -->
		<!--                 <th>社会信用代码/工商注册号</th> -->
		<!--                 <th>列入事由</th> -->
		<!--                 <th>发生日期</th> -->
		<!--                 <th>列入名单日期</th> -->
		<!--             </tr> -->
		<!--             </thead> -->
		<!--             <tbody> -->
		<!--             	<td colspan="7">无</td> -->
		<!--             </tbody> -->
		<!--         </table> -->
		<!--     </div> -->
		<!--     <div class="admin-department">安监局<span class="ml10">共<span class="light">0</span>条</span></div> -->
		<!--     <div> -->
		<!--         <table id="" class="table-row table-row-color nowrap mb10" width="100%"> -->
		<!--             <thead> -->
		<!--             <tr> -->
		<!--                 <th>序号</th> -->
		<!--                 <th>表彰名称</th> -->
		<!--                 <th>表彰等级</th> -->
		<!--                 <th>表彰文件（号）</th> -->
		<!--                 <th>信息类型</th> -->
		<!--                 <th>表彰时间</th> -->
		<!--                 <th>累计表彰次数</th> -->
		<!--             </tr> -->
		<!--             </thead> -->
		<!--             <tbody> -->
		<!--             	<td colspan="7">无</td> -->
		<!--             </tbody> -->
		<!--         </table> -->
		<!--     </div> -->
		<!--     <div class="table-outside-title"> -->
		<!--         <i class="bad-info-icon"></i> -->
		<!--         不良信息 -->
		<!--     </div> -->
		<!--     <div class="admin-department">安监局<span class="ml10">共<span class="light" id="blackCount">0</span>条</span></div> -->
		<!--     <div id="blackxx"> -->
		<!--         <table id="ajBlackTeble" class="table-row table-row-color nowrap mb10" width="100%"> -->
		<!--             <thead> -->
		<!--             <tr> -->
		<!--                 <th>序号</th> -->
		<!--                 <th>当事人名称</th> -->
		<!--                 <th>证件号</th> -->
		<!--                 <th>列入事由</th> -->
		<!--                 <th>发生日期</th> -->
		<!--                 <th>列入名单日期</th> -->
		<!--             </tr> -->
		<!--             </thead> -->
		<!--         </table> -->
		<!--     </div> -->
		<!--     <div class="table-outside-title mb10"> -->
		<!--         <i class="social-behaviour-icon"></i> -->
		<!--         社会行为信息 -->
		<!--     </div> -->

		<div class="table-outside-title">
			<i class="correlation-registration-icon"></i> 关联记录
		</div>
		<div class="admin-department">
			企业关联信息<span class="ml10">共<span class="light" id="glCount">0</span>条
			</span>
		</div>
		<div>
			<table id="hxTeble" class="table-row table-row-color nowrap mb10"
				width="100%">
				<thead>
					<tr>
						<th>序号</th>
						<th>企业名称</th>
						<th>统一信用代码/注册号</th>
						<th>企业状态</th>
						<th>关系</th>
					</tr>
				</thead>
			</table>
		</div>

		<!--  -->
		<div class="table-outside-title">
			<i class="correlation-registration-icon"></i> 资质许可信息
		</div>
		<div class="admin-department">
			人社局 县级核发的专业技术职称证书信息 <span class="ml10">共<span class="light"
				id="count">0</span>条
			</span>
		</div>
		<div>
			<table id="zyjszcTable" class="table-row table-row-color nowrap mb10"
				width="100%">
				<thead>
					<tr>
						<th>姓名</th>
						<th>身份证号码</th>
						<th>证件类型</th>
						<th>证件号码</th>
						<th>证书编号</th>
						<th>专业技术职称种类</th>
						<th>职称级别</th>
						<th>授予时间</th>
						<th>评定组织</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<!-- 通用页面 -->
	<jsp:include page="../../credit/system/common/common.jsp" />
	<script src="<c:url value='/js/credit/system/grxq.js'/>"></script>
</body>
</html>