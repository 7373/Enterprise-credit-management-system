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
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/biz.css"/>"/>
</head>
<body>
<jsp:include page="../../biz/common/header.jsp"/>
<div class="mod biz-main mt20">
    <h2 class="biz-title">
        <i class="process-icon"></i>
        系统流程
    </h2>
    <div class="mod contract-mg-cont">
        <div class="system-flowchart">

        </div>
    </div>
</div>
<jsp:include page="../../common/footer.jsp"/>
<jsp:include page="../../common/common.jsp"/>
</body>
</html>