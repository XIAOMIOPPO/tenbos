$(function(){
	//1.初始化Table 
	var oTable = new TableInit();
	oTable.Init();
	
	$('#alterOrder').click(function(){
		var select = $('#tab_receptionConsult').bootstrapTable('getSelections');
		if (select.length === 0 || select.length >1) {
			toastr.warning("请选择一行数据");
		}else {
			$('#exceptionSelectId1').val(select[0]['exceptionManageId']);
			$('#myModal12').modal('show');
		}
		
	});
	
	
	
	$('#updateDisposeBtn').click(function(){
			$.ajax({
				url : "anomalyManage/updateDisposeMessage.action",
				type : "POST",
				data : {
					exceptionManageId : $('#exceptionSelectId1').val(),
					result : $('resultDisTo').val()
				},
				traditional : true,//这里设置为true
				success : function(response) {
					if (response.status == "success" ) {
						toastr.success("处理成功");
						var url = {
								url : 'anomalyManage/findAllAnomalyManage.action'
							};
							$('#tab_receptionConsult')
									.bootstrapTable('refresh',
											url);
					} else {
						toastr.error("处理失败");
					}
				}
			})
			$('#myModal12').modal('hide');

	});

	
	$('#destroyOrder').click(function(){
		var select = $('#tab_receptionConsult').bootstrapTable('getSelections');
		if (select.length === 0 || select.length >1) {
			toastr.warning("请选择一行数据");
		}else {
			$('#exceptionSelectId2').val(select[0]['exceptionManageId']);
			$('#myModal14').modal('show');
		}
	});
	
	$('#updateNotarizeBtn').click(function(){
			$.ajax({
				url : "anomalyManage/updateNotarizeMessage.action",
				type : "POST",
				data : {
					exceptionManageId : $('#exceptionSelectId2').val(),
					affirmFruit : $('#affirmFruitSe').val()
				},
				traditional : true,//这里设置为true
				success : function(response) {
					if (response.status == "success" ) {
						toastr.success("确认成功");
						var url = {
								url : 'anomalyManage/findAllAnomalyManage.action'
							};
							$('#tab_receptionConsult')
									.bootstrapTable('refresh', 
											url);
					} else {
						toastr.error("确认失败");
					}
				}
			})
			$('#myModal14').modal('hide');
	});

});	





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
				url : 'anomalyManage/findAllAnomalyManage.action', //请求后台的URL（*） 
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
					field : 'coSourcingNo',
					title : '条码号'
				}, {
					field : 'productName',
					title : '品名'
				}, {
					field : 'principal',
					title : '委托人'
				}, {
					field : 'principalOrg',
					title : '委托单位'
				}, {
					field : 'exceptionType',
					title : '异常类型'
				}, {
					field : 'exceptionItem',
					title : '异常项目'
				}, {
					field : 'carriageTo',
					title : '可否运输'
				}, {
					field : 'disposeTo',
					title : '可否处理'
				}, {
					field : 'actualPortReality',
					title : '实际到港时间',
					formatter:function (value){
						return formatDate(value);
					}
				}, {
					field : 'remarks',
					title : '备注'
				}, {
					field : 'enteringName',
					title : '录入人'
				}, {
					field : 'enteringUnit',
					title : '录入单位'
				}, {
					field : 'processor',
					title : '处理人'
				},{
					field : 'processingUnit',
					title : '处理单位'
				},{
					field : 'processTime',
					title : '处理时间',
					formatter:function (value){
						return formatDate(value);
					}
				}, {
					field : 'exceptionstatus',
					title : '异常状态'
				}, {
					field : 'affirmName',
					title : '确认人'
				}, {
					field : 'affirmUnit',
					title : '确认单位'
				}, {
					field : 'affirmTime',
					title : '确认时间',
					formatter:function (value){
						return formatDate(value);
					}
				}, {
					field : 'affirmJobNumber',
					title : '确认人工号'
				},{
					field : 'affirmFruit',
					title : '确认结果'
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

