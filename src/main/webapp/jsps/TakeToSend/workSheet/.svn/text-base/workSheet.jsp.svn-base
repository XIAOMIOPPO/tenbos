<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>table</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<style type="text/css">


.row {
  margin-top: 3px;
  margin-bottom: 3px;
}
.panel{
  margin:auto
}

input{
background-color:expression(this.readOnly==true?"#eee":"#fff");
}

.yuan {   
  border-radius: 6px;  
  border:1px solid #DBDBDB;
} 
</style>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/toastr/toastr.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-select.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/select2/select2.min.css">

<script src="${pageContext.request.contextPath}/static/jquery-3.2.1.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/collapse.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-select.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/select2/select2.full.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/select2/select2.min.js"></script>
</head>

<body>
   <div class="modal fade in" id="myModal" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
					<label>选择业务通知单</label>			       
					</h4>
				</div>
				<div class="modal-body">
				    <select id="YWTZD" class="select" style="width:500px;" onmousedown="if(this.options.length>6){this.size=7}" onblur="this.size=0" onchange="this.size=0"></select>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	
	<shiro:hasPermission name="GZDLR:S">
	<div class="modal fade in" id="myModal1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
					<label>补录</label>			       
					</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-btn">
							<shiro:hasPermission name="GZDLR：SEARCH">
								<button id="search" class="btn btn-default" type="button">搜索</button>
							</shiro:hasPermission>
						</span> <input id="sear" type="text" class="form-control" placeholder="请输入完整性状态"
							style="width: 171px">
							<input id="searSou" type="text" class="form-control" placeholder="请输入工作单来源"
							style="width: 171px">
							<input id="searTime" type="text" class="form-control" placeholder="请输入开单时间"
							style="width: 171px">
					</div>
					<table id="table"></table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	</shiro:hasPermission>
   
   <form class="form-horizontal" role="form" id="Form">
   <div id="toolbar" class="btn-group">
      <shiro:hasPermission name="GZDLR:ADD">
       <button id="add" class="btn btn-primary" type="button">新增</button>
      </shiro:hasPermission>
      <shiro:hasPermission name="GZDLR:UPDATE">
       <button id="update" class="btn btn-primary" type="button">保存</button>
      </shiro:hasPermission>
      <shiro:hasPermission name="GZDLR:TK">
       <button id="work" class="btn btn-primary" type="button">任务</button>
      </shiro:hasPermission>
       <button id="cancel" class="btn btn-primary" type="reset" >取消</button>
   </div>
   <div style="margin-left:15px;margin-top:20px">
    <div class="panel panel-default row" style="border:1px solid #F0F0F0;background-color:#FCFCFC">
    <div class="panel-heading">
				<a href="#collapse" data-toggle="collapse">基本信息</a>
	</div>
	<div id="collapse" class="panel-collapse collapse in">
	   <div style="margin-left:55px;margin-top:10px;">
		<div class="row form-group">
			<label class="col-sm-1 text-right">工作单号</label>
			<div class="col-sm-3">
				<input type="text" class="form-control clean" style="width:210px;height:25px" id="workSheetNo" name="workSheetNo"
				title="工作单号提示"data-toggle="popover"data-content="①.工作单号位数为11位
							②.工作单号以“TCBOS”开头其他位数为0-9的数字 中间以'-'隔开③.工作单号唯一"data-placement="bottom">
			</div>
			<label class="col-sm-1 text-right">业务通知单</label>
			<div class="col-sm-3">
			    <div class="input-group">
							<span class="input-group-btn">
							   <shiro:hasPermission name="GZDLR：YW">
								<button id="select" class="btn btn-default select" type="button" style="width:13px;height:25px">☟</button>
							   </shiro:hasPermission>
							</span> 
							<input id="businessNoticeNo" name="businessNoticeNo" class="form-control clean" style="width:185px;height:25px"
				title="业务通知单号提示"data-toggle="popover"data-content="①.业务通知单号位数为21位
							②.工作单号以“YWTZD”开头中间为日期以流水号结尾中间以'-'隔开③.业务通知单号唯一"data-placement="bottom">
						</div>
			</div>
			<label class="col-sm-1 text-right" id="productLab">产品</label>
			<div class="col-sm-3">
				<select id="product" class="yuan clean select" style="width:210px;height:25px">
				    <option selected = "selected" ></option>
				</select>
			</div>
		</div>
		<div class="row form-group">
			<label class="col-sm-1 text-right">取件人</label>
			<div class="col-sm-3">
				<input id="empName" name="empName" type="text" class="yuan clean" style="width:210px;height:25px">
			</div>
			<label class="col-sm-1 text-right">受理单位</label>
			<div class="col-sm-3">
				<input id="takeOrgName" name="takeOrgName" type="text" class="yuan clean" style="width:210px;height:25px">
			</div>
			<label id="stowageRequirementLab" class="col-sm-1 text-right">配载要求</label>
			<div class="col-sm-3">
				<select id="stowageRequirement" class="yuan clean select" style="width:210px;height:25px">
				    <option selected = "selected" ></option>
				</select>
			</div>
		</div>
	</div>
	</div>
	</div>
	<div class="panel panel-default row" style="border:1px solid #F0F0F0;background-color:#FCFCFC">
    <div class="panel-heading">
				<a href="#senAdd" data-toggle="collapse">收寄件人</a>
	</div>
	<div id="senAdd" class="panel-collapse collapse">
	   <div class="row">
	      <div class="col-sm-5" style="border:1px solid #F0F0F0;margin-left:100px;margin-right:20px;background-color:#FFFFFF">
	        <div class="row form-group">
	          <label class="col-sm-2 text-right" id="JJR">寄件人</label>
			  <div class="col-sm-3" style="margin-right:10px">
				<input id="customerName" name="customerName" type="text" class="form-control dis clean" style="width:150px;height:25px">
			  </div>
			  <label class="col-sm-3 text-right">寄件人编码</label>
			  <div class="col-sm-2">
				<input id="customerNo1" type="text" class="yuan dis clean" style="width:150px;height:25px"
				title="可以自动生成"data-toggle="popover"data-placement="bottom">
			  </div>
	        </div>
	        <div class="row form-group">
	          <label class="col-sm-2 text-right">地址</label>
			  <div class="col-sm-10">
				<input id="fetchAddressSender" name="fetchAddressSender" type="text" class="form-control dis clean">
			  </div>
	        </div>
	        <div class="row form-group">
	          <label class="col-sm-2 text-right">单位</label>
			  <div class="col-sm-10">
				<input id="senderCompany" type="text" class="form-control dis clean">
			  </div>
	        </div>
	        <div class="row form-group">
	          <label class="col-sm-2 text-right">电话</label>
			  <div class="col-sm-3" style="margin-right:10px">
				<input id="phoneNum" name="phoneNum" type="text" class="form-control dis clean" style="width:150px;height:25px">
			  </div>
			  <label class="col-sm-3 text-right">传真</label>
			  <div class="col-sm-2">
				<input id="senderFax" type="text" class="yuan dis clean" style="width:150px;height:25px">
			  </div>
	        </div>
	      </div>
	      <div class="col-sm-5" style="border:1px solid #F0F0F0;background-color:#FFFFFF">
	        <div class="row form-group">
	          <label class="col-sm-2 text-right" id="SJR">收件人</label>
			  <div class="col-sm-3" style="margin-right:10px">
				<input id="contacts" name="contacts" type="text" class="form-control dis clean" style="width:150px;height:25px">
			  </div>
			  <label class="col-sm-3 text-right">收件人编码</label>
			  <div class="col-sm-2">
				<input id="addressesNo" type="text" class="yuan dis clean" style="width:150px;height:25px"
				title="可以自动生成"data-toggle="popover"data-placement="bottom">
			  </div>
	        </div>
	        <div class="row form-group">
	          <label class="col-sm-2 text-right">地址</label>
			  <div class="col-sm-10">
				<input id="serveAddressAdd" name="serveAddressAdd" type="text" class="form-control dis clean">
			  </div>
	        </div>
	        <div class="row form-group">
	          <label class="col-sm-2 text-right">单位</label>
			  <div class="col-sm-10">
				<input id="addressesCompany" type="text" class="form-control dis clean">
			  </div>
	        </div>
	        <div class="row form-group">
	          <label class="col-sm-2 text-right">电话</label>
			  <div class="col-sm-3" style="margin-right:10px">
				<input id="telephone" name="telephone" type="text" class="form-control dis clean" style="width:150px;height:25px">
			  </div>
			  <label class="col-sm-3 text-right">传真</label>
			  <div class="col-sm-2">
				<input id="addressesFax" type="text" class="yuan dis clean" style="width:150px;height:25px">
			  </div>
	        </div>
	      </div>
	      <div class="col-sm-1"></div>
	   </div>
	</div>
	</div>
    <div class="panel panel-default row" style="border:1px solid #F0F0F0;background-color:#FCFCFC">
    <div class="panel-heading">
				<a href="#rule" data-toggle="collapse">相关规则</a>
	</div>
	<div id="rule" class="panel-collapse collapse">
	   <div class="row">
	    <div class="col-sm-5" style="border:1px solid #F0F0F0;margin-left:100px;margin-right:20px;background-color:#FFFFFF">
	      <div class="row form-group">
	        <label class="col-sm-2 text-right">产品名</label>
			<div class="col-sm-10">
		       <input id="productName" type="text" class="form-control clean" name="productName">
			</div>
	      </div>
	      <div class="row form-group">
	        <label class="col-sm-2 text-right">实际件数</label>
			<div class="col-sm-3" style="margin-right:10px">
			  <input value="1" id="productAmount" type="text" class="yuan" style="width:150px;height:25px">
			</div>
			<label class="col-sm-3 text-right">计费数量</label>
			<div class="col-sm-2">
			  <input value="1" id="numberPackages" name="numberPackages" type="text" class="form-control dis" style="width:150px;height:25px">
			</div>
	      </div>
	      <div class="row form-group">
	        <label class="col-sm-2 text-right">体积</label>
			<div class="col-sm-10">
		       <input id="volume" name="volume" type="text" class="form-control clean">
			</div>
	      </div>
	      <div class="row form-group">
	        <label class="col-sm-2 text-right">实际重量</label>
			<div class="col-sm-3" style="margin-right:10px">
			  <input value="1" id="actualWeight" type="text"class="yuan" style="width:150px;height:25px">
			</div>
			<label class="col-sm-3 text-right">计费重量</label>
			<div class="col-sm-2">
			  <input value="1" type="text" id="weight" name="weight" class="form-control dis" style="width:150px;height:25px">
			</div>
	      </div>
	      <div class="row form-group">
	        <label class="col-sm-2 text-right">声明价值</label>
			<div class="col-sm-10">
		       <input id="declaredValue" type="text" class="form-control clean">
			</div>
	      </div>
	    </div>
	    <div class="col-sm-5" style="height:235px;border:1px solid #F0F0F0;background-color:#FFFFFF">
	      <div class="row form-group">
	        <label id="insuranceTypeLab" class="col-sm-2 text-right">保险类型</label>
			<div class="col-sm-3" style="margin-right:10px">
			  <select id="insuranceType" class="form-control clean select" style="width:150px;height:25px" >
			        <option selected = "selected" ></option>
			  </select>
			</div>
			<label class="col-sm-3 text-right">保险费</label>
			<div class="col-sm-2">
			  <input value="0" id="insurancePremium" type="text" class="form-control" style="width:150px;height:25px">
			</div>
	      </div>
	      <div class="row form-group">
	        <label id="originalPackingLab" class="col-sm-2 text-right">原包装</label>
			<div class="col-sm-3" style="margin-right:10px">
			  <select id="originalPacking" class="form-control clean select" style="width:150px;height:25px">
			        <option selected = "selected" ></option> 
			  </select>
			</div>
			<label id="actualPackingLab" class="col-sm-3 text-right">实际包装</label>
			<div class="col-sm-2">
			  <select id="actualPacking" class="form-control clean select" style="width:150px;height:25px">
			        <option selected = "selected" ></option>
			  </select>
			</div>
	      </div>
	      <div class="row form-group">
	        <label class="col-sm-2 text-right">包装费</label>
			<div class="col-sm-3" style="margin-right:10px">
			  <input value="0" id="packingCharges" type="text" class="form-control" style="width:150px;height:25px">
			</div>
			<label class="col-sm-3 text-right">包装要求</label>
			<div class="col-sm-2">
			  <input id="packagingRequirements" type="text" class="form-control clean" style="width:150px;height:25px">
			</div>
	      </div>
	      <div class="row form-group">
	        <label id="settlementModeLab" class="col-sm-2 text-right">结算方式</label>
			<div class="col-sm-2">
		       <select id="settlementMode" class="form-control clean select" style="width:70px;height:25px">
			        <option selected = "selected" ></option>
			  </select>
			</div>
			<label class="col-sm-2 text-right">代收款</label>
			<div class="col-sm-2">
		       <input id="replaceReceivables" type="text" value="0" class="form-control" style="width:70px;height:25px">
			</div>
			<label class="col-sm-2 text-right">到付款</label>
			<div class="col-sm-2">
		       <input id="paymentArrival" type="text" value="0" class="form-control" style="width:65px;height:25px">
			</div>
	      </div>
	      <div class="row form-group">
	        <div class="col-sm-2"></div>
			<div class="col-sm-3" style="margin-right:10px">
			 <shiro:hasPermission name="GZDLR：JS">
			  <input id="count" type="button" value="计算" style="width:150px" class="btn btn-inverse">
			 </shiro:hasPermission>
			</div>
			<label class="col-sm-3 text-right">预收费</label>
			<div class="col-sm-2">
			  <input type="text" id="preCharge" name="preCharge" class="form-control dis clean" style="width:150px;height:25px">
			</div>
	      </div>
	    </div>
	  </div>
    </div>
    </div>
    <div class="panel panel-default row" style="border:1px solid #F0F0F0;background-color:#FCFCFC">
    <div class="panel-heading">
				<a href="#message" data-toggle="collapse">相关信息</a>
	</div>
	<div id="message" class="panel-collapse collapse">
      <div class="row">
	    <div class="col-sm-5" style="border:1px solid #F0F0F0;margin-left:100px;margin-right:20px;background-color:#FFFFFF">
	      <div class="row form-group" style="height:37px">
			<div class="col-sm-1">
		       <input id="feedbackSign"  type="checkbox" value="1" class="checkbox">
			</div>
	        <label class="col-sm-2">反馈签收</label>
			<div class="col-sm-1">
		       <input id="holidayIsCollect"  type="checkbox" value="1" class="checkbox">
			</div>
			<label class="col-sm-3">节假日可收货</label>
			<label class="col-sm-2 text-right">送达时限</label>
			<div class="col-sm-2">
		       <input id="serviceTimeLimit" type="text" class="form-control clean" style="width:117px;height:25px">
			</div>
	      </div>
	      <div class="row form-group">
	        <label id="processingMethodLab" class="col-sm-2 text-right">处理方式</label>
			<div class="col-sm-3" style="margin-right:10px">
			  <select id="processingMethod" class="form-control clean select" style="width:150px;height:25px">
			        <option selected = "selected" ></option>
			  </select>
			</div>
			<label id="signBackLab" class="col-sm-3 text-right">签单返回</label>
			<div class="col-sm-2">
			  <select id="signBack" class="form-control clean select" style="width:150px;height:25px">
			        <option  selected = "selected" ></option>
			  </select>
			</div>
	      </div>
	    </div>
	    <div class="col-sm-5" style="border:1px solid #F0F0F0;background-color:#FFFFFF">
	      <div class="row form-group" style="margin-top:15px">
	        <label class="col-sm-2 text-right" style="margin-top:25px">重要提示</label>
			<div class="col-sm-10">
		       <textarea id="importantTips" class="form-control clean"></textarea>
			</div>
	      </div>
	    </div>
	  </div>
    </div>
    </div>
    </div>
   </form>  
<script type="text/javascript"> 
   $("#myModal1").modal('show');

   //时间插件
   $("#serviceTimeLimit").datetimepicker({
		format : "yyyy-mm-dd",
		autoclose : true,
		todayBtn : true,
		language : 'zh-CN',
		pickerPosition : "bottom-left",
		minView : 2,
		startDate : '2017-01-01',
		minDate:'1970-01-01',
		endDate:new Date() 
	    });
   
    $("#searTime").datetimepicker({
		format : "yyyy-mm-dd",
		autoclose : true,
		todayBtn : true,
		language : 'zh-CN',
		pickerPosition : "bottom-left",
		minView : 2,
		startDate : '2017-01-01',
		minDate:'1970-01-01',
		endDate:new Date(),
		autoclose:true,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0
	    }); 
   $("[data-toggle='popover']").popover();
   //下拉框插件    拿到数据
   $("#select").click(function(){
	  $("#myModal").modal('show'); 
	  $.ajax({
			url : "workSheet/findBusinessNoticeNo",
			type : "post",
			data:{
				"workSheetNo":""
			},
			traditional : true,
			success : function(response) {
			var select = $("#YWTZD");
	        for(var i=0;i<response.length;i++){
	        item=$("<option></option>");
	        item.append(response[i]);
	        item.attr("value",response[i]);
	        select.append(item);
	        };
	         select.append("<option selected='selected'></option>"); 
		 }
     }); 
   });
   $("#YWTZD").select2({
	   tags: true
   });
   $("#product").select2();
   $("#stowageRequirement").select2();
   $("#insuranceType").select2();
   $("#originalPacking").select2();
   $("#actualPacking").select2();
   $("#settlementMode").select2();
   $("#processingMethod").select2();
   $("#signBack").select2();
   
   $("#businessNoticeNo").dblclick(function(){
	   $.ajax({
			url : "workSheet/createYW",
			type : "post",
			traditional : true,
			success : function(response) {
				$("#businessNoticeNo").val(response);
	        }
	   });
   });
   
   $("#customerNo1").dblclick(function(){
	   $.ajax({
			url : "workSheet/createKH",
			type : "post",
			data:{
				str:"寄件人"
			},
			traditional : true,
			success : function(response) {
				$("#customerNo1").val(response);
	        }
	   });
   });
   
   $("#addressesNo").dblclick(function(){
	   $.ajax({
			url : "workSheet/createKH",
			type : "post",
			data:{
				str:"收件人"
			},
			traditional : true,
			success : function(response) {
				$("#addressesNo").val(response);
	        }
	   });
   });
   
   $.ajax({
		url : "workSheet/findHelpFile",
		type : "post",
		data:{
			"recordName":$("#productLab").html()
		},
		traditional : true,
		success : function(response) {
		var select = $("#product");
       for(var i=0;i<response.length;i++){
       item=$("<option></option>");
       item.append(response[i]);
       item.attr("value",response[i]);
       select.append(item);
       };
	  }
  });
   
   $.ajax({
		url : "workSheet/findHelpFile",
		type : "post",
		data:{
			"recordName":$("#stowageRequirementLab").html()
		},
		traditional : true,
		success : function(response) {
		var select = $("#stowageRequirement");
        for(var i=0;i<response.length;i++){
        item=$("<option></option>");
        item.append(response[i]);
        item.attr("value",response[i]);
        select.append(item);
        };
	  }
   });
   
   $.ajax({
		url : "workSheet/findHelpFile",
		type : "post",
		data:{
			"recordName":$("#insuranceTypeLab").html()
		},
		traditional : true,
		success : function(response) {
		var select = $("#insuranceType");
       for(var i=0;i<response.length;i++){
       item=$("<option></option>");
       item.append(response[i]);
       item.attr("value",response[i]);
       select.append(item);
       };
	  }
   });
   
   $.ajax({
		url : "workSheet/findHelpFile",
		type : "post",
		data:{
			"recordName":$("#originalPackingLab").html()
		},
		traditional : true,
		success : function(response) {
		var select = $("#originalPacking");
        for(var i=0;i<response.length;i++){
        item=$("<option></option>");
        item.append(response[i]);
        item.attr("value",response[i]);
        select.append(item);
        };
	  }
   });
   
   $.ajax({
		url : "workSheet/findHelpFile",
		type : "post",
		data:{
			"recordName":$("#actualPackingLab").html()
		},
		traditional : true,
		success : function(response) {
		var select = $("#actualPacking");
        for(var i=0;i<response.length;i++){
        item=$("<option></option>");
        item.append(response[i]);
        item.attr("value",response[i]);
        select.append(item);
        };
	   }
    });
   
   $.ajax({
		url : "workSheet/findHelpFile",
		type : "post",
		data:{
			"recordName":$("#settlementModeLab").html()
		},
		traditional : true,
		success : function(response) {
		var select = $("#settlementMode");
        for(var i=0;i<response.length;i++){
        item=$("<option></option>");
        item.append(response[i]);
        item.attr("value",response[i]);
        select.append(item);
        };
	   }
    });
   
   $.ajax({
		url : "workSheet/findHelpFile",
		type : "post",
		data:{
			"recordName":$("#processingMethodLab").html()
		},
		traditional : true,
		success : function(response) {
		var select = $("#processingMethod");
        for(var i=0;i<response.length;i++){
        item=$("<option></option>");
        item.append(response[i]);
        item.attr("value",response[i]);
        select.append(item);
        };
	   }
    });
   
   $.ajax({
		url : "workSheet/findHelpFile",
		type : "post",
		data:{
			"recordName":$("#signBackLab").html()
		},
		traditional : true,
		success : function(response) {
		var select = $("#signBack");
        for(var i=0;i<response.length;i++){
        item=$("<option></option>");
        item.append(response[i]);
        item.attr("value",response[i]);
        select.append(item);
        };
	   }
   });
   
   
	 
   //业务通知单改变事件
   $("#YWTZD").change(function(){
	   $("#businessNoticeNo").val($("#YWTZD").val());
	   $.ajax({
			url : "workSheet/findBusinessRecsiptByBus",
			type : "post",
			data:{
				"businessNoticeNo":$("#YWTZD").val()
			},
			traditional : true,
			success : function(response) {
	        $("#product").val(response.product);
	        $("#customerNo1").val(response.customerNo);
	        $("#customerName").val(response.customerName);
	        $("#phoneNum").val(response.phoneNum);
	        $("#contacts").val(response.contacts);
	        $("#telephone").val(response.telephone);
	        $("#serveAddressAdd").val(response.serveAddress);
	        $("#fetchAddressSender").val(response.fetchAddress);
	        $("#productName").val(response.productName);
	        $("#weight").val(response.weight);
	        $("#volume").val(response.volume);
	        $("#numberPackages").val(response.numberPackages);
	        $("#preCharge").val(response.precharge);
		 }
	   });
	   
	   $.ajax({
			url : "workSheet/findWorkOrderByBus",
			type : "post",
			data:{
				"businessNoticeNo":$("#businessNoticeNo").val()
			},
			traditional : true,
			success : function(response) {
	        $("#empName").val(response.empName);
	        $("#takeOrgName").val(response.takeOrgName);
		 }
	   });
   });
   
   vali();
   
   //checkbox
   
 //添加专区
    $("#add").click(function(){
       //遍历复选框并赋值
       $(".checkbox").each(function(){
    		   if(this.checked){
    			   this.value=0;
    			   
    		   }else{
    			   this.value=1;
    		   }
       }); 
	   $.ajax({
		   url:"workSheet/addWorkSheet",
		   type:"post",
		   beforeSend:function(){
			    //重新校验
			   	$('#Form').data('bootstrapValidator').validate();
			    //获取校验结果
			   	var result =  $('#Form').data('bootstrapValidator').isValid();
				if(!result){
					toastr.warning("校验失败");
					return false;
				}
				
				return true;
		   },
		   data:{//workSheet:workSheetParam(),
			     //sender:senderParam(),
			     //addresses:addressesParam(),
			     //rule:ruleParam()
			      workSheetNo:$("#workSheetNo").val(),
				  product:$("#product").val(),
				  businessNoticeNo:$("#businessNoticeNo").val(),
				  empName:$("#empName").val(),
				  pickup:$("#takeOrgName").val(),
				  stowageRequirement:$("#stowageRequirement").val(),
				  specialOfferNo:$("#specialOfferNo").val(),
				  senderName:$("#customerName").val(),
				  senderNo:$("#customerNo").val(),
				  senderAddress:$("#fetchAddressSender").val(),
				  senderCompany:$("#senderCompany").val(),
				  senderPhone:$("#phoneNum").val(),
				  senderFax:$("#senderFax").val(),
				  workSheetNo:$("#workSheetNo").val(),
				  addressesName:$("#contacts").val(),
				  addressesNo:$("#addressesNo").val(),
				  addressesAddress:$("#serveAddressAdd").val(),
				  addressesCompany:$("#addressesCompany").val(),
				  addressesPhone:$("#telephone").val(),
				  addressesFax:$("#addressesFax").val(),
				  workSheetNo:$("#workSheetNo").val(),
				  billingQuantity:$("#numberPackages").val(),
				  actualWeight:$("#actualWeight").val(),
				  productName:$("#productName").val(),
				  size:$("#volume").val(),
			      insuranceType:$("#insuranceType").val(),
			      declaredValue:$("#declaredValue").val(),
			      insurancePremium:$("#insurancePremium").val(),
			      originalPacking:$("#originalPacking").val(),
			      actualPacking:$("#actualPacking").val(),
			      packingCharges:$("#packingCharges").val(),
			      packagingRequirements:$("#packagingRequirements").val(),
			      productAmount:$("#productAmount").val(),
			      billingWeight:$("#weight").val(),
			      settlementMode:$("#settlementMode").val(),
			      preCharge:$("#preCharge").val(),
			      replaceReceivables:$("#replaceReceivables").val(),
			      paymentArrival:$("#paymentArrival").val(),
			      feedbackSign:$("#feedbackSign").val(),
			      holidayIsCollect:$("#holidayIsCollect").val(),
			      serviceTimeLimit:$("#serviceTimeLimit").val(),
			      processingMethod:$("#processingMethod").val(),
			      signBack:$("#signBack").val(),
			      importantTips:$("#importantTips").val(),
			      workSheetNo:$("#workSheetNo").val(),
		   },
		   success:function(result){
				if (result == "success") {
					 toastr.success("新增成功");
					 $('.clean').val("");
					 $('#Form').data("bootstrapValidator").resetForm();
				} else {
					toastr.error("新增失败");
				}
		   } 
	   });  
	  
	  
	  
   }); 
   
   //修改专区
   $("#update").click(function(){
	     $.ajax({
		   url:"workSheet/updateWorkSheet",
		   type:"post",
		   data:{
			   workSheetNo:$("#workSheetNo").val(),
				  product:$("#product").val(),
				  businessNoticeNo:$("#businessNoticeNo").val(),
				  empName:$("#empName").val(),
				  pickup:$("#takeOrgName").val(),
				  stowageRequirement:$("#stowageRequirement").val(),
				  specialOfferNo:$("#specialOfferNo").val(),
				  senderName:$("#customerName").val(),
				  senderNo:$("#customerNo").val(),
				  senderAddress:$("#fetchAddressSender").val(),
				  senderCompany:$("#senderCompany").val(),
				  senderPhone:$("#phoneNum").val(),
				  senderFax:$("#senderFax").val(),
				  workSheetNo:$("#workSheetNo").val(),
				  addressesName:$("#contacts").val(),
				  addressesNo:$("#addressesNo").val(),
				  addressesAddress:$("#serveAddressAdd").val(),
				  addressesCompany:$("#addressesCompany").val(),
				  addressesPhone:$("#telephone").val(),
				  addressesFax:$("#addressesFax").val(),
				  workSheetNo:$("#workSheetNo").val(),
				  billingQuantity:$("#numberPackages").val(),
				  actualWeight:$("#actualWeight").val(),
				  productName:$("#productName").val(),
				  size:$("#volume").val(),
			      insuranceType:$("#insuranceType").val(),
			      declaredValue:$("#declaredValue").val(),
			      insurancePremium:$("#insurancePremium").val(),
			      originalPacking:$("#originalPacking").val(),
			      actualPacking:$("#actualPacking").val(),
			      packingCharges:$("#packingCharges").val(),
			      packagingRequirements:$("#packagingRequirements").val(),
			      productAmount:$("#productAmount").val(),
			      billingWeight:$("#weight").val(),
			      settlementMode:$("#settlementMode").val(),
			      preCharge:$("#preCharge").val(),
			      replaceReceivables:$("#replaceReceivables").val(),
			      paymentArrival:$("#paymentArrival").val(),
			      feedbackSign:$("#feedbackSign").val(),
			      holidayIsCollect:$("#holidayIsCollect").val(),
			      serviceTimeLimit:$("#serviceTimeLimit").val(),
			      processingMethod:$("#processingMethod").val(),
			      signBack:$("#signBack").val(),
			      importantTips:$("#importantTips").val(),
			      workSheetNo:$("#workSheetNo").val(),
		   },
		   success:function(result){
				if (result == "success") {
					 toastr.success("保存成功");
					 $('.clean').val("");
					 $('#Form').data("bootstrapValidator").resetForm();
				} else {
					toastr.error("保存失败");
				}
		   } 
	   });  
	   
   });
 
   //计算金额的方法
   $("#count").click(function(){
			var placeOfDispatch = $("#fetchAddressSender").val();
			var receivingLand = $("#serveAddressAdd").val();
			 $.ajax({
				url:"freightCharge/findFreightChargeByPlaceOfDispatchAndReceivingLand.action",
				type:"post",
				data:{
					"placeOfDispatch":placeOfDispatch,
					"receivingLand":receivingLand
				},
				traditional:true,
				success:function(response){
					var weight = parseFloat(document.getElementById("weight").value);
					var insurancePremium = parseInt(document.getElementById("insurancePremium").value);
					var packingCharges = parseInt(document.getElementById("packingCharges").value);
					if(0<weight && weight<1){
						$("#preCharge").val(response.firstHeavy);
					}else{
						if($("#product").val()=="快件"){
						   $("#preCharge").val((weight-1)*response.secondHeavy+response.firstHeavy+5+insurancePremium+packingCharges); 
						}else{
						   $("#preCharge").val((weight-1)*response.secondHeavy+response.firstHeavy+insurancePremium+packingCharges);
						} 
					}
					
				}
			}); 
			
	});

   //页面输入校验
   $("#workSheetNo").blur(function(){
	   var workSheetNo = $("#workSheetNo").val();
	   var temp = /^TCBOS-\d{5}$/;
	   if(temp.test(workSheetNo)==true){
		   $("input").attr("disabled",false);
		   $("#businessNoticeNo").attr("disabled",false);
		   $.ajax({
				url : "workSheet/validate",
				type : "post",
				data:{
					"workSheetNo":workSheetNo
				},
				traditional : true,
				success : function(response) {
		        if(response=="success"){
		        	toastr.success("输入正确");
		        	$("#update").attr("disabled",true);
		            $("input").attr("disabled",false);
		        }else{
		        	layer.msg('工作单号重复,是否进行工作单保存操作？',{
						  time : 0 //不自动关闭
						  ,btn : [ '确定', '取消' ],
						  yes : function(index) {
							layer.close(index);
							$("#add").attr("disabled",true);
							
							 $.ajax({
									url : "workSheet/findWorkSheet",
									type : "post",
									data:{
										"workSheetNo":workSheetNo
									},
									traditional : true,
									success : function(response) {
							        $("#workSheetNo").val(response.workSheetNo);
							        $("#product").val(response.product);
							        $("#businessNoticeNo").val(response.businessNoticeNo);
							        $("#stowageRequirement").val(response.stowageRequirement);
							        $("#empName").val(response.empName);
							        $("#takeOrgName").val(response.pickup);
							        $("#customerName").val(response.sender.senderName);
							        $("#customerNo1").val(response.sender.senderNo);
							        $("#fetchAddressSender").val(response.sender.senderAddress);
							        $("#senderCompany").val(response.sender.senderCompany);
							        $("#phoneNum").val(response.sender.senderPhone);
							        $("#senderFax").val(response.sender.senderFax);
							        $("#contacts").val(response.addresses.addressesName);
							        $("#addressesNo").val(response.addresses.addressesNo);
							        $("#serveAddressAdd").val(response.addresses.addressesAddress);
							        $("#addressesCompany").val(response.addresses.addressesCompany);
							        $("#telephone").val(response.addresses.addressesPhone);
							        $("#addressesFax").val(response.addresses.addressesFax);
							        $("#productName").val(response.rule.productName);
							        $("#productAmount").val(response.rule.productAmount);
							        $("#numberPackages").val(response.rule.billingQuantity);
							        $("#volume").val(response.rule.size);
							        $("#actualWeight").val(response.rule.actualWeight);
							        $("#weight").val(response.rule.billingWeight);
							        $("#declaredValue").val(response.rule.declaredValue);
							        $("#insuranceType").val(response.rule.insuranceType);
							        $("#insurancePremium").val(response.rule.insurancePremium);
							        $("#originalPacking").val(response.rule.originalPacking);
							        $("#actualPacking").val(response.rule.actualPacking);
							        $("#packingCharges").val(response.rule.packingCharges);
							        $("#packagingRequirements").val(response.rule.packagingRequirements);
							        $("#settlementMode").val(response.rule.settlementMode);
							        $("#replaceReceivables").val(response.rule.replaceReceivables);
							        $("#paymentArrival").val(response.rule.paymentArrival);
							        $("#preCharge").val(response.rule.preCharge);
							        $("#feedbackSign").val(response.rule.feedbackSign);
							        $("#holidayIsCollect").val(response.rule.holidayIsCollect);
							        $("#serviceTimeLimit").val(response.rule.serviceTimeLimit);
							        $("#processingMethod").val(response.rule.processingMethod);
							        $("#signBack").val(response.rule.signBack);
							        $("#importantTips").val(response.rule.importantTips);
								 }
						    });   
						   if($("#businessNoticeNo").val()!=null){
							   $(".dis").attr("disabled",true);
						   }
					      }
				       });
		            $("#workSheetNo").attr("disabled",false);
		        }
			 }
		   });
	   }else{
		   toastr.error("工作单格式不正确");
		   $("input").attr("disabled",true);
		   $("#businessNoticeNo").attr("disabled",true);
		   $("#workSheetNo").attr("disabled",false);
	   }
	   
   });
   //保险类型
   $("#insuranceType").change(function(){
	   if($("#insuranceType").val()=="无保险"){
		   $("#insurancePremium").attr("disabled",true);
		   $("#insurancePremium").val(0);
	   }else{
		   $("#insurancePremium").attr("disabled",false);
	   }
	   
   });
   //包装类型
   $("#actualPacking").change(function(){
	   $("#packagingRequirements").attr("disabled",true);
	   if($("#actualPacking").val()=="快递袋"){
		   $("#packingCharges").attr("disabled",true);
		   $("#packingCharges").val(2);
	   }else if($("#actualPacking").val()=="纸箱"){
		   $("#packingCharges").attr("disabled",true);
		   $("#packingCharges").val(5);
	   }else if($("#actualPacking").val()=="木箱"){
		   $("#packingCharges").attr("disabled",true);
		   $("#packingCharges").val(10);
	   }else{
		   $("#packingCharges").attr("disabled",false);
		   $("#packagingRequirements").attr("disabled",false);
		   $("#packingCharges").val(0);
	   }
	   
   });
   
   //取消功能
   $("#cancel").click(function(){
	   window.location.reload();
   });
    
   //提交校验
   function vali(){
   $('#Form').bootstrapValidator({
	   live: 'enabled',
       fields: {
    	   workSheetNo: {
               validators: {
                   notEmpty: {
                       message: '工作单号不能为空'
                   }
               }
           },
           customerName: {
               validators: {
                   notEmpty: {
                       message: '寄件人名不能为空'
                   }
               }
           },
           fetchAddressSender: {
               validators: {
                   notEmpty: {
                       message: '寄件人地址不能为空'
                   }
               }
           },
           phoneNum: {
               validators: {
                   notEmpty: {
                       message: '寄件人电话不能为空'
                   },regexp:{
                   	regexp:/^1[3|4|5|8][0-9]\d{4,8}$/,
                	message: '电话号码格式不正确'
                }
               }
           },
           contacts: {
               validators: {
                   notEmpty: {
                       message: '收件人不能为空'
                   }
               }
           },
           serveAddressAdd: {
               validators: {
                   notEmpty: {
                       message: '收件人地址不能为空'
                   }
               }
           },
           telephone: {
               validators: {
                   notEmpty: {
                       message: '收件人电话不能为空'
                   },regexp:{
                   	regexp:/^1[3|4|5|8][0-9]\d{4,8}$/,
                	message: '电话号码格式不正确'
                }
               }
           },
           productName: {
               validators: {
                   notEmpty: {
                       message: '产品名不能为空'
                   }
               }
           },
           numberPackages: {
               validators: {
                   notEmpty: {
                       message: '实际件数不能为空'
                   },stringLength: {  
                       min: 0,  
                       max: 8,  
                       message: '实际件数必须在0到8位之间'  
                   },regexp:{
                      	regexp:/^\d+(\.\d+)?$/,
                    	message: '只能输入正整数'
                    }
               }
           },
           weight: {
               validators: {
                   notEmpty: {
                       message: '实际重量不能为空'
                   },stringLength: {  
                       min: 0,  
                       max: 8,  
                       message: '实际重量必须在0到8位之间'  
                   },regexp:{
                      	regexp:/^\d+(\.\d+)?$/,
                    	message: '只能输入正数'
                    }
               }
           }
       }
   });
   }
   function workSheetParam(){
	   var workSheet = {
				  workSheetNo:$("#workSheetNo").val(),
				  product:$("#product").val(),
				  businessNoticeNo:$("#businessNoticeNo").val(),
				  empName:$("#empName").val(),
				  pickup:$("#takeOrgName").val(),
				  stowageRequirement:$("#stowageRequirement").val(),
				  specialOfferNo:$("#specialOfferNo").val(),
	   }
	   return workSheet;
   }
   function senderParam(){
	   var sender = {
				  senderName:$("#customerName").val(),
				  senderNo:$("#customerNo1").val(),
				  senderAddress:$("#fetchAddressSender").val(),
				  senderCompany:$("#senderCompany").val(),
				  senderPhone:$("#phoneNum").val(),
				  senderFax:$("#senderFax").val(),
				  workSheetNo:$("#workSheetNo").val(),
		  }
	   return sender;
   }   
   function addressesParam(){
	   var addresses = {
				  addressesName:$("#contacts").val(),
				  addressesNo:$("#addressesNo").val(),
				  addressesAddress:$("#serveAddressAdd").val(),
				  addressesCompany:$("#addressesCompany").val(),
				  addressesPhone:$("#telephone").val(),
				  addressesFax:$("#addressesFax").val(),
				  workSheetNo:$("#workSheetNo").val(),
		  }
	   return addresses;
   }	  
   function ruleParam(){
	   var rule = {
				  billingQuantity:$("#numberPackages").val(),
				  actualWeight:$("#actualWeight").val(),
				  productName:$("#productName").val(),
				  size:$("#volume").val(),
			      insuranceType:$("#insuranceType").val(),
			      declaredValue:$("#declaredValue").val(),
			      insurancePremium:$("#insurancePremium").val(),
			      originalPacking:$("#originalPacking").val(),
			      actualPacking:$("#actualPacking").val(),
			      packingCharges:$("#packingCharges").val(),
			      packagingRequirements:$("#packagingRequirements").val(),
			      productAmount:$("#productAmount").val(),
			      billingWeight:$("#weight").val(),
			      settlementMode:$("#settlementMode").val(),
			      preCharge:$("#preCharge").val(),
			      replaceReceivables:$("#replaceReceivables").val(),
			      paymentArrival:$("#paymentArrival").val(),
			      feedbackSign:$("#feedbackSign").val(),
			      holidayIsCollect:$("#holidayIsCollect").val(),
			      serviceTimeLimit:$("#serviceTimeLimit").val(),
			      processingMethod:$("#processingMethod").val(),
			      signBack:$("#signBack").val(),
			      importantTips:$("#importantTips").val(),
			      workSheetNo:$("#workSheetNo").val(),
				  
		  }
	   return rule;
   }	
   
   //任务操作
   $("#work").click(function(){
	   $("#myModal1").modal('show');
   });
   
   $(function () {

	    //1.初始化Table
	    var oTable = new TableInit();
	    oTable.Init();
	});
   
   var TableInit = function () {
	    var oTableInit = new Object();
	    //初始化Table
	    oTableInit.Init = function () {
	        $('#table').bootstrapTable({
				url : 'workSheet/findAllWorkSheet', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 200, //每页的记录行数（*） 
				pageList : [ 3, 25, 50, 100 ], //可供选择的每页的行数（*） 
				minimumCountColumns : 1, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				height : 180, //行高，如果没有设置height属性，表格自动根据记录条数决定表格高度 
				uniqueId : "workSheetNo", //每一行的唯一标识，一般为主键列 
				onClickRow : function(row) {
					if(row.integraliyStatus=='信息完整'){
						toastr.success("此工作单信息完整，不需要进行补录");
					}else{
						layer.msg('此工作单信息不完整，是否进行补录操作',{
							  time : 0 //不自动关闭
							  ,btn : [ '确定', '取消' ],
							  yes : function(index) {
								layer.close(index);
								$("#add").attr("disabled",true);
								$("#work").attr("disabled",true);
								$("#myModal1").modal('hide');
								//通过工作单快速录入或者工作单导入带入信息
							       $.ajax({
										url : "workSheet/findWorkSheet",
										type : "post",
										data:{
											"workSheetNo":row.workSheetNo
										},
										traditional : true,
										success : function(response) {
								        $("#workSheetNo").val(response.workSheetNo);
								        $("#product").val(response.product);
								        $("#businessNoticeNo").val(response.businessNoticeNo);
								        $("#stowageRequirement").val(response.stowageRequirement);
								        $("#empName").val(response.empName);
								        $("#takeOrgName").val(response.pickup);
								        $("#customerName").val(response.sender.senderName);
								        $("#customerNo1").val(response.sender.senderNo);
								        $("#fetchAddressSender").val(response.sender.senderAddress);
								        $("#senderCompany").val(response.sender.senderCompany);
								        $("#phoneNum").val(response.sender.senderPhone);
								        $("#senderFax").val(response.sender.senderFax);
								        $("#contacts").val(response.addresses.addressesName);
								        $("#addressesNo").val(response.addresses.addressesNo);
								        $("#serveAddressAdd").val(response.addresses.addressesAddress);
								        $("#addressesCompany").val(response.addresses.addressesCompany);
								        $("#telephone").val(response.addresses.addressesPhone);
								        $("#addressesFax").val(response.addresses.addressesFax);
								        $("#productName").val(response.rule.productName);
								        $("#productAmount").val(response.rule.productAmount);
								        $("#numberPackages").val(response.rule.billingQuantity);
								        $("#volume").val(response.rule.size);
								        $("#actualWeight").val(response.rule.actualWeight);
								        $("#weight").val(response.rule.billingWeight);
								        $("#declaredValue").val(response.rule.declaredValue);
								        $("#insuranceType").val(response.rule.insuranceType);
								        $("#insurancePremium").val(response.rule.insurancePremium);
								        $("#originalPacking").val(response.rule.originalPacking);
								        $("#actualPacking").val(response.rule.actualPacking);
								        $("#packingCharges").val(response.rule.packingCharges);
								        $("#packagingRequirements").val(response.rule.packagingRequirements);
								        $("#settlementMode").val(response.rule.settlementMode);
								        $("#replaceReceivables").val(response.rule.replaceReceivables);
								        $("#paymentArrival").val(response.rule.paymentArrival);
								        $("#preCharge").val(response.rule.preCharge);
								        $("#feedbackSign").val(response.rule.feedbackSign);
								        $("#holidayIsCollect").val(response.rule.holidayIsCollect);
								        $("#serviceTimeLimit").val(response.rule.serviceTimeLimit);
								        $("#processingMethod").val(response.rule.processingMethod);
								        $("#signBack").val(response.rule.signBack);
								        $("#importantTips").val(response.rule.importantTips);
								        
									 }
							    });   
							   if($("#businessNoticeNo").val()!=null){
								   $(".dis").attr("disabled",true);
							   }												
						      }
					       });
						
					}
					
				},
				columns: [{
	                checkbox: true
	            }, {
	                field: 'workSheetNo',
	                title: '工作单号'
	            }, {
	                field: 'integraliyStatus',
	                title: '完整性状态'
	            }, {
	                field: 'workSheetSource',
	                title: '工作单来源'
	            }, {
	                field: 'drawerTime',
	                title: '开单时间',
	                formatter : getLocalTime
	            }]
			});
	    };

	    //得到查询的参数
	    return oTableInit;
	};
	
	$("#search").click(function(){
		var cli={
				url:"workSheet/findAllWorkSheet?integraliyStatus="+$("#sear").val()+"&workSheetSource="+$("#searSou").val()+"&drawerTime="+$("#searTime").val(),
				silent:true,
		}
		$('#table').bootstrapTable('refresh', cli);
	});
		  
	
	function getLocalTime(ns){
		if(ns!=null&&ns!="null"&&ns!=""){
		var now = new Date(ns);
		var year = now.getYear()+1900;
		var month = now.getMonth()+1;
		var date = now.getDate();
		var hour=now.getHours();
		var minute=now.getMinutes(); 
		return year+"-"+month+"-"+date +" "+hour+":"+minute;
		}else{
			return " ";
		}
	}
	
</script>










</body>
</html>
