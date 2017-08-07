<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-06-09
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信用临安</title>
</head>
<body>
<ul class="xyla-nav">
    <li><i></i><a class="${empty menu?'active':''}" href="/">首页</a></li>
    <li><a class="${menu ==1?'active':''}" href="/gateway/reception/doEnOrganStruct?menu=1">组织架构</a></li>
    <li><a class="${menu ==2?'active':''}" href="/gateway/reception/doEnCreditDynamic?menu=2">信用动态</a></li>
    <li><a class="${menu ==3?'active':''}" href="/gateway/reception/doEnPolicyRule?menu=3">政策法规</a></li>
    <li><a class="${menu ==4?'active':''}" href="/gateway/reception/doEnCreditResearch?menu=4">信用研究</a></li>
    <li><a class="${menu ==5?'active':''}" href="/gateway/reception/doEnCreditSearch?menu=5">信用查询</a></li>
    <li><a class="${menu ==6?'active':''}" href="/gateway/reception/doEnPublishPlatform?menu=6&item=Double">发布平台</a></li>
    <li><a class="${menu ==7?'active':''}" href="/gateway/reception/doEnInterCommunion?menu=7">互动交流</a></li>
</ul>
</body>
</html>
