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










    <div class="container .container-fluid">
        <div class="form-format">
            <form class="form-horizontal" id="sysUserForm">
                <input type="hidden" id="uid" name="uid" value="${sysUser.uid}">
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">申诉人/企业/机构名称：</label>
                    <div class="col-9">
                        <input type="text" name="username" class="form-control" placeholder=""
                               value="">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">申诉机构：</label>
                    <div class="ipt-box col-4">
                        <select name="" id=""></select>
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">证件类型：</label>
                    <div class="ipt-box col-4">
                        <select name=""></select>
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">证件号码：</label>
                    <div class="col-4">
                        <input type="text" name="" class="form-control" placeholder=""
                               value="">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">联系邮箱：</label>
                    <div class="col-4">
                        <input type="text" name="" class="form-control" placeholder=""
                               value="">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">联系电话：</label>
                    <div class="col-4">
                        <input type="text" name="" class="form-control" placeholder=""
                               value="">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label">手机验证码：</label>
                    <div class="col-1 mr5">
                        <input type="text" name="" class="form-control" placeholder=""
                               value="">
                    </div>
                    <button type="submit" class="fl btn btn-ms mr5">发送验证码</button>
                    <button type="submit" class="fl btn btn-ms disabled mr5">60s后重新发送</button>
                    <button type="submit" class="btn btn-ms">重新发送</button>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">留言标题：</label>
                    <div class="col-9">
                        <input type="text" name="username" class="form-control" placeholder="" value="">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">留言内容：</label>
                    <div class="col-9">
                        <div>
		                     <textarea rows="10" name="" class="form-textarea"></textarea>
                        </div>
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">相关证明材料：</label>
                    <div class="col-9">
                        <div class="file-box mr5">
                            <span><input type="file" id="btnFile" class="btnFile" name="btnFile"></span>
                            <button type="submit" class="fl btn btn-ms">上传</button>
                        </div>
                        <div class="filelabel">
                            已上传1.docx
                            <span class="close-icon"></span>
                        </div>
                    </div>
                </div>
                <div class="line-b"></div>
                <div class="center mt20">
                    <button id="save" type="submit" class="btn btn-sm mr20">提交</button>
                    <button id="cancel" type="button" class="btn btn-sm">取消</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>