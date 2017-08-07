<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<title>林业局页面</title>
<link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon" />
<link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/> ">
<link rel="stylesheet" href="<c:url value='/css/credit/credit.css'/> ">
</head>
<body>
<div class="iframe-wrap">
<div class="form-panel">
<div class="title">林木种子生产经营许可</div>
    <form id="qryFormTreeseed">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
						<label class="item-name label-name col-3"><span
							class="long-label">上传日期</span></label>
						<div class="col-9">
							<div class="ipt-box col-12">
								<div class="ipt-box col-5">
									<input type="text" readonly="readonly" onclick="laydate()"
										id="importTimeLeft" name="importTimeLeft"
										class="ipt-txt laydate-icon clx ipt-input">
								</div>
								<span class="item-line col-2">到</span>
								<div class="ipt-box col-5">
									<input type="text" readonly="readonly" onclick="laydate()"
										id="importTimeRight" name="importTimeRight"
										class="ipt-txt laydate-icon clx ipt-input">
								</div>
							</div>
						</div>
					</div>
					<input type='hidden' name='importDept' value='${depCode }'/>
            </div>
            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" id="searchTreeseed" value="检 索" class="btn btn-sm">
                </div>
            </div>
        </div>
    </form>
    <div class="box-panel">
		<table id="treeseed-table" class="table-row  mt5 nowrap" width="100%">
			<thead style="white-space: nowrap;">
				<tr>
					<th>序号</th>
					<th>企业名称（自然人姓名）</th>
					<th>法人社会信用代码/组织机构代码/工商注册号或工商登记号（自然人身份证号）</th>
					<th>许可证编号</th>
					<th>发证日期</th>
					<th>有效期限</th>
					<th>生产地点</th>
					<th>生产种类</th>
					<th>上传时间</th>
					<th>操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	
	<div class="form-panel">
	<div class="title">红名单</div>
    <form id="qryFormRedList">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
						<label class="item-name label-name col-3"><span
							class="long-label">上传日期</span></label>
						<div class="col-9">
							<div class="ipt-box col-12">
								<div class="ipt-box col-5">
									<input type="text" readonly="readonly" onclick="laydate()"
										name="importTimeLeft"
										class="ipt-txt laydate-icon clx ipt-input">
								</div>
								<span class="item-line col-2">到</span>
								<div class="ipt-box col-5">
									<input type="text" readonly="readonly" onclick="laydate()"
										name="importTimeRight"
										class="ipt-txt laydate-icon clx ipt-input">
								</div>
							</div>
						</div>
					</div>
					<input type="hidden" name="listType" value='r'/>
					<input type='hidden' name='importDept' value='${depCode }'/>
            </div>
            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" id="searchRedList" value="检 索" class="btn btn-sm mr30">
                </div>
            </div>
        </div>
    </form>
    <div class="box-panel">
		<table id="redList-table" class="table-row  mt5 nowrap" width="100%">
			<thead style="white-space: nowrap;">
				<tr>
					<th>序号</th>
					<th>当事人姓名/单位名称</th>
					<th>身份证号/社会信用代码/组织机构代码/工商注册号</th>
					<th>列入红/黑名单事由</th>
					<th>发生时间</th>
					<th>列入名单时间</th>
					<th>上传时间</th>
					<th>操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	
	<div class="form-panel">
	<div class="title">黑名单</div>
    <form id="qryFormBlackList">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
						<label class="item-name label-name col-3"><span
							class="long-label">上传日期</span></label>
						<div class="col-9">
							<div class="ipt-box col-12">
								<div class="ipt-box col-5">
									<input type="text" readonly="readonly" onclick="laydate()"
										name="importTimeLeft"
										class="ipt-txt laydate-icon clx ipt-input">
								</div>
								<span class="item-line col-2">到</span>
								<div class="ipt-box col-5">
									<input type="text" readonly="readonly" onclick="laydate()"
										name="importTimeRight"
										class="ipt-txt laydate-icon clx ipt-input">
								</div>
							</div>
						</div>
					</div>
					<input type="hidden" name="listType" value='b'/>
					<input type='hidden' name='importDept' value='${depCode }'/>
            </div>
            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" id="searchBlackList" value="检 索" class="btn btn-sm mr30">
                </div>
            </div>
        </div>
    </form>
    <div class="box-panel">
		<table id="blackList-table" class="table-row nowrap" width="100%">
			<thead style="white-space: nowrap;">
				<tr>
					<th>序号</th>
					<th>当事人姓名/单位名称</th>
					<th>身份证号/社会信用代码/组织机构代码/工商注册号</th>
					<th>列入红/黑名单事由</th>
					<th>发生时间</th>
					<th>列入名单时间</th>
					<th>上传时间</th>
					<th>操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	</div>
</body>
<!-- 通用页面 -->
<jsp:include page="../common/common.jsp" />
<script src="<c:url value='/js/credit/system/temp/tempAgriculture.js'/> "></script>
</html>
