require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/busUtil', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, busUtil, http, handlebars) {

    var table;
    var searchParams=$("#consultForm").serializeObject();
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
            el: '#consult-table',
            scrollX: true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url: '/gateway/backstage/consult/doGetCreditConsultList.json',
                data: function (d) {
                d.params = searchParams;
                }
            },
            columns: [
                {data: null, defaultContent: 1, className: 'center'},
                {data: null,  className: 'center'},
                {data: 'messageStatus', className: 'center'},
                {data: 'messageTitle',  className: 'center'},
                {data: 'messageType',  className: 'center'},
                {data: 'createTime',  className: 'center'},
                {data: 'optTime',  className: 'center'},
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                    	//1.发布； 0.暂停
                    	console.log(row);
                        if (row.messageStatus == '0')
                            return "<span class='light-gray'><a href='javascript:void(0)' id='' class='replay'>回复</a></span>";
                        else if(row.messageStatus == '1')
                            return "<span class='light-gray'><a href='javascript:void(0)' id='' class='view'>详情</a> </span>";
                    }
                },{
                    targets: 2,
                    render: function (data, type, row, meta) {
                    	//1.发布； 0.暂停
                    	console.log(row);
                    	if (row.messageStatus == '0')
        					return '待回复';
                    	else if (row.messageStatus == '1')
        					return '已回复';
                    }
                }
            ]
        })
    }
    
    
//  表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#consultForm").serializeObject();
        table.ajax.reload();
    }); 
    
    
    function bind() {
        util.bindEvents([ {
            el: '.view',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '详情',
                    area: ['800px', '600px'],
                    content: '/gateway/backstage/consult/show?uid=' + data.uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '.replay',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '回复',
                    area: ['800px', '700px'],
                    content: '/gateway/backstage/consult/showReplay?uid=' + data.uid,
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
        }
        ])
    };


});


