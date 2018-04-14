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
<title>异常录入</title>

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
<link href="static/select2/select2.min.css" rel="stylesheet">


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
<script type="text/javascript" src="static/select2/select2.min.js"></script>

</head>
<body class="default">

	
	<div id="anomalyBtn" class="btn-group">
		<button type="button" class="btn btn-success" id="additionExceptionBtn"
			data-toggle="modal">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>保存
		</button>
		<button type="button" class="btn btn-info" id="reflshBtn">
			<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
		</button>
		<button type="button" class="btn btn-primary" id="destroyOrder">
			<span class="glyphicon glyphicon-print" aria-hidden="true"></span>打印
		</button>
		<button type="button" class="btn btn-warning" id="return">
			<span class="glyphicon glyphicon-share" aria-hidden="true"></span>返回
		</button>		
	</div>


<div class="panel-group" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" 
                href="#collapseOne">
                待处理数据
                </a>
            </h4>
        </div>
        <div id="collapseOne" class="panel-collapse collapse in">
            <div class="panel-body">
            	<div class="container">
	            	<div class="row">
						<div class="col-xs-9 col-sm-9"> 
		            		<div class="col-xs-3">
			            		<select class="form-control">
			            			<option value="工作单条码号">工作单条码号</option>
			            			<option value="交接单号">交接单号</option>
			            			<option value="合包号">合包号</option>
			            		</select>
		            		</div>
		            		<div class="col-xs-3">
		            			<input type="text" class="form-control" id="selectInput">
		            		</div>
		            		<div class="col-xs-3">
								<button type="button" class="btn btn-default" id="selectAnomaly">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
								</button>	
		            		</div>
						</div>
	            	</div>
            	</div>
				<table id="tab_receptionConsult"></table>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" 
                href="#collapseTwo">
                异常信息
            </a>
            </h4>
        </div>
        <div id="collapseTwo" class="panel-collapse collapse">
        <div class="panel-body">
            	<div class="container">
	            	<div class="row">
						<div class="col-xs-12 col-sm-12"> 
		            		<div class="col-xs-6">
			            		<label for="name" class="labelFont">异常编码</label>
			            		<select class="form-control" id="exceptionNo">

			            		</select>
		            		</div>
		            		<div class="col-xs-6">
		            			<label for="name" class="labelFont">异常类型</label>
		            			<select class="form-control" id="exceptionType">

								</select>
		            		</div>
						</div>
						
						<div class="col-xs-12 col-sm-12"> 
		            		<div class="col-xs-6">
		            			<label for="name" class="labelFont">异常项目</label>
								<input type="text" class="form-control" id="exceptionItem">
		            		</div>
		            		<div class="col-xs-6">
		            			<label for="name" class="labelFont">实际到港时间</label>
		            			<input type="text" class="form-control" id="Relaytimes" data-date-format="yyyy-mm-dd hh:mm:ss" readonly>
		            		</div>
						</div>
						
						<div class="col-xs-12 col-sm-12"> 
		            		<div class="col-xs-6">
		            			<label for="name" class="labelFont">可否运输</label>
		            			<select class="form-control" id="carriageTo">
									<option value="可以">可以</option>
									<option value="不可以">不可以</option>
								</select>
							</div>
							<div class="col-xs-6">
			            		<label for="name" class="labelFont">是否处理</label>
			            		<select class="form-control" id="disposeTo">
									<option value="处理">处理</option>
									<option value="不处理">不处理</option>
								</select>
		            		</div>

						</div>
						
						<div class="col-xs-12 col-sm-12"> 
		            		<div class="col-xs-9">
		            			<label for="name" class="labelFont">意见备注</label>
		            			<input type="text" class="form-control" id="remarks">
		            		</div>
						</div>
	            	</div>
            	</div>
        </div>
        </div>
    </div>
</div>

	<script type="text/javascript" src="jsps/transitShipment/anomaly/js/anomalyEntering.js"></script>	
</body>
</html>