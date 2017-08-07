<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信用临安</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/admin.css"/>"/>
</head>
<body>
<form id="questionnaireForm" class="form-box">
    <div class="form-list pdr30">
        <div class="form-item clearfix">
                <label class="item-name col-2">问题：</label>
                <div class="col-10">
                    <div class="ipt-box">
                        <input type="text" class="ipt-txt" id="problem" name="problem" value="${questionnaire.problem}"/>
                    </div>
                </div>
        </div>
        
<!--         <div class="form-item clearfix mr20"> -->
<!--       		  <div class="col-5"> -->
<!--                     <label class="item-name col-5"> 调研时间：</label> -->
<!--                     <div class="col-6"> -->
<!--                     	<div class="ipt-box col-575"> -->
<!--                             <input type="text" readonly="readonly" onclick="laydate();" name="surveyTimeStart" -->
<%--                                    class="ipt-txt clx" id="surveyTimeStart" value="<fmt:formatDate value="${questionnaire.surveyTimeStart}" pattern="yyyy-MM-dd"/>" > --%>
<!--                         </div> -->
<!--                         <span class="item-line col-05">-</span> -->
<!--                         <div class="ipt-box col-575"> -->
<!--                             <input type="text" readonly="readonly" onclick="laydate();" name="surveyTimeEnd" -->
<%--                                     class="ipt-txt clx" id="surveyTimeEnd" value="<fmt:formatDate value="${questionnaire.surveyTimeEnd}" pattern="yyyy-MM-dd"/>" > --%>
<!--                          </div> -->
<!--                      </div> -->
<!--                  </div> -->
<!-- 		</div> -->
        
        
        <div class="form-item clearfix">
            <label class="item-name col-2">选项：</label>
            <div class="col-10">
                <div class="ipt-box ml30">
                    <span class="num-tip">A</span>
                    <input type="text" class="ipt-txt" id="optionA" name="optionA" value="${questionnaire.optionA}"/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"></label>
            <div class="col-10">
                <div class="ipt-box ml30">
                    <span class="num-tip">B</span>
                    <input type="text"  class="ipt-txt" id="optionB" name="optionB" value="${questionnaire.optionB}"/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"></label>
            <div class="col-10">
                <div class="ipt-box ml30">
                    <span class="num-tip">C</span>
                    <input type="text"  class="ipt-txt" id="optionC" name="optionC" value="${questionnaire.optionC}"/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"></label>
            <div class="col-10">
                <div class="ipt-box ml30">
                    <span class="num-tip">D</span>
                    <input type="text"  class="ipt-txt" id="optionD" name="optionD" value="${questionnaire.optionD}"/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"></label>
            <div class="col-10">
                <div class="ipt-box ml30">
                    <span class="num-tip">E</span>
                    <input type="text"  class="ipt-txt" id="optionE" name="optionE" value="${questionnaire.optionE}"/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"></label>
            <div class="col-10">
                <div class="ipt-box ml30">
                    <span class="num-tip">F</span>
                    <input type="text"  class="ipt-txt" id="optionF" name="optionF" value="${questionnaire.optionF}"/>
                </div>
            </div>
        </div>
        <input type="hidden" id="uid" name="uid" value="${questionnaire.uid}">
        <input type="hidden" name="flag" id="flag" >
        <div class="pdt10 border-top ml40">
            <div class="center">
                <input type="button" id="submit" value="提交" class="btn mr20">
                <input type="button" id="publish" value="马上发布" class="btn mr20">
                <input type="button" id="cancel" value="取消" class="btn mr20">
            </div>
        </div>
    </div>
</form>
<jsp:include page="../../system/common/common.jsp"/>
<script src="<c:url value='/js/gateway/biz/backstage/questionnaire_survey_edit.js'/>"></script>
</body>
</html>