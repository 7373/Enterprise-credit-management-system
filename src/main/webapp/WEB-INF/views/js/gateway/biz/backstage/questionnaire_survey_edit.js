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
        $('#questionnaireForm').validate({
             rules: {
            	 problem: {
                     required: true
                 },
            	 optionA: {
                     required: true
                 },
		        optionB: {
		            required: true
		        },
		        surveyTimeStart: {
	                 required: true
	             },
	             surveyTimeEnd: {
		            required: true
		        }
             },
             messages: {
            	 problem: {
                     required: '问题不能为空',
                 },
            	 optionA: {
                     required: '选项A不能为空',
                 },
                 optionB: {
                     required: '选项B不能为空',
                 },
                 surveyTimeStart: {
                     required: '调研开始时间不能为空',
                 },
                 surveyTimeEnd: {
                     required: '调研结束时间不能为空',
                 }
             },
             submitHandler: function () {
                 var formParam = $('#questionnaireForm').serializeObject();
                 console.log($('#flag').val());
                 http.httpRequest({
                     url: '/gateway/backstage/questionnaire/edit',
                     serializable: false,
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
         	 el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        },{
        	 el: '#publish',
             event: 'click',
             handler: function () {
            	 $('#flag').val("1");//1:发布
            	 $('#questionnaireForm').submit();
             }
         },{
        	 el: '#submit',
             event: 'click',
             handler: function () {
            	 $('#flag').val("0");//0:提交
            	 $('#questionnaireForm').submit();
             }
         }
        ])
    };


});


