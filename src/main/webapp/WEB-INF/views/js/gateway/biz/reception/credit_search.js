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
            bind()
        }
        //生成或刷新验证码
        function changeCode() {  //刷新
            $('.js-check-img').attr('src', '/ndrcCaptcha?t=' + Math.random());
            event.cancelBubble=true;
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
                        url : '/gateway/reception/qybase/qylist.json',
                        type : 'post',
                        //contentType:"json",
                        data : function(d) {
                            d.params = searchParams;
                        }
                    },
                    // 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                    // className不要写成class
                    columns : [ {data : "enterprise_id",width : '60px',className : 'center'},
                        {data : "qymc",width : '130px',className : 'center'},
                        {data : "gszch", width : '130px', className : 'center'},
                        {data : null, width : '60px', defaultContent : 1, className : 'center'}],
                    columnDefs : [
                        { targets : 3,
                            render : function(data, type, row, meta) {
                                return "<a href='javascript:void(0)' id='' class='mr10 look' fxId='"+row.gszch+"'>查看</a>";
                            }
                        }

                    ]
                })
        }

        function check(){
            var qymc = $("#qymc").val();
            var gszch = $("#gszch").val();
            var checkCode = $("#checkCode").val();
            if(!qymc&&!gszch){
                layer.msg("查询条件不能为空！", {time: 1000}, function() {});
                return false;
            }
            if(!checkCode){
                layer.msg("验证码不能为空！", {time: 1000}, function() {});
                return false;
            }
            getValidateCode();
            if(code != checkCode){
                layer.msg("验证码错误请重新输入！", {time: 1000}, function() {});
                changeCode();
                return false;
            }
            return true;
        }

        function getValidateCode(){
            $.ajax({
                type: "GET",
                url: "/gateway/reception/doGetSessionValidateCode",
                async:false,
                dataType: "json",
                success: function(data){
                    code =  data.data;
                }
            });

        }

        function bind() {
            util.bindEvents([ {
                el: '.js-checkcode',
                event: 'click',
                handler: function () {
                    changeCode();
                }
            }, {
                el : '.look',
                event : 'click',
                handler : function() {
                    //var data = table.row($(this).closest('tr')).data();
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
                }
            },{
                el: '#search',
                event: 'click',
                handler: function () {
                    $("#searchparam").val("");
                    if(!check()) return;
                    searchParams = $("#hxForm").serializeObject();
                    table.ajax.reload();
                }
            } ])
        }
        ;

    });
