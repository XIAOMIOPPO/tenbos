<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>授权</title>
<link rel="stylesheet" href="static/jqxtreegrid/css/jqxbase.css" type="text/css" />
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css" />

<link rel="stylesheet" type="text/css" href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="static/toastr/toastr.css"/>

<style>
.dbselect{
	background:#e4efc9 !important;
}

</style>

<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript" src="static/toastr/toastr.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxcore.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxdata.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxbuttons.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxscrollbar.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxdatatable.js"></script>
<script type="text/javascript" src="static/jqxtreegrid/js/jqxtreegrid.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>

<script type="text/javascript">
	
	$(document).ready(function () { 
		
		
		$('#role_usersearch').click(function (){
			  var opt = {
			    url: "user/listUser",
			    silent: true,
			    query:{      
			    	type:1,
			        level:2,
			        storageinId : $('#userName').val(),
				  	offset:0,
				  	limit:20
			    }
			  };
			  $('#tb_user').bootstrapTable('refresh', opt);
		});
		
		
		var rolesource =
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
		var roledataAdapter = new $.jqx.dataAdapter(rolesource);
		// create Tree Grid
		var averageW=parseInt($("#roletreegrid").width()/3);//定义表格树每列的宽度
		$("#roletreegrid").jqxTreeGrid(
		{
		   	width:  $("#roletreegrid").width(),
		   	pageSize: 10,
		   	pageSizeOptions: ['15', '20', '30'],
		   	pageable:true,
		   	pagerPosition:'bottom',
		    source: roledataAdapter,
		    sortable: true,
		    checkboxes:true,
		    hierarchicalCheckboxes: true,
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
		
		
		
		$('#tb_user').bootstrapTable({
			url : 'user/listUser', //请求后台的URL（*） 
			method : 'post', //请求方式（*） 
			striped : true, //是否显示行间隔色 
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
			pagination : true, //是否显示分页（*） 
			sortable : false, //是否启用排序 
			sortOrder : "asc", //排序方式
			striped : true,
			queryParams : function(params){
				var temp = {
					limit : params.limit, //页面大小 
					offset : params.offset, //页码 
				};
				return temp;
			},//传递参数（*） 
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
			pageNumber : 1, //初始化加载第一页，默认第一页 
			pageSize : 8, //每页的记录行数（*） 
			pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
			//search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
			strictSearch : true,
			//showColumns : true, //是否显示所有的列 
			//showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行 
			height : 450, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
			uniqueId : "userId", //每一行的唯一标识，一般为主键列 
			//showToggle : true, //是否显示详细视图和列表视图的切换按钮 
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'userName',
				title : '用户姓名'
			}, {
				field : 'phoneNum',
				title : '电话'
			}],
			onDblClickRow:function(row, $element){
				//异步请求数据
				$element.parent().find('.dbselect').removeClass('dbselect');
				$element.addClass('dbselect');
				$.post('auth/rolebyuid',{userId:row.userId},function(data){
					var ids = [];
					for(var i=0;i<data.length;i++){
						ids.push(data[i].roleId);
					}
					showSelected($("#roletreegrid"),ids);
				});
			}
		});
		
		
		$('#role_search').click(function(){
			var roleName=$("#roleName").val();
			var roleType=$("#roleType").val();
			
			//清除过滤器
			$("#roletreegrid").jqxTreeGrid('clearFilters');
			var filtertype = 'stringfilter';
		    // 创建一个过滤器组
		    var filtergroup = new $.jqx.filter();
		    var filter_or_operator = 1;
		    var filtercondition = 'equal';
			if(roleName!=''){
		      var filtervalue = roleName;
		      var filter = filtergroup.createfilter(filtertype, filtervalue, filtercondition);
		      filtergroup.addfilter(filter_or_operator, filter);
			  //添加过滤器
		      $("#roletreegrid").jqxTreeGrid('addFilter', 'roleName', filtergroup);
					
			}
				
			if(roleType!=''){
			   var filtervalue = roleType;
			   var filter = filtergroup.createfilter(filtertype, filtervalue, filtercondition);
			   filtergroup.addfilter(filter_or_operator, filter);
			   //添加过滤器
			   $("#roletreegrid").jqxTreeGrid('addFilter', 'roleTypeName', filtergroup);
			}
				
			//应用过滤器
		    $("#roletreegrid").jqxTreeGrid('applyFilters');
		});
		
		
		
		/* $('#roletreegrid').on('rowCheck', function (event) {
		      var args = event.args;
		      var row = args.row;
		      if(row.records){
				  $("#roletreegrid").jqxTreeGrid('checkRows',null,row);
				  $("#roletreegrid").jqxTreeGrid('render');
		      }
		  }); */
		      /* var records = row.records;
		      var length=records.length;
		      var ids=[];
		      for(var i=0;i<length;i++){
		    	  var id = records[i].roleId;
		    	  ids.push(id);
		      }
		      
		      console.log(ids);
		      var treegrid=$("#roletreegrid");
		      for(var i=0;i<ids.length;i++){
		    	  treegrid.jqxTreeGrid('checkRow',ids[i],false,'tree');
		      } */
		
		/* $('#roletreegrid').on('rowUncheck', function (event) {
			var args = event.args;
		    var row = args.row;
		    if(row.records){
			    var records = row.records;
			    var treegrid=$("#roletreegrid");
			    for(var i=0;i<records.length;i++){
			    	console.log(records[i]);
			    	$("#roletreegrid").jqxTreeGrid('myuncheckRow',records[i].roleId,false,'tree');
			    }
			    $("#roletreegrid").jqxTreeGrid('render');
		    }else{
		    	if(row.parent){
		    		$("#roletreegrid").jqxTreeGrid('uncheckRow',row.parent.roleId);
		    	}
		    }
		}); */
		
		count=0;
		
		$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
			// 获取已激活的标签页的名称
			var activeTab = $(e.target).text().trim(); 
			if(activeTab=='角色授权'&&count==0){
				createTreeGrid();
				createResGrid();
				count+=1;
			}
		});
		
		
		
		$('#res_role_search').click(function(){
			var roleName=$("#res_roleName").val();
			var roleType=$("#res_roleType").val();
			
			//清除过滤器
			$("#res_roletreegrid").jqxTreeGrid('clearFilters');
			var filtertype = 'stringfilter';
		    // 创建一个过滤器组
		    var filtergroup = new $.jqx.filter();
		    var filter_or_operator = 1;
		    var filtercondition = 'CONTAINS';
			if(roleName!=''){
		      var filtervalue = roleName;
		      var filter = filtergroup.createfilter(filtertype, filtervalue, filtercondition);
		      filtergroup.addfilter(filter_or_operator, filter);
			  //添加过滤器
		      $("#res_roletreegrid").jqxTreeGrid('addFilter', 'roleName', filtergroup);
					
			}
				
			if(roleType!=''){
			   var filtervalue = roleType;
			   var filter = filtergroup.createfilter(filtertype, filtervalue, filtercondition);
			   filtergroup.addfilter(filter_or_operator, filter);
			   //添加过滤器
			   $("#res_roletreegrid").jqxTreeGrid('addFilter', 'roleTypeName', filtergroup);
			}
				
			//应用过滤器
		    $("#res_roletreegrid").jqxTreeGrid('applyFilters');
		});
		
		
		$('#res_search').click(function(){
			var resName=$("#resName").val();
			var resType=$("#resType").val();
			
			//清除过滤器
			$("#restreegrid").jqxTreeGrid('clearFilters');
			var filtertype = 'stringfilter';
		    // 创建一个过滤器组
		    var filtergroup = new $.jqx.filter();
		    var filter_or_operator = 1;
		    var filtercondition = 'CONTAINS';
			if(roleName!=''){
		      var filtervalue = resName;
		      var filter = filtergroup.createfilter(filtertype, filtervalue, filtercondition);
		      filtergroup.addfilter(filter_or_operator, filter);
			  //添加过滤器
		      $("#restreegrid").jqxTreeGrid('addFilter', 'resourceName', filtergroup);
					
			}
				
			if(roleType!=''){
			   var filtervalue = resType;
			   var filter = filtergroup.createfilter(filtertype, filtervalue, filtercondition);
			   filtergroup.addfilter(filter_or_operator, filter);
			   //添加过滤器
			   $("#restreegrid").jqxTreeGrid('addFilter', 'resourceType', filtergroup);
			}
				
			//应用过滤器
		    $("#restreegrid").jqxTreeGrid('applyFilters');
		});
		
		
		$('#user_role_sub').click(function(){
			//获取用户表格选择的数据
			var userSelect = $('#tb_user').bootstrapTable('getSelections');
			var roleSelect = $('#roletreegrid').jqxTreeGrid('getCheckedRows');
			
			if(userSelect.length==0){
				toastr.warning('请至少选择一个用户');
				return;
			}
			
			if(roleSelect.length==0){
				toastr.warning('至少选择一个角色');
				return;
			}
			
			//筛选角色数据
			var filterRoleSelect = new Array();
			for(var i=0;i<roleSelect.length;i++){
				if(roleSelect[i].parent!=null){
					filterRoleSelect.push(roleSelect[i].roleId);
				}
			}
			
			var filterUserSelect = new Array();
			for(var i=0;i<userSelect.length;i++){
				filterUserSelect.push(userSelect[i].userId);
			}
			
			//同步数据库
			$.post('auth/auserole',{userId:filterUserSelect,roleId:filterRoleSelect},function(data){
				if(data.status=='success'){
					toastr.success('授权成功');
				}else{
					toastr.success('授权失败');
				}
			});
			
			
			
			
		});
		
		
		
		$('#res_role_sub').click(function(){
			var roleSelect = $('#res_roletreegrid').jqxTreeGrid('getCheckedRows');
			var resSelect = $('#restreegrid').jqxTreeGrid('getCheckedRows');
			
			if(resSelect.length==0){
				toastr.warning('请至少选择一个资源!');
				return;
			}
			
			if(roleSelect.length==0){
				toastr.warning('至少选择一个角色!');
				return;
			}
			
			//筛选角色数据
			var filterRoleSelect = new Array();
			for(var i=0;i<roleSelect.length;i++){
				if(roleSelect[i].parent!=null){
					filterRoleSelect.push(roleSelect[i].roleId);
				}
			}
			
			
			var filterResSelect = new Array();
			for(var i=0;i<resSelect.length;i++){
				if(resSelect[i].parent!=null){
					filterResSelect.push(resSelect[i].resourceId);
				}
				
			}
			
			
			
			
			//同步数据库
			$.post('auth/aresrole',{resId:filterResSelect,roleId:filterRoleSelect},function(data){
				if(data.status=='success'){
					toastr.success('授权成功');
				}else{
					toastr.success('授权失败');
				}
			});
			
			
			
			
		});
		
		
		
		
		
	});
		
		
	function createTreeGrid(){
		
		var rolesource =
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
		var roledataAdapter = new $.jqx.dataAdapter(rolesource);
		// create Tree Grid
		var averageW=parseInt($("#roletreegrid").width()/3);//定义表格树每列的宽度
		
		$("#res_roletreegrid").jqxTreeGrid(
				{
				   	width:  $("#res_roletreegrid").width(),
				   	pageSize: 10,
				   	pageSizeOptions: ['15', '20', '30'],
				   	pageable:true,
				   	pagerPosition:'bottom',
				    source: roledataAdapter,
				    sortable: true,
				    checkboxes:true,
				    hierarchicalCheckboxes: true,
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
		
		
		$("#res_roletreegrid").on('rowDoubleClick',function(event){
			var args = event.args; 
			var row = args.row;
			var rows = $("#res_roletreegrid").jqxTreeGrid('getRows');
			//取消所有被选中的行
			cancelAllCheck(rows,$("#res_roletreegrid"));
			//选中当前行
			$("#res_roletreegrid").jqxTreeGrid('checkRow',row.uid);
			//请求数据
			$.post('auth/resbyroleid',{roleId:row.roleId},function(data){
				var ids = [];
				for(var i=0;i<data.length;i++){
					ids.push(data[i].resourceId);
				}
				showSelected($("#restreegrid"),ids);
			});
			
			
			
		});
		
		
		
		
		
	}
	
	
	function createResGrid(){
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
		    id: 'resourceId',
		    url:'auth/allres'
		};
		var dataAdapter = new $.jqx.dataAdapter(source);
		var averageW=parseInt($("#restreegrid").width()/3);//定义表格树每列的宽度
		$("#restreegrid").jqxTreeGrid(
		{
		   	width:  $("#restreegrid").width(),
		   	pageSize: 15,
		   	pageSizeOptions: ['15', '20', '30'],
		   	pageable:true,
		   	pagerPosition:'bottom',
		    source: dataAdapter,
		    checkboxes:true,
		    sortable: true,
		    hierarchicalCheckboxes: true,
		    ready: function(){
		    	//事先展开数据
		        //$("#treegrid").jqxTreeGrid('expandRow', '2');
		    },
		    columns: [
		      { text: '资源名', dataField: 'resourceName', width: averageW },
		      { text: '资源编码', dataField: 'resourceCode', width: averageW },
		      { text: '资源类型', dataField: 'fileName', width: averageW }
		    ]
		});
	}
	
	
	
	function showSelected(targetObj,dataList){
		
		//取消所有选中节点
		var rows = targetObj.jqxTreeGrid('getRows');
		cancelAllCheck(rows,targetObj);
		//勾选目标值
		for(var i=0;i<dataList.length;i++){
			targetObj.jqxTreeGrid('mycheckRow',dataList[i],true,'tree');
		}
		rows = targetObj.jqxTreeGrid('getRows');
		for(var i=0;i<rows.length;i++){
			if(rows[i].records){
				if(isAllSelect(rows[i].records)){
					targetObj.jqxTreeGrid('mycheckRow',rows[i].uid,true,'tree');
				}
			}
		}
		//重新渲染grid
		targetObj.jqxTreeGrid('render');
		
	}
	
	
   /**
	* 判断是否全部选中
	*/
	function isAllSelect(data){
		for(var i=0;i<data.length;i++){
			if(!data[i].checked){
				return false;
			}
		}
		
		return true;
	}
	
   /**
	* 清除所有已选择的复选框
	*/
	function cancelAllCheck(data,target){
		for(var i=0;i<data.length;i++){
			if(data[i].records==undefined){
				target.jqxTreeGrid('myuncheckRow',data[i].uid,false,'tree');
			}else{
				target.jqxTreeGrid('myuncheckRow',data[i].uid,false,'tree');
				cancelAllCheck(data[i].records,target);
			}
		}
	}
	
	
	
</script>

</head>
<body>

	<div class="panel-body">
		<div class="panel panel-default">
			<div class="panel-body">
				
				<ul id="myTab" class="nav nav-tabs">
				    <li class="active">
				        <a href="#role" data-toggle="tab">
				                               用户角色
				        </a>
				    </li>
				    <li>
				    	<a href="#res" data-toggle="tab">
				    		角色授权
						</a>
					</li>
				</ul>
				<div id="myTabContent" class="tab-content">
				    <div class="tab-pane fade in active" id="role">
				       <div class="row" style="padding:20px">
				       		<div class="col-md-12">
					       	   <button class="btn btn-primary pull-right" id="user_role_sub">提交</button>
				       		</div>
				       </div>
				       <div class="row">
				       
					       <div class="col-md-6" >
					       		<div class="row" style="margin-bottom:20px">
						       	   <form role="form">
						       	   	<div class="form-group">
								    <div class="col-sm-4">
								      <input type="text" class="form-control" id="userName" placeholder="请输入姓">
								    </div>
								    <div class="col-sm-4">
								      <input type="text" class="form-control" id="org" placeholder="所属单位">
								    </div>
								    <div class="col-sm-4">
							       	  <button class="btn btn-primary" id="role_usersearch">查询</button>
								    </div>
								    </div>
						       	   </form>
					       		</div>
							       <table id="tb_user"></table>
					       </div>
					    
					       
					       <div class="col-md-6">
					       		<div class="row" style="margin-bottom:20px">
						       	   <form role="form" onsubmit="return false">
						       	   	<div class="form-group">
								    <div class="col-sm-4">
								      <input type="text" class="form-control" id="roleName" placeholder="角色名"/>
								    </div>
								    <div class="col-sm-4">
								      <input type="text" class="form-control" id="roleType" placeholder="角色类型"/>
								    </div>
								    <div class="col-sm-4">
							       	  <button class="btn btn-primary" id="role_search">查询</button>
								    </div>
								    </div>
						       	   </form>
					       		</div>
						       <div id="roletreegrid"></div>
					       </div>
				       
				       </div>
				       
				    </div>
				    
				    <div class="tab-pane fade" id="res">
				       <div class="row" style="padding:20px">
				       		<div class="col-md-12">
					       	   <button class="btn btn-primary pull-right" id="res_role_sub">提交</button>
				       		</div>
				       </div>
				       <div class="row">
					       <div class="col-md-6" >
								<div class="row" style="margin-bottom:20px">
						       	   <form role="form" onsubmit="return false">
						       	   	<div class="form-group">
								    <div class="col-sm-4">
								      <input type="text" class="form-control" id="res_roleName" placeholder="角色名"/>
								    </div>
								    <div class="col-sm-4">
								      <input type="text" class="form-control" id="res_roleType" placeholder="角色类型"/>
								    </div>
								    <div class="col-sm-4">
							       	  <button class="btn btn-primary" id="res_role_search">查询</button>
								    </div>
								    </div>
						       	   </form>
					       		</div>					       
						       <div id="res_roletreegrid"></div>
					       </div>
					       
					      
					       <div class="col-md-6">
					       <div class="row" style="margin-bottom:20px">
						       	   <form role="form" onsubmit="return false">
						       	   	<div class="form-group">
								    <div class="col-sm-4">
								      <input type="text" class="form-control" id="resName" placeholder="资源名"/>
								    </div>
								    <div class="col-sm-4">
								      <input type="text" class="form-control" id="resType" placeholder="资源类型"/>
								    </div>
								    <div class="col-sm-4">
							       	  <button class="btn btn-primary" id="res_search">查询</button>
								    </div>
								    </div>
						       	   </form>
					       		</div>
						       <div id="restreegrid"></div>
					       </div>
				       
				       </div>
				       
				    </div>
				</div>
				
				
				
				
		    </div>
		</div>
	</div>

</body>
</html>