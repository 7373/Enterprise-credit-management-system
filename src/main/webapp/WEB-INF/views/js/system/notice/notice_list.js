require(['component/iframeLayer',
         'component/dataTable',
         'common/util',
         'common/http',
         'handlebars',
         'jquery'], function (layer, dataTable, util, http, handlebars) {

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
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#notice-table',
            ajax: '/admin/notice/list.json',
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
          //是否加索引值
            showIndex: true,
            
            columns: [
                {data: null,width:'60px',defaultContent:1,className: 'center'},
                {data: 'noticeName'},
                {data: 'publisher'},
                {data: 'publishDept'},
                {data: 'createTime', width: '150px'},
                {data: null, width: '120px', className: 'center'}
            ],
            columnDefs: [
                {
                    targets: 5,
                    render: function (data, type, row, meta) {
                    	 return "<a href='javascript:void(0)' class='mr10 js-view'>查看</a><em>   </em><a href='javascript:void(0)' class='mr10 js-delete'>删除</a>";
                    }
                }
            ]
        })
    }

    function bind() {
        util.bindEvents([{
            el: '.js-add',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '新增公告',
                    area: ['628px', '380px'],
                    content: '/admin/notice/enAdd',
                    callback: function (data) {
                        //重新加载列表数据
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
                        url: '/admin/notice/delete',
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
            el: '.js-view',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '查看公告',
                    area: ['628px', '380px'],
                    content: '/admin/notice/view?uid=' + data.uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }
        ])
    };
});


