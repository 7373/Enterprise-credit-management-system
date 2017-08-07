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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/vendor/idangerous.swiper2.7.6.css"/>"/>
</head>
<body>
<jsp:include page="../common/gateway_header.jsp" />
    <div class="banner">
        <div class="xyla-nav-wrap">
            <div class="mark"></div>
            <jsp:include page="../common/gateway_menu.jsp" />
        </div>
    </div>

    <div class="message mb20">
<!--         <a href="javascript:void(0);"><i></i>截至2014年4月17日，存续企业26541家，注吊销企业23514家，已更新信用数据23514条</a> -->
    </div>

    <div class="wrapper">
        <div class="news mb20 clearfix">
            <div class="img-news fl">
                <div class="swiper-news">
                    <div class="swiper-wrapper clear">
                        <div class="swiper-slide">
                            <img src="/img/gateway/news-01.png" alt="图片加载失败">
                            <div class="bot-info">
                                <div class="mark"></div>
                                <p>我市与阿里集团信用体系建设合作会议召开</p>
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <img src="/img/gateway/news-01.png" alt="图片加载失败">
                            <div class="bot-info">
                                <div class="mark"></div>
                                <p>我市与阿里集团信用</p>
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <img src="/img/gateway/news-01.png" alt="图片加载失败">
                            <div class="bot-info">
                                <div class="mark"></div>
                                <p>我市与阿里集团信用</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="swipe-btn swipe-next"></div>
                <div class="swipe-btn swipe-prev"></div>
            </div>
            <div class="information fl">
                <a class="info-more" href="/gateway/reception/doEnCreditDynamic?menu=2">更多<i></i></a>
                <ul class="info-nav clearfix" id="play">
                    <li><a class="js-news-nav active" data-val="2000" href="javascript:void(0);">本地动态</a></li>
                    <li><a class="js-news-nav" data-val="2002" href="javascript:void(0);">省市动态</a></li>
                    <li><a class="js-news-nav" data-val="2003" href="javascript:void(0);">国家动态</a></li>
                </ul>
                <div class="swiper-info">
                    <div class="swiper-wrapper">
<!--                    本地动态---信用临安动态 /信用浙江动态/信用中国动态-->
                        <ul class="swiper-slide info-list" id="credit_la_list">
                        </ul>
                    </div>
                </div>
            </div>
            <div class="department fl">
                <div class="title"><i></i>部门公示</div>
                <ul class="list clearfix">
                    <li class="item-l"><a href="http://www.linan.gov.cn/hbj/" target="_blank">环保局</a></li>
                    <li class="item-r"><a href="http://www.linan.gov.cn/mzj/" target="_blank">民政局</a></li>
                    <li class="item-l"><a href="http://www.linan.gov.cn/scjgj/" target="_blank">市场监管局</a></li>
                    <li class="item-r"><a href="http://www.linan.gov.cn/czj/" target="_blank">财政局</a></li>
                    <li class="item-l"><a href="http://www.linan.gov.cn/gtzyj/" target="_blank">国土资源局</a></li>
                    <li class="item-r"><a href="http://www.linan.gov.cn/nlj/" target="_blank">农林局</a></li>
                    <li class="item-l"><a href="http://www.linan.gov.cn/ghjsj/" target="_blank">规划建设局</a></li>
                    <li class="item-r"><a href="http://www.linan.gov.cn/jtj/" target="_blank">交通运输局</a></li>
                    <li class="item-l"><a href="http://www.linan.gov.cn/slsdj/" target="_blank">水利水电局</a></li>
                </ul>
            </div>
        </div>
        <div class="enterprise-search mb20">
            <form action="" class="s-form clearfix">
                <input id="searchparam" type="text" class="s-txt fl" placeholder="输入完整企业名称\统一信用代码\注册码查询企业信用情况" onfocus="this.placeholder=''" onblur="this.placeholder='输入完整企业名称\统一信用代码\注册码查询企业信用情况'"/>
                <input id="search" type="button" class="s-btn fr" value="搜索"/>
            </form>
        </div>
        <div class="article mb20">
            <div class="top-item mb20 clearfix">
                <div class="item mr20">
                    <div class="title">
                        <h2 class="fl">七天双公示</h2>
                        <div class="more fr"><a href="/gateway/reception/doEnPublishPlatform?menu=6&item=Double">更多<i></i></a></div>
                    </div>
                    <ul class="list" id="seven_double_list" >
                    </ul>
                </div>
                <div class="item mr20">
                    <div class="title">
                        <h2 class="fl">信用红名单</h2>
                        <div class="more fr"><a href="gateway/reception/doEnPublishPlatform?menu=6&item=Red">更多<i></i></a></div>
                    </div>
                    <ul class="list" id="credit_red_list" >
                    </ul>
                </div>
                <div class="item">
                    <div class="title">
                        <h2 class="fl">信用黑名单</h2>
                        <div class="more fr"><a href="gateway/reception/doEnPublishPlatform?menu=6&item=Black">更多<i></i></a></div>
                    </div>
                    <ul class="list" id="credit_black_list" >
                    </ul>
                </div>
            </div>
            <div class="bot-item clearfix">
                <div class="item mr20">
                    <div class="title">
                        <h2 class="fl">政策法规</h2>
                        <div class="more fr"><a href="/gateway/reception/doEnPolicyRule?menu=3">更多<i></i></a></div>
                    </div>
                    
                    <ul class="list" id="policy_rule_list">
                    </ul>
                </div>
                <div class="item mr20">
                    <div class="title">
                        <h2 class="fl">信用研究</h2>
                        <div class="more fr"><a href="/gateway/reception/doEnCreditResearch?menu=4" >更多<i></i></a></div>                    </div>
                    <ul class="list" id="credit_research_list">
                    </ul>
                </div>
                
                <div class="item investigate">
                    <div class="title">
                        <h2>在线调查</h2>
                    </div>
                    <div class="list" id="questionnaire">
                    
                    </div>
                </div>
            </div>
        </div>
        <div class="blogroll mb20">
            <div class="title mb20"><h3>友情链接</h3></div>
            <ul class="list clearfix">
                <li><a href="http://www.creditchina.gov.cn/" target="_blank">
                    <img src="/img/gateway/blogroll-01.png" alt="信用中国">
                </a></li>
                <li><a href="http://www.zjcredit.gov.cn/" target="_blank">
                    <img src="/img/gateway/blogroll-02.png" alt="信用浙江">
                </a></li>
                <li><a href="http://www.zj.gov.cn/" target="_blank">
                    <img src="/img/gateway/blogroll-03.png" alt="浙江省人民政府">
                </a></li>
                <li><a href="http://www.zjzwfw.gov.cn/" target="_blank">
                    <img src="/img/gateway/blogroll-04.png" alt="浙江政府服务网">
                </a></li>
                <li><a href="http://wang65685.qiyegongqiu.net/" target="_blank">
                    <img src="/img/gateway/blogroll-05.png" alt="临安发改委">
                </a></li>
            </ul>
        </div>
        <div class="web-select">
            <div class="nice-select nice-select01 mr20" name="nice-select">
                <input type="text" value="国内信用网站" readonly>
                <ul class="ul01">
                    <li><a href="http://qyxy.baic.gov.cn/" target="_blank">北京市</a></li>
                    <li><a href="http://www.nmxygl.com/" target="_blank">内蒙古自治区</a></li>
                    <li><a href="http://www.lncredit.gov.cn/" target="_blank">辽宁省</a></li>
                    <li><a href="http://www.hljcredit.gov.cn/" target="_blank">黑龙江省</a></li>
                    <li><a href="http://www.shcredit.gov.cn/" target="_blank">上海市</a></li>
                    <li><a href="http://www.jsxyxh.com/" target="_blank">江苏省</a></li>
                    <li><a href="http://www.zjcredit.gov.cn/" target="_blank">浙江省</a></li>
                    <li><a href="http://www.creditah.gov.cn/" target="_blank">安徽省</a></li>
                    <li><a href="http://www.zxpg.com/" target="_blank">河南省</a></li>
                    <li><a href="http://www.hncredit.gov.cn/" target="_blank">湖南省</a></li>
                    <li><a href="http://www.gdcredit.gov.cn/IndexAction!getList.do" target="_blank">广东省</a></li>
                    <li><a href="http://www.hixypj.com/" target="_blank">海南省</a></li>
                    <li><a href="http://www.cqcredit.cn/" target="_blank">重庆市</a></li>
                    <li><a href="http://www.gzcredit.gov.cn/" target="_blank">贵州省</a></li>
                    <li><a href="http://www.sxcredit.gov.cn/" target="_blank">陕西省</a></li>
                    <li><a href="http://www.gscredit.gov.cn/" target="_blank">甘肃省</a></li>
                    <li><a href="http://www.qhsxyw.cn/" target="_blank">青海省</a></li>
                    <li><a href="http://www.xjhxcredit.com/" target="_blank">新疆维吾尔自治区</a></li>
                    <li><a href="http://www.szcredit.com.cn/web/index.html" target="_blank">深圳市</a></li>
                    <li><a href="http://www.nncredit.gov.cn/" target="_blank">南宁市</a></li>
                </ul>
            </div>
            <div class="nice-select nice-select02 mr20" name="nice-select">
                <input type="text" value="省内信用网站" readonly>
                <ul class="ul02">
                    <li><a href="http://www.zjcredit.gov.cn/" target="_blank">浙江省</a></li>
                    <li><a href="http://www.nbcredit.gov.cn/index.html" target="_blank">宁波市</a></li>
                    <li><a href="http://www.wzcredit.gov.cn/" target="_blank">温州市</a></li>
                    <li><a href="http://www.jxcredit.gov.cn/" target="_blank">嘉兴市</a></li>
                    <li><a href="http://www.sxscredit.gov.cn/" target="_blank">绍兴市</a></li>
                    <li><a href="http://www.tzcredit.gov.cn/" target="_blank">台州市</a></li>
                </ul>
            </div>
            <div class="nice-select nice-select03" name="nice-select">
                <input type="text" value="区县信用网站" readonly>
                <ul class="ul03">
                    <li><a href="http://gk.jiande.gov.cn/new_xxgk/zdlygk/" target="_blank">建德市政府信息公开</a></li>
                    <li><a href="http://www.hedajfj.gov.cn/col/col1303/index.html" target="_blank">信用下沙</a></li>
                    <li><a href="http://www.qdh.gov.cn/col/col1293564/index.html" target="_blank">信用淳安</a></li>
                    <li><a href="http://120.26.246.202:8080/" target="_blank">信用富阳</a></li>
                    <li><a href="http://www.linan.gov.cn/xxgk/ztzl/xyla/" target="_blank">浙江临安</a></li>
                    <li><a href="http://www.hhtz.gov.cn/col/col813/index.html" target="_blank">信用滨江</a></li>
                    <li><a href="http://www.hzxh.gov.cn/col/col1229464/index.html" target="_blank">信用西湖</a></li>
                    <li><a href="http://www.gongshu.gov.cn/col/col1243340/index.html?key" target="_blank">信用拱墅</a></li>
                    <li><a href="http://hzjg.zj.gov.cn/col/col1256493/index.html" target="_blank">信用江干</a></li>
                    <li><a href="http://www.hzxc.gov.cn/pub/xczwz/xyxc/hhmd/" target="_blank">信用下城</a></li>
                    <li><a href="http://www.shangcheng.gov.cn/col/col1267813/index.html" target="_blank">信用上城</a></li>
                    <li><a href="https://www.baidu.com/" target="_blank">信用余杭</a></li>
                    <li><a href="http://www.xsecredit.org.cn/" target="_blank">信用萧山</a></li>
                </ul>
            </div>
        </div>
    </div>

<!-- 政策法规 -->
<script id="policy_rule_li_list" type="text/x-handlebars-template">
    {{#each data}}
    <li><a href="/gateway/reception/publish/getPublishDetail?menu=3&item={{type2Code}}&uid={{uid}}" class="headTitle" linkUID="{{UID}}" >
	<i></i>{{title}}</a> <span>{{publishTime}}</span></li>
    {{/each}}
</script>
<!-- 信用研究 -->
<script id="credit_research_li_list" type="text/x-handlebars-template">
    {{#each data}}
    <li><a href="/gateway/reception/publish/getPublishDetail?menu=4&item={{type2Code}}&uid={{uid}}" class="headTitle" linkUID="{{UID}}" >
	<i></i>{{title}}</a> <span>{{publishTime}}</span></li>
    {{/each}}
</script>
<!-- 信用动态 -->
<script id="credit_dynamic_li_list" type="text/x-handlebars-template">
    {{#each data}}
    <li><a href="/gateway/reception/publish/getPublishDetail?menu=2&item={{type2Code}}&uid={{uid}}" class="headTitle" linkUID="{{UID}}" >
	<i></i>{{title}}</a> <span>{{publishTime}}</span></li>
    {{/each}}
</script>
<!-- 七天双公示 -->
<script id="seven_double_li_list" type="text/x-handlebars-template">
	{{#each data}}
	<li>
	<a href="/gateway/reception/ndlicense/getSevenDoubleListDetail?menu=6&item=Double&uid={{uid}}&type={{type}}&name={{entName}}" class="headTitle" linkUID="{{UID}}"><i></i>【{{type}}】{{entName}}</a>
	<span>{{inputDate}}</span>
	</li>
	{{/each}}
</script>
<!-- 信用红名单 -->
<script id="credit_red_li_list" type="text/x-handlebars-template">
    {{#each data}}
    <li><a href="javascript:void(0)" partyName={{partyName}} class="headTitle red" linkUID="{{UID}}" >
	<i></i>{{partyName}}</a> <span>{{occurrDate}}</span></li>
    {{/each}}
</script>
<!-- 信用黑名单 -->
<script id="credit_black_li_list" type="text/x-handlebars-template">
    {{#each data}}
    <li><a href="javascript:void(0)" id="{{uid}}" partyName={{partyName}} class="headTitle black" linkUID="{{UID}}" >
	<i></i>{{partyName}}</a> <span>{{occurrDate}}</span></li>
    {{/each}}
</script>
<script id="questionnaire_li" type="text/x-handlebars-template">
<p class="problem">{{problem}}?</p>
<form id="surveyForm" >
  <ul class="choice-list" id="radioSelected">
	<input type="hidden" name="ProblemID" value="{{uid}}">
    <li><input type="radio" name="radio" id="optionA" value="optionA"/><label>A {{optionA}}</label></li>
    <li><input type="radio" name="radio" id="optionB" value="optionB"/><label>B {{optionB}}</label></li>
    {{#if optionC}}<li><input type="radio" id="optionC" name="radio" value="optionC"/><label>C {{optionC}}</label></li>{{/if}}
    {{#if optionD}}<li><input type="radio" id="optionD" name="radio" value="optionD"/><label>D {{optionD}}</label></li>{{/if}}
    {{#if optionE}}<li><input type="radio" id="optionE" name="radio" value="optionE"/><label>E {{optionE}}</label></li>{{/if}}
    {{#if optionF}}<li><input type="radio" id="optionF" name="radio" value="optionF"/><label>F {{optionF}}</label></li>{{/if}}
  </ul>
  <div class="choice-btn">
     <input type="button" id="surveySubmit" value="提交" class="mr20"/>
     <input type="button" value="查看" uid={{uid}} id="showbar"/>
  </div>
</form>
</script>

<!-- 通用页面 -->
<jsp:include page="../common/gateway_footer.jsp"/>
<script src="<c:url value='/js/lib/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script src="<c:url value='/js/gateway/biz/reception/index.js'/>"></script>
</body>

</html>