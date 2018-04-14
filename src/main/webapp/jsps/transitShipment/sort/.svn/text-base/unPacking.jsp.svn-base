<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>拆包处理</title>

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
			<div class="panel-body">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top:15px">
						<div class="col-sm-3" style="margin-left:-80px">
							<label class="control-label col-lg-6"
								for="txt_search_workSheetNo">合包号</label>
							<div class="col-lg-6">
								<input type="text" class="form-control"
									id="packageNo">
							</div>	
						</div>
						<div class="col-sm-3" style="margin-left:-80px">
							<label class="control-label col-lg-6"
								for="txt_search_workSheetNo">封签号</label>
							<div class="col-lg-6">
								<input type="text" class="form-control"
									id="packageNo">
							</div>	
						</div>
						<div class="col-sm-3" style="margin-left:-80px">
							<label class="control-label col-lg-6"
								for="txt_search_workSheetNo">到达地</label>
							<div class="col-lg-6">
								<input type="text" class="form-control"
									id="packageNo">
							</div>	
						</div>
						<div class="col-sm-3" style="margin-left:-80px">
							<label class="control-label col-lg-6"
								for="txt_search_workSheetNo">送达时限</label>
							<div class="col-lg-6">
								<input type="text" class="form-control"
									id="packageNo">
							</div>	
						</div>
						<div class="col-sm-3" style="margin-left:-80px">
							<label class="control-label col-lg-6"
								for="txt_search_workSheetNo">特殊保障</label>
							<div class="col-lg-6">
								<input type="text" class="form-control"
									id="packageNo">
							</div>	
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3" style="margin-left:-80px">
							<label class="control-label col-lg-6"
								for="txt_search_workSheetNo">总票数</label>
							<div class="col-lg-6">
								<input type="text" class="form-control"
									id="packageNo">
							</div>	
						</div>
						<div class="col-sm-3" style="margin-left:-80px">
							<label class="control-label col-lg-6"
								for="txt_search_workSheetNo">总件数</label>
							<div class="col-lg-6">
								<input type="text" class="form-control"
									id="packageNo">
							</div>	
						</div>
						<div class="col-sm-3" style="margin-left:-80px">
							<label class="control-label col-lg-6"
								for="txt_search_workSheetNo">总重量</label>
							<div class="col-lg-6">
								<input type="text" class="form-control"
									id="packageNo">
							</div>	
						</div>
						<div class="col-sm-3" style="margin-left:-80px">
							<label class="control-label col-lg-6"
								for="txt_search_workSheetNo">总体积</label>
							<div class="col-lg-6">
								<input type="text" class="form-control"
									id="packageNo">
							</div>	
						</div>
						<div class="col-sm-3" style="margin-left:-80px">
							<label class="control-label col-lg-6"
								for="txt_search_workSheetNo">配载要求</label>
							<div class="col-lg-6">
								<input type="text" class="form-control"
									id="packageNo">
							</div>	
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3" style="margin-left:-80px">
							<label class="control-label col-lg-6"
								for="txt_search_workSheetNo">拆包人</label>
							<div class="col-lg-6">
								<input type="text" class="form-control"
									id="packageNo">
							</div>	
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div  class="panel-body" style="padding-bottom:0px;">
		<table id="tb_departments"></table>
	</div>
	<script type="text/javascript">
		$(function(){
			$('#tb_departments').bootstrapTable({
				url : '', //请求后台的URL（*）
				method : 'post', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 sortable
				sortOrder : "asc", //排序方式
				queryParams : queryParams,//传递参数（*） 
				sidePagination : "client", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 8, //每页的记录行数（*） 
				pageList : [ 8, 16, 25 ], //可供选择的每页的行数（*） 
				search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
				strictSearch : true,
				showColumns : true, //是否显示所有的列 
				showRefresh : true, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "packageId", //每一行的唯一标识，一般为主键列 
				showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				columns : [ {
					checkbox : true
				}, {
					field : '',
					title : '条码号'	
				}, {
					field : '',
					title : '特殊保障'
				}, {
					field : '',
					title : '品名'
				}, {
					field : '',
					title : '到达地'
				}, {
					field : '',
					title : '票数'
				}, {
					field : '',
					title : '实际件数'
				}, {
					field : '',
					title : '件数'
				}, {
					field : '',
					title : '重量'
				}, {
					field : '',
					title : '体积'
				}, {
					field : '',
					title : '到达时限'
				}, {
					field : '',
					title : '重要提示'
				}, {
					field : '',
					title : '配载要求'
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
	</script>
</body>
</html>