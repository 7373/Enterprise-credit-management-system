require(
		['component/iframeLayer', 
         'component/dataTable', 
         'common/util', 
         'common/http', 
         'handlebars', 
         'jquery',
         'jquery.serialize',
         'laydate',
         'jquery.validate',
         'pagination'],
		function(layer, dataTable, util, http, busUtil, handlebars) {
			var table;
			var searchParams = $("#hxForm").serializeObject();// 查询参数申明!
			init();
			/**
			 * 初始化函数集合
			 */
			function init() {
				initTable();
				initZyjszcTableInfoTable();
				bind();
			}

			/**
			 * 初始化dataTable
			 */
			function initTable() {
				table = dataTable.load({
							// 需要初始化dataTable的dom元素
							el : '#hxTeble',
							scrollX : true, // 支持滚动
							showIndex : true,
							lengthMenu : [ 5, 10, 20, 50, 100 ],
							ajax : {
								url : '/credit/qybase/qylist.json',
								type : 'post',
								data : function(d) {
									d.params = {'frdbzjh':$('#idCard').val()};
								}
							},
							// 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
							// className不要写成class
							columns : [ 
					           {data: null, className: 'center'},
					           {data: 'qymc',  className: 'center'},
				                {data: 'gszch', className: 'center'},
				                {data: 'qyzt',  className: 'center'},
				                {data: null,  className: 'center'}
					           ],
					            columnDefs: [
					                         {
					                             targets: 4,
					                             render: function (data, type, row, meta) {
					                             	return "法人代表";
					                             }
					                         }
					                     ],
					           "fnDrawCallback": function (oSettings) {
								 $("#glCount").text(oSettings._iRecordsTotal);
					    		}
						})
			}
			/**
			 * 县级核发的专业技术职称证书信息  人社局
			 * @returns
			 */
			
			function initZyjszcTableInfoTable() {
				table = dataTable.load({
					el : '#zyjszcTable',
					scrollX : true, // 支持滚动
					showIndex : false,
					lengthMenu : [ 5, 10, 20, 50, 100 ],
					ajax : {
						url : '/credit/ndTowmSkillCertInfo/data.json',
						type : 'post',
						data : function(d) {
							d.params = searchParams;
						}
					},
					columns : [ {
						data : 'name',
						className : 'center'
					}, {
						data : 'idCardDesc',
						className : 'center'
					}, {
						data : 'certType',
						className : 'center'
					}, {
						data : 'certNO',
						className : 'center'
					}, {
						data : 'certNumber',
						className : 'center'
					}, {
						data : 'titleType',
						className : 'center'
					} , {
						data : 'titleClass',
						className : 'center'
					} , {
						data : 'grantDate',
						className : 'center'
					}, {
						data : 'evaluateUnit',
						className : 'center'
					} ],
					"fnDrawCallback" : function(data) {
						$("#count").text(data._iRecordsTotal);
					}
				})
			}
			
			
			function bind() {
			};

		});

