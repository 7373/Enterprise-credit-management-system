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
        <div class="assist">任务编码：0000000</div>
        <div class="title">协查申请</div>
        <div class="pd20">
            <div class="table-outside-title2 mb5">
                <span>录入对象</span>
                <button type="submit" class="btn btn-xs">删除</button>
                <button type="submit" class="btn btn-xs">添加</button>
            </div>
            <div>
                <table class="table-row nowrap mb10" width="100%">
                    <thead>
                    <tr>
                        <th width="5%">序号</th>
                        <th width="5%">选择</th>
                        <th>对象名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="center">1</td>
                        <td class="center"><input type="checkbox"/></td>
                        <td><input type="text" class="ipt-txt"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="table-outside-title2 mb5">
                <span>协查部门</span>
                <button type="submit" class="btn btn-xs">删除</button>
                <button type="submit" class="btn btn-xs">添加</button>
            </div>
            <div>
                <table class="table-row nowrap mb10" width="100%">
                    <thead>
                    <tr>
                        <th width="5%">序号</th>
                        <th width="5%">选择</th>
                        <th width="70%">部门名称</th>
                        <th>是否发送工作提示</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="center">1</td>
                        <td class="center"><input type="checkbox"/></td>
                        <td><input type="text" class="ipt-txt"/></td>
                        <td class="center">
                            <input type="radio" id="yes" name="send" checked="checked" /><label for="yes" class="mr25">是</label>
                            <input type="radio" id="no" name="send" /><label for="no">否</label>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="table-outside-title2 mb10 line-b">
                <span>协查部门</span>
            </div>
            <form class=" mb10">
                <div class="form-list">
                    <div class="form-item clearfix">
                        <label class="item-name col-2">协查原因&nbsp;</label>
                        <div class="col-9">
                            <textarea rows="10" name="" class="form-textarea"></textarea>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <label class="item-name col-4">联系人&nbsp;</label>
                            <div class="col-4">
                                <div class="ipt-box">
                                    <input type="text" class="ipt-txt clx" name="username" value="">
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <label class="item-name col-3">联系电话&nbsp;</label>
                            <div class="col-7">
                                <div class="ipt-box">
                                    <input type="text" class="ipt-txt clx" name="realName" value="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <div class="col-6">
                            <label class="item-name col-4">联系部门&nbsp;</label>
                            <div class="col-8">
                                <div class="ipt-box">
                                    <input type="text" class="ipt-txt clx" name="username" value="">
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <label class="item-name col-3">联系邮箱&nbsp;</label>
                            <div class="col-7">
                                <div class="ipt-box">
                                    <input type="text" class="ipt-txt clx" name="realName" value="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mt15">
                    <div class="center">
                        <input type="button" id="search" value="提交" class="btn mr20">
                        <input type="reset" id="" value="取消" class="btn ">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>