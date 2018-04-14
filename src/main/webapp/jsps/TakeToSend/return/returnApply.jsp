<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

<title>returnApply</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">

<script src="${pageContext.request.contextPath}/static/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>

</head>
<body>
	<div  class="panel-body">
		<div class="panel panel-default">
			<div class="panel-heading">查询条件</div>
			<div class="panel-body">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top:15px">
						<label class="control-label col-sm-1"
							for="txt_search_timeName">录入人</label>
						<div class="col-sm-2">
							<input type="text" class="form-control"
								id="txt_search_departmentname">
						</div>
						<label class="control-label col-sm-1" for="txt_search_Date">录入日期</label>
						<div class="col-sm-4">
							<div class="col-lg-5">
								<input type="text" class="form-control" id="startDate">
							</div>
							<span class="col-lg-1">~</span>
							<div class="col-lg-5">
								<input type="text" class="form-control" id="endDate">
							</div>
						</div>
						<label class="control-label col-sm-1"
							for="txt_search_timeName" style="margin-left: -10px">录入单位</label>
						<div class="col-sm-2">
							<input type="text" class="form-control"
								id="txt_search_departmentname">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-1"
							for="txt_search_timeName" style="margin-left: 1px">异常项目</label>
						<div class="col-sm-2">
							<select class="form-control" type="text">
							</select>
						</div>
						<label class="control-label col-sm-1"
							for="txt_search_timeName">异常类型</label>
						<div class="col-sm-3" style="margin-left: 14px">
							<select class="form-control" type="text">
								
							</select>
						</div>
						<label class="control-label col-sm-1"
							for="txt_search_timeName" style="margin-left: 88px">接收单位</label>
						<div class="col-sm-2">
							<input type="text" class="form-control"
								id="txt_search_departmentname">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-4"></div>
						<div class="col-sm-4">
							<div class="col-sm-3">
								<input type="checkbox"> <span>含下级</span>
							</div>
							<div class="col-sm-3">
								<input type="checkbox"> <span>作废</span>
							</div>
							<button type="button" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
			</button>
			<button id="btn_edit" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-default btn-danger">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</div>
		<table id="tb_departments"></table>
	</div>
	<script type="text/javascript">
		$(function(){
			var oTable = new TableInit();
			oTable.Init();
		})
		var TableInit = function() {
			
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : '', //请求后台的URL（*） 
					method : 'post', //请求方式（*） 
					toolbar : '#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : false, //是否启用排序 sortable
					sortOrder : "asc", //排序方式
					queryParams : oTableInit.queryParams,//传递参数（*） 
					sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
					pageNumber : 1, //初始化加载第一页，默认第一页 
					pageSize : 8, //每页的记录行数（*） 
					pageList : [ 8, 16, 25 ], //可供选择的每页的行数（*） 
					search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "applicationId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'jobNo',
						title : '工作单号'	
					}, {
						field : '',
						title : '异常编码'
					}, {
						field : '',
						title : '异常类型 '					
					}, {
						field : '',
						title : '异常项目'
					}, {
						field : '',
						title : '接收单位'
					}, {
						field : '',
						title : '实际到港时间'
					}, {
						field : '',
						title : '作废标记'
					}, {
						field : '',
						title : '处理标志'
					} ]
				});
				
			};
			oTableInit.queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset //页码 
				};
				return temp;
			};

			return oTableInit;
		};
	</script>
</body>

</html>