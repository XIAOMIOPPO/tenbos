<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>运费计算</title>

<link rel="stylesheet" type="text/css"href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"rel="stylesheet">
<link href="static/select/bootstrap-select.css" rel="stylesheet" type="text/css">
<link href="static/toastr/toastr.css"rel="stylesheet" type="text/css">

<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>

<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/distpicker.data.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/distpicker.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/main.js"></script>
<script type="text/javascript" src="static/select/bootstrap-select.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<style type="text/css">
	
	
	.describle{
		background-color:#F5F5F5;
		width:95%;
		margin:auto;
		margin-top:70px;
	}
	
	h4.freight-tit {
	    font-size: 24px;
	}
	
	.cx-table {
	    width: 800px;
	    font-size: 15px;
	}
	
	
	.result{
		width:95%;
		margin:auto;
		margin-bottom:70px;
	}
	
	#thead{
		background-color:#F5F5F5;
		height:50px;
		text-align:center;
		font-size:16px;
		font-family:"Microsoft YaHei";
	}
	
	#tbody{
		background-color:#FCFCFC;
		height:50px;
		text-align:center;
		font-size:14px;
		font-family:"Microsoft YaHei";
	}
	
	
</style>

<script type="text/javascript">
	$(function(){
		$("#productType").selectpicker();
		$("#countPrice").click(function(){
			//拿到收货地,寄件地和重量的值
			var placeOfDispatch = $("#placeOfDispatch").val();
			var receivingLand = $("#receivingLand").val();
			var weights = $("#weight").val();
			//如果这个值去掉空格不等于空
			if((placeOfDispatch.trim() != null && placeOfDispatch != "") && 
					(receivingLand.trim() !=null && receivingLand != "") &&
					(weights.trim() != null && weights != "")){
				//拿到收货地的省市和寄件地的省市的值
				var placeProvince = $("#province2").val()+$("#city2").val();
				var recevingProvince = $("#province3").val()+$("#city3").val();
				//如果这两个值相等
				if(placeProvince==recevingProvince){
					//拿到产品类型的值
					var product = $("#productType").val();
					//如果产品类型的值等于航空
					if(product=="航空"){
						//就将结果隐藏并告知原因
						$(".result").css("display","none");
						toastr.error("计算失败 原因:同城不能使用航空");
					}else{
						//否则就将结果显示
						$(".result").css("display","block");
					}
				}else{
					$(".result").css("display","block");
				}
			}else{
				//隐藏结果
				toastr.error("计算失败 原因:寄件地/收货地/重量不能为空");
				$(".result").css("display","none");
			}
			
			//将重量的值转换为float类型
			var weight1 = parseFloat(document.getElementById("weight").value);
			//取天花板值
			var weighta = Math.ceil(weight1);
			//拿到产品类型的值
			var product = $("#productType").val();
			//将拿到的值赋值给下面的表
			$("#heavy").html(weighta);
			$("#products").html(product);
			//异步请求计算运费
			 $.ajax({
				url:"freightCharge/findFreightChargeByPlaceOfDispatchAndReceivingLand.action",
				type:"post",
				data:{
					"placeOfDispatch":placeOfDispatch,
					"receivingLand":receivingLand
				},
				traditional:true,
				success:function(response){
					var product = $("#productType").val();
					var secondHeavy=(weighta-1)*response.secondHeavy+response.firstHeavy;
					if(product=="快件"){
						if(placeProvince==recevingProvince){
							$("#days").html("1~2天");
						}else{
							$("#days").html("2~4天");
						}
						if(0<weighta && weighta<1){
							$("#money").html(response.firstHeavy+(response.firstHeavy)*0.5);
						}else{
							$("#money").html(secondHeavy+secondHeavy*0.5);
						}
					}else if(product=="航空"){
						if(placeProvince==recevingProvince){
							$("#days").html("1~2天");
						}
						
						if(0<weighta && weighta<1){
							$("#money").html(response.firstHeavy*2);
						}else{
							$("#money").html(secondHeavy*2);
						}
					}else{
						if(placeProvince==recevingProvince){
							$("#days").html("1~2天");
						}else{
							$("#days").html("3~5天");
						}
						if(0<weighta && weighta<1){
							$("#money").html(response.firstHeavy);
						}else{
							$("#money").html(secondHeavy);
						}
					}
				}
			}); 
			
		});
		
		$("#weight").blur(function(){
			var weight = parseFloat(document.getElementById("weight").value);
			var temp=/^\d+(\.\d+)?$/;
			if(temp.test(weight)==false){
				$("#countPrice").attr("disabled",true);
				toastr.error("错误:您输入的值为空或者不是正数");
			}else if(weight>99999){
				$("#countPrice").attr("disabled",true);
				toastr.error("错误:所输入的值过大");
			}else{
				$("#countPrice").attr("disabled",false);
			}
		});
		
		$("#placeOfDispatch").click(function(){
			$('#myModal2').show();
			$("#subUp").click(function(){
				var province = $("#province2").val();
				var city = $("#city2").val();
				var district = $("#district2").val();
				var all = $("#all").val();
				$("#placeOfDispatch").attr("value",province+city+district+all);
				$("#myModal2").hidden();
			});
			
		});
		
		$("#receivingLand").click(function(){
			$("#myModal3").show();
			$("#sub").click(function(){
				var province = $("#province3").val();
				var city = $("#city3").val();
				var district = $("#district3").val();
				var aoo = $("#aoo").val();
				$("#receivingLand").attr("value",province+city+district+aoo);
				$("#myModal3").hidden();
			});
		});
	});
	 
	
</script>

</head>

<body class = "default">
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="acceptance">
			<div class="col-xs-12 col-sm-12">
				<form role="form">
					<div class="form-group sershIn">
						<div class="col-md-7 col-sm-7">
							<label for="name" class="labelFont">寄件地</label> 
							<input type="text" class="form-control"name = "placeOfDispatch" id = "placeOfDispatch" 
							placeholder="寄件地(省|市必填):省\直辖市|市(|区\县). 如：湖南省|长沙市|雨花区" data-toggle="modal" data-target="#myModal2"/>
						</div>
					</div>
				</form>
			 </div>
			 <div class="col-xs-12 col-sm-12">	
				<div class="form-group sershIn">
					<form role="form">
						<div class="form-group sershIn">
							<div class="col-md-7 col-sm-7">
								<label for="name" class="labelFont">收货地</label> 
								<input type="text" class="form-control"id = "receivingLand" name = "receivingLand" 
								placeholder="收货地(省|市必填 ):省\直辖市|市(|区\县). 如：广东省|深圳市|宝安区" data-toggle="modal" data-target="#myModal3"/>
							</div>
						</div>
					</form>
				</div>
			 </div>
			 
			  <div class="col-xs-12 col-sm-12">	
					<div class="form-group sershIn">
						<form role="form">
							<div class="form-group sershIn">
								<div class="col-md-2 col-sm-2">
									<label for="name" class="labelFont">重量</label> 
									<input type="text" class="form-control" id = "weight" onblur="checkCount(this)" 
									placeholder="请输入大于0.1Kg的重量 " name = "weight"/>
								</div>
								<div class="col-md-2 col-sm-2">
									<label for="name" class="labelFont">产品类型</label> 
									<br/>
									<select id="productType" class="selectpicker bla bla bli"data-live-search="true">
										<option>暜件</option>
										<option>快件</option>
										<option id="airport">航空</option>
									</select>
								</div>
								<div class="col-md-2">
									<label>&nbsp;</label>
									<input type="button" class="form-control" value = "计算价格" id="countPrice"
									style="background-color:#7D7DFF;color:white;width:100px;"/>
								</div>
							</div>
						</form>
					</div>
			 </div>
		</div>
	</div>
			 
	<hr>&nbsp;&nbsp;&nbsp;&nbsp;<hr>
	 <div class = "result" style = "display:none;">
	 	<h4 class = "freight-tit">查询结果</h4>
	 	<table class = "cx-table">
	 		<thead id = "thead">
	 			<tr>
		 			<td>产品类型</td>
		 			<td>重量</td>
		 			<td>预计到达时间</td>
		 			<td>金额</td>
	 			</tr>
	 		</thead>
	 		<tbody id = "tbody">
	 			<tr>
	 				<td><span id="products"></span></td>
	 				<td><span id = "heavy"></span></td>
	 				<td id="days"></td>
	 				<td>
	 					&yen;<span id = "money"></span>
	 				</td>
	 			</tr>
	 		</tbody>
	 	</table>
	 </div>
	 
	 
	 
	 <div class = "describle">
	 		<ul>
			<li>说明:</li>
			
			<li>1、此价格只适用于一般货物的标准快递服务；非一般货物（贵重物品、高档手机、名牌包、高档首饰、高档手表、精密仪器、生物制药、</li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;恒温需求货物、易碎物品等）需在此价格水平上浮25%-40%，具体请咨询当地快递。</li>
			
			<li>2、此报价系统个别城市将无法提供服务，具体是否可服务详情敬请查询取派区域或拨打全国统一客服热线4006789000。</li>
			
			<li>3、此报价系统采取不足1Kg取1Kg的方法计算运费,如:2.1kg取3Kg</li>
			</ul>
			<ul>
			<li>准时送达承诺：本快递承诺按上述时间准时将您的物品递送到运单注明的收件人手中，如若延误，将予以减免运费。</li>
			</ul>
			
			<ul>
			<li>具体标准为:</li>
			
			<li>(1) 快件产品：晚点免单-晚点则运费全免；</li>
			
			<li>(2) 暜件产品：不享有准时承诺-因分拣等货、找特殊派送资源需额外时间。</li>
			
			<li>(县级及以下偏远地区不在本承诺范畴中）。</li>
	 		</ul>
	 </div>
	 
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">寄件地址</h4>
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
						</div>
						<div>&nbsp;</div>
						<input type="text" id = "all" class="form-control"placeholder="详细地址" style="width:426px;"/>
					</form>
				</div>
				<div class="modal-footer">
					<button id="subUp" type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal2">确认</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
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
					<h4 class="modal-title" id="myModalLabel">收货地址</h4>
				</div>
				<div class="modal-body">
					<form class="form-inline" role="form">
						<div data-toggle="distpicker">
							<div class="form-group">
								<label class="sr-only" for="province3">Province</label> <select
									class="form-control" id="province3"
									data-province="---- 选择省 ----"></select>
							</div>
							<div class="form-group">
								<label class="sr-only" for="city3">City</label> <select
									class="form-control" id="city3" data-city="---- 选择市 ----"></select>
							</div>
							<div class="form-group">
								<label class="sr-only" for="district3">District</label> <select
									class="form-control" id="district3"
									data-district="---- 选择区 ----"></select>
							</div>
							<div>&nbsp;</div>
							<input type="text" id = "aoo" class="form-control"placeholder="详细地址" style="width:426px;"/>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button id="sub" type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal3">确认</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>