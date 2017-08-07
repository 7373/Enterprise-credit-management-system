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
        $('#noticeForm').validate({
        	rules: {
        		noticeName:{required:true},
        		endTime:{required:true}
    		},
    		onkeyup:false,
            showErrors:function(errorMap,errorList){
           	 for(var i in errorMap){
                 layer.tips(errorMap[i],$('#noticeForm input[name='+i+'],textarea[name='+i+']'),{
                     tips:3,
                     tipsMore:true,
                     ltype:0
                 });
              }
            },
            submitHandler: function () {
            	if($('#filePath').val()==''){
            		layer.msg("附件不能为空", {time: 3000}, function() {});
    			    return ;
            	}
                http.httpRequest({
                    url: '/admin/pubnotice/save',
                    serializable: true,
                    data: $('#noticeForm').serializeObject(),
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
        }
        ])
    }
    
    //上传部分代码
    var $files=$("#filePath"), filesArr=[], $upstate=$("#uploadState");
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
		var fileTypeArr = ["doc"];
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
            url: '/admin/pubnotice/upload',
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
	            			str=str+filesArr[i];
	            		}
	            	}
	            	$files.val(str);
					var index = data.indexOf("-");
					var text = data.substring(index + 1, data.length);
					$("#filelabel").append("<p><i class='icon-file'></i><span class='file-name mr10'>"+text+"</span>&nbsp;&nbsp;<span path='"+data+"' style='color:#25A1A1;cursor:pointer' >预览附件</span>&nbsp;&nbsp;<a href='javascript:void(0)' path='"+data+"' class='a-blue'>删除</a><br/><p>");
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
		if((getRealLength(filesArr)+1)>1){
    		layer.msg("超过附件文件份数", {time: 3000}, function() {});
    		//重置file选择
        	$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
			return ;
		}
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
	//返回数组长度（去空格）
	function getRealLength(arr){
		var j=0;
		for (var i=0;i<arr.length;i++) {
		    if (arr[i] == "") {
		    	j++;
		    }
		}
		return (arr.length-j);
	}
	
})