require(['common/util', 'component/iframeLayer', 'common/http', 'ztree','jquery.serialize'], function (util, layer, http) {


    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }

    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
                var formParam = $('#sysPermisionForm').serializeObject();
                http.httpRequest({
                    type: 'post',
                    url: '/admin/system/syspermision/save',
                    data: formParam,
                    success: function (data) {
                        if (data.status == 'success') {
                            layer.msg(data.msg, {time: 500}, function () {
                                layer.close({reload: true});
                                return;
                            });
                        }
                        var errorMsg = data.msg;
                        var errors = data.errors;
                        if (errors.length > 0) {
                            for (var i = 0; i < errors.length; i++) {
                                errorMsg += '<br/>' + (i + 1) + '：' + errors[i].field + errors[i].info;
                            }
                        }
                        layer.msg(errorMsg, {time: 1000});
                    }
                });
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        }])
    }
})