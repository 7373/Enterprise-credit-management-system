<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户授权</title>
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/credit/credit.css'/>">
</head>
<body>
<div class="main msgshow">
    <form id="submitForm" method="post">
		 <input type="hidden"  name="id"  value="${ndGrant.id}" />
        <input type="hidden" id="corpidOrSfzjhm" name="corpidOrSfzjhm"  value="${ndGrant.corpidOrSfzjhm}" />
        <input type="hidden" id="ndGrant.uid" name="uid"  value="${ndGrant.uid}" />
        <input type="hidden" id="graUserID" name="graUserID"  value="${ndGrant.graUserID}" />
        <input type="hidden" name="graIsDel" value="0" />

        <table class="tablebox">
            <tr>
                <th width="140">授权人姓名：</th>
                <td width="320"><input type="text" id="graUserName" name="graUserName" value="${ndGrant.graUserName}" disabled="disabled" size="40"/></td>
                <td></td>
            </tr>
            <tr>
                <th width="140">授权类型：</th>
                <td width="320">
                    <c:if test="${ndGrant.id==null}">
                        <select id="graType" name="graType">
                            <option id="company" value="0">企业</option>
                            <option id="people" value="1" ${ndGrant.graType=='1' ?'selected':''}>个人</option>
                        </select>
                    </c:if>
                    <c:if test="${ndGrant.id!=null}">
                        <select id="graType" name="graType" disabled="disabled">
                            <option id="company" value="0">企业</option>
                            <option id="people" value="1" ${ndGrant.graType=='1' ?'selected':''}>个人</option>
                        </select>
                    </c:if>
                </td>
                <td></td>
            </tr>
            <!-- 企业 /个人-->
            <tr>
                <th class="company">授权企业名称：</th>
                <th class="people" style="display: none">授权个人姓名：</th>
                <td>
                    <c:if test="${ndGrant.id==null}">
                        <input type="text" id="graName" name="graName" value="${ndGrant.graName}"  size="40"/>
                    </c:if>
                    <c:if test="${ndGrant.id!=null}">
                        <input type="text" id="graName" name="graName" value="${ndGrant.graName}"  size="40" disabled="disabled"/>
                    </c:if>
                </td>
                <td rowspan="2">
                    <c:if test="${ndGrant.id==null}">
                        <input type="button" id="check" value="校  验" class="btn" />
                    </c:if>
                </td>
            </tr>
            <tr>
                <th class="company">授权企业注册号：</th>
                <th class="people" style="display: none">授权个人证件号：</th>
                <td>
                    <c:if test="${ndGrant.id==null}">
                        <input type="text" id="graNo" name="graNo" value="${ndGrant.graNo}" size="40" />
                    </c:if>
                    <c:if test="${ndGrant.id!=null}">
                        <input type="text" id="graNo" name="graNo" value="${ndGrant.graNo}" size="40" disabled="disabled"/>
                    </c:if>
                </td>
            </tr>

            <tr>
                <th>授权开始日期：</th>
                <td><input type="text" id="graStartLine" name="graStartLine"
                           value="${ndGrant.graStartLine}" onclick="laydate()" readonly="readonly" style="width:154px;height:26px;" /></td>
                <td></td>
            </tr>

            <tr>
                <th>授权截止日期：</th>
                <td><input type="text" id="graDeadLine" name="graDeadLine"
                           value="${ndGrant.graDeadLine}" onclick="laydate()" readonly="readonly" style="width:154px;height:26px;" /></td>
                <td></td>
            </tr>
        </table>
        <div class="btnCenter">
            <input type="button" id="save" value="提交" class="btn"/>
            <input type="button" id="cancel" value="取消" class="btn"/>
        </div>
    </form>
</div>
<script src="<c:url value='/js/lib/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script src="<c:url value='/js/credit/system/grant/credit_grant_edit.js'/>"></script>
</body>
</html>