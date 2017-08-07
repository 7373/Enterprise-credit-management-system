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
        $('#sysUserForm').validate({
            rules: {
                username: {
                    required: true,
                    rangelength: [5, 20]
                },
                password: {
                    rangelength: [6, 20]
                },
                email: {
                    required: true
                }
            },
            messages: {
                username: {
                    required: '登录账号不能为空',
                    rangelength: '登录账号长度必须是{0}到{1}之间'
                },
                password: {
                    rangelength: '登录密码长度必须是{0}到{1}之间'
                },
                email: {
                    required: '电子邮件不能为空'
                }
            },
            /**
             * 如果想用layer.tips做验证提示，可以用这个方法
             * @param errorMap
             * @param errorList
             */
            showErrors: function (errorMap, errorList) {
                for (var i in errorMap) {
                    layer.tips(errorMap[i], $('#sysUserForm input[name=' + i + ']'), {
                        tips: 3,
                        tipsMore: true,
                        ltype: 0
                    });
                }
            },
            submitHandler: function () {
            	if($('#orgName').val()=="" && $('#userId').val()==""){
            		layer.msg("请选择部门", {time: 3000}, function() {});
            		return;
            	}
                var formParam = $('#sysUserForm').serializeObject();
                http.httpRequest({
                    url: '/admin/system/sysuser/save',
                    serializable: true,
                    data: formParam,
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
        },{
            el: '#selectDept',
            event: 'click',
            handler: function () {
            	doSelectDept();
            }
        }
        ])
    }
    
    //选择部门
    function doSelectDept() {
        var select_dept_url=window._CONFIG.select_dept_url;
        layer.dialog({
            title: '选择设置部门',
            area: ['420px', '666px'],
            content: select_dept_url,
            callback: function (data) {
            	var orgCode = data.orgCode;
            	var orgName = data.orgName;
                    $("#orgName").val(orgName);
                    $("#orgCode").val(orgCode);
                }
        })
    }

})