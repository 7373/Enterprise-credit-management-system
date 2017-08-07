<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-06-14
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html>--%>
<%--<head>--%>
    <%--<title>信用临安</title>--%>
<%--</head>--%>
<%--<body>--%>
<form id="consult-form">
    <div class="credit-info pl52">
        <ul>
            <li><label class="w-78"><span>*</span>真实姓名：</label><input id="realName" name="realName" type="text"></li>
            <li><label class="w-78">职业：</label><input id="profession" name="profession" type="text"></li>
            <li><label class="w-78">联系电话：</label><input id="tel" name="tel" type="text"></li>
            <li><label class="w-78">联系邮箱：</label><input id="mail" name="mail" type="text"></li>
            <li>
                <label class="w-78 vertical10">留言类型：</label>
            <div class="select-box">
                <select id="messageType" name="messageType" class="select">
                    <option value="咨询">咨询</option>
                    <option value="改进建议">改进建议</option>
                    <option value="投诉">投诉</option>
                </select>
            </div>

            </li>
            <li><label class="w-78"><span>*</span>留言标题：</label><input id="messageTitle" name="messageTitle" class="w-600" type="text"></li>
            <li><label class="w-78"><span>*</span>留言内容：</label><textarea id="messageContent" name="messageContent" class="textarea-message" rows="10"></textarea></li>
            <li>
                <label class="w-78">验证码：</label>
                <input class="w-80 verification-code" type="text" id="checkCode" name="checkCode"  placeholder="请输入验证码"><span>
                <img src="/ndrcCaptcha?t=0.9532056235676236" alt="" class="js-check-img" width="94px"></span>
                <a href="javascript:void(0);" class="js-checkcode">换一张</a>

            </li>
            <li class="error" id="errorContainer" style="color: red"></li>
        </ul>
    </div>
<!--     <p class="center notice mb10"><input id="checkbox" type="checkbox">同意<a href="#">《留言须知》</a></p> -->
    <div class="btn-group center">
        <input class="w-90 fs16 btn-sub btn-bg-bule" type="submit" value="提交">
        <input id="reset" class="w-90 fs16 btn-sub btn-bg-bule" type="reset" value="重置">
    </div>
</form>

<%--<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>--%>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value='/js/gateway/biz/reception/inter_consult.js'/>"></script>
<%--</body>--%>
<%--</html>--%>
