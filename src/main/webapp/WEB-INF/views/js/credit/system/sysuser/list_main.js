require(['component/iframeLayer',
         'component/dataTable',
         'common/util',
         'common/http',
         'handlebars',
         'jquery','jquery.serialize'], function (layer, dataTable, util, http, handlebars) {

	var searchParams=$("#hxForm").serializeObject();
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            ajax: {
                url:'/credit/system/sysuser/list.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: 'username', width: '100px'},
                {data: 'realName'},
                {data: 'email'},
                {data: 'status'},
                {data: 'createTime', width: '150px'},
                {data: 'lastLoginTime', width: '150px'},
                {data: null, width: '200px', className: 'center'}
            ],
            columnDefs: [
                {
                    targets: 6,
                    render: function (data, type, row, meta) {
                        var context = {
                            func: [
                                {
                                    'text': '编辑',
                                    'class': 'js-edit'
                                },
                                {
                                    'text': '删除',
                                    'class': 'js-delete'
                                },
                                {
                                    'text': '授权',
                                    'class': 'js-grant'
                                },{
                                	'text':'查看授权',
                                	'class':'js-seeGrant'
                                }
                            ]
                        };
                        return template(context);
                    }
                }
            ]
        })
    }
//  表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#hxForm").serializeObject();
        table.ajax.reload();
    }); 
    
    function bind() {
        util.bindEvents([{
            el: '.js-add',
            event: 'click',
            handler: function () {
                layer.dialog({
                                                      title: '新增用户',
                    area: ['628px', '450px'],
                    content: '/credit/system/sysuser/show',
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '编辑用户',
                    area: ['628px', '450px'],
                    content: '/credit/system/sysuser/show?uid=' + data.uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '.js-delete',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/credit/system/sysuser/delete',
                        data: {uid: data.uid},
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
        }, {
            el: '.js-grant',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '授权',
                    area: ['628px', '450px'],
                    content: '/credit/ndgrant/doEnAddAndEditGrant?userID=' + data.uid,
                    callback: function (data) {
                    }
                })
            }
        },{
        	el:'.js-seeGrant',
        	event:'click',
        	handler:function(){
        		var data =table.row($(this).closest('td')).data();
        		layer.dialog({
        			title:'查看授权',
        			area: ['980px', '450px'],
        			content:'/credit/ndgrant/list?userID=' + data.uid,
        			callback:function(data){
        				
        			}
        		})
        	}
        }])
    };
});


