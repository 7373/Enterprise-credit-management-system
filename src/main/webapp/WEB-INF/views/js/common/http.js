/**
 * http请求工具
 */
define(['jquery', 'component/iframeLayer'], function ($, layer) {

    // 默认值
    var defaultOpt = {
        async: true,
        dataType: 'json',
        type: 'get',
        serializable: false
    };

    /**
     * 组装http请求参数
     * @param options
     * {
     *  interface: 接口名称
     *  type:get/post  请求类型
     *  data:{},  业务参数
     *  serializable:true/false,  是否需要序列化
     * @returns {void|*}
     */
    function generateHttpParam(options) {

        var index;  //success之后销毁对应的layer层

        // 参数合并
        var opt = $.extend({}, defaultOpt, options);

        opt.beforeSend = function () {
            if (options.beforeSend) {
                options.beforeSend();
            } else {
                if(opt.type.toLowerCase() === 'post'){
                    index = layer.msg('处理中，请稍后', {icon: 16, time: -1, shade: [0.4, '#CCC']});
                }
            }
        };

        // 获取请求地址
        opt.url = generateUrl(options.url);
        // 成功回调
        opt.success = function (data) {
            // 成功回调
            options.success && options.success(data);
        };
        // 失败回调
        opt.error = function (jqXHR, textStatus, errorThrown) {
            if (unAuthError(jqXHR, textStatus, errorThrown)) {
                return;
            }

            if (options.error) {
                options.error();
            } else {
                layer.msg('网络异常，请重试');
            }
        };

        // 请求完成回调
        opt.complete = function () {
            if (index) {
                setTimeout(function(){layer.close(index);},1000);
            }
        };

        // json参数序列化
        if (opt.serializable) {
            opt.contentType = 'application/json';
            opt.data = JSON.stringify(opt.data);
        }

        //返回
        return opt;
    }

    /**
     * 组装http请求url
     * @param interface
     */
    function generateUrl(url) {
        var p = {
            // 增加时间戳，解决IE浏览器ajax请求缓存问题
            _t: new Date().getTime()
        };

        var operator = /\?/gi.test(url) ? '&' : '?';
        return url + operator + $.param(p);
    }


    /**
     * http get请求
     * @param options
     */
    function httpRequest(options) {
        var ajax = $.ajax(generateHttpParam(options));
        return ajax;
    }

    /**
     * 未授权错误
     * @param jqXHR
     * @param textStatus
     * @param errorThrown
     */
    function unAuthError(jqXHR, textStatus, errorThrown) {

        if(jqXHR.status === 406){
            parent.layer.alert("您当前提交的内容未做任何修改,请等待30秒之后再次进行保存操作！", {icon: 7, title: '提示'}, function (index) {
                layer.close(index);
            });
            return false;
        }
        if (jqXHR.status === 401) {

            var result = jqXHR.responseJSON;
            if(result.errorCode=='401.5'){  // 为解决年报端session过期或用户退出时候发送的ajax请求的拦截器配置跳转到对应的登录页面
                parent.layer.alert("您尚未登录或登录时间过长,请重新登录!", {icon: 7, title: '登录提示'}, function () {
                    top.location = result.msg;
                });
            }else {
                parent.layer.alert("您尚未登录或登录时间过长,请重新登录!", {icon: 7, title: '登录提示'}, function () {
                    top.location = "/";
                });
            }
            return true;
        }
    }

    // 返回
    return {
        httpRequest: httpRequest,
        unAuthError: unAuthError
    };
});