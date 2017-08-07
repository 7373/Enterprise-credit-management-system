<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/system.css"/>"/>
</head>
<body>
<table class="table-row">
    <tr>
        <th rowspan="2">地区</th>
        <th rowspan="2">申请登记总数</th>
        <th colspan="3">登记情况</th>
        <th colspan="5">附件种类</th>
    </tr>
    <tr>
        <th>登记通过</th>
        <th>登记失败</th>
        <th>登记失效</th>
        <th>合同</th>
        <th>申请书</th>
        <th>代理人委托书/身份证</th>
        <th>营业执照</th>
        <th>其他</th>
    </tr>
</table>
</body>
</html>