<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>table</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<style type="text/css">
<
style type ="text /css">body {
	font-size: 24px;
	margin: 0;
	padding: 0
}

.row {
  margin-top: 6px;
  margin-bottom: 6px;
}
.background {
	margin-left: 100px;
}

p {
	height: 40px;
	line-height: 40px;
}

.open-model {
	text-align: center;
}

.open-model input {
	padding: 10px 20px;
	font-size: 24px;
	line-height: 24px;
	border: 0px;
	background: #F53639;
	color: #FFF;
	cursor: pointer;
}

.open-model input:hover {
	background: #F3726D;
}

.open-model input:focus {
	border: 0px;
	outline-width: 0px;
}

.model {
	opacity: 0.75;
	background: #666;
	position: fixed;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	z-index: 1000;
}

.model-dialog {
	width: 600px;
	height: 400px;
	background: white;
	position: absolute;
	z-index: 1001;
	left: 0;
	top: 0;
}

.hide {
	display: none;
}

/* #myModal{
    position: absolute; z-index: 1003;   
            width:320px; height:320px; text-align:center;  
} */
</style>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/toastr/toastr.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-select.css">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">


<script src="${pageContext.request.contextPath}/static/jquery-3.2.1.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/collapse.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-select.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
</head>

<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-heading">
				<a href="#collapse" data-toggle="collapse">查询条件</a>
			</div>
			<div class="panel-body collapse" id="collapse">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1" for="search_fixedAreaName">定区名</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_fixedAreaName">
						</div>
						<label class="control-label col-sm-1" for="search_userName">区负责人</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_userName">
						</div>
						<div class="col-sm-4" style="text-align: left;">
						  <shiro:hasPermission name="DQ:SEARCH">
							<button type="button" style="margin-left: 50px" id="btn_query"
								class="btn btn-primary">查询</button>
						  </shiro:hasPermission>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button"
				class="btn btn-default btn-danger">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button id="edit_cli" type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>管理客户
			</button>
		   <button id="edit_emp" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>管理职员
			</button>
			<button id="edit_par" type="button"
				class="btn btn-danger">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>管理分区
			</button>
		</div>
		<table id="tb_fixedArea" class="tab tab-hover"></table>
		<hr />
		
		<ul class="nav nav-tabs">
			<li><a href="#fixedArea_client" data-toggle="tab">客户信息</a></li>
			<li><a href="#fixedArea_emp" data-toggle="tab">职员信息</a></li>
			<li><a href="#fixedArea_partition" data-toggle="tab">分区信息</a></li>
		</ul>		
				
		<div id="myTabContent" class="tab-content">
			<div id="fixedArea_emp" class="tab-pane fade in active">
				<table id="tb_fixedArea_emp"></table>
			</div>
			<div id="fixedArea_client" class="tab-pane fade">
				<table id="tb_fixedArea_client"></table>
			</div>
			<div id="fixedArea_partition" class="tab-pane fade">
				<table id="tb_fixedArea_partition"></table>
			</div>
		</div>
	</div>

    <shiro:hasPermission name="DQ:MA">
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">定区名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="fixedAreaName"
									placeholder="请输入定区名称">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">区负责人</label>
							<div class="col-sm-10">
								<select id="userName" class="form-control"></select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">用户编号</label>
							<div class="col-sm-10">
								<select id="id_select" class="form-control" readOnly="readOnly"></select>
							</div>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button id="sub" type="button" class="btn btn-warning">提交</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	</shiro:hasPermission>
    
    <shiro:hasPermission name="DQ:MB">
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">定区名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="fixedAreaNameUp"
									placeholder="定区名称">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">定区编码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="fixedAreaNumUp"
									placeholder="定区编码">
							</div>
						</div>


					</form>
				</div>
				<div class="modal-footer">
					<button id="subUp" type="button" class="btn btn-warning">提交</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	</shiro:hasPermission>
	
	<shiro:hasPermission name="DQ:MC">
	<div class="modal fade" id="myModal4" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:750px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
					<label style="float:left;margin-left:15px">管理分区</label>&nbsp;				       
					<label id="fNP" class="control-label" style="float:right;margin-right:45px"></label><label for="lastname" class="control-label" style="float:right;">当前定区名称:</label>
					</h4>
				</div>
				<div class="modal-body">
				    <div class="container">
						<div class="input-group">
							<span class="input-group-btn">
								<button id="searchF" class="btn btn-default" type="button">搜索</button>
							</span> 
							<input id="searchFQ" type="text" class="form-control" style="width:210px">
						</div>
						<div class="row">
                         <div class="col-sm-3">
                           <table id="tb_fixedArea_partition1"></table>
                         </div>
                         <div class="col-sm-1">
                          <div class="row" style="height:100px"></div>
                          <div class="row">
                            <button id="addPar" type="button" class="btn btn-inverse">》》》</button>
                          </div>   
                          <div class="row">
                            <button id="remPar" type="button" class="btn btn-inverse">《《《</button>
                          </div>
                         </div>
                         <div class="col-sm-3">
                           <table id="tb_fixedArea_partition2"></table>
                         </div>      
                       </div>
                    </div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	</shiro:hasPermission>
	
	<shiro:hasPermission name="DQ:MD">
	<div class="modal fade" id="myModal5" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:750px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel"><label style="float:left;margin-left:15px">管理客户</label>&nbsp;				       
					<label id="fNC" class="control-label" style="float:right;margin-right:45px"></label><label for="lastname" class="control-label" style="float:right;">当前定区名称:</label></h4>
				</div>
				<div class="modal-body">
				    <div class="container">
				       <div class="input-group">
							<span class="input-group-btn">
								<button id="searchK" class="btn btn-default" type="button">搜索</button>
							</span> 
							<input id="searchKH" type="text" class="form-control" style="width:210px">
						</div>
                       <div class="row">
                         <div class="col-sm-3">
                           <table id="tb_fixedArea_client1"></table>
                         </div>
                         <div class="col-sm-1">
                          <div class="row" style="height:100px"></div>
                          <div class="row">
                            <button id="addCli" type="button" class="btn btn-inverse">》》》</button>
                          </div>   
                          <div class="row">
                            <button id="remCli" type="button" class="btn btn-inverse">《《《</button>
                          </div>
                         </div>
                         <div class="col-sm-3">
                           <table id="tb_fixedArea_client2"></table>
                         </div>      
                       </div>
                    </div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	</shiro:hasPermission>
	
	<shiro:hasPermission name="DQ:ME">
	<div class="modal fade" id="myModal6" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:750px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel"><label style="float:left;margin-left:15px">管理职员</label>&nbsp;				       
					<label id="fNE" class="control-label" style="float:right;margin-right:45px"></label><label for="lastname" class="control-label" style="float:right;">当前定区名称:</label></h4>
				</div>
				<div class="modal-body">
				    <div class="container">
				    <div class="input-group">
							<span class="input-group-btn">
								<button id="searchZ" class="btn btn-default" type="button">搜索</button>
							</span> 
							<input id="searchZY" type="text" class="form-control" style="width:210px">
						</div>
                       <div class="row">
                         <div class="col-sm-3">
                           <table id="tb_fixedArea_emp1"></table>
                         </div>
                         <div class="col-sm-1">
                          <div class="row" style="height:100px"></div>
                          <div class="row">
                            <button id="addEmp" type="button" class="btn btn-inverse">》》》</button>
                          </div>   
                          <div class="row">
                            <button id="remEmp" type="button" class="btn btn-inverse">《《《</button>
                          </div>
                         </div>
                         <div class="col-sm-3">
                           <table id="tb_fixedArea_emp2"></table>
                         </div>      
                       </div>
                    </div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	</shiro:hasPermission>
	



	<script type="text/javascript">
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_fixedArea').bootstrapTable({
				url : 'fixedArea/findFixedAreaPage', //请求后台的URL（*） 
				method : 'get', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParamsType : "undefined",//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 2, //每页的记录行数（*） 
				pageList : [ 1, 25, 50, 100 ], //可供选择的每页的行数（*） 
				search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
				strictSearch : true,
				showColumns : true, //是否显示所有的列 
				showRefresh : true, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				height : 300, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "fixedAreaId", //每一行的唯一标识，一般为主键列 
				showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				queryParams : function queryParams(params) {
					var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					pageSize : params.pageSize, //页面大小 
					pageNumber : params.pageNumber, //页码 
					fixedAreaName : $("#search_fixedAreaName").val(),
									userName : $("#search_userName").val()
					};
				return temp;
				},onClickRow : function(row) {

				//客户表
				var obj = {
				url : "fixedArea/findClientByFixedArea?fixedAreaId="+ row.fixedAreaId,
				silent : true,

				};

				$('#tb_fixedArea_client').bootstrapTable('refresh', obj)

				//分区表
				var obj1 = {
				url : "fixedArea/findPartitionByFixedArea?fixedAreaId="+ row.fixedAreaId,
				silent : true,

				};

				$('#tb_fixedArea_partition').bootstrapTable('refresh', obj1)

				//职员表
				var obj2 = {
				url : "fixedArea/findEmpByFixedArea?fixedAreaId="+ row.fixedAreaId,
				silent : true,

				};

				$('#tb_fixedArea_emp').bootstrapTable('refresh', obj2)
				},
				columns : [ {
				checkbox : true},
				{
				field : 'fixedAreaNum',
				title : '定区编号'
				}, {
				field : 'fixedAreaName',
				title : '定区名'
				}, {
				field : 'userId',
				title : '用户编号'
				}, {
				field : 'userName',
				title : '区域负责人'
				} ]
			});

			}; //得到查询的参数

			//客户表
			$('#tb_fixedArea_client').bootstrapTable({
				url : 'client/findCilentPagenation1', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 200, //每页的记录行数（*） 
				pageList : [ 8, 25, 50, 100 ], //可供选择的每页的行数（*） 
				strictSearch : true,
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				height : 300, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "clientId", //每一行的唯一标识，一般为主键列 
				columns : [ {
					checkbox : true
				}, {
					field : 'clientId',
					title : '客户编号'
				}, {
					field : 'clientName',
					title : '客户姓名'
				}, {
					field : 'phoneNum',
					title : '联系电话'
				}, {
					field : 'clientType',
					title : '客户类型'
				} ]
			});

			//分区表
			$('#tb_fixedArea_partition').bootstrapTable({
				url : 'partitionPageQuery', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 200, //每页的记录行数（*） 
				pageList : [ 3, 25, 50, 100 ], //可供选择的每页的行数（*） 
				strictSearch : true,
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				height : 300, //行高，如果没有设置height属性，表格自动根据记录条数决定表格高度 
				uniqueId : "partitionId", //每一行的唯一标识，一般为主键列 
				detailView : false, //是否显示父子表
				columns : [ {
					checkbox : true
				}, {
					field : 'partitionId',
					title : '分区编号'
				}, {
					field : 'province',
					title : '省'
				}, {
					field : 'county',
					title : '市'
				}, {
					field : 'property',
					title : '县'
				} ]
			});

			//职员表
			$('#tb_fixedArea_emp').bootstrapTable({
				url : 'emp/findAllEmp.action', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : true, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 200, //每页的记录行数（*） 
				pageList : [ 5, 10, 20 ], //可供选择的每页的行数（*） 
				strictSearch : true,
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				height : 300, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "empId", //每一行的唯一标识，一般为主键列 
				singleSelect : false, //设置单选  
				columns : [ {
					checkbox : true
				}, {
					field : 'empId',
					title : '职员编号'
				}, {
					field : 'empName',
					title : '职员姓名'
				}, {
					field : 'orgName',
					title : '部门名称'
				}, {
					field : 'deliverName',
					title : '收派名称'
				} ]

			});
			
			$('#tb_fixedArea_partition1').bootstrapTable({
				url : 'partitionPageQuery', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 200, //每页的记录行数（*） 
				pageList : [ 3, 25, 50, 100 ], //可供选择的每页的行数（*） 
				minimumCountColumns : 1, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				height : 300, //行高，如果没有设置height属性，表格自动根据记录条数决定表格高度 
				uniqueId : "partitionId", //每一行的唯一标识，一般为主键列 
				columns : [ {
					checkbox : true
				}, {
					field : 'addressKey',
					title : '分区'
				} ]
			});
			
			$('#tb_fixedArea_partition2').bootstrapTable({
				url : 'partitionPageQuery', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 200, //每页的记录行数（*） 
				pageList : [ 3, 25, 50, 100 ], //可供选择的每页的行数（*） 
				minimumCountColumns : 1, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				height : 300, //行高，如果没有设置height属性，表格自动根据记录条数决定表格高度 
				uniqueId : "partitionId", //每一行的唯一标识，一般为主键列 
				columns : [ {
					checkbox : true
				}, {
					field : 'addressKey',
					title : '分区'
				} ]
			});
			
			$('#tb_fixedArea_client1').bootstrapTable({
				url : 'client/findCilentPagenation', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 200, //每页的记录行数（*） 
				pageList : [ 8, 25, 50, 100 ], //可供选择的每页的行数（*） 
				strictSearch : true,
				clickToSelect : true, //是否启用点击选中行 
				height : 300, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "clientId", //每一行的唯一标识，一般为主键列 
				columns : [ {
					checkbox : true
				},{
					field : 'clientName',
					title : '客户姓名'
				} ]
			});
			
			$('#tb_fixedArea_client2').bootstrapTable({
				url : 'client/findCilentPagenation', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 200, //每页的记录行数（*） 
				pageList : [ 8, 25, 50, 100 ], //可供选择的每页的行数（*） 
				strictSearch : true,
				clickToSelect : true, //是否启用点击选中行 
				height : 300, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "clientId", //每一行的唯一标识，一般为主键列 
				columns : [ {
					checkbox : true
				},{
					field : 'clientName',
					title : '客户姓名'
				} ]
			});
			
			$('#tb_fixedArea_emp1').bootstrapTable({
				url : 'emp/findAllEmp.action', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 200, //每页的记录行数（*） 
				pageList : [ 8, 25, 50, 100 ], //可供选择的每页的行数（*） 
				strictSearch : true,
				clickToSelect : true, //是否启用点击选中行 
				height : 300, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "empId", //每一行的唯一标识，一般为主键列 
				singleSelect : false, //设置单选  
				columns : [ {
					checkbox : true
				}, {
					field : 'empName',
					title : '职员姓名'
				}]

			});
			
			$('#tb_fixedArea_emp2').bootstrapTable({
				url : 'emp/findAllEmp.action', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 200, //每页的记录行数（*） 
				pageList : [ 8, 25, 50, 100 ], //可供选择的每页的行数（*） 
				strictSearch : true,
				clickToSelect : true, //是否启用点击选中行 
				height : 300, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "empId", //每一行的唯一标识，一般为主键列 
				singleSelect : false, //设置单选  
				columns : [ {
					checkbox : true
				}, {
					field : 'empName',
					title : '职员姓名'
				}]

			});
			
			

			return oTableInit;
		};

		var ButtonInit = function() {
			var oInit = new Object();
			var postdata = {};
			oInit.Init = function() {
				//初始化页面上面的按钮事件 
				$("#btn_add").click(function() {
					$('#myModal').modal('show');
					$(':input').val("");

					findFUN();
					findFUId();
					$("#userName").change(function(){
						 //定区编号
		                    findFUId();
		                   
						});
					
				});

				$("#btn_edit").click(function() {
					var select = $('#tb_fixedArea').bootstrapTable('getSelections');
						if (select.length != 1) {
						   toastr.info("请选择一行");
						} else {
							$('#myModal2').modal('show')
							var obj = select[0];
							var upFixedAreaId = obj.fixedAreaId;
							var upFixedAreaName = obj.fixedAreaName;
							var upFixedAreaNum = obj.fixedAreaNum;

							$("#fixedAreaNameUp").val(upFixedAreaName);
							$("#fixedAreaNumUp").val(upFixedAreaNum);

							//修改
				    $("#subUp").click(function() {
						var fAName = $("#fixedAreaNameUp").val();
						var fNum = $("#fixedAreaNumUp").val();

						$.ajax({
							url : "fixedArea/updateFixedArea",
							type : "post",
							data : {
							  "fixedAreaId" : upFixedAreaId,
							  "fixedAreaName" : fAName,
							  "fixedAreaNum" : fNum

							},
							traditional : true,//这里设置为true
							success : function(result) {
							  if (result == "success") {
							    toastr.success("修改成功");
							    $('#tb_fixedArea').bootstrapTable('refresh');
								$('#myModal2').modal('hide')
							  } else {
								toastr.error("修改失败");
							  }
						  }
						});

					});
				  }

				});

				$("#btn_delete").click(function() {
					var select = $('#tb_fixedArea').bootstrapTable('getSelections');
					if (select.length === 0) {
						toastr.info("请选择一行");
					} else {
						layer.msg('确定删除？',{
						  time : 0 //不自动关闭
						  ,btn : [ '确定', '取消' ],
						  yes : function(index) {
							layer.close(index);
							var arrs = [];
							for (var i = 0; i < select.length; i++) {
							  arrs[i] = select[i]['fixedAreaId'];
							}
										$.ajax({
											url : "fixedArea/deleteFixedArea",
											type : "post",
											data : {
											"fixedAreaId" : arrs
											},
											traditional : true,//这里设置为true
											success : function(result) {
											if (result == "success") {
											  toastr.success("删除成功");

											  $('#tb_fixedArea').bootstrapTable('refresh');
											} else {
											  toastr.error("删除失败");
											}
										  }
										});
																			
					      }
				       });
				     }
				});
			};
			return oInit;
		};

		//搜索
		$("#btn_query").click(function() {
			var obj = {
				url : "fixedArea/findFixedAreaPageByTerm",
				silent : true,
				query : {
					fixedAreaName : $('#search_fixedAreaName').val(),
					userName : $('#search_userName').val(),
					pageNumber : 1
				} 
			};
			$('#tb_fixedArea').bootstrapTable('refresh', obj)
			$(':input').val("");
		});
		
		//管理分区
		$("#edit_par").click(function(){
			var select = $('#tb_fixedArea').bootstrapTable('getSelections');
			if (select.length != 1) {
			   toastr.info("请选择一行");
			}else {
				$('#myModal4').modal('show')
				var obj = select[0];
				var upFixedAreaId = obj.fixedAreaId;
				var upFixedAreaName = obj.fixedAreaName;
				$("#fNP").html(upFixedAreaName);
				
				$("#searchF").click(function(){
					var part={
							url:"fixedArea/findPartitionNotInFixedArea?fixedAreaId="+upFixedAreaId+"&county="+$('#searchFQ').val(),
							silent:true,
					}
					$('#tb_fixedArea_partition1').bootstrapTable('refresh', part);
				});

				var obj2 = {
						url : "fixedArea/findPartitionNotInFixedArea?fixedAreaId="+ upFixedAreaId,
						silent : true,

						};

				$('#tb_fixedArea_partition1').bootstrapTable('refresh', obj2)
				//修改
                var obj1 = {
				url : "fixedArea/findPartitionByFixedArea?fixedAreaId="+ upFixedAreaId,
				silent : true,

				};

				$('#tb_fixedArea_partition2').bootstrapTable('refresh', obj1)
				
				//传入
				$("#addPar").click(function(){
					var select = $('#tb_fixedArea_partition1').bootstrapTable('getSelections');
					if (select.length === 0) {
						toastr.info("请选择一行");
					}else if(select.length >=4){
						toastr.info("超过限制行数4行");
					}else {
						var arrs = [];
						for (var i = 0; i < select.length; i++) {
						    arrs[i] = select[i]['partitionId'];
						}

					    $.ajax({
							url : "fixedArea/managePartition",
							type : "post",
							data : {
							  "fixedAreaId" : upFixedAreaId,
							  "partitionId" : arrs,

							},
							traditional : true,//这里设置为true
							success : function(result) {
							  if (result == "success") {
							    toastr.success("管理分区成功");
							    var obj2 = {
										url : "fixedArea/findPartitionNotInFixedArea?fixedAreaId="+ upFixedAreaId,
										silent : true,

										};

										$('#tb_fixedArea_partition1').bootstrapTable('refresh', obj2)
								//修改
				                var obj1 = {
								url : "fixedArea/findPartitionByFixedArea?fixedAreaId="+ upFixedAreaId,
								silent : true,

								};

								$('#tb_fixedArea_partition2').bootstrapTable('refresh', obj1)
								$('#tb_fixedArea').bootstrapTable('refresh')
							  } else {
								toastr.error("管理分区失败");
							  }
						  }
						}); 
																			
								}
				       
				     });
				
				//传出
				$("#remPar").click(function(){
					var select = $('#tb_fixedArea_partition2').bootstrapTable('getSelections');
					if (select.length === 0) {
						toastr.info("请选择一行");
					}else if(select.length >=4){
						toastr.info("超过限制行数4行");
					}else {
						var arrs = [];
						for (var i = 0; i < select.length; i++) {
						    arrs[i] = select[i]['partitionId'];
						}

					    $.ajax({
							url : "fixedArea/managePar",
							type : "post",
							  data : {
							  "fixedAreaId" : upFixedAreaId,
							  "partitionId" : arrs,

							},
							traditional : true,//这里设置为true
							success : function(result) {
							  if (result == "success") {
							    toastr.success("管理分区成功");
							    var obj2 = {
										url : "fixedArea/findPartitionNotInFixedArea?fixedAreaId="+ upFixedAreaId,
										silent : true,

										};

										$('#tb_fixedArea_partition1').bootstrapTable('refresh', obj2)
								//修改
				                var obj1 = {
								url : "fixedArea/findPartitionByFixedArea?fixedAreaId="+ upFixedAreaId,
								silent : true,

								};

								$('#tb_fixedArea_partition2').bootstrapTable('refresh', obj1)
								$('#tb_fixedArea').bootstrapTable('refresh')
							  } else {
								toastr.error("管理分区失败");
							  }
						  }
						}); 
																			
								}
				       
				     });
					

	       }
			
		});
		
		//管理客户
		$("#edit_cli").click(function(){
			var select = $('#tb_fixedArea').bootstrapTable('getSelections');
			if (select.length != 1) {
			   toastr.info("请选择一行");
			} else {
				$('#myModal5').modal('show')
				var obj = select[0];
				var upFixedAreaId = obj.fixedAreaId;
				var upFixedAreaName = obj.fixedAreaName;
				
				$("#fNC").html(upFixedAreaName);
				
				$("#searchK").click(function(){
					var cli={
							url:"fixedArea/findClientNotInFixedArea?fixedAreaId="+upFixedAreaId+"&clientName="+$('#searchKH').val(),
							silent:true,
					}
					$('#tb_fixedArea_client1').bootstrapTable('refresh', cli);
				});
				
				//左表刷新
				var obj2 = {
						url : "fixedArea/findClientNotInFixedArea?fixedAreaId="+ upFixedAreaId,
						silent : true,

						};

				$('#tb_fixedArea_client1').bootstrapTable('refresh', obj2)

				//右表刷新
                var obj1 = {
				url : "fixedArea/findClientByFixedArea?fixedAreaId="+ upFixedAreaId,
				silent : true,

				};

				$('#tb_fixedArea_client2').bootstrapTable('refresh', obj1)
				
				//传入
				$("#addCli").click(function(){
					var select = $('#tb_fixedArea_client1').bootstrapTable('getSelections');
					
					if (select.length === 0) {
						toastr.info("请选择一行");
					}else if(select.length >=10){
						toastr.info("超过限制行数10行");
					}else {
						var arrs = [];
						for (var i = 0; i < select.length; i++) {
						    arrs[i] = select[i]['clientId'];
						}

					    $.ajax({
							url : "fixedArea/addFixedAreaClient",
							type : "post",
							data : {
							  "fixedAreaId" : upFixedAreaId,
							  "clientId" : arrs,

							},
							traditional : true,//这里设置为true
							success : function(result) {
							  if (result == "success") {
							    toastr.success("管理客户成功");
							    
							  //左表刷新
								var obj2 = {
										url : "fixedArea/findClientNotInFixedArea?fixedAreaId="+ upFixedAreaId,
										silent : true,

										};

								$('#tb_fixedArea_client1').bootstrapTable('refresh', obj2)

								//右表刷新
				                var obj1 = {
								url : "fixedArea/findClientByFixedArea?fixedAreaId="+ upFixedAreaId,
								silent : true,

								};

								$('#tb_fixedArea_client2').bootstrapTable('refresh', obj1)
							  } else {
								toastr.error("管理客户失败");
							  }
						  }
						}); 
																			
								}
				       
				     });
				
				//传出
				$("#remCli").click(function(){
					var select = $('#tb_fixedArea_client2').bootstrapTable('getSelections');
					
					if (select.length === 0) {
						toastr.info("请选择一行");
					}else if(select.length >=10){
						toastr.info("超过限制行数10行");
					} else {
						var arrs = [];
						for (var i = 0; i < select.length; i++) {
						    arrs[i] = select[i]['clientId'];
						}

					    $.ajax({
							url : "fixedArea/deleteFixedAreaClient",
							type : "post",
							data : {
							  "fixedAreaId" : upFixedAreaId,
							  "clientId" : arrs,

							},
							traditional : true,//这里设置为true
							success : function(result) {
							  if (result == "success") {
							    toastr.success("管理客户成功");
							    //左表刷新
								var obj2 = {
										url : "fixedArea/findClientNotInFixedArea?fixedAreaId="+ upFixedAreaId,
										silent : true,

										};

								$('#tb_fixedArea_client1').bootstrapTable('refresh', obj2)

								//右表刷新
				                var obj1 = {
								url : "fixedArea/findClientByFixedArea?fixedAreaId="+ upFixedAreaId,
								silent : true,

								};

								$('#tb_fixedArea_client2').bootstrapTable('refresh', obj1)
							  } else {
								toastr.error("管理客户失败");
							  }
						  }
						}); 
																			
								}
				       
				     });
					

	       }
			
		});

		//管理职员

		$("#edit_emp").click(function(){
			var select = $('#tb_fixedArea').bootstrapTable('getSelections');
			if (select.length != 1) {
			   toastr.info("请选择一行");
			} else {
				$('#myModal6').modal('show')
				var obj = select[0];
				var upFixedAreaId = obj.fixedAreaId;
				var upFixedAreaName = obj.fixedAreaName;
				
				$("#fNE").html(upFixedAreaName);
				
				$("#searchZ").click(function(){
					var emp={
							url:"fixedArea/findEmpNotInFixedArea?fixedAreaId="+upFixedAreaId+"&empName="+$('#searchZY').val(),
							silent:true,
					}
					$('#tb_fixedArea_emp1').bootstrapTable('refresh', emp);
				});
				
				//左表刷新
				var obj2 = {
						url : "fixedArea/findEmpNotInFixedArea?fixedAreaId="+ upFixedAreaId,
						silent : true,

						};

				$('#tb_fixedArea_emp1').bootstrapTable('refresh', obj2)

				//右表刷新
                var obj1 = {
				url : "fixedArea/findEmpByFixedArea?fixedAreaId="+ upFixedAreaId,
				silent : true,

				};

				$('#tb_fixedArea_emp2').bootstrapTable('refresh', obj1)
				
				//传入
				$("#addEmp").click(function(){
					var select = $('#tb_fixedArea_emp1').bootstrapTable('getSelections');
					
					if (select.length === 0) {
						toastr.info("请选择一行");
					}else if(select.length >=5){
						toastr.info("超过限制行数5行");
					} else {
						var arrs = [];
						for (var i = 0; i < select.length; i++) {
						    arrs[i] = select[i]['empId'];
						}

					    $.ajax({
							url : "fixedArea/addFixedAreaEmp",
							type : "post",
							data : {
							  "fixedAreaId" : upFixedAreaId,
							  "empId" : arrs,

							},
							traditional : true,//这里设置为true
							success : function(result) {
							  if (result == "success") {
							    toastr.success("管理职员成功");
							    
							  //左表刷新
								var obj2 = {
										url : "fixedArea/findEmpNotInFixedArea?fixedAreaId="+ upFixedAreaId,
										silent : true,

										};

								$('#tb_fixedArea_emp1').bootstrapTable('refresh', obj2)

								//右表刷新
				                var obj1 = {
								url : "fixedArea/findEmpByFixedArea?fixedAreaId="+ upFixedAreaId,
								silent : true,

								};

								$('#tb_fixedArea_emp2').bootstrapTable('refresh', obj1)
							  } else {
								toastr.error("管理职员失败");
							  }
						  }
						}); 
																			
								}
				       
				     });
				
				//传出
				$("#remEmp").click(function(){
					var select = $('#tb_fixedArea_emp2').bootstrapTable('getSelections');
					
					if (select.length === 0) {
						toastr.info("请选择一行");
					}else if(select.length >=5){
						toastr.info("超过限制行数5行");
					} else {
						var arrs = [];
						for (var i = 0; i < select.length; i++) {
						    arrs[i] = select[i]['empId'];
						}

					    $.ajax({
							url : "fixedArea/deleteFixedAreaEmp",
							type : "post",
							data : {
							  "fixedAreaId" : upFixedAreaId,
							  "empId" : arrs,

							},
							traditional : true,//这里设置为true
							success : function(result) {
							  if (result == "success") {
							    toastr.success("管理职员成功");
							    //左表刷新
								var obj2 = {
										url : "fixedArea/findEmpNotInFixedArea?fixedAreaId="+ upFixedAreaId,
										silent : true,

										};

								$('#tb_fixedArea_emp1').bootstrapTable('refresh', obj2)

								//右表刷新
				                var obj1 = {
								url : "fixedArea/findEmpByFixedArea?fixedAreaId="+ upFixedAreaId,
								silent : true,

								};

								$('#tb_fixedArea_emp2').bootstrapTable('refresh', obj1)
							  } else {
								toastr.error("管理职员失败");
							  }
						  }
						}); 
																			
								}
				       
				     });
					

	       }
			
		});

		$(function() {
			//1.初始化Table 
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件 
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();

			$("#sub").click(function() {
				
				var fixedAreaName = $("#fixedAreaName").val();
				var userId = $("#id_select").val();
				var userName = $("#userName").val();
				
				if(fixedAreaName==null || fixedAreaName==''){
					$("#fixedAreaName").attr("style","color:#FF0000");
					$("#fixedAreaName").val("定区名不能为空!"); 
					$("#fixedAreaName").click(function(){
						$(":input").val("");
						$("#fixedAreaName").attr("style","color:#000000");
					})
				
					
				}else{
				$.ajax({
					url : "fixedArea/addFixedArea",
					type : "post",
					data : {
						"fixedAreaName" : fixedAreaName,
						"userId" : userId,
						"userName" : userName

					},

					success : function(result) {
						if (result == "success") {
							toastr.success("添加成功");
							$('#tb_fixedArea').bootstrapTable('refresh');
							$('#myModal').modal('hide');
							$(':input').val("");
						} else {
							toastr.error("添加失败");
							$(
							'#myModal')
							.modal(
									'hide')
						}
					}
				});
				}

			});

		});
		
		
		
		
		function findFUN(){
			$.ajax({
				url : "fixedArea/findUserName",
				type : "post",
				traditional : true,
				success : function(response) {
                var select = $("#userName");
                  for(var i=0;i<response.length;i++){
                	  item=$("<option></option>");
                	  item.append(response[i]);
                	  item.attr("value",response[i]);
                	  select.append(item);
                  };
				}
			});
		}
		
		function findFUId(){
			var parUserName=$("#userName").val();

			
			$.ajax({
				url : "fixedArea/findUserId",
				type : "post",
				data : {
					  "userName" : parUserName

				}, 
				traditional : true,
				success : function(response) {
                var select = $("#id_select");
                  for(var i=0;i<response.length;i++){
                	  item=$("<option selected='selected'></option>");
                	  item.append(response[i]);
                	  item.attr("value",response[i]);
                	  select.append(item);
                  };
                  
                  //定区编号
                  
				}
			});
		}

		
		
	</script>


</body>
</html>
