require(
		[ 'component/iframeLayer', 'component/dataTable', 'common/util',
				'common/http', 'common/busUtil', 'handlebars', 'jquery',
				'jquery.serialize', 'laydate' ],
		function(layer, dataTable, util, http, busUtil, handlebars) {
			var taxCreditLevelTable,wageBlackListTable;
			var searchParams = $("#hxForm").serializeObject();// 查询参数申明!
			//var searchParamA = $("#wageForm").serializeObject();// 查询参数申明!
			init();
			/**
			 * 初始化函数集合
			 */
			function init() {
				initTaxCreditLevelTable();
				initWageBlackListTable();
			}

			/**
			 * 纳税信用等级评定信息
			 */
			function initTaxCreditLevelTable() {
				taxCreditLevelTable = dataTable
						.load({
							el : '#taxCreditLevelTable',
							scrollX : true, // 支持滚动
							showIndex : false,
							lengthMenu : [ 5, 10, 20, 50, 100 ],
							ajax : {
								url : '/credit/taxcreditlevel/list',
								type : 'post',
								data : function(d) {
									d.params = searchParams;
								}
							},
							columns : [ {
								data : "taxName",
								className : 'center'
							}, {
								data : "creditLevel",
								className : 'center'
							}, {
								data : "uniscid",
								className : 'center'
							}],"fnDrawCallback": function (data) {
								//$("#ajjlhxx").html(data._iRecordsTotal);
							}
						})
			}
			/**
			 * 初始化企业国土局黑名单（不良信息）表
			 */
			function initWageBlackListTable() {
				wageBlackListTable = dataTable
						.load({
							el : '#wageBlackListTable',
							scrollX : true, // 支持滚动
							showIndex : false,
							lengthMenu : [ 5, 10, 20, 50, 100 ],
							ajax : {
								url : '/credit/wageblacklist/list',
								type : 'post',
								data : function(d) {
									d.params = searchParams;
								}
							},
							columns : [ {
								data : "qymc",
								className : 'center'
							}, {
								data : "regno",
								className : 'center'
							}, {
								data : "wageAmount",
								className : 'center'
							}, {
								data : "startDate",
								className : 'center'
							}, {
								data : "endDate",
								className : 'center'
							}],"fnDrawCallback": function (data) {
								//$("#gtjblxx").html(data._iRecordsTotal);
							}
						})
			}

		});

