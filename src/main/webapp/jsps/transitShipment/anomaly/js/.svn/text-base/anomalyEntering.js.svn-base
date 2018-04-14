$(function(){
	//1.初始化Table 
	var oTable = new TableInit();
	oTable.Init();

	
	$('#exceptionNo').select2({
		 tags: true
	});
	
	$('#exceptionType').select2({
		 tags: true
	});
	
	$.ajax({
		url : "anomaly/findAllExceptionNo.action",
		type : "post",
		async:true,
		traditional : true,//这里设置为true
		success : function(response) {
			if(response){
				var html = $('#exceptionNo');
				for(var i=0;i<response.length;i++){
					item=$("<option></option>");
					item.append(response[i]);
					item.attr("value",response[i]);
					html.append(item);
				}
			}
		}
	});
	
	$.ajax({
		url : "anomaly/findAllExceptionType.action",
		type : "post",
		async:true,
		traditional : true,//这里设置为true
		success : function(response) {
			if(response){
				var html = $('#exceptionType');
				for(var i=0;i<response.length;i++){
					item=$("<option></option>");
					item.append(response[i]);
					item.attr("value",response[i]);
					html.append(item);
				}
			}
		}
	});
	
    $('#Relaytimes').datetimepicker({
        format: 'yyyy-mm-dd hh:mm:ss',
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: true
    });
	
    
    $('#additionExceptionBtn').click(addException);
    
    $('#reflshBtn').click(function(){
    	 location.reload();
    });
    
    $('#selectAnomaly').click(function(){
    	$('#tab_receptionConsult').bootstrapTable("refresh", {
    		url : "anomalyManage/findAnomalyManageByCondition.action",
    		silent : true,
    		queryParams : oTable.queryParams
    	});
    });
});	


var addException = function(){
	
	$.ajax({
		url : "anomalyManage/addAnomalyManage.action",
		type : "POST",
		data : {
			"exceptionNo" : $('#exceptionNo').val(),
			"exceptionType" : $('#exceptionType').val(),
			"exceptionItem":$('#exceptionItem').val(),
			"Relaytimes":$('#Relaytimes').val(),
			"carriageTo":$('#carriageTo').val(),
			"disposeTo":$('#disposeTo').val(),
			"remarks" : $('#remarks').val(),
		},
		traditional : true,//这里设置为true
		success : function(response) {
			if (response.status == "success" ) {
				$('#exceptionItem').val('');
				$('#Relaytimes').val('');
				$('#carriageTo').val('');
				$('#disposeTo').val('');
				$('#remarks').val('');
				toastr.success("保存成功");
				
			} else {
				toastr.error("保存失败");
			}
		}
	})
};	




var TableInit = function() {
		var oTableInit = new Object();
		//初始化Table 
		oTableInit.Init = function() {
			
			//时间的转换
			function formatDate(ns) {
				var now = new Date(ns);
				var year=now.getYear()+1900;
				var month=now.getMonth()+1;
				if(month<10){
					month = "0"+month;
				}
				var date=now.getDate();
				if(date<10){
					date = "0"+date;
				}
				var hour=now.getHours();
				if(hour<10){
					hour = "0"+hour;
				}
				var minute=now.getMinutes();
				if(minute<10){
					minute = "0"+minute;
				}
				return year+"-"+month+"-"+date+" "+hour+":"+minute;

			}
			
			$('#tab_receptionConsult').bootstrapTable({
				url : '', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "desc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 10, //每页的记录行数（*） 
				pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
				search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
				strictSearch : true,
				showColumns : true, //是否显示所有的列 
				showRefresh : true, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "exceptionId", //每一行的唯一标识，一般为主键列 
				showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				columns : [ {
					checkbox : true
				}, {
					field : 'exceptionNo',
					title : '异常编号'
				}, {
					field : 'exceptionType',
					title : '异常类型'
				}, {
					field : 'exceptionItem',
					title : '异常项目'
				}, {
					field : 'remarks',
					title : '异常备注'
				}, {
					field : 'exceptionstatus',
					title : '作废状态'
				}, {
					field : 'carriageTo',
					title : '可否运输'
				}, {
					field : 'disposeTo',
					title : '需要处理'
				}, {
					field : 'productName',
					title : '品名'
				}, {
					field : 'admissibilityOfUnits',
					title : '接收单位类型'
				}, {
					field : 'enteringName',
					title : '录入人'
				}, {
					field : 'enteringUnit',
					title : '录入单位'
				}, {
					field : 'enteringTime',
					title : '录入时间',
					formatter:function (value){
						return formatDate(value);
					}
				}]
			});
		}; //得到查询的参数
		
		oTableInit.queryParams = function(params) {
			var temp = {
				limit : params.limit, //页面大小 
				offset : params.offset, //页码 
				coSourcingNo:$('#selectInput').val(),
			};
			return temp;
		};
		

		return oTableInit;
};

