<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"></base>

<title>日志管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css" rel="stylesheet">
<link href="static/toastr/toastr.css" rel="stylesheet">
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script> 
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
</head>
<body>
	<div class="panel-body" style="padding-bottom:0px;">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top:15px">
						<div class="col-sm-3">
							<input type="text" class="form-control"
								id="userName  " placeholder="请输入操作用户名" >
						</div>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="visitResource" placeholder="请输入访问资源" >
						</div>
						<br>
						<div class="col-sm-3">
							<input type="text" class="form-control time" id="lowDate" placeholder="请输入最小时间" readonly>
							<span class="add-on"><i class="icon-th"></i></span>
						</div>
						<div class="col-sm-3">
							<input type="text" class="form-control time" id="highDate"  placeholder="请输入最大时间" readonly>
							<span class="add-on"><i class="icon-th"></i></span>
						</div>
						<div class="col-sm-4" style="text-align:left;">
						<shiro:hasPermission name="AUTH:ALL">
							<button type="button" style="margin-left:50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</shiro:hasPermission>
						</div>
					</div>
				</form>
			</div>
		</div>
		
		<div id="toolbar" class="btn-group">
		<shiro:hasPermission name="AUTH:LEADING">
		    <button id="btn_leading" type="button" class="btn btn-warning">
				<span class="glyphicon glyphicon-cloud-download" aria-hidden="true"></span>导入
			</button> 
		</shiro:hasPermission>  
		<shiro:hasPermission name="AUTH:EXPORT">
			<button id="btn_export" type="button" class="btn btn-inverse">
				<span class="glyphicon glyphicon-cloud-upload" aria-hidden="true"></span>导出
			</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="AUTH:DELETE">
			<button id="btn_delete" type="button" class="btn btn-danger">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</shiro:hasPermission>
		</div>
		<table id="tb_departments"></table>
	</div>


	<div class="model hide"></div>
	
	<script type="text/javascript">
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'logList', //请求后台的URL（*） 
					method : 'get', //请求方式（*） 
					toolbar : '#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : true, //是否启用排序 
					sortOrder : "asc", //排序方式
					queryParams : oTableInit.queryParams,//传递参数（*） 
					sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
					pageNumber : 1, //初始化加载第一页，默认第一页 
					pageSize : 10, //每页的记录行数（*） 
					pageList : [ 5, 10, 50, 100 ], //可供选择的每页的行数（*） 
					search : false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "logId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'logId',
						title : '日志编号'
					}, {
						field : 'userName',
						title : '操作用户名'
					}, {
						field : 'visitDate',
						title : '访问时间',
						formatter:function formatDate(now){
							now = new Date(now);
							var year = now.getFullYear();
							var month = now.getMonth()+1;
							var date = now.getDate();
							var hour = now.getHours();
							var minute = now.getMinutes();
							var second = now.getSeconds();
							return year+"/"+month+"/"+date+" "+hour+":"+minute+":"+second;
						}
					}, {
						field : 'visitResource',
						title : '访问资源'
					}, {
						field : 'visitResult',
						title : '访问结果'
					} ]
				});
		    }; //得到查询的参数

			oTableInit.queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset, //页码 
					userName : $("#userName").val(),
					lowDate:$("#lowDate").val(),
					highDate:$("#highDate").val(),
				};
				return temp;
			};

			return oTableInit;
		};

		var ButtonInit = function() {
			var oInit = new Object();
			var postdata = {};
			oInit.Init = function() {
				
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
			$('.time').datetimepicker({  
				format: 'yyyy-mm-dd hh:mm:ss',
		        language: 'ch',
		        pickDate: false,
		        pickTime: true 
		    });
			//导出
		    $("#btn_export").click(function(){
		    	layer.msg('确定删除?',{
					time:0,//不自动关闭
					btn:['确认','取消'],
					yes:function(index){
						layer.close(index);
						$.ajax({
				    		type:"get",
				    		url:"outExcelLog.action",
				    		data:{path:"D:\\一键上传\\导出日志.xls"},
				    		success:function(result){
								if(result == "success"){
									toastr.success('导出成功!');
								}else{
									toastr.error('导出失败!');
								}
							}
				    	});
					}
				}); 
		    	
		    });
			
		    $("#btn_delete").click(
					function() {
						var select = $('#tb_departments').bootstrapTable(
								'getSelections');
						if (select.length === 0) {
							toastr.warning("请至少选择一行!");
						} else {
							layer.msg('确定删除?',{
								time:0,//不自动关闭
								btn:['确认','取消'],
								yes:function(index){
									layer.close(index);
									var arrs = [];
									for (var i = 0; i < select.length; i++) {
										arrs[i] = select[i]['logId'];
									}
									$.ajax({
										type: "GET", 
										url:'deleteLogByLogId.action',
										data : {logIds:arrs},
										success:function(result) {
											if (result == "success") {
												toastr.success('删除成功!');
											} else {
												toastr.error('删除失败!');
											}
										}
									});
									$('#tb_departments').bootstrapTable('remove', {
										field : 'logId',
										values : arrs
									});
						       }		
						});							
		             }
		       });			
		});
		function check(){			
			//校验逻辑		
			return true;
		}
	</script>
  </body>
</html>