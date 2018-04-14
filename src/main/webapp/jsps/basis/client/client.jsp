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

<title>客户</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">




<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css"
	rel="stylesheet">
	<link href="static/toastr/toastr.css"
	rel="stylesheet">

<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/toastr/toastr.js"></script>
<script src="static/jquery.form.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>


</head>

<body>
	<div class="panel-body" style="padding-bottom:0px;">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top:15px">
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">客户姓名</label>
						<div class="col-sm-2">
							<input type="text" class="form-control"
								id="clientName1">
						</div>
						<label class="control-label col-sm-1" for="txt_search_statu">客户类型</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="clientType1">
						</div>
						<label class="control-label col-sm-1" for="txt_search_statu">联系电话</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="phone1">
						</div>
						<div class="col-sm-2" style="text-align:left;">
							<button type="button" style="margin-left:50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
		<shiro:hasPermission name="KHGL:ADD">
			<button id="btn_add" type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="KHGL:UPDATE">
			<button id="btn_edit" type="button" class="btn btn-primary">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="KHGL:DEL">
			<button id="btn_delete"  type="button" class="btn btn-danger">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			</shiro:hasPermission>
		</div>
		<table id="tb_departments"></table>
	</div>

   
 <div class="modal fade" id="add">  
            <div class="modal-dialog">    
              <div class="modal-content">    
                <div class="modal-header">添加</div>    
                <form class="form-horizontal" id="addclient" action="client/AddClient">    
                  <div class="modal-body">    
                     <!-- <div class="form-group">    
                      <label for="inputID" class="col-sm-2 control-label">客户编号</label>    
                      <div class="col-sm-10">    
                        <input id="clientNum" name="clientNum"type="text" class="form-control list-inline" placeholder="clientNum" />    
                      </div>    
                    </div>   -->  
                    <div class="form-group">    
                      <label for="clientName" class="col-sm-2 control-label">客户名字</label>    
                      <div class="col-sm-10">    
                        <input id="clientName" name="clientName" type="text" class="form-control list-inline" placeholder="name"/>    
                      </div>    
                    </div>    
                    <div class="form-group">    
                      <label for="inputUsername" class="col-sm-2 control-label">性别</label>    
                      <div class="col-sm-10">    
                       <select class="form-control" id="sex" name="sex">
                        <option>男</option>
                        <option>女</option>
                    </select>	
                      </div>    
                    </div>    
                    <div class="form-group">    
                      <label for="inputphone" class="col-sm-2 control-label">联系电话</label>    
                      <div class="col-sm-10">    
                        <input id="phone" name="phoneNum" type="text" class="form-control list-inline" placeholder="phone"/>    
                      </div>    
                    </div>    
                     <div class="form-group">    
                      <label for="inputclienttype" class="col-sm-2 control-label">客户类型</label>    
                      <div class="col-sm-10">    
                        <select class="form-control" id="clientType" name="clientType">
                              <option>标准客户</option>
                              <option>目标客户</option>
                              <option>VIP客户</option>
                              <option>意向客户</option>
                              <option>企业客户</option>
                              <option>潜在客户</option>
                              <option>普通客户</option>
                        </select>
                      </div>    
                    </div>  
                      <div class="form-group">    
                      <label for="inputnewFrom" class="col-sm-2 control-label">客户来源</label>    
                      <div class="col-sm-10">    
                        <input id="newFrom" name="newFrom" type="text" class="form-control list-inline" placeholder="NewFrom"/>    
                      </div>    
                    </div>  
                     <div class="form-group">    
                      <label for="inputtrail" class="col-sm-2 control-label">客户地址</label>    
                      <div class="col-sm-10">    
                        <input id="clientAddress"  name="clientAddress"type="text" class="form-control list-inline" placeholder="clientAddress"/>    
                      </div>    
                    </div>  
                  </div>    
                </form>    
                <div class="modal-footer">    
                  <button class="btn btn-primary" id="AddClientbtn" type="button">提交</button>       
                  <button class="btn btn-info" data-dismiss="modal">退出</button>    
                </div>    
              </div>    
            </div>    
          </div>   

	
   
 <div class="modal fade" id="edit">  
            <div class="modal-dialog">    
              <div class="modal-content">    
                <div class="modal-header">修改</div>    
                <form class="form-horizontal">    
                  <div class="modal-body">    
                 <div class="form-group">    
                      <label for="inputID" class="col-sm-2 control-label">客户编号</label>    
                      <div class="col-sm-10">    
                        <input id="clientNum1" type="text" class="form-control list-inline" placeholder="clientnum" />    
                      </div>    
                    </div>    
                    <div class="form-group">    
                      <label for="inputpwd" class="col-sm-2 control-label">客户名字</label>    
                      <div class="col-sm-10">    
                        <input id="clientName2" type="text" class="form-control list-inline" placeholder="name"/>    
                      </div>    
                    </div>    
                    <div class="form-group">    
                      <label for="inputUsername" class="col-sm-2 control-label">性别</label>    
                      <div class="col-sm-10">    
                       <select class="form-control" id="sex1">
                        <option>男</option>
                        <option>女</option>
                    </select>	
                      </div>    
                    </div>    
                    <div class="form-group">    
                      <label for="inputphone" class="col-sm-2 control-label">联系电话</label>    
                      <div class="col-sm-10">    
                        <input id="phoneNum" type="text" class="form-control list-inline" placeholder="phone"/>    
                      </div>    
                    </div>    
                     <div class="form-group">    
                      <label for="inputclienttype" class="col-sm-2 control-label">客户类型</label>    
                      <div class="col-sm-10">    
                        <select class="form-control" id="clientType2">
                              <option>标准客户</option>
                              <option>目标客户</option>
                              <option>VIP客户</option>
                              <option>意向客户</option>
                              <option>企业客户</option>
                              <option>潜在客户</option>
                              <option>普通客户</option>
                        </select>
                      </div>    
                    </div>  
                     <div class="form-group">    
                      <label for="inputtrail" class="col-sm-2 control-label">客户地址</label>    
                      <div class="col-sm-10">    
                        <input id="clientAddress1" type="text" class="form-control list-inline" placeholder="clientAddress"/>    
                      </div>    
                    </div>  
                     <div class="form-group">    
                      <label for="inputnewFrom" class="col-sm-2 control-label">客户来源</label>    
                      <div class="col-sm-10">    
                        <input id="newFrom1" type="text" class="form-control list-inline" placeholder="NewFrom"/>    
                      </div>    
                    </div>  
                  </div>    
                </form>    
                <div class="modal-footer">    
                  <button class="btn btn-primary" id="subUp" type="button">提交</button>       
                  <button class="btn btn-info" data-dismiss="modal">退出</button>    
                </div>    
              </div>    
            </div>    
          </div>    
    
	<script type="text/javascript">
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'client/findCilentPagenation', //请求后台的URL（*） 
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
					pageSize : 8, //每页的记录行数（*） 
					pageList : [ 8, 25, 50, 100 ], //可供选择的每页的行数（*） 
					search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "clientId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					},{
						field : 'clientNum',
						title : '客户编号'
					},{
						field : 'clientName',
						title : '客户姓名'
					}, {
						field : 'sex',
						title : '性别'
					}, {
						field : 'phoneNum',
						title : '联系电话'
					}, {
						field : 'clientType',
						title : '客户类型'
					},{
						field : 'newFrom',
						title : '客户来源'
					},{
						field : 'clientAddress',
						title : '客户地址'
					}]
				});
			}; //得到查询的参数

			oTableInit.queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset, //页码 
					departmentName : $("#txt_search_departmentname").val(),
					status : $("#txt_search_statu").val()
				};
				return temp;
			};
			$('#btn_query').click(function (){
				  var opt = {
						  
				    url: "client/findCilentPagenationWithCriteria",
				    silent: true,
				    query:{      
				    	type:1,
 				        level:2,
				        clientName : $('#clientName1').val(),
				        clientType : $('#clientType1').val(),
				        phoneNum   : $('#phone1').val()
				        
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
					$('#add').modal('show');
					 $("#addclient").data('bootstrapValidator').destroy();
				     $("#addclient").data('bootstrapValidator', null);
				     formValidator();
				});

				$("#btn_edit").click(
						function() {
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请选中一行");
							}else if(select.length>1)
								{toastr.warning("一次只能修改一条");}
							else
							{

								$('#edit').modal('show')
								var obj= select[0];
								var upclientId =obj.clientId;
								var upclientNum = obj.clientNum;
								var upclientName = obj.clientName;
								var upsex = obj.sex;
								var upphoneNum = obj.phoneNum;
								var upclientType = obj.clientType;
								var upclientAddress = obj.clientAddress;
								var upnewFrom = obj.newFrom;

								$("#clientId1").val(upclientId);
								$("#clientNum1").val(upclientNum);
								$("#clientName2").val(upclientName);
								$("#sex1").val(upsex);
								$("#phoneNum").val(upphoneNum);
								$("#clientType2").val(upclientType);
								$("#clientAddress1").val(upclientAddress);
								$("#newFrom1").val(upnewFrom);
								
								
						

							}

						});

				$("#btn_delete").click(
						function() {
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请选中一行");
							}
							else {

								var arrs = [];
								for (var i = 0; i < select.length; i++) {
									arrs[i] = select[i]['clientId'];
								}

								$('#tb_departments').bootstrapTable('remove', {
									field : 'clientId',
									values : arrs
								}); 

								$.post("client/delClient", {clientId:arrs}, function(result) {
									if (result.status == 'success') {
										toastr.success("删除成功");
									} else {
										toastr.warning("删除失败");
									}
								});

							}

						});

			};
			return oInit;
		};
			

		$(function() {
			//1.初始化Table 
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件 
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();
			
		 $("#AddClientbtn").click(function(){
			
			var options = {
					url:"client/AddClient",
					beforeSubmit:function(){
						$('#addclient').data('bootstrapValidator').validate();
						var result =  $('#addclient').data('bootstrapValidator').isValid();
						if(!result){
							toastr.warning("校验失败");
							return false;
						}
						
						return true;
						
					},
					success:function(data){
						$("#add").modal('hide');
						if(data ==1){
							$('#tb_departments').bootstrapTable('refresh');
							toastr.success('添加成功');
						}else{
							toastr.error('添加失败');
						}
						
					},
					type:'post',
					clearForm:true 
			};
			 $("#addclient").ajaxSubmit(options); 
		}); 

			//修改
			$("#subUp").click(function(){
				var upclientNum = $("#clientNum1").val();
				var upclientId = $("#clientId1").val();
				var fAclientName = $("#clientName2").val();
				var usex = $("#sex1").val();
				var uPhone = $("#phoneNum").val();
				var uClientType = $("#clientType2").val();
				var uclientAddress = $("#clientAddress1").val();
				var uNewFrom = $("#newFrom1").val();
				
				
				$.ajax({
					url:"client/UpdateClient",
					type:"post",
					data:{"clientId":upclientId,
						  "clientNum":upclientNum,
						  "clientName":fAclientName,
						  "sex":usex,
						  "phoneNum":uPhone,
						  "clientType":uClientType,
						  "clientAddress":uclientAddress,
						  "newFrom":uNewFrom
						
					},
					
					traditional: true,//这里设置为true
					success:function(result) {
						$('#edit').modal('hide');
						if (result == 1) {
							$('#tb_departments').bootstrapTable('refresh');
							toastr.success('修改成功');
						} else {
						}
					}
				})
				
			});
			formValidator();
		});
		

	 function formValidator(){
	        $('#addclient').bootstrapValidator({

	            fields: {
	            	clientName: {
	                    message: '名字验证失败',
	                    validators: {
	                        notEmpty: {
	                            message: '名字不能为空'
	                        }
	                    }
	                },
	                phoneNum: {
	                    validators: {
	                        notEmpty: {
	                            message: '电话不能为空'
	                        },regexp:{
	                        	regexp:/^1[3|4|5|8][0-9]\d{4,8}$/,
	                        	message: '电话号码格式不正确'
	                        }
	                    }
	                },
	                trail: {
	                    validators: {
	                        notEmpty: {
	                            message: '客户跟进请填写，不能为空'
	                        }
	                    }
	                },
	                newFrom: {
	                    validators: {
	                        notEmpty: {
	                            message: '请输入客户来源'
	                        }
	                    }
	                } /* ,
	                sex: {
	                    validators: {
	                        notEmpty: {
	                            message: '请输入客户来源'
	                        }
	                    }
	                }  */
	            }
	        });
	 }

	
	</script>


</body>
</html>
