<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

<title>print</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="static/select/bootstrap-select.css">
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">

<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>
<script type="text/javascript" src="static/select/bootstrap-select.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<style type="text/css">
#center {
margin:0 auto;
padding-bottom:0px;
width:800px
}
</style>

</head>
<body>
	<div  class="panel-body" id="center">
		<div class="panel panel-default">
			<form id="formSearch" class="form-horizontal">
				<div class="panel-body">
					<div id="top" class="form-group">
						<div class="col-sm-3" style="padding-left:30px;">
							<img src="jsps/images/BigLogo.jpg" class="img-circle">
						</div>
						<div class="col-sm-5" style="font:normal bold 24px 宋体;padding-left:30px;margin:80px 0 0 0;">tenbos返货单打印</div>
						<div class="col-sm-4" style="padding-left:8%">
							<img src="jsps/images/generP.jpg" class="img-thumbnail">
						</div>
					</div>
					<div id="neck" class="form-group">
						<div class="col-sm-4">
							<span>客户编号:${gen.customerListNo}</span>
						</div>
						<div class="col-sm-4" style="padding-left:5%">
								<p>日期：<fmt:formatDate value="${gen.takeTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
						</div>
						<div class="col-sm-4">
							<span style="font:italic bold 24px 宋体;">No:</span>
							<span>${gen.workSheetNo}</span>
						</div>
					</div>
					<div class="form-group" style="padding:0 20px 0 20px">
						<table class="table table-bordered">
							<tr class="">
								<th>委托人:</th>
								<td colspan="7">${gen.senderName}</td>
							</tr>
							<tr>
								<th>委托单位:</th>
								<td>${gen.senderCompany}</td>
								<th>品名:</th>
								<td colspan="2">${gen.productName}</td>
								<th>产品类型:</th>
								<td>${gen.product}</td>
							</tr>
							<tr>
								<th>返货状态</th>
								<td>${gen.status}</td>
								<th>处理结果</th>
								<td colspan="5">${gen.importantTips}</td>
							</tr>
							<tr>
								<th>件数</th>
								<td>${gen.productAmount}</td>
								<th>体积</th>
								<td colspan="2">${gen.volume}</td>
								<th>代收款:</th>
								<td>${gen.replaceReceivables}</td>
							</tr>
							<tr>
								<td colspan="5"></td>
								<th>受理人:</th>
								<td colspan="2">${gen.empName}</td>
							</tr>
							<tr>
								<td colspan="5"></td>
								<th>受理单位:</th>
								<td colspan="2">${gen.pickup}</td>
							</tr>
							<tr>
								<th>到达地:</th>
								<td colspan="7">${gen.destination}</td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>