<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tenbos登录页面</title>
<link rel="stylesheet" href="static/login.css">
<link rel="stylesheet" href="static/toastr/toastr.css">
<link href="static/slide/slide-unlock.css" rel="stylesheet" media="all"/>
<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/jquery.form.js"></script>
<script src="static/slide/jquery.slideunlock.js"></script>
<script src="static/toastr/toastr.js"></script>

</head>
<body>
<div id="login">
    <div class="wrapper">
    	<div class="login" style="margin-top:0px;height:35px">
    	
    	</div>
        <div class="login">
            <form action="#" method="post" id="loginForm" class="container offset1 loginform">
                <div id="owl-login">
                    <div class="hand"></div>
                    <div class="hand hand-r"></div>
                    <div class="arms">
                        <div class="arm"></div>
                        <div class="arm arm-r"></div>
                    </div>
                </div>
                <div class="pad">
                    <input type="hidden" name="_csrf" value="9IAtUxV2CatyxHiK2LxzOsT6wtBE6h8BpzOmk=">
                    <div class="control-group">
                        <div class="controls">
                            <label for="email" class="control-label fa fa-envelope"></label>
                            <input required="" id="userName" type="text" name="userName" placeholder="用户名" tabindex="1" autofocus="autofocus" class="form-control input-medium">
                        	<div class="help-block with-errors">
                        		<ul class="list-unstyled">
                        			<li>
                        			</li>
                        		</ul>
                        	</div>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <label for="password" class="control-label fa fa-asterisk"></label>
                            <input required="" id="password" type="password" name="pwd" placeholder="密码" tabindex="2" class="form-control input-medium">
                        	<div class="help-block with-errors">
                        		<ul class="list-unstyled">
                        			<li>
                        				
                        			</li>
                        		</ul>
                        	</div>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <div id="slider">
							    <div id="slider_bg"></div>
								<span id="label">&gt;&gt;</span> <span id="labelTip">拖动滑块验证</span>
							</div>
							<div id="warn" class="help-block with-errors">
                        		<ul class="list-unstyled">
                        			<li>
                        				
                        			</li>
                        		</ul>
                        	</div>
                        </div>
                    </div>
                </div>
                <div class="form-actions"><a href="#" tabindex="5" class="btn pull-left btn-link text-muted">腾云物流系统</a>
                    <button id="lbtn" tabindex="4" class="btn btn-primary">登陆</button>
                </div>
            </form>
        </div>
    </div>
    <script>
    $(function() {
        $('#login #password').focus(function() {
            $('#owl-login').addClass('password');
            $("#password").css('border-color','');
    		$("#password").next().find('li').children().remove();
        }).blur(function() {
            $('#owl-login').removeClass('password');
        });
        
        
        $('#userName').focus(function() {
        	$("#userName").css('border-color','');
    		$("#userName").next().find('li').children().remove();
        })
        
        
    	
    	
    	var slider = new SliderUnlock("#slider",{
            successLabelTip : "验证成功" 
        },function(){
           flag=true;
        });
    	
        slider.init();
        
        $('#lbtn').click(function(e){
        	e.preventDefault();
    		var options = {
    				url:'user/login',
    				beforeSubmit:function(){
    					return checkForm();
    				},
    				success:function(res){
    					if(res.status=="success"){
    						window.location.href='jsps/index1.jsp';
    					}else if(res.status=='kickout'){
    						toastr.warning("此账号已登陆！");
    					}else{
    						slider = new SliderUnlock("#slider",{
    				            successLabelTip : "验证成功" 
    				        },function(){
    				           flag=true;
    				        });
    				    	
    				        slider.init();
    						flag=false;
    						$("#userName").css('border-color','#a94442');
    						$("#password").css('border-color','#a94442');
    						$("#password").next().find('li').append('<span style="color:#a94442">'+res.error+'</span>');
    					}
    				}
    		};
    		$('#loginForm').ajaxSubmit(options);
    	});
        
        
        
    });
    
    var flag=false;
    
    function checkForm(){
    	var userName=$("#userName").val();
    	var password=$("#password").val();
    	if(userName==null||userName==""){
    		$("#userName").css('border-color','#a94442');
    		$("#userName").next().find('li').append('<span style="color:#a94442">用户名不能为空！</span>');
    		return false;
    	}
    	if(password==null||password==""){
    		$("#password").css('border-color','#a94442');
    		$("#password").next().find('li').append('<span style="color:#a94442">密码不能为空！</span>');
    		return false;
    	}
    	
    	if(!flag){
    		if($('#warn').find('span').length==0){
	    		$('#warn').find('li').append('<span style="color:#a94442">请拖动滑块验证！</span>');
    		}
    		return false;
    	}
    	
    	return true;
    }
    
    
    
    
    
    </script>
</div>
</body>
</html>