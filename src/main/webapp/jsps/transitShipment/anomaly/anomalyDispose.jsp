<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常处理</title>
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/toastr/toastr.css" rel="stylesheet">
<link
	href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="static/jqueryCsxz/zyzn_1.css" rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.css"rel="stylesheet">

<script src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>

<script type="text/javascript" src="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/edit/bootstrap-table-editable.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/distpicker.data.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/distpicker.js"></script>


</head>
<body class="default">
				<div id="anomalyBtn" class="btn-group">
					<button type="button" class="btn btn-info"
						id="superadditionOrder" data-toggle="modal">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
					</button>
					<button type="button" class="btn btn-warning" id="alterOrder">
						<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>处理
					</button>
					<button type="button" class="btn btn-success" id="destroyOrder">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>确认
					</button>
				</div>
				<table id="tab_receptionConsult"></table>


<div>
<div class="modal fade" id="myModal12" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">处理异常</h4>
            </div>
            <div class="modal-body">
            	<input type="hidden" id="exceptionSelectId1" value="">
            	<select id="resultDisTo" class="form-control">
            		<option value="可以运输">可以运输</option>
            		<option value="不可以运输">不可以运输</option>
            	</select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="updateDisposeBtn">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>



<div class="modal fade" id="myModal14" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">异常确认</h4>
            </div>
            <div class="modal-body">
            	<input type="hidden" id="exceptionSelectId2" value="">
            	<select id="affirmFruitSe" class="form-control">
            		<option value="同意">同意</option>
            		<option value="不同意">不同意</option>
            	</select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="updateNotarizeBtn">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>



</div>











	
<script type="text/javascript" src="jsps/transitShipment/anomaly/js/anomalyDispose.js"></script>	
</body>
</html>