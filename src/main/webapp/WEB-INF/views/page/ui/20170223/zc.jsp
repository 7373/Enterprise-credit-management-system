<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业端注册</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/biz.css"/>"/>
</head>
<body>
<!-- 头部开始 -->
<div class="biz-top">
    <div class="mod clearfix">
        <a href="###" class="biz-logo"></a>
        <div class="fr nav-bar">
            <a href="" class="mr10">
                <i class="icon-user"></i>
                <span class="txt">用户管理</span>
            </a>
            <a href="" class="mr10">
                <i class="icon-procedure"></i>
                <span class="txt">操作流程</span>
            </a>
            <a href="">
                <span class="txt">退出系统</span>
                <i class="icon-logout"></i>
            </a>
        </div>
    </div>
</div>
<!-- 主体 用户注册开始 -->
<div class="mod biz-main mt20">
    <h2 class="biz-title">
        <i class="icon-user"></i>
        用户注册
    </h2>
    <div class="mod biz-content">
        <ul class="register-list">
            <li>
                <label>企业名称：</label>
                <div class="info">
                    <input type="text" class="ipt-txt" value="浙江汇信科技有限公司"/>
                </div>
            </li>
            <li>
                <label>注册号/统一代码：</label>
                <div class="info">
                    <input type="text" class="ipt-txt" value=""/>
                </div>
            </li>
            <li>
                <label>用户名：</label>
                <div class="info">
                    <input type="text" class="ipt-txt" value=""/>
                </div>
            </li>
            <li>
                <label>密码：</label>
                <div class="info">
                    <input type="password" class="ipt-txt" value=""/>
                </div>
            </li>
            <li>
                <label>确认密码：</label>
                <div class="info">
                    <input type="password" class="ipt-txt" value=""/>
                </div>
            </li>
            <li>
                <label>经办人姓名：</label>
                <div class="info">
                    <input type="text" class="ipt-txt" value=""/>
                </div>
            </li>
            <li>
                <label>经办人证件类型：</label>
                <div class="info">
                    <select name="" id="" class="ipt-sel">
                        <option value="" selected>居民身份证</option>
                        <option value="">驾驶证</option>
                        <option value="">市民卡</option>
                    </select>
                </div>
            </li>
            <li>
                <label>经办人证件号码：</label>
                <div class="info">
                    <input type="text" class="ipt-txt" value=""/>
                </div>
            </li>
            <li>
                <label>经办人手机：</label>
                <div class="info">
                    <input type="text" class="ipt-txt" value=""/>
                </div>
            </li>
            <li>
                <label>验证码：</label>
                <div class="info">
                    <input type="password" class="ipt-txt" value=""/>
                    <input type="button" class="btn" value="获取验证码"/>
                </div>
            </li>
            <%--<li>--%>
            <%--<label>合同类别：</label>--%>
            <%--<div class="info">--%>
            <%--<input type="checkbox"/><span class="mr10">类别一</span>--%>
            <%--<input type="checkbox"/><span>类别二</span>--%>
            <%--</div>--%>
            <%--</li>--%>
            <li>
                <label>上传营业执照：</label>
                <div class="info">
                    <div class="mb10"><input type="button" class="btn mr10" value="添加附件"><a href=""
                                                                                            class="a-blue">模板下载</a>
                    </div>
                    <div class="mb10"><i class="icon-file"></i><span class="file-name mr10">营业执照1.doc</span><a href=""
                                                                                                               class="a-blue">预览附件</a>
                    </div>
                </div>
            </li>
            <li>
                <label></label>
                <div class="info">
                    <input type="button" class="btn btn-reg" value="立即注册"/>
                </div>
            </li>
        </ul>
    </div>
</div>

<!-- 底部 开始 -->
<div class="footer">
    <p>©&nbsp;&nbsp;2016 浙江汇信科技有限公司 版权所有<br/>
        浙ICP备：浙B2-20070198-13&nbsp;&nbsp;&nbsp;&nbsp;浙公网安备：33010502002208号
    </p>
</div>
</body>
</html>