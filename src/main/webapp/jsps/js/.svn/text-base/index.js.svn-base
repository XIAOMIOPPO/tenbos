$(function(){
	/*var countNeedDispatcher = function(){
		$.ajax({
			url : "dispatcher/countNeedDispatcher",
			type : "post",
			traditional : true,//这里设置为true
			success : function(result) {
				
			}
		});
	};*/
	
	
	var tindex=-1;
	
	$('#tab-list').bind("contextmenu", function(e){
		var size = $('#tab-list li a i').length;
		var target = $(e.target);
		if(target.is("ul")){
			//单击外部，hide关闭右边
			$('#context-menu ul li').eq(1).hide();
			tindex=size;
		}else{
			$('#context-menu ul li').eq(0).show();
			$('#context-menu ul li').eq(1).show();
			$('#context-menu ul li').eq(2).show();
			$('#context-menu ul li').eq(3).show();
			//单击li标签
			//判断右边是否有元素
			var thistab = target.find('i').attr("tabclose");
			if(thistab){
				var index = findIndex(thistab);
				if(size>1){
					if (index==size-1) {
						//最后一个
						$('#context-menu ul li').eq(1).hide();
					} else if(index==0) {
						//第一个
						$('#context-menu ul li').eq(0).hide();
					}else{
						
					}
				}else{
					//size为一
					$('#context-menu ul li').eq(0).hide();
					$('#context-menu ul li').eq(1).hide();
					$('#context-menu ul li').eq(2).hide();
					$('#context-menu ul li').eq(3).hide();
					
				}
				tindex=index;
			}
		}
	    return false;
	})
	
	
	function findIndex(thistab){
		var index=-1;
		var thistab=$.trim(thistab)+'';
		$.each($('#tab-list li a i'),function(i,item){
			 var tab = $(item).attr("tabclose").trim()+'';
			 if(tab==thistab){
				 index=i;
			 }
		});
		return index;
	}
	
	
	
	$('#tab-list').contextmenu({
		  target: '#context-menu',
		  onItem: function(context, e) {
			  e.preventDefault();
			  var page = $(e.target).text();
			  if(page=="关闭所有页面"){
				  $('#tab-list li a i').each(function(){
					  closeTab($(this).attr("tabclose"));
				  });
			  }else if(page=="关闭左边页面"){
				  if(tindex!=-1){
					  $.each($('#tab-list li a i'),function(i,item){
						  var tab = $(item).attr("tabclose");
						  if(i<tindex){
							  closeTab(tab);
						  }
					  });
				  }
				  
			  }else if(page=="关闭右边页面"){
				  if(tindex!=-1){
					  $.each($('#tab-list li a i'),function(i,item){
						  var tab = $(item).attr("tabclose");
						  if(i>tindex){
							  closeTab(tab);
						  }
					  });
				  }
			  }else{
				  if(tindex!=-1){
					  $.each($('#tab-list li a i'),function(i,item){
						  var tab = $(item).attr("tabclose");
						  if(i!=tindex){
							  closeTab(tab);
						  }
					  });
				  }
			  }
			  
		  }
	});
	
	
	
	
	
	
	
 });
