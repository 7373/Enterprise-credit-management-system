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
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
</head>
<body>
<body>
<c:if test="${ndCreditAppeal.endState==1 }">
	<form id="formData">
	<input type="hidden" id="uid" name="uid" value="${uid }">
	<div class="form-item clearfix">
		<div class="form-item clearfix mr20">
			<div class="col-6">
		      <label class="item-name col-4">处理结果：&nbsp;</label>
		      <div class="col-7">
		            <div class="ipt-box">
		                <select name="handleResult" style="margin-left: 20px;width:200px">
		                    <option value="信息无误">信息无误</option>
		                    <option value="处理完成">处理完成</option>
		                </select>
		            </div>
		        </div>
		      </div>
		</div>
	    <div class="mt15">
	    	<div class="col-6">
			 <label class="item-name col-4 mr20">备注：&nbsp;</label>
		      <div class="col-7">
		            <div class="ipt-box" style="margin-left: 17px;">
		                <textarea rows="5" cols="20" name="handleRemark" 
		                style="width:194px;"></textarea>
		            </div>
		        </div>
			</div>
	    </div>
	</div>
	
	<div class="mt15">
	    <div class="center">
			<input type="button" id="confirm" value="确认" class="btn mr20">
	        <input type="reset" id="cancel" value="取消" class="btn ">
		</div>
	</div>
</form>
</c:if>
<c:if test="${ndCreditAppeal.endState==2 }">
	<form id="formData">
	<div class="form-item clearfix">
		<div class="form-item clearfix mr20">
			<div class="col-6">
		      <label class="item-name col-4">处理结果：&nbsp;</label>
		      <div class="col-7">
		            <div class="ipt-box">
		                <select name="handleResult" style="margin-left: 20px;width:200px" disabled="disabled">
		                    <option value="${ndCreditAppeal.handleResult }">${ndCreditAppeal.handleResult }</option>
		                </select>
		            </div>
		        </div>
		      </div>
		</div>
	    <div class="mt15">
	    	<div class="col-6">
			 <label class="item-name col-4 mr20">备注：&nbsp;</label>
		      <div class="col-7">
		            <div class="ipt-box" style="margin-left: 17px;">
		                <textarea rows="5" cols="20" name="handleRemark" 
		                style="width:194px;" readonly>${ndCreditAppeal.handleRemark }</textarea>
		            </div>
		        </div>
			</div>
	    </div>
	</div>
	
	<div class="mt15">
	    <div class="center">
<!-- 			<input type="button" id="confirm" value="确认" class="btn mr20"> -->
		</div>
	</div>
</form>
</c:if>
</body>
<jsp:include page="../../credit/system/common/common.jsp"/>
<script type="text/javascript" src='<c:url value="/js/credit/system/feedback.js"/>'></script>
</html>