require(['common/util', 'component/iframeLayer', 'common/http', 'jquery.validate', 'jquery','jquery.serialize', 'common/ajaxfileupload'], function (util, layer, http) {
	init();
	
	function init() {
        bind();
    }
     
	
    /**
     * 事件绑定
     */
    function bind() {
        util.bindEvents([{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        }
        ])
    }
    
	
})