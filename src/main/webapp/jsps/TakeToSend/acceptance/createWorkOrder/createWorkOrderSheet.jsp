<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/toastr/toastr.css" rel="stylesheet">
<link
	href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="static/jqueryCsxz/zyzn_1.css" rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.css"rel="stylesheet">

<script src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>

<script type="text/javascript" src="static/jqueryCsxz/City_data.js"></script>
<script type="text/javascript" src="static/jqueryCsxz/areadata.js"></script>
<script type="text/javascript" src="static/jqueryCsxz/auto_area.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/edit/bootstrap-table-editable.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/distpicker.data.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/distpicker.js"></script>

</head>
<body>
	<div>
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>已确认
			</button>
			<button id="btn_edit" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>已取件
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>已收货
			</button>
		</div>
		<table id="tb_departments"></table>
	</div>


<script type="text/javascript">
	var TableInit = function() {
		var oTableInit = new Object();
		//初始化Table 
		oTableInit.Init = function() {
			$('#tb_departments').bootstrapTable({
				url : 'workOrder/findAllWorkOrder.action', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
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
				uniqueId : "workOrderId", //每一行的唯一标识，一般为主键列 
				showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				columns : [{
					checkbox : true
				},  {
					field : 'businessRecsiptNo',
					title : '受理单号'
				}, {
					field : 'workOrderTime',
					title : '下单时间',
					formatter:function (value){
						return formatDate(value);
					}
				}, {
					field : 'workOrderType',
					title : '类型'
				}, {
					field : 'traceNum',
					title : '追单次数'
				} ,{
					field : 'wstatus',
					title : '当前状态'
				}, {
					field : 'empNum',
					title : '操作人工号'
				}, {
					field : 'empName',
					title : '取件人'
				}, {
					field : 'takeOrgName',
					title : '受理单位'
				}, {
					field : 'takeTime',
					title : '受理时间',
					formatter:function (value){
						return formatDate(value);
					}
				}, {
					field : 'sortingCode',
					title : '分拣编码'
				}],
			});
		}; //得到查询的参数

		oTableInit.queryParams = function(params) {
			var temp = {
				//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
				limit : params.limit, //页面大小 
				offset : params.offset, //页码 
				departmentname : $("#txt_search_departmentname").val(),
				statu : $("#txt_search_statu").val()
			};
			return temp;
		};

		return oTableInit;
	};
	
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

	var ButtonInit = function() {
		var oInit = new Object();
		var postdata = {};
		oInit.Init = function() {
			//初始化页面上面的按钮事件 
			$("#btn_add").click(function() {
				var select = $('#tb_departments').bootstrapTable(
							'getSelections');
				if (select.length === 0) {
					toastr.warning("请至少选择一行");
				}else if(select.length >1){
					toastr.warning("一次选择一行");
				}else if(select[0]['Wstatus'] == '已确认'||select[0]['Wstatus'] == '已取件' || select[0]['Wstatus'] == '已收货'){
					toastr.warning("不能进行该操作");
				}else{
					var workOrderId = select[0]['workOrderId'];
					$.ajax({
						url : "workOrder/updateWorkOrderStatus.action",
						type : "post",
						data : {
							"workOrderId" : workOrderId ,
							"Wstatus" : "已确认"
						},
						async:true,
						traditional : true,//这里设置为true
						success : function(response) {
							if (response.status == "success") {
								toastr.success("通知接受成功"); 
								var url = {
										url : 'workOrder/findAllWorkOrder.action'
									};
									$('#tb_departments')
											.bootstrapTable('refresh',
													url);
							} else {
								toastr.error("通知接受失败");  
							}
						}
					});
				}
				
			});

			$("#btn_edit").click(
					function() {
						var select = $('#tb_departments').bootstrapTable(
						'getSelections');
						if (select.length === 0) {
							toastr.warning("请至少选择一行");
						}else if(select.length >1){
							toastr.warning("一次选择一行");
						}else if(select[0]['Wstatus'] == '已取件' || select[0]['Wstatus'] == '已收货'){
							toastr.warning("不能进行该操作");
						}else{
							var workOrderId = select[0]['workOrderId'];
							$.ajax({
								url : "workOrder/updateWorkOrderStatus.action",
								type : "post",
								data : {
									"workOrderId" : workOrderId ,
									"Wstatus" : "已取件"
								},
								async:true,
								traditional : true,//这里设置为true
								success : function(response) {
									if (response.status == "success") {
										toastr.success("取件成功"); 
										var url = {
												url : 'workOrder/findAllWorkOrder.action'
											};
											$('#tb_departments')
													.bootstrapTable('refresh',
															url);
									} else {
										toastr.error("取件失败");  
									}
								}
							});
							
							//添加工作单
							$.ajax({
								url : "workOrder/addWorkSheet.action",
								type : "post",
								data : {
									"workOrderId" : select[0]['workOrderId'] ,
								},
								async:true,
								traditional : true,//这里设置为true
								success : function(response) {
									if (response.status == "success") {
										toastr.success("工作单生成成功"); 
									} else {
										toastr.error("工作单生成失败");  
									}
								}
							});
						}

					});

			$("#btn_delete").click(
					function() {
						var select = $('#tb_departments').bootstrapTable(
						'getSelections');
						if (select.length === 0) {
							toastr.warning("请至少选择一行");
						}else if(select.length >1){
							toastr.warning("一次选择一行");
						}else if(select[0]['Wstatus'] == '已通知' || select[0]['Wstatus'] == '已收货'){
							toastr.warning("不能进行该操作");
						}else{
							var workOrderId = select[0]['workOrderId'];
							$.ajax({
								url : "workOrder/updateWorkOrderStatus.action",
								type : "post",
								data : {
									"workOrderId" : workOrderId ,
									"Wstatus" : "已收货"
								},
								async:true,
								traditional : true,//这里设置为true
								success : function(response) {
									if (response.status == "success") {
										toastr.success("收货成功"); 
										var url = {
												url : 'workOrder/findAllWorkOrder.action'
											};
											$('#tb_departments')
													.bootstrapTable('refresh',
															url);
									} else {
										toastr.error("收货失败");  
									}
								}
							});
						}

					});

		};
		return oInit;
	};
	
	

	$(function() {
		//1.初始化Table 
		var oTable = new TableInit();
		oTable.Init();
		//2.初始化Button的点击事件 
		var oButtonInit = new ButtonInit();
		oButtonInit.Init();
	});

</script>























</body>
</html>