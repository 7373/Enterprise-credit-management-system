require(['layer1',
         'component/dataTable',
         'common/util',
         'common/http',
         'jquery',
         'jquery.serialize',
         'handlebars',
         'jquery','laydate'], function (layer, dataTable, util, http, handlebars) {
	
	var tableFirst;
	var tableRedList;
	var tableBlackList;
	var tableSafePro;
	var tableCommendRewardInfoList;
	var tableProduceAccident;
	var tableAdminForceInfoList
	var serializeFormAdminForceInfoList=$("#qryFormAdminForceInfoList").serializeObject();
	var serializeFormProduceAccidentList=$("#qryFormProduceAccidentList").serializeObject();
	var serializeFormCommendRewardList = $("#qryFormCommendRewardInfoList").serializeObject();
	var serializeFormFirst = $("#qryFormFirst").serializeObject();
	var serializeFormRedList = $("#qryFormRedList").serializeObject();
	var serializeFormBlackList = $("#qryFormBlackList").serializeObject();
	var serializeFormSafeProList = $('#qryFormSafeProList').serializeObject();
	init();
	function init(){
		initTableProduceAccidentList();
		initTableAdminForceInfoList();
		initTableCommendRewardInfoList();
		initTableAccident();
		initTableRedList();
		initTableBlackList();
		initTableSafePro();
		bind();
	}
	function initTableProduceAccidentList(){
		tableProduceAccidentList = dataTable.load({
			el:'#produceAccident-table',
			scrollX:true,
			showIndex:true,
			lengthMenu:[5,10,20,50,100],
			ajax:{
				url:'/credit/tempProduceSafeAccident/list',
				data:function(d){
					d.params=serializeFormProduceAccidentList;
				}
			},
			columns:[
			   {data:null,defaultContent:1,className:'center'},
			   {data:'accidentName',className:'center'},
			   {data:'occurDate',className:'center'},
			   {data:'deathNum',className:'center'},
			   {data:'injuredNum',className:'center'},
			   {data:'hanleResult',className:'center'},
			   {data:'accidentCountAll',className:'center'}
			]
		})
	}
	function initTableAdminForceInfoList(){
		tableAdminForceInfoList = dataTable.load({
			el:'#adminForceInfo-table',
			scrollX:true,
			showIndex:true,
			lengthMenu:[5,10,20,50,100],
			ajax:{
				url:'/credit/tempAdminForceInfo/list',
				data:function(d){
					d.params=serializeFormAdminForceInfoList;
				}
			},
			columns:[
			   {data:null,defaultContent:1,className:'center'},
			   {data:'adminForceNO',className:'center'},
			   {data:'adminForceTime',className:'center'},
			   {data:'sequeDetail',className:'center'}
			]
		})
	}
	function initTableCommendRewardInfoList(){
		tableCommendRewardInfoList = dataTable.load({
			el:'#commendRewardInfo-table',
			scrollX:true,
			showIndex:true,
			lengthMenu:[5,10,20,50,100],
			ajax:{
				url:'/credit/ndCommendRewardInfo/list',
				data:function(d){
					d.params=serializeFormCommendRewardList;
				}
			},
			columns:[
			         {data:null,defaultContent:1,className:'center'},
			         {data:'commendName',className:'center'},
			         {data:'commendGrade',className:'center'},
			         {data:'commendFileNO',className:'center'},
			         {data:'commendDeptName',className:'center'},
			         {data:'commendTime',className:'center'},
			         {data:'commendCount',className:'center'}
			 ]
		})
	}
	function initTableAccident(){
		tableFirst = dataTable.load({
			el:'#accident-table',
			scrollX:   true,//支持滚动
			showIndex: true,
			lengthMenu: [ 5, 10, 20, 50, 100 ],
			ajax:{
				url:'/tempAccidentSuperviseInfo/findMsg',
				data:function(d){
					d.params = serializeFormFirst;
				}
			},
			columns:[
			         {data:null,defaultContent: 1,className:'center',width:'70px' },
			         {data:'dangerDetail',className:'center'},
			         {data:'changeTerm',className:'center'},
			         {data:'changeCompleteInfo',className:'center'},
			         {data:'importTime',className:'center'},
			         {data:null,className:'center'}
			         ],
			columnDefs:[{
				targets:5,
				render:function(data,type,row,meta){
					return "<a href='javascript:void(0);' class='delete' uid="+row.uid+">删除</a>";
				}
			}]
		})
	}
	
	function initTableRedList(){
		tableRedList = dataTable.load({
			el:'#redList-table',
			scrollX:true,
			showIndex:true,
			lengthMenu: [ 5, 10, 20, 50, 100 ],
			ajax:{
				url:'/credit/redblack/findMsg',
				data:function(d){
					d.params = serializeFormRedList;
				}
			},
			columns:[
			         {data:null,defaultContent:1,className:'center',width:'70px'},
			         {data:'partyName',className:'center'},
			         {data:'certNO',className:'center'},
			         {data:'inclusion',className:'center'},
			         {data:'occurrDate',className:'center'},
			         {data:'includeListDate',className:'center'},
			         {data:'importTime',className:'center'},
			         {data:null,className:'center'}
			         ],
			columnDefs:[{
				targets:7,
				render:function(data,type,row,meta){
					return "<a href='javascript:void(0);' uid="+row.uid+" class='deleteRedList'>删除</a>"
				}
			}]
		})
	}
	function initTableBlackList(){
		tableBlackList = dataTable.load({
			el:'#blackList-table',
			scrollX:true,
			showIndex:true,
			lengthMenu: [ 5, 10, 20, 50, 100 ],
			ajax:{
				url:'/credit/redblack/findMsg',
				data:function(d){
					d.params = serializeFormBlackList;
				}
			},
			columns:[
			         {data:null,defaultContent:1,className:'center',width:'70px'},
			         {data:'partyName',className:'center'},
			         {data:'certNO',className:'center'},
			         {data:'inclusion',className:'center'},
			         {data:'occurrDate',className:'center'},
			         {data:'includeListDate',className:'center'},
			         {data:'importTime',className:'center'},
			         {data:null,className:'center'}
			         ],
			columnDefs:[{
				targets:7,
				render:function(data,type,row,meta){
					return "<a href='javascript:void(0);' uid="+row.uid+" class='deleteBlackList'>删除</a>"
				}
			}]
			
		})
	}
	
	function initTableSafePro(){
		tableSafePro = dataTable.load({
			el:'#SafePro-table',
			scrollX:true,
			showIndex:true,
			lengthMenu: [ 5, 10, 20, 50, 100 ],
			ajax:{
				url:'/tempSafeProduceLincence/findMsg',
				data:function(d){
					d.params = serializeFormSafeProList;
				}
			},
			columns:[
			         {data:null,defaultContent:1,className:'center',width:'70px'},
			         {data:'isNeedLicence',className:'center'},
			         {data:'licenceNO',className:'center'},
			         {data:'licenceRange',className:'center'},
			         {data:'licenceEndTime',className:'center'},
			         {data:'importTime',className:'center'},
			         {data:null,className:'center'}
			         ],
			columnDefs:[{
				targets:6,
				render:function(data,type,row,meta){
					return "<a href='javascript:void(0);' uid="+row.uid+" class='deleteSafeProList'>删除</a>"
				}
			}]
		})
	}
	
	function bind(){
		util.bindEvents([{
			el:'#searchCommendRewardInfoList',
			event:'click',
			handler:function(){
				serializeFormCommendRewardList = $("#qryFormCommendRewardInfoList").serializeObject();
				tableCommendRewardInfoList.ajax.reload();
			}
			},{
			el:'#searchAdminForceInfoList',
			event:'click',
			handler:function(){
				serializeFormAdminForceInfoList = $("#qryFormAdminForceInfoList").serializeObject();
				tableAdminForceInfoList.ajax.reload();
			}
			},{
			el:'#searchProduceAccidentList',
			event:'click',
			handler:function(){
				serializeFormProduceAccidentList = $("#qryFormProduceAccidentList").serializeObject();
				tableProduceAccidentList.ajax.reload();
			}
			},{
			el:'.delete',
			event:'click',
			handler:function(){
				var uid = $(this).attr('uid');
				layer.confirm("确定删除吗?",{icon: 3, title: '提示'},function(){
					$.ajax({
						url:'/tempAccidentSuperviseInfo/delete',
						type:'post',
						data:{'uid':uid},
						dataType:'JSON',
						async:false,
						success:function(data){
							layer.msg(data.msg,{time:3000},function(){});
						}
					})
					tableFirst.ajax.reload();
				});
				
			}
		},{
			el:'.deleteRedList',
			event:'click',
			handler:function(){
				var uid = $(this).attr('uid');
				layer.confirm("确定删除吗?",{icon: 3, title: '提示'},function(){
					$.ajax({
						url:'/credit/redblack/delete',
						type:'post',
						data:{'uid':uid},
						dataType:'JSON',
						async:false,
						success:function(data){
							layer.msg(data.msg,{time:3000},function(){});
						}
					})
					tableRedList.ajax.reload();
				});
			}
		},{
			el:'#searchRedList',
			event:'click',
			handler:function(){
				serializeFormRedList = $("#qryFormRedList").serializeObject();
				tableRedList.ajax.reload();
			}
		},{
			el:'.deleteBlackList',
			event:'click',
			handler:function(){
				var uid = $(this).attr('uid');
				layer.confirm("确定删除吗?",{icon: 3, title: '提示'},function(){
					$.ajax({
						url:'/credit/redblack/delete',
						type:'post',
						data:{'uid':uid},
						dataType:'JSON',
						async:false,
						success:function(data){
							layer.msg(data.msg,{time:3000},function(){});
						}
					})
					tableBlackList.ajax.reload();
				});
			}
		},{
			el:'#searchBlackList',
			event:'click',
			handler:function(){
				serializeFormBlackList = $("#qryFormBlackList").serializeObject();
				tableBlackList.ajax.reload();
			}
		},{
			el:'#searchSafeProList',
			event:'click',
			handler:function(){
				serializeFormSafeProList = $('#qryFormSafeProList').serializeObject();
				tableSafePro.ajax.reload();
			}
		},{
			el:'.deleteSafeProList',
			event:'click',
			handler:function(){
				var uid = $(this).attr('uid');
				layer.confirm("确定删除吗?",{icon: 3, title: '提示'},function(){
					$.ajax({
						url:'/tempSafeProduceLincence/delete',
						type:'post',
						data:{'uid':uid},
						dataType:'JSON',
						async:false,
						success:function(data){
							layer.msg(data.msg,{time:3000},function(){});
						}
					})
					tableSafePro.ajax.reload();
				});
			}
		}])
	}
	 $("#searchFirst").bind('click',function(){
		serializeFormFirst = $("#qryFormFirst").serializeObject();
		tableFirst.ajax.reload();
	 })
})