require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules', 'common/ajaxfileupload'], function (layer, dataTable, util, http, busUtil,handlebars) {
	  //上传代码参数初始化
    var $files, 
    filesArrHT=[],filesArrSQS=[],filesArrDLR=[],filesArrQT=[],
    $upstate = $("#uploadStateSQS"),
    btnFile = 'btnFileSQS',
    $filelabel = $("#filelabelSQS"),
    $fileBox=$("#fileBoxSQS"),idStr,urlStr;
	
    init();
    
    /**
     * 初始化函数集合
     */
    function init() {
    	initPreSelect();
    	initSonSelect();
        bind();
        formValidate();
    }
    
    function initPreSelect(){
    	busUtil.initFcfPreType('contractTypeFir');
    }
    function initSonSelect(){
    	busUtil.initFcfSonType('contractTypeSec','0');
    }
    
    $('#contractTypeFir').change(function(){
    	$('#contractTypeSec').html('');
    	busUtil.initFcfSonType('contractTypeSec',$('#contractTypeFir').val());
    });
    
    function formValidate(){
    	$('#hxForm').validate({
    		rules: {
    			contractName:{required:true,maxlength:50},//合同名称
    			contractFile:{required:true},//合同
    			applicationFile:{required:true},//申请书
    			agentProxyAndCard:{required:true}//代理人委托书及身份证
    		},
    		onkeyup:false,
            showErrors:function(errorMap,errorList){
           	 for(var i in errorMap){
                 layer.tips(errorMap[i],$('#hxForm input[name='+i+'],textarea[name='+i+']'),{
                     tips:3,
                     tipsMore:true,
                     ltype:0
                 });
              }
            },
            submitHandler: function () {
            		var contractName = $('#contractName').val();
            		if($.trim(contractName) == ""){
        	    	layer.msg("合同名称不能为空", {time: 3000}, function() {});
    			    return ;
            		}
                	var g = /[\+\-\*\\\!\~\@\#\$\%\^\&\?\/\|\'\;\:\<\>\,\.\`\[\]\{\}\{\}\：\；\‘\“\"\？\、\，\。\《\》\·\~\！\@\#\￥\%\……\&\*\+\=\_\-\——\-]/;
                	if(g.test(contractName)){
                		layer.msg('合同名称输入格式不正确，请不要输入字符',{time:1000});
                		return ;
                	}
	            	if($('#contractTypeSec').val()==''){
	        	    	layer.msg("合同类别不能为空", {time: 3000}, function() {});
	    			    return ;
	        	    }
	            	if($('#filesHT').val()== "" || $('#filesSQS').val()== "" || $('#filesDLR').val()== ""){
	        	    	layer.msg("必选材料未上传", {time: 3000}, function() {});
	    			    return ;
	        	    }
            		var formParam = $('#hxForm').serializeObject();
                    http.httpRequest({
                        url: '/biz/contract/saveContract',
                        serializable: true,
                        data: formParam,
                        type: 'post',
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
    
    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
            	$('#state').val('1');
            	$('#hxForm').submit();
            }
        },{
            el: '#storage',
            event: 'click',
            handler: function () {
            	$('#state').val('0');
            	var formParam = $('#hxForm').serializeObject();
                http.httpRequest({
                    url: '/biz/contract/saveContract',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	if(data.status=='success'){
                        		layer.close({reload: true});
                        	}
                        });
                    }
                });
            }
        },{
            el: '.upload_instruct',
            event: 'click',
            handler: function () {
            	window.open ('/biz/contract/upload_instruction');
            }
        }
        ]);
    }
    
    //上传部分代码
    function upload(filesArr,file){
    	if(file==""){
    		layer.msg("请先选择需要上传的文件", {time: 3000}, function() {});
    		return false;
    	}
    	if(contains_(filesArr,file)){
    		layer.msg("文件已存在", {time: 2000}, function() {});
    		return false;
    	}
    	$upstate.show();
    	$.ajaxFileUpload({
            url: "/biz/contract/upload"+idStr,
            type: 'post',
            data: {"fileName":file},
            secureuri: false,
            fileElementId: btnFile,
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
					$filelabel.append("<p><i class='cl-icon'></i>"+text+"&nbsp;&nbsp;<span path='"+data+"' style='color:#07538F;cursor:pointer' >预览</span>&nbsp;&nbsp;<a href='javascript:void(0)' id='"+idStr+"' path='"+data+"'>删除</a><br/></p>");
	            	layer.msg("上传成功", {time: 1200}, function() {});
            	}else {
            		layer.msg("上传失败", {time: 2000}, function() {});
            	}
				//重置file选择
            	$fileBox.html("").append('<input type="file" id="btnFile'+idStr+'" class="btnFile" name="btnFile'+idStr+'"/>');
    			$upstate.hide();
            },error: function(data, status){
				//重置file选择
            	$fileBox.html("").append('<input type="file" id="btnFile'+idStr+'" class="btnFile" name="btnFile'+idStr+'"/>');
    			$upstate.hide();
            	layer.msg("上传失败，请检查网络及文件大小", {time: 3000}, function() {});
            }
        });
    }
    //委托事件
    $('.fileBox').delegate('input','change',function(){
		var text=$(this).val();
		var index = text.lastIndexOf("\\");
		text = text.substring(index + 1, text.length);
		idStr = this.id.substring(7);
    	$upstate = $("#uploadState"+idStr);
    	$files = $("#files"+idStr);
    	$fileBox =$("#fileBox"+idStr);
    	btnFile = this.id;
    	$filelabel = $("#filelabel"+idStr);
    	//验证文件的格式（文件或图片）
    	var file_name = text.toLowerCase().split("").reverse().join("");//文件名反转
		var fileTypeIndex = file_name.indexOf(".");//找到第一个点的位置
		var fileType =file_name.substring(0,fileTypeIndex).toLowerCase().split("").reverse().join("");//获取文件类型
		//上传
		if(idStr=="HT"){
			if(fileType != "doc"){
				layer.msg("请选择doc格式的文件", {time: 1200}, function() {});
				return;
			}
			if((getRealLength(filesArrHT)+1)>1){
        		layer.msg("超过附件文件份数", {time: 3000}, function() {});
        		//重置file选择
            	$fileBox.html("").append('<input type="file" id="btnFile'+idStr+'" class="btnFile" name="btnFile'+idStr+'"/>');
    			return ;
    		}
    		upload(filesArrHT,text);
    	}
    	else if(idStr=="SQS"){
    		if(fileType != "jpg"){
				layer.msg("请选择jpg格式的文件", {time: 1200}, function() {});
				return;
			} 
    		upload(filesArrSQS,text);
    	}
    	else if(idStr=="DLR"){
    		if(fileType != "jpg"){
				layer.msg("请选择jpg格式的文件", {time: 1200}, function() {});
				return;
			} 
    		upload(filesArrDLR,text);
    	}else{
    		if(fileType != "doc" && fileType != "jpg"){
				layer.msg("请选择jpg或者doc格式的文件", {time: 1200}, function() {});
				return;
			}
    		if((getRealLength(filesArrQT)+1)>5){
        		layer.msg("超过附件文件份数", {time: 3000}, function() {});
        		//重置file选择
            	$fileBox.html("").append('<input type="file" id="btnFile'+idStr+'" class="btnFile" name="btnFile'+idStr+'"/>');
    			return ;
    		}
    		upload(filesArrQT,text);
    	}
	})
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
  //删除附件
	$('.filelabel').delegate('a','click',function(){
		var path=$(this).attr("path");
		if(this.id=="HT"){
			filesArrHT = arrCreate(filesArrHT,path,this.id);
    	}
    	else if(this.id=="SQS"){
    		filesArrSQS = arrCreate(filesArrSQS,path,this.id);
    	}
    	else if(this.id=="DLR"){
    		filesArrDLR = arrCreate(filesArrDLR,path,this.id);
    	}
    	else if(this.id=="QT"){
    		filesArrQT = arrCreate(filesArrQT,path,this.id);
    	}
		$(this).parent().remove();
	});
	
    //预览
    $(".filelabel").delegate('span', 'click', function () {
        var path = $(this).attr("path");
        window.location.href="/biz/entuser/download?fileName=" + path;
    });
	
	//组装数组
	function arrCreate(filesArr,path,id){
		var str="";
		for(var i=0; i<filesArr.length; i++){
    		if(filesArr[i] !=path && filesArr[i] !=""){
        		str=str+filesArr[i]+"|";
    		}
    	}
		$('#files'+id).val(str);
		var val=$('#files'+id).val().substring(0,$('#files'+id).val().length-1);
        filesArr=val.split("|");
        return filesArr;
	}
    
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
