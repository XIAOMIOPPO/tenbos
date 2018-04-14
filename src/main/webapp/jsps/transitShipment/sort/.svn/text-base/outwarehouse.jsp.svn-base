<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>出入库查询</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">



<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css"
	rel="stylesheet">
<link href="static/toastr/toastr.css" rel="stylesheet">
<link
	href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/toastr/toastr.js"></script>
<script src="static/jquery.form.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/jquery.jqprint.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>
		<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-zh.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootbox.js"></script>
</head>

<body>
	<div class="panel-body" style="padding-bottom:0px;">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" class="form-horizontal">
					 <div class="form-group" style="margin-top:15px"> 
					<div class="form-group">
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">操作单位</label>
						<div class="col-sm-2">
							<input type="text" class="form-control"
								id="operationUnit_o">
						</div>
						     
							<label class="control-label col-sm-1" for="txt_search_statu" id="datetimepicker">入库时间</label>
						    <div class="col-sm-8 ">
							<div class="col-sm-2">
								<input type="text" class="form-control time" id="warehouseTime_w">
							</div>
							<span class="col-lg-1">至</span>
							<div class="col-sm-2">
								<input type="text" class="form-control time" id="warehouseTime_t">
							</div>
							<label class="control-label col-sm-1" for="txt_search_statu" style="width: 103px">出库时间</label>
							
							<div class="col-sm-2">
								<input type="text" class="form-control time" id="deliveryTime_d">
							</div> 
							<span class="col-lg-1">至</span>
							<div class="col-sm-2">
								<input type="text" class="form-control time" id="deliveryTime_e">
							</div>
							</div>
							
					</div>
		
					<div class="form-group">
							<label class="control-label col-sm-1" for="txt_search_statu">出入类型</label>
							<div class="col-sm-2">
								<select class="form-control" id="AccessType_a">
								 <option value="0">出库</option>
								 <option value="1">入库</option>
								 <option value="3">全部</option>
								</select>
							</div>	
							<label class="control-label col-sm-1" for="txt_search_statu">操作时间</label>
							<div class="col-sm-8 ">
							<div class="col-sm-2">
								<input type="text" class="form-control time" id="operationTime_o">
							</div> 
							<span class="col-lg-1">至</span>
							<div class="col-sm-2">
								<input type="text" class="form-control time" id="operationTime_p">
							</div>
							<label class="control-label col-sm-1" for="txt_search_statu" style="width: 103px">交接单号</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="receiptNo_r">
							</div>
							</div>
							
				   </div>
						<div class="form-group">
							
							<label class="control-label col-sm-1" for="txt_search_statu">工作单号</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" id="jobNo_j">
							</div>
							<div class="col-sm-2" style="text-align:left;">
								<button type="button" style="margin-left:50px" id="btn_query"
									class="btn btn-primary">查询</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
			<button id="btn" type="button" class="btn btn-success" >
				<span class="glyphicon glyphicon-plus" aria-hidden="true"   ></span>打印
			</button>
			<button id="btn_out" type="button" class="btn btn-primary">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>导出
			</button>
		</div>
		<table id="tb_departments"></table>
	</div>
	
	<script type="text/javascript">
	
	
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'outwarehouse/findoutwarehousePagenation', //请求后台的URL（*） 
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
					pageSize : 8, //每页的记录行数（*） 
					pageList : [ 8, 25, 50, 100 ], //可供选择的每页的行数（*） 
					search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "outwarehouseId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					},//打印开始位置符合
					{
						field : 'receiptNo',
						title : '交接单号'
					},{
						field : 'jobNo',
						title : '工作单号'
					}, {
						field : 'warehousePeople',
						title : '入库人'
					}, {
						field : 'warehouseTime',
						title : '入库时间',
						formatter : FormatDate
					
					}, {
						field : 'operator',
						title : '操作人'
					},{
						field : 'queryType',
						title : '操作类型'
					},{
						field : 'operationTime',
						title : '操作时间',
						formatter : FormatDate
					
					},{
						field : 'operationUnit',
						title : '操作单位'
					},{
						field : 'deliveryTime',
						title : '出库时间',
						formatter : FormatDate
					
					},{
						field : 'deliveryMan',
						title : '出库人'
					},{
						field : 'accessType',
						title : '出入类型',
						formatter:function(data){
							if(data=='0'){
								return '出库';
							}else if(data=='1'){
								return '入库';
							}else{
								return '全部';
							}
						}
					},{
						field : 'delivery',
						title : '交货人'
					},{
						field : 'numberOf',
						title : '件数'
					}]
				//打印结束位置符合
				});
			}; //得到查询的参数
			
			oTableInit.queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset, //页码 
					departmentName : $("#txt_search_departmentname").val(),
					status : $("#txt_search_statu").val()
				};
				return temp;
			};
			$("#btn_out").click(function(){
				$.ajax({
					type:"post",
					url:"outwarehouse/outware",
					data:{
						path:"D://出入库导出.xls"
					},
					success:function(result){
						if (result == "success") {
							toastr.success("导出成功");
						} else {
							toastr.warning("导出失败");
						}
					}
				});
			});

			$('#btn_query').click(function (){
				  var opt = {
						  
				    url: "outwarehouse/findoutwarehousePagenationWithCriteria",
				    silent: true,
				    query:{      
				    	/* type:1,
 				        level:2, */
 				       operationUnit: $('#operationUnit_o').val(),
 				      warehouseTime_t: $('#warehouseTime_t').val(),
 				     warehouseTime_w: $('#warehouseTime_w').val(),
				     deliveryTime_e : $('#deliveryTime_e').val(),
 				     deliveryTime_d : $('#deliveryTime_d').val(),
 				    operationTime_o : $('#operationTime_o').val(),
 				   operationTime_p : $('#operationTime_p').val(),
 				       receiptNo : $('#receiptNo_r').val(),
 				        jobNo : $('#jobNo_j').val(),
 				        AccessType : $('#AccessType_a').val()
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
				$("#btn_add").click(function() {
					$('#addApply').modal('show');
					$('#addapply').data('bootstrapValidator').destroy();
					$('#addapply').data('bootstrapValidator', null); 
					formValidator();
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

			

			formValidator();
		});

		
	//日期格式化
	 function FormatDate (strTime) {
		    var date = new Date(strTime);
		    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
		}
	//日期插件
	 $('.time').datetimepicker({
			format : 'yyyy-mm-dd hh:mm:ss',
			language : 'zh-CN',
			regional : 'zh-CN',
			pickDate : false,
			pickTime : true
		}); 
/* 	//printit() 确认打印
	
	 $('#btn').click(function (){
	 if(confirm('确认打印吗？')){
	 document.getElementById('btn').style.display="none";//隐藏
	 window.print();//打印
	 document.getElementById('btn').style.display="inline";//显示
	 }
	 
	}); 
	 */
	 $("#btn").click(function(){
			var select = $('#tb_departments').bootstrapTable(
			'getSelections');
			if (select.length == 0) {
				toastr.warning('请选择一行');
			}else{
				
				if(confirm('确认打印吗？')){
					//定义
					var str = [];
					//循环选中的出入库单数组，获取出入库单号id
					for(var i=0;i<select.length;i++){
						
						/* var astr='outwarehouseIds='+select[i].outwarehouseId;
						if(i>0){
							astr='&' +astr;
						} 
						
						str +=astr; */
						
						str.push(select[i].outwarehouseId);
						
					}
					$.post('outwarehouse/outprint',{outwarehouseIds:str},function(data){
						window.open('jsps/transitShipment/sort/prinout.jsp');
					})
						
					
				}
			}
		});
	
	</script>


</body>
</html>
