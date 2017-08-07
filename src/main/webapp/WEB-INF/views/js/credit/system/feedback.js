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
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        },{
        	el:'#confirm',
        	event:'click',
        	handler:function(){
        		var formData = $("#formData").serializeObject();
        		$.ajax({
        			url:'/credit/appeal/feedback',
        			data:formData,
        			type:'post',
        			dataType:'json',
        			success:function(data){
        				if(data.status=="success"){
        					layer.close();
        					
        				}
        			},
        			error:function(){
        				layer.msg("网络故障",{time:500});
        			}
        		})
        	}
        }
        ])
    }
    
	
})