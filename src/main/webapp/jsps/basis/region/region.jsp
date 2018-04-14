<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<link href="static/toastr/toastr.css" rel="stylesheet">


<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>

<script src="static/jquery.form.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>

<script type="text/javascript" src="static/jquery.ocupload-1.1.2.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/jquery.citys.js"></script>

<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>


</head>

<script type="text/javascript">
 $(function(){
	 
	 $('#linkage').citys({code:350206});
	 
 })

</script>

<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1" for="txt_search_province">省份</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="txt_search_province"
								name="province">
						</div>
						<label class="control-label col-sm-1" for="txt_search_city">城市</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="txt_search_city"
								name="city">
						</div>
						<label class="control-label col-sm-1" for="txt_search_county">县级</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="txt_search_county"
								name="county">
						</div>
					</div>
					<div class="form-group" style="margin-top: 15px">
						<div class="col-sm-12" style="text-align: left;">
							<button type="button" style="margin-left: 50px" id="btn_query"
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
			<button id="btn_edit" type="button" class="btn btn-primary">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-danger">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button id="btn_leadout" type="button" class="btn btn-warning">
				<span class="glyphicon glyphicon-cloud-download" aria-hidden="true"></span>导出
			</button>
			<button id="btn_leading" type="button" class="btn btn-inverse">
				<span class="glyphicon glyphicon-cloud-upload" aria-hidden="true"></span>导入
			</button>
		</div>
		<table id="tb_departments"></table>
	</div>


	<div class="modal fade" id="add" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">添加</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="addForm"
						onsubmit="return check()" role="form">
						<div class="form-group" id="linkage">
							<label for="firstname" class="col-sm-2 control-label">省</label>
							<div class="col-sm-4">
								<select class="form-control" id="province" name="province"></select>
							</div>
							<label for="firstname" class="col-sm-2 control-label">城市</label>
							<div class="col-sm-4">
								<select class="form-control" id="city" name="city"></select>
							</div>
							<label for="firstname" class="col-sm-2 control-label">区/县</label>
							<div class="col-sm-4">
								<select class="form-control" id="county" name="area"></select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">邮编</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="postcode"
									placeholder="请输入邮编" name="postcode">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">城市编码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="citycode"
									placeholder="请输入邮编" name="citycode">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">简码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="brevitycode"
									placeholder="请输入简码" name="brevitycode">
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

	<div class="modal fade" id="update" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" onsubmit="return check()" role="form">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">省份</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="update-province"
									placeholder="请输入省份">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">城市</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="update-city"
									placeholder="请输入城市">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">县级</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="update-county"
									placeholder="请输入县级">
							</div>
						</div>

						<div class="form-group">
							<div class="text-center">
								<button id="sub-update" class="btn btn-primary">提交</button>
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


	<script type="text/javascript">
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'region/findAllArea', //请求后台的URL（*） 
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
					pageSize : 7, //每页的记录行数（*） 
					pageList : [ 5, 10, 50, 100 ], //可供选择的每页的行数（*） 
					search : false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "areaId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'areaId',
						title : '区域Id'
					},  {
						field : 'province',
						title : '省份'
					}, {
						field : 'city',
						title : '城市'
					}, {
						field : 'county',
						title : '县级'
					}, {
						field : 'postcode',
						title : '邮编'
					}, {
						field : 'citycode',
						title : '城市编码'
					}, {
						field : 'brevitycode',
						title : '简码'
					}, {
						field : 'isUse',
						title : '状态',
						formatter:function(value){
							if(value == "1"){
								return "已配备";	
							}else{
								return "未配备";
							}
						}
					} ]
				});
			}; //得到查询的参数

			oTableInit.queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset, //页码 
					province : $("#txt_search_province").val(),
					city : $("#txt_search_city").val(),
					county : $("#txt_search_county").val()
				};
				return temp;
			};
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

				//修改区域
				$("#btn_edit").click(function() {
						var select = $('#tb_departments').bootstrapTable('getSelections');
						if (select.length === 0) {
							toastr.warning("请选择一行");
						} else if(select.length > 1){
							toastr.warning("不能选择多行");
						} else{
							$("#update").modal('show');
							$("#sub-update").click(function(){
								var arrs = [];
								for (var i = 0; i < select.length; i++) {
									arrs[i] = select[i]['areaId'];
								}
								//异步同步数据库
								$.ajax({
									url : "region/updateArea",
									type : "post",
									data : {
										"province":$('#update-province').val(),
										"city":$('#update-city').val(),
										"county": $('#update-county').val(),
										"areaId":arrs
									},
									traditional : true,//这里设置为true
									success : function(result) {
										if (result.status == "success") {
											toastr.success("修改成功");
											$("#update").modal('hide');
											$('#tb_departments').bootstrapTable('refresh');
										} else {
											toastr.error("修改失败");
										}
									}
								});
							});
						}
				});
				
				//删除
				$("#btn_delete").click(
						function() {
							var select = $('#tb_departments').bootstrapTable('getSelections');
							if (select.length === 0) {
								toastr.warning("请选择一行");
							} else {
								var arrs = [];
								for (var i = 0; i < select.length; i++) {
									arrs[i] = select[i]['areaId'];
								}
								
								$.ajax({
									url : "region/deleteArea",
									type : "post",
									data : {
										"areaId" : arrs
									},
									traditional : true,//这里设置为true
									success : function(result) {
										if (result == "success") {
											$('#tb_departments').bootstrapTable('remove', {
												field : 'areaId',
												values : arrs
											}); 
											toastr.success("删除成功");
										} else {
											toastr.error("删除失败");
										}
									}
								})
								
							}

						});
				
				$("#btn_leading").click(function(){
					$("#btn_leading").upload({
				        action:"region/uploadArea", //表单提交的地址
				        name:"myFile",
				        onComplete:function (data) { //提交表单之后
				           if(data == "0"){
				        	   toastr.success("Excel导入成功"); //提示框，Excel导入成功
				            }else{
				            	toastr.error("Excel导入失败"); //提示框，Excel导入成失败
				            }
				        },
				        onSelect: function() {//当用户选择了一个文件后触发事件
				            //当选择了文件后，关闭自动提交
				            this.autoSubmit=false;
				            //校验上传的文件名是否满足后缀为.xls或.xlsx
				            var regex =/^.*\.(?:xls|xlsx)$/i;
				            if(regex.test($("[name = '"+this.name()+"']").val())){
				            	toastr.success("导入成功");
				                //通过校验
				                this.submit();
				            }else{
				            	toastr.error("未通过");
				                //未通过
					        	alert($("[name = 'myFile']"));
				            }
				        }
				    });
				});
				
				$("#btn_leadout").click(function(){
					$.ajax({
						type:"post",
						url:"region/outArea",
						data:{
							path:"E://区域导出.xls"
						},
						success:function(result){
							if (result == "success") {
								toastr.success("导出成功");
							} else {
								toastr.success("导出失败");
							}
						}
					});
				});
				
			};
			return oInit;
		};
		
		$("#sub").click(function() {
			var obj = {
					province : $('#province').find("option:selected").text(),
					city : $('#city').find("option:selected").text(),
					county : $('#county').find("option:selected").text(),
					postcode : $('#postcode').val(),
					citycode : $('#citycode').val(),
					brevitycode : $('#brevitycode').val()
			};
			
			var addressInit = function(_province, _city, _county,
					defaultProvince, defaultCity, defaultCounty){  
			    var province = document.getElementById(province);  
			    var city = document.getElementById(city);  
			    var county = document.getElementById(county);  
			      
			    function cmbSelect(cmb, str)  
			    {  
			        for(var i=0; i<cmb.options.length; i++)  
			        {  
			            if(cmb.options[i].value == str)  
			            {  
			                cmb.selectedIndex = i;  
			                return;  
			            }  
			        }  
			    }  
			    function cmbAddOption(cmb, str, obj)  
			    {  
			        var option = document.createElement("OPTION");  
			        cmb.options.add(option);  
			        option.innerText = obj;  
			        option.value = obj;  
			        option.obj = obj;  
			    }  
			      
			    function changeCity()  
			    {  
			        county.options.length = 0;  
			        if(city.selectedIndex == -1)return;  
			        var item = city.options[city.selectedIndex].obj;  
			        for(var i=0; i<item.areaList.length; i++)  
			        {  
			            cmbAddOption(county, item.areaList[i], null);  
			        }  
			        cmbSelect(county, defaultCounty);  
			    }  
			    function changeProvince()  
			    {  
			        city.options.length = 0;  
			        city.onchange = null;  
			        if(province.selectedIndex == -1)return;  
			        var item = province.options[province.selectedIndex].obj;  
			        for(var i=0; i<item.cityList.length; i++)  
			        {  
			            cmbAddOption(city, item.cityList[i].name, item.cityList[i]);  
			        }  
			        cmbSelect(city, defaultCity);  
			        changeCity();  
			        city.onchange = changeCity;  
			    }  
			      
			    for(var i=0; i<provinceList.length; i++)  
			    {  
			        cmbAddOption(province, provinceList[i].name, provinceList[i]);  
			    }  
			    cmbSelect(province, defaultProvince);  
			    changeProvince();  
			    province.onchange = changeProvince;  
			}  
			
			var form =  $('#addForm').data('bootstrapValidator').isValid();
			
			//异步同步数据库
			$.getJSON("region/addArea", obj, function(result) {
					if(form){
						if (result.status == "success") {
							toastr.success("添加成功");
							$("#add").modal('hide');
							$('#tb_departments').bootstrapTable('refresh');
						} else {
							toastr.error("添加失败");
						}
						return true;
					}else{
						return false;
					}
			});
		});

		$("#btn_query").click(function() {
			var obj = {
				url : "region/findAllArea",
				type : "get",
				query : {
					province : $("#txt_search_province").val(),
					city : $("#txt_search_city").val(),
					county : $("#txt_search_county").val(),
					offset : 0
				}
			}
			$('#tb_departments').bootstrapTable('refresh', obj);
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
	            fields: {
	                postcode: {
	                    validators: {
	                        notEmpty: {
	                            message: '邮编不能为空'
	                        }
	                    }
	                },
	                citycode: {
	                    validators: {
	                        notEmpty: {
	                            message: '城市编码不能为空'
	                        }
	                    }
	                },
	                brevitycode: {
	                    validators: {
	                        notEmpty: {
	                            message: '简码不能为空'
	                        }
	                    }
	                }
	            }
	        });
	    });
		
		
		
		
		
		
		
	</script>


</body>
</html>
