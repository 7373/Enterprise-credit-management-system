<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<title>安监页面</title>
<link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon" />
<link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/> ">
<link rel="stylesheet" href="<c:url value='/css/credit/credit.css'/> ">
</head>
<body>
<div class="iframe-wrap">
<div class="form-panel">
<div class="title">生产安全事故信息</div>
    <form id="qryFormProduceAccidentList">
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
                    <input type="button" id="searchProduceAccidentList" value="检 索" class="btn btn-sm mr30">
                </div>
            </div>
        </div>
    </form>
    <div class="box-panel">
		<table id="produceAccident-table" class="table-row  mt5 nowrap" width="100%">
			<thead style="white-space: nowrap;">
				<tr>
					<th>序号</th>
					<th>事故名称</th>
					<th>发生日期</th>
					<th>伤亡情况(死亡人数)</th>
					<th>伤亡情况(伤亡人数)</th>
					<th>处理结果</th>
					<th>累计发生事故次数</th>
				</tr>
			</thead>
		</table>
	</div>
</div> 
<div class="form-panel">
<div class="title">查封、扣押等行政强制信息</div>
    <form id="qryFormAdminForceInfoList">
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
					<input type='hidden' name='importDept' value='${depCode }'/>
            </div>
            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" id="searchAdminForceInfoList" value="检 索" class="btn btn-sm mr30">
                </div>
            </div>
        </div>
    </form>
    <div class="box-panel">
		<table id="adminForceInfo-table" class="table-row  mt5 nowrap" width="100%">
			<thead style="white-space: nowrap;">
				<tr>
					<th>序号</th>
					<th>行政强制文书号</th>
					<th>行政强制决定日期</th>
					<th>查封扣押清单内容</th>
				</tr>
			</thead>
		</table>
	</div>
</div>
<div class="form-panel">
<div class="title">表彰奖励信息</div>
    <form id="qryFormCommendRewardInfoList">
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
					<input type='hidden' name='importDept' value='${depCode }'/>
            </div>
            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" id="searchCommendRewardInfoList" value="检 索" class="btn btn-sm mr30">
                </div>
            </div>
        </div>
    </form>
    <div class="box-panel">
		<table id="commendRewardInfo-table" class="table-row  mt5 nowrap" width="100%">
			<thead style="white-space: nowrap;">
				<tr>
					<th>序号</th>
					<th>表彰名称</th>
					<th>表彰等级</th>
					<th>表彰文件(号)</th>
					<th>表彰部门全称</th>
					<th>表彰时间</th>
					<th>累计表彰次数</th>
				</tr>
			</thead>
		</table>
	</div>
</div>
<div class="form-panel">
<div class="title">重大事故隐患信息</div>
    <form id="qryFormFirst">
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
					<input type='hidden' name='importDept' value='${depCode }'/>
            </div>
            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" id="searchFirst" value="检 索" class="btn btn-sm mr30">
                </div>
            </div>
        </div>
    </form>
    <div class="box-panel">
		<table id="accident-table" class="table-row  mt5 nowrap" width="100%">
			<thead style="white-space: nowrap;">
				<tr>
					<th>序号</th>
					<th>隐患具体信息</th>
					<th>整改期限</th>
					<th>整改完成情况</th>
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
		<table id="blackList-table" class="table-row  mt5 nowrap" width="100%">
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
	<div class="title">生产安全许可证</div>
    <form id="qryFormSafeProList">
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
					<input type='hidden' name='importDept' value='${depCode }'/>
            </div>
            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" id="searchSafeProList" value="检 索" class="btn btn-sm mr30">
                </div>
            </div>
        </div>
    </form>
    <div class="box-panel">
		<table id="SafePro-table" class="table-row  mt5 nowrap" width="100%">
			<thead style="white-space: nowrap;">
				<tr>
					<th>序号</th>
					<th>是否需要申请安全生产许可证</th>
					<th>许可证号码</th>
					<th>许可范围</th>
					<th>许可证有效期</th>
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
<script src="<c:url value='/js/credit/system/temp/tempSafety.js'/> "></script>
</html>
