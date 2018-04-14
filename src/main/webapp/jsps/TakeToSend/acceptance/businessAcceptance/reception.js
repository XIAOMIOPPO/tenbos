$(function(){
	//1.初始化Table 
	var oTable = new TableInit();
	oTable.Init();
	
	
	//新单 按钮点击事件
	$('#addNewOrder').click(toAddNewOrder);

	//追单 按钮点击事件
	$('#superadditionOrder').click(toSuperadditionOrder);



	//改单 按钮点击事件
	$('#alterOrder').click(toAlterOrder);


	//销单 按钮点击事件
	$('#destroyOrder').click(toDestroyOrder);

	//计算运费 按钮点击事件
	$('#imputedPrice').click(toImputedPrice);

	//保存咨询 按钮点击事件
	$('#addNewConsult').click(toNewConsult);
	
	//查询宣传任务
	$.ajax({
		url : "recsipt/findPropagandaContent.action",
		type : "post",
		async:true,
		traditional : true,//这里设置为true
		success : function(response) {
			var html = $('#PropagandaContent');
			if(response == null){
				item=$("<div></div>");
				item.append('没有最新消息');
			}else if(response){
				for(var i=0;i<response.length;i++){
					item=$("<div class='cloudMessage'></div>");
					item.append(response[i]);
					html.append(item);
				}
			}
		}
	});
	
	$("#subUp").click(function(){
		var province = $("#province4").val();
		var city = $("#city4").val();
		var district = $("#district4").val();
		var all = $("#all").val();
		$("#fetchAddress").attr("value",province+city+district+all);
		$("#fetchAddress").val(province+city+district+all);
		$("#myModal4").hidden();
	});
	
	$("#subAddress").click(function(){
		var province = $("#province2").val();
		var city = $("#city2").val();
		var district = $("#district2").val();
		var aoo = $("#aoo2").val();
		$("#serveAddress").attr("value",province+city+district+aoo);
		$("#myModal3").hidden();
	});
	
	//模糊查询按钮
	$('#searchBtn').click(function(){
		$('#tab_AllreceptionConsult').bootstrapTable("refresh", {
			url : "recsipt/findRecsiptByConditionVague.action",
			silent : true,
			query :{
				SphoneNum : $('#searchPhoneNum').val(),
				ScustomerName : $('#searchClientName').val(),
				Scontacts : $('#searchToUserName').val(),
				Stelephone : $('#searchToUserPhone').val(),
				SfetchAddress : $('#searchClientAddress').val(),
				SserveAddress : $('#searchoUserAddress').val(),
				SproductName : $('#searchProductName').val()
			}
		})
	});
	
    $('#forTakeToSendTime').datetimepicker({
        format: 'yyyy-mm-dd hh:mm:ss',
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: true
    });
    
    
    $('#forConsultTime').datetimepicker({
        format: 'yyyy-mm-dd hh:mm:ss',
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: true
    });
   
	

});


//给来电号码输入框设置失去焦点事件
$('#phoneNum').blur(function(){
	if($('#phoneNum').val() == "" ){
		toastr.warning("请输入来电手机号码");
	}else{
		//发送异步请求  查询值赋给其他的输入框
		var phoneNum = $('#phoneNum').val();
		$.ajax({
			url : "recsipt/findClientByPhoneNum.action",
			type : "post",
			data : {
				"phoneNum" : phoneNum
			},
			async:true,
			traditional : true,//这里设置为true
			success : function(response) {
				if(response == ''){
					$('#businessRecsiptNo').val('');
					$('#customerNo').val('');
					$('#customerName').val('');
					$('#fetchCity').val('');
					$('#fetchAddress').val('');
					toastr.warning('该号码是新客户，请完善资料！');					
				}else if(response.client){
					$('#businessRecsiptNo').val(response.businessRecsiptNo);
					$('#customerNo').val(response.client.clientNum);
					$('#customerName').val(response.client.clientName);
					$('#fetchCity').val(response.fetchCity);
					$('#fetchAddress').val(response.client.clientAddress);
				}
			}
		});
	}
});

//查询分拣编码
$('#fetchAddress').blur(function(){	
	$.ajax({
		url : "recsipt/findFetchAddress.action",
		type : "post",
		data : {
			"fetchAddress" : $('#fetchAddress').val()
		},
		async:true,
		traditional : true,//这里设置为true
		success : function(response) {
			if(response == ''){
				toastr.warning('请检查该地址！系统找不到匹配的地址');
			}else{
				$('#assignCode').val(response.assignCode);
			}
		}
	});
});


//新单 按钮点击事件的函数
var toAddNewOrder = function(){
	var phoneNum = $('#phoneNum').val();
	var businessRecsiptNo = $('#businessRecsiptNo').val();
	var customerNo = $('#customerNo').val();
	var customerName = $('#customerName').val();
	var fetchCity = $('#fetchCity').val();
	
	var contacts = $('#contacts').val();
	var telephone = $('#telephone').val();
	var fetchAddress = $('#fetchAddress').val();
	var serveAddress = $('#serveAddress').val();
	var productName = $('#productName').val();
	var numberPackages = $('#numberPackages').val();
	var weight = $('#weight').val();
	var volume = $('#volume').val();
	var product = $('#product').val();
	var assignCode = $('#assignCode').val();
	var SendTime = $('#forTakeToSendTime').val();
	var commonRemarks = $('#commonRemarks').val();
	var Remarks = $('#Remarks').val();
	
	var fetchCity = fetchAddress.substring(fetchAddress.indexOf("省")+1,fetchAddress.indexOf("市"));
	var arrivalCity = serveAddress.substring(serveAddress.indexOf("省")+1,serveAddress.indexOf("市"));
	
	//判断是否为空
	if(phoneNum == '' && contacts == '' && telephone ==  '' && fetchAddress == '' && serveAddress == ''){
		toastr.warning("请完善受理单资料");
	}else{
		$.ajax({
			url : "recsipt/addRecsipt.action",
			type : "post",
			data : {
				phoneNum : $('#phoneNum').val(),
				businessRecsiptNo : $('#businessRecsiptNo').val(),
				customerNo : $('#customerNo').val(),
				customerName : $('#customerName').val(),
				fetchCity : fetchCity,
				arrivalCity : arrivalCity,
				contacts : $('#contacts').val(),
				telephone : $('#telephone').val(),
				fetchAddress : $('#fetchAddress').val(),
				serveAddress : $('#serveAddress').val(),
				productName : $('#productName').val(),
				numberPackages : $('#numberPackages').val(),
				weight : $('#weight').val(),
				volume : $('#volume').val(),
				product : $('#product').val(),
				assignCode : $('#assignCode').val(),
				SendTime : $('#forTakeToSendTime').val(),
				commonRemarks : $('#commonRemarks').val(),
				Remarks : $('#Remarks').val(),
			},
			async:true,
			traditional : true,//这里设置为true
			success : function(response) {
				if (response.status == "success") {
					toastr.success("添加新单成功"); 
					var url = {
							url : 'recsipt/findAllRecsipt.action'
						};
						$('#tab_AllreceptionConsult')
								.bootstrapTable('refresh',
										url);
						$('#tab_orderProperty')
						.bootstrapTable('refresh',
								url);
				
					//添加成功清除数据
						$('#phoneNum').val('');
						$('#businessRecsiptNo').val('');
						$('#customerNo').val('');
						$('#customerName').val('');
						$('#fetchCity').val('');
						$('#arrivalCity').val('');
						$('#contacts').val('');
						$('#telephone').val('');
						$('#fetchAddress').val('');
						$('#serveAddress').val('');
						$('#productName').val('');
						$('#numberPackages').val('');
						$('#weight').val('');
						$('#volume').val('');
						$('#product').val('');
						$('#assignCode').val('');
						$('#forTakeToSendTime').val('');
						$('#commonRemarks').val('');
						$('#Remarks').val('');
				} else {
					var url = {
							url : 'recsipt/findAllRecsipt.action'
						};
						$('#tab_AllreceptionConsult')
								.bootstrapTable('refresh',
										url);
						$('#tab_orderProperty')
						.bootstrapTable('refresh',
								url);
					toastr.error("添加新单失败");  
				}
			}
		});
	}
	
};
//追单 按钮点击事件函数
var toSuperadditionOrder = function(){
	var select = $('#tab_AllreceptionConsult').bootstrapTable(
	'getSelections');
	if (select.length === 0) {
		toastr.warning("请至少选择一行");
	} else if(select.length>1){
		toastr.warning("一次只能选择一行");
	}else if(select[0]['destoryCause'] != '未销单'){
		toastr.warning("该订单已经取消了,不能进行追单");
	}else{
		$.ajax({
			url : "recsipt/updateWorkOrder.action",
			type : "post",
			data : {
				businessRecsiptId:select[0]['businessRecsiptId'],
				workOrderType : '追工单'
			},
			async:true,
			traditional : true,//这里设置为true
			success : function(response) {
				if (response.status == "success") {
					toastr.success("追单成功"); 
					var url = {
							url : 'recsipt/findAllRecsipt.action'
						};
						$('#tab_AllreceptionConsult')
								.bootstrapTable('refresh',
										url);
						$('#tab_orderProperty')
						.bootstrapTable('refresh',
								url);
				} else {
					toastr.error("追单失败");  
				}
			}
		});
		
	}
};


//改单 按钮点击事件函数
var toAlterOrder = function(){
	var select = $('#tab_AllreceptionConsult').bootstrapTable(
	'getSelections');
	if (select.length === 0) {
		toastr.warning("请至少选择一行");
	} else if(select.length>1){
		toastr.warning("一次只能选择一行");
	}else if(select[0]['destoryCause'] != '未销单'){
		toastr.warning("该单已经取消了，不能进行改单");
	}else{	
		$.ajax({
			url : "recsipt/updateBusinessRecsipt.action",
			type : "post",
			data : {
				businessRecsiptId : select[0]['businessRecsiptId'],
				phoneNum : select[0]['phoneNum'],
				contacts : select[0]['contacts'],
				telephone : select[0]['telephone'],
				fetchAddress : select[0]['fetchAddress'],
				serveAddress : select[0]['serveAddress'],
				appointmentDispatchTime : select[0]['appointmentDispatchTime'],
				productName :  select[0]['productName'],
				numberPackages : select[0]['numberPackages'],
				weight : select[0]['weight'],
				volume : select[0]['volume'],
			},
			async:true,
			traditional : true,//这里设置为true
			success : function(response) {
				if (response.status == "success") {
					toastr.success("改单成功"); 
					var url = {
							url : 'recsipt/findAllRecsipt.action'
						};
						$('#tab_AllreceptionConsult')
								.bootstrapTable('refresh',
										url);
						$('#tab_orderProperty')
						.bootstrapTable('refresh',
								url);
				} else {
					toastr.error("改单失败");  
				}
			}
		});
		
	}
};


//销单 按钮点击事件函数
var toDestroyOrder = function(){
	var select = $('#tab_AllreceptionConsult').bootstrapTable(
	'getSelections');
	if (select.length === 0) {
		toastr.warning("请至少选择一行");
	} else if(select.length>1){
		toastr.warning("一次只能选择一行");
	}else if(select[0]['destoryCause'] != '未销单'){
		toastr.warning("该单已经取消了，不能再进行销单");
	}else{	
		var businessRecsiptId = select[0]['businessRecsiptId'];
		$('#destoryId').val(businessRecsiptId);
		$("#destoryMyModalLabel").modal("show");
	}
};

//确认销单点击事件
$('#editBtn').click(function(){
	var businessRecsiptId = $('#destoryId').val();
	var destoryNone = $('#destoryNone').val();
	$.ajax({
		url : "recsipt/deleteWorkOrder.action",
		type : "post",
		data : {
			businessRecsiptId:businessRecsiptId,
			workOrderType : '销工单',
			cause : destoryNone
		},
		async:true,
		traditional : true,//这里设置为true
		success : function(response) {
			if (response.status == "success") {
				toastr.success("销单成功"); 
				var url = {
						url : 'recsipt/findAllRecsipt.action'
					};
					$('#tab_AllreceptionConsult')
							.bootstrapTable('refresh',
									url);
					$('#tab_orderProperty')
					.bootstrapTable('refresh',
							url);
			} else {
				toastr.error("销单失败");  
			}
		}
	});
	$("#destoryMyModalLabel").modal('hide');
	
});	

//计算运费 按钮点击事件函数
var toImputedPrice = function(){
	var select = $('#tab_AllreceptionConsult').bootstrapTable(
	'getSelections');
	if (select.length === 0) {
		toastr.warning("请至少选择一行");
	} else if(select.length>1){
		toastr.warning("一次只能选择一行");
	}else {	
		var businessRecsiptId = select[0]['businessRecsiptId'];
	}
};
$('#contactPhone').blur(function(){	
	if($('#contactPhone').val() == "" ){
		toastr.warning("请输入来电手机号码");
	}else{
		//发送异步请求  查询值赋给其他的输入框
		var phoneNum = $('#contactPhone').val();
		$.ajax({
			url : "recsipt/findClientByPhoneNum.action",
			type : "post",
			data : {
				"phoneNum" : phoneNum
			},
			async:true,
			traditional : true,//这里设置为true
			success : function(response) {
				if(response == ''){
					toastr.warning('该号码是新客户，请完善资料！');
					$('#ConsultcustomerNo').val('');
					$('#ConsultcustomerName').val('');
					$('#contactAddress').val('');
				}else if(response.client){
					$('#ConsultcustomerNo').val(response.client.clientNum);
					$('#ConsultcustomerName').val(response.client.clientName);
					$('#contactAddress').val(response.client.clientAddress);
				}
			}
		});
		
		$.ajax({
			url:"consult/findBusinessRecsiptNoByClient.action",
			type:"post",
			data : {
				"phoneNum" : phoneNum
			},
			async:true,
			traditional: true,
			success:function(response) {
				var html=$('#CCbusinessRecsiptNo');
				for(var i=0;i<response.length;i++){
						item=$("<option></option>");
						item.append(response[i]);
						item.attr("value",response[i]);
						html.append(item);
				}
				
			}
		});
		
		$.ajax({
			url:"consult/findWorkOrderNoByClient.action",
			type:"post",
			data : {
				"phoneNum" : phoneNum
			},
			async:true,
			traditional: true,
			success:function(response) {
				var html=$('#CCworkOrderNo');
				for(var i=0;i<response.length;i++){
						item=$("<option></option>");
						item.append(response[i]);
						item.attr("value",response[i]);
						html.append(item);
				}
				
			}
		});
	}

	
	
});

//新咨询 按钮点击事件函数
var toNewConsult = function(){
	
	var customerName = $('#ConsultcustomerName').val();
	var customerNo = $('#ConsultcustomerNo').val();
	var contacts = $('#Consultcontacts').val();
	var contactPhone = $('#contactPhone').val();
	var telephone = $('#Consultelephone').val();
	var portraiture = $('#portraiture').val();
	var contactAddress = $('#contactAddress').val();
	var zipCode = $('#zipCode').val();
	var Email = $('#Email').val();
	var cooperate = $('#cooperate').val();
	var workOrderNo = $('#CCworkOrderNo').val();
	var consultType = $('#ConsultconsultType').val();
	var consultWay = $('#consultWay').val();
	var consultTime = $('#forConsultTime').val();
	var consultContent = $('#consultContent').val();
	var consultFruit = $('#consultFruit').val();
	var businessRecsiptNo = $('#CCbusinessRecsiptNo').val();
	
	
	$.ajax({
		url : "consult/addConsult.action",
		type : "post",
		data : {
			customerName:customerName,
			customerNo : customerNo,
			contacts : contacts,
			contactPhone:contactPhone,
			telephone:telephone,
			portraiture:portraiture,
			contactAddress:contactAddress,
			zipCode:zipCode,
			Email:Email,
			cooperate:cooperate,
			workOrderNo:workOrderNo,
			consultType:consultType,
			consultWay:consultWay,
			consultTimes:consultTime,
			consultContent:consultContent,
			consultFruit:consultFruit,
			businessRecsiptNo:businessRecsiptNo,
		},
		async:true,
		traditional : true,//这里设置为true
		success : function(response) {
			if (response.status == "success") {
				$('#ConsultcustomerName').val('');
				$('#ConsultcustomerNo').val('');
				$('#Consultcontacts').val('');
				$('#contactPhone').val('');
			    $('#Consultelephone').val('');
				$('#portraiture').val('');
				$('#contactAddress').val('');
				$('#zipCode').val('');
				$('#Email').val('');
				$('#cooperate').val('');
				$('#CCworkOrderNo').val('');
				$('#ConsultconsultType').val('');
				$('#consultWay').val('');
				$('#forConsultTime').val('');
				$('#consultContent').val('');
				$('#consultFruit').val('');
				$('#CCbusinessRecsiptNo').val('');
				toastr.success("咨询保存成功"); 
					$('#tab_receptionConsult')
					.bootstrapTable('refresh', 'consult/findBusReConsult.action');
					$('#tab_workOrderConsult')
					.bootstrapTable('refresh', 'consult/findWorkOrderConsult.action');
			} else {
				toastr.error("咨询保存失败");  
			}
		}
	});
};


var TableInit = function() {
	var oTableInit = new Object();
	//初始化Table 
	oTableInit.Init = function() {
		$('#tab_AllreceptionConsult').bootstrapTable({
			url : 'recsipt/findAllRecsipt.action', //请求后台的URL（*） 
			method : 'post', //请求方式（*） 
			toolbar : '#receptionConsult', //工具按钮用哪个容器 
			striped : true, //是否显示行间隔色 
			cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
			pagination : true, //是否显示分页（*） 
			sortable : false, //是否启用排序 
			sortOrder : "desc", //排序方式
			queryParams : oTableInit.queryParams,//传递参数（*） 
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
			pageNumber : 1, //初始化加载第一页，默认第一页 
			pageSize : 5, //每页的记录行数（*） 
			pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
			search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
			strictSearch : true,
			showColumns : true, //是否显示所有的列 
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 4, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行 
			//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
			uniqueId : "businessRecsiptNo", //每一行的唯一标识，一般为主键列 
			showToggle : true, //是否显示详细视图和列表视图的切换按钮 
			cardView : false, //是否显示详细视图
			detailView : true, //是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'businessRecsiptNo',
				title : '业务单号',
				width : 350
			}, {
				field : 'customerName',
				title : '客户名字',
			}, {
				field : 'phoneNum',
				title : '客户号码',
			}, {
				field : 'contacts',
				title : '收件人',
                editable: {
                    type: 'text',
                    title: '收件人',
                    validate: function (v) {
                        if (!v) return '收件人不能为空';
                    }
                }
			}, {
				field : 'fetchAddress',
				title : '取件地址',
				width : 500,
                editable: {
                    type: 'text',
                    title: '取件地址',
                    validate: function (v) {
                        if (!v) return '取件地址不能为空';
                    }
                }
			},{
				field : 'serveAddress',
				title : '收件地址',
				width : 500,
                editable: {
                    type: 'text',
                    title: '收件地址',
                    validate: function (v) {
                        if (!v) return '收件地址不能为空';
                    }
                }
			},{
				field : 'appointmentDispatchTime',
				title : '预约取件时间',
				formatter:function (value){
					return formatDate(value);
				},
				editable: {
                    type: 'datetime',
                    title: '预约取件时间',
                    validate: function (v) {
                        if (!v) return '预约取件时间不能为空';
                    }
                }
			},{
				field : 'productName',
				title : '产品名字',
                editable: {
                    type: 'text',
                    title: '产品名',
                    validate: function (v) {
                        if (!v) return '产品名不能为空';
                    }
                }
			},{
				field : 'weight',
				title : '重量',
                editable: {
                    type: 'text',
                    title: '重量',
                    validate: function (v) {
                    	if (!v) return '重量不能为空';
                        if (isNaN(v)) return '重量必须是数字';
                        var weight = parseFloat(v);
                        if (weight <= 0) return '重量必须是正数';
                   }
                }
			},{
				field : 'volume',
				title : '体积',
                editable: {
                    type: 'text',
                    title: '体积',
                    validate: function (v) {
                    	if (!v) return '体积不能为空';
                        if (isNaN(v)) return '体积必须是数字';
                        var volume = parseFloat(v);
                        if (volume <= 0) return '体积必须是正数';
                   }
                }
			},{
				field : 'numberPackages',
				title : '数量',
                editable: {
                    type: 'text',
                    title: '数量',
                    validate: function (v) {
                    	if (!v) return '数量不能为空';
                        if (isNaN(v)) return '数量必须是数字';
                        var numberPackages = parseInt(v);
                        if (numberPackages <= 0) return '数量必须是正整数';
                   }
                }
			},{
				field : 'precharge',
				title : '金额'
			}],
	        //注册加载子表的事件。注意下这里的三个参数！
	        onExpandRow: function (index, row, $detail) {
	        	oTableInit.InitSubTable(index, row, $detail);
	        }
		});
		
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
		
		oTableInit.InitSubTable = function (index, row, $detail) {
		        var parentid = row.businessRecsiptId;
		        var cur_table = $detail.html('<table></table>').find('table');
		        $(cur_table).bootstrapTable({
		        	url : 'workOrder/findWorkOrderById.action', //请求后台的URL（*） 
					method : 'post', //请求方式（*） 
					toolbar : '#toolbar', //工具按钮用哪个容器 
					striped : true, //是否显示行间隔色 
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*） 
					pagination : false, //是否显示分页（*） 
					sortable : false, //是否启用排序 
					sortOrder : "asc", //排序方式
			        queryParams: { businessRecsiptId: parentid },
			        ajaxOptions: { businessRecsiptId: parentid },
					sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*） 
					pageNumber : 1, //初始化加载第一页，默认第一页 
					pageSize : 6, //每页的记录行数（*） 
					pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
					clickToSelect : true, //是否启用点击选中行 
					//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
					uniqueId : "workOrderNo", //每一行的唯一标识，一般为主键列 
					showToggle : false, //是否显示详细视图和列表视图的切换按钮 
					cardView : false, //是否显示详细视图
					detailView : false, //是否显示父子表
					columns : [ {
						field : 'businessRecsiptNo',
						title : '受理单号'
					}, {
						field : 'workOrderTime',
						title : '下单时间',
						formatter:function (value){
							return formatDate(value);
						}
					}, {
						field : 'workOrderType',
						title : '类型'
					}, {
						field : 'traceNum',
						title : '追单次数'
					} ,{
						field : 'wstatus',
						title : '当前状态'
					}, {
						field : 'empNum',
						title : '操作人工号'
					}, {
						field : 'empName',
						title : '取件人'
					}, {
						field : 'takeOrgName',
						title : '受理单位'
					}, {
						field : 'takeTime',
						title : '受理时间',
						formatter:function (value){
							return formatDate(value);
						}
					}, {
						field : 'sortingCode',
						title : '分拣编码'
					}],
		            //无线循环取子表，直到子表里面没有记录
		            onExpandRow: function (index, row, $Subdetail) {
		            	oTableInit.InitSubTable(index, row, $Subdetail);
		            }
		        });
		 }
		
		oTableInit.queryParams = function(params) {
			var temp = {
				//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的 
				limit : params.limit, //页面大小 
				offset : params.offset, //页码 
				phoneNum : $('#phoneNum').val(),
				businessRecsiptNo : $('#businessRecsiptNo').val(),
				customerNo : $('#customerNo').val(),
				customerName : $('#customerName').val(),
				fetchCity : $('#fetchCity').val(),
				arrivalCity : $('#arrivalCity').val(),
				contacts : $('#contacts').val(),
				telephone : $('#telephone').val(),
				fetchAddress : $('#fetchAddress').val(),
				serveAddress : $('#serveAddress').val(),
				productName : $('#productName').val(),
				numberPackages : $('#numberPackages').val(),
				weight : $('#weight').val(),
				volume : $('#volume').val(),
				product : $('#product').val(),
				assignCode : $('#assignCode').val(),
				appointmentDispatchTime : $('#forTakeToSendTime').val(),
				commonRemarks : $('#commonRemarks').val(),
				Remarks : $('#Remarks').val(),

			};
			return temp;
		};
		
		
		
		
		$('#tab_orderProperty').bootstrapTable({
			url : 'recsipt/findAllRecsipt.action', //请求后台的URL（*） 
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
			pageSize : 6, //每页的记录行数（*） 
			pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
			search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
			strictSearch : true,
			showColumns : true, //是否显示所有的列 
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 4, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行 
			//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
			uniqueId : "businessRecsiptId", //每一行的唯一标识，一般为主键列 
			showToggle : true, //是否显示详细视图和列表视图的切换按钮 
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'businessRecsiptNo',
				title : '通知单号'
			}, {
				field : 'customerName',
				title : '联系人'
			}, {
				field : 'phoneNum',
				title : '联系电话'
			}, {
				field : 'acceptTime',
				title : '下单时间',
				formatter:function (value){
					return formatDate(value);
				}
			}, {
				field : 'serveAddress',
				title : '收件地址'
			}, {
				field : 'destoryCause',
				title : '销单原因'
			}, {
				field : 'userId',
				title : '操作人工号'
			}, {
				field : 'operator',
				title : '操作人姓名'
			}, {
				field : 'operatorOrg',
				title : '操作人单位'
			}, {
				field : 'operatorTime',
				title : '操作时间',
				formatter:function (value){
					return formatDate(value);
				}
			}]
		});
		
		$('#tab_receptionConsult').bootstrapTable({
			url : 'consult/findBusReConsult.action', //请求后台的URL（*） 
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
			pageSize : 10, //每页的记录行数（*） 
			pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
			search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
			strictSearch : true,
			showColumns : true, //是否显示所有的列 
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行 
			//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
			uniqueId : "consultId", //每一行的唯一标识，一般为主键列 
			showToggle : true, //是否显示详细视图和列表视图的切换按钮 
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'consultContent',
				title : '咨询内容'
			}, {
				field : 'consultFruit',
				title : '咨询结果'
			}, {
				field : 'initialUnit',
				title : '受理人'
			}, {
				field : 'consultTime',
				title : '咨询时间',
				formatter:function (value){
					return formatDate(value);
				}
			}]
		});
		
		$('#tab_workOrderConsult').bootstrapTable({
			url : 'consult/findWorkOrderConsult.action', //请求后台的URL（*） 
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
			pageSize : 10, //每页的记录行数（*） 
			pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*） 
			search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大 
			strictSearch : true,
			showColumns : true, //是否显示所有的列 
			showRefresh : true, //是否显示刷新按钮
			minimumCountColumns : 2, //最少允许的列数
			clickToSelect : true, //是否启用点击选中行 
			//height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度 
			uniqueId : "consultId", //每一行的唯一标识，一般为主键列 
			showToggle : true, //是否显示详细视图和列表视图的切换按钮 
			cardView : false, //是否显示详细视图
			detailView : false, //是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'workOrderNo',
				title : '工作单号'
			}, {
				field : 'businessRecsiptNo',
				title : '业务单号'
			}, {
				field : 'consultContent',
				title : '咨询内容'
			}, {
				field : 'consultFruit',
				title : '咨询结果'
			}, {
				field : 'initialUnit',
				title : '受理人'
			}, {
				field : 'consultTime',
				title : '咨询时间',
				formatter:function (value){
					return formatDate(value);
				}
			} ]
		});
	}; //得到查询的参数

	return oTableInit;
};



$("#phoneNum").blur(function(){
	var phoneNum = $("#phoneNum").val();
	var reg = /^1\d{10}$/; 
	if(!reg.test(phoneNum)){
		$("#phoneNum").css("border","1px solid #CE0000");
		$("#addNewOrder").attr("disabled",true);
		
	}else{
		$("#phoneNum").css("border","1px solid gray");
	}
});


$("#telephone").blur(function(){
	var telephone = $("#telephone").val();
	var reg = /^1\d{10}$/; 
	if(!reg.test(telephone)){
		$("#telephone").css("border","1px solid #CE0000");
		$("#addNewOrder").attr("disabled",true);
	}else{
		$("#telephone").css("border","1px solid gray");
	}
});


$("#numberPackages").blur(function(){
	var numberPackages = $("#numberPackages").val();
	var reg = /^[1-9]([0-9])*$/;
	if(!reg.test(numberPackages)){
		$("#numberPackages").css("border","1px solid #CE0000");
		$("#addNewOrder").attr("disabled",true);
	}else{
		$("#numberPackages").css("border","1px solid gray");
	}
});


$("#weight").blur(function(){
	var weight = $("#weight").val();
	var reg = /^\d+(\.\d+)?$/;
	if(!reg.test(weight)){
		$("#weight").css("border","1px solid #CE0000");
		$("#addNewOrder").attr("disabled",true);
	}else{
		$("#weight").css("border","1px solid gray");
	}
});


$("#volume").blur(function(){
	var volume = $("#volume").val();
	var reg = /^\d+(\.\d+)?$/;
	if(!reg.test(volume)){
		$("#volume").css("border","1px solid #CE0000");
		$("#addNewOrder").attr("disabled",true);
	}else{
		$("#volume").css("border","1px solid gray");
		$("#addNewOrder").attr("disabled",false);
	}
});
