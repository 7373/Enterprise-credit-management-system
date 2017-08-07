require(['common/util', 'component/iframeLayer', 'common/http', 'jquery.validate', 'jquery', 'jquery.serialize', 'common/ajaxfileupload'], function (util, layer, http) {

    //验证码重新发送计时参数初始化
    var count;
    var countdown;

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
            $('#appealForm').validate({
        //        showErrors: function (errorMap, errorList) {
        //    for (var i in errorList) {
        //        $('#errorContainer').html(errorList[i].message);
        //        break;
        //    }
        //},onkeyup: function () {
        //        if ($(this.lastActive).valid()) {
        //            $('#errorContainer').html('');
        //        }
        //    },
        //    onfocusout: false,
            rules: {
                appealName: {
                    required: true
                },
                appealOrgan: {
                    required: true
                },
                certType: {
                    required: true
                },
                certNO: {
                    required: true
                },
                email: {
                    required: true
                },
                tel: {
                    required: true,
                },
                checkCode: {
                    required: true
                },
                title: {
                    required: true
                },
                appealContent: {
                    required: true
                }

            },

            messages: {
                appealName: {
                    required: '申诉人/企业/机构名称不能为空'
                },
                appealOrgan: {
                    required: '申诉机构不能为空'
                },
                certType: {
                    required: '证件类型不能为空'
                },
                certNO: {
                    required: '证件号码不能为空'
                },
                email: {
                    required: '联系邮箱不能为空'
                },
                tel: {
                    required: '联系电话不能为空',
                },
                checkCode: {
                    required: '验证码不能为空'
                },
                title: {
                    required: '标题不能为空'
                },
                appealContent: {
                    required: '申诉内容不能为空'
                }
            },
            submitHandler: function (form) {
                if ($('#proveMaterial').val() == "") {
                    layer.msg("相关证明材料未上传", {time: 1000}, function () {
                    });
                    return;
                }
                if(!$("#checkbox").is(":checked")){
                    layer.msg("请阅读并同意留言须知！", {time: 1000}, function () {
                    });
                    return;
                }

                var formParam = $(form).serializeObject();
                http.httpRequest({
                    url: '/gateway/reception/appeal/save',
                    type: 'post',
                    data: formParam,
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                            if (data.status == 'success') {
                                $('#reset').click();
                            }
                        });
                    }
                });
            }
        });
    }
    
    
    function bind(){
    	util.bindEvents([{
    		el: '#selectDept',
            event: 'click',
            handler: function () {
            	doSelectDept();
            }
    	}])
    }
    

    /**
     * 事件绑定
     */
    $("#sendMsg").unbind("click").bind("click",function(){
    	if ($('#managerTel').val() == "") {
            layer.msg("经办人手机为空", {time: 1000}, function () {
            });
            return;
        }
        http.httpRequest({
            url: '/gateway/reception/sendMsg',
            type: 'post',
            data: {tel: $('#managerTel').val()},
            success: function (data) {
                layer.msg(data.msg, {time: 1000}, function () {
                    if (data.status == 'success') {
                        count = 60;
                        $("#sendMsg").attr("disabled", true);
                        $("#sendMsg").val("重新发送" + count + " 秒");
                        countdown = setInterval(CountDown, 1000);
                    }
                });
            }
        });
    })
    $("#reset").unbind("click").bind("click",function(){
    	 $('.clx').val('');
         $(".filelabel").html('');
         filesArr = [];
    })
    
    /**
     * 部门树
     * @returns
     */
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
                    $("#appealOrgan").val(orgCode);
                }
        })
    }

    //验证码计时
    function CountDown() {
        count--;
        $("#sendMsg").val("重新发送" + count + " 秒");
        if (count == 0) {
            $("#sendMsg").val("获取验证码").removeAttr("disabled");
            clearInterval(countdown);
        }
    }

    //上传部分代码
    var $files = $("#proveMaterial"), filesArr = [], $upstate = $("#uploadState");

    function upload(file) {
        if (file == "") {
            layer.msg("请先选择需要上传的文件", {time: 3000}, function () {
            });
            return false;
        }
        //验证文件的格式（文件或图片）
        var file_name = file.toLowerCase().split("").reverse().join("");//文件名反转
        var fileTypeIndex = file_name.indexOf(".");//找到第一个点的位置
        var fileType = file_name.substring(0, fileTypeIndex).toLowerCase().split("").reverse().join("");//获取文件类型
        //可通过的类型
        var fileTypeArr = ["doc", "jpg"];
        var isType = false;
        for (var i = 0; i < fileTypeArr.length; i++) {
            if (fileTypeArr[i] == fileType) {
                isType = true;
            }
        }
        if (isType == false) {
            layer.msg("请选择正确格式的文件", {time: 1200}, function () {
            });
            return false;
        }
        if (contains_(filesArr, file)) {
            layer.msg("文件已存在", {time: 2000}, function () {
            });
            return false;
        }
        var markArr = ["#", "%", "&"];
        for (var i = 0; i < markArr.length; i++) {
            if (file.indexOf(markArr[i]) != -1) {
                layer.msg("文件名不能包含特殊符，例如#,%,&等", {time: 1200}, function () {
                });
                return false;
            }
        }
        $upstate.show();
        $.ajaxFileUpload({
            url: '/gateway/reception/appeal/upload',
            type: 'post',
            data: {"fileName": file},
            secureuri: false,
            fileElementId: 'btnFile',
            dataType: 'text',
            success: function (data, status) {
                if (data != "error") {
                    //放入数组
                    filesArr.push(data);
                    var str = "";
                    for (var i = 0; i < filesArr.length; i++) {
                        if (filesArr[i] != "") {
                            str = str + filesArr[i] + "|";
                        }
                    }
                    $files.val(str);
                    var index = data.indexOf("-");
                    var text = data.substring(index + 1, data.length);
                    $(".filelabel").append("已上传" + text + "&nbsp;<span class='close-icon' path='" + data + "'></span>");
                    layer.msg("上传成功", {time: 1200}, function () {
                    });
                } else {
                    layer.msg("上传失败", {time: 2000}, function () {
                    });
                }
                //重置file选择
                $("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
                $upstate.hide();


            }, error: function (data, status) {
                //重置file选择
                $("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
                $upstate.hide();
                layer.msg("上传失败，请检查网络及文件大小", {time: 3000}, function () {
                });
            }
        });
    }

    //委托事件
    $("#fileBox").delegate('input', 'change', function () {
        var text = $(this).val();
        var index = text.lastIndexOf("\\");
        text = text.substring(index + 1, text.length);
        //上传
        upload(text);
    });
    //判断附件是否已存在
    function contains_(array, str) {
        var index, text;
        for (var i = 0; i < array.length; i++) {
            index = array[i].indexOf("-");
            text = array[i].substring(index + 1, array[i].length);
            if (text == str) {
                return true;
            }
        }
        return false;
    }

//    //预览
//    $("#filelabel").delegate('span', 'click', function () {
//        var path = $(this).attr("path");
//        window.location.href="/appeal/download?fileName=" + path;
//    });

    //删除附件
    $(".filelabel").delegate('span', 'click', function () {
        var path = $(this).attr("path");
        var str = "";
        for (var i = 0; i < filesArr.length; i++) {
            if (filesArr[i] != path && filesArr[i] != "") {
                str = str + filesArr[i] + "|";
            }
        }
        $files.val(str);
        var val = $files.val().substring(0, $files.val().length - 1);
        filesArr = val.split("|");
        $(this).parent().remove();
    });

})