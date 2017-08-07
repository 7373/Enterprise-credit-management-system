require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules', 'common/ajaxfileupload'], function (layer, dataTable, util, http, busUtil,handlebars) {
	$("#search").bind('click',function(){
		var text = $("#btnFile").val();
		var index = text.lastIndexOf("\\");
		text = text.substring(index+1,text.length);
		upload(text);
	})
	$("#uploadFile").delegate('input','change',function(){
		var text = $("#btnFile").val();
		$("#fileName").val(text.substring(text.lastIndexOf("\\")+1,text.length));
	})
	function upload(file){
		if(file==""){
    		layer.msg("请先选择需要上传的文件", {time: 3000}, function() {});
    		return false;
    	}
		if(file.substring(file.lastIndexOf(".")+1,file.length)!='xls'){
			$("#fileName").val("");
			layer.msg("文件格式要以xls结尾，如某某局.xls",{time:3000},function(){});
			return;
		}
		$.ajaxFileUpload({
            url: '/credit/upload/uploadFile',
            type: 'post',
            data: {"fileName":file},
            secureuri: false,
            fileElementId: 'btnFile',
            dataType: 'text',
            success: function(data,status){
            	var msg = data.split(',');
    			if(msg[0]=='success'){
    				$("#fileName").val("");
    				layer.msg(msg[1],{time:3000},function(){});
    			}else if(msg[0]=='error'){
    				$("#fileName").val("");
    				layer.msg(msg[1],{time:3000},function(){});
    			}
            },error: function(data, status){
            	layer.msg("上传失败，请检查网络及文件大小", {time: 6000}, function() {});
            }
        });
	}
	
	$(".downTemple").click(function(){
		window.location.href="/credit/upload/downTemple";
	});
})