<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tencloud委派统计单打印</title>
<script src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"
	type="text/javascript"></script>
	  
<style type="text/css">
td {
	padding: 10px;
}
</style>
</head>
<body>
	<c:forEach items="${sessionScope.DelegationStatistics}" var="delegationStatisticsUtil">
		<table border="1px"
			style="margin: 50px auto 1px; text-align: center; font-size: 15px; border-collapse: collapse;">
			<thead>
				<tr>
					<td colspan="10"style="font-size:25px; border-bottom-color:white;">
						<span style=" color: #ccc;font-style:italic;font-size: 30px;position:absolute;left:430px"><img src="/jsps/images/12.png" height=10%" width="10%" />Tencloud</span> 委派统计单
					</td>
				</tr>

				<tr>
					<td colspan="6"
						style="border-right-color: white;">网点代码：${delegationStatisticsUtil.orgId}</td>
				</tr>
			</thead>

			<tbody>
				<tr style="text-align: center;">
					<td>网点名称</td>
					<td>应派送票数</td>
					<td>已派送票数</td>
					<td>未派送票数</td>
					<td>已返货数量</td>
				</tr>

				<tr>
					<td style="height:100px">${delegationStatisticsUtil.pickup}</td>
					<td>${delegationStatisticsUtil.votes}</td>
					<td>${delegationStatisticsUtil.delivered}</td>
					<td>${delegationStatisticsUtil.notDelivered}</td>
					<td>${delegationStatisticsUtil.returnNum}</td>
				</tr>
			</tbody>

			<tfoot>
				<tr>
					<td colspan="4"
						style="border-right-color: white;">晚点率：${delegationStatisticsUtil.delayRate}</td>
					<td colspan="2" style="border-right-color: white;">返货率：${delegationStatisticsUtil.returnRate}</td>
				</tr>
			</tfoot>

		</table>
	</c:forEach>
</body>
</html>