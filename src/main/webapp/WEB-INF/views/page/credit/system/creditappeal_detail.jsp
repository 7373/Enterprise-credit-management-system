<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/credit/credit.css"/>"/>
</head>
<body>
    <div class="container .container-fluid">
        <div class="form-format">
            <form class="form-horizontal" id="hxForm">
                <input type="hidden" name="appealId" value="${user.uid}">
                <input type="hidden" name="appealSource" value="${user.userType}">
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">申诉人/企业/机构名称：</label>
                    <div class="col-9">
                        <input type="text" name="appealName" class="form-control" readonly
                               value="${ndCreditAppeal.appealName}">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">申诉机构：</label>
                    <div class="ipt-box col-4">
                        <input type="text" name="appealOrgan" class="form-control" readonly
                               value="${ndCreditAppeal.appealOrgan}">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">证件类型：</label>
                    <div class="ipt-box col-4">
                        <input type="text" name="certType" class="form-control" readonly
                               value="${ndCreditAppeal.certType == '1'?'身份证':(ndCreditAppeal.certType==2?'统一信用代码':'其他')}">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">证件号码：</label>
                    <div class="col-4">
                        <input type="text" name="certNO" class="form-control" readonly
                               value="${ndCreditAppeal.certNO}">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">联系邮箱：</label>
                    <div class="col-4">
                        <input type="text" name="email" class="form-control" readonly
                               value="${ndCreditAppeal.email}">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">联系电话：</label>
                    <div class="col-4">
                        <input type="text" name="tel" class="form-control" readonly
                               value="${ndCreditAppeal.tel}">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">标题：</label>
                    <div class="col-9">
                        <input type="text" name="title" class="form-control" readonly value="${ndCreditAppeal.title}">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">申诉内容：</label>
                    <div class="col-9">
                        <div>
		                     <textarea rows="10" name="appealContent" class="form-textarea" readonly>${ndCreditAppeal.appealContent}</textarea>
                        </div>
                    </div>
                </div>
                <div class="line-b"></div>
                <div class="center mt20">
                    <button id="close" type="button" class="btn btn-sm">关闭</button>
                </div>
            </form>
        </div>
    </div>
<!-- 通用页面 -->
<jsp:include page="../../credit/system/common/common.jsp"/>
<script src="<c:url value='/js/credit/system/creditappeal_detail.js'/>"></script>
</body>
</html>