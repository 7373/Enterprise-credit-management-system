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
        initPreSelect();
        initSonSelect('0');
        bind();
    }

    /**
     * 初始化合同类别*/
    function initPreSelect(){
    	busUtil.initFcfPreType('contractTypeFir');
    }
    function initSonSelect(num){
    	busUtil.initFcfSonType('contractTypeSec',num);
    }
    
    $('#contractTypeFir').change(function(){
    	$('#contractTypeSec').html('');
    	busUtil.initFcfSonType('contractTypeSec',$('#contractTypeFir').val());
    });
    
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#contract-table',
            scrollX:true, //支持滚动
            showIndex: true,
            ajax: {
                url:'/admin/query/list.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
            	{data: null,width:'60px',defaultContent:1,className: 'center'},
            	{data: "entName",width:'130px', className: 'center'},
                {data: "registTime",width:'130px', className: 'center'},
                {data: "state",width:'130px', className: 'center'},
                {data: "recordNO",width:'130px', className: 'center'},
                {data: "contractName",width:'130px', className: 'center'},
                {data: "contractType",width:'130px', className: 'center'},
                {data: "registDept",width:'130px', className: 'center'},
                {data: null,width:'120px',defaultContent:1,className: 'center'}
            ],
            columnDefs: [{
				targets: 3,
			    render: function (data, type, row, meta) {
			    	return busUtil.fmtState(row.state);
			    }
			},{
				targets: 6,
			    render: function (data, type, row, meta) {
			    	return busUtil.fmtFcfType(row.contractType);
			    }
			},{
				targets: 8,
			    render: function (data, type, row, meta) {
			    	   return "<a href='javascript:void(0)' id='' class='mr10 look'>查看</a>";
			    }
			}
               
            ]
        })
    }
//    表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#hxForm").serializeObject();
        table.ajax.reload();
    }); 
    
    

    
    function bind() {
        util.bindEvents([{
            el: '#reset',
            event: 'click',
            handler: function () {
            	$('.clx').val('');
            	$('#orgCode').val($('#orgCodeDesc').val());
            	$('#contractTypeFir').html('');
            	$('#contractTypeSec').html('');
            	initPreSelect();
            	initSonSelect('0');
            }
        }, {
            el: '.look',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '查看',
                    area: ['800px', '700px'],
                    content: '/admin/accept/look?uid=' + data.uid,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        },{
            el: '#selectDept',
            event: 'click',
            handler: function () {
            	doSelectDept();
            }
        }
        ])
    }; 
    
  //选择部门
    function doSelectDept() {
        var select_dept_url=window._CONFIG.select_dept_url;
        layer.dialog({
            title: '选择设置部门',
            area: ['420px', '666px'],
            content: select_dept_url                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ,
            callback: function (data) {
            	var orgCode = data.orgCode;
            	var orgName = data.orgName;
                    $("#orgName").val(orgName);
                    $("#orgCode").val(orgCode);
                }
        })
    }
    
});


