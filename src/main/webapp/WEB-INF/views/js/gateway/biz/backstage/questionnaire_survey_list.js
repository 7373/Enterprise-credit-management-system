require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/busUtil', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, busUtil, http, handlebars) {

    var table;
    var searchParams=$("#questionnaireForm").serializeObject();
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
            el: '#questionnaire-table',
            scrollX: true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url: '/gateway/backstage/questionnaire/doGetQuestionnaireSurveyList.json',
                data: function (d) {
                d.params = searchParams;
                }
            },
            columns: [
                {data: null, defaultContent: 1, className: 'center'},
                {data: null,  className: 'center'},
                {data: 'createTime', className: 'center'},
//                {data: 'surveyTimeStart',  className: 'center'},
//                {data: 'surveyTimeEnd',  className: 'center'},
                {data: 'problem',  className: 'center'},
                {data: null,  className: 'center'},
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                    	//1：已发布； 0：未发布
                    	console.log(row);
                        if (row.publishState == '0')
                            return "<span class='light-gray'><a href='javascript:void(0)' id='' class='view'>查看</a> | <a href='javascript:void(0)' id='' class='edit'>编辑</a> | <a href='javascript:void(0)' id='' class='publish'>发布</a> | <a href='javascript:void(0)' id='' class='delete'>删除</a></span>";
                        else if(row.publishState == '1')
                            return "<span class='light-gray'><a href='javascript:void(0)' id='' class='view'>查看</a> | <a href='javascript:void(0)' id='' class='delete'>删除</a> </span> | <a href='javascript:void(0)' id='' class='stop'>暂停</a> </span>";
                    }
                },{
                    targets: 4,
                    render: function (data, type, row, meta) {
        					return "<span class='light-gray'><a href='javascript:void(0)' id='' class='detail'>详情</a> </span>";
                    }
                }
            ]
        })
    }
    
    
    function bind() {
        util.bindEvents([ {
            el: '.view',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '查看',
                    area: ['800px', '600px'],
                    content: '/gateway/backstage/questionnaire/show?uid=' + data.uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '.edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '编辑',
                    area: ['800px', '700px'],
                    content: '/gateway/backstage/questionnaire/enEdit?uid=' + data.uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '.detail',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                        title : '问卷统计',
                        area : [ '800px', '700px' ],
                        content : '/gateway/reception/surveyresult/doEnBarGraph?uid='+data.uid,
                        callback : function(data) { }
                })
            }
        }, {
            el: '.publish',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要发布吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/gateway/backstage/questionnaire/publish',
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
            el: '.stop',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要暂停吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/gateway/backstage/questionnaire/stop',
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
            el: '.delete',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/gateway/backstage/questionnaire/delete',
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
        	el: '#js-add',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: ['新增'],
                    area: ['800px', '600px'],
                    content: '/gateway/backstage/questionnaire/enAdd',
                    callback: function (data) {
                        //重新加载列表数据
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


