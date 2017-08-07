<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/biz.css"/>"/>
</head>
<body>
    <div class="contract-tp-box">
        <ul>
            <li>
                <label>合同名称：</label>
                <div class="info">
                    <input type="text" class="ipt-txt" >
                </div>
            </li>
            <li>
                <label>合同类别：</label>
                <div class="info">
                    <select name="" id="" class="ipt-sel">
                        <option value="" selected=""></option>
                    </select>
                </div>
            </li>
        </ul>
        <h4>必选上传材料：<a href="" class="light fr">上传说明</a></h4>
        <div>
            <table class="table-col-spread">
                <tr>
                    <td class="title">合同</td>
                    <td>
                        <div class="upload">
                            <input type="file" class="btnFile">
                            <input type="button" class="btn mr8" value="添加附件"><a href="">模板下载</a>
                            <p><i class="cl-icon"></i>营业执照1.doc<a href="" class="ml15">模板下载</a></p>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="title">申请书</td>
                    <td>
                        <div class="upload">
                            <input type="file" class="btnFile">
                            <input type="button" class="btn mr8" value="添加附件"><a href="">模板下载</a>
                            <p><i class="cl-icon"></i>营业执照1.doc<a href="" class="ml15">模板下载</a></p>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="title">代理人委托书及身份证</td>
                    <td>
                        <div class="upload">
                            <input type="file" class="btnFile">
                            <input type="button" class="btn mr8" value="添加附件"><a href="">模板下载</a>
                            <p><i class="cl-icon"></i>营业执照1.doc<a href="" class="ml15">模板下载</a></p>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <h4 class="mt10">可选上传材料：</h4>
        <div>
            <table class="table-col-spread">
                <tr>
                    <td class="title">其他附件份数</td>
                    <td>
                        <select name="" class="ipt-sel">
                            <option value="" selected=""></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="title">其他材料</td>
                    <td>
                        <div class="upload">
                            <input type="file" class="btnFile">
                            <input type="button" class="btn mr8" value="添加附件"><a href="">模板下载</a>
                            <p><i class="cl-icon"></i>营业执照1.doc<a href="" class="ml15">模板下载</a></p>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>