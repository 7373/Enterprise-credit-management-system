require(['common/util', 'layer1', 'common/http', 'jquery.validate', 'jquery','jquery.serialize'], function (util, layer, http) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        var code;
        formValid();
    }

    /**
     * 登录表单验证
     */
    function formValid() {
        $('#consult-form').validate({showErrors: function (errorMap, errorList) {
            for (var i in errorList) {
                $('#errorContainer').html(errorList[i].message);
                break;
            }
        },
            onkeyup: function () {
                if ($(this.lastActive).valid()) {
                    $('#errorContainer').html('');
                }
            },
            onfocusout: false,
            rules: {
                realName: {
                    required: true
                },
                messageTitle: {
                    required: true
                },
                messageContent: {
                    required: true
                }
            },
            messages: {
                realName: {
                    required: '真实姓名不能为空'
                },
                messageTitle: {
                    required: '留言标题不能为空'
                },
                messageContent: {
                    required: '留言内容不能为空'
                }
            },
            submitHandler: function (form) {
                if(!$("#checkbox").is(':checked')){
                    layer.msg("请阅读并同意留言须知！", {time: 1000}, function() {});
                    return false;
                }
                getValidateCode();
                var checkCode = $("#checkCode").val();
                if(code!=checkCode){
                    layer.msg("验证码错误请重新输入！", {time: 1000}, function() {});
                    changeCode();
                    return false;
                }
                var formParam = $(form).serializeObject();
                http.httpRequest({
                    url: '/gateway/reception/consult/creditConsultValidate',
                    type: 'post',
                    data: formParam,
                    success: function (data) {
                        if (data.status == 'success') {
                            $('#reset').trigger('click');
                            $('.js-checkcode').trigger('click');
                            layer.msg(data.msg);
                        }
                    }
                });
            }
        });
    }


    //生成或刷新验证码
    function changeCode() {  //刷新
        $('.js-check-img').attr('src', '/ndrcCaptcha?t=' + Math.random());
        event.cancelBubble=true;
    }

    function getValidateCode(){
        $.ajax({
            type: "GET",
            url: "/gateway/reception/doGetSessionValidateCode",
            async:false,
            dataType: "json",
            success: function(data){
                code =  data.data;
            }
        });
    }


    $(".js-checkcode").unbind("click").bind("click",function(){
    	changeCode();
    })

})