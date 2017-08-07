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
        $('#catalogForm').validate({
            rules: {
            	uid: {
                    required: true
                },
                catalogName: {
                	required: true
                },
                catalogType: {
                    required: true
                }
            },
            messages: {
            	catalogName1: {
                    required: '一级目录不能为空',
                },
                catalogName2: {
                	required: '二级目录不能为空',
                },
                catalogType: {
                    required: '目录类别不能为空'
                }
            },
            submitHandler: function () {
                var formParam = $('#catalogForm').serializeObject();
                http.httpRequest({
                    url: '/gateway/backstage/catalog/save',
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
        })
    }
    
    
    function bind() {
        util.bindEvents([{
            el: '#search',
            event: 'click',
            handler: function () {
            	var parentID = $(":selected").attr("code");
            	$('#parentID').val(parentID);
            	$('#catalogForm').submit();
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


