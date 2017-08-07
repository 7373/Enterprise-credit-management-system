require(['component/iframeLayer', 'common/util', 'jquery.layout', 'jquery.nanoscroller'], function (layer, util) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        layoutInit();
        bind();
        calcHeight();
         //$(".nano").nanoScroller();
    }

    /**
     * 页面布局初始化
     */
    function layoutInit() {
        $('#container').layout({
            west: {
                size: '200',
                spacing_open: 8
            },
            north: {
                spacing_open: 0
            }
        });
    }

    /**
     * 计算iframe主体高度
     */
    function setHeight() {
        var h = $(window).height();
        $('.J_mainContent').css('height', h - $('.J_mainContent').offset().top - 74  + 'px');
    }

    function calcHeight() {
        setHeight();
        $(".nano").nanoScroller();
         window.onresize = function () {
            setHeight();
             setTimeout(function () {
                $(".nano").nanoScroller();
             }, 500);

         };
    }

    function bind() {
        util.bindEvents([{
            el: '.js-logout',
            event: 'click',
            handler: function () {
                logOut();
            }
        }, {
            el: '.J_menuItem',
            event: 'click',
            handler: function () {
                $('.sidebar .J_menuItem').removeClass('cur');
                $(this).addClass('cur');
                var href = $(this).attr('data-href');
                $('.J_iframe').attr('src',href);
            }
        },{
        	el:'.js-logo',
        	event:'click',
        	handler:function(){
                window.location.reload();
        		 /*$('.sidebar .J_menuItem').removeClass('cur');
                 $('.J_iframe').attr('src','/admin/audit/welcome');*/
        	}
        }
      ,{
    	el:'.modify-pwd',
    	event:'click',
    	handler:function(){
    		layer.dialog({
                title: '修改密码',
                area: ['900px', '500px'],
                content: '/credit/system/sysuser/enEditPass' ,
                callback: function (data) {
                    if (data.reload) {
                    	 parent.location.href='/xylogin';
                    }
                }
            })
    	}}])
    }

    function logOut() {
        layer.confirm('确定要退出登录吗?', {icon: 3, title: '提示'}, function () {
            location.assign('/credit/admin/logout');
        });
    }
})