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

<title>工作单查询</title>

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
<link rel="stylesheet" 
	href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="jsps/basis/search/css/worksheetsearch.css">

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
<script type="text/javascript" 
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
	
</head>

<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">条件查询</div>
			<div class="panel-body collapse fade" id="searchbody">
			
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1" for="search_workSheetNo ">工作单号:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_workSheetNo" />
						</div>
						<label class="control-label col-sm-1" for="search_cargoReturnSign">返单标记:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_cargoReturnSign" />
						</div>
						<label class="control-label col-sm-1" for="search_productName">品名:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_productName" />
						</div>
						<label class="control-label col-sm-1" for="search_productAmount">件数:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_productAmount" />
						</div>
						<label class="control-label col-sm-1" for="search_product">产品</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_product" />
						</div>
						<label class="control-label col-sm-1" for="search_specialOfferNo">专项报价编号:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_specialOfferNo" />
						</div>
						<label class="control-label col-sm-1" for="search_senderName">寄件人:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_senderName" />
						</div>
						<label class="control-label col-sm-1" for="search_senderPhone">寄件人电话:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_senderPhone" />
						</div>
						<label class="control-label col-sm-1" for="search_senderCompany">寄件人单位:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_senderCompany" />
						</div>
						<label class="control-label col-sm-1" for="search_addresseeAddress">到达地:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_addresseeAddress" />
						</div>
						<label class="control-label col-sm-1" for="search_addressName">收件人:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_addressName" />
						</div>
						<label class="control-label col-sm-1" for="search_signTime">签收人:</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_signTime" />
						</div>
					</div>
					
					<!-- 模糊查询的按钮 -->
					<div class="col-sm-12">
						<button type="button" id="btn_query"class="btn btn-primary pull-right">
							查询
						</button>
					</div>
				</form>
			</div>
		</div>


	<div id="toolbar" class="btn-group">
		<button id="btn_search" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
		</button>
		<button id="btn_update" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>修改
		</button>
		<button id="btn_delete" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>作废
		</button>
		<button id="btn_canceldelete" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>取消作废
		</button>
		<button id="btn_tips" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>任务提示
		</button>
		<button id="btn_logsearch" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>日志查询
		</button>
		<button id="btn_stampsearchResult" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>打印查询结果
		</button>
		<button id="btn_cancel"	 type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>取消
		</button>
		<button id="btn_saved" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>保存
		</button>
		<button id="btn_stampLabel" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-bookmark" aria-hidden="true"></span>打印标签
		</button>
		<button id="btn_stamp" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-book" aria-hidden="true"></span>打印工作单
		</button>
		
		
	</div>
	<table id="tb_departments"></table>
</div>

	<!-- 打印工作单模态框 -->
	<div class="modal fade" id="stampModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body" id="test">
					<ul id="myTab" class="nav nav-tabs">
						<li class="active">
							<a href="#domestic" data-toggle="tab">
								国内
							</a>
						</li>
						<li>
							<a href="#international" data-toggle="tab">
								国际
							</a>
						</li>
					</ul>
				</div>

				<div class="tab-content">
					<!-- 国内工作单 -->
					<div class="tab-pane fade in active" id="domestic">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label class="col-sm-2 control-label"
									style="margin-left: -15px;">工作单号</label>
								<div class="col-sm-4">
									<input class="form-control" id="focusedInput" type="text"
										value="请输入工作单号" style="margin-left: -20px;">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label"
									style="margin-left: -15px;"> 件数: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" type="text"
										placeholder="请输入件数" style="margin-left: -20px;">
								</div>
								<label for="" class="col-sm-2 control-label"
									style="margin-left: -15px;"> 分拣代码: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" type="text"
										placeholder="请填写分拣代码" style="margin-left: -20px;">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label"
									style="margin-left: -15px;"> 发站: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" type="text"
										placeholder="请填写发货站点" style="margin-left: -20px;">
								</div>
								<label for="" class="col-sm-2 control-label"
									style="margin-left: -15px;"> 发货方式: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" type="text"
										placeholder="请填写发货方式" style="margin-left: -20px;">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label"
									style="margin-left: -15px;"> 到站: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" type="text"
										placeholder="请填写到货站点" style="margin-left: -20px;">
								</div>
								<label for="" class="col-sm-2 control-label"
									style="margin-left: -15px;"> 返货标志: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" type="text"
										placeholder="请填写返货标志" style="margin-left: -20px;">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label"
									style="margin-left: -15px;"> 时间: </label>
								<div class="col-sm-4">
									<input class="form-control" id="time" type="text" value="请选择时间"
										style="margin-left: -20px;">
								</div>
							</div>

							<div class="modal-footer">
								<!-- 打印按钮 -->
								<button type="button" class="btn btn-primary btn-xs"
									id="stampworksheet">打印大标签92mm*102mm</button>
								<br />
								<button type="button" class="btn btn-primary btn-xs"
									id="stampworksheet" style="margin-top: 10px; width: 156px;">
									打印小标签92mm*62mm</button>
							</div>
						</form>
					</div>
					<!-- 国际工作单 -->
					<div class="tab-pane fade" id="international">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label for="" class="col-sm-2 control-label"> 工作单表: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" type="text"
										placeholder="请填写工作单号">
								</div>
								<label for="" class="col-sm-2 control-label"
									style="margin-left: -30px;"> 口岸: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" type="text"
										placeholder="请填写出货口岸">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label"> 货物名称: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" type="text"
										placeholder="请填写货物名称">
								</div>
								<label for="" class="col-sm-2 control-label"
									style="margin-left: -30px;"> 发站: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" type="text"
										placeholder="请填写发站地点">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label"> 件数: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" type="text"
										placeholder="请填写货物件数">
								</div>
								<label for="" class="col-sm-2 control-label"
									style="margin-left: -30px;"> 到站: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" type="text"
										placeholder="请填到站地点">
								</div>
							</div>
							<!-- 打印按钮 -->
							<div class="modal-footer">
								<button type="button" class="btn btn-primary">打印(P)</button>
							</div>
						</form>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>



	<!-- 修改模态框 -->
	<div class="modal fade" id="updateModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">修改</h4>
				</div>
				<div class="modal-body" id="test">
					<form class="form-horizontal" id="" role="form"
						action="">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label"> 工作单号: </label>
							<div class="col-sm-4">
								<input class="form-control" id="disabledInput" type="text"
									placeholder="请填写新的工作单号">
							</div>
							<label for="lastname" class="col-sm-2 control-label"
								style="margin-left: -30px;"> 返单标记: </label>
							<div class="col-sm-4">
								<input class="form-control" id="disabledInput" type="text"
									placeholder="请填写返货标志">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label"> 修改时间: </label>
							<div class="col-sm-4">
								<input class="form-control" id="disabledInput" type="text"
									placeholder="请填写新的录入时间">
							</div>
							<label for="lastname" class="col-sm-2 control-label"
								style="margin-left: -30px;"> 修改人: </label>
							<div class="col-sm-4">
								<input class="form-control" id="disabledInput" type="text"
									placeholder="请填写新的录入人">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label"> 修改单位: </label>
							<div class="col-sm-4">
								<input class="form-control" id="disabledInput" type="text"
									placeholder="请填写新的录入单位">
							</div>
							<label for="lastname" class="col-sm-2 control-label"
								style="margin-left: -30px;"> 修改单位: </label>
							<div class="col-sm-4">
								<input class="form-control" id="disabledInput" type="text"
									placeholder="请填写新的修改单位">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label"> 状态: </label>
							<div class="col-sm-4">
								<input class="form-control" id="disabledInput" type="text"
									placeholder="请填写新的状态">
							</div>
							<label for="lastname" class="col-sm-2 control-label"
								style="margin-left: -30px;"> 录入类型: </label>
							<div class="col-sm-4">
								<input class="form-control" id="disabledInput" type="text"
									placeholder="请填写新的录入类型">
							</div>
						</div>
					</form>
				</div>
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
	
	
	<script type="text/javascript">
	$('#time').datetimepicker({  
		format: 'yyyy:MM:dd hh:mm:ss',
        language: 'ch',
        pickDate: false,
        pickTime: true 
      }); 
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'search/findPagenation',
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
					uniqueId : "workSheetNo",  //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'workSheetNo',
						title : '工作单号'
					}, {
						field : 'cargoReturnSign',
						title : '返单标记'
					}, {
						field : 'productName',
						title : '品名'
					}, {
						field : 'productAmount',
						title : '件数'
					}, {
						field : 'product',
						title : '产品'
					}, {
						field : 'specialOfferNo',
						title : '专项报价编号'
					}, {
						field : 'senderName',
						title : '寄件人'
					}, {
						field : 'senderPhone',
						title : '寄件人电话'
					}, {
						field : 'senderCompany',
						title : '寄件人单位'
					}, {
						field : 'addresseeAddress',
						title : '到达地'
					}, {
						field : 'expectedDeliveryTime',
						title : '希望到达时间'
					}, {
						field : 'addresseeName',
						title : '收件人'
					}, {
						field : 'signTime',
						title : '签收时间'
					}, {  
						field : 'makeupMan',
						title : '修改人'
					}, {
						field : 'makeupUnit',
						title : '修改单位'
					}, {
						field : 'makeupTime',
						title : '修改时间'
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
				$("#btn_stamp").click(function() {
					//显示模态框
					$('#stampModal').modal('show');
				})
				//弹出打印框的按钮	
				$('#myTab a').click(function(e){
					$('#myTab a').tab('show')
				})
				//弹出修改模态框的按钮 
				$('#btn_update').click(function(){
					$('#updateModal').modal('show')
				})
			};
			return oInit;
		};
		
		//模糊查询
		$("#btn_query").click(function() {
			var search = {
				url : "search/findPagenationWithCriteria",
				silent : true,
				query : {
					type : 1,
					leavel : 11,
					workSheetNo: $('#search_workSheetNo').val(),
					cargoReturnSign: $('#search_cargoReturnSign').val(),
					productName: $('#search_productName').val(),
					productAmount:$('#search_productAmount').val(),
					product:$('#search_product').val(),
					specialOfferNo:$('#search_specialOfferNo').val(),
					senderName:$('#search_senderName').val(),
					senderPhone:$('#search_senderPhone').val(),
					senderCompany:$('#search_senderCompany').val(),
					addresseeAddress:$('#search_addresseeAddress').val(),
					addressName:$('#search_addressName').val(),
					offset : 0
				}
			};
			$('#tb_departments').bootstrapTable('refresh', search);
		});
		
		//查询按钮
		$('#btn_search').click(function(){
			
		});
		
		//修改按钮
		$('#btn_update').click(function(){
			
		});
		
		//作废按钮
		$('#btn_delete').click(function(){
			
		});
		
		//取消作废
		$('#btn_canceldelete').click(function(){
			
		});
		
		//任务提示
		$('#btn_tips').click(function(){
			
		});
		
		//日志查询按钮 跳转到日志查询页面
		$('#btn_logsearch').click(function(){
			
		});
		
		//打印查询结果
		$('#btn_stampsearchResult').click(function(){
			
		});
		
		//取消
		$('#btn_cancel').click(function(){
			
		});
		
		//保存
		$('#btn_saved').click(function(){
			
		});
		
		//打印标签
		$('#btn_stampLabel').click(function(){
			
		});
		
		//打印工作单
		$('#btn_stamp').click(function(){
			
		})
		
		
		$(function() {
			//1.初始化Table 
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件 
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();
		});

		$(function() {
			
		});
	</script>
</body>
</html>
