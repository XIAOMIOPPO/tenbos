<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="${pageContext.request.contextPath}/"></base>
<title id="Description">打印</title>
<meta name="description"
	content="This sample demonstrates how we can bind jQWidgets TreeGrid widget to Array Data by using jQWidgets DataAdapter plugin.">
<meta name="viewport"
	content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />
<link rel="stylesheet" href="static/select/bootstrap-select.css">
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">
<link rel="stylesheet" href="static/toastr/toastr.css">
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/select/bootstrap-select.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript">
	$(function(){
		$("#d_search").click(function(){
			var wno = $("#wno").val();
			if(wno==null||wno==''){
				toastr.warning("请输入工作单号！");
			}else{
				$.ajax({
					url : "workSheet/findWorkSheet",
					type : "post",
					data:{
						"workSheetNo":wno
					},
					traditional : true,
					success : function(response) {
				        $("#actualWeight").val(response.rule.actualWeight);
				        $("#phoneNum").val(response.sender.senderPhone);
				        $("#stowageRequirement").val(response.stowageRequirement);
				        $("#productAmount").val(response.rule.productAmount);
				        $("#serviceTimeLimit").val(response.rule.serviceTimeLimit);
				        $("#fetchAddressSender").val(response.sender.senderAddress);
					}
		    	}); 
			}
			  
		});
		
		$('#printbig').click(function(){
			var wno = $("#wno").val();
			$('#fprint input').each(function(){
				var val = this.value;
				if(val==null||val==''){
					toastr.warning("工作单号信息不完整！");
					return ;
				}
				
			});
			
			$.post("pack/printPack",{wno:wno,width:200,height:100},function(data){
				window.open("jsps/TakeToSend/pack/titac.jsp");
			});
		
			
		});
		
		$('#printsmall').click(function(){
			var wno = $("#wno").val();
			$('#fprint input').each(function(){
				var val = this.value;
				if(val==null||val==''){
					toastr.warning("工作单号信息不完整！");
					return ;
				}
				
			});
			
			$.post("pack/printPack",{wno:wno,width:300,height:150},function(data){
				window.open("jsps/TakeToSend/pack/titac.jsp");
			});
			
		});
		
		
		
		
		
	});
</script>
</head>
<body>
	
	
	<div class="panel-body" style="padding-bottom:0px;">
		<div class="panel panel-default">
			<div class="panel-body" id="searchbody">
					<ul id="myTab" class="nav nav-tabs">
						<li class="active">
							<a href="#domestic" data-toggle="tab" aria-expanded="true">
								国内
							</a>
						</li>
						<li class="">
							<a href="#international" data-toggle="tab" aria-expanded="false">
								国际
							</a>
						</li>
					</ul>
					<div class="tab-content">
					<!-- 国内工作单 -->
					<div class="tab-pane fade active in" id="domestic">
						<div style="margin-top:20px">
						<form class="form-horizontal" id="fprint" role="form">
							<div class="form-group">
								<label class="col-sm-2 control-label" style="margin-left: -15px;">工作单号</label>
								<div class="col-sm-4">
									<div class="input-group">
								    <input type="text" id="wno" class="form-control" placeholder="请输入工作单号">
								    <span class="input-group-btn">
								        <input type="button" id="d_search" class="btn btn-default" value="查询" />
								    </span>
								</div>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label" style="margin-left: -15px;"> 件数: </label>
								<div class="col-sm-4">
									<input class="form-control" id="productAmount" placeholder="请输入件数" style="margin-left: -20px;" type="text">
								</div>
								<label for="" class="col-sm-2 control-label" style="margin-left: -15px;"> 重量: </label>
								<div class="col-sm-4">
									<input class="form-control" id="actualWeight" placeholder="请填写分拣代码" style="margin-left: -20px;" type="text">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label" style="margin-left: -15px;"> 发货人地址: </label>
								<div class="col-sm-4">
									<input class="form-control" id="fetchAddressSender" placeholder="请填写发货站点" style="margin-left: -20px;" type="text">
								</div>
								<label for="" class="col-sm-2 control-label" style="margin-left: -15px;"> 发货方式: </label>
								<div class="col-sm-4">
									<input class="form-control" id="stowageRequirement" placeholder="请填写发货方式" style="margin-left: -20px;" type="text">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label" style="margin-left: -15px;"> 收货人地址: </label>
								<div class="col-sm-4">
									<input class="form-control" id="serveAddressAdd" placeholder="请填写到货站点" style="margin-left: -20px;" type="text">
								</div>
								<label for="" class="col-sm-2 control-label" style="margin-left: -15px;"> 寄件人联系电话: </label>
								<div class="col-sm-4">
									<input class="form-control" id="phoneNum" placeholder="请填写返货标志" style="margin-left: -20px;" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="margin-left: -15px;"> 时间: </label>
								<div class="col-sm-4">
									<input class="form-control" id="serviceTimeLimit" value="请选择时间" style="margin-left: -20px;" type="text">
								</div>
							</div>

							<div class="modal-footer">
								<!-- 打印按钮 -->
								<button type="button" class="btn btn-primary btn-xs" id="printbig">打印大标签92mm*102mm</button>
								<br>
									<button type="button" class="btn btn-primary btn-xs" id="printsmall" style="margin-top: 10px; width: 156px;">打印小标签92mm*62mm</button>
							</div>
						</form>
						</div>
					</div>
					<!-- 国际工作单 -->
					<div class="tab-pane fade in" id="international">
						<div style="margin-top:20px">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label for="" class="col-sm-2 control-label"> 工作单表: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" placeholder="请填写工作单号" type="text">
								</div>
								<label for="" class="col-sm-2 control-label" style="margin-left: -30px;"> 口岸: </label>
								<div class="col-sm-4">
									<input class="form-control" id="disabledInput" placeholder="请填写出货口岸" type="text">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label"> 货物名称: </label>
								<div class="col-sm-4">
									<input class="form-control" id="productName" placeholder="请填写货物名称" type="text">
								</div>
								<label for="" class="col-sm-2 control-label" style="margin-left: -30px;"> 发货人地址: </label>
								<div class="col-sm-4">
									<input class="form-control" id="fetchAddressSender" placeholder="请填写发站地点" type="text">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label"> 件数: </label>
								<div class="col-sm-4">
									<input class="form-control" id="productAmount" placeholder="请填写货物件数" type="text">
								</div>
								<label for="" class="col-sm-2 control-label" style="margin-left: -30px;"> 收货人地址: </label>
								<div class="col-sm-4">
									<input class="form-control" id="serveAddressAdd" placeholder="请填到站地点" type="text">
								</div>
							</div>
							<!-- 打印按钮 -->
							<div class="modal-footer">
								<button type="button" id="printg" class="btn btn-primary">打印(P)</button>
							</div>
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
</body>
</html>