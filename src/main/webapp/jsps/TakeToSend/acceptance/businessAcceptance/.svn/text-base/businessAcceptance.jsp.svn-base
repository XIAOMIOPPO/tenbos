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
<title>业务受理</title>

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

<script type="text/javascript" src="static/jqueryCsxz/City_data.js"></script>
<script type="text/javascript" src="static/jqueryCsxz/areadata.js"></script>
<script type="text/javascript" src="static/jqueryCsxz/auto_area.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/edit/bootstrap-editable.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/edit/bootstrap-table-editable.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/distpicker.data.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/distpicker.js"></script>


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
#mainContainer{
	width: 100%;
	margin: auto;
	margin-top: 10px;
	margin-bottom: 60px;
}
#destoryNone{
	margin-bottom: 20px;
	margin-top  : 20px;
	resize: none;
}

#newOrderDiv{
	margin-top: 10px;
}
.cloudMessage{
	margin-bottom: 20px;
}
</style>
</head>
<body class="default">
			<div id="mainContainer">
				<div class="modal fade" id="destoryMyModalLabel" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">销单</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-xs-12 col-sm-12">
										<form role="form">
											<div class="form-group sershIn">
												<div class="col-md-12 col-sm-12">
													<label for="name" class="labelFont">销单Id</label> 
													<input type="text" class="form-control" id="destoryId" readonly="readonly">
												</div>
											</div>
											<div class="form-group sershIn">
												<div class="col-md-12 col-sm-12">
													<textarea rows="6" cols="82" id="destoryNone" placeholder="请您给出宝贵的意见，我们会立即改正。"></textarea>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" id="editBtn"  class="btn btn-primary">提交更改</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>






				<ul id="myTabs" class="nav nav-tabs">
					<li class="active"><a href="#remessage" data-toggle="tab">
							受理单管理 </a></li>
					<li><a href="#contents" data-toggle="tab" id="toResult">新单</a></li>
					<li><a href="#orderItemResyult" data-toggle="tab">订单属性</a></li>
				</ul>
				<div id="myTabContents" class="tab-content">
					<div class="tab-pane fade in active" id="remessage">
						<div class="panel-group" id="accordion">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion" 
										   href="#searchTwo">
											查询通知单信息
										</a>
									</h4>
								</div>
								<div id="searchTwo" class="panel-collapse collapse">
									<div class="panel-body">
									    <div class="row" >
									        <div class="col-xs-12 col-sm-12" >
									        	<div class="col-xs-4 col-sm-4" >
													<label for="name" class="labelFont">来电号码</label> 
													<input type="text" class="form-control" id="searchPhoneNum">
													<label for="name" class="labelFont">客户名</label> 
													<input type="text" class="form-control" id="searchClientName">
													<label for="name" class="labelFont">取件地址</label> 
													<input type="text" class="form-control" id="searchClientAddress">														
									        	</div>
									        	<div class="col-xs-4 col-sm-4" >
													<label for="name" class="labelFont">收件人名</label> 
													<input type="text" class="form-control" id="searchToUserName">
													<label for="name" class="labelFont">收件人联系电话</label> 
													<input type="text" class="form-control" id="searchToUserPhone">
													<label for="name" class="labelFont">收件地址</label> 
													<input type="text" class="form-control" id="searchoUserAddress">
									        	</div>
									        	<div class="col-xs-4 col-sm-4" >
													<label for="name" class="labelFont">取件员</label> 
													<input type="text" class="form-control" id="searchEmpNum">
													<label for="name" class="labelFont">产品名字</label> 
													<input type="text" class="form-control" id="searchProductName">
													<label for="name" class="labelFont"> &nbsp; </label> 
													<input type="button" value="搜索" class="form-control" id="searchBtn">
									        	</div>									        	
									        </div>
									    </div>    
									</div>
								</div>
							</div>
						</div>
						
						<div id="receptionConsult" class="btn-group">
							<button type="button" class="btn btn-warning" id="superadditionOrder" data-toggle="modal">
								<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>追单
							</button>
							<button type="button" class="btn btn-info" id="alterOrder">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>改单
							</button>
							<button type="button" class="btn btn-danger" id="destroyOrder">
								<span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>销单
							</button>	
						</div>
						<table id="tab_AllreceptionConsult"></table>
					</div>
					
					
					
					<!-- 操作 -->
					

					
					<div class="tab-pane fade" id="contents">
						<div class="row">
							<div class="col-xs-8 col-sm-8">
								<form role="form">
									<div class="form-group sershIn">
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">来电号码</label> 
											<input type="text" class="form-control" id="phoneNum" placeholder="请输入来电号码">
										</div>
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">客户名称</label> 
											<input type="text" id="customerName" class="form-control" placeholder="客户名称">
										</div>
									</div>
									<div class="form-group sershIn">
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">客户编号</label> 
											<fieldset disabled>
												<input type="text" id="customerNo" class="form-control" placeholder="客户编号">
											</fieldset>
										</div>
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">通知单号</label> 
											<fieldset disabled>
												<input type="text" id="businessRecsiptNo" class="form-control" placeholder="通知单号">
											</fieldset>
										</div>
									</div>
									<div class="form-group sershIn">
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">收件人</label> 
											<input type="text" id="contacts" class="form-control" placeholder="收件人">
										</div>
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">联系电话</label> 
											<input type="text" id="telephone" class="form-control" placeholder="收件人联系电话">
										</div>
									</div>
									<div class="form-group sershIn">
										<div class="col-md-12 col-sm-12">
											<label for="name" class="labelFont">取件地址 (取件员上门取件地址)</label> 
											<input type="text" id="fetchAddress" readonly class="form-control" placeholder="取件地(省|市必填):省\直辖市|市(|区\县). 如：湖南省|长沙市|雨花区" data-toggle="modal" data-target="#myModal4">
										</div>
									</div>
									<div class="form-group sershIn">
										<div class="col-md-12 col-sm-12">
											<label for="name" class="labelFont">收件地址 (收货地址)</label> 
											<input type="text" id="serveAddress" readonly class="form-control" placeholder="收件地(省|市必填):省\直辖市|市(|区\县). 如：湖南省|长沙市|雨花区" data-toggle="modal" data-target="#myModal3">
										</div>
									</div>
									<div class="form-group sershIn">
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">品名</label> 
											<input type="text" id="productName" class="form-control" placeholder="品名">
										</div>
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">件数</label> 
											<input type="text" id="numberPackages" class="form-control" placeholder="件数">
										</div>
									</div>
									<div class="form-group sershIn">
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">重量(KG)</label> 
											<input type="text" id="weight" class="form-control" placeholder="请输入大于0的数，首重1Kg">
										</div>
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">体积(平方)</label> 
											<input type="text" id="volume" class="form-control" placeholder="请输入大于0的数">
										</div>
									</div>
									<div class="form-group sershIn">
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">产品时限</label> 
											<select class="form-control" id="product">
												<option value="普件">普件</option>
												<option value="快件">快件</option>
												<option value="同城">同城</option>
											</select>
										</div>
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">类型</label> 
											<select class="form-control">
												<option value="下单">下单</option>
												<option value="咨询">咨询</option>
											</select>
										</div>
									</div>
									<div class="form-group sershIn">
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">分拣编码</label> 
											<input type="text" id="assignCode" class="form-control" placeholder="点击取件地址获取分拣编码">
										</div>
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">预约取件时间</label> 
											<input type="text" class="form-control" placeholder="取件员上门取件时间" id="forTakeToSendTime" data-date-format="yyyy-mm-dd hh:mm:ss" readonly>
										</div>
									</div>
									<div class="form-group sershIn">
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">常用备注</label> 
											<select class="form-control" id="commonRemarks">
												<option value="请不要损坏外包装">请不要损坏外包装</option>
												<option value="易碎品">易碎品</option>
												<option value="防水">防水</option>
												<option value="易燃易爆">易燃易爆</option>
												<option value="禁止暴晒">禁止暴晒</option>
												<option value="禁止挤压">禁止挤压</option>
											</select>
										</div>
										<div class="col-md-6 col-sm-6">
											<label for="name" class="labelFont">备注</label> 
											<input type="text" id="Remarks" class="form-control" placeholder="备注">
										</div>
									</div>
									<div class="form-group sershIn">
										<div class="col-md-6 col-sm-6">
	
										</div>
										<div class="col-md-6 col-sm-6" id = "newOrderDiv">
											<button type="button" class="btn btn-success" id="addNewOrder">
												<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新单
											</button>	
										</div>
									</div>
								</form>
							</div>
							<div class="col-xs-4 col-sm-4">
								<div class="panel panel-default" id="messgPanel">
									<div class="panel-heading"class="col-xs-12 col-sm-12">
										<h3 class="panel-title">最新消息</h3>
									</div>
									<div class="panel-body" id="PropagandaContent">
										
									</div>
								</div>
							</div>

							<div class="clearfix visible-xs"></div>

						</div>
					</div>
					<div class="tab-pane fade" id="orderItemResyult">
						<table id="tab_orderProperty"></table>
					</div>
				</div>

				






	<div class="modal fade" id="myModal4" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">选择地址</h4>
				</div>
				<div class="modal-body">
					<form class="form-inline" role="form">
						<div data-toggle="distpicker">
							<div class="form-group">
								<label class="sr-only" for="province4">Province</label> <select
									class="form-control" id="province4"
									data-province="---- 选择省 ----"></select>
							</div>
							<div class="form-group">
								<label class="sr-only" for="city4">City</label> <select
									class="form-control" id="city4" data-city="---- 选择市 ----"></select>
							</div>
							<div class="form-group">
								<label class="sr-only" for="district4">District</label> <select
									class="form-control" id="district4"
									data-district="---- 选择区 ----"></select>
							</div>
						</div>
						<div>&nbsp;</div>
						<input type="text" id = "all" class="form-control"placeholder="详细地址" style="width:426px;"/>
					</form>
				</div>
				<div class="modal-footer">
					<button id="subUp" type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal4">提交</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">选择地址</h4>
				</div>
				<div class="modal-body">
					<form class="form-inline" role="form">
						<div data-toggle="distpicker">
							<div class="form-group">
								<label class="sr-only" for="province2">Province</label> <select
									class="form-control" id="province2"
									data-province="---- 选择省 ----"></select>
							</div>
							<div class="form-group">
								<label class="sr-only" for="city2">City</label> <select
									class="form-control" id="city2" data-city="---- 选择市 ----"></select>
							</div>
							<div class="form-group">
								<label class="sr-only" for="district2">District</label> <select
									class="form-control" id="district2"
									data-district="---- 选择区 ----"></select>
							</div>
							<div>&nbsp;</div>
							<input type="text" id = "aoo2" class="form-control"placeholder="详细地址" style="width:426px;"/>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button id="subAddress" type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal3">提交</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
















			</div>







	<!-- 第二部分   表格查询部分 -->



	<script type="text/javascript"
		src="jsps/TakeToSend/acceptance/businessAcceptance/reception.js"></script>

</body>
</html>