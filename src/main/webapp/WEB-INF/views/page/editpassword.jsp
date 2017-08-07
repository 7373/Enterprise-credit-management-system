<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>浙江省合同格式条款备案系统</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/biz.css"/>"/>
</head>
<body class="white-bg h-auto">
<form id="findpassword-form">
    <div class="mod-900 biz-main ">
        <div class="biz-content mt20">
            <ul class="register-list">
                <li>
                    <label>原密码：</label>
                    <div class="info">
                        <input type="password" class="ipt-txt clx" name="password" id="password" value="" placeholder="请输入原密码"/>
                    </div>
                </li>
                <li>
                    <label>新密码：</label>
                    <div class="info">
                        <input type="password" name="password1" id="password1" class="ipt-txt clx" value="" placeholder="请输入新密码"/>
                    </div>
                </li>
                <li>
                    <label>确认密码：</label>
                    <div class="info">
                        <input type="password" name="password2" id="password2" class="ipt-txt clx" value="" placeholder="请确认密码"/>
                    </div>
                </li>
                <li>
                    <label></label>
                    <div class="info">
						 <label class="error" id="errorContainer"></label>
                    </div>
                </li>
                <li class="mt10">
                    <label></label>
                    <input type="hidden" name="uid" value="${id}"/>
                    <input type="hidden" name="roles" value="${roles}"/>
                    <div class="btn-box center">
	                  <input type="submit" class="btn btn-primary" value="确认修改"/>&nbsp;&nbsp;&nbsp;
                      <input type="button" id="reset" class="btn btn-primary" value="重置"/>
	              </div>
                </li>
            </ul>
        </div>
    </div>
</form>
<!-- 通用页面 -->
<jsp:include page="credit/system/common/common.jsp"/>
<script src="<c:url value='/js/system/editpassword.js'/>"></script>
</body>
</html>