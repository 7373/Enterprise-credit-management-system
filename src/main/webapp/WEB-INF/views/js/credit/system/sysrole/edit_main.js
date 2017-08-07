require(['common/util',
        'component/iframeLayer',
        'common/http',
        'ztree',
        'ztreeCheck'], function (util, layer, http) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        ztreeInit();
        bind();
    }

    var treeObj = null;

    //权限树配置
    var treeSetting = {
        check: {
            enable: true,
            chkboxType: {Y: "ps", N: "s"}
        },
        view: {
            dblClickExpand: true,
            showLine: true
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        }
    };

    /**
     * 角色权限
     */
    function ztreeInit() {
        http.httpRequest({
            url: '/credit/system/syspermision/list.json',
            success: function (data) {
                var treeData = data.data;

                //获取角色权限

                http.httpRequest({
                    type: 'post',
                    url: '/credit/system/sysrole/permisions.json',
                    data: {roleId: roleId},
                    success: function (data) {
                        var rolePermions = data.data;
                        $.each(treeData, function (i, nodeData) {
                            treeData[i].open = true
                            $.each(rolePermions, function (j, permision) {
                                if (permision.permisionId == nodeData.id) {
                                    treeData[i].checked = true;
                                }
                            });
                        })
                        //初始化权限树
                        treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, treeData);
                    }
                })
            }
        });
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        }, {
            el: '#save',
            event: 'click',
            handler: function () {

                var nodes = treeObj.getCheckedNodes(true);
                if (nodes.length < 1) {
                    layer.alert('请至少选择一项权限！');
                    return false;
                }

                var arr = [];
                $.each(nodes, function (k, v) {
                    arr.push(v.id);
                });

                if($('input[name="name"]').val() == "" || $('textarea[name="desc"]').val() == ""){
                	layer.msg("必填项不能为空", {time: 1000}, function () {
                    });
                	return;
                }
                var formParam = {
                    uid: $('input[name="uid"]').val(),
                    name: $('input[name="name"]').val(),
                    desc: $('textarea[name="desc"]').val(),
                    roleType:'2',
                    permisions: arr
                };
                http.httpRequest({
                    url: '/credit/system/sysrole/save',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                            layer.close({reload: true});
                        });
                    }
                })
            }
        }])
    }

})