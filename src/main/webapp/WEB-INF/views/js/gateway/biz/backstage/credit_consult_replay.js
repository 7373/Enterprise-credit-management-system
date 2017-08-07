require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules', 'common/ajaxfileupload'], function (layer, dataTable, util, http, busUtil,handlebars) {

    var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	
        bind();
        formValid();
    }
  
    
    

    
    function formValid() {
       $('#consultForm').validate({
            rules: {
            	realName: {
                    required: true
                }
            },
            messages: {
            	realName: {
                    required: '真实姓名不能为空',
                }
            },
            submitHandler: function () {
                var formParam = $('#consultForm').serializeObject();
                http.httpRequest({
                    url: '/gateway/backstage/consult/replay',
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
        	   $('#consultForm').submit();
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


