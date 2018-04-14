<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查台转单</title>

<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="static/toastr/toastr.css" rel="stylesheet" type="text/css">
<link
	href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" type="text/css"> 
<link href="static/jqueryCsxz/zyzn_1.css" rel="stylesheet" type="text/css">
<link href="static/select/bootstrap-select.css" rel="stylesheet" type="text/css">
<link href="static/select/bootstrap-treeview.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="static/toastr/toastr.css">

<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>
<script type="text/javascript"
	src="static/select/bootstrap-treeview.min.js"></script>
<script type="text/javascript" src="static/select/bootstrap-select.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="static/jqueryCsxz/City_data.js"></script>
<script type="text/javascript" src="static/jqueryCsxz/areadata.js"></script>
<script type="text/javascript" src="static/jqueryCsxz/auto_area.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("#txt_search_empNum").blur(function(){
			$.ajax({
				type:"post",//请求方式
				url:'cmts/findPhoneNumByEmpNum',//url地址
				data:{empNum:$("#txt_search_empNum").val()},//请求参数
				dataType:"text",//响应数据格式
				success:function(data){
					$('#txt_search_phoneNum').val(data);
				}//成功回调函数
			});
		});
		
		
		$("#btn_turnTheSingle").click(function(){
			checkMTS();
			
		});
		
		$("#turnTheSinglea").css({
			"pointer-events":"none",
			"color":"gray"
		});

		//1.初始化Table
		var oTable = new TableInit();
		oTable.Init();

		//2.初始化Button的点击事件
		var oButtonInit = new ButtonInit();
		oButtonInit.Init();

		var myDate = new Date().Format("yyyy-MM-dd");
		$("#txt_search_workOrderTime").val(myDate);
		
		$("#btn_query").click(function(){
			var options={
					url:'cmts/query', //form提交数据的地址
					type:'post', //form提交的方式(method:post/get)
					dataType:'json', //服务器返回数据类型
					beforeSubmit:function(){//提交前校验
						var empNum = $("#txt_search_empNum").val();
						if(empNum == ""){
							toastr.error("员工号不能为空");
						}
					},
					success:function(data){
						if(data.status == 1){
							initSelect();
							$('#queryTable').bootstrapTable('load', data);
							$("#turnTheSinglea").css({
								"pointer-events":"auto",
								"color":"black"
							});
							$.ajax({
								type:"post",//请求方式
								url:"cmts/queryNewWorkOrder",//url地址
								data:{empNum:$("#txt_search_empNum").val(),
									workOrderTime:$("#txt_search_workOrderTime").val()},//请求参数
								dataType:"json",//响应数据格式
								success:function(data){
									$('#newWorkOrder').bootstrapTable('load', data);
								}//成功回调函数
							});
							$.ajax({
								type:"post",//请求方式
								url:"cmts/queryOldWorkOrder",//url地址
								data:{oldEmpNum:$("#txt_search_empNum").val(),
									oldWorkOrderTime:$("#txt_search_workOrderTime").val()},//请求参数
								dataType:"json",//响应数据格式
								success:function(data){
									$('#oldWorkOrder').bootstrapTable('load', data);
								}//成功回调函数
							});
						}else if(data.status == 2){
							$('#queryTable').bootstrapTable('load', data);
							$("#turnTheSinglea").css({
								"pointer-events":"none",
								"color":"gray"
							});
							$("#turnTheSingleali").click(function(){
								toastr.info("转单已被禁用");
							});
						}else if(data.status == 3){
							toastr.error("未找到相关数据");
						}else if(data.status == 0){
							toastr.error("员工密码错误");
						}
					} //提交成功后执行的回调函数
			}
			$("#formSearch").ajaxSubmit(options);
		});
		
		$("#btn_turnTheSingleSubmit").click(function(){
			turnTheSingleAA();
		});
		
		$('#txt_search_workOrderTime').datetimepicker({
	        format: 'yyyy-mm-dd',
	        language: 'zh-CN',
	        autoclose: true,
	        todayHighlight: true
	    });
		
		
		$('#intoTheWay').change(function(){
			var target = $(this).val();
			if(target == "empNumDiv"){
				$('#empNumDiv').css("display","block");
				$('#fixedAreaNumDiv').css("display","none");
				$('#orgNameDiv').css("display","none");
			}else if(target == "orgNameDiv"){
				$('#empNumDiv').css("display","none");
				$('#fixedAreaNumDiv').css("display","none");
				$('#orgNameDiv').css("display","block");
			}else if(target == "fixedAreaNumDiv"){
				$('#empNumDiv').css("display","none");
				$('#fixedAreaNumDiv').css("display","block");
				$('#orgNameDiv').css("display","none");
			}
		});
		
		
	});
	
	function initSelect(){
		$('#intoTheWay').selectpicker({
			'selectedText' : 'cat',
			type : 'select'
		});
		$('#fixedAreaNum').selectpicker({
			'selectedText' : 'cat',
			type : 'select',
			url:'cmts/allFixedAreaNum',
			key:'fixedAreaId',
			value:'fixedAreaNum'
		});
		
		$('#empNum').selectpicker({
			'selectedText' : 'cat',
			type : 'select',
			url:'cmts/allEmpNum',
			key:'empId',
			value:'empNum'
		});
		
		$.post('cmts/orgDtoTree',{date:new Date()},function(result){
	    	$('#orgName').selectpicker({
				type:'tree',
				tree:{
					data:result
				},
				hiddenInput:true,
				inputName:'takeOrgName'
				
	        });
    	});
		
		/* $('#orgName').selectpicker({
			'selectedText' : 'cat',
			type : 'select',
			url:'cmts/allOrgName',
			key:'orgId',
			value:'orgName'
		}); */
	}
	
	function loadTable(data){
		$('#queryTable').bootstrapTable({
			data:data,
			toolbar : '#toolbar', //工具按钮用哪个容器 
			striped : true, //是否显示行间隔色 
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
			pagination : true, //是否显示分页（*） 
			sortable : false, //是否启用排序 
			sortOrder : "asc", //排序方式
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
			pageNumber : 1, //初始化加载第一页，默认第一页 
			pageSize : 10, //每页的记录行数（*） 
			pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
			search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
			strictSearch : true,
			showColumns : true, //是否显示所有的列 
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行 
			height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
			uniqueId : "workOrderNo", //每一行的唯一标识，一般为主键列 
			showToggle : true, //是否显示详细视图和列表视图的切换按钮 
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'workOrderNo',
				title : '工单号'
			}, {
				field : 'noteNum',
				title : '短信序号'
			}, {
				field : 'businessRecsiptNo',
				title : '业务通知单号'
			}, {
				field : 'workOrderTime',
				title : '工单生成时间'
			}, {
				field : 'serveAddress',
				title : '收件地址'
			}, {
				field : 'contacts',
				title : '联系人'
			}, {
				field : 'telephone',
				title : '联系电话'
			}, {
				field : 'traceNum',
				title : '追单次数'
			}, {
				field : 'operatorOrg',
				title : '处理单位'
			} ]
		});
	}
	
	function loadNewTable(data){
		$('#newWorkOrder').bootstrapTable({
			data:data,
			toolbar : '#toolbar', //工具按钮用哪个容器 
			striped : true, //是否显示行间隔色 
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
			pagination : true, //是否显示分页（*） 
			sortable : false, //是否启用排序 
			sortOrder : "asc", //排序方式
			queryParams : oTableInit.queryParams,//传递参数（*） 
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
			pageNumber : 1, //初始化加载第一页，默认第一页 
			pageSize : 10, //每页的记录行数（*） 
			pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
			search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
			strictSearch : true,
			showColumns : true, //是否显示所有的列 
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行 
			height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
			uniqueId : "workOrderNo", //每一行的唯一标识，一般为主键列 
			showToggle : true, //是否显示详细视图和列表视图的切换按钮 
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'workOrderNo',
				title : '工单号'
			}, {
				field : 'workOrderType',
				title : '工单类型'
			}, {
				field : 'wstatus',
				title : '取件状态'
			}, {
				field : 'noteNum',
				title : '短信序号'
			}, {
				field : 'workOrderTime',
				title : '工单生成时间'
			}, {
				field : 'traceNum',
				title : '追单次数'
			}, {
				field : 'empNum',
				title : '小件员编号'
			}, {
				field : 'takeOrgName',
				title : '取件单位'
			}, {
				field : 'takeTime',
				title : '取件时间'
			}, {
				field : 'sortingCode',
				title : '分拣编码'
			} ]
		});
	}
	
	function loadOldTable(data){
		$('#oldWorkOrder').bootstrapTable({
			data:data,
			toolbar : '#toolbar', //工具按钮用哪个容器 
			striped : true, //是否显示行间隔色 
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
			pagination : true, //是否显示分页（*） 
			sortable : false, //是否启用排序 
			sortOrder : "asc", //排序方式
			queryParams : oTableInit.queryParams,//传递参数（*） 
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
			pageNumber : 1, //初始化加载第一页，默认第一页 
			pageSize : 10, //每页的记录行数（*） 
			pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
			search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
			strictSearch : true,
			showColumns : true, //是否显示所有的列 
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行 
			height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
			uniqueId : "workOrderNo", //每一行的唯一标识，一般为主键列 
			showToggle : true, //是否显示详细视图和列表视图的切换按钮 
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'oldWorkOrderNo',
				title : '工单号'
			}, {
				field : 'oldWorkOrderType',
				title : '工单类型'
			}, {
				field : 'oldWstatus',
				title : '取件状态'
			}, {
				field : 'oldNoteNum',
				title : '短信序号'
			}, {
				field : 'oldWorkOrderTime',
				title : '工单生成时间'
			}, {
				field : 'oldTraceNum',
				title : '追单次数'
			}, {
				field : 'oldEmpNum',
				title : '小件员编号'
			}, {
				field : 'oldTakeOrgName',
				title : '取件单位'
			}, {
				field : 'oldTakeTime',
				title : '取件时间'
			}, {
				field : 'oldSortingCode',
				title : '分拣编码'
			} ]
		});
	}

	var TableInit = function() {
		var oTableInit = new Object();

		//初始化Table
		oTableInit.Init = function() {
			
			$('#queryTable').bootstrapTable({
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 10, //每页的记录行数（*） 
				pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
				search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
				strictSearch : true,
				showColumns : true, //是否显示所有的列 
				showRefresh : true, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "workOrderNo", //每一行的唯一标识，一般为主键列 
				showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				columns : [ {
					checkbox : true
				}, {
					field : 'workOrderNo',
					title : '工单号'
				}, {
					field : 'noteNum',
					title : '短信序号'
				}, {
					field : 'businessRecsiptNo',
					title : '业务通知单号'
				}, {
					field : 'workOrderTime',
					title : '工单生成时间'
				}, {
					field : 'serveAddress',
					title : '收件地址'
				}, {
					field : 'contacts',
					title : '联系人'
				}, {
					field : 'telephone',
					title : '联系电话'
				}, {
					field : 'traceNum',
					title : '追单次数'
				}, {
					field : 'operatorOrg',
					title : '处理单位'
				} ]
			});
			

			$('#newWorkOrder').bootstrapTable({
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 10, //每页的记录行数（*） 
				pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
				search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
				strictSearch : true,
				showColumns : true, //是否显示所有的列 
				showRefresh : true, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "workOrderNo", //每一行的唯一标识，一般为主键列 
				showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				columns : [ {
					checkbox : true
				}, {
					field : 'workOrderNo',
					title : '工单号'
				}, {
					field : 'workOrderType',
					title : '工单类型'
				}, {
					field : 'wstatus',
					title : '取件状态'
				}, {
					field : 'noteNum',
					title : '短信序号'
				}, {
					field : 'workOrderTime',
					title : '工单生成时间',
					formatter:function (value){
						return formatDate(value);
					}
				}, {
					field : 'traceNum',
					title : '追单次数'
				}, {
					field : 'empNum',
					title : '小件员编号'
				}, {
					field : 'takeOrgName',
					title : '取件单位'
				}, {
					field : 'takeTime',
					title : '取件时间',
					formatter:function (value){
						return formatDate(value);
					}
				}, {
					field : 'sortingCode',
					title : '分拣编码'
				} ]
			});

			$('#oldWorkOrder').bootstrapTable({
				toolbar : '#toolbar', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 10, //每页的记录行数（*） 
				pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
				search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
				strictSearch : true,
				showColumns : true, //是否显示所有的列 
				showRefresh : true, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
				uniqueId : "oldWorkOrderNo", //每一行的唯一标识，一般为主键列 
				showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				columns : [ {
					checkbox : true
				}, {
					field : 'oldWorkOrderNo',
					title : '工单号'
				}, {
					field : 'oldWorkOrderType',
					title : '工单类型'
				}, {
					field : 'oldWstatus',
					title : '取件状态'
				}, {
					field : 'oldNoteNum',
					title : '短信序号'
				}, {
					field : 'oldWorkOrderTime',
					title : '工单生成时间'
				}, {
					field : 'oldTraceNum',
					title : '追单次数'
				}, {
					field : 'oldEmpNum',
					title : '小件员编号'
				}, {
					field : 'oldTakeOrgName',
					title : '取件单位'
				}, {
					field : 'oldTakeTime',
					title : '取件时间'
				}, {
					field : 'oldSortingCode',
					title : '分拣编码'
				} ]
			});
		}; //得到查询的参数

		return oTableInit;
	};

	var ButtonInit = function() {
		var oInit = new Object();
		var postdata = {};

		oInit.Init = function() {
			//初始化页面上面的按钮事件
		};

		return oInit;
	};
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth()+1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth()+3)/3), //季度
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
	
	function formatDate(ns) {
		var now = new Date(ns);
		var year=now.getYear()+1900;
		var month=now.getMonth()+1;
		if(month<10){
			month = "0"+month;
		}
		var date=now.getDate();
		if(date<10){
			date = "0"+date;
		}
		var hour=now.getHours();
		if(hour<10){
			hour = "0"+hour;
		}
		var minute=now.getMinutes();
		if(minute<10){
			minute = "0"+minute;
		}
		return year+"-"+month+"-"+date+" "+hour+":"+minute;

	}
	
	function formatDateXX(ns) {
		var now = new Date(ns);
		var year=now.getYear()+1900;
		var month=now.getMonth()+1;
		if(month<10){
			month = "0"+month;
		}
		var date=now.getDate();
		if(date<10){
			date = "0"+date;
		}
		var hour=now.getHours();
		if(hour<10){
			hour = "0"+hour;
		}
		var minute=now.getMinutes();
		if(minute<10){
			minute = "0"+minute;
		}
		return year+"-"+month+"-"+date;

	}
	
	function checkMTS(){
		var selection = $("#newWorkOrder").bootstrapTable('getSelections');
		if(selection.length == 1){
			$("#turnTheSingleModel").modal("show");
		}else{
			toastr.warning("请选中一行!");
		}
	}
	
	function turnTheSingleAA(){
		var selection = $("#newWorkOrder").bootstrapTable('getSelections');
		var oldWorkOrderTime = selection[0]['workOrderTime'];
		var o = formatDateXX(oldWorkOrderTime);
		var takeTime = selection[0]['takeTime'];
		var t = formatDate(takeTime);
		var target = $("#intoTheWay").val();
		var sortingCode = $("#fixedAreaNum").val();
		var empNum = $("#empNum").val();
		var takeOrgName = $("#orgName").prev().val();
		if(target == "empNumDiv"){
			sortingCode = "";
			takeOrgName = "";
		}else if(target == "orgNameDiv"){
			sortingCode = "";
			empNum = "";
		}else if(target == "fixedAreaNumDiv"){
			empNum = "";
			takeOrgName = "";
		}
		$.ajax({
			url:"cmts/turnTheSingle",
			type:"post",
			data:{
				oldWorkOrderNo : selection[0]['workOrderNo'],
				oldWorkOrderType : selection[0]['workOrderType'],
				oldWstatus : selection[0]['wstatus'],
				oldNoteNum : selection[0]['noteNum'],
				oldWorkOrderTime : o,
				oldTraceNum : selection[0]['traceNum'],
				oldEmpNum : selection[0]['empNum'],
				oldTakeOrgName : selection[0]['takeOrgName'],
				oldTakeTime : t,
				oldSortingCode : selection[0]['sortingCode'],
				sortingCode : sortingCode,
				empNum : empNum,
				takeOrgName : takeOrgName
			},
			async:true,
			traditional:true,
			success:function(data){
				if(data.status == 1){
					toastr.success("转单成功",{timeOut:2000,progressBar:true});
					$("#turnTheSingleModel").modal("hide");
					$.ajax({
						type:"post",//请求方式
						url:"cmts/queryNewWorkOrder",//url地址
						data:{empNum:$("#txt_search_empNum").val(),
							workOrderTime:$("#txt_search_workOrderTime").val()},//请求参数
						dataType:"json",//响应数据格式
						success:function(data){
							$('#newWorkOrder').bootstrapTable('load', data);
						}//成功回调函数
					});
					$.ajax({
						type:"post",//请求方式
						url:"cmts/queryOldWorkOrder",//url地址
						data:{oldEmpNum:$("#txt_search_empNum").val(),
							oldWorkOrderTime:$("#txt_search_workOrderTime").val()},//请求参数
						dataType:"json",//响应数据格式
						success:function(data){
							$('#oldWorkOrder').bootstrapTable('load', data);
						}//成功回调函数
					});
				}else if(data.status == 0){
					$("#turnTheSingleModel").modal("hide");
					toastr.error("转单失败",{timeOut:2000,progressBar:true});
				}
			}
		});
	}
</script>
</head>
<body class="default">
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#query" data-toggle="tab"> 查台 </a></li>
		<li id="turnTheSingleali"><a href="#turnTheSingle" data-toggle="tab" id="turnTheSinglea" style="pointer-events:none;color:gary;">转单</a></li>
		<li><span id="spanBtn"></span></li>
		<li></li>
	</ul>

	<div class="panel-body">
		<div class="panel panel-default">
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="query">
					<div style="height:20px;"></div>
					<form id="formSearch" class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-sm-1"
								for="txt_search_departmentname">员工工号</label>
							<div class="col-sm-3" style="height: 50px;">
								<input type="text" class="form-control" id="txt_search_empNum" name="empNum"
									placeholder="请输入员工工号" style="width: 50%;">
							</div>
							<label class="control-label col-sm-1"
								for="txt_search_departmentname">电话号码</label>
							<div class="col-sm-3" style="height: 50px;">
								<input type="text" class="form-control" id="txt_search_phoneNum" name="phoneNum"
									style="width: 50%;" readonly>
							</div>
							<label class="control-label col-sm-1"
								for="txt_search_departmentname">查台密码</label>
							<div class="col-sm-3" style="height: 50px;">
								<input type="text" class="form-control"
									id="txt_search_empPassword" placeholder="请输入查台密码" name="empPassword"
									style="width: 50%;">
							</div>
							<label class="control-label col-sm-1"
								for="txt_search_departmentname">短信序号</label>
							<div class="col-sm-3" style="height: 50px;">
								<input type="text" class="form-control" id="txt_search_noteNum" name="noteNum"
									placeholder="请输入短息序号" style="width: 50%;">
							</div>
							<label class="control-label col-sm-1"
								for="txt_search_departmentname">通知单号</label>
							<div class="col-sm-3" style="height: 50px;">
								<input type="text" class="form-control"
									id="txt_search_businessRecsiptNo" placeholder="请输入通知单号" name="businessRecsiptNo"
									style="width: 50%;">
							</div>
							<label class="control-label col-sm-1"
								for="txt_search_departmentname">工单日期</label>
							<div class="col-sm-3" style="height: 50px;">
								<input type="text" class="form-control"
									id="txt_search_workOrderTime" placeholder="工单日期" name="workOrderTime"
									style="width: 50%;" data-date-format="yyyy-mm-dd" readonly>
							</div>
							<label class="control-label col-sm-4"
								for="txt_search_departmentname">    </label>
							<div class="col-sm-6" style="height: 50px;">
								<button type="button" id="btn_query" class="btn btn-primary"
									style="text-align: center; width: 50%;">查台</button>
							</div>
						</div>
					</form>
					<table id="queryTable"></table>
				</div>
				<div class="tab-pane fade" id="turnTheSingle">
					<button type="button" id="btn_turnTheSingle"
						class="btn btn-primary" style="text-align: center; width: 20%;"
						data-toggle="modal">转单</button>
					<label class="control-label col-sm-1"
								for="txt_search_departmentname">新工单</label>
					<table id="newWorkOrder"></table>
					<label class="control-label col-sm-1"
								for="txt_search_departmentname">销工单</label>
					<table id="oldWorkOrder"></table>
				</div>
			</div>

			<div class="modal fade" id="turnTheSingleModel" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">转单</h4>
						</div>
						<div class="modal-body">
							<form class="form-horizontal" role="form" id="turnTheSingleForm">
								<div class="form-group">
									<label for="lastname" class="col-sm-2 control-label">转入方式</label>
									<div class="col-sm-10">
										<select id="intoTheWay" class="selectpicker bla bla bli"
											data-live-search="true">
											<option value="fixedAreaNumDiv">定区编码</option>
											<option value="empNumDiv">小件员工号</option>
											<option value="orgNameDiv">单位</option>
										</select>
										<!-- /input-group -->
									</div>
								</div>
								<div class="form-group" id="fixedAreaNumDiv">
									<label class="col-sm-2 control-label">转入目标</label>
									<div class="col-sm-10">
										<select id="fixedAreaNum" class="selectpicker bla bla bli"
											data-live-search="true">
											<option> </option>
										</select>
									</div>
								</div>
								<div class="form-group" id="empNumDiv" style="display:none;">
									<label class="col-sm-2 control-label">转入目标</label>
									<div class="col-sm-10">
										<select id="empNum" class="selectpicker bla bla bli"
											data-live-search="true">
											<option> </option>
										</select>
									</div>
								</div>
								<div class="form-group" id="orgNameDiv" style="display:none;">
									<label class="col-sm-2 control-label">转入目标</label>
									<div class="col-sm-10">
										<select id="orgName" class="selectpicker bla bla bli"
											data-live-search="true">
											<option> </option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="button" class="btn btn-default" id="btn_turnTheSingleSubmit">转单</button>
									</div>
								</div>
							</form>

						</div>

					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>

		</div>
</body>
</html>