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

<title>签收录入</title>

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
						<label class="control-label col-sm-1" for="search_drawerName">录入人姓名</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_drawerName"/>
						</div>
						<label class="control-label col-sm-1" for="search_workSheetNo">工作单号</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_workSheetNo"/>
						</div>
						<label class="control-label col-sm-1" for="search_signType">签收类型</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_signType"/>
						</div>
						<label class="control-label col-sm-1" for="search_empNo">派送人员工号</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_empNo"/>
						</div>
						<label class="control-label col-sm-1" for="search_sendUnit">单位</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="search_sendUnit"/>
						</div>
					</div>
					<div class="col-sm-12" style="text-align: left;">
						<button type="button" style="margin-left: 50px" id="btn_query"
							class="btn btn-primary pull-right">
							查询
						</button>
					</div>
				</form>
			</div>
		</div>
		
		<!-- -------------- -->
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>增加
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>删除未保存的签收录入
			</button>
			<button id="btn_update" type="button" class="btn btn-default">'
				<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>修改
			</button>
			<button id="btn_search" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>申请单查询
			</button>
		</div>
	<table id="tb_departments"></table>
</div>
	
	<!-- 添加模态框 -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" style="margin-left:-100px">
		<div class="modal-dialog">
			<div class="modal-content" style="width:800px">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">新增</h4>
				</div>
				<div class="modal-body" id="test">

					<form class="form-horizontal" id="addSignForm" role="form"
						action="/addSign">
						<div class="form-group">
							<!-- 关联工作单表  -->
							<label for="lastname" class="col-sm-2 control-label">工作单号</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="workSheetNo"
									placeholder="请输入工作单号">
							</div>
							<label for="lastname" class="col-sm-2 control-label">返货标志</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="returnSign"
									placeholder="请填写返货标志">
							</div>
						</div>
						
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">工作单类型</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="workSheetType"
									placeholder="请填写工作单类型">
							</div>
							<label for="lastname" class="col-sm-2 control-label">签收类型</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="signType"
									placeholder="请填写签收类型">
							</div>
						</div>
						
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">原单核销标志</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="verificationMark"
									placeholder="请填写原单核销标志">
							</div>
							<label for="lastname" class="col-sm-2 control-label">签收人</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="recipient"
									placeholder="请填写签收人">
							</div>
						</div>
						<div class="form-group">
							<!-- 参考员工表 -->
							<label for="lastname" class="col-sm-2 control-label">派送员工</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="empNo"
									placeholder="请填写派送员工号">
							</div>
							<!-- 参考员工表 -->
							<label for="lastname" class="col-sm-2 control-label">派送员名称</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="empName"
									placeholder="请填写派送员名称">
							</div>
						</div>
						<div class="form-group">
							<!-- 关联组织结构表 -->
							<label for="lastname" class="col-sm-2 control-label">派件单位</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="sendUnit"
									placeholder="请填写派件单位">
							</div>
							<label for="lastname" class="col-sm-2 control-label">签收时间</label>
							<div class="col-sm-4">
								<input type="text" class="form-control time" name="signTime"
									placeholder="请选择签收时间">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">录入人</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="drawerName"
									placeholder="请填写录入人">
							</div>
							<label for="lastname" class="col-sm-2 control-label">录入单位</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="drawerCompany"
									placeholder="请填写录入单位">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">录入时间</label>
							<div class="col-sm-4">
								<input type="text" class="form-control time" name="drawerTime"
									placeholder="请选择录入时间">
							</div>
						</div>

					</form>
				</div>
				
				<div class="modal-footer">
					<button type="button" id="add_sign" class="btn btn-primary">
						提交</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
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
					<form class="form-horizontal" id="updateSignForm" role="form"
						action="/updateSignIn">
						<!-- 通过已经签收工作单的签收人删除 -->
						<input type="hidden" name="recipient">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">签收人</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="addressesName"
									name="addressesName" placeholder="请填写新的签收人">
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
		$('.time').datetimepicker({  
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
					url : 'sign/findSignPagenation',
					method : 'post', //请求方式（*） 
					toolbar :'#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : false, //是否启用排序 
					sortOrder : "asc", //排序方式l
					queryParams : oTableInit.queryParams,//传递参数（*） 
					sidePagination : "client", //分页方式：client客户端分页，server服务端分页（*） 
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
					uniqueId : "signInId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'signId', 
						title : '签收录入Id'
					}, {
						field : 'workSheetNo',
						title : '工作单号'
					}, {
						field : 'cargoReturnSign',
						title : '返货标志'
					}, {
						field : 'workSheetType',
						title : '工作单类型'
					}, {
						field : 'signType',
						title : '签收类型'
					}, {
						field : 'verificationMark',
						title : '原单核销标志'
					}, {
						field : 'addressesName',
						title : '签收人'
					}, {
						field : 'empNo',
						title : '派送员工号'
					}, {
						field : 'empName',
						title : '派送员名称'
					}, {
						field : 'sendUnit',
						title : '派件单位'
					}, {
						field : 'signTime',
						title : '签收时间',
						formatter:function (value){
							return FormatDate(value);
						}
					}, {
						field : 'drawerName',
						title : '录入人'
					}, {
						field : 'drawerCompany',
						title : '录入单位'
					}, {
						field : 'drawerTime',
						title : '录入时间',
						formatter:function (value){
							return FormatDate(value);
						}
					}, {
						field : 'abnormalRemarks',
						title : '异常信息备注'
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
				$("#btn_add").click(function(){
					$('#addModal').modal('show');
				});
				//添加
				$("#add_sign").click(function(){
					//配置表单
					var options = {
						//目标url
						url : 'sign/addSignIn',
						//成功回调函数
						success : function(data){
							if(data.status='success'){
								toastr.success("添加成功");
								$('#tb_departments').bootstrapTable('refresh');
							}else{
								toastr.error("添加失败");
							}
						},
						//请求方式
						type : 'post',
					};
					console.log(options);
					//异步提交表单
					$("#addSignForm").ajaxSubmit(options);
					//隐藏模态框
					$('#addModal').modal('hide');
					$('#addSignForm').find(":input").val('');
				});
				
				//修改
				$("#btn_update").click(function(){
					$('#updateModal').modal('show');
				});

				//删除
				$("#btn_delete").click(
					function(){
						var select = $('tb_departments').bootstrapTable
						('getSelections');
						if(select.length === 0){
							toastr.warning("请选择一行");
						}else{
							var arrs = [];
							for(var i = 0;i< select.length; i++){
								arrs[i] = select[i]['signId']
							}
							$('#tb_departments').bootstrapTable('remove',{
								field : 'signId',
								values : arrs
							});
							$.ajax({
								url : "sign/deleteSignIn",
								type: "post",
								data : {
									"signId" : arrs
								},
								traditional : true,
								successs : function(result){
									if(result.status == "success"){
										toastr.success("删除成功");
										var url ={
											url : 'sign/findSignPagenation'
										};
										$('#tb_departments').bootstrapTable('refresh');
									}else{
										toastr.error("删除失败")
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
			var sign = {
				url : "sign/findSignPagenation",
				silent : true,
				query : {
					type : 1,
					leavel : 5,
					drawerName : $('#search_drawerName').val(),
					workSheetNo : $('#search_workSheetNo').val(),
					signType : $('#search_signType').val(),
					empNo : $('#search_empNo').val(),
					sendUnit : $('#search_sendUnit').val(),
					offset : 0
				}
			};
			$('#tb_departments').bootstrapTable('refresh', sign);
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
		function FormatDate (strTime) {
		    var date = new Date(strTime);
		    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
		}
	</script>
</body>
</html>
