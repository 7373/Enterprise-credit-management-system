require(['common/util', 'layer1', 'common/http', 'jquery.validate', 'jquery','jquery.serialize'], 
		function (util, layer, http) {
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
     * 登录表单验证
     */
    function formValid() {
        $('#login-form').validate({
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
                entName: {
                    required: true,
                    rangelength: [5, 20]
                },
                passWord: {
                    required: true,
                    rangelength: [6, 20]
                },
                checkCode: {
                    required: true
                }
            },

            messages: {
                entName: {
                    required: '登录账号不能为空',
                    rangelength: '登录账号长度必须是{0}到{1}之间'
                },
                passWord: {
                    required: '登录密码不能为空',
                    rangelength: '登录密码长度必须是{0}到{1}之间'
                },
                checkCode: {
                    required: '验证码不能为空'
                }
            },
            submitHandler: function (form) {
                var formParam = $(form).serializeObject();
                http.httpRequest({
                    url: '/biz/login',
                    type: 'post',
                    data: formParam,
                    success: function (data) {
                    	console.log(data.errorCode);
	                    if (data.status == 'success') {
	                    	window.location.href='/biz/contract/views';
	                        return;
	                    }
	                    //待审核
	                    if(data.status == 'fail'&& data.msg =='0'){
	                    	window.location.href='/biz/entuser/enRegisterNotice';
	                    	return;
	                    }
	                    //审核未通过
	                    if(data.status == 'fail'&& data.msg =='2'){
	                    	window.location.href='/biz/entuser/registerEdit?uid='+data.errorCode;
	                    	return;
	                    }
	                    $('.js-checkcode').trigger('click');
	                    layer.msg(data.msg);
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
            el: '.register-btn',
            event: 'click',
            handler: function () {
            	window.location.href='/biz/entuser/register';
            }
        },{
        	el: '.pro',
            event: 'click',
            handler: function () {
            	window.open("/biz/entuser/doEnPro","_blank");
            }
        },{
        	el: '.gstel',
            event: 'click',
            handler: function () {
            	window.open("/biz/entuser/doEnGSTelView","_blank");
            }
        }
        ])
    }

})