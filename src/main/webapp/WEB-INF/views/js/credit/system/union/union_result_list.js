require([ 'component/iframeLayer', 'component/dataTable', 'common/util',
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
							el : '#hx-table',
							scrollX : true, // 支持滚动
							showIndex : true,
							lengthMenu : [ 5, 10, 20, 50, 100 ],
							ajax : {
								url : '/credit/ndunion/info/rstList.json',
								type : 'post',
								// contentType:"json",
								data : function(d) {
									d.params = searchParams;
								}
							},
							columns : [ 
							     {data : null,defaultContent : 1,className : 'center'},
							     {data : null,className : 'center'},
							     {data : null,className : 'center'},
							     {data : 'jobNO',className : 'center'},
							     {data : 'assistReason',className : 'center'},
							     {data : 'handleStatue',className : 'center'},
							     {data : 'contactsDepName',className : 'center'},
							     {data : 'createTime',className : 'center'},
							     {data : 'recDepName',className : 'center'}
							     ],
							columnDefs : [ 
								{
									targets : 1,
									render : function(data, type, row, meta) {
										return "<a href='javascript:void(0)' id='' class='mr10 look' value=''>下载</a>";
									}
								},{
									targets : 2,
									render : function(data, type, row, meta) {
										return "<a href='javascript:void(0)' id='' class='mr10 look' value=''>查看</a>";
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
				util.bindEvents([
				     {
						el : '.return_modify',// 返回修改（2退回）
						event : 'click',
						handler : function() {
							var data = table.row(
									$(this).closest('td')).data();
							updateContractState(data.uid, "2");
						}
					},{
						el:"#selectDept",
						event:'click',
						handler:function(){
							doSelectDept();
						}
					}
				 ])
			};
			
			
		    //选择部门
		    function doSelectDept() {
		        var select_dept_url=window._CONFIG.select_dept_url;
		        layer.dialog({
		            title: '选择设置部门',
		            area: ['420px', '666px'],
		            content: select_dept_url,
		            callback: function (data) {
		                $("#orgName").val(data.orgName);
		                $("#orgCode").val(data.orgCode);
		            }
		        })
		    }

});
