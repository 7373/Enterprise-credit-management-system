require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery',
         'jquery.serialize','laydate','common/validateRules'],
         function (layer, dataTable, util, http,handlebars) {
	
	init();
    
	function init() {
		$('#entName').html(window.opener.document.getElementById('entName').value);
		$('#contractName').html(window.opener.document.getElementById('contractName').value);
		$('#backTime').html(window.opener.document.getElementById('backTime').value);
		$('#recordBackNO').html(window.opener.document.getElementById('recordBackNO').value);
    }
    
})
