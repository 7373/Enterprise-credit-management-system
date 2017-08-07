<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-06-16
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.select1{
	width: 205px;
	height: 29px;
	padding-right: 14px;
	border: 1px solid #ccc;
	
}

.place1{
	width: 200px;
	display: inline-block;
	position: absolute;
}

</style>
<form id="hxForm" class="form-box mb10">
    <div class="query-criteria clearfix">
        <div class="fl mr24">
            <label class="w-98 lebelcss">当事人名称：</label><input id="w-name" class="w-219" name="name" type="text" value="${name}">
        </div>
        <div class=" mr24">
            <label class="w-98 lebelcss">公示类型：</label>
	                <select id="searchType" name="searchType" class="select1 w-219">
	                    <option value="xk" ${type=='xk'?'selected':''}>许可</option>
	                    <option value="cf" ${type=='cf'?'selected':''}>处罚</option>
	                </select>
            
        </div>
        <div class="fl mr24" width="50%">
            <label class="w-98 lebelcss">决定日期：</label>
            <input type="text" id="startDate" name="startDate" readonly="readonly" onclick="laydate()" class="w-98 ipt-txt laydate-icon clx ipt-input">
            到
            <input type="text" id="endDate" name="endDate" readonly="readonly" onclick="laydate()" class="w-98 ipt-txt laydate-icon clx ipt-input">
        </div>
       <div class="mr24" width="50%">
			<label class="w-98 lebelcss" >部门：</label>
			<div class="place1">
				<div class="ipt-box">
					<input type="hidden" name="orgCode" id="orgCode">
					<input type="text" readonly class="ipt- txt clx w-219" id="orgName">
					<span class="add-icon" id="selectDept"><i style="position: relative;top: -12px;"></i></span>
				</div>
			</div>
		</div>
		<input type="hidden" id="type"  value="${type}">
		<input type="hidden" id="uid" name="uid" value="${uid}">
        <div class="mt15">
            <div class="center">
                <input type="button" id="search" value="查询" class="w-90 fs16 btn-sub btn-bg-bule">
                <input type="reset" id="reset" value="重置" class="w-90 fs16 btn-sub btn-bg-bule ">
            </div>
        </div>
    </div>
</form>
<div class="box-panel">
    <table id="publish-table" class="table-row nowrap" width="100%">
        <thead>
        <tr>
            <th>公示类型</th>
            <th>部门</th>
            <th>当事人名称</th>
            <th>标题</th>
            <th>决定日期</th>
        </tr>
        </thead>
    </table>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
 <script src="<c:url value='/js/gateway/biz/reception/publish_platform_double.js'/>"></script>
