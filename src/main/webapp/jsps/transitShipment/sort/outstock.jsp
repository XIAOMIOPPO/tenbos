<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出库</title>
<base href="${pageContext.request.contextPath}/"></base>
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="static/toastr/toastr.css" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-file/css/fileinput.min.css"
	rel="stylesheet">
<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-file/js/fileinput.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript" src="jsps/transitShipment/sort/js/outstock.js"></script>

<script type="text/javascript">

$(function(){
	
	
	
	
	
});


</script>

</head>
<body>

<div class="panel-body">
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="btn-group">
				<button class="btn btn-success">新增</button>
				<button class="btn btn-info">保存</button>
				<button class="btn btn-danger">取消</button>
				<button class="btn btn-primary">确认</button>
				<button class="btn btn-info">列表显示</button>
				<button class="btn btn-primary">查询</button>
				<button class="btn btn-info">导入</button>
				<button class="btn btn-primary">对比</button>
				<button class="btn btn-info">货票号导入</button>
			</div>
		</div>
	</div>
	
	<div class="panel panel-default">
	<div class="panel-body">
		<ul id="myTab" class="nav nav-tabs">
		    <li class="active">
		        <a href="#card" data-toggle="tab">
		            	卡片
		        </a>
		    </li>
		    <li class="">
		        <a href="#list" data-toggle="tab">
		            	列表
		        </a>
		    </li>
		</ul>
		
		<div class="tab-content">
			<!-- panel start -->
			<div class="tab-pane fade in active" id="card">
				<!-- form start -->
		    	<div class="panel panel-default">
						<div class="panel-body">
							 
						<form class="form-horizontal" role="form">
							  <div class="form-group">
							   <label for="" class="col-sm-1 control-label" style="width: 120px">出库交接单号</label>
								 <div class="col-sm-2">
								      <input type="text" class="form-control" id="cbox">
								</div>
								<div class="col-sm-4">
							          <input type="checkbox" id="phone1"><span>按分组生成物流</span>
						        </div>
						     </div>
						     <div class="form-group">
						        <label for="" class="col-sm-1 control-label" style="width: 64px" >类型 </label>     
								 <div class="col-sm-2">
								     <select class="form-control">
								        <option>长途物流交接单</option>
								     </select>
								</div>
								<div class="rowGroup">
								<label for="" class="col-sm-1 control-label" style="width: 140px" >线路资源</label>     
								 <div class="col-sm-2">
								      <input type="text" class="form-control" id="" placeholder="线路资源">      
								</div>
								</div>
								<div class="rowGroup">
								<label for="" class="col-sm-1 control-label" style="width: 140px" >线路资源</label>     
								 <div class="col-sm-2">
								      <input type="text" class="form-control" id="" placeholder="线路资源">
								</div>
								<button>...</button>
								</div>
						     </div>
						     <div class="form-group">
						     <div class="rowGroup">
								<label for="" class="col-sm-1 control-label" style="width: 91px" >物流司机</label>     
								 <div class="col-sm-2">
								      <input type="text" placeholder="物流司机" class="form-control" id="">
								</div>
								</div>
								<div class="rowGroup">
								<label for="" class="col-sm-1 control-label" style="width: 112px" >物流司机</label>     
								 <div class="col-sm-2">
								      <input type="text" class="form-control" id="">
								</div>
								</div>
						     </div>
							 </form>
						</div>
				</div><!-- form end -->
				
				<!-- inner tab start -->
				<ul id="myTab" class="nav nav-tabs">
			        <li class="active">
				        <a href="#details" data-toggle="tab">
				            	交接单明细
				        </a>
			        </li>
			        <li class="">
				        <a href="#delivery" data-toggle="tab">
				            	发货信息
				        </a>
			        </li>
			        <li class="">
				        <a href="#pick" data-toggle="tab">
				            	提货信息
				        </a>
			        </li>
			        <li class="">
				        <a href="#were" data-toggle="tab">
				            	货票号
				        </a>
			        </li>
				</ul><!-- inner tab end -->
				
				<!-- content start -->
				<div class="tab-content">
					<!-- detail start -->
					<div class="tab-pane fade in active" id="details">
					    <table id="detTable"></table>
					</div><!-- detail end -->
					<!-- delivery start -->
					<div class="tab-pane fade in" id="delivery">
					     <table id="delTable"></table>
					     <div class="btn-group">
					       <button value="同总件数">同总件数</button>
					       <button value="同剩余票数">同剩余票数</button>
					       <button value="保存" >保存</button>
					       
					     </div>
					</div><!-- delivery end -->
		 			<!-- pick start -->
					<div class="tab-pane fade in" id="pick">
					    <table id="pickTable"></table>
					</div><!-- pick end -->
					<!-- were start -->
					<div class="tab-pane fade in" id="were">
					    <table id="wereTable"></table>
					</div><!-- were end -->
				
				</div><!-- content end -->
				
			</div><!-- panel end -->
		    <!-- panel2 start -->
			<div class="tab-pane fade in " id="list">
				<div class="col-md-6">
		    	  <table id="listTable"></table>
				</div>
				<div class="col-md-6">
		    	  <table id="lstTable"></table> 
				</div>
			</div><!-- panel2 end -->
		    		    
		</div>
	</div>

</div>
	
</div>


	






</body>
</html>