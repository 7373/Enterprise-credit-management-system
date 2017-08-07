<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<title></title>
<link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon" />
<link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/> ">
<link rel="stylesheet" href="<c:url value='/css/credit/credit.css'/> ">
</head>
<body>
<div class="iframe-wrap">
<div class="form-panel">
<div class="title">上传情况查询</div>
    <form id="hxForm">
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
					<input type='hidden' name='importDept' value='${deptCode}'/>
            </div>
            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" id="search" value="检 索" class="btn btn-sm mr30">
                </div>
            </div>
        </div>
    </form>
    <div class="box-panel">
		<table id="hxTable" class="table-row  mt5 nowrap" width="100%">
			<thead style="white-space: nowrap;">
				<tr>
					<th>序号</th>
					<th>操作</th>
					<th>部门</th>
					<th>文件标题</th>
					<th>上传时间</th>
					<th>上传操作人</th>
					<th>删除操作人</th>
				</tr>
			</thead>
		</table>
	</div>
</div> 
</div>
</body>
<!-- 通用页面 -->
<jsp:include page="./common/common.jsp" />
<script src="<c:url value='/js/credit/system/uploadhandle_list.js'/> "></script>
</html>
