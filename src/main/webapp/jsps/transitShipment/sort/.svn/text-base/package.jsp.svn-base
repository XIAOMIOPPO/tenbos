<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>package</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="static/toastr/toastr.css">
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">
<link href="static/bootstrap-file/css/fileinput.min.css"
	rel="stylesheet">
<link href="jsps/TakeToSend/worksheetLead/worksheetLead.css"
	rel="stylesheet">


<script src="static/jquery-3.2.1.min.js"></script>	
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-file/js/fileinput.js"></script>
<script type="text/javascript"
	src="static/bootstrap-file/js/locales/zh.js"></script>

<style type="text/css">
.mid-wrap-tit {
	position: absolute;
	background: #ffffff;
	padding: 3px 6px;
	left: 10px;
	top: -16px;
}

.mid-wrap {
	border: #EEEEEE 3px solid;
	border-radius: 10px;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	-o-border-radius: 10px;
	position: relative;
	margin: 6px 0 15px 0;
	padding: 28px;
}

#import-wrap {
	font-size: 14px;
	line-height: 1.8;
}

.dbselect{
	background:#e4efc9 !important;
}
</style>

</head>

<body>
	<div id="toolbar" class="btn-group">
		<button id="btn_add" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-save" aria-hidden="true"></span> 接受数据
		</button>
		<button id="btn_delete" type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除合包
		</button>
		<button id="btn_addP" type="button" class="btn btn-success">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 生成合包信息
		</button>
		<button id="btn_update" type="button" class="btn btn-primary">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
		</button>
		<div class="col-sm-2" style="margin-left:-16px">
			<button id="btn_leading" type="button" class="btn btn-inverse">
				<span class="glyphicon glyphicon-import" aria-hidden="true"></span> 导入数据
			</button>
		</div>
		<div class="col-sm-3" style="margin-left:-16px">
			<button id="btn_import" type="button" class="btn btn-inverse">
				<span class="glyphicon glyphicon-import" aria-hidden="true"></span> 追加导入数据
			</button>
		</div>
	</div>
	<div  class="panel-body" style="padding-bottom:0px;">
		<table id="tb_departments"></table>
		<div>
			<font size="4px">合包明细（del键删除记录）</font>
		</div>
		<table id="tb_departments1"></table>
	</div>
	
	<!-- 添加模态框（Modal） -->
	<div class="modal fade" id="myModalAdd" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 1050px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-
						hidden="true">&times;</button>
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">添加</h3>
						</div>
						<div class="panel-body">

							<div class="panel-collapse collapse in" id="collapseConsult">
								<form id="addFrom" class="form-horizontal">

									<button id="btn_addPackage" type="button" class="btn btn-success">
										<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>保存
									</button>
									<button id="btn_cal" type="button" class="btn btn-warning"
										" data-dismiss="modal">
										<span class=" glyphicon glyphicon-remove" aria-hidden="true"></span>取消
									</button>
									<div class="form-group" style="margin-top: 15px">

										<label class="control-label col-sm-1" for="txt_search_statu">合包号
										</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="packageNo">
										</div>

										<label class="control-label col-sm-1" for="txt_search_statu">封签号</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="sealNumber"
												disabled>
										</div>

										<label class="control-label col-sm-1" for="txt_search_statu">到达地</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="destination">
										</div>

										<label class="control-label col-sm-1" for="txt_search_statu"
											style="width: 9%">送达时限</label>
										<div class="col-sm-2" style="width: 16%">
											<input type="text" class="form-control time" id="serviceTimeLimit"
												disabled>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-1" for="txt_search_statu">总票数</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="votes"
												disabled>
										</div>

										<label class="control-label col-sm-1" for="txt_search_statu">总件数</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="totalPackages"
												disabled>
										</div>

										<label class="control-label col-sm-1" for="txt_search_statu">总重量</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="totalWeight"
												disabled>
										</div>

										<label class="control-label col-sm-1" for="txt_search_statu" style="width:9%">配送要求</label>
										<div class="col-sm-2" style="width:16%">
											<input type="text" class="form-control" id="stowageRequirement"
												disabled>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-1" for="txt_search_statu">总体积</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="totalVolume" disabled>
										</div>
										<label class="control-label col-sm-1" for="txt_search_statu">合包人</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="packageName" disabled>
										</div>

									</div>

								</form>
							</div>
						</div>
						<div class="modal-footer">

							<table id="table-bottom"></table>

						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	
	<!-- 修改模态框（Modal） -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 1050px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-
						hidden="true">&times;</button>
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">修改</h3>
						</div>
						<div class="panel-body">

							<div class="panel-collapse collapse in" id="collapseConsult">
								<form id="updateFrom" class="form-horizontal">

									<button id="btn_edit" type="button" class="btn btn-success">
										<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>保存
									</button>
									<button id="btn_cal" type="button" class="btn btn-warning"
										" data-dismiss="modal">
										<span class=" glyphicon glyphicon-remove" aria-hidden="true"></span>取消
									</button>
									<div class="form-group" style="margin-top: 15px">

										<label class="control-label col-sm-1" for="txt_search_statu">合包号
										</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="packageNoU" name="packageNo" disabled>
										</div>

										<label class="control-label col-sm-1" for="txt_search_statu">封签号</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="sealNumberU" name="sealNumber"
												disabled>
										</div>

										<label class="control-label col-sm-1" for="txt_search_statu">到达地</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" name="destination" id="destinationU">
										</div>

										<label class="control-label col-sm-1" for="txt_search_statu"
											style="width: 9%">送达时限</label>
										<div class="col-sm-2" style="width: 16%">
											<input type="text" class="form-control time" id="serviceTimeLimitU" name="serviceTimeLimit"
												disabled>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-1" for="txt_search_statu">总票数</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="votesU" name="votes"
												disabled>
										</div>

										<label class="control-label col-sm-1" for="txt_search_statu">总件数</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="totalPackagesU" name="totalPackages"
												disabled>
										</div>

										<label class="control-label col-sm-1" for="txt_search_statu">总重量</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="totalWeightU" name="totalWeight"
												disabled>
										</div>

										<label class="control-label col-sm-1" for="txt_search_statu" style="width:9%">配送要求</label>
										<div class="col-sm-2" style="width:16%">
											<select type="text" class="form-control" name="stowageRequirement" id="stowageRequirementU">
												<option value="禁航空铁路">禁铁路</option>
												<option value="无">无</option>
												<option value="禁航空">禁航空</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-1" for="txt_search_statu">总体积</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" name="totalVolume" id="totalVolumeU" disabled>
										</div>
										<label class="control-label col-sm-1" for="txt_search_statu">合包人</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" name="packageName" id="packageNameU" disabled>
										</div>

									</div>

								</form>
							</div>
						</div>
						<div class="modal-footer">

							<table id="table-bottom1"></table>

						</div>
					</div>
				</div>

			</div>
		</div>

	</div>
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">导入合包数据</h4>
				</div>
				<div class="modal-body">
					<div id="wizard" class="bwizard clearfix">
					
						<div class="tab-content">
							
							<div id="step2" role="tabpanel" class="hide" aria-hidden="true"
								style="">
								<div class="panel panel-default" id="hide"
									style="margin-top: 20px;">
									<div class="file-loading">
										<input id="input-file" name="myFile" type="file" multiple />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<!-- <button type="button" id="next" class="btn btn-primary">下一步</button>
					<button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="cancel()">关闭</button>
					<button type="button" id="after" class="btn btn-primary hide">上一步</button> -->
					<button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="cancel()">完成</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="myModalIN" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">导入合包数据</h4>
				</div>
				<div class="modal-body">
					<div id="wizard" class="bwizard clearfix">
						
						<div class="tab-content">
							
							<div id="stepL2" role="tabpanel" class="hide" aria-hidden="true"
								style="">
								<div class="panel panel-default" id="hide"
									style="margin-top: 20px;">
									<div class="file-loading">
										<input id="input-fileL" name="myFile" type="file" multiple />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="cancel()">完成</button>
					
				</div>
			</div>
		</div>
	</div>


	<!--下载模态框 -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 720px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-
						hidden="true">&times;</button>
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">下载</h3>
						</div>
						<div class="panel-body">
							<form class="form-horizontal" onsubmit="return check()"
								role="form">
								<div id="wizard" class="bwizard clearfix">
			                         <div id="step1" role="tabpanel" class="bwizard-activated "
										aria-hidden="false" style="">
										<div style="margin-top: 20px; margin-bottom: 20px;">
											导入模板下载 &nbsp;&nbsp; <a
												href="PackageServlet?filename=Package.xls">
												<button type="button" class="btn btn-success"
													id="downloadBoard">
													<span aria-hidden="true"></span> 下载
												</button>
											</a>
										</div>
										<div>
											<div class="mid-wrap import">
												<span class="mid-wrap-tit">导入说明</span>
												<h4>填写excel模版</h4>
												<div id="templateCaption">
													<p>1)下载EXCEL空白格式模板,填充数据</p>
													<p>2)模板中红色字体的列为必填项;</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default4" data-dismiss="modal">提交</button>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(function(){
				$('#tb_departments').bootstrapTable({
					url : 'packages/findPackageinfoPagenation', //请求后台的URL（*）
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
					height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "packageId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'packageNo',
						title : '合包号'	
					}, {
						field : 'packageName',
						title : '合包人'
					}, {
						field : 'sealNumber',
						title : '封签号'
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
			
			
			$(function(){
				$('#tb_departments1').bootstrapTable({
					url : '', //请求后台的URL（*） 
					method : 'post', //请求方式（*） 
					//toolbar : '#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : false, //是否启用排序 sortable
					sortOrder : "asc", //排序方式
					queryParams : queryParams1,//传递参数（*） 
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
					uniqueId : "packListId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'oddNo',
						title : '单号'	
					}]
				});
				
			});
			
			
			queryParams1 = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit1 : params.limit, //页面大小 
					offset1 : params.offset //页码
				};
				return temp;
			};
			$(function() {
				$("#btn_add").click(function(){
					$('#myModal2').modal('show');
				})
				
				$("#btn_leading").click(function(){
					$('#myModal').modal('show');
					$('#step2').attr('aria-hidden', false).attr('class',
					'bwizard-activated');
				});
				
				$('#download a').click(
						function(e) {
							e.preventDefault();
							$('#download').attr('class', 'active');
							$('#uploadLead').attr('class', '');
							$('#step1').attr('aria-hidden', false).attr('class','bwizard-activated');
							$('#step2').attr('aria-hidden', true).attr('class', 'hide');
							$('#next').removeClass('hide');
							$('#after').addClass('hide');
							$('#over').addClass('hide');
						});

				$('#next').click(
						function() {
							$('#download').attr('class', '');
							$('#uploadLead').attr('class', 'active');
							$('#step1').attr('aria-hidden', true).attr('class', 'hide');
							$('#step2').attr('aria-hidden', false).attr('class','bwizard-activated');
							$('#next').addClass('hide');
							$('#after').removeClass('hide');
							$('#over').removeClass('hide');
						});
				// div上传导入文件点击事件
				$('#uploadLead a').click(
						function(e) {
							e.preventDefault();
							$('#download').attr('class', '');
							$('#uploadLead').attr('class', 'active');
							$('#step1').attr('aria-hidden', true).attr('class', 'hide');
							$('#step2').attr('aria-hidden', false).attr('class','bwizard-activated');
							$('#next').addClass('hide');
							$('#after').removeClass('hide');
							$('#over').removeClass('hide');
						});
				$('#after').click(
						function() {
							$('#download').attr('class', 'active');
							$('#uploadLead').attr('class', '');
							$('#step1').attr('aria-hidden', false).attr('class','bwizard-activated');
							$('#step2').attr('aria-hidden', true).attr('class', 'hide');
							$('#next').removeClass('hide');
							$('#after').addClass('hide');
							$('#over').addClass('hide');
						});
				
			});
			
			$(function(){
				$("#btn_import").click(function(){
					$("#myModalIN").modal('show');
					$('#stepL2').attr('aria-hidden', false).attr('class',
					'bwizard-activated');
				});
				
				$('#downloadL a').click(
						function(e) {
							e.preventDefault();
							$('#downloadL').attr('class', 'active');
							$('#uploadLeadL').attr('class', '');
							$('#stepL1').attr('aria-hidden', false).attr('class','bwizard-activated');
							$('#stepL2').attr('aria-hidden', true).attr('class', 'hide');
							$('#nextL').removeClass('hide');
							$('#afterL').addClass('hide');
							$('#overL').addClass('hide');
						});

				$('#nextL').click(
						function() {
							$('#downloadL').attr('class', '');
							$('#uploadLeadL').attr('class', 'active');
							$('#stepL1').attr('aria-hidden', true).attr('class', 'hide');
							$('#stepL2').attr('aria-hidden', false).attr('class','bwizard-activated');
							$('#nextL').addClass('hide');
							$('#afterL').removeClass('hide');
							$('#overL').removeClass('hide');
						});
				// div上传导入文件点击事件
				$('#uploadLeadL a').click(
						function(e) {
							e.preventDefault();
							$('#downloadL').attr('class', '');
							$('#uploadLeadL').attr('class', 'active');
							$('#stepL1').attr('aria-hidden', true).attr('class', 'hide');
							$('#stepL2').attr('aria-hidden', false).attr('class','bwizard-activated');
							$('#nextL').addClass('hide');
							$('#afterL').removeClass('hide');
							$('#overL').removeClass('hide');
						});
				$('#afterL').click(
						function() {
							$('#downloadL').attr('class', 'active');
							$('#uploadLeadL').attr('class', '');
							$('#stepL1').attr('aria-hidden', false).attr('class','bwizard-activated');
							$('#stepL2').attr('aria-hidden', true).attr('class', 'hide');
							$('#nextL').removeClass('hide');
							$('#afterL').addClass('hide');
							$('#overL').addClass('hide');
						});
			})
			
				$("#input-file").fileinput({
					uploadUrl : "packages/uploadPackageLead",
					language : 'zh',// 设置语言
					name : "myFile",
					maxFileCount : 1,
					allowedFileExtensions : [ 'xls' ]
				// 接收的文件后缀
				}).on("fileuploaded", function(event, data, previewId, index) {
					//var oTable = new TableInit();
					//oTable.Init(data.response.list);
					$(".kv-file-remove").trigger("click");
					$('#myModal').modal('hide');
					if (data.response.status == "success") {
						$("#tb_departments1").bootstrapTable('removeAll');
						toastr.success("导入成功");
						$("#tb_departments1").bootstrapTable('load', data.response.list);
						$('#quantilyWorkOrderNum').attr('disabled', false);
						$('#delete').attr('disabled', false);
						$('#lead').attr('disabled', false);

						$("#input-file").fileinput('reset');
					} else {
						toastr.error("导入失败");

					}
				});
			
			$("#input-fileL").fileinput({
				uploadUrl : "packages/uploadPackageLead",
				language : 'zh',// 设置语言
				maxFileCount : 1,
				allowedFileExtensions : [ 'xls' ]
			// 接收的文件后缀
			}).on("fileuploaded", function(event, data, previewId, index) {
				//var oTable = new TableInit();
				//oTable.Init(data.response.list);
				$(".kv-file-remove").trigger("click");
				$('#myModalIN').modal('hide');
				if (data.response.status == "success") {
					toastr.success("导入成功");
					$("#tb_departments1").bootstrapTable('append', data.response.list);
					$('#quantilyWorkOrderNum').attr('disabled', false);
					$('#delete').attr('disabled', false);
					$('#lead').attr('disabled', false);
					$("#input-fileL").fileinput('reset');
				} else {
					toastr.error("导入失败");

				}
			});

		function FormatDate (strTime) {
		    var date = new Date(strTime);
		    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
		}
		
		$(function(){
			$('#table-bottom').bootstrapTable({
				//url : 'packages/fileup', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				//toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 sortable
				sortOrder : "asc", //排序方式
				queryParams : queryParams1,//传递参数（*） 
				sidePagination : "client", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 8, //每页的记录行数（*） 
				pageList : [ 8, 16, 25 ], //可供选择的每页的行数（*） 
				//search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
				//strictSearch : true,
				//showColumns : true, //是否显示所有的列 
				//showRefresh : true, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "packListId", //每一行的唯一标识，一般为主键列 
				//showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				//cardView : false, //是否显示详细视图
				//detailView : false, //是否显示父子表
				columns : [ {
					checkbox : true
				}, {
					field : 'oddNo',
					title : '单号'
				}, {
					field : 'productName',
					title : '品名'
				}, {
					field : 'destination',
					title : '到达地'
				}, {
					field : 'vote',
					title : '票数'
				}, {
					field : 'productAmount',
					title : '实际件数'
				}, {
					field : 'number',
					title : '件数'
				}, {
					field : 'actualWeight',
					title : '重量'
				}, {
					field : 'volume',
					title : '体积'
				}, {
					field : 'serviceTimeLimit',
					title : '到达时限',
					formatter : FormatDate
				}, {
					field : 'importantTips',
					title : '重要提示'
				}, {
					field : 'stowageRequirement',
					title : '配送要求'
				}, {
					field : 'inputType', 
					title : '输入类型',
				} ]
			});

		// 初始化工单咨询Table
		// 得到查询的参数
		queryParams2 = function(params) {
			var temp = {
				// 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
				pageSize : params.limit,
				start : params.offset,
			};
			return temp;
		};
	});
		
		//生成合包信息
		$("#btn_addP").click(function(){
			var select = $('#tb_departments1').bootstrapTable(
					'getSelections');
			if (select.length === 0) {
				toastr.warning('请选择一行');
			}else{
				var oddNo1 = [];
				for(var i=0;i<select.length;i++){
					var odd = select[i].oddNo;
					oddNo1.push(odd);
				}
				//定义一个变量
				var packData=null;
				$.post('packages/fileup',{strings:oddNo1},function(data){
					$("#table-bottom").bootstrapTable('removeAll');
					$('#table-bottom').bootstrapTable('append', data);
					//变量接受table-bottom表单里的数据
					packData=data;
					//定义变量
					var totalPackages = 0;
					var votes = 0;
					var totalWeight = 0;
					var totalVolume = 0;
					//遍历table-bottom表单里的数据
					for(var i=0;i<packData.length;i++){
						var destination = packData[i].destination;
						var vote = packData[i].vote;
						votes+=vote;
						var number = packData[i].number;
						totalPackages+=number;
						var actualWeight = packData[i].actualWeight;
						totalWeight+=actualWeight;
						var volume = packData[i].volume;
						totalVolume+=volume;
						var serviceTimeLimit=packData[i].serviceTimeLimit;
						var stowageRequirement = packData[i].stowageRequirement;
					}
					//上传到input框
					$('#destination').val(destination);
					$('#votes').val(votes);
					$('#totalPackages').val(totalPackages);
					$('#totalWeight').val(totalWeight);
					$('#totalVolume').val(totalVolume);
					$('#serviceTimeLimit').val(FormatDate(serviceTimeLimit));
					$('#stowageRequirement').val(stowageRequirement);
					$.ajax({
						url:"packages/getSealNo",
						type:"post",
						success:function(data){
							$("#sealNumber").val(data)
						}
					});
					$.ajax({
						url:"packages/getPackageNo",
						type:"post",
						success:function(data){
							$("#packageNo").val(data)
						}
					});
					$.ajax({
						url:"packages/getPackageName",
						type:"post",
						success:function(data){
							$("#packageName").val(data)
						}
					});
				})
			   $('#myModalAdd').modal('show');

				$('#btn_addPackage').click(function(){
					var listO = $('#table-bottom').bootstrapTable('getData');
					var listP = listO.slice(0);
					$.each(listP,function(i,item){
						delete item['0'];
						delete item['serviceTimeLimit'];
					});
					var obj = {
						packageNo:$('#packageNo').val(),
						sealNumber:$('#sealNumber').val(),
						destination:$('#destination').val(),
						votes:$('#votes').val(),
						totalPackages:$('#totalPackages').val(),
						totalWeight:$('#totalWeight').val(),
						serviceTimeLimit:$('#serviceTimeLimit').val(),
						stowageRequirement:$('#stowageRequirement').val(),
						totalVolume:$('#totalVolume').val(),
						packageName:$('#packageName').val(),
						pkgDetailList:listP
					};
					/* 
					 $.post('packages/addPackageinfo',{packageinfo:obj},function(data){
					}); */
					 
					$.ajax({
						url:"packages/addPackageinfo",
						type:"post",
						data:{packageinfo:JSON.stringify(obj)},
						dataType:'json',
						traditional:true,
						success:function(data){
							if(data.status == 'success'){
								 var objs = $('#tb_departments1').bootstrapTable('getSelections');
								 var str =[]
								 for(var i=0;i<objs.length;i++){
									 str.push(objs[i].oddNo)
								 }
								$("#tb_departments1").bootstrapTable('remove', {field: 'oddNo', values: str});
								$('#myModalAdd').modal('hide');
								toastr.success("添加成功");
								$("#tb_departments").bootstrapTable('refresh');
							}else{
								$('#myModalAdd').modal('hide');
								toastr.error('添加失败');
							}
						}
					});
					
				});
			}
		});
		$(function(){
			$('#table-bottom1').bootstrapTable({
				//url : 'packages/fileup', //请求后台的URL（*）
				method : 'post', //请求方式（*） 
				//toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 sortable
				sortOrder : "asc", //排序方式
				queryParams : queryParams1,//传递参数（*） 
				sidePagination : "client", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 8, //每页的记录行数（*） 
				pageList : [ 8, 16, 25 ], //可供选择的每页的行数（*） 
				//search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
				//strictSearch : true,
				//showColumns : true, //是否显示所有的列 
				//showRefresh : true, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "packListId", //每一行的唯一标识，一般为主键列 
				//showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				//cardView : false, //是否显示详细视图
				//detailView : false, //是否显示父子表
				columns : [ {
					checkbox : true
				}, {
					field : 'oddNo',
					title : '单号'
				}, {
					field : 'productName',
					title : '品名'
				}, {
					field : 'destination',
					title : '到达地'
				}, {
					field : 'vote',
					title : '票数'
				}, {
					field : 'productAmount',
					title : '实际件数'
				}, {
					field : 'number',
					title : '件数'
				}, {
					field : 'actualWeight',
					title : '重量'
				}, {
					field : 'volume',
					title : '体积'
				}, {
					field : 'serviceTimeLimit',
					title : '到达时限',
					formatter : FormatDate
				}, {
					field : 'importantTips',
					title : '重要提示'
				}, {
					field : 'stowageRequirement',
					title : '配送要求'
				}, {
					field : 'inputType', 
					title : '输入类型',
				} ]
			});

		// 初始化工单咨询Table
		// 得到查询的参数
		queryParams2 = function(params) {
			var temp = {
				// 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
				pageSize : params.limit,
				start : params.offset,
			};
			return temp;
		};
	});
		$(function(){
			$('#btn_update').click(function(){
				var select = $('#tb_departments').bootstrapTable(
						'getSelections');
				if (select.length != 1) {
					toastr.warning('必须且只能选择一行');
				}else{
					var packageId = select[0].packageId;
					$.post('packages/findPackageinfoById',{packageId:packageId},function(data){
						$("#table-bottom1").bootstrapTable('removeAll');
						$('#table-bottom1').bootstrapTable('append', data.pkgDetailList);
						$("#packageNoU").val(data.packageNo);
						$("#sealNumberU").val(data.sealNumber);
						$("#destinationU").val(data.destination);
						$("#votesU").val(data.votes);
						$("#totalPackagesU").val(data.totalPackages);
						$("#totalWeightU ").val(data.totalWeight);
						$("#serviceTimeLimitU").val(FormatDate(data.serviceTimeLimit));
						for(var i=0;i<$("stowageRequirementU").children().length;i++){
							if($("#stowageRequirementU").children()[i].value==data.stowageRequirementU){
								$("#stowageRequirementU").children()[i].attr("selected","selected");
								$("#stowageRequirementU").selectpicker('refresh');
							}
						}
						//$("#stowageRequirementU").val(data.stowageRequirement);
						$("#totalVolumeU").val(data.totalVolume);
						$("#packageNameU").val(data.packageName)
					}); 
					
					$('#updateModal').modal('show');
				}
			})
			
			$('#btn_edit').click(function(){
				var option={
						url:'packages/updatePackageinfo',
						beforeSubmit:function(data){
							data.isUse=$('#updateFrom').find('option:selected').attr('value');
							//check();
						},
						success:function(data){
							$("#myModalF").modal('hide');
							if(data.status=="success"){
								toastr.success("修改成功");
								$("#tb_departments").bootstrapTable('refresh');
							}else{
								toastr.error("修改失败");								
							}
						}
				}
				$('#updateFrom').ajaxSubmit(option);
			});
			 //点击删除合包
			$("#btn_delete").click(function() {
					var select = $('#tb_departments').bootstrapTable('getSelections');
		
					if (select.length === 0) {
						toastr.warning('请选择一行进行删除!');
		
					} else {
						var arrs = [];
						for (var i = 0; i < select.length; i++) {
							arrs[i] = select[i]['packageNo'];
						}
						deletePicktime(arrs);
		
					}
		
				})
				function deletePicktime(ids) {
							
							layer.msg('确定删除？',{
								  time : 0 //不自动关闭
								  ,btn : [ '确定', '取消' ],
								  yes : function(index) {
									layer.close(index);
									$.ajax({
							            url: "packages/deletePackageStatus",
							            type: "post",
							            data: {
							            	packageNo:ids
							            },
							            success: function (data) {
						                	toastr.success("成功作废");
							                //重新加载记录
							                //重新加载数据
					              			$("#tb_departments").bootstrapTable('refresh', {url: 'packages/findPackageinfoPagenation'});
							            }
							        });
							      }
						       });
						}

		})
		document.onkeydown = function(e) {
			e = e || event;
			if (e.keyCode == 46) { //判断是否单击的delete按键
				var select = $('#tb_departments1').bootstrapTable('getSelections');
	
				if (select.length === 0) {
					toastr.warning('请选择一条删除!');
	
				} else {
					layer.msg('确定删除？',{
						  time : 0 //不自动关闭
						  ,btn : [ '确定', '取消' ],
						  yes : function(index) {
							 var objs = $('#tb_departments1').bootstrapTable('getSelections');
							 var str =[]
							 for(var i=0;i<objs.length;i++){
								 str.push(objs[i].oddNo)
							 }
								$("#tb_departments1").bootstrapTable('remove', {field: 'oddNo', values: str})
								
								$('#tb_departments1').bootstrapTable('refresh');
								toastr.success('删除成功!');
							layer.close(index);
					      }
				       });
				}
				return false;
			}
		}
		

	</script>
</body>
</html>