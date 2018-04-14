<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>快速录入</title>

<link rel="stylesheet" type="text/css"href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"rel="stylesheet">
<link href="static/select/select2.min.css"rel="stylesheet" type="text/css">
<link href="static/toastr/toastr.css"rel="stylesheet" type="text/css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css">

<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript" src="static/select/select2.full.js"></script>
<script type="text/javascript" src="static/select/select2.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<style type="text/css">
	.form-control{
		border:none;
	}
	
	.red{
		border:1px solid red;
	}
	
</style>

<script type="text/javascript">
	$(function(){
		$(".select2").select2();
		$("[data-toggle='popover']").popover();
		
		//查找配载要求和产品
		function find(){
			//查找配载要求
			$.ajax({
				url:"fastEntering/findStowageRequirement.action",
				type:"post",
				async:true,
				data:{
					recordName:$("#pzyq").html()
				},
				traditional: true,
				success:function(response) {
					var html=$('.stowageRequirement');
					for(var i=0;i<response.length;i++){
							item=$("<option></option>");
							item.append(response[i]);
							item.attr("value",response[i]);
							html.append(item);
					}
					
				}
			});
			//查找产品
			$.ajax({
				url:"fastEntering/findStowageRequirement.action",
				type:"post",
				async:true,
				data:{
					recordName:$("#cp").html()
				},
				traditional: true,
				success:function(response) {
					var html=$('.product');
					for(var i=0;i<response.length;i++){
							item=$("<option></option>");
							item.append(response[i]);
							item.attr("value",response[i]);
							html.append(item);
					}
					
				}
			});
		}
		
		//页面一加载就调用find()方法查找产品和配载要求
		find();
		
		//添加的函数
		function add(){
			//定义一个空的数组
			var array =[];
			//遍历表格中的所有tr
			if(!validate()){
				return ;
			}
			$("#tbody").find('tr').each(function(){
				//创建一个数组用来保存所有的值
				var obj={};
				//遍历所有的input框
				$(this).find('input').each(function(){
					//将所有input框中的值放入数组中
					obj[this.name]=$(this).val();
				});
				//遍历所有的搜索框
				$(this).find('select').each(function(){
					//将所有的搜框框的值放入数组
					obj[this.name]=$(this).val();
				});
				//将第二个数组放入第一个数组
				array.push(obj);
				
			});
			//异步同步数据库
			$.ajax({
				url:"fastEntering/addWorkSheet",
				type:"get",
				data:{
					fastEntering:JSON.stringify(array)
				},
				async:false,
				success:function(result){
					var errors = result.errors.length;
					var renos = result.renos.length;
					if (errors+renos==0) {
						toastr.success("添加成功");
						$("#table").find('tbody tr').remove();
					}else if(errors+renos>0){
						$("#table").find('tr td input[name="workSheetNo"]').each(function(){
							var wno = this.value;
							if(result.errors.indexOf(wno)!=-1){
								toastr.error("添加失败  原因:未知错误");
							}else if(result.renos.indexOf(wno)!=-1){
								toastr.error("添加失败  原因:工作单号重复");
							}else{
								$(this).parent().parent().remove();
							}
						});
					}
				}
			});
		}
		
		//点击按钮保存
		$("#save").click(function(){
			add();
		});
	
		
		//新增一行
		$(document).ready(function(){
		    $("#addRow").click(function(){
		       var tr="<tr class=\"active\">"+
		       		  "<td><input type=\"text\" class=\"form-control\" id=\"workSheetNo\" name = \"workSheetNo\" style=\"width:100%;height:100%;\"/></td>"+
		              "<td><input type=\"text\" class=\"form-control\" id=\"destination\" name = \"destination\" style=\"width:100%;height:100%;\"/></td></td>"+
		              "<td><select class=\"product select2\"  name=\"product\" style=\"width:120px;height:100%;\"></select></td>"+
		              "<td><input type=\"text\" class=\"form-control\" id=\"productAmount\" name =\"productAmount\"style=\"width:100%;height:100%;\"/></td>"+
		              "<td><input type=\"text\" class=\"form-control\" id=\"actualWeight\" name =\"actualWeight\"style=\"width:100%;height:100%;\"/></td>"+
		              "<td><select class=\"stowageRequirement select2\" name=\"stowageRequirement\"style=\"width:120px;height:100%;\"></select></td>"+
		              "<td>"+
					  "<button type=\"button\" class=\"btn\" onclick=\"clickButton(this)\">"+
					  "<span class=\"glyphicon glyphicon-lock\" aria-hidden=\"true\"></span>"+
					  "</button>"+
					  "</td>"+
					  "<td>"+
					  "<button type=\"button\" class=\"btn\" onclick=\"clickEdit(this)\">"+
					  "<span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span>"+
					  "</button>"+
					  "</td>"+
					  "<td>"+
					  "<button type=\"button\" class=\"btn\" onclick=\"delRow(this)\">"+
					  "<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>"+
					  "</button>"+
					  "</td>"+
	              	  "</tr>";
		              
				 $("#table").append(tr);
			 	var p = $('.product').eq(0).html();
				$('.product').html(p);
				var s = $('.stowageRequirement').eq(0).html();
				$('.stowageRequirement').html(s);
			 	$(".select2").select2();
			 	
		    });
		});
		
	});
	
	//点击按钮该行不可再编辑
	function clickButton(obj){
		$(obj).parent().parent().children().each(function(){
			$(this).find('.form-control').attr("disabled",true); 
			$(this).find('.select2').attr("disabled",true);
		});
	}
	
	//点击按钮该行可再编辑
	function clickEdit(obj){
		$(obj).parent().parent().children().each(function(){
			$(this).find('.form-control').attr("disabled",false); 
			$(this).find('.select2').attr("disabled",false);
		});
	}

	//点击按钮删除一行
	function delRow(obj){
		//获取表格  
	    var t=document.getElementById('table');  
	    //删除当前行  
	    t.deleteRow(obj.parentNode.parentNode.rowIndex);  
	}
	
	//校验工作单编号
	function validateWorkSheetNo(){
		var flag = true;
		 $('input[name="workSheetNo"]').each(function(){
			//校验是否为空
			var obj=this;
			var temp = /^TCBOS-\d{5}$/;
			if (obj.value == "" || obj.value.length == 0) {
				$(this).css("border","1px solid #AE0000");
			    $(this).val("工作单编号不能为空");
				flag = false;
			}else if(temp.test(obj.value)==false){
				$(this).css("border","1px solid #AE0000");
			    $(this).val("您输入的格式错误");
				flag=false;
			}else{
				$(this).css("border","1px solid white");
			}
			 
		});
		return flag; 
	}
	
	
	//校验到达地
	function validateDestination(){
		var flag = true;
		$('input[name="destination"]').each(function(){
			var obj=this;
			//校验是否为空
			if (obj.value == "" || obj.value.length == 0) {
			    $(this).val("到达地不能为空");
			    $(this).css("border","1px solid #AE0000");
			}
			
			if(!(obj.value == "" || obj.value.length == 0) && obj.value != "到达地不能为空"){
				$(this).css("border","1px solid white");
			}
			
		});
		return flag;
	}
	
	//校验总件数
	function validateProductAmount(){
		var flag = true;
		$('input[name="productAmount"]').each(function(){
			var obj=this;
			//校验是否为空
			if (obj.value == "" || obj.value.length == 0) {
				$(this).css("border","1px solid #AE0000");
			    $(this).val("总件数不能为空");
				flag = false;
			}else if(/^[0-9]+$/.test(obj.value)==false){//校验是否是数字
				$(this).css("border","1px solid #CE0000");
			    $(this).val("请输入一个数字");
				flag=false;
			}else{
				$(this).css("border","1px solid white");
			}
		});
		return flag;
	}
	
	//校验重量
	function validateActualWeight(){	
		var flag=true;
		$('input[name="actualWeight"]').each(function(){
			var obj=this;
			//校验是否为空
			if (obj.value == "" || obj.value.length == 0) {
				$(this).css("border","1px solid #CE0000");
			    $(this).val("重量不能为空");
				flag=false;
			}else{
				$(this).css("border","1px solid white");
			}
			//校验是否是数字
			if(/^[0-9]+$/.test(obj.value)==false){
				$(this).css("border","1px solid #CE0000");
			    $(this).val("请输入一个数字");
				flag=false;
			}else{
				$(this).css("border","1px solid white");
			}
		});
		return flag;
	}
	
	//调用校验的方法
	function validate(obj){
		var flag=true;
		if(!validateWorkSheetNo()){
			flag=false;
		}
		
		if(!validateDestination()){
			flag=false;
		}
		
		if(!validateProductAmount()){
			flag=false;		
		}
		
		if(!validateActualWeight()){
			flag=false;
		}
		
		return flag;
	}
	
	
</script>
</head>

<body class = "default">
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="acceptance">
			<div class="table-responsive">
				<form id = "form">
					<table class="table table-hover" id="table" style="text-align:center;">
						<thead>
						<tr class="active">
							<th >工作单编号</th>
							<th>到达地</th>
							<th id="cp">产品</th>
							<th>总件数</th>
							<th>重量</th>
							<th id="pzyq">配载要求</th>
							<th>操作</th>
							<th>
								<span class="glyphicon glyphicon-plus" aria-hidden="true" id="addRow"></span>
							</th>
							<th>
								<shiro:hasPermission name="KSLR:ADDFE">
									<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"id="save"></span>
								</shiro:hasPermission>
							</th>						
						</tr>
						</thead>
						<tbody id="tbody">
							<tr class="active">
								<td><input type="text" class="form-control"
									id="workSheetNo" name="workSheetNo"
									style="width: 100%; height: 100%;"
									title="工作单号提示"data-toggle="popover"
									data-content="①.工作单号位数为11位②.工作单号以“TCBOS”开头其他位数为0-9的数字 中间以'-'隔开
									③.工作单号唯一"data-placement="bottom"/>
								</td>
								<td><input type="text" class="form-control"
									id="destination" name="destination"
									style="width: 100%; height: 100%;" /></td>
								<td><select class="product select2" name="product"
									style="width: 120px; height: 100%;"></select></td>
								<td><input type="text" class="form-control"
									id="productAmount" name="productAmount"
									style="width: 100%; height: 100%;"/></td>
								<td><input type="text" class="form-control"
									id="actualWeight" name="actualWeight"
									style="width: 100%; height: 100%;"/></td>
								<td><select class="stowageRequirement select2"
									name="stowageRequirement" style="width: 120px; height: 100%;"></select>
								</td>
								<td>
									<button type="button" class="btn" onclick="clickButton(this)">
										<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
									</button>
								</td>
								<td>
									<button type="button" class="btn" onclick="clickEdit(this)">
										<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									</button>
								</td>
								<td>
									<button type="button" class="btn" onclick="delRow(this)">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									</button>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>