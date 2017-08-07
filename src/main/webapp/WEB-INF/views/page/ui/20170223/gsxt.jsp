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
<body class="white-bg">
<!-- 头部开始 -->
<div class="sys-top">
    <div class="logo"></div>
</div>

<!-- 主体开始 -->
<div class="mod">
    <div class="search-outer clearfix mb20">
        <div class="search-box">
            <input type="text" class="fl txt mr5" placeholder="输入企业名称/合同名称" />
            <div class="btn-outer">
                <input type="button" class="btn btn-search" value="搜索">
                <i class="icon-search"></i>
            </div>
        </div>
    </div>
    <div class="search-result">
        <table class="table-row">
            <thead>
            <tr>
                <th>序号</th>
                <th>企业名称</th>
                <th>企业注册号/统一代码 </th>
                <th>合同名称</th>
                <th>合同分类</th>
                <th>合同性质</th>
                <th>登记时间</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td>2</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>