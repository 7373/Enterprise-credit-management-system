require(
		[ 'component/iframeLayer', 'component/dataTable', 'common/util',
				'common/http', 'common/busUtil', 'handlebars', 'jquery',
				'jquery.serialize', 'laydate' ],
		function(layer, dataTable, util, http, busUtil, handlebars) {
			var table;
			var searchParams = $("#hxForm").serializeObject();// 查询参数声明!

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
				table = dataTable
						.load({
							// 需要初始化dataTable的dom元素
							el : '#contract-table',
							scrollX : true, // 支持滚动
							showIndex : true,
							lengthMenu : [ 5, 10, 20, 50, 100 ],

							ajax : {
								url : '/credit/ndShareInfo/search',
								type : 'post',
								//contentType:"json",
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
								data : "unitName",
								width : '130px',
								className : 'center'
							}, {
								data : "infoTitle",
								width : '130px',
								className : 'center'
							}, {
								data : "infoType",
								width : '130px',
								className : 'center'
							}, {
								data : "nper",
								width : '130px',
								className : 'center'
							}, {
								data : "seePermission",
								width : '130px',
								className : 'center'
							}, {
								data : null,
								width : '60px',
								className : 'center'
							} 
							],
							columnDefs : [{
								targets : 6,
								render : function(data, type, row, meta) {
									return "<a href='javascript:void(0)' id='' class='mr10 look' value='"+row.sfzhm+"'>查看</a>";
								}
							}

							]
						})
			}
			// 表格之外的查询按钮事件
			$("#search").click(function() {
				searchParams = $("#hxForm").serializeObject();
				table.ajax.reload();
			});

			function bind() {
				util.bindEvents([ {
					el : '#reset',
					event : 'click',
					handler : function() {
						$('.clx').val('');
					}
				}
			  ])
				
			};

		});

