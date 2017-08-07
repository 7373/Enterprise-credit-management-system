require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'common/busUtil', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, busUtil,handlebars) {
  
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
            el: '#regist-table',
            scrollX:true, //支持滚动
            showIndex: true,
            ajax: {
                url:'/admin/audit/list.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
            	{data: null,width:'60px',defaultContent:1,className: 'center'},
            	{data: null,width:'120px',defaultContent:1,className: 'center'},
                {data: "entName",width:'130px', className: 'center'},
                {data: "uniscid",width:'130px', className: 'center'},
                {data: "managerName",width:'130px', className: 'center'},
                {data: "managerCertNO",width:'130px', className: 'center'},
                {data: "managerTel",width:'130px', className: 'center'},
                {data: null,width:'60px',defaultContent:1,className: 'center'}
            ],
            columnDefs: [{
				targets: 1,
			    render: function (data, type, row, meta) {
			       if(row.checkState=='1'){
			    	   return "通过审核";
			       }else if(row.checkState=='2'){
			    	   return "审核未通过";
			       }else
			    	   return "<a href='javascript:void(0)' id='' class='mr10 pass'>通过审核</a><em class='line'>|</em><a href='javascript:void(0)' id='' class='mr10 noPass'>不予通过</a>";
			    }
			},{
				targets:7,
			    render: function (data, type, row, meta) {
			    		return "<a href='javascript:void(0)' id='look'>查看详情</a>";
			    }
			}
          ]
        })
    }
    //表格之外的查询按钮事件
    $("#search").click(function(){
    	if($('#orgCode').val()=="")
			$('#orgCode').val($('#orgCodeDesc').val());
    	searchParams = $("#hxForm").serializeObject();
        table.ajax.reload();
    }); 
    function bind() {
        util.bindEvents([{
            el: '.pass',//通过审核
            event: 'click',
            handler: function () {
            	 var data = table.row($(this).closest('td')).data();
            	 layer.confirm('确定要通过吗?', {icon: 3, title: '提示'}, function (index) {
                     http.httpRequest({
                         url: '/admin/audit/editCheckState',
                         type:'post',
                         data: {uid: data.uid,checkState:"1"},
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
            el: '.noPass',//不予通过
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                editCheckState(data.uid,"2");	
                
//                layer.dialog({
//                    title: '注册审核 ',
//                    area: ['580px', '400px'],
//                    content: '/admin/audit/enCheckView?uid=' + data.uid+'&checkState=' + "2",
//                    callback: function (data) {
//                        if (data.reload) {
//                            table.ajax.reload();
//                        }
//                    }
//                })
                
            }
        },{
            el: '#reset',
            event: 'click',
            handler: function () {
            	$('.clx').val('');
            	$('.checkState').val('0');
            }
        },{
            el: '#selectDept',
            event: 'click',
            handler: function () {
            	doSelectDept();
            }
        },{
            el: '#look',
            event: 'click',
            handler: function () {
        	 var data = table.row($(this).closest('td')).data();
             layer.dialog({
                 title: '查看详情',
                 area: ['700px', '250px'],
                 content: '/admin/audit/lookInfo?uid=' + data.uid,
                 callback: function (data) {
                	 
                 }
             })
            }
        }])
    };
    
    //选择部门
    function doSelectDept() {
        var select_dept_url=window._CONFIG.select_dept_url;
        layer.dialog({
            title: '选择设置部门',
            area: ['420px', '666px'],
            content: select_dept_url,
            callback: function (data) {
            	var orgCode = data.orgCode;
            	var orgName = data.orgName;
                    $("#orgName").val(orgName);
                    $("#orgCode").val(orgCode);
                }
        })
    }
    
    //修改审核状态
    function editCheckState(uid,state){
    	layer.dialog({
            title: '注册审核 ',
            area: ['580px', '400px'],
            content: '/admin/audit/enCheckView?uid=' + uid+'&checkState=' + state,
            callback: function (data) {
                if (data.reload) {
                    table.ajax.reload();
                }
            }
        })
    }
});


