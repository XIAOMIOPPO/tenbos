<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="${pageContext.request.contextPath}/"></base>
<title id="Description">资源管理</title>
<meta name="description"
	content="This sample demonstrates how we can bind jQWidgets TreeGrid widget to Array Data by using jQWidgets DataAdapter plugin.">
<meta name="viewport"
	content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />
<link rel="stylesheet" href="static/jqxtreegrid/css/jqxbase.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="static/toastr/toastr.css"/>
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="static/select/bootstrap-treeview.min.css" type="text/css" />
<link rel="stylesheet" href="static/select/bootstrap-select.css" type="text/css" />
<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript" src="static/select/bootstrap-treeview.min.js"></script>
<script type="text/javascript" src="static/select/bootstrap-select.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxcore.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxdata.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxbuttons.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxscrollbar.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxdatatable.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxtreegrid.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">
	$(document).ready(function () {          
	
	// create Tree Grid
	refreshGrid();
	
	$('#resAddForm').bootstrapValidator({
		message: 'This value is not valid',
		fields:{
			resourceName:{
				validators: {
                    notEmpty: {
                        message: '请输入资源名'
                    }
                }
			},
			resourceCode:{
				validators: {
                    notEmpty: {
                        message: '请输入资源码'
                    }
                }
			},
			rindex:{
				validators: {
                    notEmpty: {
                        message: '请输入优先级'
                    },regexp: {/* 只需加此键值对，包含正则表达式，和提示 */
                        regexp: /^[0-9]+$/,
                        message: '只能是数字'
                    }
                }
			}
		}
		
	});
	
	
	
	$("#btn_add").click(function() {
		addRes();
	});

	$("#btn_edit").click(function(){
		editRes();
	});

	
	$("#btn_delete").click(function(){
		//获取id
		var selection = $("#treegrid").jqxTreeGrid('getSelection');
		if(selection.length==0){
			toastr.warning("请选择一行!");
			return ;
		}
		//根据id删除
		$.post('auth/delres',{resId:selection[0].resourceId},function(data){
			if(data.status=='success'){
				toastr.success("删除成功");
				refreshGrid();
			}else{
				toastr.error("删除失败");
			}
		});
		
	});
	
	
	$('#resSub').click(function(){
		//异步提交表单
		var options = {
			url:'auth/ares',
			beforeSubmit:function(){
				if($('#resourceType').val()==''){
					toastr.warning("请选择按钮类型");
					return false;
				}
				
				$('#resAddForm').data('bootstrapValidator').validate();
				var result = $('#resAddForm').data('bootstrapValidator').isValid();
				if(!result){
					toastr.warning("参数不合法");
					return false;
				}
				return true;
			},
			success:function(data){
				$("#aResModal").modal('hide');
				//获取父窗口
				if (data.status=='success') {
					//添加成功
					refreshGrid();
					toastr.success("添加成功");
				} else {
					//添加失败
					toastr.error("添加失败");
				}
			}
				
		};
		$('#resAddForm').ajaxSubmit(options);
		
	});
	
	
	$('#uSubmit').click(function(){
		
		var options = {
			url:'auth/ures',
			success:function(data){
				$('#uModal').modal('hide');
				if (data.status=='success') {
					refreshGrid();
					toastr.success("修改成功");
				} else {
					toastr.error("修改失败");
				}
			}
		};
		$('#uForm').ajaxSubmit(options);
	});
	
	
	$("#searchBtn").click(function(){
		//获取搜素的字符串
		var resName=$("#sresName").val();
		var resType=$("#sresType").val();
		
		
		//清除过滤器
		$("#treegrid").jqxTreeGrid('clearFilters');
		var filtertype = 'stringfilter';
	    // 创建一个过滤器组
	    var filtergroup = new $.jqx.filter();
	    var filter_or_operator = 1;
	    var filtercondition = 'CONTAINS';
		if(resName!=''){
	      var filtervalue = resName;
	      var filter = filtergroup.createfilter(filtertype, filtervalue, filtercondition);
	      filtergroup.addfilter(filter_or_operator, filter);
		  //添加过滤器
	      $("#treegrid").jqxTreeGrid('addFilter', 'resourceName', filtergroup);
				
		}
			
		if(resType!=''){
		   var filtervalue = resType;
		   var filter = filtergroup.createfilter(filtertype, filtervalue, filtercondition);
		   filtergroup.addfilter(filter_or_operator, filter);
		   //添加过滤器
		   $("#treegrid").jqxTreeGrid('addFilter', 'recordName', filtergroup);
		}
			
		//应用过滤器
	    $("#treegrid").jqxTreeGrid('applyFilters');
		
		
	});  
		

	});

	function addRes() {
		$('#aresType').selectpicker({
			type:'select',
			hiddenInput:true,
			url:'basisFiles/options?remarlk=ZYLX',
			inputName:'resourceType',
			key:'fileId',
			value:'fileName'
        });
		
    	
    	$.post('auth/restree',{date:new Date()},function(result){
	    	$('#treesel').selectpicker({
				type:'tree',
				hiddenInput:true,
				inputName:'parentResId',
				tree:{
					data:result
				}
	        });
	    	//treesel.setTreeSelectItem(rowData.resourceId,rowData.resourceName);
    	});
    	
    	
		var selection = $("#treegrid").jqxTreeGrid('getSelection');
		if(selection.length!=0){
			var rowData = selection[0];
			$('#treesel').selectpicker("setTreeSelect",{id:rowData.resourceId,text:rowData.resourceName});
		}
    	
    	$("#aResModal").modal('show');

	}
	
	function refreshGrid(dataAdapter){
		var source =
		{
		    dataType: "json",
		    dataFields: [
		        { name: 'resourceId', type: 'string' },
		        { name: 'resourceName', type: 'string' },
		        { name: 'resourceCode', type: 'string' },
		        { name: 'resourceUrl', type: 'string' },
		        { name: 'resourceType', type: 'string' },
		        { name: 'parentResId', type: 'string' },
		        { name: 'rindex', type: 'number' },
		        { name: 'fileName', type: 'string'}
		    ],
		    hierarchy:
		    {
		        keyDataField: { name: 'resourceId' },
		        parentDataField: { name: 'parentResId' }
		    },
		    id: 'resourseId',
		    url:'auth/allres'
		};
		var dataAdapter = new $.jqx.dataAdapter(source);
		var averageW=parseInt($("#treegrid").width()/5);//定义表格树每列的宽度
		$("#treegrid").jqxTreeGrid(
		{
		   	width:  $("#treegrid").width(),
		   	pageSize: 10,
		   	pageSizeOptions: ['15', '20', '30'],
		   	pageable:true,
		   	pagerPosition:'bottom',
		    source: dataAdapter,
		    sortable: true,
		    ready: function(){
		    	//事先展开数据
		        //$("#treegrid").jqxTreeGrid('expandRow', '2');
		    },
		    columns: [
		      { text: '资源名', dataField: 'resourceName', width: averageW },
		      { text: '资源编码', dataField: 'resourceCode', width: averageW },
		      { text: '资源url', dataField: 'resourceUrl', width: averageW },
		      { text: '资源类型', dataField: 'fileName', width: averageW },
		      { text: '序列', dataField: 'rindex', width: averageW }
		    ]
		});
	
		$('#treegrid').on('bindingComplete', function (event) {
			$("#treegrid").jqxTreeGrid().jqxTreeGrid('sortBy', 'rindex', 'asc');
		}); 
		
	}

	function editRes() {
		//判断是否选中一行
		var selection = $("#treegrid").jqxTreeGrid('getSelection')
		if (selection.length == 0) {
			toastr.warning("请选择一行进行修改 !");
		} else {
			//获取行数据
			var rowData = selection[0];
			//给模态框赋值
			$("#uModal").find(':input').each(function(){
				var name = $(this).attr('name');
				if(name!=undefined&&name!=null){
					$(this).val(rowData[name]);
				}
			});
			
			$.post('auth/restree',{date:new Date()},function(result){
		        $('#utreesel').selectpicker({
					type:'tree',
					hiddenInput:true,
					inputName:'parentResId',
					tree:{
						data:result
					}
		        });
		        
	    	});
			
			//给下拉框添加事件
			$('#uresType').selectpicker({
				noneSelectedText: rowData.recordName,
				type:'select',
				hiddenInput:true,
				url:'basisFiles/options?remarlk=ZYLX',
				inputName:'resourceType',
				key:'fileId',
				value:'fileName'
	        });
			$('#uresType').selectpicker('setSelectItem',rowData.recordName);
			//给li标签添加事件
			$("#uModal").modal('show');

		}

	}
</script>
</head>
<body>
	
	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" action="auth/search" class="form-horizontal">
					<div class="form-group" style="margin-top:15px">
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">资源名</label>
						<div class="col-sm-3">
							<input type="text" id="sresName" class="form-control"
								name="rolename" id="txt_search_departmentname">
						</div>
						<label class="control-label col-sm-1" for="txt_search_statu">状态</label>
						<div class="col-sm-3">
							<select id="sresType" class="form-control">
								<option></option>
								<option>菜单</option>
								<option>按钮</option>
							</select>
						</div>
						<div class="col-sm-4" style="text-align:left;">
							<button type="button" id="searchBtn" style="margin-left:50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
			<shiro:hasPermission name="RES:ADD">
				<button id="btn_add" type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="RES:UPDATE">
				<button id="btn_edit" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="RES:DELETE">
				<button id="btn_delete" type="button" class="btn btn-danger">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button>
			</shiro:hasPermission>
		</div>
	</div>
	
	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-body">
				<div id="treegrid"></div>
		    </div>
		</div>
	</div>
	
	<div class="modal fade" id="uModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" id="myModalLabel">修改资源</h4>
	            </div>
	            <div class="modal-body" id="test">
	    <form class="form-horizontal" id="uForm" role="form" action="auth/ures" method="post">
	            		<input type="hidden" id="resourceId" name="resourceId"/>
					  <div class="form-group">
					    <label for="firstname" class="col-sm-2 control-label">资源名</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="resname" name="resourceName" placeholder="请输入资源名">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">资源编码</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="rescode" name="resourceCode" placeholder="请输入资源编码">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">资源URL</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="resurl" name="resourceUrl"  placeholder="请输入资源URL">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">资源类型</label>
					    <div class="col-sm-10">
					      <select id="uresType" class="selectpicker bla bla bli" data-live-search="true">
			  			  </select>
					    </div>
					  </div>
					  <div class="form-group">
							    <label for="lastname" class="col-sm-2 control-label">父类</label>
							    <div class="col-sm-5 col-md-10">
							      <select id="utreesel" class="selectpicker bla bla bli" data-live-search="true">
			  					  </select>
							    </div>
					  </div>
					  
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">优先级</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="rindex" name="rindex" placeholder="请输入资源优先级">
					    </div>
					  </div>
					  
					</form>
					  
	            
	            </div>
	            
	            <div class="modal-footer">
					<button type="button" id="uSubmit" class="btn btn-primary">
						提交更改
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						取消
					</button>
				</div>
	            
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal-dialog -->
	</div>
	
	
	
	<div class="modal fade" id="aResModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" id="myModalLabel">添加资源</h4>
	            </div>
	            <div class="modal-body" id="test">
					<form id="resAddForm" class="form-horizontal" role="form" action="auth/ares" method="post">
			   			<input type="hidden" id="resourceId" name="resourceId"/>
							  <div class="form-group">
							    <label for="firstname" class="col-sm-2 control-label">资源名</label>
							    <div class="col-sm-5 col-md-10">
							      <input type="text" class="form-control" id="resname" name="resourceName" placeholder="请输入资源名">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="lastname" class="col-sm-2 control-label">资源编码</label>
							    <div class="col-sm-5 col-md-10">
							      <input type="text" class="form-control" id="rescode" name="resourceCode" placeholder="请输入资源编码">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="lastname" class="col-sm-2 control-label">资源URL</label>
							    <div class="col-sm-5 col-md-10">
							      <input type="text" class="form-control" id="resurl" name="resourceUrl"  placeholder="请输入资源URL">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="lastname" class="col-sm-2 control-label">资源类型</label>
							    <div class="col-sm-5 col-md-10">
							      <select id="aresType" class="selectpicker bla bla bli" data-live-search="true">
			  					  </select>
							    </div>
							  </div>
							  
							  <div class="form-group">
							    <label for="lastname" class="col-sm-2 control-label">父类</label>
							    <div class="col-sm-5 col-md-10">
							      <select id="treesel" class="selectpicker bla bla bli" data-live-search="true">
			  					  </select>
							    </div>
							  </div>
							  
							  <div class="form-group">
							    <label for="lastname" class="col-sm-2 control-label">优先级</label>
							    <div class="col-sm-5 col-md-10">
							      <input type="text" class="form-control" id="rindex" name="rindex" placeholder="请输入资源优先级">
							    </div>
							  </div>
					</form>	            
	            </div>
	            
	            <div class="modal-footer">
					<button type="button" id="resSub" class="btn btn-primary">
						确认添加
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						取消
					</button>
				</div>
	            
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal-dialog -->
	</div>
	
	
	
</body>
</html>