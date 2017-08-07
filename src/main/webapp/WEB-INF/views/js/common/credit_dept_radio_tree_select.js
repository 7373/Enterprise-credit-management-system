require(['common/util', 'component/iframeLayer', 'common/http', 'handlebars', 'layer1', 'ztree','ztreeCheck'], function (util, layer, http, handlebars) {
	init();
    /**
     * 初始化函数集合
     */
    function init() {
        loadTree();
        bind();
    }

    //部门树对象
    var treeObj = null;

    //加载部门树
    function loadTree() {
        var treeUrl = window._CONFIG.treeUrl;
        //部门树配置
        var setting = {
            check: {
                enable: true,
                chkStyle: "radio",
                autoCheckTrigger: true,
                radioType: "all"
            },
            data: {
                key: {
                    name: "depName",
                    title: "depName"
                },
                simpleData: {
                    enable: true,
                    idKey: "depCode",
                    pIdKey: "parentid"

                }
            }
        };
        http.httpRequest({
            type: 'post',
            url: treeUrl,
            success: function (data) {
                treeObj = $.fn.zTree.init($('#sysDepartTree'), setting, data);
                var tree = $.fn.zTree.getZTreeObj("sysDepartTree");
                beforeExpand(tree.getNodes(),tree);
            }
        });
    }
    //部门树展开时事件
    function beforeExpand(treeNodes,tree) {
        if(treeNodes!=null){
            hideNullNode(treeNodes,tree);
        }
    }

    /**
     * 以递归的形式隐藏子节点为空的节点
     * @param treeNode
     * @param treeObj
     */
    function hideNullNode(treeNode,treeObj){
        for(var i in treeNode){
            if(treeNode[i].children!=null){
                hideNullNode(treeNode[i].children,treeObj);
            }else{
                if(treeNode[i].isParent==true){
                    /*treeObj.hideNode(treeNode[i]);*/
                }
            }
        }
    }

    function bind() {
        util.bindEvents([
            {
                el: '#departmentSubmit',
                event: 'click',
                handler: function () {
                    var data = new Object();
                    var treeObj = $.fn.zTree.getZTreeObj("sysDepartTree");
                    var nodes = treeObj.getCheckedNodes(true);
                    if (nodes.length == 0) {
                        layer.msg("请选择部门", {ltype: 0, time: 2000});
                        return false;
                    } else {
                        data.orgName = nodes[0].depName;
                        data.orgCode = nodes[0].depCode;
                        layer.close(data);
                    }
                }
            },
            {
                el: '#cancle',
                event: 'click',
                handler: function () {
                    layer.close();
                }
            }
        ])
    }
})