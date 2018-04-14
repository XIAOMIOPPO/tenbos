<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/edit/bootstrap-editable.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">

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
</head>
<body>
    <div id="toolbar" class="btn-group">
		<button id="add" type="button" class="btn btn-inverse">增加</button>
	</div>

    <table class="table table-striped table-bordered table-hover" id="subprocessTable"></table> 
    <table class="table table-striped table-bordered table-hover" id="subprocessTable1"></table> 
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
    			title : '城市',
    			width:'250px',
    			edit:{  
    			    type:'input',//下拉框  
    			    valueField:'id',  
    			    textField:'text'
    			}
    		}, {
    			field : 'province',
    			title : '编码',
    			width:'250px'
    		}, {
    			field : 'county',
    			title : '名称',
    			width:'250px'
    		}, {
    			field : 'property',
    			title : '地址',
    			width:'250px'
    		} ] 
        });
    </script>
</body>
</html>