<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css"
	rel="stylesheet">
<link href="static/toastr/toastr.css" rel="stylesheet">

<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>

<style type="text/css">
body {
	margin: 0;
	padding: 0;
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

.prompt {
	color: red;
}
</style>

</head>
<body>






	<div id="myTabContent" class="tab-content">
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="#collapseOne" data-toggle="collapse"
							data-parent="#accordion">查询条件</a>
					</div>
					<div class="panel-body collapse fade" id="collapseOne">
						<form id="formSearch" class="form-horizontal">
							<div class="form-group" style="margin-top: 15px">
								<label class="control-label col-sm-1" for="txt_search_statu"
									style="width: 120px;">基础档案名</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="recordName">
								</div>

								<div class="col-sm-4" style="text-align: left;">
									<button type="button" id="btn_query" class="btn btn-primary">查询</button>
								</div>

							</div>
						</form>
					</div>
				</div>

				<!-- 主表 -->
				<div id="toolbar" class="btn-group">
					<button class="btn btn-success" data-toggle="modal"
						data-target="#myModal" >
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
					</button>
					<button id="btn_edit" type="button" class="btn btn-info">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
					</button>
					<button id="btn_delete" type="button" class="btn btn-danger">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
					</button>
				</div>

				<div id="toolbar" class="btn-group">
					<button type="button" class="btn btn-success" id="addHelpFiles">
						<span class="glyphicon glyphicon-plus"></span>新增
					</button>
					<button type="button" class="btn btn-info"
						id="btn_edit_helpFile">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
					</button>
					<button type="button" class="btn btn-danger"
						id="btn_delete_helpFile">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
					</button>
				</div>

				<table id="tb_departments"></table>

			</div>



			<div class="col-md-6">
				<!-- 从表 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="#collapseTwo" data-toggle="collapse"
							data-parent="#accordion">查询条件</a>
					</div>
					<div class="panel-body collapse fade" id="collapseTwo">
						<form id="formSearch" class="form-horizontal">
							<div class="form-group" style="margin-top: 15px">
								<label class="control-label col-sm-1" for="txt_search_statu"
									style="width: 120px;">辅助档案名</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="fileName">
								</div>

								<label class="control-label col-sm-1" for="txt_search_statu"
									style="width: 100px;">助记码</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="mnemonicCode">
								</div>
								<div class="col-sm-4" style="text-align: left;">
									<button type="button" style="margin: -35px 0px 0px 470px"
										id="btn_helpFiles" class="btn btn-primary">查询</button>
								</div>

							</div>
						</form>
					</div>
				</div>



				<table id="table_departments"></table>

			</div>
		</div>


	</div>


	<div class="model hide"></div>
	<!-- 添加基础档案 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加基础档案</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form"
						id="addSubForm">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">基础档案名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="txt_recordName"
									onblur="checkRecordName(this)" onfocus="cancelPrompt(this)"
									placeholder="请输入基础档案名称" name="recordName"> <span
									id="txt_recordName_prompt" class="prompt"></span>
							</div>
						</div>

						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">备注</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="txt_remarlk"
									placeholder="请输入档案备注" onblur="checkRemarlk(this)"
									onfocus="cancelPrompt(this)" name="remarlk"> <span
									id="txt_remarlk_prompt" class="prompt"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="cancel()">关闭</button>
					<button type="button" id="sub" class="btn btn-primary">添加</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 双击主表ID显示字表信息 -->
	<input type="hidden" id="recordIds" value="" />

	<!-- 修改基础档案表开始 -->
	<div class="modal fade" id="myModalEd" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改基础档案</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form" id="updateBasis">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">基础档案名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_recordName"
									placeholder="请输入基础档案名称" name="recordName">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">档案备注</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_remarlk"
									placeholder="请修改备注">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="cancel()">关闭</button>
					<button type="button" id="editSub" class="btn btn-primary">确认修改</button>
				</div>
			</div>
		</div>
	</div>
	<!--修改基础档案表结束  -->

	<!-- 添加辅助档案表开始 -->
	<div class="modal fade" id="myModalAdd" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加子集档案档案</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form"
						id="addHelpFilesForm">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">子集档案名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="file_fileName"
									name="fileName" onblur="checkFileName(this)"
									onfocus="cancelPrompt(this)" placeholder="请输入子集档案名称"> <span
									id="file_fileName_prompt" class="prompt"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">选择父集类型</label>
							<div class="col-sm-10">
								<select id="file_recordId"
									class="selectpicker show-menu-arrow form-control"
									data-hide-disabled="true" data-size="5" name="recordName"></select>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">助记码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="file_mnemonicCode"
									placeholder="请输入助记码" name="mnemonicCode"
									onblur="checkMnemonicCode(this)" onfocus="cancelPrompt(this)">
								<span id="file_mnemonicCode_prompt" class="prompt"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">备注</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="file_remake"
									placeholder="请输入备注" name="remake" onblur="checkRemake(this)"
									onfocus="cancelPrompt(this)"> <span
									id="file_remake_prompt" class="prompt"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="cancel()">关闭</button>
					<button type="button" id="myModalAddSub" class="btn btn-primary">添加</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加辅助档案表结束-->

	<!-- 修改辅助表开始 -->
	<div class="modal fade" id="myModalEdHelpFile" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改子集档案</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form" id="updateFile">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">子集档案名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_fileName" name="fileName"
									placeholder="请输入子集档案名称">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">助记码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_mnemonicCode"
									placeholder="请输入助记码">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">备注</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_remake"
									placeholder="请输入备注">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="cancel()">关闭</button>
					<button type="button" id="editSubHelpFiles" class="btn btn-primary">确认修改</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 修改辅助表结束 -->



	<script type="text/javascript">
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'basisFiles/findAllBasisFiles', //请求后台的URL（*） 
					method : 'post', //请求方式（*） 
					toolbar : '#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : true, //是否启用排序 
					sortOrder: "asc",  //排序方式
					queryParams : oTableInit.queryParamsOne,//传递参数（*） 
					sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
					pageNumber : 1, //初始化加载第一页，默认第一页 
					pageSize : 8, //每页的记录行数（*） 
					pageList : [5,8,10, 20,50 ], //可供选择的每页的行数（*） 
					search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					uniqueId : "recordId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'recordName',
						title : '基础档案名称'
					}, {
						field : 'classification',
						title : '是否分级',
						formatter:function(data){
							if(data=='1'){
								return '否';
							}else{
								return '是';
							}
						}
					} , {
						field : 'remarlk',
						title : '备注'
					} ],
					  //双击基础档案ID显示子类信息
					  onDblClickRow:function(row,tr){
						var recordId = row.recordId;
						$("#recordIds").val(recordId);
						var opt = {
								url : "basisFiles/findAllHelpFiles",
								silent : true,
								query : {
									type : 1,
									level : 2,
									recordId : recordId,
									offset:0
								}
							};
							$('#table_departments').bootstrapTable('refresh', opt);
					}  
				});
				
				//辅助档案表格
				$('#table_departments').bootstrapTable({
					url : 'basisFiles/findAllHelpFiles', //请求后台的URL（*） 
					method : 'post', //请求方式（*） 
					toolbar : '#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : true, //是否启用排序 
					sortOrder : "asc", //排序方式
					queryParams : oTableInit.queryParamsTwo,//传递参数（*） 
					sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
					pageNumber : 1, //初始化加载第一页，默认第一页 
					pageSize : 8, //每页的记录行数（*） 
					pageList : [5,8,10, 20,50 ], //可供选择的每页的行数（*） 
					search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行  
					uniqueId : "fileId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					},{
						field : 'fileName',
						title : '辅助档案名'
					},{
						field : 'recordName',
						title : '上级档案名称'
					},{
						field : 'mnemonicCode',
						title : '助记码'
					},{
						field:'isUse',
						title:'是否作废',
						formatter:function(data){
							if(data=='1'){
								return '否';
							}else{
								return '是';
							}
						}
					},{
						field : 'remake',
						title : '备注'
					}]
				});
				
			}; //得到查询的参数

			oTableInit.queryParamsOne = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset, //页码 
					recordId:$("#recordIds").val(),
					recordName : $("#recordName").val(),
				};
				return temp;
			};
			
			oTableInit.queryParamsTwo = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset, //页码 
					recordId:$("#recordIds").val(),
					fileName : $("#fileName").val(),
					mnemonicCode : $("#mnemonicCode").val()
				};
				return temp;
			};
			//基础档案表查询点击事件
			$('#btn_query').click(function() {
				var opt = {
					url : "basisFiles/findAllBasisFiles",
					silent : true,
					query : {
						type : 1,
						level : 2,
						recordName : $('#recordName').val(),
						offset:0
					}
				};
				$('#tb_departments').bootstrapTable('refresh', opt);
			});
			//辅助档案表查询点击事件
			$("#btn_helpFiles").click(function(){
				var opt = {
						url : "basisFiles/findAllHelpFiles",
						silent : true,
						query : {
							type : 1,
							level : 2,
							fileName : $('#fileName').val(),
							mnemonicCode : $('#mnemonicCode').val(),
							offset:0
						}
					};
					$('#table_departments').bootstrapTable('refresh', opt);
					
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
					
				});
				//添加辅助档案
				$("#addHelpFiles").click(function(){
					$.post("basisFiles/findAllRecordName",function(response){
						var html="";
						for(var i =0;i<response.length;i++){
							if(i==0){
								html="<option selected id='"+response[i].recordId+"'>"+response[i].recordName+"</option>";
							}else{
								html=html+"<option id='"+response[i].recordId+"'>"+response[i].recordName+"</option>";
							}
						}
						$("#file_recordId").html('').append(html);
					});
					$("#myModalAdd").modal("show");
				});
				//辅助档案添加的提交按钮点击事件
				$("#myModalAddSub").click(function(){
					  var recordId= $('#file_recordId').find('option:selected').attr('id');
					  var recordName = $('#file_recordId').val();
					  var fileName = $('#file_fileName').val();
		         	  var isUse = $('#file_isUse').val();
		         	  var mnemonicCode = $('#file_mnemonicCode').val();
		         	  var remake = $('#file_remake').val();
		         	 $('#addHelpFilesForm').data('bootstrapValidator').validate();
						if ($('#addHelpFilesForm').data('bootstrapValidator').isValid()) {
							  $.ajax({
				         		  type:"post",
				         		 url:"basisFiles/addHelpFiles",
				         		data:{
				         			"fileName":fileName,
				         			"recordId":recordId,
				         			"recordName":recordName,
									"mnemonicCode":mnemonicCode,
									"isUse":isUse,
									"remake":remake
								},
				         		traditional: true,//这里设置为true
								success:function(result){
									if(result.status=="success"){
										toastr.success("添加成功");
										$('#addHelpFilesForm')[0].reset();
										$('#table_departments').bootstrapTable('refresh');
										$('#myModalAdd').modal('hide')
									}else if(result.status == "fileName"){
										toastr.error("添加失败,原因:基础档案名称相同");
									}else{
										toastr.error("添加失败");
										$('#table_departments').bootstrapTable('refresh');
										$('#myModalAdd').modal('hide')
									}
								}
				         	  });
				         	  
						}else{
							toastr.error("校验失败");
						}
		         	
		         	  
				});
				
				//基础档案修改
				$("#btn_edit").click(//基础档案修改开始
						function() {
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请选择一行");
							}else if(select.length>1){
								toastr.warning("不能同时修改多行");
							}else{
								$('#myModalEd').modal('show')
								var obj= select[0];
								var recordId =obj.recordId;
								var recordName = obj.recordName;
								var remarlk = obj.remarlk;
								
								$("#edit_recordName").val(recordName);
								$("#edit_remarlk").val(remarlk);
								//修改
								$("#editSub").click(function(){
									var recordName = $("#edit_recordName").val();
									var remarlk = $("#edit_remarlk").val();
									 $('#updateBasis').data('bootstrapValidator').validate();
										if ($('#updateBasis').data('bootstrapValidator').isValid()) {
											$.ajax({
												url:"basisFiles/updateBasisFiles",
												type:"post",
												data:{"recordId":recordId,
													  "recordName":recordName,
													  "remarlk":remarlk
													
												},
												traditional: true,//这里设置为true
												success:function(result){
													if(result.status=="success"){
														toastr.success("修改成功");
														$('#tb_departments').bootstrapTable('refresh');
														$('#myModalEd').modal('hide')
													}else if(result.status=="recordName"){
														toastr.error("修改失败,原因:基础档案名相同");
													}else{
														toastr.error("修改失败");
														$('#myModalEd').modal('hide')
													}
												}
											});
										}else{
											toastr.warning("基础档案名不能为空");
										}
									
										
								}); 
								
							}

						});//基础档案修改结束
						
				//修改辅助档案表的点击事件
				$("#btn_edit_helpFile").click(function(){//修改的点击事件开始
					var select = $('#table_departments').bootstrapTable(
					'getSelections');
					if (select.length === 0) {
						toastr.warning("请选择一行");
					}else if(select.length>1){
						toastr.warning("不能同时修改多行");
					}else{
						$("#myModalEdHelpFile").modal('show');
						var obj= select[0];
						var fileId =obj.fileId;
						var fileName = obj.fileName;
						var mnemonicCode = obj.mnemonicCode;
						var remake = obj.remake;
						$("#edit_fileName").val(fileName);
						$("#edit_mnemonicCode").val(mnemonicCode);
						$("#edit_remake").val(remake);
						
						$("#editSubHelpFiles").click(function(){
							var fileName = $("#edit_fileName").val();
							var mnemonicCode = $("#edit_mnemonicCode").val();
							var remake = $("#edit_remake").val();
							 $('#updateFile').data('bootstrapValidator').validate();
								if ($('#updateFile').data('bootstrapValidator').isValid()) {
									$.ajax({
										url:"basisFiles/updateHelpFiles",
										type:"post",
										data:{"fileId":fileId,
											  "fileName":fileName,
											  "mnemonicCode":mnemonicCode,
											  "remake":remake,
											
										},
										traditional: true,//这里设置为true
										success:function(result){
											if(result.status=="success"){
												toastr.success("修改成功");
												$('#table_departments').bootstrapTable('refresh');
												$('#myModalEdHelpFile').modal('hide')
											}else if(result.status=="fileName"){
												toastr.error("修改失败,原因:基础档案名相同");
											}else{
												toastr.error("修改失败");
												$('#myModalEdHelpFile').modal('hide')
											}
										}
									});
								}else{
									toastr.warning("辅助档案名不能为空");
								}
							
						});
					}
					
				});//修改的点击事件结束
						
				//============================================
				//删除基础档案
				$("#btn_delete").click(//删除开始
						function() {
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请至少选择一行");
							} else {
								 layer.msg('确定删除?',{
									time:0,//不自动关闭
									btn:['确认','取消'],
									yes:function(index){
										layer.close(index);
										var arrs = [];
										for (var i = 0; i < select.length; i++) {
											arrs[i] = select[i]['recordId'];
										}

										$('#tb_departments').bootstrapTable('remove', {
											field : 'recordId',
											values : arrs
										}); 

										$.ajax({
											url : "basisFiles/deleteBasisFiles",
											type : "post",
											data :"recordIds="+arrs+"",
											traditional : true,//这里设置为true;
											success : function(result) {
												if (result == "success") {
													toastr.success("删除成功");
													var url={
															url:'basisFiles/findAllBasisFiles'
													};
													$('#tb_departments')
													.bootstrapTable('refresh',url);
													$('#table_departments')
													.bootstrapTable('refresh');
												} else {
													$('#tb_departments').bootstrapTable('refresh');
													toastr.error("删除失败");
												}
											}
										});
									}
								}); 
								

							}

						});//删除结束
						
						//辅助档案表删除开始
						$("#btn_delete_helpFile").click(function(){
							var select = $('#table_departments').bootstrapTable(
							'getSelections');
							if (select.length === 0) {
								toastr.warning("请至少选择一行");
							} else {
								layer.msg('确定删除?',{
									time:0,//不自动关闭
									btn:['确认','取消'],
									yes:function(index){
										layer.close(index);
										var arrs = [];
										for (var i = 0; i < select.length; i++) {
											arrs[i] = select[i]['fileId'];
										}
										$('#table_departments').bootstrapTable('remove', {
											field : 'fileId',
											values : arrs
										}); 
										$.ajax({
											url : "basisFiles/deleteHelpFiles",
											type : "post",
											data :{fileIds:arrs},
											traditional : true,//这里设置为true;
											success : function(result) {
													if (result == "success") {
														toastr.success("删除成功");
													var url={
															url:'basisFiles/findAllHelpFiles'
													};
													$('#table_departments')
													.bootstrapTable('refresh',url);
												} else {
													$('#table_departments').bootstrapTable('refresh');
													toastr.error("删除失败");
												}
											}
										});
									}
								});
								
							}
						});
						//辅助档案表删除结束

			};
			return oInit;
		};
		//基础档案表添加的提交按钮
		$("#sub").click(function() {
			var obj = {
				recordName : $('#txt_recordName').val(),
				remarlk : $('#txt_remarlk').val()
			};
			cancel();
			//异步同步数据库
			$('#addSubForm').data('bootstrapValidator').validate();
			if ($('#addSubForm').data('bootstrapValidator').isValid()) {
				$.getJSON("basisFiles/addBasisFiles", obj, function(result) {
					if (result.status == "success") {
						$('#myModal').modal('hide')
						$('#tb_departments').bootstrapTable('refresh');
						toastr.success("添加成功");
						$('#addSubForm')[0].reset();
					}else if(result.status == "recordName"){
						toastr.error("添加失败,原因:基础档案名称相同");
					}else{
						toastr.error("添加失败");
						$('#myModal').modal('hide')
					}
				});
			} else {
				toastr.error("校验失败");
				
			}

		});
		
		
		$(function() {
			//1.初始化Table 
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件 
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();
		});
		function test() {
			var oldWidth = $('body').outerWidth();
			var marginLeft = (document.documentElement.clientWidth - $(
					".model-dialog").outerWidth()) / 2;
			var marginHeight = (document.documentElement.clientHeight - $(
					".model-dialog").outerHeight()) / 2;
			$('.model-dialog').css('margin-left', marginLeft);
			$('.model-dialog').css('margin-top', marginHeight);
			$('body').css('overflow', 'hidden');
			var newWidth = $('body').outerWidth();
			var scrollbarWidth = newWidth - oldWidth;
			$('body').css('padding-right', scrollbarWidth + 'px');
			$('.model').removeClass('hide');
			$('.model-dialog').removeClass('hide');
		}
		function cancel() {
			$('body').css('overflow', 'auto');
			$('body').css('padding-right', '0px');
			$('.model').addClass('hide');
			$('.model-dialog').addClass('hide');
		}
		function check() {
			//校验逻辑
			return false;
		}
		//基础档案表的添加的校验
		$('#addSubForm').bootstrapValidator({
            fields: {
            	recordName: {
                    message: '名字验证失败',
                    validators: {
                        notEmpty: {
                            message: '名字不能为空'
                        }
                    }
                }
            }
        });
		//基础档案表的修改的校验
		$('#updateBasis').bootstrapValidator({
            fields: {
            	recordName: {
                    message: '名字验证失败',
                    validators: {
                        notEmpty: {
                            message: '名字不能为空'
                        }
                    }
                }
            }
        });
	//=========================================================================================
		//辅助档案表的添加的校验
		$('#addHelpFilesForm').bootstrapValidator({
		fields: {
        	fileName: {
                message: '名字验证失败',
                validators: {
                    notEmpty: {
                        message: '名字不能为空'
                    }
                }
            },
            mnemonicCode: {
                validators: {
                	message: '助记码验证失败',
                    notEmpty: {
                        message: '助记码不能为空'
                    }
                    
                }
            }
            
        }
	});
	
		//辅助档案表的修改的校验
		$('#updateFile').bootstrapValidator({
            fields: {
            	fileName: {
                    message: '名字验证失败',
                    validators: {
                        notEmpty: {
                            message: '名字不能为空'
                        }
                    }
                }
            }
        });
	
	</script>

</body>
</html>