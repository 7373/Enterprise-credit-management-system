define(['layer1'], function (layer1) {

    var _data = '@LAYERDIALOG.DATA';
    parent[_data] = {}; //全局命名空间

    return {
        /**
         * //得到当前iframe层的索引，子iframe时使用
         * @param name 必填 iframe的name值
         * @param options 可选
         */
        getFrameIndex: function(name,options){
            var defaultOptions = {
                ltype: 1 // 打开弹出层的类型 1表示父窗口打开，0表示当前窗口打开
            };
            var opt = $.extend({}, defaultOptions, options);
            var layer = opt.ltype === 1 ? parent.layer : layer1;
            return layer.getFrameIndex(name);
        },
        /**
         *  弹出框，一般用于加载独立页面和iframe(可参照layer官网参数)
         * @param options 可选参数
         * {
         *      title：'弹框标题',
         *      area: '弹框宽高'，
         *      content: '弹框内容'
         *      type: '弹框类型' default 2(iframe打开)
         * }
         * @returns {*}
         */
        dialog: function (options) {
            var defaultOptions = {
                ltype: 1, // 打开弹出层的类型 1表示父窗口打开，0表示当前窗口打开
                type: 2 //默认打开新的url
            };
            var opt = $.extend({}, defaultOptions, options);
            var layer = opt.ltype === 1 ? parent.layer : layer1;

            function end() {
                opt.callback && opt.callback(parent[_data]);
            }

            var o = $.extend({}, {
                zIndex: layer.zIndex, success: function (layero) {
                    layer.setTop(layero);
                }, end: end
            }, opt);
            return layer.open(o);
        },
        /**
         * @param index: index //不使用iframe页面时需要传递关闭弹窗的索引
         * @param options options 可选参数：
         {
            reload：true,//关闭弹窗时是否进行执行回调(可自己定义名称)
            ltype:1 //默认可传0
         }
         */
        close: function (index,options) {
            parent[_data] = {};
            if(typeof index === 'object'){
                options = index;
                index = undefined;
            }
            var defaultOptions = {
                ltype: 1 // 打开弹出层的类型 1表示父窗口打开，0表示当前窗口打开
            };
            var opt = $.extend({}, defaultOptions, options);
            var layer = opt.ltype === 1 ? parent.layer : layer1;
            parent[_data] = opt;
            var cIndex = index ? index : this.getFrameIndex(window.name);
            layer.close(cIndex);
        },
        /**
         *
         * @param type 关闭弹窗的类型 dialog/page/iframe/loading/tips 也可以不传
         * @param ltype 是否父页面打开 1/0 页可以不传
         */
        closeAll: function (type, ltype) {
            var layer = (ltype && ltype === 1) ? parent.layer : layer1;
            layer.closeAll(type);
        },
        /**
         *  alert弹出框(可参照layer官网参数 )
         * @param content
         * @param options 多了ltype这一个参数，其他跟官网一致
         * @param yes
         * @returns {*}
         */
        alert: function (content, options, yes) {
            var defaultOptions = {
                ltype: 1 // 打开弹出层的类型 1表示父窗口打开，0表示当前窗口打开
            }
            var opt = $.extend({}, defaultOptions, options);
            var layer = opt.ltype === 1 ? parent.layer : layer1;
            opt = $.extend(opt, {
                zIndex: layer.zIndex,
                success: function (layero) {
                    layer.setTop(layero);
                }
            })
            return layer.alert(content, opt, yes);
        },
        
        prompt: function (options, yes) {
            var defaultOptions = {
                ltype: 1 // 打开弹出层的类型 1表示父窗口打开，0表示当前窗口打开
            }
            var opt = $.extend({}, defaultOptions, options);
            var layer = opt.ltype === 1 ? parent.layer : layer1;
            return layer.prompt(opt, yes);
        },
        
        /**
         *  confirm弹出框(可参照layer官网参数 )
         * @param content
         * @param options 多了ltype这一个参数，其他跟官网一致
         * @param yes
         * @param cancel
         * @returns {*}
         */
        confirm: function (content, options, yes, cancel) {
            var defaultOptions = {
                ltype: 1 // 打开弹出层的类型 1表示父窗口打开，0表示当前窗口打开
            }
            var opt = $.extend({}, defaultOptions, options);
            var layer = opt.ltype === 1 ? parent.layer : layer1;
            opt = $.extend(opt, {
                zIndex: layer.zIndex,
                success: function (layero) {
                    layer.setTop(layero);
                }
            })
            return layer.confirm(content, opt, yes, cancel);
        },
        /**
         *  msg信息框(可参照layer官网参数 )
         * @param content
         * @param options 多了ltype这一个参数，其他跟官网一致
         * @param yes
         * @param cancel
         * @returns {*}
         */
        msg: function (content, options, end) {
            var defaultOptions = {
                ltype: 1 // 打开弹出层的类型 1表示父窗口打开，0表示当前窗口打开
            };
            var opt = $.extend({}, defaultOptions, options);

            var layer = opt.ltype === 1 ? parent.layer : layer1;

            opt = $.extend(opt, {
                zIndex: layer.zIndex,
                success: function (layero) {
                    layer.setTop(layero);
                }
            });
            return layer.msg(content, opt, end);
        },
        /**
         * (可参照layer官网参数 )
         * @param icon
         * @param options
         * @returns {*|void|{noBubble}}
         */
        load: function (icon, options) {
            var defaultOptions = {
                ltype: 1 // 打开弹出层的类型 1表示父窗口打开，0表示当前窗口打开
            };
            var opt = $.extend({}, defaultOptions, options);

            var layer = opt.ltype === 1 ? parent.layer : layer1;

            opt = $.extend(opt, {
                zIndex: layer.zIndex,
                success: function (layero) {
                    layer.setTop(layero);
                }
            });

            return layer.load(icon, opt);
        },
        /**
         * 一般layer是在对应的iframe内部，如果调用了iframLayer.js则需要添加ltype：0(可参照layer官网参数 )
         * @param content
         * @param follow
         * @param options
         * @returns {*|{Open, Close, Resize, Slide, Pin, Unpin, noRoomToOpen, minSizeWarning, maxSizeWarning}}
         */
        tips: function (content, follow, options) {
            var defaultOptions = {
                ltype: 1 // 打开弹出层的类型 1表示父窗口打开，0表示当前窗口打开
            };
            var opt = $.extend({}, defaultOptions, options);

            var layer = opt.ltype === 1 ? parent.layer : layer1;
            return layer.tips(content, follow, opt);
        }
    }
});