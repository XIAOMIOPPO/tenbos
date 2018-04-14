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
	createTable("#ltb1","sign/sin",[{
		field : 'storageinId',
		title : '入库id'
	},{
		field : 'storageinNo',
		title : '入库单号'
	},{
		field : 'recDate',
		title : '接受时间'
	},{
		field : 'recPersonName',
		title : '接受人姓名'
	},{
		field : 'recOrgName',
		title : '接受单位'
	},{
		field : 'recOrgName',
		title : '接受单位'
	},{
		field : 'sendPersonName',
		title : '发送人名'
	},{
		field : 'sendOrgName',
		title : '发送人单位'
	}],"storageinId","server");
	
	//双击事件
	$("#ltb1").on('dbl-click-row.bs.table',function(row, $element){
		var id = $element.storageinId;
		var opt = {
		    url: "sign/sindetail",
		    silent: true,
		    query:{      
		    	type:1,
		        level:2,
		        storageinId : id,
			  	offset:0,
			  	limit:20
		    }
		};
		$('#ltb2').bootstrapTable('refresh', opt);
	});
	
	//初始化list2 table
	createTable("#ltb2","sign/sindetail",[{
		field : 'sdetailId',
		title : '入库详情id'
	},{
		field : 'sdetailNo',
		title : '工作单号'
	},{
		field : 'copackno',
		title : '合包号'
	},{
		field : 'weight',
		title : '重量'
	},{
		field : 'outstorageno',
		title : '关联出库交接单号'
	},{
		field : 'rstatus',
		title : '状态'
	}],"sdetailId","server");
	
	//初始化卡片界面表格
	createTable("#dbt","sign/sindetail",[{
		checkbox : true,
		title : '异常'
	},{
		field : 'isIn',
		title : '状态',
		formatter:function(i){
			if(i=='1'){
				return '下环节入库';
			}else{
				return '它环节入库';
			}
		}
	},{
		field : 'outdetailId',
		title : '交接单号'
	},{
		field : 'outdetailNo',
		title : '单号'
	}],"sdetailId","client");
	
	
	
	//初始化导入数据表格
	createTable("#drt","sign/sindetail",[{
		checkbox : true,
		title : '异常'
	},{
		field : 'outstorageno',
		title : '关联出库交接单号'
	},{
		field : 'sdetailNo',
		title : '单号'
	},{
		field : 'copackno',
		title : '合包号'
	},{
		field : 'weight',
		title : '重量'
	},{
		field : 'rstatus',
		title : '状态'
	}],"outstorageno","client");
	
	
	
	//初始化导入数据表格
	createTable("#fh","sign/sindetail",[{
		field : 'outstorageno',
		title : '交接单号'
	},{
		field : 'sdetailNo',
		title : '代票号'
	},{
		field : 'copackno',
		title : '总件数'
	},{
		field : 'weight',
		title : '总件数'
	},{
		field : 'money',
		title : '总金额'
	},{
		field : 'money',
		title : '返货人'
	},{
		field : 'money',
		title : '返货时间'
	}],"sdetailId","server");
	
	
	//初始化导入数据表格
	createTable("#th","sign/sindetail",[{
		field : 'outstorageno',
		title : '交接单号'
	},{
		field : 'sdetailNo',
		title : '提货总件数'
	},{
		field : 'copackno',
		title : '提货人'
	},{
		field : 'weight',
		title : '提货时间'
	}],"sdetailId","client");
	
	
	
	
	createTable("#mtable","sign/sindetail",[{
		checkbox : true
	},{
		field : 'outstorageno',
		title : '交接单号'
	},{
		field : 'type',
		title : '类别'
	}],"outstorageno","client");
	
	//导入框
	$("#input-file").fileinput({
		uploadUrl : "sign/upload",
		language : 'zh',// 设置语言
		maxFileCount : 1,
		allowedFileExtensions : [ 'xls' ,'xlsx']
	// 接收的文件后缀
	}).on("fileuploaded", function(event, data, previewId, index) {
		$(".kv-file-remove").trigger("click");
		$('#importModal').modal('hide');
		toastr.success("导入成功");
		$('#drt').bootstrapTable('load',data.response);
		$("#input-file").fileinput('reset');
	});
	
	
	$("#duibi").click(function(){
		//获取导入数据中的关联出库单id
		var data = $('#drt').bootstrapTable('getData');
		
		if(data.length==0){
			toastr.warning('没有导入数据');
			return ;
		}
		
		//获取id
		var cids = [];
		$.each(data,function(i,item){
			cids.push(item.outstorageno);
		});
		
		//获取出库单状态 判断物流方向是否本单位 交给后台处理
		$.post('sign/ostatus',{outno:cids},function(data){
			//用户选择id获取详细
			$('#mtable').bootstrapTable('load',data);
			//打开模态框
			$('#myModal').modal('show');
		});
		
		
		
	});
	
	
	$('#hqmx').click(function(){
		var select = $('#mtable').bootstrapTable('getSelections');
		if(select.length==0){
			toastr.warning("请至少选择一行！");
		}else{
			//获取所选交接单号
			var ids = [];
			$.each(select,function(i,item){
				ids.push(item.outstorageno);
			});
			
			//获取所选交接单号的明细信息
			$.post("sign/odetail",{outstoragenos:ids},function(data){
				if(data.status="success"){
					//获取详情成功
					detail=data;
					$('#dbt').bootstrapTable('load',data);
					toastr.success("获取详情成功");
				}else{
					//获取详情失败
					toastr.error("获取详情失败");
				}
			});
			
			
		}
		
		
	});
	
	
	$('#dbsj').click(function(){
		//判断是否有详细信息
		if(!detail){
			toastr.warning("请先获取明细信息！");
			return ;
		}
		
		//对比明细信息与扫描获得的信息 以左边的信息为基础进行对比
		//获取右边对比中的单号
		var ids=[];
		var rdata = $('#drt').bootstrapTable('getData');
		$.each(rdata,function(i,item){
			ids.push(item.sdetailNo);
		});
		
		
		var details = [];
		$.each(detail,function(i,item){
			details.push(item.outdetailNo);
		});
		
		
		var result = 0;
		//左边对比信息
		for(var i=0;i<detail.length;i++){
			if(ids.indexOf(detail[i].outdetailNo)==-1){
				//不匹配 标注单号
				$('#dbt tbody tr').eq(i).css("background","#FF6666");
				//标记为有单无货
				result+=1;
			}
			
		}
		
		var yhwd=0;
		
		//对比右侧表格
		for(var j=0;j<ids.length;j++){
			if(details.indexOf(ids[i])==-1){
				$('#drt tbody tr').eq(i).css("background","#FF9900");
				$('#drt tbody tr').eq(4).text("有货无单");
				yhwd+=1;
			}
		}
		
		$('#myModal').modal('hide');
		
		toastr.info("有单无货 "+result+" 件"+"有货无单"+yhwd+"件");
		
	});
	
	
	function checkSheet(){
		
		//对比明细信息与扫描获得的信息 以左边的信息为基础进行对比
		//获取右边对比中的单号
		var ids=[];
		var rdata = $('#drt').bootstrapTable('getData');
		$.each(rdata,function(i,item){
			ids.push(item.sdetailNo);
		});
		
		
		var details = [];
		$.each(detail,function(i,item){
			details.push(item.outdetailNo);
		});
		
		
		var result = 0;
		//左边对比信息
		for(var i=0;i<detail.length;i++){
			if(ids.indexOf(detail[i].outdetailNo)==-1){
				//不匹配 标注单号
				$('#dbt tbody tr').eq(i).css("background","#FF6666");
				//check异常的单号
				//$('#drt').bootstrapTable('check',i);
				//记录结果
				result+=1;
			}
			
		}
		
		var yhwd=0;
		
		//对比右侧表格
		for(var j=0;j<ids.length;j++){
			if(details.indexOf(ids[i])==-1){
				$('#drt tbody tr').eq(i).css("background","#FF9900 ");
				yhwd+=1;
			}
		}
		
		$('#myModal').modal('hide');
		
		return result+yhwd;
	}
	
	$('#saveData').click(function(){
		
		//判断是否有异常信息
		if(checkSheet()>0){
			layer.msg('确定保存异常记录?',{
				time:0,//不自动关闭
				btn:['确认','取消'],
				yes:function(index){
					layer.close(index);
					//获取导入的数据
					var rdata = $('#drt').bootstrapTable('getData');
					
					if(rdata.length==0){
						toastr.warning('请导入数据');
						return ;
					}
					
					var data = rdata.slice(0);
					
					$.each(data,function(i,item){
						delete item['0']
					});
					
					
					//异步发送数据
					$.post('sign/addin',{storagein:JSON.stringify(data)},function(data){
						//异步发送数据
						if(data.status=='success'){
							toastr.success('生成入库单成功');
						}else{
							toastr.error('生成入库单失败');
						}
					});
				}
			});
		}
		
		//生成保存数据
		
	});
	
	
	
	$('#addData').click(function(){
		//获取框张的数据
		var no = $('#addDataForm').val();
		
		if(no==null||$.trim(no)==''){
			toastr.warning('请填写正确的单号！');
			return ;
		}
		
		//查询数据
		$.post('sign/sheetdata',{no:no},function(data){
			if(data.length==0){
				toastr.warning('无此工作单号或合包号');
			}else{
				//判断是否已经存在
				var alldata = $('#drt').bootstrapTable('getData');
				$.each(alldata,function(i,item){
					if(item.sdetailNo==alldata.sdetailNo){
						toastr.warning('数据已存在！');
						return;
					}
				});
				$('#drt').bootstrapTable('append',data);
				toastr.success('添加成功');
			}
		});
		
		
	});
	
	
	
	
	$("#cancel").click(function(){
		layer.msg('确定删除?',{
			time:0,//不自动关闭
			btn:['确认','取消'],
			yes:function(index){
				layer.close(index);
				$('.btable').bootstrapTable('removeAll');
			}
		});
		
	});
	
	
	
	$('#tianjia').click(function(){
		var no = $('#dbdh').val();
		if(no==null||no==''){
			toastr.warning('请输入正确的出库单号！');
			return ;
		}
		
		//发送请求查询数据
		$.post('sign/odetails',{outNo:no},function(data){
			$('#dbt').bootstrapTable('append',data);
		});
		
		
	});
	
	
	

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


