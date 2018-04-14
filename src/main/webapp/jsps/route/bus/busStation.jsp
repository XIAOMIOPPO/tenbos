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

<title>汽车站</title>

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
		<button type="button" class="btn btn-inverse" id="update">修改</button>
		<button type="button" class="btn btn-inverse" id="delete">删除</button>
		<div class="btn-group">
			<button type="button" class="btn btn-inverse dropdown-toggle btn-sm"data-toggle="dropdown">行操作</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#" id="addData">增行</a></li>
				<li><a href="#">删行</a></li>
			</ul>
		</div>
		<button type="button" class="btn btn-inverse">保存</button>
		<button type="button" class="btn btn-inverse">取消</button>
		<button type="button" class="btn btn-inverse">刷新</button>
		<button type="button" class="btn btn-inverse" id="search">查询</button>
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
								<label>城市</label>
								<input class="form-control" type="text" id="city">
							</div>
							<div class="col-sm-6 ">
								<label>备注</label>
								<input class="form-control" type="text" id="remark">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>汽车站名</label>
								<input class="form-control" type="text" id="busStationName">
							</div>
							<div class="col-sm-6 ">
								<label>地址</label>
								<input class="form-control" type="text" id="address">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>联系电话</label>
								<input class="form-control" type="text" id="contactNumber">
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
	
	<div class="modal fade" id="myModal3" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<label class="modal-title">修改</label>
				</div>
				<div class="modal-body" style="text-align:right;">
					<form  class="form-inline" role="form">
				    	<div class="row">
							<div class="col-sm-6 ">
								<label>城市</label>
								<input class="form-control" type="text" id="city1">
							</div>
							<div class="col-sm-6 ">
								<label>汽车站名</label>
								<input class="form-control" type="text" id="busStationName1">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>地址</label>
								<input class="form-control" type="text" id="address1">
							</div>
							<div class="col-sm-6 ">
								<label>联系电话</label>
								<input class="form-control" type="text" id="contactNumber1">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>备注</label>
								<input class="form-control" type="text" id="remark1">
							</div>
							<div class="col-sm-6 ">
								<label>是否禁用</label>
								<select id="isUse" class="form-control" style="width:170px">
									<option value="1">是</option>
									<option value="0">否</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="subUpdate" type="button" class="btn btn-warning">修改</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="myModal4" role="dialog"
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
								<label>城市</label>
								<input class="form-control" type="text" id="city4">
							</div>
							<div class="col-sm-6 ">
								<label>编码</label>
								<input class="form-control" type="text" id="code4">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-6 ">
								<label>汽车站名</label>
								<input class="form-control" type="text" id="busStationName4">
							</div>
							<div class="col-sm-6 ">
								<label>地址</label>
								<input class="form-control" type="text" id="address4">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="sear" type="button" class="btn btn-warning">查找</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
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
            url:'busStation/findAllBusStation', //请求后台的URL（*） 
			method : 'post', //请求方式（*） 
			striped : true, //是否显示行间隔色 
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
			pagination : true, //是否显示分页（*） 
			sortable : false, //是否启用排序 
			sortOrder : "asc", //排序方式
			queryParams : oTableInit.queryParams,//传递参数（*） 
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
			pageNumber : 1, //初始化加载第一页，默认第一页 
			pageSize : 20, //每页的记录行数（*） 
			pageList : [ 3, 5, 10, 20 ], //可供选择的每页的行数（*） 
			minimumCountColumns : 1, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行 
			uniqueId : "city", //每一行的唯一标识，一般为主键列 
			columns : [ {
				checkbox : true
			}, {
				field : 'city',
				title : '城市',
			},{
				field : 'busStationName',
				title : '汽车站名',
			},{
				field:'contactNumber',
				title:'联系电话'
			},{
				field:'remark',
				title:'备注'
			}]
		});
    };

    oTableInit.queryParams = function(params) {
		var temp = {
			//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
			limit : params.limit, //页面大小 
			offset : params.offset, //页码 
			city : $("#city4").val(),
			code : $("#code4").val(),
			busStationName : $("#busStationName4").val(),
			address : $("#address4").val()
		};
		return temp;
	};
    //得到查询的参数
    return oTableInit;
};


//模态框
$("#add").click(function(){
	$('#myModal2').modal('show');
});

//添加
$("#subUp").click(function() {
	var obj = {
		city : $('#city').val(),
		busStationName : $('#busStationName').val(),
		address : $('#address').val(),
		contactNumber : $('#contactNumber').val(),
		remark : $('#remark').val(),
	};
	//异步同步数据库
	$.getJSON("busStation/addBusStation",obj,function(result) {
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
$("#delete").click(function() {
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
						arrs[i] = select[i]['busStationId'];
					}

					$('#subprocessTable').bootstrapTable('remove', {
						field : 'busStationId',
						values : arrs
					});

					$.ajax({
						url:"busStation/deleteBusStationById",
						type:"post",
						data:{busStationIds:arrs},
						traditional:true,
						success:function(result){
							if(result == "success"){
								toastr.success("删除成功");
								var url={url:'busStation/findAllBusStation'};
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
$("#update").click(function() {
	var select = $('#subprocessTable').bootstrapTable('getSelections');
		if (select.length === 0) {
			toastr.warning("请选择一行");
		} else if(select.length>1){
			toastr.warning("不能同时修改多行");
		}else {
			$('#myModal3').modal('show');
			var obj = select[0];
			var busStationId = obj.busStationId;
			var city = obj.city;
			$("#city1").val(city);
			var busStationName = obj.busStationName;
			$("#busStationName1").val(busStationName);
			var address = obj.address;
			$("#address1").val(address);
			var contactNumber = obj.contactNumber;
			$("#contactNumber1").val(contactNumber);
			var remark = obj.remark;
			$("#remark1").val(remark);
			var isUse = obj.isUse;
			$("#isUse").val(isUse);
		}
		$("#subUpdate").click(function(){
			var city = $("#city1").val();
			var busStationName = $("#busStationName1").val();
			var address = $("#address1").val();
			var contactNumber = $("#contactNumber1").val();
			var remark = $("#remark1").val();
			var isUse = $("#isUse").val();
			$.ajax({
				url:"busStation/updateBusStationById",
				type:"post",
				data:{
					"busStationId":busStationId,
					"city":city,
					"busStationName":busStationName,
					"address":address,
					"contactNumber":contactNumber,
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
});

$("#search").click(function(){
	$("#myModal4").modal('show');
})

$("#sear").click(function(){
	$("#myModal4").modal('hiden');
	$('#subprocessTable').bootstrapTable('refresh');
})


</script>   

</body>
</html>