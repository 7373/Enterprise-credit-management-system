require(['common/util', 'component/iframeLayer', 'common/http', 'jquery.validate', 'jquery','jquery.serialize', 'common/ajaxfileupload'], function (util, layer, http) {
    
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
        $('#register-form').validate({
            rules: {
            	entName: {
                    required: true
                },
                orgName: {
                    required: true
                },
                uniscid: {
                    required: true
                },
                passWord: {
                    required: true,
                    rangelength: [6, 20]
                },
                passWord1: {
                    required: true,
                    equalTo: "#passWord"
                },
                managerName: {
                    required: true
                },
                managerCertNO: {
                    required: true
                },
                managerTel: {
                    required: true,
                },
                checkCode: {
                    required: true
                }
            },

            messages: {
            	entName: {
                    required: '企业名称不能为空'
                },
                uniscid: {
                    required: '注册号/统一代码不能为空'
                },
                orgName: {
                    required: '登记机关不能为空'
                },
                passWord: {
                    required: '密码不能为空',
                    rangelength: '登录密码长度必须是{0}到{1}之间'
                },
                passWord1: {
                	required: '密码不能为空',
                    equalTo: "请再次输入相同的值"
                },
                managerCertNO: {
                    required: '经办人证件号不能为空'
                },
                managerName: {
                    required: '经办人姓名不能为空'
                },
                managerTel: {
                    required: '经办人手机号不能为空',
                },
                checkCode: {
                    required: '验证码不能为空'
                }
            },
            submitHandler: function (form) {
            	if($('#orgName').val()==""){
            		layer.msg("登记机关不能为空", {time: 1000}, function () {});
            		return;
            	}
            	if($('#businessLicense').val()==""){
            		layer.msg("营业执照未上传", {time: 1000}, function () {});
            		return;
            	}
            	
                var formParam = $(form).serializeObject();
                http.httpRequest({
                    url: '/biz/entuser/register',
                    type: 'post',
                    data: formParam,
                    success: function (data) {
                    	layer.msg(data.msg, {time: 1000}, function () {
                        	if(data.status=='success'){
                        	   window.location.href='/biz/login';
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
            el: '.register-btn',
            event: 'click',
            handler: function () {
            	window.location.href='/biz/entuser/register';
            }
        },{
            el: '#selectDept',
            event: 'click',
            handler: function () {
            	doSelectDept();
            }
        },{
            el: '#sendMsg',
            event: 'click',
            handler: function () {
            	if($('#managerTel').val()==""){
            		layer.msg("经办人手机为空", {time: 1000}, function () {});
            		return;
            	}
            	http.httpRequest({
                    url: '/biz/sendMsg',
                    type: 'post',
                    data: {tel:$('#managerTel').val()},
                    success: function (data) {
                    	layer.msg(data.msg, {time: 1000}, function () {
                    		if(data.status == 'success'){
                    			count = 60;
                        		$("#sendMsg").attr("disabled", true);
                        		$("#sendMsg").val("重新发送" + count + " 秒");
                                countdown = setInterval(CountDown, 1000);
                    		}
                        });
                    }
                });	
            }
        }
        ])
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
    
    //上传部分代码
    var $files=$("#businessLicense"), filesArr=[], $upstate=$("#uploadState");
    function upload(file){
    	if(file==""){
    		layer.msg("请先选择需要上传的文件", {time: 3000}, function() {});
    		return false;
    	}
    	//验证文件的格式（文件或图片）
    	var file_name = file.toLowerCase().split("").reverse().join("");//文件名反转
		var fileTypeIndex = file_name.indexOf(".");//找到第一个点的位置
		var fileType =file_name.substring(0,fileTypeIndex).toLowerCase().split("").reverse().join("");//获取文件类型
		//可通过的类型
		var fileTypeArr = ["doc","jpg"];
		var isType = false;
		for(var i=0; i<fileTypeArr.length; i++){
    		if(fileTypeArr[i] == fileType){
    			isType = true;
    		}
    	}
		if(isType == false){
			layer.msg("请选择正确格式的文件", {time: 1200}, function() {});
			return false;
		} 
    	if(contains_(filesArr, file)){
    		layer.msg("文件已存在", {time: 2000}, function() {});
    		return false;
    	}
    	$upstate.show();
    	$.ajaxFileUpload({
            url: '/biz/entuser/upload',
            type: 'post',
            data: {"fileName":file},
            secureuri: false,
            fileElementId: 'btnFile',
            dataType: 'text',
            success: function(data, status){
            	if(data !="error") {
	            	//放入数组
	            	filesArr.push(data);
	            	var str="";
	            	for(var i=0; i<filesArr.length; i++){
	            		if(filesArr[i] != ""){
	            			str=str+filesArr[i]+"|";
	            		}
	            	}
	            	$files.val(str);
					var index = data.indexOf("-");
					var text = data.substring(index + 1, data.length);
					$("#filelabel").append("<p><i class='icon-file'></i><span class='file-name mr10'>"+text+"</span>&nbsp;&nbsp;<span path='"+data+"' style='color:#07538F;cursor:pointer' >预览附件</span>&nbsp;&nbsp;<a href='javascript:void(0)' path='"+data+"' class='a-blue'>删除</a><br/><p>");
		            layer.msg("上传成功", {time: 1200}, function() {});
            	}else {
            		layer.msg("上传失败", {time: 2000}, function() {});
            	}
				//重置file选择
            	$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
    			$upstate.hide();
    			
    			
    			
            },error: function(data, status){
				//重置file选择
            	$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
    			$upstate.hide();
            	layer.msg("上传失败，请检查网络及文件大小", {time: 3000}, function() {});
            }
        });
    }
  //委托事件
    $("#fileBox").delegate('input','change',function(){
		var text=$(this).val();
		var index = text.lastIndexOf("\\");
		text = text.substring(index + 1, text.length);
		//上传
		upload(text);
	});
	//判断附件是否已存在
    function contains_(array, str){
    	var index, text;
    	for(var i=0; i<array.length; i++){
    		index = array[i].indexOf("-");
			text = array[i].substring(index + 1, array[i].length);
    		if(text==str){
    			return true;
    		}
    	}
    	return false;
    }
    
    //预览
    $("#filelabel").delegate('span', 'click', function () {
        var path = $(this).attr("path");
        window.location.href="/biz/entuser/download?fileName=" + path;
    });
    
  //删除附件
	$("#filelabel").delegate('a','click',function(){
		var path=$(this).attr("path");
		var str="";
    	for(var i=0; i<filesArr.length; i++){
    		if(filesArr[i] !=path && filesArr[i] != ""){
        		str=str+filesArr[i]+"|";
    		}
    	}
    	$files.val(str);
    	var val=$files.val().substring(0,$files.val().length-1);
        filesArr = val.split("|");
    	$(this).parent().remove();
	});
	
	function get(min,max) {
		return Math.floor(Math.random()*(max-min))+min;
	}
})