require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules', 'common/ajaxfileupload'], function (layer, dataTable, util, http,handlebars) {
	
    init();
    
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }
     
    function bind() {
        util.bindEvents([{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        }])
    };
    
	//下载预览
    $(".filelabel").delegate('a', 'click', function () {
        var path = $(this).attr("path");
        window.location.href="/biz/entuser/download?fileName=" + path;
      });
	
})
