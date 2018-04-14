<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="${pageContext.request.contextPath}/"></base>
<title id="Description">角色管理</title>
<meta name="description"
	content="This sample demonstrates how we can bind jQWidgets TreeGrid widget to Array Data by using jQWidgets DataAdapter plugin.">
<meta name="viewport"
	content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />
<link rel="stylesheet" href="static/jqxtreegrid/css/jqxbase.css" type="text/css" />
<link rel="stylesheet" href="static/select/bootstrap-select.css" type="text/css" />
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="static/toastr/toastr.css"/>
<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/select/bootstrap-select.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxcore.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxdata.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxbuttons.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxscrollbar.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxdatatable.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxtreegrid.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">

	
	
	/* $('#treegrid').on('rowExpand', function (event) {
		  //获取行对象
	      var row = args.row;
		  //判断是否需要加载子节点
	       if(row.children.length==1){
	    	//异步请求子节点
	    	$.post('auth/roleSubNode',{parentResId:row.roleId},function(data){
			    //添加节点
	    		$("#treeGrid").jqxTreeGrid('addRow', data.roleId, data, 'first', row.roleId);
	    	},'json');   
	    	
	      }
	       
	}); */

	$(document).ready(function () {          
		refreshGrid();
	
		$('#aForm').bootstrapValidator({
			message: '非法数据',
			fields: {
				roleName:{
					validators: {
	                    notEmpty: {
	                        message: '请输入角色名'
	                    }
	                }
				},
				roleCode:{
					validators: {
	                    notEmpty: {
	                        message: '请输入角色编码'
	                    }
	                }
				},
				roleTypeName:{
					validators: {
	                    notEmpty: {
	                        message: '请输入角色类型'
	                    }
	                }
				}
			}
			
		});
		
		
		$('#btn_add').click(function(){
			addRes();
		});
		
		$('#btn_edit').click(function(){
			editRes();
		});
		
		$('#btn_delete').click(function(){
			var selection = $("#treegrid").jqxTreeGrid('getSelection');
			if(selection.length==0){
				toastr.warning('请选择一行');
			}else{
				$.post('auth/delrole',{roleId:selection[0].roleId},function(data){
					if(data.status=='success'){
						toastr.success("删除成功");
						refreshGrid();
					}else{
						toastr.error("删除失败");
					}
				});
			}
			
			
		});
			
		
		$('#aSubmit').click(function(){
			var options = {
					url:'auth/arole',
					beforeSubmit:function(){
						$('#aForm').data('bootstrapValidator').isValid();
						var result = $('#aForm').data('bootstrapValidator').validate();
						if(!result){
							toastr.warning("数据不合法");
							return false;
						}
						return true;
					},
					success:function(data){
						$('#aModal').modal('hide');
						if(data.status=='success'){
							toastr.success("添加成功");
							refreshGrid();
						}else{
							toastr.error("添加失败");
						}
					}
			};
			
			$('#aForm').ajaxSubmit(options);
		});
		
		
		$("#uSubmit").click(function(){
			var options = {
					url:'auth/urole',
					beforeSubmit:function(){
						/* $('#aForm').data('bootstrapValidator').isValid();
						var result = $('#aForm').data('bootstrapValidator').validate();
						if(!result){
							toastr.warning("数据不合法");
							return false;
						} */
						return true;
					},
					success:function(data){
						$('#uModal').modal('hide');
						if(data.status=='success'){
							toastr.success("修改成功");
							refreshGrid();
						}else{
							toastr.error("修改失败");
						}
					}
			};
			
			$('#uForm').ajaxSubmit(options);
			
		});
		
		
		
		
		
		
	});
		
	function refreshGrid(){
	
		var source =
		{
		    dataType: "json",
		    dataFields: [
		        { name: 'roleId', type: 'string' },
		        { name: 'roleName', type: 'string' },
		        { name: 'roleCode', type: 'string' },
		        { name: 'roleTypeId', type: 'string' },
		        { name: 'roleTypeName', type: 'string' }
		    ],
		    hierarchy:
		    {
		        keyDataField: { name: 'roleId' },
		        parentDataField: { name: 'roleTypeId' }
		    },
		    id: 'roleId',
		    url:'auth/allrole'
		};
	
		var dataAdapter = new $.jqx.dataAdapter(source);
		// create Tree Grid
		var averageW=parseInt($("#treegrid").width()/3);//定义表格树每列的宽度
		$("#treegrid").jqxTreeGrid(
		{
		   	width:  $("#treegrid").width(),
		   	pageSize: 20,
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
		      { text: '角色名', dataField: 'roleName', width: averageW },
		      { text: '角色编码', dataField: 'roleCode', width: averageW },
		      { text: '角色类型名', dataField: 'roleTypeName', width: averageW }
		    ]
		});
		
	}
	
	count=0;
	
	function addRes(){
		$('.rolesel').selectpicker({
            'selectedText': 'cat',
			type:'select',
			hiddenInput:true,
			url:'basisFiles/options?remarlk=DWLX',
			inputName:'roleTypeId',
			key:'fileId',
			value:'fileName'
        });
		
		$("#aModal").modal("show");
	}
	
	function editRes(){
		//判断是否选中一行
		var selection = $("#treegrid").jqxTreeGrid('getSelection');
		
		
		if(selection.length==0){
			toastr.warning("请选择一行");
		}else{
			
			if(selection[0].roleCode==null){
				return ;
			}
			
			
			
			//获取行数据
			var rowData=selection[0];
			//给模态框赋值
			$("#uModal").find(':input').each(function(){
				var name = $(this).attr('name');
				if(name!=undefined&&name!=null){
					$(this).val(rowData[name]);
				}
			});
			
			$('.rolesel').selectpicker({
	            noneSelectedText: rowData.roleTypeName,
				type:'select',
				hiddenInput:true,
				url:'basisFiles/options?remarlk=DWLX',
				inputName:'roleTypeId',
				key:'fileId',
				value:'fileName'
	        });
			
			$('.rolesel').selectpicker('setSelectItem',rowData.roleTypeName);
			
			
			
			
			//给下拉框添加事件
			//给li标签添加事件
			$("#uModal").modal('show');
			
			
		}
		
		
	}
	
	
	
    </script>
</head>
<body class='default'>

	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse" data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top:15px">
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">角色名</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								id="txt_search_departmentname" name="roleName"/>
						</div>
						<label class="control-label col-sm-1" for="txt_search_statu">角色类型</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="txt_search_statu" name="roleTypeName"/>
						</div>
						<div class="col-sm-4" style="text-align:left;">
							<button type="button" style="margin-left:50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
			<shiro:hasPermission name="ROLE:ADD">
				<button id="btn_add" type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="ROLE:UPDATE">
				<button id="btn_edit" type="button" class="btn btn-info">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="ROLE:DELETE">
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
	    <form class="form-horizontal" id="uForm" role="form" method="post">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" id="myModalLabel">修改角色</h4>
	            </div>
	            <input type="hidden" required id="uroleId" name="roleId"/>
	            <div class="modal-body" id="test">
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">角色名</label>
					    <div class="col-sm-10">
					      <input type="text" required class="form-control" id="roleName" name="roleName" placeholder="请输入角色名">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">角色编码</label>
					    <div class="col-sm-10">
					      <input type="text" required class="form-control" id="roleCode" name="roleCode"  placeholder="请输入角色编码">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">角色类型</label>
					    <div class="col-sm-10">
					      <select id="roleType" class="rolesel selectpicker bla bla bli" name="roleTypeName" data-live-search="true">
						  </select>
					    </div>
					  </div>
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
		</form>
	</div>
	
	
	<div class="modal fade" id="aModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <form class="form-horizontal" id="aForm" role="form" action="auth/ares" method="post">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" id="myModalLabel">添加角色</h4>
	            </div>
	            
	            <div class="modal-body" id="test">
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">角色名</label>
					    <div class="col-sm-10">
					      <input type="text" required class="form-control" id="roleName" name="roleName" placeholder="请输入角色名">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">角色编码</label>
					    <div class="col-sm-10">
					      <input type="text" required class="form-control" id="roleCode" name="roleCode"  placeholder="请输入角色编码">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">角色类型</label>
					    <div class="col-sm-10" >
					      <select name="roleTypeName" class="rolesel selectpicker bla bla bli" data-live-search="true">
						  </select>
					    </div>
					  </div>
					  
	            </div>
	            
	            <div class="modal-footer">
					<button type="button" id="aSubmit" class="btn btn-primary">
						提交更改
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						取消
					</button>
				</div>
	            
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal-dialog -->
		</form>
	</div>
	
	
	<script type="text/javascript">
	
	</script>
	
	
	
	
	
</body>
</html>