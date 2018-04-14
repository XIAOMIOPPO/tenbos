<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title id="Description">组织结构管理</title>
<base href="<%=basePath %>"></base>
<meta name="description"
	content="This sample demonstrates how we can bind jQWidgets TreeGrid widget to Array Data by using jQWidgets DataAdapter plugin.">
<meta name="viewport"
	content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />
<link rel="stylesheet" href="static/jqxtreegrid/css/jqxbase.css"
	type="text/css" />
<link rel="stylesheet"
	href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	type="text/css" />
<link
	href="static/select/bootstrap-select.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="static/toastr/toastr.css">
<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript"
	src="static/select/bootstrap-select.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxcore.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxdata.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxbuttons.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript"
	src="static/jqxtreegrid/js/jqxscrollbar.js"></script>
<script type="text/javascript"
	src="static/jqxtreegrid/js/jqxdatatable.js"></script>
<script type="text/javascript"
	src="static/jqxtreegrid/js/jqxtreegrid.js"></script>

	
<script type="text/javascript">
	$(document).ready(function () {
	
		createTreeGrid();
	
		$('.norgType').selectpicker({
			'selectedText' : 'cat',
			type : 'select',
			hiddenInput : true,
			url : 'basisFiles/options?remarlk=ZZJGLX',
			inputName : 'orgType',
			key : 'fileId',
			value : 'fileName'
		});
	
	$("#btn_add").click(function() {
		addOrg();
	});
	
	$("#submitAdd").click(function(){
		var options={
				url:'org/addOrg', //form提交数据的地址
				type:'post', //form提交的方式(method:post/get)
				dataType:'json', //服务器返回数据类型
				beforeSubmit:function(){//提交前校验
					var orgName = $("#orgName").val();
					var orgType = $("#orgType").val();
					var empName = $("#empName").val();
					var parendOrgId = $("#parendOrgId").val();
					var location = $("#location").val();
					var orgindex = $("#orgindex").val();
					if(orgName == ""){
						toastr.error("组织名不能为空");
					}else if(orgType == ""){
						toastr.error("组织类型不能为空");
					}else if(empName == ""){
						toastr.error("负责人不能为空");
					}else if(parendOrgId == ""){
						toastr.error("父组织不能为空");
					}else if(location == ""){
						toastr.error("地址不能为空");
					}else if(orgindex == ""){
						toastr.error("序列不能为空");
					}
				},
				success:function(data){
					$("#addOrg").modal('hide');
					$("#treegrid").jqxTreeGrid('refresh');
					if(data.status == 1){
						toastr.success("添加成功");
						createTreeGrid();
					}else{
						toastr.error("添加失败");
					}
				} //提交成功后执行的回调函数
		}
		$("#addOrgForm").ajaxSubmit(options);
	});

	$("#btn_edit").click(function(){
		editOrg();
	});
	
	$("#submitEdit").click(function(){
		
		var options={
				url:'org/updateOrg', //form提交数据的地址
				type:'post', //form提交的方式(method:post/get)
				dataType:'json', //服务器返回数据类型
				success:function(data){
					$("#editOrg").modal('hide');
					if(data.status == 1){
						toastr.success("修改成功",{timeOut:2000,progressBar:true});
						var rowData = $("#editOrg").data('rowdata');
						refreshRow(rowData,'#editOrgForm');
						
					}else{
						toastr.error("修改失败",{timeOut:2000,progressBar:true});
					}
					$("#treegrid").jqxTreeGrid('refresh');
				} //提交成功后执行的回调函数
		}
		$("#editOrgForm").ajaxSubmit(options);
	});
	
	
	$("#btn_delete").click(function(){
		deleteOrg();
	});
	
	$("#btn_query").click(function(){
		queryOrg();
	});
	
	$("#btn_query").jqxButton({
	      theme: 'energyblue',
	      width: 100,
	      height: 35
	});
	
	$("#queryForm").find("#orgType-btn").click(function(){
		var dropDiv = $(this);
		var targetUL = $(this).find(".dropdown-menu");
		if(targetUL.children().length==0){
			$.getJSON("org/allOrgTypeName",function(data){
				for(var i=0;i<data.length;i++){
					var item = $("<li data='"+data[i].orgType+"'></li>");
					
					item.click(function(){
						dropDiv.prev().prev().val($(this).attr("data"));
						dropDiv.prev().val($(this).children().html());
					});
					item.append("<a href='javascript:void(0)'>"+data[i].fileName+"</a>");
					dropDiv.find(".dropdown-menu").append(item);
				}
			});
		}
	
	});
	
	
	
	});
	
	function createTreeGrid(){
		var source =
		{
		    dataType: "json",
		    dataFields: [
		        { name: 'orgId', type: 'string' },
		        { name: 'orgName', type: 'string' },
		        { name: 'orgType', type: 'string' },
		        { name: 'fileName', type: 'string' },
		        { name: 'empName', type: 'string' },
		        { name: 'parendOrgId', type: 'string' },
		        { name: 'location', type: 'string' },
		        { name: 'orgindex', type: 'number' }
		    ],
		    hierarchy:
		    {
		        keyDataField: { name: 'orgId' },
		        parentDataField: { name: 'parendOrgId' }
		    },
		    id: 'orgId',
		    url:'org/allOrg'
		};
		var dataAdapter = new $.jqx.dataAdapter(source);
		// create Tree Grid
		$("#treegrid").jqxTreeGrid(
		{
		   	width:  $("#treegrid").width(),
		   	pageSize: 10,
		   	pageSizeOptions: ['15', '20', '30'],
		   	pageable:true,
		   	pagerPosition:'bottom',
		    source: dataAdapter,
		    sortable: true,
		    ready:function(){
		    	$("#treegrid").jqxTreeGrid('expandRow', 'ORG0000000000001');
		    },
		    columns: [
		      { text: '组织结构名', dataField: 'orgName', width: $("#treegrid").width()/5},
		      { text: '负责人', dataField: 'empName', width: $("#treegrid").width()/5},
		      { text: '地址', dataField: 'location', width: $("#treegrid").width()/5},
		      { text: '组织类型', dataField: 'fileName', width: $("#treegrid").width()/5},
		      { text: '序列', dataField: 'orgindex', width: $("#treegrid").width()/5}
		    ]
		});
		

		$('#treegrid').on('rowExpand',function(event){
			var args = event.args;
	        var row = args.row;
	        var key = args.key;
		});
	}
	
	function refreshRow(rowData,formId){
		var formData = $(formId).serializeArray();
		var formatData={};
		for(var i=0;i<formData.length;i++){
			var data = formData[i];
			if(data.value){
				formatData[data.name]=data.value;
			}
		}
		rowData=$.extend(rowData, formatData);
		$("#treegrid").jqxTreeGrid('updateRow', rowData.orgId, rowData);
	}
	
	function addOrg(){
		
		
		$("#addOrg").find("#parendOrg-btn").click(function(){
			var dropDiv = $(this);
			var targetUL = $(this).find(".dropdown-menu");
			if(targetUL.children().length==0){
				$.getJSON("org/allOrg",function(data){
					for(var i=0;i<data.length;i++){
						var item = $("<li data='"+data[i].orgId+"'></li>");
						
						item.click(function(){
							dropDiv.prev().prev().val($(this).attr("data"));
							dropDiv.prev().val($(this).children().html());
						});
						item.append("<a href='javascript:void(0)'>"+data[i].orgName+"</a>");
						dropDiv.find(".dropdown-menu").append(item);
					}
				});
			}
			
		});
		
		

		$("#addOrg").modal('show');
	}
	
	function editOrg(){
		//判断是否选中一行
		var selection = $("#treegrid").jqxTreeGrid('getSelection');
		if(selection.length==0){
			toastr.warning("请选中一行!");
		}else{
			//获取被选择行数
			console.log(selection);
			console.info(selection);
			var rowData = selection[0];
			$("#orgId").val(rowData.orgId);
			$("#editOrg").modal('show');
			$("#editOrg").data('rowdata',rowData);
		}
	}
	
	function deleteOrg(){
		toastr.warning("还未开放此功能！");
	}
	
	function queryOrg(){
		$("#treegrid").jqxTreeGrid('clearFilters');
		var orgName = $("#txt_search_orgName").val();
		var fileName = $("#txt_search_fileName").val();
		var empName = $("#txt_search_empName").val();
		var filtertype = 'stringfilter';
	    // create a new group of filters.
	    var filtergroup = new $.jqx.filter();
	    var filter_or_operator = 1;
		if(orgName!=''){
			var filtervalue = orgName;
		    console.log(1,filtervalue);
		    var filtercondition = 'CONTAINS';
		    var filter = filtergroup.createfilter(filtertype, filtervalue, filtercondition);
		    filtergroup.addfilter(filter_or_operator, filter);
			// add the filters.
			 $("#treegrid").jqxTreeGrid('addFilter', 'orgName', filtergroup);
		}
		if(fileName!=''){
			var filtervalue = fileName;
		    console.log(1,filtervalue);
		    var filtercondition = 'CONTAINS';
		    var filter = filtergroup.createfilter(filtertype, filtervalue, filtercondition);
		    filtergroup.addfilter(filter_or_operator, filter);
			// add the filters.
			 $("#treegrid").jqxTreeGrid('addFilter', 'fileName', filtergroup);
		}
		if(empName!=''){
			var filtervalue = empName;
		    console.log(1,filtervalue);
		    var filtercondition = 'CONTAINS';
		    var filter = filtergroup.createfilter(filtertype, filtervalue, filtercondition);
		    filtergroup.addfilter(filter_or_operator, filter);
			// add the filters.
			 $("#treegrid").jqxTreeGrid('addFilter', 'empName', filtergroup);
		}
	    // apply the filters.
	    $("#treegrid").jqxTreeGrid('applyFilters');

	}
	
	
    </script>
</head>
<body>

	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-heading">查询条件</div>
			<div class="panel-body" id="queryForm">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<div class="col-sm-3" style="width:23%;">
							<input type="text" class="form-control"
								id="txt_search_orgName" placeholder="组织结构名">
						</div>
							<div class="col-sm-10" style="width:28%;">
								<select class="norgType" name="orgName" class="empsel selectpicker bla bla bli"
									data-live-search="true">

								</select>
							</div>
						<div class="col-sm-3" style="width:23%;">
							<input type="text" class="form-control" id="txt_search_empName" placeholder="负责人">
						</div>
						<div class="col-sm-4" style="text-align: left;width:20%;">
							<button type="button" style="margin-left: 50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-success">
				<span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-danger">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</div>
	</div>

	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-body">
				<div id="treegrid"></div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="editOrg" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">修改组织结构</h4>
				</div>
				<div class="modal-body" id="test">
					<form class="form-horizontal" role="form" 
						id="editOrgForm">
						<div class="form-group">
							<label class="col-sm-2 control-label">组织编码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="orgId" readonly="readonly" name="orgId">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">组织名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									placeholder="请输入要修改的组织结构名" name="orgName">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">负责人</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									placeholder="请输入要修改的负责人" name="empName">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">地址</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									placeholder="请输入要修改的地址" name="location">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="button" class="btn btn-default" id="submitEdit">提交更改</button>
							</div>
						</div>
					</form>

				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	
	<div class="modal fade" id="addOrg" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">添加组织结构</h4>
				</div>
				<div class="modal-body" id="test">
					<form class="form-horizontal" role="form"
						id="addOrgForm">
						<div class="form-group">
							<label class="col-sm-2 control-label">组织名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="orgName"
									placeholder="请输入组织结构名" name="orgName">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">组织类型</label>
							<div class="col-sm-10">
								<select class="norgType" class="empsel selectpicker bla bla bli"
									data-live-search="true">

								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">负责人</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="empName"
									placeholder="请输入负责人" name="empName">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">父组织</label>
							<div class="col-sm-10">
								<div class="input-group">
									<input type="hidden" id="parendOrgId" name="parendOrgId"
										class="form-control"> <input type="text" id="rtype"
										class="form-control" placeholder="请选择父组织结构" readonly="readonly">
									<div class="input-group-btn" id="parendOrg-btn">
										<button type="button"
											class="btn btn-default 
			                        dropdown-toggle"
											data-toggle="dropdown">
											父组织 <span class="caret"></span>
										</button>
										<ul class="dropdown-menu pull-right">

										</ul>
									</div>
									<!-- /btn-group -->
								</div>
								<!-- /input-group -->
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">地址</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="location"
									placeholder="请输入地址" name="location">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">组织序列</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="orgindex"
									placeholder="请输入组织序列" name="orgindex">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="button" class="btn btn-default" id="submitAdd">提交添加</button>
							</div>
						</div>
					</form>

				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>


</body>
</html>