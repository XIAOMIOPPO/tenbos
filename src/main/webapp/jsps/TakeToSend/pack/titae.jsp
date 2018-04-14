<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>包装信息查询</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<link rel="stylesheet" href="static/select/bootstrap-select.css">
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">
<link rel="stylesheet" href="static/toastr/toastr.css">
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/select/bootstrap-select.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>



</head>

<body>
	<div class="panel-body" style="padding-bottom:0px;">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group">
						  <div class="card">
						    <label class="control-label col-sm-1" for="txt_search_workSheetNo">工作单号</label>
						    <div class="col-sm-2 col-md-3">
								<input type="text" class="form-control" id="txt_search_workSheetNo">
							</div>
						  </div>
						  <div class="card">
						    <label class="control-label col-sm-1" for="txt_search_description">品名</label>
							<div class="col-sm-2 col-md-3">
								<input type="text" class="form-control" id="txt_search_description">
							</div>	
						  </div>
						  <div class="card">
						  <label class="control-label col-sm-1" for="txt_search_outId">出库人员</label>
							<div class="col-sm-2 col-md-3">
								<input type="text" class="form-control" id="txt_search_outId">
							</div>
						  </div>
					</div>
					<div class="form-group">
						<div class="card">
							<label class="control-label col-sm-1" for="txt_search_enpId">入库人员</label>
							 <div class="col-sm-2 col-md-3">    
	                        	<input type="text" class="form-control" id="txt_search_enpId">
	                      	 </div>
						</div>
						<div class="card">
							<label class="control-label col-sm-1" for="txt_search_folder">包装人员</label>
							 <div class="col-sm-2 col-md-3">    
	                        	<input type="text" class="form-control" id="txt_search_folder">
	                      	 </div>
						</div>
						<div class="card">
						<label class="control-label col-sm-1" for="txt_search_clieId">委托单位</label>
							 <div class="col-sm-2 col-md-3">    
	                        	<input type="text" class="form-control" id="txt_search_clieId">
	                      	 </div> 
						</div>
					</div>
					<div class="row" >
						<div class="col-sm-6" >
							<button  type="button" style="margin-left:50px" id="btn_query" class="pull-right btn btn-primary">查询</button>
						</div>
					</div>
					
				</form>
			</div>
		</div>
		<table id="tb_departments"></table>
	</div>
	
	<script type="text/javascript">
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'pack/listUserPack', //请求后台的URL（*） 
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
					pageSize : 8, //每页的记录行数（*） 
					pageList : [8,16,24,32], //可供选择的每页的行数（*） 
					search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 1, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "packId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'workSheetNo',
						title : '工作单号'
					}, {
						field : 'description',
						title : '品名'
					}, {
						field : 'metHod',
						title : '发货方式'
					}, {
						field : 'pacKage',
						title : '包装单位'
					}, {
						field : 'enpId',
						title : '入库人'
					}, {
						field : 'taskTime',
						title : '入库时间'
					}, {
						field : 'ruKushi',
						title : '出库时间'
					}, {
						field : 'folder',
						title : '包装员'
					}, {
						field : 'outId',
						title : '出库人'
					}, {
						field : 'clieId',
						title : '委托单位'
					}, {
						field : 'packAges',
						title : '件数'
					}, {
						field : 'wegeht',
						title : '重量'
					}, {
						field : 'gedweight',
						title : '计费重量'
					}, {
						field : 'volume',
						title : '体积'
					}, {
						field : 'expenses',
						title : '运费'
					}]
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
			$('#btn_query').click(function (data){
				  var opt = {
				    url: "pack/listUserPack",
				    silent: true,
				    query:{      
				    	type:1,
				        level:2,
				        workSheetNo : $('#txt_search_workSheetNo').val(),
						description : $('#txt_search_description').val(),
					  	outId : $('#txt_search_outId').val(),
					  	enpId : $('#txt_search_enpId').val(),
					  	folder : $('#txt_search_folder').val(),
					  	clieId : $('#txt_search_clieId').val()
				    }
				  };
				  $('#tb_departments').bootstrapTable('refresh', opt);
			});


			return oTableInit;
		};

		var ButtonInit = function() {
			var oInit = new Object();
			var postdata = {};
			oInit.Init = function() {
				//初始化页面上面的按钮事件 
				$("#btn_add").click(function() {
					$("#uModal").modal('show');
					
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
