<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="shiro" uri="http://shiro.apache.org/tags"%>
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>abnormalMonitoringSingle</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="static/toastr/toastr.css">
<link rel="stylesheet" href="static/select/bootstrap-select.css">
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">

<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript" src="static/select/bootstrap-select.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
</head>
<body>
	<div id="toolbar" class="btn-group">
		<button id="btn_add" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span> 异常查询
		</button>
		<button id="btn_transfer" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span> 刷新
		</button>
		<button id="btn_delete" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> 退出
		</button>
	</div>
	<div  class="panel-body" style="padding-bottom:0px;">
		<div class="form-group">
			<table id="tb_departments"></table>
		</div>
		<div class="form-group">
			<button>
				<span>出入库跟踪</span>
			</button>
			<button>
				<span>单货异常关闭</span>
			</button>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
				$('#tb_departments').bootstrapTable({
					url : '', //请求后台的URL（*） 
					method : 'post', //请求方式（*） 
					toolbar : '#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : false, //是否启用排序 sortable
					sortOrder : "asc", //排序方式
					queryParams : queryParams,//传递参数（*） 
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
					uniqueId : "abnormalId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'abnormalNo',
						title : '异常编号'	
					}, {
						field : 'launchTime',
						title : '发起时间'
					}, {
						field : 'launch',
						title : '发起人'
					}, {
						field : 'launchUnit',
						title : '发起单位'
					}, {
						field : 'abnormalType',
						title : '异常类型'
					}, {
						field : 'transferNo',
						title : '交接单号'
					}, {
						field : 'oddNo',
						title : '单号'
					}, {
						field : 'packageNo',
						title : '合包号'
					}, {
						field : 'abnormalHedgingNo',
						title : '对冲异常编号'
					}, {
						field : 'status',
						title : '状态'
					}, {
						field : 'processingTime',
						title : '处理时间'
					}]
				});
				
			});
			
			queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset //页码
				};
				return temp;
			};
	</script>
</body>
</html>