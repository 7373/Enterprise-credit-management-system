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
        <div class="title">部门数据上传</div>
        <div class="template-down mb30">
        	<a href="javascript:void(0)" class="downTemple" >模板下载:${deptFileName}</a>
        </div>
        <form class="form-horizontal" id="noticeForm">
        	<div class="complaint-files-select clearfix">
            <div class="col-10 ipt-box mr5">
                <input type="text" id="fileName" class="ipt-txt clx" name="" value="">
            </div>
            <div class="file-box mr5">
                <span id="uploadFile"><input type="file" id="btnFile" class="btnFile  w-80" name="btnFile"></span>
                <button type="button" class="fl btn btn-ms w-80">选择文件</button>
            </div>
      	  </div>
        </form>
        <div class="center mb20">
            <input type="button" id="search" value="上传" class="btn">
        </div>
        <div class="line-b mb20"></div>
        <div class="notes">
            <p>注意事项：</p>
            <p>1、文件的命名，文件命名格式：部门+日期（如模板）；若是多个文件，文件命名格式：部门名称+日期+-数字，例如：某某局20160101-1.xls。</p>
            <p>2、上传成功的sheel不能再次上传，避免数据重复。</p>
            <p>3、公司名称、工商注册号、身份证号等不能为空。</p>
            <p>4、数字型的数据，如金额、数量等，不能含有“千”、“万”、“万元”等汉字。</p>
            <p>5、日期型的数据，必须为日期格式或者yyyy-mm-dd格式的文本类型。</p>
            <p>6、若没有数据的行提示数据格式错误，请删除空行。</p>
            <p>7、不能再已成功上传文件的基础上追加数据！若要追加，下载模板并按照1命名模板，添加数据前，<span class="light">请删除所有的sheet的数据</span>，仅上传要追加的数据。</p>
            <p>8、一次只能上传一个文件。</p>
        </div>
        <br/><br/><br/><br/>
    </div>
</div>
<jsp:include page="common/common.jsp"></jsp:include>
<script type="text/javascript" src="<c:url value='/js/credit/system/upload_list.js'/>"></script>
</body>
</html>