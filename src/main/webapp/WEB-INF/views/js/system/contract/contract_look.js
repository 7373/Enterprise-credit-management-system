require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http','common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules', 'common/ajaxfileupload'], function (layer, dataTable, util, http,busUtil,handlebars) {
	
    init();
    
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    	contractTypeSelect();
    	
    }
    
    function contractTypeSelect(){
    	$('#contractType').val(busUtil.fmtFcfType($('#contractTypeCode').val()));
    }
    
    
    
	//下载预览
    $(".filelabel").delegate('a', 'click', function () {
        var path = $(this).attr("path");
        window.location.href="/biz/entuser/download?fileName=" + path;
      });
    
    function bind(){
    	util.bindEvents([{
    		el:'.upload_instruction',
    		event:'click',
    		handler: function(){
    			window.open('/admin/accept/upload_instruction');
    		}
    	},{
       	 el: '.filing_notice',
         event: 'click',
         handler: function () {
        	 window.open("/admin/accept/filing_notice","_blank");
//         	parent.window.open ('/admin/accept/filing_notice?contractName=' +$("#contractName").val()+ "&registTime="+$("#registTime").val()+"&entName="+$("#entName").val()+"&recordNO="+$("#recordNO").val());
         }
     },{
       	 el: '#close',
         event: 'click',
         handler: function () {
         	layer.close();
         }
     }
    		
    	])
    }
	
})
