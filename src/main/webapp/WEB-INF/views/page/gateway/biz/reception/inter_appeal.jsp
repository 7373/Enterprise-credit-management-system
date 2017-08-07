<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<form id="appealForm">
    <div class="credit-info pl15">
        <ul>
            <input type="hidden" name="appealSource" value="1">
            <li><label class="w-131">申述人/企业/机构名称：</label><input name="appealName" class="w-600" type="text"></li>
            <li>
                <label class="w-131 vertical10">申述机构：</label><div class="select-box">
                <div class="col-4 pos-rel">
                    <input type="text" class="form-control"  id="orgName" value="" readonly/>
                        <input type="hidden"  name="appealOrgan" id="appealOrgan"/>
                        <span class="add-icon" id="selectDept">
                            <i></i>
                        </span>
                </div>
            </div>

            </li>
            <li>
                <label class="w-131 vertical10">证件类型：</label><div class="select-box">
                <select name="certType" class="select">
                    <option value="1">身份证</option>
                    <option value="2">统一信用代码</option>
                    <option value="3">其他</option>
                </select>
            </div>

            </li>
            <li><label class="w-131">证件号码：</label><input name="certNO" type="text"></li>
            <li><label class="w-131">联系邮箱：</label><input name="email" type="text"></li>
            <li><label class="w-131">联系电话：</label><input name="tel" type="text" id="managerTel"></li>
            <li>
                <label class="w-131">手机验证码：</label>
                <input name="checkCode" class="w-70" type="text" >
                <a class="btn-mad btn-bg-bule" href="javascript:void(0);" id="sendMsg" >发送验证码</a>
<!--                 <a class="btn-mad w-100 btn-bg-disable" href="javascript:void(0);">60S后重新发送</a> -->
<!--                 <a class="btn-mad btn-bg-bule" href="javascript:void(0);">重新发送</a> -->
            </li>

            <li><label class="w-131"><span>*</span>留言标题：</label><input name="title" class="w-600" type="text"></li>
            <li><label class="w-131"><span>*</span>留言内容：</label><textarea name="appealContent" class="textarea-message" rows="10"></textarea></li>
            <li>
                <label class="w-131">相关证明材料：</label>
                <div class="file-box">
                    <input type="button" class="upload btn-mad w-60 btn-bg-bule" value="上传">
                    <span id="fileBox">
                        <input type="file" id="btnFile" class="file" name="btnFile">
                    </span>
                    <iframe width="0" height="0" name="uploadframe"></iframe>
                    <div class="filelabel">
                    </div>
                    <span id="uploadState" class="upload-state">上传中....</span>
                </div>
                <input type="hidden" id="proveMaterial" class="clx" name="proveMaterial" value=""/>
            </li>

        </ul>
    </div>
<!--     <p class="center notice mb10"><input type="checkbox" id="checkbox">同意<a href="#">《留言须知》</a></p> -->
    <div class="error" id="errorContainer" style="color: red"></div>
<!--     <div class="line-b"></div> -->
    <div class="center mt20">
        <button id="save" type="submit" class="btn btn-sm mr20">提交</button>
        <button id="reset" type="reset" class="btn btn-sm">重置</button>
    </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value='/js/gateway/biz/reception/inter_appeal.js'/>"></script>
<script>
window._CONFIG = {
        select_dept_url: '<c:url value="/gateway/reception/dept/enRadioTreeSelect"/>'
    }
</script>
</body>
</html>