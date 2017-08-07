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
<div class="iframe-wrap">
    <div class="form-panel">
        <div class="title">企业信息查询</div>
        <div class="tip light">查询说明：目前查询的法人信用记录，是有关政府部门按照有关规定向社会公开的信用信息。对查看到的信用信息有异议，可提出<a href="">异议处理</a>。</div>
        <form id="" class="form-box">
            <div class="form-list">
                <div class="form-item clearfix mr20">
                    <div class="col-6">
                        <label class="item-name col-5">企业名称&nbsp;</label>
                        <div class="col-5">
                            <div class="ipt-box">
                                <input type="text" class="ipt-txt clx" name="" value="">
                            </div>
                        </div>
                    </div>
                    <div class="col-6">
                        <label class="item-name col-4">社会统一信用代码/工商注册号&nbsp;</label>
                        <div class="col-4">
                            <div class="ipt-box">
                                <input type="text" class="ipt-txt clx" name="" value="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mt15">
                <div class="center">
                    <input type="button" id="search" value="查询" class="btn mr20">
                    <input type="reset" id="" value="重置" class="btn ">
                </div>
            </div>
        </form>
        <div class="box-panel">
            <table id="" class="table-row nowrap" width="100%">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>企业名称</th>
                    <th>社会统一信用代码/工商注册号</th>
                    <th>预警标识</th>
                    <th>操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
</body>
</html>