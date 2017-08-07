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
        <div class="title"> 内容采编管理</div>
        <form id="newsPublishForm" class="form-box">
            <div class="form-list">
                <div class="form-item clearfix mr20">
                    <div id="uniCode" class="col-4">
                        <label class="item-name col-5">标题：</label>
                        <div class="col-7">
                            <div class="ipt-box">
                                <input type="text" class="ipt-txt js-name clx" name="title" value=""/>
                            </div>
                        </div>

                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">一级分类：</label>
                        <div class="col-7">
                            <div class="ipt-box">
                            	<select id="type1Code" name="type1Code" >
                                        <option value="">无</option>
                                        <c:forEach var="catalog1" items="${ndrcCatalog1List}">
      									<option class="clx aaaa" value="${catalog1.catalogCode}" catalogCode="${catalog1.catalogCode}" uid="${catalog1.UID}" code="${catalog1.catalogName}" >${catalog1.catalogName}</option>
      									</c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">二级分类：</label>
                        <div class="col-7">
                            <div class="ipt-box">
                            	<select id="type2Code" name="type2Code">
                                    <option class='remove' value="">无</option>
                                    </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix mr20">
                    <div id="uniCode" class="col-4">
                        <label class="item-name col-5">发布人：</label>
                        <div class="col-7">
                            <div class="ipt-box">
                            	<input type="text" class="ipt-txt js-name clx" name="publisher" value=""/>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">发布时间：</label>
                        <div class="col-7">
                            <div class="ipt-box col-575">
                                <input type="text" readonly="readonly" onclick="laydate();" name="publishTimeStart"
                                       class="ipt-txt clx" id="publishTimeStart">
                            </div>
                            <span class="col-05 item-line">-</span>
                            <div class="ipt-box col-575">
                                <input type="text" readonly="readonly" onclick="laydate();" name="publishTimeEnd"
                                       class="ipt-txt clx" id="publishTimeEnd">
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <label class="item-name col-5">状态：</label>
                        <div class="col-7">
                            <div class="ipt-box">
                                <select name="state" id="state" class="clx">
                             		   <option value="">无</option>
                                        <option value="0">暂停</option>
                                        <option value="1">发布</option>
                                </select>
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
        <div class="clearfix mb5 pos-rel">
            <p class="fl"><input type="button" class="btn-sm mr5" value="新增" id="js-add"></p>
            <%--<span class="table-load js-table-load top20" title="刷新表格"></span>--%>
        </div>

        <div class="">
            <div class="table-out">
                <table id="scene-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap"
                       width="100%">
                    <thead>
                    <tr>
                        <th style="padding: 0 20px;">序号</th>
                        <th>操作</th>
                        <th>标题</th>
                        <th>状态</th>
                        <th>一级分类</th>
                        <th>二级分类</th>
                        <th>发布人</th>
                        <th>最近发布时间</th>
                        <th>最近修改时间</th>
                        <th>创建时间</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
    <jsp:include page="../../system/common/common.jsp"/>
<script src="<c:url value='/js/gateway/biz/backstage/news_publish_list.js'/>"></script>
</body>
</html>