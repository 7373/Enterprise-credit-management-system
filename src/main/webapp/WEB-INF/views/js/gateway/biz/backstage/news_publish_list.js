require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/busUtil', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, busUtil, http, handlebars) {

    var table;
    var searchParams=$("#newsPublishForm").serializeObject();
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	
        initDataTable();
        bind();
    }


    /**
     * 初始化dataTable
     */
    function initDataTable() {

        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#scene-table',
            scrollX: true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url: '/gateway/backstage/publish/doGetNewsPublishList.json',
                data: function (d) {
                d.params = searchParams;
                }
            },
            columns: [
                {data: null, defaultContent: 1, className: 'center'},
                {data: null,  className: 'center'},
                {data: 'title', className: 'center'},
                {data: 'state',  className: 'center'},
                {data: 'type1',  className: 'center'},
                {data: 'type2',  className: 'center'},
                {data: 'publisher',  className: 'center'},
                {data: 'publishTime',  className: 'center'},
                {data: 'updateTime',  className: 'center'},
                {data: 'createTime',  className: 'center'}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                    	//1.发布； 0.暂停
                        if (row.state == '0')
                            return "<span class='light-gray'><a href='javascript:void(0)' id='' class='view'>查看</a> | <a href='javascript:void(0)' id='' class='edit'>编辑</a> | <a href='javascript:void(0)' id='' class='publish'>发布</a> | <a href='javascript:void(0)' id='' class='delete'>删除</a></span>";
                        else if(row.state == '1')
                            return "<span class='light-gray'><a href='javascript:void(0)' id='' class='view'>查看</a> | <a href='javascript:void(0)' id='' class='stop'>暂停</a> | <a href='javascript:void(0)' id='' class='delete'>删除</a></span>";
                    }
                },{
                    targets: 3,
                    render: function (data, type, row, meta) {
                    	//1.发布； 0.暂停
                    	if (row.state == '0')
        					return '暂停';
                    	else if (row.state == '1')
        					return '发布';
                    }
                }
            ]
        })
    }
    
    
    function buildMenu2(uid){
        http.httpRequest({
                        url: '/gateway/backstage/catalog/selectCatalog2ByUID',
                        data: {"uid": uid},
                        success: function (data) {
                            $('#type2Code').append("<option value='' class='remove'>无</option>");
                        	$.each(data,function(i,n){//循环显示list中的值
                        		$('#type2Code').append("<option uid='"+n.uid+"' code='"+n.catalogName+"' value='"+n.catalogCode+"' class='remove levelTwo'>"+n.catalogName+"</option>");
                        	});
                        }
                    });
    }

    
//  表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#newsPublishForm").serializeObject();
        table.ajax.reload();
    }); 
    
    
    function bind() {
        util.bindEvents([{
            el: '#js-add',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: ['新增'],
                    area: ['800px', '600px'],
                    content: '/gateway/backstage/publish/enAdd',
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '.view',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '查看',
                    area: ['800px', '600px'],
                    content: '/gateway/backstage/publish/show?uid=' + data.uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '.delete',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/gateway/backstage/publish/delete',
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
            el: '.publish',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要发布吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/gateway/backstage/publish/publish',
                        data: {uid: data.uid},
                        success: function (data) {
                            if (data.status == 'success') {
                                //重新加载列表数据
                                if (data.msg) {
                                    layer.msg(data.msg, {time: 500}, function () {
                                        table.ajax.reload();
                                    });
                                }
                            }else{
                            	if (data.msg) {
                            		layer.confirm(data.msg, {icon: 2, title: '提示'});
                                        table.ajax.reload();
                                }
                            }
                        }
                    });

                });
            }
        }, {
            el: '.stop',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要暂停吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/gateway/backstage/publish/stop',
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
            el: '.edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '修改',
                    area: ['800px', '700px'],
                    content: '/gateway/backstage/publish/enEdit?uid=' + data.uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '#reset',
            event: 'click',
            handler: function () {
            	$('.clx').val('');
            }
        },{
            el: '#type1Code',
            event: 'change',
            handler: function () {
                $('.remove').remove();//移除之前存在的
                var uid=$("#type1Code option:selected").attr("uid");//根据UID获取一级目录选定的菜单
                var catalogOneCode=$('#type1Code option:selected').attr("catalogCode");
                if(catalogOneCode==''){
                    $('#type2Code').append("<option value='' class='remove'>无</option>");
                    return;
                }
                buildMenu2(uid);
            }
        }
        ])
    };


});


