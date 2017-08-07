<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>部门选择</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="<c:url value='/css/system.css'/>">
</head>
<body  class="white-bg">
<ul id="sysDepartTree" class="ztree ztree-list"></ul>
<div class="center mt20">
                <button type="button" id="departmentSubmit" class="btn btn-sm mr20">确定</button>
                <button id="cancle"  type="button" class="btn btn-sm">取消</button>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
    <script src="/js/common/credit_dept_radio_tree_select.js"></script>
<script type="text/javascript">
    window._CONFIG = {
        treeUrl: '<c:url value="/gateway/reception/dept/doGetDeptList"/>'
    }
</script>
</body>
</html>
