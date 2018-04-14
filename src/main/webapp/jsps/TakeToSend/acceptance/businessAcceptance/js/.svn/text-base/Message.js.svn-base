$(function(){
	
	$('#Message').click(function(){
		$.ajax({
			url : "recsipt/findWorkOrderOne.action",
			type : "post",
			async:true,
			traditional : true,//这里设置为true
			success : function(response) {
				$('#name').val(response.workOrder.empName);
				$('#orderNo').val(response.workOrder.workOrderNo);
				$('#Time').val(response.businessRecsipt.appointmentDispatchTime);
				$('#address').val(response.businessRecsipt.fetchAddress);
				$('#brId').val(response.businessRecsipt.businessRecsiptId)
			}
		});

		$('#MessageDIV').show();
		
		
		
	});
	
	$('#relayEMP').click(function(){
		$.ajax({
			url : "recsipt/confirmPick.action",
			type : "post",
			data : {
				"BussnessnoId" : $('#brId').val(),
				"status" : '已取件'
			},
			async:true,
			traditional : true,//这里设置为true
			success : function(response) {
				if (response.status == "success") {
						alert("取件成功")
				} else {
					alert("取件失败") 
				}
			}
		});
	});
	
	$('#relaycloung').click(function(){
		$.ajax({
			url : "recsipt/confirmPick.action",
			type : "post",
			data : {
				"BussnessnoId" : $('#brId').val(),
				"status" : '已收货'
			},
			async:true,
			traditional : true,//这里设置为true
			success : function(response) {
				if (response.status == "success") {
						alert("取件成功")
				} else {
					alert("取件失败") 
				}
			}
		});
	});
	
});