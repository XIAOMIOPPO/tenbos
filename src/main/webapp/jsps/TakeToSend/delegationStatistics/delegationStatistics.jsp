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
<script type="text/javascript" 
    src="https://cdn.bootcss.com/Chart.js/2.7.1/Chart.bundle.min.js"></script>
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
							for="txt_search_departmentname">网点代码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="orgId">
						</div>
						<label class="control-label col-sm-5"
							for="txt_search_departmentname">网点名称</label>
						<div class="col-sm-3">
							<input type="text" class="form-control time" id="pickup">
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
			<button id="btn_bar" type="button" class="btn btn-danger">
				<span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>柱形图
			</button>
			<button id="btn_line" type="button" class="btn btn-danger">
				<span class="glyphicon glyphicon-signal" aria-hidden="true"></span>折线图
			</button>


		</div>
		<table id="tb_departments"></table>
	</div>
     <div class="modal fade model2" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:800px;margin:auto">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">打印</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="lfirstname" class="col-sm-2 control-label">网点代码：</label>
							<div class="col-sm-4" id="printOrgId" style="margin-top: 7px;'">
							</div>
							<label for="lastname" class="col-sm-2 control-label">网点名称：</label>
							<div class="col-sm-4" id="printPickup" style="margin-top: 7px;'">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">应派送票数：</label>
							<div class="col-sm-4" id="printPayableVotes" style="margin-top: 7px;'">
							</div>
							<label for="lastname" class="col-sm-2 control-label">已派送票数：</label>
							<div class="col-sm-4" id="printDelivered" style="margin-top: 7px;'">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">未派送票数：</label>
							<div class="col-sm-4" id="printNotDelivered" style="margin-top: 7px;'">
							</div>
							<label for="lastname" class="col-sm-2 control-label">已返货数量：</label>
							<div class="col-sm-4" id="printReturnNum" style="margin-top: 7px;'">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">晚点率：</label>
							<div class="col-sm-4" id="printDelayRate" style="margin-top: 7px;'">
							</div>
							<label for="lastname" class="col-sm-2 control-label">返货率：</label>
							<div class="col-sm-4" id="printReturnRate" style="margin-top: 7px;'">
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
     <div class="modal fade model2" id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:800px;margin:auto">
			<div class="modal-content">
				<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">柱状图</h4>
				</div>
				<div class="modal-body">
				<canvas id="Bar" style="width:50px;height:100px;"></canvas>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade model2" id="myModal4" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:800px;margin:auto">
			<div class="modal-content">
				<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">折线图</h4>
				</div>
				<div class="modal-body">
				<canvas id="Line" style="width:50px;height:100px;"></canvas>
				</div>
			</div>
		</div>
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
				url : 'delegationStatistics/delegationStatisticsQuery', //请求后台的URL（*） 
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
				height : 500, //行高，如果没有设置height属性，表格自动根据记录条数决定表格高度 
				uniqueId : "orgId", //每一行的唯一标识，一般为主键列 
				showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				columns : [ {
					checkbox : true
				}, {
					field : 'orgId',
					title : '网点代码'
				},{
					field : 'pickup',
					title : '网点名称'
				}, {
					field : 'votes',
					title : '应派送票数'
				}, {
					field : 'delivered',
					title : '已派送票数'
				}, {
					field : 'notDelivered',
					title : '未派送票数',
				}, {
					field : 'returnNum',
					title : '已返货数量',
				}, {
					field : 'delayRate',
					title : '晚点率',
				}, {
					field : 'returnRate',
					title : '返货率',
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
								url : "delegationStatistics/delegationStatisticsQueryWithCriteria",
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
						if (select.length == 0) {
							toastr.info("请选择一行");
						} else {
							var arrs=[];
							for (var i = 0; i < select.length; i++) {
								arrs.push(select[i].orgId);
							}
							$.ajax({
								url:"delegationStatistics/printDelegationStatistics",
								type:"post",
								data:{"orgId":arrs},
								success:function(){
									window.open("jsps/TakeToSend/delegationStatistics/delegationPrint.jsp")
								}
							});
							
							var obj = select[0];
							var printOrgId = obj.orgId;
							var printPickup = obj.pickup;
				            var printVotes = obj.votes;
				            var printDelivered = obj.delivered;
				            var printNotDelivered = obj.notDelivered;
				            var printReturnNum = obj.returnNum;
				            var printDelayRate = obj.delayRate;
				            var printReturnRate = obj.returnRate;
		
								$("#printOrgId").text(printOrgId);
								$("#printPickup").text(printPickup);
					            $("#printVotes").text(printVotes);
					            $("#printDelivered").text(printDelivered);
					            $("#printNotDelivered").text(printNotDelivered);
					            $("#printReturnNum").text(printReturnNum);
					            $("#printDelayRate").text(printDelayRate);
					            $("#printReturnRate").text(printReturnRate);
						}
						
	}); 
							 $("#btn_bar").click(function() {
									var select = $('#tb_departments')
									.bootstrapTable('getSelections');
							if (select.length != 1) {
								toastr.info("请选择一行");
							} else {
								var obj = select[0];
								var printVotes = obj.votes;
					            var printDelivered = obj.delivered;
					            var printNotDelivered = obj.notDelivered;
					            var printReturnNum = obj.returnNum;
								createBargraph(['应派送票数','已派送票数','未派送票数','已返货数量'],[printVotes,printDelivered,printNotDelivered,printReturnNum]);
								$('#myModal3').modal('show')
						}
							$("#btn_line").click(function() {
								var select = $('#tb_departments')
								.bootstrapTable('getSelections');
						if (select.length != 1) {
							toastr.info("请选择一行");
						} else {
							var obj = select[0];
							var printVotes = obj.votes;
				            var printDelivered = obj.delivered;
				            var printNotDelivered = obj.notDelivered;
				            var printReturnNum = obj.returnNum;
							createLinegraph(['‘应派送票数','已派送票数','未派送票数','已返货数量'],[printVotes,printDelivered,printNotDelivered,printReturnNum]);
							$('#myModal4').modal('show')
				     }
				});
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
	   function createBargraph(names,data){
		   var ctx = document.getElementById("Bar").getContext('2d');
			document.getElementById("Bar").width = 800;
			document.getElementById("Bar").height = 400;
		    var myChart = new Chart(ctx, {
		        type: 'bar',
		        data: {
		            labels: names,
		            datasets: [{
		                label: '腾云物流网点查询',
		                data: data,
		                backgroundColor: [
		                    'rgba(255, 99, 132, 0.2)',
		                    'rgba(54, 162, 235, 0.2)',
		                    'rgba(255, 206, 86, 0.2)',
		                    'rgba(75, 192, 192, 0.2)',
		                    'rgba(153, 102, 255, 0.2)',
		                    'rgba(255, 159, 64, 0.2)'
		                ],
		                borderColor: [
		                    'rgba(255,99,132,1)',
		                    'rgba(54, 162, 235, 1)',
		                    'rgba(255, 206, 86, 1)',
		                    'rgba(75, 192, 192, 1)',
		                    'rgba(153, 102, 255, 1)',
		                    'rgba(255, 159, 64, 1)'
		                ],
		                borderWidth: 1
		            }]
		        },
		        options: {
		            scales: {
		                yAxes: [{
		                    ticks: {
		                        beginAtZero:true
		                    }
		                }]
		            }
		        }
		    });
	   }
	   function createLinegraph(names,data){
		   var ctx = document.getElementById("Line").getContext('2d');
			document.getElementById("Line").width = 800;
			document.getElementById("Line").height = 400;
		    var myChart = new Chart(ctx, {
		        type: 'line',
		        data: {
		            labels: names,
		            datasets: [{
		                label: '腾云物流网点查询',
		                data: data,
		                backgroundColor: [
		                    'rgba(255, 99, 132, 0.2)',
		                    'rgba(54, 162, 235, 0.2)',
		                    'rgba(255, 206, 86, 0.2)',
		                    'rgba(75, 192, 192, 0.2)',
		                    'rgba(153, 102, 255, 0.2)',
		                    'rgba(255, 159, 64, 0.2)'
		                ],
		                borderColor: [
		                    'rgba(255,99,132,1)',
		                    'rgba(54, 162, 235, 1)',
		                    'rgba(255, 206, 86, 1)',
		                    'rgba(75, 192, 192, 1)',
		                    'rgba(153, 102, 255, 1)',
		                    'rgba(255, 159, 64, 1)'
		                ],
		                borderWidth: 1
		            }]
		        },
		        options: {
		            scales: {
		                yAxes: [{
		                    ticks: {
		                        beginAtZero:true
		                    }
		                }]
		            }
		        }
		    });
	   }
	   
	</script>
</body>
</html>
