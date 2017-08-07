<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-06-15
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="hxForm" class="form-box mb10">
    <div class="query-criteria clearfix">
        <div class="mr24">
            <label>标题：</label><input id="messageTitle" class="w-219" name="messageTitle" type="text">
        </div>
        <div class="mt15">
            <div class="center">
                <input type="button" id="search" value="查询" class="btn mr20">
                <input type="reset" id="reset" value="重置" class="btn ">
            </div>
        </div>
    </div>
</form>

<div class="box-panel">
    <table id="contract-table" class="table-row nowrap" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>类型</th>
            <th>标题</th>
            <th>当事人</th>
            <th>处理时间</th>
            <th>反馈详情</th>
        </tr>
        </thead>
    </table>
</div>



<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value='/js/gateway/biz/reception/inter_feedback.js'/>"></script>