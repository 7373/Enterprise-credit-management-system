require(['layer1',
         'component/dataTable',
         'common/util',
         'common/http',
         'jquery',
         'jquery.serialize',
         'handlebars',
         'jquery','laydate'], function (layer, dataTable, util, http, handlebars) {
 
	var tableTreeseed;
	var tableRedList;
	var tableBlackList;
	
	var serializeFormTreeseed = $('#qryFormTreeseed').serializeObject();
	var serializeFormRedList = $("#qryFormRedList").serializeObject();
	var serializeFormBlackList = $("#qryFormBlackList").serializeObject();
	
	init();
	
	function init(){
		initTableTreeseed();
		initTableRedList();
		initTableBlackList();
		bind();
	}
	
	function initTableTreeseed(){
		tableTreeseed = dataTable.load({
			el:'#treeseed-table',
			scrollX:true,
			showIndex:true,
			lengthMenu: [ 5, 10, 20, 50, 100 ],
			ajax:{
				url:'/tempSeedManagePermit/findMsg',
				data:function(d){
					d.params = serializeFormTreeseed;
				}
			},
			columns:[
			         {data:null,defaultContent: 1,className:'center',width:'70px' },
			         {data:'entName',className:'center'},
			         {data:'unicode',className:'center'},
			         {data:'licenceNO',className:'center'},
			         {data:'issueTime',className:'center'},
			         {data:'termEnd',className:'center'},
			         {data:'produceLoc',className:'center'},
			         {data:'manageType',className:'center'},
			         {data:'importTime',className:'center'},
			         {data:null,className:'center'}
			         ],
			columnDefs:[{
				targets:9,
				render:function(data,type,row,meta){
					return "<a href='javascript:void(0);' class='deleteTreeseed' uid="+row.uid+">删除</a>";
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
	
	function bind(){
		util.bindEvents([{
			el:'#searchTreeseed',
			event:'click',
			handler:function(){
				serializeFormTreeseed = $('#qryFormTreeseed').serializeObject();
				tableTreeseed.ajax.reload();
			}
		},{
			el:'.deleteTreeseed',
			event:'click',
			handler:function(){
				var uid = $(this).attr('uid');
				layer.confirm("确定删除吗?",{icon: 3, title: '提示'},function(){
					$.ajax({
						url:'/tempSeedManagePermit/delete',
						type:'post',
						data:{'uid':uid},
						dataType:'JSON',
						async:false,
						success:function(data){
							layer.msg(data.msg,{time:3000},function(){});
						}
					})
					tableTreeseed.ajax.reload();
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
		}])
	}
})