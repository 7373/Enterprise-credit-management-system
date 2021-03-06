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
        信用咨询管理
    </h2>
</div>
<div class="pdlr20">
        <form id="sceneForm" class="form-box">
            <div class="form-list">
                <div class="form-item clearfix mr20">
                    <div class="col-1"></div>
                    <div class="col-5">
                        <label class="item-name col-5">留言类型：</label>
                        <div class="col-7">
                            <div class="ipt-box">
                                <input type="text" class="ipt-txt js-name" name="nameLike" value=""/>
                            </div>
                        </div>
                    </div>
                    <div class="col-5">
                        <label class="item-name col-5">状态：</label>
                        <div class="col-6">
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

                </div>
                <div class="form-item clearfix mr20">
                    <div class="col-1"></div>
                    <div class="col-5">
                        <label class="item-name col-5">留言类型：</label>
                        <div class="col-7">
                            <div class="ipt-box">
                                <input type="text" class="ipt-txt js-name" name="nameLike" value=""/>
                            </div>
                        </div>
                    </div>
                    <div class="col-5">
                        <label class="item-name col-5"> 留言时间：</label>
                        <div class="col-6">
                            <div class="ipt-box col-575">
                                <select name="">
                                    <option value=""></option>
                                    <option value=""></option>
                                    <option value=""></option>
                                </select>
                            </div>
                            <span class="item-line col-05">-</span>
                            <div class="ipt-box col-575">
                                <select name="">
                                    <option value=""></option>
                                    <option value=""></option>
                                    <option value=""></option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="mt10">
                    <div class="center">
                        <input type="button" id="search" value="查询" class="btn mr20"><input
                            type="reset" id="cancel" value="重置" class="btn">
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
                        <th>状态</th>
                        <th>留言标题</th>

                        <th>留言类型</th>

                        <th>留言时间</th>

                        <th>回复时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>