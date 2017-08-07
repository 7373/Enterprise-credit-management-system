require(
    [ 'component/iframeLayer', 'component/dataTable', 'common/util',
        'common/http', 'common/busUtil', 'handlebars', 'jquery',
        'jquery.serialize', 'laydate' ],
    function(layer, dataTable, util, http, busUtil, handlebars) {
        var table,code;
        var searchParams = $("#hxForm").serializeObject();// 查询参数声明!

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
        
            table = dataTable
                .load({
                    // 需要初始化dataTable的dom元素
                    el : '#contract-table',
                    scrollX : true, // 支持滚动
                    showIndex : false,
                    lengthMenu : [ 5, 10, 20, 50, 100 ],
                    ajax : {
                        url : '/gateway/reception/redBlackList/qygrredblacklist.json',
                        type : 'post',
                        //contentType:"json",
                        data : function(d) {
                            d.params = searchParams;
                        }
                    },
                    // 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                    // className不要写成class
                    columns : [ {data : "importDept",width : '60px',className : 'center'},
                        {data : "partyName",width : '130px',className : 'center'},
                        {data : "unicode", width : '130px', className : 'center'},
                        {data : "inclusion", width : '130px', className : 'center'},
                        {data : "includeListDate", width : '130px', className : 'center'}],
                    columnDefs : []
                })
        }

        $(".look").unbind().bind("click",function(){
            if($(this).text()==0) return;
            //	layer.open
            layer.dialog({
                title : '查看',
                area : [ '800px', '700px' ],
                content : '/gateway/reception/qybase/qyxq?uid='+ $(this).attr('fxId'),
                callback : function(data) {
                    if (data.reload) {
                        table.ajax.reload();
                    }
                }
            })
        });

        $("#search").unbind().bind("click",function(){
            searchParams = $("#hxForm").serializeObject();
            table.ajax.reload();
        });
        $("#selectDept").unbind().bind("click",function(){
            doSelectDept();
        });
        $("#reset").unbind().bind("click",function(){
            $("#orgCode").val('');
        });
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
