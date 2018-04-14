<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>班车线路</title>

<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.css">
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link href = "static/toastr/toastr.css" rel="stylesheet">
	
<script src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>		
<script type="text/javascript" src = "static/toastr/toastr.js"></script>
<script type="text/javascript" src = "static/layer/layer.js"></script>
</head>
<body>
	<div id="toolbar" class="btn-group">
		<button id="add" type="button" class="btn btn-inverse">增加</button>
		<button type="button" class="btn btn-inverse" id="change">修改</button>
		<button type="button" class="btn btn-inverse" id= "delete">删除</button>
		<div class="btn-group">
			<button type="button" class="btn btn-inverse dropdown-toggle btn-sm"data-toggle="dropdown">行操作</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#" id="addData">增行</a></li>
				<li><a href="#">删行</a></li>
			</ul>
		</div>
		<button type="button" class="btn btn-inverse">保存</button>
		<button type="button" class="btn btn-inverse">取消</button>
		<div class="btn-group">
			<button type="button" class="btn btn-inverse dropdown-toggle btn-sm"data-toggle="dropdown">审核</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#" id="check">审核(分析)</a></li>
				<li><a href="#">取消审核(分析)</a></li>
				<li><a href="#">审核(正式)</a></li>
				<li><a href="#">取消审核(正式)</a></li>
				<li><a href="#">审核(临时线路)</a></li>
			</ul>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-inverse dropdown-toggle btn-sm"data-toggle="dropdown"">作废</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#" id="check">作废(分析)</a></li>
				<li><a href="#">取消作废(分析)</a></li>
				<li><a href="#">作废(正式)</a></li>
				<li><a href="#">取消作废(正式)</a></li>
				<li><a href="#">作废(临时线路)</a></li>
			</ul>
		</div>
		<button type="button" class="btn btn-inverse">刷新</button>
		<button type="button" class="btn btn-inverse" id="find">查询</button>
	</div>

    <table class="table table-striped table-bordered table-hover" id="subprocessTable"></table>  
	
	<div class="modal fade" id="myModal2" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">新增</h4>
				</div>
				<div class="modal-body" style="text-align:right;">
					<form  class="form-inline" role="form">
				    	<div class="row">
							<div class="col-sm-6 ">
								<label>线路类型</label>
								<select id="circuitType" class="form-control" style="width:170px">
									<option>干线</option>
									<option>支线</option>
									<option>省内</option>
									<option>航空</option>
								</select>
							</div>
							<div class="col-sm-6 ">
								<label>线路名称</label>
								<input class="form-control" type="text" id="busLineName">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>线路编码</label>
								<input class="form-control" type="text" id="busLineCode">
							</div>
							<div class="col-sm-6 ">
								<label>开始城市</label>
								<input class="form-control" type="text" id="startCity">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>到达城市</label>
								<input class="form-control" type="text" id="arriveCity">
							</div>
							<div class="col-sm-6 ">
								<label>总里程</label>
								<input class="form-control" type="text" id="countMileage">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>备注</label>
								<input class="form-control" type="text" id="remark">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="subUp" type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal2">确认</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="myModal" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">查询</h4>
				</div>
				<div class="modal-body" style="text-align:right;">
					<form  class="form-inline" role="form">
				    	<div class="row">
							<div class="col-sm-6 ">
								<label>线路类型</label>
								<input class = "form-control" type = "text" id = "circuitType1"/>
							</div>
							<div class="col-sm-6 ">
								<label>线路名称</label>
								<input class="form-control" type="text" id="busLineName1">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>开始城市</label>
								<input class="form-control" type="text" id="startCity1">
							</div>
							<div class="col-sm-6 ">
								<label>到达城市</label>
								<input class="form-control" type="text" id="arriveCity1">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>编码</label>
								<input class="form-control" type="text" id="busLineCode1">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="search" type="button" class="btn btn-warning">查询</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
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
					<h4 class="modal-title">修改</h4>
				</div>
				<div class="modal-body" style="text-align:right;">
					<form  class="form-inline" role="form">
				    	<div class="row">
							<div class="col-sm-6 ">
								<label>线路类型</label>
								<input class = "form-control" type = "text" id = "circuitType2"/>
							</div>
							<div class="col-sm-6 ">
								<label>线路名称</label>
								<input class="form-control" type="text" id="busLineName2">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>开始城市</label>
								<input class="form-control" type="text" id="startCity2">
							</div>
							<div class="col-sm-6 ">
								<label>到达城市</label>
								<input class="form-control" type="text" id="arriveCity2">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>编码</label>
								<input class="form-control" type="text" id="busLineCode2">
							</div>
							<div class="col-sm-6 ">
								<label>总里程</label>
								<input class="form-control" type="text" id="countMileage2">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>备注</label>
								<input class="form-control" type="text" id="remark2">
							</div>
							<div class="col-sm-6 ">
								<label>是否禁用</label>
								<input class="form-control" type="text" id="isUse">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="update" type="button" class="btn btn-warning">修改</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript">
$(function(){  
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});
	var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
	    $('#subprocessTable').bootstrapTable({  
	        method: 'post',  
	        url:"busLine/findAllBusLine",  
	        editable:true,//开启编辑模式  
	        clickToSelect: true,  
	        queryParams : oTableInit.queryParams,
	        sidePagination : "server", 
	        cache: false,  
	        pagination: true,  
	        pageList: [3,5,10,25],  
	        pageSize:10,  
	        pageNumber:1,  
	        uniqueId: 'index', //将index列设为唯一索引  
	        striped: true,  
	        smartDisplay:true,  
	        columns : [{
				checkbox : true
			}, {
				field : 'circuitType',
				title : '线路类型',
			}, {
				field : 'busLineCode',
				title : '班车线路编码',
			}, {
				field : 'busLineName',
				title : '班车线路名称',
			},{
				field : 'startCity',
				title : '发车城市',
			},{
				field : 'arriveCity',
				title : '到达城市',
			} ,{
				field : 'countMileage',
				title : '总里程',
			},{
				field : 'remark',
				title : '备注',
			}] 
	    });  
    };
    oTableInit.queryParams = function(params) {
		var temp = {
			//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
			limit : params.limit, //页面大小 
			offset : params.offset, //页码 
			circuitType : $('#circuitType1').val(),
			busLineCode : $('#busLineCode1').val(),
			busLineName : $('#busLineName1').val(),
			startCity:$('#startCity1').val(),
			arriveCity:$('#arriveCity1').val()
		};
		return temp;
	};
	//得到查询的参数
    return oTableInit;
}

$("#add").click(function(){
	$('#myModal2').modal('show');
});

$("#find").click(function(){
	$('#myModal').modal('show');
});

$("#search").click(function(){
	$("#myModal").modal('hide');
	$('#subprocessTable').bootstrapTable('refresh');
});

//添加
$("#subUp").click(function(){
	var obj = {
			circuitType : $('#circuitType').val(),
			busLineCode : $('#busLineCode').val(),
			busLineName : $('#busLineName').val(),
			countMileage : $('#countMileage').val(),
			startCity:$('#startCity').val(),
			arriveCity:$('#arriveCity').val(),
			remark : $('#remark').val(),
		};
		//异步同步数据库
		$.getJSON("busLine/addBusLine",obj,function(result) {
			if (result.status == "success") {
						toastr.success("添加成功");
						$('#myModal2').modal('hide');
						$('#subprocessTable').bootstrapTable('refresh');
			} else {
					toastr.error("添加失败");
			}
		});
});

//删除
$("#delete").click(function(){
	var select = $('#subprocessTable').bootstrapTable('getSelections');
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
					arrs[i] = select[i]['busLineId'];
				}

				$('#subprocessTable').bootstrapTable('remove', {
					field : 'busLineId',
					values : arrs
				});

				$.ajax({
					url:"busLine/deleteBusLineById",
					type:"post",
					data:{busLineIds:arrs},
					traditional:true,
					success:function(result){
						if(result == "success"){
							toastr.success("删除成功");
							var url={url:'busLine/findAllBusLine'};
							$('#subprocessTable').bootstrapTable('refresh',url);
						}else{
							toastr.error("删除失败");
						}
					}
				});
			}
		});
	}
});

//修改
$("#change").click(function(){
	var select = $('#subprocessTable').bootstrapTable('getSelections');
	if (select.length === 0) {
		toastr.warning("请选择一行");
	} else if(select.length>1){
		toastr.warning("不能同时修改多行");
	}else {
		$('#myModal3').modal('show');
		var obj = select[0];
		var busLineId = obj.busLineId;
		var circuitType = obj.circuitType;
		$("#circuitType2").val(circuitType);
		var busLineName = obj.busLineName;
		$("#busLineName2").val(busLineName);
		var startCity = obj.startCity;
		$("#startCity2").val(startCity);
		var arriveCity = obj.arriveCity;
		$("#arriveCity2").val(arriveCity);
		var busLineCode = obj.busLineCode;
		$("#busLineCode2").val(busLineCode);
		var countMileage = obj.countMileage;
		$("#countMileage2").val(countMileage);
		var remark = obj.remark;
		$("#remark2").val(remark);
		var isUse = obj.isUse;
		$("#isUse").val(isUse);
	}
	$("#update").click(function(){
		var circuitType = $("#circuitType2").val();
		var busLineName = $("#busLineName2").val();
		var startCity = $("#startCity2").val();
		var arriveCity = $("#arriveCity2").val();
		var busLineCode = $("#busLineCode2").val();
		var countMileage = $("#countMileage2").val();
		var remark = $("#remark2").val();
		var isUse = $("#isUse").val();
		$.ajax({
			url:"busLine/updateBusLineById",
			type:"post",
			data:{
				"busLineId":busLineId,
				"circuitType":circuitType,
				"busLineName":busLineName,
				"startCity":startCity,
				"arriveCity":arriveCity,
				"busLineCode":busLineCode,
				"countMileage":countMileage,
				"remark":remark,
				"isUse":isUse
			},	
			traditional:true,
			success:function(result){
				if(result == "success"){
					toastr.success("修改成功");
					$('#myModal3').modal('hide');
					$('#subprocessTable').bootstrapTable('refresh');
				}else{
					toastr.error("修改失败");
				}
			}
		});
	});
})

</script>   

</body>
</html>