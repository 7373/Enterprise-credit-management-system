require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate', 'pagination'], function (layer, dataTable, util, http, handlebars) {

	
    init();

    /**
     * 初始化函数集合
     */
    var uid = $("#uid").val();
    var pagename;
    function init() {
    	load();
        bind();
    }

    function load(){
    	$('.cont-title-text').html($('.nav-cur span').text());
    	pagename = buildPage(uid);
        $("#main").empty();
        $("#main").load(pagename);
    }
    
    function buildPage(uid){
    	if(uid != ''){
    		return "/gateway/reception/doEnCredit"+$('.nav-cur').attr("value")+"?type=" + $('#type').val() + "&uid=" + $('#uid').val()+"&name="+$('#name').val();
    	}else{
    		return "/gateway/reception/doEnCredit"+$('.nav-cur').attr("value")+"?type=" + $('#type').val();
    	}
    }
    function bind() {
        util.bindEvents([{
            el: $('.js-nav-list a'),
            event: 'click',
            handler: function () {
                $('.js-nav-list a').removeClass('nav-cur');
                $(this).addClass('nav-cur');
                $('.cont-title-text').html($('.nav-cur span').text());
                $("#uid").val("");
                uid = $("#uid").val();
                pagename = buildPage(uid);
                $("#main").empty();
                $("#main").load(pagename);
            }
        }])
    }

})