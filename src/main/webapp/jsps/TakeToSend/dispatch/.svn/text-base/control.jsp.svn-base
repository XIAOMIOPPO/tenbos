<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>取货监控查询</title>
	<!-- Jquery组件引用 -->
	<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
	<!-- bootstrap组件引用 -->
	<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css"/>
    <script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
	<!-- bootstrap table组件以及中文包的引用 -->
	<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
	<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css" />
	<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
	<!-- 提示框Js文件和Css的引用 -->
	<script type="text/javascript" src="static/toastr/toastr.js"></script>
	<link rel="stylesheet" type="text/css" href="static/toastr/toastr.css" />
    <!--<script type="text/javascript" src="sweetalert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="sweetalert.css" /> -->
	<!-- 页面下拉框Js文件和Css的引用 -->
	<script type="text/javascript" src="static/select/bootstrap-select.js"></script>
	<link rel="stylesheet" type="text/css" href="static/select/bootstrap-select.css" />
	<!-- <script type="text/javascript" src="/bus-table.js"></script> -->	
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
        <div id="toolbar" class="btn-group">
        <shiro:hasPermission name="QHJKCX:EXPORT">
           <button id="btn_export" type="button" class="btn btn-inverse">
				<span class="glyphicon glyphicon-cloud-upload" aria-hidden="true"></span>导出
			</button>
		</shiro:hasPermission>
        </div>
        <table id="tb_departments"></table>
    </div>
    <script type="text/javascript">
	    $(function () {
	
	        //1.初始化Table
	        var oTable = new TableInit();
	        oTable.Init();
	
	        //2.初始化Button的点击事件
	        var oButtonInit = new ButtonInit();
	        oButtonInit.Init();	
	    });
	
	
	    var TableInit = function () {
	        var oTableInit = new Object();
	        //初始化Table
	        oTableInit.Init = function () {
	            $('#tb_departments').bootstrapTable({
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
	                    field: '',
	                    title: '业务通知单'
	                }, {
	                    field: '',
	                    title: '取货标志'
	                }, {
	                    field: '',
	                    title: '受理时间'
	                }, {
	                    field: '',
	                    title: '分单开始时间'
	                },{
	                    field: '',
	                    title: '分单结束时间'
	                },{
	                    field: '',
	                    title: '确认时间'
	                },{
	                    field: '',
	                    title: '取件时间'
	                },{
	                    field: '',
	                    title: '分单类型'
	                },{
	                    field: '',
	                    title: '受理单位'
	                },{
	                    field: '',
	                    title: '受理人'
	                },{
	                    field: '',
	                    title: '取货单位'
	                },{
	                    field: '',
	                    title: '取货人姓名'
	                },{
	                    field: '',
	                    title: '确认单位'
	                },{
	                    field: '',
	                    title: '确认人'
	                },{
	                    field: '',
	                    title: '重要提示'
	                },{
	                    field: '',
	                    title: '追单次数'
	                },{
	                    field: '',
	                    title: '异常备注'
	                },{
	                    field: '',
	                    title: '到达地'
	                },{
	                    field: '',
	                    title: '发货方式'
	                },{
	                    field: '',
	                    title: '发货类型'
	                },{
	                    field: '',
	                    title: '品名'
	                },{
	                    field: '',
	                    title: '委托人'
	                },{
	                    field: '',
	                    title: '委托单位'
	                },{
	                    field: '',
	                    title: '委托地址'
	                },{
	                    field: '',
	                    title: '委托电话'
	                },{
	                    field: '',
	                    title: '代收款'
	                },{
	                    field: '',
	                    title: '到付款'
	                },{
	                    field: '',
	                    title: '客户单号'
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
    </script>
</body>
</html>