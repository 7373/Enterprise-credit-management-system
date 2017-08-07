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
            	{data: "isExt", className: 'center'},
            	{data: "contractName", className: 'center'},
            	{data: "entName", className: 'center'},
            	{data: "registDept", className: 'center'},
                {data: "contractType", className: 'center'},
                {data: "registTime", className: 'center'}
            ],
            columnDefs: [{
				targets: 1,
			    render: function (data, type, row, meta) {
			    	if(row.isExt == '1'){
			    		return "<font style='color:red'>是</font><a href='javascript:void(0)' id='' class='mr10 extract_list'>（抽取列表）</a>";
			    	}
			    	return "否";
			    }
			},{
				targets: 5,
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
    
    //抽取
    function extract(){
    	var ratio = $('#ratio').val();
    	var g = /^[1-9]*[1-9][0-9]*$/;
    	if(!g.test(ratio)){
    		layer.msg('抽取比例输入格式不正确，请输入1-100之间的整数！',{time:1000});
    		$('#ratio').focus();
    		return false;
    	}
    	if(parseInt(ratio)>parseInt(100) || parseInt(ratio)<parseInt(1)){
    		layer.msg('抽取比例输入数值不正确，请输入1-100之间的整数！',{time:1000});
    		$('#ratio').focus();
    		return false;
    	}
    	
    	http.httpRequest({
            url: '/admin/extract/randomExtract',
            serializable: true,
            data: $("#hx-form").serializeObject(),
            type:'post',
            success: function (data) {
                if (data.status == 'error') {
                	layer.msg("无抽取结果");
                }else{
                	$('#exNO').attr('value',data.data);
                	table.ajax.reload();
                }
            }
        });
    }
    
    function bind() {
        util.bindEvents([{
            el: '#extract',
            event: 'click',
            handler: function () {
            	extract();
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
        },{
        	el: '#export',
        	event:'click',
        	handler:function(){
        		var exNO = $('#exNO').val();
        		if('-11' == exNO){
        			layer.msg('请先进行随机抽取，再导出抽取结果',{time:1000});
        			return false;
        		}
        		window.location.href = '/admin/extract/export/'+exNO;
        	}
        },{
        	el: '.extract_list',
        	event:'click',
        	handler:function(){
        		var data = table.row($(this).closest('td')).data();
        		layer.dialog({
                    title: ['抽取列表'],
                    area: ['800px', '600px'],
                    content: '/admin/extract/enExtractList/'+data.conUid,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
        	}
        }])
    };
});


