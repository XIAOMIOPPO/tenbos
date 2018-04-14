<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
<base href="${pageContext.request.contextPath}/"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>签单信息接收</title>
<link rel="stylesheet" href="static/jqxtreegrid/css/jqxbase.css" type="text/css" />
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="static/toastr/toastr.css"/>

<style>
body {
	font-size: 24px;
	margin: 0;
	padding: 0
}

.row {
  margin-top: 6px;
  margin-bottom: 6px;
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

<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxcore.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxdata.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxbuttons.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxscrollbar.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxdatatable.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxtreegrid.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
</head>

<body>
      <div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1" for="returnId">返单号</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="returnId">
						</div>
						<label class="control-label col-sm-1" for="returnType">返单类型</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="returnType">
						</div>
						<div class="col-sm-4" style="text-align: left;">
						  <shiro:hasPermission name="DQ:SEARCH">
							<button type="button" style="margin-left: 50px" id="btn_query"
								class="btn btn-primary">查询</button>
						  </shiro:hasPermission>
						</div>
					</div>
				</form>
			</div>
		</div>	
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_data" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>数据接收
			</button>
			<button id="btn_delete" type="button" class="btn btn-default btn-danger">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button id="btn_sign" type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>签单签收
			</button>
		   <button id="btn_relay" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>转发
			</button>
		</div>
		<table id="tb_receive"></table>
		<hr/>
		</div>
		
		<script type="text/javascript">
		var TableInit = function() {
			var oTableInit = new Object();
			// 初始化Table
			oTableInit.Init = function() {
				$('#tb_receive').bootstrapTable({
					url : '', // 请求后台的URL（*）
					method : 'post', // 请求方式（*）
					toolbar : '#toolbar', // 工具按钮用哪个容器
					cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
					pagination : true, // 是否显示分页（*）
					sortable : false, // 是否启用排序
					sortOrder : "asc", // 排序方式
					queryParams : oTableInit.queryParams,// 传递参数（*）
					sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
					pageNumber : 1, // 初始化加载第一页，默认第一页
					pageSize : 8, // 每页的记录行数（*）
					pageList : [ 1, 5, 10, 50 ], // 可供选择的每页的行数（*）
					search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
					strictSearch : true,
					showColumns : true, // 是否显示所有的列
					showRefresh : true, // 是否显示刷新按钮
					minimumCountColumns : 2, // 最少允许的列数，
					height : 700, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
					uniqueId : "", // 每一行的唯一标识，一般为主键列
					showToggle : true, // 是否显示详细视图和列表视图的切换按钮
					cardView : false, // 是否显示详细视图
					detailView : false, // 是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'workId',
						title : '工作单号'
					}, {
						field : 'returnType',
						title : '返单类型'
					}, {
						field : 'returnAsk',
						title : '返单要求'
					}, {
						field : 'returnRemark',
						title : '返单备注'
					}, {
						field : 'launchMan',
						title : '发单人'
					}, {
						field : 'launchUnit',
						title : '发单单位'
					}, {
						field : 'launchTime',
						title : '发单时间'
					}, {
						field : 'signTime',
						title : '签收时间'
					} ],
				});

			}; // 得到查询的参数

			$('#tb_receive').bootstrapTable({
				url : '', // 请求后台的URL（*）
				method : 'post', // 请求方式（*）
				toolbar : '#toolbar', // 工具按钮用哪个容器
				striped : true, // 是否显示行间隔色
				cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination : true, // 是否显示分页（*）
				sortable : false, // 是否启用排序
				sortOrder : "asc", // 排序方式
				queryParams : oTableInit.queryParams,// 传递参数（*）
				sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
				pageNumber : 1, // 初始化加载第一页，默认第一页
				pageSize : 3, // 每页的记录行数（*）
				pageList : [ 1, 5, 10, 50 ], // 可供选择的每页的行数（*）
				search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch : true,
				showColumns : true, // 是否显示所有的列
				showRefresh : true, // 是否显示刷新按钮
				minimumCountColumns : 2, // 最少允许的列数
				clickToSelect : true, // 是否启用点击选中行
				height : 300, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
				uniqueId : "", // 每一行的唯一标识，一般为主键列
				columns : [ {
					checkbox : true
				}, {
					field : 'workId',
					title : '工作单号'
				}, {
					field : 'returnType',
					title : '返单类型'
				}, {
					field : 'settlementMode',
					title : '结算方式'
				}, {
					field : 'actMark',
					title : '代收标志'
				}, {
					field : 'omit',
					title : '省内'
				}, {
					field : 'acceptingUnit',
					title : '受理单位'
				}, {
					field : 'returnRemark',
					title : '返单备注'
				}, {
					field : 'signTime',
					title : '签收时间'
				} ]
			});

			oTableInit.queryParams = function(params) {
				var temp = {
					// 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					limit : params.limit, // 页面大小
					offset : params.offset, // 页码
				};
				return temp;
			};
			return oTableInit;
		};

		var ButtonInit = function() {
			var oInit = new Object();
			var postdata = {};
			oInit.Init = function() {
				$("#btn_sendBack").click(function() {
					var select = $('#tb_dispatcher').bootstrapTable('getSelections');
					if (select.length === 0) {
						toastr.warning("请选择一行");
					} else if (select.length > 1) {
						toastr.warning("不能选择多行");
					} else {
						var obj = select[0];

						$("#btn_returnCause").click(function() {
							var arrs = [];
							for (var i = 0; i < select.length; i++) {
								arrs[i] = select[i]['businessRecsiptId'];
							}

							//异步同步数据库
							$.ajax({
								url : "dispatcher/returnDispatcher",
								type : "post",
								data : {
									"returnCause" : $('#returnCauseDispatcher').val(),
									"businessRecsiptId" : arrs,
								},
								traditional : true,//这里设置为true
								success : function(result) {
									if (result.status == "success") {
										toastr.success("修改成功");
										$("#sendBack").modal('hide');
			
										$('#tb_dispatcher').bootstrapTable('refresh');
										$('#tb_dispatcherAnnals').bootstrapTable('refresh');
			
									} else {
										toastr.error("修改失败");
									}
								}
							});
						});
					}
				});
				
				$("#btn_query").click(function() {
					var obj = {
						url : "dispatcher/findAllNeedDispatcherWorkOrder",
						type : "get",
						query : {
							arrivalCity : $("#search_arriveSite").val(),
							fetchAddress : $("#search_fetchAddress").val(),
							offset : 1
						}
					}
					$('#tb_dispatcher').bootstrapTable('refresh', obj);
					$(':input').val("");
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