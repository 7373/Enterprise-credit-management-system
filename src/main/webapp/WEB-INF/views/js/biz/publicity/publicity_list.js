require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate'],
		function (layer, dataTable, util, http, busUtil,handlebars) {
	var table;
	var searchParams=$("#hxForm").serializeObject();//查询参数声明!
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
            el: '#pub-table',
            scrollX:true, //支持滚动
            showIndex: true,
            ajax: {
                url:'/pub/list.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
            	{data: null,width:'60px',defaultContent:1,className: 'center'},
            	{data: "entName",width: '100px'},
            	{data: "uniscid",width: '100px'},
                {data: "contractName",width: '100px'},
                {data: "contractType",width: '100px'},  
                {data: "registTime",width: '100px'}
            ],
            columnDefs: [{
				targets: 4,
			    render: function (data, type, row, meta) {
			    	return busUtil.fmtFcfType(row.contractType);
			    }
			}],
            "drawCallback": function( settings ) {
            	
            }
        })
    }
//    表格之外的查询按钮事件
    $("#search").click(goSearch); 
    
    $("#hxForm").keydown(function(event){
    	if(event.keyCode==13){
    		goSearch();
    	}
    });
    
    function goSearch(){
    	var entNameDesc = $('#entNameDesc').val();
    	var g = /[\+\-\*\\\!\~\@\#\$\%\^\&\?\/\|\'\;\:\<\>\,\.\`\[\]\{\}\{\}\：\；\‘\“\"\？\、\，\。\《\》\·\~\！\@\#\￥\%\……\&\*\+\=\_\-\——\-]/;
    	if(g.test(entNameDesc)){
    		layer.msg('输入格式不正确',{time:3000});
    		return ;
    	}
    	if(entNameDesc.length <= 2){
    		layer.msg("关键字长度必须大于2", {time: 3000}, function() {});
    		return;
    	}
    	searchParams = $("#hxForm").serializeObject();
        table.ajax.reload();
    }
    
    function bind() {
        util.bindEvents([{
            el: '#pub-table tr',
            event: 'click',
            handler: function () {
                var data = table.row($(this)).data().contractFile.split("|");
                window.location.href="/biz/entuser/download?fileName=" + data[0];
            }
        }
        ])
    }
});


