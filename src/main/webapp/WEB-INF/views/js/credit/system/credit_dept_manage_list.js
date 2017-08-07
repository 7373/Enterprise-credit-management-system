require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree'], function (util, layer, http, handlebars) {
	init();
   
    /**
     * 初始化函数集合
     */
    function init() {
        ztreeInit();
        bind();
    }

    //区域树对象
    var treeObj = null;
    //初始化区域显示
    var viewTemplate = handlebars.compile($('#viewTemplate').html());

    //区域树配置
    var treeSetting = {
        view: {
            dblClickExpand: true,
            showLine: true
        },
        data: {
        	key: {
                name: "depName",
                title: "depName"
            },
            simpleData: {
                enable: true,
                idKey: 'depCode',
                pIdKey: 'parentid',
                rootPId: ''
            }
        },
        callback: {
            onClick: function (event, treeId, treeNode) {
                var parentNode = treeNode.getParentNode();
                showDept(treeNode.depCode, parentNode);
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
            url: '/credit/dept/doGetDeptList',
            success: function (data) {
                //初始化权限树
                treeObj = $.fn.zTree.init($('#deptTree'), treeSetting, data);
                showDept();
            }
        });
    }

    /**
     * 显示区域数据
     * @param id
     * @param parentNode
     */
    function showDept(id, parentNode) {
        if (!id) {
            $('#showDept').html(viewTemplate());
            return;
        }
        //加载权限数据
        http.httpRequest({
            type: 'post',
            url: '/credit/dept/doGetDept',
            data: {depCode: id},
            success: function (data) {
                if (data.status == 'success') {
                    var context = data.data;
                    context.parentName = '--';
                    if (parentNode != null) {
                        context.parentName = parentNode.depName;
                    }
                    //展示权限数据
                    $('#showDept').html(viewTemplate(context));
                }
            }
        });
    }

    /**
     * 获取选中的PID
     * @returns {*}
     */
    function getSelectedPId() {
        var id;
        if (treeObj) {
            var nodes = treeObj.getSelectedNodes();
            if (nodes.length > 0) {
                id = nodes[0].parentid;
            }
        }
        return id;
    }
    /**
     * 获取选中的SID
     * @returns {*}
     */
    function getSelectedSId() {
        var id;
        if (treeObj) {
            var nodes = treeObj.getSelectedNodes();
            if (nodes.length > 0) {
                id = nodes[0].depCode;
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
                var pid = getSelectedPId();
                var sid = getSelectedSId();
                if(sid ==undefined){
                	layer.msg('请选择要增加的部门', {time: 500});
                	return;
                }
                layer.dialog({
                    title: '新增部门',
                    area: ['50%', '50%'],
                    content: '/credit/dept/enEdit?pid='+pid+'&sid='+sid,
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
                if (!id) {
                	layer.msg('请选择要修改的部门', {time: 500});
                    return;
                }
                var sid = getSelectedSId();
//                if(sid.indexOf('_')==-1){
//                	layer.msg('父节点不可修改', {time: 500});
//                	return;
//                }
                layer.dialog({
                    title: '修改部门',
                    area: ['50%', '50%'],
                    content: '/credit/dept/enEdit?uid=' + id+'&sid='+sid+'&pName='+$('.pName').html(),
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
                    layer.msg('请选择要删除的权限', {time: 500});
                    return;
                }

                if(getIsExitsChildren()){
                    layer.msg("删除失败，原因是要删除的节点下存在子节点！", {time: 1000});
                    return;
                }
                layer.confirm('确定要删除该部门吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        type: 'post',
                        url: '/credit/dept/delete',
                        data: {uid: id},
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
                });
            }
        }])
    }
    function getIsExitsChildren(){
        var treeObj = $.fn.zTree.getZTreeObj("deptTree");
        var nodes = treeObj.getSelectedNodes();
        if (nodes.length > 0) {
            var childrenNodes = nodes[0].children;
            if(childrenNodes==undefined){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
})