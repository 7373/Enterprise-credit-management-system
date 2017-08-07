require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	/*
	 * 初始化
	 */
	init();
	function init(){
		initEcharts();
		bind();
	}
	
	
	// 初始化echarts图表
	function initEcharts(){
		initEcharts1();
		initEcharts2();
	}



	// 存续数
	function initEcharts1(){
		var myChart1 = echarts.init(document.getElementById('main1'));
//		http.httpRequest({
//			type:'POST',
//			url:'',
//			success:function(json){
	        var option1 = {
	        		
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
				    legend: {
				        data:['月上传次数','月上传匹配率']
				    },
				    xAxis: [
				        {
				            type: 'category',
				            data:['安监局','编委办','财政局','城管局','公安局','规划建设局','国税局','国土资源局','环保局','交通运输局','教育局','民政局','农业局','人社局','市场监管局','司法局','卫计局','文广新局'],
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
				            name: '上传次数',
				            min: 0,
				            max: 45,
				            interval: 5
				        },
				        {
				            type: 'value',
				            name: '上传匹配率',
				            min: 0,
				            max: 100,
				            interval: 20,
				            axisLabel: {
				                formatter: '{value} %'
				            }
				        }
				    ],
				    series: [
				        {
				            name:'月上传次数',
				            type:'bar',
				            itemStyle : {  
                                normal : {  
                                    color:'#6495ED', 
                                }  
                            },  
				            data:[35,15,25,40,10,5,25,35,43,25,10,5,15,25,30,29,36,15]
				        },
				        {
				            name:'月上传匹配率',
				            type:'line',
				            yAxisIndex: 1,
				            itemStyle : {  
                                normal : {  
                                    color:'#CD3333',  //圈圈的颜色
                                }  
                            }, 
				            data:[80,60,46,25,30,40,53,67,85,73,64,90,56,80,53,30,43,57]
				        },
				    ]
				};
	        myChart1.setOption(option1); 
//			}
//		});
	}
	
	// 当月新设数量
	function initEcharts2(){
		var myChart2 = echarts.init(document.getElementById('main2')); 
//		http.httpRequest({
//			type:'POST',
//			url:'',
//			success:function(json){
			var option2 = {
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
			    legend: {
			        data:['累计上传次数','累计上传匹配率']
			    },
			    xAxis: [
			        {
			            type: 'category',
			            data: ['安监局','编委办','财政局','城管局','公安局','规划建设局','国税局','国土资源局','环保局','交通运输局','教育局','民政局','农业局','人社局','市场监管局','司法局','卫计局','文广新局'],
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
			            name: '累计上传次数',
			            min: 0,
			            max: 600,
			            interval: 100,
			            axisLabel: {
			                formatter: '{value}'
			            }
			        },
			        {
			            type: 'value',
			            name: '累计上传匹配率',
			            min: 0,
			            max: 100,
			            interval: 20,
			            axisLabel: {
			                formatter: '{value} %'
			            }
			        }
			    ],
			    series: [
			        {
			            name:'累计上传次数',
			            type:'bar',
			            itemStyle : {  
                            normal : {  
                                color:'#6A5ACD', 
                            }  
                        }, 
			            data:[300, 430, 500, 433, 311,255,560,333,566,321,159,263,211,166,366,466,503,460]
			        },
			        {
			            name:'累计上传匹配率',
			            type:'line',
			            yAxisIndex: 1,
			            itemStyle : {  
                            normal : {  
                                color:'#CD3333', 
                            }  
                        },
			            data:[80,60,46,25,30,40,53,67,85,73,64,90,56,80,53,30,43,57]
			        }
			    ]
			};
		
		    	myChart2.setOption(option2); 
//        }});
	}

	
	function bind(){
		util.bindEvents([
		{
		    el: '.qycx',
		    event: 'click',
		    handler: function () {
		    	window.location.href="/credit/qybase/views";
		    }
		},{
		    el: '.grcx',
		    event: 'click',
		    handler: function () {
		    	window.location.href="/credit/grbase/views";
		    }
		},{
		    el: '.gxcx',
		    event: 'click',
		    handler: function () {
		    	window.location.href="/credit/ndShareInfo/views";
		    }
		}
		])
	}


})
