<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="shiro" uri="http://shiro.apache.org/tags"%>
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

<title>generateSingle</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="static/toastr/toastr.css">
<link rel="stylesheet" href="static/select/bootstrap-select.css">
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">

<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript" src="static/select/bootstrap-select.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>

</head>
<body>
	<div  class="panel-body" style="padding-bottom:0px;">
		<div class="panel panel-default">
			<div class="panel-heading">
				<a href="#collapse" data-toggle="collapse"><font size="2em">查询条件</font></a>
			</div>
			<div class="panel-body collapse" id="collapse">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top:15px">
						<label class="control-label col-sm-1"
							for="txt_search_workSheetNo">工作单号</label>
						<div class="col-sm-2">
							<input type="text" class="form-control"
								id="workSheetNoC">
						</div>
						<label class="control-label col-sm-1" for="txt_search_drawerTime">开单时间</label>
						<div class="col-sm-4">
							<div class="col-lg-5">
								<input type="text" class="form-control time" id="lowdrawerTime">
							</div>
							<span class="col-lg-1">~</span>
							<div class="col-lg-5">
								<input type="text" class="form-control time" id="highdrawerTime">
							</div>
						</div>
						<label class="control-label col-sm-1" style="margin-left:-60px">状态</label>
						<div class="col-sm-2">
							<select type="text" class="form-control" id="status">
								<option value="0">全部</option>
								<option value="1">已返货</option>
								<option value="2" selected="selected">待返货</option>
							</select>							
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-1"
							for="txt_search_addresseeCompany">受理单位</label>
						<div class="col-sm-2">
							<input type="text" class="form-control"
								id="senderCompany1">
						</div>
						<label class="control-label col-sm-1"
							for="txt_search_inputTime">异常时间</label>
						<div class="col-sm-4">
							<div class="col-lg-5">
								<input type="text" class="form-control time" id="lowinputTime">
							</div>
							<span class="col-lg-1">~</span>
							<div class="col-lg-5">
								<input type="text" class="form-control time" id="highinputTime">
							</div>
						</div>
						<div class="col-sm-3">
							<div class="col-sm-4" style="margin-top:15px">
								<input type="checkbox"> <span>含下级</span>
							</div>
							<button type="button" id="btn_query"
							class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
			<shiro:hasPermission name="SCFHD:SCFD">
				<button id="btn_add" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>生成返单
				</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="SCFHD:TRANSFER">
				<button id="btn_transfer" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-retweet" aria-hidden="true"></span> 转移
				</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="SCFHD:DEL">
				<button id="btn_delete" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>作废
				</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="SCFHD:HIGHP">
			<button id="btn_highPrimary" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>高级查询
			</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="SCFHD:TQUERY">
			<button id="btn_trackingQuery" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>追踪查询
			</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="SCFHD:PRINT">
			<button id="btn_print" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-print" aria-hidden="true"></span>打印
			</button>
			</shiro:hasPermission>
		</div>
		<table id="tb_departments"></table>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog"  style="width:800px;top:200px;">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h3 class="modal-title" id="myModalLabel">生成返单</h3>
	            </div>
	            <div class="modal-footer">
	            	<form method="POST" id="addForm"  class="form-horizontal" onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">工作单号</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="workSheetNo"  name="workSheetNo" readonly
									placeholder="请输入工作单号名称">
							</div>
							<label for="lastname" class="col-sm-2 control-label">产品</label>
							<div class="col-sm-4">
								<select type="text" class="form-control selectpicker bla bla bli" data-live-search="true" id="product"  name="product">
									<option value="普件">普件</option>
									<option value="快件">快件</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">实际件数</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="productAmount" name="productAmount"
									placeholder="请输入实际件数">
							</div>
							<label for="lastname" class="col-sm-2 control-label">结算方式</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="settlementMode" name="settlementMode"
									placeholder="请输入结算方式">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">品名</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="productName" name="productName"
									placeholder="请输入品名">
							</div>
							<label for="lastname" class="col-sm-2 control-label">原包装</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="originalPacking" name="originalPacking"
									placeholder="请输入原包装">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">实际重量</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="actualWeight" name="actualWeight"
									placeholder="请输入实际重量">
							</div>
							<label for="lastname" class="col-sm-2 control-label">到达地</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="destination" name="destination"
									placeholder="请输入到达地">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">体积</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="volume" name="volume"
									placeholder="请输入体积">
							</div>
							<label for="lastname" class="col-sm-2 control-label">配置要求</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="stowageRequirement" name="stowageRequirement"
									placeholder="请输入配置要求">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">送达时间</label>
							<div class="col-sm-4">
								<input type="text" class="form-control time" id="serviceTimeLimit" name="serviceTimeLimit"
									placeholder="请输入送达时间">
							</div>
							<label for="lastname" class="col-sm-2 control-label">委托人</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="senderName" name="senderName"
									placeholder="请输入委托人">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">发货传真</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="senderFax" name="senderFax"
									placeholder="请输入发货传真">
							</div>
							<label for="lastname" class="col-sm-2 control-label">发货地址</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="senderAddress" name="senderAddress"
									placeholder="请输入发货地址">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">发货手机</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="senderPhone" name="senderPhone"
									placeholder="请输入发货手机">
							</div>
							<label for="lastname" class="col-sm-2 control-label">发货单位号</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="senderNo" name="senderNo"
									placeholder="请输入发货单位号">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">收货人</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="addressesName" name="addressesName"
									placeholder="请输入收货人">
							</div>
							<label for="lastname" class="col-sm-2 control-label">收货单位</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="addressesCompany" name="addressesCompany"
									placeholder="请输入收货单位">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">收货传真</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="addressesFax" name="addressesFax"
									placeholder="请输入收货传真">
							</div>
							<label for="lastname" class="col-sm-2 control-label">收货手机</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="addressesPhone" name="addressesPhone"
									placeholder="请输入收货手机">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">收货地址</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="addressesAddress" name="addressesAddress"
									placeholder="请输入收货地址">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">收货编号</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="addressesNo" name="addressesNo"
									placeholder="请输入收货编号">
							</div>
							<label for="lastname" class="col-sm-2 control-label">保险类型</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="insuranceType" name="insuranceType"
									placeholder="请输入保险类型">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">保险费</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="insurancePremium" name="insurancePremium"
									placeholder="请输入保险费">
							</div>
							<label for="lastname" class="col-sm-2 control-label">声明价值</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="declaredValue" name="declaredValue"
									placeholder="请输入声明价值">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">重要提示</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="importantTips" name="importantTips"
									placeholder="请输入重要提示">
							</div>
							<label for="lastname" class="col-sm-2 control-label">到付款</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="paymentArrival" name="paymentArrival"
									placeholder="请输入到付款">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">代收款</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="replaceReceivables" name="replaceReceivables"
									placeholder="请输入代收款">
							</div>
							<label for="lastname" class="col-sm-2 control-label">包装要求</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="packagingRequirements" name="packagingRequirements"
									placeholder="请输入包装要求">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">开单时间</label>
							<div class="col-sm-4">
								<input type="text" class="form-control time" id="drawerTime" name="drawerTime" readonly
									placeholder="请输入开单时间">
							</div>
							<label for="lastname" class="col-sm-2 control-label">已打印</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="isPrint" name="isPrint"
									placeholder="请输入已打印">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">客户单号</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="customerListNo" name="customerListNo"
									placeholder="请输入客户单号">
							</div>
							<label for="lastname" class="col-sm-2 control-label">计费重量</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="billingWeight" name="billingWeight"
									placeholder="请输入计费重量">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">开单人</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="drawerName" name="drawerName"
									placeholder="请输入开单人">
							</div>
							<label for="lastname" class="col-sm-2 control-label">操作单位</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="operationUnit" name="operationUnit" readonly
									placeholder="请输入操作单位">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">取件单位</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="pickup" name="pickup" readonly
									placeholder="请输入取件单位">
							</div>
						</div>
					</form>
					<button id="sub" type="button"  class="btn btn-primary">提交</button>
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	<div class="modal fade" id="myModalF" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h3 class="modal-title" id="myModalLabel">转移</h3>
	            </div>
	            <div class="modal-footer">
	            	<form method="POST" id="advancedQuery"  class="form-horizontal" onsubmit="return check()" role="form">
	            		<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">接受单位</label>
							<div class="col-sm-9">
								<select type="text" class="selectpicker bla bla bli" data-live-search="true" id="orgName" name="receiver">
								</select>
							</div>
						</div>
	            	</form>
					<button id="suvancedQuery" type="button"  class="btn btn-primary">提交</button>
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	<div class="modal fade" id="myModalH" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h3 class="modal-title" id="myModalLabel">高级查询</h3>
	            </div>
	            <div class="modal-footer">
	            	<form method="POST" id="highPrimary"  class="form-horizontal" onsubmit="return check()" role="form">
	            		<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">件数</label>
							<div class="col-sm-9">
								<div class="col-lg-5">
									<input type="text" class="form-control" id="lowproductAmount">
								</div>
								<span class="col-lg-1">~</span>
								<div class="col-lg-5">
									<input type="text" class="form-control" id="highproductAmount">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">重量</label>
							<div class="col-sm-9">
								<div class="col-lg-5">
									<input type="text" class="form-control" id="lowactualWeight">
								</div>
								<span class="col-lg-1">~</span>
								<div class="col-lg-5">
									<input type="text" class="form-control" id="highactualWeight">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">到付款</label>
							<div class="col-sm-9">
								<div class="col-lg-5">
									<input type="text" class="form-control" id="lowPaymentArrival">
								</div>
								<span class="col-lg-1">~</span>
								<div class="col-lg-5">
									<input type="text" class="form-control" id="highPaymentArrival">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">代收款</label>
							<div class="col-sm-9">
								<div class="col-lg-5">
									<input type="text" class="form-control" id="lowreplaceReceivables">
								</div>
								<span class="col-lg-1">~</span>
								<div class="col-lg-5">
									<input type="text" class="form-control" id="highreplaceReceivables">
								</div>
							</div>
						</div>
	            	</form>
					<button id="highPrimaryH" type="button"  class="btn btn-primary">提交</button>
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	<div class="modal fade" id="myModalT" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h3 class="modal-title" id="myModalLabel">追踪查询</h3>
	            </div>
	            <div class="modal-footer">
	            	<form method="POST" id="TracInquiry"  class="form-horizontal" onsubmit="return check()" role="form">
	            		<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">工作单号</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="workSheetNo1" name="workSheetNo">
							</div>
						</div>
	            	</form>
					<button id="sub" type="button"  class="btn btn-primary">提交</button>
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	<script type="text/javascript">
		$('.time').datetimepicker({
			  language: 'zh-CN',
			  weekStart: 1,
			  todayBtn: 1,
			  autoclose: 1,
			  todayHighlight: 1,
			  startView: 2,
			  minView: 2,
			  forceParse: 0
			 });
		$(function(){
				$('#tb_departments').bootstrapTable({
					url : 'generrateI/findGenerrateInvoicePagenation', //请求后台的URL（*） 
					method : 'post', //请求方式（*） 
					toolbar : '#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : false, //是否启用排序 sortable
					sortOrder : "asc", //排序方式
					queryParams : queryParams,//传递参数（*） 
					sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
					pageNumber : 1, //初始化加载第一页，默认第一页 
					pageSize : 8, //每页的记录行数（*） 
					pageList : [ 8, 16, 25 ], //可供选择的每页的行数（*） 
					search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "workSheetNo", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'workSheetNo',
						title : '工作单号'	
					}, {
						field : 'drawerTime',
						title : '开单时间',
						formatter : FormatDate
					}, {
						field : 'inputTime',
						title : '异常录入时间',
						formatter : FormatDate
					}, {
						field : 'status',
						title : '状态',
						formatter:function(data){
							if(data=='1'){
								return '未执行';
							}else if(data=="2"){
								return '已返货';
							}
						}
					}, {
						field : 'customerListNo',
						title : '客户编号'
					}, {
						field : 'senderName',
						title : '委托人'
					}, {
						field : 'senderCompany',
						title : '委托单位'
					}, {
						field : 'productAmount',
						title : '件数'
					}, {
						filed : 'volume',
						title : '体积'
					}, {
						filed : 'actualWeight',
						title : '实际重量'
					}, {
						field : 'destination',
						title : '到达地'
					}, {
						field : 'productName',
						title : '品名'
					}, {
						field : 'product',
						title : '产品类型'
					}, {
						field : 'PaymentArrival',
						title : '到付款'
					}, {
						field : 'replaceReceivables',
						title : '代收款'
					}, {
						field : 'empName',
						title : '受理人'
					}, {
						field : 'takeTime',
						title : '受理时间',
						formatter : FormatDate
					}, {
						field : 'pickup',
						title : '受理单位'
					}, {
						field : 'importantTips',
						title : '重要提示'
					}]
				});
				
			});
			
			
			queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset //页码
				};
				return temp;
			};
			$('#btn_query').click(function (){
				var lowdrawerTime = $('#lowdrawerTime').val();
				var highdrawerTime = $('#highdrawerTime').val();
				var lowinputTime = $('#lowinputTime').val();
				var highinputTime = $('#highinputTime').val();
				if(lowdrawerTime>highdrawerTime || lowinputTime>highinputTime){
					toastr.warning('请注意时间的先后');
				}else{
			 	 var opt = {
						    url: "generrateI/findGenerrateInvoicePagenationWithCriteria",
						    silent: true,
							    query:{      
							    	type:1,
							        level:2,
							        workSheetNo : $('#workSheetNoC').val(),
							        lowdrawerTime : $('#lowdrawerTime').val(),
							        highdrawerTime : $('#highdrawerTime').val(),
							        senderCompany : $('#senderCompany1').val(),
							        lowinputTime : $('#lowinputTime').val(),
							        highinputTime : $('#highinputTime').val(),
							        astatus : $('#status').val(),
								  	offset:0
							    }
						  };
				}
				$('#tb_departments').bootstrapTable('refresh', opt);
			});
			
		
			$("#btn_add").click(function() {
						var select = $('#tb_departments').bootstrapTable(
								'getSelections');
						if (select.length === 0) {
							toastr.warning('请选择一行');
						}else if(select.length>1){
							toastr.warning('只能生成一行');
						}else{
							var rowData = select[0];
							$("#addForm").find(':input').each(function(){
								if($(this).attr('name')){
									if($(this).hasClass("time")){	
										var data = rowData[$(this).attr('name')];
	
										$(this).val(FormatDate(data));
									}else{
										$(this).val(rowData[$(this).attr('name')]);
									}
								}
							});
							$.ajax({
								url : "workSheet/findWorkSheet",
								type : "post",
								data:{
									"workSheetNo":rowData.workSheetNo
								},
								traditional : true,
								success : function(response) {
						        $("#stowageRequirement").val(response.stowageRequirement);
							 }
						   });
							
							$.ajax({
								url : "generrateI/findSender",
								type : "post",
								data:{
									"workSheetNo":rowData.workSheetNo
								},
								traditional : true,
								success : function(response) {
						        $("#senderNo").val(response.senderNo);
						        $("#senderFax").val(response.senderFax);
						        $("#senderAddress").val(response.senderAddress);
						        $("#senderCompany").val(response.senderCompany);
						        $("#senderPhone").val(response.senderPhone);
							 }
						   });
							
							$.ajax({
								url : "generrateI/findAddresses",
								type : "post",
								data:{
									"workSheetNo":rowData.workSheetNo
								},
								traditional : true,
								success : function(response) {
						        $("#addressesNo").val(response.addressesNo);
						        $("#addressesFax").val(response.addressesFax);
						        $("#addressesName").val(response.addressesName);
						        $("#addressesAddress").val(response.addressesAddress);
						        $("#addressesCompany").val(response.addressesCompany);
						        $("#addressesPhone").val(response.addressesPhone);
							 }
						   });
							
							$.ajax({
								url : "generrateI/findDrawer",
								type : "post",
								data:{
									"workSheetNo":rowData.workSheetNo
								},
								traditional : true,
								success : function(response) {
						        $("#drawerName").val(response.drawerName);
						        $("#operationUnit").val(response.drawerOperationCompany);
							 }
						   });
							
							$.ajax({
								url : "generrateI/findRule",
								type : "post",
								data:{
									"workSheetNo":rowData.workSheetNo
								},
								traditional : true,
								success : function(response) {
						        $("#insuranceType").val(response.insuranceType);
						        $("#declaredValue").val(response.declaredValue);
						        $("#insurancePremium").val(response.insurancePremium);
						        $("#originalPacking").val(response.originalPacking);
						        $("#packagingRequirements").val(response.packagingRequirements);
						        $("#billingWeight").val(response.billingWeight);
						        $("#settlementMode").val(response.settlementMode);
						        $("#serviceTimeLimit").val(FormatDate(response.serviceTimeLimit));
						        $("#isPrint").val(response.isPrint);
							 }
						   });
							
							$("#myModal").modal('show');
						}
							
					});
				$("#sub").click(function(){
				   var option={
							url:'generrateI/addGenerrateInvoice',
							success:function(data){
								$("#myModal").modal('hide');
								if(data.status=="success"){
									toastr.success("成功生成返单");
									$("#tb_departments").bootstrapTable('refresh');
								}else{
									toastr.error("生成返单失败");								
								}
							}
					}
					$('#addForm').ajaxSubmit(option);
				});

				$("#btn_delete").click(function(){
						var select = $('#tb_departments').bootstrapTable(
								'getSelections');
						if (select.length === 0) {
							toastr.warning('请选择一行');
						} else {

							var arrs = [];
							for (var i = 0; i < select.length; i++) {
								arrs[i] = select[i]['workSheetNo'];
							}
							deletePicktime(arrs);
						}
				});
				
				function deletePicktime(ids) {
					
					layer.msg('确定删除？',{
						  time : 0 //不自动关闭
						  ,btn : [ '确定', '取消' ],
						  yes : function(index) {
							layer.close(index);
							$.ajax({
					            url: "generrateI/deleteGenerrateInvoice",
					            type: "post",
					            data: {
					            	workSheetNo: ids
					            },
					            success: function (data) {
				                	toastr.success("成功作废");
					                //重新加载记录
					                //重新加载数据
			              			$("#tb_departments").bootstrapTable('refresh', {url: 'generrateI/findGenerrateInvoicePagenation'});
					            }
					        });
					      }
				       });
				}
		
		$("#btn_transfer").click(function(){
			var select = $('#tb_departments').bootstrapTable(
			'getSelections');
			if (select.length === 0) {
				toastr.warning('请选择一行');
			}else if(select.length>1){
				toastr.warning('只能生成一行');
			}else{
				$.post('cmts/orgDtoTree',{date:new Date()},function(result){
			    	$('#orgName').selectpicker({
						type:'tree',
						tree:{
							data:result
						},
						hiddenInput:true,
						inputName:'takeOrgName'
						
			        });
		    	});
				$("#myModalF").modal('show');
			}
		})
		
		$("#suvancedQuery").click(function(){
			var option={
					url:'generrateI/upateReceiverByNo',
					success:function(data){
						$("#myModalF").modal('hide');
						if(data.status=="success"){
							toastr.success("转移成功");
							$("#tb_departments").bootstrapTable('refresh');
						}else{
							toastr.error("转移失败");								
						}
					}
			}
			$('#advancedQuery').ajaxSubmit(option);
		})
				
		$("#btn_print").click(function(){
			var select = $('#tb_departments').bootstrapTable(
			'getSelections');
			if (select.length === 0) {
				toastr.warning('请选择一行');
			}else if(select.length>1){
				toastr.warning('选择一行');
			}else if(select[0].status=="1"){
				window.open("generrateI/print?workSheetNo="+select[0].workSheetNo)
			}else if(select[0].status=="2"){
				window.open("generrateI/labelPrinting?workSheetNo="+select[0].workSheetNo)
			}
		});
		
		$("#btn_highPrimary").click(function(){
			$("#myModalH").modal('show');
			
		});
		
		$("#highPrimaryH").click(function(){
			var lowproductAmount = $('#lowproductAmount').val();
			var highproductAmount = $('#highproductAmount').val();
			var lowactualWeight = $('#lowactualWeight').val();
			var highactualWeight = $('#highactualWeight').val();
			var lowPaymentArrival = $('#lowPaymentArrival').val();
			var highPaymentArrival = $('#highPaymentArrival').val();
			var lowreplaceReceivables = $('#lowreplaceReceivables').val();
			var highreplaceReceivables = $('#highreplaceReceivables').val();
			if(lowproductAmount>highproductAmount || lowactualWeight>highactualWeight || lowPaymentArrival>highPaymentArrival || lowreplaceReceivables>highreplaceReceivables){
				toastr.warning('请注意大小');
			}else{
				$("#myModalH").modal('hide');
		 	 var opt = {
					    url: "generrateI/findGenerrateInvoiceUtilByWith",
					    silent: true,
						    query:{      
						    	type:1,
						        level:2,
						        lowproductAmount : $('#lowproductAmount').val(),
						        highproductAmount : $('#highproductAmount').val(),
						        lowactualWeight : $('#lowactualWeight').val(),
						        highactualWeight : $('#highactualWeight').val(),
						        lowPaymentArrival : $('#lowPaymentArrival').val(),
						        highPaymentArrival : $('#highPaymentArrival').val(),
						        lowreplaceReceivables : $('#lowreplaceReceivables').val(),
						        highreplaceReceivables : $('#highreplaceReceivables').val(),
							  	offset:0
						    }
					  };
			}
			$('#tb_departments').bootstrapTable('refresh', opt);
		})
		
		$("#btn_trackingQuery").click(function(){
			$("#myModalT").modal("show")
		})
		
		function FormatDate (strTime) {
		    var date = new Date(strTime);
		    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
		}
		
	</script>
</body>

</html>