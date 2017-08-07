<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/credit/credit.css'/>">
</head>
<body>
<div class="iframe-wrap">
	<div class="form-panel">
		<div class="title">异议申诉</div>
        <div class="form-format">
            <form class="form-horizontal" id="hxForm">
                <input type="hidden" name="appealId" value="${user.uid}">
                <input type="hidden" name="appealSource" value="${user.userType}">
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">申诉人/企业/机构名称：</label>
                    <div class="col-9">
                        <input type="text" name="appealName" class="form-control" placeholder=""
                               value="">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">申诉机构：</label>
                <div class="col-4 pos-rel">
                    <input type="text" class="form-control"  id="orgName" value="" readonly/>
                        <input type="hidden"  name="appealOrgan" id="appealOrgan"/>
                        <span class="add-icon" id="selectDept">
                            <i></i>
                        </span>
                </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">证件类型：</label>
                    <div class="ipt-box col-4">
                        <select name="certType">
                        	<option value="1">身份证</option>
                        	<option value="2">统一信用代码</option>
                        	<option value="3">其他</option>
                        </select>
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">证件号码：</label>
                    <div class="col-4">
                        <input type="text" name="certNO" class="form-control" placeholder=""
                               value="">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">联系邮箱：</label>
                    <div class="col-4">
                        <input type="text" name="email" class="form-control" placeholder=""
                               value="">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">联系电话：</label>
                    <div class="col-4">
                        <input type="text" name="tel" class="form-control" placeholder=""
                               id="tel" value="">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label">手机验证码：</label>
                    <div class="col-1 mr5">
                        <input type="text" name="checkCode" class="form-control" placeholder=""
                               value="">
                    </div>
                    <button type="button" class="fl btn btn-ms mr5" id="sendMsg" >发送验证码</button>
<!--                     <button type="button" class="fl btn btn-ms disabled mr5">60s后重新发送</button> -->
<!--                     <button type="button" class="btn btn-ms">重新发送</button> -->
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">留言标题：</label>
                    <div class="col-9">
                        <input type="text" name="title" class="form-control" placeholder="" value="">
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">留言内容：</label>
                    <div class="col-9">
                        <div>
		                     <textarea rows="10" name="appealContent" class="form-textarea"></textarea>
                        </div>
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-3 control-label ">相关证明材料：</label>
                    <div class="col-9">
                        <div class="file-box mr5">
                            <span id="fileBox"><input type="file" id="btnFile" class="btnFile" name="btnFile"></span>
                            <iframe width="0" height="0" name="uploadframe"></iframe>
                            <input type="button" class="btn mr10" value="上传"/>
                        </div>
                        <input type="hidden" id="proveMaterial" class="clx" name="proveMaterial" value=""/>
                        <div class="filelabel">
<!--                         <span class="close-icon"></span> -->
                        </div>
                        <span id="uploadState" style="color:red;display:none">上传中....</span>
                    </div>
                </div>
                <div class="line-b"></div>
                <div class="center mt20">
                    <button id="save" type="submit" class="btn btn-sm mr20">提交</button>
                    <button id="reset" type="reset" class="btn btn-sm">重置</button>
                </div>
            </form>
        </div>
    </div></div></div>
<!-- 通用页面 -->
<jsp:include page="../../credit/system/common/common.jsp"/>
<script src="<c:url value='/js/credit/system/creditappeal_list.js'/>"></script>
<script>
window._CONFIG = {
        select_dept_url: '<c:url value="/credit/dept/enRadioTreeSelect"/>'
    }
</script>
</body>
</html>