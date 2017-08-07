require(['common/util', 'component/iframeLayer', 'common/http', 'jquery.validate', 'jquery','jquery.serialize', 'common/ajaxfileupload'], function (util, layer, http) {
    //执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
        formValid();
        bind();
    }

    /**
     * 注册表单验证
     */
    function formValid() {
        $('#findpassword-form').validate({
        	showErrors: function (errorMap, errorList) {
                for (var i in errorList) {
                    $(errorList[i].element).addClass('error');
                    $('#errorContainer').html(errorList[i].message);
                    break;
                }
            },
            onkeyup: function () {
                if ($(this.lastActive).valid()) {
                    $('#errorContainer').html('');
                    $(this.lastActive).removeClass('error');
                }
            },
            onfocusout: false,
        	rules: {
                password: {
                    required: true,
                    rangelength: [6, 20]
                },
                password1: {
                    required: true,
                    rangelength: [6, 20]
                },
                password2: {
                    required: true,
                    equalTo: "#password1"
                }
            },

            messages: {
                password: {
                    required: '密码不能为空',
                    rangelength: '登录密码长度必须是{0}到{1}之间'
                },
                password1: {
                    required: '密码不能为空',
                    rangelength: '登录密码长度必须是{0}到{1}之间'
                },
                password2: {
                	required: '密码不能为空',
                    equalTo: "请再次输入相同的值"
                }
            },
            submitHandler: function () {
                var formParam = $('#findpassword-form').serializeObject();
                http.httpRequest({
                    url: '/credit/system/sysuser/editPass',
                    type: 'post',
                    data: formParam,
                    success: function (data) {
                    	layer.msg(data.msg, {time: 1000}, function () {
                        	if(data.status=='success'){
                        	   layer.close({reload: true});
                        	}
                        });
                    }
                });
            }
        });
    }

    /**
     * 事件绑定
     */
    function bind() {
        util.bindEvents([{
            el: '#reset',
            event: 'click',
            handler: function () {
            	$('.clx').val('');
            }
        }
        ])
    }
})