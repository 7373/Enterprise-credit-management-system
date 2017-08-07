<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>信用临安</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/gateway.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/gateway/video-js.css"/>"/>
    <script src="/js/lib/video/video.min.js"></script>
</head>
<div>
    <video id="my_video_1" class="video-js vjs-default-skin" controls preload="auto"width="640"height="480" style="margin-left:10px;margin-top:3px;"   data-setup="{}">
        <source src="${filePath}" type='video/mp4'>
    </video>
</div>
<body>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/pagination/jquery.pagination.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
</body>
</html>