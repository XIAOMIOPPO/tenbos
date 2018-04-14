$(function(){
	 $('#linkage').citys({code:350206});
 });

$('.time').datetimepicker({
	format : 'yyyy-mm-dd',
	language : 'zh-CN',
	autoclose : true,
	todayHighlight : true

});

function clean() {
	$("#distributionUnit").children("option").remove();
}

function cleanEmpName() {
	$("#empName").children("option").remove();
}

function cleanOrgName() {
	$("#addTrade").children("option").remove();
}

function formatDate(ns) {
	var now = new Date(ns);
	var year = now.getYear() + 1900;
	var month = now.getMonth() + 1;
	var date = now.getDate();
	var hour = now.getHours();
	var minute = now.getMinutes();
	var second = now.getSeconds();
	return year + "-" + month + "-" + date;
}

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#tb_dispatcher').bootstrapTable({
			url : 'dispatcher/findAllNeedDispatcherWorkOrder', // 请求后台的URL（*）
			method : 'post', // 请求方式（*）
			toolbar : '#toolbar', // 工具按钮用哪个容器
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : false, // 是否启用排序
			sortOrder : "asc", // 排序方式
			queryParams : oTableInit.queryParams,// 传递参数（*）
			sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 8, // 每页的记录行数（*）
			pageList : [ 1, 5, 10, 50 ], // 可供选择的每页的行数（*）
			search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,
			showColumns : true, // 是否显示所有的列
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数，
			height : 700, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "businessRecsiptId", // 每一行的唯一标识，一般为主键列
			showToggle : true, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			onClickRow : function(row) {
				var obj = {
					url : "dispatcher/findAllDispatcherAnnals?businessRecsiptId="+ row.businessRecsiptId,
					silent : true,
				};
				$('#tb_dispatcherAnnals').bootstrapTable('refresh', obj)},
			columns : [ {
				checkbox : true
			}, {
				field : 'businessRecsiptNo',
				title : '业务通知单号'
			}, {
				field : 'customerName',
				title : '客户名'
			}, {
				field : 'phoneNum',
				title : '电话号码'
			}, {
				field : 'fetchAddress',
				title : '取货地址'
			}, {
				field : 'assignCode',
				title : '分拣编码'
			}, {
				field : 'serveAddress',
				title : '收件地址'
			}, {
				field : 'commonRemarks',
				title : '备注'
			}, {
				field : 'arrivalCity',
				title : '到达地'
			}, {
				field : 'commonRemarks',
				title : '备注'
			}, {
				field : 'destoryCause',
				title : '销单原因'
			}, {
				field : 'type',
				title : '类型',
				formatter : function(value) {
					if (value == "1") {
						return "需要调度";
					} else if(value == "2") {
						return "调度成功";
					} else if(value == "0") {
						return "下单成功";
					}
				}
			}],
			rowStyle : function(row, index) {
				var strclass = {};
				if (row.type == "1") {
					strclass = {
						css : {
							'background-color' : '#e0e0e0'
						}
					};// 还有一个active
				}
				return strclass
			},
		});

	}; // 得到查询的参数

	$('#tb_dispatcherAnnals').bootstrapTable({
		url : 'dispatcher/findAllDispatcherAnnals', // 请求后台的URL（*）
		method : 'post', // 请求方式（*）
		toolbar : '#toolbar', // 工具按钮用哪个容器
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sortable : false, // 是否启用排序
		sortOrder : "asc", // 排序方式
		queryParams : oTableInit.queryParams,// 传递参数（*）
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 3, // 每页的记录行数（*）
		pageList : [ 1, 5, 10, 50 ], // 可供选择的每页的行数（*）
		search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		strictSearch : true,
		showColumns : true, // 是否显示所有的列
		showRefresh : true, // 是否显示刷新按钮
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		height : 300, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		uniqueId : "businessRecsiptId", // 每一行的唯一标识，一般为主键列
		columns : [ {
			checkbox : true
		}, {
			field : 'dispatcherNum',
			title : '调度序号'
		}, {
			field : 'operator',
			title : '操作人'
		}, {
			field : 'operatorOrg',
			title : '操作单位'
		}, {
			field : 'operatorTime',
			title : '操作时间',
			formatter : function(value) {
				return formatDate(value)
			}
		}, {
			field : 'commonRemarks',
			title : '备注'
		}, {
			field : 'status',
			title : '状态',
			formatter : function(value) {
				if (value == "1") {
					return "正常调度";
				} else {
					return "退回";
				}
			}
		}]

	});

	oTableInit.queryParams = function(params) {
		var temp = {
			// 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			arrivalCity : $("#search_arriveSite").val(),
			fetchAddress : $("#search_fetchAddress").val()
		};
		return temp;
	};

	return oTableInit;
};

var ButtonInit = function() {
	var oInit = new Object();
	var postdata = {};
	oInit.Init = function() {
		$("#btn_distribution").click(function() {
			clean();
			cleanEmpName();
			
			var addressInit = function(_province, _city, _county,
					defaultProvince, defaultCity, defaultCounty){  
			    var province = document.getElementById(province);  
			    var city = document.getElementById(city);  
			    var county = document.getElementById(county);  
			    function cmbSelect(cmb, str){  
			        for(var i=0; i<cmb.options.length; i++){  
			            if(cmb.options[i].value == str){  
			                cmb.selectedIndex = i;  
			                return;  
			            }  
			        }  
			    }  
			    function cmbAddOption(cmb, str, obj){  
			        var option = document.createElement("OPTION");  
			        cmb.options.add(option);  
			        option.innerText = obj;  
			        option.value = obj;  
			        option.obj = obj;  
			    }  
			    function changeCity(){  
			        county.options.length = 0;  
			        if(city.selectedIndex == -1)return;  
			        var item = city.options[city.selectedIndex].obj;  
			        for(var i=0; i<item.areaList.length; i++){  
			            cmbAddOption(county, item.areaList[i], null);  
			        }  
			        cmbSelect(county, defaultCounty);  
			    }  
			    function changeProvince(){  
			        city.options.length = 0;  
			        city.onchange = null;  
			        if(province.selectedIndex == -1)return;  
			        var item = province.options[province.selectedIndex].obj;  
			        for(var i=0; i<item.cityList.length; i++){  
			            cmbAddOption(city, item.cityList[i].name, item.cityList[i]);  
			        }  
			        cmbSelect(city, defaultCity);  
			        changeCity();  
			        city.onchange = changeCity;  
			    }  
			      
			    for(var i=0; i<provinceList.length; i++){  
			        cmbAddOption(province, provinceList[i].name, provinceList[i]);  
			    }  
			    cmbSelect(province, defaultProvince);  
			    changeProvince();  
			    province.onchange = changeProvince;  
			}  
			
			var select = $('#tb_dispatcher').bootstrapTable('getSelections');
			if (select.length === 0) {
				toastr.warning("请选择一行");
			} else if (select.length > 1) {
				toastr.warning("不能选择多行");
			} else {
				$("#distribution").modal('show');

				$("#btn_allot").click(function() {
					$("#distribution").modal('hide');
					$("#distribution2").modal('show');
					
					$.post({
						url : 'dispatcher/findOnJobEmp',
						data : {
							"fixedAreaNum" : $('#assignCode').val(),
						},
						success:function(response) {
							var html=$('#empName');
							for(var i=0;i<response.length;i++){
								item=$("<option></option>");
									
								item.append(response[i]);
								item.attr("value",response[i]);
								html.append(item);
							}
							
							var empNameVal = $('#empName').find("option:selected").text();
							if(empNameVal == ''){
								$("#distribution2").modal('hide');
								toastr.warning("没有在职员工，转给加盟商");
								$("#externalDistribution").modal('show');
								//查询所有加盟商
								$.ajax({
									url : 'dispatcher/findAllOrg',
									success:function(response) {
										var html=$('#franchisee');
										for(var i=0;i<response.length;i++){
											item=$("<option></option>");
											item.append(response[i].orgName);
											item.attr("value",response[i].orgName);
											html.append(item);
										}
									}
								});
							}
						}
					});
				});
				
				$('#franchisee').blur(function() {
					$.post({
						url : "dispatcher/findAllFranchiseeByOrgName",
						data : {
							"orgName" : $('#franchisee').find("option:selected").text()
						},
						success : function(response) {
							var html=$('#jobEmpName');
							for(var i=0;i<response.length;i++){
								item=$("<option></option>");
									
								item.append(response[i]);
								item.attr("value",response[i]);
								html.append(item);
							}
						}
					});
				});
				
				$('#detailed').blur(function() {
					var assginCodeValue = $('#detailed').val();
					if(assginCodeValue == ''){
						toastr.warning("请输入详细地址");
						return false;
					}else{
						$.ajax({
							url : "dispatcher/findFetchAddress",
							type : "post",
							data : {
								"fetchAddress" : $('#county').find("option:selected").text()
							},
							async : true,
							traditional : true,// 这里设置为true
							success : function(response) {
								if (response == '') {
									toastr.warning('请检查该地址！系统找不到匹配的地址');
								} else {
									$('#assignCode').val(response.assignCode);
								}
							}
						});
					}
				});
				
				var arrs = [];
				for (var i = 0; i < select.length; i++) {
					arrs[i] = select[i]['businessRecsiptId'];
				}
				$("#btn_allot2").click(function() {
					$.ajax({
						url : "dispatcher/distributionDispatcher",
						type : "post",
						data : {
							"empName" : $("#empName").find("option:selected").text(),
							"businessRecsiptId" : arrs
						},
						traditional : true,// 这里设置为true
						success : function(result) {
							if (result.status == "success") {
								toastr.success("调度成功");
								$("#distribution2").modal('hide');

								$('#tb_dispatcher').bootstrapTable('refresh');
								$('#tb_dispatcherAnnals').bootstrapTable('refresh');
							} else {
								toastr.error("调度失败");
							}
						}
					});
				});

				$("#btn_allot3").click(function() {
					$.ajax({
						url : "dispatcher/externalDistribution",
						type : "post",
						data : {
							"empName" : $("#jobEmpName").find("option:selected").text(),
							"businessRecsiptId" : arrs
						},
						traditional : true,// 这里设置为true
						success : function(result) {
							if (result.status == "success") {
								toastr.success("调度成功");
								$("#externalDistribution").modal('hide');
								
								$('#tb_dispatcher').bootstrapTable('refresh');
								$('#tb_dispatcherAnnals').bootstrapTable('refresh');
							} else {
								toastr.error("调度失败");
							}
						}
					});
				});
			}
		});

		$("#btn_meltSingle").click(function() {
			var select = $('#tb_dispatcher').bootstrapTable('getSelections');
			if (select.length === 0) {
				toastr.warning("请选择一行");
			} else if (select.length > 1) {
				toastr.warning("不能选择多行");
			} else {
				$("#meltSingle").modal('show');
				$("#btn_destroy").click(function() {
					var arrs = [];
					for (var i = 0; i < select.length; i++) {
						arrs[i] = select[i]['businessRecsiptId'];
					}

					// 异步同步数据库
					$.ajax({
						url : "dispatcher/destroyDispatcher",
						type : "post",
						data : {
							"destoryCause" :  $('#cause').val(),
							"businessRecsiptId" : arrs
						},
						traditional : true,// 这里设置为true
						success : function(result) {
							if (result.status == "success") {
								toastr.success("成功");
								$("#meltSingle").modal('hide');

								$('#tb_dispatcher').bootstrapTable('refresh');
								$('#tb_dispatcherAnnals').bootstrapTable('refresh');
							} else {
								toastr.error("失败");
							}
						}
					});
				});
			}

		});

		$("#btn_sendBack").click(function() {
			var select = $('#tb_dispatcher').bootstrapTable('getSelections');
			if (select.length === 0) {
				toastr.warning("请选择一行");
			} else if (select.length > 1) {
				toastr.warning("不能选择多行");
			} else {
				var obj = select[0];

				$("#sendBack").modal('show');
				$("#btn_returnCause").click(function() {
					var arrs = [];
					for (var i = 0; i < select.length; i++) {
						arrs[i] = select[i]['businessRecsiptId'];
					}

					//异步同步数据库
					$.ajax({
						url : "dispatcher/returnDispatcher",
						type : "post",
						data : {
							"returnCause" : $('#returnCauseDispatcher').val(),
							"businessRecsiptId" : arrs,
						},
						traditional : true,//这里设置为true
						success : function(result) {
							if (result.status == "success") {
								toastr.success("修改成功");
								$("#sendBack").modal('hide');
	
								$('#tb_dispatcher').bootstrapTable('refresh');
								$('#tb_dispatcherAnnals').bootstrapTable('refresh');
	
							} else {
								toastr.error("修改失败");
							}
						}
					});
				});
			}
		});
		
		$("#btn_query").click(function() {
			var obj = {
				url : "dispatcher/findAllNeedDispatcherWorkOrder",
				type : "get",
				query : {
					arrivalCity : $("#search_arriveSite").val(),
					fetchAddress : $("#search_fetchAddress").val(),
					offset : 1
				}
			}
			$('#tb_dispatcher').bootstrapTable('refresh', obj);
			$(':input').val("");
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
});