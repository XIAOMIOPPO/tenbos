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

<title>table</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/common.css">
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/cssreset-min.css">
<link rel="stylesheet" type="text/css" href="static/toastr/toastr.css">
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.css">


<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/jquery.citys.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/jquery.ocupload-1.1.2.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>

</head>

<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-heading">
				<a href="#collapse" data-toggle="collapse">查询条件</a>
			</div>
			<div class="panel-body collapse" id="collapse">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-5"
							for="txt_search_departmentname">工作单号</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="workSheetNo">
						</div>
						<label class="control-label col-sm-5"
							for="txt_search_departmentname">签收状态</label>
						<div class="col-sm-3">
							<input type="text" class="form-control time" id="signStatus">
						</div>
						<label class="control-label col-sm-5"
							for="txt_search_departmentname">受理单位</label>
						<div class="col-sm-3">
							<input type="text" class="form-control time" id="pickup">
						</div>
						<label class="control-label col-sm-5"
							for="txt_search_departmentname">派送单位</label>
						<div class="col-sm-3">
							<input type="text" class="form-control time" id="empName">
						</div>
						<label class="control-label col-sm-5"
							for="txt_search_departmentname">交接时间</label>
						<div class="col-sm-3">
							<input type="text" class="form-control time" id="handoverTime">
						</div>
						<div class="col-sm-4" style="text-align: left;">
							<button type="button" style="margin-left: 50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
			<button id="btn_print" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-print" aria-hidden="true"></span>打印
			</button>
			<button id="btn_refresh" type="button" class="btn btn-danger">
				<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
			</button>

		</div>
		<table id="tb_departments"></table>
	</div>
     <div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">打印</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="lfirstname" class="col-sm-2 control-label">工作单号：</label>
							<div class="col-sm-4" id="printWorkSheetNo">
							</div>
							<label for="lastname" class="col-sm-2 control-label">交接时间：</label>
							<div class="col-sm-4" id="printHandoverTime">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">签收状态：</label>
							<div class="col-sm-4" id="printSignStatus">
							</div>
							<label for="lastname" class="col-sm-2 control-label">签收人：</label>
							<div class="col-sm-4" id="printAddresseeId">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">派送单位：</label>
							<div class="col-sm-4" id="printEmpName">
							</div>
							<label for="lastname" class="col-sm-2 control-label">受理单位：</label>
							<div class="col-sm-4" id="printPickup">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">产品名：</label>
							<div class="col-sm-4" id="printProduct">
							</div>
							<label for="lastname" class="col-sm-2 control-label">配载要求：</label>
							<div class="col-sm-4" id="printStowageRequirement">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">总票数：</label>
							<div class="col-sm-4" id="printVotes">
							</div>
							<label for="lastname" class="col-sm-2 control-label">已配送：</label>
							<div class="col-sm-4" id="printDelivered">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">未配送：</label>
							<div class="col-sm-4" id="printNotDelivered">
							</div>
						    <label for="lastname" class="col-sm-2 control-label">晚点率：</label>
							<div class="col-sm-4" id="printDelayRate">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
		<!-- /.modal-dialog -->
	</div>

	

	<script type="text/javascript">
	
	
	function formatDate(ns) {
		var now = new Date(ns);
		
		var year=now.getYear()+1900;
		var month=now.getMonth()+1;
		var date=now.getDate();
		var hour=now.getHours();
		var minute=now.getMinutes();
		var second=now.getSeconds();
		
		return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;

	}
	var TableInit = function() {
		var oTableInit = new Object();
		//初始化Table 
		oTableInit.Init = function() {
			$('#tb_departments').bootstrapTable({
				url : 'assignmentDetailed/assignmentDetailedQuery', //请求后台的URL（*） 
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
				pageSize : 2, //每页的记录行数（*） 
				pageList : [ 3, 25, 50, 100 ], //可供选择的每页的行数（*） 
				search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
				strictSearch : true,
				showColumns : true, //是否显示所有的列 
				showRefresh : true, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数决定表格高度 
				uniqueId : "assignmentDetailedId", //每一行的唯一标识，一般为主键列 
				showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				columns : [ {
					checkbox : true
				}, {
					field : 'workSheetNo',
					title : '工作单号'
				}, {
					field : 'handoverTime',
					title : '交接时间',
					formatter:function (value){
						return formatDate(value);
					}
				}, {
					field : 'signStatus',
					title : '签收状态'
				}, {
					field : 'addresseeId',
					title : '签收人'
				}, {
					field : 'empName',
					title : '派送单位',
				}, {
					field : 'pickup',
					title : '受理单位',
				}, {
					field : 'product',
					title : '产品名',
				}, {
					field : 'stowageRequirement',
					title : '配载要求',
				}, {
					field : 'votes',
					title : '总票数',
				}, {
					field : 'delivered',
					title : '已派送',
				}, {
					field : 'notDelivered',
					title : '未派送',
				}, {
					field : 'delayRate',
					title : '晚点率',
				}]
			});
		}; //得到查询的参数
		
						oTableInit.queryParams = function(params) {
							var temp = {
								//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
								limit : params.limit, //页面大小 
								offset : params.offset, //页码 
								departmentname : $("#txt_search_departmentname").val(),
								statu : $("#txt_search_statu").val()
							};
							return temp;
						};
						$('#btn_query').click(function() {
							var opt = {
								url : "assignmentDetailed/assignmentDetailedQueryWithCriteria",
								silent : true,
								query : {
									type : 1,
									level : 2,
									franchiseeCodekjkj : $('#franchiseeCode').val(),
									cancelSign: $('#cancelSign').val()
								}
							};
							$('#tb_departments').bootstrapTable('refresh', opt);
						});
						return oTableInit;
					};
				
					var ButtonInit = function() {
						var oInit = new Object();
						var postdata = {};
						oInit.Init = function() {
							//初始化页面上面的按钮事件 
							
							
							$("#btn_print").click(function() {
								var select = $('#tb_departments')
								.bootstrapTable('getSelections');
						if (select.length != 1) {
							toastr.info("请选择一行");
						} else {
							$('#myModal2').modal('show')
							var obj = select[0];
							var printWorkSheetNo = obj.workSheetNo;
							var printHandoverTime = obj.handoverTime;
				            var printSignStatus = obj.signStatus;
				            var printAddresseeId = obj.addresseeId;
				            var printEmpName = obj.empName;
				            var printPickup = obj.pickup;
				            var printProduct = obj.product;
				            var printStowageRequirement = obj.stowageRequirement;
				            var printVotes = obj.votes;
				            var printDelivered = obj.delivered;
				            var printNotDelivered = obj.notDelivered;
				            var printDelayRate = obj.delayRate;
		
								$("#printWorkSheetNo").text(printWorkSheetNo);
								$("#printHandoverTime").text(printHandoverTime);
					            $("#printSignStatus").text(printSignStatus);
					            $("#printAddresseeId").text(printAddresseeId);
					            $("#printEmpName").text(printEmpName);
					            $("#printPickup").text(printPickup);
					            $("#printProduct").text(printProduct);
					            $("#printStowageRequirement").text(printStowageRequirement);
					            $("#printVotes").text(printVotes);
					            $("#printDelivered").text(printDelivered);
					            $("#printNotDelivered").text(printNotDelivered);
					            $("#printDelayRate").text(printDelayRate);
					
					}
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
