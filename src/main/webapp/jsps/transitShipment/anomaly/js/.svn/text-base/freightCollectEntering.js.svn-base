$(function(){
	//1.初始化Table 
	var oTable = new TableInit();
	oTable.Init();
	
	$('#btn_save').click(function(){
		$('#myModal_save').modal('show');
	});
	
	$('#txt_save_jobListNo').blur(function(){
		var workSheetNo = $('#txt_save_jobListNo').val();
		if(workSheetNo == '' || workSheetNo == null){
			toastr.warning("请输入工作单号");
		}else{
			$.ajax({
				url : "changeEntering/findWorkSheet.action",
				type : "post",
				data : {
					"workSheetNo" : workSheetNo
				},
				async:true,
				traditional : true,//这里设置为true
				success : function(response) {
					if(response == ''){
						$('#txt_save_enteringUnit').val('');
						$('#txt_save_senderUnit').val('');
						$('#txt_save_cameCollect').val('');
						$('#txt_save_agencyFund').val('');
						$('#txt_save_productName').val('');
						$('#txt_save_addressee').val('');
						toastr.warning('没有该工作单信息');					
					}else{
						$('#txt_save_productName').val(response.workSheet.product);
						$('#txt_save_enteringUnit').val(response.enteringUnit);
						$('#txt_save_senderUnit').val(response.workSheet.drawer.drawerOperationCompany);
						
						$('#txt_save_cameCollect').val(response.workSheet.rule.replaceReceivables);
						$('#txt_save_agencyFund').val(response.workSheet.rule.paymentArrival);
						$('#txt_save_addressee').val(response.workSheet.addresses.addressesName);
					}
				}
			});
		}
	});
	
	$('#btn_submit_saveChangeEntering').click(function(){
		var workSheetNo = $('#txt_save_jobListNo').val();
		var enteringUnit = $('#txt_save_enteringUnit').val();
		var sendeeUnit = $('#txt_save_senderUnit').val();
		var cameCollect = $('#txt_save_cameCollect').val();
		var agencyFund = $('#txt_save_agencyFund').val();
		var productName = $('#txt_save_productName').val();
		var addressee = $('#txt_save_addressee').val();
		
		var changeCameCollect = $('#txt_save_changeCameCollect').val();
		var changeAgencyFund = $('#txt_save_changeAgencyFund').val();
		var changeCause = $('#txt_save_changeCause').val();
		
		
		$.ajax({
			url : "changeEntering/addChangeEntering.action",
			type : "post",
			data : {
				"workSheetNo" : workSheetNo,
				"enteringUnit" : enteringUnit,
				"sendeeUnit" :sendeeUnit,
				"cameCollect":cameCollect,
				"agencyFund":agencyFund,
				"productName":productName,
				"addressee":addressee,
				"changeCameCollect": changeCameCollect,
				"changeAgencyFund":changeAgencyFund,
				"changeCause":changeCause
			},
			async:true,
			traditional : true,//这里设置为true
			success : function(response) {
				if (response.status == "success") {
					toastr.success("保存成功"); 
					var url = {
							url : 'changeEntering/findAllChangeEntering.action'
						};
						$('#tb_departments')
								.bootstrapTable('refresh',
										url);
				} else {
					toastr.error("保存失败");  
				}
			}
		});
		
		$('#myModal_save').modal('hide');
	});
	
});







var TableInit = function() {
	var oTableInit = new Object();
	//初始化Table 
	oTableInit.Init = function() {
		
		//时间的转换
		function formatDate(ns) {
			var now = new Date(ns);
			var year=now.getYear()+1900;
			var month=now.getMonth()+1;
			if(month<10){
				month = "0"+month;
			}
			var date=now.getDate();
			if(date<10){
				date = "0"+date;
			}
			var hour=now.getHours();
			if(hour<10){
				hour = "0"+hour;
			}
			var minute=now.getMinutes();
			if(minute<10){
				minute = "0"+minute;
			}
			return year+"-"+month+"-"+date+" "+hour+":"+minute;

		}
		
		$('#tb_departments').bootstrapTable({
    	    url: 'changeEntering/findAllChangeEntering.action',//请求后台的URL（*）
    		method : 'post', //请求方式（*） 
				toolbar : '#toolbars', //工具按钮用哪个容器 
				striped : true, //是否显示行间隔色 
				cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
				pagination : true, //是否显示分页（*） 
				sortable : false, //是否启用排序 
				sortOrder : "asc", //排序方式
				queryParams : oTableInit.queryParams,//传递参数（*） 
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
				pageNumber : 1, //初始化加载第一页，默认第一页 
				pageSize : 10, //每页的记录行数（*） 
				pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
				strictSearch : true,
				maintainSelected:true,//翻页复选框状态不会改变
				showColumns : true, //是否显示所有的列 
				showRefresh : true, //是否显示刷新按钮
				minimumCountColumns : 2, //最少允许的列数
				clickToSelect : true, //是否启用点击选中行 
				uniqueId : "recordId", //每一行的唯一标识，一般为主键列 
				showToggle : true, //是否显示详细视图和列表视图的切换按钮 
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
        columns: [{
            checkbox: true
        }, 
        {
            field: 'workSheetNo',
            align: 'center',
            title: '工作单号',
            width: '100px'
        },
        {
            field: 'productName',
            align: 'center',
            width: '100px',
            title: '品名'	
        }, 
        {
            field: 'cameCollect',
            align: 'center',
            width: '100px',
            title: '原到付款金额'
        }, 
        {
            field: 'agencyFund',
            align: 'center',
            width: '100px',
            title: '原代收款金额'
        }, 
        {
            field: 'changeCameCollect',
            align: 'center',
            width: '100px',
            title: '变更到付款'
        }, 
        {
            field: 'changeAgencyFund',
            align: 'center',
            width: '100px',
            title: '变更代收款'
        },
        {
            field: 'sendeeStatus',
            align: 'center',
            width: '100px',
            title: '接收状态'
        }, 
        {
            field: 'enteringMan',
            align: 'center',
            width: '100px',
            title: '录入人'
        }, 
        {
            field: 'enteringUnit',
            align: 'center',
            width: '200px',
            title: '录入单位'
        },
        {
            field: 'sendeeUnit',
            align: 'center',
            width: '200px',
            title: '接收单位'
        },	
        {
            field: 'enteringTime',
            align: 'center',
            width: '100px',
            title: '录入时间',
			formatter:function (value){
				return formatDate(value);
			}
        },
        {
            field: 'changeCause',
            align: 'center',
            width: '100px',
            title: '变更原因'
        },
        {
            field: 'senderUnit',
            align: 'center',
            width: '100px',
            title: '委托单位'
            	
        },
        {
            field: 'addressee',
            align: 'center',
            width: '100px',
            title: '收货人'
        },
        ],
    });
   
	}; //得到查询的参数
	
	oTableInit.queryParams = function(params) {
		var temp = {
			limit : params.limit, //页面大小 
			offset : params.offset, //页码 
		};
		return temp;
	};
	

	return oTableInit;
};




