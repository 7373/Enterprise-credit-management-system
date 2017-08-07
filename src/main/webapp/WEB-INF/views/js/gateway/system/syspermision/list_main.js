require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree'], function (util, layer, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        ztreeInit();
        bind();
    }

    //权限树对象
    var treeObj = null;
    //初始化权限显示
    var viewTemplate = handlebars.compile($('#viewTemplate').html());

    //权限树配置
    var treeSetting = {
        view: {
            dblClickExpand: true,
            showLine: true
        },
        data: {
            simpleData: {
                enable: true,
                idKey: 'id',
                pIdKey: 'pId',
                rootPId: ''
            }
        },
        callback: {
            onClick: function (event, treeId, treeNode) {
                var parentNode = treeNode.getParentNode();
                showPermision(treeNode.id, parentNode);
            }
        }
    };

    /**
     * 角色权限
     */
    function ztreeInit() {
        //加载权限数据
        http.httpRequest({
            type: 'post',
            url: '/gateway/system/syspermision/list.json',
            success: function (data) {
                if (data.status == 'success') {
                    //初始化权限树
                    treeObj = $.fn.zTree.init($('#permisionTree'), treeSetting, data.data);
                    showPermision();
                }
            }
        });
    }

    /**
     * 显示权限数据
     * @param id
     * @param parentNode
     */
    function showPermision(id, parentNode) {
        if (!id) {
            $('#showArea').html(viewTemplate());
            return;
        }
        //加载权限数据
        http.httpRequest({
            type: 'post',
            url: '/gateway/system/syspermision/query',
            data: {id: id},
            success: function (data) {
                if (data.status == 'success') {
                    var context = data.data;
                    context.parentName = '--';
                    if (parentNode) {
                        context.parentName = parentNode.name;
                    }
                    context.type = context.type == '1' ? '菜单权限' : '操作权限';
                    //展示权限数据
                    $('#showArea').html(viewTemplate(context));
                }
            }
        });
    }

    /**
     * 获取选中的权限ID
     * @returns {*}
     */
    function getFirstSelectedId() {
        var id;
        if (treeObj) {
            var nodes = treeObj.getSelectedNodes();
            if (nodes.length > 0) {
                id = nodes[0].id;
            }
        }
        return id;
    }

    function bind() {
        util.bindEvents([{
            el: '#addBtn',
            event: 'click',
            handler: function () {
                //选中的权限ID
                var sid = getFirstSelectedId();
                if(!sid){
                	layer.msg('请选择要增加的权限的位置', {time: 500});
                    return;
                }
                layer.dialog({
                    title: '新增权限',
                    area: ['628px', '434px'],
                    content: '/gateway/system/syspermision/show?sid=' + sid,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            ztreeInit();
                        }
                    }
                })
            }
        }, {
            el: '#editBtn',
            event: 'click',
            handler: function () {
                var id = $('#id').val();
                var sid = getFirstSelectedId();
                if (!id) {
                    layer.msg('请选择要修改的权限', {time: 500});
                    return;
                }
                layer.dialog({
                    title: '修改权限',
                    area: ['628px', '434px'],
                    content: '/gateway/system/syspermision/show?id=' + id,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            ztreeInit();
                        }
                    }
                })
            }
        }, {
            el: '#delBtn',
            event: 'click',
            handler: function () {
                var id = $('#id').val();
                if (!id) {
                    layer.msg('请选择要修改的权限', {time: 500});
                    return;
                }
                http.httpRequest({
                    type: 'post',
                    url: '/gateway/system/syspermision/delete',
                    data: {id: id},
                    success: function (data) {
                        if (data.status == 'success') {
                            if (data.msg) {
                                layer.msg(data.msg, {time: 500}, function () {
                                    //删除成功重新加载
                                    ztreeInit();
                                });
                            }
                            return;
                        }
                        var errorMsg = data.msg;
                        var errors = data.errors;
                        if (errors.length > 0) {
                            for (var i = 0; i < errors.length; i++) {
                                errorMsg += '<br/>' + (i + 1) + '：' + errors[i].field + errors[i].info;
                            }
                        }
                        layer.msg(errorMsg, {time: 1000});
                    }
                });
            }
        },{
            el:"#reloadBtn",
            event:"click",
            handler:function () {
                http.httpRequest({
                    type:"GET",
                    url: '/gateway/system/syspermision/reload',
                    success:function (data) {
                        var errorMsg = data.msg;
                        var errors = data.errors;
                        if (errors.length > 0) {
                            for (var i = 0; i < errors.length; i++) {
                                errorMsg += '<br/>' + (i + 1) + '：' + errors[i].field + errors[i].info;
                            }
                        }
                        layer.msg(errorMsg, {time: 1000});
                    }

                });
            }
        }])
    }
})