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
<title>Tencloud受派明细单打印</title>
<script src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"
	type="text/javascript"></script>
	  
<style type="text/css">
td {
	padding: 10px;
}
</style>
</head>
<body>
	<c:forEach items="${sessionScope.AssignmentDetailed}" var="assignmentDetailedUtil">
		<table border="1px"
			style="margin: 50px auto 1px; text-align: center; font-size: 15px; border-collapse: collapse;">
			<thead>
				<tr>
					<td colspan="10"style="font-size:25px; border-bottom-color:white;">
						<span style=" color: #ccc;font-style:italic;font-size: 30px;position:absolute;left:330px"><img src="/jsps/images/12.png" height=10%" width="10%" />Tencloud</span> 受派明细单
					</td>
				</tr>

				<tr>
					<td colspan="6"
						style="border-right-color: white;">工作单号：${assignmentDetailedUtil.workSheetNo}</td>
				</tr>
			</thead>

			<tbody>
				<tr style="text-align: center;">
					<td>签收状态</td>
					<td>签收人</td>
					<td>派送单位</td>
					<td>受理单位</td>
					<td>结算方式</td>
					<td>产品名</td>
					<td>件数</td>
					<td>体积</td>
					<td>到达地</td>
					<td>希望送达时间</td>
					<td>配载要求</td>
					
				</tr>

				<tr>
					<td style="height:100px">${assignmentDetailedUtil.signStatus}</td>
					<td>${assignmentDetailedUtil.addressesName}</td>
					<td>${assignmentDetailedUtil.empName}</td>
					<td>${assignmentDetailedUtil.pickup}</td>
					<td>${assignmentDetailedUtil.settlementMode}</td>
					<td>${assignmentDetailedUtil.productName}</td>
					<td>${assignmentDetailedUtil.productAmount}</td>
					<td>${assignmentDetailedUtil.size}</td>
					<td>${assignmentDetailedUtil.addressesAddress}</td>
					<td>${assignmentDetailedUtil.serviceTimeLimit}</td>
					<td>${assignmentDetailedUtil.stowageRequirement}</td>
				</tr>
			</tbody>

			<tfoot>
				<tr>
					<td colspan="4"
						style="border-right-color: white;">总票数：${assignmentDetailedUtil.votes}</td>
					<td colspan="2" style="border-right-color: white;">已派送：${assignmentDetailedUtil.delivered}</td>
					<td colspan="2" style="border-right-color: white;">未派送：${assignmentDetailedUtil.delivered}</td>
					<td colspan="4" >晚点率：${assignmentDetailedUtil.delayRate}</td>
				</tr>
			</tfoot>

		</table>
	</c:forEach>
</body>
</html>