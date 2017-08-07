<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信用临安</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/admin.css"/>"/>
</head>
<body class="pd20">
<div>
    <table class="table-horizontal">
        <tr>
            <td class="bg-gray right" width="80">真实姓名:</td>
            <td>${ndrcCreditConsult.realName }</td>
            <td class="bg-gray right" width="80">职业:</td>
            <td>${ndrcCreditConsult.profession }</td>
        </tr>
        <tr>
            <td class="bg-gray right" >联系电话:</td>
            <td>${ndrcCreditConsult.tel }</td>
            <td class="bg-gray right" >联系邮箱:</td>
            <td>${ndrcCreditConsult.mail }</td>
        </tr>
        <tr>
            <td class="bg-gray right" >留言类型:</td>
            <td>${ndrcCreditConsult.messageType }</td>
            <td class="bg-gray right" >留言时间:</td>
            <td><fmt:formatDate value="${ndrcCreditConsult.createTime }" pattern="yyyy-MM-dd"/></td>
        </tr>
        <tr>
            <td class="bg-gray right" >留言标题:</td>
            <td colspan="3">${ndrcCreditConsult.messageTitle }</td>
        </tr>
        <tr>
            <td class="bg-gray right h175">留言内容:</td>
            <td colspan="3">${ndrcCreditConsult.messageContent }</td>
        </tr>
        <tr>
            <td class="bg-gray right h175">回复内容:</td>
            <td colspan="3">${ndrcCreditConsult.messageReply }</td>
        </tr>
    </table>
	<input type="hidden" id="uid" name="uid" value="${ndrcCreditConsult.uid }" >
    <div class="mt10">
        <div class="center">
<!--             <input type="button" id="replay" value="回复" class="btn mr20"> -->
            <input type="reset" id="cancel" value="返回" class="btn">
        </div>
    </div>
</div>
<jsp:include page="../../system/common/common.jsp"/>
<script src="<c:url value='/js/gateway/biz/backstage/credit_consult_view.js'/>"></script>
</body>
</html>