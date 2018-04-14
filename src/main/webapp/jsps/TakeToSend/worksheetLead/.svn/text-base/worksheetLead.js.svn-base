$(function() {
	// ==================================================
	// 查询分拣编码
	$('#fetchAddress').blur(function() {

		$.ajax({
			url : "workSheetLead/findFetchAddress",
			type : "post",
			data : {
				"fetchAddress" : $('#fetchAddress').val()
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
	});
	// ==================================================
	// 1.初始化Table
	// 导入按钮点击事件
	$('#lead').click(function() {
		$('#myModal').modal('show');
	});
	$('#myModal').modal('show');
	// div下载在文件按钮点击事件
	$('#download a').click(
			function(e) {
				e.preventDefault();
				$('#download').attr('class', 'active');
				$('#uploadLead').attr('class', '');
				$('#step1').attr('aria-hidden', false).attr('class',
						'bwizard-activated');
				$('#step2').attr('aria-hidden', true).attr('class', 'hide');
				$('#next').removeClass('hide');
				$('#after').addClass('hide');
				$('#over').addClass('hide');
			});

	$('#next').click(
			function() {
				$('#download').attr('class', '');
				$('#uploadLead').attr('class', 'active');
				$('#step1').attr('aria-hidden', true).attr('class', 'hide');
				$('#step2').attr('aria-hidden', false).attr('class',
						'bwizard-activated');
				$('#next').addClass('hide');
				$('#after').removeClass('hide');
				$('#over').removeClass('hide');
			});
	// div上传导入文件点击事件
	$('#uploadLead a').click(
			function(e) {
				e.preventDefault();
				$('#download').attr('class', '');
				$('#uploadLead').attr('class', 'active');
				$('#step1').attr('aria-hidden', true).attr('class', 'hide');
				$('#step2').attr('aria-hidden', false).attr('class',
						'bwizard-activated');
				$('#next').addClass('hide');
				$('#after').removeClass('hide');
				$('#over').removeClass('hide');
			});
	$('#after').click(
			function() {
				$('#download').attr('class', 'active');
				$('#uploadLead').attr('class', '');
				$('#step1').attr('aria-hidden', false).attr('class',
						'bwizard-activated');
				$('#step2').attr('aria-hidden', true).attr('class', 'hide');
				$('#next').removeClass('hide');
				$('#after').addClass('hide');
				$('#over').addClass('hide');
			})
	// 保存 按钮点击事件
	$('#save').click(
			function() {
				var select = $('#tb_departments').bootstrapTable(
						'getSelections');
				if (select.length === 0) {
					toastr.warning("请至少选中一行");
				} else {
					$('#people').modal('show');
					$.post("workSheetLead/findAddressBySmallEmp", {
						senderAddress : select[0].senderAddress
					}, function(response) {
						var html = "";
						for (var i = 0; i < response.length; i++) {
							if (i == 0) {
								html = "<option class='frhf' selected id='"
										+ response[i].empNum + "'>"
										+ response[i].empName + "</option>";
								$('#empNum').val(response[i].empNum);

							} else {
								html = html + "<option class='frhf' id='"
										+ response[i].empNum + "'>"
										+ response[i].empName + "</option>";
							}
						}
						$("#senderAddress").html('').append(html);
					});
				}
			});
	$("#appointed").click(function() {
		var sr = $("#senderAddress").val();
		var select = $('#tb_departments').bootstrapTable('getSelections');
		for (var i = 0; i < select.length; i++) {
			var item = select[i];
			item.empName = sr;
			$('#tb_departments').bootstrapTable('updateRow', {
				index : item.index,
				row : item
			});
		}
		toastr.success("指定成功");
		$('#people').modal('hide');
		$('#addJsp').attr('disabled', false);
	});
	$('#addJsp').click(
			function() {
				var flag = true;
				var sr = $("#senderAddress").val();
				var select = $('#tb_departments').bootstrapTable(
						'getSelections');
				var updata = select.slice(0);
				$.each(updata, function(i, item) {
					if (sr != null && sr != "") {
						item.empName = sr;
					}
					if ($.trim(item.destination) == ''
							|| $.trim(item.senderName) == ''
							|| $.trim(item.senderFax) == ''
							|| $.trim(item.senderAddress) == ''
							|| $.trim(item.senderPhone) == ''
							|| $.trim(item.addressesName) == ''
							|| $.trim(item.addressesFax) == ''
							|| $.trim(item.addressesAddress) == ''
							|| $.trim(item.addressesPhone) == '') {
						flag = false;
						toastr.warning('信息不完整');
						return;
					}
				});

				if (flag) {
					$.each(updata, function(i, item) {
						delete item['0'];
					});
					$.ajax({
						type : "post",
						url : "workSheetLead/addWorkSheetLead",
						data : {
							workSheetLeads : JSON.stringify(updata)
						},
						traditional : true,// 这里设置为true
						success : function(data) {
							$.each(select, function(i, item) {
								if (data.indexOf(item.workSheetNo) == -1) {
									var arrs = [];
									arrs.push(item.workSheetNo);
									$('#tb_departments').bootstrapTable(
											'remove', {
												field : 'workSheetNo',
												values : arrs
											});
									$('#people').modal('hide');
									toastr.success("保存成功");
									$('#save').attr('disabled', true);
									$('#addJsp').attr('disabled', true);
								} else {
									toastr.error("保存失败", item.workSheetNo);
								}
							});

						}
					});
				}

			});
	$('#senderAddress').click(function() {
		$('#empNum').val($(this).find("option:selected").attr("id"));
	});
	// 批量生成工单号 按钮点击事件
	$('#quantilyWorkOrderNum')
			.click(
					function() {
						var select = $('#tb_departments').bootstrapTable(
								'getSelections');
						if (select.length === 0) {
							toastr.warning("请至少选中一行");
						} else {
							$
									.ajax({
										type : "post",
										data : {
											num : select.length,
										},
										url : "workSheetLead/quantilyWorkOrderNum",
										traditional : true,// 这里设置为true
										success : function(data) {
											for (var i = 0; i < select.length; i++) {
												var item = select[i];
												item.workSheetNo = data.workSheet[i].workSheetNo;
												item.businessNoticeNo = data.workSheet[i].businessNoticeNo;
												item.customerListNo = data.sender[i].senderNo;
												$('#tb_departments')
														.bootstrapTable(
																'updateRow',
																{
																	index : item.index,
																	row : item
																});
											}

										}
									});
							$('#save').attr('disabled', false);
						}
					});
	// 填写说明 按钮点击事件
	$('#writeExplain').click(function() {
		$('#remake').modal('show');
	});
	/*
	 * $('#downloadBoard').click(function(){
	 * $.post('workSheetLead/findDownLoadBorder',{date:new
	 * Date()},function(action){ $('#dddd').find(".modal-body").html("");
	 * $.each(action,function(i,item){ var qwe =$('<div><label><input
	 * type="checkbox" class="class"></label></div>');
	 * qwe.append(item).find("input").attr('name','filename').attr('value',item);
	 * $('#dddd').find(".modal-body").append(qwe); }); });
	 * $('#downloadBorder').modal('show'); });
	 */
	$("#delete").click(function() {
		var select = $('#tb_departments').bootstrapTable('getSelections');
		if (select.length === 0) {
			toastr.warning("请至少选择一行");
		} else {
			layer.msg('确定删除?', {
				time : 0,// 不自动关闭
				btn : [ '确认', '取消' ],
				yes : function(index) {
					layer.close(index);
					var arrs = [];
					for (var i = 0; i < select.length; i++) {
						arrs[i] = select[i]['businessNoticeNo'];
					}
					$('#tb_departments').bootstrapTable('remove', {
						field : 'businessNoticeNo',
						values : arrs
					});
				}
			});
		}
	});
	$("#input-file").fileinput({
		uploadUrl : "workSheetLead/uploadWorkSheetLead",
		language : 'zh',// 设置语言
		maxFileCount : 1,
		allowedFileExtensions : [ 'xls' ]
	// 接收的文件后缀
	}).on("fileuploaded", function(event, data, previewId, index) {
		var oTable = new TableInit();
		oTable.Init(data.response.list);
		$(".kv-file-remove").trigger("click");
		$('#myModal').modal('hide');
		if (data.response.status == "success") {
			toastr.success("导入成功");
			$('#quantilyWorkOrderNum').attr('disabled', false);
			$('#delete').attr('disabled', false);
			$('#lead').attr('disabled', false);

			$("#input-file").fileinput('reset');
		} else {
			toastr.error("导入失败");

		}
	});
});

function check() {
	var checks = $('.class:checked');
	var len = checks.length;
	if (len == 0) {
		toastr.warning("请选中复选框");
		return false;
	} else {
		return true;
	}

}

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function(data) {
		$('#tb_departments').bootstrapTable({
			data : data,
			editable : true,// 开启编辑模式
			toolbar : '#toolbar', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : true, // 是否启用排序
			sortOrder : "asc", // 排序方式
			queryParams : oTableInit.queryParamsOne,// 传递参数（*）
			sidePagination : "client", // 分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 8, // 每页的记录行数（*）
			pageList : [ 8, 10, 20, 50 ], // 可供选择的每页的行数（*）
			search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,
			showColumns : true, // 是否显示所有的列
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			uniqueId : "workSheetNo", // 每一行的唯一标识，一般为主键列
			showToggle : true, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'workSheetNo',
				title : '工作单号'
			}, {
				field : 'businessNoticeNo',
				title : '业务通知单号'
			}, {
				field : 'customerListNo',
				title : '客户单号'
			}, {
				field : 'product',
				title : '产品　　',
				editable : {
					type : 'text',
					title : '产品',
					validate : function(v) {
						if (v == null || v == '' || v == ' ')
							return '产品不能为空';
					}
				}
			}, {
				field : 'destination',
				title : '到达地　　　　　　',
				editable : {
					type : 'text',
					title : '到达地',
					validate : function(v) {
						if (v == null || v == '' || v == ' ')
							return '到达地不能为空';
					}
				}
			}, {
				field : 'empName',
				title : '取派员'
			}, {
				field : 'stowageRequirement',
				title : '配载要求　'
			}, {
				field : 'senderName',
				title : '寄件人',
				editable : {
					type : 'text',
					title : '寄件人',
					validate : function(v) {
						if (v == null || v == '' || v == ' ')
							return '寄件人不能为空';
					}
				}
			},  {
				field : 'senderPhone',
				title : '寄件人电话',
				editable : {
					type : 'text',
					title : '寄件人电话',
					validate : function(v) {
						if (v == null || v == '' || v == ' ')
							return '寄件人电话不能为空';
						if (!(/^1[34578]\d{9}$/.test(v))) {
							return '手机格式不正确';
						}
					}
				}
			}, {
				field : 'senderAddress',
				title : '寄件人地址',
				editable : {
					type : 'text',
					title : '寄件人地址',
					validate : function(v) {
						if (v == null || v == '' || v == ' ')
							return '寄件人地址不能为空';
					}
				}
			},{
				field : 'senderFax',
				title : '寄件人传真',
				editable : {
					type : 'text',
					title : '寄件人传真',
					validate : function(v) {
						if (v == null || v == '' || v == ' ')
							return '寄件人传真不能为空';
						if (!/^(\d{3,4}-)?\d{7,8}$/.test(v))
							return '寄件人传真格式不正确';

					}
				}
			}, {
				field : 'senderCompany',
				title : '寄件人单位　　'
			}, {
				field : 'addressesName',
				title : '收件人',
				editable : {
					type : 'text',
					title : '收件人',
					validate : function(v) {
						if (v == null || v == '' || v == ' ')
							return '收件人不能为空';
					}
				}
			},{
				field : 'addressesPhone',
				title : '收件人电话',
				editable : {
					type : 'text',
					title : '收件人电话',
					validate : function(v) {
						if (v == null || v == '' || v == ' ')
							return '收件人不能为空';
						if (!(/^1[34578]\d{9}$/.test(v))) {
							return '手机格式不正确';
						}
					}
				}
			},{
				field : 'addressesAddress',
				title : '收件人地址',
				editable : {
					type : 'text',
					title : '收件人地址',
					validate : function(v) {
						if (v == null || v == '' || v == ' ')
							return '收件人地址不能为空';
					}
				}
			}, {
				field : 'addressesFax',
				title : '收件人传真',
				editable : {
					type : 'text',
					title : '收件人传真',
					validate : function(v) {
						if (v == null || v == '' || v == ' ')
							return '收件人传真不能为空';
						if (!/^(\d{3,4}-)?\d{7,8}$/.test(v))
							return '收件人传真格式不正确';

					}
				}
			},  {
				field : 'addressesCompany',
				title : '收件人单位　　'
			},  {
				field : 'actualWeight',
				title : '实际重量'
			}, {
				field : 'productName',
				title : '品名'
			}, {
				field : 'size',
				title : '体积'
			}, {
				field : 'insuranceType',
				title : '保险类型'
			}, {
				field : 'insurancePremium',
				title : '保险费'
			}, {
				field : 'declaredValue',
				title : '声明价值'
			}, {
				field : 'originalPacking',
				title : '原包装'
			}, {
				field : 'actualPacking',
				title : '实际包装'
			}, {
				field : 'packingCharges',
				title : '包装费'
			}, {
				field : 'packagingRequirements',
				title : '包装要求'
			}, {
				field : 'productAmount',
				title : '实际件数',
				editable : {
					type : 'text',
					title : '实际件数',
					validate : function(v) {
						if (isNaN(v))
							return '实际件数必须是数字';
						var productAmount = parseInt(v);
						if (productAmount <= 0)
							return '实际件数必须是正整数';
						var re = /^\d{1,2}$/;
						if (v.match(re) == null)
							return '实际件数必须是正整数';
					}
				}
			}, {
				field : 'billingWeight',
				title : '计费重量'
			}, {
				field : 'preCharge',
				title : '预收费'
			}, {
				field : 'settlementMode',
				title : '结算方式'
			}, {
				field : 'replaceReceivables',
				title : '代收款'
			}, {
				field : 'paymentArrival',
				title : '到付款'
			}, {
				field : 'feedbackSign',
				title : '反馈签收',
				formatter : function(data) {
					if (data == '1') {
						return '否';
					} else {
						return '是';
					}
				}
			}, {
				field : 'holidayIsCollect',
				title : '节假日可以收货',
				formatter : function(data) {
					if (data == '1') {
						return '否';
					} else {
						return '是';
					}
				}
			}, {
				field : 'serviceTimeLimit',
				title : '送达时限',
				editable : {
					type : 'date',
					title : '送达时限',
					validate : function(v) {
						if (v == null || v == '' || v == ' ')
							return '送达时限不能为空';
					}
				}
			} ]
		});
	}; // 得到查询的参数
	oTableInit.queryParamsOne = function(params) {
		var temp = {
			// 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
		};
		return temp;
	};
	return oTableInit;
};