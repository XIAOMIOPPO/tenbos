<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
	String path = request.getContextPath();
    SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>签收查询</title>
	<!-- Jquery组件引用 -->
	<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
	<!-- bootstrap组件引用 -->
	<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	    <link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css"/>
    <script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>			
	<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.css" />
    <script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<!-- bootstrap table组件以及中文包的引用 -->
	<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
	<link rel="stylesheet" type="text/css" href="static/bootstrap-3s.3.7-dist/css/bootstrap-table.css" />
	<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
	<!-- 提示框Js文件和Css的引用 -->
	<script type="text/javascript" src="static/toastr/toastr.js"></script>
	<link rel="stylesheet" type="text/css" href="static/toastr/toastr.css" />
	<%-- <script type="text/javascript" src="sweetalert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="sweetalert.css" /> --%>
	<!-- 页面下拉框Js文件和Css的引用 -->
	<script type="text/javascript" src="static/select/bootstrap-select.js"></script>
	<link rel="stylesheet" type="text/css" href="static/select/bootstrap-select.css" />
	<%-- <script type="text/javascript" src="$bus-table.js"></script> --%>	
    <style type="text/css">
		body {
			margin: 0;
			padding: 0
		}
		
		.background {
			margin-left: 100px;
		}
		
		p {
			height: 40px;
			line-height: 40px;
		}
		
		.open-model {
			text-align: center;
		}
		
		.open-model input {
			padding: 10px 20px;
			font-size: 24px;
			line-height: 24px;
			border: 0px;
			background: #F53639;
			color: #FFF;
			cursor: pointer;
		}
		
		.open-model input:hover {
			background: #F3726D;
		}
		
		.open-model input:focus {
			border: 0px;
			outline-width: 0px;
		}
		
		.model {
			opacity: 0.75;
			background: #666;
			position: fixed;
			left: 0;
			right: 0;
			top: 0;
			bottom: 0;
			z-index: 1000;
		}
		
		.model-dialog {
			width: 600px;
			height: 400px;
			background: white;
			position: absolute;
			z-index: 1001;
			left: 0;
			top: 0;
		}
		
		.hide {
			display: none;
		}
	</style>

</head>
<body>

	<div class="panel-body" style="padding-bottom:0px;">
        <div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">查询条件</div>
			<div class="panel-collapse collapse on" id="collapseOne">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">录入人姓名</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="txt_search_staffName">
						</div>
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">签收日期</label>
						<div class="col-sm-2">
							<input type="text" class="form-control form_datetime" value=<%=sdfTime.format(new Date()) %> id="txt_search_dateName">
						</div>
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">至</label>
						<div class="col-sm-2">
							<input type="text" class="form-control form_datetime" value=<%=sdfTime.format(new Date()) %> id="txt_search_dateName">
						</div>
						<br>
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">工作单号</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="txt_search_staffName">
						</div>
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">签收类型</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="txt_search_staffName">
						</div>
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">签收人员工号</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="txt_search_staffName">
						</div>
						<br>
						<br>
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">录入单位</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="txt_search_staffName">
						</div>
						<br>
						<br>
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">派送单位</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="txt_search_staffName">
						</div>
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">工单类型</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="txt_search_staffName">
						</div>						
						<div class="col-sm-2" style="text-align: left;">
						<shiro:hasPermission name="QSCX:ALL">
							<button type="button" style="margin-left: 50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</shiro:hasPermission>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div id="toolbar" class="btn-group">
		<shiro:hasPermission name="QSCX:EXPORT">
           <button id="btn_export" type="button" class="btn btn-inverse">
				<span class="glyphicon glyphicon-cloud-upload" aria-hidden="true"></span>导出
			</button>
	    </shiro:hasPermission>
        </div>
        <table id="td_signForInquiry"></table>
    </div>
    <script type="text/javascript">
	    $(function () {
	
	        //1.初始化Table
	        var oTable = new TableInit();
	        oTable.Init();
	
	        //2.初始化Button的点击事件
	        var oButtonInit = new ButtonInit();
	        oButtonInit.Init();
	        
	        $(".form_datetime").datetimepicker({
			      format: "yyyy-mm-dd",
			      autoclose: true,
			      todayBtn: true,
			      language:'zh-CN',
			      pickerPosition:"bottom-right",
			      minView:2
			});
	
	    });
	
	    var TableInit = function () {
	        var oTableInit = new Object();
	        //初始化Table
	        oTableInit.Init = function () {
	            $('#td_signForInquiry').bootstrapTable({
	                url: '/Home/GetDepartment',         //请求后台的URL（*）
	                method: 'get',                      //请求方式（*）
	                toolbar: '#toolbar',                //工具按钮用哪个容器
	                striped: true,                      //是否显示行间隔色
	                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	                pagination: true,                   //是否显示分页（*）
	                sortable: false,                     //是否启用排序
	                sortOrder: "asc",                   //排序方式
	                queryParams: oTableInit.queryParams,//传递参数（*）
	                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
	                pageNumber:1,                       //初始化加载第一页，默认第一页
	                pageSize: 10,                       //每页的记录行数（*）
	                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
	                search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	                strictSearch: true,
	                showColumns: true,                  //是否显示所有的列
	                showRefresh: true,                  //是否显示刷新按钮
	                minimumCountColumns: 2,             //最少允许的列数
	                clickToSelect: true,                //是否启用点击选中行
	                //height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	                //uniqueId: " ",                     //每一行的唯一标识，一般为主键列
	                showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
	                cardView: false,                    //是否显示详细视图
	                detailView: false,                   //是否显示父子表
	                columns: [{
	                    checkbox: true
	                }, {
	                    field: 'workOrderNo',
	                    title: '工作单号'
	                }, {
	                    field: 'workOrderType',
	                    title: '工单类型'
	                }, {
	                    field: 'staffNumber',
	                    title: '派送员工号'
	                }, {
	                    field: 'staffName',
	                    title: '派送人姓名'
	                },{
	                    field: 'getProductManName',
	                    title: '签收人姓名'
	                },{
	                    field: '',
	                    title: '签收时间'
	                },{
	                    field: '',
	                    title: '签收类型'
	                },{
	                    field: '',
	                    title: '签收单位'
	                },{
	                    field: '',
	                    title: '录入人'
	                },{
	                    field: '',
	                    title: '录入时间'
	                },{
	                    field: '',
	                    title: '录入单位'
	                }, ]
	            });
	        };
	
	        return oTableInit;
	    };
	
	
	    var ButtonInit = function () {
	        var oInit = new Object();
	        var postdata = {};
	
	        oInit.Init = function () {
	            //初始化页面上面的按钮事件
	        };
	
	        return oInit;
	    };
	    
	    $("#btn_query").click(function(){
			var obj = {
					url : "../../../log/logPageQuery.action",
					silent : true,
					query : {
						workOrderNo : $("#txt_search_workOrderNo").val(),
						staffPassword : $("#txt_search_staffPassword").val(),
						ssmNum : $("#txt_search_ssmNum").val(),
						businessRecsiptNo : $("#txt_search_businessRecsiptNo").val(),
						workOrderTime : $("#txt_search_workOrderTime").val(),
					}
			};
        	$('#td_signForInquiry').bootstrapTable('refresh');      	
        }); 
		
		$(function() {
			//1.初始化Table 
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件 
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();
			//3.初始化消息提示框
			toastr.options.positionClass = 'toast-top-center';
			toastr.options= { 
					closeButton: false,  //是否显示关闭按钮
					debug: false,   //是否为调试
					progressBar: true,  //是否显示进度条
					positionClass: "toast-top-center",  //在页面中显示的位置
					onclick: null,  //点击事件
					showDuration: "100",  //显示动作时间
					hideDuration: "1000",  //隐藏动作时间
					timeOut: "2000",  //自动关闭超时时间
					extendedTimeOut: "1000",  
					showEasing: "swing",  
					hideEasing: "linear",  
					preventDuplicates: true ,
					preventOpenDuplicates: true, //重复内容的提示框在开启时只出现一个
					showMethod: "fadeIn",  //显示的方式
					hideMethod: "fadeOut" //隐藏的方式
			};  
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
		
		function check(){
			
			//校验逻辑
			
			return false;
		}
	</script>
</body>
</html>