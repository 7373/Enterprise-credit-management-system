require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'],
		function (layer, dataTable, util, http,handlebars) {
	var table;
	var searchParams=$("#hxForm").serializeObject();//查询参数声明!
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
    }

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#hx-table',
            scrollX:true, //支持滚动
            showIndex: true,
            ajax: {
                url:'/admin/log/list.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
            	{data: null, className: 'center', 'defaultContent': ' '},
            	{data: "logUser", className: 'center'},
            	{data: "logLoc", className: 'center'},
            	{data: "logType", className: 'center'},
            	{data: "logIp", className: 'center'},
            	{data: "logTime", className: 'center'},
            	{data: "logRemark", className: 'center'}
            ],
            columnDefs: [   ]
        })
    }
    
    
    
});


