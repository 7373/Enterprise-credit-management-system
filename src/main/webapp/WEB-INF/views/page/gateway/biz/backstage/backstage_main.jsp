<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/admin.css"/>"/>
<div class="clearfix pd20">
    <%--<div class="fl echarts-box"></div>--%>
    <div class="fl"  style=" width:100%">
        <div class="table-out">
            <table style="margin: auto" id="scene-table" border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap"
                   width="50%">
                <thead>
                <tr>
                    <th style="padding: 0 20px;">序号</th>
                    <th width="35%">栏目</th>

                    <th width="30%">信息条目数</th>

                    <th >最新更新日期</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>信用动态</td>
                    <td>${ndCountCatalog.countCreditDynamic }</td>
                    <td><fmt:formatDate value="${ndCountCatalog.timeCreditDynamic }" pattern="yyyy-MM-dd"/></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>政策法规</td>
                    <td>${ndCountCatalog.countPolicy }</td>
                    <td><fmt:formatDate value="${ndCountCatalog.timePolicy }" pattern="yyyy-MM-dd"/></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>信用研究</td>
                    <td>${ndCountCatalog.countCreditRule }</td>
                    <td><fmt:formatDate value="${ndCountCatalog.timeCreditRule }" pattern="yyyy-MM-dd"/></td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>视频资料</td>
                    <td>${ndCountCatalog.countVideo }</td>
                    <td><fmt:formatDate value="${ndCountCatalog.timeVideo }" pattern="yyyy-MM-dd"/></td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>七天双公示</td>
                    <td>${ndCountCatalog.countSevenDouble }</td>
                    <td><fmt:formatDate value="${ndCountCatalog.timeSevenDouble }" pattern="yyyy-MM-dd"/></td>
                </tr>
                <tr>
                    <td>6</td>
                    <td>信用红名单</td>
                    <td>${ndCountCatalog.countRedList }</td>
                    <td><fmt:formatDate value="${ndCountCatalog.timeRedList}" pattern="yyyy-MM-dd"/></td> 
                </tr>
                <tr>
                    <td>7</td>
                    <td>信用黑名单</td>
                    <td>${ndCountCatalog.countBlackList }</td>
                    <td><fmt:formatDate value="${ndCountCatalog.timeBlackList}" pattern="yyyy-MM-dd"/></td> 
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>