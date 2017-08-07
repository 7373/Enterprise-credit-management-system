require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules', 'common/ajaxfileupload'], function (layer, dataTable, util, http, busUtil,handlebars) {

    var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initValue();
        bind();
        formValid();
    }
  
    
   
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
 	  editor1.readonly(true);
 	  var _html = editor1.html();//获取插件中的内容
  	$("#content").val(_html);
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
                    url: '/gateway/backstage/publish/add',
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


});


