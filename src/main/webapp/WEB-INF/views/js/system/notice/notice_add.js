require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules', 'common/ajaxfileupload'], function (layer, dataTable, util, http, busUtil,handlebars) {


    init();

    /**
     * 初始化函数集合
     */

    function init() {
        formValid();
        bind();
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#noticeForm').validate({
            rules: {
            	noticeName: {
                    required: true
                },
                noticeView: {
                    required: true
                }
            },
            submitHandler: function () {
                http.httpRequest({
                    url: '/admin/notice/save',
                    serializable: true,
                    data: $('#noticeForm').serializeObject(),
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                            layer.close({reload: true});
                        });
                    }
                })
            }
        })
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        }
        ])
    }
})