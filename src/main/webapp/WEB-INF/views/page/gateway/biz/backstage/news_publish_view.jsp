<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信用临安</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/admin.css"/>"/>
</head>
<body>
<div>
    <h2 class="cont-hd">
        内容采编管理—查看
    </h2>
</div>
<div class="pdlr20">
    <form id="viewPublishForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix mr20">
                <div id="" class="col-12">
                    <label class="item-name col-1">标题：</label>
                    <div class="col-11">
                        <div class="ipt-box">
                            <input type="text" readonly="readonly" class="ipt-txt js-name" name="title" value="${newsPublish.title}"/>
                        </div>
                    </div>

                </div>
            </div>
            <div class="form-item clearfix mr20">
                <div class="col-12">
                    <label class="item-name col-1">标题：</label>
                    <div class="col-11">
                        <div class="col-4">
                            <label class="item-name col-5">一级分类：</label>
                            <div class="col-7">
                                <div class="ipt-box">
                                	<input type="text" readonly="readonly" class="ipt-txt js-name" name="type1" value="${newsPublish.type1}"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">二级分类：</label>
                            <div class="col-7">
                                <div class="ipt-box">
                                	<input type="text" readonly="readonly" class="ipt-txt js-name" name="type2" value="${newsPublish.type2}"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">发布状态：</label>
                            <div class="col-7">
                                <div class="ipt-box">
                                	<input type="text" readonly="readonly" class="ipt-txt js-name" name="state" id="state" 
                                	value="${newsPublish.stateDesc}"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="form-item clearfix mr20">
                <div id="" class="col-12">
                    <label class="item-name col-1">内容：</label>
                    <div class="col-11">
                        <div class="ipt-box">
                            <textarea  id="content" name="content" cols="100" rows="10" style="width:700px;height:280px;visibility:hidden;">${newsPublish.content}</textarea>
                            <label class="item-name col-1">字数统计：</label>
							<label class="item-name col-1" id="count" name="count" ></label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<jsp:include page="../../system/common/common.jsp"/>
<script charset="utf-8" src="/js/lib/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="/js/lib/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="/js/lib/kindeditor/plugins/code/prettify.js"></script>
<script src="<c:url value='/js/gateway/biz/backstage/news_publish_view.js'/>"></script>
</body>
</html>