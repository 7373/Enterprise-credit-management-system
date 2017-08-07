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
								url : '/credit/grbase/grlist.json',
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
								data : "xm",
								width : '130px',
								className : 'center'
							}, {
								data : "sfzhmJm",
								width : '130px',
								className : 'center'
							}, {
								data : "listType",
								width : '130px',
								className : 'center'
							}, {
								data : null,
								width : '60px',
								defaultContent : 1,
								className : 'center'
							} 
							],
							columnDefs : [ 
							               {
								targets : 3,
								render : function(data, type, row, meta) {
									if(row.listType=='r')
										return "涉及红名单";
									if(row.listType=='b')
										return "涉及黑名单";
									else
										return "";
								}
							},{
								targets : 4,
								render : function(data, type, row, meta) {
									return "<a href='javascript:void(0)' id='' class='mr10 look' value='"+row.sfzhmDesc+"'>查看</a>";
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
				},{
					el : '.look',
					event : 'click',
					handler : function() {
						if($(this).text()==0) return;
						window.open('/credit/grbase/grxq?uid='+ $(this).attr('value'));
					}
				}])
			}
			;

		});

