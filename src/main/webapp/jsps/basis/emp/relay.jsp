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
<title>替班情况</title>
<link rel="icon" type="image/x-icon" href="jsps/images/Logo.jpg">

<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">

<link href="static/toastr/toastr.css" rel="stylesheet">

<script src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>

<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>
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

.hide {
	display: none;
}
</style>
</head>

<body>
	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne1"> 查询条件 </a>
				</h4>
			</div>
			<div id="collapseOne1" class="panel-collapse collapse in">
				<div class="panel-body">
					<table class="table">
						<tr>
							<td><input type="text" id="RelayEmpName"
								class="form-control" placeholder="替班员工名字"></td>
							<td><input type="text" placeholder="替班开始时间"
								class="form-control" name="sRstartTime" id="sRstartTime"
								data-date-format="yyyy-mm-dd hh:mm:ss" readonly></td>
							<td><input type="text" placeholder="替班结束时间"
								class="form-control" name="sRendTime" id="sRendTime"
								data-date-format="yyyy-mm-dd hh:mm:ss" readonly></td>
							<td colspan="5" align="center">
								<button type="button" id="findRelayByCar"
									class="btn btn-primary">查询</button>
							</td>
						</tr>
						<tr>

						</tr>
					</table>
				</div>
			</div>

			<div>
				<div id="toolbar" class="btn-group">
					<button id="btn_add_relay" class="btn btn-success"
						data-toggle="modal" data-target="#myModal1">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
					</button>
					<button id="btn_relay-edit" type="button" class="btn btn-info">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
					</button>
					<button id="btn_relay-delete" type="button" class="btn btn-danger">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
					</button>
				</div>
				<table id="tb_relay"></table>
			</div>
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">添加替班信息</h4>
						</div>
						<div class="modal-body">
							<form action="relay/addRelay.action" method="post"
								class="form-horizontal" onsubmit="return check()" role="form">
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">替班姓名</label>
									<div class="col-sm-10">
										<select class="form-control" id="replaceName" class="empNames"
											name="replaceName">

										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">被替姓名</label>
									<div class="col-sm-10">
										<select class="form-control" id="replacedName"
											class="empNames" name="replacedName">

										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">开始时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="startTimes"
											id="txt_search_startTime"
											data-date-format="yyyy-mm-dd hh:mm:ss" readonly>
									</div>
								</div>
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">结束时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="endTimes"
											id="txt_search_endTime"
											data-date-format="yyyy-mm-dd hh:ii:ss" readonly>
									</div>
								</div>
								<div class="form-group">
									<label for="lastname" class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="remake"
											placeholder="请输入此次替班的备注" name="remake">
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal" onclick="cancel()">关闭</button>
									<input type="submit" id="sub" class="btn btn-primary"
										value="添加" disabled />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

			<div class="modal fade" id="updateRelayMode" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">修改替班信息</h4>
						</div>
						<div class="modal-body">
							<form action="relay/updateRealy.action" method="post"
								class="form-horizontal" onsubmit="return check()" role="form">
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">ID</label>
									<div class="col-sm-10">
										<fieldset disabled>
											<input type="text" class="form-control" id="RDrelayId"
												name="RDrelayId">
										</fieldset>
									</div>
								</div>
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">替班姓名</label>
									<div class="col-sm-10">
										<select class="form-control" id="RDreplaceName"
											name="RDreplaceName">

										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">被替姓名</label>
									<div class="col-sm-10">
										<select class="form-control" id="RDreplacedName"
											name="RDreplacedName">

										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">开始时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="RDstartTime"
											id="RDstartTime" data-date-format="yyyy-mm-dd hh:mm:ss"
											readonly>
									</div>
								</div>
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">结束时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="RDendTime"
											id="RDendTime" data-date-format="yyyy-mm-dd hh:mm:ss"
											readonly>
									</div>
								</div>
								<div class="form-group">
									<label for="lastname" class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="RDremake"
											name="RDremake">
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal" onclick="cancel()">关闭</button>
									<input type="button" id="edit-Relay" class="btn btn-primary"
										value="确定修改" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>

		<script type="text/javascript">
		
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_relay').bootstrapTable({
					url : 'relay/findAllRelay.action', //请求后台的URL（*） 
					method : 'post', //请求方式（*） 
					toolbar : '#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : true, //是否启用排序 
					sortOrder : "desc", //排序方式
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
					uniqueId : "replaceId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'relayId',
						title : '编号'
					},{
						field : 'replaceName',
						title : '替班员工名字'
					}, {
						field : 'replacedName',
						title : '被替班员工名字'
					}, {
						field : 'startTime',
						title : '替班开始时间',
						formatter:function (value){
							return formatDate(value);
						}
					}, {
						field : 'endTime',
						title : '替班结束时间',
						formatter:function (value){
							return formatDate(value);
						}
					}, {
						field : 'remake',
						title : '备注'
					}]
				});
				
			}; //得到查询的参数
			
			//时间的转换
			function formatDate(ns) {
				var now = new Date(ns);
				var year=now.getYear()+1900;
				var month=now.getMonth()+1;
				if(month<10){
					month = "0"+month;
				}
				var date=now.getDate();
				if(date<10){
					date = "0"+date;
				}
				var hour=now.getHours();
				if(hour<10){
					hour = "0"+hour;
				}
				var minute=now.getMinutes();
				if(minute<10){
					minute = "0"+minute;
				}
				return year+"-"+month+"-"+date+" "+hour+":"+minute;

			}
	
			oTableInit.queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset, //页码 
					statu : $("#txt_search_statu").val(),
					replaceName :  $("#RelayEmpName").val(),
					startTime :  $("#sRstartTime").val(),
					endTime :  $("#sRendTime").val(),
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
				$("#btn_add_relay").click(function() {
					$.ajax({
						url:"relay/findAllEmpName.action",
						type:"post",
						async:true,
						traditional: true,
						success:function(response) {
							var replacedName=$('#replacedName');
							for(var i=0;i<response.length;i++){
									item=$("<option></option>");
									item.append(response[i]);
									item.attr("value",response[i]);
									replacedName.append(item);
							}
							
						}
					})
					
					$.ajax({
						url:"relay/findAllEmpName.action",
						type:"post",
						async:true,
						traditional: true,
						success:function(response) {
							var replaceName = $("#replaceName");
							for(var i=0;i<response.length;i++){
									item=$("<option></option>");
									item.append(response[i]);
									item.attr("value",response[i]);
									replaceName.append(item);
							}
							
						}
					})
					
					
					
					test();

				});

				$("#btn_relay-edit").click(
						function() {
							var select = $('#tb_relay').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请选择一行");
							}else if(select.length>1){
								toastr.warning("只能选择一行");
							}else{
								$("#RDrelayId").val(select[0].relayId);
								$("#RreplaceName").val(select[0].replaceName);
								$("#RDreplacedName").val(select[0].replacedName);
								$("#RDremake").val(select[0].remake);
								
								$.ajax({
									url:"relay/findAllEmpName.action",
									type:"post",
									async:true,
									traditional: true,
									success:function(response) {
										var replacedName=$('#RDreplacedName');
										for(var i=0;i<response.length;i++){
												item=$("<option></option>");
												item.append(response[i]);
												item.attr("value",response[i]);
												replacedName.append(item);
										}
										
									}
								})
								
								$.ajax({
									url:"relay/findAllEmpName.action",
									type:"post",
									async:true,
									traditional: true,
									success:function(response) {
										var replaceName = $("#RDreplaceName");
										for(var i=0;i<response.length;i++){
												item=$("<option></option>");
												item.append(response[i]);
												item.attr("value",response[i]);
												replaceName.append(item);
										}
										
									}
								})
								$("#updateRelayMode").modal({show:true});
							}

						});
				$("#edit-Relay").click(function(){
					var relayId = $("#RDrelayId").val();
					var startTime = $("#RDstartTime").val();
					var endTime = $("#RDendTime").val();
					var replaceName = $("#RDreplaceName").val();
					var replacedName = $("#RDreplacedName").val();
					var remake = $("#RDremake").val();
					
					if( endTime<= startTime){
						toastr.warning("开始时间不能小于或者等于结束时间"); 
					}else if(replaceName==replacedName){
						toastr.warning("替班人不能和被替班人名字相同"); 
					}else{
						$.ajax({
							url : "relay/updateRealy.action",
							type : "post",
							data : {
								"relayId" : relayId,
								"RstartTime" : startTime,
								"RendTime" : endTime,
								"replaceName" : replaceName,
								"replacedName" : replacedName,
								"remake":remake
							},
							traditional : true,//这里设置为true
							success : function(result) {
								$("#updateRelayMode").modal('hide');
								if (result == "success") {
									toastr.success("修改成功"); 
									var url = {
										url : 'relay/findAllRelay.action'
									};
									$("#updateRelayMode").modal({show:false});
									$('#tb_relay').bootstrapTable('refresh',url);
								} else {
									 toastr.error("修改失败");  
								}
							}
						})
					}
					
					
				});
				
				$('#remake').click(function(){
					var startTimes = $('#txt_search_startTime').val();
					var endTimes = $('#txt_search_endTime').val();
					var replacedName = $('#replacedName').val();
					var replaceName = $('#replaceName').val();
					if(replaceName == replacedName){
						toastr.warning("替班人和被替班人不能是同一个人"); 
					}else{
						if(endTimes <= startTimes){
							toastr.warning("开始时间不能小于或者等于结束时间"); 
							$('#sub').prop("disabled",true);
						}else{
							 $('#sub').prop("disabled",false);
						}
					}
				});

				$("#btn_relay-delete").click(
						function() {
							var select = $('#tb_relay').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请选择一行");
							} else {

								var arrs = [];
								for (var i = 0; i < select.length; i++) {
									arrs[i] = select[i]['relayId'];
								}
								
								$('#tb_relay').bootstrapTable('remove', {
									field : 'relayId',
									values : arrs
								});
								
								$.ajax({
									url : "relay/deleteRelay.action",
									type : "POST",
									data : {
										"relayId" : arrs
									},
									traditional : true,//这里设置为true
									success : function(result) {
										if (result == "success") {
											toastr.success("删除成功");
											var url = {
												url : 'relay/findAllRelay.action'
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
			$('#myModal1').modal('hide')
			//异步同步数据库
			$.getJSON("add", obj, function(result) {
				if (result.status == "success") {
					alert("${msg}");
				} else {
					alert("${msg}");
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
			
			
			$('#findRelayByCar').click(function() {		
				var endtime = $('#sRendTime').val();
				var starttime = $('#sRstartTime').val();
				if(endtime <= starttime){
					toastr.warning("结束时间不能小于开始时间");
				}else{
					$('#tb_relay').bootstrapTable("refresh", {
						url : "relay/findRelayByVague.action",
						silent : true,
						queryParams : oTable.queryParams
					});
				}
			});
			
		    $('#txt_search_startTime').datetimepicker({
		        format: 'yyyy-mm-dd hh:mm:ss',
	            language: 'zh-CN',
	            autoclose: true,
	            todayHighlight: true
		    });
		    
		    $('#txt_search_endTime').datetimepicker({
		        format: 'yyyy-mm-dd hh:mm:ss',
	            language: 'zh-CN',
	            autoclose: true,
	            todayHighlight: true
		    });
		    
		    $('#RDstartTime').datetimepicker({
		        format: 'yyyy-mm-dd hh:mm:ss',
	            language: 'zh-CN',
	            autoclose: true,
	            todayHighlight: true
		    });
		    
		    $('#RDendTime').datetimepicker({
		        format: 'yyyy-mm-dd hh:mm:ss',
	            language: 'zh-CN',
	            autoclose: true,
	            todayHighlight: true
		    });
		    
		    $('#sRstartTime').datetimepicker({
		        format: 'yyyy-mm-dd hh:mm:ss',
	            language: 'zh-CN',
	            autoclose: true,
	            todayHighlight: true
		    });
		    
		    $('#sRendTime').datetimepicker({
		        format: 'yyyy-mm-dd hh:mm:ss',
	            language: 'zh-CN',
	            autoclose: true,
	            todayHighlight: true
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
</body>
</html>