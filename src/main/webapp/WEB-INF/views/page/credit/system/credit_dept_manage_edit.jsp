<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title></title>
    <link rel="stylesheet" href="<c:url value='/css/credit/credit.css'/>">

</head>
<body class="pd10">
<form id="hxForm">
    <div class="clearfix">
        <h3 class="h3-title center"></h3>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
            <tr>
                <td class="bg-gray right" width="15%"><span class="light"> *</span>上级部门名称：</td>
                <td width="30%">
                    <div class="ipt-box pd0">
                        <input type="hidden" name="depCode" value="${ndDept.depCode}"/>
                        <c:if test="${pid != null && pid !=''}">
                        	<input type="radio" name="depPcode" checked="checked" value="${pid}">添加同级部门
                        </c:if>
                        <c:if test="${pid != null && pid ==''}">
                         <input type="radio" name="depPcode" checked="checked" value="${sid}">添加子部门
                        </c:if>   
                        <c:if test="${pid == null}">
                          ${pName}
                        </c:if> 
                    </div>
                </td>

            </tr>
            <tr>
                <td class="bg-gray right" width="15%"><span class="light"> *</span>部门名称：</td>
                <td>
                    <div class="ipt-box pd0">
                    <br/>
                        <input type="text" name="depName" class="ipt-txt" placeholder="请输入部门名称"
                               value="${ndDept.depName}">
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="15%">备注：</td>
                <td>
                    <div class="ipt-box pd0">
                    	<br/>
                        <input type="text" name="depRemark" class="ipt-txt" placeholder="请输入备注"
                               value="${ndDept.depRemark}">
                    </div>
                </td>
            </tr>
        </table>
        <p class="center mt10"><input type="button" id="save" class="btn mr20" value="保 存"/><input type="button" class="btn" value="取 消" id="cancel"/></p>
    </div>
</form>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/credit/system/credit_dept_manage_edit.js"></script>
</body>
</html>
