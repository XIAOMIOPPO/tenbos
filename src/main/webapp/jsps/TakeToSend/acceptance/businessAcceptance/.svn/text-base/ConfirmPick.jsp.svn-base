<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>


<script
	src="jsps/TakeToSend/acceptance/businessAcceptance/js/modernizr-2.js"></script>
<link
	href="jsps/TakeToSend/acceptance/businessAcceptance/css/iphone.css"
	rel="stylesheet" type="text/css" />
<script src="http://www.jq22.com/jquery/jquery-1.7.1.js"></script>
<script
	src="jsps/TakeToSend/acceptance/businessAcceptance/js/jquery-ui-1.8.16.custom.min.js"></script>
<script src="jsps/TakeToSend/acceptance/businessAcceptance/js/iphone.js"></script>
<link href="jsps/TakeToSend/acceptance/businessAcceptance/css/page.css"
	rel="stylesheet" type="text/css" />


<style type="text/css">
	#MessageDIV{
		width: 500px;
		height: 400px;
		background:  white;
		position: absolute;
		right: 10%;
		top: 10%;
		display: none;
		border-radius : 10px; 
	}
</style>
</head>
<body>
	<div id="container">
		<div class="main">
			<div class="project">
				<div class="site">
					<div class="iphone_container">
						<div class="iphone">
							<div class="iphone_light_gradient"></div>
							<div class="iphone_power_button" id="iphone_power_button"></div>
							<div class="iphone_voice_toogle"></div>
							<div class="iphone_voice_plus"></div>
							<div class="iphone_voice_minus"></div>
							<div class="iphone_camera"></div>
							<div class="iphone_dynamic">
								<span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span>
							</div>
							<div class="iphone_black_bg"></div>
							<div class="iphone_display">
								<div class="iphone_headline" id="iphone_headline">
									<div class="iphone_net"></div>
									<div class="iphone_net_title">移动</div>
									<div class="iphone_wi-fi">
										<div class="hack"></div>
									</div>
									<div class="iphone_clock" id="iphone_headline_clock">00:00</div>
									<div class="iphone_lock"></div>
									<div class="iphone_battery"></div>
								</div>
								<div class="iphone_header" id="iphone_lock_header">
									<div class="iphone_time" id="iphone_lock_time">
										0<span>:</span>00
									</div>
									<div class="iphone_date" id="iphone_lock_date"></div>
								</div>
								<div class="iphone_footer" id="iphone_lock_footer">
									<div class="iphone_unlock" id="iphone_unlock">
										<div class="iphone_slider" id="iphone_slider"></div>
										<div class="iphone_slide2unlock" id="iphone_slide2unlock">滑动解锁</div>
									</div>
								</div>
								<div class="iphone_icons_containter"
									id="iphone_icons_containter">
									<div class="icon">
										<div class="i_message" id="Message">
											<div class="bg_angled"></div>
											<div class="bulb"></div>
											<div class="tail"></div>
											<div class="hack"></div>
										</div>
										<span>Message</span>
									</div>
									<div class="icon">
										<div class="i_calendar">
											<div class="day" id="iphone_icon_day"></div>
											<div class="day_num" id="iphone_icon_day_num"></div>
										</div>
										<span>Calendar</span>
									</div>
									<div class="icon">
										<div class="i_clock">
											<div class="gray_blick"></div>
											<div class="center_dot"></div>
											<div class="minute"></div>
											<div class="second"></div>
											<div class="hour"></div>
											<ul>
												<li>1</li>
												<li>2</li>
												<li>3</li>
												<li>4</li>
												<li>5</li>
												<li>6</li>
												<li>7</li>
												<li>8</li>
												<li>9</li>
												<li>10</li>
												<li>11</li>
												<li>12</li>
											</ul>
										</div>
										<span>Clock</span>
									</div>
									<div class="icon">
										<div class="i_notes"></div>
										<span>Notes</span>
									</div>
									<div class="icon">
										<div class="i_reminders">
											<div>&#10004;</div>
											<div>&#10004;</div>
											<div>&#10004;</div>
										</div>
										<span>Reminders</span>
									</div>
									<div class="icon">
										<div class="i_mail">
											<div class="mail">
												<div class="mail_top"></div>
												<div class="mail_bottom"></div>
											</div>
											<div class="clouds">
												<b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b>
											</div>
											<div class="clouds2">
												<b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b><b></b>
											</div>
										</div>
										<span>Mail</span>
									</div>
									<div class="icon">
										<div class="i_app_store">
											<div class="kirpich">
												<div class="pen1"></div>
												<div class="pen2"></div>
											</div>
											<div class="glow">
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
											</div>
										</div>
										<span>App Store</span>
									</div>
									<div class="icon">
										<div class="i_videos">
											<div class="top">
												<hr class="hr1" />
												<hr class="hr2" />
												<hr class="hr3" />
												<hr class="hr4" />
												<hr class="hr5" />
												<hr class="hack" />
											</div>
											<div class="bottom">
												<b class="c1"></b><b class="c2"></b><b class="c3"></b><b
													class="c4"></b>
											</div>
										</div>
										<span>Videos</span>
									</div>
									<div class="icon">
										<div class="i_youtube">
											<div class="screen"></div>
											<sub></sub><sup></sup>
											<hr />
										</div>
										<span>YouTube</span>
									</div>

									<!--
			<div class="icon">
				<div class="i_maps">
				</div>
				<span>Maps</span>
			</div>
-->

									<div class="icon">
										<div class="i_calculator">
											<div class="plus">
												<b></b>
											</div>
											<div class="minus">
												<b></b>
											</div>
											<div class="multiply">
												<b></b>
											</div>
											<div class="result">
												<b></b>
											</div>
										</div>
										<span>Calculator</span>
									</div>
									<div class="icon">
										<div class="i_itunes">
											<div class="nota"></div>
											<div class="nota2"></div>
											<div class="glow">
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
											</div>
										</div>
										<span>iTunes</span>
									</div>
									<div class="icon">
										<div class="i_stocks">
											<ul>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
											</ul>
											<div>
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
											</div>
										</div>
										<span>Stocks</span>
									</div>
									<div class="icon">
										<div class="i_voice_memos">
											<div class="mic"></div>
											<sub></sub> <sup></sup>
										</div>
										<span>Voice Memos</span>
									</div>
									<div class="icon">
										<div class="i_weather">
											<div class="light">
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
											</div>
											<div class="sun"></div>
											<div class="num">
												23<sup>o</sup>
											</div>
										</div>
										<span>Weather</span>
									</div>
								</div>
								<div class="iphone_dock" id="iphone_dock">
									<div class="icon">
										<div class="i_phone">
											<div class="bg_angled"></div>
											<div class="truba">
												馃摓<b></b>
											</div>
										</div>
										<span>Phone</span>
									</div>
									<div class="icon">
										<div class="i_contacts">
											<div class="left_side">
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
												<hr />
											</div>
											<div class="right_side">
												a<br /> b<br /> c<br /> d<br /> e<br /> f
											</div>
											<div class="profile">
												<div class="head"></div>
												<div class="neck"></div>
											</div>
										</div>
										<span>Contacts</span>
									</div>
									<div class="icon">
										<div class="i_camera">
											<div class="eye">
												<div class="blick">
													<b></b>
												</div>
											</div>
										</div>
										<span>Camera</span>
									</div>
									<div class="icon">
										<div class="i_music">
											<div class="nota"></div>
											<div class="nota2"></div>
											<div class="glow"></div>
										</div>
										<span>Music</span>
									</div>
								</div>
							</div>
							<div class="iphone_home" id="iphone_home_button"></div>
						</div>

					</div>

				</div>
			</div>


		</div>
	</div>

	
	<div id="MessageDIV">
		<input id="name">
		<input id="orderNo">
		<input id="Time">
		<input id="address">
		<input type="hidden" id="brId">
		
		
		<button id="relayEMP">确认取件</button>
		<button id="relaycloung">确认收货</button>
	</div>





<script type="text/javascript" src="jsps/TakeToSend/acceptance/businessAcceptance/js/Message.js"></script>
	
</body>
</html>