package com.yidu.tencloud.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class NoteUtil {

	/**
	 * 转单成功通知(发给转单后的员工)
	 * @param phoneNum 手机号
	 * @param name 员工名
	 * @param workOrderNo 工单号
	 */
	public static void turnTheSingleNoticeT(String phoneNum,String name,String workOrderNo) {
	    //设置超时时间-可自行调整
	    System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
	    System.setProperty("sun.net.client.defaultReadTimeout", "10000");
	    //初始化ascClient需要的几个参数
	    final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
	    final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
	    //替换成你的AK
	    final String accessKeyId = "LTAIHzvOciTJQ74c";//你的accessKeyId,参考本文档步骤2
	    final String accessKeySecret = "CfKWxfU7LKAz3repk5D1GGZoSsz4ll";//你的accessKeySecret，参考本文档步骤2
	    //初始化ascClient,暂时不支持多region（请勿修改）
	    IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
	    accessKeySecret);
	    try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    IAcsClient acsClient = new DefaultAcsClient(profile);
	     //组装请求对象
	     SendSmsRequest request = new SendSmsRequest();
	     //使用post提交
	     request.setMethod(MethodType.POST);
	     //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
	     request.setPhoneNumbers(phoneNum);
	     //必填:短信签名-可在短信控制台中找到
	     request.setSignName("Tencloud物流");
	     //必填:短信模板-可在短信控制台中找到
	     request.setTemplateCode("SMS_116563149");
	     //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
	     //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
	     request.setTemplateParam("{\"name\":\""+name+"\", "
	     		+ "\"workOrderNo\":\""+workOrderNo+"\"}");
	     //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
	     //request.setSmsUpExtendCode("90997");
	     //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
	     request.setOutId("yourOutId");
	    //请求失败这里会抛ClientException异常
	    SendSmsResponse sendSmsResponse = null;
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sendSmsResponse.getCode());
	    if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
	    //请求成功
	    	System.out.println("发送成功");
	    }else{
	    	System.out.println("发送失败");
	    }
	}


	/**
	 * 转单成功通知(发给转单前的员工)
	 * @param phoneNum 手机号
	 * @param name 员工名
	 * @param workOrderNo 工单号
	 */
	public static void turnTheSingleNoticeO(String phoneNum,String name,String workOrderNo) {
	    //设置超时时间-可自行调整
	    System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
	    System.setProperty("sun.net.client.defaultReadTimeout", "10000");
	    //初始化ascClient需要的几个参数
	    final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
	    final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
	    //替换成你的AK
	    final String accessKeyId = "LTAIHzvOciTJQ74c";//你的accessKeyId,参考本文档步骤2
	    final String accessKeySecret = "CfKWxfU7LKAz3repk5D1GGZoSsz4ll";//你的accessKeySecret，参考本文档步骤2
	    //初始化ascClient,暂时不支持多region（请勿修改）
	    IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
	    accessKeySecret);
	    try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    IAcsClient acsClient = new DefaultAcsClient(profile);
	     //组装请求对象
	     SendSmsRequest request = new SendSmsRequest();
	     //使用post提交
	     request.setMethod(MethodType.POST);
	     //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
	     request.setPhoneNumbers(phoneNum);
	     //必填:短信签名-可在短信控制台中找到
	     request.setSignName("Tencloud物流");
	     //必填:短信模板-可在短信控制台中找到
	     request.setTemplateCode("SMS_116593126");
	     //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
	     //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
	     request.setTemplateParam("{\"name\":\""+name+"\", "
	     		+ "\"workOrderNo\":\""+workOrderNo+"\"}");
	     //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
	     //request.setSmsUpExtendCode("90997");
	     //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
	     request.setOutId("yourOutId");
	    //请求失败这里会抛ClientException异常
	    SendSmsResponse sendSmsResponse = null;
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sendSmsResponse.getCode());
	    if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
	    //请求成功
	    	System.out.println("发送成功");
	    }else{
	    	System.out.println("发送失败");
	    }
	}
	
	
	/**
	 * 业务通知单发送短信方法
	 * @param phoneNum 寄件人电话
	 * @param name 名字
	 * @param oStuatus   订单状态
	 * @param orderNo 订单单号
	 * @param address  寄件地址
	 * @param toPhoneNum 收件人号码
	 * @param user  收件人名
	 * @param money  金额
	 * @return
	 * 尊敬的：${name} ,您的订单号为：${orderNo} 的订单，
	 * 快递员：${empName}，联系方式：${empPhone}；
	 * 于${time}，上门取件。预计收费金额：${money}，
	 * 我们将极速为您送达，感谢您的使用；
	 */
	public static String createNoteToClient(String phoneNum,String name,String orderNo,String empName,
			String empPhone ,  String time ,String money){
	    //设置超时时间-可自行调整
	    System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
	    System.setProperty("sun.net.client.defaultReadTimeout", "10000");
	    //初始化ascClient需要的几个参数
	    final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
	    final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
	    //替换成你的AK
	    final String accessKeyId = "LTAIHzvOciTJQ74c";//你的accessKeyId,参考本文档步骤2
	    final String accessKeySecret = "CfKWxfU7LKAz3repk5D1GGZoSsz4ll";//你的accessKeySecret，参考本文档步骤2
	    //初始化ascClient,暂时不支持多region（请勿修改）
	    IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
	    accessKeySecret);
	    try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    IAcsClient acsClient = new DefaultAcsClient(profile);
	     //组装请求对象
	     SendSmsRequest request = new SendSmsRequest();
	     //使用post提交
	     request.setMethod(MethodType.POST);
	     //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
	     request.setPhoneNumbers(phoneNum);
	     //必填:短信签名-可在短信控制台中找到
	     request.setSignName("Tencloud物流");
	     //必填:短信模板-可在短信控制台中找到
	     request.setTemplateCode("SMS_120375353");
	     //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
	     //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
	     request.setTemplateParam("{\"name\":\""+name+"\", "
	     		+ "\"orderNo\":\""+orderNo+"\","
	     		+ "\"empName\":\""+empName+"\","
	     		+ "\"empPhone\":\""+empPhone+"\","
	     		+ "\"time\":\""+time+"\","
	     		+ "\"money\":\""+money+"\"}");
	     /**
			 * 尊敬的：${name} ,您的订单号为：${orderNo} 的订单，
			 * 快递员：${empName}，联系方式：${empPhone}；
			 * 于${time}，上门取件。预计收费金额：${money}，
			 * 我们将极速为您送达，感谢您的使用；
	      */
	     
	     //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
	     //request.setSmsUpExtendCode("90997");
	     //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
	     request.setOutId("yourOutId");
	    //请求失败这里会抛ClientException异常
	    SendSmsResponse sendSmsResponse = null;
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sendSmsResponse.getCode());
	    if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
	    //请求成功
	    	System.out.println("发送短信成功");
	    	return sendSmsResponse.getCode();
	    }else{
	    	System.out.println("发送短信失败");
	    	return sendSmsResponse.getCode();
	    }
	}
	
	
	
	/**
	 * 业务通知单发送短信方法
	 * @param phoneNum 寄件人电话
	 * @param name 名字
	 * @param oStuatus   订单状态
	 * @param orderNo 订单单号
	 * @param address  寄件地址
	 * @param toPhoneNum 收件人号码
	 * @param user  收件人名
	 * @param money  金额
	 * @return
	 */
	public static String createToNote(String phoneNum,String name,String oStuatus,String orderNo,
			String address ,  String user){
	    //设置超时时间-可自行调整
	    System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
	    System.setProperty("sun.net.client.defaultReadTimeout", "10000");
	    //初始化ascClient需要的几个参数
	    final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
	    final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
	    //替换成你的AK
	    final String accessKeyId = "LTAIHzvOciTJQ74c";//你的accessKeyId,参考本文档步骤2
	    final String accessKeySecret = "CfKWxfU7LKAz3repk5D1GGZoSsz4ll";//你的accessKeySecret，参考本文档步骤2
	    //初始化ascClient,暂时不支持多region（请勿修改）
	    IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
	    accessKeySecret);
	    try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    IAcsClient acsClient = new DefaultAcsClient(profile);
	     //组装请求对象
	     SendSmsRequest request = new SendSmsRequest();
	     //使用post提交
	     request.setMethod(MethodType.POST);
	     //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
	     request.setPhoneNumbers(phoneNum);
	     //必填:短信签名-可在短信控制台中找到
	     request.setSignName("Tencloud物流");
	     //必填:短信模板-可在短信控制台中找到
	     request.setTemplateCode("SMS_115265216");
	     //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
	     //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
	     request.setTemplateParam("{\"name\":\""+name+"\", "
	     		+ "\"orderType\":\""+oStuatus+"\","
	     		+ "\"orderNo\":\""+orderNo+"\","
	     		+ "\"address\":\""+address+"\","
	     		+ "\"userName\":\""+user+"\"}");
	     //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
	     //request.setSmsUpExtendCode("90997");
	     //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
	     request.setOutId("yourOutId");
	    //请求失败这里会抛ClientException异常
	    SendSmsResponse sendSmsResponse = null;
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sendSmsResponse.getCode());
	    if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
	    //请求成功
	    	System.out.println("发送短信成功");
	    	return sendSmsResponse.getCode();
	    }else{
	    	System.out.println("发送短信失败");
	    	return sendSmsResponse.getCode();
	    }
	}
	
	
}