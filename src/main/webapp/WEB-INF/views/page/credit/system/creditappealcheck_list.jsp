<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/credit/credit.css"/>"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
</head>
<body>
<div class="iframe-wrap">
    <div class="form-panel">
        <div class="title">异议申诉受理</div>
        <form id="hxForm" class="form-box">
            <div class="form-list">
            	 <div class="form-list">
                <div class="form-item clearfix mr20">
                	<div class="col-6 ">
                		<div class="ml130">
		                    <label class="item-name label-name col-3"><span
							class="long-label">发起日期&nbsp;</span></label>
							<div class="col-9">
								<div class="ipt-box col-8">
									<div class="ipt-box col-5">
										<input type="text" id="buildDateLeft" name="buildDateLeft"
											readonly="readonly" onclick="laydate()"
											class="ipt-txt laydate-icon clx ipt-input">
									</div>
									<span class="item-line col-2">到</span>
									<div class="ipt-box col-5">
										<input type="text" id="buildDateRight" name="buildDateRight"
											readonly="readonly" onclick="laydate()"
											class="ipt-txt laydate-icon clx ipt-input">
									</div>
								</div>
							</div>
	                    </div>
               	</div>
                
                    <div class="col-6">
                        <label class="item-name col-4">对象名称：</label>
                        <div class="col-4">
                            <div class="ipt-box">
                                <input type="text" class="ipt-txt clx" name="appealName" value="">
                            </div>
                        </div>

                    </div>
                    
                </div>
            </div>
                <div class="form-item clearfix mr20">
                    <div class="col-6">
                        <label class="item-name col-5">发起来源&nbsp;</label>
                        <div class="col-5">
                            <div class="ipt-box">
                            	<select  name="appealSource">
                            		<option value="2">系统内部</option>
                            		<option value="1">外部互联网门户</option>
                            	</select>
                            </div>
                        </div>
                    </div>
                    <div class="col-6">
                        <label class="item-name col-4">处理状态&nbsp;</label>
                        <div class="col-4">
                            <div class="ipt-box">
                               <select  name="endState">
                             		<option value="1" selected="selected">正常待处理</option>
                             		<option value="2">已处理</option>
		                        	<option value="3">超期处理</option>   
	                        	</select>                        
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <input type="hidden" class="ipt-txt" name="deptCode" value="${user.dept}">
            <div class="mt15">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="reset" id="" value="重置" class="btn ">
                </div>
            </div>
        </form>
        <div class="box-panel">
            <table id="hxTable" class="table-row nowrap" width="100%">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>操作</th>
                    <th>到期状态</th>
                    <th>申诉人/企业/机构名称</th>
                    <th>申诉机构</th>
                    <th>申诉详情</th>
                    <th>申诉附件</th>
                    <th>发起来源</th>
                    <th>处理人</th>
                    <th>处理时间</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<!-- 通用页面 -->
<jsp:include page="../../credit/system/common/common.jsp"/>
<script src="<c:url value='/js/credit/system/creditappealcheck_list.js'/>"></script>
</body>
</html>