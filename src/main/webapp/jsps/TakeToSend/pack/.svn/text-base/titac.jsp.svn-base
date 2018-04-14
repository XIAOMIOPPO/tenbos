<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<link rel="stylesheet" href="static/select/bootstrap-select.css">
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">
<link rel="stylesheet" href="static/toastr/toastr.css">
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/select/bootstrap-select.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>
<style type="text/css">
#center {
margin:0 auto;
padding-bottom:0px;
width:1100px
}
</style>
</head>

<body>
	<div  class="panel-body" id="center">
		<div class="panel panel-default">
			<form id="formSearch" class="form-horizontal">
				<div class="panel-body">
					<div id="top" class="form-group">
						<div class="col-sm-4" style="padding-left:30px;">
							<img src="jsps/images/BigLogo.jpg" class="img-circle">
						</div>
						<div class="col-sm-5" style="font:normal bold 24px 宋体;padding-left:30px;margin:80px 0 0 0;">包装信息打印</div>
						<div class="col-sm-3" style="padding-left:8%">
							<img src="load/code?width=200&height=100&msg=000000000012" class="img-thumbnail">
						</div>
					</div>
					<div id="neck" class="form-group">
						<div class="col-sm-11">
							<span>工作单号:${sessionScope.gen.workSheetNo}</span>
						</div>
					</div>
					<div class="form-group" style="padding:0 20px 0 20px">
						<table class="table table-bordered">
							<tr>
								<th class="col-sm-2">件数:</th>
								<td class="col-sm-4">${sessionScope.gen.rule.productAmount}</td>
								<th class="col-sm-2">重量:</th>
								<td class="col-sm-4">${sessionScope.gen.rule.actualWeight}</td>
							</tr>
							<tr>
								<tr>
								<th class="col-sm-1">发货人地址:</th>
								<td class="col-sm-5">${sessionScope.gen.sender.senderAddress}</td>
								<th class="col-sm-1">发货方式:</th>
								<td class="col-sm-5">${sessionScope.gen.rule.processingMethod}</td>
							</tr>
							<tr>
								<th class="col-sm-1">收货人地址:</th>
								<td class="col-sm-5">${sessionScope.gen.addresses.addressesAddress}</td>
								<th class="col-sm-1">寄件人联系电话:</th>
								<td class="col-sm-5">${sessionScope.gen.sender.senderPhone}</td>
							</tr>
							<tr>
								<th>时间:</th>
								<td colspan="7">${sessionScope.gen.rule.serviceTimeLimit}</td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
