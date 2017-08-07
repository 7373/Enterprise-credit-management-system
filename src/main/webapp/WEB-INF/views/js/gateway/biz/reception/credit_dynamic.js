require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate', 'pagination'], function (layer, dataTable, util, http, handlebars) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        build(0, 10);
        bind();
    }

    function build(page, length, callback) {
        var type = $(".nav-cur").attr("type");
        var params = {type2Code: type};
        http.httpRequest({
            url: '/gateway/reception/publish/getCreditDynamic',
            data: {start: page * length, length: length, params: params},
            success: function (data) {
                var itemCount = data.recordsTotal;
                if (itemCount != 0) {
                    $("#pageforhide").show();
                    $("#nodata").text("").hide();
                    $('.pagination').pagination(itemCount, {
                        prev_text: '<i class="icon-triangle-left"></i>上一页',
                        next_text: '下一页<i class="icon-triangle-right"></i>',
                        num_display_entries: 3,
                        num_edge_entries: 2,
                        current_page: page,
                        items_per_page: length,
                        link_to: 'javascript:void(0)',
                        ellipse_text: '...',
                        first_text: '首页',
                        last_text: '末页',
                        callback: function (page, jq) {
                            // page表示当前是第几页，length表示每页长度
                            build(page, length);
                        }
                    });

                    $('.items-page select').on('change',function(){
                        var num = $('#items-page select option:selected').val();
                        build(0, num);
                    });

                    var myTemplate = handlebars.compile($("#notice_li_list").html());
                    $('#notice-list-id').html(myTemplate(data));
                    //$("#notice-list-id a").click(function(){
                    //    var linkUID = $(this).attr("linkUID");
                    //    showdetail(linkUID,state);
                    //});
                    $("#notice-total").text(itemCount);
                    var pageNum = itemCount % 10 == 0 ? itemCount / 10 : Math.ceil(itemCount / 10);
                    $("#notice_pageNum").text(pageNum);

                } else {
                    $(".notice-list").html("");
                    $("#pageforhide").hide();
                    $("#nodata").show().text("暂无数据。");
                }
            }
        });
    };

    function bind() {
        util.bindEvents([{
            el: '.js-nav-list a',
            event: 'click',
            handler: function () {
                $('.js-nav-list a').removeClass('nav-cur');
                $(this).addClass('nav-cur');
                $('.cont-title-text').html($('.nav-cur span').text());
                build(0,10);
            }
        }])
    }

})