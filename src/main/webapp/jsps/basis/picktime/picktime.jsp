<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="shiro" uri="http://shiro.apache.org/tags"%>
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

<title>picktime</title>

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
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">

<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript" src="static/select/bootstrap-select.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
</head>

<body>
	<div class="panel-body" style="padding-bottom:0px;">
		<div class="panel panel-default">
			<div class="panel-heading">
				<a href="#collapse" data-toggle="collapse"><font size="2em">查询条件</font></a>
			</div>
			<div class="panel-body collapse" id="collapse">
				<form id="formSearch" class="form-horizontal" role="form">
					<div class="form-group">
						<label class="control-label col-sm-2"
							for="txt_search_timeName">收派时间名</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								id="timeName">
						</div>
						<label class="control-label col-sm-3" id="txt_search_orgName">所属单位</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="orgName">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" id="txt_search_orgName">平常上班时间</label>
						<div class="col-sm-4">
							<div class="col-lg-4">
								<input type="text" class="form-control time" id="lowWorkTime">
							</div>
							<span class="col-lg-1">~</span>
							<div class="col-lg-4">
								<input type="text" class="form-control time" id="highWorkTime">
							</div>
						</div>
						<label class="control-label col-sm-2" id="txt_search_satTime">平常下班时间</label>
						<div class="col-sm-4">
							<div class="col-lg-4">
								<input type="text" class="form-control time" id="lowOffDuty">
							</div>
							<span class="col-lg-1">~</span>
							<div class="col-lg-4">
								<input type="text" class="form-control time" id="highOffDuty">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" id="txt_search_orgName">周六上班时间</label>
						<div class="col-sm-4">
							<div class="col-lg-4">
								<input type="text" class="form-control time" id="lowSatWorkTime">
							</div>
							<span class="col-lg-1">~</span>
							<div class="col-lg-4">
								<input type="text" class="form-control time" id="highSatWorkTime">
							</div>
						</div>
						<label class="control-label col-sm-2" id="txt_search_satTime">周六下班时间</label>
						<div class="col-sm-4">
							<div class="col-lg-4">
								<input type="text" class="form-control time" id="lowSatOffDuty">
							</div>
							<span class="col-lg-1">~</span>
							<div class="col-lg-4">
								<input type="text" class="form-control time" id="highSatOffDuty">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" id="txt_search_orgName">周日上班时间</label>
						<div class="col-sm-4">
							<div class="col-lg-4">
								<input type="text" class="form-control time" id="lowSunWorkTime">
							</div>
							<span class="col-lg-1">~</span>
							<div class="col-lg-4">
								<input type="text" class="form-control time" id="highSunWorkTime">
							</div>
						</div>
						<label class="control-label col-sm-2" id="txt_search_satTime">周日下班时间</label>
						<div class="col-sm-4">
							<div class="col-lg-4">
								<input type="text" class="form-control time" id="lowSunOffDuty">
							</div>
							<span class="col-lg-1">~</span>
							<div class="col-lg-4">
								<input type="text" class="form-control time" id="highSunOffDuty">
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-6"></div>
						<div class="col-sm-6">
							<button type="button" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>	
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
			<shiro:hasPermission name="SPSJGL:ADD">
				<button id="btn_add" type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="SPSJGL:UPDATE">
				<button id="btn_edit" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="SPSJGL:DELETE">
				<button id="btn_delete" type="button" class="btn btn-default btn-danger">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button>
			</shiro:hasPermission>
		</div>
		<table id="tb_departments"></table>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h3 class="modal-title" id="myModalLabel">添加</h3>
	            </div>
	            <div class="modal-footer">
	            	<form method="POST" id="addForm"  class="form-horizontal" onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="firstname" class="col-sm-3 control-label">收派时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="timeName"  name="timeName"
									placeholder="请输入收派时间名称">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">所属单位</label>
							<div class="col-sm-9">
								<select type="text" class="form-control selectpicker bla bla bli" data-live-search="true" id="orgNames"  name="orgName">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">平时上班时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control time" id="workTime" name="workTime"
									placeholder="请输入上班时间">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">平时下班时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control time" id="offDuty" name="offDuty"
									placeholder="请输入下班时间">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">周六上班时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control time" id="satWorkTime" name="satWorkTime"
									placeholder="请输入上班时间">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">周六下班时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control time" id="satOffDuty" name="satOffDuty"
									placeholder="请输入下班时间">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">周日上班时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control time" id="sunWorkTime" name="sunWorkTime"
									placeholder="请输入上班时间">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">周日下班时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control time" id="sunOffDuty" name="sunOffDuty"
									placeholder="请输入下班时间">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">状态</label>
							<select class="col-sm-2 control-label" name="isUse" style="margin-left:14px;">
								<option value="1">启动</option>
								<option value="0">禁用</option>
							</select>
						</div>
					</form>
					<button id="sub" type="button"  class="btn btn-primary">提交</button>
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>

		<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h3 class="modal-title" id="myModalLabel">修改</h3>
	            </div>
	            <div class="modal-footer">
	            	<form method="POST" id="updateForm1"  class="form-horizontal" onsubmit="return check()" role="form">
						<input type="hidden" id="drawTimeId" name="drawTimeId"/>
						<div class="form-group">
							<label for="firstname" class="col-sm-3 control-label">收派时间名</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="timeName1"  name="timeName"
									placeholder="请输入名称">
							</div>
						</div>
						<input type="hidden" id="orgId" name="orgId"/>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">所属单位</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="orgNames"  name="orgName"
									placeholder="请输入名字">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">平时上班时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control time" id="workTime1" name="workTime"
									placeholder="请输入上班时间">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">平时下班时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control time" id="offDuty1" name="offDuty"
									placeholder="请输入下班时间">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">周六上班时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control time" id="satWorkTime1" name="satWorkTime"
									placeholder="请输入姓">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">周六下班时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control time" id="satOffDuty1" name="satOffDuty"
									placeholder="请输入姓">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">周日上班时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control time" id="sunWorkTime1" name="sunWorkTime"
									placeholder="请输入姓">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">周日下班时间</label>
							<div class="col-sm-9">
								<input type="text" class="form-control time" id="sunOffDuty1" name="sunOffDuty"
									placeholder="请输入姓">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-3 control-label">状态</label>
							<select class="col-sm-2 control-label" id="isUse" name="isUse" style="margin-left:14px;">
								<option value="1">启动</option>
								<option value="0">禁用</option>
							</select>
						</div>
					</form>
					<button id="subU" type="button" class="btn btn-primary">提交</button>
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>


	<script type="text/javascript">
		
		
	    
		$('.time').datetimepicker({  
			format: 'hh:mm:ss',
	        language: 'ch',
	        pickDate: false,
	        pickTime: true 
	      }); 
		var TableInit = function() {
				
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'pick/findPickTimePagenation', //请求后台的URL（*） 
					method : 'post', //请求方式（*） 
					toolbar : '#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : false, //是否启用排序 sortable
					sortOrder : "asc", //排序方式
					queryParams : oTableInit.queryParams,//传递参数（*） 
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
					uniqueId : "drawTimeId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'timeName',
						title : '收派时间名'
					}, {
						field : 'orgName',
						title : '所属单位'
					}, {
						field : 'workTime',
						title : '平常上班时间',
						formatter : getLocalTime		
					}, {
						field : 'offDuty',
						title : '平常下班时间',
						formatter : getLocalTime
					}, {
						field : 'satWorkTime',
						title : '周六上班时间',
						formatter : getLocalTime						
					}, {
						field : 'satOffDuty',
						title : '周六下班时间',
						formatter : getLocalTime
					}, {
						field : 'sunWorkTime',
						title : '周日上班时间',
						formatter : getLocalTime
					}, {
						field : 'sunOffDuty',
						title : '周日下班时间',
						formatter : getLocalTime
					}, {
						field : 'isUse',
						title : '状态',
						formatter:function(data){
							if(data=='1'){
								return '启动';
							}else{
								return '禁用';
								
							}
						}
					} ]
				});
				
			}; //得到查询的参数
			
			

			oTableInit.queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset //页码 
				};
				return temp;
			};
			$('#btn_query').click(function (){
			 	 var opt = {
						    url: "pick/findPickTimePagenationWithCriteria",
						    silent: true,
							    query:{      
							    	type:1,
							        level:2,
									timeName : $('#timeName').val(),
								  	orgName : $('#orgName').val(),
								  	lowWorkTime : $('#lowWorkTime').val(),
								  	highWorkTime : $('#highWorkTime').val(),
								  	lowOffDuty : $('#lowOffDuty').val(),
								  	highOffDuty : $('#highOffDuty').val(),
								  	lowSatWorkTime : $('#lowSatWorkTime').val(),
								  	highSatWorkTime : $('#highSatWorkTime').val(),
								  	lowSatOffDuty : $('#lowSatOffDuty').val(),
								  	highSatOffDuty : $('#highSatOffDuty').val(),
								  	lowSunWorkTime : $('#lowSunWorkTime').val(),
								  	highSunWorkTime : $('#highSunWorkTime').val(),
								  	lowSunOffDuty : $('#lowSunOffDuty').val(),
								  	highSunOffDuty : $('#highSunOffDuty').val(),
								  	offset:0
							    }
						  };
				$('#tb_departments').bootstrapTable('refresh', opt);
			});

			return oTableInit;
		};

		
		var ButtonInit = function() {
			var oInit = new Object();
			var postdata = {};
			oInit.Init = function() {
				//初始化页面上面的按钮事件 
				$("#btn_add").click(function() {
					$("#myModal").modal('show');
					formValidator();
				});
				$("#btn_edit").click(
						function() {
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning('请选择一行');
							}else if(select.length>1){
								toastr.warning('只能修改一行');
							}else{
								var rowData = select[0];
								$("#myModal1").find(':input').each(function(){
									if($(this).attr('name')){
										if($(this).hasClass("time")){	
											var data = rowData[$(this).attr('name')];

											$(this).val(getLocalTime(data));
										}else{
											$(this).val(rowData[$(this).attr('name')]);
										}
									}
								});
								$("#myModal1").modal('show');
								
							}

						});
						$("#subU").click(function(){
							var workTime = $('#workTime1').val();
							var offDuty = $('#offDuty1').val();
							var satWorkTime = $('#satWorkTime1').val();
							var satOffDuty = $('#satOffDuty1').val();
							var sunWorkTime = $('#sunWorkTime1').val();
							var sunOffDuty = $('#sunOffDuty1').val();
							if(workTime>offDuty || satWorkTime>satOffDuty || sunWorkTime>sunOffDuty){
								toastr.warning('上班时间必须小于下班时间');
							}else{
								var option={
										url:'pick/updatePickTime',
										beforeSubmit:function(data){
											data.isUse=$('#updateForm1').find('option:selected').attr('value');
											//check();
										},
										success:function(data){
											$("#myModal1").modal('hide');
											
											if(data.status=="success"){
												toastr.success("修改成功");
												$("#tb_departments").bootstrapTable('refresh');
											}else{
												toastr.error("修改失败");								
											}
										}
								}
							}
								$('#updateForm1').ajaxSubmit(option);
							
						});
						
						
						function check(){
							
						}
						
						
						$("#btn_delete").click(
								function() {
									var select = $('#tb_departments').bootstrapTable(
											'getSelections');
									if (select.length === 0) {
										toastr.warning('请选择一行');
									} else {
		
										var arrs = [];
										for (var i = 0; i < select.length; i++) {
											arrs[i] = select[i]['drawTimeId'];
										}
										deletePicktime(arrs);
									}
		
								});

			};
			return oInit;
		};
		
		
		function deletePicktime(ids) {
			
			layer.msg('确定删除？',{
				  time : 0 //不自动关闭
				  ,btn : [ '确定', '取消' ],
				  yes : function(index) {
					layer.close(index);
					$.ajax({
			            url: "pick/deletePickTime",
			            type: "post",
			            data: {
			            	drawTimeId: ids
			            },
			            success: function (data) {
		                	toastr.success("删除成功");
			                //重新加载记录
			                //重新加载数据
	              			$("#tb_departments").bootstrapTable('refresh', {url: 'pick/findPickTimePagenation'});
			            }
			        });
			      }
		       });
			
		   /*  var msg = "您真的确定要删除吗？";
		    if (confirm(msg) == true) {
		        $.ajax({
		            url: "pick/deletePickTime",
		            type: "post",
		            data: {
		            	drawTimeId: ids
		            },
		            success: function (data) {
	                	toastr.success(data.msg,"删除成功");
		                //重新加载记录
		                //重新加载数据
              			$("#tb_departments").bootstrapTable('refresh', {url: 'pick/findPickTimePagenation'});
		            }
		        });
		    } */
		}
		
		
		
		function getLocalTime(nS) {
			var now = new Date(nS);
			var hour=now.getHours();
			var minute=now.getMinutes();
			var second=now.getSeconds(); 
			if(minute==0){
				return hour+":"+minute+"0"+":"+second;
			}
			return hour+":"+minute+":"+second; 
		} 
		

		$(function() {
			$('#orgNames').selectpicker({
				type:'select',
				hiddenInput:true,
				url:'pick/findAllOrganization',
				inputName:'orgId',
				key:'orgId',
				value:'orgName'
            });
			//1.初始化Table 
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件 
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();
			$("#sub").click(function () {
				var workTime = $('#workTime').val();
				var offDuty = $('#offDuty').val();
				var satWorkTime = $('#satWorkTime').val();
				var satOffDuty = $('#satOffDuty').val();
				var sunWorkTime = $('#sunWorkTime').val();
				var sunOffDuty = $('#sunOffDuty').val();
				if(workTime>offDuty || satWorkTime>satOffDuty || sunWorkTime>sunOffDuty){
					toastr.warning('上班时间必须小于下班时间');
				}else{
					var option={
							url:'pick/addPicktime',
							beforeSubmit:function(){
								$('#addForm').data('bootstrapValidator').validate();
								var result =  $('#addForm').data('bootstrapValidator').isValid();
								if(!result){
									toastr.warning("校验失败");
									return false;
								}
								return true;
							},
							success:function(data){
								$("#myModal").modal('hide');
								if(data.status=="success"){
									toastr.success("添加成功");
									$("#tb_departments").bootstrapTable('refresh');
								}else{
									toastr.error("添加失败");								
								}
							}
					}
				}
				$('#addForm').ajaxSubmit(option);
		    });
			
		});

		function test() {
			var oldWidth = $('body').outerWidth();
			var marginLeft = (document.documentElement.clientWidth - $(
					".model-dialog").outerWidth()) / 2;
			var marginHeight = (document.documentElement.clientHeight - $(
					".model-dialog").outerHeight()) / 2;
			$('.model-dialog').css('margin-left', marginLeft);
			$('.model-dialog').css('margin-top', marginHeight);
			$('body').css('overflow', 'hidden');
			var newWidth = $('body').outerWidth();
			var scrollbarWidth = newWidth - oldWidth;
			$('body').css('padding-right', scrollbarWidth + 'px');
			$('.model').removeClass('hide');
			$('.model-dialog').removeClass('hide');
		}

		function cancel() {
			$('body').css('overflow', 'auto');
			$('body').css('padding-right', '0px');
			$('.model').addClass('hide');
			$('.model-dialog').addClass('hide');
		}
		
		function formValidator(){
	        $('#addForm').bootstrapValidator({
	            fields: {
	            	timeName: {
	                    message: '名字验证失败',
	                    validators: {
	                        notEmpty: {
	                            message: '名字不能为空'
	                        }
	                    }
	            	},
	            	workTime: {
	                    message: '时间验证失败',
	                    validators: {
	                        notEmpty: {
	                            message: '时间不能为空'
	                        }
	                    }
	            	},
		        	  offDuty: {
		                    message: '时间验证失败',
		                    validators: {
		                        notEmpty: {
		                            message: '时间不能为空'
		                        }
		                    }
		        	  	},
		            	satWorkTime: {
		                    message: '时间验证失败',
		                    validators: {
		                        notEmpty: {
		                            message: '时间不能为空'
		                        }
		                    }
		            	},
		            	satOffDuty: {
		                    message: '时间验证失败',
		                    validators: {
		                        notEmpty: {
		                            message: '时间不能为空'
		                        }
		                    }
		            	},
		            	sunWorkTime: {
		                    message: '时间验证失败',
		                    validators: {
		                        notEmpty: {
		                            message: '时间不能为空'
		                        }
		                    }
		            	},
		            	sunOffDuty: {
		                    message: '时间验证失败',
		                    validators: {
		                        notEmpty: {
		                            message: '时间不能为空'
		                        }
		                    }
			          },
	          }
	        });  
		}

	</script>


</body>
</html>
