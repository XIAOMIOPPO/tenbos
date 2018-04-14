function createTable(id,url,columns,uniqueId,sidePagination){
	$(id).bootstrapTable({
		url : url, //请求后台的URL（*） 
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
		sidePagination : sidePagination, //分页方式：client客户端分页，server服务端分页（*） 
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
		uniqueId : uniqueId, //每一行的唯一标识，一般为主键列 
		//showToggle : true, //是否显示详细视图和列表视图的切换按钮 
		cardView : false, //是否显示详细视图
		detailView : false, //是否显示父子表
		columns : columns
	});
}

$(function(){
	
	var detail=null;
	
	//初始化list1 table
	createTable("#detTable","sign/sin",[{
		field : 'storageinId',
		title : '单号'
	},{
		field : 'storageinNo',
		title : '合包号'
	},{
		field : 'recDate',
		title : '重量'
	},{
		field : 'recPersonName',
		title : '扫描时间'
	},{
		field : 'recOrgName',
		title : '扫描'
	},{
		field : 'recOrgName',
		title : '下环节入库标志'
	},{
		field : 'sendPersonName',
		title : '二次入库标志'
	}],"storageinId","server");
	
	
});
$(function(){
	
	var detail=null;
	
	//初始化list1 table
	createTable("#delTable","sign/sin",[{
		field : 'storageinId',
		title : '发货件数'
	},{
		field : 'storageinNo',
		title : '发货人'
	},{
		field : 'recDate',
		title : '发货时间'
	}],"storageinId","server");
	
	
});

$(function(){
	
	var detail=null;
	
	//初始化list1 table
	createTable("#pickTable","sign/sin",[{
		field : 'storageinId',
		title : '提货件数'
	},{
		field : 'storageinNo',
		title : '提货人'
	},{
		field : 'recDate',
		title : '发货时间'
	}],"storageinId","server");
	
	
});

$(function(){
	
	var detail=null;
	
	//初始化list1 table
	createTable("#wereTable","sign/sin",[{
		field : 'storageinId',
		title : '货票号'
	},{
		field : 'storageinNo',
		title : '航班次数'
	},{
		field : 'recDate',
		title : '件数'
	},{
		field : 'recDate',
		title : '金额'
	},{
		field : 'recDate',
		title : '录入日期'
	},{
		field : 'recDate',
		title : '录入人'
	}],"storageinId","server");
	
	
});

$(function(){
	
	var detail=null;
	
	//初始化list1 table
	createTable("#listTable","sign/fpout",[{
		field : 'outstorageno',
		title : '交接单号'
	},{
		field : 'outstorageType',
		title : '交接单类型'
	},{
		field : 'lineType',
		title : '线路类型'
	},{
		field : 'recDate',
		title : '出库单位'
	},{
		field : 'recDate',
		title : '出库时间'
	},{
		field : 'recDate',
		title : '状态'
	}],"outstorageId","server");
	
});
$(function(){
	
	var detail=null;
	
	//初始化list1 table
	createTable("#lstTable","sign/sin",[{
		field : 'storageinId',
		title : '单号'
	},{
		field : 'storageinNo',
		title : '合包号'
	},{
		field : 'recDate',
		title : '重量'
	},{
		field : 'recDate',
		title : '出库单位'
	},{
		field : 'recDate',
		title : '扫描时间'
	},{
		field : 'recDate',
		title : '扫描'
	}],"storageinId","server");
	
	
});
function formatDate(ns) {
	var now = new Date(ns);
	
	var year=now.getYear()+1900;
	var month=now.getMonth()+1;
	var date=now.getDate();
	var hour=now.getHours();
	var minute=now.getMinutes();
	var second=now.getSeconds();
	
	return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;

}


