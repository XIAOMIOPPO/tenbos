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

<title>资源异常录入</title>

<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.css">
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">

<script src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>		
</head>
<body>
	<div id="toolbar" class="btn-group">
		<button id="add" type="button" class="btn btn-inverse">增加</button>
		<button type="button" class="btn btn-inverse">修改</button>
		<button type="button" class="btn btn-inverse">删除</button>
		<button type="button" class="btn btn-inverse">作废</button>
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
		<button type="button" class="btn btn-inverse">查询</button>
	</div>

    <table class="table table-striped table-bordered table-hover" id="subprocessTable"></table>  
<script type="text/javascript">
$(function(){  
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
			title : '线路资源',
			width:'250px',
			edit:{  
			    type:'input',//下拉框  
			    valueField:'id',  
			    textField:'text'
			}
		}, {
			field : 'province',
			title : '异常原因',
			width:'250px'
		}, {
			field : 'county',
			title : '开始日期',
			width:'250px'
		}, {
			field : 'property',
			title : '结束日期',
			width:'250px'
		}, {
			field : 'property',
			title : '备注',
			width:'250px'
		} ] 
    });  
  
    /** 
     * add a new row 
     */  
    $('#addData').click(function(){  
        $('#subprocessTable').bootstrapTable('selectPage', 1); //Jump to the first page  
        var data = {partitionId: '', province: '',county:'', property: ''}; //define a new row data，certainly it's empty  
  
        $('#subprocessTable').bootstrapTable('prepend', data); //the method of prepend must defined all fields，but append needn't  
  
        	$("#dataTable tr:eq(1) td:eq(0)").trigger("dblclick");  
        	$("#subprocessTable tr:eq(1) td:eq(0)").append("<input type='text' class='form-control'>");
        	$("#subprocessTable tr:eq(1) td:eq(1)").append("<input type='text' class='form-control'>");
        	$("#subprocessTable tr:eq(1) td:eq(2)").append("<input type='text' class='form-control'>");
        	$("#subprocessTable tr:eq(1) td:eq(3)").append("<input type='text' class='form-control'>");
            $("#subprocessTable input:eq(0)").focus(); 
        	
    });  
    
    $("#add").click(function(){
    	$("#subprocessTable tr:eq(1) td:eq(0)").html($("#subprocessTable tr:eq(1) td:eq(0) input").val());
    	$("#subprocessTable tr:eq(1) td:eq(1)").html($("#subprocessTable tr:eq(1) td:eq(1) input").val());
    	$("#subprocessTable tr:eq(1) td:eq(2)").html($("#subprocessTable tr:eq(1) td:eq(2) input").val());
    	$("#subprocessTable tr:eq(1) td:eq(3)").html($("#subprocessTable tr:eq(1) td:eq(3) input").val());
    	$("input").remove();
    	
    })
});
</script>   

</body>
</html>