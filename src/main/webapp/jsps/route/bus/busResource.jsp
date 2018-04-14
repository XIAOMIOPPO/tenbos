<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班车线路图</title>
<style type="text/css">
html {
	height: 100%;
}

body {
	height: 100%;
	margin: 0px;
	padding: 0px;
}

#container {
	height: 100%;
	width:70%;
	float: right;
}

#left{
	width:30%;
	height:100%;
	float:left;
	overflow-y:scroll;
}

.anchorBL{
	display:none;
}
 
#log{
	margin: 7% 0 0 0;
}

#input{
	padding:3% 0;
}

#collapse{
	position: fixed;
	left:30%;
	top:30%;
	background:url(img/result.png) no-repeat 0 -142px;
	width:1%;
	height:12%;
}

</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=cHEzHzIG3PblnQQgGNbm4QrZirnk9lYd">
	//v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
</script>
<script src="static/jquery-3.2.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>

<body>
	<div id="left" class="panel-collapse collapse in">
		<div id="input">
			<div class="input-group">
	            <span class="input-group-addon">起点</span>
	            <input class="form-control" type="text" id="startCity">
	            <span class="input-group-addon">终点</span>
	            <input class="form-control" type="text" id="endCity">
	            <span class="input-group-addon">
					<span class="glyphicon glyphicon-search" aria-hidden="true"  id="query-btn"></span>
	            </span>
			 </div>
		</div>
		<div id="log"></div>
	</div>
	<div id="container"></div>
	<div id="collapse">
    </div>
	<script type="text/javascript">
		/* var map = new BMap.Map("container");
		// 创建地图实例  
		var point = new BMap.Point(116.404, 39.915);
		// 创建点坐标  
		map.centerAndZoom(point, 15); */
		// 初始化地图，设置中心点坐标和地图级别
		/*定点查询*/
		/* var start = "";
		var startSearch = new BMap.LocalSearch(map);
		startSearch.setSearchCompleteCallback(function (searchResult) {
			var poi = searchResult.getPoi(0);
			start = new BMap.Point(poi.point.lng, poi.point.lat);
			map.centerAndZoom(poi.point, 13);
		});
		startSearch.search("长沙");
		
		var end = "";
		var endSearch = new BMap.LocalSearch(map);
		endSearch.setSearchCompleteCallback(function (searchResult) {
			var poi = searchResult.getPoi(0);
			end = new BMap.Point(poi.point.lng, poi.point.lat);
			map.centerAndZoom(poi.point, 13);
		});
		endSearch.search("永州"); */
		
		//去除路网
		/* map.setMapStyle({
			styleJson : [ {
				"featureType" : "road",
				"elementType" : "all",
				"stylers" : {
					//"color": "#ffffff",
					"visibility" : "off"
				}
			} ]
		}); */
		
		/* var options = {    
		    onSearchComplete: function(results){    
		        if (driving.getStatus() == BMAP_STATUS_SUCCESS){    
		            // 获取第一条方案   
		            var plan = results.getPlan(0);      
		            // 获取方案的驾车线路   
		            var route = plan.getRoute(0);      
		            // 获取每个关键步骤，并输出到页面   
		            var s = [];    
		            for (var i = 0; i < route.getNumSteps(); i ++){    
		                var step = route.getStep(i);    
		                s.push((i + 1) + ". " + step.getDescription());    
		            }    
		            document.getElementById("log").innerHTML = s.join("<br>");    
		        }    
		    },
		    renderOptions: {    
		        map: map,    
		        autoViewport: true    
		    } 
		};    
		var driving = new BMap.DrivingRoute(map, options); */ 
		var map = new BMap.Map("container");    
		map.centerAndZoom(new BMap.Point(113.010532,28.140207), 18); 
		var driving = new BMap.DrivingRoute(map, {    
		    renderOptions: {    
		        map: map,    
		        autoViewport: true,
		        panel:"log"
		    }    
		});  
		
		map.addControl(new BMap.NavigationControl());    
		map.addControl(new BMap.ScaleControl());    
		map.addControl(new BMap.OverviewMapControl());    
		map.addControl(new BMap.MapTypeControl());  
		
		$(function(){
			$("#collapse").click(function(){
				if($("#left").width()>0){
					$("#left").css("width","0");
					$("#container").css("width","100%");
					$("#collapse").css("left","0");
					$("#collapse").css("background","url(img/result.png) no-repeat 0 -242px");
				}else{
					$("#left").css("width","30%");
					$("#container").css("width","70%");
					$("#collapse").css("left","30%");
					$("#collapse").css("background","url(img/result.png) no-repeat 0 -142px");
				}
			});
			
			$("#query-btn").click(function(){
				var startCity = $("#startCity").val();
				var endCity = $("#endCity").val();
				var geoc = new BMap.Geocoder();
				geoc.getPoint(startCity, function(start) {
					geoc.getPoint(endCity, function(end) {
						driving.search(start, end);
					});
				});
			});
		});
		
		map.enableScrollWheelZoom(true);
		/* var map = new BMap.Map("container");    
		map.centerAndZoom(new BMap.Point(116.404, 39.915), 14);    
		var transit = new BMap.TransitRoute(map, {    
		    renderOptions: {map: map, panel: "results"}    
		});    
		transit.search("王府井", "西单");  */
	</script>
</body>
</html>