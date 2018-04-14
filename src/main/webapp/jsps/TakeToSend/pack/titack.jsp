<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>包装信息录入</title>

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
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
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

</head>
<body>
<div class="panel-body">
	<div class="row">
		<div class="col-sm-6">
			  <div class="form-group">
			    <label class="col-sm-2" for="workSheetNo">工作单号</label>
			    <div class="col-sm-4">
				    <input type="text" class="form-control" name="workSheetNo" id="workSheetNo" placeholder="请输入工作单号">
			    </div>
				<label class="col-sm-2" for="outId">包装人员</label>
			    <div class="col-sm-4">
				    <input type="text" class="form-control" id="outId">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2" for="productAmount">实际件数</label>
			    <div class="col-sm-4">
				    <input type="text" class="form-control" name="productAmount" id="productAmount" >
			    </div>
			    <label class="col-sm-2" for="actualWeight">实际重量</label>
			    <div class="col-sm-4">
				    <input type="text" class="form-control" name="actualWeight" id="actualWeight">
			    </div>
			  </div>
			  <div class="form-group">
			  	<label class="col-sm-2" for="billingQuantity">计费重量</label>
			    <div class="col-sm-4">
				    <input type="text" class="form-control" name="billingQuantity" id="billingQuantity">
			    </div>
			    <label class="col-sm-2" for="size">实际体积</label>
			    <div class="col-sm-4">
				    <input type="text" class="form-control" name="size" id="size">
			    </div>
			  </div>
			  <div class="form-group">
			  	<label class="col-sm-2" for="packingCharges">包装费</label>
			    <div class="col-sm-4">
				    <input type="text" class="form-control" name="packingCharges" id="packingCharges">
			    </div>
			    <label class="col-sm-2" for="actualPacking">实际包装</label>
			    <div class="col-sm-4" >
				   <select class="form-control" id="actualPacking" name="actualPacking">
				   	<option value="carton">纸箱</option>
				   	<option value="wooden">木箱</option>
				   	<option value="delivery">小件箱</option>
				   	<option value="defend">防震板</option>
				   	<option value="density">高密度防震板</option>
				   	<option value="strength">编制袋</option>
				   	<option value="pneuma">气垫膜</option>
				   	<option value="package">打包带(塑料)</option>
				   	<option value="packageTie">打包带</option>
				   </select>
			    </div>
			  </div>
			  <div class="form-group">
			  	<label class="col-sm-2" for="drawerName">入库人</label>
			    <div class="col-sm-4">
				    <input type="text" class="form-control" name="drawerName" id="drawerName">
			    </div>
			    <label class="col-sm-2" for="drawerTime">入库时间</label>
			    <div class="col-sm-4">
				    <input type="text" class="form-control time" name="drawerTime" id="drawerTime">
			    </div>
			  </div>
				<button id="appeancer" class="btn btn-primary col-sm-12 pull-right" >查询</button>

				<button class="btn btn-primary col-sm-12 pull-right" id="Impeck">计算运费</button>
			  
			</form>
		</div>
		<div class="col-sm-6">
			<table class="table table-hover">
				<tr>
			      <td>个</td>
			      <td>包装项目</td>
			      <td>体积</td>
			      <td>等级</td>
			      <td>服务费</td>
			      <td>材料费</td>
			    </tr>
			    <tr class="carton">
			      <td>个</td>
			      <td>1号纸箱</td>
			      <td>8</td>
			      <td>无</td>
			      <td>25.00</td>
			      <td>21.00</td>
			    </tr>
			    <tr class="carton">
			      <td>个</td>
			      <td>2号纸箱</td>
			      <td>7</td>
			      <td>无</td>
			      <td>17.00</td>
			      <td>14.00</td>
			    </tr>
			    <tr class="carton">
			      <td>个</td>
			      <td>3号纸箱</td>
			      <td>6</td>
			      <td>无</td>
			      <td>12.00</td>
			      <td>10.00</td>
			    </tr>
			    <tr class="carton">
			      <td>个</td>
			      <td>4号纸箱</td>
			      <td>5</td>
			      <td>一级</td>
			      <td>8.00</td>
			      <td>5.50</td>
			    </tr>
			    <tr class="carton">
			      <td>个</td>
			      <td>4号纸箱</td>
			      <td>4</td>
			      <td>二级</td>
			      <td>5.00</td>
			      <td>4.50</td>
			    </tr>
			    <tr class="carton">
			      <td>个</td>
			      <td>5号纸箱</td>
			      <td>3</td>
			      <td>一级</td>
			      <td>4.00</td>
			      <td>3.20</td>
			    </tr>
			    <tr class="carton">
			      <td>个</td>
			      <td>5号纸箱</td>
			      <td>2</td>
			      <td>二级</td>
			      <td>3.00</td>
			      <td>2.00</td>
			    </tr>
			    <tr class="carton">
			      <td>个</td>
			      <td>6号纸箱</td>
			      <td>1</td>
			      <td>无</td>
			      <td>2.90</td>
			      <td>1.50</td>
			    </tr>
			    <tr class="wooden">
			      <td>个</td>
			      <td>1号木箱</td>
			      <td>8</td>
			      <td>无</td>
			      <td>30.00</td>
			      <td>26.00</td>
			    </tr>
			    <tr class="wooden">
			      <td>个</td>
			      <td>2号木箱</td>
			      <td>7</td>
			      <td>无</td>
			      <td>22.00</td>
			      <td>19.00</td>
			    </tr>
			    <tr class="wooden">
			      <td>个</td>
			      <td>3号木箱</td>
			      <td>6</td>
			      <td>无</td>
			      <td>17.00</td>
			      <td>15.00</td>
			    </tr>
			    <tr class="wooden">
			      <td>个</td>
			      <td>4号木箱</td>
			      <td>5</td>
			      <td>一级</td>
			      <td>13.00</td>
			      <td>10.50</td>
			    </tr>
			    <tr class="wooden">
			      <td>个</td>
			      <td>4号木箱</td>
			      <td>4</td>
			      <td>二级</td>
			      <td>10.00</td>
			      <td>9.50</td>
			    </tr>
			    <tr class="wooden">
			      <td>个</td>
			      <td>5号木箱</td>
			      <td>3</td>
			      <td>一级</td>
			      <td>9.00</td>
			      <td>8.20</td>
			    </tr>
			    <tr class="wooden">
			      <td>个</td>
			      <td>5号木箱</td>
			      <td>2</td>
			      <td>二级</td>
			      <td>8.00</td>
			      <td>7.00</td>
			    </tr>
			    <tr class="wooden">
			      <td>个</td>
			      <td>6号木箱</td>
			      <td>1</td>
			      <td>无</td>
			      <td>7.90</td>
			      <td>6.50</td>
			    </tr>
			    <tr class="delivery">
			      <td>个</td>
			      <td>小件箱</td>
			      <td>4</td>
			      <td>无</td>
			      <td>0.00</td>
			      <td>3.3</td>
			    </tr>
			    <tr class="defend">
			      <td>张</td>
			      <td>防震板</td>
			      <td>5</td>
			      <td>无</td>
			      <td>9.00</td>
			      <td>8.00</td>
			    </tr>
			    <tr class="density">
			      <td>张</td>
			      <td>高密度防震板</td>
			      <td>5</td>
			      <td>无</td>
			      <td>20.00</td>
			      <td>18.00</td>
			    </tr>
			    <tr class="strength">
			      <td>米</td>
			      <td>编制袋</td>
			      <td>无</td>
			      <td>无</td>
			      <td>6.00</td>
			      <td>5.00</td>
			    </tr>
			    <tr class="pneuma">
			      <td>米</td>
			      <td>气垫膜</td>
			      <td>无</td>
			      <td>无</td>
			      <td>1.20</td>
			      <td>1.00</td>
			    </tr>
			    <tr class="package">
			      <td>根</td>
			      <td>打包带(塑料)</td>
			      <td>无</td>
			      <td>无</td>
			      <td>0.00</td>
			      <td>1.00</td>
			    </tr>
			    <tr class="packageTie">
			      <td>根</td>
			      <td>打包带</td>
			      <td>无</td>
			      <td>无</td>
			      <td>0.00</td>
			      <td>4.00</td>
			    </tr>
			</table>
		</div>
		
	</div>
</div>

<script type="text/javascript">

$(function(){
	
	$('.time').datetimepicker({  
		format: 'hh:mm:ss',
        language: 'ch',
        pickDate: false,
        pickTime: true 
    });
	$('#appeancer').click(function(e){
		e.preventDefault();
		var workSheetNo = $('#workSheetNo').val();
		if(workSheetNo != null && workSheetNo != ''){
			$.post('pack/listUserApperance',{workSheetNo:workSheetNo},function(data){
				$('input').each(function(){
					if(this.name){
						this.value=data[this.name];
					}
				});
			})
		}
	});
	$('#Impeck').click(function(e){
		e.preventDefault();
		var size =$('#size').val();
		var actualPacking = $('#actualPacking').val();
		var productAmount = $('#productAmount').val();
		if(actualPacking != null && actualPacking != ''){
			$('.'+actualPacking).each(function(){
				if($(this).children().eq(2).text() == size){
					var price = parseFloat($(this).children().eq(4).text())+parseFloat($(this).children().eq(5).text());
					var packingCharges = price*productAmount;
					$('#packingCharges').val(packingCharges);
					return;
				}
			})
		}
	});
	
});



</script>

</body>
</html>