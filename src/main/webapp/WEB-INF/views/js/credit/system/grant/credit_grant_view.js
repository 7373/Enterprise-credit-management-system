require(['component/iframeLayer',
         'component/dataTable',
         'common/util',
         'common/http',
         'handlebars',
         'jquery','jquery.serialize'], function (layer, dataTable, util, http, handlebars) {

	var hxForm = $("#hxForm").serializeObject();
	var userName= $("#userName").val();
	var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        initTable();
    }
    function initTable(){
    	var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
    	table = dataTable.load({
    		el:'#grantInfo-table',
    		scrollX : true, // 支持滚动
			showIndex : true,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url:'/credit/ndgrant/doReadNdGrantListJSON',
				type:'post',
				data:function(d){
					d.params=hxForm;
				}
			},
			columns:[{
				data:null,
				className:'center'
			},{
				data:'graUserName',
				className:'center'
			},{
				data:'graNo',
				className:'center'
			},{
				data:'graName',
				className:'center'
			},{
				data:'graStartLine',
				className:'center'
			},{
				data:'graDeadLine',
				className:'center'
			},{
				data:null,
				className:'center'
			}],
			columnDefs:[{
				targets: 1,
                render: function (data, type, row, meta) {
                	return userName;
                }
			},{
				targets:6,
				render:function(data, type, row, meta){
					var context = {
                            func: [
                                {
                                    'text': '编辑',
                                    'class': 'js-edit'
                                },
                                {
                                    'text': '删除',
                                    'class': 'js-delete'
                                }
                            ]
                        };
                        return template(context);
				}
			}]
    	})
    	
    }
    function bind() {
        util.bindEvents([{
        	el:'.js-edit',
        	event:'click',
        	handler:function(){
        		var data = table.row($(this).closest('td')).data();
        		console.log(data)
                layer.dialog({
                    title: '授权',
                    area: ['628px', '450px'],
                    content: '/credit/ndgrant/doEnEditGrant?uid=' + data.uid,
                    callback: function (data) {
                    	 table.ajax.reload();
                    }
                })
        	}
        		
        },{
        	el:'.js-delete',
        	event:'click',
        	handler:function(){
        		var data = table.row($(this).closest('td')).data();
        		console.log(data)
        		 layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                     http.httpRequest({
                         url: '/credit/ndgrant/doAddAndEditGrant',
                         data: {'uid': data.uid,'graIsDel':1,'id':data.id},
                         success: function (data) {
                             if (data.status == 'success') {
                                 //重新加载列表数据
                                 if (data.msg) {
                                     layer.msg(data.msg, {time: 500}, function () {
                                         table.ajax.reload();
                                     });
                                 }
                             }
                         }
                     });

                 });
        	}
        }])
    }
})