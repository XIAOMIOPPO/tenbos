<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>table</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/common.css">
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/cssreset-min.css">
<link rel="stylesheet" type="text/css" href="static/toastr/toastr.css">
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.css">


<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/jquery.citys.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/jquery.ocupload-1.1.2.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>

</head>

<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-heading">
				<a href="#collapse" data-toggle="collapse">查询条件</a>
			</div>
			<div class="panel-body collapse" id="collapse">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-5"
							for="txt_search_departmentname">宣传概要</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="publicityOutline">
						</div>
						<label class="control-label col-sm-5"
							for="txt_search_departmentname">发布时间</label>
						<div class="col-sm-3">
							<input type="text" class="form-control time" id="findReleaseTime"
									name="date">
						</div>
						<label class="control-label col-sm-5"
							for="txt_search_departmentname">生效时间</label>
						<div class="col-sm-3">
							<input type="text" class="form-control time" id="findfailureTime"
									name="date">
						</div>
						<label class="control-label col-sm-5" for="txt_search_statu">状态</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="status">
						</div>
						<div class="col-sm-4" style="text-align: left;">
							<button type="button" style="margin-left: 50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
		<shiro:hasPermission name="ZRWDSZ:XZ">
			<button id="btn_add" type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="ZRWDSZ:XG">
			<button id="btn_edit" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>修改
			</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="ZRWDSZ:SC">
			<button id="btn_delete" type="button" class="btn btn-danger">
				<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
			</button>
		</shiro:hasPermission>	
		</div>
		<table id="tb_departments"></table>
	</div>


	<div class="model hide"></div>
	<div class="modal fade" id="add" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">添加</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×<tton>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form" id="addForm">
						<div class="form-group">
							<label for="lfirstname" class="col-sm-2 control-label">宣传概要</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="addpublicityOutline"
									placeholder="请输入宣传概要" name="publicityOutline">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">详细内容</label>
							<div class="col-sm-4">
								<textarea rows="8" cols="50" placeholder="请输入详细内容"
									id="propagandaContent">
							   </textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">发布时间</label>
							<div class="col-sm-4">
								<input type="text" class="form-control time" id="addreleaseTime"
									name="date">
							</div>
							<label for="lastname" class="col-sm-2 control-label">生效时间</label>
							<div class="col-sm-4">
								<input type="text" class="form-control time" id="addfailureTime"
									name="date">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">更新时间</label>
							<div class="col-sm-4">
								<input type="text" class="form-control time" id=updateTime
									name="date">
							</div>
							<label for="lastname" class="col-sm-2 control-label">更新单位</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="updateUnit"
									placeholder="请输入更新单位" name="updateUnit">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">更新人</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="userId"
									placeholder="请输入更新人" name="userId">
							</div>
							<label for="lastname" class="col-sm-2 control-label">状态</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="addstatus"
									placeholder="请输入状态" name="status">
							</div>
						</div>
						<div class="form-group">
							<div class="text-center">
								<button id="sub" class="btn btn-primary">提交</button>
								<button class="btn btn-info" data-dismiss="modal"
									aria-hidden="true">取消</button>
							</div>
						</div>
					</form>

				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>

	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="lfirstname" class="col-sm-2 control-label">宣传概要</label>
							<div class="col-sm-4">
								<input type="text" class="form-control"
									id="updatePublicityOutline" placeholder="请输入宣传概要"
									name="publicityOutline">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">详细内容</label>
							<div class="col-sm-4">
								<textarea rows="8" cols="50" placeholder="请输入详细内容"
									id="updatePropagandaContent">
							   </textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">发布时间</label>
							<div class="col-sm-4" >
								<input type="text" class="form-control time" id="updateReleaseTime"
									name="date" >
							</div>
							<label for="lastname" class="col-sm-2 control-label">生效时间</label>
							<div class="col-sm-4" >
								<input type="text" class="form-control time" id="updateFailureTime"
									name="date" >
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">状态</label>
							<div class="col-sm-4">
								<select>
								  <option id="updateStatus">已过期</option>
								  <option id="updateStatus">已发布</option>
								  <option id="updateStatus">已发布未生效</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button id="subUp" type="button" class="btn btn-warning">提交</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	$('#findReleaseTime').datetimepicker({  
		format: 'yyyy-mm-dd hh:mm:ss',
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: true 
      });
	$('#findfailureTime').datetimepicker({  
		format: 'yyyy-mm-dd hh:mm:ss',
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: true 
      });
	$('#addreleaseTime').datetimepicker({  
		format: 'yyyy-mm-dd hh:mm:ss',
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: true
      }); 
	$('#addfailureTime').datetimepicker({  
		format: 'yyyy-mm-dd hh:mm:ss',
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: true 
     });
	$('#updateReleaseTime').datetimepicker({  
		format: 'yyyy-mm-dd hh:mm:ss',
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: true 
      });
	$('#updateTime').datetimepicker({  
		format: 'yyyy-mm-dd hh:mm:ss',
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: true 
      });
	$('#updateFailureTime').datetimepicker({  
		format: 'yyyy-mm-dd hh:mm:ss',
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: true 
      });
	function formatDate(ns) {
		var now = new Date(ns);
		
		var year=now.getYear()+1900;
		var month=now.getMonth()+1;
		var date=now.getDate();
		var hour=now.getHours();
		var minute=now.getMinutes();
		var second=now.getSeconds();
		
		return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;

	}
	var TableInit = function() {
		var oTableInit = new Object();
		//初始化Table 
		oTableInit.Init = function() {
			$('#tb_departments').bootstrapTable({
				url : 'propaganda/propagandaPageQuery', //请求后台的URL（*） 
				method : 'post', //请求方式（*） 
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 5, //每页的记录行数（*） 
				pageList : [ 3, 25, 50, 100 ], //可供选择的每页的行数（*） 
				search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
				strictSearch : true,
				showColumns : true, //是否显示所有的列 
				showRefresh : true, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数决定表格高度 
				uniqueId : "propagandaId", //每一行的唯一标识，一般为主键列 
				showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				columns : [ {
					checkbox : true
				}, {
					field : 'publicityOutline',
					title : '宣传概要'
				}, {
					field : 'propagandaContent',
					title : '宣传内容'
				}, {
					field : 'releaseTime',
					title : '发布时间',
					formatter:function (value){
						return formatDate(value);
					}
				}, {
					field : 'failureTime',
					title : '失效时间',
					formatter:function (value){
						return formatDate(value);
					}
				}, {
					field : 'updateTime',
					title : '更新时间',
					formatter:function (value){
						return formatDate(value);
					}
				}, {
					field : 'updateUnit',
					title : '更新单位'
				}, {
					field : 'userId',
					title : '更新人'
				}, {
					field : 'status',
					title : '状态'
				}]
			});
		}; //得到查询的参数
		
						oTableInit.queryParams = function(params) {
							var temp = {
								//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
								limit : params.limit, //页面大小 
								offset : params.offset, //页码 
								departmentname : $("#txt_search_departmentname").val(),
								statu : $("#txt_search_statu").val()
							};
							return temp;
						};
						$('#btn_query').click(function() {
							var opt = {
								url : "propaganda/partitionPageQueryWithCriteria",
								silent : true,
								query : {
									type : 1,
									level : 2,
									publicityOutline : $('#publicityOutline').val(),
									releaseTime: $('#findReleaseTime').val(),
									failureTime: $('#findfailureTime').val(),
									status: $('#status').val()
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
								$("#add").modal('show');
							});
							
							$("#btn_edit").click(function() {
								var select = $('#tb_departments')
								.bootstrapTable('getSelections');
						if (select.length != 1) {
							toastr.info("请选择一行");
						} else {
							$('#myModal2').modal('show')
							var obj = select[0];
							var upPublicityOutline = obj.publicityOutline;
							var upPropagandaContent = obj.propagandaContent;
				            var upReleaseTime = obj.releaseTime;
				            var upFailureTime = obj.failureTime;
				            var upStatus = obj.status;
							$("#updatePublicityOutline").val(upPublicityOutline);
							$("#updatePropagandaContent").val(upPropagandaContent);
				            $("#updateReleaseTime").val(upReleaseTime);
				            $("#updateFailureTime").val(upFailureTime);
				            $("#updateStatus").val(upStatus);
							//修改
							$("#subUp").click(function() {
								var UpdatePu = $("#updatePublicityOutline").val();
								var UpdatePr = $("#updatePropagandaContent").val();
                                var UpdateR = $("#updateReleaseTime").val();
                                var UpdateF = $("#updateFailureTime").val();
                                var UpdateS = $("#updateStatus").val();
								$.ajax({
											url : "propaganda/updatePropaganda",
											type : "post",
											data : {
												"propagandaId" : select[0].propagandaId,
												"publicityOutline" : UpdatePu,
												"propagandaContent" : UpdatePr,
												"releaseTime" : UpdateR,
												"failureTime" : UpdateF,
												"status" : UpdateS,
											},
											traditional : true,//这里设置为true
											success : function(
													result) {
												if (result.status == "success") {
													toastr.success("修改成功");
													$('#tb_departments')
															.bootstrapTable('refresh');
													$('#myModal2').modal('hide')
												} else {
													toastr.error("修改失败");
												}
											}
										})
							});
						}
					});
							$("#btn_delete").click(function() {
								var select = $('#tb_departments').bootstrapTable(
								'getSelections');
						if (select.length === 0) {
							 toastr.warning("请选择一行");
						}else if(select.length > 1){
							toastr.warning("选择行数过多");
						} else {
							var arrs = [];
							for (var i = 0; i < select.length; i++) {
								arrs[i] = select[i]['propagandaId'];
							}

							$('#tb_departments').bootstrapTable('remove', {
								field : 'propagandaId',
								values : arrs
							});
							$.ajax({
								url : "propaganda/deletePropaganda",
								type : "post",
								data : {
									"propagandaId" : arrs
								},
								traditional : true,//这里设置为true
								success : function(result) {
									if (result == "success") {
										toastr.success("删除成功");
										var url = {
											url : 'propaganda/propagandaPageQuery'
										};
										$('#tb_departments')
												.bootstrapTable('refresh',
														url);
									} else {
										toastr.error("删除失败");
									}
								}
							})
						}
			});
		};
		return oInit;
	};
	 
	$("#sub").click(function() {
		var obj = {
			    publicityOutline : $('#addpublicityOutline').val(),
				propagandaContent : $('#propagandaContent').val(),
				PreleaseTime : $('#addreleaseTime').val(),
				PfailureTime : $('#addfailureTime').val(),
				PupdateTime : $('#updateTime').val(),
				updateUnit : $('#updateUnit').val(),
				userId : $('#userId').val(),
				status : $('#addstatus').val()
			};
	
			var form =  $('#addForm').data('bootstrapValidator').isValid();
			//异步同步数据库
			$.getJSON("propaganda/addPropaganda", obj, function(result) {
				if(form){
					if (result.status == "success") {
						$("#add").modal("hide");
						$('#tb_departments').bootstrapTable('refresh');
						 toastr.success("添加成功");
					} else {
						toastr.error("添加失败");
					}
					return true;
				}else{
					return false;
				}
			});
		});
	    $(function() {
				//1.初始化Table 
				var oTable = new TableInit();
				oTable.Init();
				//2.初始化Button的点击事件 
				var oButtonInit = new ButtonInit();
				oButtonInit.Init();
	    });
		$(function () {
	        $('form').bootstrapValidator({

	    message: 'This value is not valid',
            feedbackIcons: {
             valid: 'glyphicon glyphicon-ok',
             invalid: 'glyphicon glyphicon-remove',
             validating: 'glyphicon glyphicon-refresh'
            }, 

	            fields: {
	            	publicityOutline: {
	                    message: '区域验证失败',
	                    validators: {
	                        notEmpty: {
	                            message: '宣传概要不能为空'
	                        }
	                    }
	                },
	                propagandaContent: {
	                    validators: {
	                        notEmpty: {
	                            message: '宣传内容不能为空'
	                        }
	                    }
	                }        
	            }
	});
});
	

	</script>
</body>
</html>
