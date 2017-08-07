<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<input type="hidden" name="enterprise_id"
			value="${data.enterprise_id}"> <input type="hidden"
			name="importDept" value="ZF330682015">
	</form>
	<form id="redForm">
		<input type="hidden" name="enterprise_id"
			value="${data.enterprise_id}"> <input type="hidden"
			name="importDept" value="ZF330682014"> <input type="hidden"
			name="listType" value="r"> <input type="hidden"
			name="partyType" value="q">
	</form>
	<form id="blackForm">
		<input type="hidden" name="enterprise_id"
			value="${data.enterprise_id}"> <input type="hidden"
			name="importDept" value="ZF330682014"> <input type="hidden"
			name="listType" value="b"> <input type="hidden"
			name="partyType" value="q">
	</form>
	<div class="pd20">
		<div class="common-title">
<!-- 			<span class="assist">信用标识：-</span> -->
			<h2>企业信用信息</h2>
			<input id="privacy" class="btn" uid="${param.uid}" value="隐私信息"
				type="button" />
		</div>
		<div class="table-outside-title">
			<i class="basic-info-icon"></i> 基本信息
		</div>
		<table id="" class="table-row nowrap mb10" width="100%">
			<tr>
				<td class="bg-grey light-black right">企业名称</td>
				<td>${data.qymc}</td>
				<td class="bg-grey light-black right">统一社会信用代码/注册号</td>
				<td>${data.gszch}</td>
			</tr>
			<tr>
				<td class="bg-grey light-black right">法定代表人</td>
				<td>${data.frdbxm}</td>
				<td class="bg-grey light-black right">注册资本（万元）</td>
				<td>-</td>
			</tr>
			<tr>
				<td class="bg-grey light-black right">住所（经营场所）</td>
				<td>-</td>
				<td class="bg-grey light-black right">成立日期</td>
				<td><fmt:formatDate value="${data.hzrq}" pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<td class="bg-grey light-black right">企业状态</td>
				<td>${data.qyzt== null?'存续':'吊销'}</td>
				<td class="bg-grey light-black right">行业</td>
				<td>-</td>
			</tr>
			<!-- <tr>
				<td class="bg-grey light-black right">经营范围</td>
				<td colspan="3">-</td>
			</tr> -->
		</table>
		<div class="table-outside-title">
			<i class="licensing-qual-icon"></i> 许可资质信息
		</div>



		<div class="admin-department">
			安监局<span class="ml10">共<span class="light" id="scxk">0</span>条
			</span>
			<div>
				<table id="qySafeProduceLicenceTable"
					class="table-row table-row-color nowrap mb10" width="100%">
					<thead>
						<tr>
							<th>企业名称</th>
							<th>社会信用代码/组织机构代码/工商注册号</th>
							<th>是否需要申请安全生产许可证</th>
							<th>许可证号码</th>
							<th>许可范围</th>
							<th>许可证有效期</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>



		<div class="admin-department xfaq">
			公安局 消防安全许可信息（建设工程消防设计审核、建设工程消防验收）<span class="ml10">共<span
				class="light" id="xfaqxx">0</span>条
			</span>
			<div>
				<table id="xfaqTable" class="table-row table-row-color nowrap mb10"
					width="100%">
					<thead>
						<tr>
							<th>项目名称</th>
							<th>单位社会信用代码/工商注册号/组织机构代码</th>
							<th>单位名称</th>
							<th>审批类型</th>
							<th>审批文号</th>
							<th>审批时间</th>


						</tr>
					</thead>
				</table>
			</div>
		</div>



		<div class="admin-department lmzzsc">
			林业局（农业局） 林木种子生产经营种类许可 <span class="ml10">共<span class="light"
				id="lmzzscxx">0</span>条
			</span>

			<div>
				<table id="lmzzscTable"
					class="table-row table-row-color nowrap mb10" width="100%">
					<thead>
						<tr>
							<th>企业名称（自然人姓名）</th>
							<th>法人社会信用代码/组织机构代码/工商注册号或工商登记号（自然人身份证号）</th>
							<th>许可证编号</th>
							<th>发证日期</th>
							<th>有效期限</th>
							<th>生产地点</th>
							<th>生产种类</th>

						</tr>
					</thead>
				</table>
			</div>
		</div>






		<div class="admin-department aqsc">
			安监局 安全生产许可证 <span class="ml10">共<span class="light"
				id="aqscxx">0</span>条
			</span>

			<div>
				<table id="aqscTable" class="table-row table-row-color nowrap mb10"
					width="100%">
					<thead>
						<tr>
							<th>企业名称</th>
							<th>社会信用代码/组织机构代码/工商注册号</th>
							<th>是否需要申请安全生产许可证</th>
							<th>许可证号码</th>
							<th>许可范围</th>
							<th>许可证有效期</th>

						</tr>
					</thead>
				</table>
			</div>
		</div>















		<div class="table-outside-title">
			<i class="better-info-icon"></i> 良好信息
		</div>
		<div class="admin-department wgjl">
			文广新局 奖励信息 <span class="ml10">共<span class="light" id="wgjlxx">0</span>条
			</span>

			<div>
				<table id="wgjlxxTable"
					class="table-row table-row-color nowrap mb10" width="100%">
					<thead>
						<tr>
							<th>获奖单位（场所）名称</th>
							<th>单位（场所）类型</th>
							<th>地址</th>
							<th>所在区域</th>
							<th>奖励名称</th>
							<th>奖励级别</th>
							<th>奖励时间</th>
							<th>颁奖单位</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
		<div class="admin-department sczm">
			市场监管局 省知名商号信息 <span class="ml10">共<span class="light"
				id="sczmxx">0</span>条
			</span>

			<div>
				<table id="sczmTable" class="table-row table-row-color nowrap mb10"
					width="100%">
					<thead>
						<tr>
							<th>企业名称</th>
							<th>社会信用代码/工商注册号</th>
							<th>字号</th>
							<th>认定时间</th>
							<th>有效期</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>


		<div class="admin-department sbcp">
			市场监管局 驰名商标信息、省著名商标信息、省名牌产品信息<span class="ml10">共<span
				class="light" id="sbcpxx">0</span>条
			</span>

			<div>
				<table id="sbcpTable" class="table-row table-row-color nowrap mb10"
					width="100%">
					<thead>
						<tr>
							<th>企业名称</th>
							<th>社会信用代码/工商注册号</th>
							<th>商标注册号</th>
							<th>认定称号</th>

						</tr>
					</thead>
				</table>
			</div>
		</div>

		<!--  -->
		<div class="admin-department ccbhg">
			市场监管局 产品质量监督抽查不合格记录信息 <span class="ml10">共<span class="light"
				id="ccbhgxx">0</span>条
			</span>

			<div>
				<table id="ccbhgTable" class="table-row table-row-color nowrap mb10"
					width="100%">
					<thead>
						<tr>
							<th>企业名称</th>
							<th>社会信用代码/工商注册号</th>
							<th>产品名称</th>
							<th>商标</th>
							<th>规格型号</th>
							<th>生产日期/批号</th>
							<th>产品分类</th>
							<th>承检机构</th>
							<th>抽查日期</th>
							<th>抽查级别</th>
							<th>抽查结果</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>

		<!--  -->


		<div class="admin-department djpd">
			环保局 环境等级评定信息 <span class="ml10">共<span class="light"
				id="djpdxx">0</span>条
			</span>

			<div>
				<table id="djpdTable" class="table-row table-row-color nowrap mb10"
					width="100%">
					<thead>
						<tr>
							<th>企业名称</th>
							<th>社会信用代码/工商注册号</th>
							<th>环境评定等级</th>
							<th>文件号</th>

						</tr>
					</thead>
				</table>
			</div>
		</div>

		<!--  -->


		<div class="admin-department djpg">
			民政局 社会组织等级评估信息 <span class="ml10">共<span class="light"
				id="djpgxx">0</span>条
			</span>

			<div>
				<table id="djpgTable" class="table-row table-row-color nowrap mb10"
					width="100%">
					<thead>
						<tr>
							<th>社会组织评估等级</th>
							<th>社会信用代码/组织机构代码</th>
							<th>评估等级有效期</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>

		<!--  -->
		<div class="table-outside-title">
			<i class="bad-info-icon"></i> 不良信息
		</div>
		<!-- 		<div class="admin-department"> -->
		<!-- 			国土局<span class="ml10">共<span class="light" id="gtjblxx">0</span>条 -->
		<!-- 			</span> -->
		<!-- 		</div> -->
		<!-- 		<div> -->
		<!-- 			<table id="qyGtjBlackListTable" class="table-row table-row-color nowrap mb10" -->
		<!-- 				width="100%"> -->
		<!-- 				<thead> -->
		<!-- 					<tr> -->
		<!-- 						<th>列入事由</th> -->
		<!-- 						<th>发生日期</th> -->
		<!-- 						<th>列入名单日期</th> -->
		<!-- 					</tr> -->
		<!-- 				</thead> -->
		<!-- 			</table> -->
		<!-- 		</div> -->
		<!-- 
		<div class="table-outside-title mb10">
			<i class="social-behaviour-icon"></i> 社会行为信息
		</div>
	
		<div class="table-outside-title">
			<i class="correlation-registration-icon"></i> 关联记录
		</div> 
	-->



		<div class="admin-department qyqs">
			财政（地税）局 企业（个体工商户）欠税信息 <span class="ml10">共<span class="light"
				id="qyqsxx">0</span>条
			</span>

			<div>
				<table id="qyqsTable" class="table-row table-row-color nowrap mb10"
					width="100%">
					<thead>
						<tr>
							<th>纳税人名称</th>
							<th>统一社会信用代码</th>
							<th>法定代表人（负责人或业主姓名〕</th>
							<th>注册地址</th>
							<th>欠税税种</th>
							<th>欠税金额</th>

						</tr>
					</thead>
				</table>
			</div>
		</div>





		<div class="admin-department zdhz">
			公安局 重大火灾隐患信息 <span class="ml10">共<span class="light"
				id="zdhzxx">0</span>条
			</span>

			<div>
				<table id="zdhzTable" class="table-row table-row-color nowrap mb10"
					width="100%">
					<thead>
						<tr>
							<th>单位名称</th>
							<th>单位社会信用代码/工商注册号/组织机构代码</th>
							<th>存在重大火灾隐患内容</th>
							<th>认定时间</th>
							<th>认定依据</th>
							<th>销案时间</th>

						</tr>
					</thead>
				</table>
			</div>
		</div>






		<div class="admin-department xzqz">
			公安局 行政强制信息 <span class="ml10">共<span class="light" id="xzqzxx">0</span>条
			</span>

			<div>
				<table id="xzqzTable" class="table-row table-row-color nowrap mb10"
					width="100%">
					<thead>
						<tr>
							<th>单位名称</th>
							<th>单位社会信用代码/工商注册号/组织机构代码</th>
							<th>临时查封时间</th>
							<th>解除临时查封时间</th>
							<th>临时查封/解除临时查封文号</th>
							<th>强制执行文号</th>
							<th>强制执行内容</th>
							<th>强制执行时间</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>




















	</div>
</body>
<script src="<c:url value='/js/lib/require.js'/> "></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script src="<c:url value='/js/credit/system/qyxq.js'/>"></script>
</html>