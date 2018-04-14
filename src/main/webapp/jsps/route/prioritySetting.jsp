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
<title>资源优先级设置</title>

<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="static/select/select2.min.css" rel="stylesheet" type="text/css">
<link href="static/toastr/toastr.css" rel="stylesheet" type="text/css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">

<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/select/select2.full.js"></script>
<script type="text/javascript" src="static/select/select2.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>

<script type="text/javascript">
$(function() {
	//1.初始化Table 
	var oTable = new TableInit();
	oTable.Init();
	//2.初始化Button的点击事件 
	
});
var TableInit = function() {
	var oTableInit = new Object();
	//初始化Table 
	oTableInit.Init = function() {
		//直达
		$('#priority').bootstrapTable({
			url : '', //请求后台的URL（*） 
			method : 'post', //请求方式（*） 
			striped : true, //是否显示行间隔色 
			pagination : true, //是否显示分页（*） 
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
			pageNumber : 1, //初始化加载第一页，默认第一页 
			pageSize : 5, //每页的记录行数（*） 
			pageList : [ 10, 20, 50 ], //可供选择的每页的行数（*） 
			clickToSelect : true, //是否启用点击选中行 
			uniqueId : "deliverId", //每一行的唯一标识，一般为主键列 
			columns : [{
				field : 'deliverName',
			}]
		});
		
		//中转
		$('#prioritySetting').bootstrapTable({
			url : '', //请求后台的URL（*） 
			method : 'post', //请求方式（*） 
			striped : true, //是否显示行间隔色 
			pagination : true, //是否显示分页（*） 
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
			pageNumber : 1, //初始化加载第一页，默认第一页 
			pageSize : 5, //每页的记录行数（*） 
			pageList : [ 10, 20, 50 ], //可供选择的每页的行数（*） 
			clickToSelect : true, //是否启用点击选中行 
			uniqueId : "deliverId", //每一行的唯一标识，一般为主键列 
			columns : [{
				field : 'deliverName',
			} ]
		});
	};
	return oTableInit;
};

</script>
</head>
<body>
	<div id="toolbar" class="btn-group">
		<button id="btn_add" class="btn btn-success" data-toggle="modal" data-target="#myModal">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>设置优先级
		</button>
		<button id="btn_save" type="button" class="btn btn-info">
			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>保存
		</button>
		<button id="btn_delete" type="button" class="btn btn-danger">
			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>取消
		</button>
		<button id="btn_globe" type="button" class="btn  btn-primary">
			<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>同步
		</button>
	</div>
	
	<div class="col-xs-12 col-sm-12">
		<form role="form">
			<div class="form-group sershIn">
				<div class="col-sm-5">
					<div class="input-group">
			            <span class="input-group-addon">发送城市</span>
			            <input class="form-control" type="text">
			            <span class="input-group-addon">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			            </span>
			        </div>
				</div>
				
				<div class="col-sm-1"></div>
				
				<div class="col-sm-5">
					<div class="input-group">
			            <span class="input-group-addon">到达城市</span>
			            <input class="form-control" type="text">
			            <span class="input-group-addon">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			            </span>
			        </div>
				</div>
				
				<div class="col-sm-1"></div>	
			</div>
		</form>
	</div>
	
	<div class="col-xs-12 col-sm-12">
		<form role="form">
			<div class="form-group sershIn">
				<div class="col-sm-5">
					<div class="input-group">
			            <span class="input-group-addon">直达</span>
			        </div>
			        <table id="priority"></table>
				</div>
				
				<div class="col-sm-1">
					<div>&nbsp;</div>
					<button id="btn_save" type="button" class="btn btn-gray">
						<span class="glyphicon glyphicon-open" aria-hidden="true"></span>
					</button>
					<div>&nbsp;</div>
					<button id="btn_save" type="button" class="btn btn-gray">
						<span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>
					</button>
					<div>&nbsp;</div>
					<button id="btn_save" type="button" class="btn btn-gray">
						<span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>
					</button>
					<div>&nbsp;</div>
					<button id="btn_save" type="button" class="btn btn-gray">
						<span class="glyphicon glyphicon-save" aria-hidden="true"></span>
					</button>
				</div>
				
				<div class="col-sm-5">
					<div class="input-group">
			            <span class="input-group-addon">中转</span>
			        </div>
			        <table id="prioritySetting"></table>
				</div>
				
				<div class="col-sm-1">
					<div>&nbsp;</div>
					<button id="btn_save" type="button" class="btn btn-gray">
						<span class="glyphicon glyphicon-open" aria-hidden="true"></span>
					</button>
					<div>&nbsp;</div>
					<button id="btn_save" type="button" class="btn btn-gray">
						<span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>
					</button>
					<div>&nbsp;</div>
					<button id="btn_save" type="button" class="btn btn-gray">
						<span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>
					</button>
					<div>&nbsp;</div>
					<button id="btn_save" type="button" class="btn btn-gray">
						<span class="glyphicon glyphicon-save" aria-hidden="true"></span>
					</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>