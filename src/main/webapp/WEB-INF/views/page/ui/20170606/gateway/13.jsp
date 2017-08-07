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
        内容采编管理—新增
    </h2>
</div>
<div class="pdlr20">
    <form id="sceneForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix mr20">
                <div id="" class="col-12">
                    <label class="item-name col-1">标题：</label>
                    <div class="col-11">
                        <div class="ipt-box">
                            <input type="text" class="ipt-txt js-name" name="nameLike" value=""/>
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
                                    <select name="module">
                                        <option value="">全部</option>
                                        <option value="0">广告</option>
                                        <option value="1">应用</option>
                                        <option value="2">活动</option>
                                        <option value="3">资源</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">二级分类：</label>
                            <div class="col-7">
                                <div class="ipt-box">
                                    <select name="terminal">
                                        <option value="">全部</option>
                                        <option value="0">客户端</option>
                                        <option value="1">官网</option>
                                        <option value="2">APP</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <label class="item-name col-5">发布状态：</label>
                            <div class="col-7">
                                <div class="ipt-box">
                                    <select name="terminal">
                                        <option value="">全部</option>
                                        <option value="0">客户端</option>
                                        <option value="1">官网</option>
                                        <option value="2">APP</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mr20">


            </div>
            <div class="mt10">
                <div class="center">
                    <input type="button" id="search" value="提交" class="btn mr20"><input
                        type="reset" id="cancel" value="取消" class="btn">
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>