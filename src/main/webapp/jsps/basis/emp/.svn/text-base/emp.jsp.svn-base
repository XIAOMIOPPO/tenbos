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
<title>取派员设置</title>
<link rel="icon" type="image/x-icon" href="jsps/images/Logo.jpg">

<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/toastr/toastr.css" rel="stylesheet">



<script src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>


<style type="text/css">
body {
	font-size: 16px;
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

#empSercTab td {
	height: 75px;
	border: none;
}

.hide {
	display: none;
}

.state1 {
	color: #aaa;
}

.state2 {
	color: #000;
}

.state3 {
	color: red;
}

.state4 {
	color: green;
}
</style>

</head>
<body class='default'>
	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse"
				data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<table class="table table-hover" id="empSercTab">
					<tr>
						<td><input type="text" id="SempName" class="form-control"
							placeholder="职员名字"></td>
						<td><input type="text" id="SphoneNum" class="form-control"
							placeholder="手机号码"></td>
						<td><input type="text" id="SorgName" class="form-control"
							placeholder="所属部门"></td>
					</tr>

					<tr>
						<td><input type="text" id="SdeliverName" class="form-control"
							placeholder="收派类型"></td>
						<td><input type="text" id="StimeName" class="form-control"
							placeholder="收派时间"></td>
						<td><input type="text" id="SfileName" class="form-control"
							placeholder="档案明细"></td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<button type="button" id="findEmpByCar" class="btn btn-primary">查询</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	</div>
	<div id="toolbar" class="btn-group">
		<button class="btn btn-success" data-toggle="modal"
			data-target="#myModal" id="btn_add">
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


	<div class="model hide"></div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">添加职员</h4>
				</div>
				<div class="modal-body">
					<form action="emp/addEmp.action" method="post"
						class="form-horizontal" onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">名字</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="empName"
									placeholder="请输入名字" name="empName"> <span
									class='state1'></span>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">查台密码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="empPassword"
									placeholder="请输入查台密码" name="empPassword"> <span
									class='state1'></span>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">手机号码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="phoneNum"
									placeholder="请输入手机号码" name="phoneNum"> <span
									class='state1'></span>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">isPDA</label>
							<div class="col-sm-10">
								<select class="form-control" id="isPDA" name="isPDA">
									<option value="0">0</option>
									<option value="1">1</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">单位名称</label>
							<div class="col-sm-10">
								<select class="form-control" id="orgName" name="orgName">

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">收派标准</label>
							<div class="col-sm-10">
								<select class="form-control" id="deliverName" name="deliverName">

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">收派时间</label>
							<div class="col-sm-10">
								<select class="form-control" id="timeName" name="timeName">

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">档案明细</label>
							<div class="col-sm-10">
								<select class="form-control" id="fileName" name="fileName">

								</select>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal" onclick="cancel()">关闭</button>
							<button type="submit" id="sub" class="btn btn-primary" disabled>添加</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="updateEmpMode" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改职员信息</h4>
				</div>
				<div class="modal-body">
					<form action="emp/addEmp.action" method="post"
						class="form-horizontal" onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">ID</label>
							<div class="col-sm-10">
								<fieldset disabled>
									<input type="text" class="form-control" id="EempId"
										name="EempId">
								</fieldset>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">名字</label>
							<div class="col-sm-10">
								<fieldset disabled>
									<input type="text" class="form-control" id="EempName"
										name="EempName">
								</fieldset>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">编号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="EempNum"
									name="EempNum">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">查台密码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="EempPassword"
									name="EempPassword"> <span class='state1'></span>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">手机号码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="EphoneNum"
									name="EphoneNum"> <span class='state1'></span>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">isPDA</label>
							<div class="col-sm-10">
								<select class="form-control" id="EisPDA" name="EisPDA">
									<option value="0">0</option>
									<option value="1">1</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">单位名称</label>
							<div class="col-sm-10">
								<select class="form-control" id="EorgName" name="EorgName">

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">收派标准</label>
							<div class="col-sm-10">
								<select class="form-control" id="EdeliverName"
									name="EdeliverName">

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">收派时间</label>
							<div class="col-sm-10">
								<select class="form-control" id="EtimeName" name="EtimeName">

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">档案明细</label>
							<div class="col-sm-10">
								<select class="form-control" id="EfileName" name="EfileName">

								</select>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal" onclick="cancel()">关闭</button>
							<input type="button" id="editEmp" class="btn btn-primary"
								value="确认修改" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
			var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
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
					pageSize : 8, //每页的记录行数（*） 
					pageList : [ 8, 15, 30 ], //可供选择的每页的行数（*） 
					search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "empId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					fixedColumns: true,
					fixedNumber : 2,
					singleSelect : false, //设置单选  
					columns : [ {
						checkbox : true
					}, {
						field : 'empId',
						title : '职员Id'
					},  {
						field : 'empNum',
						title : '职员编号'
					},{
						field : 'empName',
						title : '姓名'
					}, {
						field : 'empPassword',
						title : '查台密码'
					}, {
						field : 'phoneNum',
						title : '手机号码'
					}, {
						field : 'isPDA',
						title : 'PDA',
						formatter:function (value){
							if(value =='1'){
								return '已配备';
							}else{
								return '未配备';
							}
						}
					}, {
						field : 'orgName',
						title : '公司名称'
					}, {
						field : 'deliverName',
						title : '收派标准'
					}, {
						field : 'timeName',
						title : '收派时间'
					}, {
						field : 'fileName',
						title : '收派类型'
					} ]
				
				
				});
				
			}; //得到查询的参数


			oTableInit.queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset, //页码 
					departmentname : $("#txt_search_departmentname").val(),
					statu : $("#txt_search_statu").val(),
					empName : $("#SempName").val(),
					phoneNum :$("#SphoneNum").val(),
					orgName :$("#SorgName").val(),
					deliverName :$("#SdeliverName").val(),
					timeName :$("#StimeName").val(),
					fileName :$("#SfileName").val()

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
				$("#btn_add").click(function() {
					$.ajax({
						url:"emp/findDeliverName.action",
						type:"post",
						async:true,
						traditional: true,
						success:function(response) {
							var html=$('#deliverName');
							for(var i=0;i<response.length;i++){
									item=$("<option></option>");
									item.append(response[i]);
									item.attr("value",response[i]);
									html.append(item);
							}
							
						}
					})
					
					$.ajax({
						url:"emp/findDrawTimeName.action",
						type:"post",
						async:true,
						traditional: true,
						success:function(response) {
							var html=$('#timeName');
							for(var i=0;i<response.length;i++){
									item=$("<option></option>");
									item.append(response[i]);
									item.attr("value",response[i]);
									html.append(item);
							}
							
						}
					})
					
					$.ajax({
						url:"emp/findOrgName.action",
						type:"post",
						async:true,
						traditional: true,
						success:function(response) {
							var html=$('#orgName');
							for(var i=0;i<response.length;i++){
									item=$("<option></option>");
									item.append(response[i]);
									item.attr("value",response[i]);
									html.append(item);
							}
							
						}
					})
					
					$.ajax({
						url:"emp/findFileName.action",
						type:"post",
						async:true,
						traditional: true,
						success:function(response) {
							var html=$('#fileName');
							for(var i=0;i<response.length;i++){
									item=$("<option></option>");
									item.append(response[i]);
									item.attr("value",response[i]);
									html.append(item);
							}
							
						}
					})
					test();

				});
				



				$("#btn_edit").click(
						function() {

							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请至少选择一行");
							} else if(select.length>1){
								toastr.warning("一次只能选择一行");
							}else {							
								$("#EempId").val(select[0].empId);
								$("#EempName").val(select[0].empName);
								$("#EempPassword").val(select[0].empPassword);
								$('#EempNum').val(select[0].empNum);
								$("#EphoneNum").val(select[0].phoneNum);
								$("#EisPDA").val(select[0].isPDA);
								$("#EorgName").val(select[0].orgName);
								$("#EdeliverName").val(select[0].deliverName);
								$("#EtimeName").val(select[0].timeName);
								$("#EfileName").val(select[0].fileName);
								$.ajax({
									url:"emp/findDeliverName.action",
									type:"post",
									async:true,
									traditional: true,
									success:function(response) {
										var html=$('#EdeliverName');
										for(var i=0;i<response.length;i++){
												item=$("<option></option>");
												item.append(response[i]);
												item.attr("value",response[i]);
												html.append(item);
										}
										
									}
								})
								
								$.ajax({
									url:"emp/findDrawTimeName.action",
									type:"post",
									async:true,
									traditional: true,
									success:function(response) {
										var html=$('#EtimeName');
										for(var i=0;i<response.length;i++){
												item=$("<option></option>");
												item.append(response[i]);
												item.attr("value",response[i]);
												html.append(item);
										}
										
									}
								})
								
								$.ajax({
									url:"emp/findOrgName.action",
									type:"post",
									async:true,
									traditional: true,
									success:function(response) {
										var html=$('#EorgName');
										for(var i=0;i<response.length;i++){
												item=$("<option></option>");
												item.append(response[i]);
												item.attr("value",response[i]);
												html.append(item);
										}
										
									}
								})
								
								$.ajax({
									url:"emp/findFileName.action",
									type:"post",
									async:true,
									traditional: true,
									success:function(response) {
										var html=$('#EfileName');
										for(var i=0;i<response.length;i++){
												item=$("<option></option>");
												item.append(response[i]);
												item.attr("value",response[i]);
												html.append(item);
										}
									}
								})								
								$("#updateEmpMode").modal({show:true});
							}

				});
				
				$("#editEmp").click(function(){
					var empId = $("#EempId").val();
					var empPassword = $("#EempPassword").val();
					var phoneNum = $("#EphoneNum").val();
					var empNum = $("#EempNum").val();
					var isPDA = $("#EisPDA").val();
					var orgName = $("#EorgName").val();
					var deliverName = $("#EdeliverName").val();
					var timeName = $("#EtimeName").val();
					var fileName = $("#EfileName").val();
					$.ajax({
						url : "emp/updateEmp.action",
						type : "post",
						data : {
							"empNum":empNum,
							"empPassword" : empPassword,
							"phoneNum" : phoneNum,
							"isPDA" : isPDA,
							"orgName" : orgName,
							"deliverName" : deliverName,
							"empPassword" : empPassword,
							"timeName" : timeName,
							"fileName" : fileName,
							"empId":empId
						},
						traditional : true,//这里设置为true
						success : function(result) {
						$("#updateEmpMode").modal('hide');
							if (result == "success") {
								toastr.success("修改成功");
								var url = {
									url : 'emp/findAllEmp.action'
								};
								$('#tb_departments')
										.bootstrapTable('refresh',
												url);
							} else {
								toastr.error("修改失败");
							}
						}
					})
					
				});

				$("#btn_delete").click(
						function() {
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请至少选择一行");
							}else {
								var arrs = [];
								for (var i = 0; i < select.length; i++) {
									arrs[i] = select[i]['empId'];
								}
								$('#tb_departments').bootstrapTable('remove', {
									field : 'empId',
									values : arrs
								});

								$.ajax({
									url : "emp/deleteEmp.action",
									type : "post",
									data : {
										"empId" : arrs
									},
									traditional : true,//这里设置为true
									success : function(result) {
										if (result == "success") {
											toastr.success("删除成功");
											var url = {
												url : 'emp/findAllEmp.action'
											};
											$('#tb_departments')
													.bootstrapTable('refresh',
															url);
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

		$("#sub").click(function() {
			cancel();
			$('#myModal').modal('hide')
			//异步同步数据库
			$.getJSON("add", obj, function(result) {
				if (result.status == "success") {
					toastr.success("添加成功"); 
				} else {
					toastr.error("添加失败");  
				}
			});

		});
		$(function() {
			//1.初始化Table 
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件 
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();

			$('#findEmpByCar').click(function() {
				$('#tb_departments').bootstrapTable("refresh", {
					url : "emp/findEmpByConditionVague.action",
					silent : true,
					queryParams : oTable.queryParams
				});
			});

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
			return true;
		}
	</script>



	<script>
      $(function(){
    	  
    	  var MyValidator = function() { 
    		  $('.form-horizontal').validate({
    	            errorElement : 'span',  
    	            errorClass : 'help-block',  
    	            focusInvalid : false,  
    	            rules : { 
    	            	empName : {  
    	                    required : true  
    	                },  
    	                empPassword : {  
    	                    required : true  
    	                },  
    	                phoneNum : {  
    	                    required : true  
    	                }  
    	            },
    	            messages : {  
    	            	empName : {  
    	                    required : "姓名不能为空"  
    	                },  
    	                empPassword : {  
    	                    required : "密码不能为空"  
    	                },  
    	                phoneNum : {  
    	                    required : "手机号码不能为空"  
    	                } 
    	            },
    	            highlight : function(element) {  
    	                $(element).closest('.form-group').addClass('has-error');  
    	            }, 
    	            success : function(label) {  
    	                label.closest('.form-group').removeClass('has-error');  
    	                label.remove();  
    	            },  
    	  
    	            errorPlacement : function(error, element) {  
    	                element.parent('div').append(error);  
    	            },  
    	  
    	            submitHandler : function(form) {  
    	                form.submit();  
    	            } 
    		  });  
    	  }
    	 
        // 验证用户名
        $('input[name="empName"]').focus(function(){
          $(this).next().text('用户名应该为2-8位之间').removeClass('state1').addClass('state2');
          $('#sub').prop("disabled",true);
        }).blur(function(){
          if($(this).val().length >= 2 && $(this).val().length <=12 && $(this).val()!=''){
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            $('#sub').prop("disabled",false);
          }else{
            $(this).next().text('用户名应该为3-8位之间').removeClass('state1').addClass('state3');
            $('#sub').prop("disabled",true);
          }
            
        });
  
        //验证密码
        $('input[name="empPassword"]').focus(function(){
          $(this).next().text('密码应该为6-20位之间').removeClass('state1').addClass('state2');
          $('#sub').prop("disabled",true);
        }).blur(function(){
          if($(this).val().length >= 6 && $(this).val().length <=20 && $(this).val()!=''){
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            $('#sub').prop("disabled",false);
          }else{
            $(this).next().text('密码应该为6-20位之间').removeClass('state1').addClass('state3');
            $('#sub').prop("disabled",true);
          }
            
        });
  
        //验证手机
        $('input[name="phoneNum"]').focus(function(){
          $(this).next().text('请输入正确的手机号码格式').removeClass('state1').addClass('state2');
          $('#sub').prop("disabled",true);
        }).blur(function(){
          if($(this).val().search(/^1\d{10}$/)==-1){
            $(this).next().text('请输入正确的手机号码格式').removeClass('state1').addClass('state3');
            $('#sub').prop("disabled",true);
          }else{         
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            $('#sub').prop("disabled",false);
          }
            
        });  
        
        
      //修改职员信息验证  

        //验证密码
        $('#EempPassword').focus(function(){
          $(this).next().text('密码应该为6-20位之间').removeClass('state1').addClass('state2');
          $('#editEmp').prop("disabled",true);
        }).blur(function(){
          if($(this).val().length >= 6 && $(this).val().length <=20 && $(this).val()!=''){
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            $('#editEmp').prop("disabled",false);
          }else{
            $(this).next().text('密码应该为6-20位之间').removeClass('state1').addClass('state3');
            $('#editEmp').prop("disabled",true);
          }
            
        });
  
        //验证手机
        $('#EphoneNum').focus(function(){
          $(this).next().text('请输入正确的手机号码格式').removeClass('state1').addClass('state2');
          $('#editEmp').prop("disabled",true);
        }).blur(function(){
          if($(this).val().search(/^1\d{10}$/)==-1){
            $(this).next().text('请输入正确的手机号码格式').removeClass('state1').addClass('state3');
            $('#editEmp').prop("disabled",true);
          }else{         
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            $('#editEmp').prop("disabled",false);
          }
            
        });  
     });
</script>

</body>
</html>