require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
    /*
     * 初始化
     */
    init();
    function init(){
//        initEcharts(11);
        buildEcharts();
        bind();
    }

    function buildEcharts(){
    	var uid = $('#uid').val();
        $.ajax({
            type: "GET",
//            'bb6ff364558411e7bdaf00188b839ae8'
            url: "/gateway/reception/surveyresult/barshow",
            data:{problemID: uid},
            async:false,
            dataType: "json",
            success: function(data){
                initEcharts(data.data);
            }
        });
    }

    // 存续数
    function initEcharts(data){
        var myChart = echarts.init(document.getElementById('main'));
        var option = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    crossStyle: {
                        color: '#999'
                    }
                }
            },
            toolbox: {
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            xAxis: [
                {
                    type: 'category',
//                    data:['选项A','选项B','选项C','选项D'],
                    data:['选项A','选项B','选项C','选项D','选项E','选项F'],
                    axisPointer: {
                        type: 'shadow'
                    },
                    axisLabel: {
                        interval:0,
                        rotate:50
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '选择数量',
                    min: 0,
                    max: data[1]['maxnum'],
//                    max: 100,
                    interval: 5
                }
            ],
            series: [
                {
                    name:'选择次数',
                    type:'bar',
                    itemStyle : {
                        normal : {
                            color:'#6495ED',
                        }
                    },
//                    data:[88,39,62,15]
                    data:data[0]
                }
            ]
        };
        myChart.setOption(option);
    }

    function bind(){
        util.bindEvents([
            {
                el: '',
                event: 'click',
                handler: function () {

                }
            }
        ])
    }


})
