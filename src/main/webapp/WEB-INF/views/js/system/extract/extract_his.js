require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http','common/busUtil', 'handlebars', 
         'jquery','jquery.serialize','laydate'],
		function (layer, dataTable, util, http,busUtil,handlebars) {
	var table;
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
            el: '#hx-table',
            scrollX:true, //支持滚动
            showIndex: true,
            ajax: {
                url:'/admin/extract/listHis.json',
                data:function(d){
                	d.params = $("#hx-form").serializeObject();
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
            	{data: null,width:'60px',defaultContent:1,className: 'center'},
            	{data: null, className: 'center'},
            	{data: "contractName", className: 'center'},
            	{data: "exTime", className: 'center'},
            	{data: "entName", className: 'center'},
            	{data: "registDept", className: 'center'},
                {data: "contractType", className: 'center'},
                {data: "registTime", className: 'center'}
            ],
            columnDefs: [
             {
				targets: 1,
			    render: function (data, type, row, meta) {
			    	if(data.state == '3'){
			    		return "<span class='light-gray'><a href='javascript:void(0)' id='' class='mod_back'>发送退回通知</a> ";
			    	}else if(data.state == '5'){
			    		return "<span class='light-gray'><a href='javascript:void(0)' id='' class='mod_n'>未修改</a> ";
			    	}else if(data.state == '4'){
			    		return "<span class='light-gray'>已修改</span> ";
			    	}
			    }
			 },{
					targets: 6,
				    render: function (data, type, row, meta) {
				    	return busUtil.fmtFcfType(row.contractType);
				    }
				 } 
            ]
        })
    }
    
    
    
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
    
    //修改状态
    function editState(uid,state,advNum,facNum){
    	layer.confirm('确定要执行此操作吗?', {icon: 3, title: '提示'}, function (index) {
   		 http.httpRequest({
               url: '/admin/extract/updateContract/'+uid+'/'+state+'/'+advNum+'/'+facNum,
               data: {},
               success: function (data) {
               	layer.close(index);
                 	table.ajax.reload();
               }
           });
   	});
    }
    
    function bind() {
        util.bindEvents([{
            el: '#search',
            event: 'click',
            handler: function () {
            	table.ajax.reload();
            }
        },{
            el: '.mod_n',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	var re = /^[0-9]*[1-9][0-9]*$/ ; 
            	var advNum,facNum;
            	layer.prompt({formType :0,title : '请输入建议修改数量'},function(value, index, elem) {
					layer.prompt({formType :0,title : '请输入实际修改数量'},function(value2, index2, elem2) {
						advNum = value ; facNum = value2;
						if(! re.test(advNum)){
		            		 layer.msg("请输入有效建议修改数量！"); return ;
		            	}
		            	if(! re.test(facNum)){
		            		 layer.msg("请输入有效实际修改数量！"); return ;
		            	}
		            	if(parseInt(facNum) > parseInt(advNum)){
		            		layer.msg("实际修改数量不能大于建议修改数量！"); return ;
		            	}
		            	
		            	editState(data.conUid,'4',advNum,facNum);
					});
            	});
            	
			}
        },{
            el: '.mod_back',
            event: 'click',
            handler: function () {
            	var data = table.row($(this).closest('td')).data();
            	editState(data.conUid,'5',0,0);
			}
        },{
            el: '#selectDept',
            event: 'click',
            handler: function () {
            	doSelectDept();
            }
        },{
        	el: '#reset',
        	event:'click',
        	handler:function(){
        		$('.clx').val('');
        		$('#ratio').val('1');
        		$('#contractTypeFir').html('');
            	$('#contractTypeSec').html('');
            	initPreSelect();
            	initSonSelect('0');
        	}
        }])
    };
    
});


