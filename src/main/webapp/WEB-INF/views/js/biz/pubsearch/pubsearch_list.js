require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate'],
		function (layer, dataTable, util, http, busUtil,handlebars) {
$(function(){
    		$("#search").click(goFind);
    		function goFind(){
    	    	var entName = $("#Entname").val();
    	    	if(entName==null || entName.trim()==""){
    	    		layer.msg('输入格式不正确',{time:3000});
    	    		return;
    	    	};
    	    	window.location.href="/pub/publicity_list?entName="+entName;
    	    };
    	    $("#Entname").keyup(function(e) {
                e = e || e.event;
                if (e.keyCode == 13) {
                    goFind();
                }
            });
    	    //预览
    	    $(".down").click(function () {
    	        window.location.href="/biz/entuser/download?fileName=" + this.id;
    	    });
});
})