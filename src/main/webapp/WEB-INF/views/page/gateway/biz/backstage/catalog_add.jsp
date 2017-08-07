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
        频道/栏目管理—新增
    </h2>
</div>
<div class="pdlr20">
    <form id="catalogForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix mr20">
                <div class="col-12">
                    <label class="item-name col-1">标题：</label>
                    <div class="col-11">
                        <div class="col-4">
                            <label class="item-name col-5">一级分类：</label>
                            <div class="col-7">
                                <div class="ipt-box">
                                    <select id="uid" name="uid">
                                        <c:forEach var="catalog" items="${CatalogOneList}">
      									<option uid="${catalog.UID}" value="${catalog.UID}" code="${catalog.UID}">${catalog.catalogName}</option>
      									</c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">二级分类：</label>
                            <div class="col-7">
                                <div class="ipt-box">
		                            <input type="text" class="ipt-txt js-name" name="catalogName" value=""/>
		                        </div>
                    		</div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">目录类别：</label>
                            <div class="col-7">
                                <div class="ipt-box">
                                    <select name="catalogType">
                                        <option value="文字类">文字类</option>
                                        <option value="视频类">视频类</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
             <input type="hidden" name="parentID" id="parentID" value="">
             <input type="hidden" name="isDel" id="isDel" value="0">
            <div class="mt10">
                <div class="center">
                    <input type="button" id="search" value="提交" class="btn mr20"><input
                        type="reset" id="cancel" value="取消" class="btn">
                </div>
            </div>
        </div>
    </form>
</div>
<jsp:include page="../../system/common/common.jsp"/>
<script src="<c:url value='/js/gateway/biz/backstage/catalog_add.js'/>"></script>
</body>
</html>