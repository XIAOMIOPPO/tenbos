<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.yidu.tencloud.util.SessionCounter" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>TenCloud后台管理</title>
    <link rel="icon" type="image/x-icon" href="jsps/images/Logo.jpg">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	
	<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
	<link rel="stylesheet" href="jsps/css/ace/font-awesome.min.css" />
	
	<script src="static/jquery-3.2.1.min.js"></script>
	
	<link rel="stylesheet" href="jsps/css/ace/ace.min.css" />
	<link rel="stylesheet" href="jsps/css/ace/ace-rtl.min.css" />
	<link rel="stylesheet" href="jsps/css/ace/ace-skins.min.css" />
    <script src="jsps/js/ace/ace-extra.min.js"></script>
    
    <style type="text/css">
        .submenu{ []
           cursor: pointer;
        }
    
    </style>
  </head>
  
  <body class="">
    <div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
								TenCloud物流系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="adminjsps/admin/images/LOGO/13.png" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎光临,</small>
										Jason
								</span>
								<i class="icon-caret-down"></i>
							</a>
							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										设置
									</a>
								</li>
								<li>
									<a href="#">
										<i class="icon-user"></i>
										个人资料
									</a>
								</li>

								<li class="divider"></li>
								<li>
									<a href="#">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

	<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>

							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>

							<button class="btn btn-danger">
								<i class="icon-cogs"></i>
							</button>
						</div>

						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<ul class="nav nav-list">
						<li class="active">
							<a data-href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 控制台 </span>
							</a>
						</li>
	
						<li>
							<a href="javascript:void(0)" class="dropdown-toggle">
								<i class="icon-desktop"></i>
								<span class="menu-text"> 系统管理 </span>
								<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<li>
									<a id="1" data-href="jsps/system/user/titax.jsp" title="用户管理">
										<i class="icon-double-angle-right"></i>
										用户管理
									</a>
								</li>
								<li>
									<a id="2" data-href="jsps/system/authorize/resmanager.jsp" title="资源管理">
										<i class="icon-double-angle-right"></i>
										资源管理
									</a>
								</li>
								<li>
									<a id="3" data-href="jsps/system/authorize/rolemanager.jsp" title="角色管理">
										<i class="icon-double-angle-right"></i>
										角色管理
									</a>
								</li>
								<li>
									<a id="4" data-href="jsps/system/authorize/authorize.jsp" title="权限分配">
										<i class="icon-double-angle-right"></i>
										权限分配
									</a>
								</li>
								<li>
									<a id="5" data-href="jsps/system/log/logList.jsp" title="操作日志">
										<i class="icon-double-angle-right"></i>
										操作日志
									</a>
								</li>
							</ul>

						</li>	


						<li>
							<a href="javascript:void(0)" class="dropdown-toggle">
								<i class=" icon-folder-open"></i>
								<span class="menu-text"> 基本设置 </span>
								<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<li>
									<a id="6" data-href="jsps/basis/basisFiles/basisFiles.jsp" title="基础档案设置">
										<i class="icon-double-angle-right"></i>
										基础档案设置
									</a>
								</li>
								<li>
									<a id="7" data-href="jsps/basis/pickstandard/deliverCriterion.jsp" title="收派标准">
										<i class="icon-double-angle-right"></i>
										收派标准
									</a>
								</li>
								<li>
									<a id="8" data-href="jsps/basis/bus/bus.jsp" title="班车设置">
										<i class="icon-double-angle-right"></i>
										班车设置
									</a>
								</li>
								<li>
									<a id="9" data-href="jsps/basis/emp/emp.jsp" title="取派设置">
										<i class="icon-double-angle-right"></i>
										取派设置
									</a>
								</li>
								<li>
									<a id="10" data-href="jsps/basis/emp/relay.jsp" title="替班管理">
										<i class="icon-double-angle-right"></i>
										替班管理
									</a>
								</li>
								<li>
									<a id="11" data-href="jsps/basis/region/region.jsp" title="区域设置">
										<i class="icon-double-angle-right"></i>
										区域设置
									</a>
								</li>
								<li>
									<a id="12" data-href="jsps/basis/partition/partition.jsp" title="管理分区">
										<i class="icon-double-angle-right"></i>
										管理分区
									</a>
								</li>
								<li>
									<a id="13" data-href="jsps/basis/fixedArea/fixedArea.jsp" title="管理定区/调度排班">
										<i class="icon-double-angle-right"></i>
										管理定区/调度排班
									</a>
								</li>
								<li>
									<a id="14" data-href="jsps/basis/picktime/picktime.jsp" title="取派时间管理">
										<i class="icon-double-angle-right"></i>
										取派时间管理
									</a>
								</li>
								<li>
									<a id="15" data-href="jsps/basis/client/client.jsp" title="客户管理">
										<i class="icon-double-angle-right"></i>
										客户管理
									</a>
								</li>
								<li>
									<a id="16" data-href="jsps/basis/org/orgmanager.jsp" title="组织管理">
										<i class="icon-double-angle-right"></i>
										组织管理
									</a>
								</li>
							</ul>
						</li>
	
	
	
						<li>
							<a href="javascript:void(0)" class="dropdown-toggle">
								<i class=" icon-twitter"></i>
								<span class="menu-text"> 取派管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="javascript:void(0)" class="dropdown-toggle">
										<i class="icon-list-alt"></i>
											<span class="menu-text"> 受理</span>
										<b class="arrow icon-angle-down"></b>
									</a>

									<ul class="submenu">
								<li>
									<a id="17" data-href="jsps/TakeToSend/acceptance/businessAcceptance/businessAcceptance.jsp" title="业务受理">
										<i class="icon-double-angle-right"></i>
										业务受理
									</a>
								</li>

								<li>
									<a id="18" data-href="jsps/emp/emp.jsp" title="工作单快速录入">
										<i class="icon-double-angle-right"></i>
										工作单快速录入
									</a>
								</li>
								
								<li>
									<a id="19" data-href="jsps/emp/relay.jsp" title="工作单录入">
										<i class="icon-double-angle-right"></i>
										工作单录入
									</a>
								</li>

								<li>
									<a id="20" data-href="motaik.jsp" title="工作单导入">
										<i class="icon-double-angle-right"></i>
										工作单导入
									</a>
								</li>

								<li>
									<a id="21" data-href="adminjsps/admin/category/cateoper.jsp?biz=level2" title="工作单查询">
										<i class="icon-double-angle-right"></i>
										工作单查询
									</a>
								</li>

									</ul>
								</li>

								
								<li>
									<a href="javascript:void(0)" class="dropdown-toggle">
										<i class="icon-edit"></i>
										<span class="menu-text"> 调度 </span>
		
										<b class="arrow icon-angle-down"></b>
									</a>
		
									<ul class="submenu">
										<li>
											<a id="22" data-href="adminjsps/admin/customer/findAllCustomer.jsp?biz=findAllCus" title="查台转单">
												<i class="icon-double-angle-right"></i>
												查台转单
											</a>
										</li>
		
										<li>
											<a id="23" data-href="adminjsps/admin/customer/findAllCustomer.jsp?biz=findActive" title="人工调度">
												<i class="icon-double-angle-right"></i>
												人工调度
											</a>
										</li>
										
										<li>
											<a id="24" data-href="adminjsps/admin/customer/findAllCustomer.jsp?biz=findActive" title="工作单打印">
												<i class="icon-double-angle-right"></i>
												工作单打印
											</a>
										</li>
										
										<li>
											<a id="25" data-href="adminjsps/admin/customer/findAllCustomer.jsp?biz=findActive" title="签收录入">
												<i class="icon-double-angle-right"></i>
												签收录入
											</a>
										</li>

										<li>
											<a id="26" data-href="adminjsps/admin/customer/findAllCustomer.jsp?biz=findActive" title="取消签收录入申请确认">
												<i class="icon-double-angle-right"></i>
												取消签收录入申请
											</a>
										</li>

										<li>
											<a id="27" data-href="adminjsps/admin/customer/findAllCustomer.jsp?biz=findActive" title="宣传任务">
												<i class="icon-double-angle-right"></i>
												宣传任务
											</a>
										</li>																														
									</ul>
								</li>	
								
								<li>
									<a href="javascript:void(0)" class="dropdown-toggle">
										<i class="icon-list"></i>
										<span class="menu-text"> 返货 </span>
		
										<b class="arrow icon-angle-down"></b>
									</a>
		
									<ul class="submenu">
										<li>
											<a id="28" data-href="adminjsps/admin/product/product.jsp" title="返货申请">
												<i class="icon-double-angle-right"></i>
												返货申请
											</a>
										</li>
		
										<li>
											<a id="29" data-href="adminjsps/admin/product/addProduct.jsp" title="返货申请确认">
												<i class="icon-double-angle-right"></i>
												返货申请确认
											</a>
										</li>
		
										<li>
											<a id="30" data-href="adminjsps/admin/product/updateProduct.jsp" title="生成返货单">
												<i class="icon-double-angle-right"></i>
												生成返货单
											</a>
										</li>
										
										<li>
											<a id="31" data-href="adminjsps/admin/product/updateProduct.jsp" title="异调工作单">
												<i class="icon-double-angle-right"></i>
												异调工作单
											</a>
										</li>
									</ul>
								</li>
	
	
								<li>
									<a href="javascript:void(0)" class="dropdown-toggle">
										<i class="icon-list"></i>
										<span class="menu-text"> 包装 </span>
		
										<b class="arrow icon-angle-down"></b>
									</a>
		
									<ul class="submenu">
										<li>
											<a id="32" data-href="adminjsps/admin/product/product.jsp" title="核重操作">
												<i class="icon-double-angle-right"></i>
												核重操作
											</a>
										</li>
		
										<li>
											<a id="33" data-href="adminjsps/admin/product/addProduct.jsp" title="核重监控">
												<i class="icon-double-angle-right"></i>
												核重监控
											</a>
										</li>
		
										<li>
											<a id="34" data-href="adminjsps/admin/product/updateProduct.jsp" title="条码打印">
												<i class="icon-double-angle-right"></i>
												条码打印
											</a>
										</li>
										
										<li>
											<a id="35" data-href="adminjsps/admin/product/updateProduct.jsp" title="包装信息录入">
												<i class="icon-double-angle-right"></i>
												包装信息录入
											</a>
										</li>
										<li>
											<a id="36" data-href="adminjsps/admin/product/updateProduct.jsp" title="包装信息查询">
												<i class="icon-double-angle-right"></i>
												包装信息查询
											</a>
										</li>
									</ul>
								</li>	
	
	
	
								<li>
									<a href="javascript:void(0)" class="dropdown-toggle">
										<i class="icon-list"></i>
										<span class="menu-text"> 签单 </span>
		
										<b class="arrow icon-angle-down"></b>
									</a>
		
									<ul class="submenu">
										<li>
											<a id="37" data-href="adminjsps/admin/product/product.jsp" title="签单信息录入">
												<i class="icon-double-angle-right"></i>
												签单信息录入
											</a>
										</li>
		
										<li>
											<a id="38" data-href="adminjsps/admin/product/addProduct.jsp" title="签单信息接收">
												<i class="icon-double-angle-right"></i>
												签单信息接收
											</a>
										</li>
		
										<li>
											<a id="39" data-href="adminjsps/admin/product/updateProduct.jsp" title="签单信息查询">
												<i class="icon-double-angle-right"></i>
												签单信息查询
											</a>
										</li>
										
										<li>
											<a id="40" data-href="adminjsps/admin/product/updateProduct.jsp" title="异调工作单">
												<i class="icon-double-angle-right"></i>
												原单登记核销
											</a>
										</li>
									</ul>
								</li>	
	
								<li>
									<a href="javascript:void(0)" class="dropdown-toggle">
										<i class="icon-list"></i>
										<span class="menu-text"> 大物流 </span>
		
										<b class="arrow icon-angle-down"></b>
									</a>
		
									<ul class="submenu">
										<li>
											<a id="41" data-href="adminjsps/admin/product/product.jsp" title="大物流发货对照">
												<i class="icon-double-angle-right"></i>
												大物流发货对照
											</a>
										</li>
									</ul>
								</li>		
	
								<li>
									<a href="javascript:void(0)" class="dropdown-toggle">
										<i class="icon-list"></i>
										<span class="menu-text"> 受理查询 </span>
		
										<b class="arrow icon-angle-down"></b>
									</a>
		
									<ul class="submenu">
										<li>
											<a id="42" data-href="adminjsps/admin/product/product.jsp" title="调度历史查询">
												<i class="icon-double-angle-right"></i>
												调度历史查询
											</a>
										</li>
		
										<li>
											<a id="43" data-href="adminjsps/admin/product/addProduct.jsp" title="PDA短信取货查询">
												<i class="icon-double-angle-right"></i>
												PDA短信取货查询
											</a>
										</li>
		
										<li>
											<a id="44" data-href="adminjsps/admin/product/updateProduct.jsp" title="网络工作单录入">
												<i class="icon-double-angle-right"></i>
												网络工作单录入
											</a>
										</li>
									</ul>
								</li>		
								
								<li>
									<a href="javascript:void(0)" class="dropdown-toggle">
										<i class="icon-list-alt"></i>
										<span class="menu-text"> 调度查询 </span>
										<b class="arrow icon-angle-down"></b>
									</a>
		
									<ul class="submenu">
										<li>
											<a id="45" data-href="adminjsps/admin/log/admins.jsp" title="取派调度令监控">
												<i class="icon-double-angle-right"></i>
												取派调度令监控
											</a>
										</li>
										<li>
											<a id="46" data-href="adminjsps/admin/log/admins.jsp" title="签收查询">
												<i class="icon-double-angle-right"></i>
												签收查询
											</a>
										</li>
										<li>
											<a id="47" data-href="adminjsps/admin/log/admins.jsp" title="取货监控查询">
												<i class="icon-double-angle-right"></i>
												取货监控查询
											</a>
										</li>								
									</ul>
								</li>
								
								
								<li>
									<a href="javascript:void(0)" class="dropdown-toggle">
										<i class="icon-list-alt"></i>
										<span class="menu-text"> 合作网络管理 </span>
										<b class="arrow icon-angle-down"></b>
									</a>
		
									<ul class="submenu">
										<li>
											<a id="48" data-href="adminjsps/admin/log/admins.jsp" title="责任网点设置">
												<i class="icon-double-angle-right"></i>
												责任网点设置
											</a>
										</li>
										<li>
											<a id="49" data-href="adminjsps/admin/log/admins.jsp" title="委派查询">
												<i class="icon-double-angle-right"></i>
												委派查询
											</a>
										</li>
										<li>
											<a id="50" data-href="adminjsps/admin/log/admins.jsp" title="受派查询">
												<i class="icon-double-angle-right"></i>
												受派查询
											</a>
										</li>
										<li>
											<a id="51" data-href="adminjsps/admin/log/admins.jsp" title="委派统计分析">
												<i class="icon-double-angle-right"></i>
												委派统计分析
											</a>
										</li>								
									</ul>
								</li>																							
							</ul>
						</li>
					
	
						<li>
							<a href="javascript:void(0)" class="dropdown-toggle">
								<i class="icon-signout"></i>
								<span class="menu-text"> 中转管理 </span>
								<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<li>
									<a id="52" data-href="adminjsps/admin/order/Order.jsp?biz=findAll" title="等待开发">
										<i class="icon-double-angle-right"></i>
										等待开发
									</a>
								</li>
							</ul>
						</li>	

						<li>
							<a href="javascript:void(0)" class="dropdown-toggle">
								<i class=" icon-phone-sign"></i>
								<span class="menu-text"> 路由管理 </span>
								<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<li>
									<a id="53" data-href="adminjsps/admin/order/Order.jsp?biz=findAll" title="等待开发">
										<i class="icon-double-angle-right"></i>
										等待开发
									</a>
								</li>
							</ul>
						</li>	


						<li>
							<a href="javascript:void(0)" class="dropdown-toggle">
								<i class="icon-credit-card"></i>
								<span class="menu-text"> 财务管理 </span>
								<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<li>
									<a id="54" data-href="adminjsps/admin/order/Order.jsp?biz=findAll" title="等待开发">
										<i class="icon-double-angle-right"></i>
										等待开发
									</a>
								</li>
							</ul>
						</li>						

						<li>
							<a href="javascript:void(0)" class="dropdown-toggle">
								<i class="icon-book"></i>
								<span class="menu-text"> 经营管理报表 </span>
								<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<li>
									<a id="55" data-href="adminjsps/admin/order/Order.jsp?biz=findAll" title="等待开发">
										<i class="icon-double-angle-right"></i>
										等待开发
									</a>
								</li>
							</ul>
						</li>							

						<li>
							<a href="javascript:void(0)" class="dropdown-toggle">
								<i class="icon-bar-chart"></i>
								<span class="menu-text"> 财务管理报表 </span>
								<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<li>
									<a id="56" data-href="adminjsps/admin/order/Order.jsp?biz=findAll" title="等待开发">
										<i class="icon-double-angle-right"></i>
										等待开发
									</a>
								</li>
							</ul>
						</li>	


						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-file-alt"></i>

								<span class="menu-text">
									其他页面
									<span class="badge badge-primary ">5</span>
								</span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="faq.html">
										<i class="icon-double-angle-right"></i>
										帮助
									</a>
								</li>

								<li>
									<a href="error-404.html">
										<i class="icon-double-angle-right"></i>
										404错误页面
									</a>
								</li>

								<li>
									<a href="error-500.html">
										<i class="icon-double-angle-right"></i>
										500错误页面
									</a>
								</li>

								<li>
									<a href="grid.html">
										<i class="icon-double-angle-right"></i>
										网格
									</a>
								</li>

								<li>
									<a href="blank.html">
										<i class="icon-double-angle-right"></i>
										空白页面
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>


                <div class="main-content">
				     <div class="page-content"> 
					     <div class="row"> 
						     <div class="col-xs-12" style="padding-left:5px;"> 
							    <ul class="nav nav-tabs" role="tablist"> 
								    <li class="active">
									    <a href="#tab_0" role="tab" data-toggle="tab">首页</a>
									</li> 
								</ul> 
								<div class="tab-content"> 
								   <div role="tabpanel" class="tab-pane active" id="tab_0">
								        							
                                       <!-- PAGE CONTENT BEGINS -->

								<div class="alert alert-block alert-success">
									<button type="button" class="close" data-dismiss="alert">
										<i class="icon-remove"></i>
									</button>

									<i class="icon-ok green"></i>

									欢迎使用
									<strong class="green">
										TenCloud后台管理系统        
										<small>(v1.0)</small>
										
									   当前在线人数：<%= SessionCounter.getACTIVE_SESSIONS() %> 	
									</strong>	
								</div>


<!-- Chart.js -->
<script type="text/javascript" src="jsps/js/Chart.js-master/src/chart.js"></script>

								<div class="row">
									<div class="space-6"></div>

									<div class="col-sm-7 infobox-container">
										<script type="text/javascript">
											$(function(){
												
											});
										</script>
									</div>

									<div class="vspace-sm"></div>

									<div class="col-sm-5">
										<div class="widget-box">
											<div class="widget-header widget-header-flat widget-header-small">
												<h5>
													<i class="icon-signal"></i>
													访问来源
												</h5>

												<div class="widget-toolbar no-border">
													<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
														本周
														<i class="icon-angle-down icon-on-right bigger-110"></i>
													</button>

													<ul class="dropdown-menu pull-right dropdown-125 dropdown-lighter dropdown-caret">
														<li class="active">
															<a href="#" class="blue">
																<i class="icon-caret-right bigger-110">&nbsp;</i>
																本周
															</a>
														</li>

														<li>
															<a href="#">
																<i class="icon-caret-right bigger-110 invisible">&nbsp;</i>
																上周
															</a>
														</li>

														<li>
															<a href="#">
																<i class="icon-caret-right bigger-110 invisible">&nbsp;</i>
																本月
															</a>
														</li>

														<li>
															<a href="#">
																<i class="icon-caret-right bigger-110 invisible">&nbsp;</i>
																上月
															</a>
														</li>
													</ul>
												</div>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													<div id="piechart-placeholder"></div>

													<div class="hr hr8 hr-double"></div>

													<div class="clearfix">
														<div class="grid3">
															<span class="grey">
																<i class="icon-facebook-sign icon-2x blue"></i>
																&nbsp; likes
															</span>
															<h4 class="bigger pull-right">1,255</h4>
														</div>

														<div class="grid3">
															<span class="grey">
																<i class="icon-twitter-sign icon-2x purple"></i>
																&nbsp; tweets
															</span>
															<h4 class="bigger pull-right">941</h4>
														</div>

														<div class="grid3">
															<span class="grey">
																<i class="icon-pinterest-sign icon-2x red"></i>
																&nbsp; pins
															</span>
															<h4 class="bigger pull-right">1,050</h4>
														</div>
													</div>
												</div><!-- /widget-main -->
											</div><!-- /widget-body -->
										</div><!-- /widget-box -->
									</div><!-- /span -->
								</div><!-- /row -->

								<div class="hr hr32 hr-dotted"></div>

								<div class="row">
									<div class="col-sm-5">
										<div class="widget-box transparent">
											<div class="widget-header widget-header-flat">
												<h4 class="lighter">
													<i class="icon-star orange"></i>
													热门域名
												</h4>

												<div class="widget-toolbar">
													<a href="#" data-action="collapse">
														<i class="icon-chevron-up"></i>
													</a>
												</div>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<table class="table table-bordered table-striped">
														<thead class="thin-border-bottom">
															<tr>
																<th>
																	<i class="icon-caret-right blue"></i>
																	名称
																</th>

																<th>
																	<i class="icon-caret-right blue"></i>
																	价格
																</th>

																<th class="hidden-480">
																	<i class="icon-caret-right blue"></i>
																	状态
																</th>
															</tr>
														</thead>

														<tbody>
															<tr>
																<td>internet.com</td>

																<td>
																	<small>
																		<s class="red">$29.99</s>
																	</small>
																	<b class="green">$19.99</b>
																</td>

																<td class="hidden-480">
																	<span class="label label-info arrowed-right arrowed-in">销售中</span>
																</td>
															</tr>

															<tr>
																<td>online.com</td>

																<td>
																	<small>
																		<s class="red"></s>
																	</small>
																	<b class="green">$16.45</b>
																</td>

																<td class="hidden-480">
																	<span class="label label-success arrowed-in arrowed-in-right">可用</span>
																</td>
															</tr>

															<tr>
																<td>newnet.com</td>

																<td>
																	<small>
																		<s class="red"></s>
																	</small>
																	<b class="green">$15.00</b>
																</td>

																<td class="hidden-480">
																	<span class="label label-danger arrowed">待定</span>
																</td>
															</tr>

															<tr>
																<td>web.com</td>

																<td>
																	<small>
																		<s class="red">$24.99</s>
																	</small>
																	<b class="green">$19.95</b>
																</td>

																<td class="hidden-480">
																	<span class="label arrowed">
																		<s>无货</s>
																	</span>
																</td>
															</tr>

															<tr>
																<td>domain.com</td>

																<td>
																	<small>
																		<s class="red"></s>
																	</small>
																	<b class="green">$12.00</b>
																</td>

																<td class="hidden-480">
																	<span class="label label-warning arrowed arrowed-right">售完</span>
																</td>
															</tr>
														</tbody>
													</table>
												</div><!-- /widget-main -->
											</div><!-- /widget-body -->
										</div><!-- /widget-box -->
									</div>

									<div class="col-sm-7">
										<div class="widget-box transparent">
											<div class="widget-header widget-header-flat">
												<h4 class="lighter">
													<i class="icon-signal"></i>
													销售统计
												</h4>

												<div class="widget-toolbar">
													<a href="#" data-action="collapse">
														<i class="icon-chevron-up"></i>
													</a>
												</div>
											</div>

											<div class="widget-body">
												<div class="widget-main padding-4">
													<div id="sales-charts"></div>
												</div><!-- /widget-main -->
											</div><!-- /widget-body -->
										</div><!-- /widget-box -->
									</div>
								</div>

								<div class="hr hr32 hr-dotted"></div>

								

								   </div> 
								</div> 
							</div> 
						 </div> 
					</div> 
				</div>                
				<!-- /.main-content -->


				<div class="ace-settings-container" id="ace-settings-container">
					<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
						<i class="icon-cog bigger-150"></i>
					</div>

					<div class="ace-settings-box" id="ace-settings-box">
						<div>
							<div class="pull-left">
								<select id="skin-colorpicker" class="hide">
									<option data-skin="default" value="#438EB9">#438EB9</option>
									<option data-skin="skin-1" value="#222A2D">#222A2D</option>
									<option data-skin="skin-2" value="#C6487E">#C6487E</option>
									<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
								</select>
							</div>
							<span>&nbsp; 选择皮肤</span>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
							<label class="lbl" for="ace-settings-navbar"> 固定导航条</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
							<label class="lbl" for="ace-settings-sidebar"> 固定滑动条</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
							<label class="lbl" for="ace-settings-breadcrumbs">固定面包屑</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
							<label class="lbl" for="ace-settings-rtl">切换到左边</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
							<label class="lbl" for="ace-settings-add-container">
								切换窄屏
								<b></b>
							</label>
						</div>
					</div>
				</div><!-- /#ace-settings-container -->
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

	
		<script type="text/javascript">
			window.jQuery || document.write("<script src='static/jquery-3.2.1.min.js'>"+"<"+"script>");
		</script>
        <script type="text/javascript" src="jsps/js/ace/bootstrap-tabs.js"></script>
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='jsps/js/ace/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
		<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<script src="jsps/js/ace/typeahead-bs2.min.js"></script>

		<script src="jsps/js/ace/bootstrap.min.js"></script>
		<script src="jsps/js/ace/jquery.slimscroll.min.js"></script>
		<script src="jsps/js/ace/jquery.easy-pie-chart.min.js"></script>
		<script src="jsps/js/ace/jquery.sparkline.min.js"></script>
		<script src="jsps/js/ace/jquery.flot.min.js"></script>
		<script src="jsps/js/ace/jquery.flot.pie.min.js"></script>
		<script src="jsps/js/ace/ace/jquery.flot.resize.min.js"></script>

		<!-- ace scripts -->

		<script src="jsps/js/ace/ace-elements.min.js"></script>
		<script src="jsps/js/ace/ace.min.js"></script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			jQuery(function($) {
				$('.easy-pie-chart.percentage').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
					var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
					var size = parseInt($(this).data('size')) || 50;
					$(this).easyPieChart({
						barColor: barColor,
						trackColor: trackColor,
						scaleColor: false,
						lineCap: 'butt',
						lineWidth: parseInt(size/10),
						animate: /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
						size: size
					});
				})
			
				$('.sparkline').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
					$(this).sparkline('html', {tagValuesAttribute:'data-values', type: 'bar', barColor: barColor , chartRangeMin:$(this).data('min') || 0} );
				});
				
				//给左侧导航添加监听
			    $(".submenu a").click(function(event){
			    	event.preventDefault();
			    	var href = $(this).attr("data-href");
					var title = $(this).attr("title");
					var id = $(this).attr("id");
					addTabs({url:href,title:title,id:id,close:true});
			    });
			
			
			
			  var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
			  var data = [
				{ label: "social networks",  data: 38.7, color: "#68BC31"},
				{ label: "search engines",  data: 24.5, color: "#2091CF"},
				{ label: "ad campaigns",  data: 8.2, color: "#AF4E96"},
				{ label: "direct traffic",  data: 18.6, color: "#DA5430"},
				{ label: "other",  data: 10, color: "#FEE074"}
			  ]
			  function drawPieChart(placeholder, data, position) {
			 	  $.plot(placeholder, data, {
					series: {
						pie: {
							show: true,
							tilt:0.8,
							highlight: {
								opacity: 0.25
							},
							stroke: {
								color: '#fff',
								width: 2
							},
							startAngle: 2
						}
					},
					legend: {
						show: true,
						position: position || "ne", 
						labelBoxBorderColor: null,
						margin:[-30,15]
					}
					,
					grid: {
						hoverable: true,
						clickable: true
					}
				 })
			 }
			 drawPieChart(placeholder, data);
			
			 /**
			 we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
			 so that's not needed actually.
			 */
			 placeholder.data('chart', data);
			 placeholder.data('draw', drawPieChart);
			
			
			
			  var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
			  var previousPoint = null;
			
			  placeholder.on('plothover', function (event, pos, item) {
				if(item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : " + item.series['percent']+'%';
						$tooltip.show().children(0).text(tip);
					}
					$tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
				} else {
					$tooltip.hide();
					previousPoint = null;
				}
				
			 });
			
			
			
			
			
			
				var d1 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d1.push([i, Math.sin(i)]);
				}
			
				var d2 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d2.push([i, Math.cos(i)]);
				}
			
				var d3 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.2) {
					d3.push([i, Math.tan(i)]);
				}
				
			
				var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'220px'});
				$.plot("#sales-charts", [
					{ label: "Domains", data: d1 },
					{ label: "Hosting", data: d2 },
					{ label: "Services", data: d3 }
				], {
					hoverable: true,
					shadowSize: 0,
					series: {
						lines: { show: true },
						points: { show: true }
					},
					xaxis: {
						tickLength: 0
					},
					yaxis: {
						ticks: 10,
						min: -2,
						max: 2,
						tickDecimals: 3
					},
					grid: {
						backgroundColor: { colors: [ "#fff", "#fff" ] },
						borderWidth: 1,
						borderColor:'#555'
					}
				});
			
			
				$('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('.tab-content')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			
			
				$('.dialogs,.comments').slimScroll({
					height: '300px'
			    });
				
				
				//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
				//so disable dragging when clicking on label
				var agent = navigator.userAgent.toLowerCase();
				if("ontouchstart" in document && /applewebkit/.test(agent) && /android/.test(agent))
				  $('#tasks').on('touchstart', function(e){
					var li = $(e.target).closest('#tasks li');
					if(li.length == 0)return;
					var label = li.find('label.inline').get(0);
					if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
				});
			
				$('#tasks').sortable({
					opacity:0.8,
					revert:true,
					forceHelperSize:true,
					placeholder: 'draggable-placeholder',
					forcePlaceholderSize:true,
					tolerance:'pointer',
					stop: function( event, ui ) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
						$(ui.item).css('z-index', 'auto');
					}
					}
				);
				$('#tasks').disableSelection();
				$('#tasks input:checkbox').removeAttr('checked').on('click', function(){
					if(this.checked) $(this).closest('li').addClass('selected');
					else $(this).closest('li').removeClass('selected');
				});
				
			
			})
		</script>
		<script type="text/javascript">
			function reinitIframe(){
			 $('iframe').each(function(){
						try{
							console.log($(this).height());
							//var bHeight = iframes[i][0].contentWindow.document.body.scrollHeight;
							//var dHeight = iframes[i][0].contentWindow.document.documentElement.scrollHeight;
							var height = Math.max(1100, $(this).height());
							$(this).height(height);
							//iframes[i][0].height = height;
							}catch (ex){}
					});

				}
			window.setInterval(reinitIframe, 200);
		</script>
  </body>
</html>
