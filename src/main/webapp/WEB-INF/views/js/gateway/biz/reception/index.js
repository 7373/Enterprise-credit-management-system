require(
    [ 'component/iframeLayer', 'component/dataTable', 'common/util',
        'common/http', 'common/busUtil', 'handlebars', 'jquery',
        'jquery.serialize', 'laydate','swiper','placeholder' ],
    function(layer, dataTable, util, http, busUtil, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	//页面从上往下
    	creditDynamic(2000);//信用临安动态
    	SevenDouble();
    	CreditRedList();//信用红名单
    	CreditBlackList();//信用黑名单
    	lawsAndRegulations();//政策法规
    	creditResearch();//信用研究
    	Questionnaire();//在线调查
        bind();

    }

    
    //模拟select下拉框
    $('.nice-select01').click(function(e){
        $(this).find('ul').toggle();
        $('.ul02').hide();
        $('.ul03').hide();
        e.stopPropagation();
    });
    $('.nice-select02').click(function(e){
        $(this).find('ul').toggle();
        $('.ul01').hide();
        $('.ul03').hide();
        e.stopPropagation();
    });
    $('.nice-select03').click(function(e){
        $(this).find('ul').toggle();
        $('.ul02').hide();
        $('.ul01').hide();
        e.stopPropagation();
    });
    $(document).click(function(){
        $('.nice-select ul').hide();
    });

    //新闻动态tab切换
    $(".js-news-nav").on('click',function () {
        $(".js-news-nav").removeClass("active");
        $(this).addClass("active");
        var navSwiper = new Swiper('.swiper-info', {
            //只能使用扩展API函数改变slides滑动
            onlyExternal: true,
            //滑动方向，可设置水平(horizontal)或垂直(vertical)。
            mode: 'horizontal'
            	
        });
        navSwiper.swipeTo($(this).data('val'), 300, false);
        var val = $(this).attr("data-val");
        creditDynamic(val);//本地动态
        //省市动态
        //国家动态
    });


    //图片新闻-图片轮播切换
    var mySwiper = new Swiper('.swiper-news',{
        onlyExternal : true,
        speed: 500
    });
    $('.swipe-prev').click(function(){
        mySwiper.swipePrev();
    });
    $('.swipe-next').click(function(){
        mySwiper.swipeNext();
    });

    //ie低版本兼容placeholder
    $('.s-txt').placeholder();
   
    /**
     * 问卷调查
     * @returns
     */
    function Questionnaire(){
    	
    	var params = {publishState : "1"};
    	http.httpRequest({
			url: '/gateway/reception/questionnaire/doGetQuestionnaireSurvey',
			data:{params: params},
			success: function(data){
				var myTemplate = handlebars.compile($("#questionnaire_li").html());
                $('#questionnaire').html(myTemplate(data.data));
                //柱状图的查看
                var uid = $("#showbar").attr("uid");//获取所要显示问卷调查的uid
                $("#showbar").bind("click",function(){
                    layer.dialog({
                        title : '问卷统计',
                        area : [ '800px', '700px' ],
                        content : '/gateway/reception/surveyresult/doEnBarGraph?uid='+uid,
                        callback : function(data) { }
                    })
                });
                $("#surveySubmit").bind("click",function(){
                	var radioSelected = $('#radioSelected input[name="radio"]:checked ').val();//获取单选选中的value值
                	//未选中选项提示
                	if(radioSelected == null || radioSelected == ""){
                		layer.msg("请选择所投问题选项!", {time: 5000}, function () {});
                		return;
                	}
                	http.httpRequest({
                        url: '/gateway/reception/surveyresult/save',
                        data: {'option':radioSelected,'uid':uid},
                        success: function (data) {
                            layer.msg(data.msg, {time: 1000}, function () {
                                layer.close({reload: true});
                            });
                        }
                    })
                });
			}
    	});
    }
    
    
    /**
     * 信用红名单
     * @returns
     */
    function CreditRedList(){
    	var params = {listType: "r"};
        http.httpRequest({
            url: '/gateway/reception/redBlackList/data.json',
            data: {params: params},
            async:false,//false为同步,默认为true(异步)
            success: function (data) {
            	var myTemplate = handlebars.compile($("#credit_red_li_list").html());
                $('#credit_red_list').html(myTemplate(data));
            	$(".red").click(function(){ 
            		window.location.href="/gateway/reception/redBlackList/getRedBlackListDetail?menu=6&item=Red&uid="+this.id+"&name="+ $(this).attr("partyName");
            	});
            }
        });
    }
    
    /**
     * 信用黑名单
     * @returns
     */
    function CreditBlackList(){
    	var params = {listType: "b"};
        http.httpRequest({
            url: '/gateway/reception/redBlackList/data.json',
            data: {params: params},
            async:false,//false为同步,默认为true(异步)
            success: function (data) {
            	var myTemplate = handlebars.compile($("#credit_black_li_list").html());
            	$('#credit_black_list').html(myTemplate(data));
            	$(".black").click(function(){
            		window.location.href="/gateway/reception/redBlackList/getRedBlackListDetail?menu=6&item=Black&uid="+this.id+"&name="+$(this).attr("partyName");
            	});
            }
        });
    }
    
    function SevenDouble(){
    	http.httpRequest({
    		url: '/gateway/reception/ndlicense/doubleList',
    		data: {start: 0, length: 10},
    		async:false,//同步
    		success: function(data){
    			var myTemplate = handlebars.compile($("#seven_double_li_list").html());
    			$('#seven_double_list').html(myTemplate(data));
    		}
    	});
    }
    
    
    /**
     * 政策法规
     * @returns
     */
    function lawsAndRegulations(){
    	var params = {type1Code: 1001};
        http.httpRequest({
            url: '/gateway/reception/publish/getCreditDynamic',
            data: {start: 0, length: 10,params: params},
            async:false,//false为同步,默认为true(异步)
            success: function (data) {
            	var myTemplate = handlebars.compile($("#policy_rule_li_list").html());
                $('#policy_rule_list').html(myTemplate(data));
            }
        });
    }

    /**
     * 信用研究
     * @returns
     */
    function creditResearch(){
    	var params = {type1Code: 1002};
        http.httpRequest({
            url: '/gateway/reception/publish/getCreditDynamic',
            data: {start: 0, length: 10,params: params},
            async:false,//false为同步,默认为true(异步)
            success: function (data) {
            	var myTemplate = handlebars.compile($("#credit_research_li_list").html());
                $('#credit_research_list').html(myTemplate(data));
                
            }
        });
    }
    
    /**
     * 信用临安动态
     * @returns
     */
    function creditDynamic(code){
    	var params = {type2Code: code};
        http.httpRequest({
            url: '/gateway/reception/publish/getCreditDynamic',
            data: {start: 0, length: 10,params: params},
            async:false,//false为同步,默认为true(异步)
            success: function (data) {
                var myTemplate = handlebars.compile($("#credit_dynamic_li_list").html());
                $('#credit_la_list').html(myTemplate(data));
            }
        });
    }
    
    function bind() {
        util.bindEvents([{
            el: '.js-logout',
            event: 'click',
            handler: function () {
                logOut();
            }
        },{
            el: '#search',
            event: 'click',
            handler: function () {
                var searchparam = $.trim($("#searchparam").val());
                if(!searchparam){
                    layer.msg("查询条件不能为空！", {time: 1000}, function () { });
                    return;
                }
                window.open("gateway/reception/doEnCreditSearch?menu=5&searchparam="+searchparam);
            }
        }
        ])
    }

})