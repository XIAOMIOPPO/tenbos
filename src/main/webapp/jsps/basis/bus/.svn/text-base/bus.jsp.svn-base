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

<title>班车</title>

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
						<label class="control-label col-sm-1" for="search_licenseNum">车牌号</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_licenseNum" />
						</div>
						<label class="control-label col-sm-1" for="search_motorcycleType">车型</label>
						<div class="col-sm-3">
							<select class="form-control" id="search_motorcycleType">
								<option></option>
								<option>大型卡车</option>
								<option>中型卡车</option>
								<option>小型卡车</option>
								<option>三轮车</option>
							</select>
							<!-- <input type="text" class="form-control"
								id="search_motorcycleType" /> -->
						</div>
						<label class="control-label col-sm-1"
							for="search_commonCarrier">承运商</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"	
								id="search_commonCarrier" />
						</div>
					</div>
					<div class="col-sm-12" style="text-align: left;">
						<button type="button" style="margin-left: 50px" id="btn_query"
							class="btn btn-primary pull-right">查询</button>
					</div>
				</form>
			</div>
		</div>
<!-- -------------------------------------------------------------------------------------------- -->

	<div id="toolbar" class="btn-group">
		<button id="btn_add" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
		</button>
		<button id="btn_edit" type="button" class="btn btn-info">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
		</button>
		<button id="btn_delete" type="button" class="btn btn-danger">
			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
		</button>
	</div>
	<table id="tb_departments"></table>
</div>

<!-- ------------------------------------------------------------------------------------------- -->
	<!-- 添加班车模态框 -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">添加班车</h4>
				</div>
				<div class="modal-body" id="test">

					<form class="form-horizontal" id="addBusForm" role="form"
						action="/addBus">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">车牌号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="licenseNum"
									placeholder="请输入车牌号">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">承运商</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="commonCarrier"
									placeholder="请填写承运商">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">车型</label>
							<div class="col-sm-10">
								<select class="form-control" name="motorcycleType"
									id="motocrcycleType">
									<option value="火车">火车</option>
									<option value="大型卡车">大型卡车</option>
									<option value="中型卡车">中型卡车</option>
									<option value="小型卡车">小型卡车</option>
									<option value="三轮车">三轮车</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">司机名</label>
							<div class="col-sm-10">
								<select name="empName" class="empsel selectpicker bla bla bli"
									data-live-search="true">

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">吨控</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="tControl"
									placeholder="请填写卡车载量">
							</div>
						</div>
						<div class="form-group">
							<!-- 关联基础档案表获取数据 -->
							<label for="lastname" class="col-sm-2 control-label">线路类型</label>
							<div class="col-sm-10">
								<select class="bussel selectpicker bla bla bli"
									data-live-search="true">
								</select>
							</div>
						</div>

					</form>
				</div>
<!-- -------------------------------------------------------------------------------------------------- -->
				
				<div class="modal-footer">
					<button type="button" id="add_sub" class="btn btn-primary">
						提交更改</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>

<!-- -------------------------------------------------------------------------------------------------- -->

	<!-- 修改班车的模态框 -->
	<div class="modal fade" id="updateModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">修改班车</h4>
				</div>
				<div class="modal-body" id="test">

					<form class="form-horizontal" id="updateBusForm" role="form"
						action="/updateBus">
						<input type="hidden" name="busId">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">车牌号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="licenseNum"
									name="licenseNum" placeholder="请输入车牌号">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">承运商</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="commonCarrier"
									name="commonCarrier" placeholder="请填写承运商">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">车型</label>
							<div class="col-sm-10">
								<select class="form-control" id="motorcycleType"
									name="motorcycleType">
									<option></option>
									<option value="火车">火车</option>
									<option value="大型卡车">大型卡车</option>
									<option value="中型卡车">中型卡车</option>
									<option value="小型卡车">小型卡车</option>
									<option value="三轮车">三轮车</option>
								</select>
							</div>
						</div>
						<!-- 参考员工表 -->
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">司机</label>
							<div class="col-sm-10">
								<select id="empName" name="empName"
									class="empsel selectpicker bla bla bli" data-live-search="true">

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">吨控</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="tControl"
									name="tControl" placeholder="请填写卡车载量">
							</div>
						</div>
						<div class="form-group">
							<!-- 参考基础档案表 -->
							<label for="lastname" class="col-sm-2 control-label">线路类型</label>
							<div class="col-sm-10">
								<select id="circuitType" class="bussel selectpicker bla bla bli"
									data-live-search="true">

								</select>

							</div>
						</div>

					</form>
				</div>

<!-- ----------------------------------------------------------------------------------------------------- -->

				<div class="modal-footer">
					<button type="button" id="update_sub" class="btn btn-primary">
						提交更改</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>

<!-- ---------------------------------------------------------------------------------------------------- -->







	<script type="text/javascript">
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'bus/findBusPagenationWithCriteria',
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
					uniqueId : "busId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'licenseNum',
						title : '车牌号'
					}, {
						field : 'commonCarrier',
						title : '承运商'
					}, {
						field : 'motorcycleType',
						title : '车型'
					}, {
						field : 'empName',
						title : '司机名'
					}, {
						field : 'tControl',
						title : '吨控'
					}, {
						field : 'fileName',
						title : '线路类型'
					},{
						field : 'circuitName',
						title : '线路名称'
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
				//添加班车
				$("#btn_add").click(function() {
					// b
					$('.bussel').selectpicker({
						'selectedText' : 'cat',
						type : 'select',
						hiddenInput : true,
						url : 'basisFiles/options?remarlk=XLLX',
						inputName : 'circuitType',
						key : 'fileId',
						value : 'fileName'
					});
					//
					$('.empsel').selectpicker({
						'selectedText' : 'cat',
						type : 'select',
						hiddenInput : true,
						url : 'bus/allEmp',
						inputName : 'empId',
						key : 'empId',
						value : 'empName'
					});
					//
					$('#addModal').modal('show');
				});

				//修改班车
				$("#btn_edit").click(
						function() {
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请选择一行");
							} else {
								var rowdata = select[0]; //获得被选中数组中的第一个元素
								$('.empsel').selectpicker({
									'selectedText' : 'cat',
									type : 'select',
									hiddenInput : true,
									url : 'bus/allEmp',
									inputName : 'empId',
									key : 'empId',
									value : 'empName'
								});
								//
								$('.empsel').selectpicker('setSelectItem',rowdata.empName);
								//
								$('.bussel').selectpicker({
									'selectedText' : 'cat',
									type : 'select',
									hiddenInput : true,
									url : 'basisFiles/options?code=railway',
									inputName : 'circuitType',
									key : 'fileId',
									value : 'fileName'
								});
								//
								$('.bussel').selectpicker('setSelectItem',rowdata.fileName);
								
								//获得选中行的数据
								//传递值
								$('#updateModal').find(":input").each(
										function() {
											//给表单赋值
											var input = $(this);
											input.val(rowdata[input
													.attr('name')]);
										});
								//
								$('#updateModal').modal('show');
							}
						});

				//删除班车
				$("#btn_delete").click(
						function() {
							//
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请选择一行");
							} else {
								var arrs = [];
								//
								for (var i = 0; i < select.length; i++) {
									arrs[i] = select[i]['busId'];
								}
								//
								$('#tb_departments').bootstrapTable('remove', {
									field : 'busId',
									values : arrs
								});
								//同步数据库
								$.ajax({
									url : "bus/deleteBus",
									type : "post",
									data : {
										"busId" : arrs
									},
									traditional : true,
									success : function(result) {
										if (result.status == "success") {
											toastr.success("删除成功");
											var url = {
												url : 'bus/findBusPagenation'
											};
											$('#tb_departments')
													.bootstrapTable('refresh');
										} else {
											toastr.error("删除失败");
										}
									}
								})
							}
						});
			};
			return oInit;
		};
		//模糊查询
		$("#btn_query").click(function() {
			var bus = {
				url : "bus/findBusPagenationWithCriteria",
				silent : true,
				query : {
					type : 1,
					leavel : 5,
					licenseNum : $('#search_licenseNum').val(),
					motorcycleType : $('#search_motorcycleType').val(),
					circuitType : $('#search_circuitType').val(),
					commonCarrier : $('#search_commonCarrier').val(),
					empId : $('#search_empId').val(),
					offset : 0
				}
			};
			$('#tb_departments').bootstrapTable('refresh', bus);
		});

		//添加班车 
		$("#add_sub").click(function() {
			//配置表单
			var options = {
				//目标url
				url : 'bus/addBus',
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
			$("#addBusForm").ajaxSubmit(options);
			//隐藏模态框
			$('#addModal').modal('hide');
			//
			$("#addBusForm").find(":input").val('');
		});

		//修改班车
		$("#update_sub").click(function() {
			//配置表单
			var options = {
				//目标url
				url : 'bus/updateBus',
				//成功回调函数
				success : function(data) {
					$('#updateModal').modal('hide');
					if(data.status='success'){
						toastr.success("修改成功");
						$('#tb_departments')
						.bootstrapTable('refresh');
					}else{
						toastr.error("修改失败");						
					}
				},
				//请求方式
				type : 'post'
			};
			//异步提交表单
			$("#updateBusForm").ajaxSubmit(options);
		});

		$(function() {
			//1.初始化Table 
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件 
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();
			$('.empsel').selectpicker({
				'selectedText' : 'cat',
				type : 'select',
				hiddenInput : true,
				url : 'bus/allEmp',
				inputName : 'empId',
				key : 'empId',
				value : 'empName'
			});
			$('.bussel').selectpicker({
				'selectedText' : 'cat',
				type : 'select',
				hiddenInput : true,
				url : 'basisFiles/options?remarlk=XLLX',
				inputName : 'circuitType',
				key : 'fileId',
				value : 'fileName'
			});
		});

		$(function() {
			$('#add_sub').bootstrapValidator({
				fields:{
					message:'车牌号校验失败',
					validators:{
						notEmpty:{
							message:'车牌号不可为空'
						}
					}
				},
				fields:{
					message:'承运商校验失败',
					validators:{
						notEmpty:{
							message:'该承运商不存在'
						}
					}
				},
				fields:{
					message:'司机校验失败',
					validators:{
						notEmpty:{
							message:'该司机不存在'
						}
					}
				},
				fields:{
					message:'吨控校验失败',
					validators:{
						notEmpty:{
							message:'吨控不可为空'
						}
					}
				},
				fields:{
					message:'线路校验失败',
					validators:{
						notEmpty:{
							message:'该线路不存在'
						}
					}
				}
			});
			$('#update_sub').bootstrapValidator({
				fields:{
					message:'车牌号校验失败',
					validators:{
						notEmpty:{
							message:'车牌号不可为空'
						}
					}
				},
				fields:{
					message:'承运商校验失败',
					validators:{
						notEmpty:{
							message:'该承运商不存在'
						}
					}
				},
				fields:{
					message:'司机校验失败',
					validators:{
						notEmpty:{
							message:'该司机不存在'
						}
					}
				},
				fields:{
					message:'吨控校验失败',
					validators:{
						notEmpty:{
							message:'吨控不可为空'
						}
					}
				},
				fields:{
					message:'线路校验失败',
					validators:{
						notEmpty:{
							message:'该线路不存在'
						}
					}
				}
			});
		});
		
	</script>
</body>
</html>
