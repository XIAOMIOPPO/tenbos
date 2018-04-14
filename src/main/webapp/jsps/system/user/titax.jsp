<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>titax</title>

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
<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/select/bootstrap-select.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>



</head>

<body>
	<div class="panel-body" style="padding-bottom:0px;">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top:15px">
						<label class="control-label col-sm-1" for="txt_search_userName">用户名</label>
						<div class="col-md-2">
							<input type="text" class="form-control" id="txt_search_userName">
						</div>
						<label class="control-label col-md-2" for="txt_search_phoneNum">联系电话</label>
						<div class="col-md-2">
							<input type="text" class="form-control" id="txt_search_phoneNum">
						</div>
						<label class="control-label col-md-2" for="txt_search_orgId">所属部门</label>
						<div class="col-md-2">
							<select class="orgselect selectpicker bla bla bli" data-live-search="true">
							</select>
						</div>
					</div>
					<div class="form-group" >
						<label class="control-label col-md-1" for="txt_search_isUse">用户状态</label>
						<div class="col-md-2">    
                        <select class="form-control" id="txt_search_isUse">
                              <option> </option>
                              <option value="0">禁用</option>
                              <option value="1">使用中</option>
                        </select>
                      	</div>    
						<div class="col-md-8" style="text-align:left;">
							<button type="button" id="btn_query"
								class="btn btn-primary pull-right">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-danger">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</div>
		<table id="tb_departments"></table>
	</div>


	<div class="model hide"></div>
	<div class="modal fade" id="uModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" id="myModalLabel">增加资源</h4>
	            </div>
	            <div class="modal-body" id="test">
	            	<form class="form-horizontal" role="form" id="addUser" action="user/adduser">
					  <div class="form-group">
					    <label for="firstName" class="col-sm-2 control-label">用户名字</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="userName" id="userName" placeholder="请输入名字">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="firstPwd" class="col-sm-2 control-label">用户密码</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="pwd" id="pwd" placeholder="请输入密码">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="firstAge" class="col-sm-2 control-label">用户年龄</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="age" id="age" placeholder="请输入年龄">
					    </div>
					  </div>
					  <div class="form-group">    
                     	 <label for="firstSex" class="col-sm-2 control-label">用户性别</label>    
                      	<div class="col-sm-10">    
                       		<select class="form-control" id="sex" name="sex">
                       			 <option>男</option>
                        	 	 <option>女</option>
                    		</select>
                    	</div>
                      </div>
					  <div class="form-group">
					    <label for="firstPhoneNum" class="col-sm-2 control-label">联系电话</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="phoneNum" id="phoneNum" >
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="firstOrgId" class="col-sm-2 control-label">所属部门</label>
					   <div class="col-sm-10">    
                        <select class="orgselect selectpicker bla bla bli" data-live-search="true" name="fileName">
						</select>
                      </div>    
					  </div>
					  <div class="form-group">    
                      <label for="firstIsUse" class="col-sm-2 control-label">用户状态</label>    
                      <div class="col-sm-10">    
                        <select class="form-control" id="isUse" name="isUse">
                              <option value="1">使用中</option>
                              <option value="0">禁用</option>
                        </select>
                      </div>    
                    </div>  
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <div class="checkbox">
					        <label>
					          <input type="checkbox">请记住我
					        </label>
					      </div>
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="button" id="uploadUser" class="btn btn-default">保存</button>
					      <button class="btn btn-info" data-dismiss="modal">退出</button>   
					    </div>
					  </div>
					</form>
	            </div>
	            
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal-dialog -->
	</div>
	<div class="modal fade" id="edit">  
            <div class="modal-dialog">    
              <div class="modal-content">    
                <div class="modal-header">修改</div>    
                <form class="form-horizontal">    
                  <div class="modal-body">    
                    <div class="form-group">    
                      <label for="inputID" class="col-sm-2 control-label">用户Id</label>    
                      <div class="col-sm-10">    
                        <input id="userId1" type="text" class="form-control list-inline" placeholder="userId" />    
                      </div>    
                    </div> 
                     <div class="form-group">    
                      <label for="inputpwd" class="col-sm-2 control-label">用户名字</label>    
                      <div class="col-sm-10">    
                        <input id="userName1" type="text" class="form-control list-inline" placeholder="userName"/>    
                      </div>    
                    </div>    
                    <div class="form-group">    
                      <label for="inputage" class="col-sm-2 control-label">用户年龄</label>    
                      <div class="col-sm-10">    
                        <input id="age1" type="text" class="form-control list-inline" placeholder="age"/>    
                      </div>    
                    </div>    
                    <div class="form-group">    
                      <label for="inputsex" class="col-sm-2 control-label">用户性别</label>    
                      <div class="col-sm-10">    
                       <select class="form-control" id="sex1">
                        <option>男</option>
                        <option>女</option>
                    </select>	
                      </div>    
                    </div>    
                    <div class="form-group">    
                      <label for="inputphone" class="col-sm-2 control-label">所属部门</label>    
                      <div class="col-sm-10">    
							<select  class="orgselect selectpicker bla bla bli"  data-live-search="true">
							</select>                     
                      </div>
                    </div>      
                    <div class="form-group">    
                      <label for="inputphone" class="col-sm-2 control-label">联系电话</label>    
                      <div class="col-sm-10">    
                        <input id="phoneNum1" type="text" class="form-control list-inline" placeholder="phoneNum"/>    
                      </div>    
                    </div>    
                     <div class="form-group">    
                      <label for="inputclienttype" class="col-sm-2 control-label">用户状态</label>    
                      <div class="col-sm-10">    
                        <select class="form-control" id="isUse1">
                              <option value="1">使用中</option>
                              <option value="0">禁用</option>
                        </select>
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
					url : 'user/listUser', //请求后台的URL（*） 
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
					pageList : [8,16,24,32], //可供选择的每页的行数（*） 
					search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "userId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'userName',
						title : '用户姓名'
					}, {
						field : 'pwd',
						title : '用户密码'
					}, {
						field : 'age',
						title : '用户年龄'
					}, {
						field : 'sex',
						title : '用户性别'
					}, {
						field : 'phoneNum',
						title : '联系电话'
					}, {
						field : 'orgName',
						title : '所属部门'
					}, {
						field : 'isUse',
						title : '用户状态',
						formatter:function(data){
							if(data=='0'){
								return '禁用';
							}else{
								return '使用中';
							}
						}
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
			$('#btn_query').click(function (data){
				  var opt = {
				    url: "user/listUser",
				    silent: true,
				    query:{      
				    	type:1,
				        level:2,
						userName : $('#txt_search_userName').val(),
					  	phoneNum : $('#txt_search_phoneNum').val(),
					  	orgId : $('#txt_search_orgId').val(),
					  	isUse : $('#txt_search_isUse').val()
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
					$("#uModal").modal('show');
					
				});

				$("#btn_edit").click(
						function() {
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请选择一行");
							}else if(select.length>1)
								{
								toastr.warning("一次只能修改一条");
								}
							else{
								var obj = select[0];
								$('.orgselect').selectpicker('setSelectItem',obj.fileName);
								var userId = obj.userId;
								var userName = obj.userName;
								var pwd = obj.pwd;
								var age = obj.age;
								var sex = obj.sex;
								var phoneNum = obj.phoneNum;
								var fileName = obj.fileName;
								var isUser = obj.isUse;
								$("#userId1").val(userId);
								$("#userName1").val(userName);
								$("#pwd1").val(pwd);
								$("#age1").val(age);
								$("#sex1").val(sex);
								$("#phoneNum1").val(phoneNum);
								$("#fileName1").val(fileName);
								var use = $("#isUse1").find('option[value="'+isUser+'"]').attr("selected",true);
								$('#edit').modal('show');
							}

						});
				$("#btn_delete").click(
						function() {
							url:"user/deluser"
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请选择一行");
							} else {

								var arrs = [];
								for (var i = 0; i < select.length; i++) {
									arrs[i] = select[i]['userId'];
								}

								$('#tb_departments').bootstrapTable('remove', {
									field : 'userId',
									values : arrs[0]
								});

								$.getJSON("user/deluser",{userId:arrs[0],isUse:'0'}, function(result) {
									if (result.status == "success") {
										toastr.success("删除成功");
										$('#tb_departments').bootstrapTable('refresh');

									} else {
										toastr.error("删除失败");
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
			
			$('#uploadUser').click(function(){
				var options = {
						url:'user/adduser',
						beforeSubmit:function(){
							$('#addUser').data('bootstrapValidator').validate();
							var result = $('#addUser').data('bootstrapValidator').isValid();
							if(!result){
								toastr.warning("校验失败");
								return false;
								
							}
							return true;
						},
						success:function(data){
							$("#uModal").modal('hide');
							if(data.status=='success'){
								$('#tb_departments').bootstrapTable('refresh');
								toastr.success('添加成功')
							}else{
								toastr.error('添加失败')
							}
						},
						type:'post',
						clearForm:true
				};
				$("#addUser").ajaxSubmit(options);
			});
			
			
			
			$("#subUp").click(function(){
				var userId=$("#userId1").val();
				var userName = $("#userName1").val();
				var pwd = $("#pwd1").val();
				var age = $("#age1").val();
				var sex = $("#sex1").val();
				var phoneNum = $("#phoneNum1").val();
				var orgId = $("#edit").find("input[name='orgId']").val();
				var isUse = $("#isUse1").val();
			$.ajax({
				url:"user/upduser",
				type:"post",
				data:{
					  "userId":userId,
					  "userName":userName,
					  "pwd":pwd,
					  "age":age,
					  "sex":sex,
					  "phoneNum":phoneNum,
					  "orgId":orgId,
					  "isUse":isUse,
				},
			traditional: true,
			success:function(result) {
				$('#edit').modal('hide');
				if (result.status == "success") {
					$('#tb_departments').bootstrapTable('refresh');
						toastr.success("修改成功");
					}else{
						toastr.error("修改失败");
					}
				}
			});
		});
	});
		
		$(function(){
			$('.orgselect').selectpicker({
                'selectedText': 'cat',
				type:'select',
				hiddenInput:true,
				url:'org/allOrg',
				inputName:'orgId',
				key:'orgId',
				value:'orgName'
            });
			$('#addUser').bootstrapValidator({
				fields:{
					userName:{
						message:'用户名验证失败',
						validators:{
							notEmpty:{
								message:'用户名不能为空'
							}							
						}
					},
					pwd:{
						validators:{
							notEmpty:{
								message:'密码不能为空'
							}
						}
					},
					age:{
						validators:{
							notEmpty:{
								message:'年龄不能为空'
							}
						}
					},
					sex:{
						validators:{
							notEmpty:{
								message:'性别不能为空'
							}
						}
					},
					phoneNum:{
						validators:{
							notEmpty:{
								message:'联系电话不能为空'
							},regexp:{
								
								regexp:/^1[3|4|5|8|7][0-9]\d{6,8}$/,
								message:'电话号码格式不正确,请输入11位的电话号码'
							}
							
						}
					},
					fileName:{
						validators:{
							notEmpty:{
								message:'部门不能为空'
							}
						}
					},
					isUse:{
						validators:{
							notEmpty:{
								message:'状态不能为空'
							}
						}
					}
					
				}
			});
		});
		
		
	</script>


</body>
</html>
