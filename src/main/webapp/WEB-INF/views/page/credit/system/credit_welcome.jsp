<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="<c:url value='/css/credit/credit.css'/>">
</head>
<body>
<div class="iframe-wrap">
	<div class="form-panel">
		<div class="title">首页</div>
		
	    <div class="credit-info-query clearfix">
	        <div class="item company-query mr30 qycx">企业信息查询</div>
	        <div class="item personal-query mr30 grcx">个人信息查询</div>
	        <div class="item share-query gxcx">共享查询</div>
	    </div>
				<div style="padding-top:10px;font-size: 23px;color: #87CEEB;margin-left:10px;">数据归集监控</div>
	        <div class="mt38">
	            <div class="home-item h-statistics">
	                <div class="h-contant clearfix" style="border-top: none; height: 350px;">
	                	<div id="main1" style="height:350px;"></div>
	                </div>
	                <br/>
	                <div class="h-contant clearfix" style="border-top: none; height: 350px;">
	                	<div id="main2" style="height:350px;"></div>
	                </div>
	                
	            </div>
	        </div>
      </div>
    </div>
    <script src="/js/lib/echarts/echarts-all.js"></script>
    <script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
    <script src="/js/credit/system/credit_welcome.js"></script>
</body>
</html>