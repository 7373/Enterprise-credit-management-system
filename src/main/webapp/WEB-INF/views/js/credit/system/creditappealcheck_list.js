require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/busUtil', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, busUtil, http, handlebars) {

    var table;
    var searchParams = $("#hxForm").serializeObject();// 查询参数声明!
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
            el: '#hxTable',
            scrollX: true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url: '/credit/appeal/appeallist.json',
                data: function (d) {
                	d.params = searchParams;
                }
            },
            columns: [
                {data: null, defaultContent: 1, className: 'center'},
                {data: null,  className: 'center'},
                {data: 'endState', className: 'center'},
                {data: 'appealName',  className: 'center'},
                {data: 'appealOrgan',  className: 'center'},
                {data: 'appealContent',  className: 'center'},
                {data: 'proveMaterial',  className: 'center'},
                {data: 'appealSource',  className: 'center'},
                {data: 'handlePerson',  className: 'center'},
                {data: 'handleTime',  className: 'center'}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                    	if(row.endState == '1')
                    		return "<a href='javascript:void(0)' class='feedback'>反馈</a>";
                    	else 
                    		return "<a href='javascript:void(0)' class='lookfeedback'>反馈结果查看</a>";
                    }
                }, {
                    targets: 2,
                    render: function (data, type, row, meta) {
                    	if(row.endState == '1' && row.isOverDate=='false')
                    		return "正常待处理";
                    	else if(row.endState == '2')
                    		return "已处理";
                    	else
                    		return "超期处理";
                    }
                }, {
                    targets: 5,
                    render: function (data, type, row, meta) {
                    	return "<a href='javascript:void(0)' id='detail'>查看</a>"
                    }
                }, {
                    targets: 6,
                    render: function (data, type, row, meta) {
                    	return "<a href='javascript:void(0)' id='download'>下载</a>"
                    }
                }
                , {
                    targets: 7,
                    render: function (data, type, row, meta) {
                    	if(row.appealSource == '1')
                    		return "外部互联网门户";
                    	else
                    		return "系统内部用户";
                    }
                }
            ]
        })
    }

 // 表格之外的查询按钮事件
	$("#search").click(function() {
		searchParams = $("#hxForm").serializeObject();
		table.ajax.reload();
	});
	
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
            el: '#detail',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '查看',
                    area: ['820px', '650px'],
                    content: '/credit/appeal/detail?uid=' + data.uid,
                    callback: function (data) {
                    }
                })
            }
        }, {
            el: '#download',
            event: 'click',
            handler: function () {
                var proveMaterial = table.row($(this).closest('td')).data().proveMaterial;
                window.location.href="/credit/appeal/export?proveMaterial="+proveMaterial;
            }
        },{
        	el:'.feedback',
        	event:'click',
        	handler:function(){
        		var data = table.row($(this).closest('td')).data();
        		layer.dialog({
        			title:'反馈',
        			area:['300px','250px'],
        			content:'/credit/appeal/gofeedback?uid=' + data.uid,
        			callback:function(data){
        				table.ajax.reload();
        			}
        		})
        	}
        },{
        	el:'.lookfeedback',
        	event:'click',
        	handler:function(){
        		var data = table.row($(this).closest('td')).data();
        		layer.dialog({
        			title:'反馈结果查看',
        			area:['300px','250px'],
        			content:'/credit/appeal/gofeedback?uid=' + data.uid,
        			callback:function(data){
        				
        			}
        		})
        	}
        }
        ])
    };


});


