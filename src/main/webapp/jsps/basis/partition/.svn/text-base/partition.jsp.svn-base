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
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/common.css">
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/cssreset-min.css">
<link rel="stylesheet" type="text/css"
	href="static/toastr/toastr.css">
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css"
	href="static/toastr/toastr.css">
		
<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/jquery.citys.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/jquery.ocupload-1.1.2.js"></script>
<script type="text/javascript"
	src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="static/toastr/toastr.js"></script>	
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>


	
</head>
<script type="text/javascript">
 $(function(){
	 
	 $('#linkage').citys({code:350206});
	 
 });  

</script>
<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">分区Id</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="partitionId">
						</div>
						<label class="control-label col-sm-1" for="txt_search_statu">关键字</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="addressKey">
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
			<button id="btn_add" type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-danger">
				<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
			</button>
			<button id="btn_export" type="button" class="btn btn-inverse">
				<span class="glyphicon glyphicon-cloud-upload" aria-hidden="true"></span>导出
			</button>
			<button id="btn_leading" type="button" class="btn btn-warning">
				<span class="glyphicon glyphicon-cloud-download" aria-hidden="true"></span>导入
			</button>
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
						<div class="form-group" id="linkage">
						    <label for="firstname" class="col-sm-2 control-label">省:</label>
							<div  class="col-sm-4">
							   <select  class="form-control"  id = "province" name="province"></select>
							</div>
							<label for="firstname" class="col-sm-2 control-label">城市:</label>
							<div  class="col-sm-4">
	                           <select class="form-control" id="city" name="city"></select>
							</div>
							<label for="firstname"  class="col-sm-2 control-label">区/县:</label>
							<div  class="col-sm-4">
	                           <select class="form-control" id="county" name="area"></select>
							</div>
						</div>
					    
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">属性</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="property"
									placeholder="请输入属性" name="property">
							</div>
							<label for="lastname" class="col-sm-2 control-label">关键字</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="addressKey"
									placeholder="请输入关键字" name="addressKey">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">起始号</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="startNum"
									placeholder="请输入起始号" name="startNum">
							</div>
							<label for="lastname" class="col-sm-2 control-label">终止号</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="endNum"
									placeholder="请输入终止号" name="endNum">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">单双号</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="single"
									placeholder="请输入单双号" name="single">
							</div>
							<label for="lastname" class="col-sm-2 control-label">辅助关键字</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="secondaryKey"
									placeholder="请输入辅助关键字" name="secondaryKey">
							</div>
						</div>
						<div class="form-group">
							<div class="text-center">
								<button id="sub" class="btn btn-primary">提交</button>
								<button class="btn btn-info" data-dismiss="modal" aria-hidden="true">取消</button>
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
							<label for="lastname" class="col-sm-2 control-label">分区Id</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="updatePartition"
									placeholder="分区名称">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">属性</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="updateProperty"
									placeholder="属性">
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
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'partitionPageQuery', //请求后台的URL（*） 
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
					pageList : [ 3, 25, 50, 100 ], //可供选择的每页的行数（*） 
					search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数决定表格高度 
					uniqueId : "partitionId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					}, {
						field : 'province',
						title : '省份'
					}, {
						field : 'city',
						title : '市'
					}, {
						field : 'county',
						title : '区/县'
					}, {
						field : 'property',
						title : '属性'
					}, {
						field : 'addressKey',
						title : '关键字'
					}, {
						field : 'startNum',
						title : '起始号'
					}, {
						field : 'endNum',
						title : '终止号'
					}, {
						field : 'single',
						title : '单双号'
					}, {
						field : 'secondaryKey',
						title : '辅助关键字'
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
					url : "partitionPageQueryWithCriteria",
					silent : true,
					query : {
						type : 1,
						level : 2,
						partitionId : $('#partitionId').val(),
						addressKey : $('#addressKey').val()
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
				$("#btn_leading").click(function(){
					$("#btn_leading").upload({
				        action:"uploadArea", //表单提交的地址
				        name:"myFile",
				        onComplete:function (data) { //提交表单之后
				           if(data == "0"){
				        	   toastr.success("导入成功"); //提示框，Excel导入成功
				            }else{
				            	 toastr.success("导入失败");//提示框，Excel导入失败
				            }
				        },
				        onSelect: function() {//当用户选择了一个文件后触发事件
				            //当选择了文件后，关闭自动提交
				            this.autoSubmit=false;
				            //校验上传的文件名是否满足后缀为.xls或.xlsx
				            var regex =/^.*\.(?:xls|xlsx)$/i;
				           
				            if(regex.test($("[name = '"+this.name()+"']").val())){
				                //通过校验
				                this.submit();
				            }else{
				            	 toastr.error("未通过");
				                //未通过
				                alert($("[name = 'myFile']")); //错误提示框，文件格式不正确，必须以.xls或.xlsx结尾
				            }
				        }
				    }); 
					
				});
				$("#btn_export").click(function(){
					$.ajax({
						type:"post",
						url:"outArea",
						data:{
							path:"E://分区.xlsx"
						},
						success:function(result){
							if (result == "success") {
								 toastr.success("导出成功,可到E盘查看");
							} else {
								 toastr.sucerrorcess("导出失败");
							}
						}
					});
				});
				$("#btn_edit").click(
								function() {
									var select = $('#tb_departments')
											.bootstrapTable('getSelections');
									if (select.length != 1) {
										toastr.info("请选择一行");
									} else {
										$('#myModal2').modal('show')
										var obj = select[0];
										var upPartitionId = obj.partitionId;
										var upProperty = obj.property;

										$("#updatePartition")
												.val(upPartitionId);
										$("#updateProperty").val(upProperty);

										//修改
										$("#subUp")
												.click(
														function() {
															var UpdatePa = $(
																	"#updatePartition")
																	.val();
															var UpdatePr = $(
																	"#updateProperty")
																	.val();

															$.ajax({
																		url : "updatePartition",
																		type : "post",
																		data : {
																			"partitionId" : UpdatePa,
																			"property" : UpdatePr,
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

				$("#btn_delete").click(
						function() {
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								 toastr.warning("请选择一行");
							}else if(select.length > 1){
								toastr.warning("选择行数过多");
							} else {
								var arrs = [];
								for (var i = 0; i < select.length; i++) {
									arrs[i] = select[i]['partitionId'];
								}

								$('#tb_departments').bootstrapTable('remove', {
									field : 'partitionId',
									values : arrs
								});

								$.ajax({
									url : "deletePartition",
									type : "post",
									data : {
										"partitionId" : arrs
									},
									traditional : true,//这里设置为true
									success : function(result) {
										if (result == "success") {
											toastr.success("删除成功");
											var url = {
												url : 'partitionPageQuery'
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
				partitionId : $('#partitionId').val(),
				province : $('#province').find("option:selected").text(),
				city : $('#city').find("option:selected").text(),
				county : $('#county').find("option:selected").text(),
				property : $('#property').val(),
				addressKey:$('#addressKey').val(),
				startNum : $('#startNum').val(),
				endNum : $('#endNum').val(),
				single : $('#single').val(),
				secondaryKey : $('#secondaryKey').val()
			};
			var addressInit = function(_province, _city, _county, defaultProvince, defaultCity, defaultCounty)  
			{  
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
			$.getJSON("addPartition", obj, function(result) {
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
	                property: {
	                    validators: {
	                        notEmpty: {
	                            message: '属性不能为空'
	                        }
	                    }
	                },
	                addressKey: {
	                    validators: {
	                        notEmpty: {
	                            message: '关键字不能为空'
	                        }
	                    }
	                },
	                startNum: {   
	                    validators: {
	                        notEmpty: {
	                            message: '起始号不能为空'
	                        }
	                    }
	                },
	                endNum: {
	                    validators: {
	                        notEmpty: {
	                            message: '终止号不能为空'
	                        }
	                    }
	                },
	                single: {
	                    validators: {
	                        notEmpty: {
	                            message: '单双号不能为空'
	                        }
	                    }
	                },
	                secondaryKey: {
	                    validators: {
	                        notEmpty: {
	                            message: '辅助关键字不能为空'
	                        }
	                    }
	                }
	            }
	        });
	    });
		

	</script>

</body>
</html>
