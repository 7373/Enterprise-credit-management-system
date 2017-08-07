require(
		[ 'component/iframeLayer', 'component/dataTable', 'common/util',
				'common/http', 'common/busUtil', 'handlebars', 'jquery',
				'jquery.serialize', 'laydate' ],
		function(layer, dataTable, util, http, busUtil, handlebars) {
			var table;
			var searchParams = $("#qyRedBlackForm").serializeObject();// 查询参数声明!

			init();
			/**
			 * 初始化函数集合
			 */
			function init() {
				initDataTable();
				bind()
			}

			/**
			 * 初始化dataTable
			 */
			function initDataTable() {
				table = dataTable.load({
							// 需要初始化dataTable的dom元素
							el : '#qyRedBlackTable',
							scrollX : true, // 支持滚动
							showIndex : true,
							lengthMenu : [ 5, 10, 20, 50, 100 ],

							ajax : {
								url : '/credit/redBlackList/data.json',
								type : 'post',
								data : function(d) {
									d.params = searchParams;
								}
							},
							// 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
							// className不要写成class
							columns : [ {
								data : null,
								width : '60px',
								defaultContent : 1,
								className : 'center'
							}, {
								data : "partyName",
								width : '130px',
								className : 'center'
							}, {
								data : "unicode",
								width : '130px',
								className : 'center'
							}, {
								data : "importDept",
								width : '130px',
								className : 'center'
							},{
								data:"inclusion",
								width:'130px',
								className:'center'
							},{
								data:'occurrDate',
								width:'130px',
								className:'center'
							},{
								data:'includeListDate',
								width:'130px',
								className:'center'
							}]
						})
			}
			// 表格之外的查询按钮事件
			$("#qySearch").click(function() {
				searchParams = $("#qyRedBlackForm").serializeObject();
				table.ajax.reload();
			});

			function bind() {
				util.bindEvents([ {
					el : '#qyReset',
					event : 'click',
					handler : function() {
						$('.clx').val('');
					}
				}
				 ])
			}
			;

		});

