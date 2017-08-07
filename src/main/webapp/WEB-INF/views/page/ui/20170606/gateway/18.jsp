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
<body>
<div>
    <h2 class="cont-hd">
        日志监控
    </h2>
</div>
<div class="pdlr20 mt10">

        <div class="">
            <div class="table-out">
                <table id="scene-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap"
                       width="100%">
                    <thead>
                    <tr>
                        <th style="padding: 0 20px;">序号</th>
                        <th>最新操作人 </th>
                        <th>最新操作人</th>

                        <th>操作时间</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>

</body>
</html>