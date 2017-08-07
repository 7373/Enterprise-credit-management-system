define(['jquery', 'dataTables.bootstrap', 'buttons.html5', 'buttons.flash', 'buttons.print', 'dataTables.select'], function () {

    return {
        /**
         * DataTable的默认配置
         * @param options
         * @returns {jQuery table}
         */
        load: function (options) {
            $.fn.dataTable.ext.errMode = function (settings, tn, msg) {
                window.console && console.log(msg);
            };
            var defaultOptions = {
                //默认第一列不显示索引
                showIndex: false,
                //默认启用服务器分页
                serverSide: true,
                //默认不进行排序
                ordering: false,
                //控制表格的延迟渲染，可以提高初始化的速度。
                deferRender: true,
                //销毁已经存在的Datatables实例并替换新的选项
                destroy: true,
                //datatables如果已经初始化了，则继续使用之前的Datatables实例
                retrieve: true,
                //是否显示处理状态
                processing: true,
                isScrollYShow: true,
                language: {
                    'processing': '<img src="/img/loading_32.gif"/>'
                },
                //查询按钮元素id标识
                searchBtnId: '#js-search',
                //分页类型
                pagingType: 'full_numbers',
                //是否选择导出 默认否
                selectExport: false,
                //各个组件的位置配置
                dom: '<"wapper"rt><"bottom"<"pull-left page-length"l><"pull-left"i><"pull-left"B><"pull-right"p>>',
                buttons: [
//                    {
//                        extend: 'print',
//                        text: '打印'
//                    },
//                    {
//                        extend: 'excel',
//                        text: '导出'
//                    }
                ]
            };

            var obj = {};

            function setdataSrc() {
                return {
                    dataSrc: function (json) {
                        // data非数组的时候统一转换为空数组（注：强烈要求后端查询无数据时，data返回空列表即data:[]）
                        if (!$.isArray(json.data)) return [];
                        for (var i = 0, ien = json.data.length; i < ien; i++) {
                            json.data[i]['_idx'] = i;
                        }
                        return json.data;
                    }
                }
            }

            if (typeof options.ajax == 'string') {
                obj = {
                    url: options.ajax,
                    dataSrc: options.ajax.dataSrc || setdataSrc().dataSrc
                };
                options.ajax = obj;
            } else if (typeof options.ajax == 'object') {
                options.ajax.dataSrc = options.ajax.dataSrc || setdataSrc().dataSrc;
            }

            //对于使用cut截取的，重写其render方法
            obj.columns = options.columns;
            obj.columnDefs = options.columnDefs;
            for (var j = 0; j < obj.columns.length; j++) {
                (function (j) {
                    var cut = obj.columns[j].cut;
                    if (cut) {
                        obj.columnDefs.push({
                            targets: j,
                            render: function (data, type, row, meta) {
                                if (data && (data.length > cut.length)) {
                                    var mark = cut.mark || '...';
                                    $(table.cell(meta.row, meta.col).node()).attr('title', data);
                                    return (data.substr(0, cut.length) + mark);
                                }
                                return data;
                            }
                        });
                        delete obj.columns[j].cut;
                    }
                })(j)
            }
            options.columnDefs = obj.columnDefs;
            options.columns = obj.columns;
            var opt = $.extend({}, defaultOptions, options);

            opt.ajax.beforeSend = function(){
                $(opt.searchBtnId).length && $(opt.searchBtnId).css('cursor','not-allowed').prop('disabled', true);
            };
            opt.ajax.complete = function () {
                $(opt.searchBtnId).length && $(opt.searchBtnId).css('cursor','pointer').prop('disabled', false);
            };

            if (opt.selectExport) {
                opt.select = {
                    style: 'multi',
                    selector: 'input:checkbox[type="checkbox"]'
                };
                if (opt.buttons.length && opt.buttons[1]) {
                    opt.buttons[1].exportOptions = {
                        rows: {selected: true}
                    }
                }
            }

            if (opt.isScrollYShow) {
                if (!opt.scrollY) {
                    opt.scrollY = '388px';
                }
                opt.scrollCollapse = true;
            }
            var table = $(options.el).DataTable(opt);

            //是否显示索引
            if (opt.showIndex) {
                var i = 0;
                //加索引
                table.on('draw.dt', function () {
                    table.column(0, {
                        search: 'applied',
                        order: 'applied'
                    }).nodes().each(function (cell, i) {
                        //i 从0开始，所以这里先加1
                        i = i + 1;
                        //服务器模式下获取分页信息，使用 DT 提供的 API 直接获取分页信息
                        var page = table.page.info();
                        //当前第几页，从0开始
                        var pageno = page.page;
                        //每页数据
                        var length = page.length;
                        //行号等于 页数*每页数据长度+行号
                        var columnIndex = (i + pageno * length);
                        cell.innerHTML = columnIndex;
                    });
                })
            }

            return table;
        }

    }
})