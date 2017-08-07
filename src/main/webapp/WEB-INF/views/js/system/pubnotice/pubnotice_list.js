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
            ajax: '/admin/pubnotice/list.json',
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
          //是否加索引值
            showIndex: true,
            
            columns: [
                {data: null,width:'60px',defaultContent:1,className: 'center'},
                {data: 'noticeName', width: '150px'},
                {data: 'createTime', width: '120px'},
                {data: 'endTime', width: '120px'},
                {data: null, width: '100px', className: 'center'}
            ],
            columnDefs: [
                {
                    targets: 4,
                    render: function (data, type, row, meta) {
                    	 return "<a href='javascript:void(0)' class='mr10 js-delete'>删除</a>";
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
                    content: '/admin/pubnotice/enAdd',
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
                        url: '/admin/pubnotice/delete',
                        data: {uid: data.uid},
                        type:'post',
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
        }
        ])
    };
});


