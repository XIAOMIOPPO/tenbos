<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>工作单日志查询</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link
	href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/toastr/toastr.css"
	rel="stylesheet">
<link
	href="static/select/bootstrap-select.css"
	rel="stylesheet">


<script
	src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="static/jquery.form.js"></script>
<script
	src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/select/bootstrap-select.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
</head>

<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">条件查询</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1" for=""></label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="" />
						</div>
						<label class="control-label col-sm-1" for=""></label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="" />
						</div>
						<label class="control-label col-sm-1" for=""></label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="" />
						</div>
					</div>
					<div class="col-sm-12" style="text-align: left;">
						<button type="button" style="margin-left: 50px" id="btn_query"
							class="btn btn-primary pull-right">查询</button>
					</div>
			</div>
			</form>
		</div>

	<div id="toolbar" class="btn-group">
		
	</div>
	<table id="tb_departments"></table>
</div>


	<script type="text/javascript"> 
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'log/findLogPagenation',
					method : 'post', //请求方式（*） 
					toolbar :'#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : false, //是否启用排序 
					sortOrder : "asc", //排序方式
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
					height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "workSheetLogId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'workSheetLogId', 
						title : '工作单日志号'
					}, {
						field : 'workSheetNo',
						title : '工作单号'
					}, {
						field : 'cargoReturnSign',
						title : '返货标志'
					}, {
						field : 'status',
						title : '状态'
					}, {
						field : 'editMan',
						title : '修改人'
					}, {
						field : 'editTime',
						title : '修改时间'
					}, {
						field : 'editUnit',
						title : '修改单位'
					}, {
						field : 'deleteSource',
						title : '修改原因'
					}, {
						field : 'makeupType',
						title : '录入类型'
					}]
				});
			};

			//得到查询的参数
			oTableInit.queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset
				};
				return temp;
			};
			return oTableInit;
		};

		var ButtonInit = function() {
			var oInit = new Object();
			var postdata = {};
			oInit.Init = function() {
				//初始化页面上面的按钮事件 
			};
			return oInit;
		};
		
		//模糊查询
		$("#btn_query").click(function() {
			var stamp = {
				url : "",
				silent : true,
				query : {
					type : 1,
					leavel : 3,
					consignmentType : $('#').val(),
					consignmentWay : $('#').val(),
					arrivePlace : $('#').val(),
					offset : 0
				}
			};
			$('#tb_departments').bootstrapTable('refresh', stamp);
		});


		

		$(function() {
			//1.初始化Table 
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件 
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();
			
		}); 
		
		//校验
		$(function() {
			
		});
		
	</script>
</body>
</html>
