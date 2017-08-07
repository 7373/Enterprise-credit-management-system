<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信用临安</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/system.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/admin.css"/>"/>
</head>
<body>
<div class="iframe-wrap">
<!--     <div class="iframe-header-bg"></div> -->
    <div class="form-panel">
    <div class="title">信用咨询管理</div>
        <form id="consultForm" class="form-box">
            <div class="form-list">
                <div class="form-item clearfix mr20">
                    <div class="col-1"></div>
                    <div class="col-5">
                        <label class="item-name col-5">留言标题：</label>
                        <div class="col-7">
                            <div class="ipt-box">
                                <input type="text" class="ipt-txt js-name" name="messageTitle" value=""/>
                            </div>
                        </div>
                    </div>
                    <div class="col-5">
                        <label class="item-name col-5">状态：</label>
                        <div class="col-6">
                            <div class="ipt-box">
                                <select name="messageStatus">
                                    <option value="">全部</option>
                                    <option value="0">待回复</option>
                                    <option value="1">已回复</option>
                                </select>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="form-item clearfix mr20">
                    <div class="col-1"></div>
                    <div class="col-5">
                        <label class="item-name col-5">留言类型：</label>
                        <div class="col-7">
                            <div class="ipt-box">
                                <input type="text" class="ipt-txt js-name" name="messageType" value=""/>
                            </div>
                        </div>
                    </div>
                    <div class="col-5">
                        <label class="item-name col-5"> 留言时间：</label>
                        <div class="col-6">
                        	<div class="ipt-box col-575">
                                <input type="text" readonly="readonly" onclick="laydate();" name="createTimeStart"
                                       class="ipt-txt clx" id="createTimeStart">
                            </div>
                            <span class="item-line col-05">-</span>
                            <div class="ipt-box col-575">
                                <input type="text" readonly="readonly" onclick="laydate();" name="createTimeEnd"
                                       class="ipt-txt clx" id="createTimeEnd">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="mt10">
                    <div class="center">
                        <input type="button" id="search" value="查询" class="btn mr20"><input
                            type="reset" id="reset" value="重置" class="btn">
                    </div>
                </div>
            </div>
        </form>

        <div class="pd15">
                <table id="consult-table" border="0" cellspacing="0" cellpadding="0" class="table-row nowrap"
                       width="100%">
                    <thead>
                    <tr>
                        <th style="padding: 0 20px;">序号</th>
                        <th>操作</th>
                        <th>状态</th>
                        <th>留言标题</th>

                        <th>留言类型</th>

                        <th>留言时间</th>

                        <th>回复时间</th>
                    </tr>
                    </thead>
                </table>
        </div>
    </div>
</div>
<jsp:include page="../../system/common/common.jsp"/>
<script src="<c:url value='/js/gateway/biz/backstage/credit_consult_list.js'/>"></script>
</body>
</html>