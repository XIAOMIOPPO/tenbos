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
<title>工作单导入</title>
<style type="text/css">
.mid-wrap-tit {
	position: absolute;
	background: #ffffff;
	padding: 3px 6px;
	left: 10px;
	top: -16px;
}

.mid-wrap {
	border: #EEEEEE 3px solid;
	border-radius: 10px;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	-o-border-radius: 10px;
	position: relative;
	margin: 6px 0 15px 0;
	padding: 28px;
}

#import-wrap {
	font-size: 14px;
	line-height: 1.8;
}
</style>
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css"
	rel="stylesheet">
<link href="static/toastr/toastr.css" rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap-checkbox.css"
	rel="stylesheet">
<link href="static/bootstrap-file/css/fileinput.min.css"
	rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.css"
	rel="stylesheet">
<link
	href="static/bootstrap-3.3.7-dist/edit/bootstrap-datetimepicker.css"
	rel="stylesheet">
<link href="jsps/TakeToSend/worksheetLead/worksheetLead.css"
	rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/fixed-columns/fixed-columns.css"
	rel="stylesheet">

<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script src="static/bootstrap-3.3.7-dis	t/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript"
	src="jsps/TakeToSend/worksheetLead/worksheetLead.js"></script>
<script type="text/javascript"
	src="static/bootstrap-file/js/fileinput.js"></script>
<script type="text/javascript"
	src="static/bootstrap-file/js/locales/zh.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/edittable/edittable.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/edit/bootstrap-table-editable.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/edit/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/edit/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bwizard.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/fixed-columns/fixed-columns.js"></script>
</head>
<body class="default">
	<div id="toolbar" class="btn-group">
		<button type="button" class="btn btn-success" id="lead">
			<span class="glyphicon glyphicon-cloud-download" aria-hidden="true"></span>导入
		</button>
		<button type="button" class="btn btn-info" id="quantilyWorkOrderNum" disabled="disabled">
			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>批量生成工作单号
		</button>
		<button type="button" class="btn btn-danger" id="save" disabled="disabled">
			<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>指定取派员
		</button>
		<button type="button" class="btn btn-warning" id="addJsp" disabled="disabled">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>保存
		</button>
		<button type="button" class="btn btn-success" id="writeExplain">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>填写说明
		</button>
		<button type="button" class="btn btn-inverse" id="delete" disabled="disabled">
			<span class="glyphicon glyphicon-trash" aria-hidden="true" ></span>删除
		</button>

	</div>
	<!-- 保存结果开始 -->
	<div class="modal fade" id="people" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">保存导入结果</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form"
						id="">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label" disabled="disabled">取件人工号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="empNum">
							</div>
						</div>

						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label" >取件人</label>
							<div class="col-sm-10">
								<select id="senderAddress"
									class="selectpicker show-menu-arrow form-control"
									data-hide-disabled="true" data-size="5" name="empName"></select>
							</div> 
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="cancel()">取消</button>
					<button type="button" id="appointed" class="btn btn-primary">指定</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 保存结果结束 -->
	<!-- 批量生成工单号开始 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">工单导入</h4>
				</div>
				<div class="modal-body">
					<div id="wizard" class="bwizard clearfix">
						<ol class="bwizard-steps clearfix clickable" role="tablist">
							<li role="tab" style="z-index: 1;" aria-selected="true"
								class="active" id="download"><a href="#step1"
								class="hidden-phone">下载模板并填写</a></li>
							<li role="tab" style="z-index: 2;" aria-selected="false"
								id="uploadLead"><a href="#step2" class="hidden-phone">上传导入文件</a></li>
						</ol>
						<div class="tab-content">
							<div id="step1" role="tabpanel" class="bwizard-activated "
								aria-hidden="false" style="">
								<div style="margin-top: 20px; margin-bottom: 20px;">
									导入模板下载 &nbsp;&nbsp; <a href="WorkSheetServlet?filename=Lead.xls">
										<button type="button" class="btn btn-success"
											id="downloadBoard">
											<span aria-hidden="true"></span> 下载
										</button>
									</a>
								</div>
								<div>
									<div class="mid-wrap import">
										<span class="mid-wrap-tit">导入说明</span>
										<h4>填写excel模版</h4>
										<div id="templateCaption">
											<p>1)下载EXCEL空白格式模板,填充数据</p>
											<p>2)模板中红色字体的列为必填项;</p>
										</div>
									</div>
								</div>
							</div>
							<div id="step2" role="tabpanel" class="hide" aria-hidden="true"
								style="">
								<div class="panel panel-default" id="hide"
									style="margin-top: 20px;">
									<div class="file-loading">
										<input id="input-file" name="myFile" type="file" multiple />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="next" class="btn btn-primary">下一步</button>
					<button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="cancel()">关闭</button>
					<button type="button" id="after" class="btn btn-primary hide">上一步</button>
					<button type="button" id="over" class="btn btn-primary hide"
						data-dismiss="modal" onclick="cancel()">完成</button>

				</div>
			</div>
		</div>
	</div>
	<!-- 批量生成工单号结束 -->
	<!-- 填写说明开始 -->
	<div class="modal fade" id="remake" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">填写说明</h4>
				</div>

				<div class="modal-body">
					<p style="margin-top: 20px;">1)下载EXCEL空白格式模板,填充数据</p>
					<p style="margin-top: 20px;">2)模板中红色字体的列为必填项;</p>
					<p style="margin-top: 20px;">3)选择已下载填写完成的模板,点击文件上传导入;</p>
					<p style="margin-top: 20px;">4)点击批量生成工作单号按钮生成工作单号</p>
					<p style="margin-top: 20px;">5)点击指定取派员按钮指定取派员</p>
					<p style="margin-top: 20px;">6)保存操作结果</p>
				</div>
			</div>
		</div>
	</div>
	<!-- 填写说明结束 -->
	<!-- 下载模板 开始-->
	<div class="modal fade" id="downloadBorder" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<form class="form-horizontal" role="form" id="dddd"
				action="WorkSheetServlet" onsubmit="return check()">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">下载说明</h4>
					</div>
					<div class="modal-body"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							onclick="cancel()">取消</button>
						<button type="submit" id="ss" class="btn btn-primary">下载</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- 下载模板结束 -->
	<table id="tb_departments"></table>
		
				<!-- 
				
	 -->
</body>
</html>