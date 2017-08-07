require(['common/util', 'component/iframeLayer', 'common/http', 'ztree','jquery.serialize','laydate'], function (util, layer, http) {


    init();
    /**
     * 初始化函数集合
     */
    function init() {
        changer();
        bind();
    }
    if($('#ndGrant.uid').val()=='')
        var isChecked = 0;//是否校验通过 0未通过 1通过
    else
        var isChecked = 1;//是否校验通过 0未通过 1通过
    //校验企业名称注册或个人姓名证件号
    function checkNameAndNo(){
        var graname = $('#graName').val();
        var grano = $('#graNo').val();
        var graUserID = $('#graUserID').val();
        var graType = $('#graType').val();
        if(graType=='1'&&grano==''){
            layer.msg("个人授权时，证件号不能为空", {time: 1000});
            return false;
        }
        if(graname=='' && grano ==''){
            graType=='0'?layer.msg("请填写企业名称或注册号", {time: 1000}):layer.msg("请填写个人证件号", {time: 1000});
            return false;
        }

        http.httpRequest({
            type: 'post',
            url: '/credit/qybase/qygrinfo',
            data: { 'graName' : graname,
                'graNo' : grano,
                'graUserID' : graUserID,
                'graType' : graType},
            success: function (data) {
                console.log(data);
                if(data.status=="success"){
                    if(graType=='0'){
                        $('#corpidOrSfzjhm').val(data['data'].enterprise_id);
                        $('#graName').val(data['data'].qymc);
                        $('#graNo').val(data['data'].gszch);
                    }else{
                        $('#corpidOrSfzjhm').val(data['data'].sfzhm);
                        $('#graName').val(data['data'].xm);
                        $('#graNo').val(data['data'].sfzhm);
                    }
                }
                isChecked = 1
                layer.msg(data.msg, {time: 1000});
            }
        });


    }

    //提交表单
    function save(){
        if(isChecked=='0'){
            graType=='0'?layer.msg("请填写企业名称或注册号", {time: 1000}):layer.msg("请填写个人证件号", {time: 1000});
            return false;
        }
        var startline = $('#graStartLine').val();
        if(startline==''){
            layer.msg("请填写授权开始日期", {time: 1000});
            return false;
        }

        var deadline = $('#graDeadLine').val();
        if(deadline==''){
            layer.msg("请填写授权截止日期", {time: 1000});
            return false;
        }

        var formParam = $('#submitForm').serializeObject();
        console.log(formParam)
        http.httpRequest({
            type: 'post',
            url: '/credit/ndgrant/doAddAndEditGrant',
            data: formParam,
            success: function (data) {
                layer.msg(data.msg, {time: 1000});
                if(data.status=="success")
                    layer.close();
            }
        });

    }

    function changer(){
        var type = $('#graType').val();
        if(type==null||type=='') return false;
        if(type=='0'){
            $(".company").show();
            $(".people").hide();
        }else{
            $(".company").hide();
            $(".people").show();
        }
    }
    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
                save();
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        }, {
            el: '#check',
            event: 'click',
            handler: function () {
                checkNameAndNo();
            }
        }, {
            el: '#graType',
            event: 'click',
            handler: function () {
                if($(this).val()=='0'){
                    $(".company").show();
                    $(".people").hide();
                }else{
                    $(".company").hide();
                    $(".people").show();
                }
            }
        }])
    }
})