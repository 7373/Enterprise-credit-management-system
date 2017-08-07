require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http','common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules', 'common/ajaxfileupload'], function (layer, dataTable, util, http,busUtil,handlebars) {

	init();
    
    /**
     * 初始化函数集合
     */
    function init() {
    	contractTypeSelect();
    	bind();
    }
    
    function contractTypeSelect(){
    	$('#contractType').val(busUtil.fmtFcfType($('#contractTypeCode').val()));
    }
    
    
    
    //下载预览
    $(".filelabel").delegate('a', 'click', function () {
        var path = $(this).attr("path");
        window.location.href="/biz/entuser/download?fileName=" + path;
    });
	
    
    function bind() {
        util.bindEvents([{
        	 el: '.filing_notice',
             event: 'click',
             handler: function () {
            	 if($('#state').val() =='3')
            		 window.open("/biz/contract/filing_notice","_blank");
            	 else
            		 window.open("/biz/contract/filing_noticeforTH","_blank");
            	 
             }
         },{
             el: '#close',
             event: 'click',
             handler: function () {
             	layer.close();
             }
         }
         ]);
    }
    
})
