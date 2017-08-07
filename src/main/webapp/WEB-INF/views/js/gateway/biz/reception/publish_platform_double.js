require(
    [ 'component/iframeLayer', 'component/dataTable', 'common/util',
        'common/http', 'common/busUtil', 'handlebars', 'jquery',
        'jquery.serialize', 'laydate' ],
    function(layer, dataTable, util, http, busUtil, handlebars) {
        var table,code,url;
        var searchParams = $("#hxForm").serializeObject();// 查询参数声明!
        init();
        /**
         * 初始化函数集合
         */
        function init() {
        	check();
            initDataTable();
        }
        /**
         * 初始化dataTable
         */
        function check(){
        	
        	var str =$("#searchType").val();
        	var type = $('#type').val();
        	if(str=='xk' || type =='xk'){
        		url='/gateway/reception'+'/ndlicense/list';
        	}else if(str=='cf' || type =='cf'){
        		url='/gateway/reception'+'/ndpunish/list';
        	}
        }
        function initDataTable() {
            table = dataTable
                .load({
                    // 需要初始化dataTable的dom元素
                    el : '#publish-table',
                    scrollX : true, // 支持滚动
                    showIndex : false,
                    lengthMenu : [ 5, 10, 20, 50, 100 ],
                    ajax : {
                        url : url,
                        type : 'post',
                        //contentType:"json",
                        data : function(d) {
                            d.params = searchParams;
                        }
                    },
                    // 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                    // className不要写成class
                    columns : [ {data : "type",width : '60px',className : 'center'},
                        {data : "deptName",width : '130px',className : 'center'},
                        {data : "name", width : '130px', className : 'center'},
                        {data : "title", width : '130px', className : 'center'},
                        {data : "decideTime", width : '130px', className : 'center'}],
                    columnDefs : [
                     ]
                })
        }
		$("#search").unbind("click").bind("click",function(){
			 searchParams = $("#hxForm").serializeObject();
		     check();
		     table.ajax.url(url).load();
		})
		$("#selectDept").unbind("click").bind("click",function(){
			doSelectDept();
		})
		$("#reset").unbind("click").bind("click",function(){
			$("#orgCode").val('');
		})
        function doSelectDept() {
            layer.dialog({
                title: '选择设置部门',
                area: ['420px', '666px'],
                content: '/gateway/reception/dept/enRadioTreeSelect',
                callback: function (data) {
                	var orgCode = data.orgCode;
                	var orgName = data.orgName;
                        $("#orgName").val(orgName);
                        $("#orgCode").val(orgCode);
                    }
            })
        }

    });
