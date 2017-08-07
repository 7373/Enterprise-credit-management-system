require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http','common/busUtil', 'handlebars','jquery','jquery.serialize','laydate'],
		function (layer, dataTable, util, http,busUtil,handlebars) {
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
    
    
    function initPreSelect(){
    	busUtil.initFcfPreTypeForSearch('contractTypeFir');
    }
    function initSonSelect(num){
    	busUtil.initFcfSonTypeForSearch('contractTypeSec',num);
    }
    
    $('#contractTypeFir').change(function(){
    	$('#contractTypeSec').html('');
    	busUtil.initFcfSonTypeForSearch('contractTypeSec',$('#contractTypeFir').val());
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
            lengthMenu: [ 5, 10, 20, 50, 100 ],

            ajax: {
                url:'/admin/accept/list.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
            	{data: null,width:'60px',defaultContent:1,className: 'center'},
            	{data: null,width:'120px',defaultContent:1,className: 'center'},
            	{data: "contractName",width:'130px', className: 'center'},
            	{data: "contractType",width:'130px', className: 'center'},
            	{data: "entName",width:'130px', className: 'center'},
            	{data: "registDept",width:'130px', className: 'center'},
                {data: "managerName",width:'130px', className: 'center'},                
                {data: "managerTel",width:'130px', className: 'center'},
                {data: "createTime",width:'130px', className: 'center'}
            ],
            columnDefs: [{
				targets: 1,
			    render: function (data, type, row, meta) {
			    	   return "<a href='javascript:void(0)' id='' class='mr10 pass'>予以备案</a><em class='line'>|</em><a href='javascript:void(0)' id='' class='mr10 return_modify'>退回</a><em class='line'>|</em><a href='javascript:void(0)' id='' class='mr10 look'>查看</a>";
			    }
			},{
				targets: 3,
			    render: function (data, type, row, meta) {
			    	return busUtil.fmtFcfType(row.contractType);
			    }
			}
               
            ]
        })
    }
//    表格之外的查询按钮事件
    $("#search").click(function(){
    	if($('#orgCode').val()=="")
			$('#orgCode').val($('#orgCodeDesc').val());
    	searchParams = $("#hxForm").serializeObject();
        table.ajax.reload();
    }); 
    
    
    
    function bind() {
        util.bindEvents([{
            el: '#reset',
            event: 'click',
            handler: function () {
            	$('.clx').val('');
            	$('#contractTypeFir').html('');
            	$('#contractTypeSec').html('');
            	initPreSelect();
            	initSonSelect('0');
            }
        },{
            el: '.pass',//予以备案（3已登记）
            event: 'click',
            handler: function () {
            	 var data = table.row($(this).closest('td')).data();
//                 updateContractState(data.uid,"3");	
                 layer.confirm('确定要通过吗?', {icon: 3, title: '提示'}, function (index) {
                     http.httpRequest({
                         url: '/admin/accept/updateContractState',
                         type: 'post',
                         data: {uid: data.uid,state:"3"},
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
        },{
            el: '.return_modify',//返回修改（2退回）
            event: 'click',
            handler: function () {
            	 var data = table.row($(this).closest('td')).data();
            	 updateContractState(data.uid,"2");  
            }
        }, {
            el: '.look',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '查看',
                    area: ['800px', '700px'],
                    content: '/admin/accept/show?uid=' + data.uid,
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
        }])
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
    
  //修改审核状态
    function updateContractState(uid,state){
    	layer.dialog({
            title: '备案处理 ',
            area: ['660px', '480px'],
            content: '/admin/accept/enCheckView?uid=' + uid+'&state=' + state,
            callback: function (data) {
                if (data.reload) {
                    table.ajax.reload();
                }
            }
        })
    }
    
});


