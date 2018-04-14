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

<title>大巴线路</title>

<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.css">
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
	
<script src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>		
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>

</head>
<body>
	<div id="toolbar" class="btn-group">
		<button id="add" type="button" class="btn btn-inverse">增加</button>
		<button type="button" class="btn btn-inverse">修改</button>
		<button type="button" class="btn btn-inverse">删除</button>
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
		<button type="button" class="btn btn-inverse">查询</button>
	</div>

    <table class="table table-striped table-bordered table-hover" id="subprocessTable"></table>  
    
    
    <div class="modal fade" id="myModal2" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:95%">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">寄件地址</h4>
				</div>
				<div class="col-sm-12" style="text-align:right">
					<form class="form-inline" role="form">
				    	<div class="row">
							<div class="col-sm-3 ">
								<label>大巴线路编码</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>起始城市</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>起始汽车站</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>出港运转中心</label>
								<input class="form-control" type="text">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-3 ">
								<label>出港批次</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>班次</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>发时</label>
								<input class="form-control" id="startTime" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>到时</label>
 								<input class="form-control" id = "endTime" type="text">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-3 ">
								<label>途经天数</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>进港批次</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>进港运转中心</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>到达城市</label>
								<input class="form-control" type="text">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-3 ">
								<label>到达汽车站</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>中转批次</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>中转运转中心</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>摆渡中转批次</label>
								<input class="form-control" type="text">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-3 ">
								<label>摆渡中转运转中心</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>合作对象</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>承载实际重量</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>承载体积重量</label>
								<input class="form-control" type="text">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-3 ">
								<label>成本单价</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>报价单位</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>单价</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>最低收费</label>
								<input class="form-control" type="text">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-3 ">
								<label>操作费</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>是否有合同</label>
								<select id="isContract" class="form-control" style="width:170px">
									<option>是</option>
									<option>否</option>
								</select>
							</div>
							<div class="col-sm-3 ">
								<label>合作起始日期</label>
								<input class="form-control" type="text" id = "contractStart">
							</div>
							<div class="col-sm-3 ">
								<label>合作终止日期</label>
								<input class="form-control" type="text" id = "contractEnd">
							</div>
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-3 ">
								<label>交货提前时间</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>交货时间点</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>提货延迟时间</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>提货时间点</label>
								<input class="form-control" type="text">
							</div>
							
						</div>
						<div>&nbsp;</div>
						<div class="row">
							<div class="col-sm-3 ">
								<label>备注</label>
								<input class="form-control" type="text">
							</div>
							<div class="col-sm-3 ">
								<label>班期</label>
								<input class="form-control" type="text">
							</div>
						</div>
					</form>
					
				</div>
				<div class="row modal-footer">
					<button style="float:right;margin:10px 5px 5px 5px;" type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
					<button style="float:right;margin:10px 5px 5px 5px;" id="subUp" type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal2">确认</button>
					
				</div>
				
			</div>
		</div>
	</div>
	
<script type="text/javascript">
$(function(){  
	 //时间插件
	 $("#startTime").datetimepicker({
		format : "yyyy-mm-dd",
		autoclose : true,
		todayBtn : true,
		language : 'zh-CN',
		pickerPosition : "bottom-left",
		minView : 2,
		startDate : '2017-01-01',
		minDate:'1970-01-01',
		endDate:new Date() 
	   });
	 
	 $("#endTime").datetimepicker({
			format : "yyyy-mm-dd",
			autoclose : true,
			todayBtn : true,
			language : 'zh-CN',
			pickerPosition : "bottom-left",
			minView : 2,
			startDate : '2017-01-01',
			minDate:'1970-01-01',
			endDate:new Date() 
	 });
	 
	 $("#contractStart").datetimepicker({
			format : "yyyy-mm-dd",
			autoclose : true,
			todayBtn : true,
			language : 'zh-CN',
			pickerPosition : "bottom-left",
			minView : 2,
			startDate : '2017-01-01',
			minDate:'1970-01-01',
			endDate:new Date() 
	 });
	 
	 $("#contractEnd").datetimepicker({
			format : "yyyy-mm-dd",
			autoclose : true,
			todayBtn : true,
			language : 'zh-CN',
			pickerPosition : "bottom-left",
			minView : 2,
			startDate : '2017-01-01',
			minDate:'1970-01-01',
			endDate:new Date() 
	 });
	 
    //初始化表格  
    $('#subprocessTable').bootstrapTable({  
        method: 'get',  
        url:"",  
        editable:true,//开启编辑模式  
        clickToSelect: true,  
        cache: false,  
        pagination: true,  
        pageList: [10,25,50,100],  
        pageSize:10,  
        pageNumber:1,  
        uniqueId: 'index', //将index列设为唯一索引  
        striped: true,  
        smartDisplay:true,  
        columns : [{
			field : 'partitionId',
			title : '大巴线路编码',
			edit:{  
			    type:'input',//下拉框  
			    valueField:'id',  
			    textField:'text'
			}
		}, {
			field : 'province',
			title : '起始城市',
		}, {
			field : 'county',
			title : '起始汽车站',
		}, {
			field : 'property',
			title : '出港运转中心',
		}, {
			field : 'a',
			title : '出港批次',
		}, {
			field : 'b',
			title : '班次',
		}, {
			field : 'c',
			title : '发时',
		}, {
			field : 'd',
			title : '到时',
		}, {
			field : 'e',
			title : '途径天数',
		}, {
			field : 'f',
			title : '进港批次',
		}, {
			field : 'g',
			title : '进港运转中心',
		}, {
			field : 'b',
			title : '到达城市',
		}, {
			field : 'c',
			title : '到达汽车站',
		}, {
			field : 'province',
			title : '中转批次',
		}, {
			field : 'county',
			title : '中转运转中心',
		}, {
			field : 'property',
			title : '摆渡中转批次',
		}, {
			field : 'a',
			title : '摆渡中转运转中心',
		}, {
			field : 'b',
			title : '合作对象',
		}, {
			field : 'c',
			title : '承载实际重量',
		}, {
			field : 'd',
			title : '承载体积重量',
		}, {
			field : 'e',
			title : '成本单价',
		}, {
			field : 'f',
			title : '报价单位',
		}, {
			field : 'g',
			title : '单价',
		}, {
			field : 'b',
			title : '最低收费',
		}, {
			field : 'c',
			title : '操作费',
		}, {
			field : 'c',
			title : '是否有合同',
		}, {
			field : 'd',
			title : '合作起始日期',
		}, {
			field : 'e',
			title : '合作终止日期',
		}, {
			field : 'f',
			title : '交货提前时间',
		}, {
			field : 'g',
			title : '交货时间点',
		}, {
			field : 'b',
			title : '提货延迟时间',
		}, {
			field : 'c',
			title : '提货时间点',
		}, {
			field : 'b',
			title : '备注',
		}, {
			field : 'c',
			title : '班期',
		}] 
    });  
});

$("#add").click(function(){
	$('#myModal2').modal('show');
	$("#sub").click(function(){
		$("#myModal3").hidden();
	});
});
</script>   

</body>
</html>