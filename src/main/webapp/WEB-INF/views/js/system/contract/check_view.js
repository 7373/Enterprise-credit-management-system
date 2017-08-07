require(['component/iframeLayer', 'common/util', 'common/http', 'layer1', 'jquery.validate', 'jquery.serialize'], function (layer, util, http) {

    init();

    /**
     * 初始化函数集合
     */

    function init() {
        bind();
        formValidate();
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        }])
    }
	$(":radio").change(function(){
		var radioText = $(this).val();
		$("#checkView").val("");
		$("#checkView").val(radioText);
	});
    function formValidate(){
    	$('#hxForm').validate({
    		rules: {
    			checkView:{required:true},//审核意见
    		},
    		messages:{
    			checkView:{required:"请输入处理意见"}
    		},
    		onkeyup:false,
            showErrors:function(errorMap,errorList){
           	 for(var i in errorMap){
                 layer.tips(errorMap[i],$('#hxForm input[name='+i+'],textarea[name='+i+']'),{
                     tips:3,
                     tipsMore:true,
                     ltype:0
                 });
              }
            },
            submitHandler: function () {
            	
                    http.httpRequest({
                        url: '/admin/accept/updateContractState',
                        data: {uid: $('#uid').val(),state:"2",checkView:$('#checkView').val()},
                        type: 'post',
                        success: function (data) {
                            layer.msg(data.msg, {time: 1000}, function () {
                            	if(data.status=='success'){
                            		layer.close({reload: true});
                            	}
                            });
                        }
                    });
            }
        });
    }

})
