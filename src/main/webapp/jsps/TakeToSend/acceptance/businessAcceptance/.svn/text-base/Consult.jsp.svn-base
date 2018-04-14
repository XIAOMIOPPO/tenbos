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
<title>Insert title here</title>

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

<script type="text/javascript" src="static/jqueryCsxz/City_data.js"></script>
<script type="text/javascript" src="static/jqueryCsxz/areadata.js"></script>
<script type="text/javascript" src="static/jqueryCsxz/auto_area.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/edit/bootstrap-table-editable.js"></script>

<style type="text/css">
.container {
	margin-top: 30px;
}

.labelFont {
	margin-top: 5px;
}

.sershIn {
	margin-bottom: 10px;
}

#messgPanel {
	height: 700px;
}

#spanBtn {
	margin-left: 10px;
	margin-right: 10px;
	padding-left: 4px;
	padding-right: 4px;
}

#addNewConsult {
	margin-top: 30px;
}

#mainContainer {
	width: 98%;
	margin: auto;
	margin-top: 10px;
	margin-bottom: 60px;
}

#destoryNone {
	margin-bottom: 20px;
	margin-top: 20px;
	resize: none;
}
#mondel{
	height: 50px;
}
</style>
</head>
<body>
	<div class="row">
		<div class="col-xs-12 col-sm-12">
			<form role="form">
				<div class="form-group sershIn">
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">电话</label> <input type="text"
							class="form-control" id="contactPhone" placeholder="电话">
					</div>
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">客户编号</label> <input
							type="text" class="form-control" id="ConsultcustomerNo"
							placeholder="客户编号">
					</div>
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">联系人</label> <input type="text"
							class="form-control" id="Consultcontacts" placeholder="联系人">
					</div>
				</div>
				<div class="form-group sershIn">
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">客户名称</label> <input
							type="text" class="form-control" id="ConsultcustomerName"
							placeholder="客户名称">
					</div>
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">手机</label> <input type="text"
							class="form-control" id="Consultelephone" placeholder="手机">
					</div>
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">传真</label> <input type="text"
							class="form-control" id="portraiture" placeholder="传真">
					</div>
				</div>
				<div class="form-group sershIn">
					<div class="col-md-8 col-sm-8">
						<label for="name" class="labelFont">联系地址</label> <input
							type="text" class="form-control" id="contactAddress"
							placeholder="联系地址">
					</div>
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">邮编</label> <input type="text"
							class="form-control" id="zipCode" placeholder="邮编">
					</div>
				</div>
				<div class="form-group sershIn">
					<div class="col-md-8 col-sm-8">
						<label for="name" class="labelFont">Email</label> <input
							type="text" class="form-control" id="Email" placeholder="Email">
					</div>
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">是否合作过</label> <select
							class="form-control" id="cooperate">
							<option value="有">有</option>
							<option value="没有">没有</option>
						</select>
					</div>
				</div>
				<div class="form-group sershIn">
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">类型</label> <input type="text"
							class="form-control" placeholder="类型">
					</div>
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">工作单号</label> <select
							class="form-control" id="CCworkOrderNo">

						</select>
					</div>
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">通知单号</label> <select
							class="form-control" id="CCbusinessRecsiptNo">

						</select>
					</div>
				</div>
				<div class="form-group sershIn">
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">咨询类型</label> <select
							class="form-control" id="ConsultconsultType">
							<option value="受理咨询">受理咨询</option>
							<option value="工单咨询">工单咨询</option>
						</select>
					</div>
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">方式</label> <select
							class="form-control" id="consultWay">
							<option value="电话">电话</option>
							<option value="网络">网络</option>
						</select>
					</div>
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">意向</label> <select
							class="form-control">
							<option value="很强烈">很强烈</option>
							<option value="有意向">有意向</option>
							<option value="没意向">没意向</option>
						</select>
					</div>
				</div>
				<div class="form-group sershIn">
					<div class="col-md-4 col-sm-4">
						<label for="name" class="labelFont">咨询日期</label> <input
							type="text" class="form-control" id="forConsultTime"
							data-date-format="yyyy-mm-dd hh:mm:ss" readonly>
					</div>
					<div class="col-md-8 col-sm-8">
						<label for="name" class="labelFont">咨询内容</label> <input
							type="text" class="form-control" id="consultContent"
							placeholder="咨询内容">
					</div>
				</div>
				<div class="form-group sershIn">
					<div class="col-md-8 col-sm-8">
						<label for="name" class="labelFont">咨询结果</label> <input
							type="text" class="form-control" id="consultFruit"
							placeholder="咨询结果">
					</div>
					<div class="col-md-4 col-sm-4">
						<button type="button" class="btn btn-success" id="addNewConsult">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							保存咨询
						</button>
					</div>
				</div>
			</form>
		</div>
		<div class="clearfix visible-xs"></div>
	</div>
	
	<div id="mondel"></div>

	<ul id="mySelectTab" class="nav nav-tabs">
		<li class="active"><a href="#receptionConsult" data-toggle="tab">
				受理咨询 </a></li>
		<li><a href="#workOrderConsult" data-toggle="tab"> 工单咨询 </a></li>
	</ul>
	<div id="mySelectTabContent" class="tab-content">



		<div class="tab-pane fade in active" id="receptionConsult">
			<table id="tab_receptionConsult"></table>
		</div>

		<div class="tab-pane fade" id="workOrderConsult">
			<table id="tab_workOrderConsult"></table>
		</div>
	</div>
<script type="text/javascript"
	src="jsps/TakeToSend/acceptance/businessAcceptance/reception.js"></script>	
</body>
</html>