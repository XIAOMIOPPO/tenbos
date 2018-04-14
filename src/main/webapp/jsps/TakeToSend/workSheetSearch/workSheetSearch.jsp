<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>工作单查询</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/toastr/toastr.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-select.css">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">


<script src="${pageContext.request.contextPath}/static/jquery-3.2.1.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/collapse.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-select.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>



</head>
<body>
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-default" data-toggle="modal"
				data-target="#findMoreModel">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>查询
			</button>
			<button id="btn_update" type="button" class="btn btn-default" data-toggle="modal"
				data-target="#addModel">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>作废
			</button>
			<button id="btn_updateNo" type="button" class="btn btn-default" data-toggle="modal"
				data-target="#addModel">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>取消作废
			</button>
			<button id="btn_print" type="button" class="btn btn-default" data-toggle="modal"
				data-target="#addModel">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>打印工作单
			</button>
		</div>
	<div class="panel panel-default">
			<div class="panel-heading">
				<a href="#collapse" data-toggle="collapse">查询条件</a>
			</div>
			<div class="panel-body collapse" id="collapse">
				<form class="form-horizontal" 
								role="form">
								<div class="form-group">
									<label for="lastname" class="col-sm-1 control-label text-right">工作单号:</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="workSheetNo">
									</div>
									<label for="lastname" class="col-sm-1 control-label text-right">委托单位:</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" id="pickup">
									</div>
									<label for="lastname" class="col-sm-1 control-label text-right">单据状态:</label>
									<div class="col-sm-2">
										<select id="integraliyStatus" class="selectpicker form-control">
										  <option></option>
										  <option>配载信息不全</option>
										  <option>其他信息不全</option>
										  <option>信息完整</option>
										</select>
									</div>
									<div class="text-center col-sm-3">
										<button id="subFind" class="btn btn-primary">点击查询</button>
									</div>
								</div>
							</form>
			</div>
		</div>	
		
		

		<table id="jobListFindTb"></table>
		
		<script type="text/javascript">
		$(function () {

		    //1.初始化Table
		    var oTable = new TableInit();
		    oTable.Init();
		    
		});
	   
	   var TableInit = function () {
		    var oTableInit = new Object();
		    //初始化Table
		    oTableInit.Init = function () {
		        $('#jobListFindTb').bootstrapTable({
					url : 'workSheetSearch/findSubJobList', //请求后台的URL（*） 
					method : 'post', //请求方式（*） 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : false, //是否启用排序 
					sortOrder : "asc", //排序方式
					queryParams : oTableInit.queryParams,//传递参数（*） 
					sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
					pageNumber : 1, //初始化加载第一页，默认第一页 
					pageSize : 1, //每页的记录行数（*） 
					pageList : [ 3, 25, 50, 100 ], //可供选择的每页的行数（*） 
					minimumCountColumns : 1, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					height : 180, //行高，如果没有设置height属性，表格自动根据记录条数决定表格高度
					uniqueId : "workSheetNo", //每一行的唯一标识，一般为主键列 
					rowStyle:function(row,index){
						var strclass = "";
						if(row.cancelStatus=="作废"){
							strclass='danger';
						}
						return {classes:strclass}
					},
					columns : [ {
						checkbox : true
					}, {
						field : 'workSheetNo',
						title : '工作单号'
					}, {
						field : 'productName',
						title : '品名'
					}, {
						field : 'billingQuantity',
						title : '件数'
					}, {
						field : 'product',
						title : '产品'
					}, {
						field : 'senderName',
						title : '委托人'
					},{
						field : 'senderPhone',
						title : '委托电话'
					},{
						field : 'senderCompany',
						title : '委托单位'
					},{
						field : 'addressesAddress',
						title : '到达地'
					},{
						field : 'addressesName',
						title : '签收人'
					},	{
						field : 'integraliyStatus',
						title : '单据状态'
					},{
						field : 'supplementName',
						title : '补录人'
					},{
						field : 'supplementCompany',
						title : '补录单位'
					}]
				});
		    };
		    oTableInit.queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset, //页码 
					workSheetNo : $("#workSheetNo").val(),
					integraliyStatus : $("#integraliyStatus").val(),
					pickup : $("#pickup").val(),

				};
				return temp;
			};

		    //得到查询的参数
		    return oTableInit;
		};
		
		
		$('#subFind').click(function(e) {
			e.preventDefault();
			$('#jobListFindTb').bootstrapTable("refresh");
			$("input").val("");
			$("#integraliyStatus").val("");
		});
		
		$("#btn_update").click(function() {
			var select = $('#jobListFindTb').bootstrapTable('getSelections');
			if (select.length === 0) {
				toastr.info("请选择一行");
			} else {
				layer.msg('确定作废？',{
				  time : 0 //不自动关闭
				  ,btn : [ '确定', '取消' ],
				  yes : function(index) {
					layer.close(index);
								$.ajax({
									url : "workSheetSearch/updateStatus",
									type : "post",
									data : {
									"workSheetNo" : select[0].workSheetNo
									},
									traditional : true,//这里设置为true
									success : function(result) {
									if (result == "success") {
									  toastr.success("作废成功");

									  $('#jobListFindTb').bootstrapTable('refresh');
									} else {
									  toastr.error("作废失败");
									}
								  }
								});
																	
			      }
		       });
		     }
		});
		
		$("#btn_updateNo").click(function() {
			var select = $('#jobListFindTb').bootstrapTable('getSelections');
			if (select.length === 0) {
				toastr.info("请选择一行");
			} else {
				layer.msg('取消作废？',{
				  time : 0 //不自动关闭
				  ,btn : [ '确定', '取消' ],
				  yes : function(index) {
					layer.close(index);
								$.ajax({
									url : "workSheetSearch/updateStatusNo",
									type : "post",
									data : {
									"workSheetNo" : select[0].workSheetNo
									},
									traditional : true,//这里设置为true
									success : function(result) {
									if (result == "success") {
									  toastr.success("取消作废成功");

									  $('#jobListFindTb').bootstrapTable('refresh');
									} else {
									  toastr.error("取消作废失败");
									}
								  }
								});
																	
			      }
		       });
		     }
		});
		
		$("#btn_print").click(function(){
			var select = $('#jobListFindTb').bootstrapTable(
			'getSelections');
			if (select.length != 1) {
				toastr.warning('请选择一行');
			}else if(select[0].cancelStatus=="不作废"){
				window.open("workSheetSearch/print?workSheetNo="+select[0].workSheetNo)
			}
		});
		
		</script>
</body>
</html>