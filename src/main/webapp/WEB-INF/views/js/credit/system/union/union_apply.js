require(['component/iframeLayer', 'component/dataTable', 'common/util', 
         'common/http', 'handlebars', 'jquery','jquery.serialize','laydate',
         'common/validateRules'], function (layer, dataTable, util, http,handlebars) {

	init();
	function init(){
		formValid();
		bind();
	}
	
	
	function formValid(){
		$('#hx-form').validate({
    		rules: {
    			assistReason:{required:true,maxlength:200},
    			contactsName:{required:true,maxlength:20},
    			contactsTel:{required:true,maxlength:20}
    		},
    		messages:{
    			assistReason:{required:'协查原因不能为空'},
	    		contactsName:{required:'联系人不能为空'},
				contactsTel:{required:'联系电话不能为空'}
    		},
    		onkeyup:false,
            showErrors:function(errorMap,errorList){
            	 for(var i in errorMap){
                     layer.tips(errorMap[i],$('#hx-form input[name='+i+'],textarea[name='+i+']'),{
                         tips:3,
                         tipsMore:true,
                         ltype:0
                     });
                 }
            },
            submitHandler: function () {
            	if(!checkFormTable()){
            		return false;
            	}
                http.httpRequest({
	   	             url: '/credit/ndunion/info/save',
	   	             data: $('#hx-form').serializeArray(),
	   	             type: 'post',
	   	             success: function(data) {
	   	            	 layer.msg(data.msg, {time: 1500}, function () {
	                            layer.close({reload: true});
	                            location.reload();
	                        });
	   	             }
	   	         	});
            }
            
        });
	}
	
	
	function checkFormTable(){
		if($('#table-obj tr').length == '1'){
			 layer.msg('录入对象不能为空！', {time: 1500}, function () {
                layer.close({reload: true});
            });
			 return false;
		}
		
		if($('#table-dep tr').length == '1'){
			 layer.msg('协查部门不能为空', {time: 1500}, function () {
                layer.close({reload: true});
            });
			 return false;
		}
		return true;
	}
	
	function bind(){
		util.bindEvents([
		    {
	    		el: '.btn-add-obj',
	    		event: 'click',
	    		handler: function () {
	    			var  lastTr = $("#tbody_obj tr:last");
	    			var index = 0;
	    			if(lastTr && lastTr.length == 1){
	    				index = parseInt(lastTr.attr("data-index")) + 1;
	    			}
	    			var objHtml = '<tr data-index="'+index+'"><td class="center">' + (parseInt(index)+1) + '</td>'
	    				+ '<td class="center"><input type="checkbox" />'
	    				+ '</td><td><input name="unionObjList['+index+'].entName" type="text" class="ipt-txt" /></td></tr>';
	    			$('#tbody_obj').append(objHtml);
	    			$('.btn-del-obj').click(function(){
	    				$('input:checkbox').each(function() {
	    			        if (this.checked == true) {
	    			        	$(this).parent().parent().remove();
	    			        }
	    			});
	    			});
	    		}
	    	},{
	    		el:'.btn-add-dept',
	    		event:'click',
	    		handler:function(){
	    			var  lastTr = $("#tbody_dept tr:last");
	    			var index = 0;
	    			if(lastTr && lastTr.length == 1){
	    				index = parseInt(lastTr.attr("data-index")) + 1;
	    			}
	    			var deptHtml = '<tr data-index="'+index+'"><td class="center">'+(parseInt(index)+1)+'</td>'
	    				+'<td class="center"><input type="checkbox" value="'+index+'"/></td>'
	    				+'<td>'
	    				+'<input type="hidden" id="orgCode_'+index+'" name="unionDeptList['+index+'].recDep" />'
	    				+'<div class="pos-rel"><input type="text"  id="orgName_'+index+'" class="ipt-txt" readonly/>'
	    				+'<span class="add-icon depTree"  td-index="'+index+'"><i></i></span></div></td>'
	    				+'<td class="center">'
	    				+'<input type="radio" id="yes" name="unionDeptList['+index+'].isSend" checked="checked" value="1" /><label for="yes" class="mr25">是</label>' 
	    				+'<input type="radio" id="no"  name="unionDeptList['+index+'].isSend" value="0" /><label for="no">否</label>'
	    				+'</td></tr>';
	    			$('#tbody_dept').append(deptHtml);
	    			$('.btn-del-dept').click(function(){
	    				$('input:checkbox').each(function() {
	    			        if (this.checked == true) {
	    			        	$(this).parent().parent().remove();
	    			        }
	    			});
	    			});
	    		}
	    	},{
	    		el :'.depTree',
	    		event:'click',
	    		handler:function(){
	    			doSelectDept($(this).attr('td-index'));
	    		}
	    	}
	    ]);
		
	}
	
	
    //选择部门
    function doSelectDept(idx) {
        var select_dept_url=window._CONFIG.select_dept_url;
        layer.dialog({
            title: '选择设置部门',
            area: ['420px', '666px'],
            content: select_dept_url,
            callback: function (data) {
            	var orgCode = data.orgCode;
            	var orgName = data.orgName;
                $("#orgName_"+idx).val(orgName);
                $("#orgCode_"+idx).val(orgCode);
            }
        })
    }
    	
})
