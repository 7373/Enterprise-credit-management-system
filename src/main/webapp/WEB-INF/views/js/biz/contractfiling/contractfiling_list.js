require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/busUtil', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, busUtil, http, handlebars) {

    var table;
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
            el: '#contract-table',
            scrollX: true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url: '/biz/contract/doGetContarctList.json',
                data: function (d) {
                    d.params = {'userId': $('#userId').val()};
                }
            },
            columns: [
                {data: null, defaultContent: 1, className: 'center'},
                {data: null,  className: 'center'},
                {data: null, className: 'center'},
                {data: 'contractName',  className: 'center'},
                {data: 'state',  className: 'center'},
                {data: 'createTime',  className: 'center'},
                {data: 'registTime',  className: 'center'}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
//				    	"0":"未提交"  "1":"已提交"  "2":"退回"   "3":"已备案"  "4":"已修改" "5":"未修改" 
                        if (row.state == '0')
                            return "<span class='light-gray'><a href='javascript:void(0)' id='' class='view'>查看</a> | <a href='javascript:void(0)' id='' class='eidt'>修改</a> | <a href='javascript:void(0)' id='' class='delete'>删除</a></span>";
                        else if(row.state == '2')
                            return "<span class='light-gray'><a href='javascript:void(0)' id='' class='view'>查看</a> | <a href='javascript:void(0)' id='' class='eidt'>修改</a> | <a href='javascript:void(0)' id='' class='delete'>删除</a></span>";
                        else if( row.state == '3')
                            return "<span class='light-gray'><a href='javascript:void(0)' id='' class='view'>查看</a></span>";
                        else
                            return "<span class='light-gray'><a href='javascript:void(0)' id='' class='view'>查看</a></span>";
                    }
                }, {
                    targets: 2,
                    render: function (data, type, row, meta) {
                    	if (row.state == '5' || row.state == '4')
                            return row.recordBackNO;
                        else
                            return row.recordNO;
                    }
                }, {
                    targets: 4,
                    render: function (data, type, row, meta) {
                        return busUtil.bizFmtState(row.state);
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
                    title: ['新增'],
                    area: ['800px', '600px'],
                    content: '/biz/contract/enAdd',
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
                    content: '/biz/contract/show?uid=' + data.uid,
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
                        url: '/biz/contract/delete',
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
            el: '.eidt',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '修改',
                    area: ['800px', '700px'],
                    content: '/biz/contract/enEdit?uid=' + data.uid,
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


