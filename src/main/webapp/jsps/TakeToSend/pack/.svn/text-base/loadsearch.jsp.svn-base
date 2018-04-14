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
<script type="text/javascript">
	
	$(function(){
		
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
		
		$('#tb_departments').bootstrapTable({
			url : 'load/findpack', //请求后台的URL（*） 
			method : 'post', //请求方式（*） 
			toolbar : '#toolbar', //工具按钮用哪个容器 
			striped : true, //是否显示行间隔色 
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
			pagination : true, //是否显示分页（*） 
			sortable : false, //是否启用排序 
			sortOrder : "asc", //排序方式
			queryParams : queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset //页码 
				};
				return temp;
			},//传递参数（*） 
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
			pageNumber : 1, //初始化加载第一页，默认第一页 
			pageSize : 8, //每页的记录行数（*） 
			pageList : [8,16,24,32], //可供选择的每页的行数（*） 
			search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
			strictSearch : true,
			showColumns : true, //是否显示所有的列 
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 1, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行 
			height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
			uniqueId : "packId", //每一行的唯一标识，一般为主键列 
			showToggle : true, //是否显示详细视图和列表视图的切换按钮 
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'jobListNo',
				title : '工作单号'
			}, {
				field : 'jobListNo',
				title : '荷重单位'
			}, {
				field : 'packagesNum',
				title : '件数'
			}, {
				field : 'whither',
				title : '到达地'
			}, {
				field : 'factWeight',
				title : '原重量'
			}, {
				field : 'gewichtsdifferenz',
				title : '重量差'
			}, {
				field : 'operateTime',
				title : '称重时间'
			}]
		});
		
		
		$('#sbtn').click(function(e){
			e.preventDefault();
			var opt = {
			    url: "load/findpack",
			    silent: true,
			    query:{      
			    	type:1,
				    level:2,
			        orgName : $('#hzdw').val(),
			        startTime : $('#clientType1').val(),
			        endTime   : $('#phone1').val(),
			        jobListNo : $('#dh').val()
			    }
		    };
			
			if($('#fuhao').val()=='>'){
				opt.query.maxWeight=$('#zlc').val();
			}else{
				opt.query.minWeight=$('#zlc').val();
			}
			
		    $('#tb_departments').bootstrapTable('refresh', opt);
			
		});
		
		
		
	});
	
	
	
</script>
</head>
<body>
	
	
	<div class="panel-body" style="padding-bottom:0px;">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group">
						    <label for="firstname" class="col-sm-1 control-label">荷重单位</label>
						    <div class="col-sm-2">
						      <input type="text" class="form-control" name="orgName" id="hzdw" placeholder="请输入荷重单位">
						    </div>
						     <label class="col-sm-2">
						      含下级<input type="checkbox">
						    </label>
						    <label for="firstname" class="col-sm-1 control-label">称重时间</label>
						    <div class="col-sm-2">
						      <input type="text" class="form-control time" name="startTime" id="start" placeholder="请输入时间">
						    </div>
						    <div class="col-sm-2">
						      <input type="text" class="form-control time" name="endTime" id="end" placeholder="请输入时间">
						    </div>
						    
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-1 control-label">重量差</label>
						    <div class="col-sm-1">
						    	<select class="form-control" id="fuhao">
						    		<option value=">">&gt;</option>
						    		<option value="<">&lt;</option>
						    	</select>
						    </div>
						    <div class="col-sm-3">
						    	<input type="text" class="form-control" name="gewichtsdifferenz" id="zlc" placeholder="请输入重量差">
						    </div>
						    <label for="firstname" class="col-sm-1 control-label">单号</label>
						    <div class="col-sm-2">
						      <input type="text" class="form-control" name="jobListNo" id="dh" placeholder="请输入单号">
						    </div>
						    <div class="col-sm-3">
						    	<button id="sbtn" class="btn btn-primary">查询</button>
						    </div>
					</div>
				</form>
			</div>
		</div>
		<table id="tb_departments"></table>
	</div>
	
	
	
	
</body>
</html>