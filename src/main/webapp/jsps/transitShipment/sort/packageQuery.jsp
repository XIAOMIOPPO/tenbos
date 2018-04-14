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

<title>packageQuery</title>
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
<link rel="stylesheet" href="static/select/bootstrap-treeview.min.css">

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
<script type="text/javascript" src="static/select/bootstrap-treeview.min.js"></script>
<script type="text/javascript" src="static/select/jquery.cookie.js"></script>
</head>
<body>
	<div id="toolbar" class="btn-group">
		<button id="btn_query" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span> 查询
		</button>
		<button id="btn_transfer" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span> 刷新
		</button>
		<button id="btn_delete" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-print" aria-hidden="true"></span> 打印
		</button>
		<button id="btn_highPrimary" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span> 返回
		</button>
	</div>
	<div  class="panel-body" style="padding-bottom:0px;">
		<div class="col-sm-9">
			<table id="tb_departments"></table>
		</div>
		<div class="col-sm-3">
			<table id="tb_departments1"></table>
		</div>
	</div>
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:800px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">查询</h4>
				</div>
				<div class="modal-footer">
					<div class="form-group">
						<div class="col-sm-4">
							<ul id="myTab" class="nav nav-tabs">
							   <li class="active"><a href="#home" data-toggle="tab">
							      候选条件</a>
							   </li>
							   <li><a href="#ios" data-toggle="tab">保存条件</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
							   <div class="tab-pane fade in active" id="home" style="height:400px">
							      <div id="tree"></div>
							      <ul id="browser" class="filetree treeview-famfamfam">
							      	<li><span class="folder">所有条件</span>
										<ul>
											<li><span class="file">合包号</span></li>
											<li><span class="file">合包日期</span></li>
											<li><span class="file">拆包状态</span></li>
											<li><span class="file">封签号</span></li>
											<li><span class="file">合包单位</span></li>
											<li><span class="file">拆包单位</span></li>
										</ul>
									</li>
							      </ul>
							   </div>
							   <div class="tab-pane fade" id="ios" style="height:400px;">
									<div style="folat:right;margin-top:10px;">
								      <button type="button">
								      	<span>+</span>
								      </button>
								      <button type="button">
								      	<span>-</span>
								      </button>
									</div>
									<div style="height:350px;margin-top:10px;border:1px solid red;border-radius:5px">
										<span 	>
											...收藏夹
										</span>
									</div>
							   </div>
							</div>
						</div>
						<div class="col-sm-8">
							<ul id="myTab" class="nav nav-tabs">
							   <li class="active"><a href="#home1" data-toggle="tab">
							      候选条件</a>
							   </li>
							   <li><a href="#ios1" data-toggle="tab">保存条件</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
							   <div class="tab-pane fade in active" id="home1">
							      <button ></button>
							   </div>
							   <div class="tab-pane fade" id="ios1">
							      <p>iOS is a mobile operating system developed and distributed by Apple 
							         Inc. Originally released in 2007 for the iPhone, iPod Touch, and 
							         Apple TV. iOS is derived from OS X, with which it shares the 
							         Darwin foundation. iOS is Apple's mobile version of the 
							         OS X operating system used on Apple computers.</p>
							   </div>
							</div>
						</div>
					</div>
				</div>
			</div>
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
					uniqueId : "packageId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'packageNo',
						title : '合包号'	
					}, {
						field : 'sealNumber',
						title : '封签号'
					}, {
						field : 'packageUnit',
						title : '合包单位'
					}, {
						field : 'packageName',
						title : '合包人'
					}, {
						field : '',
						title : '拆包人'
					}, {
						field : '',
						title : '拆包单位'
					}, {
						field : '',
						title : '拆包时间'
					}, {
						field : '',
						title : '记录人'
					}, {
						field : '',
						title : '记录时间'
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
			
			$(function(){
				$("#btn_query").click(function(){
					$("#myModal").modal('show');
				});
				$(document).ready(function(){
					$("#browser").treeview({
						toggle: function() {
							console.log("%s was toggled.", $(this).find(">span").text());
						}
					});
				});
			});
			
			
			$(function(){
				$('#tb_departments1').bootstrapTable({
					url : '', //请求后台的URL（*） 
					method : 'post', //请求方式（*） 
					//toolbar : '#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : false, //是否启用排序 sortable
					sortOrder : "asc", //排序方式
					queryParams : queryParams1,//传递参数（*） 
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
					uniqueId : "packListId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : '',
						title : '条码号'	
					}]
				});
				
			});
			
			
			queryParams1 = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit1 : params.limit, //页面大小 
					offset1 : params.offset //页码
				};
				return temp;
			};
	</script>
</body>
</html>