require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http','common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules', 'common/ajaxfileupload'], function (layer, dataTable, util, http,busUtil,handlebars) {
	
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
            el: '#random-table',
            scrollX:true, //支持滚动
            showIndex: true,
          
            ajax: {
                url:'/admin/extract/list.json',
                data:function(d){
                	d.params = $("#hx-form").serializeObject();
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
            	{data: null,width:'60px',defaultContent:1,className: 'center'},
            	{data: "exUserName", className: 'center'},
            	{data: "registDept", className: 'center'},
                {data: "exTime", className: 'center'}
            ],
            columnDefs: [
            ]
        })
    }
    
    
    function bind(){
    	util.bindEvents([{
       	 el: '#close',
         event: 'click',
         handler: function () {
         	layer.close();
         }
    	}])
    }
    
    
    

	
})
