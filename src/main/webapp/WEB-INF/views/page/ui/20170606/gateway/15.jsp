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
<form id="paramForm" class="form-box">
    <div class="form-list pdr30">
        <div class="form-item clearfix">
                <label class="item-name col-2">问题：</label>
                <div class="col-10">
                    <div class="ipt-box">
                        <input type="text" class="ipt-txt" name="nameLike" value=""/>
                    </div>
                </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">调研时间：</label>
            <div class="col-4">
                    <div class="ipt-box col-12">
                        <div class="ipt-box col-575">
                            <select name="">
                                <option value=""></option>
                                <option value=""></option>
                                <option value=""></option>
                            </select>
                        </div>
                        <span class="item-line col-05">	&minus;</span>
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
        <div class="form-item clearfix">
            <label class="item-name col-2">选项：</label>
            <div class="col-10">
                <div class="ipt-box ml30">
                    <span class="num-tip">1</span>
                    <input type="text" class="ipt-txt" name="nameLike" value=""/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"></label>
            <div class="col-10">
                <div class="ipt-box ml30">
                    <span class="num-tip">2</span>
                    <input type="text"  class="ipt-txt" name="nameLike" value=""/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"></label>
            <div class="col-10">
                <div class="ipt-box ml30">
                    <span class="num-tip">3</span>
                    <input type="text"  class="ipt-txt" name="nameLike" value=""/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"></label>
            <div class="col-10">
                <div class="ipt-box ml30">
                    <span class="num-tip">4</span>
                    <input type="text"  class="ipt-txt" name="nameLike" value=""/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix mt5 mb10">
            <label class="item-name col-2"></label>
            <div class="col-05">
                <input type="button"  value="提交" class="btn-sm mr20">
            </div>
        </div>
        <div class="pdt10 border-top ml40">
            <div class="center">
                <input type="button"  value="提交" class="btn mr20">
                <input type="button"  value="马上发布" class="btn mr20">
                <input type="button"  value="取消" class="btn mr20">
            </div>
        </div>
    </div>
</form>
</body>
</html>