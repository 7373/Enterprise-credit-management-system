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
        内容采编管理—新增
    </h2>
</div>
<div class="">
    <form id="publishForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix mr20">
                <div id="" class="col-12">
                    <label class="item-name col-1">标题：</label>
                    <div class="col-11">
                        <div class="ipt-box">
                            <input type="text" class="ipt-txt js-name" name="title" value=""/>
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
                                    <select id="type1Code" name="type1Code" class="">
<!--                                         <option value="">无</option> -->
                                        <c:forEach var="catalog1" items="${ndrcCatalog1List}">
      									<option value="${catalog1.catalogCode}" uid="${catalog1.UID}" code="${catalog1.catalogName}" >${catalog1.catalogName}</option>
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
<!--                                     <option class='remove' value="">无</option> -->
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">发布状态：</label>
                            <div class="col-7">
                                <div class="ipt-box">
                                    <select name="state" id="state">
                                        <option value="0">暂停</option>
                                        <option value="1">发布</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="form-item clearfix mr20">
                <div id="maincontent" class="col-12">
                    <label class="item-name col-1">内容：</label>
                    <div class="col-11">
                        <div class="ipt-box">
                            <textarea  id="content"  name="content" cols="100" rows="10" style="width:700px;height:280px;visibility:hidden;">
                            
                            </textarea>
                            <label class="item-name col-1">字数统计：</label>
							<label class="item-name col-1" id="count" name="count" ></label>
                        </div>
                    </div>
                    
                </div>
            </div>
            
            <div class="form-item clearfix mr20">
			<input type="hidden" id="type1" name="type1" />
			<input type="hidden" id="type2" name="type2" />
			<input type="hidden" id="isDel" name="isDel" value="0" />
            </div>
            <div class="credit-info pl15">
            <ul>
            <li>
                <label class="col-1"></label>
            <div class="file-box col-11">
                <input id="uploadname" type="button" class="upload btn-mad btn-bg-bule" value="图片上传">
                    <span id="fileBox">
                        <input type="file" id="btnFile" class="file" name="btnFile">
                    </span>
                <iframe width="0" height="0" name="uploadframe"></iframe>
                <div class="filelabel">
                </div>
                <span id="uploadState" class="upload-state">上传中....</span>
            </div></li></ul></div>
            <input type="hidden" id="filePath" class="clx" name="filePath" value=""/>
            <div class="mt50">
                <div class="center">
                    <input type="button" id="search" value="提交" class="btn mr20">
                    <input type="reset" id="cancel" value="取消" class="btn">
                </div>
            </div>
        </div>
    </form>
</div>
<jsp:include page="../../system/common/common.jsp"/>
<script charset="utf-8" src="/js/lib/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="/js/lib/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="/js/lib/kindeditor/plugins/code/prettify.js"></script>
<script src="<c:url value='/js/gateway/biz/backstage/news_publish_add.js'/>"></script>
</body>
</html>