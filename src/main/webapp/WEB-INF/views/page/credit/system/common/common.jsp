<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    // 定义全局变量
    window.__FRAMEWORK__ = {
        // 根路径
        root_url: "<c:url value='/' />".split(';')[0]
    };
</script>
<script src="<c:url value='/js/lib/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
