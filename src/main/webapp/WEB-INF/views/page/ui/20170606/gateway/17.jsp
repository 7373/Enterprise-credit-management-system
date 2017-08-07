<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/admin.css"/>"/>
</head>
<body class="pd20">
<div>
    <table class="table-horizontal">
        <tr>
            <td class="bg-gray right" width="80">真实姓名:</td>
            <td></td>
            <td class="bg-gray right" width="80">职业:</td>
            <td></td>
        </tr>
        <tr>
            <td class="bg-gray right" >联系电话:</td>
            <td></td>
            <td class="bg-gray right" >联系邮箱:</td>
            <td></td>
        </tr>
        <tr>
            <td class="bg-gray right" >留言类型:</td>
            <td></td>
            <td class="bg-gray right" >留言时间:</td>
            <td></td>
        </tr>
        <tr>
            <td class="bg-gray right" >留言标题:</td>
            <td colspan="3"></td>
        </tr>
        <tr>
            <td class="bg-gray right h175">留言内容:</td>
            <td colspan="3"></td>
        </tr>
    </table>

    <div class="comeback">
        <h3 class="title mt15">回复内容：</h3>
        <textarea name="" id="" cols="30" rows="10"></textarea>
    </div>
    <div class="mt10">
        <div class="center">
            <input type="button" id="search" value="提交" class="btn mr20"><input
                type="reset" id="cancel" value="取消" class="btn">
        </div>
    </div>
</div>

</body>
</html>