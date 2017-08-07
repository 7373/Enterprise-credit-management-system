require([ 'common/util', 'common/http', 'jquery', 'jquery.serialize'], function (util, http ) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }

    function bind() {
        util.bindEvents([{
            el: '.js-nav-list a',
            event: 'click',
            handler: function () {
                $('.js-nav-list a').removeClass('nav-cur');
                $(this).addClass('nav-cur');
                $('.cont-title-text').html($('.nav-cur span').text());
                var type =$(this).attr("val");
                $("#main").empty();
                $("#main").load("/gateway/reception/"+type);
            }
        }])
    }

})