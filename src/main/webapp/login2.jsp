<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tenbos登录页面</title>
<link rel="stylesheet" href="static/login.css">
<link href="static/slide/slide-unlock.css" rel="stylesheet" media="all"/>
<script src="static/jquery-3.2.1.min.js"></script>
<script src="static/jquery.form.js"></script>
<script src="static/slide/jquery.slideunlock.js"></script>
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
                            <input id="userName" type="email" name="userName" placeholder="Email" tabindex="1" autofocus="autofocus" class="form-control input-medium">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <label for="password" class="control-label fa fa-asterisk"></label>
                            <input id="password" type="password" name="password" placeholder="Password" tabindex="2" class="form-control input-medium">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <div id="slider">
							    <div id="slider_bg"></div>
								<span id="label">&gt;&gt;</span> <span id="labelTip">拖动滑块验证</span>
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
        }).blur(function() {
            $('#owl-login').removeClass('password');
        });
        
        
        $('#lbtn').click(function(){
    		var options = {
    				url:'user/login',
    				beforeSubmit:function(){
    					return checkForm();
    				},
    				success:function(res){
    					if(res.status=="success"){
    						window.location.href='jsps/index1.jsp';
    					}else{
    						$("#error").html(res.error);
    					}
    				}
    		};
    		$('#loginForm').ajaxSubmit(options);
    	});
    	
    	
    	var slider = new SliderUnlock("#slider",{
            successLabelTip : "验证成功" 
        },function(){
           flag=true;
        });
    	slider.init();
        
        
        
        
    });
    
    var flag=false;
    
    function checkForm(){
    	var userName=$("#userName").val();
    	var password=$("#password").val();
    	if(userName==null||userName==""){
    		alert("用户名不能为空！");
    		return false;
    	}
    	if(password==null||password==""){
    		alert("密码不能为空！");
    		return false;
    	}
    	return true&&flag;
    }
    
    
    
    
    
    </script>
</div>
</body>
</html>