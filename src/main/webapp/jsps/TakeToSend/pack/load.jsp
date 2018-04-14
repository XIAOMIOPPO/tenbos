<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="${pageContext.request.contextPath}/"></base>
<title id="Description">资源管理</title>
<meta name="description"
	content="This sample demonstrates how we can bind jQWidgets TreeGrid widget to Array Data by using jQWidgets DataAdapter plugin.">
<meta name="viewport"
	content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />
<link rel="stylesheet" type="text/css" href="static/toastr/toastr.css"/>
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css" />
<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript">
	
	$(function(){
		
		var userName = "${sessionScope.user.userName}";
		
		$('#hz').click(function(){
			//工作单号
			var wno = $('#workSheetNo').val();
			
			if(wno==null||wno==''){
				toastr.warning('请扫描条码或输入单号查询');
				return ;
			}
			
			//获取电子称的数据
			var sweight = $('#sweight').val();
			if(sweight==null||sweight==''){
				toastr.warning('请填写重量');
				return ;
			}
			
			//计算重量差
			var cweight = parseFloat(sweight)-parseFloat($('#actualWeight').val());
			//数量
			var num = $('#hnum').val();
			//生成表格数据
			var $tr = $('<tr/>');
			var $td = $('<td/>');
			//条码
			$tr.append($td.clone().append(wno));
			//单号
			$tr.append($td.clone().append(wno));
			//本次重量
			$tr.append($td.clone().append(sweight));
			//件数
			$tr.append($td.clone().append(num));
			//操作时间
			$tr.append($td.clone().append(new Date()));
			//操作人
			$tr.append($td.clone().append(userName));
			
			$('#table').append($tr);
			
			$('#ykj').text(num);
			$('#yhz').text(sweight);
			$('#zlc').text(cweight);
			
			var obj={
					//工作单号
					jobListNo:wno,
					//条码
					stripeCode:wno,
					//本次重量
					thisWeight:sweight,
					//件数
					packagesNum:num,
					nucleatedParts:num,
					gewichtsdifferenz:cweight,
					//到达地
					whither:$('#destination').val(),
					//原重量
					factWeight:$('#actualWeight').val()
			}
			
			//添加荷重记录
			if(wno==null||wno==''){
				toastr.warning('请扫描条码或输入单号查询');
			}else{
				$.post('load/addload',obj,function(data){
					toastr.success('荷重成功');
					reset();
				});
			}
			
			
			
			
		});
		
		
		function reset(){
			$('#ykj').text('');
			$('#yhz').text('');
			$('#zlc').text('');
			$('#wno').val('');
			$('#workSheetNo').val('');
			$('#hnum').val('');
			$('#actualWeight').val('');
			$('#destination').val('');
		}
		
		$('#search').click(function(){
			var no = $('#wno').val();
			if(no==null||no==''){
				toastr.warning('请输入单号查询');
			}else{
				//根据单号查询先关信息
				$.post('workSheet/findWorkSheet',{workSheetNo:no},function(data){
					//填充数据
					if(data){
						$('#workSheetNo').val(no);
						$('#hnum').val(data.rule.billingQuantity);
						$('#actualWeight').val(data.rule.actualWeight);
						$('#destination').val(data.addresses.addressesAddress);
					}else{
						toastr.info('无工作单信息');
					}
				});
			}
			
		});
		
		
		
	});
	
	
	
</script>
</head>
<body>
	
	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-body" id="searchbody">
				<div class="row" style="margin-bottom:20px">
					<div class="col-md-4">
						<form class="form-horizontal" role="form">
							<label for="worksheetNo" class="col-sm-2 col-md-2 control-label">单号</label>
						    <div class="col-sm-1 col-md-10">
						      <input type="text" id="wno" class="form-control" placeholder="请输入名字">
						    </div>
						</form>
					</div>
					<div class="col-md-2">
						<button class="btn btn-primary" id="search">查询</button>
					</div>
					<div class="col-md-2">
						<button class="btn btn-primary" id="hz">荷重</button>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<textarea id="sweight" style="font-size:38px;width:100%;height:100%"></textarea>
					</div>

					<div class="col-md-6">
						<div style="width:100%;height:100%;background:#f5f5f5;padding:10px">
						<form class="form-horizontal" role="form">
						  <div class="form-group">
						    <label for="worksheetNo" class="col-sm-2 col-md-2 control-label" style="font-size:12px">单号</label>
						    <div class="col-sm-4 col-md-4">
						      <input type="text" class="form-control" name="workSheetNo" id="workSheetNo" placeholder="单号">
						    </div>
						    <label for="num" class="col-sm-2 col-md-2 control-label" style="font-size:12px">件数</label>
						    <div class="col-sm-4 col-md-4">
						      <input type="text" class="form-control" name="billingQuantity" id="hnum" placeholder="件数">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="worksheetNo" class="col-sm-2 col-md-2 control-label" style="font-size:12px">原重量</label>
						    <div class="col-sm-4 col-md-4">
						      <input type="text" class="form-control" name="actualWeight" id="actualWeight" placeholder="原重量">
						    </div>
						    <label for="num" class="col-sm-2 col-md-2 control-label" style="font-size:12px">到达地</label>
						    <div class="col-sm-4 col-md-4">
						      <input type="text" class="form-control" name="destination" id="destination" placeholder="到达地">
						    </div>
						  </div>
						</form>
						
						</div>
						<div style="margin-top:5px">
							<div class="col-md-3">已核件</div>
							<div class="col-md-1" id="ykj"></div>
							<div class="col-md-3">已荷重</div>
							<div class="col-md-1" id="yhz"></div>
							<div class="col-md-3">重量差</div>
							<div class="col-md-1" id="zlc"></div>
						</div>
					</div>
				
				</div>
				
				
			</div>
		</div>
		
	</div>
	
	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-body">
				<table class="table table-bordered">
				  <thead>
				    <tr>
				      <th>条码</th>
				      <th>单号</th>
				      <th>本次重量</th>
				      <th>件数</th>
				      <th>操作时间</th>
				      <th>操作人</th>
				    </tr>
				  </thead>
				  <tbody id="table">
				    
				  </tbody>
				</table>
		    </div>
		</div>
	</div>
	
	
	
	
</body>
</html>