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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>火车线路</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/edit/bootstrap-editable.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/toastr/toastr.css">

<script src="${pageContext.request.contextPath}/static/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/edit/bootstrap-editable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/static/toastr/toastr.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
</head>
<body>
	<div id="toolbar" class="btn-group">
		<button id="add" type="button" class="btn btn-inverse">增加</button>
		<button id="update" type="button" class="btn btn-inverse">修改</button>
		<button id="delete" type="button" class="btn btn-inverse">删除</button>
		<div class="btn-group">
			<button type="button" class="btn btn-inverse dropdown-toggle btn-sm"data-toggle="dropdown">行操作</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#" id="addData">增行</a></li>
				<li><a href="#">删行</a></li>
			</ul>
		</div>
		<button type="button" class="btn btn-inverse">保存</button>
		<button type="button" class="btn btn-inverse">取消</button>
		<button type="button" class="btn btn-inverse">审核</button>
		<button type="button" class="btn btn-inverse">作废</button>
		<button type="button" class="btn btn-inverse">刷新</button>
		<button type="button" class="btn btn-inverse" id="search">查询</button>
	</div>
	
	<div class="modal fade" id="myModal1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:1100px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
					<label>查询</label>			       
					</h4>
				</div>
				<div class="modal-body">
					<div class="row form-group">
						<label class="col-sm-1 text-right">起始城市</label>
						<div class="col-sm-5">
							<input id="startingCity" type="text"
								class="form-control">
						</div>
						<label class="col-sm-1 text-right">到达城市</label>
						<div class="col-sm-5">
							<input id="arriveCity" type="text"
								class="form-control">
						</div>
					</div>
					<div class="row form-group">
						<label class="col-sm-1 text-right">起始车站</label>
						<div class="col-sm-5">
							<input id="startingStation" type="text"
								class="form-control">
						</div>
						<label class="col-sm-1 text-right">到达车站</label>
						<div class="col-sm-5">
							<input id="arriveStation" type="text"
								class="form-control">
						</div>
					</div>
				</div>
				<div class="modal-footer">
				    <button type="button" class="btn btn-primary" id="sear">提交</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="myModal2" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
					<label>新增</label>			       
					</h4>
				</div>
				<div class="modal-body">
					<div class="row form-group">
						<label class="col-sm-2 text-right">线路编码</label>
						<div class="col-sm-10">
							<input id="lineCode" type="text"
								class="form-control">
						</div>
					</div>
				
					<div class="row form-group">
						<label class="col-sm-2 text-right">起始城市</label>
						<div class="col-sm-10">
							<input id="startingCity1" type="text"
								class="form-control">
						</div>
					</div>
					
					<div class="row form-group">
						<label class="col-sm-2 text-right">到达城市</label>
						<div class="col-sm-10">
							<input id="arriveCity1" type="text"
								class="form-control">
						</div>
					</div>
					
					<div class="row form-group">
						<label class="col-sm-2 text-right">起始车站</label>
						<div class="col-sm-10">
							<input id="startingStation1" type="text"
								class="form-control">
						</div>
					</div>
					<div class="row form-group">
						<label class="col-sm-2 text-right">到达车站</label>
						<div class="col-sm-10">
							<input id="arriveStation1" type="text"
								class="form-control">
						</div>
					</div>
				</div>
				<div class="modal-footer">
				    <button type="button" class="btn btn-primary" id="addLine">提交</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="myModal3" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
					<label>修改</label>			       
					</h4>
				</div>
				<div class="modal-body">
					<div class="row form-group">
						<label class="col-sm-2 text-right">线路编码</label>
						<div class="col-sm-10">
							<input id="lineCode2" type="text"
								class="form-control">
						</div>
					</div>
				
					<div class="row form-group">
						<label class="col-sm-2 text-right">起始城市</label>
						<div class="col-sm-10">
							<input id="startingCity2" type="text"
								class="form-control">
						</div>
					</div>
					
					<div class="row form-group">
						<label class="col-sm-2 text-right">到达城市</label>
						<div class="col-sm-10">
							<input id="arriveCity2" type="text"
								class="form-control">
						</div>
					</div>
					
					<div class="row form-group">
						<label class="col-sm-2 text-right">起始车站</label>
						<div class="col-sm-10">
							<input id="startingStation2" type="text"
								class="form-control">
						</div>
					</div>
					<div class="row form-group">
						<label class="col-sm-2 text-right">到达车站</label>
						<div class="col-sm-10">
							<input id="arriveStation2" type="text"
								class="form-control">
						</div>
					</div>
				</div>
				<div class="modal-footer">
				    <button type="button" class="btn btn-primary" id="updateLine">提交</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

    <table class="table table-striped table-bordered table-hover" id="subprocessTable"></table>  
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
        $('#subprocessTable').bootstrapTable({
			url : 'line/findAllLine', //请求后台的URL（*） 
			method : 'post', //请求方式（*） 
			striped : true, //是否显示行间隔色 
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
			pagination : true, //是否显示分页（*） 
			sortable : false, //是否启用排序 
			sortOrder : "asc", //排序方式
			queryParams : oTableInit.queryParams,//传递参数（*） 
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
			pageNumber : 1, //初始化加载第一页，默认第一页 
			pageSize : 15, //每页的记录行数（*） 
			pageList : [ 3, 25, 50, 100 ], //可供选择的每页的行数（*） 
			minimumCountColumns : 20, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行 
			uniqueId : "lineCode", //每一行的唯一标识，一般为主键列 
			columns : [{
				checkbox:true
			},{
				field : 'lineName',
				title : '线路名称',
			},{
				field : 'lineCode',
				title : '线路编码',
			}, {
				field : 'startingCity',
				title : '起始城市',
			}, {
				field : 'startingStation',
				title : '起始车站',
			}, {
				field : 'arriveCity',
				title : '到达城市',
			}, {
				field : 'arriveStation',
				title : '到达车站',
			},{
				field : 'distance',
				title : '线路里程',
			}]
		});
    };
    oTableInit.queryParams = function(params) {
		var temp = {
			//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
			limit : params.limit, //页面大小 
			offset : params.offset, //页码 
			startingCity : $("#startingCity").val(),
			arriveCity : $("#arriveCity").val(),
			startingStation : $("#startingStation").val(),
			arriveStation : $("#arriveStation").val(),

		};
		return temp;
	};

    //得到查询的参数
    return oTableInit;
};
$("#sear").click(function(e){
	e.preventDefault();
	$('#subprocessTable').bootstrapTable('refresh');
	$("input").val("");
})
$("#search").click(function(){
	$("#myModal1").modal('show');
});

$("#add").click(function(){
	$("#myModal2").modal('show');
});

$("#addLine").click(function(){
	var obj = {
		lineCode : $("#lineCode2").val(),
		startingCity : $("#startingCity2").val(),
		arriveCity : $("#arriveCity2").val(),
		startingStation : $("#startingStation2").val(),
		arriveStation : $("#arriveStation2").val()
	};
	$.getJSON("line/addLine",obj,function(result){
		if(result.status=="success"){
			toastr.success("添加成功");
			$("#myModal2").modal('hide');
			$('#subprocessTable').bootstrapTable('refresh');
		}else{
			toastr.error("添加失败");
		}
	})
	
})

$("#update").click(function(){
	var select = $('#subprocessTable').bootstrapTable('getSelections');
	if(select.length !=1){
		toastr.info("请选择一行");
	}else{
	$("#myModal3").modal('show');
	$("#lineCode2").val(select[0].lineCode)
	$("#startingCity2").val(select[0].startingCity)	
	$("#arriveCity2").val(select[0].arriveCity)
	$("#startingStation2").val(select[0].startingStation)
	$("#arriveStation2").val(select[0].arriveStation)
	
	$("#updateLine").click(function(){
	var obj = {
		lineId : select[0].lineId,
		lineCode : $("#lineCode2").val(),
		startingCity : $("#startingCity2").val(),
		arriveCity : $("#arriveCity2").val(),
		startingStation : $("#startingStation2").val(),
		arriveStation : $("#arriveStation2").val(),
	};
	$.getJSON("line/updateLine",obj,function(result){
		if(result.status=="success"){
			toastr.success("修改成功");
			$("#myModal3").modal('hide');
			$('#subprocessTable').bootstrapTable('refresh');
		}else{
			toastr.error("修改失败");
		}
	})
	
})
	}
});

$("#delete").click(function(){
	var select = $('#subprocessTable').bootstrapTable('getSelections');
	if(select.length == 0){
		toastr.info("请选择一行");
	}else{
		layer.msg('确定删除？',{
			  time : 0 //不自动关闭
			  ,btn : [ '确定', '取消' ],
			  yes : function(index) {
				layer.close(index);
				var obj = {
						lineId : select[0].lineId,
						status : 1
					};
					$.getJSON("line/updateLine",obj,function(result){
						if(result.status=="success"){
							toastr.success("删除成功");
							$("#myModal3").modal('hide');
							$('#subprocessTable').bootstrapTable('refresh');
						}else{
							toastr.error("删除失败");
						}
					})
																
		      }
	       });
	}
})

</script>   

</body>
</html>