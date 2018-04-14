<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入库</title>
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
<script type="text/javascript" src="jsps/transitShipment/sort/js/stockin.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-file/js/fileinput.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
</head>
<body>

<div class="panel-body">
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="btn-group">
				<button class="btn btn-success">新增</button>
				<button class="btn btn-primary" id="saveData">保存</button>
				<button class="btn btn-danger" id="cancel">取消</button>
				<button class="btn btn-warning">异常发起</button>
				<button class="btn btn-info">拆包</button>
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
		    <!-- panel1 start-->
		    <div class="tab-pane fade in active" id="card">
		    	<ul class="nav nav-tabs">
				    <li class="active">
				        <a href="#detail" data-toggle="tab">
				            	交接单明细
				        </a>
				    </li>
				    <li class="">
				        <a href="#send" data-toggle="tab">
				            	发货信息
				        </a>
				    </li>
				    <li class="">
				        <a href="#receive" data-toggle="tab">
				            	提货信息
				        </a>
				    </li>
				</ul>
				
				<div class="tab-content">
				    <!-- panel1 start-->
				    <div class="tab-pane active" id="detail">
				    	<div class="row">
				    		<div class="col-md-5" style="margin-top:10px">
				    			<div>
				    				<form class="form-inline" role="form" onsubmit="return false">
									  <div class="form-group">
									    <select class="form-control">
									    	<option>正常入库</option>
									    	<option>二次入库</option>
									    </select>
									  </div>
									  <div class="form-group">
									    <input type="text" id="dbdh" class="form-control" />
									  </div>
									  <button class="btn btn-default" id="tianjia">添加</button>
									  <button class="btn btn-default" id="duibi">对比</button>
									</form>
				    			</div>
				    			<div style="margin-top:10px">
				    				<table id="dbt" class="btable"></table>
				    			</div>
				    		</div>
				    		<div class="col-md-7" style="margin-top:10px">
				    			<div>
				    				<form class="form-inline" role="form" onsubmit="return false">
									  <div class="checkbox">
									     	 <label>
										        <input type="checkbox" name="optionsRadios" id="optionsRadios1" value="option1" checked> 追加导入
										     </label>
									  </div>
									  <button class="btn btn-default">接受数据</button>
									  <button class="btn btn-default"  data-toggle="modal" data-target="#importModal">导入数据</button>
									  <div class="form-group">
									    <input type="text" id="addDataForm" class="form-control" placeholder="可输入条码/合包号/工作单号" />
									  </div>
									   <button class="btn btn-default" id="addData">添加数据</button>
									</form>
				    			</div>
				    			<div style="margin-top:10px">
				    				<table id="drt" class="btable"></table>
				    			</div>
				    		</div>
				    	</div>	
				    </div><!-- panel1 end -->
				    <!-- panel2 start -->
				    <div class="tab-pane" id="send" style="margin-top:10px">
				    	<table id="fh" class="btable"></table>
				    </div><!-- panel2 end -->
				    <!-- panel3 start-->
				    <div class="tab-pane" id="receive" style="margin-top:10px">
				    	<table id="th" class="btable"></table>
				    </div><!-- panel3 end -->
				</div>
		    
		    </div><!-- panel1 end -->
		    <!-- panel2 start -->
		    <div class="tab-pane fade" id="list">
		    	<div class="col-md-6" style="margin-top:10px">
			    	<table id="ltb1"></table>
		    	</div>
				<div class="col-md-6" style="margin-top:10px">
			    	<table id="ltb2"></table>
				</div>
		    </div><!-- panel2 end -->
		</div>
			
			
			
		</div>
	</div>
	
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">对比</h4>
            </div>
            <div class="modal-footer">
            	<div class="col-md-10">
	            	<table id="mtable"></table>
            	</div>
            	<div class="col-md-2">
            		<div style="margin-bottom:20px">
	            		<button id="hqmx" class="btn btn-default">获取明细</button>
            		</div>
    				<div style="margin-bottom:20px">
	            		<button id="dbsj" class="btn btn-default">&nbsp;&nbsp;&nbsp;对比&nbsp;&nbsp;&nbsp;</button>
    				</div>
    				<div>
            			<button id="gl" class="btn btn-default">&nbsp;&nbsp;&nbsp;关联&nbsp;&nbsp;&nbsp;</button>
    				</div>
            	</div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<div class="modal fade" id="importModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">导入数据</h4>
            </div>
            <div class="modal-body">
            	<div class="panel panel-default"
					style="margin-top: 20px;">
					<div class="file-loading">
						<input id="input-file" name="myFile" type="file" multiple />
					</div>
				</div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>



</body>
</html>