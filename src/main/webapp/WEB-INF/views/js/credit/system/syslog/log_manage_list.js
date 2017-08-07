require(
		[ 'component/iframeLayer', 'component/dataTable', 'common/util',
				'common/http', 'common/busUtil', 'handlebars', 'jquery',
				'jquery.serialize', 'laydate' ],
		function(layer, dataTable, util, http, busUtil, handlebars) {
			var table;
			var logParams = $("#hxForm").serializeObject();// 查询参数申明!
			var url="";
			var type=$("#userType").attr("name");
			if(type=='1'){
				url="/gateway/system/syslog";
			}else{
				url="/credit/system/syslog";
			}
			init();
			/**
			 * 初始化函数集合
			 */
			function init() {
				initDataTable();
			}

			/**
			 * 初始化dataTable
			 */
			function initDataTable() {
				table = dataTable
						.load({
							// 需要初始化dataTable的dom元素
							el : '#log-table',
							scrollX : true, // 支持滚动
							showIndex : true,
							lengthMenu : [ 5, 10, 20, 50, 100 ],

							ajax : {
								url : url+'/list.json',
								type : 'post',
								//contentType:"json",
								data : function(d) {
									d.params=logParams;
								}
							},
							// 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
							// className不要写成class
							columns : [ {
								data : null,
								defaultContent : 1,
								className : 'center'
							}, {
								data : "logLoginName",
								className : 'center'
							}, {
								data : "logMsg",
								className : 'center'
							}, {
								data : "logDate",
								className : 'center'
							}],
							columnDefs : []
						})
			}

		});

