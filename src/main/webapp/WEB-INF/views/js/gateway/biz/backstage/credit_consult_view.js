require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules', 'common/ajaxfileupload'], function (layer, dataTable, util, http, busUtil,handlebars) {

    var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	
        bind();
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
    };


});


