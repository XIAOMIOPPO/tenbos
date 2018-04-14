<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>返货</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">




<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/bootstrap-3.3.7-dist/css/bootstrapValidator.min.css"
	rel="stylesheet">
<link href="static/toastr/toastr.css" rel="stylesheet">
<link
	href="static/bootstrap-3.3.7-dist/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/toastr/toastr.js"></script>
<script src="static/jquery.form.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.7-dist/js/bootstrap-datetimepicker.fr.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootbox.js"></script>
</head>

<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-heading" data-toggle="collapse"
				data-target="#searchbody">查询条件</div>
			<div class="panel-body collapse fade" id="searchbody">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">录入人</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="entryPerson1"/>
						</div>
						<label class="control-label col-sm-1 input-append date "
							for="txt_search_statu" id="datetimepicker" data-date="12-02-2012"
							data-date-format="dd-mm-yyyy">录入日期</label>
						<div class="col-sm-4 ">
							<div class="col-sm-5">
								<input type="text" size="16" class=" form-control time "
									id="lowinputTime" />
							</div>
							<span class="col-lg-1">至</span>
							<div class="col-sm-5">
								<input type="text"  class=" form-control time" id="highinputTime"/>
							</div>
						</div>
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">处理状态</label>
						<div class="col-sm-2">
							<select class="form-control" id="status1" name="">
								<option value="1">未确认</option>
								<option value="2">同意返货</option>
								<option value="3">拒绝</option>
								<option value="4">同意转发</option>
							</select>
						</div>
					</div>
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1" for="txt_search_statu">录入单位</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="inputUnit1"/>
						</div>
						<label class="control-label col-sm-1" for="txt_search_statu">返货单位</label>
						<div class="col-sm-2">
							<!-- <select class="form-control" id="returningUnit1" name="">
								<option value="1">未确认</option>
							</select> -->
							<input type="text" class="form-control" id="returningUnit1"/>
						</div>
						<label class="control-label col-sm-1" for="txt_search_statu">返货类型</label>
						<div class="col-sm-2">
							<select class="form-control" id="cargoType1" name="">
								<option>整票返货</option>
								<option>全部签收</option>
							</select>
						</div>
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">返货状态</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="statusGoogs1"/>
						</div>
					</div>
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1" for="txt_search_statu">接收单位</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="receiver1"/>
						</div>
						<!-- <div class="col-sm-1">
							<input type="checkbox" id="phone1"><span>含下级</span>
						</div> -->
							<label class="control-label col-sm-1" for="txt_search_statu">做废</label>
						<div class="col-sm-1">
							<select class="form-control" id="c_invalidSign" name="n_invalidSign">
							    <option value="1">否</option>
							    <option value="0">是</option>
							</select>
						</div>
						<div class="col-sm-1">
							<input type="checkbox" id="phone1"><span>含下级</span>
						</div>
						<div class="col-sm-2" style="text-align: left;">
							<button type="button" style="margin-left: 50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="toolbar" class="btn-group">
		<shiro:hasPermission name="FHSQ:ADD"> 
			<button id="btn_add" type="button" class="btn btn-success">
				<span class=" glyphicon glyphicon-plus" aria-hidden="true"></span>增加
			</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="FHSQ:UPDATE"> 
			<button id="btn_edit" type="button" class="btn btn-primary">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
		 </shiro:hasPermission> 
		 <shiro:hasPermission name="FHSQ:DELETE">	 
			<button id="btn_delete" type="button" class="btn btn-danger">
				<span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>作废
			</button>
		 </shiro:hasPermission> 
		</div>
		<table id="tb_departments"></table>
	</div>
	
	
	
<div class="modal fade" id="addApply">  
            <div class="modal-dialog">    
              <div class="modal-content">    
                <div class="modal-header">添加</div>    
                <form class="form-horizontal" role="form" id="addapply">
                    <fieldset>
                       <div class="form-group">
                        <div class="rowGroup">
                          <label class="col-sm-2 control-label" for="a_applicationNo">客户电话</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="clientphone" name="clientphone" type="text" />
                          </div>
                          </div> 
                          <div class="rowGroup">
                          <label class="col-sm-2 control-label" for="a_jobNo">工作单号</label>
                          <div class="col-sm-4">
                             <select class="form-control" id="a_jobNo" name="jobNo">
							   
						     </select>
                             <!-- <input class="form-control" id="a_jobNo" name="jobNo" type="text" placeholder="工作单号"/> -->
                          </div>
                          </div>
                            <div class="rowGroup">
                          <label class="col-sm-2 control-label" for="a_cargoType">返货类型</label>
                          <div class="col-sm-4">
                          <select class="form-control" id="a_cargoType" name="cargoType">
							    <option>整票返货</option>
								<option>全部签收</option>
						</select>
						 </div>
						    </div>
                       </div>
                       <div class="form-group">
                          
						    <div class="rowGroup">
                          <label class="col-sm-2 control-label" for="a_piecesNumber">破损丢失件数</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="a_piecesNumber" name="piecesNumber" type="text" placeholder="破损丢失件数"/>
                          </div>
                           </div>
                            <div class="rowGroup">
                           <label class="col-sm-2 control-label" for="a_receiver">接收单位</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="a_receiver" name="receiver" type="text" placeholder="接收单位"/>
                          </div>
                          </div>
                       </div>
                    </fieldset>     
                   <!--  <fieldset>
                        <div class="form-group">
                              <div class="rowGroup">
                            <label class="col-sm-2 control-label" for="a_enrat">进港时间</label>
                          <div class="col-sm-4">
                             <input class="form-control time" id="a_enrat" name="enrat" type="text" placeholder="进港时间"/>
                          </div>
                          </div>
                           
                        </div>
                   </fieldset> -->
                    
                <!--  <fieldset>
                        <div class="form-group">
                          <div class="rowGroup">
                             <label class="col-sm-2 control-label" for="a_invalidSign">作废标志</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="a_invalidSign"name="invalidSign" type="text" placeholder="作废标志"/>
                          </div>
                          </div>
                            <div class="rowGroup">
                            <label class="col-sm-2 control-label" for="a_returningUnit">返货单位</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="a_returningUnit" name="returningUnit" type="text" placeholder="返货单位"/>
                          </div>
                          
                        </div>
                        </div>
                </fieldset> -->
                 <fieldset>
                        <div class="form-group">
                          <!-- <div class="rowGroup">
                             <label class="col-sm-2 control-label" for="a_inputTime">录入时间</label>
                          <div class="col-sm-4">
                             <input class="form-control time" id="a_inputTime" name="inputTime" type="text" placeholder="录入时间"/>
                          </div>
                          </div> -->
                    <!--         <div class="rowGroup">
                            <label class="col-sm-2 control-label" for="a_inputUnit">录入单位</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="a_inputUnit" name="inputUnit" type="text" placeholder="录入单位"/>
                          </div>
                          </div> -->
                           <div class="rowGroup">
                            <label class="col-sm-2 control-label" for="a_status">返货处理状态</label>
                          <div class="col-sm-4">
                            <select class="form-control" id="a_status" name="status">
                                <option value="1">未确认</option>
								<option value="2">同意返货</option>
								<option value="3">拒绝</option>
								<option value="4">同意转发</option>
                            </select>
                          </div>
                          </div>
                        </div>
                </fieldset>
                 <!-- <fieldset>
                        <div class="form-group">
                          <div class="rowGroup">
                             <label class="col-sm-2 control-label" for="a_entryPerson">录入人</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="a_entryPerson" name="entryPerson" type="text" placeholder="录入人"/>
                          </div>
                          </div>
                            <div class="rowGroup">
                            <label class="col-sm-2 control-label" for="a_acknowledgindUnit">确认单位</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="a_acknowledgindUnit"name="acknowledgindUnit" type="text" placeholder="确认单位"/>
                          </div>
                          </div>
                        </div>
                </fieldset> -->
               <!--   <fieldset>
                        <div class="form-group">
                          <div class="rowGroup">
                             <label class="col-sm-2 control-label" for="a_verifier">确认人</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="a_verifier" name="verifier" type="text" placeholder="确认人"/>
                          </div>
                          </div>
                           
                        </div>
                </fieldset> -->
                 <fieldset>
                        <div class="form-group">
                          <div class="rowGroup">
                             <label class="col-sm-2 control-label" for="a_statusGoogs">返货执行状态</label>
                          <div class="col-sm-4">
                             <select class="form-control" id="a_statusGoogs" name="statusGoogs">
                                <option value="1">未执行</option>
								<option value="2">已返货</option>
								<option value="3">已转发</option>
                            </select>
                          </div>
                          </div>
                          <div class="rowGroup">
                             <label class="col-sm-2 control-label" for="a_handlingSuggestion">处理意见</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="a_handlingSuggestion" name="handlingSuggestion" type="text" placeholder="处理意见"/>
                          </div>
                          </div>
                          </div>
                </fieldset>
                <fieldset>
                        <div class="form-group">
                          
                            <div class="rowGroup">
                            <label class="col-sm-2 control-label" for="a_typeofRejection">拒绝类型</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="a_typeofRejection" name="typeofRejection" type="text" placeholder="拒绝类型"/>
                          </div>
                          </div>
                        </div>
                </fieldset>
                </form>    
                <div class="modal-footer">    
                  <button class="btn btn-primary" id="addsup" type="button">提交</button>       
                  <button class="btn btn-info" data-dismiss="modal">退出</button>    
                </div>    
              </div>    
            </div>    
          </div>
<div class="modal fade" id="deitApply">  
            <div class="modal-dialog">    
              <div class="modal-content">    
                <div class="modal-header">修改</div>    
                <form class="form-horizontal" role="form">
                    <fieldset>
                       <div class="form-group">
                       <input type="hidden" id="t_applicationId" name="t_applicationId"/>
                          <label class="col-sm-2 control-label" for="t_applicationNo">申请单号</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_applicationNo" name="applicationNo" type="text" disabled placeholder="申请单号"/>
                          </div>
                          <label class="col-sm-2 control-label" for="t_jobNo">工作单号</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_jobNo" name="jobNo" type="text" disabled placeholder="msh"/>
                          </div>
                       </div>
                       <div class="form-group">
                          <label class="col-sm-2 control-label" for="t_cargoType">返货类型</label>
                          <div class="col-sm-4">
                          	<select class="form-control" id="t_cargoType" name="cargoType">
								<option>整票返货</option>
								<option>全部签收</option>
						  	</select>
                          </div>
                          <label class="col-sm-2 control-label" for="t_piecesNumber">破损丢失件数</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_piecesNumber" name="piecesNumber" type="text" placeholder="123456"/>
                          </div>
                       </div>
                    </fieldset>     
                    <fieldset>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="t_enrat">进港时间</label>
                          <div class="col-sm-4">
                             <input class="form-control Time" id="t_enrat" disabled name="enrat" type="text" placeholder="123456"/>
                          </div>
                           <label class="col-sm-2 control-label" for="t_receiver">接收单位</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_receiver"name="receiver" disabled type="text" placeholder="123456"/>
                          </div>
                        </div>
                   </fieldset>
                    
                 <fieldset>
                        <div class="form-group">
                             <label class="col-sm-2 control-label" for="t_invalidSign">作废标志</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_invalidSign" name="invalidSign" type="text" placeholder="123456" disabled/>
                          </div>
                            <label class="col-sm-2 control-label" for="t_returningUnit">返货单位</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_returningUnit" name="returningUnit" type="text" placeholder="返货单位"/>
                          </div>
                        </div>
                </fieldset>
                 <fieldset>
                        <div class="form-group">
                             <label class="col-sm-2 control-label" for="t_inputTime">录入时间</label>
                          <div class="col-sm-4">
                             <input class="form-control Time" id="t_inputTime" name="inputTime" disabled type="text" placeholder="录入时间"/>
                          </div>
                            <label class="col-sm-2 control-label" for="t_inputUnit">录入单位</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_inputUnit" name="inputUnit" disabled type="text" placeholder="录入单位"/>
                          </div>
                        </div>
                </fieldset>
                 <fieldset>
                        <div class="form-group">
                             <label class="col-sm-2 control-label" for="t_entryPerson">录入人</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_entryPerson" name="entryPerson" disabled type="text" placeholder="录入人"/>
                          </div>
                            <label class="col-sm-2 control-label" for="t_acknowledgindUnit">确认单位</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_acknowledgindUnit" name="acknowledgindUnit" disabled type="text" placeholder="确认单位"/>
                          </div>
                        </div>
                </fieldset>
                 <fieldset>
                        <div class="form-group">
                             <label class="col-sm-2 control-label" for="t_verifier">确认人</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_verifier" name="verifier" disabled type="text" placeholder="确认人"/>
                          </div>
                            <label class="col-sm-2 control-label" for="t_status">返货处理状态</label>
                          <div class="col-sm-4">
                            <select class="form-control" id="t_status" name="status">
                                <option value="1">未确认</option>
								<option value="2">同意返货</option>
								<option value="3">拒绝</option>
								<option value="4">同意转发</option>
                            </select>
                          </div>
                        </div>
                </fieldset>
                 <fieldset>
                        <div class="form-group">
                             <label class="col-sm-2 control-label" for="t_statusGoogs">返货执行状态</label>
                          <div class="col-sm-4">
                             <select class="form-control" id="t_statusGoogs" disabled name="statusGoogs">
                                <option value="1">未执行</option>
								<option value="2">已返货</option>
								<option value="3">已转发</option>
                            </select>
                          </div>
                            <label class="col-sm-2 control-label" for="t_sign">系统自动确认标志</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_sign" name="sign" type="text" placeholder="系统自动确认标志"/>
                          </div>
                        </div>
                </fieldset>
                <fieldset>
                        <div class="form-group">
                             <label class="col-sm-2 control-label" for="t_handlingSuggestion">处理意见</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_handlingSuggestion" disabled name="handlingSuggestion" type="text" placeholder="处理意见"/>
                          </div>
                            <label class="col-sm-2 control-label" for="t_typeofRejection">拒绝类型</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="t_typeofRejection" name="typeofRejection" type="text" placeholder="拒绝类型"/>
                          </div>
                        </div>
                </fieldset>
                </form>    
                <div class="modal-footer">    
                  <button class="btn btn-primary" id="subUp" type="button">提交</button>       
                  <button class="btn btn-info" data-dismiss="modal">退出</button>    
                </div>    
              </div>    
            </div>    
          </div>    

	<script type="text/javascript">
		$('.time').datetimepicker({
			format : 'yyyy-mm-dd hh:mm:ss',
			language : 'ch',
			pickDate : false,
			pickTime : true
		});
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table 
			oTableInit.Init = function() {
				$('#tb_departments').bootstrapTable({
					url : 'apply/findApplyGoodsPagenation', //请求后台的URL（*） 
					method : 'post', //请求方式（*） 
					toolbar : '#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : true, //是否显示分页（*） 
					sortable : false, //是否启用排序 
					sortOrder : "asc", //排序方式
					queryParams : oTableInit.queryParams,//传递参数（*） 
					sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
					pageNumber : 1, //初始化加载第一页，默认第一页 
					pageSize : 5, //每页的记录行数（*） 
					pageList : [ 8, 25, 50, 100 ], //可供选择的每页的行数（*） 
					search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
					strictSearch : true,
					showColumns : true, //是否显示所有的列 
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					clickToSelect : true, //是否启用点击选中行 
					height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "applicationId", //每一行的唯一标识，一般为主键列 
					showToggle : true, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						checkbox : true
					},/* {
						field : 'applicationNo',
						title : '申请单号'
					}, */{
						field : 'jobNo',
						title : '工作单号'
					},{
						field : 'cargoType',
						title : '返货类型'
					},{
						field : 'piecesNumber',
						title : '破损丢失件数'
					},{
						field : 'enrat',
						title : '进港时间',
						formatter:crtTimeFtt
					},{
						field : 'receiver',
						title : '接收单位'
					},{
						field : 'invalidSign',
						title : '作废标志',
						formatter:function(data){
							if(data=='1'){
								return '否';
							}else {
								return '是';
							}
						}
					},{
						field : 'returningUnit',
						title : '返货单位'
					},{
						field : 'inputTime',
						title : '录入时间',
						formatter:crtTimeFtt
					},{
						field : 'inputUnit',
						title : '录入单位'
					},{
						field : 'entryPerson',
						title : '录入人'
					},{
						field : 'acknowledgindUnit',
						title : '确认单位 '
					},{
						field : 'verifier',
						title : '确认人 '
					},{
						field : 'status',
						title : '返货处理状态 ',
						formatter:function(data){
							if(data=='1'){
								return '未确认';
							}else if(data=='2'){
								return '同意返货';
							}else if(data=='3'){
								return '拒绝';
							}else{
								return '同意转发';
							}
						}
					},{
						field : 'statusGoogs',
						title : '返货执行状态 ',
						formatter:function(data){
							if(data=='1'){
								return '未执行';
							}else if(data=='2'){
								return '已返货';
							}else{
								return '已转发';
							}
						}
					},{
						field : 'sign',
						title : '系统自动确认标志 '
					},{
						field : 'handlingSuggestion',
						title : '处理意见 '
					},{
						field : 'typeofRejection',
						title : '拒绝类型 '
					}]
				});
			};
            

			 $("input[name='c_invalidSign']").each(function(){
                 if ($(this).attr("checked")) {//选中的
                    var invalidSign = $("#c_invalidSign").val();
                   //对它进行操作吧
                 }
             })
			//得到查询的参数
			oTableInit.queryParams = function(params) {
				var temp = {
					//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
					limit : params.limit, //页面大小 
					offset : params.offset, //页码 
					departmentName : $("#txt_search_departmentname").val(),
					status : $("#txt_search_statu").val()
				};
				return temp;
			};
			$('#btn_query').click(function() {
				var opt = {

					url : "apply/findApplyGoodsPagenationWithCriteria",
					silent : true,
					query : {
						/* type : 1,
						level : 2, */
						entryPerson : $('#entryPerson1').val(),
						lowinputTime : $('#lowinputTimet').val(),
						highinputTime : $('#highinputTimet').val(),
						status : $('#status1').val(),
						inputUnit : $('#inputUnit1').val(),
						returningUnit : $('#returningUnit1').val(),
						cargoType : $('#cargoType1').val(),
						statusGoogs : $('#statusGoogs1').val(),
						receiver : $('#receiver1').val(),
						invalidSign:$('#c_invalidSign').val()


					}

				};
				$('#tb_departments').bootstrapTable('refresh', opt);
			});
			return oTableInit;
		};

		 //日期格式化
		function crtTimeFtt(val, row) {
		    if (val != null) {
		            var date = new Date(val);
		            return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate()+' '+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds();
		        }
		}
		
		var ButtonInit = function() {
			var oInit = new Object();
			var postdata = {};
			oInit.Init = function() {
				//初始化页面上面的按钮事件 
				$("#btn_add").click(function() {
					$('#addApply').modal('show');
					$('#addapply').data('bootstrapValidator').destroy();
					$('#addapply').data('bootstrapValidator', null); 
					formValidator();
				});

				$("#btn_edit").click(
						function() {
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请选中一行");
							}else if (select.length > 1) {
								toastr.warning("一次只能修改一条");
							}else {
								var rowData = select[0];
								if(rowData.statusGoogs ==2)
							    {
									toastr.warning("已返货 不能修改");
									return;
							    }else if(rowData.statusGoogs ==3){
							    	toastr.warning("不能修改,已转发");
							    	return;
							    }
								$("#deitApply").find(':input').each(function(){	
									if($(this).attr('name')){
										if($(this).hasClass("Time")){	
											var data = rowData[$(this).attr('name')];
											data=(data);
								
											$(this).val(data);
										}else{
											$(this).val(rowData[$(this).attr('name')]);
										}
									}
								});
								
								$('#deitApply').modal('show')
								 var obj = select[0];
								var upapplicationId = obj.applicationId;
								var upapplicationNo = obj.applicationNo;
								var upjobNo = obj.jobNo;
								var upcargoType = obj.cargoType;
								var uppiecesNumber = obj.piecesNumber;
								var uenrat = obj.enrat;
								var upreceiver = obj.receiver;
								var upinvalidSign = obj.invalidSign;
								var upreturningUnit = obj.returningUnit;
								var upinputTime = obj.inputTime;
								var upinputUnit = obj.inputUnit;
								var upentryPerson = obj.entryPerson;
								var upacknowledgindUnit = obj.acknowledgindUnit;
								var upverifier = obj.verifier;
								var upstatus = obj.status;
								var upstatusGoogs = obj.statusGoogs;
								var upsign = obj.sign;
								var uphandlingSuggestion = obj.handlingSuggestion;
								var uptypeofRejection = obj.typeofRejection;
								
								$("#t_applicationId").val(upapplicationId);
								$("#t_applicationNo").val(upapplicationNo);
								$("#t_jobNo").val(upjobNo);
								$("#t_cargoType").val(upcargoType);
								$("#t_piecesNumber").val(uppiecesNumber);
								$("#Time").val(uenrat);
								$("#t_receiver").val(upreceiver);
								$("#t_invalidSign").val(upinvalidSign);
								$("#t_returningUnit").val(upreturningUnit);
								$("#Time").val(upinputTime);
								$("#t_inputUnit").val(upinputUnit);
								$("#t_entryPerson").val(upentryPerson);
								$("#t_acknowledgindUnit").val(upacknowledgindUnit);
								$("#t_verifier").val(upverifier);
								$("#t_status").val(upstatus);
								$("#t_statusGoogs").val(upstatusGoogs);
								$("#t_sign").val(upsign);
								$("#t_handlingSuggestion").val(uphandlingSuggestion);
								$("#t_typeofRejection").val(uptypeofRejection);

								
							}

						});

				$("#btn_delete").click(
						function() {
							var select = $('#tb_departments').bootstrapTable(
									'getSelections');
							if (select.length === 0) {
								toastr.warning("请选中一行");
							}else {
								var deDate = select[0];
								if(deDate.status ==2)
								{
									toastr.warning("已返货的不可以作废");
									return;
								}else if(deDate.status ==4)
								{
									toastr.warning("已转发的返货不可以作废");
									return;
								}
								
								var arrs = [];
								
								for (var i = 0; i < select.length; i++) {
									arrs[i] = select[i]['applicationId'];
								}
								
								/* $('#tb_departments').bootstrapTable('remove', {
									field : 'applicationId',
									values : arrs
									
								}); */
								
								layer.msg('确定作废？',{
									  time : 0 //不自动关闭
									  ,btn : [ '确定', '取消' ],
									  yes : function(index) {
										layer.close(index);
										$.post("apply/updateApplyGoodsIn", {
											applyGoods : arrs
										}, function(result) {
											 if (result.status == 'success') {
												$('#tb_departments').bootstrapTable(
												'refresh');//刷新表格
												toastr.success("作废成功");
											} else {
												toastr.warning("作废失败");
											}
										}); 
									   $('#tb_departments').bootstrapTable('remove', {
											field : 'applicationId',
											values : arrs
										});



																			
								      }
							       });
							
								
						        /* if(window.confirm('你确定要作废吗？作废了不可以恢复哦'))
								{
						        	
								   $.post("apply/updateApplyGoodsIn", {
										applyGoods : arrs
									}, function(result) {
										 if (result.status == 'success') {
											$('#tb_departments').bootstrapTable(
											'refresh');//刷新表格
											toastr.success("作废成功");
										} else {
											toastr.warning("作废失败");
										}
									}); 
								   $('#tb_departments').bootstrapTable('remove', {
										field : 'applicationId',
										values : arrs
									});
                                      
								} */
								

							}

						});

			};
			return oInit;
		};

		$(function() {
			//1.初始化Table 
			var oTable = new TableInit();
			oTable.Init();
			//2.初始化Button的点击事件 
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();

			$("#addsup").click(function() {
						var options = {
							url : "apply/addApplyGoods",
							beforeSubmit : function() {
								 $('#addapply').data('bootstrapValidator').validate();
								var result = $('#addapply').data('bootstrapValidator').isValid();
								if (!result) {
									toastr.warning("校验失败,请正确填写");
									return false;
								} 

								return true;

							},
							success : function(data) {
								$("#addApply").modal('hide');
								if (data == 1) {
									$('#tb_departments').bootstrapTable(
											'refresh');
									toastr.success('添加成功');
								} else {
									toastr.error('添加失败');
								}

							},
							type : 'POST',
							clearForm : true
						};
						$("#addapply").ajaxSubmit(options);
					});
			
			//修改
			$("#subUp").click(function() {
				var upapplicationId =$("#t_applicationId").val();
				var upapplicationNo =$("#t_applicationNo").val();
				var upjobNo =$("#t_jobNo").val();
				var upcargoType =$("#t_cargoType").val();
				var uppiecesNumber =$("#t_piecesNumber").val();
				var upenrat =$("#t_enrat").val();
				var upreceiver =$("#t_receiver").val();
				var upinvalidSign =$("#t_invalidSign").val();
				var upreturningUnit =$("#t_returningUnit").val();
				var upinputTime =$("#t_inputTime").val();
				var upinputUnit =$("#t_inputUnit").val();
				var upentryPerson =$("#t_entryPerson").val();
				var upacknowledgindUnit =$("#t_acknowledgindUnit").val();
				var upverifier1 =$("#t_verifier").val();
				var upstatus =$("#t_status").val();
				var upstatusGoogsw =$("#t_statusGoogs").val();
				var upsign =$("#t_sign").val();
				var uphandlingSuggestion =$("#t_handlingSuggestion").val();
				var uptypeofRejection =$("#t_typeofRejection").val();
			
				$.ajax({
					url : "apply/updateApplyGoods",
					type : "POST",
					data : {
						"applicationId" : upapplicationId,
						"applicationNo" : upapplicationNo,
						"jobNo" : upjobNo,
						"cargoType" : upcargoType,
						"piecesNumber" : uppiecesNumber,
						"enrat" : upenrat,
						"receiver" : upreceiver,
						"invalidSign" : upinvalidSign,
						"returningUnit" : upreturningUnit,
						"inputTime" : upinputTime,
						"inputUnit" : upinputUnit,
						"entryPerson" : upentryPerson,
						"acknowledgindUnit" : upacknowledgindUnit,
						"verifier" : upverifier1,
						"status" : upstatus,
						"statusGoogs" : upstatusGoogsw,
						"sign" : upsign,
						"handlingSuggestion" : uphandlingSuggestion,
						"typeofRejection" : uptypeofRejection
						
					

					},
                    
					traditional : true,//这里设置为true
					success : function(result) {
						$('#deitApply').modal('hide');
						if (result == 1) {
							$('#tb_departments').bootstrapTable('refresh');
							toastr.success('修改成功');
						} else {
							toastr.success('修改成功');
						}
					}
				})

			});
			formValidator();
		});

		function formValidator() {
			$('#addapply').bootstrapValidator({
				 container: 'tooltip',
			        group: '.rowGroup',
			        message : '数据错误',
			        excluded: ':disabled',
			        feedbackIcons: {
			            valid: 'fa fa-check',
			            invalid: 'fa fa-times',
			            validating: 'fa fa-refresh'
			        },
				fields : {
					applicationNo : {
						message : '申请单号验证失败',
						validators : {
							notEmpty : {
								message : '申请单号不能为空'
							}
						}
					},
					jobNo : {
						validators : {
							notEmpty : {
								message : '工作单号不能为空'
							}/* ,
							regexp : {
								regexp : /^1[3|4|5|8][0-9]\d{4,8}$/,
								message : '电话号码格式不正确'
							} */
						}
					},
					piecesNumber : {
						validators : {
							notEmpty : {
								
								message : '默认件数为0,请填写'
								
							}
						}
					},
					enrat : {
						validators : {
							notEmpty : {
								message : '请输入日期'
							}
						}
					}
			 ,
				  receiver: {
				    validators: {
				      notEmpty: {
				      message: '请输入接收单位'
				         }
				          }
				      } 
			 ,
			 inputUnit : {
					validators : {
						notEmpty : {
							message : '请输入录入单位'
						}
					}
				}
			 ,
			 status : {
					validators : {
						notEmpty : {
							message : '请输入返货处理状态'
						}
					}
				}
			 ,
			 statusGoogs : {
					validators : {
						notEmpty : {
							message : '返货执行状态'
						}
					}
				}
			 ,
			 handlingSuggestion : {
					validators : {
						notEmpty : {
							message : '请输入处理意见'
						}
					}
				}
			 ,
			 typeofRejection : {
					validators : {
						notEmpty : {
							message : '请输入拒绝原因'
						}
					}
				}
			 ,
				}
			});
		}
		
		$("#clientphone").on("blur",function(){
          
			$.ajax({
				url:"apply/workSheetApplyGood",
				type:"post",
				data:{senderPhone:$("#clientphone").val()},
				async:true,
				traditional: true,
				success:function(response) {
					var html=$('#a_jobNo');
					for(var i=0;i<response.length;i++){
							item=$("<option></option>");
							item.append(response[i]);
							item.attr("value",response[i]);
							html.append(item);
					}
					
				}
			})
			
		});
	</script>


</body>
</html>
