<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.yidu.tencloud.util.SessionCounter" %>  
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
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
	<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-contextmenu.js"></script>
	<link rel="stylesheet" href="jsps/css/ace/ace.min.css" />
	<link rel="stylesheet" href="jsps/css/ace/ace-rtl.min.css" />
	<link rel="stylesheet" href="jsps/css/ace/ace-skins.min.css" />
    <script src="jsps/js/ace/ace-extra.min.js"></script>
    <script type="text/javascript" 
    src="static/chart/Chart.bundle.min.js"></script>
    
    <style type="text/css">
        .submenu{ 
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
								<img class="nav-user-photo" src="jsps/images/Logo.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎光临,</small>
										<shiro:principal/>
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
									<a href="logout">
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

					<ul class="nav nav-list" id="shiroTreeMenu">
    					<li class="active">
							<a data-href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 控制台 </span>
							</a>
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
					     <div class="row" style="padding-left:-5px;margin-right: -20px;"> 
						     <div class="col-xs-12" style="padding-left:0px;"> 
							    <ul class="nav nav-tabs" id="tab-list" role="tablist" style="position:relative;top:-1px"> 
								    <li class="active">
									    <a href="#tab_0" role="tab" data-toggle="tab">首页</a>
									</li> 
								</ul> 
								<div class="tab-content" style="padding:0;border:none"> 
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
										
									   
									</strong>	
								</div>




								<div class="row">
									<div class="space-6"></div>

									<div class="col-sm-7 infobox-container">
										<div class="infobox infobox-green  ">
											<div class="infobox-icon">
												<i class="icon-comments"></i>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number" id="packageNumber"></span>
												<div class="infobox-content">合包数</div>
											</div>
										</div>

										<div class="infobox infobox-blue  ">
											<div class="infobox-icon">
												<i class="icon-twitter"></i>
											</div>

											<div class="infobox-data">
												<span id="propagandaTask" class="infobox-data-number">0</span>
												<div class="infobox-content">宣传任务</div>
											</div>

											<div class="badge badge-success">
												+32%
												<i class="icon-arrow-up"></i>
											</div>
										</div>

										<div class="infobox infobox-pink  ">
											<div class="infobox-icon">
												<i class="icon-shopping-cart"></i>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number" id="orderNum"></span>
												<div class="infobox-content">受理单</div>
											</div>
											<div class="stat stat-important">4%</div>
										</div>

										<div class="infobox infobox-red  ">
											<div class="infobox-icon">
												<i class="icon-beaker"></i>
											</div>

											<div class="infobox-data">
												<span id="needDispatcherNum" class="infobox-data-number"></span>
												<div class="infobox-content">需要调度</div>
											</div>
										</div>
										
										<div class="infobox infobox-pink">
											<div class="infobox-icon">
												<i class="icon-signin" ></i>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number" id="countAStatus"></span>
												<div class="infobox-content">已返货</div>
											</div>
										</div>

										<div class="infobox infobox-blue2  ">
											<div class="infobox-progress">
												<div class="easy-pie-chart percentage" data-percent="42" data-size="46">
													<span class="percent">42</span>%
												</div>
											</div>

											<div class="infobox-data">
												<span class="infobox-text">交易使用</span>

												<div class="infobox-content">
													<span class="bigger-110">~</span>
													剩余58GB
												</div>
											</div>
										</div>

										<div class="space-6"></div>

										<div class="infobox infobox-green infobox-small infobox-dark">
											<div class="infobox-progress">
												<div class="easy-pie-chart percentage" data-percent="61" data-size="39">
													<span class="percent">61</span>%
												</div>
											</div>

											<div class="infobox-data">
												<div class="infobox-content">任务</div>
												<div class="infobox-content">完成</div>
											</div>
										</div>

										<div class="infobox infobox-blue infobox-small infobox-dark">
											<div class="infobox-chart">
												<span class="sparkline" data-values="3,4,2,3,4,4,2,2"></span>
											</div>

											<div class="infobox-data">
												<div class="infobox-content">获得</div>
												<div class="infobox-content">$32,000</div>
											</div>
										</div>

										<div class="infobox infobox-grey infobox-small infobox-dark">
											<div class="infobox-icon">
												<i class="icon-download-alt"></i>
											</div>

											<div class="infobox-data">
												<div class="infobox-content">在线人数</div>
												<div class="infobox-content">											
													<%= SessionCounter.getACTIVE_SESSIONS() %> 	
												</div>
											</div>
										</div>
									</div>
									<div class="row">
									<div class="col-sm-5">
										<div class="widget-box transparent">
											<div class="widget-header widget-header-flat">
												<h4 class="lighter">
													<i class="icon-star orange"></i>
													通知单状态
												</h4>
				
												<div class="widget-toolbar">
													<a href="#" data-action="collapse">
														<i class="icon-chevron-up"></i>
													</a>
												</div>
											</div>
				
											<div class="widget-body">
											  <canvas id="pieChart" width="50px" height="100px"></canvas>
											  <script type="text/javascript"> 
												$.ajax({
													url : "dispatcher/creatBusin",
													type : "post",
													traditional : true,
													success : function(response) {
														createLinegraph1(['下单成功','待调度','已调度'],[response[2],response[1],response[0]]);
													}
												});
												function createLinegraph1(names,data){
													var ctx = document.getElementById("pieChart").getContext('2d');
													document.getElementById("pieChart").width = 400;
													document.getElementById("pieChart").height = 200;

													var myChart = new Chart(ctx, {
														type: 'pie',
														data: {
														labels: names,
														datasets: [{
															label: '受理单饼图',
															data: data,
															backgroundColor: [
																'rgba(255, 99, 132, 0.2)',
																'rgba(54, 162, 235, 0.2)',
																'rgba(255, 206, 86, 0.2)',
																'rgba(75, 192, 192, 0.2)',
																'rgba(153, 102, 255, 0.2)',
																'rgba(255, 159, 64, 0.2)'
															],
															borderColor: [
																'rgba(255,99,132,1)',
																'rgba(54, 162, 235, 1)',
																'rgba(255, 206, 86, 1)',
																'rgba(75, 192, 192, 1)',
																'rgba(153, 102, 255, 1)',
																'rgba(255, 159, 64, 1)'
															],
															borderWidth: 1
																}]
															}
														});
													}
												</script> 
											</div><!-- /widget-body -->
										</div><!-- /widget-box -->
									</div>
								</div>                
									<div class="vspace-sm"></div>

								</div><!-- /row -->
								
								<div class="hr hr32 hr-dotted"></div>

								<div class="row">
									<div class="col-sm-5">
										<div class="widget-box transparent">
											<div class="widget-header widget-header-flat">
												<h4 class="lighter">
													<i class="icon-star orange"></i>
													工作单数量
												</h4>

												<div class="widget-toolbar">
													<a href="#" data-action="collapse">
														<i class="icon-chevron-up"></i>
													</a>
												</div>
											</div>

											<div class="widget-body">
											  <canvas id="Line" style="width:50px;height:100px;"></canvas>
											  <script type="text/javascript">
												  $.ajax({
														url : "workSheet/bargraph",
														type : "post",
														traditional : true,
														success : function(response) {
															createLine(['<%= new SimpleDateFormat("MM-dd").format(new Date(new Date().getTime() - 86400000*6)) %>','<%= new SimpleDateFormat("MM-dd").format(new Date(new Date().getTime() - 86400000*5)) %>','<%= new SimpleDateFormat("MM-dd").format(new Date(new Date().getTime() - 86400000*4)) %>','<%= new SimpleDateFormat("MM-dd").format(new Date(new Date().getTime() - 86400000*3)) %>','<%= new SimpleDateFormat("MM-dd").format(new Date(new Date().getTime() - 86400000*2)) %>','<%= new SimpleDateFormat("MM-dd").format(new Date(new Date().getTime() - 86400000)) %>','<%= new SimpleDateFormat("MM-dd").format(Calendar.getInstance().getTime()) %>'],[response[6],response[5],response[4],response[3],response[2],response[1],response[0]]);
												        }
												   });
												  
												  function createLine(names,data){
													   var ctx = document.getElementById("Line").getContext('2d');
														document.getElementById("Line").width = 800;
														document.getElementById("Line").height = 400;
													    var myChart = new Chart(ctx, {
													        type: 'line',
													        data: {
													            labels: names,
													            datasets: [{
													                label: '工作单数量',
													                data: data,
													                backgroundColor: [
													                    'rgba(255, 99, 132, 0.2)',
													                    'rgba(54, 162, 235, 0.2)',
													                    'rgba(255, 206, 86, 0.2)',
													                    'rgba(75, 192, 192, 0.2)',
													                    'rgba(153, 102, 255, 0.2)',
													                    'rgba(255, 159, 64, 0.2)'
													                ],
													                borderColor: [
													                    'rgba(255,99,132,1)',
													                    'rgba(54, 162, 235, 1)',
													                    'rgba(255, 206, 86, 1)',
													                    'rgba(75, 192, 192, 1)',
													                    'rgba(153, 102, 255, 1)',
													                    'rgba(255, 159, 64, 1)'
													                ],
													                borderWidth: 1
													            }]
													        },
													        options: {
													            scales: {
													                yAxes: [{
													                    ticks: {
													                        beginAtZero:true
													                    }
													                }]
													            }
													        }
													    });
												   }
											  </script>
											</div><!-- /widget-body -->
										</div><!-- /widget-box -->
									</div>
									

								 <div class="row">
									<div class="col-sm-5">
										<div class="widget-box transparent">
											<div class="widget-header widget-header-flat">
												<h4 class="lighter">
													<i class="icon-star orange"></i>
													返货状态表
												</h4>
				
												<div class="widget-toolbar">
													<a href="#" data-action="collapse">
														<i class="icon-chevron-up"></i>
													</a>
												</div>
											</div>
				
											<div class="widget-body">
											  <canvas id="barChart" width="50px" height="100px"></canvas>
											  <script type="text/javascript"> 
														$.ajax({
																url : "generrateI/creatPie",
																type : "post",
																traditional : true,
																success : function(response) {
																	createLinegraph(['全部','已转发','已返货','未执行'],[response[3],response[2],response[1],response[0]]);
														        }
														   });
														function createLinegraph(names,data){
																			   var ctx = document.getElementById("barChart").getContext('2d');
																				document.getElementById("barChart").width = 300;
																				document.getElementById("barChart").height = 200;
																			    var myChart = new Chart(ctx, {
																			        type: 'polarArea',
																			        data: {
																			            labels: names,
																			            datasets: [{
																			                label: '返货状态饼图',
																			                data: data,
																			                backgroundColor: [
																			                    'rgba(255, 99, 132, 0.2)',
																			                    'rgba(54, 162, 235, 0.2)',
																			                    'rgba(255, 206, 86, 0.2)',
																			                    'rgba(75, 192, 192, 0.2)',
																			                    'rgba(153, 102, 255, 0.2)',
																			                    'rgba(255, 159, 64, 0.2)'
																			                ],
																			                borderColor: [
																			                    'rgba(255,99,132,1)',
																			                    'rgba(54, 162, 235, 1)',
																			                    'rgba(255, 206, 86, 1)',
																			                    'rgba(75, 192, 192, 1)',
																			                    'rgba(153, 102, 255, 1)',
																			                    'rgba(255, 159, 64, 1)'
																			                ],
																			                borderWidth: 1
																			            }]
																			        },
																			        options: {
																			            scales: {
																			                yAxes: [{
																			                    ticks: {
																			                        beginAtZero:true
																			                    }
																			                }]
																			            }
																			        }
																			    });
																		   }
												</script> 
											</div><!-- /widget-body -->
										</div><!-- /widget-box -->
									</div>
								</div>                
								<!-- /.main-content -->
								<div class="hr hr32 hr-dotted"></div>
								   </div> 
								</div> 
							</div> 
						 </div>
						
					</div> 
					

				
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
			</div>
	</div>
		
		<div id="context-menu">
		  <ul class="dropdown-menu" role="menu">
		    <li><a tabindex="-1" href="#">关闭左边页面</a></li>
		    <li><a tabindex="-1" href="#">关闭右边页面</a></li>
		    <li><a tabindex="-1" href="#">关闭其他页面</a></li>
		    <li class="divider"></li>
		    <li><a tabindex="-1" href="#">关闭所有页面</a></li>
		  </ul>
		</div>
		
		
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
				buildTree();
				//给左侧导航添加监听
			    /* $("").click(function(event){
			    	event.preventDefault();
			    	var href = $(this).attr("data-href");
					var title = $(this).attr("title");
					var id = $(this).attr("id");
					addTabs({url:href,title:title,id:id,close:true});
			    }); */
			    
			    $("#shiroTreeMenu").bind("click", function(e){
			    	e.preventDefault();
			    	console.log(e);
			    	if(e.target.className=="menu"){
				    	var attrs = e.target.attributes;
				    	var href = attrs['data-href'].value;
						var title = attrs.title.value;
						var id = attrs.id.value;
						addTabs({url:href,title:title,id:id,close:true});
			    	}
			    });
			
			
			
			  var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
			  var data = [
				{ label: "受理单",  data: 50, color: "#68BC31"},
				{ label: "待受理单",  data: 70, color: "#2091CF"},
				/* { label: "已接单",  data: 10.2, color: "#AF4E96"},
				{ label: "待接单",  data: 16.6, color: "#DA5430"},
				{ label: "完成",  data: 10, color: "#FEE074"} */
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
					},
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
		    var menuIconArray = {"基础档案":"icon-folder-open","系统管理":"icon-desktop","取派管理":"icon-twitter",
		    		"中转管理":"icon-signout","路由管理":"icon-phone-sign","财务管理":"icon-credit-card",
		    		"经营管理报表":"icon-book","财务管理报表":"icon-bar-chart","其他页面":"icon-file-alt"};
		    var template = {
		        icon: '<i class="icon-double-angle-right"/>',
		        listicon: '<i class="icon-list-alt"/>',
		        menuicon: '<b class="arrow icon-angle-down"/>',
		        item: '<a/>',
		        ul: '<ul style="submenu"/>',
		        menutxt: '<span class="menu-text"/>'
		    };
		
		    var count = 1;
		
		    function createA(node) {
		        var $a = $(template.item);
		        if (node.resList != null && node.resList.length != 0) {
		            var $icon = $(template.listicon);
		            if(menuIconArray[node.resourceName]){
		            	$icon.attr('class',menuIconArray[node.resourceName])
		            }
		            var $menutxt = $(template.menutxt).append(node.resourceName);
		            var $downicon = $(template.menuicon);
		            $a.append($icon).append($menutxt).append($downicon).attr("class", "dropdown-toggle").attr("href", "javascript:void(0)");
		        } else {
		            var $icon = $(template.icon);
		            $a.addClass("menu").append($icon).append(node.resourceName).attr("data-href", node.resourceUrl).attr("id", count++).attr("title", node.resourceName);
		        }
		        return $a;
		    }
		
		    function createLi(node) {
		        var $li = $("<li/>");
		        $li.append(createA(node));
		        var $ul = $('<ul class="submenu"/>');
		        if (node.resList != null && node.resList.length != 0) {
		            $.each(node.resList,
		            function(i, node) {
		                $ul.append(createLi(node));
		                $li.append($ul);
		            });
		
		        }
		
		        return $li;
		    }
		
		    var list = $("#shiroTreeMenu");
		    function buildTree() {
		        $.post('user/findres', {
		            date: new Date()
		        },
		        function(nodes) {
		            $.each(nodes,
		            function(i, node) {
		                list.append(createLi(node));
		            });
		        });
		    }
		</script>
		
		<script type="text/javascript">
			function reinitIframe(){
			 $('iframe').each(function(){
						try{
							var bHeight = $(this.contentWindow.document.body).height();//this.contentWindow.document.body.outerHeight;
							//var height = Math.max(bHeight,dHeight);
							//$(this).height(height);
							//this.height=Math.max(600,bHeight);
							var height = Math.max(600,bHeight);
							if(height<1200&&!(this.title=='区域设置'||this.title=='管理分区')){
								this.height=height+"px";
							}
							}catch (ex){}
					});

				}
			window.setInterval(reinitIframe, 300);
		</script>
		<script type="text/javascript">
		$(function(){
			
			$.ajax({
				url:'packages/countPackageNumber',
				type : "post",
				traditional : true,//这里设置为true
				success : function(response) {
					$('#packageNumber').append(response);
				}
			});
			
			$.ajax({
				url:'recsipt/countOrderNum.action',
				type : "post",
				traditional : true,//这里设置为true
				success : function(response) {
					$('#orderNum').append(response);
				}
			});
			
			$.ajax({
				url:'generrateI/countApplygoodsByStatus',
				type : "post",
				traditional : true,//这里设置为true
				success : function(response) {
					$('#countAStatus').append(response);
				}
			});
			
			$.ajax({
				url : "dispatcher/countNeedDispatcher",
				type : "post",
				traditional : true,//这里设置为true
				success : function(result) {
					$("#needDispatcherNum").append(result);
				}
			});	
			
			$.ajax({
				url : "propaganda/findWeekPropaganda",
				type : "post",
				traditional : true,//这里设置为true
				success : function(result) {
					$("#propagandaTask").text(result);
				}
			});
			
			
		 });
		</script>
		
		<script type="text/javascript" src="jsps/js/index.js"></script>
  </body>
</html>
