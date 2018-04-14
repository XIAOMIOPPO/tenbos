<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收派标准管理</title>

<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"rel="stylesheet">
<link href = "${pageContext.request.contextPath}/static/toastr/toastr.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/static/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/static/toastr/toastr.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src = "${pageContext.request.contextPath}/static/layer/layer.js"></script>

<style type="text/css">
	.prompt{
		color:red;
	}
</style>
</head>
<body>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="home">
			<div class="panel-body" style="padding-bottom: 0px;">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="#collapseOne" data-toggle="collapse"
							data-parent="#accordion">查询条件</a>
					</div>
					<div class="panel-body" id="collapseOne">
						<shiro:hasPermission name="SPBZ:CRITERDC">
							<form id="formSearch" cl ass="form-horizontal" method="post">
								<div class="form-group" style="margin-top: 15px">
									<div class="col-sm-3">
										<input type="text" class="form-control" id="deliverName"
											name="deliverName" placeholder="请输入要查询的收派标准名">
									</div>
	
									<div class="col-sm-3">
										<input type="text" class="form-control" id="minWeight"
											name="minWeight" placeholder="请输入小于最大重量的数字">
									</div>
	
	
									<div class="col-sm-3">
										<input type="text" class="form-control" id="maxWeight"
											name="maxWeight" placeholder="请输入大于最小重量的数字">
									</div>
	
									<br /> 
									<br />
									
									<div class="col-sm-3">
										<input type="text" class="form-control" id="minLength"
											name="minLength" placeholder="请输入小于最大长度的数字">
									</div>
	
									<div class="col-sm-3">
										<input type="text" class="form-control" id="maxLength"
											name="maxLength" placeholder="请输入大于最小长度的数字">
									</div>
	
									<label></label>
	
									<div class="col-sm-4" style="text-align: center;">
											<button type="button" style="margin-left: 50px" id="btn_query"
												class="btn btn-primary">查询
											</button>
									</div>
								</div>
							</form>
						</shiro:hasPermission>
					</div>
				</div>
				<div id="toolbar" class="btn-group">
						<button class="btn btn-success" data-toggle="modal"
							data-target="#myModal">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
						</button>
						<button id="btn_edit" type="button" class="btn btn-info">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
						</button>
						<shiro:hasPermission name="SPBZ:DELETECDC">
							<button id="btn_delete" type="button" class="btn btn-danger">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
							</button>
						</shiro:hasPermission>
				</div>
				<table id="tb_departments"></table>
			</div>

			<div class="model hide"></div>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">添加收派标准</h4>
						</div>
						<div class="modal-body">
							<form class="form-horizontal" onsubmit="return check()"
								role="form" id = "addValidator">
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">收派名称</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="txt_deliverName"
												onblur="checkDeliverName(this)" name="deliverName"disabled>
										</div>
								</div>
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">最小重量</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="txt_minWeight"
											onblur="checkMinWeight(this)" onfocus="cancelPrompt(this)"
											name="minWeight" class="input"
											placeholder="单位:千克(Kg)" /> <span
											id="txt_minWeight_prompt" class="prompt"></span>
									</div>
								</div>
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label"> 最大重量</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="txt_maxWeight"
											onblur="checkMaxWeight(this)" onfocus="cancelPrompt(this)"
											name="maxWeight" class="input"  placeholder="单位:千克(Kg)"/> <span
											id="txt_maxWeight_prompt" class="prompt"></span>
									</div>
								</div>
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">最小长度</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="txt_minLength"
											onblur="checkMinLength(this)" onfocus="cancelPrompt(this)"
											name="minLength" class="input" placeholder="单位:厘米(cm)"/> <span
											id="txt_minLength_prompt" class="prompt"></span>
									</div>
								</div>
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">最大长度</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="txt_maxLength"
											onblur="checkMaxLength(this)" onfocus="cancelPrompt(this)"
											name="maxLength" class="input" placeholder="单位:厘米(cm)" /> <span
											id="txt_maxLength_prompt" class="prompt"></span>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"data-dismiss="modal" onclick="cancel()">关闭</button>
							<shiro:hasPermission name="SPBZ:ADDCDC">
								<button type="button" id="sub" class="btn btn-primary" disabled>提交更改</button>
							</shiro:hasPermission>
						</div>
					</div>
				</div>
			</div>

			<!-- 修改 -->
			<div class="model hide"></div>
			<div class="modal fade" id="myUpdate" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">修改</h4>
						</div>
						<div class="modal-body">
							<form class="form-horizontal" onsubmit="return check()"
								role="form">
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">是否禁用</label>
									<div class="col-sm-10">
										<select class="form-control" name="isUse" id= "isUse">
											<option value="0">是</option>
											<option value="1">否</option>
										</select>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal" onclick="cancel()">关闭</button>
							<shiro:hasPermission name="SPBZ:UPDATECDC">
								<button type="button" id="update" class="btn btn-primary">提交更改</button>
							</shiro:hasPermission>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$('#collapseOne').collapse({
			parent : '#accordion',
			toggle : true,
		});
		//---------------------------------------------------------------------------------------------
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments')
						.bootstrapTable(
								{
									url : 'deliverCriterion/findAllDeliverCriterionPageQuery.action', //请求后台的URL（*） 
									method : 'post', //请求方式（*） 
									toolbar : '#toolbar', //工具按钮用哪个容器 
									striped : true, //是否显示行间隔色 
									cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
									pagination : true, //是否显示分页（*） 
									sortable : true, //是否启用排序 
									sortOrder : "asc", //排序方式
									queryParamType : oTableInit.queryParams,//传递参数（*） 
									sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
									pageNumber : 1, //初始化加载第一页，默认第一页 
									pageSize : 5, //每页的记录行数（*） 
									pageList : [ 10, 20, 50 ], //可供选择的每页的行数（*） 
									search : true, //是否显示表格搜索，此搜索客户端搜索，不会进服务端，所以，个人感觉意义不大 
									strictSearch : true,
									showColumns : true, //是否显示所有的列 
									showRefresh : true, //是否显示刷新按钮
									minimumCountColumns : 2, //最少允许的列数
									clickToSelect : true, //是否启用点击选中行 
									uniqueId : "deliverId", //每一行的唯一标识，一般为主键列 
									showToggle : true, //是否显示详细视图和列表视图的切换按钮 
									cardView : false, //是否显示详细视图
									detailView : false, //是否显示父子表
									columns : [ {
										checkbox : true
									}, {
										field : 'deliverName',
										title : '收派标准名 '
									}, {
										field : 'minWeight',
										title : '最小重量 '
									}, {
										field : 'maxWeight',
										title : '最大重量 '
									}, {
										field : 'minLength',
										title : '最小长度 '
									}, {
										field : 'maxLength',
										title : '最大长度 '
									}, {
										field : 'isUse',
										title : '是否作废',
										formatter:function(data){
											if(data=='0'){
												return '是';
											}else{
												return '否';
											}
										}
									} ]
								});
			};

			//得到查询的参数
			oTableInit.queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset, //页码 
					deliverName : $('#deliverName').val(),
					minWeight : $('#minWeight').val(),
					maxWeight : $('#maxWeight').val(),
					minLength : $('#minLength').val(),
					maxLength : $('#maxLength').val()
				};
				return temp;
			};

			return oTableInit;
		};
		//--------------------------------------------------------------------------------
		//------------------ButtonInit  start----------------------------------------------------------
		var ButtonInit = function() {
			var oInit = new Object();
			var postdata = {};
			oInit.Init = function() {
				//初始化页面上面的按钮事件 
				$("#btn_add").click(function() {
					test();
				});
				
				//模糊查询
				$('#btn_query').click(function() {
					var opt = {
						url : "deliverCriterion/criterDeliverCriterion.action",
						silent : true,
						query : {
							type : 1,
							level : 2,
							
							deliverName : $('#deliverName').val(),
							minWeight : $('#minWeight').val(),
							maxWeight : $('#maxWeight').val(),
							minLength : $('#minLength').val(),
							maxLength : $('#maxLength').val()
						}
					};
					$('#tb_departments').bootstrapTable('refresh', opt);
				});

				//修改
				$("#btn_edit").click(function() {
					var select = $('#tb_departments').bootstrapTable('getSelections');
						if (select.length === 0) {
							toastr.warning("请选择一行");
						} else if(select.length>1){
							toastr.warning("不能同时修改多行");
						}else {
							$('#myUpdate').modal('show');
							var obj = select[0];
							var deliverId = obj.deliverId;
							var isUse = obj.isUse;
							$("#isUse").val(isUse);
								
							$("#update").click(function(){
								var isUse = $("#isUse").val();
								$.ajax({
									url:"deliverCriterion/updateIsUseById.action",
									type:"post",
									data:{
										"deliverId":deliverId,
										"isUse":isUse
									},	
									traditional:true,
									success:function(result){
										if(result == "success"){
											toastr.success("修改成功");
											$('#myUpdate').modal('hide');
											$('#tb_departments').bootstrapTable('refresh');
										}else{
											toastr.error("修改失败");
											$('#myUpdate').modal('hide');
										}
									}
								});
							});
								
							}
				});
				
				
				
				//添加
				$("#sub").click(function() {
					var obj = {
						deliverName : $('#txt_deliverName').val(),
						minWeight : $('#txt_minWeight').val(),
						maxWeight : $('#txt_maxWeight').val(),
						minLength : $('#txt_minLength').val(),
						maxLength : $('#txt_maxLength').val(),
					};
						//异步同步数据库
						$.getJSON("deliverCriterion/addDeliverCriterion.action",obj,function(result) {
								if (result.status == "success") {
										toastr.success("添加成功");
										$('#myModal').modal('hide');
										$('#tb_departments').bootstrapTable('refresh');
								} else if(result.status == "Name"){
									toastr.error("添加失败，原因：收派标准名重复");
								}else {
									toastr.error("添加失败");
								}
							});
					
										
					}); 


				//删除
				$("#btn_delete").click(function() {
					var select = $('#tb_departments').bootstrapTable('getSelections');
						if (select.length === 0) {
							toastr.warning("请选择一行");
						} else {
							layer.msg('确认删除？',{
								time:0,//不自动删除
								btn:['确认','取消'],
								yes:function(index){
									layer.close(index);
									var arrs = [];
									for (var i = 0; i < select.length; i++) {
										arrs[i] = select[i]['deliverId'];
										alert(arrs);
									}

									$('#tb_departments').bootstrapTable('remove', {
										field : 'deliverId',
										values : arrs
									});

									$.ajax({
										url:"deliverCriterion/deleteDeliverCriterion.action",
										type:"post",
										data:{deliverIds:arrs},
										traditional:true,
										success:function(result){
											if(result == "success"){
												toastr.success("删除成功");
												var url={url:'deliverCriterion/findAllDeliverCriterionPageQuery.action'};
												$('#tb_departments').bootstrapTable('refresh',url);
											}else{
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

		//--------------------------------------------------------------------------------
		$(function() {
			//1.初始化Table 
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件 
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();
			
			$("#txt_maxWeight").change(function(){
				var maxWeight = $(this).val();
				var minWeight = $("#txt_minWeight").val();
				if(minWeight>=maxWeight){
					$("#sub").prop("disabled",true);
					toastr.warning("最小重量不能大于最大重量");
				}
			});
			
			$("#txt_maxLength").change(function(){
				var maxWeight = $(this).val();
				var minWeight = $("#txt_minLength").val();
				if(minWeight>=maxWeight){
					$("#sub").prop("disabled",true);
					toastr.warning("最小长度不能大于最大长度");
				}
			});
		});

		//----------------------------------------------------------------------------------
		function test() {
			var oldWidth = $('body').outerWidth();
			var marginLeft = (document.documentElement.clientWidth - $(".model-dialog").outerWidth()) / 2;
			var marginHeight = (document.documentElement.clientHeight - $(".model-dialog").outerHeight()) / 2;
			$('.model-dialog').css('margin-left', marginLeft);
			$('.model-dialog').css('margin-top', marginHeight);
			$('body').css('overflow', 'hidden');
			var newWidth = $('body').outerWidth();
			var scrollbarWidth = newWidth - oldWidth;
			$('body').css('padding-right', scrollbarWidth + 'px');
			$('.model').removeClass('hide');
			$('.model-dialog').removeClass('hide');
		}

		//---------------------------------------------------------------------------------------
		function cancel() {
			$('body').css('overflow', 'auto');
			$('body').css('padding-right', '0px');
			$('.model').addClass('hide');
			$('.model-dialog').addClass('hide');
		}

		//--------------------------------------------------------------------------------------
		function check() {
			//校验逻辑
			return false;
		}

		//数据校验
		//根据最小重量和最大重量自动生成收派标准名 
		$("#sub").click(function(){
			var minWeight = $("#txt_minWeight").val();
			var maxWeight = $("#txt_maxWeight").val();
			$("#txt_deliverName").attr("value",minWeight+"~"+maxWeight);
			
		});
		
		//校验最小重量
		var checkMinWeight = function(obj) {
			//校验不能为负
			var temp=/^\d+(\.\d+)?$/;
			if(temp.test(obj.value)==false){
				 document.getElementById(obj.id + "_prompt").innerText = "不能为负";
			}
			//校验是否为空
			if (obj.value == null || obj.value.length == 0|| obj.value.trim().length == 0) {
				document.getElementById(obj.id + "_prompt").innerText = "最小重量不能为空";
				$("#sub").prop("disabled",true);
				return false;
			}
			
			//校验是否是数字
			if(isNaN(obj.value)){
				document.getElementById(obj.id + "_prompt").innerText = "请输入数字";
				$("#sub").attr("disabled",true);
				return false;
			} 	
			
			//校验长度
			if (obj.value < 0.01 || obj.value > 999) {
				document.getElementById(obj.id + "_prompt").innerText = "输入的值过大或过小";
				$("#sub").prop("disabled",true);
				return false;
				
			}
		}
		
	
		//-------------------------------------------------------------------------------------

		//校验最大重量
		var checkMaxWeight = function(obj) {
			//校验不能为负
			var temp=/^\d+(\.\d+)?$/;
			if(temp.test(obj.value)==false){
				 document.getElementById(obj.id + "_prompt").innerText = "不能为负";
			}
			
			//检验是否为空
			if (obj.value == null || obj.value.length == 0
					|| obj.value.trim().length == 0) {
				document.getElementById(obj.id + "_prompt").innerText = "最大重量不能为空";
				$("#sub").prop("disabled",true);
				return false;
			}
			
			//校验是否是数字
			if(isNaN(obj.value)){
				document.getElementById(obj.id + "_prompt").innerText = "请输入数字";
				$("#sub").prop("disabled",true);
				return false;
			} 	
			
			//校验长度
			if (obj.value<0.01 || obj.value> 9999999) {
				document.getElementById(obj.id + "_prompt").innerText = "输入的值过大或过小";
				$("#sub").prop("disabled",true);
				return false;
			}
			

			$('#txt_maxWeight').change(function(){
				var maxWeight =$(this).val();
				var minWeight= $('#txt_minWeight').val();
				if(minWeight>maxWeight){
					$("#sub").prop("disabled",true);
					toastr.warning("最小重量不能大于最大重量");
				}
			});
			
		}

		//----------------------------------------------------------------------------------------

		//校验最小长度
		var checkMinLength = function(obj) {
			//校验不能为负
			var temp=/^\d+(\.\d+)?$/;
			if(temp.test(obj.value)==false){
				 document.getElementById(obj.id + "_prompt").innerText = "不能为负";
			}
			
			//检验是否为空
			if (obj.value == null || obj.value.length == 0
					|| obj.value.trim().length == 0) {
				document.getElementById(obj.id + "_prompt").innerText = "最小长度不能为空";
				$("#sub").prop("disabled",true);
				return false;
			}

			//校验是否是数字
			if(isNaN(obj.value)){
				document.getElementById(obj.id + "_prompt").innerText = "请输入数字";
				$("#sub").prop("disabled",true);
				return false;
			} 	 
			
			//校验长度
			if (obj.value<0.01 || obj.value > 999) {
				document.getElementById(obj.id + "_prompt").innerText = "输入的值过大或过小";
				$("#sub").prop("disabled",true);
				return false;
			}
			
		}

		//-------------------------------------------------------------------------------------------

		//校验最大长度
		var checkMaxLength = function(obj) {
			//校验不能为负
			var temp=/^\d+(\.\d+)?$/;
			if(temp.test(obj.value)==false){
				 document.getElementById(obj.id + "_prompt").innerText = "不能为负";
			}
			
			//检验是否为空
			if (obj.value == null || obj.value.length == 0
					|| obj.value.trim().length == 0) {
				document.getElementById(obj.id + "_prompt").innerText = "最大长度不能为空";
				$("#sub").prop("disabled",true);
				return false;
			}

			//校验是否是数字
			if(isNaN(obj.value)){
				document.getElementById(obj.id + "_prompt").innerText = "请输入数字";
				$("#sub").prop("disabled",true);
				return false;
			} 	 
			
			//校验长度
			if (obj.value< 0.01 || obj.value > 9999999 ) {
				document.getElementById(obj.id + "_prompt").innerText = "输入的值过大或过小";
				$("#sub").prop("disabled",true);
				return false;
			}
			
			$('#txt_maxLength').change(function(){
				var maxWeight =$(this).val();
				var minWeight= $('#txt_minLength').val();
				if(minWeight>maxWeight){
					$("#sub").prop("disabled",true);
					toastr.warning("最小长度不能大于最大长度");
				}
			});
			
			
			
			$("#sub").prop("disabled",false);
			return true;
			
		}

		//--------------------------------------------------------------------------------------------

		//清除错误提示
		var cancelPrompt = function(obj) {
			document.getElementById(obj.id + "_prompt").innerText = "";
		};

		//--------------------------------------------------------------------------------------------

		var check = function(obj) {
			//校验最小重量
			if (!checkMinWeight(document.getElementById("txt_minWeight"))) {
				return false;
			}
			//校验最大重量
			if (!checkMaxWeight(document.getElementById("txt_maxWeight"))) {
				return false;
			}
			//校验最小长度
			if (!checkMinLength(document.getElementById("txt_minLength"))) {
				return false;
			}
			//校验最大重量
			if (!checkMaxLength(document.getElementById("txt_maxLength"))) {
				return false;
			}

		}
		
		
		//---------------------------------------------------------------------------
	</script>
</body>
</html>