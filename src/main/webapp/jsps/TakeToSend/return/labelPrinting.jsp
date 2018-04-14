<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

<title>labelPrinting</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
#center {
margin:0 auto;
padding-bottom:0px;
width:800px
}
</style>
</head>
<body>
	<div  class="panel-body" id="center">
		<form id="formSearch" class="form-horizontal">
			<div style="padding:0 250px">
				<table  style="width:300px;border-radius:5px;" border="1" cellspacing="0" cellpadding="0">
					<tr>
						<th style="width:100px;height:50px">
							<fmt:formatDate value="${gens.serviceTimeLimit}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</th>
						<th style="width:100px;height:50px">${gens.status}</th>
					</tr>
					<tr>
						<th style="width:100px;height:50px">${gens.productAmount}</th>
						<th style="width:100px;height:50px">SSH</th>
					</tr>
				</table>
				<div style="margin:">
						<font style="margin-left:15%" size="4">
							${gens.workSheetNo}-${gens.productAmount}-1
						</font>
				</div>
				<div style="hight:100px;margin:10px">
					<span style="margin-left:15%;">
						t条形码
					</span>
				</div>
			</div>
		</form>
	</div>
</body>
</html>