<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>铁路路由</title>
<style type="text/css">
body, html {
	width: 100%;
	height: 100%;
	margin: 0;
	font-family: "微软雅黑";
}

#l-map {
	height: 500px;
	width: 100%;
}
</style>
<script
	src="${ pageContext.request.contextPath }/js/jquery-3.1.1.min.js"
	type="text/javascript"></script>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/toastr/toastr.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-select.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/select2/select2.min.css">

<script src="${pageContext.request.contextPath}/static/jquery-3.2.1.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/collapse.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-select.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/select2/select2.full.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/select2/select2.min.js"></script>
<title>根据起终点名称查询公交换乘</title>

<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=3.0&ak=cHEzHzIG3PblnQQgGNbm4QrZirnk9lYd"></script>
<style type="text/css">
body, html, #container {
	width: 100%;
	height: 100%;
	overflow: hidden;
	margin: 0;
	font-family: "微软雅黑";
}
</style>
</head>
<body>
	<div style="float: left; width: 30%;">
		<div class="input-group">
			<span class="input-group-addon">城市</span> <input id="start"
				class="form-control" type="text" placeholder="请输入起始城市"> <input
				id="end" class="form-control" type="text" placeholder="请输入到达城市">
			<span class="input-group-addon"> <span id="btn"
				class="glyphicon glyphicon-search" aria-hidden="true"></span>
			</span>
		</div>
		<div id="log" ></div>
		<div><h3>暂无路线信息，请查询</h3></div>
	</div>
	<div id="container" style="float: right; width: 70%;"></div>
	<script type="text/javascript">
	var map = new BMap.Map("container");  
    var point = new BMap.Point(113,28.2);
    map.centerAndZoom(point, 16);  
    map.enableScrollWheelZoom(); 

    var myIcon = new BMap.Icon("YD.jpg",new BMap.Size(30,30),{
        anchor: new BMap.Size(10,10)    
    });

    var marker=new BMap.Marker(point,{icon: myIcon});  
    map.addOverlay(marker);  

    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function(r){
        if(this.getStatus() == BMAP_STATUS_SUCCESS){
            var mk = new BMap.Marker(r.point);
            map.addOverlay(mk);
            //map.panTo(r.point);//地图中心点移到当前位置
            var latCurrent = r.point.lat;
            var lngCurrent = r.point.lng;
            //alert('我的位置：'+ latCurrent + ',' + lngCurrent);

            location.href="http://api.map.baidu.com/direction?origin="+latCurrent+","+lngCurrent+"&destination=39.89778,116.709684&mode=driving&region=长沙&output=html";

        }
        else {
            //alert('failed'+this.getStatus());
        }        
    },{enableHighAccuracy: true})


    map.addOverlay(marker);  
    var licontent="<b>TENCLOUD物流集团</b><br>";  
        licontent+="<span><strong>地址：</strong>长沙市雨花区香樟路110号</span><br>";  
        licontent+="<span><strong>电话：</strong>(010)81556565 / 6969</span><br>";          
    var opts = { 
        width : 200,
        height: 80,
    };         
    var  infoWindow = new BMap.InfoWindow(licontent, opts);  
    marker.openInfoWindow(infoWindow);  
    marker.addEventListener('click',function(){
        marker.openInfoWindow(infoWindow);
    });  
		var transit = new BMap.TransitRoute(map, {
			renderOptions : {
				map : map,
				autoViewport : true,
				panel : "log",
			},
			// 配置跨城公交的换成策略为优先出发早
			intercityPolicy : BMAP_INTERCITY_POLICY_EARLY_START,
			// 配置跨城公交的交通方式策略为飞机优先
			transitTypePolicy : BMAP_TRANSIT_TYPE_POLICY_TRAIN
		});
		map.addControl(new BMap.NavigationControl());    
		map.addControl(new BMap.ScaleControl());    
		map.addControl(new BMap.OverviewMapControl());    
		map.addControl(new BMap.MapTypeControl());
		var geoc = new BMap.Geocoder();
		$("#btn").click(function(){
			geoc.getPoint($("#start").val(), function(start) {
				geoc.getPoint($("#end").val(), function(end) {
					transit.search(start, end);
				});
			});
			
		})
		map.enableScrollWheelZoom(true);

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
	</script>
</body>
</html>
