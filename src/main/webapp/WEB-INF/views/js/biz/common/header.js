require(['component/iframeLayer', 'common/util', 'jquery.layout'], function (layer, util) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }




    function bind() {
        util.bindEvents([{
            el: '.js-logout',
            event: 'click',
            handler: function () {
            	layer.confirm('确定要退出登录吗?', {icon: 3, title: '提示'}, function () {
                    location.assign('/biz/login');
                });
            }
        }, {
            el: '.js-manageruser',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '密码修改',
                    area: ['900px', '500px'],
                    content: '/biz/entuser/manageruser' ,
                    callback: function (data) {
                        if (data.reload) {
                        	 parent.location.href='/biz/login';
                        }
                    }
                })
            }
        },{
            el: '.operate_instruction',
            event: 'click',
            handler: function () {
            	window.open ('/biz/contract/operate_instruction');
            }
        }])
    }

})