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

<title>工作单打印</title>

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
						<label class="control-label col-sm-1" for="search_consignmentType">发货类型</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_consignmentType" />
						</div>
						<label class="control-label col-sm-1" for="search_consignmentWay">发货方式</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_consignmentWay" />
						</div>
						<label class="control-label col-sm-1" for="search_arrivePlace">到达地</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_arrivePlace" />
						</div>
					</div>
					<div class="col-sm-12" style="text-align: left;">
						<button type="button" style="margin-left: 50px" id="btn_query"
							class="btn btn-primary pull-right">查询</button>
					</div>
				</form>
			</div>
		</div>

	<div id="toolbar" class="btn-group">
		<button id="btn_add" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>批量生成工作单号
		</button>
		<button id="btn_search" type="button" class="btn btn-info">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>查询
		</button>
		<button id="btn_stamp" type="button" class="btn btn-danger">
			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>打印
		</button>
	</div>
	<table id="tb_departments"></table>
</div>

<!-- ------------------------------------------------------------------------------------------- -->
	<!-- 批量生成工作单号模态框 -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">批量生成单号</h4>
				</div>
				<div class="modal-body" id="test">

					<form class="form-horizontal" id="addWorkSheet" role="form"
						action=" /addWorkSheet">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">初始单号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="startNum"
									placeholder="请输入初始单号">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">生成数量</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="createNum"
									placeholder="请输入生成数量">
							</div>
						</div>
					</form>
				</div>
				
				<div class="modal-footer">
					<button type="button" id="add_worklistnum" class="btn btn-primary">
						提交更改</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>

<!-- ----------- -->


	<script type="text/javascript"> 
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'stamp/findStampPagenation',
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
					pageSize : 10, //每页的记录行数（*） 
					pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
					search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "stampNum", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'stampNum',
						title : '序号'
					}, {
						field : 'workSheetNum',
						title : '工作单号'
					}, {
						field : 'consignmentType',
						title : '发货类型'
					}, {
						field : 'consignmentWay',
						title : '发货方式'
					}, {
						field : 'arrivePlace',
						title : '到达地'
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
				//批量生成工作单号 按钮
				$("#btn_add").click(function() {
					//显示模态框
					$('#addModal').modal('show');
				});
				
				//查询
				$("#btn_search").click(function(){
					//跳转至查询工作单界面
				});
				
				//打印
				$("btn_stamp").click(function(){
					//弹出打印模态框
					$('stampModal').modal('show');
				});
			};
			return oInit;
		};
		
		//模糊查询
		$("#btn_query").click(function() {
			var stamp = {
				url : "stamp/findStampPagenationWithCriteria",
				silent : true,
				query : {
					type : 1,
					leavel : 3,
					consignmentType : $('#search_consignmentType').val(),
					consignmentWay : $('#search_consignmentWay').val(),
					arrivePlace : $('#search_arrivePlace').val(),
					offset : 0
				}
			};
			$('#tb_departments').bootstrapTable('refresh', stamp);
		});

		//批量生成工作单号
		$("#add_worklistnum").click(function() {
			//配置表单
			var options = {
				//目标url
				url : 'stamp/addWorkSheet',
				//成功回调函数
				success : function(data) {
					if(data.status='success'){
						toastr.success("添加成功");
						$('#tb_departments')
						.bootstrapTable('refresh');
					}else{
						toastr.error("添加失败");						
					}
				},
				//请求方式
				type : 'post',
			};
			console.log(options);
			//异步提交表单
			$("#addWorkSheet").ajaxSubmit(options);
			//隐藏模态框
			$('#addModal').modal('hide');
			//
			$("#addWorkSheet").find(":input").val('');
		});

		

		$(function() {
			//1.初始化Table 
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件 
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();
			
		});

		$(function() {
			$('#add_worklistnum').bootstrapValidator({	
				fields:{
					message:'初始单号校验失败',
					validators:{
						notEmpty:{
							message:'初始单号不能为空'
						}
					}
				},
				fields:{
					message:'生成数量校验失败',
					validators:{
						notEmpty:{
							message:'生成数量不能为空'
						}
					}
				},
			});	
		});
		
	</script>
</body>
</html>
