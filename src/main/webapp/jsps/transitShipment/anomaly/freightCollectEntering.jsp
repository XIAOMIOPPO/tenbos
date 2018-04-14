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
<title>到付代收变更录入</title>
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
<body>
<!--按钮区-->
<div>
	<div id="toolbars" class="btn-group">
		<button id="btn_save" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>保存
		</button>
		<button id="btn_sendee" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-retweet" aria-hidden="true"></span>&nbsp;接收
		</button>
		<button id="btn_update" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>修改
		</button>
		<button id="btn_delete" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-retweet" aria-hidden="true"></span>&nbsp;删除
		</button>
	</div>
	<table id="tb_departments"></table>
</div>
	
<!--保存到付代收变更录入-->
	<div class="modal fade" id="myModal_save" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:900px;">
			<div class="modal-content">
			<form class="form-horizontal" id="save_form" onsubmit="return check()" role="form">	
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-
						hidden="true">&times;</button>
					
					<div class="panel panel-success">
						<div class="panel-heading">
							<h3 class="panel-title">保存</h3>
						</div>
					
						<div class="panel-body">
							<div class="container">
								<div class="row" >
									 <div class="col-xs-10 col-sm-10" >
									 	<div class="col-md-4">
									 		<label for="firstname" class="control-label">工作单号</label>
									 		<input type="text" class="form-control" id="txt_save_jobListNo"  name="jobListNo">
									 	</div>
									 	<div class="col-md-4">
									 		<label for="lastname" class="control-label">当前操作人单位</label>
									 		 <input type="text" class="form-control" id="txt_save_enteringUnit" disabled="">
									 	</div>
									 	<div class="col-md-4">
									 		<label for="lastname" class="control-label">委托单位</label>
								     		<input type="text" class="form-control" id="txt_save_senderUnit" name = "txtCreateAddressee" disabled="">
									 	</div>
									 </div>
									 
									 
									 <div class="col-xs-10 col-sm-10" >
									 	<div class="col-md-4">
									 		<label for="lastname" class="control-label">原到付款</label>
									 		<input type="text" class="form-control" id="txt_save_cameCollect" disabled="">
									 	</div>
									 	<div class="col-md-4">
									 		<label for="lastname" class="control-label ">原代收款</label>
									 		<input type="text" class="form-control" id="txt_save_agencyFund" name = "txtCreateFactWeight" disabled="">
									 	</div>
									 	<div class="col-md-4">
									 		<label for="lastname" class="control-label">品名</label>
									 		<input type="text" class="form-control" id="txt_save_productName" name="txtCreateSize" disabled="">
									 	</div>
									 </div>
									 
									 
									 <div class="col-xs-10 col-sm-10" >
									 	<div class="col-md-4">
									 		<label for="lastname" class="control-label">收货人</label>
									 		<input type="text" class="form-control" id="txt_save_addressee" name = "txtCreateAddressee" disabled="">
									 	</div>
									 	<div class="col-md-4">
									 		<label for="lastname" class="control-label">变更到付款</label>
									 		<input type="text" class="form-control" id="txt_save_changeCameCollect" name="changeCameCollect">
									 	</div>
									 	<div class="col-md-4">
									 		<label for="lastname" class="control-label">变更代收款</label>
									 		<input type="text" class="form-control" id="txt_save_changeAgencyFund" name="changeAgencyFund">
									 	</div>
									 </div>
									 
									 <div class="col-xs-10 col-sm-10" >
									 	<div class="col-md-8">
									 		<label for="lastname" class="control-label">变更原因</label>
									 		<input type="text" class="form-control" id="txt_save_changeCause" name="changeCause">
									 	</div>
									 </div>
								</div>
							</div>		
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="btn_submit_saveChangeEntering">提交</button>
					<button type="button" class="btn btn-default4" data-dismiss="modal">关闭</button>
				</div>
				
				</form>
			</div>
		</div>
	</div>	
	
	
	
<script type="text/javascript" src="jsps/transitShipment/anomaly/js/freightCollectEntering.js"></script>	
</body>
</html>