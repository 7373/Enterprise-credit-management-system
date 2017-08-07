require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/busUtil', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, busUtil, http, handlebars) {

    var table;
    var searchParams=$("#sceneForm").serializeObject();
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
                url: '/gateway/backstage/catalog/doGetCatalogList.json',
                data: function (d) {
                d.params = searchParams;
                }
            },
            columns: [
                {data: null, defaultContent: 1, className: 'center'},
                {data: null,  className: 'center'},
                {data: 'catalogName1', className: 'center'},
                {data: 'catalogName',  className: 'center'},
                {data: 'catalogType',  className: 'center'},
                {data: 'createTime',  className: 'center'}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                          return "<span class='light-gray'><a href='javascript:void(0)' id='' class='delete'>删除</a></span>";
                    }
                }
            ]
        })
    }

    function bind() {
        util.bindEvents([{
            el: '#js-add',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: ['新增'],
                    area: ['800px', '600px'],
                    content: '/gateway/backstage/catalog/enAdd',
                    callback: function (data) {
                        //重新加载列表数据
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
                        url: '/gateway/backstage/catalog/delete',
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
        }
        ])
    };


});


