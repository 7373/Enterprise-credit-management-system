require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules', 'common/ajaxfileupload'], function (layer, dataTable, util, http, busUtil,handlebars) {

    var table,uploadformat=["doc","jpg"];
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initValue();
    	buildMenu2();//刚进来时就加载
    	initUploadVideo();
        bind();
        formValid();
    }
  
    
    
    //加载二级目录，并选中
    function buildMenu2(){
    	$('.remove').remove();//移除之前存在的
    	var uid=$("#type1Code option:selected").attr("uid");//根据UID获取一级目录选定的菜单的UID
        http.httpRequest({
                        url: '/gateway/backstage/catalog/selectCatalog2ByUID',
                        data: {"uid": uid},
                        success: function (data) {
                        	$.each(data,function(i,n){//循环显示list中的值
                        		$('#type2Code').append("<option "+($('#type2CodeFlag').val()==n.catalogCode ? "selected" : "")+" uid='"+n.uid+"' code='"+n.catalogName+"' value='"+n.catalogCode+"' class='remove levelTwo'>"+n.catalogName+"</option>");
                        	});
                        	
                        }
                    });
    }

    
    $('#type1Code').change(function(){
    	buildMenu2();
    	var code = $("#type2Code :selected").val();
    	uploadVideo(code);
    });
    
    function initUploadVideo(){
    	var code = $('#type2CodeFlag').val();
    	uploadVideo(code);
    }
    
    function uploadVideo(code){
    	if(code == '2008'){
    		$("#uploadname").val("视频上传");
    		uploadformat=["avi"];
    		$("#maincontent").hide();
    	}else{
    		$("#uploadname").val("图片上传");
    		uploadformat=["doc","jpg"];
    		$("#maincontent").show();
    	}
    }
    
    $('#type2Code').change(function(){
    	var code = $("#type2Code :selected").val();
    	uploadVideo(code);
    });
    
    
    function initValue(){
 	   editor1 = KindEditor.create('#content', {
				cssPath : '/js/lib/kindeditor/plugins/code/prettify.css',
				uploadJson : '/js/lib/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '/js/lib/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
			afterChange: function() {
				//字数统计
				KindEditor('#count').html(this.count("html")+" ").css('color', this.count("html")>3000?"red":"green");
			},
			items : [//图标显示项
				  'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
				  'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
				  'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
				  'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
				  'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
				  'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
				  'anchor', 'link', 'unlink', '|', 'about']
			});
 }
    
    

    
    function formValid() {
       $('#publishForm').validate({
            rules: {
            	title: {
                    required: true
                }
            },
            messages: {
            	title: {
                    required: '标题不能为空',
                }
            },
            submitHandler: function () {
            	var _html = editor1.html();//获取插件中的内容
            	$("#content").val(_html);
                var formParam = $('#publishForm').serializeObject();
                http.httpRequest({
                    url: '/gateway/backstage/publish/edit',
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
        });
    }
    
    
    function bind() {
        util.bindEvents([{
        	el: '#search',
           event: 'click',
           handler: function () {
        	   var type1 = $("#type1Code option:selected").attr("code");//获取一级目录的名称
	           	var type2 = $("#type2Code option:selected").attr("code");//获取二级目录的名称
	           	$("#type1").val(type1);//设置一级目录的名称
	           	$("#type2").val(type2);//设置二级目录的名称
        	   $('#publishForm').submit();
           }
        },{
         	 el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        }
        ])
    };

    
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
        var fileTypeArr = uploadformat;
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
        var markArr = ["#","%","&"];
        for(var i=0;i<markArr.length;i++){
            if(file.indexOf(markArr[i]) != -1){
                layer.msg("文件名不能包含特殊符，例如#,%,&等", {time: 1200}, function() {});
                return false;
            }
        }
        $upstate.show();
        $.ajaxFileUpload({
            url: '/credit/appeal/upload',
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
                    $(".filelabel").append("已上传" + text + "&nbsp;<span class='close-icon' path='" + data + "'></span>");
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

    //删除附件
    $(".filelabel").delegate('span','click',function(){
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


});


