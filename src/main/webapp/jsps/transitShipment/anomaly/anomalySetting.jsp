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
<title>异常设置</title>

<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/toastr/toastr.css" rel="stylesheet">
<link
	href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="static/jqueryCsxz/zyzn_1.css" rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.css"
	rel="stylesheet">
<link href="static/select2/select2.min.css" rel="stylesheet">
<link href="jsps/transitShipment/anomaly/css/anomalySetting.css" rel="stylesheet">


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

<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/edit/bootstrap-table-editable.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/distpicker.data.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/distpicker.js"></script>
<script type="text/javascript" src="static/select2/select2.min.js"></script>
</head>
<body class="default">
	<div id="anomalyBtn" class="btn-group">
		<button type="button" class="btn btn-info" id="entry"
			data-toggle="modal">
			<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>录入
		</button>
		<button type="button" class="btn btn-warning" id="alterOrder">
			<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>修改
		</button>
		<button type="button" class="btn btn-danger" id="destroyAnomaly">
			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>作废
		</button>
	</div>
	<table id="tab_receptionConsult"></table>



<div class="modal fade" id="entryModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">录入异常设置</h4>
            </div>
            <div class="modal-body">
				<table class="table table-striped">
					<tr>
						<td>
							<label for="name" class="labelFont">异常类型</label>
							<select id="exceptionType" class="form-control">
								
							</select>					
						</td>
						<td>
							<label for="name" class="labelFont">异常项目</label>
							<input type="text" class="form-control" id="exceptionItem">
						</td>
					</tr>
					<tr>
						<td>
							<label for="name" class="labelFont">接收单位类型</label>
							<select class="form-control" id="takeInOrgType">
								<option value="受理单位">受理单位</option>
								<option value="上一环节单位">上一环节单位</option>
							</select>
						</td>
						<td>
							<label for="name" class="labelFont">可否运输</label>
							<select class="form-control" id="carriageTo">
								<option value="否">可以</option>
								<option value="否">不可以</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<label for="name" class="labelFont">需要处理</label>
							<select class="form-control" id="disposeTo">
								<option value="是">需要</option>
								<option value="否">不需要</option>
							</select>
						</td>
						<td>
							<label for="name" class="labelFont">自动标识</label>
							<select class="form-control" id="automaticMarker">
								<option value="是">自动</option>
								<option value="否">不自动</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<label for="name" class="labelFont">异常备注</label>
							<textarea rows="3" cols="60" id="anomalyDesc"></textarea>
						</td>
					</tr>
				</table>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                <button type="button" class="btn btn-primary" id="addAnomalyBtn">保存</button>
	            </div>
				
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>












	<script type="text/javascript"
		src="jsps/transitShipment/anomaly/js/anomalySetting.js"></script>
</body>
</html>