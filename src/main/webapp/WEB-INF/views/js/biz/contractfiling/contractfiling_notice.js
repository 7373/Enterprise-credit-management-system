require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery',
         'jquery.serialize','laydate','common/validateRules'],
         function (layer, dataTable, util, http,handlebars) {
	
	init();
    
	function init() {
		$('#entName').html(window.opener.document.getElementById('entName').value);
		$('#contractName').html(window.opener.document.getElementById('contractName').value);
		$('.registTime').html(window.opener.document.getElementById('registTime').value);
		$('.backTime').html(window.opener.document.getElementById('backTime').value);
		$('#recordNO').html(window.opener.document.getElementById('recordNO').value);
    }
    
})
