$(function(){
	//1.初始化Table 
	var oTable = new TableInit();
	oTable.Init();

	//录入 按钮点击事件
	$('#entry').click(function(){
		
		
		$('#entryModal').modal('show');
	});
	
	$('#exceptionType').select2({
		 tags: true
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
	
	//保存异常的点击事件
	$('#addAnomalyBtn').click(addAnomalyBtn);
	
	//作废异常信息按钮点击事件
	$('#destroyAnomaly').click(destroyAnomaly);
});	

var addAnomalyBtn = function(){
	var exceptionType = $('#exceptionType').val();
	var exceptionItem = $('#exceptionItem').val();
	var takeInOrgType = $('#takeInOrgType').val();
	var carriageTo = $('#carriageTo').val();
	var disposeTo = $('#disposeTo').val();
	var automaticMarker = $('#automaticMarker').val();
	var anomalyDesc = $('#anomalyDesc').val();
	
	$.ajax({
		url : "anomaly/addAnomaly.action",
		type : "post",
		data : {
			"exceptionType" : exceptionType,
			"exceptionItem" : exceptionItem,
			"takeInOrgType" : takeInOrgType,
			"carriageTo" : carriageTo,
			"disposeTo" : disposeTo,
			"automaticMarker" : automaticMarker,
			"exceptionRemark" : anomalyDesc,
			"secondOrgTo":"否",
			"status":'否',
		},
		async:true,
		traditional : true,//这里设置为true
		success : function(response) {
			if (response.status == "success") {
				toastr.success("异常信息保存成功"); 
				var url = {
						url : 'anomaly/findAllAnomaly.action'
					};
					$('#tab_receptionConsult')
							.bootstrapTable('refresh',
									url);
			} else {
				toastr.error("异常信息保存失败");  
			}
		}
	});
	
	$('#entryModal').modal('hide');
};

var destroyAnomaly = function(){
	var select = $('#tab_receptionConsult').bootstrapTable('getSelections');
	
	if (select.length === 0) {
		toastr.warning("请至少选择一行");
	}else if(select[0]['status'] == '是' || select[0]['status'] == '已作废'){
		toastr.warning("不能作废已经被作废的异常信息");
	}else {
		var arrs = [];
		for (var i = 0; i < select.length; i++) {
			if(select[i]['status'] == '是' || select[i]['status'] == '已作废'){
				toastr.warning("不能作废已经被作废的异常信息");
			}else{
				arrs[i] = select[i]['exceptionId'];
			}
		}
		$.ajax({
			url : "anomaly/deleteAnomaly.action",
			type : "post",
			data : {
				"exceptionIds" : arrs
			},
			traditional : true,//这里设置为true
			success : function(response) {
				if (response.status == "success" ) {
					toastr.success("作废异常信息成功");
					var url = {
						url : 'anomaly/findAllAnomaly.action'
					};
					$('#tab_receptionConsult')
							.bootstrapTable('refresh',
									url);
				} else {
					toastr.error("作废异常信息失败");
				}
			}
		})
	}
	
	
	
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
				url : 'anomaly/findAllAnomaly.action', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				toolbar : '#anomalyBtn', //工具按钮用哪个容器 
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
				uniqueId : "consultId", //每一行的唯一标识，一般为主键列 
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
					field : 'exceptionRemark',
					title : '异常备注'
				}, {
					field : 'status',
					title : '作废状态',
					formatter:function (value){
						if(value =='否'){
							return '未作废';
						}else{
							return '已作废';
						}
					}
				}, {
					field : 'carriageTo',
					title : '可否运输'
				}, {
					field : 'disposeTo',
					title : '需要处理'
				}, {
					field : 'automaticMarker',
					title : '自动标识'
				}, {
					field : 'takeInOrgType',
					title : '接收单位类型'
				}, {
					field : 'entering',
					title : '录入人'
				}, {
					field : 'enteringOrg',
					title : '录入单位'
				}, {
					field : 'enteringTime',
					title : '录入时间',
					formatter:function (value){
						return formatDate(value);
					}
				}, {
					field : 'enteringNum',
					title : '人员编号'
				},]
			});
		}; //得到查询的参数
		
		oTableInit.queryParams = function(params) {
			var temp = {
				limit : params.limit, //页面大小 
				offset : params.offset, //页码 
			};
			return temp;
		};
		

		return oTableInit;
};

