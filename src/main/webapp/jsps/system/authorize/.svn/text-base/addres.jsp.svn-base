<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="${pageContext.request.contextPath}/"></base>
<title id="Description">添加资源</title>
<meta name="description"
	content="This sample demonstrates how we can bind jQWidgets TreeGrid widget to Array Data by using jQWidgets DataAdapter plugin.">
<link rel="stylesheet" href="js/styles/jqx.base.css"
	type="text/css" />
<meta name="viewport"
	content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />
<link rel="stylesheet" href="static/jqxtreegrid/css/jqxbase.css" type="text/css" />
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css" />
<script type="text/javascript" src="static/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css" />
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="static/zTree/css/zTreeStyle/metro.css">
<script src="static/zTree/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="static/jquery.form.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
</head>
<body>
	
	<div class="container">
		<div class="row">
			<div style="margin:20px auto;" class="col-sm-4 col-md-12">
			 <form id="resAddForm" class="form-horizontal" role="form" action="auth/ares" method="post">
	   			<input type="hidden" id="resourceId" name="resourceId"/>
					  <div class="form-group">
					    <label for="firstname" class="col-sm-2 control-label">资源名</label>
					    <div class="col-sm-5 col-md-5">
					      <input type="text" class="form-control" id="resname" name="resourceName" placeholder="请输入资源名">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">资源编码</label>
					    <div class="col-sm-5 col-md-5">
					      <input type="text" class="form-control" id="rescode" name="resourceCode" placeholder="请输入资源编码">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">资源URL</label>
					    <div class="col-sm-5 col-md-5">
					      <input type="text" class="form-control" id="resurl" name="resourceUrl"  placeholder="请输入资源URL">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">资源类型</label>
					    <div class="col-sm-5 col-md-5">
					      <div class="input-group">
			                    <input type="hidden" id="restype" name = "resourceType" class="form-control">
			                    <input type="text" id="rtype" class="form-control">
			                    <div class="input-group-btn" id="rtypeNode">
			                        <button type="button" class="btn btn-default 
			                        dropdown-toggle" data-toggle="dropdown">资源类型
			                            <span class="caret"></span>
			                        </button>
			                        <ul class="dropdown-menu pull-right">
			                            
			                        </ul>
			                    </div><!-- /btn-group -->
			                </div><!-- /input-group -->
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">父类</label>
					    <div class="col-sm-5 col-md-5">
					      <div class="input-group">
			                    <input type="hidden" id="parentId" name = "parentResId" class="form-control">
			                    <input type="text" id="ptype" class="form-control">
			                    <div class="input-group-btn">
			                        <button type="button" class="btn btn-default 
			                        dropdown-toggle" id="parentTree">父类结点
			                            <span class="caret"></span>
			                        </button>
			                        <ul id="tree" class="ztree dropdown-menu pull-right" style="width:460px; overflow:auto;">
			                        	
			                        </ul>
									
			                    </div><!-- /btn-group -->
			                </div><!-- /input-group -->
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">优先级</label>
					    <div class="col-sm-5 col-md-5">
					      <input type="text" class="form-control" id="rindex" name="rindex" placeholder="请输入资源优先级">
					    </div>
					  </div>
					  
					  
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="button" id="resSub" class="btn btn-default">提交</button>
					    </div>
					  </div>
	            
	   		
			
			</form>
			</div>
			
		</div>
	</div>
	
	<script type="text/javascript">
	
	$(function(){
		$('#resAddForm').bootstrapValidator({
			message: 'This value is not valid',
			fields:{
				resourceName:{
					validators: {
	                    notEmpty: {
	                        message: '请输入资源名'
	                    }
	                }
				},
				resourceCode:{
					validators: {
	                    notEmpty: {
	                        message: '请输入资源码'
	                    }
	                }
				},
				resourceUrl:{
					validators: {
	                    notEmpty: {
	                        message: '请输入URL'
	                    }
	                }
				},
				rindex:{
					validators: {
	                    notEmpty: {
	                        message: '请输入优先级'
	                    },regexp: {/* 只需加此键值对，包含正则表达式，和提示 */
                            regexp: /^[0-9]+$/,
                            message: '只能是数字'
                        }
	                }
				}
			}
			
		});
	});
	
	var zTree;
    var demoIframe;

    function addHoverDom(treeId, treeNode) {
        var sObj = $("#" + treeNode.tId + "_span");
        if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
        var addStr = "<span class='button remove' id='removeBtn_" + treeNode.tId
                + "' title='add node' onfocus='this.blur();'></span>";

        addStr += "<span class='button add' id='addBtn_" + treeNode.tId + "'></span>";
        addStr += "<span class='button edit' id='editBtn_" + treeNode.tId + "'></span>";
        sObj.after(addStr);
        var btn = $("#addBtn_"+treeNode.tId);
        if (btn) btn.bind("click", function(){
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            zTree.addNodes(treeNode, {id:(1000 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
            return false;
        });
    };

    function removeHoverDom(treeId, treeNode) {
        $("#addBtn_"+treeNode.tId).unbind().remove();
        $("#removeBtn_"+treeNode.tId).unbind().remove();
        $("#editBtn_"+treeNode.tId).unbind().remove();
    };

    var setting = {
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false
        },
        data: {
        	key: {
        		name:'resourceName'
        	},
            simpleData: {
                enable:true,
                idKey: "resourceId",
                pIdKey: "parentResId",
                rootPId: ""
            }
        },
        callback: {
            beforeClick: function(treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree");
                if (treeNode.isParent) {
                    zTree.expandNode(treeNode);
                    return false;
                } else {
                    demoIframe.attr("src",treeNode.file + ".html");
                    return true;
                }
            },
            onMouseDown:function(event, treeId, treeNode){
            	console.log(treeNode.resourceId)
            	//treeNode.showNodes();
            	//设置框框的值
            	console.log(treeNode.resourceName+":"+treeNode.resourceId);
            	$("#ptype").val(treeNode.resourceName);
            	$("#parentId").val(treeNode.resourceId);
            	
            },
            onDblClick:function(event, treeId, treeNode){
            	$("#parentTree").next().hide();
            }
            
            
        
        
        }
    };


    $(document).ready(function(){
	   	$.getJSON("auth/allres",function(data){
	    	var zNodes = data;
	        var t = $("#tree");
	        t = $.fn.zTree.init(t, setting, zNodes);
	        demoIframe = $("#testIframe");
	        //demoIframe.bind("load", loadReady);
	        var zTree = $.fn.zTree.getZTreeObj("tree");
	    	
	    });

    });

    function loadReady() {
        
        demoIframe.height(h);
    }
    
    $(function(){
    	$("#parentTree").click(function(){
    		$(this).next().show();
    	});
    	
    	$('#resSub').click(function(){
    		//异步提交表单
    		var options = {
    			url:'auth/ares',
    			beforeSubmit:function(){
    				if($('#rtype').val()==''){
    					return false;
    				}
    				
    				if($('#parentId').val()==''){
    					return false;
    				}
    				
    				$('#resAddForm').data('bootstrapValidator').validate();
    				var result = $('#resAddForm').data('bootstrapValidator').isValid();
    				if(!result){
    					return false;
    				}
    				
    				return true;
    			},
    			success:function(data){
    				//获取父窗口
    				var index = parent.layer.getFrameIndex(window.name);
    				if (data.status=='success') {
						//添加成功
						parent.refreshGrid();
    					parent.layer.close(index);
						parent.toastr.success("添加成功");
					} else {
						//添加失败
						parent.layer.close(index);
						parent.toastr.error("添加失败");
					}
    			}
    				
    		};
    		$('#resAddForm').ajaxSubmit(options);
    		
    	});
    	
    	$("#rtypeNode").click(function(){
			var dropDiv = $(this);
			var targetUL = $(this).find(".dropdown-menu");
			if(targetUL.children().length==0){
				$.getJSON("auth/alloption",function(data){
					for(var i=0;i<data.length;i++){
						var item = $("<li data='"+data[i].fileId+"'></li>");
						item.click(function(){
							dropDiv.prev().prev().val($(this).attr("data"));
							dropDiv.prev().val($(this).children().html());
						});
						item.append("<a href='javascript:void(0)'>"+data[i].recordName+"</a>");
						dropDiv.find(".dropdown-menu").append(item);
					}
					//$('#rtype').val(data[0].recordName);
				});
			}
		
	});
    	
    });
    
    
	
	</script>
	
	
</body>
</html>