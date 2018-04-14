<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>铁路线路资源管理</title>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/edit/bootstrap-editable.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">

<script src="${pageContext.request.contextPath}/static/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/edit/bootstrap-editable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>

	<script type="text/javascript" src="${ pageContext.request.contextPath }/static/chart/echarts.min.js"></script>
	<script type="text/javascript" src="${ pageContext.request.contextPath }/static/chart/china.js"></script>
	<script type="text/javascript" src="${ pageContext.request.contextPath }/static/chart/echarts-all.js"></script>
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
		
		.control-label{
			width:120px;
		}
		
		.form-group{
			height:52px;
		}
		
		.alert{
			display: none;
		}
		
		.modelBtn{
			text-align: center;
		}
		
		.emptyMsg{
			display: none;
			color: red;
			text-align: center;
		}
		
		a:hover,a:visited,a:active,a:link{
			text-decoration: none;
		}
	</style>
</head>

<body>
		
		<div id="main" style="height:630px;width:900px;margin:auto;"></div>
		<script type="text/javascript">
			// 基于准备好的dom,初始化ecahrts实例
			var myChart = echarts.init(document.getElementById('main'));
			function itemStyle(idx) {
			    return {
			        normal: {
			            color:'#000',
			            borderWidth:1,
			            borderColor:['rgba(30,144,255,1)','lime'][idx],
			            lineStyle: {
			                type: 'solid'
			            }
			        }
			    }
			};
			
        	$(function(){
        		option = {
        			    backgroundColor: '#fff',
        			    color: ['rgba(30,144,255,1)','lime'],
        			    title : {
        			        text: 'TENBOS全国铁路支线干线一览图',
        			        x:'center',
        			        textStyle : {
        			            color: '#000'
        			        }
        			    },
        			    tooltip : {
        			        trigger: 'item',
        			        formatter: '{b}'
        			    },
        			    legend: {
        			        orient: 'vertical',
        			        x:'left',
        			        selectedMode:'single',
        			        data:['中国铁路'],
        			        textStyle : {
        			            color: '#000'
        			        }
        			    },
        			    toolbox: {
        			        show : true,
        			        orient : 'vertical',
        			        x: 'right',
        			        y: 'center',
        			        feature : {
        			            mark : {show: true},
        			            dataView : {show: true, readOnly: false},
        			            restore : {show: true},
        			            saveAsImage : {show: true}
        			        }
        			    },
        			    series : [
        			        {
        			            name: '中国铁路',
        			            type: 'map',
        			            roam: true,
        			            hoverable: false,
        			            mapType: 'china',
        			            itemStyle:{
        			                normal:{
        			                    borderColor:'#4F4F4F',
        			                    borderWidth:0.5,
        			                    areaStyle:{
        			                        color: 'rgba(242,242,242,1)'
        			                    }
        			                }
        			            },
        			            data:[],
        			            markLine : {
        			                symbol: ['circle', 'circle'],  
        			                symbolSize : 1.2,
        			                //effect : effect,
        			                itemStyle : itemStyle(0),
        			                smooth:true,
        			                smoothness:0.05,
        			                data : []
        			            },
        			            geoCoord:{}
        			        }
        			    ]
        			};
        		$.ajax({
					url:"route/findRoute",
					type:"get",
					async:false,
					success:function(response){
						option.series[0].geoCoord=response;
						 $.ajax({
							url:"route/findLineStation",
							type:"get",
							async:false,
							success:function(response){
								var array = new Array();
								var num = 0;
								for(var i=0;i<response.length;i++){
									var stationList = $(response)[i].route;
									var sortStationList = sortList($(stationList));
									for(var j=0;j<sortStationList.length-1;j++){
										var startCity = $(sortStationList)[j].name;
										var endCity = $(sortStationList)[j+1].name;
										var cirData = [{name:startCity}, {name:endCity}];
										array[num] = cirData;
										num++;
									}
								}
								option.series[0].markLine.data = array;
							}
						}); 
					}
				});
        		
        		function sortList(stationList){
        			for(var i=0;i<stationList.length-1;i++){
        				for(var j=0;j<stationList.length-1;j++){
        					var start = stationList[j].orders;
            				var end = stationList[j+1].orders;
            				if(start>end){
            					var temp = stationList[j];
            					stationList[j] = stationList[j+1];
            					stationList[j+1] = temp;
            				}
        				}
        			}
        			return stationList;
        		};
				
				
                //myChart.hideLoading();  
                myChart.setOption(option);
			});
	</script>

	
</body>
</html>