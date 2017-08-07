require(
    [ 'component/iframeLayer', 'component/dataTable', 'common/util',
        'common/http', 'common/busUtil', 'handlebars', 'jquery',
        'jquery.serialize' ],
    function(layer, dataTable, util, http, busUtil, handlebars) {
        var table;
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
                    showIndex : true,
                    lengthMenu : [ 5, 10, 20, 50, 100 ],
                    ajax : {
                        url : '/gateway/reception/consult/feedbacklist.json',
                        type : 'post',
                        //contentType:"json",
                        data : function(d) {
                            d.params = searchParams;
                        }
                    },
                    // 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                    // className不要写成class
                    columns : [ {data : "uid",width : '60px',className : 'center'},
                        {data : "feedbackType",width : '130px',className : 'center'},
                        {data : "messageTitle", width : '130px', className : 'center'},
                        {data : "realName", width : '130px', className : 'center'},
                        {data : "optTime", width : '130px', className : 'center'},
                        {data : null, width : '60px', defaultContent : 1, className : 'center'}],
                    columnDefs : [
                        { targets : 1,
                            render : function(data, type, row, meta) {
                                if(row.feedbackType==1) return "信用咨询";
                                if(row.feedbackType==2) return "信用申诉";
                                return "";
                            }
                        },{ targets : 5,
                            render : function(data, type, row, meta) {
                                return "<a href='javascript:void(0)'class='look' onclick='check(this)' uid='"+row.uid+"' feedbackType='"+row.feedbackType+"'>查看</a>";
                            }
                        }

                    ],"fnDrawCallback": function (data) {
                    	$(".look").unbind("click").bind("click",function(){
                        	var type = $(this).attr("feedbackType");
                            var uid = $(this).attr("uid");
                            var url;
                            if(type==1) url = '/gateway/reception/consult/show?uid=' + uid;
                            if(type==2) url = '/gateway/reception/appeal/gofeedback?uid=' + uid;
                        layer.dialog({
                            title: '反馈详情',
                            area: [type==1?'800px':'320px', type==1?'650px':'250px'],
                            content: url,
                            callback: function (data) {
                            }
                        })
                        });
					}
                })
        }
        $("#search").unbind("click").bind("click",function(){
        	searchParams = $("#hxForm").serializeObject();
            table.ajax.reload();
        })
        
 

    });
