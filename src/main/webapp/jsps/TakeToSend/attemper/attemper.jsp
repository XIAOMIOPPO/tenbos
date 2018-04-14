<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>人工调度</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/toastr/toastr.css" rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css" rel="stylesheet">

<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>

<script src="static/jquery.form.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>

<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/jquery.citys.js"></script>
<script type="text/javascript" src="static/jquery.ocupload-1.1.2.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript"
	src="jsps/TakeToSend/attemper/attemper.js"></script>



</head>

<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-heading">
				<a href="#collapse" data-toggle="collapse">查询条件</a>
			</div>
			<div class="panel-body collapse" id="collapse">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<div>
							<label class="control-label col-sm-4" for="search_unit">到达地</label>
							<div class="col-sm-5" style="margin-bottom: 10px;">
								<input type="text" class="form-control" id="search_arriveSite" 
								name="arrivalCity">
							</div>
							<label class="control-label col-sm-4" for="search_unit">取货地址</label>
							<div class="col-sm-5" style="margin-bottom: 10px;">
								<input type="text" class="form-control" id="search_fetchAddress" 
								name="fetchAddress">
							</div>
						</div>
						
						<div class="form-group" style="margin-top: 15px">
							<div class="col-sm-7" style="text-align: left;">
								<button type="button" style="margin-left: 50px;padding: 10px 60px 10px 60px;"
								  id="btn_query" class="btn btn-primary pull-right">查询</button>
							</div>
						</div>
						
					</div>
				</form>
			</div>
		</div>
		
		<div id="toolbar" class="btn-group">
		<shiro:hasPermission name="RGDD:FP">
			<button id="btn_distribution" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>分配
			</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="RGDD:XD">
			<button id="btn_meltSingle" type="button"
				class="btn btn-default btn-danger">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>销单
			</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="RGDD:TH">
			<button id="btn_sendBack" type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>退回
			</button>
		</shiro:hasPermission>
		</div>
		<table id="tb_dispatcher" class="tab tab-hover"></table>
		<hr/>
		
		<ul class="nav nav-tabs">
			<li><a href="#dispatcherAnnals" data-toggle="tab">调度历史</a></li>
		</ul>		
				
		<div id="myTabContent" class="tab-content">
			<div id="dispatcherAnnals" class="tab-pane fade in active">
				<table id="tb_dispatcherAnnals"></table>
			</div>
		</div>
	</div>

	<div class="modal fade" id="distribution" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">分配:地址信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" class="form"
						onsubmit="return check()" role="form">
						<div class="form-group" id="linkage">
							<label for="firstname" class="col-sm-2 control-label">省</label>
							<div class="col-sm-10" style="margin-bottom: 8px;">
								<select class="form-control" id="province" name="province"></select>
							</div>
							<label for="firstname" class="col-sm-2 control-label">城市</label>
							<div class="col-sm-10" style="margin-bottom: 8px;">
								<select class="form-control" id="city" name="city"></select>
							</div>
							<label for="firstname" class="col-sm-2 control-label">区/县</label>
							<div class="col-sm-10">
								<select class="form-control" id="county" name="area"></select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">详细地址</label>
							<div class="col-sm-10">
								<input type="text" id="detailed" class="form-control" placeholder="详细地址">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">分拣编码</label>
							<div class="col-sm-10">
								<input type="text" id="assignCode" class="form-control" placeholder="分拣编码"
								style="background: #e0e0e0;">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="btn_allot" type="button" class="btn btn-warning">下一步</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="distribution2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">分配:员工信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" class="form"
						onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">员工名</label>
							<div class="col-sm-10">
								<select id="empName" name="empName" class="selectpicker show-tick form-control">
									
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="btn_allot2" type="button" class="btn btn-warning">确定</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="externalDistribution" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">分配：合作网络</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" class="form"
						onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">加盟商</label>
							<div class="col-sm-10">
								<select id="franchisee" name="franchisee" class="selectpicker show-tick form-control">
									
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">员工名</label>
							<div class="col-sm-10">
								<select id="jobEmpName" name="jobEmpName" class="selectpicker show-tick form-control">
									
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="btn_allot3" type="button" class="btn btn-warning">确认</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="meltSingle" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">销单</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">备注</label>
							<div class="col-sm-8">
								<textarea rows="6" cols="40" placeholder="请输入原因"
								id="cause"></textarea>
							</div>
							
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="btn_destroy" type="button" class="btn btn-warning">确定</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="sendBack" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">退回</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">原因</label>
							<div class="col-sm-10">
								<textarea rows="8" cols="40" placeholder="请输入原因"
								id="returnCauseDispatcher"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="btn_returnCause" type="button" class="btn btn-warning">确定</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
